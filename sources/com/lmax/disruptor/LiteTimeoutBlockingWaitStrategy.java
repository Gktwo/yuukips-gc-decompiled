package com.lmax.disruptor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: grasscutter.jar:com/lmax/disruptor/LiteTimeoutBlockingWaitStrategy.class */
public class LiteTimeoutBlockingWaitStrategy implements WaitStrategy {
    private final Object mutex = new Object();
    private final AtomicBoolean signalNeeded = new AtomicBoolean(false);
    private final long timeoutInNanos;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, r0, method: com.lmax.disruptor.LiteTimeoutBlockingWaitStrategy.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/util/concurrent/atomic/AtomicBoolean;, J)Ljava/lang/String;}, LiteTimeoutBlockingWaitStrategy{mutex=, signalNeeded=, timeoutInNanos=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/util/concurrent/atomic/AtomicBoolean;, J)Ljava/lang/String;}, LiteTimeoutBlockingWaitStrategy{mutex=, signalNeeded=, timeoutInNanos=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            java.lang.Object r0 = r0.mutex
            r1 = r5
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.signalNeeded
            r2 = r5
            long r2 = r2.timeoutInNanos
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;, Ljava/util/concurrent/atomic/AtomicBoolean;, J)Ljava/lang/String;}, LiteTimeoutBlockingWaitStrategy{mutex=, signalNeeded=, timeoutInNanos=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.LiteTimeoutBlockingWaitStrategy.toString():java.lang.String");
    }

    public LiteTimeoutBlockingWaitStrategy(long timeout, TimeUnit units) {
        this.timeoutInNanos = units.toNanos(timeout);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.lmax.disruptor.WaitStrategy
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long waitFor(long r6, com.lmax.disruptor.Sequence r8, com.lmax.disruptor.Sequence r9, com.lmax.disruptor.SequenceBarrier r10) throws com.lmax.disruptor.AlertException, java.lang.InterruptedException, com.lmax.disruptor.TimeoutException {
        /*
            r5 = this;
            r0 = r5
            long r0 = r0.timeoutInNanos
            r11 = r0
            r0 = r8
            long r0 = r0.get()
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0054
            r0 = r5
            java.lang.Object r0 = r0.mutex
            r1 = r0
            r15 = r1
            monitor-enter(r0)
        L_0x0017:
            r0 = r8
            long r0 = r0.get()     // Catch: all -> 0x004c
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0046
            r0 = r5
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.signalNeeded     // Catch: all -> 0x004c
            r1 = 1
            boolean r0 = r0.getAndSet(r1)     // Catch: all -> 0x004c
            r0 = r10
            r0.checkAlert()     // Catch: all -> 0x004c
            r0 = r5
            java.lang.Object r0 = r0.mutex     // Catch: all -> 0x004c
            r1 = r11
            long r0 = com.lmax.disruptor.util.Util.awaitNanos(r0, r1)     // Catch: all -> 0x004c
            r11 = r0
            r0 = r11
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0017
            com.lmax.disruptor.TimeoutException r0 = com.lmax.disruptor.TimeoutException.INSTANCE     // Catch: all -> 0x004c
            throw r0     // Catch: all -> 0x004c
        L_0x0046:
            r0 = r15
            monitor-exit(r0)     // Catch: all -> 0x004c
            goto L_0x0054
        L_0x004c:
            r16 = move-exception
            r0 = r15
            monitor-exit(r0)     // Catch: all -> 0x004c
            r0 = r16
            throw r0
        L_0x0054:
            r0 = r9
            long r0 = r0.get()
            r1 = r0; r1 = r0; 
            r13 = r1
            r1 = r6
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x006b
            r0 = r10
            r0.checkAlert()
            goto L_0x0054
        L_0x006b:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.LiteTimeoutBlockingWaitStrategy.waitFor(long, com.lmax.disruptor.Sequence, com.lmax.disruptor.Sequence, com.lmax.disruptor.SequenceBarrier):long");
    }

    @Override // com.lmax.disruptor.WaitStrategy
    public void signalAllWhenBlocking() {
        if (this.signalNeeded.getAndSet(false)) {
            synchronized (this.mutex) {
                this.mutex.notifyAll();
            }
        }
    }
}
