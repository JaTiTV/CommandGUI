// This claas was created by JaTiTV


package de.jatitv.commandgui.system;

import de.jatitv.commandgui.config.*;
import de.jatitv.commandgui.defultValue.DefultValue;
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

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2-----------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2    _____ _____ _    _ _____");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2   / ____/ ____| |  | |_   _|");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2  | |   | |  __| |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2  | |   | | |_ | |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2  | |___| |__| | |__| |_| |_");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2   \\_____\\_____|\\____/|_____|");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Autor: §6JaTiTV");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Version: §6" + version);
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Spigot: §6" + Main.Spigot);
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Discord: §6" + Main.DiscordLoad);
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
        if (yamlConfiguration_config.getBoolean("Plugin.Debug.Enable")) {
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Debugmodus is enable!!!");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
            Thread.sleep(5000);
        }
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Plugin load...");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        if (Main.UpdateMSG) {
            String ver = (String) yamlConfiguration_config.get("Do_not_remove_or_change.Version");
            if (configYML.isFile()) {
                if (ver == null) {
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(Main.UpdateInfo);
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                    Thread.sleep(20000);
                } else {
                    if (!ver.equals(Main.getPlugin().getDescription().getVersion())) {

                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(Main.UpdateInfo);
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4-------------------------------");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2");
                        Thread.sleep(20000);
                    } else Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
                }
            } else {
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§6Thanks for downloading and installing CommandGUI");
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4");
                Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
                Thread.sleep(5000);
            }
        }

        Config.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Messages.messagesCreate();
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        GUI_1.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        GUI_2.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        GUI_3.configCreate();
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");

        Vault.loadVault();

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2Plugin loaded successfully.");
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§2-----------------------------------------------------------------------------------");
    }
}
