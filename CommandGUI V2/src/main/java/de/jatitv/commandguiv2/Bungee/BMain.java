package de.jatitv.commandguiv2.Bungee;

import net.md_5.bungee.api.plugin.Plugin;

public final class BMain extends Plugin {
    private static Plugin plugin;

    public static String Prefix = "§8[§4C§9GUI§8]";

    public static String Version;
    public static String Autor;
    public static Integer SpigotID = 90671;
    public static Integer BstatsID = 10840;
    public static String Spigot = "https://www.spigotmc.org/resources/" + SpigotID;
    public static String Discord = "https://discord.gg/vRyXFFterJ";

    @Override
    public void onEnable() {
        // Plugin startup logic
        Long long_ = Long.valueOf(System.currentTimeMillis());
        plugin = this;
        Autor = plugin.getDescription().getAuthor();
        Version = plugin.getDescription().getVersion();
        Bsend.console(Prefix + "§4============================= §8[§4Command§9GUI§5BUNGEE§8] §4=============================");
        Bsend.console(Prefix + "§4   _____ §9_____ _    _ _____ §e   ___  ");
        Bsend.console(Prefix + "§4  / ____§9/ ____| |  | |_   _|§e  |__ \\ ");
        Bsend.console(Prefix + "§4 | |   §9| |  __| |  | | | |§e_   __ ) |");
        Bsend.console(Prefix + "§4 | |   §9| | |_ | |  | | | §e\\ \\ / // / ");
        Bsend.console(Prefix + "§4 | |___§9| |__| | |__| |_| |§e\\ V // /_ ");
        Bsend.console(Prefix + "§4  \\_____§9\\_____|\\____/|_____§e\\_/|____|");
        Bsend.console(Prefix);
        Bsend.console(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", ""));
        Bsend.console(Prefix + " §2Version: §6" + Version);
        Bsend.console(Prefix + " §2Spigot: §6" + Spigot);
        Bsend.console(Prefix + " §2Discord: §6" + Discord);


        plugin.getProxy().registerChannel("commandgui:bungee");
        plugin.getProxy().getPluginManager().registerListener(plugin, new BListener());

        BMetrics metrics = new BMetrics(this, BstatsID);

        Bsend.console(Prefix + " §2Plugin loaded successfully." + " §7- §e" + (System.currentTimeMillis() - long_.longValue()) + "ms");
        Bsend.console(Prefix + "§4==============================================================================");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bsend.console(Prefix + "§4============================= §8[§4Command§9GUI§5BUNGEE§8] §4=============================");
        Bsend.console(Prefix + " §2Autor: §6" + String.valueOf(Autor).replace("[", "").replace("]", "") );
        Bsend.console(Prefix + " §2Version: §6" + Version);
        Bsend.console(Prefix + " §2Spigot: §6" + Spigot);
        Bsend.console(Prefix + " §2Discord: §6" + Discord);
        Bsend.console(Prefix + " §4Plugin successfully disabled.");
        Bsend.console(Prefix + "§4==============================================================================");
    }
}
