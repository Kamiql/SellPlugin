package de.kamiql.commands.enums;

import org.bukkit.Material;

public enum SellableItems {

    // Kategorien
    ORES(Material.STONE, "Erze"),
    BLOCKS(Material.STONE, "Roh-Erze"),
    ORE_BLOCKS(Material.DIAMOND_BLOCK, "Erzblöcke"),
    WOODS(Material.OAK_LOG, "Logs"),
    PLANKS(Material.OAK_PLANKS, "Planks"),
    RAW_MATERIALS(Material.COBBLESTONE, "Rohstoffe"),
    CROPS(Material.WHEAT, "Landwirtschaft"),
    ANIMAL_DROPS(Material.LEATHER, "Tiere und andere Drops"),
    CONCRETE(Material.WHITE_CONCRETE, "Concrete & Concrete Powder"),
    TERRACOTTA(Material.TERRACOTTA, "Terracotta"),
    OTHER(Material.HEART_OF_THE_SEA, "Andere Items"),

    // Erze
    COAL(Material.COAL, 5.0, "Erze"),
    IRON_INGOT(Material.IRON_INGOT, 5.0, "Erze"),
    GOLD_INGOT(Material.GOLD_INGOT, 5.0, "Erze"),
    DIAMOND(Material.DIAMOND, 20.0, "Erze"),
    EMERALD(Material.EMERALD, 20.0, "Erze"),
    REDSTONE(Material.REDSTONE, 3.0, "Erze"),
    LAPIS_LAZULI(Material.LAPIS_LAZULI, 2.0, "Erze"),
    NETHERITE_INGOT(Material.NETHERITE_INGOT, 250.0, "Erze"),
    COPPER_INGOT(Material.COPPER_INGOT, 3.0, "Erze"),

    // Roh-Erze
    COAL_ORE(Material.COAL_ORE, 8.0, "Roh-Erze"),
    IRON_ORE(Material.IRON_ORE, 8.0, "Roh-Erze"),
    GOLD_ORE(Material.GOLD_ORE, 8.0, "Roh-Erze"),
    DIAMOND_ORE(Material.DIAMOND_ORE, 80.0, "Roh-Erze"),
    EMERALD_ORE(Material.EMERALD_ORE, 200.0, "Roh-Erze"),
    REDSTONE_ORE(Material.REDSTONE_ORE, 8.0, "Roh-Erze"),
    LAPIS_ORE(Material.LAPIS_ORE, 10.0, "Roh-Erze"),
    NETHER_GOLD_ORE(Material.NETHER_GOLD_ORE, 5.0, "Roh-Erze"),
    ANCIENT_DEBRIS(Material.ANCIENT_DEBRIS, 125.0, "Roh-Erze"),
    COPPER_ORE(Material.COPPER_ORE, 8.0, "Roh-Erze"),

    // Erzblöcke
    IRON_BLOCK(Material.IRON_BLOCK, 50.0, "Erzblöcke"),
    GOLD_BLOCK(Material.GOLD_BLOCK, 50.0, "Erzblöcke"),
    DIAMOND_BLOCK(Material.DIAMOND_BLOCK, 200.0, "Erzblöcke"),
    EMERALD_BLOCK(Material.EMERALD_BLOCK, 200.0, "Erzblöcke"),
    REDSTONE_BLOCK(Material.REDSTONE_BLOCK, 30.0, "Erzblöcke"),
    LAPIS_BLOCK(Material.LAPIS_BLOCK, 20.0, "Erzblöcke"),
    COPPER_BLOCK(Material.COPPER_BLOCK, 30.0, "Erzblöcke"),
    NETHERITE_BLOCK(Material.NETHERITE_BLOCK, 2500, "Erzblöcke"),

    // Holzarten (Logs)
    OAK_LOG(Material.OAK_LOG, 5.0, "Logs"),
    SPRUCE_LOG(Material.SPRUCE_LOG, 5.0, "Logs"),
    BIRCH_LOG(Material.BIRCH_LOG, 5.0, "Logs"),
    JUNGLE_LOG(Material.JUNGLE_LOG, 5.0, "Logs"),
    ACACIA_LOG(Material.ACACIA_LOG, 5.0, "Logs"),
    DARK_OAK_LOG(Material.DARK_OAK_LOG, 5.0, "Logs"),
    CRIMSON_STEM(Material.CRIMSON_STEM, 7.0, "Logs"),
    WARPED_STEM(Material.WARPED_STEM, 7.0, "Logs"),

