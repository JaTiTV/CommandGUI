package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.languages.LanguagesCreate;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_mysql;
import org.bukkit.Bukkit;

import java.io.File;
import java.util.List;

public class Load {
    public static void onLoad(String Prefix, List Autor, String Version, String Spigot, String Discord){
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2-----------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4  _____ §9_____ _    _ _____");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4 / ____§9/ ____| |  | |_   _|");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4| |   §9| |  __| |  | | | |");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4| |   §9| | |_ | |  | | | |");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4| |___§9| |__| | |__| |_| |_");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2  §4 \\_____§9\\_____|\\____/|_____|");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Autor: §6" + Autor);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Version: §6" + Version);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Spigot: §6" + Spigot);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Discord: §6" + Discord);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §4Plugin load...");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");

        if (!new File(Main.getPlugin().getDataFolder(), "config.yml").exists()){
            Main.getPlugin().saveResource("config.yml", false);
            Main.getPlugin().saveResource("GUIs/default.yml", false);
        }
        if (!new File(Main.getPlugin().getDataFolder(), "mysql.yml").exists()){
            Main.getPlugin().saveResource("mysql.yml", false);
        }
        Select_config.onSelect();
        Select_mysql.onSelect();
        GUI_Obj_Select.onSelect();

        LanguagesCreate.langCreate(Version);
        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");
        Select_msg.onSelect();

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
            Bukkit.getConsoleSender().sendMessage(" §6Storage medium §2YML §6is used.");
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
        Bukkit.getConsoleSender().sendMessage(Prefix + " §8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(Prefix + " §2-----------------------------------------------------------------------------------");
    }
}
