package de.kamiql.commands.enums;

import de.kamiql.Main;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

public enum SellableItems {

    // Erze
    COAL(Material.COAL),
    IRON_INGOT(Material.IRON_INGOT),
    GOLD_INGOT(Material.GOLD_INGOT),
    DIAMOND(Material.DIAMOND),
    EMERALD(Material.EMERALD),
    REDSTONE(Material.REDSTONE),
    LAPIS_LAZULI(Material.LAPIS_LAZULI),
    NETHERITE_INGOT(Material.NETHERITE_INGOT),
    COPPER_INGOT(Material.COPPER_INGOT),
    RAW_COPPER(Material.RAW_COPPER),
    RAW_GOLD(Material.RAW_GOLD),
    RAW_IRON(Material.RAW_IRON),

    // Roh-Erze
    COAL_ORE(Material.COAL_ORE),
    IRON_ORE(Material.IRON_ORE),
    GOLD_ORE(Material.GOLD_ORE),
    DIAMOND_ORE(Material.DIAMOND_ORE),
    EMERALD_ORE(Material.EMERALD_ORE),
    REDSTONE_ORE(Material.REDSTONE_ORE),
    LAPIS_ORE(Material.LAPIS_ORE),
    NETHER_GOLD_ORE(Material.NETHER_GOLD_ORE),
    ANCIENT_DEBRIS(Material.ANCIENT_DEBRIS),
    COPPER_ORE(Material.COPPER_ORE),

    DEEPSLATE_COAL_ORE(Material.DEEPSLATE_COAL_ORE),
    DEEPSLATE_IRON_ORE(Material.DEEPSLATE_IRON_ORE),
    DEEPSLATE_COPPER_ORE(Material.DEEPSLATE_COPPER_ORE),
    DEEPSLATE_GOLD_ORE(Material.DEEPSLATE_GOLD_ORE),
    DEEPSLATE_REDSTONE_ORE(Material.DEEPSLATE_REDSTONE_ORE),
    DEEPSLATE_EMERALD_ORE(Material.DEEPSLATE_EMERALD_ORE),
    DEEPSLATE_LAPIS_ORE(Material.DEEPSLATE_LAPIS_ORE),
    DEEPSLATE_DIAMOND_ORE(Material.DEEPSLATE_DIAMOND_ORE),

    // Erzblöcke
    IRON_BLOCK(Material.IRON_BLOCK),
    GOLD_BLOCK(Material.GOLD_BLOCK),
    DIAMOND_BLOCK(Material.DIAMOND_BLOCK),
    EMERALD_BLOCK(Material.EMERALD_BLOCK),
    REDSTONE_BLOCK(Material.REDSTONE_BLOCK),
    LAPIS_BLOCK(Material.LAPIS_BLOCK),
    COPPER_BLOCK(Material.COPPER_BLOCK),
    NETHERITE_BLOCK(Material.NETHERITE_BLOCK),

    // Holzarten (Logs)
    OAK_LOG(Material.OAK_LOG),
    SPRUCE_LOG(Material.SPRUCE_LOG),
    BIRCH_LOG(Material.BIRCH_LOG),
    JUNGLE_LOG(Material.JUNGLE_LOG),
    ACACIA_LOG(Material.ACACIA_LOG),
    DARK_OAK_LOG(Material.DARK_OAK_LOG),
    MANGROVE_LOG(Material.MANGROVE_LOG),
    CHERRY_LOG(Material.CHERRY_LOG),
    BAMBOO_BLOCK(Material.BAMBOO_BLOCK),
    CRIMSON_STEM(Material.CRIMSON_STEM),
    WARPED_STEM(Material.WARPED_STEM),


    // Verarbeitete Holzarten (Planks)
    OAK_PLANKS(Material.OAK_PLANKS),
    SPRUCE_PLANKS(Material.SPRUCE_PLANKS),
    BIRCH_PLANKS(Material.BIRCH_PLANKS),
    JUNGLE_PLANKS(Material.JUNGLE_PLANKS),
    ACACIA_PLANKS(Material.ACACIA_PLANKS),
    DARK_OAK_PLANKS(Material.DARK_OAK_PLANKS),
    MANGROVE_PLANKS(Material.MANGROVE_PLANKS),
    CHERRY_PLANKS(Material.CHERRY_PLANKS),
    BAMBOO_PLANKS(Material.BAMBOO_PLANKS),
    CRIMSON_PLANKS(Material.CRIMSON_PLANKS),
    WARPED_PLANKS(Material.WARPED_PLANKS),

