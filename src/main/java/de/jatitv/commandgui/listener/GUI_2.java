// This claas was created by JaTiTV


package de.jatitv.commandgui.listener;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.system.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
public class GUI_2 implements Listener {

    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (DefaultValue_GUI_2.GiveUseItemOnFirstJoin) {
            if (!p.hasPlayedBefore()) {
                if (!DefaultValue_GUI_2.GiveUseItemOnFirstJoin_Permission_Enable || p.hasPermission(DefaultValue_GUI_2.GiveUseItemOnFirstJoin_Permission)
                        || p.hasPermission("commandgui.admin") || p.isOp()) {
                    ItemStack item = new ItemStack(Material.valueOf(DefaultValue_GUI_2.UseItem_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefaultValue_GUI_2.UseItem_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName));
                    itemMeta.setLore(DefaultValue_GUI_2.UseItem_Lore);
                    item.setItemMeta(itemMeta);
                    item.setAmount(1);
                    p.getInventory().addItem(item);
                }
            }
        }
    }


    @EventHandler
    public void onInteractWB1(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (!DefaultValue_GUI_2.Permission_Enable || p.hasPermission(DefaultValue_GUI_2.Permission)
                || p.hasPermission("commandgui.admin") || p.isOp()) {
            if (e.getItem() != null && p.getItemInHand().getType() == Material.valueOf(DefaultValue_GUI_2.UseItem_Item)) {
                if (e.getItem().getItemMeta().getDisplayName().equals(DefaultValue_GUI_2.UseItem_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                        && e.getItem().getType() == Material.valueOf(DefaultValue_GUI_2.UseItem_Item)) {
                    de.jatitv.commandgui.commands.GUI_2.openCGUI(e.getPlayer());
                }
            }
        } else {
            e.setCancelled(true);
            p.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.UseItem_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                    .replace("[perm]", DefaultValue_GUI_2.Permission));
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (player.getOpenInventory().getTitle().equals(de.jatitv.commandgui.commands.GUI_2.GUI_NAME)
                    || player.getOpenInventory().getTitle().equals(PlaceholderAPI.setPlaceholders(player, de.jatitv.commandgui.commands.GUI_2.GUI_NAME))) {
                e.setCancelled(true);
                if (DefaultValue_GUI_2.L1_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L1_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S1_Price)) {
                                    if (DefaultValue_GUI_2.L1_S1_Command_Enable || DefaultValue_GUI_2.L1_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S1_Command);

                                        }
                                        if (DefaultValue_GUI_2.L1_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L1_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S2_Price)) {
                                    if (DefaultValue_GUI_2.L1_S2_Command_Enable || DefaultValue_GUI_2.L1_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L1_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S3_Price)) {
                                    if (DefaultValue_GUI_2.L1_S3_Command_Enable || DefaultValue_GUI_2.L1_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L1_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S4_Price)) {
                                    if (DefaultValue_GUI_2.L1_S4_Command_Enable || DefaultValue_GUI_2.L1_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S4_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S4_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S4_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L1_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S5_Price)) {
                                    if (DefaultValue_GUI_2.L1_S5_Command_Enable || DefaultValue_GUI_2.L1_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L1_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S6_Price)) {
                                    if (DefaultValue_GUI_2.L1_S6_Command_Enable || DefaultValue_GUI_2.L1_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L1_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S7_Price)) {
                                    if (DefaultValue_GUI_2.L1_S7_Command_Enable || DefaultValue_GUI_2.L1_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L1_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S8_Price)) {
                                    if (DefaultValue_GUI_2.L1_S8_Command_Enable || DefaultValue_GUI_2.L1_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S8_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S8_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S8_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L1_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L1_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L1_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L1_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L1_S9_Price)) {
                                    if (DefaultValue_GUI_2.L1_S9_Command_Enable || DefaultValue_GUI_2.L1_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L1_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L1_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L1_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L1_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L1_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L1_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L1_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L1_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L1_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L1_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L1_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L1_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L1_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L1_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L1_S9_Permission));
                        }
                    }
                }


                if (DefaultValue_GUI_2.L2_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L2_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S1_Price)) {
                                    if (DefaultValue_GUI_2.L2_S1_Command_Enable || DefaultValue_GUI_2.L2_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }

                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S1_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L2_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S2_Price)) {
                                    if (DefaultValue_GUI_2.L2_S2_Command_Enable || DefaultValue_GUI_2.L2_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L2_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S3_Price)) {
                                    if (DefaultValue_GUI_2.L2_S3_Command_Enable || DefaultValue_GUI_2.L2_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L2_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S4_Price)) {
                                    if (DefaultValue_GUI_2.L2_S4_Command_Enable || DefaultValue_GUI_2.L2_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S4_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S4_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S4_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L2_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S5_Price)) {
                                    if (DefaultValue_GUI_2.L2_S5_Command_Enable || DefaultValue_GUI_2.L2_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L2_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S6_Price)) {
                                    if (DefaultValue_GUI_2.L2_S6_Command_Enable || DefaultValue_GUI_2.L2_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S6_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S6_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S6_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L2_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S7_Price)) {
                                    if (DefaultValue_GUI_2.L2_S7_Command_Enable || DefaultValue_GUI_2.L2_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L2_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S8_Price)) {
                                    if (DefaultValue_GUI_2.L2_S8_Command_Enable || DefaultValue_GUI_2.L2_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S8_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S8_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S8_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L2_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L2_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L2_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L2_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L2_S9_Price)) {
                                    if (DefaultValue_GUI_2.L2_S9_Command_Enable || DefaultValue_GUI_2.L2_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L2_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L2_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L2_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L2_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L2_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L2_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L2_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L2_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L2_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L2_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L2_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L2_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L2_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L2_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L2_S9_Permission));
                        }
                    }
                }


                if (DefaultValue_GUI_2.L3_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L3_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S1_Price)) {
                                    if (DefaultValue_GUI_2.L3_S1_Command_Enable || DefaultValue_GUI_2.L3_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }

                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S1_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L3_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S2_Price)) {
                                    if (DefaultValue_GUI_2.L3_S2_Command_Enable || DefaultValue_GUI_2.L3_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L3_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S3_Price)) {
                                    if (DefaultValue_GUI_2.L3_S3_Command_Enable || DefaultValue_GUI_2.L3_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L3_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S4_Price)) {
                                    if (DefaultValue_GUI_2.L3_S4_Command_Enable || DefaultValue_GUI_2.L3_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S4_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S4_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S4_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L3_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S5_Price)) {
                                    if (DefaultValue_GUI_2.L3_S5_Command_Enable || DefaultValue_GUI_2.L3_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L3_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S6_Price)) {
                                    if (DefaultValue_GUI_2.L3_S6_Command_Enable || DefaultValue_GUI_2.L3_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S6_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S6_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S6_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L3_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S7_Price)) {
                                    if (DefaultValue_GUI_2.L3_S7_Command_Enable || DefaultValue_GUI_2.L3_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L3_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S8_Price)) {
                                    if (DefaultValue_GUI_2.L3_S8_Command_Enable || DefaultValue_GUI_2.L3_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S8_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S8_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S8_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L3_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L3_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L3_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L3_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L3_S9_Price)) {
                                    if (DefaultValue_GUI_2.L3_S9_Command_Enable || DefaultValue_GUI_2.L3_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L3_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L3_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L3_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L3_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L3_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L3_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L3_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L3_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L3_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L3_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L3_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L3_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L3_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L3_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L3_S9_Permission));
                        }
                    }
                }


                if (DefaultValue_GUI_2.L4_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L4_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S1_Price)) {
                                    if (DefaultValue_GUI_2.L4_S1_Command_Enable || DefaultValue_GUI_2.L4_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }

                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S1_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L4_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S2_Price)) {
                                    if (DefaultValue_GUI_2.L4_S2_Command_Enable || DefaultValue_GUI_2.L4_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L4_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S3_Price)) {
                                    if (DefaultValue_GUI_2.L4_S3_Command_Enable || DefaultValue_GUI_2.L4_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L4_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S4_Price)) {
                                    if (DefaultValue_GUI_2.L4_S4_Command_Enable || DefaultValue_GUI_2.L4_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S4_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S4_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S4_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L4_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S5_Price)) {
                                    if (DefaultValue_GUI_2.L4_S5_Command_Enable || DefaultValue_GUI_2.L4_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L4_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S6_Price)) {
                                    if (DefaultValue_GUI_2.L4_S6_Command_Enable || DefaultValue_GUI_2.L4_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S6_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S6_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S6_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L4_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S7_Price)) {
                                    if (DefaultValue_GUI_2.L4_S7_Command_Enable || DefaultValue_GUI_2.L4_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L4_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S8_Price)) {
                                    if (DefaultValue_GUI_2.L4_S8_Command_Enable || DefaultValue_GUI_2.L4_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S8_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S8_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S8_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L4_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L4_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L4_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L4_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L4_S9_Price)) {
                                    if (DefaultValue_GUI_2.L4_S9_Command_Enable || DefaultValue_GUI_2.L4_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L4_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L4_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L4_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L4_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L4_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L4_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L4_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L4_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L4_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L4_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L4_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L4_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L4_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L4_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L4_S9_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L5_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S1_Price)) {
                                    if (DefaultValue_GUI_2.L5_S1_Command_Enable || DefaultValue_GUI_2.L5_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }

                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S1_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L5_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S2_Price)) {
                                    if (DefaultValue_GUI_2.L5_S2_Command_Enable || DefaultValue_GUI_2.L5_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L5_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S3_Price)) {
                                    if (DefaultValue_GUI_2.L5_S3_Command_Enable || DefaultValue_GUI_2.L5_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L5_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S4_Price)) {
                                    if (DefaultValue_GUI_2.L5_S4_Command_Enable || DefaultValue_GUI_2.L5_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L5_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S5_Price)) {
                                    if (DefaultValue_GUI_2.L5_S5_Command_Enable || DefaultValue_GUI_2.L5_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L5_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S6_Price)) {
                                    if (DefaultValue_GUI_2.L5_S6_Command_Enable || DefaultValue_GUI_2.L5_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S6_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S6_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S6_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L5_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S7_Price)) {
                                    if (DefaultValue_GUI_2.L5_S7_Command_Enable || DefaultValue_GUI_2.L5_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L5_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S8_Price)) {
                                    if (DefaultValue_GUI_2.L5_S8_Command_Enable || DefaultValue_GUI_2.L5_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S8_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S8_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S8_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L5_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L5_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L5_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L5_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L5_S9_Price)) {
                                    if (DefaultValue_GUI_2.L5_S9_Command_Enable || DefaultValue_GUI_2.L5_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L5_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L5_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L5_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L5_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L5_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L5_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L5_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L5_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L5_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L5_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L5_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L5_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L5_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L5_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L5_S9_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefaultValue_GUI_2.L6_S1_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S1_Price)) {
                                    if (DefaultValue_GUI_2.L6_S1_Command_Enable || DefaultValue_GUI_2.L6_S1_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S1_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S1_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S1_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }

                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S1_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S1_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S1_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S1_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S1_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S1_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S1_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S1_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S1_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S1_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S1_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S1_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefaultValue_GUI_2.L6_S2_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S2_Price)) {
                                    if (DefaultValue_GUI_2.L6_S2_Command_Enable || DefaultValue_GUI_2.L6_S2_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S2_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S2_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S2_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S2_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S2_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S2_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S2_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S2_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S2_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S2_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S2_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S2_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S2_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S2_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S2_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefaultValue_GUI_2.L6_S3_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S3_Price)) {
                                    if (DefaultValue_GUI_2.L6_S3_Command_Enable || DefaultValue_GUI_2.L6_S3_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S3_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S3_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S3_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S3_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S3_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S3_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S3_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S3_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S3_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S3_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S3_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S3_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S3_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S3_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S3_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefaultValue_GUI_2.L6_S4_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S4_Price)) {
                                    if (DefaultValue_GUI_2.L6_S4_Command_Enable || DefaultValue_GUI_2.L6_S4_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S4_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S4_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S4_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S4_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S4_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S4_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S4_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S4_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S4_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S4_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S4_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S4_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S4_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S4_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S4_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefaultValue_GUI_2.L6_S5_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S5_Price)) {
                                    if (DefaultValue_GUI_2.L6_S5_Command_Enable || DefaultValue_GUI_2.L6_S5_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S5_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S5_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S5_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S5_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S5_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S5_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S5_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S5_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S5_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S5_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S5_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S5_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S5_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S5_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S5_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefaultValue_GUI_2.L6_S6_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S6_Price)) {
                                    if (DefaultValue_GUI_2.L6_S6_Command_Enable || DefaultValue_GUI_2.L6_S6_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S6_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S6_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S6_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S6_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S6_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S6_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S6_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S6_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S6_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S6_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S6_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S6_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S6_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S6_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S6_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefaultValue_GUI_2.L6_S7_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S7_Price)) {
                                    if (DefaultValue_GUI_2.L6_S7_Command_Enable || DefaultValue_GUI_2.L6_S7_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S7_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S7_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S7_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S7_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S7_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S7_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S7_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S7_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S7_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S7_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S7_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S7_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefaultValue_GUI_2.L6_S8_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S8_Price)) {
                                    if (DefaultValue_GUI_2.L6_S8_Command_Enable || DefaultValue_GUI_2.L6_S8_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S8_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S8_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S8_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S7_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S7_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S7_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S8_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S8_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S8_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S8_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S8_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S8_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S8_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S8_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S8_Permission));
                        }
                    }
                }

                if (DefaultValue_GUI_2.L6_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefaultValue_GUI_2.L6_S9_Permission_Enable || player.hasPermission(DefaultValue_GUI_2.L6_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefaultValue_GUI_2.L6_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_2.buy(player, DefaultValue_GUI_2.L6_S9_Price)) {
                                    if (DefaultValue_GUI_2.L6_S9_Command_Enable || DefaultValue_GUI_2.L6_S9_Message_Enable) {
                                        player.sendMessage(DefaultValue.Buy_msg.replace("[itemname]", DefaultValue_GUI_2.L6_S9_Name)
                                                .replace("[price]", DefaultValue_GUI_2.L6_S9_Price + " " + DefaultValue.Currency));
                                        if (DefaultValue_GUI_2.L6_S9_Command_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            if (DefaultValue_GUI_2.L6_S9_CommandAsConsole){
                                                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S9_Command.replace("[player]", player.getName()));
                                            } else player.performCommand(DefaultValue_GUI_2.L6_S9_Command);
                                        }
                                        if (DefaultValue_GUI_2.L6_S9_Message_Enable) {
                                            if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                                player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                            }
                                            player.closeInventory();
                                            for (String s : DefaultValue_GUI_2.L6_S9_Message) {
                                                if (Main.PaPi) {
                                                    player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                                } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                            }
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefaultValue.No_money);
                                    if (DefaultValue.Sound_NoMoney_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefaultValue_GUI_2.L6_S9_Command_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    if (DefaultValue_GUI_2.L6_S9_CommandAsConsole){
                                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), DefaultValue_GUI_2.L6_S9_Command.replace("[player]", player.getName()));
                                    } else player.performCommand(DefaultValue_GUI_2.L6_S9_Command);
                                }
                                if (DefaultValue_GUI_2.L6_S9_Message_Enable) {
                                    if (DefaultValue.Sound_Click_Enable && DefaultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefaultValue.Sound_Click, 3, 1);
                                    }
                                    player.closeInventory();
                                    for (String s : DefaultValue_GUI_2.L6_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefaultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefaultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefaultValue.NoPermissionForItem.replace("[item]", DefaultValue_GUI_2.L6_S9_Name.replace("[guiname]", DefaultValue_GUI_2.GUIName))
                                    .replace("[perm]", DefaultValue_GUI_2.L6_S9_Permission));
                        }
                    }
                }
            }
        }
    }
}
