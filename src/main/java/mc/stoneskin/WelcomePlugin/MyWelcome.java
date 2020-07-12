package mc.stoneskin.WelcomePlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class MyWelcome extends JavaPlugin {
    public void onEnable() {
	   
        final MessageHelper helper = new MessageHelper(this);
       
		this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(helper), this);
        this.getCommand("welcome").setExecutor(new WelcomeCommand(helper));
		this.getLogger().fine("MyWelcome Plugin Activated!");
    

    }
    public void onDisable() {
		//getLogger().fine("MyWelcome Plugin Deactivated!");
	}


}