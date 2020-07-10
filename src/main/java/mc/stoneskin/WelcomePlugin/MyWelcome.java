package mc.stoneskin.WelcomePlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class MyWelcome extends JavaPlugin {
    public void onEnable() {
	   

        ConfigHelper.Instance().init(this);
		getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
        this.getCommand("Welcome").setExecutor(new WelcomeCommand());
		getLogger().fine("MyWelcome Plugin Activated!");
        FileConfiguration config = getConfig();

    }
    public void onDisable() {
		//getLogger().fine("MyWelcome Plugin Deactivated!");
	}


}