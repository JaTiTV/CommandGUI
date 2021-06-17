package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GUI_CmdExecuter implements CommandExecutor, TabCompleter {
    String Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Prefix = Main.Prefix;
        if (sender.hasPermission("bupa.admin") || sender.isOp()) {
            if (args.length == 0) {
                sender.sendMessage("§4Use: §7/bupa-gui reload");
            } else {
                switch (args[0].toLowerCase()) {
                    case "reload":
                    case "rl":
                        if (sender instanceof Player) sender.sendMessage(Prefix + Select_msg.ReloadStart);
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§6Plugin reload...");
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");

                        Select_config.onSelect();
                        GUI_Obj_Select.onSelect();
                        Select_msg.onSelect(Prefix);

                        if (sender instanceof Player) sender.sendMessage(Prefix + Select_msg.ReloadEnd);
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Plugin successfully reloaded.");
                        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
                        break;
                }
            }
        } else sender.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/bupa-gui").replace("[perm]", "bupa.admin"));
        return false;
    }


    //TabCompleter
    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("reload", "bupa.admin");
        put("rl", "bupa.admin");
    }};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String s, String[] args) {
        List<String> list = new ArrayList<>();
        if (sender instanceof Player) {
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
            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                if (sender.hasPermission("bupa.gui.giveitem") || sender.hasPermission("bupa.admin")) {
                    Iterator var6 = Bukkit.getOnlinePlayers().iterator();

                    while (var6.hasNext()) {
                        Player player1 = (Player) var6.next();
                        list.add(player1.getName());
                    }
                }
                return list;
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

