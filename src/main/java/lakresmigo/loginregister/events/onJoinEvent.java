package lakresmigo.loginregister.events;

import com.destroystokyo.paper.Title;
import lakresmigo.loginregister.livedata.OnlinePlayers;
import lakresmigo.loginregister.utilities.ConfigManager;
import lakresmigo.loginregister.utilities.PermissionManager;
import lakresmigo.loginregister.utilities.TitleManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;

public class onJoinEvent implements Listener {

    JavaPlugin plugin;


    private static Set<String> defaultDisabledPermissions = new HashSet<>();

    public onJoinEvent(JavaPlugin plugin) {
//        defaultDisabledPermissions.add("bukkit.command.version");
//        defaultDisabledPermissions.add("bukkit.command.plugins");
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendTitle(TitleManager.joinTitle);
        player.sendMessage(TitleManager.joinTitle.getSubtitle());

        PermissionManager.initializePermission(player);
        OnlinePlayers.addPlayer(player);
        if (OnlinePlayers.isPlayerRegistered(player)) {
            PermissionManager.removePermision(player, "register");
            player.sendMessage(TitleManager.loginTitle.getSubtitle());
        } else {
            player.sendMessage(TitleManager.registerTitle.getSubtitle());
            PermissionManager.removePermision(player, "login");
        }

        Title title;

        if (ConfigManager.configVariableExist("passwords." + player.getName())) {
            title = TitleManager.loginTitle;
        }
        else {
            title = TitleManager.registerTitle;
        }


        new BukkitRunnable()
        {

            @Override
            public void run() {
                player.sendTitle(title);
            }
        }.runTaskLater(plugin,20*3);



    }

}
