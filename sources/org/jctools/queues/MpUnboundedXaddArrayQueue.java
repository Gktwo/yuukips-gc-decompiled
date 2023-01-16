package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MpUnboundedXaddChunk;
import org.jctools.util.PortableJvmInfo;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:org/jctools/queues/MpUnboundedXaddArrayQueue.class */
abstract class MpUnboundedXaddArrayQueue<R extends MpUnboundedXaddChunk<R, E>, E> extends MpUnboundedXaddArrayQueuePad5<R, E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final long ROTATION = -2;
    final int chunkMask;
    final int chunkShift;
    final int maxPooledChunks;
    final SpscArrayQueue<R> freeChunksPool;
    static final /* synthetic */ boolean $assertionsDisabled;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001D: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001D: INVOKE_CUSTOM r2, method: org.jctools.queues.MpUnboundedXaddArrayQueue.<init>(int, int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Expecting a positive maxPooledChunks, but got:]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Expecting a positive maxPooledChunks, but got:]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    MpUnboundedXaddArrayQueue(int r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            r0.<init>()
            boolean r0 = org.jctools.util.UnsafeAccess.SUPPORTS_GET_AND_ADD_LONG
            if (r0 != 0) goto L_0x0014
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Unsafe::getAndAddLong support (JDK 8+) is required for this queue to work"
            r1.<init>(r2)
            throw r0
            r0 = r10
            if (r0 >= 0) goto L_0x0026
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Expecting a positive maxPooledChunks, but got:]}
            r1.<init>(r2)
            throw r0
            r0 = r9
            int r0 = org.jctools.util.Pow2.roundToPowerOfTwo(r0)
            r9 = r0
            r0 = r8
            r1 = r9
            r2 = 1
            int r1 = r1 - r2
            r0.chunkMask = r1
            r0 = r8
            r1 = r9
            int r1 = java.lang.Integer.numberOfTrailingZeros(r1)
            r0.chunkShift = r1
            r0 = r8
            org.jctools.queues.SpscArrayQueue r1 = new org.jctools.queues.SpscArrayQueue
            r2 = r1
            r3 = r10
            r2.<init>(r3)
            r0.freeChunksPool = r1
            r0 = r8
            r1 = 0
            r2 = 0
            r3 = r9
            r4 = r10
            if (r4 <= 0) goto L_0x0052
            r4 = 1
            goto L_0x0053
            r4 = 0
            org.jctools.queues.MpUnboundedXaddChunk r0 = r0.newChunk(r1, r2, r3, r4)
            r11 = r0
            r0 = r8
            r1 = r11
            r0.soProducerChunk(r1)
            r0 = r8
            r1 = 0
            r0.soProducerChunkIndex(r1)
            r0 = r8
            r1 = r11
            r0.soConsumerChunk(r1)
            r0 = 1
            r12 = r0
            r0 = r12
            r1 = r10
            if (r0 >= r1) goto L_0x0087
            r0 = r8
            org.jctools.queues.SpscArrayQueue<R extends org.jctools.queues.MpUnboundedXaddChunk<R, E>> r0 = r0.freeChunksPool
            r1 = r8
            r2 = -1
            r3 = 0
            r4 = r9
            r5 = 1
            org.jctools.queues.MpUnboundedXaddChunk r1 = r1.newChunk(r2, r3, r4, r5)
            boolean r0 = r0.offer(r1)
            int r12 = r12 + 1
            goto L_0x0069
            r0 = r8
            r1 = r10
            r0.maxPooledChunks = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpUnboundedXaddArrayQueue.<init>(int, int):void");
    }

    abstract R newChunk(long j, R r, int i, boolean z);

    static {
        $assertionsDisabled = !MpUnboundedXaddArrayQueue.class.desiredAssertionStatus();
    }

    public final int chunkSize() {
        return this.chunkMask + 1;
    }

    public final int maxPooledChunks() {
        return this.maxPooledChunks;
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    final R producerChunkForIndex(R initialChunk, long requiredChunkIndex) {
        R currentChunk = initialChunk;
        while (true) {
            if (currentChunk == null) {
                currentChunk = lvProducerChunk();
            }
            long currentChunkIndex = currentChunk.lvIndex();
            if ($assertionsDisabled || currentChunkIndex != -1) {
                long jumpBackward = currentChunkIndex - requiredChunkIndex;
                if (jumpBackward >= 0) {
                    for (long i = 0; i < jumpBackward; i++) {
                        currentChunk = (R) ((MpUnboundedXaddChunk) currentChunk.lvPrev());
                        if (!$assertionsDisabled && currentChunk == null) {
                            throw new AssertionError();
                        }
                    }
                    if ($assertionsDisabled || currentChunk.lvIndex() == requiredChunkIndex) {
                        return currentChunk;
                    }
                    throw new AssertionError();
                } else if (lvProducerChunkIndex() == currentChunkIndex) {
                    currentChunk = appendNextChunks(currentChunk, currentChunkIndex, -jumpBackward);
                } else {
                    currentChunk = null;
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    protected final R appendNextChunks(R currentChunk, long currentChunkIndex, long chunksToAppend) {
        if (!$assertionsDisabled && currentChunkIndex == -1) {
            throw new AssertionError();
        } else if (!casProducerChunkIndex(currentChunkIndex, ROTATION)) {
            return null;
        } else {
            if ($assertionsDisabled || currentChunkIndex == currentChunk.lvIndex()) {
                for (long i = 1; i <= chunksToAppend; i++) {
                    R newChunk = newOrPooledChunk(currentChunk, currentChunkIndex + i);
                    soProducerChunk(newChunk);
                    currentChunk.soNext(newChunk);
                    currentChunk = newChunk;
                }
                soProducerChunkIndex(currentChunkIndex + chunksToAppend);
                return currentChunk;
            }
            throw new AssertionError();
        }
    }

    private R newOrPooledChunk(R prevChunk, long nextChunkIndex) {
        R newChunk = this.freeChunksPool.poll();
        if (newChunk == null) {
            newChunk = newChunk(nextChunkIndex, prevChunk, this.chunkMask + 1, false);
        } else if ($assertionsDisabled || newChunk.lvIndex() < prevChunk.lvIndex()) {
            newChunk.soPrev(prevChunk);
            newChunk.soIndex(nextChunkIndex);
        } else {
            throw new AssertionError();
        }
        return newChunk;
    }

    final void moveToNextConsumerChunk(R cChunk, R next) {
        cChunk.soNext(null);
        next.soPrev(null);
        if (cChunk.isPooled()) {
            boolean pooled = this.freeChunksPool.offer(cChunk);
            if (!$assertionsDisabled && !pooled) {
                throw new AssertionError();
            }
        }
        soConsumerChunk(next);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return -1;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        int chunkCapacity = this.chunkMask + 1;
        return MessagePassingQueueUtil.fillInBatchesToLimit(this, s, Math.min(PortableJvmInfo.RECOMENDED_OFFER_BATCH, chunkCapacity), chunkCapacity);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c, int limit) {
        return MessagePassingQueueUtil.drain(this, c, limit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, wait, exit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }
}
