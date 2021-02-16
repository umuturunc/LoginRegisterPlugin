package lakresmigo.loginregister.registerers;

import lakresmigo.loginregister.events.RestrictionsEvent;
import lakresmigo.loginregister.events.onJoinEvent;
import lakresmigo.loginregister.events.onQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class EventsRegisterer {

    static JavaPlugin plugin;

    public EventsRegisterer(JavaPlugin plugin) {
        this.plugin = plugin;
        registerAllEvents();
    }

    private static void registerAllEvents()
    {
        plugin.getServer().getPluginManager().registerEvents(new RestrictionsEvent(),plugin);
        plugin.getServer().getPluginManager().registerEvents(new onJoinEvent(),plugin);
        plugin.getServer().getPluginManager().registerEvents(new onQuitEvent(),plugin);
    }


}
