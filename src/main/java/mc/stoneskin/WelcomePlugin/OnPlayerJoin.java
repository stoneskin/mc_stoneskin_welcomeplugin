package mc.stoneskin.WelcomePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin implements Listener {

    private ConfigHelper config= ConfigHelper.Instance();

    @EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
        config.SendWelcomeMessages(player);
	}
	
}