package me.duelling;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage("Duel plugin made by _ItzMarcus_ and Dempsey.");
	}

}
