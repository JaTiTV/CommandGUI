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

/*
    public static Boolean Sound_NoInventorySpace_Enable = true;
    public static Sound Sound_NoInventorySpace;
    public static String Sound_NoInventorySpace_input;

    public static Boolean Sound_Give_Enable = true;
    public static Sound Sound_Give;
    public static String Sound_Give_input;

    public static Boolean Sound_PlayerNotFound_Enable = true;
    public static Sound Sound_PlayerNotFound;
    public static String Sound_PlayerNotFound_input;

     */

    public static void onCreate(String Prefix) {

        String soundOpenInventory;
        if (Main.minecraft1_8) {
            soundOpenInventory = "CHEST_OPEN ";
        } else {
            soundOpenInventory = "BLOCK_CHEST_OPEN";
        }

        String soundClick;
        if (Main.minecraft1_8) {
            soundClick = "NOTE_STICKS";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundClick = "BLOCK_NOTE_HAT";
        } else {
            soundClick = "BLOCK_NOTE_BLOCK_HAT";
        }

        String soundNoMoney;
        if (Main.minecraft1_8) {
            soundNoMoney = "NOTE_PIANO";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundNoMoney = "BLOCK_NOTE_HARP";
        } else {
            soundNoMoney = "BLOCK_NOTE_BLOCK_HARP";
        }

        String soundNoInventorySpace;
        if (Main.minecraft1_8) {
            soundNoInventorySpace = "NOTE_PIANO";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundNoInventorySpace = "BLOCK_NOTE_BASS";
        } else {
            soundNoInventorySpace = "BLOCK_NOTE_BLOCK_GUITAR";
        }

        String soundGive;
        if (Main.minecraft1_8) {
            soundGive = "LEVEL_UP";
        } else {
            soundGive = "ENTITY_PLAYER_LEVELUP";
        }

        String soundPlayerNotFound;
        if (Main.minecraft1_8) {
            soundPlayerNotFound = "NOTE_PIANO";
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundPlayerNotFound = "BLOCK_NOTE_HARP";
        } else {
            soundPlayerNotFound = "BLOCK_NOTE_BLOCK_HARP";
        }

        File config = new File(Main.thisp().getDataFolder().getPath(), "sound.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        if (yamlConfiguration.contains("Sound.Enable")) {
            Sound_Enable = yamlConfiguration.getBoolean("Sound.Enable");
        } else {
            yamlConfiguration.set("Sound.Enable", true);
        }

        if (yamlConfiguration.contains("Sound.OpenInventory.Enable")) {
            Sound_OpenInventory_Enable = yamlConfiguration.getBoolean("Sound.OpenInventory.Enable");
        } else {
            yamlConfiguration.set("Sound.OpenInventory.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.OpenInventory.Sound")) {
            Sound_OpenInventory_input = (yamlConfiguration.getString("Sound.OpenInventory.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.OpenInventory.Sound", soundOpenInventory);
            Sound_OpenInventory_input = soundOpenInventory;
        }

        if (yamlConfiguration.contains("Sound.Click.Enable")) {
            Sound_Click_Enable = yamlConfiguration.getBoolean("Sound.Click.Enable");
        } else {
            yamlConfiguration.set("Sound.Click.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.Click.Sound")) {
            Sound_Click_input = (yamlConfiguration.getString("Sound.Click.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Click.Sound", soundClick);
            Sound_Click_input = soundClick;
        }

        if (yamlConfiguration.contains("Sound.NoMoney.Enable")) {
            Sound_NoMoney_Enable = yamlConfiguration.getBoolean("Sound.NoMoney.Enable");
        } else {
            yamlConfiguration.set("Sound.NoMoney.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.NoMoney.Sound")) {
            Sound_NoMoney_input = (yamlConfiguration.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoMoney.Sound", soundNoMoney);
            Sound_NoMoney_input = soundNoMoney;
        }

/*
        if (yamlConfiguration.contains("Sound.NoInventorySpace.Enable")) {
            Sound_NoInventorySpace_Enable = yamlConfiguration.getBoolean("Sound.NoInventorySpace.Enable");
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.NoInventorySpace.Sound")) {
            Sound_NoInventorySpace_input = (yamlConfiguration.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.NoInventorySpace.Sound", soundNoInventorySpace);
            Sound_NoInventorySpace_input = soundNoInventorySpace;
        }

        if (yamlConfiguration.contains("Sound.Give.Enable")) {
            Sound_Give_Enable = yamlConfiguration.getBoolean("Sound.Give.Enable");
        } else {
            yamlConfiguration.set("Sound.Give.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.Give.Sound")) {
            Sound_Give_input = (yamlConfiguration.getString("Sound.Give.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.Give.Sound", soundGive);
            Sound_Give_input = soundGive;
        }

        if (yamlConfiguration.contains("Sound.PlayerNotFound.Enable")) {
            Sound_PlayerNotFound_Enable = yamlConfiguration.getBoolean("Sound.PlayerNotFound.Enable");
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Enable", true);
        }
        if (yamlConfiguration.contains("Sound.PlayerNotFound.Sound")) {
            Sound_PlayerNotFound_input = (yamlConfiguration.getString("Sound.PlayerNotFound.Sound").toUpperCase().replace(".", "_"));
        } else {
            yamlConfiguration.set("Sound.PlayerNotFound.Sound", soundPlayerNotFound);
            Sound_PlayerNotFound_input = soundPlayerNotFound;
        }
        */


        try {
            yamlConfiguration.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Sound sound_OpenInventory = Sound.valueOf(Sound_OpenInventory_input);
            if (sound_OpenInventory != null) {
                Sound_OpenInventory = sound_OpenInventory;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8OpenInventory: §6" + Sound_OpenInventory_input) + "§4\n§4\n§4\n");
            Sound_OpenInventory = Sound.valueOf(soundOpenInventory);
        }

        try {
            Sound sound_Click = Sound.valueOf(Sound_Click_input);
            if (sound_Click != null) {
                Sound_Click = sound_Click;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Click: §6" + Sound_Click_input) + "§4\n§4\n§4\n");
            Sound_Click = Sound.valueOf(soundClick);
        }

        try {
            Sound sound_NoMoney = Sound.valueOf(Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                Sound_Click = sound_NoMoney;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + Sound_NoMoney_input) + "§4\n§4\n§4\n");
            Sound_NoMoney = Sound.valueOf(soundNoMoney);
        }

/*
        try {
            Sound sound_NoInventorySpace = Sound.valueOf(Sound_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                Sound_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8NoInventorySpace: §6" + Sound_NoInventorySpace_input) + "§4\n§4\n§4\n");
            Sound_NoInventorySpace = Sound.valueOf(soundNoInventorySpace);
        }

        try {
            Sound sound_Give = Sound.valueOf(Sound_Give_input);
            if (sound_Give != null) {
                Sound_Give = sound_Give;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Give: §6" + Sound_Give_input) + "§4\n§4\n§4\n");
            Sound_Give = Sound.valueOf(soundGive);
        }

        try {
            Sound sound_PlayerNotFound = Sound.valueOf(Sound_PlayerNotFound_input);
            if (sound_PlayerNotFound != null) {
                Sound_PlayerNotFound = sound_PlayerNotFound;
            }
        } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8PlayerNotFound: §6" + Sound_PlayerNotFound_input) + "§4\n§4\n§4\n");
            Sound_PlayerNotFound = Sound.valueOf(soundPlayerNotFound);
        }
        */
    }
}
