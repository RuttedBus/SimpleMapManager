package me.ruttedbus.worldautosaver.events;

import java.util.List;

import org.bukkit.World;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class AutoSaveEvent extends Event{
	public static final HandlerList handlers = new HandlerList();
	private String message;
	private List<World> savedWorlds;
	private long timeSaved;
	
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public static HandlerList getHandlerList() {
		return handlers;
	}
	
	public AutoSaveEvent(List<World> savedWorlds, long time, String message) {
		this.message = message;
		this.savedWorlds = savedWorlds;
		this.timeSaved = time;
	}
	
	public String getMessage() {
		return message;
	}
	
	public List<World> getWorldsSaved() {
		return savedWorlds;
	}
	
	public long getTimeSaved() {
		return timeSaved;
	}
}
