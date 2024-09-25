package de.kamiql;

import de.kamiql.commands.SellCommand;
import de.kamiql.util.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main extends JavaPlugin {
    private static Economy econ = null;

    private static Main instance;
    private static YamlConfiguration itemConfig;
    private static YamlConfiguration messageConfig;
    private static Logger logger;

    @Override
    public void onEnable() {
        instance = this;
        logger = new Logger().initialize(createLoggerFile());

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

    @Override
    public void onDisable() {
        logger.close();
    }

    private String createLoggerFile() {
        File dataFolder = this.getDataFolder();
        File logFile = new File(dataFolder, "sell_log.txt");

        try {
            if (!logFile.exists()) {
                logFile.createNewFile();
            }
        } catch (IOException e) {
            getLogger().severe("Fehler beim Erstellen der Logger-Datei: " + e.getMessage());
        }

        return logFile.getAbsolutePath();
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

    public static Logger getCustomLogger() {
        return logger;
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

    /**
     * Returns the current date and time as a formatted string.
     *
     * @param format The format of the date-time string, e.g., "yyyy-MM-dd HH:mm:ss".
     * @return A string representing the current date and time in the specified format.
     */
    public static String getDateTime(String format) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return now.format(formatter);
    }
}