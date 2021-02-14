package lakresmigo.loginregister.commands;

import lakresmigo.loginregister.utilities.PasswordManager;
import lakresmigo.loginregister.utilities.PermissionManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RegisterCommand implements CommandExecutor {
    JavaPlugin plugin;

    public RegisterCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if(args.length==2)
            {
                String password1 = args[0];
                String password2 = args[1];
                if(PasswordManager.arePasswordsMatches(password1,password2))
                {
                    PasswordManager.addPassword(player,password1);
                    PermissionManager.removePermision(player,"register");
                    PermissionManager.addPermission(player,"login");
                    return true;
                }
            }
        }
        return false;
    }
}
