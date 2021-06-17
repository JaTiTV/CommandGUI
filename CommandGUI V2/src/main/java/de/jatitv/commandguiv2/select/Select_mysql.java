package de.jatitv.commandguiv2.select;

import de.jatitv.commandguiv2.system.Database;
import de.jatitv.commandguiv2.system.Main;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Select_mysql {
    public static void onSelect(){

        File mysql = new File(Main.getPath(), "mysql.yml");
        YamlConfiguration yamlConfiguration_mysql = YamlConfiguration.loadConfiguration(mysql);

        Database.ip = yamlConfiguration_mysql.getString("MySQL.IP");
        Database.port = yamlConfiguration_mysql.getInt("MySQL.Port");
        Database.database = yamlConfiguration_mysql.getString("MySQL.Database");
        Database.user = yamlConfiguration_mysql.getString("MySQL.User");
        Database.password = yamlConfiguration_mysql.getString("MySQL.Password");
        Database.SSL = yamlConfiguration_mysql.getBoolean("MySQL.SSL");
    }
}
