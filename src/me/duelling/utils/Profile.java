package me.duelling.utils;

import me.duelling.Core;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Profile implements Listener {
	
	Core plugin = new Core();
	
	public void createProfile(Player player) {
		plugin.getConfig().getStringList("profiles").add(player.getName());
		plugin.getConfig().getStringList("profiles").set(0, player.getName() + ".kills");
		plugin.getConfig().getStringList("profiles").set(0, player.getName() + ".deaths");
		plugin.getConfig().getStringList("profiles").set(0, player.getName() + ".won");
		plugin.getConfig().getStringList("profiles").set(0, player.getName() + ".lost");
		plugin.saveConfig();
   }
	public void getProfile(Player player) {
		plugin.getConfig().getStringList("profiles." + player.getName());
	}
}
