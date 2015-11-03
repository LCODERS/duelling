package me.duelling;

import java.io.IOException;

import gq.dempsey.util.Arena;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	private static Plugin plugin;

	
	public void onEnable() {
		try {
			Arena.setup(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Bukkit.getConsoleSender().sendMessage("Duel plugin made by _ItzMarcus_ and Dempsey.");
	}

}
