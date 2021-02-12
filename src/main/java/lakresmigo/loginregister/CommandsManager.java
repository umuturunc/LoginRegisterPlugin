package lakresmigo.loginregister;

import lakresmigo.loginregister.commands.LoginCommand;
import lakresmigo.loginregister.commands.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsManager {
    static JavaPlugin plugin;

    public CommandsManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static void registerAllCommands() {
        addCommand("login", new LoginCommand(plugin));
        addCommand("register", new RegisterCommand(plugin));
    }

    public static void addCommand(String commandName, CommandExecutor commandExecutor) {
        Bukkit.getServer().getPluginCommand(commandName).setExecutor(commandExecutor);
    }

}
