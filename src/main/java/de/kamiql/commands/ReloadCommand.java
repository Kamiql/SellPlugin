package de.kamiql.commands;

import de.kamiql.Main;
import de.kamiql.i18n.core.source.I18n;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
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
        if (sender instanceof Player player) {
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("config")) {
                    try {
                        plugin.reloadConfig();
                        new I18n.Builder("reloadConfig", player)
                                .hasPrefix(true)
                                .withPlaceholder("fileName", args[1])
                                .build()
                                .sendMessageAsComponent();
                    } catch (Exception e) {
                        new I18n.Builder("reloadError", player)
                                .hasPrefix(true)
                                .build()
                                .sendMessageAsComponent();
                        throw new RuntimeException(e);
                    }
                }
            } else if (args.length == 2) {
                String fileName = args[1] + ".yml";
                File configFile = new File(plugin.getDataFolder(), fileName);

                if (configFile.exists()) {
                    new I18n.Builder("reloadFile", player)
                            .hasPrefix(true)
                            .withPlaceholder("fileName", args[1])
                            .build()
                            .sendMessageAsComponent();
                    try {
                        YamlConfiguration newConfig = YamlConfiguration.loadConfiguration(configFile);

                        if (fileName.equals("items.yml")) {
                            Main.setItemConfig(newConfig);
                        }

                        new I18n.Builder("reloadFile", player)
                                .hasPrefix(true)
                                .withPlaceholder("fileName", args[1])
                                .build()
                                .sendMessageAsComponent();
                    } catch (Exception e) {
                        new I18n.Builder("reloadError", player)
                                .hasPrefix(true)
                                .withPlaceholder("fileName", args[1])
                                .build()
                                .sendMessageAsComponent();
                        throw new RuntimeException(e);
                    }
                } else {new I18n.Builder("reloadFileNotFound", player)
                            .hasPrefix(true)
                            .withPlaceholder("fileName", args[1])
                            .build()
                            .sendMessageAsComponent();
                }
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
