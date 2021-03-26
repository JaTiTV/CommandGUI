// This claas was created by JaTiTV


package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.defultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultVaalue_GUI_2;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_3;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TabCompleteNEW implements TabCompleter {

    private static HashMap<String, String> arg1 = new HashMap<String, String>() {{
        put("help", "commandgui.admin;commandgui.command.info;commandgui.command.gui1;commandgui.command.gui2;commandgui.command.gui3;commandgui.command");
        put("info", "commandgui.admin;commandgui.command.info");
        put("give", "commandgui.admin;commandgui.command.give");
        if (!DefaultValue_GUI_1.Command_Permission_Enable || !DefultVaalue_GUI_2.Command_Permission_Enable || !DefaultValue_GUI_3.Command_Permission_Enable){
            put("open", null);
        } else put("open", "commandgui.admin;commandgui.command.gui1;commandgui.command.gui2;commandgui.command.gui3");

        put("reload", "commandgui.admin");
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

            if (args.length == 2 && args[0].equalsIgnoreCase("open")) {
                if (!DefaultValue_GUI_1.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefaultValue_GUI_1.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefaultValue_GUI_1.Command);
                    }
                }
                if (!DefultVaalue_GUI_2.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefultVaalue_GUI_2.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefultVaalue_GUI_2.Command);
                    }
                }

                if (!DefaultValue_GUI_3.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui3") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefaultValue_GUI_3.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefaultValue_GUI_3.Command);
                    }
                }
            }


            if (args.length == 2) {
                switch (args[0]) {
                    case "give":
                        if (hasPermission(p, arg1.get("give"))) {
                            for (Player player : Bukkit.getOnlinePlayers()) {
                                Boolean passend = true;
                                for (int i = 0; i < args[1].length(); i++) {
                                    if (args[1].length() >= player.getName().length()) {
                                        passend = false;
                                    } else {
                                        if (args[1].charAt(i) != player.getName().charAt(i)) {
                                            passend = false;
                                        }
                                    }
                                }
                                if (hasPermission(p, arg1.get(player)) && passend) {
                                    list.add(player.getName());
                                }
                            }
                        }
                        break;
                }
            }
            if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                if (args[2].isEmpty()) {
                    if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        if (DefaultValue_GUI_1.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                            list.add(DefaultValue_GUI_1.Command);
                        }
                        if (DefultVaalue_GUI_2.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                            list.add(DefultVaalue_GUI_2.Command);
                        }
                        if (DefaultValue_GUI_3.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                            list.add(DefaultValue_GUI_3.Command);
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
