package me.ruttedbus.worldautosaver.commands;

import me.ruttedbus.worldautosaver.util.AutoSaveHandler;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class BeginAutoSave implements CommandExecutor {
	private final JavaPlugin plugin;
	public BeginAutoSave(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("autosaver.command.beginautosave")) {
			if(!AutoSaveHandler.isRunning()) {
				AutoSaveHandler.beginAutoSave(plugin);
				sender.sendMessage(ChatColor.GOLD + "Auto-saving has been enabled!");
			}
			else {
				sender.sendMessage(ChatColor.RED + "Auto-save is already enabled!");
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + "You do not not have permission to run this command!");
		}
		return true;
	}
}
