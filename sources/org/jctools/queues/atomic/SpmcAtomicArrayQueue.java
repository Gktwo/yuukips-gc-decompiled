package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.queues.MessagePassingQueueUtil;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpmcAtomicArrayQueue.class */
public class SpmcAtomicArrayQueue<E> extends SpmcAtomicArrayQueueL3Pad<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.SpmcAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
    public int drain(org.jctools.queues.MessagePassingQueue.Consumer<E> r9, int r10) {
        /*
            r8 = this;
            r0 = 0
            r1 = r9
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "c is null"
            r1.<init>(r2)
            throw r0
            r0 = r10
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
            r1.<init>(r2)
            throw r0
            r0 = r10
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r11 = r0
            r0 = r8
            int r0 = r0.mask
            r12 = r0
            r0 = r8
            long r0 = r0.lvProducerIndexCache()
            r13 = r0
            r0 = 0
            r15 = r0
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r16 = r0
            r0 = r16
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r18 = r0
            r0 = r16
            r1 = r18
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0059
            r0 = 0
            return r0
            r0 = r18
            r13 = r0
            r0 = r8
            r1 = r18
            r0.svProducerIndexCache(r1)
            r0 = r13
            r1 = r16
            long r0 = r0 - r1
            int r0 = (int) r0
            r18 = r0
            r0 = r18
            r1 = r10
            int r0 = java.lang.Math.min(r0, r1)
            r15 = r0
            r0 = r8
            r1 = r16
            r2 = r16
            r3 = r15
            long r3 = (long) r3
            long r2 = r2 + r3
            boolean r0 = r0.casConsumerIndex(r1, r2)
            if (r0 == 0) goto L_0x003b
            r0 = 0
            r18 = r0
            r0 = r18
            r1 = r15
            if (r0 >= r1) goto L_0x00a5
            r0 = r9
            r1 = r8
            r2 = r11
            r3 = r16
            r4 = r18
            long r4 = (long) r4
            long r3 = r3 + r4
            r4 = r12
            java.lang.Object r1 = r1.removeElement(r2, r3, r4)
            r0.accept(r1)
            int r18 = r18 + 1
            goto L_0x0085
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpmcAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.SpmcAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r8 = r0
            r0 = r5
            int r0 = r0.mask
            r9 = r0
            r0 = r5
            long r0 = r0.lpProducerIndex()
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = r12
            r1 = r7
            if (r0 >= r1) goto L_0x0076
            r0 = r10
            r1 = r9
            long r1 = (long) r1
            int r0 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r0, r1)
            r13 = r0
            r0 = 0
            r1 = r8
            r2 = r13
            java.lang.Object r1 = org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r1, r2)
            if (r0 == r1) goto L_0x0058
            r0 = r12
            return r0
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
            r0 = r8
            r1 = r13
            r2 = r6
            java.lang.Object r2 = r2.get()
            org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
            r0 = r5
            r1 = r10
            r0.soProducerIndex(r1)
            int r12 = r12 + 1
            goto L_0x003b
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpmcAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public SpmcAtomicArrayQueue(int capacity) {
        super(capacity);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<E> buffer = this.buffer;
        int mask = this.mask;
        long currProducerIndex = lvProducerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(currProducerIndex, (long) mask);
        if (null == AtomicQueueUtil.lvRefElement(buffer, offset)) {
            AtomicQueueUtil.soRefElement(buffer, offset, e);
            soProducerIndex(currProducerIndex + 1);
            return true;
        } else if (currProducerIndex - lvConsumerIndex() > ((long) mask)) {
            return false;
        } else {
            do {
            } while (null != AtomicQueueUtil.lvRefElement(buffer, offset));
            AtomicQueueUtil.soRefElement(buffer, offset, e);
            soProducerIndex(currProducerIndex + 1);
            return true;
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [long] */
    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E poll() {
        /*
            r8 = this;
            r0 = r8
            long r0 = r0.lvProducerIndexCache()
            r11 = r0
        L_0x0005:
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r9 = r0
            r0 = r9
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0028
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r13 = r0
            r0 = r9
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x001f
            r0 = 0
            return r0
        L_0x001f:
            r0 = r13
            r11 = r0
            r0 = r8
            r1 = r13
            r0.svProducerIndexCache(r1)
        L_0x0028:
            r0 = r8
            r1 = r9
            r2 = r9
            r3 = 1
            long r2 = r2 + r3
            boolean r0 = r0.casConsumerIndex(r1, r2)
            if (r0 == 0) goto L_0x0005
            r0 = r8
            r1 = r8
            java.util.concurrent.atomic.AtomicReferenceArray r1 = r1.buffer
            r2 = r9
            r3 = r8
            int r3 = r3.mask
            java.lang.Object r0 = r0.removeElement(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpmcAtomicArrayQueue.poll():java.lang.Object");
    }

    private E removeElement(AtomicReferenceArray<E> buffer, long index, int mask) {
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(index, (long) mask);
        E e = (E) AtomicQueueUtil.lpRefElement(buffer, offset);
        AtomicQueueUtil.soRefElement(buffer, offset, null);
        return e;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E peek() {
        /*
            r6 = this;
            r0 = r6
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r0.buffer
            r7 = r0
            r0 = r6
            int r0 = r0.mask
            r8 = r0
            r0 = r6
            long r0 = r0.lvProducerIndexCache()
            r9 = r0
            r0 = r6
            long r0 = r0.lvConsumerIndex()
            r13 = r0
        L_0x0015:
            r0 = r13
            r11 = r0
            r0 = r11
            r1 = r9
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0039
            r0 = r6
            long r0 = r0.lvProducerIndex()
            r16 = r0
            r0 = r11
            r1 = r16
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0030
            r0 = 0
            return r0
        L_0x0030:
            r0 = r16
            r9 = r0
            r0 = r6
            r1 = r16
            r0.svProducerIndexCache(r1)
        L_0x0039:
            r0 = r7
            r1 = r11
            r2 = r8
            long r2 = (long) r2
            int r1 = org.jctools.queues.atomic.AtomicQueueUtil.calcCircularRefElementOffset(r1, r2)
            java.lang.Object r0 = org.jctools.queues.atomic.AtomicQueueUtil.lvRefElement(r0, r1)
            r15 = r0
            r0 = r6
            long r0 = r0.lvConsumerIndex()
            r13 = r0
            r0 = 0
            r1 = r15
            if (r0 == r1) goto L_0x0015
            r0 = r13
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0015
            r0 = r15
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpmcAtomicArrayQueue.peek():java.lang.Object");
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (null == e) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> buffer = this.buffer;
        int mask = this.mask;
        long producerIndex = lpProducerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(producerIndex, (long) mask);
        if (null != AtomicQueueUtil.lvRefElement(buffer, offset)) {
            return false;
        }
        AtomicQueueUtil.soRefElement(buffer, offset, e);
        soProducerIndex(producerIndex + 1);
        return true;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        return poll();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [long] */
    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        E e;
        AtomicReferenceArray<E> buffer = this.buffer;
        int mask = this.mask;
        char lvConsumerIndex = lvConsumerIndex();
        do {
            e = (E) AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(lvConsumerIndex, (long) mask));
            lvConsumerIndex = lvConsumerIndex();
        } while (lvConsumerIndex != lvConsumerIndex);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int drain(MessagePassingQueue.Consumer<E> c) {
        return MessagePassingQueueUtil.drain(this, c);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return fill(s, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.drain(this, c, w, exit);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition e) {
        MessagePassingQueueUtil.fill(this, s, w, e);
    }
}
