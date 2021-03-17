// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.DefultValue;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Reload {

    public static void reloadConfirmPlayer(Player player) throws InterruptedException {
        player.sendMessage(DefultValue.PrefixHC + "Reload");





    }


    public static void reloadConfirmConsole() throws InterruptedException {
        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "Reload");
    }
}
