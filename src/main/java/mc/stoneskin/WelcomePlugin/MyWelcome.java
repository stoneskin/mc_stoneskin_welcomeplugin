package mc.stoneskin.welcomeplugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MyWelcome extends JavaPlugin {
    public void onEnable() {
       
        ConfigHelper.load().init(this);
		 getServer().getPluginManager().registerEvents(new OnPlayerJoin(), this);
		 getLogger().info("Plugin Activated!");
	}
    public void onDisable() {
		getLogger().info("Plugin Desactivated!");
	}
}