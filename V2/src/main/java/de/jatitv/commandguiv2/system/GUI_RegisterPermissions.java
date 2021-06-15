package de.jatitv.commandguiv2.system;

import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.Objekte.GUI_Slot;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public class GUI_RegisterPermissions {
    public static void onPermRegister() {
        for (GUI_Objekt gui : Main.guiHashMap.values()) {
            for (GUI_Slot slot : gui.GUI_Slots) {
                if (Bukkit.getPluginManager().getPermission("commandgui." + gui.Command_Command + ".slot." + (slot.Slot  + 1)) == null) {
                    Bukkit.getPluginManager().addPermission(new Permission("commandgui." + gui.Command_Command + ".slot." + (slot.Slot  + 1)));
                }
            }
        }
    }
}
