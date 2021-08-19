package de.jatitv.commandguiv2.Spigot.gui;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.jatitv.commandguiv2.Spigot.Listener.GUI_Listener;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.Slot;
import de.jatitv.commandguiv2.Spigot.system.Replace;
import de.jatitv.commandguiv2.Spigot.system.config.languages.SelectMessages;
import de.jatitv.commandguiv2.Spigot.Objekte.Objekt;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.system.send;
import de.jatitv.plotsquaredgui.api.PlotSquaredGUIapi;
import io.github.solyze.plugmangui.inventories.PluginListGUI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.Plugin;

import java.lang.reflect.Field;
import java.util.UUID;

public class OpenGUI {
    private static Plugin plugin = Main.plugin;

    public static void openGUI(Player player, Objekt gui, String guiString) {
        Long long_ = Long.valueOf(System.currentTimeMillis());
        // ToDo 2.5.4 switch (guiString) {
        // ToDo 2.5.4     case "plugin.PlotSquaredGUI":
        // ToDo 2.5.4         if (Main.PlotSquaredGUI) {
        // ToDo 2.5.4             PlotSquaredGUIapi.openMainGUI(player);
        // ToDo 2.5.4         } else {
        // ToDo 2.5.4             if (player.hasPermission("commandgui.admin")) {
        // ToDo 2.5.4                 send.player(player, Main.Prefix + " §4PlotSquaredGUI could not be found! §9Please download it here: " +
        // ToDo 2.5.4                         "§6https://spigotmc.org/resources/plotsquaredgui.77506/");
        // ToDo 2.5.4             }
        // ToDo 2.5.4         }
        // ToDo 2.5.4         return;
        // ToDo 2.5.4     case "plugin.PlugManGUI":
        // ToDo 2.5.4         if (Main.PlugManGUI){
        // ToDo 2.5.4             player.openInventory((new PluginListGUI(54,1)).getInventory());
        // ToDo 2.5.4         } else {
        // ToDo 2.5.4             if (player.hasPermission("commandgui.admin")) {
        // ToDo 2.5.4                 send.player(player, Main.Prefix + " §4PlugManGUI could not be found! §9Please download it here: " +
        // ToDo 2.5.4                         "§6https://spigotmc.org/resources/plugmangui.87599/");
        // ToDo 2.5.4             }
        // ToDo 2.5.4         }
        // ToDo 2.5.4         return;
        // ToDo 2.5.4 }

        if (Main.minecraft1_13) {
            GUI_Listener.GUICode = "";
        } else GUI_Listener.GUICode = "§6§8§9§r";
        if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
            Inventory inventory;
            if (Main.PaPi) {
                inventory = Bukkit.createInventory((InventoryHolder) null, 9 * gui.GUI_Lines, (Replace.replace(player, GUI_Listener.GUICode + gui.GUI_Name)));
            } else inventory = Bukkit.createInventory((InventoryHolder) null, 9 * gui.GUI_Lines, (Replace.replace(GUI_Listener.GUICode + gui.GUI_Name)));

            if (gui.GUI_FillItem_Enable) {
                ItemStack glass;
                if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                    glass = new ItemStack(Material.valueOf("STAINED_GLASS_PANE"), 1, Short.valueOf(gui.GUI_FillItem_Item));
                } else glass = new ItemStack(Material.valueOf(gui.GUI_FillItem_Item.toUpperCase().replace(".", "_")));
                ItemMeta itemMetaglass = glass.getItemMeta();
                itemMetaglass.setDisplayName(" ");
                glass.setItemMeta(itemMetaglass);
                glass.setAmount(1);
                for (int i = 0; i < 9 * gui.GUI_Lines; i++) {
                    inventory.setItem(i, glass);
                }
            }
            for (Slot slot : gui.GUI_Slots) {
                if (slot.Enable) {
                    if (slot.Empty) {
                        ItemStack air = new ItemStack(Material.AIR);
                        inventory.setItem(slot.Slot, air);
                    } else {
                        if (slot.PlayerHead_Enable) {
                            if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                                send.player(player, Main.Prefix + "§c Playerheads are only available from version §61.13§c! §7- §bGUI: §6" + Replace.replace(gui.GUI_Name).toString() + " §bSlot: §6" + (slot.Slot + 1) + " §7- " + Replace.replace(slot.Name));
                                send.error(plugin, "Playerheads are only available from version 1.13!");
                                send.console(Main.Prefix + " §bGUI: §6" + Replace.replace(gui.GUI_Name).toString() + " §bSlot: §6" + (slot.Slot + 1) + " §7- " + Replace.replace(slot.Name));
                            } else {

                                if (slot.Base64_Enable) {
                                    ItemStack item = new ItemStack(Main.Head);
                                    SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                                    if (Main.PaPi) {
                                        itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                        itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + SelectConfig.Currency));
                                    } else {
                                        itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                                        itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + SelectConfig.Currency));
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
                                    Integer am;
                                    if (slot.ItemAmount == 0) {
                                        am = 1;
                                    } else am = slot.ItemAmount;
                                    item.setAmount(am);
                                    inventory.setItem(slot.Slot, item);
                                } else {
                                    if (slot.PlayerWhoHasOpenedTheGUI) {
                                        ItemStack item = new ItemStack(Main.Head);
                                        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                                        if (Main.PaPi) {
                                            itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                            itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + SelectConfig.Currency));
                                        } else {
                                            itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                                            itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + SelectConfig.Currency));
                                        }
                                        itemMeta.setOwner(player.getName());
                                        item.setItemMeta(itemMeta);
                                        Integer am;
                                        if (slot.ItemAmount == 0) {
                                            am = 1;
                                        } else am = slot.ItemAmount;
                                        item.setAmount(am);
                                        inventory.setItem(slot.Slot, item);
                                    } else {
                                        ItemStack item = new ItemStack(Main.Head);
                                        SkullMeta itemMeta = (SkullMeta) item.getItemMeta();
                                        if (Main.PaPi) {
                                            itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                            itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + SelectConfig.Currency));
                                        } else {
                                            itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                                            itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + SelectConfig.Currency));
                                        }
                                        itemMeta.setOwner(slot.PlayerName);
                                        item.setItemMeta(itemMeta);
                                        Integer am;
                                        if (slot.ItemAmount == 0) {
                                            am = 1;
                                        } else am = slot.ItemAmount;
                                        item.setAmount(am);
                                        inventory.setItem(slot.Slot, item);
                                    }
                                }
                            }
                        } else {
                            ItemStack item = new ItemStack(Material.valueOf(slot.Item.toUpperCase().replace(".", "_")));
                            ItemMeta itemMeta = item.getItemMeta();
                            if (Main.PaPi) {
                                itemMeta.setDisplayName(Replace.replace(player, slot.Name.replace("[player]", player.getName())));
                                itemMeta.setLore(Replace.replacePrice(player, slot.Lore, slot.Price + " " + SelectConfig.Currency));
                            } else {
                                itemMeta.setDisplayName(Replace.replace(slot.Name.replace("[player]", player.getName())));
                                itemMeta.setLore(Replace.replacePrice(slot.Lore, slot.Price + " " + SelectConfig.Currency));
                            }
                            item.setItemMeta(itemMeta);
                            Integer am;
                            if (slot.ItemAmount == 0) {
                                am = 1;
                            } else am = slot.ItemAmount;
                            item.setAmount(am);
                            inventory.setItem(slot.Slot, item);
                        }
                    }
                }
            }

            player.openInventory(inventory);
            send.debug(plugin, "§6" + player.getName() + " §5Open §6" + Replace.replace(gui.GUI_Name) + " §5" + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
        } else player.sendMessage(SelectMessages.GUIIsDisabled.replace("[gui]", Replace.replace(gui.GUI_Name)));
    }
}
