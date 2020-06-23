package pl.bullcube.Spanko;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static Plugin plugin;
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[Spanko] Plugin wylaczony");
    }

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getConsoleSender().sendMessage("[Spanko] Plugin wlaczony");
        getServer().getPluginManager().registerEvents(new EventHandlers(), this);
    }
}
