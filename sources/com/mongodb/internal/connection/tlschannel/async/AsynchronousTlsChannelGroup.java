package com.mongodb.internal.connection.tlschannel.async;

import com.mongodb.internal.connection.tlschannel.NeedsReadException;
import com.mongodb.internal.connection.tlschannel.NeedsTaskException;
import com.mongodb.internal.connection.tlschannel.NeedsWriteException;
import com.mongodb.internal.connection.tlschannel.TlsChannel;
import com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet;
import com.mongodb.internal.connection.tlschannel.util.Util;
import java.io.IOException;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadPendingException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ShutdownChannelGroupException;
import java.nio.channels.SocketChannel;
import java.nio.channels.WritePendingException;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup.class */
public class AsynchronousTlsChannelGroup {
    private static final int queueLengthMultiplier = 32;

    /* renamed from: id */
    private final int f459id;
    private final AtomicBoolean loggedTaskWarning;
    private final Selector selector;
    final ExecutorService executor;
    private final ScheduledThreadPoolExecutor timeoutExecutor;
    private final Thread selectorThread;
    private final ConcurrentLinkedQueue<RegisteredSocket> pendingRegistrations;
    private volatile Shutdown shutdown;
    private LongAdder selectionCount;
    private LongAdder startedReads;
    private LongAdder startedWrites;
    private LongAdder successfulReads;
    private LongAdder successfulWrites;
    private LongAdder failedReads;
    private LongAdder failedWrites;
    private LongAdder cancelledReads;
    private LongAdder cancelledWrites;
    private AtomicInteger currentRegistrations;
    private LongAdder currentReads;
    private LongAdder currentWrites;
    private static final Logger logger = LoggerFactory.getLogger(AsynchronousTlsChannelGroup.class);
    private static AtomicInteger globalGroupCount = new AtomicInteger();

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup$Shutdown.class */
    public enum Shutdown {
        No,
        Wait,
        Immediate
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup$RegisteredSocket.class */
    public class RegisteredSocket {
        final TlsChannel tlsChannel;
        final SocketChannel socketChannel;
        SelectionKey key;
        ReadOperation readOperation;
        WriteOperation writeOperation;
        final CountDownLatch registered = new CountDownLatch(1);
        final Lock readLock = new ReentrantLock();
        final Lock writeLock = new ReentrantLock();
        final AtomicInteger pendingOps = new AtomicInteger();

        RegisteredSocket(TlsChannel tlsChannel, SocketChannel socketChannel) throws ClosedChannelException {
            this.tlsChannel = tlsChannel;
            this.socketChannel = socketChannel;
        }

