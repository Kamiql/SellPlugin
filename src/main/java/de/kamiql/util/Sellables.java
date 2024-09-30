package de.kamiql.util;

import de.kamiql.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public class Sellables {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Sellables.class);
    private final YamlConfiguration config;
    private final Logger logger;
    private final Plugin plugin;

    public Sellables() {
        this.config = Main.getItemConfig();
        this.logger = Main.getInstance().getLogger();
        this.plugin = Main.getInstance();
    }

    public List<Material> getSellables() {
        List<Material> sellables = new ArrayList<>();
        if (config.contains("items")) {
            for (String item : config.getConfigurationSection("items").getKeys(false)) {
                Material material = Material.getMaterial(item.toUpperCase());
                if (material != null) {
                    sellables.add(material);
                }
            }
        }
        return sellables;
    }

    public ItemCategory getCategory(@NotNull Material material) {
        String categoryKey = config.getString("items." + material.toString().toUpperCase() + ".category");

        if (categoryKey != null) {
            for (ItemCategory category : getCategories()) {
                if (category.getKey().equalsIgnoreCase(categoryKey)) {
                    return category;
                }
            }
        }

        return null;
    }

    public Double getPrice(@NotNull Material material) {
        return config.getDouble("items." + material.toString().toUpperCase() + ".price");
    }

    public boolean isSellable(@NotNull Material material) {
        return config.contains("items." + material.toString().toUpperCase());
    }

    public List<ItemCategory> getCategories() {
        List<ItemCategory> categories = new ArrayList<>();
        for (String CATEGORY : config.getConfigurationSection("categories").getKeys(false)) {
            String NAME = config.getString("categories." + CATEGORY + ".displayName");
            Material MATERIAL = Material.getMaterial(Objects.requireNonNull(config.getString("categories." + CATEGORY + ".displayMaterial")));
            ItemCategory category = new ItemCategory(NAME, MATERIAL);

            categories.add(category);
        }
        return categories;
    }

    public static class ItemCategory {
        private final FileConfiguration config;
        private final Logger logger;

        private final String name;
        private final Material material;

        public ItemCategory(@NotNull String name, @Nullable Material material) {
            this.config = Main.getItemConfig();
            this.logger = Main.getInstance().getLogger();

            this.name = name;
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }

        public String getName() {
            return name;
        }

        public String getKey() {
            for (String category : config.getConfigurationSection("categories").getKeys(false)) {
                if (config.getString("categories." + category + ".displayName").equals(this.name)) {
                    return config.getString("categories." + category + ".key");
                }
            }
            return null;
        }

        public List<Material> getItems() {
            List<Material> items = new ArrayList<>();
            Sellables sellables = new Sellables();
            String currentCategoryKey = this.getKey();
            if (currentCategoryKey != null) {
                for (Material item : sellables.getSellables()) {
                    String itemCategoryKey = config.getString("items." + item.toString() + ".category");
                    if (currentCategoryKey.equals(itemCategoryKey)) {
                        items.add(item);
                    }
                }
            }
            return items;
        }

    }
}
