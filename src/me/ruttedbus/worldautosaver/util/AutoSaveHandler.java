package me.ruttedbus.worldautosaver.util;

import java.util.ArrayList;
import java.util.List;

import me.ruttedbus.worldautosaver.events.AutoSaveEvent;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class AutoSaveHandler {
	private static boolean isRunning;
	private static BukkitRunnable task;
	
	static {
		isRunning = false;
	}
	
	public static void beginAutoSave(JavaPlugin plugin) {
		if(isRunning) return;
		isRunning = true;
		task = new BukkitRunnable() {
			public void run() {
				List<World> savedWorlds = new ArrayList<World>();
				for(World w : Bukkit.getServer().getWorlds()) {
					if(w != null) {
						w.save();
						savedWorlds.add(w);
					}
				}
				long timeSaved = System.currentTimeMillis();
				AutoSaveEvent autosave = new AutoSaveEvent(savedWorlds, timeSaved, "Saved worlds at time: " + timeSaved + ". " + savedWorlds.size() + " worlds saved.");
				Bukkit.getPluginManager().callEvent(autosave);
			}
		};
		task.runTaskTimer(plugin, 100, 100);
	}
	
	public static void endAutoSave() {
		task.cancel();
		isRunning = false;
	}
	

	
	public static boolean isRunning() {
		return isRunning;
	}
}
