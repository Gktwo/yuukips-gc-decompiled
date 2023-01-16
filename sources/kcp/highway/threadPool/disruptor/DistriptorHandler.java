package kcp.highway.threadPool.disruptor;

import kcp.highway.threadPool.ITask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DistriptorHandler.class */
public class DistriptorHandler {
    protected static final Logger logger = LoggerFactory.getLogger(DistriptorHandler.class);
    private ITask task;

    public void execute() {
        try {
            this.task.execute();
            this.task = null;
        } catch (Throwable throwable) {
            logger.error("error", throwable);
        }
    }

    public void setTask(ITask task) {
        this.task = task;
    }
}
