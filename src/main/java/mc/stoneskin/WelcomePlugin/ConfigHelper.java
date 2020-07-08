package mc.stoneskin.welcomeplugin;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigHelper {
    private File file;
	private FileConfiguration config;
	
	private static ConfigHelper helper = new ConfigHelper();
	
	public static ConfigHelper load() {
		return helper;
	}
	
	public void init(Plugin plugin) {
		file = new File(plugin.getDataFolder(), "config.yml");
		
		if(!file.exists()) {
			plugin.saveResource("config.yml", false);
		}
		
		config = YamlConfiguration.loadConfiguration(file);
	}
	
	public FileConfiguration getConfig() {
		return config;
	}
	
	public void saveConfig() {
		try{
			config.save(file);
		}catch(IOException e) {
			Bukkit.getServer().getLogger().severe("Could not save the file config.yml!");
		}
	}
}