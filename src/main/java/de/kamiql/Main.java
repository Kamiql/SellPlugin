package de.kamiql;

import de.kamiql.commands.ReloadCommand;
import de.kamiql.commands.SellCommand;
import de.kamiql.i18n.api.provider.I18nProvider;
import de.kamiql.util.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends JavaPlugin {
    private static Economy econ = null;

    private static Main instance;
    private static YamlConfiguration itemConfig;
    private static YamlConfiguration messageConfig;

    @Override
    public void onEnable() {
        instance = this;

        if (!setupEconomy()) {
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
        setupLogDirectory();

        new I18nProvider(this).initialize(messageConfig, false);

        this.getCommand("sell").setExecutor(new SellCommand());
        this.getCommand("reload").setExecutor(new ReloadCommand(this));

        this.getServer().getPluginManager().registerEvents(new SellCommand(), this);
    }

    @Override
    public void onDisable() {

    }

    private void setupLogDirectory() {
        File logFolder = new File(instance.getDataFolder(), "Log");
        if (!logFolder.exists()) {
            logFolder.mkdirs();
        }
    }

    private void setupMessageConfig() {
        File file = new File(this.getDataFolder(), "language/messages.yml");
        messageConfig = YamlConfiguration.loadConfiguration(file);
    }

    private void setupItemConfig() {
        File file = new File(this.getDataFolder(), "items.yml");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            saveResource("items.yml", false);
        }
        itemConfig = YamlConfiguration.loadConfiguration(file);
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

    /**
     * Creates or retrieves the logger for a specific player. Each player has their own log file located in the 'Log' directory.
     *
     * @param player The player whose log file will be created or retrieved.
     * @return Logger instance for the specified player.
     */
    public static Logger getCustomLogger(@NotNull Player player) {
        File logFolder = new File(instance.getDataFolder(), "Log");
        File logFile = new File(logFolder, player.getUniqueId() + "_log.txt");

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            instance.getLogger().severe("Error creating logger file for player " + player.getName() + ": " + e.getMessage());
        }

        return new Logger().initialize(logFile.getAbsolutePath());
    }

    public static void setItemConfig(YamlConfiguration newItemConfig) {
        itemConfig = newItemConfig;
    }

    public static Main getInstance() {
        return instance;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public static YamlConfiguration getItemConfig() {
        return itemConfig;
    }

    public static String getDateTime(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return now.format(formatter);
    }
}
