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

        yamlConfiguration_config.set("Do_not_remove_or_change.Discord", Main.DiscordMSG);

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
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Cost Currency §4was added to §9Config.yml§4!");
        }

        if (yamlConfiguration_config.contains("GUI.DefaultGUI")) {
            DefultValue.DefaultGUI = yamlConfiguration_config.getInt("GUI.DefaultGUI");
        } else {
            yamlConfiguration_config.set("GUI.DefaultGUI", 1);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6GUI DefaultGUI §4was added to §9Config.yml§4!");
        }



        /**
         *Sound
         */

        String soundEPL;
        if(Main.minecraft1_8){
            soundEPL = "NOTE_STICKS";
        }else{
            soundEPL = "BLOCK_NOTE_BLOCK_HAT";
        }

        String soundBNBH;
        if(Main.minecraft1_8){
            soundBNBH = "NOTE_PIANO";
        }else{
            soundBNBH = "BLOCK_NOTE_BLOCK_HARP";
        }

        String soundBNBG;
        if(Main.minecraft1_8){
            soundBNBG = "NOTE_PIANO";
        }else{
            soundBNBG = "BLOCK_NOTE_BLOCK_GUITAR";
        }

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
            yamlConfiguration_config.set("Sound.Click.Sound", soundEPL);
            DefultValue.Sound_Click_input = soundEPL;
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
            yamlConfiguration_config.set("Sound.NoMoney.Sound", soundBNBH);
            DefultValue.Sound_NoMoney_input = soundBNBH;
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound NoMoney §4was added to §9Config.yml§4!");
        }



        if (yamlConfiguration_config.contains("Sound.NoInventorySpace.Enable")) {
            DefultValue.Sound_NoInventorySpace_Enable = yamlConfiguration_config.getBoolean("Sound.NoInventorySpace.Enable");
        } else {
            yamlConfiguration_config.set("Sound.NoInventorySpace.Enable", true);
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace Enable §4was added to §9Config.yml§4!");
        }
        if (yamlConfiguration_config.contains("Sound.NoInventorySpace.Sound")) {
            DefultValue.Sound_NoInventorySpace_input = (yamlConfiguration_config.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration_config.set("Sound.NoInventorySpace.Sound", soundBNBG);
            DefultValue.Sound_NoInventorySpace_input = soundBNBG;
            Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Setting §6Sound NoInventorySpace §4was added to §9Config.yml§4!");
        }

        try {
            yamlConfiguration_config.save(configYML);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Sound sound_Click = Sound.valueOf(DefultValue.Sound_Click_input);
            if (sound_Click != null) {
                DefultValue.Sound_Click = sound_Click;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefultValue.SoundNotFound.replace("[prefix]", DefultValue.Prefix)
                    .replace("[sound]", "§8Click: §6" + DefultValue.Sound_Click_input) + "§4\n§4\n§4\n");
            DefultValue.Sound_Click = Sound.valueOf(soundEPL);
        }
        try {
            Sound sound_NoMoney = Sound.valueOf(DefultValue.Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                DefultValue.Sound_NoMoney = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefultValue.SoundNotFound.replace("[prefix]", DefultValue.Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + DefultValue.Sound_NoMoney_input) + "§4\n§4\n§4\n");
            DefultValue.Sound_NoMoney = Sound.valueOf(soundBNBH);
        }
        try {
            Sound sound_NoInventorySpace = Sound.valueOf(DefultValue.Sound_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                DefultValue.Sound_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + DefultValue.SoundNotFound.replace("[prefix]", DefultValue.Prefix)
                    .replace("[sound]", "§8sound_NoInventorySpace: §6" + DefultValue.Sound_NoInventorySpace_input) + "§4\n§4\n§4\n");
            DefultValue.Sound_NoInventorySpace = Sound.valueOf(soundBNBG);
        }
    }
}
