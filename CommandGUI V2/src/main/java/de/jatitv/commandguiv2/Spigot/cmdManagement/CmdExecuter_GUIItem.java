package de.jatitv.commandguiv2.Spigot.cmdManagement;

import de.jatitv.commandguiv2.Spigot.system.config.languages.SelectMessages;
import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CmdExecuter_GUIItem implements CommandExecutor, TabCompleter {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        Player player = (Player) sender;
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            if (args.length == 0) {
                Help.sendGUIItemHelp(sender, Prefix);
            } else {
                if (args.length == 1 || args.length == 2) {
                    if (sender instanceof Player) {
                        if (SelectConfig.UseItem_AllowToggle) {
                            switch (args[0].toLowerCase()) {
                                case "on":
                                    Commands.itemOn(player);
                                    break;
                                case "off":
                                    Commands.itemOff(player);
                                    break;
                                case "slot":
                                    if (args.length == 2) {
                                        try {
                                            Commands.onSetSlot(player, Integer.valueOf(args[1]));
                                        } catch (Exception e5) {
                                            send.player(player, SelectMessages.ItemSlot_wrongValue);
                                        }

                                    } else send.player(player, "§4Use: §7/gui-item slot [slot]");

                                    break;
                                default:
                                    Help.sendHelp(player, Prefix);

                            }
                        }
                    } else sender.sendMessage(SelectMessages.OnlyForPlayer);
                }
            }
        } else sender.sendMessage(SelectMessages.NoPermissionForCommand.replace("[cmd]", "/commandgui-item").replace("[perm]", "commandgui.useitem.toggle"));
        return false;
    }


    //TabCompleter
    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("on", "commandgui.useitem.toggle");
        put("off", "commandgui.useitem.toggle");
        if (SelectConfig.UseItem_AllowSetSlot) {
            put("slot", "commandgui.useitem.toggle");
        }
    }};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (sender instanceof Player) {
            if (SelectConfig.UseItem_AllowToggle) {
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

