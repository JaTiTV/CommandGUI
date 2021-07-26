package de.jatitv.commandguiv2.Spigot.Listener;

import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Slot;
import de.jatitv.commandguiv2.Spigot.gui.GUI_GUI;
import de.jatitv.commandguiv2.Spigot.system.BCommand_Sender_Reciver;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_config;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.Replace;
import de.jatitv.commandguiv2.Spigot.system.Vault;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

public class GUI_Listener implements Listener {

    public static String GUICode;
    private static Plugin plugin = Main.plugin;

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            for (GUI_Objekt gui : Main.guiHashMap.values()) {
                if (player.getOpenInventory().getTitle().equals(Replace.replace(GUICode + gui.GUI_Name))
                        || (Main.PaPi && player.getOpenInventory().getTitle().equals(Replace.replace(player, GUICode + gui.GUI_Name)))) {
                    e.setCancelled(true);
                    for (GUI_Slot slot : gui.GUI_Slots) {
                       /* if (!slot.ItemsRemovable) {
                            e.setCancelled(true);
                        }
                        */

                        if (e.getSlot() == slot.Slot) {

                            if (!slot.Perm || player.hasPermission("commandgui.gui." + gui.Command_Command + ".slot." + (slot.Slot + 1))
                                    || player.hasPermission("commandgui.admin")) {

                                if (slot.Enable) {
                                    if (e.getCurrentItem().getItemMeta().getDisplayName().equals(Replace.replace(slot.Name))) {
                                        if (e.getCurrentItem().getType() == Main.Head || e.getCurrentItem().getType() == Material.valueOf(slot.Item.toUpperCase().replace(".", "_"))) {
                                            if (slot.Cost_Enable) {
                                                if (slot.Command_Enable || slot.Message_Enable || slot.OpenGUI_Enable || slot.ServerChange) {
                                                    if (Vault.buy(player, slot.Price)) {
                                                        player.sendMessage(Select_msg.Buy_msg.replace("[itemname]", Replace.replace(slot.Name))
                                                                .replace("[price]", slot.Price + " " + Select_config.Currency));
                                                        if (slot.Command_Enable) {

                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    player.closeInventory();
                                                                }
                                                            }.runTaskLater(plugin, 1L);

                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    if (slot.Command_BungeeCommand && Select_config.Bungee) {
                                                                        for (String cmd : slot.Command) {
                                                                            BCommand_Sender_Reciver.sendToBungee(player.getName(), cmd.replace("[player]", player.getName()));
                                                                        }
                                                                    } else {
                                                                        if (slot.CommandAsConsole) {
                                                                            for (String cmd : slot.Command) {
                                                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd.replace("[player]", player.getName()));
                                                                            }
                                                                        } else {
                                                                            for (String cmd : slot.Command) {
                                                                                player.chat("/" + cmd.replace("[player]", player.getName()));
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }.runTaskLater(plugin, 2L);
                                                        }
                                                        if (slot.OpenGUI_Enable) {
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    player.closeInventory();

                                                                }
                                                            }.runTaskLater(plugin, 1L);
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    GUI_GUI.openGUI(player, Main.guiHashMap.get(slot.OpenGUI));
                                                                }
                                                            }.runTaskLater(plugin, 2L);
                                                        }
                                                        if (slot.Message_Enable) {
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    player.closeInventory();
                                                                }
                                                            }.runTaskLater(plugin, 1L);

                                                            for (String msg : slot.Message) {
                                                                if (Main.PaPi) {
                                                                    player.sendMessage(Replace.replace(player, msg.replace("[prefix]", Main.Prefix)));
                                                                } else
                                                                    player.sendMessage(Replace.replace(msg.replace("[prefix]", Main.Prefix)));
                                                            }
                                                        }
                                                        if (slot.ServerChange) {
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    player.closeInventory();
                                                                }
                                                            }.runTaskLater(plugin, 1L);

                                                            send.player(player, Select_msg.onServerChange.replace("[server]", slot.ServerChangeServer));
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    ServerChange.send(player, slot.ServerChangeServer);
                                                                }
                                                            }.runTaskLater(Main.plugin, 20L);
                                                        }
                                                        if (slot.SetConfigEnable) {
                                                            File config = new File(slot.ConfigFilePath);
                                                            YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                                                            /*if (slot.ConfigChatInput){
                                                                ConfigChat.EditChat.put(player, slot.ConfigOptionPath);
                                                                player.sendMessage(DefaultValue.SettingsGUIchatSet.replace("[setting]", "Shop Name Chest small"));
                                                                player.sendMessage(DefaultValue.SettingsGUIchatCancel);
                                                            } else
                                                            {
                                                             */
                                                            if (e.isLeftClick()){
                                                                if (slot.ConfigOptionPremat.equals("String")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigStringValueLeft);
                                                                } else if (slot.ConfigOptionPremat.equals("Boolean")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigBooleanValueLeft);
                                                                } else if (slot.ConfigOptionPremat.equals("Integer")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigIntegerValueLeft);
                                                                } else if (slot.ConfigOptionPremat.equals("Double")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigDoubleValueLeft);
                                                                } else if (slot.ConfigOptionPremat.equals("List")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigListValueLeft);
                                                                } else {
                                                                    player.sendMessage("§cCheck the Option §6SetConfig/Option/Premat"); //todo
                                                                }
                                                            }
                                                            if (e.isRightClick()){
                                                                if (slot.ConfigOptionPremat.equals("String")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigStringValueRight);
                                                                } else if (slot.ConfigOptionPremat.equals("Boolean")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigBooleanValueRight);
                                                                } else if (slot.ConfigOptionPremat.equals("Integer")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigIntegerValueRight);
                                                                } else if (slot.ConfigOptionPremat.equals("Double")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigDoubleValueRight);
                                                                } else if (slot.ConfigOptionPremat.equals("List")) {
                                                                    yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigListValueRight);
                                                                } else {
                                                                    player.sendMessage("§cCheck the Option §6SetConfig/Option/Premat"); //todo
                                                                }
                                                            }
                                                            try {
                                                                yamlConfiguration.save(config);
                                                            } catch (IOException tac) {
                                                                tac.printStackTrace();
                                                            }
                                                            if (slot.PluginReloadEnable) {
                                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), slot.PluginReloadCommand);
                                                            }
                                                            new BukkitRunnable() {
                                                                @Override
                                                                public void run() {
                                                                    player.closeInventory();
                                                                }
                                                            }.runTaskLater(plugin, 1L);
                                                        }

                                                        if (Select_config.Sound_Enable && Select_config.Sound_Click_Enable) {
                                                            if (slot.CustomSound_Enable) {
                                                                if (!slot.CustomSound_NoSound) {
                                                                    try {
                                                                        player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);

                                                                    } catch (Exception e1) {
                                                                        send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Main.Prefix)
                                                                                .replace("[sound]", "§6GUI: §e" + Replace.replace(gui.GUI_Name) + "§r §6Slot: §e" + slot.Slot + " §6CustomSound: §9" + slot.CustomSound_Sound));
                                                                        player.playSound(player.getLocation(), Select_config.Sound_Click, 3, 1);
                                                                    }
                                                                }
                                                            } else
                                                                player.playSound(player.getLocation(), Select_config.Sound_Click, 3, 1);
                                                        }

                                                    } else {

                                                        new BukkitRunnable() {
                                                            @Override
                                                            public void run() {
                                                                player.closeInventory();
                                                            }
                                                        }.runTaskLater(plugin, 1L);

                                                        player.sendMessage(Select_msg.No_money);
                                                        if (Select_config.Sound_NoMoney_Enable && Select_config.Sound_Enable) {
                                                            player.playSound(player.getLocation(), Select_config.Sound_NoMoney, 3, 1);
                                                        }
                                                    }
                                                }
                                            } else {
                                                if (slot.Command_Enable) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            player.closeInventory();
                                                        }
                                                    }.runTaskLater(plugin, 1L);

                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            if (slot.Command_BungeeCommand) {
                                                                if (Select_config.Bungee) {
                                                                    for (String cmd : slot.Command) {
                                                                        BCommand_Sender_Reciver.sendToBungee(player.getName(), cmd.replace("[player]", player.getName()));
                                                                    }
                                                                } else {
                                                                    send.console(Main.Prefix + " §4To use bungee commands, enable the Bungee option in the config.");
                                                                    send.player(player, Main.Prefix + " §4To use bungee commands, enable the Bungee option in the config.");
                                                                }

                                                            } else {
                                                                if (slot.CommandAsConsole) {
                                                                    for (String cmd : slot.Command) {
                                                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd.replace("[player]", player.getName()));
                                                                    }
                                                                } else {
                                                                    for (String cmd : slot.Command) {
                                                                        player.chat("/" + cmd.replace("[player]", player.getName()));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }.runTaskLater(plugin, 2L);
                                                }
                                                if (slot.OpenGUI_Enable) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            player.closeInventory();
                                                        }
                                                    }.runTaskLater(plugin, 1L);
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {

                                                            GUI_GUI.openGUI(player, Main.guiHashMap.get(slot.OpenGUI));
                                                        }
                                                    }.runTaskLater(plugin, 2L);
                                                }
                                                if (slot.Message_Enable) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            player.closeInventory();
                                                        }
                                                    }.runTaskLater(plugin, 1L);


                                                    for (String msg : slot.Message) {
                                                        if (Main.PaPi) {
                                                            player.sendMessage(Replace.replace(player, msg.replace("[prefix]", Main.Prefix)));
                                                        } else
                                                            player.sendMessage(Replace.replace(msg.replace("[prefix]", Main.Prefix)));
                                                    }
                                                }
                                                if (slot.ServerChange) {
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            player.closeInventory();
                                                        }
                                                    }.runTaskLater(plugin, 1L);

                                                    send.player(player, Select_msg.onServerChange.replace("[server]", slot.ServerChangeServer));


                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            ServerChange.send(player, slot.ServerChangeServer);
                                                        }
                                                    }.runTaskLater(Main.plugin, 20L);
                                                }
                                                if (slot.SetConfigEnable) {
                                                    File config = new File(slot.ConfigFilePath);
                                                    YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
                                                            /*if (slot.ConfigChatInput){
                                                                ConfigChat.EditChat.put(player, slot.ConfigOptionPath);
                                                                player.sendMessage(DefaultValue.SettingsGUIchatSet.replace("[setting]", "Shop Name Chest small"));
                                                                player.sendMessage(DefaultValue.SettingsGUIchatCancel);
                                                            } else
                                                            {
                                                             */
                                                    if (e.isLeftClick()){
                                                        if (slot.ConfigOptionPremat.equals("String")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigStringValueLeft);
                                                        } else if (slot.ConfigOptionPremat.equals("Boolean")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigBooleanValueLeft);
                                                        } else if (slot.ConfigOptionPremat.equals("Integer")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigIntegerValueLeft);
                                                        } else if (slot.ConfigOptionPremat.equals("Double")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigDoubleValueLeft);
                                                        } else if (slot.ConfigOptionPremat.equals("List")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigListValueLeft);
                                                        } else {
                                                            player.sendMessage("§cCheck the Option §6SetConfig/Option/Premat"); //todo
                                                        }
                                                    }
                                                    if (e.isRightClick()){
                                                        if (slot.ConfigOptionPremat.equals("String")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigStringValueRight);
                                                        } else if (slot.ConfigOptionPremat.equals("Boolean")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigBooleanValueRight);
                                                        } else if (slot.ConfigOptionPremat.equals("Integer")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigIntegerValueRight);
                                                        } else if (slot.ConfigOptionPremat.equals("Double")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigDoubleValueRight);
                                                        } else if (slot.ConfigOptionPremat.equals("List")) {
                                                            yamlConfiguration.set(slot.ConfigOptionPath.replace("/", "."), slot.ConfigListValueRight);
                                                        } else {
                                                            player.sendMessage("§cCheck the Option §6SetConfig/Option/Premat"); //todo
                                                        }
                                                    }
                                                    try {
                                                        yamlConfiguration.save(config);
                                                    } catch (IOException tac) {
                                                        tac.printStackTrace();
                                                    }
                                                    if (slot.PluginReloadEnable) {
                                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), slot.PluginReloadCommand);
                                                    }
                                                    new BukkitRunnable() {
                                                        @Override
                                                        public void run() {
                                                            player.closeInventory();
                                                        }
                                                    }.runTaskLater(plugin, 1L);
                                                }
                                                if (Select_config.Sound_Enable && Select_config.Sound_Click_Enable) {
                                                    if (slot.CustomSound_Enable) {
                                                        if (!slot.CustomSound_NoSound) {
                                                            try {
                                                                player.playSound(player.getLocation(), Sound.valueOf(slot.CustomSound_Sound.toUpperCase().replace(".", "_")), 3, 1);

                                                            } catch (Exception e1) {
                                                                send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Main.Prefix)
                                                                        .replace("[sound]", "§6GUI: §e" + Replace.replace(gui.GUI_Name) + "§r §6Slot: §e" + slot.Slot + " §6CustomSound: §9" + slot.CustomSound_Sound));
                                                                player.playSound(player.getLocation(), Select_config.Sound_Click, 3, 1);
                                                            }
                                                        }
                                                    } else
                                                        player.playSound(player.getLocation(), Select_config.Sound_Click, 3, 1);
                                                }
                                            }
                                        }
                                    }
                                }
                            } else {
                                player.sendMessage(Select_msg.NoPermissionForItem.replace("[item]", Replace.replace(slot.Name))
                                        .replace("[perm]", "commandgui.gui." + gui.Command_Command + ".slot." + (slot.Slot + 1)));
                            }
                        }
                    }
                }
            }
        }
    }
}


