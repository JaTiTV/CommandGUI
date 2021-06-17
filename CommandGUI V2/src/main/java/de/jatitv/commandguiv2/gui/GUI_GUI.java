package de.jatitv.commandguiv2.gui;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Objekte.GUI_Slot;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.system.Main;
import de.jatitv.commandguiv2.system.Replace;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class GUI_GUI {
    public static void openGUI(Player player, GUI_Objekt gui) {
        player.sendMessage("4");

        if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
            player.sendMessage("5");
            Inventory inventory;
            if (Main.PaPi){
                inventory = Bukkit.createInventory((InventoryHolder) null, 9 * gui.GUI_Lines, (Replace.replace(player, "§6§8§9§r" + gui.GUI_Name)));

            } else inventory = Bukkit.createInventory((InventoryHolder) null, 9 * gui.GUI_Lines, (Replace.replace("§6§8§9§r" + gui.GUI_Name)));


            if (gui.GUI_FillItem_Enable) {
                ItemStack glass = new ItemStack(Material.valueOf(gui.GUI_FillItem_Item.toUpperCase().replace(".", "_")));
                ItemMeta itemMetaglass = glass.getItemMeta();
                itemMetaglass.setDisplayName(" ");
                glass.setItemMeta(itemMetaglass);
                glass.setAmount(1);
                for (int i = 0; i < 9 * gui.GUI_Lines; i++) {
                    inventory.setItem(i, glass);
                }
            }
            for (GUI_Slot slot : gui.GUI_Slots) {
                if (slot.Enable) {
                    if (slot.PlayerHead_Enable) {
                        if (slot.Base64Value_Enable) {
                            ItemStack item = new ItemStack(Main.Head);
                            SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                            if (Main.PaPi) {
                                itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + Select_config.Currency));
                            } else {
                                itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                                itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + Select_config.Currency));
                            }
                            GameProfile profile = new GameProfile(UUID.randomUUID(), "");
                            profile.getProperties().put("textures", new Property("textures", slot.Base64Value));
                            Field profileField = null;
                            try {
                                profileField = itemMeta.getClass().getDeclaredField("profile");
                                profileField.setAccessible(true);
                                profileField.set(itemMeta, profile);
                            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
                                e.printStackTrace();
                            }
                            item.setItemMeta(itemMeta);
                            item.setAmount(1);
                            inventory.setItem(slot.Slot, item);
                        } else {
                            if (slot.PlayerWhoHasOpenedTheGUI) {
                                ItemStack item = new ItemStack(Main.Head);
                                SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                                itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                if (Main.PaPi) {
                                    itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + Select_config.Currency));
                                } else itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + Select_config.Currency));
                                itemMeta.setOwner(player.getName());
                                item.setItemMeta(itemMeta);
                                item.setAmount(1);
                                inventory.setItem(slot.Slot, item);
                            } else {
                                ItemStack item = new ItemStack(Main.Head);
                                SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                                itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                if (Main.PaPi) {
                                    itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + Select_config.Currency));
                                } else itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + Select_config.Currency));
                                itemMeta.setOwner(slot.PlayerName);
                                item.setItemMeta(itemMeta);
                                item.setAmount(1);
                                inventory.setItem(slot.Slot, item);
                            }
                        }
                    } else {
                        ItemStack item = new ItemStack(Material.valueOf(slot.Item.toUpperCase().replace(".", "_")));
                        ItemMeta itemMeta = item.getItemMeta();
                        if (Main.PaPi){
                            itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                            itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + Select_config.Currency));
                        } else{
                            itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                            itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + Select_config.Currency));
                        }

                        item.setItemMeta(itemMeta);
                        item.setAmount(1);
                        inventory.setItem(slot.Slot, item);
                    }
                }
            }
            player.openInventory(inventory);
        } else player.sendMessage(Select_msg.GUIIsDisabled.replace("[gui]", Replace.replace(gui.GUI_Name)));
    }
}
