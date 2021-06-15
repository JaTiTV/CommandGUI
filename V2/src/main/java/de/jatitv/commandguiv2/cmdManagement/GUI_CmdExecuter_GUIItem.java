package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.system.Database;
import de.jatitv.commandguiv2.system.GUI_Give_UseItem;
import de.jatitv.commandguiv2.system.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GUI_CmdExecuter_GUIItem implements CommandExecutor, TabCompleter {
    String Prefix;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        Player player = (Player) sender;
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            if (args.length == 0) { //ToDo
                player.sendMessage("§7----§6GUI§2Item§7-§cHelp§7----");
                player.sendMessage("§8'§9/gui on§8' §eActivate the GUIItem");
                player.sendMessage("§8'§9/gui off§8' §eDeactivate the GUIItem");
                player.sendMessage("§7------------------");
            } else {
                if (args.length == 1) {
                    if (sender instanceof Player) {
                        if (Select_config.UseItem_AllowToggle) {
                            switch (args[0].toLowerCase()) {
                                case "on":
                                    for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
                                        ItemStack itm = player.getInventory().getItem(iam);
                                        if (itm != null) {
                                            if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                                                if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                                                    player.getInventory().remove(itm);
                                                    player.updateInventory();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    if (player.getInventory().getItem(Select_config.UseItem_InventorySlot - 1) == null) {
                                        Database.query("INSERT INTO `gui-item` (`UUID`, `Name`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                                                + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '1';");
                                        GUI_Give_UseItem.onGive(player.getName());
                                    } else {
                                        boolean empty = false;
                                        for (int i = 0; i < 9; i++) {
                                            if (player.getInventory().getItem(i) == null) {
                                                empty = true;
                                                break;
                                            }
                                        }
                                        if (empty) {
                                            Database.query("INSERT INTO `gui-item` (`UUID`, `Name`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                                                    + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '1';");
                                            GUI_Give_UseItem.onGiveADD(player.getName());
                                        } else sender.sendMessage(Select_msg.NoInventorySpace);
                                    }
                                    break;
                                case "off":
                                    Database.query("INSERT INTO `gui-item` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                                            + "', '0') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '0';");
                                    for (int iam = 0; iam < player.getInventory().getSize() - 5; iam++) {
                                        ItemStack itm = player.getInventory().getItem(iam);
                                        if (itm != null) {
                                            if (itm.getType() == Material.valueOf(Select_config.UseItem_Material) || itm.getType() == Main.Head) {
                                                if (itm.getItemMeta().getDisplayName().equals(Select_config.UseItem_Name)) {
                                                    player.getInventory().remove(itm);
                                                    player.updateInventory();
                                                }
                                            }
                                        }
                                    }
                                    break;
                            }
                        }
                    } else sender.sendMessage(Select_msg.OnlyForPlayer);
                }
            }
        }
        return false;
    }


    //TabCompleter
    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("on", "commandgui.useitem.toggle");
        put("off", "commandgui.useitem.toggle");
    }};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (sender instanceof Player) {
            if (Select_config.UseItem_AllowToggle) {
                Player p = (Player) sender;
                if (args.length == 1) {
                    for (String command : arg1.keySet()) {
                        Boolean passend = true;
                        for (int i = 0; i < args[0].length(); i++) {
                            if (args[0].length() >= command.length()) {
                                passend = false;
                            } else {
                                if (args[0].charAt(i) != command.charAt(i)) {
                                    passend = false;
                                }
                            }
                        }
                        if (hasPermission(p, arg1.get(command)) && passend) {
                            list.add(command);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static boolean hasPermission(Player player, String permission) {
        if (player.isOp()) {
            return true;
        }
        String[] Permissions = permission.split(";");
        for (String perm : Permissions) {
            if (player.hasPermission(perm)) {
                return true;
            }
        }
        return false;
    }

}

