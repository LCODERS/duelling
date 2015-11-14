package me.duelling.utils;

import java.io.File;
import java.io.IOException;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.Plugin;

public class MotdManager implements Listener {
	
	private static File file;
	private static FileConfiguration conf;
	
	public static void setup(Plugin p) throws IOException{
		if(!p.getDataFolder().exists()){
			p.getDataFolder().mkdir();
		}
		file = new File(p.getDataFolder(), "motd.yml");
		if(!file.exists()){
			file.createNewFile();
		}
		conf = YamlConfiguration.loadConfiguration(file);
		conf.addDefault("motd-line-1", "&6This is the first line of the MOTD.");
		conf.addDefault("motd-line-2", "&cThis is the second line of the MOTD.");
	}
	
	@EventHandler
	public void onserverpingEvent(ServerListPingEvent e) {
		e.setMotd(conf.getString("motd-line-1").replaceAll("&", "§") + "\n" + conf.getString("motd-line-2").replaceAll("&", "§"));
	}

}
