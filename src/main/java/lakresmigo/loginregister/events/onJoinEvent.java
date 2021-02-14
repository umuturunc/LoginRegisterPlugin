package lakresmigo.loginregister.events;

import lakresmigo.loginregister.utilities.PermissionManager;
import lakresmigo.loginregister.livedata.OnlinePlayers;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashSet;
import java.util.Set;

public class onJoinEvent implements Listener {

    private static Set<String> defaultDisabledPermissions = new HashSet<>();

    public onJoinEvent()
    {
//        defaultDisabledPermissions.add("bukkit.command.version");
//        defaultDisabledPermissions.add("bukkit.command.plugins");

    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        PermissionManager.initializePermission(player);
        OnlinePlayers.addPlayer(player);
        if(OnlinePlayers.isPlayerRegistered(player))
        {
            PermissionManager.removePermision(player,"register");
        }
        else {
            player.sendMessage("You are not registered");
            PermissionManager.removePermision(player,"login");
        }
//        player.recalculatePermissions();

//        player.sendMessage(PermissionManager.getAllPermissions(player).toString());
    }

}
