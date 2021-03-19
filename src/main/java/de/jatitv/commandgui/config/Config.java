// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static void configCreate(){

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration_config = YamlConfiguration.loadConfiguration(configYML);

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Config.yml load...");

        if (!yamlConfiguration_config.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_config.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_config.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_config.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_config.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_config.set("Do_not_remove_or_change.Discord", Main.Discord);

        if (yamlConfiguration_config.contains("Plugin.UpdateCheckOnJoin")) {
            DefultValue.UpdateCheckOnJoin = yamlConfiguration_config.getBoolean("Plugin.UpdateCheckOnJoin");
        } else {
            yamlConfiguration_config.set("Plugin.UpdateCheckOnJoin", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6UpdateCheckOnJoin §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("Plugin.Debug.Enable")) {
            DefultValue.Debug = yamlConfiguration_config.getBoolean("Plugin.Debug.Enable");
        } else {
            yamlConfiguration_config.set("Plugin.Debug.Enable", false);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Debug Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("Cost.Currency")) {
            DefultValue.Currency = yamlConfiguration_config.getString("Cost.Currency");
        } else {
            yamlConfiguration_config.set("Cost.Currency", "$");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Currency §4was added to §9Config.yml§4!");
        }



        /**
         *Sound
         */

        if (yamlConfiguration_config.contains("Sound.Enable")) {
            DefultValue.Sound_Enable = yamlConfiguration_config.getBoolean("Sound.Enable");
        } else {
            yamlConfiguration_config.set("Sound.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("Sound.Click.Enable")) {
            DefultValue.Sound_Click_Enable = yamlConfiguration_config.getBoolean("Sound.Click.Enable");
        } else {
            yamlConfiguration_config.set("Sound.Click.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound Click Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.Click.Sound")) {
            DefultValue.Sound_Click_input = (yamlConfiguration_config.getString("Sound.Click.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.Click.Sound", "ENTITY_PLAYER_LEVELUP");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound Click §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration_config.contains("Sound.NoMoney.Enable")) {
            DefultValue.Sound_NoMoney_Enable = yamlConfiguration_config.getBoolean("Sound.NoMoney.Enable");
        } else {
            yamlConfiguration_config.set("Sound.NoMoney.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound NoMoney Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.NoMoney.Sound")) {
            DefultValue.Sound_NoMoney_input = (yamlConfiguration_config.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.NoMoney.Sound", "BLOCK_NOTE_BLOCK_HARP");
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound NoMoney §4was added to §9Config.yml§4!");
        }

        try {
            yamlConfiguration_config.save(configYML);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Sound sound_Buy = Sound.valueOf(DefultValue.Sound_Click_input);
            if (sound_Buy != null) {
                DefultValue.Sound_Click = sound_Buy;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefultValue.SoundNotFound.replace("[prefix]", DefultValue.Prefix)
                    .replace("[sound]", "§8Click: §6" + DefultValue.Sound_Click_input) + "§4\n§4\n§4\n");
            DefultValue.Sound_Click = Sound.ENTITY_PLAYER_LEVELUP;
        }
        try {
            Sound sound_NoMoney = Sound.valueOf(DefultValue.Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                DefultValue.Sound_NoMoney = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefultValue.SoundNotFound.replace("[prefix]", DefultValue.Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + DefultValue.Sound_NoMoney_input) + "§4\n§4\n§4\n");
            DefultValue.Sound_NoMoney = Sound.BLOCK_NOTE_BLOCK_BASS;
        }
    }
}
