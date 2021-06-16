package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_10bis1_15;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_1_8bis1_9;
import de.jatitv.commandguiv2.Listener.UseItem_Listener.UseItem_ab1_16;
import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter;
import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter_GUI;
import de.jatitv.commandguiv2.Listener.GUI_Listener;
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

            Load.onLoad(Prefix, Autor, Version, Spigot, Discord);

        GUI_RegisterPermissions.onPermRegister();

        plugin.getCommand("commandgui").setExecutor(new GUI_CmdExecuter_GUI());
        plugin.getCommand("commandguiadmin").setExecutor(new GUI_CmdExecuter());

        Bukkit.getServer().getPluginManager().registerEvents(new GUI_Listener(), getPlugin());

        if (minecraft1_8 || minecraft1_9){
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_8bis1_9(), getPlugin());
        } else if (minecraft1_10 || minecraft1_11 || minecraft1_12 || minecraft1_13 || minecraft1_14 || minecraft1_15){
            Bukkit.getServer().getPluginManager().registerEvents(new UseItem_1_10bis1_15(), getPlugin());
        } else Bukkit.getServer().getPluginManager().registerEvents(new UseItem_ab1_16(), getPlugin());
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

}
