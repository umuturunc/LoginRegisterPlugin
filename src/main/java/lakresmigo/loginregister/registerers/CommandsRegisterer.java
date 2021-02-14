package lakresmigo.loginregister.registerers;

import lakresmigo.loginregister.commands.LoginCommand;
import lakresmigo.loginregister.commands.RegisterCommand;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandsRegisterer {
    static JavaPlugin plugin;

    public CommandsRegisterer(JavaPlugin plugin) {
        this.plugin = plugin;
        registerAllCommands();
    }

    private static void registerAllCommands() {
        addCommand("login", new LoginCommand(plugin));
        addCommand("register", new RegisterCommand(plugin));
    }

    private static void addCommand(String commandName, CommandExecutor commandExecutor) {
        Bukkit.getServer().getPluginCommand(commandName).setExecutor(commandExecutor);

    }

}