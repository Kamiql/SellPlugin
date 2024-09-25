package de.kamiql.commands;

import de.kamiql.Main;
import de.kamiql.gui.SellGUI;
import de.kamiql.util.Logger;
import de.kamiql.util.Messages;
import de.kamiql.util.Sellables;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SellCommand implements TabExecutor, Listener {
    private static final Logger logger = Main.getCustomLogger();

    private static final String SELLGUI_TITLE = "§8§lSell";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1 && args[0].equalsIgnoreCase("info")) {

                new SellGUI().openGUI(player);

                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

                return true;
            } else {
                Inventory inventory = Bukkit.createInventory(player, 6*9, SELLGUI_TITLE);
                player.openInventory(inventory);
                return true;
            }
        }
        return false;
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        String title = event.getView().getTitle();

        if (title.equals(SELLGUI_TITLE)) {
            Inventory inventory = event.getInventory();
            Player player = (Player) event.getPlayer();
            double total = 0;

            List<ItemStack> itemsToReturn = new ArrayList<>();
            Integer selledItems = 0;

            for (ItemStack item : inventory.getContents()) {
                if (item != null && isSellable(item)) {
                    total += getPrice(item.getType()) * item.getAmount();
                    selledItems += item.getAmount();
                } else if (item != null) {
                    itemsToReturn.add(item);
                }
            }

            if (selledItems > 0) {
                String message = new Messages().getMessage("data.messages.sellCommand.selled")
                        .replace("{total.price}", String.valueOf(total))
                        .replace("{total.item_count}", String.valueOf(selledItems))
                        .replace("{total.stack_count}", ((double) selledItems / 64) % 1 == 0
                                ? String.format("%.1f", (double) selledItems / 64)
                                : String.format("%.2f", (double) selledItems / 64));

                player.sendMessage(message);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.0f);
                Main.getEconomy().depositPlayer(player, total);

            } else if (!itemsToReturn.isEmpty()) {
                player.sendMessage(new Messages().getMessage("data.messages.sellCommand.noItem"));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);

            } else return;

            for (ItemStack item : itemsToReturn) {
                player.getInventory().addItem(item);
            }

            logger.log("Player " + player.getName() + " sold " + selledItems + " item/s for a " + total + "$");
        }
    }

    private boolean isSellable(ItemStack item) {
        Material material = item.getType();

        if (!new Sellables().isSellable(material)) {
            return false;
        }

        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();

            if (meta.hasCustomModelData()) {
                return false;
            }

            if (meta.hasAttributeModifiers()) {
                return false;
            }

            return !meta.hasLore();
        }
        return true;
    }

    private double getPrice(Material material) {
        Double price = new Sellables().getPrice(material);
        return price != 0 ? price : 0;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            List<String> comp = new ArrayList<>();
            comp.add("info");
            return comp;
        }
        return List.of();
    }
}
