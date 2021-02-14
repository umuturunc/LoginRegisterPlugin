package lakresmigo.loginregister.events;

import lakresmigo.loginregister.livedata.OnlinePlayers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class RestrictionsEvent implements Listener {



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
//        Player player = event.getPlayer();
//
//        if(OnlinePlayers.isPlayerRegistered(player))
//        {
//            if(event.get)
//        }
//        else {
//
//        }
//        if (!OnlinePlayers.isPlayerLoggedIn(event.getPlayer())) {
//            //to be continued  ...............
//            if()
//        }
    }
}
