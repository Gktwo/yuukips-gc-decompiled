package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.RangeUtil;
import org.jctools.util.UnsafeLongArrayAccess;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/MpmcArrayQueue.class */
public class MpmcArrayQueue<E> extends MpmcArrayQueueL3Pad<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpmcArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(org.jctools.queues.MessagePassingQueue.Consumer<E> r12, int r13) {
        /*
        // Method dump skipped, instructions count: 302
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpmcArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r10, int r11) {
        /*
        // Method dump skipped, instructions count: 279
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // org.jctools.queues.ConcurrentCircularArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return size();
    }

    public MpmcArrayQueue(int capacity) {
        super(RangeUtil.checkGreaterThanOrEqual(capacity, 2, "capacity"));
    }

    /* JADX WARN: Type inference failed for: r0v13, types: [long] */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* JADX WARN: Type inference failed for: r1v15, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        long mask = this.mask;
        long capacity = mask + 1;
        long[] sBuffer = this.sequenceBuffer;
        char c = 0;
        while (true) {
            long pIndex = lvProducerIndex();
            long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(pIndex, mask);
            char lvLongElement = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset);
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
                UnsafeRefArrayAccess.spRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e);
                UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, pIndex + 1);
                return true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r1v13, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        char c = 65535;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex, mask);
            char lvLongElement = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset);
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
                long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
                E e = (E) UnsafeRefArrayAccess.lpRefElement(this.buffer, offset);
                UnsafeRefArrayAccess.spRefElement(this.buffer, offset, null);
                UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, cIndex + mask + 1);
                return e;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [long] */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        char c = 65535;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex, mask));
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
                E e = (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask));
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
        long mask = this.mask;
        long[] sBuffer = this.sequenceBuffer;
        while (true) {
            long pIndex = lvProducerIndex();
            long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(pIndex, mask);
            long seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset);
            if (seq < pIndex) {
                return false;
            }
            if (seq <= pIndex && casProducerIndex(pIndex, pIndex + 1)) {
                UnsafeRefArrayAccess.spRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(pIndex, mask), e);
                UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, pIndex + 1);
                return true;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seqOffset = UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex, mask);
            long seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, seqOffset);
            long expectedSeq = cIndex + 1;
            if (seq < expectedSeq) {
                return null;
            }
            if (seq <= expectedSeq && casConsumerIndex(cIndex, cIndex + 1)) {
                long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask);
                E e = (E) UnsafeRefArrayAccess.lpRefElement(this.buffer, offset);
                UnsafeRefArrayAccess.spRefElement(this.buffer, offset, null);
                UnsafeLongArrayAccess.soLongElement(sBuffer, seqOffset, cIndex + mask + 1);
                return e;
            }
        }
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        long[] sBuffer = this.sequenceBuffer;
        long mask = this.mask;
        while (true) {
            long cIndex = lvConsumerIndex();
            long seq = UnsafeLongArrayAccess.lvLongElement(sBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(cIndex, mask));
            long expectedSeq = cIndex + 1;
            if (seq < expectedSeq) {
                return null;
            }
            if (seq == expectedSeq) {
                E e = (E) UnsafeRefArrayAccess.lvRefElement(this.buffer, UnsafeRefArrayAccess.calcCircularRefElementOffset(cIndex, mask));
                if (lvConsumerIndex() == cIndex) {
                    return e;
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: org.jctools.queues.MessagePassingQueue$Consumer<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0057, code lost:
        r0 = org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r0, r0);
        r0 = org.jctools.util.UnsafeRefArrayAccess.lpRefElement(r0, r0);
        org.jctools.util.UnsafeRefArrayAccess.spRefElement(r0, r0, null);
        org.jctools.util.UnsafeLongArrayAccess.soLongElement(r0, r0, (r0 + r0) + 1);
        r9.accept(r0);
        r23 = r23 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int drainOneByOne(org.jctools.queues.MessagePassingQueue.Consumer<E> r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            long[] r0 = r0.sequenceBuffer
            r11 = r0
            r0 = r8
            long r0 = r0.mask
            r12 = r0
            r0 = r8
            java.lang.Object[] r0 = r0.buffer
            r14 = r0
            r0 = 0
            r23 = r0
        L_0x0014:
            r0 = r23
            r1 = r10
            if (r0 >= r1) goto L_0x008c
        L_0x001a:
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r15 = r0
            r0 = r15
            r1 = r12
            long r0 = org.jctools.util.UnsafeLongArrayAccess.calcCircularLongElementOffset(r0, r1)
            r17 = r0
            r0 = r11
            r1 = r17
            long r0 = org.jctools.util.UnsafeLongArrayAccess.lvLongElement(r0, r1)
            r19 = r0
            r0 = r15
            r1 = 1
            long r0 = r0 + r1
            r21 = r0
            r0 = r19
            r1 = r21
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0042
            r0 = r23
            return r0
        L_0x0042:
            r0 = r19
            r1 = r21
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x001a
            r0 = r8
            r1 = r15
            r2 = r15
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casConsumerIndex(r1, r2)
            if (r0 == 0) goto L_0x001a
            r0 = r15
            r1 = r12
            long r0 = org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r0, r1)
            r24 = r0
            r0 = r14
            r1 = r24
            java.lang.Object r0 = org.jctools.util.UnsafeRefArrayAccess.lpRefElement(r0, r1)
            r26 = r0
            r0 = r14
            r1 = r24
            r2 = 0
            org.jctools.util.UnsafeRefArrayAccess.spRefElement(r0, r1, r2)
            r0 = r11
            r1 = r17
            r2 = r15
            r3 = r12
            long r2 = r2 + r3
            r3 = 1
            long r2 = r2 + r3
            org.jctools.util.UnsafeLongArrayAccess.soLongElement(r0, r1, r2)
            r0 = r9
            r1 = r26
            r0.accept(r1)
            int r23 = r23 + 1
            goto L_0x0014
        L_0x008c:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcArrayQueue.drainOneByOne(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
    }

    private boolean notAvailable(long index, long mask, long[] sBuffer, long expectedSeq) {
        if (UnsafeLongArrayAccess.lvLongElement(sBuffer, UnsafeLongArrayAccess.calcCircularLongElementOffset(index, mask)) < expectedSeq) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0051, code lost:
        org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r0, r0), r9.get());
        org.jctools.util.UnsafeLongArrayAccess.soLongElement(r0, r0, r0 + 1);
        r21 = r21 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int fillOneByOne(org.jctools.queues.MessagePassingQueue.Supplier<E> r9, int r10) {
        /*
            r8 = this;
            r0 = r8
            long[] r0 = r0.sequenceBuffer
            r11 = r0
            r0 = r8
            long r0 = r0.mask
            r12 = r0
            r0 = r8
            java.lang.Object[] r0 = r0.buffer
            r14 = r0
            r0 = 0
            r21 = r0
        L_0x0014:
            r0 = r21
            r1 = r10
            if (r0 >= r1) goto L_0x0073
        L_0x001a:
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r15 = r0
            r0 = r15
            r1 = r12
            long r0 = org.jctools.util.UnsafeLongArrayAccess.calcCircularLongElementOffset(r0, r1)
            r17 = r0
            r0 = r11
            r1 = r17
            long r0 = org.jctools.util.UnsafeLongArrayAccess.lvLongElement(r0, r1)
            r19 = r0
            r0 = r19
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
            r0 = r21
            return r0
        L_0x003c:
            r0 = r19
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x001a
            r0 = r8
            r1 = r15
            r2 = r15
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x001a
            r0 = r14
            r1 = r15
            r2 = r12
            long r1 = org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r1, r2)
            r2 = r9
            java.lang.Object r2 = r2.get()
            org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, r1, r2)
            r0 = r11
            r1 = r17
            r2 = r15
            r3 = 1
            long r2 = r2 + r3
            org.jctools.util.UnsafeLongArrayAccess.soLongElement(r0, r1, r2)
            int r21 = r21 + 1
            goto L_0x0014
        L_0x0073:
            r0 = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpmcArrayQueue.fillOneByOne(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
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
