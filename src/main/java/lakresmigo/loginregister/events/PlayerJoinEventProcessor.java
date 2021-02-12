package lakresmigo.loginregister.events;

import lakresmigo.loginregister.livedata.OnlinePlayers;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class PlayerJoinEventProcessor implements Listener {


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        OnlinePlayers.addPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        event.setCancelled(!OnlinePlayers.isPlayerLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        event.setCancelled(!OnlinePlayers.isPlayerLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        event.setCancelled(!OnlinePlayers.isPlayerLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        if (!OnlinePlayers.isPlayerLoggedIn(event.getPlayer())) {
            //to be continued  ...............
        }
    }
}
