// This claas was created by JaTiTV


package de.jatitv.commandgui.system;

import de.jatitv.commandgui.defultValue.DefaultValue;
import org.bukkit.Bukkit;

public class Disable {

    public static void disableSend(String version){
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-----------------------------------------------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4  _____ §9_____ _    _ _____");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4 / ____§9/ ____| |  | |_   _|");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |   §9| |  __| |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |   §9| | |_ | |  | | | |");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4| |___§9| |__| | |__| |_| |_");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2  §4 \\_____§9\\_____|\\____/|_____|");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Autor: §6JaTiTV");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Version: §6" + version);
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§2");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§8-------------------------------");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4Plugin successfully disabled.");
        Bukkit.getConsoleSender().sendMessage(DefaultValue.PrefixHC + "§4-----------------------------------------------------------------------------------");
    }

}
