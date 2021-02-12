package lakresmigo.loginregister;

import lakresmigo.loginregister.utilities.PasswordManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Loginregister extends JavaPlugin {

    CommandsManager commandsManager;
    JavaPlugin plugin;
    PasswordManager passwordManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        initializeVariables();
        saveDefaultConfig();
    }

    private void initializeVariables(){

        plugin = this;
        commandsManager = new CommandsManager(plugin);
        passwordManager = new PasswordManager(plugin);
    }
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}
