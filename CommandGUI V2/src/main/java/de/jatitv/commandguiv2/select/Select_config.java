package de.jatitv.commandguiv2.select;

import de.jatitv.commandguiv2.system.Main;
import de.jatitv.commandguiv2.system.Replace;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.List;

public class Select_config {

    public static String language;
    public static String Currency;

    public static String Storage;

    public static Boolean Bungee;
    public static String thisServer;

    public static String DefaultGUI;

    public static Boolean UseItem_Enable;
    public static Boolean UseItem_AllowToggle;
    public static Boolean UseItem_GiveOnEveryJoin;
    public static Boolean UseItem_GiveOnFirstJoin;
    public static Boolean UseItem_ServerChange;
    public static Boolean Cursor_ToGUIItem_OnLogin;
    public static Boolean Cursor_ToGUIItem_OnFirstLogin;
    public static Boolean UseItem_BlockMoveAndDrop;
    public static String UseItem_OpenGUI;
    public static Boolean UseItem_Permission;
    public static Boolean UseItem_InventorySlot_FreeSlot;
    public static Integer UseItem_InventorySlot;
    public static Boolean UseItem_InventorySlotEnforce;
    public static String UseItem_Material;
    public static Boolean UseItem_PlayerHead_Enable;
    public static Boolean UseItem_PlayerWhoHasOpenedTheGUI;
    public static String UseItem_PlayerName;
    public static String UseItem_Name;
    public static List UseItem_Lore;

    public static void onSelect() {
        File config = new File(Main.getPath(), "config.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        language = yamlConfiguration.getString("Plugin.language");
        Currency = yamlConfiguration.getString("Plugin.Currency");

        Storage = yamlConfiguration.getString("Storage");

        Bungee = yamlConfiguration.getBoolean("BungeeCord.Enable");
        thisServer = yamlConfiguration.getString("BungeeCord.thisServer");

        DefaultGUI = yamlConfiguration.getString("GUI.DefaultGUI");

        UseItem_Enable = yamlConfiguration.getBoolean("UseItem.Enable");
        UseItem_AllowToggle = yamlConfiguration.getBoolean("UseItem.AllowToggle");
        UseItem_GiveOnEveryJoin = yamlConfiguration.getBoolean("UseItem.Join.GiveOnEveryJoin");
        UseItem_GiveOnFirstJoin = yamlConfiguration.getBoolean("UseItem.Join.GiveOnFirstJoin");
        UseItem_ServerChange = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.ServerChange");
        Cursor_ToGUIItem_OnLogin = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.OnLogin");
        Cursor_ToGUIItem_OnFirstLogin = yamlConfiguration.getBoolean("UseItem.Join.Cursor.ToGUIItem.OnFirstLogin");
        UseItem_BlockMoveAndDrop = yamlConfiguration.getBoolean("UseItem.BlockMoveAndDrop");
        UseItem_OpenGUI = yamlConfiguration.getString("UseItem.OpenGUI");
        UseItem_Permission = yamlConfiguration.getBoolean("UseItem.Permission.NeededToUse");
        UseItem_InventorySlot_FreeSlot = yamlConfiguration.getBoolean("UseItem.InventorySlot.FreeSlot");
        UseItem_InventorySlot = yamlConfiguration.getInt("UseItem.InventorySlot.Slot");
        UseItem_InventorySlotEnforce = yamlConfiguration.getBoolean("UseItem.InventorySlot.SlotEnforce");
        UseItem_Material = yamlConfiguration.getString("UseItem.Item.Material").toUpperCase();
        UseItem_PlayerHead_Enable = yamlConfiguration.getBoolean("UseItem.Item.PlayerHead.Enable");
        UseItem_PlayerWhoHasOpenedTheGUI = yamlConfiguration.getBoolean("UseItem.Item.PlayerHead.PlayerWhoHasOpenedTheGUI");
        UseItem_PlayerName = yamlConfiguration.getString("UseItem.Item.PlayerHead.PlayerName");
        UseItem_Name = Replace.replace(yamlConfiguration.getString("UseItem.Name"));
        UseItem_Lore = yamlConfiguration.getList("UseItem.Lore");
    }
}
