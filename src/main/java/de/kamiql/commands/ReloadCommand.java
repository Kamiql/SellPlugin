package de.kamiql.commands;

import de.kamiql.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReloadCommand implements TabExecutor {
    private final Plugin plugin;

    public ReloadCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("config")) {
                sender.sendMessage(Main.getPrefix() + "§aConfiguration reload started...");
                try {
                    plugin.reloadConfig();
                    sender.sendMessage(Main.getPrefix() + "§aMain configuration file successfully reloaded...");
                } catch (Exception e) {
                    sender.sendMessage(Main.getPrefix() + "§cMain configuration reload failed...");
                    throw new RuntimeException(e);
                }
            }
        } else if (args.length == 2) {
            String fileName = args[1] + ".yml";
            File configFile = new File(plugin.getDataFolder(), fileName);

            if (configFile.exists()) {
                sender.sendMessage(Main.getPrefix() + "§aReloading " + fileName + "...");
                try {
                    YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);

                    if (fileName.equals("items.yml")) {
                        Main.setItemConfig(newConfig);
                    } else if (fileName.equals("messages.yml")) {
                        Main.setMessageConfig(newConfig);
                    }

                    sender.sendMessage(Main.getPrefix() + "§aConfiguration file " + fileName + " successfully reloaded...");
                } catch (Exception e) {
                    sender.sendMessage(Main.getPrefix() + "§cReload failed for " + fileName);
                    throw new RuntimeException(e);
                }
            } else {
                sender.sendMessage(Main.getPrefix() + "§cConfiguration file " + fileName + " not found.");
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("config");
        } else if (args.length == 2) {
            File dataFolder = plugin.getDataFolder();
            File[] files = dataFolder.listFiles((dir, name) -> name.endsWith(".yml"));

            if (files != null) {
                for (File file : files) {
                    completions.add(file.getName().replace(".yml", ""));
                }
            }
        }

        return completions;
    }
}
