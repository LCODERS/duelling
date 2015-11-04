package me.duelling.listeners;

import me.duelling.Core;
import me.duelling.utils.Profile;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class CreateProfile implements Listener {
	
	Profile profile = new Profile();
	Core plugin = new Core();
	
	@EventHandler
	public void createProfile(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		if(plugin.getConfig().getStringList("profiles").contains(player.getName())) {
			Bukkit.getConsoleSender().sendMessage("Loaded player profile for " + player.getName());
			return;
		} else {
			// Creating the player profile.
			profile.createProfile(player);
			Bukkit.getConsoleSender().sendMessage("Creating new player profile for " + player.getName());
			Bukkit.getConsoleSender().sendMessage("Created player profile for " + player.getName());
		}
	}
}
