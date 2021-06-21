package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Debug {
    public static void debugmsg() {

        send.debug("§5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        send.debug("§3Bukkit Version: §e" + Bukkit.getBukkitVersion());
        send.debug("§3NMS Version: §e" + Bukkit.getServer().getClass().getPackage().getName().replace("org.bukkit.craftbukkit.", ""));
        send.debug("§3Version: §e" + Bukkit.getVersion());
        send.debug("§3Java: §e" + System.getProperty("java.version"));
        send.debug("§3Worlds: §e" +String.valueOf(Bukkit.getServer().getWorlds()));
        send.debug(String.valueOf(Main.Plugins));
        send.debug("§5----------------------------------");
        if (new File(Main.getPath(), "config.yml").exists()) {
            File f = new File(String.valueOf(Main.getPath()));
            File f2 = new File(String.valueOf(Main.getPath() + "/GUIs/"));
            File f3 = new File(String.valueOf(Main.getPath() + "/languages/"));
            File[] fileArray = f.listFiles();
            File[] fileArray2 = f2.listFiles();
            File[] fileArray3 = f3.listFiles();
            for (File config : fileArray) {
                send.debug(String.valueOf(config).replace("plugins/CommandGUI/", ""));
            }
            for (File config2 : fileArray2) {
                send.debug(String.valueOf(config2).replace("plugins/CommandGUI/", ""));
            }
            for (File config3 : fileArray3) {
                send.debug(String.valueOf(config3).replace("plugins/CommandGUI/", ""));
            }
        }
        send.debug("§5!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }

    public static void onDebugFile(CommandSender sender){
        String timeStamp = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(Calendar.getInstance().getTime());
        String timeStampcfg = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        send.sender(sender, Main.Prefix + " §5Debug file was createt: §e" + Main.getPath() + "\\debug\\commandgui_debug_"+ timeStamp +".yml");
        File debug = new File(Main.getPath(), "debug/commandgui_debug_"+ timeStamp +".yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(debug);

        set("Time", timeStampcfg, yamlConfiguration);
        set("CommandGUI.Version", String.valueOf( Main.getPlugin().getDescription().getVersion()), yamlConfiguration);

        set("Server.Bukkit_Version", String.valueOf(Bukkit.getBukkitVersion()), yamlConfiguration);
        set("Server.NMS_Version", String.valueOf(Bukkit.getServer().getClass().getPackage().getName().replace("org.bukkit.craftbukkit.", "")), yamlConfiguration);
        set("Server.Version", String.valueOf(Bukkit.getVersion()), yamlConfiguration);
        set("Server.Java", String.valueOf(System.getProperty("java.version")), yamlConfiguration);
        set("Server.Worlds",  String.valueOf(Bukkit.getServer().getWorlds()), yamlConfiguration);
        set("Server.Plugins", String.valueOf(Main.Plugins) , yamlConfiguration);

        try {
            yamlConfiguration.save(debug);
        } catch (IOException e) {
            send.warning(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void set(String path, String value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
    private static void set(String path, Integer value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
    private static void set(String path, Boolean value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
    private static void set(String path, List value, YamlConfiguration config){
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
