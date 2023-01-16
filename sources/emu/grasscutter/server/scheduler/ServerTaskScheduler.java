package emu.grasscutter.server.scheduler;

import java.util.concurrent.ConcurrentHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/server/scheduler/ServerTaskScheduler.class */
public final class ServerTaskScheduler {
    private final ConcurrentHashMap<Integer, ServerTask> tasks = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<Integer, AsyncServerTask> asyncTasks = new ConcurrentHashMap<>();
    private int nextTaskId = 0;

    public void runTasks() {
        if (this.tasks.size() != 0) {
            for (ServerTask task : this.tasks.values()) {
                if (task.shouldRun()) {
                    task.run();
                }
                if (task.shouldCancel()) {
                    cancelTask(task.getTaskId());
                }
            }
            for (AsyncServerTask task2 : this.asyncTasks.values()) {
                if (!task2.hasStarted()) {
                    new Thread(task2).start();
                } else if (task2.isFinished()) {
                    this.asyncTasks.remove(Integer.valueOf(task2.getTaskId()));
                    task2.complete();
                }
            }
        }
    }

    public ServerTask getTask(int taskId) {
        return this.tasks.get(Integer.valueOf(taskId));
    }

    public AsyncServerTask getAsyncTask(int taskId) {
        return this.asyncTasks.get(Integer.valueOf(taskId));
    }

    public void cancelTask(int taskId) {
        this.tasks.remove(Integer.valueOf(taskId));
    }

    public int scheduleAsyncTask(Runnable runnable) {
        int taskId = this.nextTaskId;
        this.nextTaskId = taskId + 1;
        this.asyncTasks.put(Integer.valueOf(taskId), new AsyncServerTask(runnable, taskId));
        return taskId;
    }

    public int scheduleTask(Runnable runnable) {
        return scheduleDelayedRepeatingTask(runnable, -1, -1);
    }

    public int scheduleDelayedTask(Runnable runnable, int delay) {
        return scheduleDelayedRepeatingTask(runnable, -1, delay);
    }

    public int scheduleRepeatingTask(Runnable runnable, int period) {
        return scheduleDelayedRepeatingTask(runnable, period, 0);
    }

    public int scheduleDelayedRepeatingTask(Runnable runnable, int period, int delay) {
        int taskId = this.nextTaskId;
        this.nextTaskId = taskId + 1;
        this.tasks.put(Integer.valueOf(taskId), new ServerTask(runnable, taskId, period, delay));
        return taskId;
    }
}
