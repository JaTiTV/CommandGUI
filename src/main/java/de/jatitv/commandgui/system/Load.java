// This claas was created by JaTiTV


package de.jatitv.commandgui.system;

import de.jatitv.commandgui.config.*;
import de.jatitv.commandgui.defultValue.DefaultValue;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Load {

    public static void LoadSend(String version) throws InterruptedException {
        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration_config = YamlConfiguration.loadConfiguration(configYML);

        if (yamlConfiguration_config.getInt("Plugin.Debug.DebugStage_(1-3)") > 3) {
            yamlConfiguration_config.set("Plugin.Debug.DebugStage_(1-3)", 3);
        }

        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2-----------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4  _____ §9_____ _    _ _____");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4 / ____§9/ ____| |  | |_   _|");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |   §9| |  __| |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |   §9| | |_ | |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |___§9| |__| | |__| |_| |_");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4 \\_____§9\\_____|\\____/|_____|");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Autor: §6JaTiTV");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Version: §6" + version);
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Spigot: §6" + Main.Spigot);
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Discord: §6" + Main.DiscordLoad);
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        /*
        if (yamlConfiguration_config.getBoolean("Plugin.Debug.Enable")) {
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-------------------------------");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Debugmodus is enable!!!");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-------------------------------");
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
            Thread.sleep(5000);
        }

         */
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Plugin load...");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        if (Main.UpdateMSG) {
            String ver = (String) yamlConfiguration_config.get("Do_not_remove_or_change.Version");
            if (configYML.isFile()) {
                if (ver == null || !ver.equals(Main.getPlugin().getDescription().getVersion())) {
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-------------------------------");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(Main.UpdateInfo);
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-------------------------------");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
                    Thread.sleep(20000);
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§6Thanks for downloading and installing CommandGUI");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
                Thread.sleep(3000);
            }
        }

        Config.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Messages_EN.messagesCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Messages_DE.messagesCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Messages_FR.messagesCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Messages_NO.messagesCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        GUI_1.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        GUI_2.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        GUI_3.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Messages_Select.selectCreate();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Vault.loadVault();
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        if (Main.PaPi){
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2PlaceholderAPI successfully connected!");
        }else{
            Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4PlaceholderAPI could not be connected / found!");
        }
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2-----------------------------------------------------------------------------------");
    }
}
