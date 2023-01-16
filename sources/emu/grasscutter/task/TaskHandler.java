package emu.grasscutter.task;

import org.quartz.Job;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

@PersistJobDataAfterExecution
/* loaded from: grasscutter.jar:emu/grasscutter/task/TaskHandler.class */
public abstract class TaskHandler implements Job {
    public abstract void onEnable();

    public abstract void onDisable();

    public void restartExecute() throws JobExecutionException {
        execute(null);
    }
}
