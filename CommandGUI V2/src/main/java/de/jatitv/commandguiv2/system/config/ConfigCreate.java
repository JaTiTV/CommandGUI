package de.jatitv.commandguiv2.system.config;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;



public class ConfigCreate {

    private static Boolean UpdateCheckOnJoin = true;
    private static Boolean Debug = false;
    private static Boolean HelpAlias = true;
    private static String language = "english";
    private static String Currency = "$";
    private static String DefaultGUI = "default";


    private static String Storage = "YML";
    private static String ip = "localhost";
    private static Integer port = 3306;
    private static String database = "database";
    private static String user = "root";
    private static String password = "password";
    private static Boolean SSL = false;

    private static Boolean Bungee = false;
    private static String thisServer = "server";


    private static Boolean UseItem_Enable = true;
    private static Boolean UseItem_AllowToggle = true;
    private static Boolean UseItem_BlockMoveAndDrop = true;
    private static String UseItem_OpenGUI = "default";
    private static Boolean UseItem_Permission = true;
    private static Integer UseItem_InventorySlot = 1;
    private static Boolean UseItem_InventorySlotEnforce = false;
    private static Boolean UseItem_InventorySlot_FreeSlot = false;
    private static String UseItem_Material = "paper";
    private static Boolean UseItem_PlayerHead_Enable = false;
    private static Boolean UseItem_PlayerWhoHasOpenedTheGUI = false;
    private static String UseItem_PlayerName = "";
    private static String UseItem_Name = "&bDefault &6GUI";
    private static List UseItem_Lore = Arrays.asList("&eOpen the GUI from &bBuilders-Paradise");
    private static Boolean UseItem_GiveOnEveryJoin = true;
    private static Boolean UseItem_GiveOnFirstJoin = true;
    private static Boolean Cursor_ToGUIItem_OnLogin = true;
    private static Boolean Cursor_ToGUIItem_OnFirstLogin = true;
    private static Boolean Cursor_ServerChange_EXPERIMENTELL = false;

    private static Boolean Sound_Enable = true;
    private static Boolean Sound_OpenInventory_Enable = true;
    public static String Sound_OpenInventory_1_8 = "CHEST_OPEN";
    public static String Sound_OpenInventory_ab_1_9 = "BLOCK_CHEST_OPEN";

    private static Boolean Sound_Click_Enable = true;
    public static String Sound_Click_1_8 = "NOTE_STICKS";
    public static String Sound_Click_1_9_bis_1_12 = "BLOCK_NOTE_HAT";
    public static String Sound_Click_ab_1_13 = "BLOCK_NOTE_BLOCK_HAT";

    private static Boolean Sound_NoMoney_Enable = true;
    public static String Sound_NoMoney_1_8 = "NOTE_PIANO";
    public static String Sound_NoMoney_1_9_bis_1_12 = "BLOCK_NOTE_HARP";
    public static String Sound_NoMoney_ab_1_13 = "BLOCK_NOTE_BLOCK_HARP";


