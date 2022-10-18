package me.mrpeterss.planes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Boat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class Plane implements Listener {

    private Boat seat;
    private Minecart model;

    private MovementHandler movement;


    public Plane(Player p) {
        this.seat = (Boat) p.getWorld().spawnEntity(p.getLocation(), EntityType.BOAT);
        this.model = (Minecart) p.getWorld().spawnEntity(p.getLocation(), EntityType.MINECART_COMMAND);
        this.seat.addPassenger(this.model);

        Bukkit.getServer().getPluginManager().registerEvents(this,Main.plugin);
    }

    @EventHandler
    public void onShift(VehicleExitEvent e) {
        if (e.getVehicle() == this.seat) done();
        this.movement.stop();
    }

    @EventHandler
    public void onBoatClick(VehicleEnterEvent e) {
        this.movement = new MovementHandler(seat);
    }

    private void done() {
        HandlerList.unregisterAll(this);
    }

}
