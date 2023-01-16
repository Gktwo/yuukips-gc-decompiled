package com.lmax.disruptor;

import com.lmax.disruptor.util.Util;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: grasscutter.jar:com/lmax/disruptor/AbstractSequencer.class */
public abstract class AbstractSequencer implements Sequencer {
    private static final AtomicReferenceFieldUpdater<AbstractSequencer, Sequence[]> SEQUENCE_UPDATER = AtomicReferenceFieldUpdater.newUpdater(AbstractSequencer.class, Sequence[].class, "gatingSequences");
    protected final int bufferSize;
    protected final WaitStrategy waitStrategy;
    protected final Sequence cursor = new Sequence(-1);
    protected volatile Sequence[] gatingSequences = new Sequence[0];

    /*  JADX ERROR: Dependency scan failed at insn: 0x000F: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x000F: INVOKE_CUSTOM r0, r1, r2, method: com.lmax.disruptor.AbstractSequencer.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, AbstractSequencer{waitStrategy=, cursor=, gatingSequences=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, AbstractSequencer{waitStrategy=, cursor=, gatingSequences=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            com.lmax.disruptor.WaitStrategy r0 = r0.waitStrategy
            r1 = r4
            com.lmax.disruptor.Sequence r1 = r1.cursor
            r2 = r4
            com.lmax.disruptor.Sequence[] r2 = r2.gatingSequences
            java.lang.String r2 = java.util.Arrays.toString(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/WaitStrategy;, Lcom/lmax/disruptor/Sequence;, Ljava/lang/String;)Ljava/lang/String;}, AbstractSequencer{waitStrategy=, cursor=, gatingSequences=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.AbstractSequencer.toString():java.lang.String");
    }

    public AbstractSequencer(int bufferSize, WaitStrategy waitStrategy) {
        if (bufferSize < 1) {
            throw new IllegalArgumentException("bufferSize must not be less than 1");
        } else if (Integer.bitCount(bufferSize) != 1) {
            throw new IllegalArgumentException("bufferSize must be a power of 2");
        } else {
            this.bufferSize = bufferSize;
            this.waitStrategy = waitStrategy;
        }
    }

    @Override // com.lmax.disruptor.Cursored
    public final long getCursor() {
        return this.cursor.get();
    }

    @Override // com.lmax.disruptor.Sequenced
    public final int getBufferSize() {
        return this.bufferSize;
    }

    @Override // com.lmax.disruptor.Sequencer
    public final void addGatingSequences(Sequence... gatingSequences) {
        SequenceGroups.addSequences(this, SEQUENCE_UPDATER, this, gatingSequences);
    }

    @Override // com.lmax.disruptor.Sequencer
    public boolean removeGatingSequence(Sequence sequence) {
        return SequenceGroups.removeSequence(this, SEQUENCE_UPDATER, sequence);
    }

    @Override // com.lmax.disruptor.Sequencer
    public long getMinimumSequence() {
        return Util.getMinimumSequence(this.gatingSequences, this.cursor.get());
    }

    @Override // com.lmax.disruptor.Sequencer
    public SequenceBarrier newBarrier(Sequence... sequencesToTrack) {
        return new ProcessingSequenceBarrier(this, this.waitStrategy, this.cursor, sequencesToTrack);
    }

    @Override // com.lmax.disruptor.Sequencer
    public <T> EventPoller<T> newPoller(DataProvider<T> dataProvider, Sequence... gatingSequences) {
        return EventPoller.newInstance(dataProvider, this, new Sequence(), this.cursor, gatingSequences);
    }
}