    public static void configCreate() {
        send.Console(Main.Prefix + " §4config.yml are created / updated...");

        File config = new File(Main.getPath(), "config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        set("Plugin.UpdateCheckOnJoin", UpdateCheckOnJoin, yamlConfiguration);
        set("Plugin.Debug", Debug, yamlConfiguration);
        set("Plugin.HelpAlias", HelpAlias, yamlConfiguration);
        set("Plugin.language", language, yamlConfiguration);
        set("Plugin.Currency", Currency, yamlConfiguration);
        set("Plugin.DefaultGUI", DefaultGUI, yamlConfiguration);

        set("Storage.Type", Storage, yamlConfiguration);
        set("Storage.MySQL.IP", ip, yamlConfiguration);
        set("Storage.MySQL.Port", port, yamlConfiguration);
        set("Storage.MySQL.Database", database, yamlConfiguration);
        set("Storage.MySQL.User", user, yamlConfiguration);
        set("Storage.MySQL.Password", password, yamlConfiguration);
        set("Storage.MySQL.SSL", SSL, yamlConfiguration);

        set("BungeeCord.Enable", Bungee, yamlConfiguration);
        set("BungeeCord.ThisServer", thisServer, yamlConfiguration);

        set("UseItem.Enable", UseItem_Enable, yamlConfiguration);
        set("UseItem.AllowToggle", UseItem_AllowToggle, yamlConfiguration);
        set("UseItem.BlockMoveAndDrop", UseItem_BlockMoveAndDrop, yamlConfiguration);
        set("UseItem.OpenGUI", UseItem_OpenGUI, yamlConfiguration);
        set("UseItem.Permission.NeededToUse", UseItem_Permission, yamlConfiguration);

        set("UseItem.InventorySlot.Slot", UseItem_InventorySlot, yamlConfiguration);
        set("UseItem.InventorySlot.SlotEnforce", UseItem_InventorySlotEnforce, yamlConfiguration);
        set("UseItem.InventorySlot.FreeSlot", UseItem_InventorySlot_FreeSlot, yamlConfiguration);

        set("UseItem.Item.Material", UseItem_Material, yamlConfiguration);
        set("UseItem.Item.PlayerHead.Enable", UseItem_PlayerHead_Enable, yamlConfiguration);
        set("UseItem.Item.PlayerHead.PlayerWhoHasOpenedTheGUI", UseItem_PlayerWhoHasOpenedTheGUI, yamlConfiguration);
        set("UseItem.Item.PlayerHead.Playername", UseItem_PlayerName, yamlConfiguration);
        set("UseItem.Item.Name", UseItem_Name, yamlConfiguration);
        set("UseItem.Item.Lore", UseItem_Lore, yamlConfiguration);
        set("UseItem.Join.GiveOnEveryJoin", UseItem_GiveOnEveryJoin, yamlConfiguration);
        set("UseItem.Join.GiveOnFirstJoin", UseItem_GiveOnFirstJoin, yamlConfiguration);
        set("UseItem.Join.Cursor.ToGUIItem.OnEveryLogin", Cursor_ToGUIItem_OnLogin, yamlConfiguration);
        set("UseItem.Join.Cursor.ToGUIItem.OnFirstLogin", Cursor_ToGUIItem_OnFirstLogin, yamlConfiguration);
        set("UseItem.Join.Cursor.ToGUIItem.EXPERIMENTELL_ServerChhange", Cursor_ServerChange_EXPERIMENTELL, yamlConfiguration);

        yamlConfiguration.options().pathSeparator();
        set("Sound.Enable", true, yamlConfiguration);
        set("Sound.", true, yamlConfiguration);

        set("Sound.OpenInventory.Enable", Sound_Enable, yamlConfiguration);
        if (Main.minecraft1_8){
            set("Sound.OpenInventory.Sound",  Sound_OpenInventory_1_8, yamlConfiguration);
        } else  set("Sound.OpenInventory.Sound", Sound_OpenInventory_ab_1_9, yamlConfiguration);

        set("Sound.Click.Enable", Sound_Click_Enable, yamlConfiguration);
        if (Main.minecraft1_8) {
            set("Sound.Click.Sound", Sound_Click_1_8, yamlConfiguration);
        }else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            set("Sound.Click.Sound", Sound_Click_1_9_bis_1_12, yamlConfiguration);
        }else set("Sound.Click.Sound", Sound_Click_ab_1_13, yamlConfiguration);

        set("Sound.NoMoney.Enable", Sound_NoMoney_Enable, yamlConfiguration);
        if (Main.minecraft1_8) {
            set("Sound.NoMoney.Sound", Sound_NoMoney_1_8, yamlConfiguration);
        }else if (Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            set("Sound.NoMoney.Sound", Sound_NoMoney_1_9_bis_1_12, yamlConfiguration);
        }else set("Sound.NoMoney.Sound", Sound_NoMoney_ab_1_13, yamlConfiguration);

        try {
            yamlConfiguration.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        send.Console(Main.Prefix + " §2config.yml were successfully created / updated.");
    }

    private static void set(String path, String value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }

    private static void set(String path, Integer value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }

    private static void set(String path, Boolean value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }

    private static void set(String path, List value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
