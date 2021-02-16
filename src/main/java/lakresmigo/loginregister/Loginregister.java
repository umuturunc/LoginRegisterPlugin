package lakresmigo.loginregister;

import lakresmigo.loginregister.utilities.*;
import lakresmigo.loginregister.registerers.CommandsRegisterer;
import lakresmigo.loginregister.registerers.EventsRegisterer;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loginregister extends JavaPlugin {

    CommandsRegisterer commandsRegisterer;
    JavaPlugin plugin;
    PasswordManager passwordManager;
    EventsRegisterer eventsRegisterer;
    PermissionManager permissionManager;
    ConfigManager configManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        initializeVariables();
        saveDefaultConfig();
        ConfigManager.reloadConfigFromDisk();
    }

    private void initializeVariables(){

        plugin = this;
        commandsRegisterer = new CommandsRegisterer(plugin);
        passwordManager = new PasswordManager(plugin);
        eventsRegisterer = new EventsRegisterer(plugin);
        permissionManager = new PermissionManager(plugin);
        configManager = new ConfigManager(plugin);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
