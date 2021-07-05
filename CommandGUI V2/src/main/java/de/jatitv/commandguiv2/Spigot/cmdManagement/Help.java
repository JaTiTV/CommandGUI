package de.jatitv.commandguiv2.Spigot.cmdManagement;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Spigot.system.Replace;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_config;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.command.CommandSender;

public class Help {
    public static void sendHelp(CommandSender sender, String Prefix) {
        send.sender(sender, Prefix + " §8----- §4Command§9GUI §chelp §8-----");
        if (sender.hasPermission("commandgui.command")) {
            GUI_Objekt gui = Main.guiHashMap.get(Select_config.DefaultGUI);
            send.sender(sender, Prefix + " " + Select_msg.HelpCgui.replace("[gui]", Replace.replace(gui.GUI_Name)));
            for (String alias : Main.allAliases) {
                if (Main.guiHashMap.get(alias).GUI_Enable || sender.hasPermission("commandgui.bypass")) {
                    send.sender(sender, Prefix + " " + Select_msg.HelpOpen.replace("[gui]", alias).replace("[guiname]", Replace.replace(Main.guiHashMap.get(alias).GUI_Name)));
                }
            }
            send.sender(sender, Prefix + " " + Select_msg.HelpHelp);
        }
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_on);
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_off);
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_Slot);
        }
        if (sender.hasPermission("commandgui.command.info")) {
            send.sender(sender, Prefix + " " + Select_msg.HelpInfo);
        }
        //  if (sender.hasPermission("commandgui.command.give")) {
        //     send.sender(sender, Prefix + " " + Select_msg.HelpGive);
        //  }
        if (sender.hasPermission("commandgui.admin")) {
            send.sender(sender, Prefix + " " + Select_msg.HelpCreateDefaultGUI.replace("[directory]", Main.getPath()+ "\\GUIs\\default.yml"));
            send.sender(sender, Prefix + " " + Select_msg.HelpReload);
        }
        send.sender(sender, Prefix + " §8-------------------------");
    }

    public static void sendGUIItemHelp(CommandSender sender, String Prefix) {
        if (sender.hasPermission("commandgui.useitem.toggle")) {
            send.sender(sender, Prefix + " §8------ §4Command§9GUI§2Item §chelp §8------");
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_on);
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_off);
            send.sender(sender, Prefix + " " + Select_msg.GUIItemHelp_Slot);
            send.sender(sender, Prefix + " §8------------------------------");
        }
    }
}
