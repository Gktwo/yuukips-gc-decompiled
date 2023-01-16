package kcp.highway.threadPool.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kcp.highway.threadPool.order.waiteStrategy.WaitCondition;
import kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:kcp/highway/threadPool/order/OrderedThreadPoolExecutor.class */
public class OrderedThreadPoolExecutor extends ThreadPoolExecutor {
    private static final int DEFAULT_INITIAL_THREAD_POOL_SIZE = 0;
    private static final int DEFAULT_MAX_THREAD_POOL = 16;
    private static final int DEFAULT_KEEP_ALIVE = 30;
    private final Queue<OrderedThreadSession> waitingSessions;
    private final WaitConditionStrategy waitConditionStrategy;
    private final Set<Worker> workers;
    private volatile int largestPoolSize;
    private final AtomicInteger idleWorkers;
    private long completedTaskCount;
    private volatile boolean shutdown;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderedThreadPoolExecutor.class);
    private static final OrderedThreadSession EXIT_SIGNAL = new OrderedThreadSession();

    /*  JADX ERROR: Dependency scan failed at insn: 0x004E: INVOKE_CUSTOM r-16
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Dependency scan failed at insn: 0x0065: INVOKE_CUSTOM r-17
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x004E: INVOKE_CUSTOM r2, method: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.<init>(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.ThreadFactory):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0065: INVOKE_CUSTOM r2, method: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.<init>(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.ThreadFactory):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public OrderedThreadPoolExecutor(int r12, int r13, long r14, java.util.concurrent.TimeUnit r16, java.util.concurrent.ThreadFactory r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = 0
            r2 = 1
            r3 = r14
            r4 = r16
            java.util.concurrent.SynchronousQueue r5 = new java.util.concurrent.SynchronousQueue
            r6 = r5
            r6.<init>()
            r6 = r17
            java.util.concurrent.ThreadPoolExecutor$AbortPolicy r7 = new java.util.concurrent.ThreadPoolExecutor$AbortPolicy
            r8 = r7
            r8.<init>()
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r11
            java.util.concurrent.ConcurrentLinkedQueue r1 = new java.util.concurrent.ConcurrentLinkedQueue
            r2 = r1
            r2.<init>()
            r0.waitingSessions = r1
            r0 = r11
            kcp.highway.threadPool.order.waiteStrategy.BlockingWaitConditionStrategy r1 = new kcp.highway.threadPool.order.waiteStrategy.BlockingWaitConditionStrategy
            r2 = r1
            r2.<init>()
            r0.waitConditionStrategy = r1
            r0 = r11
            java.util.HashSet r1 = new java.util.HashSet
            r2 = r1
            r2.<init>()
            r0.workers = r1
            r0 = r11
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r2 = r1
            r2.<init>()
            r0.idleWorkers = r1
            r0 = r12
            if (r0 >= 0) goto L_0x0057
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r12
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
            r1.<init>(r2)
            throw r0
            r0 = r13
            if (r0 <= 0) goto L_0x0060
            r0 = r13
            r1 = r12
            if (r0 >= r1) goto L_0x006e
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r13
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
            r1.<init>(r2)
            throw r0
            r0 = r11
            r1 = r13
            r0.setMaximumPoolSize(r1)
            r0 = r11
            r1 = r12
            r0.setCorePoolSize(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.<init>(int, int, long, java.util.concurrent.TimeUnit, java.util.concurrent.ThreadFactory):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0011: INVOKE_CUSTOM r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0011: INVOKE_CUSTOM r2, method: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.setMaximumPoolSize(int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setMaximumPoolSize(int r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 <= 0) goto L_0x000c
            r0 = r5
            r1 = r4
            int r1 = r1.getCorePoolSize()
            if (r0 >= r1) goto L_0x001a
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, maximumPoolSize: ]}
            r1.<init>(r2)
            throw r0
            r0 = r4
            java.util.Set<kcp.highway.threadPool.order.OrderedThreadPoolExecutor$Worker> r0 = r0.workers
            r1 = r0
            r6 = r1
            monitor-enter(r0)
            r0 = r4
            r1 = r5
            r0.setMaximumPoolSize(r1)
            r0 = r4
            java.util.Set<kcp.highway.threadPool.order.OrderedThreadPoolExecutor$Worker> r0 = r0.workers
            int r0 = r0.size()
            r1 = r5
            int r0 = r0 - r1
            r7 = r0
            r0 = r7
            if (r0 <= 0) goto L_0x0040
            r0 = r4
            r0.removeWorker()
            int r7 = r7 + -1
            goto L_0x0032
            r0 = r6
            monitor-exit(r0)
            goto L_0x004c
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)
            r0 = r8
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.setMaximumPoolSize(int):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0009: INVOKE_CUSTOM r0
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0009: INVOKE_CUSTOM r2, method: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.setCorePoolSize(int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 >= 0) goto L_0x0012
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, corePoolSize: ]}
            r1.<init>(r2)
            throw r0
            r0 = r5
            r1 = r4
            int r1 = r1.getMaximumPoolSize()
            if (r0 <= r1) goto L_0x0025
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "corePoolSize exceeds maximumPoolSize"
            r1.<init>(r2)
            throw r0
            r0 = r4
            java.util.Set<kcp.highway.threadPool.order.OrderedThreadPoolExecutor$Worker> r0 = r0.workers
            r1 = r0
            r6 = r1
            monitor-enter(r0)
            r0 = r4
            int r0 = r0.getCorePoolSize()
            r1 = r5
            if (r0 <= r1) goto L_0x0049
            r0 = r4
            int r0 = r0.getCorePoolSize()
            r1 = r5
            int r0 = r0 - r1
            r7 = r0
            r0 = r7
            if (r0 <= 0) goto L_0x0049
            r0 = r4
            r0.removeWorker()
            int r7 = r7 + -1
            goto L_0x003b
            r0 = r4
            r1 = r5
            r0.setCorePoolSize(r1)
            r0 = r6
            monitor-exit(r0)
            goto L_0x005a
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)
            r0 = r8
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.setCorePoolSize(int):void");
    }

    public OrderedThreadPoolExecutor() {
        this(0, 16, 30, TimeUnit.SECONDS, Executors.defaultThreadFactory());
    }

    public OrderedThreadPoolExecutor(int maximumPoolSize) {
        this(0, maximumPoolSize, 30, TimeUnit.SECONDS, Executors.defaultThreadFactory());
    }

    public OrderedThreadPoolExecutor(int corePoolSize, int maximumPoolSize) {
        this(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, Executors.defaultThreadFactory());
    }

    public OrderedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, Executors.defaultThreadFactory());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setRejectedExecutionHandler(RejectedExecutionHandler handler) {
    }

    private void addWorker() {
        synchronized (this.workers) {
            if (this.workers.size() < getMaximumPoolSize()) {
                Worker worker = new Worker();
                Thread thread = getThreadFactory().newThread(worker);
                this.idleWorkers.incrementAndGet();
                thread.start();
                this.workers.add(worker);
                if (this.workers.size() > this.largestPoolSize) {
                    this.largestPoolSize = this.workers.size();
                }
            }
        }
    }

    private void addWorkerIfNecessary() {
        if (this.idleWorkers.get() == 0) {
            synchronized (this.workers) {
                if (this.workers.isEmpty() || this.idleWorkers.get() == 0) {
                    addWorker();
                }
            }
        }
    }

    private void removeWorker() {
        synchronized (this.workers) {
            if (this.workers.size() > getCorePoolSize()) {
                this.waitingSessions.offer(EXIT_SIGNAL);
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long deadline = System.currentTimeMillis() + unit.toMillis(timeout);
        synchronized (this.workers) {
            while (!isTerminated()) {
                long waitTime = deadline - System.currentTimeMillis();
                if (waitTime <= 0) {
                    break;
                }
                this.workers.wait(waitTime);
            }
        }
        return isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.shutdown;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        boolean isEmpty;
        if (!this.shutdown) {
            return false;
        }
        synchronized (this.workers) {
            isEmpty = this.workers.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public void shutdown() {
        if (!this.shutdown) {
            this.shutdown = true;
            synchronized (this.workers) {
                for (int i = this.workers.size(); i > 0; i--) {
                    this.waitingSessions.offer(EXIT_SIGNAL);
                }
                this.waitConditionStrategy.signalAllWhenBlocking();
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        shutdown();
        List<Runnable> answer = new ArrayList<>();
        while (true) {
            OrderedThreadSession session = this.waitingSessions.poll();
            if (session == null) {
                return answer;
            }
            if (session == EXIT_SIGNAL) {
                this.waitingSessions.offer(EXIT_SIGNAL);
                Thread.yield();
            } else {
                Queue<Runnable> queue = session.getQueue();
                synchronized (queue) {
                    for (Runnable task : queue) {
                        answer.add(task);
                    }
                    queue.clear();
                }
            }
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable task) {
        if (this.shutdown) {
            rejectTask(task);
        }
        IOrderTask event = (IOrderTask) task;
        OrderedThreadSession session = event.getSession();
        if (session.getQueue().offer(event) && !offerWaitSession(session)) {
            addWorkerIfNecessary();
        }
    }

    private boolean offerWaitSession(OrderedThreadSession session) {
        boolean processing = false;
        if (session.getProcessingCompleted().compareAndSet(true, false)) {
            this.waitingSessions.offer(session);
            processing = true;
        }
        this.waitConditionStrategy.signalAllWhenBlocking();
        return processing;
    }

    private void rejectTask(Runnable task) {
        getRejectedExecutionHandler().rejectedExecution(task, this);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getActiveCount() {
        int size;
        synchronized (this.workers) {
            size = this.workers.size() - this.idleWorkers.get();
        }
        return size;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getCompletedTaskCount() {
        char c;
        synchronized (this.workers) {
            c = this.completedTaskCount;
            for (Worker w : this.workers) {
                c += w.completedTaskCount.get();
            }
        }
        return c;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getLargestPoolSize() {
        return this.largestPoolSize;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int getPoolSize() {
        int size;
        synchronized (this.workers) {
            size = this.workers.size();
        }
        return size;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public long getTaskCount() {
        return getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean isTerminating() {
        boolean z;
        synchronized (this.workers) {
            z = isShutdown() && !isTerminated();
        }
        return z;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public int prestartAllCoreThreads() {
        int answer = 0;
        synchronized (this.workers) {
            for (int i = getCorePoolSize() - this.workers.size(); i > 0; i--) {
                addWorker();
                answer++;
            }
        }
        return answer;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean prestartCoreThread() {
        synchronized (this.workers) {
            if (this.workers.size() >= getCorePoolSize()) {
                return false;
            }
            addWorker();
            return true;
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public BlockingQueue<Runnable> getQueue() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void purge() {
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public boolean remove(Runnable task) {
        return ((IOrderTask) task).getSession().getQueue().remove(task);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/threadPool/order/OrderedThreadPoolExecutor$Worker.class */
    public class Worker implements Runnable, WaitCondition<OrderedThreadSession> {
        private AtomicLong completedTaskCount = new AtomicLong(0);
        private Thread thread;

        private Worker() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x002a
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // java.lang.Runnable
        public void run() {
            /*
            // Method dump skipped, instructions count: 422
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.Worker.run():void");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0045
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private kcp.highway.threadPool.order.OrderedThreadSession fetchSession() {
            /*
                r6 = this;
                r0 = 0
                r7 = r0
                long r0 = java.lang.System.currentTimeMillis()
                r8 = r0
                r0 = r8
                r1 = r6
                kcp.highway.threadPool.order.OrderedThreadPoolExecutor r1 = kcp.highway.threadPool.order.OrderedThreadPoolExecutor.this
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
                long r1 = r1.getKeepAliveTime(r2)
                long r0 = r0 + r1
                r10 = r0
            L_0x0014:
                r0 = r10
                r1 = r8
                long r0 = r0 - r1
                r12 = r0
                r0 = r12
                r1 = 0
                int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
                if (r0 > 0) goto L_0x0024
                goto L_0x0057
            L_0x0024:
                r0 = r6
                kcp.highway.threadPool.order.OrderedThreadPoolExecutor r0 = kcp.highway.threadPool.order.OrderedThreadPoolExecutor.this     // Catch: InterruptedException -> 0x0052, all -> 0x0045
                kcp.highway.threadPool.order.waiteStrategy.WaitConditionStrategy r0 = r0.waitConditionStrategy     // Catch: InterruptedException -> 0x0052, all -> 0x0045
                r1 = r6
                r2 = r12
                java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: InterruptedException -> 0x0052, all -> 0x0045
                java.lang.Object r0 = r0.waitFor(r1, r2, r3)     // Catch: InterruptedException -> 0x0052, all -> 0x0045
                kcp.highway.threadPool.order.OrderedThreadSession r0 = (kcp.highway.threadPool.order.OrderedThreadSession) r0     // Catch: InterruptedException -> 0x0052, all -> 0x0045
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L_0x0042
                long r0 = java.lang.System.currentTimeMillis()     // Catch: InterruptedException -> 0x0052
                r8 = r0
            L_0x0042:
                goto L_0x0057
            L_0x0045:
                r14 = move-exception
                r0 = r7
                if (r0 == 0) goto L_0x004f
                long r0 = java.lang.System.currentTimeMillis()     // Catch: InterruptedException -> 0x0052
                r8 = r0
            L_0x004f:
                r0 = r14
                throw r0     // Catch: InterruptedException -> 0x0052
            L_0x0052:
                r12 = move-exception
                goto L_0x0014
            L_0x0057:
                r0 = r7
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.order.OrderedThreadPoolExecutor.Worker.fetchSession():kcp.highway.threadPool.order.OrderedThreadSession");
        }

        private void runTasks(OrderedThreadSession session) {
            session.getRunTaskCount();
            while (true) {
                Runnable task = session.getQueue().poll();
                if (task == null) {
                    session.getProcessingCompleted().set(true);
                    return;
                }
                runTask(task);
            }
        }

        private void runTask(Runnable task) {
            OrderedThreadPoolExecutor.this.beforeExecute(this.thread, task);
            boolean ran = false;
            try {
                task.run();
                ran = true;
                OrderedThreadPoolExecutor.this.afterExecute(task, null);
                this.completedTaskCount.incrementAndGet();
            } catch (RuntimeException e) {
                if (!ran) {
                    OrderedThreadPoolExecutor.this.afterExecute(task, e);
                }
                throw e;
            }
        }

        @Override // kcp.highway.threadPool.order.waiteStrategy.WaitCondition
        public OrderedThreadSession getAttach() {
            return OrderedThreadPoolExecutor.this.waitingSessions.poll();
        }
    }
}
