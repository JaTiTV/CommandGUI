package de.jatitv.commandguiv2.system.database;

import de.jatitv.commandguiv2.system.config.select.Select_config;
import org.bukkit.entity.Player;

public class Select_Database {
    public static Boolean itemStatus(Player player){
        if (Select_config.Storage.equals("MySQL")){
            if (MySQL.select("SELECT `Status` FROM `gui-item` WHERE  `UUID`='" + player.getUniqueId() + "';").equals("1")){
                return true;
            } else return false;
        } else {
            return YML.isguiitemOn(player);
        }
    }

    public static void setItemStatusTrue(Player player){
        if (Select_config.Storage.equals("MySQL")){
            MySQL.query("INSERT INTO `gui-item` (`UUID`, `Name`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                    + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '1';");
        }else{
            YML.guiitemOn(player);
        }
    }

    public static void setItemStatusFalse(Player player){
        if (Select_config.Storage.equals("MySQL")){
            MySQL.query("INSERT INTO `gui-item` (`UUID`, `Name`) VALUES ('" + player.getUniqueId() + "', '" + player.getName()
                    + "') ON DUPLICATE KEY UPDATE `Name` = '" + player.getName() + "', `Status` = '0';");
        } else{
            YML.guiitemOff(player);
        }
    }
}
