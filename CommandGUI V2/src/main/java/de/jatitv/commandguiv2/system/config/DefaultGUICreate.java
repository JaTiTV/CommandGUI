package de.jatitv.commandguiv2.system.config;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class DefaultGUICreate {

    private static Boolean GUI_Enable = true;
    private static Integer GUI_Lines = 1;
    private static String GUI_Name = "&5default &9GUI";
    private static Boolean GUI_FillItem_Enable = true;
    private static Integer  GUI_FillItem_Item_1_8 = 15;
    private static String  GUI_FillItem_Item = "BLACK_STAINED_GLASS_PANE";

    private static Boolean Command_Alias = true;
    private static Boolean Command_Permission = true;

    private static Integer slot = 5;
    private static Boolean enable= true;
    private static Boolean Playerhead_enable = true;
    private static Boolean base64_Enable = true;
    private static String  base64value = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzg3M2MxMmJmZmI1MjUxYTBiODhkNWFlNzVjNzI0N2NiMzlhNzVmZjFhODFjYmU0YzhhMzliMzExZGRlZGEifX19";
    private static Boolean PlayerWhoHasOpenedTheGUI = false;
    private static String PlayerName = "";
    private static String Item = "";
    private static String Itemname = "&3Support Discord";
    private static List ItemLore = Arrays.asList(
            "&8-----------------",
            "&bIf you need help setting up the plugin,",
            "&bfeel free to contact me on the Suport Discord.",
            "&8-----------------",
            "&eIf you find any errors or bugs,",
            "&eplease contact me so I can fix them.",
            "&8-----------------",
            "&5Discord: §7https://discord.gg/vRyXFFterJ");
    private static Boolean CustomSound =false;
    private static String CustomSound_Sound ="";
    private static Boolean Cost = false;
    private static Double Cost_Price = 0.0;
    private static Boolean Command = false;
    private static Boolean CommandAsConsole = false;
    private static List Commands = Arrays.asList("");
    private static Boolean OpenGUI = false;
    private static String OpenGUI_GUI = "";
    private static Boolean Message = true;
    private static List Messages = Arrays.asList("&6You can find more information on Discord: &ehttps://discord.gg/vRyXFFterJ");
    private static Boolean Permission = false;



    public static void configCreate() {
        Long long_ = Long.valueOf(System.currentTimeMillis());
        send.console(Main.Prefix + " §4Default GUI file (GUIs/default.yml) is loaded...");

        File config = new File(Main.getPath(), "GUIs/default.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);

        set("GUI.Enable", GUI_Enable, yamlConfiguration);
        set("GUI.Lines", GUI_Lines, yamlConfiguration);
        set("GUI.Name", GUI_Name, yamlConfiguration);
        set("GUI.FillItem.Enable", GUI_FillItem_Enable, yamlConfiguration);
        if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            set("GUI.FillItem.GlassPaneCollor", GUI_FillItem_Item_1_8, yamlConfiguration);
        } else set("GUI.FillItem.Item", GUI_FillItem_Item, yamlConfiguration);

        set("Command.Alias", Command_Alias, yamlConfiguration);
        set("Command.Permission.Required", Command_Permission, yamlConfiguration);
        set("Slots.Example.Slot", slot, yamlConfiguration);
        set("Slots.Example.Enable", enable, yamlConfiguration);
        if (!(Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12)) {
            set("Slots.Example.Item.PlayerHead.Enable", Playerhead_enable, yamlConfiguration);
            set("Slots.Example.Item.PlayerHead.Base64.Enable", base64_Enable, yamlConfiguration);
            set("Slots.Example.Item.PlayerHead.Base64.Base64Value", base64value, yamlConfiguration);
            set("Slots.Example.Item.PlayerHead.PlayerWhoHasOpenedTheGUI", PlayerWhoHasOpenedTheGUI, yamlConfiguration);
            set("Slots.Example.Item.PlayerHead.PlayerName", PlayerName, yamlConfiguration);
        }
        if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
            set("Slots.Example.Item.Material", "TNT", yamlConfiguration);
        } else set("Slots.Example.Item.Material", Item, yamlConfiguration);
        set("Slots.Example.Item.Name", Itemname, yamlConfiguration);
        set("Slots.Example.Item.Lore", ItemLore, yamlConfiguration);
        set("Slots.Example.CustomSound.Enable", CustomSound, yamlConfiguration);
        set("Slots.Example.CustomSound.Sound", CustomSound_Sound, yamlConfiguration); //ToDo Deaktivierbar für einzelne Slots
        set("Slots.Example.Cost.Enable", Cost, yamlConfiguration);
        set("Slots.Example.Cost.Price", Cost_Price, yamlConfiguration);
        set("Slots.Example.Command.Enable", Command, yamlConfiguration);
        set("Slots.Example.Command.CommandAsConsole", CommandAsConsole, yamlConfiguration);
        set("Slots.Example.Command.Command", Commands, yamlConfiguration);
        set("Slots.Example.OpenGUI.Enable", OpenGUI, yamlConfiguration);
        set("Slots.Example.OpenGUI.GUI", OpenGUI_GUI, yamlConfiguration);
        set("Slots.Example.Message.Enable", Message, yamlConfiguration);
        set("Slots.Example.Message.Message", Messages, yamlConfiguration);
        set("Slots.Example.Permission.Required", Permission, yamlConfiguration);

        try {
            yamlConfiguration.save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }

        send.console(Main.Prefix + " §2Default GUI file (GUIs/default.yml) was loaded." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
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
    private static void set(String path, Double value, YamlConfiguration config) {
        if (!config.contains(path)) {
            config.set(path, value);
        }
    }
}
