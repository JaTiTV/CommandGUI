package de.jatitv.commandguiv2.Spigot.Listener;

import de.jatitv.commandguiv2.Spigot.Main;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class ServerChange {

    public static void send(Player player, String server){
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(b);
        try {
            out.writeUTF("Connect");
            out.writeUTF(server);
        } catch (IOException i) {
            i.printStackTrace();
        }
        player.sendPluginMessage(Main.plugin, "BungeeCord", b.toByteArray());
    }
}
