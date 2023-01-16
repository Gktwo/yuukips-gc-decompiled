package org.quartz.simpl;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jline.reader.LineReader;
import org.quartz.SchedulerConfigException;
import org.quartz.spi.ThreadPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/simpl/SimpleThreadPool.class */
public class SimpleThreadPool implements ThreadPool {
    private ThreadGroup threadGroup;
    private List<WorkerThread> workers;
    private String threadNamePrefix;
    private String schedulerInstanceName;
    private int count = -1;
    private int prio = 5;
    private boolean isShutdown = false;
    private boolean handoffPending = false;
    private boolean inheritLoader = false;
    private boolean inheritGroup = true;
    private boolean makeThreadsDaemons = false;
    private final Object nextRunnableLock = new Object();
    private LinkedList<WorkerThread> availWorkers = new LinkedList<>();
    private LinkedList<WorkerThread> busyWorkers = new LinkedList<>();
    private final Logger log = LoggerFactory.getLogger(getClass());

    public SimpleThreadPool() {
    }

    public SimpleThreadPool(int threadCount, int threadPriority) {
        setThreadCount(threadCount);
        setThreadPriority(threadPriority);
    }

    public Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.ThreadPool
    public int getPoolSize() {
        return getThreadCount();
    }

    public void setThreadCount(int count) {
        this.count = count;
    }

    public int getThreadCount() {
        return this.count;
    }

    public void setThreadPriority(int prio) {
        this.prio = prio;
    }

    public int getThreadPriority() {
        return this.prio;
    }

    public void setThreadNamePrefix(String prfx) {
        this.threadNamePrefix = prfx;
    }

    public String getThreadNamePrefix() {
        return this.threadNamePrefix;
    }

    public boolean isThreadsInheritContextClassLoaderOfInitializingThread() {
        return this.inheritLoader;
    }

    public void setThreadsInheritContextClassLoaderOfInitializingThread(boolean inheritLoader) {
        this.inheritLoader = inheritLoader;
    }

    public boolean isThreadsInheritGroupOfInitializingThread() {
        return this.inheritGroup;
    }

    public void setThreadsInheritGroupOfInitializingThread(boolean inheritGroup) {
        this.inheritGroup = inheritGroup;
    }

    public boolean isMakeThreadsDaemons() {
        return this.makeThreadsDaemons;
    }

    public void setMakeThreadsDaemons(boolean makeThreadsDaemons) {
        this.makeThreadsDaemons = makeThreadsDaemons;
    }

    @Override // org.quartz.spi.ThreadPool
    public void setInstanceId(String schedInstId) {
    }

    @Override // org.quartz.spi.ThreadPool
    public void setInstanceName(String schedName) {
        this.schedulerInstanceName = schedName;
    }

    @Override // org.quartz.spi.ThreadPool
    public void initialize() throws SchedulerConfigException {
        if (this.workers != null && this.workers.size() > 0) {
            return;
        }
        if (this.count <= 0) {
            throw new SchedulerConfigException("Thread count must be > 0");
        } else if (this.prio <= 0 || this.prio > 9) {
            throw new SchedulerConfigException("Thread priority must be > 0 and <= 9");
        } else {
            if (isThreadsInheritGroupOfInitializingThread()) {
                this.threadGroup = Thread.currentThread().getThreadGroup();
            } else {
                this.threadGroup = Thread.currentThread().getThreadGroup();
                ThreadGroup parent = this.threadGroup;
                while (!parent.getName().equals(LineReader.MAIN)) {
                    this.threadGroup = parent;
                    parent = this.threadGroup.getParent();
                }
                this.threadGroup = new ThreadGroup(parent, this.schedulerInstanceName + "-SimpleThreadPool");
                if (isMakeThreadsDaemons()) {
                    this.threadGroup.setDaemon(true);
                }
            }
            if (isThreadsInheritContextClassLoaderOfInitializingThread()) {
                getLog().info("Job execution threads will use class loader of thread: " + Thread.currentThread().getName());
            }
            for (WorkerThread wt : createWorkerThreads(this.count)) {
                wt.start();
                this.availWorkers.add(wt);
            }
        }
    }

