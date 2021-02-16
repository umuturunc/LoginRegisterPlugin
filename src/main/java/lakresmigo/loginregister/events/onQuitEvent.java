package lakresmigo.loginregister.events;

import lakresmigo.loginregister.livedata.OnlinePlayers;
import lakresmigo.loginregister.utilities.PermissionManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuitEvent implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        OnlinePlayers.removePlayer(player);
        PermissionManager.removePlayer(player);
    }
}
