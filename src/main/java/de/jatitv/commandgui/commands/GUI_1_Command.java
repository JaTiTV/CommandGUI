// This claas was created by JaTiTV


package de.jatitv.commandgui.commands;

import de.jatitv.commandgui.defultValue.DefultValue;
import de.jatitv.commandgui.defultValue.DefultValue_GUI_1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GUI_1_Command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length == 0) {
                if (!DefultValue_GUI_1.Command_Permission_Enable || player.hasPermission("commandgui.command.gui1") || player.hasPermission("commandgui.admin") || player.isOp()) {
                    if (DefultValue_GUI_1.GUI_Enable || player.hasPermission("commandgui.admin") || player.isOp()) {
                        GUI_1.openCGUI(player);
                    } else {
                        player.sendMessage(DefultValue.GUIisDisable.replace("[gui]", DefultValue_GUI_1.GUIName));
                    }
                } else player.sendMessage(DefultValue.NoPermissionForCommand.replace("[cmd]", "/commandgui " + DefultValue_GUI_1.Command)
                        .replace("[perm]", "commandgui.command.gui1"));
            }
        } else {
            sender.sendMessage("§8[§6Command§9GUI§8] §cThis command is only for players!");
        }
        return false;
    }
}