package emu.grasscutter.task.tasks;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.task.Task;
import emu.grasscutter.task.TaskHandler;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Task(taskName = "MoonCard", taskCronExpression = "0 0 0 * * ?", triggerName = "MoonCardTrigger")
/* loaded from: grasscutter.jar:emu/grasscutter/task/tasks/MoonCard.class */
public final class MoonCard extends TaskHandler {
    @Override // emu.grasscutter.task.TaskHandler
    public void onEnable() {
        Grasscutter.getLogger().debug("[Task] MoonCard task enabled.");
    }

    @Override // emu.grasscutter.task.TaskHandler
    public void onDisable() {
        Grasscutter.getLogger().debug("[Task] MoonCard task disabled.");
    }

    @Override // org.quartz.Job
    public synchronized void execute(JobExecutionContext context) throws JobExecutionException {
        if (Grasscutter.getRunMode() != Grasscutter.ServerRunMode.DISPATCH_ONLY) {
            Grasscutter.getGameServer().getPlayers().forEach(uid, player -> {
                if (player.isOnline() && player.inMoonCard()) {
                    player.getTodayMoonCard();
                }
            });
        }
    }
}
