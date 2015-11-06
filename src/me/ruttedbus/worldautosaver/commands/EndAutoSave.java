package me.ruttedbus.worldautosaver.commands;

import me.ruttedbus.worldautosaver.util.AutoSaveHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class EndAutoSave implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("autosaver.command.endautosave")) {
			if(AutoSaveHandler.isRunning()) {
				AutoSaveHandler.endAutoSave();
				sender.sendMessage(ChatColor.GOLD + "Auto-saving has been disabled.");
			}
			else {
				sender.sendMessage(ChatColor.RED + "Auto-save is already disabled!");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You do not not have permission to run this command!");
		}
		return true;
	}
}
