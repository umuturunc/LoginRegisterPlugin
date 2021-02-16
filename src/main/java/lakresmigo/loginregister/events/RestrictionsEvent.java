package lakresmigo.loginregister.events;

import lakresmigo.loginregister.livedata.OnlinePlayers;
import org.bukkit.GameMode;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.event.player.*;

import java.util.ArrayList;

public class RestrictionsEvent implements Listener {

    private boolean playerNotLoggedIn(Player player) {
        return !OnlinePlayers.isPlayerLoggedIn(player);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.ADVENTURE);

    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        event.setCancelled(playerNotLoggedIn(event.getPlayer()));

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

    private static ArrayList<String> initialAllowedCommands = new ArrayList<>();

    public RestrictionsEvent() {
        initialAllowedCommands.add("/login");
        initialAllowedCommands.add("/register");
        initialAllowedCommands.add("/girişyap");
        initialAllowedCommands.add("/kayıtol");

    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (playerNotLoggedIn(player)) {

            String command = event.getMessage();
            command = command.split(" ")[0];
//            command = command.substring(1);
//            player.sendMessage(command);

            event.setCancelled(!initialAllowedCommands.contains(command));
        }
    }
}
