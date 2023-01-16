package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;

/* loaded from: grasscutter.jar:org/jctools/queues/MpmcUnboundedXaddArrayQueue.class */
public class MpmcUnboundedXaddArrayQueue<E> extends MpUnboundedXaddArrayQueue<MpmcUnboundedXaddChunk<E>, E> {
    static final /* synthetic */ boolean $assertionsDisabled;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpmcUnboundedXaddArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = r6
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "supplier is null"
            r1.<init>(r2)
            throw r0
            r0 = r7
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
            r1.<init>(r2)
            throw r0
            r0 = r7
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r5
            int r0 = r0.chunkShift
            r8 = r0
            r0 = r5
            int r0 = r0.chunkMask
            r9 = r0
            r0 = r5
            r1 = r7
            long r1 = (long) r1
            long r0 = r0.getAndAddProducerIndex(r1)
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r13
            r1 = r7
            if (r0 >= r1) goto L_0x00c0
            r0 = r10
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 & r1
            int r0 = (int) r0
            r14 = r0
            r0 = r10
            r1 = r8
            long r0 = r0 >> r1
            r15 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0065
            r0 = r12
            long r0 = r0.lvIndex()
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0081
            r0 = r5
            r1 = r12
            r2 = r15
            org.jctools.queues.MpUnboundedXaddChunk r0 = r0.producerChunkForIndex(r1, r2)
            org.jctools.queues.MpmcUnboundedXaddChunk r0 = (org.jctools.queues.MpmcUnboundedXaddChunk) r0
            r12 = r0
            r0 = r12
            boolean r0 = r0.isPooled()
            if (r0 == 0) goto L_0x0081
            r0 = r12
            long r0 = r0.lvIndex()
            r15 = r0
            r0 = r12
            boolean r0 = r0.isPooled()
            if (r0 == 0) goto L_0x0096
            r0 = r12
            r1 = r14
            java.lang.Object r0 = r0.lvElement(r1)
            if (r0 == 0) goto L_0x0096
            goto L_0x0089
            r0 = r12
            r1 = r14
            r2 = r6
            java.lang.Object r2 = r2.get()
            r0.soElement(r1, r2)
            r0 = r12
            boolean r0 = r0.isPooled()
            if (r0 == 0) goto L_0x00b4
            r0 = r12
            r1 = r14
            r2 = r15
            r0.soSequence(r1, r2)
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
            int r13 = r13 + 1
            goto L_0x0040
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcUnboundedXaddArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        fill(supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return fill(supplier);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return size();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue
    /* bridge */ /* synthetic */ MpUnboundedXaddChunk newChunk(long j, MpUnboundedXaddChunk mpUnboundedXaddChunk, int i, boolean z) {
        return newChunk(j, (MpmcUnboundedXaddChunk) ((MpmcUnboundedXaddChunk) mpUnboundedXaddChunk), i, z);
    }

    static {
        $assertionsDisabled = !MpmcUnboundedXaddArrayQueue.class.desiredAssertionStatus();
    }

    public MpmcUnboundedXaddArrayQueue(int chunkSize, int maxPooledChunks) {
        super(chunkSize, maxPooledChunks);
    }

    public MpmcUnboundedXaddArrayQueue(int chunkSize) {
        this(chunkSize, 2);
    }

    final MpmcUnboundedXaddChunk<E> newChunk(long index, MpmcUnboundedXaddChunk<E> prev, int chunkSize, boolean pooled) {
        return new MpmcUnboundedXaddChunk<>(index, prev, chunkSize, pooled);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int chunkMask = this.chunkMask;
        int chunkShift = this.chunkShift;
        long pIndex = getAndIncrementProducerIndex();
        int piChunkOffset = (int) (pIndex & ((long) chunkMask));
        long piChunkIndex = pIndex >> chunkShift;
        MpmcUnboundedXaddChunk<E> pChunk = (MpmcUnboundedXaddChunk) lvProducerChunk();
        if (pChunk.lvIndex() != piChunkIndex) {
            pChunk = producerChunkForIndex(pChunk, piChunkIndex);
        }
        boolean isPooled = pChunk.isPooled();
        if (isPooled) {
            pChunk.spinForElement(piChunkOffset, true);
        }
        pChunk.soElement(piChunkOffset, e);
        if (!isPooled) {
            return true;
        }
        pChunk.soSequence(piChunkOffset, piChunkIndex);
        return true;
    }

    /* JADX WARN: Type inference failed for: r1v13, types: [long] */
    /* JADX WARN: Type inference failed for: r1v29, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ae, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0126, code lost:
        if (r15 == false) goto L_0x0138;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0129, code lost:
        r17 = switchToNextConsumerChunkAndPoll(r0, r18, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x013a, code lost:
        if (r16 == false) goto L_0x0146;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013d, code lost:
        r17 = r0.lvElement(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0149, code lost:
        if (org.jctools.queues.MpmcUnboundedXaddArrayQueue.$assertionsDisabled != false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0151, code lost:
        if (r0.isPooled() == false) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0159, code lost:
        if (r0.isPooled() == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0166, code lost:
        if (r0.lvSequence(r0) == r0) goto L_0x0171;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0170, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0171, code lost:
        r0.soElement(r0, null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x017b, code lost:
        return r17;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E poll() {
        /*
        // Method dump skipped, instructions count: 380
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcUnboundedXaddArrayQueue.poll():java.lang.Object");
    }

    private E switchToNextConsumerChunkAndPoll(MpmcUnboundedXaddChunk<E> cChunk, MpmcUnboundedXaddChunk<E> next, long expectedChunkIndex) {
        if (next == null) {
            long ccChunkIndex = expectedChunkIndex - 1;
            if (!$assertionsDisabled && cChunk.lvIndex() != ccChunkIndex) {
                throw new AssertionError();
            } else if (lvProducerChunkIndex() == ccChunkIndex) {
                next = appendNextChunks(cChunk, ccChunkIndex, 1);
            }
        }
        while (next == null) {
            next = cChunk.lvNext();
        }
        E e = next.spinForElement(0, false);
        if (next.isPooled()) {
            next.spinForSequence(0, expectedChunkIndex);
        }
        next.soElement(0, null);
        moveToNextConsumerChunk(cChunk, next);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        E e;
        MpmcUnboundedXaddChunk<E> next;
        int chunkMask = this.chunkMask;
        int chunkShift = this.chunkShift;
        while (true) {
            e = null;
            long cIndex = lvConsumerIndex();
            MpmcUnboundedXaddChunk<E> cChunk = (MpmcUnboundedXaddChunk) lvConsumerChunk();
            int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
            long ciChunkIndex = cIndex >> chunkShift;
            if (ciChunkOffset == 0 && cIndex != 0) {
                if (ciChunkIndex - 1 == cChunk.lvIndex() && (next = cChunk.lvNext()) != null) {
                    cChunk = next;
                }
                if (e == null || cIndex == lvProducerIndex()) {
                    if (e == null || cIndex == lvConsumerIndex()) {
                        break;
                    }
                }
            }
            if (!cChunk.isPooled() ? cChunk.lvIndex() == ciChunkIndex : cChunk.lvSequence(ciChunkOffset) == ciChunkIndex) {
                e = cChunk.lvElement(ciChunkOffset);
            }
            if (e == null) {
            }
            if (e == null) {
                break;
            }
            break;
        }
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        MpmcUnboundedXaddChunk<E> next;
        int chunkMask = this.chunkMask;
        int chunkShift = this.chunkShift;
        long cIndex = lvConsumerIndex();
        MpmcUnboundedXaddChunk<E> cChunk = (MpmcUnboundedXaddChunk) lvConsumerChunk();
        int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
        long ciChunkIndex = cIndex >> chunkShift;
        if (!(ciChunkOffset == 0 && cIndex != 0)) {
            boolean pooled = cChunk.isPooled();
            E e = null;
            if (pooled) {
                if (cChunk.lvSequence(ciChunkOffset) != ciChunkIndex) {
                    return null;
                }
            } else if (cChunk.lvIndex() != ciChunkIndex) {
                return null;
            } else {
                E lvElement = cChunk.lvElement(ciChunkOffset);
                e = lvElement;
                if (lvElement == null) {
                    return null;
                }
            }
            if (!casConsumerIndex(cIndex, cIndex + 1)) {
                return null;
            }
            if (pooled) {
                e = cChunk.lvElement(ciChunkOffset);
                if (!$assertionsDisabled && e == null) {
                    throw new AssertionError();
                }
            }
            if ($assertionsDisabled || !pooled || (pooled && cChunk.lvSequence(ciChunkOffset) == ciChunkIndex)) {
                cChunk.soElement(ciChunkOffset, null);
                return e;
            }
            throw new AssertionError();
        } else if (ciChunkIndex - 1 != cChunk.lvIndex() || (next = cChunk.lvNext()) == null) {
            return null;
        } else {
            E e2 = null;
            boolean pooled2 = next.isPooled();
            if (!pooled2) {
                e2 = next.lvElement(0);
                if (e2 == null) {
                    return null;
                }
            } else if (next.lvSequence(0) != ciChunkIndex) {
                return null;
            }
            if (!casConsumerIndex(cIndex, cIndex + 1)) {
                return null;
            }
            if (pooled2) {
                e2 = next.lvElement(0);
            }
            if ($assertionsDisabled || e2 != null) {
                next.soElement(0, null);
                moveToNextConsumerChunk(cChunk, next);
                return e2;
            }
            throw new AssertionError();
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        MpmcUnboundedXaddChunk<E> next;
        int chunkMask = this.chunkMask;
        int chunkShift = this.chunkShift;
        long cIndex = lvConsumerIndex();
        int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
        long ciChunkIndex = cIndex >> chunkShift;
        MpmcUnboundedXaddChunk<E> consumerBuffer = (MpmcUnboundedXaddChunk) lvConsumerChunk();
        if (ciChunkOffset == 0 && cIndex >= ((long) (chunkMask + 1))) {
            if (ciChunkIndex - 1 != consumerBuffer.lvIndex() || (next = consumerBuffer.lvNext()) == null) {
                return null;
            }
            consumerBuffer = next;
        }
        if (consumerBuffer.isPooled()) {
            if (consumerBuffer.lvSequence(ciChunkOffset) != ciChunkIndex) {
                return null;
            }
        } else if (consumerBuffer.lvIndex() != ciChunkIndex) {
            return null;
        }
        E e = consumerBuffer.lvElement(ciChunkOffset);
        if (cIndex != lvConsumerIndex()) {
            return null;
        }
        return e;
    }
}
