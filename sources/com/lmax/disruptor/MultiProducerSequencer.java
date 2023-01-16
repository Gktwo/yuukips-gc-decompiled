package com.lmax.disruptor;

import com.lmax.disruptor.util.Util;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;
import java.util.concurrent.locks.LockSupport;

/* loaded from: grasscutter.jar:com/lmax/disruptor/MultiProducerSequencer.class */
public final class MultiProducerSequencer extends AbstractSequencer {
    private static final VarHandle AVAILABLE_ARRAY = MethodHandles.arrayElementVarHandle(int[].class);
    private final Sequence gatingSequenceCache = new Sequence(-1);
    private final int[] availableBuffer;
    private final int indexMask;
    private final int indexShift;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r0, r1, r2, r3, method: com.lmax.disruptor.MultiProducerSequencer.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, MultiProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, MultiProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // com.lmax.disruptor.AbstractSequencer
    public java.lang.String toString() {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.bufferSize
            r1 = r5
            com.lmax.disruptor.WaitStrategy r1 = r1.waitStrategy
            r2 = r5
            com.lmax.disruptor.Sequence r2 = r2.cursor
            r3 = r5
            com.lmax.disruptor.Sequence[] r3 = r3.gatingSequences
            java.lang.String r3 = java.util.Arrays.toString(r3)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, MultiProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.MultiProducerSequencer.toString():java.lang.String");
    }

    public MultiProducerSequencer(int bufferSize, WaitStrategy waitStrategy) {
        super(bufferSize, waitStrategy);
        this.availableBuffer = new int[bufferSize];
        Arrays.fill(this.availableBuffer, -1);
        this.indexMask = bufferSize - 1;
        this.indexShift = Util.log2(bufferSize);
    }

    @Override // com.lmax.disruptor.Sequenced
    public boolean hasAvailableCapacity(int requiredCapacity) {
        return hasAvailableCapacity(this.gatingSequences, requiredCapacity, this.cursor.get());
    }

    private boolean hasAvailableCapacity(Sequence[] gatingSequences, int requiredCapacity, long cursorValue) {
        long wrapPoint = (cursorValue + ((long) requiredCapacity)) - ((long) this.bufferSize);
        long cachedGatingSequence = this.gatingSequenceCache.get();
        if (wrapPoint <= cachedGatingSequence && cachedGatingSequence <= cursorValue) {
            return true;
        }
        long minSequence = Util.getMinimumSequence(gatingSequences, cursorValue);
        this.gatingSequenceCache.set(minSequence);
        if (wrapPoint > minSequence) {
            return false;
        }
        return true;
    }

    @Override // com.lmax.disruptor.Sequencer
    public void claim(long sequence) {
        this.cursor.set(sequence);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next() {
        return next(1);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next(int n) {
        long gatingSequence;
        if (n < 1 || n > this.bufferSize) {
            throw new IllegalArgumentException("n must be > 0 and < bufferSize");
        }
        long current = this.cursor.getAndAdd((long) n);
        long nextSequence = current + ((long) n);
        long wrapPoint = nextSequence - ((long) this.bufferSize);
        long cachedGatingSequence = this.gatingSequenceCache.get();
        if (wrapPoint > cachedGatingSequence || cachedGatingSequence > current) {
            while (true) {
                gatingSequence = Util.getMinimumSequence(this.gatingSequences, current);
                if (wrapPoint <= gatingSequence) {
                    break;
                }
                LockSupport.parkNanos(1);
            }
            this.gatingSequenceCache.set(gatingSequence);
        }
        return nextSequence;
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext() throws InsufficientCapacityException {
        return tryNext(1);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext(int n) throws InsufficientCapacityException {
        long current;
        long next;
        if (n < 1) {
            throw new IllegalArgumentException("n must be > 0");
        }
        do {
            current = this.cursor.get();
            next = current + ((long) n);
            if (!hasAvailableCapacity(this.gatingSequences, n, current)) {
                throw InsufficientCapacityException.INSTANCE;
            }
        } while (!this.cursor.compareAndSet(current, next));
        return next;
    }

    @Override // com.lmax.disruptor.Sequenced
    public long remainingCapacity() {
        long consumed = Util.getMinimumSequence(this.gatingSequences, this.cursor.get());
        return ((long) getBufferSize()) - (this.cursor.get() - consumed);
    }

    @Override // com.lmax.disruptor.Sequenced
    public void publish(long sequence) {
        setAvailable(sequence);
        this.waitStrategy.signalAllWhenBlocking();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.lmax.disruptor.MultiProducerSequencer] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.lmax.disruptor.Sequenced
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publish(long r6, long r8) {
        /*
            r5 = this;
            r0 = r6
            r10 = r0
        L_0x0003:
            r0 = r10
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0019
            r0 = r5
            r1 = r10
            r0.setAvailable(r1)
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
            goto L_0x0003
        L_0x0019:
            r0 = r5
            com.lmax.disruptor.WaitStrategy r0 = r0.waitStrategy
            r0.signalAllWhenBlocking()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.MultiProducerSequencer.publish(long, long):void");
    }

    private void setAvailable(long sequence) {
        setAvailableBufferValue(calculateIndex(sequence), calculateAvailabilityFlag(sequence));
    }

    private void setAvailableBufferValue(int index, int flag) {
        AVAILABLE_ARRAY.setRelease(this.availableBuffer, index, flag);
    }

    @Override // com.lmax.disruptor.Sequencer
    public boolean isAvailable(long sequence) {
        return AVAILABLE_ARRAY.getAcquire(this.availableBuffer, calculateIndex(sequence)) == calculateAvailabilityFlag(sequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.lmax.disruptor.MultiProducerSequencer] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.lmax.disruptor.Sequencer
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getHighestPublishedSequence(long r6, long r8) {
        /*
            r5 = this;
            r0 = r6
            r10 = r0
        L_0x0003:
            r0 = r10
            r1 = r8
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0021
            r0 = r5
            r1 = r10
            boolean r0 = r0.isAvailable(r1)
            if (r0 != 0) goto L_0x0018
            r0 = r10
            r1 = 1
            long r0 = r0 - r1
            return r0
        L_0x0018:
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
            goto L_0x0003
        L_0x0021:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.MultiProducerSequencer.getHighestPublishedSequence(long, long):long");
    }

    private int calculateAvailabilityFlag(long sequence) {
        return (int) (sequence >>> this.indexShift);
    }

    private int calculateIndex(long sequence) {
        return ((int) sequence) & this.indexMask;
    }
}
