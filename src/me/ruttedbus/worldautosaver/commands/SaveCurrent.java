package me.ruttedbus.worldautosaver.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveCurrent implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("worldautosaver.commands.savecurrent")) {
			if(sender instanceof Player) {
				Player p = (Player) sender;
				World toSave = p.getWorld();
				toSave.save();
				p.sendMessage(ChatColor.GOLD + toSave.getName() + " saved.");
			}
			else {
				sender.sendMessage(ChatColor.RED + "Cannot execute this command from console!");
			}
		}
		else {
			sender.sendMessage("You do not have permission to execute this command!");
		}
		return true;
	}
}
