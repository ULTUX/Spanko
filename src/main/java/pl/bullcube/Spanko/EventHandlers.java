package pl.bullcube.Spanko;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.world.TimeSkipEvent;

public class EventHandlers implements Listener {
    @EventHandler
    public void playerBedEnterEvent(PlayerBedEnterEvent event){
            if (event.getBedEnterResult().equals(PlayerBedEnterEvent.BedEnterResult.OK)) {
                Bukkit.getServer().getOnlinePlayers().forEach((player -> {
                    player.sendTitle(ChatColor.GOLD + event.getPlayer().getName() + ChatColor.DARK_GREEN + " poszedł spać", ChatColor.GRAY + "dobranoc.", 10, 40, 30);
                    if (!player.equals(event.getPlayer()) && !player.isSleeping()) {
                        player.setSleepingIgnored(true);
                    }
                }));
            }
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, () -> Bukkit.getServer().getOnlinePlayers().forEach((player -> {
                    if (!event.getPlayer().isSleeping() && !player.isSleeping()){
                        player.setSleepingIgnored(false);
                    }
            })), 100);
    }
    @EventHandler
    public void TimeSkipEvent(TimeSkipEvent event){
        if (event.getSkipReason().equals(TimeSkipEvent.SkipReason.NIGHT_SKIP)){
            Bukkit.getServer().getOnlinePlayers().forEach((player -> {
                player.setSleepingIgnored(false);
            }));
        }
    }
}
