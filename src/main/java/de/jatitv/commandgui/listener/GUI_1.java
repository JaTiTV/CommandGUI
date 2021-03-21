// This claas was created by JaTiTV


package de.jatitv.commandgui.listener;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.system.Main;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GUI_1 implements Listener {


    @EventHandler
    public void onFirstJoin(PlayerLoginEvent e) {
        Player p = e.getPlayer();
        if (DefultValue_GUI_1.GiveUseItemOnFirstJoin) {
            if (!p.hasPlayedBefore()) {
                if (!DefultValue_GUI_1.GiveUseItemOnFirstJoin_Permission_Enable || p.hasPermission(DefultValue_GUI_1.GiveUseItemOnFirstJoin_Permission)
                        || p.hasPermission("commandgui.admin") || p.isOp()) {
                    ItemStack item = new ItemStack(Material.valueOf(DefultValue_GUI_1.UseItem_Item));
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(DefultValue_GUI_1.UseItem_Name.replace("[guiname]", DefultValue_GUI_1.GUIName));
                    itemMeta.setLore(DefultValue_GUI_1.UseItem_Lore);
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
        if (!DefultValue_GUI_1.Permission_Enable || p.hasPermission(DefultValue_GUI_1.Permission)
                || p.hasPermission("commandgui.admin") || p.isOp()) {
            if (e.getItem() != null && p.getItemInHand().getType() != Material.AIR) {
                if (e.getItem().getItemMeta().getDisplayName().equals(DefultValue_GUI_1.UseItem_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                        && e.getItem().getType() == Material.valueOf(DefultValue_GUI_1.UseItem_Item)) {
                    de.jatitv.commandgui.commands.GUI_1.openCGUI(e.getPlayer());
                }
            }
        } else {
            e.setCancelled(true);
            p.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.UseItem_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                    .replace("[perm]", DefultValue_GUI_1.Permission));
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {


        if (!(e.getWhoClicked() instanceof Player)) return;
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory() != null && e.getCurrentItem() != null) {
            if (e.getWhoClicked().getOpenInventory().getTitle().equals("§6§8§9§r" + DefultValue_GUI_1.GUIName)
                    || e.getWhoClicked().getOpenInventory().getTitle().equals(PlaceholderAPI.setPlaceholders(player, "§6§8§9§r" + DefultValue_GUI_1.GUIName))) {
                e.setCancelled(true);

                if (DefultValue_GUI_1.L1_S1_Enable) {
                    if (e.getSlot() == 0) {
                        if (!DefultValue_GUI_1.L1_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S1_Price)) {
                                    if (DefultValue_GUI_1.L1_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S1_Command);
                                }
                                if (DefultValue_GUI_1.L1_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S2_Enable) {
                    if (e.getSlot() == 1) {
                        if (!DefultValue_GUI_1.L1_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S2_Price)) {
                                    if (DefultValue_GUI_1.L1_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S2_Command);
                                }
                                if (DefultValue_GUI_1.L1_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S3_Enable) {
                    if (e.getSlot() == 2) {
                        if (!DefultValue_GUI_1.L1_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S3_Price)) {
                                    if (DefultValue_GUI_1.L1_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S3_Command);
                                }
                                if (DefultValue_GUI_1.L1_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S4_Enable) {
                    if (e.getSlot() == 3) {
                        if (!DefultValue_GUI_1.L1_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S4_Price)) {
                                    if (DefultValue_GUI_1.L1_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S4_Command);
                                }
                                if (DefultValue_GUI_1.L1_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S5_Enable) {
                    if (e.getSlot() == 4) {
                        if (!DefultValue_GUI_1.L1_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S5_Price)) {
                                    if (DefultValue_GUI_1.L1_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S5_Command);
                                }
                                if (DefultValue_GUI_1.L1_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S6_Enable) {
                    if (e.getSlot() == 5) {
                        if (!DefultValue_GUI_1.L1_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S6_Price)) {
                                    if (DefultValue_GUI_1.L1_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S6_Command);
                                }
                                if (DefultValue_GUI_1.L1_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S7_Enable) {
                    if (e.getSlot() == 6) {
                        if (!DefultValue_GUI_1.L1_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S7_Price)) {
                                    if (DefultValue_GUI_1.L1_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S7_Command);
                                }
                                if (DefultValue_GUI_1.L1_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S8_Enable) {
                    if (e.getSlot() == 7) {
                        if (!DefultValue_GUI_1.L1_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S8_Price)) {
                                    if (DefultValue_GUI_1.L1_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S8_Command);
                                }
                                if (DefultValue_GUI_1.L1_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L1_S9_Enable) {
                    if (e.getSlot() == 8) {
                        if (!DefultValue_GUI_1.L1_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L1_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L1_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L1_S9_Price)) {
                                    if (DefultValue_GUI_1.L1_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L1_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L1_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L1_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L1_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L1_S9_Command);
                                }
                                if (DefultValue_GUI_1.L1_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L1_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L1_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L1_S9_Permission));
                        }
                    }
                }


                if (DefultValue_GUI_1.L2_S1_Enable) {
                    if (e.getSlot() == 9) {
                        if (!DefultValue_GUI_1.L2_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S1_Price)) {
                                    if (DefultValue_GUI_1.L2_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S1_Command);
                                }
                                if (DefultValue_GUI_1.L2_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S2_Enable) {
                    if (e.getSlot() == 10) {
                        if (!DefultValue_GUI_1.L2_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S2_Price)) {
                                    if (DefultValue_GUI_1.L2_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S2_Command);
                                }
                                if (DefultValue_GUI_1.L2_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S3_Enable) {
                    if (e.getSlot() == 11) {
                        if (!DefultValue_GUI_1.L2_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S3_Price)) {
                                    if (DefultValue_GUI_1.L2_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S3_Command);
                                }
                                if (DefultValue_GUI_1.L2_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S4_Enable) {
                    if (e.getSlot() == 12) {
                        if (!DefultValue_GUI_1.L2_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S4_Price)) {
                                    if (DefultValue_GUI_1.L2_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S4_Command);
                                }
                                if (DefultValue_GUI_1.L2_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S5_Enable) {
                    if (e.getSlot() == 13) {
                        if (!DefultValue_GUI_1.L2_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S5_Price)) {
                                    if (DefultValue_GUI_1.L2_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S5_Command);
                                }
                                if (DefultValue_GUI_1.L2_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S6_Enable) {
                    if (e.getSlot() == 14) {
                        if (!DefultValue_GUI_1.L2_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S6_Price)) {
                                    if (DefultValue_GUI_1.L2_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S6_Command);
                                }
                                if (DefultValue_GUI_1.L2_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S7_Enable) {
                    if (e.getSlot() == 15) {
                        if (!DefultValue_GUI_1.L2_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S7_Price)) {
                                    if (DefultValue_GUI_1.L2_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S7_Command);
                                }
                                if (DefultValue_GUI_1.L2_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S8_Enable) {
                    if (e.getSlot() == 16) {
                        if (!DefultValue_GUI_1.L2_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S8_Price)) {
                                    if (DefultValue_GUI_1.L2_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S8_Command);
                                }
                                if (DefultValue_GUI_1.L2_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L2_S9_Enable) {
                    if (e.getSlot() == 17) {
                        if (!DefultValue_GUI_1.L2_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L2_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L2_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L2_S9_Price)) {
                                    if (DefultValue_GUI_1.L2_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L2_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L2_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L2_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L2_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L2_S9_Command);
                                }
                                if (DefultValue_GUI_1.L2_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L2_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L2_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L2_S9_Permission));
                        }
                    }
                }


                if (DefultValue_GUI_1.L3_S1_Enable) {
                    if (e.getSlot() == 18) {
                        if (!DefultValue_GUI_1.L3_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S1_Price)) {
                                    if (DefultValue_GUI_1.L3_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S1_Command);
                                }
                                if (DefultValue_GUI_1.L3_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S2_Enable) {
                    if (e.getSlot() == 19) {
                        if (!DefultValue_GUI_1.L3_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S2_Price)) {
                                    if (DefultValue_GUI_1.L3_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S2_Command);
                                }
                                if (DefultValue_GUI_1.L3_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S3_Enable) {
                    if (e.getSlot() == 20) {
                        if (!DefultValue_GUI_1.L3_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S3_Price)) {
                                    if (DefultValue_GUI_1.L3_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S3_Command);
                                }
                                if (DefultValue_GUI_1.L3_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S4_Enable) {
                    if (e.getSlot() == 21) {
                        if (!DefultValue_GUI_1.L3_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S4_Price)) {
                                    if (DefultValue_GUI_1.L3_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S4_Command);
                                }
                                if (DefultValue_GUI_1.L3_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S5_Enable) {
                    if (e.getSlot() == 22) {
                        if (!DefultValue_GUI_1.L3_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S5_Price)) {
                                    if (DefultValue_GUI_1.L3_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S5_Command);
                                }
                                if (DefultValue_GUI_1.L3_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S6_Enable) {
                    if (e.getSlot() == 23) {
                        if (!DefultValue_GUI_1.L3_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S6_Price)) {
                                    if (DefultValue_GUI_1.L3_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S6_Command);
                                }
                                if (DefultValue_GUI_1.L3_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S7_Enable) {
                    if (e.getSlot() == 24) {
                        if (!DefultValue_GUI_1.L3_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S7_Price)) {
                                    if (DefultValue_GUI_1.L3_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S7_Command);
                                }
                                if (DefultValue_GUI_1.L3_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S8_Enable) {
                    if (e.getSlot() == 25) {
                        if (!DefultValue_GUI_1.L3_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S8_Price)) {
                                    if (DefultValue_GUI_1.L3_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S8_Command);
                                }
                                if (DefultValue_GUI_1.L3_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L3_S9_Enable) {
                    if (e.getSlot() == 26) {
                        if (!DefultValue_GUI_1.L3_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L3_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L3_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L3_S9_Price)) {
                                    if (DefultValue_GUI_1.L3_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L3_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L3_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L3_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L3_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L3_S9_Command);
                                }
                                if (DefultValue_GUI_1.L3_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L3_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L3_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L3_S9_Permission));
                        }
                    }
                }


                if (DefultValue_GUI_1.L4_S1_Enable) {
                    if (e.getSlot() == 27) {
                        if (!DefultValue_GUI_1.L4_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S1_Price)) {
                                    if (DefultValue_GUI_1.L4_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S1_Command);
                                }
                                if (DefultValue_GUI_1.L4_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S2_Enable) {
                    if (e.getSlot() == 28) {
                        if (!DefultValue_GUI_1.L4_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S2_Price)) {
                                    if (DefultValue_GUI_1.L4_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S2_Command);
                                }
                                if (DefultValue_GUI_1.L4_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S3_Enable) {
                    if (e.getSlot() == 29) {
                        if (!DefultValue_GUI_1.L4_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S3_Price)) {
                                    if (DefultValue_GUI_1.L4_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S3_Command);
                                }
                                if (DefultValue_GUI_1.L4_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S4_Enable) {
                    if (e.getSlot() == 30) {
                        if (!DefultValue_GUI_1.L4_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S4_Price)) {
                                    if (DefultValue_GUI_1.L4_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S4_Command);
                                }
                                if (DefultValue_GUI_1.L4_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S5_Enable) {
                    if (e.getSlot() == 31) {
                        if (!DefultValue_GUI_1.L4_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S5_Price)) {
                                    if (DefultValue_GUI_1.L4_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S5_Command);
                                }
                                if (DefultValue_GUI_1.L4_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S6_Enable) {
                    if (e.getSlot() == 32) {
                        if (!DefultValue_GUI_1.L4_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S6_Price)) {
                                    if (DefultValue_GUI_1.L4_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S6_Command);
                                }
                                if (DefultValue_GUI_1.L4_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S7_Enable) {
                    if (e.getSlot() == 33) {
                        if (!DefultValue_GUI_1.L4_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S7_Price)) {
                                    if (DefultValue_GUI_1.L4_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S7_Command);
                                }
                                if (DefultValue_GUI_1.L4_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S8_Enable) {
                    if (e.getSlot() == 34) {
                        if (!DefultValue_GUI_1.L4_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S8_Price)) {
                                    if (DefultValue_GUI_1.L4_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S8_Command);
                                }
                                if (DefultValue_GUI_1.L4_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L4_S9_Enable) {
                    if (e.getSlot() == 35) {
                        if (!DefultValue_GUI_1.L4_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L4_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L4_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L4_S9_Price)) {
                                    if (DefultValue_GUI_1.L4_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L4_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L4_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L4_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L4_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L4_S9_Command);
                                }
                                if (DefultValue_GUI_1.L4_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L4_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L4_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L4_S9_Permission));
                        }
                    }
                }


                if (DefultValue_GUI_1.L5_S1_Enable) {
                    if (e.getSlot() == 36) {
                        if (!DefultValue_GUI_1.L5_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S1_Price)) {
                                    if (DefultValue_GUI_1.L5_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S1_Command);
                                }
                                if (DefultValue_GUI_1.L5_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S2_Enable) {
                    if (e.getSlot() == 37) {
                        if (!DefultValue_GUI_1.L5_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S2_Price)) {
                                    if (DefultValue_GUI_1.L5_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S2_Command);
                                }
                                if (DefultValue_GUI_1.L5_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S3_Enable) {
                    if (e.getSlot() == 38) {
                        if (!DefultValue_GUI_1.L5_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S3_Price)) {
                                    if (DefultValue_GUI_1.L5_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S3_Command);
                                }
                                if (DefultValue_GUI_1.L5_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S4_Enable) {
                    if (e.getSlot() == 39) {
                        if (!DefultValue_GUI_1.L5_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S4_Price)) {
                                    if (DefultValue_GUI_1.L5_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S4_Command);
                                }
                                if (DefultValue_GUI_1.L5_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S5_Enable) {
                    if (e.getSlot() == 40) {
                        if (!DefultValue_GUI_1.L5_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S5_Price)) {
                                    if (DefultValue_GUI_1.L5_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S5_Command);
                                }
                                if (DefultValue_GUI_1.L5_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S6_Enable) {
                    if (e.getSlot() == 41) {
                        if (!DefultValue_GUI_1.L5_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S6_Price)) {
                                    if (DefultValue_GUI_1.L5_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S6_Command);
                                }
                                if (DefultValue_GUI_1.L5_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S7_Enable) {
                    if (e.getSlot() == 42) {
                        if (!DefultValue_GUI_1.L5_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S7_Price)) {
                                    if (DefultValue_GUI_1.L5_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S7_Command);
                                }
                                if (DefultValue_GUI_1.L5_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S8_Enable) {
                    if (e.getSlot() == 43) {
                        if (!DefultValue_GUI_1.L5_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S8_Price)) {
                                    if (DefultValue_GUI_1.L5_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S8_Command);
                                }
                                if (DefultValue_GUI_1.L5_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L5_S9_Enable) {
                    if (e.getSlot() == 44) {
                        if (!DefultValue_GUI_1.L5_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L5_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L5_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L5_S9_Price)) {
                                    if (DefultValue_GUI_1.L5_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L5_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L5_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L5_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L5_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L5_S9_Command);
                                }
                                if (DefultValue_GUI_1.L5_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L5_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L5_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L5_S9_Permission));
                        }
                    }
                }


                if (DefultValue_GUI_1.L6_S1_Enable) {
                    if (e.getSlot() == 45) {
                        if (!DefultValue_GUI_1.L6_S1_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S1_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S1_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S1_Price)) {
                                    if (DefultValue_GUI_1.L6_S1_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S1_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S1_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S1_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S1_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S1_Command);
                                }
                                if (DefultValue_GUI_1.L6_S1_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S1_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S1_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S1_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S2_Enable) {
                    if (e.getSlot() == 46) {
                        if (!DefultValue_GUI_1.L6_S2_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S2_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S2_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S2_Price)) {
                                    if (DefultValue_GUI_1.L6_S2_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S2_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S2_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S2_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S2_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S2_Command);
                                }
                                if (DefultValue_GUI_1.L6_S2_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S2_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S2_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S2_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S3_Enable) {
                    if (e.getSlot() == 47) {
                        if (!DefultValue_GUI_1.L6_S3_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S3_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S3_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S3_Price)) {
                                    if (DefultValue_GUI_1.L6_S3_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S3_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S3_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S3_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S3_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S3_Command);
                                }
                                if (DefultValue_GUI_1.L6_S3_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S3_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S3_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S3_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S4_Enable) {
                    if (e.getSlot() == 48) {
                        if (!DefultValue_GUI_1.L6_S4_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S4_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S4_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S4_Price)) {
                                    if (DefultValue_GUI_1.L6_S4_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S4_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S4_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S4_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S4_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S4_Command);
                                }
                                if (DefultValue_GUI_1.L6_S4_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S4_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S4_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S4_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S5_Enable) {
                    if (e.getSlot() == 49) {
                        if (!DefultValue_GUI_1.L6_S5_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S5_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S5_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S5_Price)) {
                                    if (DefultValue_GUI_1.L6_S5_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S5_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S5_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S5_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S5_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S5_Command);
                                }
                                if (DefultValue_GUI_1.L6_S5_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S5_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S5_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S5_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S6_Enable) {
                    if (e.getSlot() == 50) {
                        if (!DefultValue_GUI_1.L6_S6_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S6_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S6_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S6_Price)) {
                                    if (DefultValue_GUI_1.L6_S6_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S6_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S6_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S6_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S6_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S6_Command);
                                }
                                if (DefultValue_GUI_1.L6_S6_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S6_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S6_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S6_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S7_Enable) {
                    if (e.getSlot() == 51) {
                        if (!DefultValue_GUI_1.L6_S7_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S7_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S7_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S7_Price)) {
                                    if (DefultValue_GUI_1.L6_S7_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S7_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S7_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S7_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S7_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S7_Command);
                                }
                                if (DefultValue_GUI_1.L6_S7_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S7_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S7_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S7_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S8_Enable) {
                    if (e.getSlot() == 52) {
                        if (!DefultValue_GUI_1.L6_S8_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S8_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S8_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S8_Price)) {
                                    if (DefultValue_GUI_1.L6_S8_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S8_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S8_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S8_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S8_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S8_Command);
                                }
                                if (DefultValue_GUI_1.L6_S8_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S8_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S8_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S8_Permission));
                        }
                    }
                }

                if (DefultValue_GUI_1.L6_S9_Enable) {
                    if (e.getSlot() == 53) {
                        if (!DefultValue_GUI_1.L6_S9_Permission_Enable || player.hasPermission(DefultValue_GUI_1.L6_S9_Permission)
                                || player.hasPermission("commandgui.admin") || player.isOp()) {
                            if (DefultValue_GUI_1.L6_S9_Cost_Enable) {
                                if (de.jatitv.commandgui.commands.GUI_1.buy(player, DefultValue_GUI_1.L6_S9_Price)) {
                                    if (DefultValue_GUI_1.L6_S9_Command_Enable) {
                                        player.closeInventory();
                                        player.chat("/" + DefultValue_GUI_1.L6_S9_Command);
                                    }
                                    if (DefultValue_GUI_1.L6_S9_Message_Enable) {
                                        player.closeInventory();
                                        for (String s : DefultValue_GUI_1.L6_S9_Message) {
                                            if (Main.PaPi) {
                                                player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                            } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                        }
                                    }
                                } else {
                                    player.closeInventory();
                                    player.sendMessage(DefultValue.No_money);
                                    if (DefultValue.Sound_NoMoney_Enable && DefultValue.Sound_Enable) {
                                        player.playSound(player.getLocation(), DefultValue.Sound_NoMoney, 3, 1);
                                    }
                                }
                            } else {
                                if (DefultValue_GUI_1.L6_S9_Command_Enable) {
                                    player.closeInventory();
                                    player.chat("/" + DefultValue_GUI_1.L6_S9_Command);
                                }
                                if (DefultValue_GUI_1.L6_S9_Message_Enable) {
                                    player.closeInventory();
                                    for (String s : DefultValue_GUI_1.L6_S9_Message) {
                                        if (Main.PaPi) {
                                            player.sendMessage(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", DefultValue.Prefix)));
                                        } else player.sendMessage(s.replace("[prefix]", DefultValue.Prefix));
                                    }
                                }
                            }
                        } else {
                            player.sendMessage(DefultValue.NoPermissionForItem.replace("[item]", DefultValue_GUI_1.L6_S9_Name.replace("[guiname]", DefultValue_GUI_1.GUIName))
                                    .replace("[perm]", DefultValue_GUI_1.L6_S9_Permission));
                        }
                    }
                }
            }
        }
    }
}
