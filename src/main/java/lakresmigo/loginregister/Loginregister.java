package lakresmigo.loginregister;

import org.bukkit.plugin.java.JavaPlugin;

public final class Loginregister extends JavaPlugin {

    CommandsManager commandsManager;
    JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        commandsManager = new CommandsManager(plugin);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
