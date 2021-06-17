package de.jatitv.commandgui.system;

import de.jatitv.commandgui.commands.cmdManagement.RegisterCommands_GUI_1;
import de.jatitv.commandgui.commands.cmdManagement.RegisterCommands_GUI_2;
import de.jatitv.commandgui.commands.cmdManagement.RegisterCommands_GUI_3;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_1;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_2;
import de.jatitv.commandgui.defaultValue.DefaultValue_GUI_3;
import org.bukkit.craftbukkit.v1_13_R1.CraftServer;

public class CmdRegister_13 {
    public static void onregister(){
        ((CraftServer) Main.plugin.getServer()).getCommandMap().register(DefaultValue_GUI_1.Command, new RegisterCommands_GUI_1(DefaultValue_GUI_1.Command));
        ((CraftServer) Main.plugin.getServer()).getCommandMap().register(DefaultValue_GUI_2.Command, new RegisterCommands_GUI_2(DefaultValue_GUI_2.Command));
        ((CraftServer) Main.plugin.getServer()).getCommandMap().register(DefaultValue_GUI_3.Command, new RegisterCommands_GUI_3(DefaultValue_GUI_3.Command));
    }
}
