package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.select.Select_config;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class GUI_Give_UseItem {
    public static void onGive(String p) {
        Player player = Bukkit.getPlayer(p);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Select_config.UseItem_PlayerHead_Enable) {
                    String p;
                    if (Select_config.UseItem_PlayerWhoHasOpenedTheGUI) {
                        p = player.getName();
                    } else p = Select_config.UseItem_PlayerName;
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setOwner(p);
                    playerheadmeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Main.replace(player, Select_config.UseItem_Lore));
                    } else playerheadmeta.setLore(Main.replace(Select_config.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    if (Select_config.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().setItem(Select_config.UseItem_InventorySlot - 1, playerhead);
                } else {
                    ItemStack item = new ItemStack(Material.valueOf(Select_config.UseItem_Material));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        itemMeta.setLore(Main.replace(player, Select_config.UseItem_Lore));
                    } else itemMeta.setLore(Main.replace(Select_config.UseItem_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    if (Select_config.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(item);
                    } else player.getInventory().setItem(Select_config.UseItem_InventorySlot - 1, item);
                }
            }
        }.runTaskLater(Main.getPlugin(), 20L * 1);
    }

    public static void onGiveADD(String p) {
        Player player = Bukkit.getPlayer(p);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (Select_config.UseItem_PlayerHead_Enable) {
                    String p;
                    if (Select_config.UseItem_PlayerWhoHasOpenedTheGUI) {
                        p = player.getName();
                    } else p = Select_config.UseItem_PlayerName;
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setOwner(p);
                    playerheadmeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Main.replace(player, Select_config.UseItem_Lore));
                    } else playerheadmeta.setLore(Main.replace(player, Select_config.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    player.getInventory().addItem(playerhead);
                } else {
                    ItemStack item = new ItemStack(Material.valueOf(Select_config.UseItem_Material));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        itemMeta.setLore(Main.replace(player, Select_config.UseItem_Lore));
                    } else itemMeta.setLore(Main.replace(Select_config.UseItem_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    player.getInventory().addItem(item);
                }
            }
        }.runTaskLater(Main.getPlugin(), 20L * 1);
    }
}
