package lakresmigo.loginregister.commands;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lakresmigo.loginregister.utilities.ConfigManager;
import lakresmigo.loginregister.utilities.TitleManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TitleCommand implements CommandExecutor {

    JavaPlugin plugin;

    public TitleCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        return false;
    }
}
