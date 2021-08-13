package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Listener.GUI_Listener;
import de.jatitv.commandguiv2.Spigot.Listener.JoinEvent;
import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_1_10bis1_15;
import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_1_8bis1_9;
import de.jatitv.commandguiv2.Spigot.Listener.UseItem_Listener.UseItem_ab1_16;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.Spigot.cmdManagement.GUI_CmdExecuter_Admin;
import de.jatitv.commandguiv2.Spigot.cmdManagement.GUI_CmdExecuter_GUI;
import de.jatitv.commandguiv2.Spigot.cmdManagement.GUI_CmdExecuter_GUIItem;
import de.jatitv.commandguiv2.Spigot.cmdManagement.GUI_CmdExecuter_Help;
import de.jatitv.commandguiv2.Spigot.cmdManagement.register.*;
import de.jatitv.commandguiv2.Spigot.system.config.ConfigCreate;
import de.jatitv.commandguiv2.Spigot.system.config.DefaultGUICreate;
import de.jatitv.commandguiv2.Spigot.system.config.languages.LanguagesCreate;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_config;
import de.jatitv.commandguiv2.Spigot.system.config.select.Select_msg;
import de.jatitv.commandguiv2.Spigot.system.database.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.*;
import java.util.List;

public class Load {
    static Plugin plugin = Main.plugin;

    public static void onLoad(String Prefix, List Autor, String Version, String Spigot, String Discord) {
        Long long_ = Long.valueOf(System.currentTimeMillis());
        send.console(Main.Prefix + "§4============================= §8[§4Command§9GUI§8] §4=============================");
        send.console(Prefix + "§4   _____ §9_____ _    _ _____ §e   ___  ");
        send.console(Prefix + "§4  / ____§9/ ____| |  | |_   _|§e  |__ \\ ");
        send.console(Prefix + "§4 | |   §9| |  __| |  | | | |§e_   __ ) |");
        send.console(Prefix + "§4 | |   §9| | |_ | |  | | | §e\\ \\ / // / ");
        send.console(Prefix + "§4 | |___§9| |__| | |__| |_| |§e\\ V // /_ ");
        send.console(Prefix + "§4  \\_____§9\\_____|\\____/|_____§e\\_/|____|");
        send.console(Prefix);
        send.console(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", ""));
        send.console(Prefix + " §2Version: §6" + Version);
        send.console(Prefix + " §2Spigot: §6" + Spigot);
        send.console(Prefix + " §2Discord: §6" + Discord);
        try {
            Debug.debugmsg();
        } catch (Exception e) {
            e.printStackTrace();
        }

        send.console(Prefix + " §8-------------------------------");


        if (!new File(Main.getPath(), "config.yml").exists()) {
            try {
                DefaultGUICreate.configCreate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            ConfigCreate.configCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Select_config.onSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Select_config.Bungee) {
            Bukkit.getMessenger().registerOutgoingPluginChannel(Main.plugin, "commandgui:bungee");
        }

        try {
            LanguagesCreate.langCreate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            GUI_Obj_Select.onSelect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Select_msg.onSelect(Prefix);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Select_config.sound(Main.Prefix);
        } catch (Exception e) {
            e.printStackTrace();
        }

        send.console(Prefix + " §8-------------------------------");
        if (Select_config.Storage.equals("MYSQL")) {
            MySQL.main();
            try {
                MySQL.query("CREATE TABLE IF NOT EXISTS `gui-item` (" +
                        "    `UUID` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Status` INT(1) NOT NULL DEFAULT '1'," +
                        "    `Slot` INT(1) NULL DEFAULT NULL," +
                        "    UNIQUE INDEX `UUID` (`UUID`)" +
                        ")" +
                        "COLLATE='utf8mb4_general_ci'" +
                        "ENGINE=InnoDB" +
                        ";");
                MySQL.query("ALTER TABLE `gui-item` ADD COLUMN IF NOT EXISTS `Slot` INT(1) NULL DEFAULT NULL AFTER `Status`;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (Select_config.Bungee) {
                MySQL.query("CREATE TABLE IF NOT EXISTS `gui-onlineplayer` (" +
                        "    `UUID` VARCHAR(191) NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Status` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    UNIQUE INDEX `UUID` (`UUID`)" +
                        ")" +
                        "COLLATE='utf8mb4_general_ci'" +
                        "ENGINE=InnoDB" +
                        ";");
            }

        } else {
            if (Select_config.Debug) send.console(Prefix + " §6Storage medium §2YML §6is used.");
        }
        if (Main.PaPi) {
            send.console(Prefix + " §2PlaceholderAPI successfully connected!");
        } else {
            send.console(Prefix + " §4PlaceholderAPI could not be connected / found!");
        }
        try {
            Vault.loadVault();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            GUI_RegisterPermissions.onPermRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.plugin.getCommand("commandguiadmin").setExecutor(new GUI_CmdExecuter_Admin());
        send.debug(plugin, "Commandregister: commandguiadmin");
        if (Select_config.HelpAlias) {
            Main.plugin.getCommand("commandguihelp").setExecutor(new GUI_CmdExecuter_Help());
            send.debug(plugin, "Commandregister: commandguihelp");
        }
        Main.plugin.getCommand("commandgui").setExecutor(new GUI_CmdExecuter_GUI());
        send.debug(plugin, "Commandregister: commandgui");
        Main.plugin.getCommand("commandgui-item").setExecutor(new GUI_CmdExecuter_GUIItem());
        send.debug(plugin, "Commandregister: commandgui-item");

        try {
            AliasRegister.onRegister();
        } catch (Exception e) {
            e.printStackTrace();
        }


        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Listener(), plugin);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinEvent(), plugin);

        if (Main.minecraft1_8 || Main.minecraft1_9) {
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_8bis1_9(), Main.plugin);
        } else if (Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12 || Main.minecraft1_13 || Main.minecraft1_14 || Main.minecraft1_15) {
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_10bis1_15(), plugin);
        } else Bukkit.getServer().getPluginManager().registerEvents(new UseItem_ab1_16(), plugin);

        if (!Select_config.DisableUpdateChecker) {
            UpdateChecker.onUpdateCheck();
        } else send.console(Main.Prefix + " §4UpdateCheck is disabled!");
        Metrics.Bstats();
        Main.addonLoad();
        send.console(Prefix + " §8-------------------------------");
        send.console(Prefix + " §2Plugin loaded successfully." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");

        send.console(Main.Prefix + "§4========================================================================");

    }

}
