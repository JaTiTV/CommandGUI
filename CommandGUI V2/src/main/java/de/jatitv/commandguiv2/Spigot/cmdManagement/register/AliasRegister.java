package de.jatitv.commandguiv2.Spigot.cmdManagement.register;

import de.jatitv.commandguiv2.Spigot.Main;
import de.jatitv.commandguiv2.Spigot.system.send;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import java.io.File;


public class AliasRegister {
    public static void onRegister() {
        Plugin plugin = Main.plugin;
        send.debug(plugin, Bukkit.getServer().getClass().getPackage().getName());
        File f = new File(Main.getPath() + "/GUIs/");
        File[] fileArray = f.listFiles();
        if (Main.allAliases.toString().equals("[]")){
            send.console(Main.Prefix + " §4No GUI files available");
            return;
        }
        for (String alias : Main.allAliases) {
            if (Main.guiHashMap.get(alias) != null) {
                if (Main.guiHashMap.get(alias).Command_Alias_Enable) {
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_8_R1")) {
                        send.debug(plugin, "Alias register 1.8_R1");
                        org.bukkit.craftbukkit.v1_8_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_8_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_8_R2")) {
                        send.debug(plugin, "Alias register 1.8_R2");
                        org.bukkit.craftbukkit.v1_8_R2.CraftServer craftServer = (org.bukkit.craftbukkit.v1_8_R2.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_8_R3")) {
                        send.debug(plugin, "Alias register 1.8_R3");
                        org.bukkit.craftbukkit.v1_8_R3.CraftServer craftServer = (org.bukkit.craftbukkit.v1_8_R3.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_9_R1")) {
                        send.debug(plugin, "Alias register 1.9_R1");
                        org.bukkit.craftbukkit.v1_9_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_9_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_9_R2")) {
                        send.debug(plugin, "Alias register 1.9_R2");
                        org.bukkit.craftbukkit.v1_9_R2.CraftServer craftServer = (org.bukkit.craftbukkit.v1_9_R2.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_10_R1")) {
                        send.debug(plugin, "Alias register 1.10_R1");
                        org.bukkit.craftbukkit.v1_10_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_10_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_11_R1")) {
                        send.debug(plugin, "Alias register 1.11_R1");
                        org.bukkit.craftbukkit.v1_11_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_11_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_12_R1")) {
                        send.debug(plugin, "Alias register 1.12_R1");
                        org.bukkit.craftbukkit.v1_12_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_12_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_13_R1")) {
                        send.debug(plugin, "Alias register 1.13_R1");
                        org.bukkit.craftbukkit.v1_13_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_13_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_13_R2")) {
                        send.debug(plugin, "Alias register 1.13_R2");
                        org.bukkit.craftbukkit.v1_13_R2.CraftServer craftServer = (org.bukkit.craftbukkit.v1_13_R2.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_14_R1")) {
                        send.debug(plugin, "Alias register 1.14_R1");
                        org.bukkit.craftbukkit.v1_14_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_14_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_15_R1")) {
                        send.debug(plugin, "Alias register 1.15_R1");
                        org.bukkit.craftbukkit.v1_15_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_15_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_16_R1")) {
                        send.debug(plugin, "Alias register 1.16_R1");
                        org.bukkit.craftbukkit.v1_16_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_16_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_16_R2")) {
                        send.debug(plugin, "Alias register 1.16_R2");
                        org.bukkit.craftbukkit.v1_16_R2.CraftServer craftServer = (org.bukkit.craftbukkit.v1_16_R2.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_16_R3")) {
                        send.debug(plugin, "Alias register 1.16_R3");
                        org.bukkit.craftbukkit.v1_16_R3.CraftServer craftServer = (org.bukkit.craftbukkit.v1_16_R3.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_17_R1")) {
                        send.debug(plugin, "Alias register 1.17_R1");
                        org.bukkit.craftbukkit.v1_17_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_17_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_17_R2")) {
                        send.debug(plugin, "Alias register 1.17_R2");
                        org.bukkit.craftbukkit.v1_17_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_17_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                    if (Bukkit.getServer().getClass().getPackage().getName().contains("1_17_R3")) {
                        send.debug(plugin, "Alias register 1.17_R3");
                        org.bukkit.craftbukkit.v1_17_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_17_R1.CraftServer) plugin.getServer();
                        craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    }
                }

            }
        }
    }
}
