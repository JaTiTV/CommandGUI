// This claas was created by JaTiTV


package de.jatitv.commandgui.config;

import de.jatitv.commandgui.DefultValue;
import de.jatitv.commandgui.Main;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Config {

    public static void configCreate() throws InterruptedException {

        File configYML = new File(Main.thisp().getDataFolder().getPath(), "Config.yml");
        YamlConfiguration yamlConfiguration_config = YamlConfiguration.loadConfiguration(configYML);

        Bukkit.getConsoleSender().sendMessage(DefultValue.PrefixHC + "§4Config.yml load...");

        if (!yamlConfiguration_config.contains("Do_not_remove_or_change.Created")) {
            yamlConfiguration_config.set("Do_not_remove_or_change.Created", "This file was created with version " + Main.getPlugin().getDescription().getVersion());
        }

        yamlConfiguration_config.set("Do_not_remove_or_change.Version", Main.getPlugin().getDescription().getVersion());

        yamlConfiguration_config.set("Do_not_remove_or_change.Autor", Main.Autor);

        yamlConfiguration_config.set("Do_not_remove_or_change.Spigot", Main.Spigot);

        yamlConfiguration_config.set("Do_not_remove_or_change.Discord", Main.Discord);

    }
}
