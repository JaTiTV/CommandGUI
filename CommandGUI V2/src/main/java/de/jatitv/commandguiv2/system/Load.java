package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Listener.GUI_Listener;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_10bis1_15;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_8bis1_9;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_ab1_16;
import de.jatitv.commandguiv2.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter_GUI;
import de.jatitv.commandguiv2.languages.LanguagesCreate;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_mysql;
import de.jatitv.commandguiv2.select.Select_sound;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.List;

public class Load {
    public static void onLoad(String Prefix, List Autor, String Version, String Spigot, String Discord){
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4============================= §8[§4Command§9GUI§8] §4=============================");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4   _____ §9_____ _    _ _____ §e   ___  ");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4  / ____§9/ ____| |  | |_   _|§e  |__ \\ ");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4 | |   §9| |  __| |  | | | |§e_   __ ) |");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4 | |   §9| | |_ | |  | | | §e\\ \\ / // / ");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4 | |___§9| |__| | |__| |_| |§e\\ V // /_ ");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4  \\_____§9\\_____|\\____/|_____§e\\_/|____|");
        Bukkit.getConsoleSender().sendMessage(Prefix);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", "") );
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Version: §6" + Version);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Spigot: §6" + Spigot);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Discord: §6" + Discord);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");

        if (!new File(Main.getPlugin().getDataFolder(), "config.yml").exists()){
            Main.getPlugin().saveResource("config.yml", false);
            Main.getPlugin().saveResource("GUIs/default.yml", false);
        }
        if (!new File(Main.getPlugin().getDataFolder(), "mysql.yml").exists()){
            Main.getPlugin().saveResource("mysql.yml", false);
        }
        Select_config.onSelect();
        Select_sound.onCreate(Prefix);
        Select_mysql.onSelect();
        GUI_Obj_Select.onSelect();

        LanguagesCreate.langCreate(Version);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");
        Select_msg.onSelect(Prefix);

        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");
        if (Select_config.Storage.equals("MySQL")){
            Database.main();
            Database.query("CREATE TABLE IF NOT EXISTS `gui-item` (" +
                    "    `UUID` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                    "    `Name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                    "    `Status` INT(11) NOT NULL DEFAULT '1'," +
                    "    UNIQUE INDEX `UUID` (`UUID`)" +
                    ")" +
                    "COLLATE='utf8mb4_general_ci'" +
                    "ENGINE=InnoDB" +
                    ";");
            if (Select_config.Bungee){
                Database.query("CREATE TABLE IF NOT EXISTS `gui-onlineplayer` (" +
                        "    `UUID` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    `Status` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                        "    UNIQUE INDEX `UUID` (`UUID`)" +
                        ")" +
                        "COLLATE='utf8mb4_general_ci'" +
                        "ENGINE=InnoDB" +
                        ";");
            }

        } else {
            Bukkit.getConsoleSender().sendMessage(Prefix + " §6Storage medium §2YML §6is used.");
        }
        if (Main.PaPi) {
            Bukkit.getConsoleSender().sendMessage(Prefix + " §2PlaceholderAPI successfully connected!");
        } else {
            Bukkit.getConsoleSender().sendMessage(Prefix + " §4PlaceholderAPI could not be connected / found!");
        }
        try {
            Vault.loadVault();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        GUI_RegisterPermissions.onPermRegister();

        Main.getPlugin().getCommand("commandgui").setExecutor(new GUI_CmdExecuter_GUI());
        Main.getPlugin().getCommand("commandguiadmin").setExecutor(new GUI_CmdExecuter());

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Listener(), Main.getPlugin());

        if (Main.minecraft1_8 || Main.minecraft1_9){
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_8bis1_9(), Main.getPlugin());
        } else if (Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12 || Main.minecraft1_13 || Main.minecraft1_14 || Main.minecraft1_15){
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_10bis1_15(), Main.getPlugin());
        } else Bukkit.getServer().getPluginManager().registerEvents(new UseItem_ab1_16(), Main.getPlugin());

        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4========================================================================");    }
}
