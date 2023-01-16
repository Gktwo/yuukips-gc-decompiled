package org.jctools.queues;

import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.PortableJvmInfo;

/* loaded from: grasscutter.jar:org/jctools/queues/MessagePassingQueueUtil.class */
public final class MessagePassingQueueUtil {
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MessagePassingQueueUtil.drain(org.jctools.queues.MessagePassingQueue<E>, org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
    public static <E> int drain(org.jctools.queues.MessagePassingQueue<E> r4, org.jctools.queues.MessagePassingQueue.Consumer<E> r5, int r6) {
        /*
            r0 = 0
            r1 = r5
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "c is null"
            r1.<init>(r2)
            throw r0
            r0 = r6
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = 0
            r8 = r0
            r0 = r8
            r1 = r6
            if (r0 >= r1) goto L_0x0048
            r0 = r4
            java.lang.Object r0 = r0.relaxedPoll()
            r1 = r0
            r7 = r1
            if (r0 == 0) goto L_0x0048
            r0 = r5
            r1 = r7
            r0.accept(r1)
            int r8 = r8 + 1
            goto L_0x002a
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MessagePassingQueueUtil.drain(org.jctools.queues.MessagePassingQueue, org.jctools.queues.MessagePassingQueue$Consumer, int):int");
    }

    public static <E> int drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c) {
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        }
        int i = 0;
        while (true) {
            E e = queue.relaxedPoll();
            if (e == null) {
                return i;
            }
            i++;
            c.accept(e);
        }
    }

    public static <E> void drain(MessagePassingQueue<E> queue, MessagePassingQueue.Consumer<E> c, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == c) {
            throw new IllegalArgumentException("c is null");
        } else if (null == wait) {
            throw new IllegalArgumentException("wait is null");
        } else if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        } else {
            int idleCounter = 0;
            while (exit.keepRunning()) {
                E e = queue.relaxedPoll();
                if (e == null) {
                    idleCounter = wait.idle(idleCounter);
                } else {
                    idleCounter = 0;
                    c.accept(e);
                }
            }
        }
    }

    public static <E> void fill(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s, MessagePassingQueue.WaitStrategy wait, MessagePassingQueue.ExitCondition exit) {
        if (null == wait) {
            throw new IllegalArgumentException("waiter is null");
        } else if (null == exit) {
            throw new IllegalArgumentException("exit condition is null");
        } else {
            int idleCounter = 0;
            while (exit.keepRunning()) {
                if (q.fill(s, PortableJvmInfo.RECOMENDED_OFFER_BATCH) == 0) {
                    idleCounter = wait.idle(idleCounter);
                } else {
                    idleCounter = 0;
                }
            }
        }
    }

    public static <E> int fillBounded(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s) {
        return fillInBatchesToLimit(q, s, PortableJvmInfo.RECOMENDED_OFFER_BATCH, q.capacity());
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [long] */
    public static <E> int fillInBatchesToLimit(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s, int batch, int limit) {
        char c = 0;
        do {
            int filled = q.fill(s, batch);
            if (filled == 0) {
                return (int) c;
            }
            c += (long) filled;
        } while (c <= ((long) limit));
        return (int) c;
    }

    public static <E> int fillUnbounded(MessagePassingQueue<E> q, MessagePassingQueue.Supplier<E> s) {
        return fillInBatchesToLimit(q, s, PortableJvmInfo.RECOMENDED_OFFER_BATCH, 4096);
    }
}
