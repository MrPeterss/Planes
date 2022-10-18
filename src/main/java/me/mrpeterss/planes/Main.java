package me.mrpeterss.planes;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        this.plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
