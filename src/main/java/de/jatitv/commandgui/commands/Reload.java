// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.config.*;
import de.jatitv.commandgui.config.GUI_1;
import de.jatitv.commandgui.config.GUI_2;
import de.jatitv.commandgui.config.GUI_3;
import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.system.Main;
import de.jatitv.commandgui.system.Vault;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload {

    public static void reload(CommandSender sender) throws InterruptedException {
        if (sender instanceof Player) {
            sender.sendMessage(DefultValue.PrefixHC + DefultValue.ReloadStart);
        }

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§6Plugin reload...");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");

        Config.configCreate();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        GUI_1.configCreate();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        GUI_2.configCreate();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        GUI_3.configCreate();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        Messages.messagesCreate();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        Vault.loadVault();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");

        if (Main.PaPi){
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2PlaceholderAPI successfully connected!");
        }else{
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4PlaceholderAPI could not be connected / found!");
        }

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        if (sender instanceof Player) {
            sender.sendMessage(DefultValue.PrefixHC + DefultValue.ReloadEnd);
        }
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Plugin successfully reloaded.");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
    }
}
