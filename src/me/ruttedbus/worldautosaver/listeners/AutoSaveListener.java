package me.ruttedbus.worldautosaver.listeners;

import me.ruttedbus.worldautosaver.events.AutoSaveEvent;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

public class AutoSaveListener implements Listener {
	@EventHandler
	public void onAutoSave(AutoSaveEvent e) {
		Bukkit.broadcastMessage(e.getMessage());
	}
}
