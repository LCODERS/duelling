package gq.dempsey.util;

import java.io.File;
import java.util.ArrayList;

import me.duelling.Core;

import org.bukkit.configuration.file.YamlConfiguration;


public class ArenaManager {
	
	private static Core cc = new Core();
	private static YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(cc.getDataFolder(), "Arena.yml"));
	
	public static ArrayList<Arena> getArenas(){
		ArrayList<Arena> list = new ArrayList<Arena>();
		for(int id : c.getIntegerList("arenas")){
			Arena a = Arena.getById(id);
			list.add(a);
		}
		return list;
	}
	
}
