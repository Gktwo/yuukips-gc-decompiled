package org.jctools.queues;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.LongCompanionObject;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.Pow2;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscBlockingConsumerArrayQueue.class */
public class MpscBlockingConsumerArrayQueue<E> extends MpscBlockingConsumerArrayQueueConsumerFields<E> implements MessagePassingQueue<E>, QueueProgressIndicators, BlockingQueue<E> {
    byte b000;
    byte b001;
    byte b002;
    byte b003;
    byte b004;
    byte b005;
    byte b006;
    byte b007;
    byte b010;
    byte b011;
    byte b012;
    byte b013;
    byte b014;
    byte b015;
    byte b016;
    byte b017;
    byte b020;
    byte b021;
    byte b022;
    byte b023;
    byte b024;
    byte b025;
    byte b026;
    byte b027;
    byte b030;
    byte b031;
    byte b032;
    byte b033;
    byte b034;
    byte b035;
    byte b036;
    byte b037;
    byte b040;
    byte b041;
    byte b042;
    byte b043;
    byte b044;
    byte b045;
    byte b046;
    byte b047;
    byte b050;
    byte b051;
    byte b052;
    byte b053;
    byte b054;
    byte b055;
    byte b056;
    byte b057;
    byte b060;
    byte b061;
    byte b062;
    byte b063;
    byte b064;
    byte b065;
    byte b066;
    byte b067;
    byte b070;
    byte b071;
    byte b072;
    byte b073;
    byte b074;
    byte b075;
    byte b076;
    byte b077;
    byte b100;
    byte b101;
    byte b102;
    byte b103;
    byte b104;
    byte b105;
    byte b106;
    byte b107;
    byte b110;
    byte b111;
    byte b112;
    byte b113;
    byte b114;
    byte b115;
    byte b116;
    byte b117;
    byte b120;
    byte b121;
    byte b122;
    byte b123;
    byte b124;
    byte b125;
    byte b126;
    byte b127;
    byte b130;
    byte b131;
    byte b132;
    byte b133;
    byte b134;
    byte b135;
    byte b136;
    byte b137;
    byte b140;
    byte b141;
    byte b142;
    byte b143;
    byte b144;
    byte b145;
    byte b146;
    byte b147;
    byte b150;
    byte b151;
    byte b152;
    byte b153;
    byte b154;
    byte b155;
    byte b156;
    byte b157;
    byte b160;
    byte b161;
    byte b162;
    byte b163;
    byte b164;
    byte b165;
    byte b166;
    byte b167;
    byte b170;
    byte b171;
    byte b172;
    byte b173;
    byte b174;
    byte b175;
    byte b176;
    byte b177;

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpscBlockingConsumerArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 277
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscBlockingConsumerArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    public MpscBlockingConsumerArrayQueue(int capacity) {
        super((long) ((Pow2.roundToPowerOfTwo(capacity) - 1) << 1), UnsafeRefArrayAccess.allocateRefArray(Pow2.roundToPowerOfTwo(capacity)));
        RangeUtil.checkGreaterThanOrEqual(capacity, 1, "capacity");
        soProducerLimit((long) ((Pow2.roundToPowerOfTwo(capacity) - 1) << 1));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final int size() {
        long currentProducerIndex;
        char lvConsumerIndex = lvConsumerIndex();
        do {
            currentProducerIndex = lvProducerIndex();
            lvConsumerIndex = lvConsumerIndex();
        } while (lvConsumerIndex != lvConsumerIndex);
        long size = (currentProducerIndex - lvConsumerIndex) >> 1;
        if (size > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public final boolean isEmpty() {
        return lvConsumerIndex() / 2 == lvProducerIndex() / 2;
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: org.jctools.queues.MpscBlockingConsumerArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean offerIfBelowThreshold(E e, int threshold) {
        if (null == e) {
            throw new NullPointerException();
        }
        long mask = this.producerMask;
        long capacity = mask + 2;
        int threshold2 = threshold << 1;
        Object[] objArr = this.producerBuffer;
        while (true) {
            long pIndex = lvProducerIndex();
            if ((pIndex & 1) != 1) {
                long producerLimit = lvProducerLimit();
                if ((capacity - (producerLimit - pIndex) >= ((long) threshold2) || producerLimit <= pIndex) && !recalculateProducerLimit(pIndex, producerLimit, lvConsumerIndex(), capacity, (long) threshold2)) {
                    return false;
                }
                if (casProducerIndex(pIndex, pIndex + 2)) {
                    UnsafeRefArrayAccess.soRefElement(objArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask), e);
                    return true;
                }
            } else if (offerAndWakeup(objArr, mask, pIndex, e)) {
                return true;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: org.jctools.queues.MpscBlockingConsumerArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        long mask = this.producerMask;
        Object[] objArr = this.producerBuffer;
        while (true) {
            long pIndex = lvProducerIndex();
            if ((pIndex & 1) != 1) {
                long producerLimit = lvProducerLimit();
                if (producerLimit <= pIndex && !recalculateProducerLimit(mask, pIndex, producerLimit)) {
                    return false;
                }
                if (casProducerIndex(pIndex, pIndex + 2)) {
                    UnsafeRefArrayAccess.soRefElement(objArr, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask), e);
                    return true;
                }
            } else if (offerAndWakeup(objArr, mask, pIndex, e)) {
                return true;
            }
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e) throws InterruptedException {
        if (!offer(e)) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.concurrent.BlockingQueue
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException {
        if (offer(e)) {
            return true;
        }
        throw new UnsupportedOperationException();
    }

    private boolean offerAndWakeup(E[] buffer, long mask, long pIndex, E e) {
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(pIndex, mask);
        Thread consumerThread = lvBlocked();
        if (consumerThread == null || !casProducerIndex(pIndex, pIndex + 1)) {
            return false;
        }
        UnsafeRefArrayAccess.soRefElement(buffer, offset, e);
        LockSupport.unpark(consumerThread);
        return true;
    }

    private boolean recalculateProducerLimit(long mask, long pIndex, long producerLimit) {
        return recalculateProducerLimit(pIndex, producerLimit, lvConsumerIndex(), mask + 2, mask + 2);
    }

    private boolean recalculateProducerLimit(long pIndex, long producerLimit, long cIndex, long bufferCapacity, long threshold) {
        if (cIndex + bufferCapacity > pIndex) {
            casProducerLimit(producerLimit, cIndex + bufferCapacity);
        }
        long size = pIndex - cIndex;
        return size < threshold && size < bufferCapacity;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.MpscBlockingConsumerArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        Object[] objArr = this.consumerBuffer;
        long mask = this.consumerMask;
        long cIndex = lpConsumerIndex();
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null) {
            return (E) parkUntilNext(objArr, cIndex, offset, LongCompanionObject.MAX_VALUE);
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, null);
        soConsumerIndex(cIndex + 2);
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.MpscBlockingConsumerArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.BlockingQueue
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        Object[] objArr = this.consumerBuffer;
        long mask = this.consumerMask;
        long cIndex = lpConsumerIndex();
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(cIndex, mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null) {
            long timeoutNs = unit.toNanos(timeout);
            if (timeoutNs <= 0) {
                return null;
            }
            return (E) parkUntilNext(objArr, cIndex, offset, timeoutNs);
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, null);
        soConsumerIndex(cIndex + 2);
        return e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0099, code lost:
        soBlocked(null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private E parkUntilNext(E[] r9, long r10, long r12, long r14) throws java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscBlockingConsumerArrayQueue.parkUntilNext(java.lang.Object[], long, long, long):java.lang.Object");
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return capacity() - size();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c, int maxElements) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v18, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        Object[] objArr = this.consumerBuffer;
        long mask = this.consumerMask;
        long index = lpConsumerIndex();
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null) {
            if (index == lvProducerIndex()) {
                return null;
            }
            e = spinWaitForElement(objArr, offset);
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, null);
        soConsumerIndex(index + 2);
        return e;
    }

    private static <E> E spinWaitForElement(E[] buffer, long offset) {
        E e;
        do {
            e = (E) UnsafeRefArrayAccess.lvRefElement(buffer, offset);
        } while (e == null);
        return e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v15, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        Object[] objArr = this.consumerBuffer;
        long mask = this.consumerMask;
        long index = lpConsumerIndex();
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, mask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null && index != lvProducerIndex()) {
            e = spinWaitForElement(objArr, offset);
        }
        return e;
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentProducerIndex() {
        return lvProducerIndex() / 2;
    }

    @Override // org.jctools.queues.QueueProgressIndicators
    public long currentConsumerIndex() {
        return lvConsumerIndex() / 2;
    }

    @Override // org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) ((this.consumerMask + 2) >> 1);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        Object[] objArr = this.consumerBuffer;
        long index = lpConsumerIndex();
        long offset = LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(index, this.consumerMask);
        E e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, offset);
        if (e == null) {
            return null;
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, null);
        soConsumerIndex(index + 2);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) UnsafeRefArrayAccess.lvRefElement(this.consumerBuffer, LinkedArrayQueueUtil.modifiedCalcCircularRefElementOffset(lpConsumerIndex(), this.consumerMask));
    }

    public int drain(MessagePassingQueue.Consumer<E> c, int limit, long timeout, TimeUnit unit) throws InterruptedException {
        if (limit == 0) {
            return 0;
        }
        int drained = drain(c, limit);
        if (drained != 0) {
            return drained;
        }
        E e = poll(timeout, unit);
        if (e == null) {
            return 0;
        }
        c.accept(e);
        return 1 + drain(c, limit - 1);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return MessagePassingQueueUtil.fillBounded(this, s);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return drain(c, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c, int limit) {
        return MessagePassingQueueUtil.drain(this, c, limit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, w, exit);
    }
}
