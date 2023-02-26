package org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jctools.queues.MessagePassingQueue;

/* loaded from: grasscutter.jar:org/jctools/queues/atomic/SpscAtomicArrayQueue.class */
public class SpscAtomicArrayQueue<E> extends SpscAtomicArrayQueueL3Pad<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.SpscAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
            org.jctools.queues.atomic.AtomicQueueUtil.soRefElement(r0, r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpscAtomicArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.atomic.SpscAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r7, int r8) {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.atomic.SpscAtomicArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // org.jctools.queues.atomic.AtomicReferenceArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public SpscAtomicArrayQueue(int capacity) {
        super(Math.max(capacity, 4));
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        AtomicReferenceArray<E> buffer = this.buffer;
        int mask = this.mask;
        long producerIndex = lpProducerIndex();
        if (producerIndex >= this.producerLimit && !offerSlowPath(buffer, mask, producerIndex)) {
            return false;
        }
        AtomicQueueUtil.soRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(producerIndex, (long) mask), e);
        soProducerIndex(producerIndex + 1);
        return true;
    }

    private boolean offerSlowPath(AtomicReferenceArray<E> buffer, int mask, long producerIndex) {
        int lookAheadStep = this.lookAheadStep;
        if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(producerIndex + ((long) lookAheadStep), (long) mask))) {
            this.producerLimit = producerIndex + ((long) lookAheadStep);
            return true;
        } else if (null != AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(producerIndex, (long) mask))) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        long consumerIndex = lpConsumerIndex();
        int offset = AtomicQueueUtil.calcCircularRefElementOffset(consumerIndex, (long) this.mask);
        AtomicReferenceArray<E> buffer = this.buffer;
        E e = (E) AtomicQueueUtil.lvRefElement(buffer, offset);
        if (null == e) {
            return null;
        }
        AtomicQueueUtil.soRefElement(buffer, offset, null);
        soConsumerIndex(consumerIndex + 1);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        return (E) AtomicQueueUtil.lvRefElement(this.buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex(), (long) this.mask));
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E message) {
        return offer(message);
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
        return drain(c, capacity());
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return fill(s, capacity());
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: org.jctools.queues.MessagePassingQueue$Consumer<E> */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [long] */
    /* JADX WARN: Type inference failed for: r0v20, types: [long] */
    @Override // org.jctools.queues.MessagePassingQueue
    public void drain(MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition exit) {
        if (0 == c) {
            throw new IllegalArgumentException("c is null");
        } else if (null == w) {
            throw new IllegalArgumentException("wait is null");
        } else if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        } else {
            AtomicReferenceArray<E> buffer = this.buffer;
            int mask = this.mask;
            char lpConsumerIndex = lpConsumerIndex();
            int counter = 0;
            while (exit.keepRunning()) {
                for (int i = 0; i < 4096; i++) {
                    int offset = AtomicQueueUtil.calcCircularRefElementOffset(lpConsumerIndex, (long) mask);
                    Object lvRefElement = AtomicQueueUtil.lvRefElement(buffer, offset);
                    if (null == lvRefElement) {
                        counter = w.idle(counter);
                    } else {
                        lpConsumerIndex++;
                        counter = 0;
                        AtomicQueueUtil.soRefElement(buffer, offset, null);
                        soConsumerIndex(lpConsumerIndex);
                        c.accept(lvRefElement);
                    }
                }
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r0v32, types: [long] */
    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy w, MessagePassingQueue.ExitCondition e) {
        if (null == w) {
            throw new IllegalArgumentException("waiter is null");
        } else if (null == e) {
            throw new IllegalArgumentException("exit condition is null");
        } else if (null == s) {
            throw new IllegalArgumentException("supplier is null");
        } else {
            AtomicReferenceArray<E> buffer = this.buffer;
            int mask = this.mask;
            int lookAheadStep = this.lookAheadStep;
            char lpProducerIndex = lpProducerIndex();
            int counter = 0;
            while (e.keepRunning()) {
                if (null == AtomicQueueUtil.lvRefElement(buffer, AtomicQueueUtil.calcCircularRefElementOffset(lpProducerIndex + ((long) lookAheadStep), (long) mask))) {
                    for (int j = 0; j < lookAheadStep; j++) {
                        int offset = AtomicQueueUtil.calcCircularRefElementOffset(lpProducerIndex, (long) mask);
                        lpProducerIndex++;
                        AtomicQueueUtil.soRefElement(buffer, offset, s.get());
                        soProducerIndex(lpProducerIndex);
                    }
                } else {
                    int offset2 = AtomicQueueUtil.calcCircularRefElementOffset(lpProducerIndex, (long) mask);
                    if (null != AtomicQueueUtil.lvRefElement(buffer, offset2)) {
                        counter = w.idle(counter);
                    } else {
                        lpProducerIndex++;
                        counter = 0;
                        AtomicQueueUtil.soRefElement(buffer, offset2, s.get());
                        soProducerIndex(lpProducerIndex);
                    }
                }
            }
        }
    }
}
