package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicLongArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;
import org.jctools.util.RangeUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpmcAtomicArrayQueue.class */
public class MpmcAtomicArrayQueue<E> extends MpmcAtomicArrayQueueL3Pad<E> {
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.mpmc.max.lookahead.step", 4096).intValue();
    private final int lookAheadStep = Math.max(2, Math.min(capacity() / 4, MAX_LOOK_AHEAD_STEP));

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.MpmcAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(org.jctools.queues.MessagePassingQueue.Consumer<E> r11, int r12) {
        /*
        // Method dump skipped, instructions count: 304
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpmcAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
    }

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.MpmcAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r9, int r10) {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpmcAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public MpmcAtomicArrayQueue(int capacity) {
        super(RangeUtil.checkGreaterThanOrEqual(capacity, 2, "capacity"));
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r1v15, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = (long) (mask + 1);
        AtomicLongArray sBuffer = this.sequenceBuffer;
        char c = 0;
        while (true) {
            long pIndex = lvProducerIndex();
            int seqOffset = AtomicQueueUtil.calcCircularLongElementOffset(pIndex, mask);
            char lvLongElement = AtomicQueueUtil.lvLongElement(sBuffer, seqOffset);
            if (lvLongElement < pIndex) {
                if (pIndex - capacity >= c) {
                    long j = pIndex - capacity;
                    c = lvConsumerIndex();
                    if (j >= j) {
                        return false;
                    }
                }
                lvLongElement = pIndex + 1;
            }
            if (lvLongElement <= pIndex && casProducerIndex(pIndex, pIndex + 1)) {
                AtomicQueueUtil.spRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
                AtomicQueueUtil.soLongElement(sBuffer, seqOffset, pIndex + 1);
                return true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r1v14, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        AtomicLongArray sBuffer = this.sequenceBuffer;
        int mask = this.mask;
        char c = 65535;
        while (true) {
            long cIndex = lvConsumerIndex();
            int seqOffset = AtomicQueueUtil.calcCircularLongElementOffset(cIndex, mask);
            char lvLongElement = AtomicQueueUtil.lvLongElement(sBuffer, seqOffset);
            long expectedSeq = cIndex + 1;
            if (lvLongElement < expectedSeq) {
                if (cIndex >= c) {
                    c = lvProducerIndex();
                    if (cIndex == cIndex) {
                        return null;
                    }
                }
                lvLongElement = expectedSeq + 1;
            }
            if (lvLongElement <= expectedSeq && casConsumerIndex(cIndex, cIndex + 1)) {
                int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) mask);
                E e = (E) AtomicQueueUtil.lpRefElement(this.buffer, offset);
                AtomicQueueUtil.spRefElement(this.buffer, offset, null);
                AtomicQueueUtil.soLongElement(sBuffer, seqOffset, cIndex + ((long) mask) + 1);
                return e;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicLongArray sBuffer = this.sequenceBuffer;
        int mask = this.mask;
        char c = 65535;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seq = AtomicQueueUtil.lvLongElement(sBuffer, AtomicQueueUtil.calcCircularLongElementOffset(cIndex, mask));
            long expectedSeq = cIndex + 1;
            if (seq < expectedSeq) {
                if (cIndex >= c) {
                    c = lvProducerIndex();
                    if (cIndex == cIndex) {
                        return null;
                    }
                } else {
                    continue;
                }
            } else if (seq == expectedSeq) {
                E e = (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) mask));
                if (lvConsumerIndex() == cIndex) {
                    return e;
                }
            } else {
                continue;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        AtomicLongArray sBuffer = this.sequenceBuffer;
        while (true) {
            long pIndex = lvProducerIndex();
            int seqOffset = AtomicQueueUtil.calcCircularLongElementOffset(pIndex, mask);
            long seq = AtomicQueueUtil.lvLongElement(sBuffer, seqOffset);
            if (seq < pIndex) {
                return false;
            }
            if (seq <= pIndex && casProducerIndex(pIndex, pIndex + 1)) {
                AtomicQueueUtil.spRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
                AtomicQueueUtil.soLongElement(sBuffer, seqOffset, pIndex + 1);
                return true;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicLongArray sBuffer = this.sequenceBuffer;
        int mask = this.mask;
        while (true) {
            long cIndex = lvConsumerIndex();
            int seqOffset = AtomicQueueUtil.calcCircularLongElementOffset(cIndex, mask);
            long seq = AtomicQueueUtil.lvLongElement(sBuffer, seqOffset);
            long expectedSeq = cIndex + 1;
            if (seq < expectedSeq) {
                return null;
            }
            if (seq <= expectedSeq && casConsumerIndex(cIndex, cIndex + 1)) {
                int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) mask);
                E e = (E) AtomicQueueUtil.lpRefElement(this.buffer, offset);
                AtomicQueueUtil.spRefElement(this.buffer, offset, null);
                AtomicQueueUtil.soLongElement(sBuffer, seqOffset, cIndex + ((long) mask) + 1);
                return e;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        AtomicLongArray sBuffer = this.sequenceBuffer;
        int mask = this.mask;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seq = AtomicQueueUtil.lvLongElement(sBuffer, AtomicQueueUtil.calcCircularLongElementOffset(cIndex, mask));
            long expectedSeq = cIndex + 1;
            if (seq < expectedSeq) {
                return null;
            }
            if (seq == expectedSeq) {
                E e = (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) mask));
                if (lvConsumerIndex() == cIndex) {
                    return e;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.MessagePassingQueue$Consumer<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, (long) r0);
        r0 = org.jctools.queues.atomic.AtomicQueueUtil.lpRefElement(r0, r0);
        org.jctools.queues.atomic.AtomicQueueUtil.spRefElement(r0, r0, null);
        org.jctools.queues.atomic.AtomicQueueUtil.soLongElement(r0, r0, (r0 + ((long) r0)) + 1);
        r9.accept(r0);
        r21 = r21 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int drainOneByOne(org.jctools.queues.MessagePassingQueue.Consumer<E> r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            java.util.concurrent.atomic.AtomicLongArray r0 = r0.sequenceBuffer
            r11 = r0
            r0 = r8
            int r0 = r0.mask
            r12 = r0
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r13 = r0
            r0 = 0
            r21 = r0
        L_0x0014:
            r0 = r21
            r1 = r10
            if (r0 >= r1) goto L_0x008e
        L_0x001a:
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r14 = r0
            r0 = r14
            r1 = r12
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularLongElementOffset(r0, r1)
            r16 = r0
            r0 = r11
            r1 = r16
            long r0 = org.jctools.queues.atomic.AtomicQueueUtil.lvLongElement(r0, r1)
            r17 = r0
            r0 = r14
            r1 = 1
            long r0 = r0 + r1
            r19 = r0
            r0 = r17
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0042
            r0 = r21
            return r0
        L_0x0042:
            r0 = r17
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x001a
            r0 = r8
            r1 = r14
            r2 = r14
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casConsumerIndex(r1, r2)
            if (r0 == 0) goto L_0x001a
            r0 = r14
            r1 = r12
            long r1 = (long) r1
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r22 = r0
            r0 = r13
            r1 = r22
            java.lang.Object r0 = org.jctools.queues.atomic.AtomicQueueUtil.lpRefElement(r0, r1)
            r23 = r0
            r0 = r13
            r1 = r22
            r2 = 0
            org.jctools.queues.atomic.AtomicQueueUtil.spRefElement(r0, r1, r2)
            r0 = r11
            r1 = r16
            r2 = r14
            r3 = r12
            long r3 = (long) r3
            long r2 = r2 + r3
            r3 = 1
            long r2 = r2 + r3
            org.jctools.queues.atomic.AtomicQueueUtil.soLongElement(r0, r1, r2)
            r0 = r9
            r1 = r23
            r0.accept(r1)
            int r21 = r21 + 1
            goto L_0x0014
        L_0x008e:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpmcAtomicArrayQueue.drainOneByOne(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
    }

    private boolean notAvailable(long index, int mask, AtomicLongArray sBuffer, long expectedSeq) {
        if (AtomicQueueUtil.lvLongElement(sBuffer, AtomicQueueUtil.calcCircularLongElementOffset(index, mask)) < expectedSeq) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, (long) r0), r9.get());
        org.jctools.queues.atomic.AtomicQueueUtil.soLongElement(r0, r0, r0 + 1);
        r19 = r19 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int fillOneByOne(org.jctools.queues.MessagePassingQueue.Supplier<E> r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            java.util.concurrent.atomic.AtomicLongArray r0 = r0.sequenceBuffer
            r11 = r0
            r0 = r8
            int r0 = r0.mask
            r12 = r0
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r13 = r0
            r0 = 0
            r19 = r0
        L_0x0014:
            r0 = r19
            r1 = r10
            if (r0 >= r1) goto L_0x0074
        L_0x001a:
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r14 = r0
            r0 = r14
            r1 = r12
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularLongElementOffset(r0, r1)
            r16 = r0
            r0 = r11
            r1 = r16
            long r0 = org.jctools.queues.atomic.AtomicQueueUtil.lvLongElement(r0, r1)
            r17 = r0
            r0 = r17
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
            r0 = r19
            return r0
        L_0x003c:
            r0 = r17
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x001a
            r0 = r8
            r1 = r14
            r2 = r14
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x001a
            r0 = r13
            r1 = r14
            r2 = r12
            long r2 = (long) r2
            int r1 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r1, r2)
            r2 = r9
            java.lang.Object r2 = r2.get()
            org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            r0 = r11
            r1 = r16
            r2 = r14
            r3 = 1
            long r2 = r2 + r3
            org.jctools.queues.atomic.AtomicQueueUtil.soLongElement(r0, r1, r2)
            int r19 = r19 + 1
            goto L_0x0014
        L_0x0074:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpmcAtomicArrayQueue.fillOneByOne(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return MessagePassingQueueUtil.fillBounded(this, s);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, w, exit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }
}
