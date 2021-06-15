package de.jatitv.commandguiv2.gui;

import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Objekte.GUI_Slot;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_sound;
import de.jatitv.commandguiv2.system.Main;
import de.jatitv.commandguiv2.system.Vault;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUI_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            for (GUI_Objekt gui : Main.guiHashMap.values()) {
                if (player.getOpenInventory().getTitle().equals(Main.replace("§6§8§9§r" + gui.GUI_Name))
                        || player.getOpenInventory().getTitle().equals(Main.replace(player, "§6§8§9§r" + gui.GUI_Name))) {
                    e.setCancelled(true);
                    for (GUI_Slot slot : gui.GUI_Slots) {
                        if (e.getSlot() == slot.Slot) {
                            if (!slot.Perm || player.hasPermission("commandgui.gui." + gui.Command_Command + ".slot." + (slot.Slot  + 1))
                                    || player.hasPermission("commandgui.admin")) {
                                if (slot.Enable) {
                                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Main.replace(slot.Name))) {
                                        if (e.getCurrentItem().getType() == Main.Head || e.getCurrentItem().getType() == Material.valueOf(slot.Item.toUpperCase().replace(".", "_"))) {
                                            if (slot.Cost_Enable) {
                                                if (Vault.buy(player, slot.Price)) {
                                                    if (slot.Command_Enable || slot.Message_Enable) {
                                                        player.sendMessage(Select_msg.Buy_msg.replace("[itemname]", slot.Name)
                                                                .replace("[price]", slot.Price + " " + Select_config.Currency));
                                                        if (slot.Command_Enable) {
                                                            player.closeInventory();
                                                            if (slot.CommandAsConsole) {
                                                                for (String cmd : slot.Command){
                                                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd.replace("[player]", player.getName()));
                                                                }
                                                            } else {
                                                                for (String cmd : slot.Command){
                                                                    player.chat("/" + cmd.replace("[player]", player.getName()));
                                                                }
                                                            }
                                                            if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                                if (slot.CustomSound_Enable) {
                                                                    player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                                } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                            }
                                                        }
                                                        if (slot.OpenGUI_Enable) {
                                                            player.closeInventory();
                                                            GUI_GUI.openGUI(player, Main.guiHashMap.get(slot.OpenGUI));
                                                            if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                                if (slot.CustomSound_Enable) {
                                                                    player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                                } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                            }
                                                        }
                                                        if (slot.Message_Enable) {
                                                            player.closeInventory();
                                                            for (String msg : slot.Message) {
                                                                player.sendMessage(Main.replace(player, msg.replace("[prefix]", Main.Prefix)));
                                                            }
                                                            if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                                if (slot.CustomSound_Enable) {
                                                                    player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                                } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    player.closeInventory();
                                                    player.sendMessage(Select_msg.No_money);
                                                    if (Select_sound.Sound_NoMoney_Enable && Select_sound.Sound_Enable) {
                                                        player.playSound(player.getLocation(), Select_sound.Sound_NoMoney, 3, 1);
                                                    }
                                                }
                                            } else {
                                                if (slot.Command_Enable) {
                                                    player.closeInventory();
                                                    if (slot.CommandAsConsole) {
                                                        for (String cmd : slot.Command){
                                                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd.replace("[player]", player.getName()));
                                                        }
                                                    } else {
                                                        for (String cmd : slot.Command){
                                                            player.chat("/" + cmd.replace("[player]", player.getName()));
                                                        }
                                                    }
                                                    if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                        if (slot.CustomSound_Enable) {
                                                            player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                        } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                    }
                                                }
                                                if (slot.OpenGUI_Enable) {
                                                    player.closeInventory();
                                                    GUI_GUI.openGUI(player, Main.guiHashMap.get(slot.OpenGUI));
                                                    if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                        if (slot.CustomSound_Enable) {
                                                            player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                        } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                    }
                                                }
                                                if (slot.Message_Enable) {
                                                    player.closeInventory();
                                                    for (String msg : slot.Message) {
                                                        player.sendMessage(Main.replace(player, msg.replace("[prefix]", Main.Prefix)));
                                                    }
                                                    if (Select_sound.Sound_Enable && Select_sound.Sound_Click_Enable) {
                                                        if (slot.CustomSound_Enable) {
                                                            player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);
                                                        } else player.playSound(player.getLocation(), Select_sound.Sound_Click, 3, 1);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                player.sendMessage(Select_msg.NoPermissionForItem.replace("[item]", Main.replace(slot.Name))
                                        .replace("[perm]", "commandgui.gui." + gui.Command_Command + ".slot." + (slot.Slot  + 1)));
                            }
                        }
                    }
                }
            }
        }
    }
}
