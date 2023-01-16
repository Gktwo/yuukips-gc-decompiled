package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.PortableJvmInfo;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscCompoundQueue.class */
public class MpscCompoundQueue<E> extends MpscCompoundQueueConsumerQueueIndex<E> {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpscCompoundQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
    public int fill(org.jctools.queues.MessagePassingQueue.Supplier<E> r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            r1 = r7
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "supplier is null"
            r1.<init>(r2)
            throw r0
            r0 = r8
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative:]}
            r1.<init>(r2)
            throw r0
            r0 = r8
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r6
            int r0 = r0.parallelQueuesMask
            r9 = r0
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            long r0 = r0.getId()
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 & r1
            int r0 = (int) r0
            r10 = r0
            r0 = r6
            org.jctools.queues.MpscArrayQueue[] r0 = r0.queues
            r11 = r0
            r0 = r11
            r1 = r10
            r0 = r0[r1]
            r1 = r7
            r2 = r8
            int r0 = r0.fill(r1, r2)
            r12 = r0
            r0 = r12
            r1 = r8
            if (r0 != r1) goto L_0x0052
            r0 = r8
            return r0
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r13 = r0
            r0 = r13
            r1 = r10
            r2 = r9
            int r1 = r1 + r2
            r2 = 1
            int r1 = r1 + r2
            if (r0 >= r1) goto L_0x0085
            r0 = r12
            r1 = r11
            r2 = r13
            r3 = r9
            r2 = r2 & r3
            r1 = r1[r2]
            r2 = r7
            r3 = r8
            r4 = r12
            int r3 = r3 - r4
            int r1 = r1.fill(r2, r3)
            int r0 = r0 + r1
            r12 = r0
            r0 = r12
            r1 = r8
            if (r0 != r1) goto L_0x007f
            r0 = r8
            return r0
            int r13 = r13 + 1
            goto L_0x0058
            r0 = r12
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscCompoundQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    public MpscCompoundQueue(int capacity) {
        this(capacity, PortableJvmInfo.CPUs);
    }

    public MpscCompoundQueue(int capacity, int queueParallelism) {
        super(capacity, queueParallelism);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int parallelQueuesMask = this.parallelQueuesMask;
        int start = (int) (Thread.currentThread().getId() & ((long) parallelQueuesMask));
        MpscArrayQueue<E>[] queues = this.queues;
        if (queues[start].offer(e)) {
            return true;
        }
        return slowOffer(queues, parallelQueuesMask, start + 1, e);
    }

    private boolean slowOffer(MpscArrayQueue<E>[] queues, int parallelQueuesMask, int start, E e) {
        int status;
        int queueCount = parallelQueuesMask + 1;
        int end = start + queueCount;
        do {
            status = 0;
            for (int i = start; i < end; i++) {
                int s = queues[i & parallelQueuesMask].failFastOffer(e);
                if (s == 0) {
                    return true;
                }
                status += s;
            }
        } while (status != queueCount);
        return false;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        int qIndex = this.consumerQueueIndex & this.parallelQueuesMask;
        int limit = qIndex + this.parallelQueues;
        E e = null;
        while (qIndex < limit) {
            e = (E) this.queues[qIndex & this.parallelQueuesMask].poll();
            if (e != null) {
                break;
            }
            qIndex++;
        }
        this.consumerQueueIndex = qIndex;
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        int qIndex = this.consumerQueueIndex & this.parallelQueuesMask;
        int limit = qIndex + this.parallelQueues;
        E e = null;
        while (qIndex < limit) {
            e = (E) this.queues[qIndex & this.parallelQueuesMask].peek();
            if (e != null) {
                break;
            }
            qIndex++;
        }
        this.consumerQueueIndex = qIndex;
        return e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public int size() {
        int size = 0;
        for (MpscArrayQueue<E> lane : this.queues) {
            size += lane.size();
        }
        return size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return getClass().getName();
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public boolean relaxedOffer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int parallelQueuesMask = this.parallelQueuesMask;
        int start = (int) (Thread.currentThread().getId() & ((long) parallelQueuesMask));
        MpscArrayQueue<E>[] queues = this.queues;
        if (queues[start].failFastOffer(e) == 0) {
            return true;
        }
        for (int i = start + 1; i < start + parallelQueuesMask + 1; i++) {
            if (queues[i & parallelQueuesMask].failFastOffer(e) == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        int qIndex = this.consumerQueueIndex & this.parallelQueuesMask;
        int limit = qIndex + this.parallelQueues;
        E e = null;
        while (qIndex < limit) {
            e = (E) this.queues[qIndex & this.parallelQueuesMask].relaxedPoll();
            if (e != null) {
                break;
            }
            qIndex++;
        }
        this.consumerQueueIndex = qIndex;
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        int qIndex = this.consumerQueueIndex & this.parallelQueuesMask;
        int limit = qIndex + this.parallelQueues;
        E e = null;
        while (qIndex < limit) {
            e = (E) this.queues[qIndex & this.parallelQueuesMask].relaxedPeek();
            if (e != null) {
                break;
            }
            qIndex++;
        }
        this.consumerQueueIndex = qIndex;
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public int capacity() {
        return this.queues.length * this.queues[0].capacity();
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
}