    // Verarbeitete Holzarten (Planks)
    OAK_PLANKS(Material.OAK_PLANKS, 1.0, "Planks"),
    SPRUCE_PLANKS(Material.SPRUCE_PLANKS, 1.0, "Planks"),
    BIRCH_PLANKS(Material.BIRCH_PLANKS, 1.0, "Planks"),
    JUNGLE_PLANKS(Material.JUNGLE_PLANKS, 1.0, "Planks"),
    ACACIA_PLANKS(Material.ACACIA_PLANKS, 1.0, "Planks"),
    DARK_OAK_PLANKS(Material.DARK_OAK_PLANKS, 1.0, "Planks"),
    CRIMSON_PLANKS(Material.CRIMSON_PLANKS, 1.0, "Planks"),
    WARPED_PLANKS(Material.WARPED_PLANKS, 1.0, "Planks"),

    // Rohstoffe
    COBBLESTONE(Material.COBBLESTONE, 1.0, "Rohstoffe"),
    STONE(Material.STONE, 2.0, "Rohstoffe"),
    SAND(Material.SAND, 1.0, "Rohstoffe"),
    SANDSTONE(Material.SANDSTONE, 3.0, "Rohstoffe"),
    GRAVEL(Material.GRAVEL, 1.0, "Rohstoffe"),
    CLAY_BALL(Material.CLAY_BALL, 2.0, "Rohstoffe"),
    CLAY(Material.CLAY, 5.0, "Rohstoffe"),
    DIRT(Material.DIRT, 0.5, "Rohstoffe"),
    GRASS_BLOCK(Material.GRASS_BLOCK, 3.0, "Rohstoffe"),
    SNOWBALL(Material.SNOWBALL, 0.5, "Rohstoffe"),
    ICE(Material.ICE, 4.0, "Rohstoffe"),
    PACKED_ICE(Material.PACKED_ICE, 10.0, "Rohstoffe"),
    BLUE_ICE(Material.BLUE_ICE, 25.0, "Rohstoffe"),
    OBSIDIAN(Material.OBSIDIAN, 75.0, "Rohstoffe"),
    NETHERRACK(Material.NETHERRACK, 0.5, "Rohstoffe"),
    SOUL_SAND(Material.SOUL_SAND, 4.0, "Rohstoffe"),
    SOUL_SOIL(Material.SOUL_SOIL, 4.0, "Rohstoffe"),
    BASALT(Material.BASALT, 2.0, "Rohstoffe"),
    BLACKSTONE(Material.BLACKSTONE, 3.0, "Rohstoffe"),
    GLOWSTONE(Material.GLOWSTONE, 6.0, "Rohstoffe"),
    QUARTZ(Material.QUARTZ, 5.0, "Rohstoffe"),
    ENDER_PEARL(Material.ENDER_PEARL, 100.0, "Rohstoffe"),
    SLIME_BALL(Material.SLIME_BALL, 8.0, "Rohstoffe"),

    // Landwirtschaftliche Erzeugnisse
    WHEAT(Material.WHEAT, 3.0, "Landwirtschaft"),
    CARROT(Material.CARROT, 2.0, "Landwirtschaft"),
    POTATO(Material.POTATO, 2.0, "Landwirtschaft"),
    BEETROOT(Material.BEETROOT, 2.0, "Landwirtschaft"),
    SUGAR_CANE(Material.SUGAR_CANE, 1.0, "Landwirtschaft"),
    PUMPKIN(Material.PUMPKIN, 5.0, "Landwirtschaft"),
    MELON_SLICE(Material.MELON_SLICE, 1.0, "Landwirtschaft"),
    MELON(Material.MELON, 10, "Landwirtschaft"),
    BAMBOO(Material.BAMBOO, 1.0, "Landwirtschaft"),
    CACTUS(Material.CACTUS, 1.0, "Landwirtschaft"),

    // Tiere und andere Drops
    LEATHER(Material.LEATHER, 5.0, "Tiere und andere Drops"),
    BEEF(Material.BEEF, 4.0, "Tiere und andere Drops"),
    PORKCHOP(Material.PORKCHOP, 4.0, "Tiere und andere Drops"),
    CHICKEN(Material.CHICKEN, 3.0, "Tiere und andere Drops"),
    MUTTON(Material.MUTTON, 3.0, "Tiere und andere Drops"),
    RABBIT(Material.RABBIT, 5.0, "Tiere und andere Drops"),
    COD(Material.COD, 2.0, "Tiere und andere Drops"),
    SALMON(Material.SALMON, 3.0, "Tiere und andere Drops"),

