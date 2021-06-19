package de.jatitv.commandguiv2.cmdManagement.register;

import de.jatitv.commandguiv2.Main;

public class AliasRegister {

    public static void onregister() {
        for (String alias : Main.allAliases) {
            if (Main.guiHashMap.get(alias).Command_Alias_Enable) {
                if (Main.minecraft1_8){
                    org.bukkit.craftbukkit.v1_8_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_8_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_9){
                    org.bukkit.craftbukkit.v1_9_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_9_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                }else if (Main.minecraft1_10){
                    org.bukkit.craftbukkit.v1_10_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_10_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                }else if (Main.minecraft1_11){
                    org.bukkit.craftbukkit.v1_11_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_11_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_12){
                    org.bukkit.craftbukkit.v1_12_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_12_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_13) {
                    org.bukkit.craftbukkit.v1_13_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_13_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_14) {
                    org.bukkit.craftbukkit.v1_14_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_14_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_15) {
                    org.bukkit.craftbukkit.v1_15_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_15_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_16) {
                    org.bukkit.craftbukkit.v1_16_R3.CraftServer craftServer = (org.bukkit.craftbukkit.v1_16_R3.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                } else if (Main.minecraft1_17) {
                    org.bukkit.craftbukkit.v1_17_R1.CraftServer craftServer = (org.bukkit.craftbukkit.v1_17_R1.CraftServer) Main.getPlugin().getServer();
                    craftServer.getCommandMap().register(alias, new RegisterCommand(alias));
                }
            }
        }
    }
}
