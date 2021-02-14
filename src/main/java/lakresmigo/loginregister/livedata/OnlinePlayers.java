package lakresmigo.loginregister.livedata;

import lakresmigo.loginregister.utilities.PasswordManager;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class OnlinePlayers {

    private static HashMap<UUID, Boolean> onlinePlayers = new HashMap<UUID,Boolean>();

    public static boolean isPlayerLoggedIn(Player player)
    {
        if(onlinePlayers.containsKey(player.getUniqueId()))
        {
            return onlinePlayers.get(player.getUniqueId());
        }
        return false;
    }

    public static void setPlayerLoggedIn(Player player)
    {
        onlinePlayers.put(player.getUniqueId(),true);
    }

    public static void addPlayer(Player player)
    {
        onlinePlayers.put(player.getUniqueId(),false);
    }

    public static void removePlayer(Player player)
    {
        onlinePlayers.remove(player.getUniqueId());
    }

    public static boolean isPlayerRegistered(Player player)
    {
        return PasswordManager.isPlayerRegistered(player);
    }
}
