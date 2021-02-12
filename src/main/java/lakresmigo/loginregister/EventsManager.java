package lakresmigo.loginregister;

import lakresmigo.loginregister.events.PlayerJoinEventProcessor;
import org.bukkit.plugin.java.JavaPlugin;

public class EventsManager {

    static JavaPlugin plugin;

    public EventsManager(JavaPlugin plugin) {
        this.plugin = plugin;
        registerAllEvents();
    }

    private static void registerAllEvents()
    {
        plugin.getServer().getPluginManager().registerEvents(new PlayerJoinEventProcessor(),plugin);
    }


}
