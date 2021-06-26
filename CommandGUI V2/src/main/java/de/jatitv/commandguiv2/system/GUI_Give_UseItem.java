package de.jatitv.commandguiv2.system;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_10bis1_15;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_8bis1_9;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_ab1_16;
import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.system.database.Select_Database;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;
import java.util.UUID;

public class GUI_Give_UseItem {



    public static void onGive(Player player) {
        Integer slot;
        if (Select_Database.selectSlot(player) == null) {
            slot = Select_config.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }

        //   new BukkitRunnable() {
        //   @Override
        //     public void run() {
        if (Select_config.UseItem_PlayerHead_Enable) {
            if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                send.player(player, Main.Prefix + "§c Playerheads for UseItem are only available from version §61.13§c!");
                send.error(Main.plugin, "Playerheads for UseItem are only available from version 1.13!");
            } else {

                if (Select_config.UseItem_Base64_Enable) {
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(Select_config.UseItem_Lore));
                    GameProfile profile = new GameProfile(UUID.randomUUID(), "");
                    profile.getProperties().put("textures", new Property("textures", Select_config.UseItem_Base64value));
                    Field profileField = null;
                    try {
                        profileField = playerheadmeta.getClass().getDeclaredField("profile");
                        profileField.setAccessible(true);
                        profileField.set(playerheadmeta, profile);
                    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                        e.printStackTrace();
                    }
                    playerhead.setItemMeta(playerheadmeta);
                    if (Select_config.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().setItem(slot - 1, playerhead);

                } else {
                    String p;
                    if (Select_config.UseItem_PlayerWhoHasOpenedTheGUI) {
                        p = player.getName();
                    } else p = Select_config.UseItem_PlayerName;
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setOwner(p);
                    playerheadmeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(Select_config.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    if (Select_config.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().setItem(slot - 1, playerhead);
                }
            }
        } else {
            ItemStack item = new ItemStack(Material.valueOf(Select_config.UseItem_Material));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(Select_config.UseItem_Name);
            if (Main.PaPi) {
                itemMeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
            } else itemMeta.setLore(Replace.replace(Select_config.UseItem_Lore));
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            if (Select_config.UseItem_InventorySlot_FreeSlot) {
                player.getInventory().addItem(item);
            } else player.getInventory().setItem(slot - 1, item);
        }
        //     }
        //   }.runTaskLater(Main.getPlugin(), 20L * 1);
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
                        playerheadmeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    player.getInventory().addItem(playerhead);
                } else {
                    ItemStack item = new ItemStack(Material.valueOf(Select_config.UseItem_Material));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(Select_config.UseItem_Name);
                    if (Main.PaPi) {
                        itemMeta.setLore(Replace.replace(player, Select_config.UseItem_Lore));
                    } else itemMeta.setLore(Replace.replace(Select_config.UseItem_Lore));
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    player.getInventory().addItem(item);
                }
            }
        }.runTaskLater(Main.plugin, 20L * 1);
    }
}
