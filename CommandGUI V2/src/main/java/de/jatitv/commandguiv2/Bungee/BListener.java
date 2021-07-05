package de.jatitv.commandguiv2.Bungee;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

public class BListener implements Listener {
    public static void hi(){
        Bsend.console("§5hi");
    }
    @EventHandler
    public void onPluginmessage(PluginMessageEvent event) {
        Bsend.console(event.getTag());
        if (event.getTag().equalsIgnoreCase("commandgui:bungee")) {

            DataInputStream stream = new DataInputStream(new ByteArrayInputStream(event.getData()));
            try {
                String channel = stream.readUTF();
                String input = stream.readUTF();
                ProxiedPlayer player = BungeeCord.getInstance().getPlayer(channel);


                if(player != null){
                    BungeeCord.getInstance().getPluginManager().dispatchCommand(player, input);

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
