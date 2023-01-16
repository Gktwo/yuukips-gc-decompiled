package org.jctools.queues;

import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.UnsafeAccess;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscLinkedQueue.class */
public class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpscLinkedQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r5, int r6) {
        /*
            r4 = this;
            r0 = 0
            r1 = r5
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "supplier is null"
            r1.<init>(r2)
            throw r0
            r0 = r6
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.get()
            org.jctools.queues.LinkedQueueNode r0 = r0.newNode(r1)
            r7 = r0
            r0 = r7
            r8 = r0
            r0 = 1
            r9 = r0
            r0 = r9
            r1 = r6
            if (r0 >= r1) goto L_0x0059
            r0 = r4
            r1 = r5
            java.lang.Object r1 = r1.get()
            org.jctools.queues.LinkedQueueNode r0 = r0.newNode(r1)
            r10 = r0
            r0 = r7
            r1 = r10
            r0.spNext(r1)
            r0 = r10
            r7 = r0
            int r9 = r9 + 1
            goto L_0x0038
            r0 = r4
            r1 = r7
            org.jctools.queues.LinkedQueueNode r0 = r0.xchgProducerNode(r1)
            r9 = r0
            r0 = r9
            r1 = r8
            r0.soNext(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscLinkedQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer, int i) {
        return drain(consumer, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPeek() {
        return relaxedPeek();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object relaxedPoll() {
        return relaxedPoll();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object peek() {
        return peek();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.Queue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ Object poll() {
        return poll();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // org.jctools.queues.BaseLinkedQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<E> node = newNode();
        spConsumerNode(node);
        xchgProducerNode(node);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        LinkedQueueNode<E> nextNode = newNode(e);
        xchgProducerNode(nextNode).soNext(nextNode);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object o) {
        if (null == o) {
            return false;
        }
        LinkedQueueNode<E> originalConsumerNode = lpConsumerNode();
        LinkedQueueNode<E> prevConsumerNode = originalConsumerNode;
        LinkedQueueNode<E> currConsumerNode = getNextConsumerNode(originalConsumerNode);
        while (currConsumerNode != null) {
            if (o.equals(currConsumerNode.lpValue())) {
                LinkedQueueNode<E> nextNode = getNextConsumerNode(currConsumerNode);
                if (nextNode != null) {
                    prevConsumerNode.soNext(nextNode);
                } else {
                    prevConsumerNode.soNext(null);
                    if (!casProducerNode(currConsumerNode, prevConsumerNode)) {
                        prevConsumerNode.soNext(spinWaitForNextNode(currConsumerNode));
                    }
                }
                currConsumerNode.soNext(null);
                currConsumerNode.spValue(null);
                return true;
            }
            prevConsumerNode = currConsumerNode;
            currConsumerNode = getNextConsumerNode(currConsumerNode);
        }
        return false;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        return MessagePassingQueueUtil.fillUnbounded(this, s);
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public void fill(MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        MessagePassingQueueUtil.fill(this, s, wait, exit);
    }

    private LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> newVal) {
        LinkedQueueNode<E> oldVal;
        if (UnsafeAccess.SUPPORTS_GET_AND_SET_REF) {
            return (LinkedQueueNode) UnsafeAccess.UNSAFE.getAndSetObject(this, P_NODE_OFFSET, newVal);
        }
        do {
            oldVal = lvProducerNode();
        } while (!UnsafeAccess.UNSAFE.compareAndSwapObject(this, P_NODE_OFFSET, oldVal, newVal));
        return oldVal;
    }

    private LinkedQueueNode<E> getNextConsumerNode(LinkedQueueNode<E> currConsumerNode) {
        LinkedQueueNode<E> nextNode = currConsumerNode.lvNext();
        if (nextNode == null && currConsumerNode != lvProducerNode()) {
            nextNode = spinWaitForNextNode(currConsumerNode);
        }
        return nextNode;
    }
}
