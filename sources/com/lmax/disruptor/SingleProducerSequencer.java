package com.lmax.disruptor;

import com.lmax.disruptor.util.Util;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

/* loaded from: grasscutter.jar:com/lmax/disruptor/SingleProducerSequencer.class */
public final class SingleProducerSequencer extends SingleProducerSequencerFields {
    protected byte p10;
    protected byte p11;
    protected byte p12;
    protected byte p13;
    protected byte p14;
    protected byte p15;
    protected byte p16;
    protected byte p17;
    protected byte p20;
    protected byte p21;
    protected byte p22;
    protected byte p23;
    protected byte p24;
    protected byte p25;
    protected byte p26;
    protected byte p27;
    protected byte p30;
    protected byte p31;
    protected byte p32;
    protected byte p33;
    protected byte p34;
    protected byte p35;
    protected byte p36;
    protected byte p37;
    protected byte p40;
    protected byte p41;
    protected byte p42;
    protected byte p43;
    protected byte p44;
    protected byte p45;
    protected byte p46;
    protected byte p47;
    protected byte p50;
    protected byte p51;
    protected byte p52;
    protected byte p53;
    protected byte p54;
    protected byte p55;
    protected byte p56;
    protected byte p57;
    protected byte p60;
    protected byte p61;
    protected byte p62;
    protected byte p63;
    protected byte p64;
    protected byte p65;
    protected byte p66;
    protected byte p67;
    protected byte p70;
    protected byte p71;
    protected byte p72;
    protected byte p73;
    protected byte p74;
    protected byte p75;
    protected byte p76;
    protected byte p77;
    static final /* synthetic */ boolean $assertionsDisabled;

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
    /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r0, r1, r2, r3, method: com.lmax.disruptor.SingleProducerSequencer.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, SingleProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, SingleProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
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
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, SingleProducerSequencer{bufferSize=, waitStrategy=, cursor=, gatingSequences=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.SingleProducerSequencer.toString():java.lang.String");
    }

    static {
        $assertionsDisabled = !SingleProducerSequencer.class.desiredAssertionStatus();
    }

    public SingleProducerSequencer(int bufferSize, WaitStrategy waitStrategy) {
        super(bufferSize, waitStrategy);
    }

    @Override // com.lmax.disruptor.Sequenced
    public boolean hasAvailableCapacity(int requiredCapacity) {
        return hasAvailableCapacity(requiredCapacity, false);
    }

    private boolean hasAvailableCapacity(int requiredCapacity, boolean doStore) {
        long nextValue = this.nextValue;
        long wrapPoint = (nextValue + ((long) requiredCapacity)) - ((long) this.bufferSize);
        long cachedGatingSequence = this.cachedValue;
        if (wrapPoint <= cachedGatingSequence && cachedGatingSequence <= nextValue) {
            return true;
        }
        if (doStore) {
            this.cursor.setVolatile(nextValue);
        }
        long minSequence = Util.getMinimumSequence(this.gatingSequences, nextValue);
        this.cachedValue = minSequence;
        if (wrapPoint > minSequence) {
            return false;
        }
        return true;
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next() {
        return next(1);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long next(int n) {
        long minSequence;
        if (!$assertionsDisabled && !sameThread()) {
            throw new AssertionError("Accessed by two threads - use ProducerType.MULTI!");
        } else if (n < 1 || n > this.bufferSize) {
            throw new IllegalArgumentException("n must be > 0 and < bufferSize");
        } else {
            long nextValue = this.nextValue;
            long nextSequence = nextValue + ((long) n);
            long wrapPoint = nextSequence - ((long) this.bufferSize);
            long cachedGatingSequence = this.cachedValue;
            if (wrapPoint > cachedGatingSequence || cachedGatingSequence > nextValue) {
                this.cursor.setVolatile(nextValue);
                while (true) {
                    minSequence = Util.getMinimumSequence(this.gatingSequences, nextValue);
                    if (wrapPoint <= minSequence) {
                        break;
                    }
                    LockSupport.parkNanos(1);
                }
                this.cachedValue = minSequence;
            }
            this.nextValue = nextSequence;
            return nextSequence;
        }
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext() throws InsufficientCapacityException {
        return tryNext(1);
    }

    @Override // com.lmax.disruptor.Sequenced
    public long tryNext(int n) throws InsufficientCapacityException {
        if (n < 1) {
            throw new IllegalArgumentException("n must be > 0");
        } else if (!hasAvailableCapacity(n, true)) {
            throw InsufficientCapacityException.INSTANCE;
        } else {
            long nextSequence = this.nextValue + ((long) n);
            this.nextValue = nextSequence;
            return nextSequence;
        }
    }

    @Override // com.lmax.disruptor.Sequenced
    public long remainingCapacity() {
        long nextValue = this.nextValue;
        return ((long) getBufferSize()) - (nextValue - Util.getMinimumSequence(this.gatingSequences, nextValue));
    }

    @Override // com.lmax.disruptor.Sequencer
    public void claim(long sequence) {
        this.nextValue = sequence;
    }

    @Override // com.lmax.disruptor.Sequenced
    public void publish(long sequence) {
        this.cursor.set(sequence);
        this.waitStrategy.signalAllWhenBlocking();
    }

    @Override // com.lmax.disruptor.Sequenced
    public void publish(long lo, long hi) {
        publish(hi);
    }

    @Override // com.lmax.disruptor.Sequencer
    public boolean isAvailable(long sequence) {
        long currentSequence = this.cursor.get();
        return sequence <= currentSequence && sequence > currentSequence - ((long) this.bufferSize);
    }

    @Override // com.lmax.disruptor.Sequencer
    public long getHighestPublishedSequence(long lowerBound, long availableSequence) {
        return availableSequence;
    }

    private boolean sameThread() {
        return ProducerThreadAssertion.isSameThreadProducingTo(this);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/lmax/disruptor/SingleProducerSequencer$ProducerThreadAssertion.class */
    public static class ProducerThreadAssertion {
        private static final Map<SingleProducerSequencer, Thread> PRODUCERS = new HashMap();

        private ProducerThreadAssertion() {
        }

        public static boolean isSameThreadProducingTo(SingleProducerSequencer singleProducerSequencer) {
            boolean equals;
            synchronized (PRODUCERS) {
                Thread currentThread = Thread.currentThread();
                if (!PRODUCERS.containsKey(singleProducerSequencer)) {
                    PRODUCERS.put(singleProducerSequencer, currentThread);
                }
                equals = PRODUCERS.get(singleProducerSequencer).equals(currentThread);
            }
            return equals;
        }
    }
}
