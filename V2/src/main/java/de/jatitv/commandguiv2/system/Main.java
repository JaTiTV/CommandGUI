package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.languages.LanguagesCreate;
import de.jatitv.commandguiv2.select.Select_config;
import de.jatitv.commandguiv2.select.Select_msg;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
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
        Bukkit.getConsoleSender().sendMessage(Prefix + "§8-------------------------------");
        if (!new File(getDataFolder(), "config.yml").exists()){
            saveResource("config.yml", false);
            saveResource("GUIs/default.yml", false);
        }
        Select_config.onSelect();


        LanguagesCreate.langCreate(Version);
        Select_msg.onSelect();
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
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§2");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4Plugin successfully disabled.");
        Bukkit.getConsoleSender().sendMessage(Main.Prefix + "§4-----------------------------------------------------------------------------------");
    }

    public static String replace(String Text) {
        return Text.replace("[prefix]", Prefix).replace("&", "§").replace("[ue]", "ü")
                .replace("[UE]", "Ü").replace("[oe]", "Ö").replace("[OE]", "Ö")
                .replace("[ae]", "ä").replace("[AE]", "Ä");
    }
}
