package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.UnsafeRefArrayAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/SpmcArrayQueue.class */
public class SpmcArrayQueue<E> extends SpmcArrayQueueL3Pad<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.SpmcArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
            java.lang.Object[] r0 = r0.buffer
            r11 = r0
            r0 = r8
            long r0 = r0.mask
            r12 = r0
            r0 = r8
            long r0 = r0.lvProducerIndexCache()
            r14 = r0
            r0 = 0
            r16 = r0
            r0 = r8
            long r0 = r0.lvConsumerIndex()
            r17 = r0
            r0 = r17
            r1 = r14
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0063
            r0 = r8
            long r0 = r0.lvProducerIndex()
            r19 = r0
            r0 = r17
            r1 = r19
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0059
            r0 = 0
            return r0
            r0 = r19
            r14 = r0
            r0 = r8
            r1 = r19
            r0.svProducerIndexCache(r1)
            r0 = r14
            r1 = r17
            long r0 = r0 - r1
            int r0 = (int) r0
            r19 = r0
            r0 = r19
            r1 = r10
            int r0 = java.lang.Math.min(r0, r1)
            r16 = r0
            r0 = r8
            r1 = r17
            r2 = r17
            r3 = r16
            long r3 = (long) r3
            long r2 = r2 + r3
            boolean r0 = r0.casConsumerIndex(r1, r2)
            if (r0 == 0) goto L_0x003b
            r0 = 0
            r19 = r0
            r0 = r19
            r1 = r16
            if (r0 >= r1) goto L_0x00a5
            r0 = r9
            r1 = r8
            r2 = r11
            r3 = r17
            r4 = r19
            long r4 = (long) r4
            long r3 = r3 + r4
            r4 = r12
            java.lang.Object r1 = r1.removeElement(r2, r3, r4)
            r0.accept(r1)
            int r19 = r19 + 1
            goto L_0x0085
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.SpmcArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.SpmcArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
            java.lang.Object[] r0 = r0.buffer
            r8 = r0
            r0 = r5
            long r0 = r0.mask
            r9 = r0
            r0 = r5
            long r0 = r0.lpProducerIndex()
            r11 = r0
            r0 = 0
            r13 = r0
            r0 = r13
            r1 = r7
            if (r0 >= r1) goto L_0x0075
            r0 = r11
            r1 = r9
            long r0 = org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r0, r1)
            r14 = r0
            r0 = 0
            r1 = r8
            r2 = r14
            java.lang.Object r1 = org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r1, r2)
            if (r0 == r1) goto L_0x0057
            r0 = r13
            return r0
            r0 = r11
            r1 = 1
            long r0 = r0 + r1
            r11 = r0
            r0 = r8
            r1 = r14
            r2 = r6
            java.lang.Object r2 = r2.get()
            org.jctools.util.UnsafeRefArrayAccess.soRefElement(r0, r1, r2)
            r0 = r5
            r1 = r11
            r0.soProducerIndex(r1)
            int r13 = r13 + 1
            goto L_0x003b
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.SpmcArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
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

    public SpmcArrayQueue(int capacity) {
        super(capacity);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        Object[] objArr = this.buffer;
        long mask = this.mask;
        long currProducerIndex = lvProducerIndex();
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(currProducerIndex, mask);
        if (null == UnsafeRefArrayAccess.lvRefElement(objArr, offset)) {
            UnsafeRefArrayAccess.soRefElement(objArr, offset, e);
            soProducerIndex(currProducerIndex + 1);
            return true;
        } else if (currProducerIndex - lvConsumerIndex() > mask) {
            return false;
        } else {
            do {
            } while (null != UnsafeRefArrayAccess.lvRefElement(objArr, offset));
            UnsafeRefArrayAccess.soRefElement(objArr, offset, e);
            soProducerIndex(currProducerIndex + 1);
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: org.jctools.queues.SpmcArrayQueue<E> */
    /* JADX WARN: Multi-variable type inference failed */
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
            java.lang.Object[] r1 = r1.buffer
            r2 = r9
            r3 = r8
            long r3 = r3.mask
            java.lang.Object r0 = r0.removeElement(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.SpmcArrayQueue.poll():java.lang.Object");
    }

    private E removeElement(E[] buffer, long index, long mask) {
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(index, mask);
        E e = (E) UnsafeRefArrayAccess.lpRefElement(buffer, offset);
        UnsafeRefArrayAccess.soRefElement(buffer, offset, null);
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
            java.lang.Object[] r0 = r0.buffer
            r7 = r0
            r0 = r6
            long r0 = r0.mask
            r8 = r0
            r0 = r6
            long r0 = r0.lvProducerIndexCache()
            r10 = r0
            r0 = r6
            long r0 = r0.lvConsumerIndex()
            r14 = r0
        L_0x0016:
            r0 = r14
            r12 = r0
            r0 = r12
            r1 = r10
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x003c
            r0 = r6
            long r0 = r0.lvProducerIndex()
            r17 = r0
            r0 = r12
            r1 = r17
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0032
            r0 = 0
            return r0
        L_0x0032:
            r0 = r17
            r10 = r0
            r0 = r6
            r1 = r17
            r0.svProducerIndexCache(r1)
        L_0x003c:
            r0 = r7
            r1 = r12
            r2 = r8
            long r1 = org.jctools.util.UnsafeRefArrayAccess.calcCircularRefElementOffset(r1, r2)
            java.lang.Object r0 = org.jctools.util.UnsafeRefArrayAccess.lvRefElement(r0, r1)
            r16 = r0
            r0 = r6
            long r0 = r0.lvConsumerIndex()
            r14 = r0
            r0 = 0
            r1 = r16
            if (r0 == r1) goto L_0x0016
            r0 = r14
            r1 = r12
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0016
            r0 = r16
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.SpmcArrayQueue.peek():java.lang.Object");
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (null == e) {
            throw new NullPointerException("Null is not a valid element");
        }
        Object[] objArr = this.buffer;
        long mask = this.mask;
        long producerIndex = lpProducerIndex();
        long offset = UnsafeRefArrayAccess.calcCircularRefElementOffset(producerIndex, mask);
        if (null != UnsafeRefArrayAccess.lvRefElement(objArr, offset)) {
            return false;
        }
        UnsafeRefArrayAccess.soRefElement(objArr, offset, e);
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
        Object[] objArr = this.buffer;
        long mask = this.mask;
        char lvConsumerIndex = lvConsumerIndex();
        do {
            e = (E) UnsafeRefArrayAccess.lvRefElement(objArr, UnsafeRefArrayAccess.calcCircularRefElementOffset(lvConsumerIndex, mask));
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
