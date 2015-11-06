package me.ruttedbus.worldautosaver.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Save implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("autosaver.command.save")) {
			if(Bukkit.getServer().getWorld(args[0]) != null) {
				Bukkit.getServer().getWorld(args[0]).save();
			}
			else {
				sender.sendMessage(ChatColor.RED + "Could not find existing world: " + args[0]);
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
		}
		return true;
	}
}