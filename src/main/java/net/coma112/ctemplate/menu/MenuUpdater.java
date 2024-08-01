package net.coma112.ctemplate.menu;

import com.github.Anon8281.universalScheduler.scheduling.tasks.MyScheduledTask;
import net.coma112.ctemplate.CTemplate;

@SuppressWarnings("deprecation")
public class MenuUpdater {
    private final Menu menu;
    private boolean running = true;
    private MyScheduledTask task;

    public MenuUpdater(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        if (!running) {
            stop();
            return;
        }

        if (menu.getInventory().getViewers().contains(menu.menuUtils.getOwner())) menu.updateMenuItems();
        else stop();
    }

    public void start(int intervalTicks) {
        if (task == null) task = CTemplate.getInstance().getScheduler().runTaskTimer(CTemplate.getInstance(), this::run, intervalTicks, intervalTicks);

    }

    public void stop() {
        running = false;
        if (task != null) {
            task.cancel();
            task = null;
        }
    }
}
