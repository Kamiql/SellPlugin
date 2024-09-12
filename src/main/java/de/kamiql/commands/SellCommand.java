package de.kamiql.commands;

import de.kamiql.Main;
import de.kamiql.commands.enums.SellableItems;
import de.kamiql.util.Messages;
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

    private static final String SELLGUI_TITLE = "§8§lSell";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 1 && args[0].equalsIgnoreCase("info")) {

                player.sendActionBar(new Messages().getMessage("data.messages.disabled"));
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
            List<ItemStack> selledItems = new ArrayList<>();

            for (ItemStack item : inventory.getContents()) {
                if (item != null && isSellable(item)) {
                    total += getPrice(item.getType()) * item.getAmount();
                    selledItems.add(item);
                } else if (item != null) {
                    itemsToReturn.add(item);
                }
            }

            if (!selledItems.isEmpty()) {

                player.sendMessage(new Messages().getMessage("data.messages.selled"));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.0f, 1.0f);

                Main.getEconomy().depositPlayer(player, total);
            } else {
                player.sendMessage(new Messages().getMessage("data.messages.noItem"));
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1.0f, 1.0f);
            }

            for (ItemStack item : itemsToReturn) {
                player.getInventory().addItem(item);
            }
        }
    }

    private boolean isSellable(ItemStack item) {
        Material material = item.getType();

        if (!isSellableMaterial(material)) {
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

            if (meta.hasLore()) {
                return false;
            }
        }
        return true;
    }


    private boolean isSellableMaterial(Material material) {
        for (SellableItems item : SellableItems.values()) {
            if (item.getMaterial() == material) {
                return true;
            }
        }
        return false;
    }

    private double getPrice(Material material) {
        for (SellableItems item : SellableItems.values()) {
            if (item.getMaterial() == material) {
                return item.getPrice();
            }
        }
        return 0;
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
