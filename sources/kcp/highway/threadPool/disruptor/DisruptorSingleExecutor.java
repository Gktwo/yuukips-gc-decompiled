package kcp.highway.threadPool.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.WaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.ITask;
import p001ch.qos.logback.core.spi.AbstractComponentTracker;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DisruptorSingleExecutor.class */
public class DisruptorSingleExecutor implements IMessageExecutor {
    int ringBufferSize = 65536;
    private WaitStrategy strategy = new BlockingWaitStrategy();
    private Disruptor<DistriptorHandler> disruptor = null;
    private RingBuffer<DistriptorHandler> buffer = null;
    private DistriptorEventFactory eventFactory = new DistriptorEventFactory();
    private AtomicBoolean istop = new AtomicBoolean();
    private String threadName;
    private DisruptorThread currentThread;
    private static final DistriptorEventHandler HANDLER = new DistriptorEventHandler();
    static int num = 1;
    static long start = System.currentTimeMillis();
    static long lastNum = 0;

    public DisruptorSingleExecutor(String threadName) {
        this.threadName = threadName;
    }

    public void start() {
        this.disruptor = new Disruptor<>(this.eventFactory, this.ringBufferSize, new LoopThreadfactory(this));
        this.buffer = this.disruptor.getRingBuffer();
        this.disruptor.handleEventsWith(HANDLER);
        this.disruptor.start();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DisruptorSingleExecutor$LoopThreadfactory.class */
    public class LoopThreadfactory implements ThreadFactory {
        IMessageExecutor iMessageExecutor;

        public LoopThreadfactory(IMessageExecutor iMessageExecutor) {
            this.iMessageExecutor = iMessageExecutor;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable r) {
            DisruptorSingleExecutor.this.currentThread = new DisruptorThread(r, this.iMessageExecutor);
            DisruptorSingleExecutor.this.currentThread.setName(DisruptorSingleExecutor.this.threadName);
            return DisruptorSingleExecutor.this.currentThread;
        }
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public void stop() {
        if (!this.istop.get()) {
            this.disruptor.shutdown();
            this.istop.set(true);
        }
    }

    public static void main(String[] args) {
        DisruptorSingleExecutor disruptorSingleExecutor = new DisruptorSingleExecutor("aa");
        disruptorSingleExecutor.start();
        disruptorSingleExecutor.execute(() -> {
            System.out.println("hahaha");
        });
        try {
            Thread.sleep(AbstractComponentTracker.LINGERING_TIMEOUT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AtomicBoolean getIstop() {
        return this.istop;
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public boolean isFull() {
        return !this.buffer.hasAvailableCapacity(1);
    }

    @Override // kcp.highway.threadPool.IMessageExecutor
    public void execute(ITask iTask) {
        Thread.currentThread();
        long next = this.buffer.next();
        this.buffer.get(next).setTask(iTask);
        this.buffer.publish(next);
    }
}
