package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.Objekt;
import de.jatitv.commandguiv2.Spigot.Objekte.Slot;
import org.bukkit.Bukkit;
import org.bukkit.permissions.Permission;

public class RegisterPermissions {
    public static void onPermRegister() {
        for (Objekt gui : Main.guiHashMap.values()) {
            if (Bukkit.getPluginManager().getPermission("commandgui.command." + gui.Command_Command) == null) {
                Bukkit.getPluginManager().addPermission(new Permission("commandgui.command." + gui.Command_Command));
            }
            for (Slot slot : gui.GUI_Slots) {
                if (Bukkit.getPluginManager().getPermission("commandgui." + gui.Command_Command + ".slot." + (slot.Slot  + 1)) == null) {
                    Bukkit.getPluginManager().addPermission(new Permission("commandgui." + gui.Command_Command + ".slot." + (slot.Slot  + 1)));
                }
            }
        }
    }
}
