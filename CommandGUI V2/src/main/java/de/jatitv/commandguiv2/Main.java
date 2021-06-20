package de.jatitv.commandguiv2;

import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.system.Load;
import de.jatitv.commandguiv2.system.send;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
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
    public static Integer SpigotID = 90671;
    public static Integer BstatsID = 10840;
    public static String Spigot = "https://www.spigotmc.org/resources/" + SpigotID;
    public static String Discord = "https://discord.gg/vRyXFFterJ";

    public static Main plugin;
    public static List Plugins;
    public static Plugin a;
    public static Economy eco = null;

    public static String update_version = null;
    public static Boolean PaPi = false;

    public static Material Head;

    public static String MCver;
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
    public static ArrayList<String> allAliases = new ArrayList<>();




    @Override
    public void onEnable() {
        Plugins = Arrays.asList(getServer().getPluginManager().getPlugins());
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
        MCver = Bukkit.getServer().getVersion();

        if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            Head = Material.valueOf("SKULL");
        } else Head = Material.valueOf("PLAYER_HEAD");

        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) PaPi = true;

        Load.onLoad(Prefix, Autor, Version, Spigot, Discord);

        /*
        plugin.getLogger().log(Level.WARNING, "§4Test1");
        plugin.getLogger().log(Level.ALL, "Test2");
        plugin.getLogger().log(Level.CONFIG, "Test3");
        plugin.getLogger().log(Level.SEVERE, "Test4");

         */
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        send.console(Main.Prefix + "§4============================= §8[§4Command§9GUI§8] §4=============================");
        send.console(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", "") );
        send.console(Prefix + " §2Version: §6" + Version);
        send.console(Prefix + " §2Spigot: §6" + Spigot);
        send.console(Prefix + " §2Discord: §6" + Discord);
        send.console(Main.Prefix + " §4Plugin successfully disabled.");
        send.console(Main.Prefix + "§4========================================================================");
    }
}
