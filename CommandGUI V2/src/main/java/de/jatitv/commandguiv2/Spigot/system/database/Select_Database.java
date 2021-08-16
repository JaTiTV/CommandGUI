package de.jatitv.commandguiv2.Spigot.system.database;

import de.jatitv.commandguiv2.Spigot.system.config.config.SelectConfig;
import org.bukkit.entity.Player;

public class Select_Database {

    public static void nameCheck(Player player) {
        if (SelectConfig.Storage.equals("MYSQL")) {

            MySQL.query("UPDATE `gui-item` SET Name='" + player.getName() + "' WHERE  UUID='" + player.getUniqueId() + "';");
            if (SelectConfig.Bungee) {
                MySQL.query("UPDATE `gui-onlineplayer` SET Name='" + player.getName() + "' WHERE  UUID='" + player.getUniqueId() + "';");
            }
        }
    }

    public static void setSlot(Player player, Integer slot) {
        if (SelectConfig.Storage.equals("MYSQL")) {
            MySQL.query("INSERT INTO `gui-item` (`UUID`, `Name`, `Slot`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                    + "','" + slot + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Slot` = '" + slot + "';");
        } else {
            YML.setGuiitemSlot(player, slot);
        }
    }

    public static void setItemStatusTrue(Player player) {
        if (SelectConfig.Storage.equals("MYSQL")) {
            MySQL.query("INSERT INTO `gui-item` (`UUID`, `Name`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                    + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '1';");
        } else {
            YML.setGuiitemOn(player);
        }
    }

    public static void setItemStatusFalse(Player player) {
        if (SelectConfig.Storage.equals("MYSQL")) {

            MySQL.query("INSERT INTO `gui-item` (`UUID`, `Name`, `Status`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                    + "', '0') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '0';");
        } else {
            YML.setGuiitemOff(player);
        }
    }

    public static Boolean selectItemStatus(Player player) {
        if (SelectConfig.Storage.equals("MYSQL")) {
            if (MySQL.count("SELECT * FROM `gui-item` WHERE BINARY UUID='" + player.getUniqueId() + "'") > 0) {
                if (MySQL.select("SELECT `Status` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("1")) {
                    return true;
                } else return false;
            } else {
                return true;
            }
        } else {
            return YML.selectGuiitemOn(player);
        }
    }

    public static Integer selectSlot(Player player) {
        if (SelectConfig.Storage.equals("MYSQL")) {
            if (MySQL.count("SELECT * FROM `gui-item` WHERE BINARY UUID='" + player.getUniqueId() + "'") > 0) {
                if (MySQL.select("SELECT `Slot` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';") != "null") {
                    return Integer.valueOf(MySQL.select("SELECT `Slot` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';"));
                } else return null;
            } else return null;

        } else {
            return YML.selectSlot(player);
        }
    }

}