        public void close() {
            AsynchronousTlsChannelGroup.this.doCancelRead(this, null);
            AsynchronousTlsChannelGroup.this.doCancelWrite(this, null);
            if (this.key != null) {
                this.key.cancel();
            }
            AsynchronousTlsChannelGroup.this.currentRegistrations.getAndDecrement();
            AsynchronousTlsChannelGroup.this.selector.wakeup();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup$Operation.class */
    private static abstract class Operation {
        final ByteBufferSet bufferSet;
        final LongConsumer onSuccess;
        final Consumer<Throwable> onFailure;
        Future<?> timeoutFuture;

        Operation(ByteBufferSet bufferSet, LongConsumer onSuccess, Consumer<Throwable> onFailure) {
            this.bufferSet = bufferSet;
            this.onSuccess = onSuccess;
            this.onFailure = onFailure;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup$ReadOperation.class */
    public static final class ReadOperation extends Operation {
        ReadOperation(ByteBufferSet bufferSet, LongConsumer onSuccess, Consumer<Throwable> onFailure) {
            super(bufferSet, onSuccess, onFailure);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup$WriteOperation.class */
    public static final class WriteOperation extends Operation {
        long consumesBytes = 0;

        WriteOperation(ByteBufferSet bufferSet, LongConsumer onSuccess, Consumer<Throwable> onFailure) {
            super(bufferSet, onSuccess, onFailure);
        }
    }

    public AsynchronousTlsChannelGroup(int nThreads) {
        this.f459id = globalGroupCount.getAndIncrement();
        this.loggedTaskWarning = new AtomicBoolean();
        this.timeoutExecutor = new ScheduledThreadPoolExecutor(1, runnable -> {
            return new Thread(runnable, String.format("async-channel-group-%d-timeout-thread", Integer.valueOf(this.f459id)));
        });
        this.selectorThread = new Thread(this::loop, String.format("async-channel-group-%d-selector", Integer.valueOf(this.f459id)));
        this.pendingRegistrations = new ConcurrentLinkedQueue<>();
        this.shutdown = Shutdown.No;
        this.selectionCount = new LongAdder();
        this.startedReads = new LongAdder();
        this.startedWrites = new LongAdder();
        this.successfulReads = new LongAdder();
        this.successfulWrites = new LongAdder();
        this.failedReads = new LongAdder();
        this.failedWrites = new LongAdder();
        this.cancelledReads = new LongAdder();
        this.cancelledWrites = new LongAdder();
        this.currentRegistrations = new AtomicInteger();
        this.currentReads = new LongAdder();
        this.currentWrites = new LongAdder();
        try {
            this.selector = Selector.open();
            this.timeoutExecutor.setRemoveOnCancelPolicy(true);
            this.executor = new ThreadPoolExecutor(nThreads, nThreads, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(nThreads * 32), runnable -> {
                return new Thread(runnable, String.format("async-channel-group-%d-handler-executor", Integer.valueOf(this.f459id)));
            }, new ThreadPoolExecutor.CallerRunsPolicy());
            this.selectorThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public AsynchronousTlsChannelGroup() {
        this(Runtime.getRuntime().availableProcessors());
    }

    /* access modifiers changed from: package-private */
    public RegisteredSocket registerSocket(TlsChannel reader, SocketChannel socketChannel) throws ClosedChannelException {
        if (this.shutdown != Shutdown.No) {
            throw new ShutdownChannelGroupException();
        }
        RegisteredSocket socket = new RegisteredSocket(reader, socketChannel);
        this.currentRegistrations.getAndIncrement();
        this.pendingRegistrations.add(socket);
        this.selector.wakeup();
        return socket;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r5.readOperation != r6) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doCancelRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.RegisteredSocket r5, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.ReadOperation r6) {
        /*
            r4 = this;
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.lock()
            r0 = r6
            if (r0 == 0) goto L_0x0015
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = r0.readOperation     // Catch: all -> 0x0064
            r1 = r6
            if (r0 == r1) goto L_0x0020
        L_0x0015:
            r0 = r6
            if (r0 != 0) goto L_0x0057
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = r0.readOperation     // Catch: all -> 0x0064
            if (r0 == 0) goto L_0x0057
        L_0x0020:
            r0 = r6
            if (r0 != 0) goto L_0x0037
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = r0.readOperation     // Catch: all -> 0x0064
            java.util.function.Consumer r0 = r0.onFailure     // Catch: all -> 0x0064
            java.util.concurrent.CancellationException r1 = new java.util.concurrent.CancellationException     // Catch: all -> 0x0064
            r2 = r1
            r2.<init>()     // Catch: all -> 0x0064
            r0.accept(r1)     // Catch: all -> 0x0064
        L_0x0037:
            r0 = r5
            r1 = 0
            r0.readOperation = r1     // Catch: all -> 0x0064
            r0 = r4
            java.util.concurrent.atomic.LongAdder r0 = r0.cancelledReads     // Catch: all -> 0x0064
            r0.increment()     // Catch: all -> 0x0064
            r0 = r4
            java.util.concurrent.atomic.LongAdder r0 = r0.currentReads     // Catch: all -> 0x0064
            r0.decrement()     // Catch: all -> 0x0064
            r0 = 1
            r7 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r7
            return r0
        L_0x0057:
            r0 = 0
            r7 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r7
            return r0
        L_0x0064:
            r8 = move-exception
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.readLock
            r0.unlock()
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.doCancelRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation):boolean");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        if (r5.writeOperation != r6) goto L_0x0015;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean doCancelWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.RegisteredSocket r5, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.WriteOperation r6) {
        /*
            r4 = this;
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.writeLock
            r0.lock()
            r0 = r6
            if (r0 == 0) goto L_0x0015
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = r0.writeOperation     // Catch: all -> 0x0064
            r1 = r6
            if (r0 == r1) goto L_0x0020
        L_0x0015:
            r0 = r6
            if (r0 != 0) goto L_0x0057
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = r0.writeOperation     // Catch: all -> 0x0064
            if (r0 == 0) goto L_0x0057
        L_0x0020:
            r0 = r6
            if (r0 != 0) goto L_0x0037
            r0 = r5
            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = r0.writeOperation     // Catch: all -> 0x0064
            java.util.function.Consumer r0 = r0.onFailure     // Catch: all -> 0x0064
            java.util.concurrent.CancellationException r1 = new java.util.concurrent.CancellationException     // Catch: all -> 0x0064
            r2 = r1
            r2.<init>()     // Catch: all -> 0x0064
            r0.accept(r1)     // Catch: all -> 0x0064
        L_0x0037:
            r0 = r5
            r1 = 0
            r0.writeOperation = r1     // Catch: all -> 0x0064
            r0 = r4
            java.util.concurrent.atomic.LongAdder r0 = r0.cancelledWrites     // Catch: all -> 0x0064
            r0.increment()     // Catch: all -> 0x0064
            r0 = r4
            java.util.concurrent.atomic.LongAdder r0 = r0.currentWrites     // Catch: all -> 0x0064
            r0.decrement()     // Catch: all -> 0x0064
            r0 = 1
            r7 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.writeLock
            r0.unlock()
            r0 = r7
            return r0
        L_0x0057:
            r0 = 0
            r7 = r0
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.writeLock
            r0.unlock()
            r0 = r7
            return r0
        L_0x0064:
            r8 = move-exception
            r0 = r5
            java.util.concurrent.locks.Lock r0 = r0.writeLock
            r0.unlock()
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.doCancelWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation):boolean");
    }

    /* access modifiers changed from: package-private */
    public ReadOperation startRead(RegisteredSocket socket, ByteBufferSet buffer, long timeout, TimeUnit unit, LongConsumer onSuccess, Consumer<Throwable> onFailure) throws ReadPendingException {
        checkTerminated();
        Util.assertTrue(buffer.hasRemaining());
        waitForSocketRegistration(socket);
        socket.readLock.lock();
        try {
            if (socket.readOperation != null) {
                throw new ReadPendingException();
            }
            ReadOperation op = new ReadOperation(buffer, onSuccess, onFailure);
            socket.pendingOps.set(5);
            if (timeout != 0) {
                op.timeoutFuture = this.timeoutExecutor.schedule(()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0059: IPUT  
                      (wrap: java.util.concurrent.ScheduledFuture<?> : 0x0056: INVOKE  (r1v7 java.util.concurrent.ScheduledFuture<?> A[REMOVE]) = 
                      (wrap: java.util.concurrent.ScheduledThreadPoolExecutor : 0x0047: IGET  (r1v6 java.util.concurrent.ScheduledThreadPoolExecutor A[REMOVE]) = 
                      (r7v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), IMMUTABLE_TYPE, THIS])
                     com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.timeoutExecutor java.util.concurrent.ScheduledThreadPoolExecutor)
                      (wrap: java.lang.Runnable : 0x004e: INVOKE_CUSTOM (r2v2 java.lang.Runnable A[REMOVE]) = 
                      (r7v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r8v0 'socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket A[D('socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket), DONT_INLINE])
                      (r0v11 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r2 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup)
                      (r3 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket)
                      (r4 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation)
                     type: DIRECT call: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.lambda$startRead$2(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation):void)
                      (r10v0 'timeout' long A[D('timeout' long)])
                      (r12v0 'unit' java.util.concurrent.TimeUnit A[D('unit' java.util.concurrent.TimeUnit)])
                     type: VIRTUAL call: java.util.concurrent.ScheduledThreadPoolExecutor.schedule(java.lang.Runnable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture)
                      (r0v11 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation)])
                     com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.ReadOperation.timeoutFuture java.util.concurrent.Future in method: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.startRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet, long, java.util.concurrent.TimeUnit, java.util.function.LongConsumer, java.util.function.Consumer<java.lang.Throwable>):com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation, file: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                    	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:462)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 31 more
                    */
                /*
                    this = this;
                    r0 = r7
                    r0.checkTerminated()
                    r0 = r9
                    boolean r0 = r0.hasRemaining()
                    com.mongodb.internal.connection.tlschannel.util.Util.assertTrue(r0)
                    r0 = r7
                    r1 = r8
                    r0.waitForSocketRegistration(r1)
                    r0 = r8
                    java.util.concurrent.locks.Lock r0 = r0.readLock
                    r0.lock()
                    r0 = r8
                    com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = r0.readOperation     // Catch: all -> 0x006e
                    if (r0 == 0) goto L_0x0028
                    java.nio.channels.ReadPendingException r0 = new java.nio.channels.ReadPendingException     // Catch: all -> 0x006e
                    r1 = r0
                    r1.<init>()     // Catch: all -> 0x006e
                    throw r0     // Catch: all -> 0x006e
                L_0x0028:
                    com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = new com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation     // Catch: all -> 0x006e
                    r1 = r0
                    r2 = r9
                    r3 = r13
                    r4 = r14
                    r1.<init>(r2, r3, r4)     // Catch: all -> 0x006e
                    r15 = r0
                    r0 = r8
                    java.util.concurrent.atomic.AtomicInteger r0 = r0.pendingOps     // Catch: all -> 0x006e
                    r1 = 5
                    r0.set(r1)     // Catch: all -> 0x006e
                    r0 = r10
                    r1 = 0
                    int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                    if (r0 == 0) goto L_0x005c
                    r0 = r15
                    r1 = r7
                    java.util.concurrent.ScheduledThreadPoolExecutor r1 = r1.timeoutExecutor     // Catch: all -> 0x006e
                    r2 = r7
                    r3 = r8
                    r4 = r15
                    com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r2 = () -> { // java.lang.Runnable.run():void
                        r2.lambda$startRead$2(r3, r4);
                    }     // Catch: all -> 0x006e
                    r3 = r10
                    r4 = r12
                    java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r3, r4)     // Catch: all -> 0x006e
                    r0.timeoutFuture = r1     // Catch: all -> 0x006e
                L_0x005c:
                    r0 = r8
                    r1 = r15
                    r0.readOperation = r1     // Catch: all -> 0x006e
                    r0 = r8
                    java.util.concurrent.locks.Lock r0 = r0.readLock
                    r0.unlock()
                    goto L_0x007c
                L_0x006e:
                    r16 = move-exception
                    r0 = r8
                    java.util.concurrent.locks.Lock r0 = r0.readLock
                    r0.unlock()
                    r0 = r16
                    throw r0
                L_0x007c:
                    r0 = r7
                    java.nio.channels.Selector r0 = r0.selector
                    java.nio.channels.Selector r0 = r0.wakeup()
                    r0 = r7
                    java.util.concurrent.atomic.LongAdder r0 = r0.startedReads
                    r0.increment()
                    r0 = r7
                    java.util.concurrent.atomic.LongAdder r0 = r0.currentReads
                    r0.increment()
                    r0 = r15
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.startRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet, long, java.util.concurrent.TimeUnit, java.util.function.LongConsumer, java.util.function.Consumer):com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation");
            }

            /* access modifiers changed from: package-private */
            public WriteOperation startWrite(RegisteredSocket socket, ByteBufferSet buffer, long timeout, TimeUnit unit, LongConsumer onSuccess, Consumer<Throwable> onFailure) throws WritePendingException {
                checkTerminated();
                Util.assertTrue(buffer.hasRemaining());
                waitForSocketRegistration(socket);
                socket.writeLock.lock();
                try {
                    if (socket.writeOperation != null) {
                        throw new WritePendingException();
                    }
                    WriteOperation op = new WriteOperation(buffer, onSuccess, onFailure);
                    socket.pendingOps.set(5);
                    if (timeout != 0) {
                        op.timeoutFuture = this.timeoutExecutor.schedule(()
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0059: IPUT  
                              (wrap: java.util.concurrent.ScheduledFuture<?> : 0x0056: INVOKE  (r1v7 java.util.concurrent.ScheduledFuture<?> A[REMOVE]) = 
                              (wrap: java.util.concurrent.ScheduledThreadPoolExecutor : 0x0047: IGET  (r1v6 java.util.concurrent.ScheduledThreadPoolExecutor A[REMOVE]) = 
                              (r7v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), IMMUTABLE_TYPE, THIS])
                             com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.timeoutExecutor java.util.concurrent.ScheduledThreadPoolExecutor)
                              (wrap: java.lang.Runnable : 0x004e: INVOKE_CUSTOM (r2v2 java.lang.Runnable A[REMOVE]) = 
                              (r7v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                              (r8v0 'socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket A[D('socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket), DONT_INLINE])
                              (r0v11 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation), DONT_INLINE])
                            
                             handle type: INVOKE_DIRECT
                             lambda: java.lang.Runnable.run():void
                             call insn: ?: INVOKE  
                              (r2 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup)
                              (r3 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket)
                              (r4 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation)
                             type: DIRECT call: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.lambda$startWrite$3(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation):void)
                              (r10v0 'timeout' long A[D('timeout' long)])
                              (r12v0 'unit' java.util.concurrent.TimeUnit A[D('unit' java.util.concurrent.TimeUnit)])
                             type: VIRTUAL call: java.util.concurrent.ScheduledThreadPoolExecutor.schedule(java.lang.Runnable, long, java.util.concurrent.TimeUnit):java.util.concurrent.ScheduledFuture)
                              (r0v11 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation)])
                             com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.WriteOperation.timeoutFuture java.util.concurrent.Future in method: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.startWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet, long, java.util.concurrent.TimeUnit, java.util.function.LongConsumer, java.util.function.Consumer<java.lang.Throwable>):com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation, file: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup.class
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:462)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                            	... 31 more
                            */
                        /*
                            this = this;
                            r0 = r7
                            r0.checkTerminated()
                            r0 = r9
                            boolean r0 = r0.hasRemaining()
                            com.mongodb.internal.connection.tlschannel.util.Util.assertTrue(r0)
                            r0 = r7
                            r1 = r8
                            r0.waitForSocketRegistration(r1)
                            r0 = r8
                            java.util.concurrent.locks.Lock r0 = r0.writeLock
                            r0.lock()
                            r0 = r8
                            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = r0.writeOperation     // Catch: all -> 0x006e
                            if (r0 == 0) goto L_0x0028
                            java.nio.channels.WritePendingException r0 = new java.nio.channels.WritePendingException     // Catch: all -> 0x006e
                            r1 = r0
                            r1.<init>()     // Catch: all -> 0x006e
                            throw r0     // Catch: all -> 0x006e
                        L_0x0028:
                            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = new com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation     // Catch: all -> 0x006e
                            r1 = r0
                            r2 = r9
                            r3 = r13
                            r4 = r14
                            r1.<init>(r2, r3, r4)     // Catch: all -> 0x006e
                            r15 = r0
                            r0 = r8
                            java.util.concurrent.atomic.AtomicInteger r0 = r0.pendingOps     // Catch: all -> 0x006e
                            r1 = 5
                            r0.set(r1)     // Catch: all -> 0x006e
                            r0 = r10
                            r1 = 0
                            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                            if (r0 == 0) goto L_0x005c
                            r0 = r15
                            r1 = r7
                            java.util.concurrent.ScheduledThreadPoolExecutor r1 = r1.timeoutExecutor     // Catch: all -> 0x006e
                            r2 = r7
                            r3 = r8
                            r4 = r15
                            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r2 = () -> { // java.lang.Runnable.run():void
                                r2.lambda$startWrite$3(r3, r4);
                            }     // Catch: all -> 0x006e
                            r3 = r10
                            r4 = r12
                            java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r3, r4)     // Catch: all -> 0x006e
                            r0.timeoutFuture = r1     // Catch: all -> 0x006e
                        L_0x005c:
                            r0 = r8
                            r1 = r15
                            r0.writeOperation = r1     // Catch: all -> 0x006e
                            r0 = r8
                            java.util.concurrent.locks.Lock r0 = r0.writeLock
                            r0.unlock()
                            goto L_0x007c
                        L_0x006e:
                            r16 = move-exception
                            r0 = r8
                            java.util.concurrent.locks.Lock r0 = r0.writeLock
                            r0.unlock()
                            r0 = r16
                            throw r0
                        L_0x007c:
                            r0 = r7
                            java.nio.channels.Selector r0 = r0.selector
                            java.nio.channels.Selector r0 = r0.wakeup()
                            r0 = r7
                            java.util.concurrent.atomic.LongAdder r0 = r0.startedWrites
                            r0.increment()
                            r0 = r7
                            java.util.concurrent.atomic.LongAdder r0 = r0.currentWrites
                            r0.increment()
                            r0 = r15
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.startWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.impl.ByteBufferSet, long, java.util.concurrent.TimeUnit, java.util.function.LongConsumer, java.util.function.Consumer):com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation");
                    }

                    private void checkTerminated() {
                        if (isTerminated()) {
                            throw new ShutdownChannelGroupException();
                        }
                    }

                    private void waitForSocketRegistration(RegisteredSocket socket) {
                        try {
                            socket.registered.await();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    private void loop() {
                        while (true) {
                            try {
                                if (this.shutdown == Shutdown.No || (this.shutdown == Shutdown.Wait && this.currentRegistrations.intValue() > 0)) {
                                    int c = this.selector.select();
                                    this.selectionCount.increment();
                                    if (c > 0) {
                                        Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                                        while (it.hasNext()) {
                                            SelectionKey key = it.next();
                                            it.remove();
                                            try {
                                                key.interestOps(0);
                                                RegisteredSocket socket = (RegisteredSocket) key.attachment();
                                                processRead(socket);
                                                processWrite(socket);
                                            } catch (CancelledKeyException e) {
                                            }
                                        }
                                    }
                                    registerPendingSockets();
                                    processPendingInterests();
                                }
                            } catch (Throwable th) {
                                this.executor.shutdown();
                                this.timeoutExecutor.shutdownNow();
                                if (this.shutdown == Shutdown.Immediate) {
                                    for (SelectionKey key2 : this.selector.keys()) {
                                        ((RegisteredSocket) key2.attachment()).close();
                                    }
                                }
                                try {
                                    this.selector.close();
                                } catch (IOException e2) {
                                    logger.warn("error closing selector: {}", e2.getMessage());
                                }
                                throw th;
                            }
                        }
                        this.executor.shutdown();
                        this.timeoutExecutor.shutdownNow();
                        if (this.shutdown == Shutdown.Immediate) {
                            for (SelectionKey key3 : this.selector.keys()) {
                                ((RegisteredSocket) key3.attachment()).close();
                            }
                        }
                        try {
                            this.selector.close();
                        } catch (IOException e3) {
                            logger.warn("error closing selector: {}", e3.getMessage());
                        }
                    }

                    private void processPendingInterests() {
                        for (SelectionKey key : this.selector.keys()) {
                            int pending = ((RegisteredSocket) key.attachment()).pendingOps.getAndSet(0);
                            if (pending != 0) {
                                try {
                                    key.interestOps(key.interestOps() | pending);
                                } catch (CancelledKeyException e) {
                                }
                            }
                        }
                    }

                    private void processWrite(RegisteredSocket socket) {
                        socket.writeLock.lock();
                        try {
                            WriteOperation op = socket.writeOperation;
                            if (op != null) {
                                this.executor.execute(()
                                /*  JADX ERROR: Method code generation error
                                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE  
                                      (wrap: java.util.concurrent.ExecutorService : 0x0013: IGET  (r0v11 java.util.concurrent.ExecutorService A[REMOVE]) = 
                                      (r5v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), IMMUTABLE_TYPE, THIS])
                                     com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.executor java.util.concurrent.ExecutorService)
                                      (wrap: java.lang.Runnable : 0x0019: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                                      (r5v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                                      (r6v0 'socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket A[D('socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket), DONT_INLINE])
                                      (r0v6 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation), DONT_INLINE])
                                    
                                     handle type: INVOKE_DIRECT
                                     lambda: java.lang.Runnable.run():void
                                     call insn: ?: INVOKE  
                                      (r1 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup)
                                      (r2 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket)
                                      (r3 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation)
                                     type: DIRECT call: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.lambda$processWrite$4(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation):void)
                                     type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.processWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket):void, file: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup.class
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                                    	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                                    	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                                    	... 27 more
                                    */
                                /*
                                    this = this;
                                    r0 = r6
                                    java.util.concurrent.locks.Lock r0 = r0.writeLock
                                    r0.lock()
                                    r0 = r6
                                    com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$WriteOperation r0 = r0.writeOperation     // Catch: all -> 0x002f
                                    r7 = r0
                                    r0 = r7
                                    if (r0 == 0) goto L_0x0023
                                    r0 = r5
                                    java.util.concurrent.ExecutorService r0 = r0.executor     // Catch: all -> 0x002f
                                    r1 = r5
                                    r2 = r6
                                    r3 = r7
                                    void r1 = () -> { // java.lang.Runnable.run():void
                                        r1.lambda$processWrite$4(r2, r3);
                                    }     // Catch: all -> 0x002f
                                    r0.execute(r1)     // Catch: all -> 0x002f
                                L_0x0023:
                                    r0 = r6
                                    java.util.concurrent.locks.Lock r0 = r0.writeLock
                                    r0.unlock()
                                    goto L_0x003b
                                L_0x002f:
                                    r8 = move-exception
                                    r0 = r6
                                    java.util.concurrent.locks.Lock r0 = r0.writeLock
                                    r0.unlock()
                                    r0 = r8
                                    throw r0
                                L_0x003b:
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.processWrite(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket):void");
                            }

                            private void processRead(RegisteredSocket socket) {
                                socket.readLock.lock();
                                try {
                                    ReadOperation op = socket.readOperation;
                                    if (op != null) {
                                        this.executor.execute(()
                                        /*  JADX ERROR: Method code generation error
                                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x001e: INVOKE  
                                              (wrap: java.util.concurrent.ExecutorService : 0x0013: IGET  (r0v11 java.util.concurrent.ExecutorService A[REMOVE]) = 
                                              (r5v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), IMMUTABLE_TYPE, THIS])
                                             com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.executor java.util.concurrent.ExecutorService)
                                              (wrap: java.lang.Runnable : 0x0019: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                                              (r5v0 'this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup A[D('this' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                                              (r6v0 'socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket A[D('socket' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket), DONT_INLINE])
                                              (r0v6 'op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation A[D('op' com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation), DONT_INLINE])
                                            
                                             handle type: INVOKE_DIRECT
                                             lambda: java.lang.Runnable.run():void
                                             call insn: ?: INVOKE  
                                              (r1 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup)
                                              (r2 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket)
                                              (r3 I:com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation)
                                             type: DIRECT call: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.lambda$processRead$5(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation):void)
                                             type: INTERFACE call: java.util.concurrent.ExecutorService.execute(java.lang.Runnable):void in method: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.processRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket):void, file: grasscutter.jar:com/mongodb/internal/connection/tlschannel/async/AsynchronousTlsChannelGroup.class
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                                            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                                            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                                            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                                            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                                            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                                            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                                            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                                            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                                            	... 27 more
                                            */
                                        /*
                                            this = this;
                                            r0 = r6
                                            java.util.concurrent.locks.Lock r0 = r0.readLock
                                            r0.lock()
                                            r0 = r6
                                            com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation r0 = r0.readOperation     // Catch: all -> 0x002f
                                            r7 = r0
                                            r0 = r7
                                            if (r0 == 0) goto L_0x0023
                                            r0 = r5
                                            java.util.concurrent.ExecutorService r0 = r0.executor     // Catch: all -> 0x002f
                                            r1 = r5
                                            r2 = r6
                                            r3 = r7
                                            void r1 = () -> { // java.lang.Runnable.run():void
                                                r1.lambda$processRead$5(r2, r3);
                                            }     // Catch: all -> 0x002f
                                            r0.execute(r1)     // Catch: all -> 0x002f
                                        L_0x0023:
                                            r0 = r6
                                            java.util.concurrent.locks.Lock r0 = r0.readLock
                                            r0.unlock()
                                            goto L_0x003b
                                        L_0x002f:
                                            r8 = move-exception
                                            r0 = r6
                                            java.util.concurrent.locks.Lock r0 = r0.readLock
                                            r0.unlock()
                                            r0 = r8
                                            throw r0
                                        L_0x003b:
                                            return
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.processRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket):void");
                                    }

                                    private void doWrite(RegisteredSocket socket, WriteOperation op) {
                                        socket.writeLock.lock();
                                        try {
                                            if (socket.writeOperation == op) {
                                                long before = op.bufferSet.remaining();
                                                try {
                                                    try {
                                                        try {
                                                            writeHandlingTasks(socket, op);
                                                            long c = before - op.bufferSet.remaining();
                                                            Util.assertTrue(c >= 0);
                                                            op.consumesBytes += c;
                                                            socket.writeOperation = null;
                                                            if (op.timeoutFuture != null) {
                                                                op.timeoutFuture.cancel(false);
                                                            }
                                                            op.onSuccess.accept(op.consumesBytes);
                                                            this.successfulWrites.increment();
                                                            this.currentWrites.decrement();
                                                        } finally {
                                                        }
                                                    } catch (NeedsWriteException e) {
                                                        socket.pendingOps.accumulateAndGet(4, a, b -> {
                                                            return a | b;
                                                        });
                                                        this.selector.wakeup();
                                                    }
                                                } catch (NeedsReadException e2) {
                                                    socket.pendingOps.accumulateAndGet(1, a, b -> {
                                                        return a | b;
                                                    });
                                                    this.selector.wakeup();
                                                } catch (IOException e3) {
                                                    if (socket.writeOperation == op) {
                                                        socket.writeOperation = null;
                                                    }
                                                    if (op.timeoutFuture != null) {
                                                        op.timeoutFuture.cancel(false);
                                                    }
                                                    op.onFailure.accept(e3);
                                                    this.failedWrites.increment();
                                                    this.currentWrites.decrement();
                                                }
                                                socket.writeLock.unlock();
                                            }
                                        } finally {
                                            socket.writeLock.unlock();
                                        }
                                    }

                                    private void writeHandlingTasks(RegisteredSocket socket, WriteOperation op) throws IOException {
                                        while (true) {
                                            try {
                                                socket.tlsChannel.write(op.bufferSet.array, op.bufferSet.offset, op.bufferSet.length);
                                                return;
                                            } catch (NeedsTaskException e) {
                                                warnAboutNeedTask();
                                                e.getTask().run();
                                            }
                                        }
                                    }

                                    private void warnAboutNeedTask() {
                                        if (!this.loggedTaskWarning.getAndSet(true)) {
                                            logger.warn("caught {}; channels used in asynchronous groups should run tasks themselves; although task is being dealt with anyway, consider configuring channels properly", NeedsTaskException.class.getName());
                                        }
                                    }

                                    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                                        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x0074
                                        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                                        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                                        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                                        */
                                    private void doRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.RegisteredSocket r6, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.ReadOperation r7) {
                                        /*
                                        // Method dump skipped, instructions count: 251
                                        */
                                        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup.doRead(com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$RegisteredSocket, com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup$ReadOperation):void");
                                    }

