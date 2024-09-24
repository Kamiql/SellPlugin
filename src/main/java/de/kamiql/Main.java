package de.kamiql;

import de.kamiql.commands.SellCommand;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {
    private static Economy econ = null;

    private static Main instance;
    private static YamlConfiguration itemConfig;
    private static YamlConfiguration messageConfig;

    @Override
    public void onEnable() {
        instance = this;

        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        File dataFolder = this.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdir();
        }

        setupItemConfig();
        setupMessageConfig();

        this.saveDefaultConfig();

        this.getCommand("sell").setExecutor(new SellCommand());

        this.getServer().getPluginManager().registerEvents(new SellCommand(), this);
    }

    private void setupMessageConfig() {
        File file = new File(this.getDataFolder(), "messages.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource("messages.yml", false);
        }
        messageConfig = YamlConfiguration.loadConfiguration(file);
    }

    private void setupItemConfig() {
        File file = new File(this.getDataFolder(), "items.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource("items.yml", false);
        }
        itemConfig = YamlConfiguration.loadConfiguration(file);
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

    public static YamlConfiguration getItemConfig() {
        return itemConfig;
    }

    public static YamlConfiguration getMessageConfig() {
        return messageConfig;
    }

    public static Main getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return messageConfig.getString("data.prefix", "§7[§eSELL§7] §7");
    }

    public static Economy getEconomy() {
        return econ;
    }
}