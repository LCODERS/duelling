package me.duelling;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	private static Plugin pootis;
	
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("Duel plugin made by _ItzMarcus_ and Dempsey.");
	}
	
}
