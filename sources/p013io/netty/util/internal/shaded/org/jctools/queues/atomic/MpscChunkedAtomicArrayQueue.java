package p013io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue;
import p013io.netty.util.internal.shaded.org.jctools.util.Pow2;

/* renamed from: io.netty.util.internal.shaded.org.jctools.queues.atomic.MpscChunkedAtomicArrayQueue */
/* loaded from: grasscutter.jar:io/netty/util/internal/shaded/org/jctools/queues/atomic/MpscChunkedAtomicArrayQueue.class */
public class MpscChunkedAtomicArrayQueue<E> extends MpscChunkedAtomicArrayQueueColdProducerFields<E> {
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

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        fill(supplier, waitStrategy, exitCondition);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier, int i) {
        return fill(supplier, i);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int fill(MessagePassingQueue.Supplier supplier) {
        return fill(supplier);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return relaxedPeek();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return relaxedPoll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return peek();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.Queue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean offer(Object obj) {
        return offer(obj);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, java.util.AbstractCollection, java.util.Collection, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return size();
    }

    public MpscChunkedAtomicArrayQueue(int maxCapacity) {
        super(Math.max(2, Math.min(1024, Pow2.roundToPowerOfTwo(maxCapacity / 8))), maxCapacity);
    }

    public MpscChunkedAtomicArrayQueue(int initialCapacity, int maxCapacity) {
        super(initialCapacity, maxCapacity);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long availableInQueue(long pIndex, long cIndex) {
        return this.maxQueueCapacity - (pIndex - cIndex);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue, p013io.netty.util.internal.shaded.org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, p013io.netty.util.internal.shaded.org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return (int) (this.maxQueueCapacity / 2);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected int getNextBufferSize(AtomicReferenceArray<E> buffer) {
        return AtomicQueueUtil.length(buffer);
    }

    @Override // p013io.netty.util.internal.shaded.org.jctools.queues.atomic.BaseMpscLinkedAtomicArrayQueue
    protected long getCurrentBufferCapacity(long mask) {
        return mask;
    }
}
