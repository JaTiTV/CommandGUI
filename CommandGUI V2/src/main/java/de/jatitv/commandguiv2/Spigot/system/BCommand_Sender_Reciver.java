package de.jatitv.commandguiv2.Spigot.system;

import de.jatitv.commandguiv2.Spigot.Main;
import org.bukkit.Bukkit;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class BCommand_Sender_Reciver {

    public static void sendToBungee(String channel, String information) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        DataOutputStream output = new DataOutputStream(stream);
        try {
            output.writeUTF(channel);
            output.writeUTF(information);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bukkit.getServer().sendPluginMessage(Main.plugin, "commandgui:bungee", stream.toByteArray());
    }

}
