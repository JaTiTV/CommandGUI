package de.jatitv.commandguiv2.Objekte;

import de.jatitv.commandguiv2.cmdManagement.GUI_CmdExecuter_GUI;
import de.jatitv.commandguiv2.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GUI_Obj_Select {
    public static void onSelect() {
        Main.guiHashMap.clear();
        File f = new File(Main.getPath() + "/GUIs/");
        File[] fileArray = f.listFiles();

        for (File config_gui : fileArray) {
            String sub = config_gui.getName().substring(config_gui.getName().length() - 4);
            if (sub.equals(".yml")) {
                YamlConfiguration yamlConfiguration_gui = YamlConfiguration.loadConfiguration(config_gui);

                Boolean GUI_Enable = yamlConfiguration_gui.getBoolean("GUI.Enable");
                Integer GUI_Lines = yamlConfiguration_gui.getInt("GUI.Lines");
                if (yamlConfiguration_gui.getInt("GUI.Lines") > 6) {
                    yamlConfiguration_gui.set("GUI.Lines", 6);
                }
                if (yamlConfiguration_gui.getInt("GUI.Lines") < 1) {
                    yamlConfiguration_gui.set("GUI.Lines", 1);
                }
                String GUI_Name = yamlConfiguration_gui.getString("GUI.Name");
                Boolean GUI_FillItem_Enable = yamlConfiguration_gui.getBoolean("GUI.FillItem.Enable");
                String GUI_FillItem_Item;
                if (Main.minecraft1_8 || Main.minecraft1_9 || Main.minecraft1_10 || Main.minecraft1_11 || Main.minecraft1_12) {
                    GUI_FillItem_Item = yamlConfiguration_gui.getString("GUI.FillItem.GlassPaneCollor");
                } else GUI_FillItem_Item = yamlConfiguration_gui.getString("GUI.FillItem.Item");


                Boolean Command_Alias_Enable = yamlConfiguration_gui.getBoolean("Command.Alias");
                Boolean Command_Permission = yamlConfiguration_gui.getBoolean("Command.Permission.Required");

                ArrayList<GUI_Slot> slots = new ArrayList<>();
                for (String key : yamlConfiguration_gui.getConfigurationSection("Slots").getKeys(false)) {
                    GUI_Slot slot = new GUI_Slot(yamlConfiguration_gui.getInt("Slots." + key + ".Slot") - 1,
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Enable"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Item.PlayerHead.Enable"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Item.PlayerHead.Base64.Enable"),
                            yamlConfiguration_gui.getString("Slots." + key + ".Item.PlayerHead.Base64.Base64Value"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Item.PlayerHead.PlayerWhoHasOpenedTheGUI"),
                            yamlConfiguration_gui.getString("Slots." + key + ".Item.PlayerHead.PlayerName"),
                            yamlConfiguration_gui.getString("Slots." + key + ".Item.Material"),
                            yamlConfiguration_gui.getString("Slots." + key + ".Item.Name"),
                            yamlConfiguration_gui.getList("Slots." + key + ".Item.Lore"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".CustomSound.Enable"),
                            yamlConfiguration_gui.getString("Slots." + key + ".CustomSound.Sound"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Cost.Enable"),
                            yamlConfiguration_gui.getDouble("Slots." + key + ".Cost.Price"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Command.Enable"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Command.CommandAsConsole"),
                            yamlConfiguration_gui.getStringList("Slots." + key + ".Command.Command"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".OpenGUI.Enable"),
                            yamlConfiguration_gui.getString("Slots." + key + ".OpenGUI.GUI"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Message.Enable"),
                            yamlConfiguration_gui.getStringList("Slots." + key + ".Message.Message"),
                            yamlConfiguration_gui.getBoolean("Slots." + key + ".Permission.Required"));
                    slots.add(slot);
                    Main.allAliases.add(config_gui.getName().replace(".yml", ""));
                }
                GUI_Objekt objekt = new GUI_Objekt(GUI_Enable, GUI_Lines, GUI_Name, GUI_FillItem_Enable, GUI_FillItem_Item,
                        config_gui.getName().replace(".yml", ""), Command_Alias_Enable, Command_Permission, slots);
                Main.guiHashMap.put(config_gui.getName().replace(".yml", ""), objekt);
                GUI_CmdExecuter_GUI.arg1.put(config_gui.getName().replace(".yml", ""), "commandgui.gui." + config_gui.getName().replace(".yml", ""));

                try {
                    yamlConfiguration_gui.save(config_gui);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
