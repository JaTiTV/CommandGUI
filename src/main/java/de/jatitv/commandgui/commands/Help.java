// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefaultValue;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defultValue.DefultVaalue_GUI_2;
import de.jatitv.commandgui.defultValue.DefaultValue_GUI_3;
import org.bukkit.command.CommandSender;

public class Help {

    public static void Help(CommandSender sender) {
        if (sender.hasPermission("commandgui.command")
                || sender.hasPermission("commandgui.command.info")
                || sender.hasPermission("commandgui.admin")
                || sender.isOp()) {
            sender.sendMessage(DefaultValue.PrefixHC + " §8----- §6Command§9GUI §chelp §8-----");
            sender.sendMessage(DefaultValue.PrefixHC);
            if (sender.hasPermission("commandgui.command") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                if (DefaultValue.DefaultGUI == 1) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpCgui.replace("[gui]", DefaultValue_GUI_1.GUIName));
                } else if (DefaultValue.DefaultGUI == 2) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpCgui.replace("[gui]", DefultVaalue_GUI_2.GUIName));
                } else if (DefaultValue.DefaultGUI == 3) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpCgui.replace("[gui]", DefaultValue_GUI_3.GUIName));
                }
                sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpHelp);
            }
            if (sender.hasPermission("commandgui.command.info") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpInfo);
            }

            if (sender.hasPermission("commandgui.command.give") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpGive);

            }
            if (!DefaultValue_GUI_1.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui1") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                if (DefaultValue_GUI_1.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpOpen.replace("[gui]", DefaultValue_GUI_1.Command).replace("[guiname]", DefaultValue_GUI_1.GUIName));
                }
            }
            if (!DefultVaalue_GUI_2.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui2") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                if (DefultVaalue_GUI_2.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpOpen.replace("[gui]", DefultVaalue_GUI_2.Command).replace("[guiname]", DefultVaalue_GUI_2.GUIName));
                }
            }
            if (!DefaultValue_GUI_3.Command_Permission_Enable || sender.hasPermission("commandgui.command.gui3") || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                if (DefaultValue_GUI_3.GUI_Enable || sender.hasPermission("commandgui.admin") || sender.isOp()) {
                    sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpOpen.replace("[gui]", DefaultValue_GUI_3.Command).replace("[guiname]", DefaultValue_GUI_3.GUIName));
                }
            }

            if (sender.hasPermission("wonderbagshop.admin") || sender.isOp()) {
                sender.sendMessage(DefaultValue.PrefixHC + " " + DefaultValue.HelpReload);
            }
            sender.sendMessage(DefaultValue.PrefixHC);
            sender.sendMessage(DefaultValue.PrefixHC + " §8----------------------------");
        } else {
            sender.sendMessage(DefaultValue.NoPermission);
        }
    }
}
