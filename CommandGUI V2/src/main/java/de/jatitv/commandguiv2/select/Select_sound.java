package de.jatitv.commandguiv2.select;

import de.jatitv.commandguiv2.system.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Select_sound {
    public static Boolean Sound_Enable = true;

    public static Boolean Sound_OpenInventory_Enable = true;
    public static Sound Sound_OpenInventory;
    public static String Sound_OpenInventory_input;

    public static Boolean Sound_Click_Enable = true;
    public static Sound Sound_Click;
    public static String Sound_Click_input;

    public static Boolean Sound_NoMoney_Enable = true;
    public static Sound Sound_NoMoney;
    public static String Sound_NoMoney_input;

    public static Boolean Sound_NoInventorySpace_Enable = true;
    public static Sound Sound_NoInventorySpace;
    public static String Sound_NoInventorySpace_input;

    public static Boolean Sound_Give_Enable = true;
    public static Sound Sound_Give;
    public static String Sound_Give_input;

    public static Boolean Sound_PlayerNotFound_Enable = true;
    public static Sound Sound_PlayerNotFound;
    public static String Sound_PlayerNotFound_input;
    public static void onCreate(String Prefix){
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

        File config = new File(Main.thisp().getDataFolder().getPath(), "sound.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        if (yamlConfiguration.contains("Sound.Enable")) {
            Sound_Enable = yamlConfiguration.getBoolean("Sound.Enable");
        } else {
            yamlConfiguration.set("Sound.Enable", true);
        }

        if (yamlConfiguration.contains("Sound.Click.Enable")) {
            Sound_Click_Enable = yamlConfiguration.getBoolean("Sound.Click.Enable");
        } else {
            yamlConfiguration.set("Sound.Click.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.Click.Sound")) {
            Sound_Click_input = (yamlConfiguration.getString("Sound.Click.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Click.Sound", soundHAT);
            Sound_Click_input = soundHAT;
        }


        if (yamlConfiguration.contains("Sound.NoMoney.Enable")) {
            Sound_NoMoney_Enable = yamlConfiguration.getBoolean("Sound.NoMoney.Enable");
        } else {
            yamlConfiguration.set("Sound.NoMoney.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.NoMoney.Sound")) {
            Sound_NoMoney_input = (yamlConfiguration.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoMoney.Sound", soundBNBH);
            Sound_NoMoney_input = soundBNBH;
        }


        if (yamlConfiguration.contains("Sound.NoInventorySpace.Enable")) {
            Sound_NoInventorySpace_Enable = yamlConfiguration.getBoolean("Sound.NoInventorySpace.Enable");
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.NoInventorySpace.Sound")) {
            Sound_NoInventorySpace_input = (yamlConfiguration.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Sound", soundBNBG);
            Sound_NoInventorySpace_input = soundBNBG;
        }


        if (yamlConfiguration.contains("Sound.Give.Enable")) {
            Sound_Give_Enable = yamlConfiguration.getBoolean("Sound.Give.Enable");
        } else {
            yamlConfiguration.set("Sound.Give.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.Give.Sound")) {
            Sound_Give_input = (yamlConfiguration.getString("Sound.Give.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Give.Sound", soundEPL);
            Sound_Give_input = soundEPL;
        }


        if (yamlConfiguration.contains("Sound.PlayerNotFound.Enable")) {
            Sound_PlayerNotFound_Enable = yamlConfiguration.getBoolean("Sound.PlayerNotFound.Enable");
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.PlayerNotFound.Sound")) {
            Sound_PlayerNotFound_input = (yamlConfiguration.getString("Sound.PlayerNotFound.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Sound", soundBNBH);
            Sound_PlayerNotFound_input = soundBNBH;
        }

        try {
            yamlConfiguration.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Sound sound_Click = Sound.valueOf(Sound_Click_input);
            if (sound_Click != null) {
                Sound_Click = sound_Click;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Click: §6" + Sound_Click_input) + "§4\n§4\n§4\n");
            Sound_Click = Sound.valueOf(soundHAT);
        }

        try {
            Sound sound_NoMoney = Sound.valueOf(Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                Sound_NoMoney = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + Sound_NoMoney_input) + "§4\n§4\n§4\n");
            Sound_NoMoney = Sound.valueOf(soundBNBH);
        }

        try {
            Sound sound_Give = Sound.valueOf(Sound_Give_input);
            if (sound_Give != null) {
                Sound_Give = sound_Give;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Give: §6" + Sound_Give_input) + "§4\n§4\n§4\n");
            Sound_Give = Sound.valueOf(soundEPL);
        }

        try {
            Sound sound_NoInventorySpace = Sound.valueOf(Sound_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                Sound_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8sound_NoInventorySpace: §6" + Sound_NoInventorySpace_input) + "§4\n§4\n§4\n");
            Sound_NoInventorySpace = Sound.valueOf(soundBNBG);
        }

        try {
            Sound sound_PlayerNotFound = Sound.valueOf(Sound_PlayerNotFound_input);
            if (sound_PlayerNotFound != null) {
                Sound_PlayerNotFound = sound_PlayerNotFound;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8PlayerNotFound: §6" + Sound_PlayerNotFound_input) + "§4\n§4\n§4\n");
            Sound_PlayerNotFound = Sound.valueOf(soundBNBH);
        }
    }
}
