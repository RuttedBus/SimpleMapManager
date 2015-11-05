package me.ruttedbus.worldautosaver;

import me.ruttedbus.worldautosaver.util.AutoSaveHandler;

import org.bukkit.plugin.java.JavaPlugin;

public class WorldAutoSaver extends JavaPlugin {
	public void onEnable() {
		if(getConfig().getBoolean("Auto save on enable")) {
			AutoSaveHandler.beginAutoSave(this);
		}
	}
	
	public void onDisable() {
		if(AutoSaveHandler.isRunning()) AutoSaveHandler.endAutoSave();
	}
}
