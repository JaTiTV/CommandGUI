package de.jatitv.commandguiv2.cmdManagement.register;

import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.system.send;

public class AliasRegister {

    public static void onregister() {
        for (String alias : Main.allAliases) {
            if (Main.guiHashMap.get(alias).Command_Alias_Enable) {
                if (Main.minecraft1_8){
                    org.bukkit.craftbukkit.v1_8_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_8_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.8");
                } else if (Main.minecraft1_9){
                    org.bukkit.craftbukkit.v1_9_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_9_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.9");
                }else if (Main.minecraft1_10){
                    org.bukkit.craftbukkit.v1_10_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_10_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.10");
                }else if (Main.minecraft1_11){
                    org.bukkit.craftbukkit.v1_11_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_11_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.11");
                } else if (Main.minecraft1_12){
                    org.bukkit.craftbukkit.v1_12_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_12_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.12");
                } else if (Main.minecraft1_13) {
                    org.bukkit.craftbukkit.v1_13_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_13_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.13");
                } else if (Main.minecraft1_14) {
                    org.bukkit.craftbukkit.v1_14_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_14_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.14");
                } else if (Main.minecraft1_15) {
                    org.bukkit.craftbukkit.v1_15_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_15_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.15");
                } else if (Main.minecraft1_16) {
                    org.bukkit.craftbukkit.v1_16_R3.CraftServer craftServer = (org.bukkit.craftbukkit.v1_16_R3.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.16");
                } else if (Main.minecraft1_17) {
                    org.bukkit.craftbukkit.v1_17_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_17_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                    send.debug("Alias register 1.17");
                }
            }
        }
    }
}
