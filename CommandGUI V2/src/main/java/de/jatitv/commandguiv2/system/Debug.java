package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.database.MySQL;
import org.bukkit.Bukkit;

import java.io.File;

public class Debug {
    public static void debugmsg() {
        send.debug("§5----------------------------------");
        send.debug("§3BukkitVersion: §e" + Bukkit.getBukkitVersion());
        send.debug("§3Version: §e" + Bukkit.getVersion());
        send.debug("§3Java: §e" + System.getProperty("java.version"));
        send.debug(String.valueOf(Bukkit.getServer().getWorlds()));
        send.debug("§5----------------------------------");
        File f = new File(String.valueOf(Main.getPath()));
        File f2 = new File(String.valueOf(Main.getPath() + "/GUIs/") );
        File f3 = new File(String.valueOf(Main.getPath()+ "/languages/"));
        File[] fileArray = f.listFiles();
        File[] fileArray2 = f2.listFiles();
        File[] fileArray3 = f3.listFiles();
        for (File config : fileArray) {
            send.debug(String.valueOf(config).replace("plugins/CommandGUI/", ""));
        }
        for (File config2: fileArray2) {
            send.debug(String.valueOf(config2).replace("plugins/CommandGUI/", ""));
        }
        for (File config3 : fileArray3) {
            send.debug(String.valueOf(config3).replace("plugins/CommandGUI/", ""));
        }
        send.debug("§5----------------------------------");

    }

    public static void debugconfig() {
        send.debug("§5-------- §9Config §5--------");
        send.debug(String.valueOf(Select_config.UpdateCheckOnJoin));
        send.debug(String.valueOf(Select_config.Debug));
        send.debug(String.valueOf(Select_config.HelpAlias));
        send.debug(String.valueOf(Select_config.language));
        send.debug(String.valueOf(Select_config.Currency));
        send.debug(String.valueOf(Select_config.DefaultGUI));
        send.debug(String.valueOf(Select_config.Storage));
        send.debug(String.valueOf(MySQL.ip));
        send.debug(String.valueOf(MySQL.port));
        send.debug(String.valueOf(MySQL.database));
        send.debug(String.valueOf(MySQL.user));
        send.debug(String.valueOf(MySQL.password));
        send.debug(String.valueOf(MySQL.SSL));
        send.debug(String.valueOf(Select_config.Bungee));
        send.debug(String.valueOf(Select_config.thisServer));
        send.debug(String.valueOf(Select_config.UseItem_Enable));
        send.debug(String.valueOf(Select_config.UseItem_AllowToggle));
        send.debug(String.valueOf(Select_config.UseItem_BlockMoveAndDrop));
        send.debug(String.valueOf(Select_config.UseItem_OpenGUI));
        send.debug(String.valueOf(Select_config.UseItem_Permission));
        send.debug(String.valueOf(Select_config.UseItem_InventorySlot_FreeSlot));
        send.debug(String.valueOf(Select_config.UseItem_InventorySlot));
        send.debug(String.valueOf(Select_config.UseItem_InventorySlotEnforce));
        send.debug(String.valueOf(Select_config.UseItem_Material));
        send.debug(String.valueOf(Select_config.UseItem_PlayerHead_Enable));
        send.debug(String.valueOf(Select_config.UseItem_PlayerWhoHasOpenedTheGUI));
        send.debug(String.valueOf(Select_config.UseItem_PlayerName));
        send.debug(String.valueOf(Select_config.UseItem_Name));
        send.debug(String.valueOf(Select_config.UseItem_Lore));
        send.debug(String.valueOf(Select_config.UseItem_GiveOnEveryJoin));
        send.debug(String.valueOf(Select_config.UseItem_GiveOnlyOnFirstJoin));
        send.debug(String.valueOf(Select_config.UseItem_ServerChange));
        send.debug(String.valueOf(Select_config.Cursor_ToGUIItem_OnLogin));
        send.debug(String.valueOf(Select_config.Cursor_ToGUIItem_OnlyOnFirstLogin));
        send.debug(String.valueOf(Select_config.Sound_Enable));
        send.debug(String.valueOf(Select_config.Sound_OpenInventory_Enable));
        send.debug(String.valueOf(Select_config.Sound_OpenInventory_input));
        send.debug(String.valueOf(Select_config.Sound_Click_Enable));
        send.debug(String.valueOf(Select_config.Sound_Click_input));
        send.debug(String.valueOf(Select_config.Sound_NoMoney_Enable));
        send.debug(String.valueOf(Select_config.Sound_NoMoney_input));
        send.debug("§5----------------------------------");

    }
}