    // Rohstoffe
    COBBLESTONE(Material.COBBLESTONE),
    STONE(Material.STONE),
    GRANITE(Material.GRANITE),
    DIORITE(Material.DIORITE),
    ANDESITE(Material.ANDESITE),
    SAND(Material.SAND),
    SANDSTONE(Material.SANDSTONE),
    GRAVEL(Material.GRAVEL),
    CLAY_BALL(Material.CLAY_BALL),
    CLAY(Material.CLAY),
    DIRT(Material.DIRT),
    GRASS_BLOCK(Material.GRASS_BLOCK),
    SNOWBALL(Material.SNOWBALL),
    ICE(Material.ICE),
    PACKED_ICE(Material.PACKED_ICE),
    BLUE_ICE(Material.BLUE_ICE),
    OBSIDIAN(Material.OBSIDIAN),
    NETHERRACK(Material.NETHERRACK),
    SOUL_SAND(Material.SOUL_SAND),
    SOUL_SOIL(Material.SOUL_SOIL),
    BASALT(Material.BASALT),
    BLACKSTONE(Material.BLACKSTONE),
    GLOWSTONE(Material.GLOWSTONE),
    QUARTZ(Material.QUARTZ),
    ENDER_PEARL(Material.ENDER_PEARL),
    SLIME_BALL(Material.SLIME_BALL),
    SLIME_BLOCK(Material.SLIME_BLOCK),
    HONEY_BLOCK(Material.HONEY_BLOCK),
    HONEYCOMB(Material.HONEYCOMB),
    HONEY_BOTTLE(Material.HONEY_BOTTLE),

    // Landwirtschaftliche Erzeugnisse
    WHEAT(Material.WHEAT),
    CARROT(Material.CARROT),
    POTATO(Material.POTATO),
    BEETROOT(Material.BEETROOT),
    SUGAR_CANE(Material.SUGAR_CANE),
    PUMPKIN(Material.PUMPKIN),
    MELON_SLICE(Material.MELON_SLICE),
    MELON(Material.MELON),
    BAMBOO(Material.BAMBOO),
    CACTUS(Material.CACTUS),

    // Tiere
    LEATHER(Material.LEATHER),
    BEEF(Material.BEEF),
    COOKED_BEEF(Material.COOKED_BEEF),
    PORKCHOP(Material.PORKCHOP),
    COOKED_PORKCHOP(Material.COOKED_PORKCHOP),
    CHICKEN(Material.CHICKEN),
    COOKED_CHICKEN(Material.COOKED_CHICKEN),
    MUTTON(Material.MUTTON),
    COOKED_MUTTON(Material.COOKED_MUTTON),
    RABBIT(Material.RABBIT),
    COOKED_RABBIT(Material.COOKED_RABBIT),
    COD(Material.COD),
    COOKED_COD(Material.COOKED_COD),
    SALMON(Material.SALMON),
    COOKED_SALMON(Material.COOKED_SALMON),

    // Concrete und Concrete Powder (alle Farben)
    WHITE_CONCRETE(Material.WHITE_CONCRETE),
    ORANGE_CONCRETE(Material.ORANGE_CONCRETE),
    MAGENTA_CONCRETE(Material.MAGENTA_CONCRETE),
    LIGHT_BLUE_CONCRETE(Material.LIGHT_BLUE_CONCRETE),
    YELLOW_CONCRETE(Material.YELLOW_CONCRETE),
    LIME_CONCRETE(Material.LIME_CONCRETE),
    PINK_CONCRETE(Material.PINK_CONCRETE),
    GRAY_CONCRETE(Material.GRAY_CONCRETE),
    LIGHT_GRAY_CONCRETE(Material.LIGHT_GRAY_CONCRETE),
    CYAN_CONCRETE(Material.CYAN_CONCRETE),
    PURPLE_CONCRETE(Material.PURPLE_CONCRETE),
    BLUE_CONCRETE(Material.BLUE_CONCRETE),
    BROWN_CONCRETE(Material.BROWN_CONCRETE),
    GREEN_CONCRETE(Material.GREEN_CONCRETE),
    RED_CONCRETE(Material.RED_CONCRETE),
    BLACK_CONCRETE(Material.BLACK_CONCRETE),
    WHITE_CONCRETE_POWDER(Material.WHITE_CONCRETE_POWDER),
    ORANGE_CONCRETE_POWDER(Material.ORANGE_CONCRETE_POWDER),
    MAGENTA_CONCRETE_POWDER(Material.MAGENTA_CONCRETE_POWDER),
    LIGHT_BLUE_CONCRETE_POWDER(Material.LIGHT_BLUE_CONCRETE_POWDER),
    YELLOW_CONCRETE_POWDER(Material.YELLOW_CONCRETE_POWDER),
    LIME_CONCRETE_POWDER(Material.LIME_CONCRETE_POWDER),
    PINK_CONCRETE_POWDER(Material.PINK_CONCRETE_POWDER),
    GRAY_CONCRETE_POWDER(Material.GRAY_CONCRETE_POWDER),
    LIGHT_GRAY_CONCRETE_POWDER(Material.LIGHT_GRAY_CONCRETE_POWDER),
    CYAN_CONCRETE_POWDER(Material.CYAN_CONCRETE_POWDER),
    PURPLE_CONCRETE_POWDER(Material.PURPLE_CONCRETE_POWDER),
    BLUE_CONCRETE_POWDER(Material.BLUE_CONCRETE_POWDER),
    BROWN_CONCRETE_POWDER(Material.BROWN_CONCRETE_POWDER),
    GREEN_CONCRETE_POWDER(Material.GREEN_CONCRETE_POWDER),
    RED_CONCRETE_POWDER(Material.RED_CONCRETE_POWDER),
    BLACK_CONCRETE_POWDER(Material.BLACK_CONCRETE_POWDER),

