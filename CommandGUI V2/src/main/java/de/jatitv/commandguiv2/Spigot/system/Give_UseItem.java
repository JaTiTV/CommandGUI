package de.jatitv.commandguiv2.Spigot.system;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.system.database.Select_Database;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class Give_UseItem {



    public static void onGive(Player player) {
        Integer slot;
        if (Select_Database.selectSlot(player) == null) {
            slot = SelectConfig.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }

        if (SelectConfig.UseItem_PlayerHead_Enable) {
            if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                send.player(player, Main.Prefix + "§c Playerheads for UseItem are only available from version §61.13§c!");
                send.error(Main.plugin, "Playerheads for UseItem are only available from version 1.13!");
            } else {

                if (SelectConfig.UseItem_Base64_Enable) {
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setDisplayName(SelectConfig.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
                    GameProfile profile = new GameProfile(UUID.randomUUID(), "");
                    profile.getProperties().put("textures", new Property("textures", SelectConfig.UseItem_Base64value));
                    Field profileField = null;
                    try {
                        profileField = playerheadmeta.getClass().getDeclaredField("profile");
                        profileField.setAccessible(true);
                        profileField.set(playerheadmeta, profile);
                    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                        e.printStackTrace();
                    }
                    playerhead.setItemMeta(playerheadmeta);
                    if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().setItem(slot - 1, playerhead);

                } else {
                    String p;
                    if (SelectConfig.UseItem_PlayerWhoHasOpenedTheGUI) {
                        p = player.getName();
                    } else p = SelectConfig.UseItem_PlayerName;
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setOwner(p);
                    playerheadmeta.setDisplayName(SelectConfig.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().setItem(slot - 1, playerhead);
                }
            }
        } else {
            ItemStack item = new ItemStack(Material.valueOf(SelectConfig.UseItem_Material));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(SelectConfig.UseItem_Name);
            if (Main.PaPi) {
                itemMeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
            } else itemMeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                player.getInventory().addItem(item);
            } else player.getInventory().setItem(slot - 1, item);
        }
    }

    public static void onGiveADD(Player player) {
        Integer slot;
        if (Select_Database.selectSlot(player) == null) {
            slot = SelectConfig.UseItem_InventorySlot;
        } else {
            slot = Select_Database.selectSlot(player);
        }

        if (SelectConfig.UseItem_PlayerHead_Enable) {
            if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                send.player(player, Main.Prefix + "§c Playerheads for UseItem are only available from version §61.13§c!");
                send.error(Main.plugin, "Playerheads for UseItem are only available from version 1.13!");
            } else {

                if (SelectConfig.UseItem_Base64_Enable) {
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setDisplayName(SelectConfig.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
                    GameProfile profile = new GameProfile(UUID.randomUUID(), "");
                    profile.getProperties().put("textures", new Property("textures", SelectConfig.UseItem_Base64value));
                    Field profileField = null;
                    try {
                        profileField = playerheadmeta.getClass().getDeclaredField("profile");
                        profileField.setAccessible(true);
                        profileField.set(playerheadmeta, profile);
                    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                        e.printStackTrace();
                    }
                    playerhead.setItemMeta(playerheadmeta);
                    if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().addItem(playerhead);

                } else {
                    String p;
                    if (SelectConfig.UseItem_PlayerWhoHasOpenedTheGUI) {
                        p = player.getName();
                    } else p = SelectConfig.UseItem_PlayerName;
                    ItemStack playerhead = new ItemStack(Main.Head);
                    SkullMeta playerheadmeta = (SkullMeta) playerhead.getItemMeta();
                    playerheadmeta.setOwner(p);
                    playerheadmeta.setDisplayName(SelectConfig.UseItem_Name);
                    if (Main.PaPi) {
                        playerheadmeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
                    } else playerheadmeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
                    playerhead.setItemMeta(playerheadmeta);
                    if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                        player.getInventory().addItem(playerhead);
                    } else player.getInventory().addItem(playerhead);
                }
            }
        } else {
            ItemStack item = new ItemStack(Material.valueOf(SelectConfig.UseItem_Material));
            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(SelectConfig.UseItem_Name);
            if (Main.PaPi) {
                itemMeta.setLore(Replace.replace(player, SelectConfig.UseItem_Lore));
            } else itemMeta.setLore(Replace.replace(SelectConfig.UseItem_Lore));
            item.setItemMeta(itemMeta);
            item.setAmount(1);
            if (SelectConfig.UseItem_InventorySlot_FreeSlot) {
                player.getInventory().addItem(item);
            } else player.getInventory().addItem(item);
        }
    }
}
