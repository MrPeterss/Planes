package me.mrpeterss.planes;

import org.bukkit.Bukkit;
import org.bukkit.entity.Boat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleMoveEvent;
import org.bukkit.util.Vector;

public class MovementHandler implements Listener {

    private Vector velocity;
    private Boat vehicle;

    public MovementHandler(Boat vehicle) {
        this.velocity = vehicle.getVelocity();
        this.vehicle = vehicle;
        Bukkit.getServer().getPluginManager().registerEvents(this,Main.plugin);
    }

    @EventHandler
    public void onMove(VehicleMoveEvent e) {

    }

    public void stop() {
        HandlerList.unregisterAll(this);
    }
}
