package emu.grasscutter.task.tasks;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.task.Task;
import emu.grasscutter.task.TaskHandler;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Task(taskName = "Banner", taskCronExpression = "0 0/5 * * * ?", triggerName = "BannerTrigger")
/* loaded from: grasscutter.jar:emu/grasscutter/task/tasks/Banner.class */
public final class Banner extends TaskHandler {
    @Override // emu.grasscutter.task.TaskHandler
    public void onEnable() {
        Grasscutter.getLogger().debug("[Task] Banner task enabled.");
    }

    @Override // emu.grasscutter.task.TaskHandler
    public void onDisable() {
        Grasscutter.getLogger().debug("[Task] Banner task disabled.");
    }

    @Override // org.quartz.Job
    public synchronized void execute(JobExecutionContext context) throws JobExecutionException {
        if (Grasscutter.getRunMode() != Grasscutter.ServerRunMode.DISPATCH_ONLY) {
            Grasscutter.getGameServer().getGachaSystem().update(context.getNextFireTime().getTime() / 1000);
        }
    }
}