    // Terracotta (alle Farben)
    WHITE_TERRACOTTA(Material.WHITE_TERRACOTTA),
    ORANGE_TERRACOTTA(Material.ORANGE_TERRACOTTA),
    MAGENTA_TERRACOTTA(Material.MAGENTA_TERRACOTTA),
    LIGHT_BLUE_TERRACOTTA(Material.LIGHT_BLUE_TERRACOTTA),
    YELLOW_TERRACOTTA(Material.YELLOW_TERRACOTTA),
    LIME_TERRACOTTA(Material.LIME_TERRACOTTA),
    PINK_TERRACOTTA(Material.PINK_TERRACOTTA),
    GRAY_TERRACOTTA(Material.GRAY_TERRACOTTA),
    LIGHT_GRAY_TERRACOTTA(Material.LIGHT_GRAY_TERRACOTTA),
    CYAN_TERRACOTTA(Material.CYAN_TERRACOTTA),
    PURPLE_TERRACOTTA(Material.PURPLE_TERRACOTTA),
    BLUE_TERRACOTTA(Material.BLUE_TERRACOTTA),
    BROWN_TERRACOTTA(Material.BROWN_TERRACOTTA),
    GREEN_TERRACOTTA(Material.GREEN_TERRACOTTA),
    RED_TERRACOTTA(Material.RED_TERRACOTTA),
    BLACK_TERRACOTTA(Material.BLACK_TERRACOTTA),

    // Andere Items
    HEART_OF_THE_SEA(Material.HEART_OF_THE_SEA),
    NAUTILUS_SHELL(Material.NAUTILUS_SHELL),
    EXPERIENCE_BOTTLE(Material.EXPERIENCE_BOTTLE),
    ENCHANTED_GOLDEN_APPLE(Material.ENCHANTED_GOLDEN_APPLE),
    BOOK(Material.BOOK),
    BEACON(Material.BEACON),
    DRAGON_EGG(Material.DRAGON_EGG),
    TOTEM_OF_UNDYING(Material.TOTEM_OF_UNDYING),
    TRIDENT(Material.TRIDENT),
    ELYTRA(Material.ELYTRA),
    SHULKER_SHELL(Material.SHULKER_SHELL),
    PHANTOM_MEMBRANE(Material.PHANTOM_MEMBRANE),
    SADDLE(Material.SADDLE),
    NAME_TAG(Material.NAME_TAG),
    NETHER_STAR(Material.NETHER_STAR),
    ENDER_EYE(Material.ENDER_EYE),
    ENDER_CHEST(Material.ENDER_CHEST),
    BLAZE_ROD(Material.BLAZE_ROD),
    GHAST_TEAR(Material.GHAST_TEAR),
    WITHER_ROSE(Material.WITHER_ROSE),
    TURTLE_HELMET(Material.TURTLE_HELMET);

    private final Material material;

    SellableItems(Material material) {
        this.material = material;
    }

    public Material getMaterial() {
        return material;
    }

    public double getPrice() {
        FileConfiguration config = Main.getInstance().getConfig();
        String path = "items." + this.material.toString();
        return config.contains(path) ? config.getDouble(path) : 0.0;
    }
}
