package de.jatitv.commandguiv2.system.database;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class YML {

    public static File storage = new File(Main.getPath(), "Storage/gui-item.yml");
    public static YamlConfiguration yamlConfigurationStorage = YamlConfiguration.loadConfiguration(storage);

    public static void setGuiitemOn(Player player) {
        yamlConfigurationStorage.set(player.getUniqueId() + ".Playername", player.getName());
        yamlConfigurationStorage.set(player.getUniqueId() + ".Status", true);

        try {
            yamlConfigurationStorage.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGuiitemOff(Player player) {
        yamlConfigurationStorage.set(player.getUniqueId() + ".Playername", player.getName());
        yamlConfigurationStorage.set(player.getUniqueId() + ".Status", false);

        try {
            yamlConfigurationStorage.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setGuiitemSlot(Player player, Integer slot) {
        yamlConfigurationStorage.set(player.getUniqueId() + ".Playername", player.getName());
        yamlConfigurationStorage.set(player.getUniqueId() + ".Slot", slot);

        try {
            yamlConfigurationStorage.save(storage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Boolean selectGuiitemOn(Player player){
        if (!yamlConfigurationStorage.contains(String.valueOf(player.getUniqueId()))) return true;
        return yamlConfigurationStorage.getBoolean(player.getUniqueId() + ".Status");
    }


    public static Integer selectSlot(Player player) {
        send.debug("yml-1");
        if (!yamlConfigurationStorage.contains(String.valueOf(player.getUniqueId()))) return null;
        if (yamlConfigurationStorage.getString(player.getUniqueId() + ".Slot") == null) return null;
        send.debug("yml-2");
        send.debug(String.valueOf(yamlConfigurationStorage.getInt(player.getUniqueId() + ".Slot")));
        return yamlConfigurationStorage.getInt(player.getUniqueId() + ".Slot");
    }
}
