package org.jctools.queues.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.IndexedQueueSizeUtil;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;
import org.jctools.queues.QueueProgressIndicators;
import org.jctools.util.PortableJvmInfo;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/BaseSpscLinkedAtomicArrayQueue.class */
abstract class BaseSpscLinkedAtomicArrayQueue<E> extends BaseSpscLinkedAtomicArrayQueueProducerColdFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators {
    private static final Object JUMP = new Object();

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r11, int r12) {
        /*
            r10 = this;
            r0 = 0
            r1 = r11
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "supplier is null"
            r1.<init>(r2)
            throw r0
            r0 = r12
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r12
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
            r1.<init>(r2)
            throw r0
            r0 = r12
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = 0
            r13 = r0
            r0 = r13
            r1 = r12
            if (r0 >= r1) goto L_0x007f
            r0 = r10
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.producerBuffer
            r14 = r0
            r0 = r10
            long r0 = r0.lpProducerIndex()
            r15 = r0
            r0 = r10
            long r0 = r0.producerMask
            r17 = r0
            r0 = r15
            r1 = r17
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r19 = r0
            r0 = r15
            r1 = r10
            long r1 = r1.producerBufferLimit
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0066
            r0 = r10
            r1 = r14
            r2 = r11
            java.lang.Object r2 = r2.get()
            r3 = r15
            r4 = r19
            r0.writeToQueue(r1, r2, r3, r4)
            goto L_0x0079
            r0 = r10
            r1 = r14
            r2 = r17
            r3 = r15
            r4 = r19
            r5 = 0
            r6 = r11
            boolean r0 = r0.offerColdPath(r1, r2, r3, r4, r5, r6)
            if (r0 != 0) goto L_0x0079
            r0 = r13
            return r0
            int r13 = r13 + 1
            goto L_0x0029
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.BaseSpscLinkedAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    abstract boolean offerColdPath(AtomicReferenceArray<E> atomicReferenceArray, long j, long j2, int i, E e, MessagePassingQueue.Supplier<? extends E> supplier);

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final int size() {
        return IndexedQueueSizeUtil.size(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return IndexedQueueSizeUtil.isEmpty(this);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex();
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex();
    }

    protected final void soNext(AtomicReferenceArray<E> curr, AtomicReferenceArray<E> next) {
        AtomicQueueUtil.soRefElement(curr, AtomicQueueUtil.nextArrayOffset(curr), next);
    }

    protected final AtomicReferenceArray<E> lvNextArrayAndUnlink(AtomicReferenceArray<E> curr) {
        int offset = AtomicQueueUtil.nextArrayOffset(curr);
        AtomicReferenceArray<E> nextBuffer = (AtomicReferenceArray) AtomicQueueUtil.lvRefElement(curr, offset);
        AtomicQueueUtil.soRefElement(curr, offset, null);
        return nextBuffer;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return peek();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [long] */
    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        char c = 0;
        int capacity = capacity();
        do {
            int filled = fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH);
            if (filled == 0) {
                return (int) c;
            }
            c += (long) filled;
        } while (c <= ((long) capacity));
        return (int) c;
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

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<E> buffer = this.producerBuffer;
        long index = lpProducerIndex();
        long mask = this.producerMask;
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, mask);
        if (index >= this.producerBufferLimit) {
            return offerColdPath(buffer, mask, index, offset, e, null);
        }
        writeToQueue(buffer, e, index, offset);
        return true;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicReferenceArray<E> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, this.consumerMask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        boolean isNextBuffer = e == JUMP;
        if (null != e && !isNextBuffer) {
            soConsumerIndex(index + 1);
            AtomicQueueUtil.soRefElement(buffer, offset, null);
            return e;
        } else if (isNextBuffer) {
            return newBufferPoll(buffer, index);
        } else {
            return null;
        }
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> buffer = this.consumerBuffer;
        long index = lpConsumerIndex();
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(index, this.consumerMask));
        if (e == JUMP) {
            return newBufferPeek(buffer, index);
        }
        return e;
    }

    final void linkOldToNew(long currIndex, AtomicReferenceArray<E> oldBuffer, int offset, AtomicReferenceArray<E> newBuffer, int offsetInNew, E e) {
        AtomicQueueUtil.soRefElement(newBuffer, offsetInNew, e);
        soNext(oldBuffer, newBuffer);
        AtomicQueueUtil.soRefElement(oldBuffer, offset, JUMP);
        soProducerIndex(currIndex + 1);
    }

    final void writeToQueue(AtomicReferenceArray<E> buffer, E e, long index, int offset) {
        AtomicQueueUtil.soRefElement(buffer, offset, e);
        soProducerIndex(index + 1);
    }

    private E newBufferPeek(AtomicReferenceArray<E> buffer, long index) {
        AtomicReferenceArray<E> nextBuffer = lvNextArrayAndUnlink(buffer);
        this.consumerBuffer = nextBuffer;
        long mask = (long) (AtomicQueueUtil.length(nextBuffer) - 2);
        this.consumerMask = mask;
        return (E) AtomicQueueUtil.lvRefElement(nextBuffer, AtomicQueueUtil.calcCircularRefElementOffset(index, mask));
    }

    private E newBufferPoll(AtomicReferenceArray<E> buffer, long index) {
        AtomicReferenceArray<E> nextBuffer = lvNextArrayAndUnlink(buffer);
        this.consumerBuffer = nextBuffer;
        long mask = (long) (AtomicQueueUtil.length(nextBuffer) - 2);
        this.consumerMask = mask;
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, mask);
        E n = (E) AtomicQueueUtil.lvRefElement(nextBuffer, offset);
        if (null == n) {
            throw new IllegalStateException("new buffer must have at least one element");
        }
        soConsumerIndex(index + 1);
        AtomicQueueUtil.soRefElement(nextBuffer, offset, null);
        return n;
    }
}
