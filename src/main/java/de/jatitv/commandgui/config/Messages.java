// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.DefultValue;
import de.jatitv.commandgui.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Messages {

    public static void messagesCreate() throws InterruptedException {


        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Messages.yml load...");


        File messagesYML = new File(Main.thisp().getDataFolder().getPath(), "Messages.yml");
        YamlConfiguration yamlConfiguration_msg = YamlConfiguration.loadConfiguration(messagesYML);


        if (!yamlConfiguration_msg.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_msg.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_msg.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_msg.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_msg.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_msg.set("Do_not_remove_or_change.Discord", Main.Discord);

    }
}
