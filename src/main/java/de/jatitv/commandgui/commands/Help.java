// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_2;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_3;
import org.bukkit.command.CommandSender;

public class Help {

    public static void Help(CommandSender sender) {
        if (sender.hasPermission("commandgui.command")
                || sender.hasPermission("commandgui.command.info")
                || sender.hasPermission("commandgui.admin")
                || sender.isOp()) {
            sender.sendMessage(DefultValue.PrefixHC + " §8----- §6Command§9GUI §chelp §8-----");
            sender.sendMessage(DefultValue.PrefixHC);
            if (sender.hasPermission("commandgui.command") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpHelp);
                if (DefultValue.DefaultGUI == 1) {
                    sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpCgui.replace("[gui]", DefultValue_GUI_1.GUIName));
                } else if (DefultValue.DefaultGUI == 2) {
                    sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpCgui.replace("[gui]", DefultValue_GUI_2.GUIName));
                } else if (DefultValue.DefaultGUI == 3) {
                    sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpCgui.replace("[gui]", DefultValue_GUI_3.GUIName));
                }
            }
            if (sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpInfo);
            }

            if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpGive);

            }
            if (sender.hasPermission("commandgui.command.1") || sender.hasPermission("commandgui.admin") || sender.isOp()){
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpGUI.replace("[gui]", " 1").replace("[guiname]", DefultValue_GUI_1.GUIName));
            }
            if (sender.hasPermission("commandgui.command.2") || sender.hasPermission("commandgui.admin") || sender.isOp()){
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpGUI.replace("[gui]", " 2").replace("[guiname]", DefultValue_GUI_2.GUIName));
            }
            if (sender.hasPermission("commandgui.command.3") || sender.hasPermission("commandgui.admin") || sender.isOp()){
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpGUI.replace("[gui]", " 3").replace("[guiname]", DefultValue_GUI_3.GUIName));
            }

            if (sender.hasPermission("wonderbagshop.admin") || sender.isOp()) {
                sender.sendMessage(DefultValue.PrefixHC + " " + DefultValue.HelpReload);
            }
            sender.sendMessage(DefultValue.PrefixHC);
            sender.sendMessage(DefultValue.PrefixHC + " §8----------------------------");
        } else {
            sender.sendMessage(DefultValue.NoPermission);
        }
    }
}
