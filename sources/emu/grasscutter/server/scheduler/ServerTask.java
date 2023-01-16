package emu.grasscutter.server.scheduler;

import emu.grasscutter.Grasscutter;

/* loaded from: grasscutter.jar:emu/grasscutter/server/scheduler/ServerTask.class */
public final class ServerTask implements Runnable {
    private final Runnable runnable;
    private final int taskId;
    private final int period;
    private final int delay;
    private int ticks = 0;
    private boolean considerDelay = true;

    public int getTaskId() {
        return this.taskId;
    }

    public ServerTask(Runnable runnable, int taskId, int period, int delay) {
        this.runnable = runnable;
        this.taskId = taskId;
        this.period = period;
        this.delay = delay;
    }

    public int getTicks() {
        return this.ticks;
    }

    public void cancel() {
        Grasscutter.getGameServer().getScheduler().cancelTask(this.taskId);
    }

    public boolean shouldRun() {
        int ticks = this.ticks;
        this.ticks = ticks + 1;
        if (this.delay == -1 || !this.considerDelay) {
            return this.period == -1 || ticks % this.period == 0;
        }
        this.considerDelay = false;
        return ticks == this.delay;
    }

    public boolean shouldCancel() {
        return this.period == -1 && this.ticks > this.delay;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.runnable.run();
    }
}
