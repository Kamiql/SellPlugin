package de.kamiql;

import de.kamiql.commands.SellCommand;
import de.kamiql.commands.enums.SellableItems;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;


public class Main extends JavaPlugin {
    private static Economy econ = null;

    private static Main instance;

    @Override
    public void onEnable() {
        instance = this;
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        setupConfig();

        this.getCommand("sell").setExecutor(new SellCommand());
        this.getServer().getPluginManager().registerEvents(new SellCommand(), this);
    }

    private void setupConfig() {
        File dataFolder = this.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        FileConfiguration config = this.getConfig();
        Arrays.stream(SellableItems.values()).forEach(item -> {
            String path = "items." + item.getMaterial().toString();
            if (!config.contains(path)) {
                config.set(path, 0.0);
            }
        });
        this.saveConfig();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return true;
    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return "§7[§eSELL§7] §7";
    }

    public static Economy getEconomy() {
        return econ;
    }
}