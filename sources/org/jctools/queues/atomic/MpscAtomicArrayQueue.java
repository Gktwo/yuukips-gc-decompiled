package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/MpscAtomicArrayQueue.class */
public class MpscAtomicArrayQueue<E> extends MpscAtomicArrayQueueL3Pad<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.MpscAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
    public int drain(org.jctools.queues.MessagePassingQueue.Consumer<E> r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = r7
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "c is null"
            r1.<init>(r2)
            throw r0
            r0 = r8
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
            r1.<init>(r2)
            throw r0
            r0 = r8
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r6
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r9 = r0
            r0 = r6
            int r0 = r0.mask
            r10 = r0
            r0 = r6
            long r0 = r0.lpConsumerIndex()
            r11 = r0
            r0 = 0
            r13 = r0
            r0 = r13
            r1 = r8
            if (r0 >= r1) goto L_0x0081
            r0 = r11
            r1 = r13
            long r1 = (long) r1
            long r0 = r0 + r1
            r14 = r0
            r0 = r14
            r1 = r10
            long r1 = (long) r1
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r16 = r0
            r0 = r9
            r1 = r16
            java.lang.Object r0 = org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r17 = r0
            r0 = 0
            r1 = r17
            if (r0 != r1) goto L_0x0064
            r0 = r13
            return r0
            r0 = r9
            r1 = r16
            r2 = 0
            org.jctools.queues.atomic.AtomicQueueUtil.spRefElement(r0, r1, r2)
            r0 = r6
            r1 = r14
            r2 = 1
            long r1 = r1 + r2
            r0.soConsumerIndex(r1)
            r0 = r7
            r1 = r17
            r0.accept(r1)
            int r13 = r13 + 1
            goto L_0x003b
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpscAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.MpscAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
            r8 = this;
            r0 = 0
            r1 = r9
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "supplier is null"
            r1.<init>(r2)
            throw r0
            r0 = r10
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
            r1.<init>(r2)
            throw r0
            r0 = r10
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r8
            int r0 = r0.mask
            r11 = r0
            r0 = r11
            r1 = 1
            int r0 = r0 + r1
            long r0 = (long) r0
            r12 = r0
            r0 = r8
            long r0 = r0.lvProducerLimit()
            r14 = r0
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r16 = r0
            r0 = r14
            r1 = r16
            long r0 = r0 - r1
            r19 = r0
            r0 = r19
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x006f
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r21 = r0
            r0 = r21
            r1 = r12
            long r0 = r0 + r1
            r14 = r0
            r0 = r14
            r1 = r16
            long r0 = r0 - r1
            r19 = r0
            r0 = r19
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0069
            r0 = 0
            return r0
            r0 = r8
            r1 = r14
            r0.soProducerLimit(r1)
            r0 = r19
            int r0 = (int) r0
            r1 = r10
            int r0 = java.lang.Math.min(r0, r1)
            r18 = r0
            r0 = r8
            r1 = r16
            r2 = r16
            r3 = r18
            long r3 = (long) r3
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x0038
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r19 = r0
            r0 = 0
            r20 = r0
            r0 = r20
            r1 = r18
            if (r0 >= r1) goto L_0x00b7
            r0 = r16
            r1 = r20
            long r1 = (long) r1
            long r0 = r0 + r1
            r1 = r11
            long r1 = (long) r1
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r21 = r0
            r0 = r19
            r1 = r21
            r2 = r9
            java.lang.Object r2 = r2.get()
            org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            int r20 = r20 + 1
            goto L_0x0090
            r0 = r18
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpscAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public MpscAtomicArrayQueue(int capacity) {
        super(capacity);
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    public boolean offerIfBelowThreshold(E e, int threshold) {
        long pIndex;
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = (long) (mask + 1);
        char lvProducerLimit = lvProducerLimit();
        do {
            pIndex = lvProducerIndex();
            if (capacity - (lvProducerLimit - pIndex) >= ((long) threshold)) {
                long cIndex = lvConsumerIndex();
                if (pIndex - cIndex >= ((long) threshold)) {
                    return false;
                }
                lvProducerLimit = cIndex + capacity;
                soProducerLimit(lvProducerLimit);
            }
        } while (!casProducerIndex(pIndex, pIndex + 1));
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean offer(E r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r9
            if (r0 != r1) goto L_0x000d
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r1 = r0
            r1.<init>()
            throw r0
        L_0x000d:
            r0 = r8
            int r0 = r0.mask
            r10 = r0
            r0 = r8
            long r0 = r0.lvProducerLimit()
            r11 = r0
        L_0x0017:
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r13 = r0
            r0 = r13
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0040
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r15 = r0
            r0 = r15
            r1 = r10
            long r1 = (long) r1
            long r0 = r0 + r1
            r1 = 1
            long r0 = r0 + r1
            r11 = r0
            r0 = r13
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003b
            r0 = 0
            return r0
        L_0x003b:
            r0 = r8
            r1 = r11
            r0.soProducerLimit(r1)
        L_0x0040:
            r0 = r8
            r1 = r13
            r2 = r13
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casProducerIndex(r1, r2)
            if (r0 == 0) goto L_0x0017
            r0 = r13
            r1 = r10
            long r1 = (long) r1
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r15 = r0
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r1 = r15
            r2 = r9
            org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.MpscAtomicArrayQueue.offer(java.lang.Object):boolean");
    }

    public final int failFastOffer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int mask = this.mask;
        long capacity = (long) (mask + 1);
        long pIndex = lvProducerIndex();
        if (pIndex >= lvProducerLimit()) {
            long producerLimit = lvConsumerIndex() + capacity;
            if (pIndex >= producerLimit) {
                return 1;
            }
            soProducerLimit(producerLimit);
        }
        if (!casProducerIndex(pIndex, pIndex + 1)) {
            return -1;
        }
        AtomicQueueUtil.soRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(pIndex, (long) mask), e);
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        AtomicReferenceArray<E> buffer = this.buffer;
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null != e) {
            AtomicQueueUtil.spRefElement(buffer, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        } else if (cIndex == lvProducerIndex()) {
            return null;
        } else {
            do {
                e = AtomicQueueUtil.lvRefElement(buffer, offset);
            } while (e == null);
            AtomicQueueUtil.spRefElement(buffer, offset, null);
            soConsumerIndex(cIndex + 1);
            return e;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v14, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        AtomicReferenceArray<E> buffer = this.buffer;
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null != e) {
            return e;
        }
        if (cIndex == lvProducerIndex()) {
            return null;
        }
        do {
            e = AtomicQueueUtil.lvRefElement(buffer, offset);
        } while (e == null);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        return offer(e);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        AtomicReferenceArray<E> buffer = this.buffer;
        long cIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(cIndex, (long) this.mask);
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e) {
            return null;
        }
        AtomicQueueUtil.spRefElement(buffer, offset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), (long) this.mask));
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return drain(c, capacity());
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

    @Deprecated
    public int weakOffer(E e) {
        return failFastOffer(e);
    }
}
