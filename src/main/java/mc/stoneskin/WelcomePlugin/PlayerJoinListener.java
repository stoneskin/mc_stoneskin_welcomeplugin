package mc.stoneskin.WelcomePlugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final MessageHelper _helper;

    public PlayerJoinListener(final MessageHelper helper) {
        _helper = helper;

    }

    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        _helper.SendWelcomeMessages(player);
	}
	
}