                                    private long readHandlingTasks(RegisteredSocket socket, ReadOperation op) throws IOException {
                                        while (true) {
                                            try {
                                                return socket.tlsChannel.read(op.bufferSet.array, op.bufferSet.offset, op.bufferSet.length);
                                            } catch (NeedsTaskException e) {
                                                warnAboutNeedTask();
                                                e.getTask().run();
                                            }
                                        }
                                    }

                                    private void registerPendingSockets() throws ClosedChannelException {
                                        while (true) {
                                            RegisteredSocket socket = this.pendingRegistrations.poll();
                                            if (socket != null) {
                                                socket.key = socket.socketChannel.register(this.selector, 0, socket);
                                                logger.trace("registered key: {}", socket.key);
                                                socket.registered.countDown();
                                            } else {
                                                return;
                                            }
                                        }
                                    }

                                    public boolean isShutdown() {
                                        return this.shutdown != Shutdown.No;
                                    }

                                    public void shutdown() {
                                        this.shutdown = Shutdown.Wait;
                                        this.selector.wakeup();
                                    }

                                    public void shutdownNow() {
                                        this.shutdown = Shutdown.Immediate;
                                        this.selector.wakeup();
                                    }

                                    public boolean isTerminated() {
                                        return this.executor.isTerminated();
                                    }

                                    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
                                        return this.executor.awaitTermination(timeout, unit);
                                    }

                                    long getSelectionCount() {
                                        return this.selectionCount.longValue();
                                    }

                                    public long getStartedReadCount() {
                                        return this.startedReads.longValue();
                                    }

                                    public long getStartedWriteCount() {
                                        return this.startedWrites.longValue();
                                    }

                                    public long getSuccessfulReadCount() {
                                        return this.successfulReads.longValue();
                                    }

                                    public long getSuccessfulWriteCount() {
                                        return this.successfulWrites.longValue();
                                    }

                                    public long getFailedReadCount() {
                                        return this.failedReads.longValue();
                                    }

                                    public long getFailedWriteCount() {
                                        return this.failedWrites.longValue();
                                    }

                                    public long getCancelledReadCount() {
                                        return this.cancelledReads.longValue();
                                    }

                                    public long getCancelledWriteCount() {
                                        return this.cancelledWrites.longValue();
                                    }

                                    public long getCurrentReadCount() {
                                        return this.currentReads.longValue();
                                    }

                                    public long getCurrentWriteCount() {
                                        return this.currentWrites.longValue();
                                    }

                                    public long getCurrentRegistrationCount() {
                                        return this.currentRegistrations.longValue();
                                    }
                                }
