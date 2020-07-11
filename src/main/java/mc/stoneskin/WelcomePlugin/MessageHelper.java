package mc.stoneskin.WelcomePlugin;


import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MessageHelper {
	//private File file;
	private FileConfiguration config;
	private Plugin plugin;
		

	public MessageHelper(final Plugin plugin) {
		this.plugin = plugin;
		config = plugin.getConfig();
	}

	public void Reload() {
		plugin.reloadConfig();
		config = plugin.getConfig();
	}

	private String[] GetMessages(final Player player) {
		// todo, support message same in array
		String msg = config.getString("welcome.message");
		if (msg != null) {
			Bukkit.getServer().getLogger().info("Welcome msg loaded:" + msg);
			System.out.print("msg = " + msg);
			msg = msg.replaceAll("&", "§").replaceAll("%p", player.getName());
			String lb = config.getString("welcome.linebreak");
			if (lb == null)
				lb = "\\n";
			final String[] s = msg.split(lb);
			return s;
		}
		return new String[] {};
	}

	public void SendWelcomeMessages(final Player player) {
		final String[] msgs = GetMessages(player);
		if (msgs.length > 0) {

			for (final String m : msgs) {
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