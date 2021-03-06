package me.duelling;

import gq.dempsey.util.Arena;

import java.io.IOException;

import me.duelling.listeners.BlockBreakListener;
import me.duelling.listeners.CreateProfile;
import me.duelling.listeners.JoinMessage;
import me.duelling.utils.ChatFormat;
import me.duelling.utils.ColoredNames;
import me.duelling.utils.MotdManager;
import me.duelling.utils.Profile;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Core extends JavaPlugin implements Listener {
	
	private static Plugin plugin;

	
	public void onEnable() {
		try {
			Arena.setup(this);
			MotdManager.setup(this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Profile(), this);
		pm.registerEvents(new CreateProfile(), this);
		pm.registerEvents(new JoinMessage(), this);
		pm.registerEvents(new BlockBreakListener(), this);
		pm.registerEvents(new MotdManager(), this);
		pm.registerEvents(new ColoredNames(), this);
		pm.registerEvents(new ChatFormat(), this);
		saveDefaultConfig();
		Bukkit.getConsoleSender().sendMessage("Duel plugin made by _ItzMarcus_ and Dempsey.");
	}

}
