package me.ruttedbus.worldautosaver;

import me.ruttedbus.worldautosaver.commands.BeginAutoSave;
import me.ruttedbus.worldautosaver.commands.EndAutoSave;
import me.ruttedbus.worldautosaver.commands.Save;
import me.ruttedbus.worldautosaver.commands.SaveAll;
import me.ruttedbus.worldautosaver.listeners.AutoSaveListener;
import me.ruttedbus.worldautosaver.util.AutoSaveHandler;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldAutoSaver extends JavaPlugin {
	public void onEnable() {
		saveDefaultConfig();
		if(getConfig().getBoolean("Auto save on enable")) {
			AutoSaveHandler.beginAutoSave(this);
		}
		Bukkit.getPluginManager().registerEvents(new AutoSaveListener(), this);
		registerCommands();
	}
	
	public void onDisable() {
		if(AutoSaveHandler.isRunning()) AutoSaveHandler.endAutoSave();
	}
	
	public void registerCommands() {
		try {
			getCommand("bas").setExecutor(new BeginAutoSave(this));
			getCommand("eas").setExecutor(new EndAutoSave());
			getCommand("save").setExecutor(new Save());
			getCommand("saveall").setExecutor(new SaveAll());
		}
		catch(NullPointerException e) {
			getLogger().warning("One or more commands in the plugin.yml for WorldAutoSaver is not set up correctly! Now disabling WorldAutoSaver...");
			Bukkit.getPluginManager().disablePlugin(this);
			
		}
	}
}