    // Concrete und Concrete Powder (alle Farben)
    WHITE_CONCRETE(Material.WHITE_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    ORANGE_CONCRETE(Material.ORANGE_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    MAGENTA_CONCRETE(Material.MAGENTA_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    LIGHT_BLUE_CONCRETE(Material.LIGHT_BLUE_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    YELLOW_CONCRETE(Material.YELLOW_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    LIME_CONCRETE(Material.LIME_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    PINK_CONCRETE(Material.PINK_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    GRAY_CONCRETE(Material.GRAY_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    LIGHT_GRAY_CONCRETE(Material.LIGHT_GRAY_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    CYAN_CONCRETE(Material.CYAN_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    PURPLE_CONCRETE(Material.PURPLE_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    BLUE_CONCRETE(Material.BLUE_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    BROWN_CONCRETE(Material.BROWN_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    GREEN_CONCRETE(Material.GREEN_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    RED_CONCRETE(Material.RED_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    BLACK_CONCRETE(Material.BLACK_CONCRETE, 5.0, "Concrete & Concrete Powder"),
    WHITE_CONCRETE_POWDER(Material.WHITE_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    ORANGE_CONCRETE_POWDER(Material.ORANGE_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    MAGENTA_CONCRETE_POWDER(Material.MAGENTA_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    LIGHT_BLUE_CONCRETE_POWDER(Material.LIGHT_BLUE_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    YELLOW_CONCRETE_POWDER(Material.YELLOW_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    LIME_CONCRETE_POWDER(Material.LIME_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    PINK_CONCRETE_POWDER(Material.PINK_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    GRAY_CONCRETE_POWDER(Material.GRAY_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    LIGHT_GRAY_CONCRETE_POWDER(Material.LIGHT_GRAY_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    CYAN_CONCRETE_POWDER(Material.CYAN_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    PURPLE_CONCRETE_POWDER(Material.PURPLE_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    BLUE_CONCRETE_POWDER(Material.BLUE_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    BROWN_CONCRETE_POWDER(Material.BROWN_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    GREEN_CONCRETE_POWDER(Material.GREEN_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    RED_CONCRETE_POWDER(Material.RED_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),
    BLACK_CONCRETE_POWDER(Material.BLACK_CONCRETE_POWDER, 5.0, "Concrete & Concrete Powder"),

    // Terracotta (alle Farben)
    WHITE_TERRACOTTA(Material.WHITE_TERRACOTTA, 5.0, "Terracotta"),
    ORANGE_TERRACOTTA(Material.ORANGE_TERRACOTTA, 5.0, "Terracotta"),
    MAGENTA_TERRACOTTA(Material.MAGENTA_TERRACOTTA, 5.0, "Terracotta"),
    LIGHT_BLUE_TERRACOTTA(Material.LIGHT_BLUE_TERRACOTTA, 5.0, "Terracotta"),
    YELLOW_TERRACOTTA(Material.YELLOW_TERRACOTTA, 5.0, "Terracotta"),
    LIME_TERRACOTTA(Material.LIME_TERRACOTTA, 5.0, "Terracotta"),
    PINK_TERRACOTTA(Material.PINK_TERRACOTTA, 5.0, "Terracotta"),
    GRAY_TERRACOTTA(Material.GRAY_TERRACOTTA, 5.0, "Terracotta"),
    LIGHT_GRAY_TERRACOTTA(Material.LIGHT_GRAY_TERRACOTTA, 5.0, "Terracotta"),
    CYAN_TERRACOTTA(Material.CYAN_TERRACOTTA, 5.0, "Terracotta"),
    PURPLE_TERRACOTTA(Material.PURPLE_TERRACOTTA, 5.0, "Terracotta"),
    BLUE_TERRACOTTA(Material.BLUE_TERRACOTTA, 5.0, "Terracotta"),
    BROWN_TERRACOTTA(Material.BROWN_TERRACOTTA, 5.0, "Terracotta"),
    GREEN_TERRACOTTA(Material.GREEN_TERRACOTTA, 5.0, "Terracotta"),
    RED_TERRACOTTA(Material.RED_TERRACOTTA, 5.0, "Terracotta"),
    BLACK_TERRACOTTA(Material.BLACK_TERRACOTTA, 5.0, "Terracotta"),

    // Andere Items
    HEART_OF_THE_SEA(Material.HEART_OF_THE_SEA, 50.0, "Andere Items"),
    NAUTILUS_SHELL(Material.NAUTILUS_SHELL, 20.0, "Andere Items"),
    EXPERIENCE_BOTTLE(Material.EXPERIENCE_BOTTLE, 1.0, "Andere Items"),
    ENCHANTED_GOLDEN_APPLE(Material.ENCHANTED_GOLDEN_APPLE, 500.0, "Andere Items"),
    BOOK(Material.BOOK, 5.0, "Andere Items");

    private final Material material;
    private final double price;
    private final String category;

    SellableItems(Material material, double price, String category) {
        this.material = material;
        this.price = price;
        this.category = category;
    }

    SellableItems(Material material, String category) {
        this(material, 0.0, category);
    }

    public Material getMaterial() {
        return material;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
