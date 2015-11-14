package gq.dempsey.util;

import java.io.File;
import java.util.ArrayList;

import me.duelling.Core;

import org.bukkit.Location;
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
	
	public static Arena createArena(int id, Location b1, Location b2, Location sp1, Location sp2){
		Arena a = new Arena(id,b1,b2,sp1,sp2);
		a.save();
		return a;
	}
	
	public static void deleteArena(int id){
		Arena.getById(id).delete();
	}
	
}
