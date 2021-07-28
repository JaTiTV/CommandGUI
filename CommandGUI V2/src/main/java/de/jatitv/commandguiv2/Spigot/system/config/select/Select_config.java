package de.jatitv.commandguiv2.Spigot.system.config.select;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.Replace;
import de.jatitv.commandguiv2.Spigot.system.config.ConfigCreate;
import de.jatitv.commandguiv2.Spigot.system.database.MySQL;
import de.jatitv.commandguiv2.Spigot.system.send;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class Select_config {

    public static Boolean DisableUpdateChecker;
    public static Boolean UpdateCheckOnJoin;
    public static Boolean Debug;
    public static Boolean HelpAlias;
    public static String language;
    public static String Currency;

    public static String Storage;

    public static Boolean Bungee;
    public static String thisServer;

    public static String DefaultGUI;

    public static Boolean UseItem_Enable;
    public static Boolean UseItem_AllowToggle;
    public static Boolean UseItem_AllowSetSlot;
    public static Boolean UseItem_GiveOnEveryJoin;
    public static Boolean UseItem_GiveOnlyOnFirstJoin;
    public static Boolean UseItem_ServerChange;
    public static Boolean Cursor_ToGUIItem_OnLogin;
    public static Boolean Cursor_ToGUIItem_OnlyOnFirstLogin;
    public static Boolean UseItem_BlockMoveAndDrop;
    public static String UseItem_OpenGUI;
    public static Boolean UseItem_Permission;
    public static Boolean UseItem_InventorySlot_FreeSlot;
    public static Integer UseItem_InventorySlot;
    public static Boolean UseItem_InventorySlotEnforce;
    public static String UseItem_Material;
    public static Boolean UseItem_PlayerHead_Enable;
    public static Boolean UseItem_Base64_Enable;
    public static String UseItem_Base64value;
    public static Boolean UseItem_PlayerWhoHasOpenedTheGUI;
    public static String UseItem_PlayerName;
    public static String UseItem_Name;
    public static List UseItem_Lore;

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


    public static void onSelect() {
        File config = new File(Main.getPath(), "config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        if (yamlConfiguration.get("Plugin.DisableUpdateChecker") == null){
            DisableUpdateChecker = false;
        } else DisableUpdateChecker = yamlConfiguration.getBoolean("Plugin.DisableUpdateChecker");
        UpdateCheckOnJoin = yamlConfiguration.getBoolean("Plugin.UpdateCheckOnJoin");
        Debug = yamlConfiguration.getBoolean("Plugin.Debug");
        HelpAlias = yamlConfiguration.getBoolean("Plugin.HelpAlias");
        language = yamlConfiguration.getString("Plugin.language");
        Currency = yamlConfiguration.getString("Plugin.Currency");
        DefaultGUI = yamlConfiguration.getString("Plugin.DefaultGUI");

        Storage = yamlConfiguration.getString("Storage.Type").toUpperCase();

        MySQL.ip = yamlConfiguration.getString("Storage.MySQL.IP");
        MySQL.port = yamlConfiguration.getInt("Storage.MySQL.Port");
        MySQL.database = yamlConfiguration.getString("Storage.MySQL.Database");
        MySQL.user = yamlConfiguration.getString("Storage.MySQL.User");
        MySQL.password = yamlConfiguration.getString("Storage.MySQL.Password");
        MySQL.SSL = yamlConfiguration.getBoolean("Storage.MySQL.SSL");

        Bungee = yamlConfiguration.getBoolean("BungeeCord.Enable");
        thisServer = yamlConfiguration.getString("BungeeCord.ThisServer");



        UseItem_Enable = yamlConfiguration.getBoolean("UseItem.Enable");
        UseItem_AllowToggle = yamlConfiguration.getBoolean("UseItem.AllowToggle");
        UseItem_AllowSetSlot = yamlConfiguration.getBoolean("UseItem.AllowSetSlot");
        UseItem_BlockMoveAndDrop = yamlConfiguration.getBoolean("UseItem.BlockMoveAndDrop");
        UseItem_OpenGUI = yamlConfiguration.getString("UseItem.OpenGUI");
        UseItem_Permission = yamlConfiguration.getBoolean("UseItem.Permission.NeededToUse");
        UseItem_InventorySlot_FreeSlot = yamlConfiguration.getBoolean("UseItem.InventorySlot.FreeSlot");
        UseItem_InventorySlot = yamlConfiguration.getInt("UseItem.InventorySlot.Slot");
        UseItem_InventorySlotEnforce = yamlConfiguration.getBoolean("UseItem.InventorySlot.SlotEnforce");
        UseItem_Material = yamlConfiguration.getString("UseItem.Item.Material").toUpperCase();
        UseItem_PlayerHead_Enable = yamlConfiguration.getBoolean("UseItem.Item.PlayerHead.Enable");
        UseItem_Base64_Enable = yamlConfiguration.getBoolean("UseItem.Item.PlayerHead.Base64.Enable");
        UseItem_Base64value = yamlConfiguration.getString("UseItem.Item.PlayerHead.Base64.Base64Value");
        UseItem_PlayerWhoHasOpenedTheGUI = yamlConfiguration.getBoolean("UseItem.Item.PlayerHead.PlayerWhoHasOpenedTheGUI");
        UseItem_PlayerName = yamlConfiguration.getString("UseItem.Item.PlayerHead.PlayerName");
        UseItem_Name = Replace.replace(yamlConfiguration.getString("UseItem.Item.Name"));
        UseItem_Lore = yamlConfiguration.getList("UseItem.Item.Lore");
        UseItem_GiveOnEveryJoin = yamlConfiguration.getBoolean("UseItem.Join.GiveOnEveryJoin");
        UseItem_GiveOnlyOnFirstJoin = yamlConfiguration.getBoolean("UseItem.Join.GiveOnlyOnFirstJoin");
        UseItem_ServerChange = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.ServerChange");
        Cursor_ToGUIItem_OnLogin = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.OnLogin");
        Cursor_ToGUIItem_OnlyOnFirstLogin = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.OnlyOnFirstLogin");


        Sound_Enable = yamlConfiguration.getBoolean("Sound.Enable");
        Sound_OpenInventory_Enable = yamlConfiguration.getBoolean("Sound.OpenInventory.Enable");
        Sound_OpenInventory_input = (yamlConfiguration.getString("Sound.OpenInventory.Sound").toUpperCase().replace(".", "_"));
        Sound_Click_Enable = yamlConfiguration.getBoolean("Sound.Click.Enable");
        Sound_Click_input = (yamlConfiguration.getString("Sound.Click.Sound").toUpperCase().replace(".", "_"));
        Sound_NoMoney_Enable = yamlConfiguration.getBoolean("Sound.NoMoney.Enable");
        Sound_NoMoney_input = (yamlConfiguration.getString("Sound.NoMoney.Sound").toUpperCase().replace(".", "_"));

        Sound_NoInventorySpace_Enable = yamlConfiguration.getBoolean("Sound.NoInventorySpace.Enable");
        Sound_NoInventorySpace_input = (yamlConfiguration.getString("Sound.NoInventorySpace.Sound").toUpperCase().replace(".", "_"));
        Sound_Give_Enable = yamlConfiguration.getBoolean("Sound.Give.Enable");
        Sound_Give_input = (yamlConfiguration.getString("Sound.Give.Sound").toUpperCase().replace(".", "_"));
        Sound_PlayerNotFound_Enable = yamlConfiguration.getBoolean("Sound.PlayerNotFound.Enable");
        Sound_PlayerNotFound_input = (yamlConfiguration.getString("Sound.PlayerNotFound.Sound").toUpperCase().replace(".", "_"));

    }

    public static void sound(String Prefix){
        String soundOpenInventory;
        if (Main.minecraft1_8) {
            soundOpenInventory = ConfigCreate.Sound_OpenInventory_1_8 ;
        } else {
            soundOpenInventory = ConfigCreate.Sound_OpenInventory_ab_1_9;
        }

        String soundClick;
        if (Main.minecraft1_8) {
            soundClick = ConfigCreate.Sound_Click_1_8;
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundClick = ConfigCreate.Sound_Click_1_9_bis_1_12;
        } else {
            soundClick = ConfigCreate.Sound_Click_ab_1_13;
        }

        String soundNoMoney;
        if (Main.minecraft1_8) {
            soundNoMoney = ConfigCreate.Sound_NoMoney_1_8;
        } else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            soundNoMoney = ConfigCreate.Sound_NoMoney_1_9_bis_1_12;
        } else {
            soundNoMoney = ConfigCreate.Sound_NoMoney_ab_1_13;
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

        try {
            Sound sound_OpenInventory = Sound.valueOf(Sound_OpenInventory_input);
            if (sound_OpenInventory != null) {
                Sound_OpenInventory = sound_OpenInventory;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8OpenInventory: §6" + Sound_OpenInventory_input) + "§4\n§4\n§4\n");
            Sound_OpenInventory = Sound.valueOf(soundOpenInventory);
        }

        try {
            Sound sound_Click = Sound.valueOf(Sound_Click_input);
            if (sound_Click != null) {
                Sound_Click = sound_Click;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Click: §6" + Sound_Click_input) + "§4\n§4\n§4\n");
            Sound_Click = Sound.valueOf(soundClick);
        }

        try {
            Sound sound_NoMoney = Sound.valueOf(Sound_NoMoney_input);
            if (sound_NoMoney != null) {
                Sound_Click = sound_NoMoney;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8NoMoney: §6" + Sound_NoMoney_input) + "§4\n§4\n§4\n");
            Sound_NoMoney = Sound.valueOf(soundNoMoney);
        }


        try {
            Sound sound_NoInventorySpace = Sound.valueOf(Sound_NoInventorySpace_input);
            if (sound_NoInventorySpace != null) {
                Sound_NoInventorySpace = sound_NoInventorySpace;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8NoInventorySpace: §6" + Sound_NoInventorySpace_input) + "§4\n§4\n§4\n");
            Sound_NoInventorySpace = Sound.valueOf(soundNoInventorySpace);
        }

        try {
            Sound sound_Give = Sound.valueOf(Sound_Give_input);
            if (sound_Give != null) {
                Sound_Give = sound_Give;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8Give: §6" + Sound_Give_input) + "§4\n§4\n§4\n");
            Sound_Give = Sound.valueOf(soundGive);
        }

        try {
            Sound sound_PlayerNotFound = Sound.valueOf(Sound_PlayerNotFound_input);
            if (sound_PlayerNotFound != null) {
                Sound_PlayerNotFound = sound_PlayerNotFound;
            }
        } catch (Exception e) {
            send.console("§4\n§4\n§4\n" + Select_msg.SoundNotFound.replace("[prefix]", Prefix)
                    .replace("[sound]", "§8PlayerNotFound: §6" + Sound_PlayerNotFound_input) + "§4\n§4\n§4\n");
            Sound_PlayerNotFound = Sound.valueOf(soundPlayerNotFound);
        }

    }
}
