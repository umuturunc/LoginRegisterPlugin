package lakresmigo.loginregister.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PasswordManager {

    static JavaPlugin plugin;

    public PasswordManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public static boolean isPlayerRegistered(Player player)
    {
        return plugin.getConfig().getConfigurationSection("passwords").contains(player.getName());
    }

    public static boolean isPasswordCorrect(Player player, String password)
    {
        //utilitis paketi altında md5 şifrelemesi yapan bir sınıf ileride eklenecek!
        return plugin.getConfig().getConfigurationSection("passwords").getString(player.getName()).equals(password);
    }

    public static void addPassword(Player player, String password)
    {
        plugin.getConfig().getConfigurationSection("passwords").set(player.getName(),password);
        plugin.saveConfig();
    }

    public static boolean arePasswordsMatches(String password1, String password2)
    {
        return password1.equals(password2);
    }
}
