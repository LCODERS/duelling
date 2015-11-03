package gq.dempsey.duelling;

import me.duelling.Core;

import org.bukkit.configuration.file.FileConfiguration;


public class Engine {
	
	private Core cor = new Core();	
	// Main Engine
	private static Engine a = new Engine();
	FileConfiguration c = cor.getConfig();
	
	
	public static Engine construct(){
		return a;
	}
	
	
	
	

}
