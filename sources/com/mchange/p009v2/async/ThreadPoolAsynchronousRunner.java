package com.mchange.p009v2.async;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.p010io.IndentedWriter;
import com.mchange.p009v2.util.ResourceClosedException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.mchange.v2.async.ThreadPoolAsynchronousRunner */
/* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPoolAsynchronousRunner.class */
public final class ThreadPoolAsynchronousRunner implements AsynchronousRunner {
    static final MLogger logger;
    static final int POLL_FOR_STOP_INTERVAL = 5000;
    static final int DFLT_DEADLOCK_DETECTOR_INTERVAL = 10000;
    static final int DFLT_INTERRUPT_DELAY_AFTER_APPARENT_DEADLOCK = 60000;
    static final int DFLT_MAX_INDIVIDUAL_TASK_TIME = 0;
    static final int DFLT_MAX_EMERGENCY_THREADS = 10;
    static final long PURGE_EVERY = 500;
    int deadlock_detector_interval;
    int interrupt_delay_after_apparent_deadlock;
    int max_individual_task_time;
    int num_threads;
    boolean daemon;
    HashSet managed;
    HashSet available;
    LinkedList pendingTasks;
    Random rnd;
    Timer myTimer;
    boolean should_cancel_timer;
    TimerTask deadlockDetector;
    TimerTask replacedThreadInterruptor;
    Map stoppedThreadsToStopDates;
    String threadLabel;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !ThreadPoolAsynchronousRunner.class.desiredAssertionStatus();
        logger = MLog.getLogger(ThreadPoolAsynchronousRunner.class);
    }

    private ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4, Timer timer, boolean z2, String str) {
        this.rnd = new Random();
        this.deadlockDetector = new DeadlockDetector();
        this.replacedThreadInterruptor = null;
        this.stoppedThreadsToStopDates = new HashMap();
        this.num_threads = i;
        this.daemon = z;
        this.max_individual_task_time = i2;
        this.deadlock_detector_interval = i3;
        this.interrupt_delay_after_apparent_deadlock = i4;
        this.myTimer = timer;
        this.should_cancel_timer = z2;
        this.threadLabel = str;
        recreateThreadsAndTasks();
        timer.schedule(this.deadlockDetector, (long) i3, (long) i3);
    }

    private ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4, Timer timer, boolean z2) {
        this(i, z, i2, i3, i4, timer, z2, null);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4, Timer timer, String str) {
        this(i, z, i2, i3, i4, timer, false, str);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4, Timer timer) {
        this(i, z, i2, i3, i4, timer, false);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4, String str) {
        this(i, z, i2, i3, i4, new Timer(true), true, str);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, int i2, int i3, int i4) {
        this(i, z, i2, i3, i4, new Timer(true), true);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, Timer timer, String str) {
        this(i, z, 0, 10000, 60000, timer, false, str);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z, Timer timer) {
        this(i, z, 0, 10000, 60000, timer, false);
    }

    public ThreadPoolAsynchronousRunner(int i, boolean z) {
        this(i, z, 0, 10000, 60000, new Timer(true), true);
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public synchronized void postRunnable(Runnable runnable) {
        try {
            this.pendingTasks.add(runnable);
            notifyAll();
            if (logger.isLoggable(MLevel.FINEST)) {
                logger.log(MLevel.FINEST, this + ": Adding task to queue -- " + runnable);
            }
        } catch (NullPointerException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "NullPointerException while posting Runnable -- Probably we're closed.", (Throwable) e);
            }
            throw new ResourceClosedException("Attempted to use a ThreadPoolAsynchronousRunner in a closed or broken state.");
        }
    }

    public synchronized int getThreadCount() {
        return this.managed.size();
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner
    public void close(boolean z) {
        synchronized (this) {
            if (this.managed != null) {
                this.deadlockDetector.cancel();
                if (this.should_cancel_timer) {
                    this.myTimer.cancel();
                }
                this.myTimer = null;
                Iterator it = this.managed.iterator();
                while (it.hasNext()) {
                    PoolThread poolThread = (PoolThread) it.next();
                    poolThread.gentleStop();
                    if (z) {
                        poolThread.interrupt();
                    }
                }
                this.managed = null;
                if (!z) {
                    Iterator it2 = this.pendingTasks.iterator();
                    while (it2.hasNext()) {
                        new Thread((Runnable) it2.next()).start();
                        it2.remove();
                    }
                }
                this.available = null;
                this.pendingTasks = null;
            }
        }
    }

    @Override // com.mchange.p009v2.async.AsynchronousRunner, com.mchange.p006v1.util.ClosableResource
    public void close() {
        close(true);
    }

    public synchronized int getActiveCount() {
        return this.managed.size() - this.available.size();
    }

    public synchronized int getIdleCount() {
        return this.available.size();
    }

    public synchronized int getPendingTaskCount() {
        return this.pendingTasks.size();
    }

    public synchronized String getStatus() {
        return getMultiLineStatusString();
    }

    public synchronized String getStackTraces() {
        return getStackTraces(0);
    }

    /* access modifiers changed from: private */
    public String getStackTraces(int i) {
        if (!$assertionsDisabled && !Thread.holdsLock(this)) {
            throw new AssertionError();
        } else if (this.managed == null) {
            return null;
        } else {
            try {
                Method method = Thread.class.getMethod("getStackTrace", null);
                StringWriter stringWriter = new StringWriter(2048);
                IndentedWriter indentedWriter = new IndentedWriter(stringWriter);
                for (int i2 = 0; i2 < i; i2++) {
                    indentedWriter.upIndent();
                }
                Iterator it = this.managed.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    printStackTraces(indentedWriter, next, (Object[]) method.invoke(next, null));
                }
                for (int i3 = 0; i3 < i; i3++) {
                    indentedWriter.downIndent();
                }
                indentedWriter.flush();
                String stringWriter2 = stringWriter.toString();
                indentedWriter.close();
                return stringWriter2;
            } catch (NoSuchMethodException e) {
                if (!logger.isLoggable(MLevel.FINE)) {
                    return null;
                }
                logger.fine(this + ": stack traces unavailable because this is a pre-Java 1.5 VM.");
                return null;
            } catch (Exception e2) {
                if (!logger.isLoggable(MLevel.FINE)) {
                    return null;
                }
                logger.log(MLevel.FINE, this + ": An Exception occurred while trying to extract PoolThread stack traces.", (Throwable) e2);
                return null;
            }
        }
    }

    /* access modifiers changed from: private */
    public String getJvmStackTraces(int i) {
        try {
            Map map = (Map) Thread.class.getMethod("getAllStackTraces", null).invoke(null, null);
            StringWriter stringWriter = new StringWriter(2048);
            IndentedWriter indentedWriter = new IndentedWriter(stringWriter);
            for (int i2 = 0; i2 < i; i2++) {
                indentedWriter.upIndent();
            }
            for (Map.Entry entry : map.entrySet()) {
                printStackTraces(indentedWriter, entry.getKey(), (Object[]) entry.getValue());
            }
            for (int i3 = 0; i3 < i; i3++) {
                indentedWriter.downIndent();
            }
            indentedWriter.flush();
            String stringWriter2 = stringWriter.toString();
            indentedWriter.close();
            return stringWriter2;
        } catch (NoSuchMethodException e) {
            if (!logger.isLoggable(MLevel.FINE)) {
                return null;
            }
            logger.fine(this + ": JVM stack traces unavailable because this is a pre-Java 1.5 VM.");
            return null;
        } catch (Exception e2) {
            if (!logger.isLoggable(MLevel.FINE)) {
                return null;
            }
            logger.log(MLevel.FINE, this + ": An Exception occurred while trying to extract PoolThread stack traces.", (Throwable) e2);
            return null;
        }
    }

    private void printStackTraces(IndentedWriter indentedWriter, Object obj, Object[] objArr) throws IOException {
        indentedWriter.println(obj);
        indentedWriter.upIndent();
        for (Object obj2 : objArr) {
            indentedWriter.println(obj2);
        }
        indentedWriter.downIndent();
    }

    public synchronized String getMultiLineStatusString() {
        return getMultiLineStatusString(0);
    }

    /* access modifiers changed from: private */
    public String getMultiLineStatusString(int i) {
        try {
            StringWriter stringWriter = new StringWriter(2048);
            IndentedWriter indentedWriter = new IndentedWriter(stringWriter);
            for (int i2 = 0; i2 < i; i2++) {
                indentedWriter.upIndent();
            }
            if (this.managed == null) {
                indentedWriter.print("[");
                indentedWriter.print(this);
                indentedWriter.println(" closed.]");
            } else {
                HashSet hashSet = (HashSet) this.managed.clone();
                hashSet.removeAll(this.available);
                indentedWriter.print("Managed Threads: ");
                indentedWriter.println(this.managed.size());
                indentedWriter.print("Active Threads: ");
                indentedWriter.println(hashSet.size());
                indentedWriter.println("Active Tasks: ");
                indentedWriter.upIndent();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    PoolThread poolThread = (PoolThread) it.next();
                    indentedWriter.println(poolThread.getCurrentTask());
                    indentedWriter.upIndent();
                    indentedWriter.print("on thread: ");
                    indentedWriter.println(poolThread.getName());
                    indentedWriter.downIndent();
                }
                indentedWriter.downIndent();
                indentedWriter.println("Pending Tasks: ");
                indentedWriter.upIndent();
                int size = this.pendingTasks.size();
                for (int i3 = 0; i3 < size; i3++) {
                    indentedWriter.println(this.pendingTasks.get(i3));
                }
                indentedWriter.downIndent();
            }
            for (int i4 = 0; i4 < i; i4++) {
                indentedWriter.downIndent();
            }
            indentedWriter.flush();
            String stringWriter2 = stringWriter.toString();
            indentedWriter.close();
            return stringWriter2;
        } catch (IOException e) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Huh? An IOException when working with a StringWriter?!?", (Throwable) e);
            }
            throw new RuntimeException("Huh? An IOException when working with a StringWriter?!? " + e);
        }
    }

    private void appendStatusString(StringBuffer stringBuffer) {
        if (this.managed == null) {
            stringBuffer.append("[closed]");
            return;
        }
        HashSet hashSet = (HashSet) this.managed.clone();
        hashSet.removeAll(this.available);
        stringBuffer.append("[num_managed_threads: ");
        stringBuffer.append(this.managed.size());
        stringBuffer.append(", num_active: ");
        stringBuffer.append(hashSet.size());
        stringBuffer.append("; activeTasks: ");
        boolean z = true;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(", ");
            }
            PoolThread poolThread = (PoolThread) it.next();
            stringBuffer.append(poolThread.getCurrentTask());
            stringBuffer.append(" (");
            stringBuffer.append(poolThread.getName());
            stringBuffer.append(')');
        }
        stringBuffer.append("; pendingTasks: ");
        int size = this.pendingTasks.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.pendingTasks.get(i));
        }
        stringBuffer.append(']');
    }

    /* access modifiers changed from: private */
    public void recreateThreadsAndTasks() {
        if (this.managed != null) {
            Date date = new Date();
            Iterator it = this.managed.iterator();
            while (it.hasNext()) {
                PoolThread poolThread = (PoolThread) it.next();
                poolThread.gentleStop();
                this.stoppedThreadsToStopDates.put(poolThread, date);
                ensureReplacedThreadsProcessing();
            }
        }
        this.managed = new HashSet();
        this.available = new HashSet();
        this.pendingTasks = new LinkedList();
        for (int i = 0; i < this.num_threads; i++) {
            PoolThread poolThread2 = new PoolThread(i, this.daemon);
            this.managed.add(poolThread2);
            this.available.add(poolThread2);
            poolThread2.start();
        }
    }

    /* access modifiers changed from: private */
    public void processReplacedThreads() {
        long currentTimeMillis = System.currentTimeMillis();
        Iterator it = this.stoppedThreadsToStopDates.keySet().iterator();
        while (it.hasNext()) {
            PoolThread poolThread = (PoolThread) it.next();
            if (!poolThread.isAlive()) {
                it.remove();
            } else if (currentTimeMillis - ((Date) this.stoppedThreadsToStopDates.get(poolThread)).getTime() > ((long) this.interrupt_delay_after_apparent_deadlock)) {
                if (logger.isLoggable(MLevel.WARNING)) {
                    logger.log(MLevel.WARNING, "Task " + poolThread.getCurrentTask() + " (in deadlocked PoolThread) failed to complete in maximum time " + this.interrupt_delay_after_apparent_deadlock + "ms. Trying interrupt().");
                }
                poolThread.interrupt();
                it.remove();
            }
            if (this.stoppedThreadsToStopDates.isEmpty()) {
                stopReplacedThreadsProcessing();
            }
        }
    }

    private void ensureReplacedThreadsProcessing() {
        if (this.replacedThreadInterruptor == null) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.fine("Apparently some threads have been replaced. Replacement thread processing enabled.");
            }
            this.replacedThreadInterruptor = new ReplacedThreadInterruptor();
            int i = this.interrupt_delay_after_apparent_deadlock / 4;
            this.myTimer.schedule(this.replacedThreadInterruptor, (long) i, (long) i);
        }
    }

    private void stopReplacedThreadsProcessing() {
        if (this.replacedThreadInterruptor != null) {
            this.replacedThreadInterruptor.cancel();
            this.replacedThreadInterruptor = null;
            if (logger.isLoggable(MLevel.FINE)) {
                logger.fine("Apparently all replaced threads have either completed their tasks or been interrupted(). Replacement thread processing cancelled.");
            }
        }
    }

    /* access modifiers changed from: private */
    public void shuttingDown(PoolThread poolThread) {
        if (this.managed != null && this.managed.contains(poolThread)) {
            this.managed.remove(poolThread);
            this.available.remove(poolThread);
            PoolThread poolThread2 = new PoolThread(poolThread.getIndex(), this.daemon);
            this.managed.add(poolThread2);
            this.available.add(poolThread2);
            poolThread2.start();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.async.ThreadPoolAsynchronousRunner$PoolThread */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPoolAsynchronousRunner$PoolThread.class */
    public class PoolThread extends Thread {
        Runnable currentTask;
        boolean should_stop;
        int index;
        TimerTask maxIndividualTaskTimeEnforcer = null;

        PoolThread(int i, boolean z) {
            setName((ThreadPoolAsynchronousRunner.this.threadLabel == null ? getClass().getName() : ThreadPoolAsynchronousRunner.this.threadLabel) + "-#" + i);
            setDaemon(z);
            this.index = i;
        }

        public int getIndex() {
            return this.index;
        }

        void gentleStop() {
            this.should_stop = true;
        }

        Runnable getCurrentTask() {
            return this.currentTask;
        }

        private void setMaxIndividualTaskTimeEnforcer() {
            this.maxIndividualTaskTimeEnforcer = new MaxIndividualTaskTimeEnforcer(this);
            ThreadPoolAsynchronousRunner.this.myTimer.schedule(this.maxIndividualTaskTimeEnforcer, (long) ThreadPoolAsynchronousRunner.this.max_individual_task_time);
        }

        private void cancelMaxIndividualTaskTimeEnforcer() {
            this.maxIndividualTaskTimeEnforcer.cancel();
            this.maxIndividualTaskTimeEnforcer = null;
        }

        private void purgeTimer() {
            ThreadPoolAsynchronousRunner.this.myTimer.purge();
            if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.FINER)) {
                ThreadPoolAsynchronousRunner.logger.log(MLevel.FINER, getClass().getName() + " -- PURGING TIMER");
            }
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:192:0x022f */
        /* JADX WARN: Type inference failed for: r0v117, types: [long] */
        /* JADX WARN: Type inference failed for: r0v149, types: [long] */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            char c;
            long j = ThreadPoolAsynchronousRunner.this.rnd.nextLong();
            while (true) {
                try {
                    try {
                        synchronized (ThreadPoolAsynchronousRunner.this) {
                            while (!this.should_stop && ThreadPoolAsynchronousRunner.this.pendingTasks.size() == 0) {
                                try {
                                    ThreadPoolAsynchronousRunner.this.wait(5000);
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                            if (!this.should_stop) {
                                if (ThreadPoolAsynchronousRunner.this.available.remove(this)) {
                                    Runnable runnable = (Runnable) ThreadPoolAsynchronousRunner.this.pendingTasks.remove(0);
                                    this.currentTask = runnable;
                                    if (ThreadPoolAsynchronousRunner.this.max_individual_task_time > 0) {
                                        try {
                                            setMaxIndividualTaskTimeEnforcer();
                                        } catch (RuntimeException e) {
                                            if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                                                ThreadPoolAsynchronousRunner.logger.log(MLevel.WARNING, this + " -- caught unexpected Exception while executing posted task.", (Throwable) e);
                                            }
                                            c = j;
                                            if (this.maxIndividualTaskTimeEnforcer != null) {
                                                cancelMaxIndividualTaskTimeEnforcer();
                                                long j2 = j ^ (j << 21);
                                                long j3 = j2 ^ (j2 >>> 35);
                                                char c2 = j3 ^ (j3 << 4);
                                                int i = ((c2 % 500) > 0 ? 1 : ((c2 % 500) == 0 ? 0 : -1));
                                                c = c2;
                                                if (i == 0) {
                                                    purgeTimer();
                                                    c = c2;
                                                }
                                            }
                                            synchronized (ThreadPoolAsynchronousRunner.this) {
                                                try {
                                                    if (this.should_stop) {
                                                        break;
                                                    } else if (ThreadPoolAsynchronousRunner.this.available == null || ThreadPoolAsynchronousRunner.this.available.add(this)) {
                                                        this.currentTask = null;
                                                    } else {
                                                        throw new InternalError("An apparently available PoolThread tried to check itself in!!!");
                                                    }
                                                } catch (Throwable th2) {
                                                    throw th2;
                                                }
                                            }
                                        } catch (Throwable th3) {
                                            if (this.maxIndividualTaskTimeEnforcer != null) {
                                                cancelMaxIndividualTaskTimeEnforcer();
                                                long j4 = j ^ (j << 21);
                                                long j5 = j4 ^ (j4 >>> 35);
                                                if ((j5 ^ (j5 << 4)) % 500 == 0) {
                                                    purgeTimer();
                                                }
                                            }
                                            synchronized (ThreadPoolAsynchronousRunner.this) {
                                                try {
                                                    if (!this.should_stop) {
                                                        if (ThreadPoolAsynchronousRunner.this.available == null || ThreadPoolAsynchronousRunner.this.available.add(this)) {
                                                            this.currentTask = null;
                                                            throw th3;
                                                        }
                                                        throw new InternalError("An apparently available PoolThread tried to check itself in!!!");
                                                    }
                                                } catch (Throwable th4) {
                                                    throw th4;
                                                }
                                            }
                                        }
                                    }
                                    runnable.run();
                                    c = j;
                                    if (this.maxIndividualTaskTimeEnforcer != null) {
                                        cancelMaxIndividualTaskTimeEnforcer();
                                        long j6 = (j == 1 ? 1 : 0) ^ (j << 21);
                                        long j7 = j6 ^ (j6 >>> 35);
                                        char c3 = j7 ^ (j7 << 4);
                                        int i2 = ((c3 % 500) > 0 ? 1 : ((c3 % 500) == 0 ? 0 : -1));
                                        c = c3;
                                        if (i2 == 0) {
                                            purgeTimer();
                                            c = c3;
                                        }
                                    }
                                    synchronized (ThreadPoolAsynchronousRunner.this) {
                                        try {
                                            if (!this.should_stop) {
                                                if (ThreadPoolAsynchronousRunner.this.available == null || ThreadPoolAsynchronousRunner.this.available.add(this)) {
                                                    this.currentTask = null;
                                                } else {
                                                    throw new InternalError("An apparently available PoolThread tried to check itself in!!!");
                                                }
                                            }
                                        } catch (Throwable th5) {
                                            throw th5;
                                        }
                                    }
                                    break;
                                }
                                throw new InternalError("An unavailable PoolThread tried to check itself out!!!");
                            }
                            break;
                        }
                        j = c;
                    } catch (Throwable th6) {
                        synchronized (ThreadPoolAsynchronousRunner.this) {
                            try {
                                ThreadPoolAsynchronousRunner.this.shuttingDown(this);
                                throw th6;
                            } catch (Throwable th7) {
                                throw th7;
                            }
                        }
                    }
                } catch (Error e2) {
                    if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                        ThreadPoolAsynchronousRunner.logger.log(MLevel.WARNING, "An Error forced the closing of " + this + ". Will attempt to reconstruct, but this might mean that something bad is happening.", (Throwable) e2);
                    }
                    throw e2;
                } catch (InterruptedException e3) {
                    synchronized (ThreadPoolAsynchronousRunner.this) {
                        try {
                            ThreadPoolAsynchronousRunner.this.shuttingDown(this);
                            return;
                        } catch (Throwable th8) {
                            throw th8;
                        }
                    }
                } catch (RuntimeException e4) {
                    if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                        ThreadPoolAsynchronousRunner.logger.log(MLevel.WARNING, "An unexpected RuntimException is implicated in the closing of " + this, (Throwable) e4);
                    }
                    throw e4;
                }
            }
            synchronized (ThreadPoolAsynchronousRunner.this) {
                try {
                    ThreadPoolAsynchronousRunner.this.shuttingDown(this);
                } catch (Throwable th9) {
                    throw th9;
                }
            }
        }
    }

    /* renamed from: com.mchange.v2.async.ThreadPoolAsynchronousRunner$DeadlockDetector */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPoolAsynchronousRunner$DeadlockDetector.class */
    class DeadlockDetector extends TimerTask {
        LinkedList last = null;
        LinkedList current = null;

        DeadlockDetector() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            synchronized (ThreadPoolAsynchronousRunner.this) {
                if (ThreadPoolAsynchronousRunner.this.pendingTasks.size() == 0) {
                    this.last = null;
                    if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.FINEST)) {
                        ThreadPoolAsynchronousRunner.logger.log(MLevel.FINEST, this + " -- Running DeadlockDetector[Exiting. No pending tasks.]");
                    }
                    return;
                }
                this.current = (LinkedList) ThreadPoolAsynchronousRunner.this.pendingTasks.clone();
                if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.FINEST)) {
                    ThreadPoolAsynchronousRunner.logger.log(MLevel.FINEST, this + " -- Running DeadlockDetector[last->" + this.last + ",current->" + this.current + ']');
                }
                if (this.current.equals(this.last)) {
                    if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                        ThreadPoolAsynchronousRunner.logger.warning(this + " -- APPARENT DEADLOCK!!! Creating emergency threads for unassigned pending tasks!");
                        StringWriter stringWriter = new StringWriter(4096);
                        PrintWriter printWriter = new PrintWriter(stringWriter);
                        printWriter.print(this);
                        printWriter.println(" -- APPARENT DEADLOCK!!! Complete Status: ");
                        printWriter.print(ThreadPoolAsynchronousRunner.this.getMultiLineStatusString(1));
                        printWriter.println("Pool thread stack traces:");
                        String stackTraces = ThreadPoolAsynchronousRunner.this.getStackTraces(1);
                        if (stackTraces == null) {
                            printWriter.println("\t[Stack traces of deadlocked task threads not available.]");
                        } else {
                            printWriter.print(stackTraces);
                        }
                        printWriter.flush();
                        ThreadPoolAsynchronousRunner.logger.warning(stringWriter.toString());
                        printWriter.close();
                    }
                    if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.FINEST)) {
                        StringWriter stringWriter2 = new StringWriter(4096);
                        PrintWriter printWriter2 = new PrintWriter(stringWriter2);
                        printWriter2.print(this);
                        printWriter2.println(" -- APPARENT DEADLOCK extra info, full JVM thread dump: ");
                        String jvmStackTraces = ThreadPoolAsynchronousRunner.this.getJvmStackTraces(1);
                        if (jvmStackTraces == null) {
                            printWriter2.println("\t[Full JVM thread dump not available.]");
                        } else {
                            printWriter2.print(jvmStackTraces);
                        }
                        printWriter2.flush();
                        ThreadPoolAsynchronousRunner.logger.finest(stringWriter2.toString());
                        printWriter2.close();
                    }
                    ThreadPoolAsynchronousRunner.this.recreateThreadsAndTasks();
                    z = true;
                }
                if (z) {
                    ThreadPerTaskAsynchronousRunner threadPerTaskAsynchronousRunner = new ThreadPerTaskAsynchronousRunner(10, (long) ThreadPoolAsynchronousRunner.this.max_individual_task_time);
                    Iterator it = this.current.iterator();
                    while (it.hasNext()) {
                        threadPerTaskAsynchronousRunner.postRunnable((Runnable) it.next());
                    }
                    threadPerTaskAsynchronousRunner.close(false);
                    this.last = null;
                } else {
                    this.last = this.current;
                }
                this.current = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.async.ThreadPoolAsynchronousRunner$MaxIndividualTaskTimeEnforcer */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPoolAsynchronousRunner$MaxIndividualTaskTimeEnforcer.class */
    public class MaxIndividualTaskTimeEnforcer extends TimerTask {

        /* renamed from: pt */
        PoolThread f392pt;
        Thread interruptMe;
        String threadStr;
        String fixedTaskStr;

        MaxIndividualTaskTimeEnforcer(PoolThread poolThread) {
            this.f392pt = poolThread;
            this.interruptMe = poolThread;
            this.threadStr = poolThread.toString();
            this.fixedTaskStr = null;
        }

        MaxIndividualTaskTimeEnforcer(Thread thread, String str, String str2) {
            this.f392pt = null;
            this.interruptMe = thread;
            this.threadStr = str;
            this.fixedTaskStr = str2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            String str;
            if (this.fixedTaskStr != null) {
                str = this.fixedTaskStr;
            } else if (this.f392pt != null) {
                synchronized (ThreadPoolAsynchronousRunner.this) {
                    str = String.valueOf(this.f392pt.getCurrentTask());
                }
            } else {
                str = "Unknown task?!";
            }
            if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                ThreadPoolAsynchronousRunner.logger.warning("A task has exceeded the maximum allowable task time. Will interrupt() thread [" + this.threadStr + "], with current task: " + str);
            }
            this.interruptMe.interrupt();
            if (ThreadPoolAsynchronousRunner.logger.isLoggable(MLevel.WARNING)) {
                ThreadPoolAsynchronousRunner.logger.warning("Thread [" + this.threadStr + "] interrupted.");
            }
        }
    }

    private void runInEmergencyThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.start();
        if (this.max_individual_task_time > 0) {
            this.myTimer.schedule(new MaxIndividualTaskTimeEnforcer(thread, thread + " [One-off emergency thread!!!]", runnable.toString()), (long) this.max_individual_task_time);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.async.ThreadPoolAsynchronousRunner$ReplacedThreadInterruptor */
    /* loaded from: grasscutter.jar:com/mchange/v2/async/ThreadPoolAsynchronousRunner$ReplacedThreadInterruptor.class */
    public class ReplacedThreadInterruptor extends TimerTask {
        ReplacedThreadInterruptor() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            synchronized (ThreadPoolAsynchronousRunner.this) {
                ThreadPoolAsynchronousRunner.this.processReplacedThreads();
            }
        }
    }
}
