package me.duelling.listeners;

import java.util.List;

import me.duelling.Core;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
	
	Core plugin = new Core();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		List<String> joinmessage = plugin.getConfig().getStringList("join-message");
		for(String msg : joinmessage) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		}
	}

}
