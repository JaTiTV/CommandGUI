package de.jatitv.commandguiv2.cmdManagement;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.system.Replace;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.command.CommandSender;

public class Help {
    public static void sendHelp(CommandSender sender, String Prefix) {
        send.Sender(sender, Prefix + " §8----- §4Command§9GUI §chelp §8-----");
        if (sender.hasPermission("commandgui.command")) {
            GUI_Objekt gui = Main.guiHashMap.get(Select_config.DefaultGUI);
            send.Sender(sender, Prefix + " " + Select_msg.HelpCgui.replace("[gui]", Replace.replace(gui.GUI_Name)));
            for (String alias : Main.allAliases) {
                if (Main.guiHashMap.get(alias).GUI_Enable || sender.hasPermission("commandgui.bypass")) {
                    send.Sender(sender, Prefix + " " + Select_msg.HelpOpen.replace("[gui]", alias).replace("[guiname]", Replace.replace(Main.guiHashMap.get(alias).GUI_Name)));
                }
            }
            send.Sender(sender, Prefix + " " + Select_msg.HelpHelp);
        }
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            send.Sender(sender, Prefix + " " + Select_msg.GUIItemHelp_on);
            send.Sender(sender, Prefix + " " + Select_msg.GUIItemHelp_off);
        }
        if (sender.hasPermission("commandgui.command.info")) {
            send.Sender(sender, Prefix + " " + Select_msg.HelpInfo);
        }
        if (sender.hasPermission("commandgui.command.give")) {
            send.Sender(sender, Prefix + " " + Select_msg.HelpGive);
        }
        if (sender.hasPermission("commandgui.admin")) {
            send.Sender(sender, Prefix + " " + Select_msg.HelpCreateDefaultGUI);
            send.Sender(sender, Prefix + " " + Select_msg.HelpReload);
        }
        send.Sender(sender, Prefix + " §8-------------------------");
    }

    public static void sendGUIItemHelp(CommandSender sender, String Prefix) {
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            send.Sender(sender, Prefix + " §8------ §4Command§9GUI§2Item §chelp §8------");
            send.Sender(sender, Prefix + " " + Select_msg.GUIItemHelp_on);
            send.Sender(sender, Prefix + " " + Select_msg.GUIItemHelp_off);
            send.Sender(sender, Prefix + " §8------------------------------");
        }

    }
}
