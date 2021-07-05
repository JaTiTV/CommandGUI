package de.jatitv.commandguiv2.Bungee;

import net.md_5.bungee.BungeeCord;

public class Bsend {
    public static void console(String msg) {
        BungeeCord.getInstance().getConsole().sendMessage(msg);
    }
}
