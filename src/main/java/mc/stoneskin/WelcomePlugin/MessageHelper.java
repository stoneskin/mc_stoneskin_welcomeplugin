package mc.stoneskin.WelcomePlugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class MessageHelper {
	// private File file;
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

	// todo remove
	// private String[] GetMessages(final Player player) {
	// // todo, support message same in array
	// String msg = config.getString("welcome.message");
	// if (msg != null) {
	// Bukkit.getServer().getLogger().info("Welcome msg loaded:" + msg);
	// System.out.print("msg = " + msg);
	// msg = msg.replaceAll("&", "§").replaceAll("%p", player.getName());
	// String lb = config.getString("welcome.linebreak");
	// if (lb == null)
	// lb = "\\n";
	// final String[] s = msg.split(lb);
	// return s;
	// }
	// return new String[] {};
	// }

	private List<String> GetMessageSections() {
		try {
			String defaultMsg = config.getString("welcome.message");
			List<String> msgSections = config.getStringList("welcome.messages");
			if (defaultMsg != null)
				msgSections.add(0, defaultMsg);
			return msgSections;
		} catch (Exception ex) {
			String err = ex.getMessage();
			ArrayList<String> re = new ArrayList<String>();
			re.add("&4" + err + "&r");
			return re;
		}
	}

	private String[] FormateMessage(Player player, String msg) {
		msg = msg.replaceAll("&", "§").replaceAll("%p", player.getName());
		String lb = config.getString("welcome.linebreak");
		if (lb == null)
			lb = "\\n";
		final String[] s = msg.split(lb);
		return s;
	}

	public void SendWelcomeMessages(final Player player) {
		List<String> messages = GetMessageSections();
		int delay =config.getInt("welcome.delay");
		if(delay<1)
			delay=1;
		for (int i = 0; i < messages.size(); i++) {
			final String msg =messages.get(i);
			Runnable task = new Runnable() {
				@Override
				public void run() {

					SendMessage(player, msg);
				}
			};
			Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, task, 20*delay*i);

		}

	}

	private void SendMessage(final Player player, String msg) {
		String[] outs = FormateMessage(player, msg);

		for (String s : outs) {
			player.sendMessage(s);
		}
	}
	// final String[] msgs = GetMessages(player);
	// if (msgs.length > 0) {

	// for (final String m : msgs) {
	// player.sendMessage(m);
	// }

	// } else {
	// //send default message
	// player.sendMessage(("&5Welcome, &r&2%p&r&5 !").replaceAll("&",
	// "§").replaceAll("%p", player.getName()));
	// }

	// }

	public FileConfiguration getConfig() {
		return config;
	}

}