package lakresmigo.loginregister.utilities;

import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class PermissionManager {

    private static JavaPlugin plugin;

    public PermissionManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    private static HashMap<UUID, PermissionAttachment> playerPermissions = new HashMap<>();

    public static void initializePermission(Player player)
    {
        playerPermissions.put(player.getUniqueId(),player.addAttachment(plugin));
    }

    public static void removePlayer(Player player)
    {
        playerPermissions.remove(player.getUniqueId());
    }

    public static void addPermission(Player player,String permission)
    {
        playerPermissions.get(player.getUniqueId()).setPermission(permission,true);
    }

    public static void removePermision(Player player,String permission)
    {
        playerPermissions.get(player.getUniqueId()).setPermission(permission,false);
    }

    public static PermissionAttachment getAllPermissions(Player player){
        return playerPermissions.get(player);
    }
}















