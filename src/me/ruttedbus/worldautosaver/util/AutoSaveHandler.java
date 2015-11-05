package me.ruttedbus.worldautosaver.util;

import java.util.ArrayList;
import java.util.List;

import me.ruttedbus.worldautosaver.events.AutoSaveEvent;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AutoSaveHandler {
	private static AutoSaveTask autosaver;
	private static boolean isRunning;
	
	public static void beginAutoSave(JavaPlugin plugin) {
		isRunning = true;
		autosaver = new AutoSaveTask();
		autosaver.runTaskTimerAsynchronously(plugin, 0, 18000);
	}
	
	private static class AutoSaveTask extends BukkitRunnable {
		public void run() {
			List<World> savedWorlds = new ArrayList<World>();
			for(World w : Bukkit.getServer().getWorlds()) {
				if(w != null) {
					w.save();
					savedWorlds.add(w);
				}
			}
			long timeSaved = System.currentTimeMillis();
			AutoSaveEvent autosave = new AutoSaveEvent(savedWorlds, timeSaved, "Saved worlds at time: " + timeSaved);
			Bukkit.getPluginManager().callEvent(autosave);
		}
	}
	
	public static void endAutoSave() {
		autosaver.cancel();
		isRunning = false;
	}
	
	public static boolean isRunning() {
		return isRunning;
	}
}
