package me.ruttedbus.worldautosaver.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class SaveAll implements CommandExecutor {
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender.hasPermission("worldautosaver.commands.saveall")) {
			List<World> savedWorlds = new ArrayList<World>();
			for(World w : Bukkit.getServer().getWorlds()){
				if(w != null) {
					w.save();
					savedWorlds.add(w);
				}
			}
			sender.sendMessage(ChatColor.GREEN  + "Saved " + savedWorlds.size() + " worlds.");
		}
		else {
			sender.sendMessage(ChatColor.RED + "You do not have permission to execute this command!");
		}
		return true;
	}
}
