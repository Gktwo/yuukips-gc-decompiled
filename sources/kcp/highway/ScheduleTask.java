package kcp.highway;

import java.util.concurrent.TimeUnit;
import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.ITask;
import p013io.netty.util.HashedWheelTimer;
import p013io.netty.util.Timeout;
import p013io.netty.util.TimerTask;

/* loaded from: grasscutter.jar:kcp/highway/ScheduleTask.class */
public class ScheduleTask implements ITask, Runnable, TimerTask {
    private final IMessageExecutor messageExecutor;
    private final Ukcp ukcp;
    private final HashedWheelTimer hashedWheelTimer;

    public ScheduleTask(IMessageExecutor messageExecutor, Ukcp ukcp, HashedWheelTimer hashedWheelTimer) {
        this.messageExecutor = messageExecutor;
        this.ukcp = ukcp;
        this.hashedWheelTimer = hashedWheelTimer;
    }

    @Override // kcp.highway.threadPool.ITask
    public void execute() {
        try {
            Ukcp ukcp = this.ukcp;
            long now = System.currentTimeMillis();
            if (ukcp.getTimeoutMillis() != 0 && now - ukcp.getTimeoutMillis() > ukcp.getLastRecieveTime()) {
                ukcp.internalClose();
            }
            if (ukcp.isActive()) {
                long timeLeft = ukcp.getTsUpdate() - now;
                if (timeLeft > 0) {
                    this.hashedWheelTimer.newTimeout(this, timeLeft, TimeUnit.MILLISECONDS);
                    return;
                }
                this.hashedWheelTimer.newTimeout(this, ukcp.flush(now), TimeUnit.MILLISECONDS);
                if (!ukcp.getWriteBuffer().isEmpty() && ukcp.canSend(false)) {
                    ukcp.notifyWriteEvent();
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.messageExecutor.execute(this);
    }

    @Override // p013io.netty.util.TimerTask
    public void run(Timeout timeout) {
        run();
    }
}
