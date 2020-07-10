package mc.stoneskin.WelcomePlugin;
import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class ConfigHelper {
	//private File file;
	private FileConfiguration config;
	private Plugin plugin;
	private static ConfigHelper helper = new ConfigHelper();

	public static ConfigHelper Instance() {
		return helper;
	}

	public void init(Plugin plugin) {
		this.plugin = plugin;
		config = plugin.getConfig();
	}

	public void Reload() {
		plugin.reloadConfig();
		config = plugin.getConfig();
	}

	private String[] GetMessages(Player player) {
		//todo, support message same in array
		String msg = config.getString("welcome.message");
		if (msg != null) {
			Bukkit.getServer().getLogger().info("Welcome msg loaded:" + msg);
			System.out.print("msg = " + msg);
			msg = msg.replaceAll("&", "§").replaceAll("%p", player.getName());
			String lb = config.getString("welcome.linebreak");
			if (lb == null)
				lb = "\\n";
			String[] s = msg.split(lb);
			return s;
		}
		return new String[]{};
	}

	public void SendWelcomeMessages(Player player) {
		String[] msgs = GetMessages(player);
		if (msgs.length > 0) {

			for (String m : msgs) {
				player.sendMessage(m);
			}

		} else {
			//send default message
			player.sendMessage(("&5Welcome, &r&2%p&r&5 !").replaceAll("&", "§").replaceAll("%p", player.getName()));
		}

	}

	public FileConfiguration getConfig() {
		return config;
	}


}