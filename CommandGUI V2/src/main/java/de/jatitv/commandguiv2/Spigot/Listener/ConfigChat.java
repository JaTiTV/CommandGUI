package de.jatitv.commandguiv2.Spigot.Listener;

import de.jatitv.commandguiv2.Spigot.Objekte.Slot;
import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.Objekte.Objekt;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;

public class ConfigChat implements Listener {
    public static HashMap<Player, String> EditChat = new HashMap<>();

    @EventHandler
    public void onChat(AsyncPlayerChatEvent playerChatEvent) {
        Player player = playerChatEvent.getPlayer();
        if (EditChat.containsKey(player)) {
            if (playerChatEvent.getMessage().equals("cancel")) {
                //player.sendMessage(DefaultValue.SettingsGUIchatIsCanceled.replace("[setting]", EditChat.get(player)));
            } else {
                for (Objekt gui : Main.guiHashMap.values()) {
                    for (Slot slot : gui.GUI_Slots) {
                        if (slot.ConfigOptionPath.equals(EditChat.get(player))) {


                        }
                    }
                }
            }
        }
    }
}