    protected List<WorkerThread> createWorkerThreads(int createCount) {
        this.workers = new LinkedList();
        for (int i = 1; i <= createCount; i++) {
            String threadPrefix = getThreadNamePrefix();
            if (threadPrefix == null) {
                threadPrefix = this.schedulerInstanceName + "_Worker";
            }
            WorkerThread wt = new WorkerThread(this, this, this.threadGroup, threadPrefix + "-" + i, getThreadPriority(), isMakeThreadsDaemons());
            if (isThreadsInheritContextClassLoaderOfInitializingThread()) {
                wt.setContextClassLoader(Thread.currentThread().getContextClassLoader());
            }
            this.workers.add(wt);
        }
        return this.workers;
    }

    public void shutdown() {
        shutdown(true);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x0074
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.spi.ThreadPool
    public void shutdown(boolean r5) {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.simpl.SimpleThreadPool.shutdown(boolean):void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0031
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.spi.ThreadPool
    public boolean runInThread(java.lang.Runnable r11) {
        /*
            r10 = this;
            r0 = r11
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
        L_0x0006:
            r0 = r10
            java.lang.Object r0 = r0.nextRunnableLock
            r1 = r0
            r12 = r1
            monitor-enter(r0)
            r0 = r10
            r1 = 1
            r0.handoffPending = r1     // Catch: all -> 0x009a
        L_0x0012:
            r0 = r10
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.availWorkers     // Catch: all -> 0x009a
            int r0 = r0.size()     // Catch: all -> 0x009a
            r1 = 1
            if (r0 >= r1) goto L_0x0035
            r0 = r10
            boolean r0 = r0.isShutdown     // Catch: all -> 0x009a
            if (r0 != 0) goto L_0x0035
            r0 = r10
            java.lang.Object r0 = r0.nextRunnableLock     // Catch: all -> 0x009a, InterruptedException -> 0x0031
            r1 = 500(0x1f4, double:2.47E-321)
            r0.wait(r1)     // Catch: all -> 0x009a, InterruptedException -> 0x0031
            goto L_0x0012
        L_0x0031:
            r13 = move-exception
            goto L_0x0012
        L_0x0035:
            r0 = r10
            boolean r0 = r0.isShutdown     // Catch: all -> 0x009a
            if (r0 != 0) goto L_0x0058
            r0 = r10
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.availWorkers     // Catch: all -> 0x009a
            java.lang.Object r0 = r0.removeFirst()     // Catch: all -> 0x009a
            org.quartz.simpl.SimpleThreadPool$WorkerThread r0 = (org.quartz.simpl.SimpleThreadPool.WorkerThread) r0     // Catch: all -> 0x009a
            r13 = r0
            r0 = r10
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.busyWorkers     // Catch: all -> 0x009a
            r1 = r13
            boolean r0 = r0.add(r1)     // Catch: all -> 0x009a
            r0 = r13
            r1 = r11
            r0.run(r1)     // Catch: all -> 0x009a
            goto L_0x0089
        L_0x0058:
            org.quartz.simpl.SimpleThreadPool$WorkerThread r0 = new org.quartz.simpl.SimpleThreadPool$WorkerThread     // Catch: all -> 0x009a
            r1 = r0
            r2 = r10
            r3 = r10
            r4 = r10
            java.lang.ThreadGroup r4 = r4.threadGroup     // Catch: all -> 0x009a
            java.lang.String r5 = "WorkerThread-LastJob"
            r6 = r10
            int r6 = r6.prio     // Catch: all -> 0x009a
            r7 = r10
            boolean r7 = r7.isMakeThreadsDaemons()     // Catch: all -> 0x009a
            r8 = r11
            r1.<init>(r3, r4, r5, r6, r7, r8)     // Catch: all -> 0x009a
            r13 = r0
            r0 = r10
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.busyWorkers     // Catch: all -> 0x009a
            r1 = r13
            boolean r0 = r0.add(r1)     // Catch: all -> 0x009a
            r0 = r10
            java.util.List<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.workers     // Catch: all -> 0x009a
            r1 = r13
            boolean r0 = r0.add(r1)     // Catch: all -> 0x009a
            r0 = r13
            r0.start()     // Catch: all -> 0x009a
        L_0x0089:
            r0 = r10
            java.lang.Object r0 = r0.nextRunnableLock     // Catch: all -> 0x009a
            r0.notifyAll()     // Catch: all -> 0x009a
            r0 = r10
            r1 = 0
            r0.handoffPending = r1     // Catch: all -> 0x009a
            r0 = r12
            monitor-exit(r0)     // Catch: all -> 0x009a
            goto L_0x00a1
        L_0x009a:
            r14 = move-exception
            r0 = r12
            monitor-exit(r0)     // Catch: all -> 0x009a
            r0 = r14
            throw r0
        L_0x00a1:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.simpl.SimpleThreadPool.runInThread(java.lang.Runnable):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x002d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.spi.ThreadPool
    public int blockForAvailableThreads() {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.nextRunnableLock
            r1 = r0
            r5 = r1
            monitor-enter(r0)
        L_0x0007:
            r0 = r4
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.availWorkers     // Catch: all -> 0x003b
            int r0 = r0.size()     // Catch: all -> 0x003b
            r1 = 1
            if (r0 < r1) goto L_0x0019
            r0 = r4
            boolean r0 = r0.handoffPending     // Catch: all -> 0x003b
            if (r0 == 0) goto L_0x0031
        L_0x0019:
            r0 = r4
            boolean r0 = r0.isShutdown     // Catch: all -> 0x003b
            if (r0 != 0) goto L_0x0031
            r0 = r4
            java.lang.Object r0 = r0.nextRunnableLock     // Catch: all -> 0x003b, InterruptedException -> 0x002d
            r1 = 500(0x1f4, double:2.47E-321)
            r0.wait(r1)     // Catch: all -> 0x003b, InterruptedException -> 0x002d
            goto L_0x0007
        L_0x002d:
            r6 = move-exception
            goto L_0x0007
        L_0x0031:
            r0 = r4
            java.util.LinkedList<org.quartz.simpl.SimpleThreadPool$WorkerThread> r0 = r0.availWorkers     // Catch: all -> 0x003b
            int r0 = r0.size()     // Catch: all -> 0x003b
            r1 = r5
            monitor-exit(r1)     // Catch: all -> 0x003b
            return r0
        L_0x003b:
            r7 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: all -> 0x003b
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.simpl.SimpleThreadPool.blockForAvailableThreads():int");
    }

    protected void makeAvailable(WorkerThread wt) {
        synchronized (this.nextRunnableLock) {
            if (!this.isShutdown) {
                this.availWorkers.add(wt);
            }
            this.busyWorkers.remove(wt);
            this.nextRunnableLock.notifyAll();
        }
    }

    protected void clearFromBusyWorkersList(WorkerThread wt) {
        synchronized (this.nextRunnableLock) {
            this.busyWorkers.remove(wt);
            this.nextRunnableLock.notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/quartz/simpl/SimpleThreadPool$WorkerThread.class */
    public class WorkerThread extends Thread {
        private final Object lock;
        private AtomicBoolean run;

        /* renamed from: tp */
        private SimpleThreadPool f3377tp;
        private Runnable runnable;
        private boolean runOnce;

        WorkerThread(SimpleThreadPool simpleThreadPool, SimpleThreadPool tp, ThreadGroup threadGroup, String name, int prio, boolean isDaemon) {
            this(tp, threadGroup, name, prio, isDaemon, null);
        }

        WorkerThread(SimpleThreadPool tp, ThreadGroup threadGroup, String name, int prio, boolean isDaemon, Runnable runnable) {
            super(threadGroup, name);
            this.lock = new Object();
            this.run = new AtomicBoolean(true);
            this.runnable = null;
            this.runOnce = false;
            this.f3377tp = tp;
            this.runnable = runnable;
            if (runnable != null) {
                this.runOnce = true;
            }
            setPriority(prio);
            setDaemon(isDaemon);
        }

        void shutdown() {
            this.run.set(false);
        }

        public void run(Runnable newRunnable) {
            synchronized (this.lock) {
                if (this.runnable != null) {
                    throw new IllegalStateException("Already running a Runnable!");
                }
                this.runnable = newRunnable;
                this.lock.notifyAll();
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:45:0x00bc
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 512
            */
            throw new UnsupportedOperationException("Method not decompiled: org.quartz.simpl.SimpleThreadPool.WorkerThread.run():void");
        }
    }
}
