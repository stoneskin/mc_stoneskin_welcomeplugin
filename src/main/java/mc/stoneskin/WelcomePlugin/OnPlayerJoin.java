package mc.stoneskin.welcomeplugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.Bukkit;

public class OnPlayerJoin implements Listener {

    private ConfigHelper config= ConfigHelper.load();

    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
        String msg= config.getConfig().getString("welcome.message");
        Bukkit.getServer().getLogger().info("Welcome msg loaded:"+msg);
        System.out.print("msg = "+msg);
        String lb=config.getConfig().getString("welcome.linebreak");
        if(lb==null)
            lb="\\n";
        // int ml= Integer.parseInt(config.getConfig().getString("welcome.maxline"));
        // if (ml<0) ml=10;

        if(msg!=null){
            String[] s = msg.split(lb);
            for (String m : s){
                player.sendMessage(m.replaceAll("&", "§").replaceAll("%p", player.getName()));
            }
            
        }else
         player.sendMessage(("&5Welcome, &r&2%p&r&5 !").replaceAll("&", "§").replaceAll("%p", player.getName()));
		
	}
	
}