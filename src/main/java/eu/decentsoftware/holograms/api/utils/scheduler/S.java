package eu.decentsoftware.holograms.api.utils.scheduler;

import eu.decentsoftware.holograms.api.DecentHolograms;
import eu.decentsoftware.holograms.api.DecentHologramsAPI;
import eu.decentsoftware.holograms.api.utils.DExecutor;
import me.eeshe.emperixlib.models.Scheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.IllegalPluginAccessException;

public class S {

    private static final DecentHolograms DECENT_HOLOGRAMS = DecentHologramsAPI.get();

    public static void stopTask(int id) {
        Bukkit.getScheduler().cancelTask(id);
    }

    public static void sync(Runnable runnable) {
        Scheduler.run(DECENT_HOLOGRAMS.getPlugin(), runnable);
    }

    public static Scheduler.Task sync(Runnable runnable, long delay) {
        return Scheduler.runLater(DECENT_HOLOGRAMS.getPlugin(), runnable, delay);
    }

    public static Scheduler.Task syncTask(Runnable runnable, long interval) {
        return Scheduler.runTimer(DECENT_HOLOGRAMS.getPlugin(), runnable, 0, interval);
    }

    public static void async(Runnable runnable) {
        try {
            Scheduler.runAsync(DECENT_HOLOGRAMS.getPlugin(), runnable);
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static void async(Runnable runnable, long delay) {
        try {
            Scheduler.runLaterAsync(DECENT_HOLOGRAMS.getPlugin(), runnable, delay);
        } catch (IllegalPluginAccessException e) {
            DExecutor.execute(runnable);
        }
    }

    public static Scheduler.Task asyncTask(Runnable runnable, long interval) {
        return Scheduler.runTimerAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable, 0, interval);
    }

    public static Scheduler.Task asyncTask(Runnable runnable, long interval, long delay) {
        return Scheduler.runTimerAsynchronously(DECENT_HOLOGRAMS.getPlugin(), runnable, delay, interval);
    }

}
