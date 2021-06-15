package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Objekte.GUI_Obj_Select;
import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter_GUI;
import de.jatitv.commandguiv2.gui.GUI_Listener;
import de.jatitv.commandguiv2.languages.LanguagesCreate;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import de.jatitv.commandguiv2.select.Select_mysql;
import me.clip.placeholderapi.PlaceholderAPI;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    public static File getPath() {
        return getPlugin().getDataFolder();
    }
    public static Main getPlugin() {
        return plugin;
    }
    public static Plugin thisp() {
        return plugin;
    }

    public static String Prefix = "§8[§4C§9GUI§8]";

    public static String Version;

    public static List<String> Autor;
    public static String Spigot = "https://www.spigotmc.org/resources/commandgui-cgui.90671/";
    public static String Discord = "https://discord.gg/vRyXFFterJ";

    public static Main plugin;
    public static Plugin a;
    public static Economy eco = null;
    public static String update_version = null;
    public static Boolean PaPi = false;

    public static Material Head;

    public static boolean minecraft1_8;
    public static boolean minecraft1_9;
    public static boolean minecraft1_10;
    public static boolean minecraft1_11;
    public static boolean minecraft1_12;
    public static boolean minecraft1_13;
    public static boolean minecraft1_14;
    public static boolean minecraft1_15;
    public static boolean minecraft1_16;
    public static boolean minecraft1_17;
    public static HashMap<String, GUI_Objekt> guiHashMap = new HashMap<>();



    @Override
    public void onEnable() {
        // Plugin startup logic
        // Plugin startup logic
        Logger logger = this.getLogger();
        plugin = this;
        Autor = thisp().getDescription().getAuthors();
        Version = thisp().getDescription().getVersion();
        a = this;
        minecraft1_8 = Bukkit.getServer().getClass().getPackage().getName().contains("1_8");
        minecraft1_9 = Bukkit.getServer().getClass().getPackage().getName().contains("1_9");
        minecraft1_10 = Bukkit.getServer().getClass().getPackage().getName().contains("1_10");
        minecraft1_11 = Bukkit.getServer().getClass().getPackage().getName().contains("1_11");
        minecraft1_12 = Bukkit.getServer().getClass().getPackage().getName().contains("1_12");
        minecraft1_13 = Bukkit.getServer().getClass().getPackage().getName().contains("1_13");
        minecraft1_14 = Bukkit.getServer().getClass().getPackage().getName().contains("1_14");
        minecraft1_15 = Bukkit.getServer().getClass().getPackage().getName().contains("1_15");
        minecraft1_16 = Bukkit.getServer().getClass().getPackage().getName().contains("1_16");
        minecraft1_17 = Bukkit.getServer().getClass().getPackage().getName().contains("1_17");

        if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            Head = Material.valueOf("SKULL");
        } else Head = Material.valueOf("PLAYER_HEAD");

            if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            PaPi = true;
        }
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2-----------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4  _____ §9_____ _    _ _____");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4 / ____§9/ ____| |  | |_   _|");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4| |   §9| |  __| |  | | | |");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4| |   §9| | |_ | |  | | | |");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4| |___§9| |__| | |__| |_| |_");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2  §4 \\_____§9\\_____|\\____/|_____|");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Autor: §6" + Autor);
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Version: §6" + Version);
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Spigot: §6" + Spigot);
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Discord: §6" + Discord);
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§4Plugin load...");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
        if (Main.PaPi) {
            Bukkit.getConsoleSender().sendMessage(Prefix + "§2PlaceholderAPI successfully connected!");
        } else {
            Bukkit.getConsoleSender().sendMessage(Prefix + "§4PlaceholderAPI could not be connected / found!");
        }
        try {
            Vault.loadVault();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
        if (!new File(getDataFolder(), "config.yml").exists()){
            saveResource("config.yml", false);
            saveResource("GUIs/default.yml", false);
        }
        if (!new File(getDataFolder(), "mysql.yml").exists()){
            saveResource("mysql.yml", false);
        }
        Select_config.onSelect();
        Select_mysql.onSelect();
        GUI_Obj_Select.onSelect();

        plugin.getCommand("commandgui").setExecutor(new GUI_CmdExecuter_GUI());
        plugin.getCommand("commandguiadmin").setExecutor(new GUI_CmdExecuter());

        LanguagesCreate.langCreate(Version);
        Select_msg.onSelect();

        GUI_RegisterPermissions.onPermRegister();

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Listener(), getPlugin());
        Bukkit.getServer().getPluginManager().registerEvents(new GUI_UseItem_Listener(), getPlugin());


        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
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
            Database.query("CREATE TABLE IF NOT EXISTS `gui-onlineplayer` (" +
                    "    `UUID` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                    "    `Name` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                    "    `Status` TINYTEXT NOT NULL COLLATE 'utf8mb4_general_ci'," +
                    "    UNIQUE INDEX `UUID` (`UUID`)" +
                    ")" +
                    "COLLATE='utf8mb4_general_ci'" +
                    "ENGINE=InnoDB" +
                    ";");
        } else {
            Bukkit.getConsoleSender().sendMessage("§6Storage medium §2YML §6is used.");
        }
        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(Prefix + "§2-----------------------------------------------------------------------------------");


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4----------------------------- §8[§4Command§9GUI§8] §4-----------------------------");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4Autor: §6JaTiTV");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4Version: §6" + Version);
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4Plugin successfully disabled.");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4------------------------------------------------------------------------");
    }

    public static String replace(String Text) {
        return Text.replace("[prefix]", Prefix).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
    public static String replace(Player player, String Text) {
        return  PlaceholderAPI.setPlaceholders(player, Text.replace("[prefix]", Prefix).replace("&", "§")
                .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä"));
    }
    public static List<String> replace(List<String> Text) {
        List<String> output = new ArrayList<>();
        for(String input : Text) {
            output.add(input.replace("[prefix]", Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä"));
        }
        return output;
    }
    public static List<String> replace(Player player, List<String> Text) {
        List<String> output = new ArrayList();
        if (player == null) {
            return Arrays.asList("player is null");
        }
        if (Text == null) {
            return Arrays.asList("Text is null");
        }
        for(String input : Text) {
            output.add(PlaceholderAPI.setPlaceholders(player, input.replace("[prefix]", Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")));
        }
        return output;
    }
    public static List replacePrice(List<String> Text, String price) {
        List rp = new ArrayList();
        for (String s : Text) {
            rp.add(s.replace("[prefix]", Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")
                    .replace("[price]", String.valueOf(price)));
        }
        return rp;
    }
    public static List replacePrice(Player player, List<String> Text, String price) {
        List rp = new ArrayList();
        for (String s : Text) {
            rp.add(PlaceholderAPI.setPlaceholders(player, s.replace("[prefix]", Prefix).replace("&", "§")
                    .replace("[ue]", "ü").replace("[UE]", "Ü").replace("[oe]", "Ö")
                    .replace("[OE]", "Ö").replace("[ae]", "ä").replace("[AE]", "Ä")
                    .replace("[price]", String.valueOf(price))));
        }
        return rp;
    }
}
