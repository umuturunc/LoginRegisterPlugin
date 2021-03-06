package lakresmigo.loginregister.events;

import lakresmigo.loginregister.livedata.OnlinePlayers;
import lakresmigo.loginregister.utilities.ConfigManager;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class RestrictionsEvent implements Listener {

    JavaPlugin plugin;


    private static ArrayList<String> initialAllowedCommands = new ArrayList<>();


    public RestrictionsEvent(JavaPlugin plugin) {
        this.plugin = plugin;

        initialAllowedCommands.add("/login");
        initialAllowedCommands.add("/register");
        initialAllowedCommands.add("/giriş");
        initialAllowedCommands.add("/kayıt");
    }


    private boolean playerNotLoggedIn(Player player) {
        return !OnlinePlayers.isPlayerLoggedIn(player);
    }



    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);

        int kicktime = ConfigManager.getConfigValueInt("kicktime");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (OnlinePlayers.isPlayerLoggedIn(player)) {
                } else {
                    player.kickPlayer("Lütfen "+(int)kicktime/20+" saniye içinde giriş yapınız");
                }
            }
        }.runTaskLater(plugin, kicktime);


    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {

        //Disable player kicking out because of flying check
        Player player = event.getPlayer();
        if (playerNotLoggedIn(player)) {
            Location location = player.getLocation();
            location.setY(location.getY() - 0.05d);
            Block block = player.getWorld().getBlockAt(location);
            if(block.isSolid())
                event.setCancelled(playerNotLoggedIn(event.getPlayer()));
        }

    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerItemHeld(PlayerItemHeldEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerPickupItem(PlayerAttemptPickupItemEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onPlayerDropItem(PlayerDropItemEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));
    }


    @EventHandler
    public void onPlayerChatEvent(AsyncPlayerChatEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));
    }

    @EventHandler
    public void onEntityTargetonPlayer(EntityTargetLivingEntityEvent event) {
        if (event.getTarget() instanceof Player) {
            event.setCancelled(playerNotLoggedIn((Player) event.getTarget()));
        }
    }


    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        Entity damager = event.getDamager();
        Entity entity = event.getEntity();
        if (damager instanceof Player) {
            if (playerNotLoggedIn((Player) damager))
                event.setCancelled(true);
        }
        if (entity instanceof Player) {
            if (playerNotLoggedIn((Player) entity))
                event.setCancelled(true);
        }
    }


    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (playerNotLoggedIn(player)) {

            String command = event.getMessage();
            command = command.split(" ")[0];
            event.setCancelled(!initialAllowedCommands.contains(command));
        }
    }
}
