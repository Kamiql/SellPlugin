package de.kamiql.gui;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import com.github.stefvanschie.inventoryframework.pane.util.Mask;
import com.github.stefvanschie.inventoryframework.pane.util.Slot;
import de.kamiql.inventoryframework.extensions.ItemPaletteGUI;
import de.kamiql.util.Sellables;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class SellGUI {

    private ChestGui home_gui = new ChestGui(6, "Sell Navigator");

    private final Sellables sellables;

    public SellGUI() {
        this.sellables = new Sellables();
        this.home_gui = setupGUI();
    }

    private ChestGui setupGUI() {

        home_gui.setOnGlobalClick(event -> {
            event.setCancelled(true);
        });
        Mask mask1 = new Mask(
                "111111111",
                "100000001",
                "100000001",
                "100000001",
                "100000001",
                "111111111"
        );

        Mask mask2 = new Mask(
                "000000000",
                "011111110",
                "011111110",
                "011111110",
                "011111110",
                "000000000"
        );

        OutlinePane pane = new OutlinePane(0, 0, 9, 6, Pane.Priority.LOWEST);
        pane.applyMask(mask1);
        pane.addItem(new GuiItem(new ItemStack(Material.WHITE_STAINED_GLASS_PANE)));
        pane.setRepeat(true);
        home_gui.addPane(pane);

        OutlinePane pane1 = new OutlinePane(0, 0, 9, 6, Pane.Priority.HIGHEST);
        pane1.applyMask(mask2);

        for (Sellables.ItemCategory category : sellables.getCategories()) {
            Material category_material = category.getMaterial();
            String category_name = category.getName();
            if (category_material != null) {
                ItemStack item = new ItemStack(category_material);
                ItemMeta meta = item.getItemMeta();

                meta.setDisplayName("§e§l" + category_name);
                List<String> lore = new ArrayList<>();
                lore.add("§7Items: §a" + category.getItems().size());
                meta.setLore(lore);
                item.setItemMeta(meta);

                GuiItem guiItem = new GuiItem(item, event -> {
                    List<Material> items = category.getItems();

                    ItemPaletteGUI gui = new ItemPaletteGUI.Builder("§e§l" + category.getName())
                            .as(material -> {
                                ItemStack itemStack = new ItemStack(material);
                                ItemMeta itemMeta = itemStack.getItemMeta();
                                itemMeta.setDisplayName("§e§l" + material.name());
                                lore.clear();
                                lore.add("§7Preis: §a" + new Sellables().getPrice(material));
                                itemMeta.setLore(lore);
                                itemStack.setItemMeta(itemMeta);
                                return new GuiItem(itemStack);
                            })
                            .show(items::contains)
                            .build();

                    OutlinePane pane2 = new OutlinePane(Slot.fromIndex(49), 1, 1);

                    ItemStack item1 = new ItemStack(Material.COMPASS);
                    ItemMeta itemMeta1 = item.getItemMeta();
                    itemMeta1.setDisplayName("§c§lZurück");
                    lore.clear();
                    lore.add("§7Klicke hier, um zurück ins Hauptmenü zu gelangen!");
                    itemMeta1.setLore(lore);
                    item1.setItemMeta(itemMeta1);

                    GuiItem guiItem1 = new GuiItem(item1, event1 -> {
                        home_gui.show(event1.getWhoClicked());
                    });
                    pane2.addItem(guiItem1);
                    gui.addPane(pane2);

                    gui.show(event.getWhoClicked());
                });

                pane1.addItem(guiItem);
            }
        }
        pane1.setRepeat(false);
        home_gui.addPane(pane1);

        return home_gui;
    }

    public void openGUI(Player viewer) {
        home_gui.show(viewer);
    }
}
