package de.jatitv.commandguiv2.cmdManagement.register;


import de.jatitv.commandguiv2.Main;
import de.jatitv.commandguiv2.Objekte.GUI_Objekt;
import de.jatitv.commandguiv2.gui.GUI_GUI;
import de.jatitv.commandguiv2.system.config.select.Select_config;
import de.jatitv.commandguiv2.system.config.select.Select_msg;
import de.jatitv.commandguiv2.system.send;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RegisterCommand extends Command {
    private String alias;

    public RegisterCommand(String alias) {
        super(alias);
        this.alias = alias;
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            GUI_Objekt gui = Main.guiHashMap.get(alias);
            if (gui.GUI_Enable || player.hasPermission("commandgui.bypass")) {
                if (!gui.Command_Permission_Enable || player.hasPermission("commandgui.command." + gui) || player.hasPermission("commandgui.bypass")) {
                    send.console(String.valueOf(gui.Command_Permission_Enable));
                    GUI_GUI.openGUI(player, gui);
                    if (Select_config.Sound_Enable && Select_config.Sound_OpenInventory_Enable) {
                        player.playSound(player.getLocation(), Select_config.Sound_OpenInventory, 3, 1);
                    }
                } else player.sendMessage(Select_msg.NoPermissionForCommand.replace("[cmd]", "/commandgui " + args[0])
                        .replace("[perm]", "commandgui.command." + gui));
            } else player.sendMessage(Select_msg.GUIIsDisabled.replace("[gui]", gui.GUI_Name));
        } else sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
        return true;
    }
}

