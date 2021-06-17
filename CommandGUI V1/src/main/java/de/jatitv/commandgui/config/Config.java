// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.defaultValue.DefaultValue;
import de.jatitv.commandgui.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static void configCreate(String version) {
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Config.yml load...");

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration_config = YamlConfiguration.loadConfiguration(configYML);

        if (!yamlConfiguration_config.contains("Do_not_remove_or_change.Created"))
            yamlConfiguration_config.set("Do_not_remove_or_change.Created", "This file was created with version " + version);
        yamlConfiguration_config.set("Do_not_remove_or_change.Version", version);
        yamlConfiguration_config.set("Do_not_remove_or_change.Autor", Main.Autor);
        yamlConfiguration_config.set("Do_not_remove_or_change.Spigot", Main.Spigot);
        yamlConfiguration_config.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

        if (yamlConfiguration_config.contains("Plugin.UpdateCheckOnJoin")) {
            DefaultValue.UpdateCheckOnJoin = yamlConfiguration_config.getBoolean("Plugin.UpdateCheckOnJoin");
        } else {
            yamlConfiguration_config.set("Plugin.UpdateCheckOnJoin", DefaultValue.UpdateCheckOnJoin);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6UpdateCheckOnJoin §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Plugin.language")) {
            DefaultValue.language = yamlConfiguration_config.getString("Plugin.language");
        } else {
            yamlConfiguration_config.set("Plugin.language", DefaultValue.language);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6language §4was added to §9Config.yml§4!");
        }
/*
        if (yamlConfiguration_config.contains("Plugin.Debug.Enable")) {
            DefultValue.Debug = yamlConfiguration_config.getBoolean("Plugin.Debug.Enable");
        } else {
            yamlConfiguration_config.set("Plugin.Debug.Enable", DefultValue.Debug);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Debug Enable §4was added to §9Config.yml§4!");
        }

 */

        if (yamlConfiguration_config.contains("Cost.Currency")) {
            DefaultValue.Currency = yamlConfiguration_config.getString("Cost.Currency");
        } else {
            yamlConfiguration_config.set("Cost.Currency", DefaultValue.Currency);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Cost Currency §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("GUI.DefaultGUI")) {
            DefaultValue.DefaultGUI = yamlConfiguration_config.getInt("GUI.DefaultGUI");
        } else {
            yamlConfiguration_config.set("GUI.DefaultGUI", DefaultValue.DefaultGUI);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6GUI DefaultGUI §4was added to §9Config.yml§4!");
        }


        /**
         *Sound
         */

        String soundEPL;
        if (Main.minecraft1_8) {
            soundEPL = "LEVEL_UP";
        } else {
            soundEPL = "ENTITY_PLAYER_LEVELUP";
        }

        String soundHAT;
        if (Main.minecraft1_8) {
            soundHAT = "NOTE_STICKS";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundHAT = "BLOCK_NOTE_HAT";
        } else {
            soundHAT = "BLOCK_NOTE_BLOCK_HAT";
        }

        String soundBNBH;
        if (Main.minecraft1_8) {
            soundBNBH = "NOTE_PIANO";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundBNBH = "BLOCK_NOTE_HARP";
        } else {
            soundBNBH = "BLOCK_NOTE_BLOCK_HARP";
        }

        String soundBNBG;
        if (Main.minecraft1_8) {
            soundBNBG = "NOTE_PIANO";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundBNBG = "BLOCK_NOTE_BASS";
        } else {
            soundBNBG = "BLOCK_NOTE_BLOCK_GUITAR";
        }

        if (yamlConfiguration_config.contains("Sound.Enable")) {
            DefaultValue.Sound_Enable = yamlConfiguration_config.getBoolean("Sound.Enable");
        } else {
            yamlConfiguration_config.set("Sound.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Enable §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("Sound.Click.Enable")) {
            DefaultValue.Sound_Click_Enable = yamlConfiguration_config.getBoolean("Sound.Click.Enable");
        } else {
            yamlConfiguration_config.set("Sound.Click.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Click Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.Click.Sound")) {
            DefaultValue.Sound_Click_input = (yamlConfiguration_config.getString("Sound.Click.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.Click.Sound", soundHAT);
            DefaultValue.Sound_Click_input = soundHAT;
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Click §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration_config.contains("Sound.NoMoney.Enable")) {
            DefaultValue.Sound_NoMoney_Enable = yamlConfiguration_config.getBoolean("Sound.NoMoney.Enable");
        } else {
            yamlConfiguration_config.set("Sound.NoMoney.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoMoney Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.NoMoney.Sound")) {
            DefaultValue.Sound_NoMoney_input = (yamlConfiguration_config.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.NoMoney.Sound", soundBNBH);
            DefaultValue.Sound_NoMoney_input = soundBNBH;
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoMoney §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration_config.contains("Sound.NoInventorySpace.Enable")) {
            DefaultValue.Sound_NoInventorySpace_Enable = yamlConfiguration_config.getBoolean("Sound.NoInventorySpace.Enable");
        } else {
            yamlConfiguration_config.set("Sound.NoInventorySpace.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.NoInventorySpace.Sound")) {
            DefaultValue.Sound_NoInventorySpace_input = (yamlConfiguration_config.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.NoInventorySpace.Sound", soundBNBG);
            DefaultValue.Sound_NoInventorySpace_input = soundBNBG;
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration_config.contains("Sound.Give.Enable")) {
            DefaultValue.Sound_Give_Enable = yamlConfiguration_config.getBoolean("Sound.Give.Enable");
        } else {
            yamlConfiguration_config.set("Sound.Give.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Give Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.Give.Sound")) {
            DefaultValue.Sound_Give_input = (yamlConfiguration_config.getString("Sound.Give.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.Give.Sound", soundEPL);
            DefaultValue.Sound_Give_input = soundEPL;
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Give §4was added to §9Config.yml§4!");
        }


        if (yamlConfiguration_config.contains("Sound.PlayerNotFound.Enable")) {
            DefaultValue.Sound_PlayerNotFound_Enable = yamlConfiguration_config.getBoolean("Sound.PlayerNotFound.Enable");
        } else {
            yamlConfiguration_config.set("Sound.PlayerNotFound.Enable", true);
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound PlayerNotFound Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.PlayerNotFound.Sound")) {
            DefaultValue.Sound_PlayerNotFound_input = (yamlConfiguration_config.getString("Sound.PlayerNotFound.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.PlayerNotFound.Sound", soundBNBH);
            DefaultValue.Sound_PlayerNotFound_input = soundBNBH;
            if (configYML.isFile()) Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Setting §6Sound Send §4was added to §9Config.yml§4!");
        }

        try {
            yamlConfiguration_config.save(configYML);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Sound sound_Click = Sound.valueOf(DefaultValue.Sound_Click_input);
            if (sound_Click != null) {
                DefaultValue.Sound_Click = sound_Click;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8Click: §6" + DefaultValue.Sound_Click_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Click = Sound.valueOf(soundHAT);
        }

        try {
            Sound sound_NoMoney = Sound.valueOf(DefaultValue.Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                DefaultValue.Sound_NoMoney = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + DefaultValue.Sound_NoMoney_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_NoMoney = Sound.valueOf(soundBNBH);
        }

        try {
            Sound sound_Give = Sound.valueOf(DefaultValue.Sound_Give_input);
            if (sound_Give != null) {
                DefaultValue.Sound_Give = sound_Give;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8Give: §6" + DefaultValue.Sound_Give_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_Give = Sound.valueOf(soundEPL);
        }

        try {
            Sound sound_NoInventorySpace = Sound.valueOf(DefaultValue.Sound_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                DefaultValue.Sound_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8sound_NoInventorySpace: §6" + DefaultValue.Sound_NoInventorySpace_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_NoInventorySpace = Sound.valueOf(soundBNBG);
        }

        try {
            Sound sound_PlayerNotFound = Sound.valueOf(DefaultValue.Sound_PlayerNotFound_input);
            if (sound_PlayerNotFound != null) {
                DefaultValue.Sound_PlayerNotFound = sound_PlayerNotFound;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefaultValue.SoundNotFound.replace("[prefix]", DefaultValue.Prefix)
                    .replace("[sound]", "§8PlayerNotFound: §6" + DefaultValue.Sound_PlayerNotFound_input) + "§4\n§4\n§4\n");
            DefaultValue.Sound_PlayerNotFound = Sound.valueOf(soundBNBH);
        }
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2Config.yml loaded successfully.");
    }
}
