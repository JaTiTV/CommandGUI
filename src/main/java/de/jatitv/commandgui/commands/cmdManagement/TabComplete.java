// This claas was created by JaTiTV


package de.jatitv.commandgui.commands.cmdManagement;

import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_2;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_3;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String lable, String[] args) {
        if (sender instanceof Player) {
            List<String> list = new ArrayList<>();
            if (args.length == 0 || args.length == 1) {
                if (args[0].isEmpty()) {

                    if (sender.hasPermission("commandgui.command")
                            || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.command.gui3")
                            || sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("help");
                    }
                    if (sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("info");
                    }
                    if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("give");
                    }
                    if (!DefultValue_GUI_1.Command_Permission_Enable || !DefultValue_GUI_2.Command_Permission_Enable || !DefultValue_GUI_2.Command_Permission_Enable
                            || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.command.gui3")
                            || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("open");
                    }
                    if (sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("reload");
                    }
                    return list;
                }
                if (args[0].charAt(0) == 'h') {
                    if (sender.hasPermission("commandgui.command")
                            || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.command.gui3")
                            || sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("help");
                    }

                } else if (args[0].charAt(0) == 'i') {
                    if (sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("info");
                    }

                } else if (args[0].charAt(0) == 'o') {
                    if (!DefultValue_GUI_1.Command_Permission_Enable || !DefultValue_GUI_2.Command_Permission_Enable || !DefultValue_GUI_2.Command_Permission_Enable
                            || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.command.gui3")
                            || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("open");
                    }

                } else if (args[0].charAt(0) == 'g') {
                    if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("give");
                    }

                } else if (args[0].charAt(0) == 'r') {
                    if (sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add("reload");
                    }
                }
                return list;
            }
            if (args.length == 2 && args[0].equalsIgnoreCase("open")) {
                if (!DefultValue_GUI_1.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefultValue_GUI_1.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefultValue_GUI_1.Command);
                    }
                }
                if (!DefultValue_GUI_2.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefultValue_GUI_2.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefultValue_GUI_2.Command);
                    }
                }

                if (!DefultValue_GUI_3.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui3") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    if (DefultValue_GUI_3.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                        list.add(DefultValue_GUI_3.Command);
                    }
                }
                return list;
            }
            if (args.length == 2 && args[0].equalsIgnoreCase("give")) {
                Iterator var6 = Bukkit.getOnlinePlayers().iterator();

                while (var6.hasNext()) {
                    Player player1 = (Player) var6.next();
                    list.add(player1.getName());
                }
                return list;

            } else {
                if (args.length == 3 && args[0].equalsIgnoreCase("give")) {
                    if (args[2].isEmpty()) {
                        if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                            list.add(DefultValue_GUI_1.Command);
                        }
                        return list;
                    }
                    return list;
                }
            }
        }
        return new ArrayList();
    }
}
