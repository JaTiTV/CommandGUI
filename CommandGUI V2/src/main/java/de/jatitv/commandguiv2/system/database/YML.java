package de.jatitv.commandguiv2.system.database;

import de.jatitv.commandguiv2.Main;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class YML {

    public static File storage = new File(Main.getPath(), "Storage/gui-item.yml");
    public static YamlConfiguration yamlConfigurationStorage = YamlConfiguration.loadConfiguration(storage);

    public static void guiitemOn(Player player) {
        yamlConfigurationStorage.set(player.getUniqueId() + ".Playername", player.getName());
        yamlConfigurationStorage.set(player.getUniqueId() + ".Status", true);

        try {
            yamlConfigurationStorage.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guiitemOff(Player player) {
        yamlConfigurationStorage.set(player.getUniqueId() + ".Playername", player.getName());
        yamlConfigurationStorage.set(player.getUniqueId() + ".Status", false);

        try {
            yamlConfigurationStorage.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean isguiitemOn(Player player){
        if (!yamlConfigurationStorage.contains(String.valueOf(player.getUniqueId()))) return true;
        return yamlConfigurationStorage.getBoolean(player.getUniqueId() + ".Status");
    }
}
