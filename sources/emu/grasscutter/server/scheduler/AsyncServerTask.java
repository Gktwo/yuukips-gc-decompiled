package emu.grasscutter.server.scheduler;

import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/scheduler/AsyncServerTask.class */
public final class AsyncServerTask implements Runnable {
    private final Runnable task;
    private final int taskId;
    @Nullable
    private final Runnable callback;
    private boolean started;
    private boolean finished;
    @Nullable
    private Object result;

    public int getTaskId() {
        return this.taskId;
    }

    public AsyncServerTask(Runnable task, int taskId) {
        this(task, null, taskId);
    }

    public AsyncServerTask(Runnable task, @Nullable Runnable callback, int taskId) {
        this.started = false;
        this.finished = false;
        this.result = null;
        this.task = task;
        this.callback = callback;
        this.taskId = taskId;
    }

    public boolean hasStarted() {
        return this.started;
    }

    public boolean isFinished() {
        return this.finished;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.started = true;
        this.task.run();
        this.finished = true;
    }

    public void complete() {
        if (this.callback != null) {
            this.callback.run();
        }
    }

    public void setResult(@Nullable Object result) {
        this.result = result;
    }

    @Nullable
    public Object getResult() {
        return this.result;
    }
}
