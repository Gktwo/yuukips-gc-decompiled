package org.jctools.queues;

import java.util.Iterator;
import org.jctools.queues.MessagePassingQueue;
import org.jctools.util.PortableJvmInfo;

/* loaded from: grasscutter.jar:org/jctools/queues/MpscUnboundedXaddArrayQueue.class */
public class MpscUnboundedXaddArrayQueue<E> extends MpUnboundedXaddArrayQueue<MpscUnboundedXaddChunk<E>, E> {
    static final /* synthetic */ boolean $assertionsDisabled;

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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpscUnboundedXaddArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer<E>, int):int
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
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public int drain(org.jctools.queues.MessagePassingQueue.Consumer<E> r6, int r7) {
        /*
            r5 = this;
            r0 = 0
            r1 = r6
            if (r0 != r1) goto L_0x000f
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "c is null"
            r1.<init>(r2)
            throw r0
            r0 = r7
            if (r0 >= 0) goto L_0x0021
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, limit is negative: ]}
            r1.<init>(r2)
            throw r0
            r0 = r7
            if (r0 != 0) goto L_0x0027
            r0 = 0
            return r0
            r0 = r5
            int r0 = r0.chunkMask
            r8 = r0
            r0 = r5
            long r0 = r0.lpConsumerIndex()
            r9 = r0
            r0 = r5
            org.jctools.queues.MpUnboundedXaddChunk r0 = r0.lpConsumerChunk()
            org.jctools.queues.MpscUnboundedXaddChunk r0 = (org.jctools.queues.MpscUnboundedXaddChunk) r0
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = r12
            r1 = r7
            if (r0 >= r1) goto L_0x00c0
            r0 = r9
            r1 = r8
            long r1 = (long) r1
            long r0 = r0 & r1
            int r0 = (int) r0
            r13 = r0
            r0 = r13
            if (r0 != 0) goto L_0x0089
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0089
            r0 = r11
            java.lang.Object r0 = r0.lvNext()
            org.jctools.queues.MpscUnboundedXaddChunk r0 = (org.jctools.queues.MpscUnboundedXaddChunk) r0
            r15 = r0
            r0 = r15
            if (r0 != 0) goto L_0x006a
            r0 = r12
            return r0
            r0 = r15
            r1 = 0
            java.lang.Object r0 = r0.lvElement(r1)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x007a
            r0 = r12
            return r0
            r0 = r5
            r1 = r11
            r2 = r15
            r0.moveToNextConsumerChunk(r1, r2)
            r0 = r15
            r11 = r0
            goto L_0x009a
            r0 = r11
            r1 = r13
            java.lang.Object r0 = r0.lvElement(r1)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x009a
            r0 = r12
            return r0
            r0 = r11
            r1 = r13
            r2 = 0
            r0.soElement(r1, r2)
            r0 = r9
            r1 = 1
            long r0 = r0 + r1
            r15 = r0
            r0 = r5
            r1 = r15
            r0.soConsumerIndex(r1)
            r0 = r6
            r1 = r14
            r0.accept(r1)
            r0 = r15
            r9 = r0
            int r12 = r12 + 1
            goto L_0x003e
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscUnboundedXaddArrayQueue.drain(org.jctools.queues.MessagePassingQueue$Consumer, int):int");
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: org.jctools.queues.MpscUnboundedXaddArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier<E>, int):int
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
            int r0 = r0.chunkShift
            r8 = r0
            r0 = r5
            int r0 = r0.chunkMask
            r9 = r0
            r0 = r5
            r1 = r7
            long r1 = (long) r1
            long r0 = r0.getAndAddProducerIndex(r1)
            r10 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r13
            r1 = r7
            if (r0 >= r1) goto L_0x008b
            r0 = r10
            r1 = r9
            long r1 = (long) r1
            long r0 = r0 & r1
            int r0 = (int) r0
            r14 = r0
            r0 = r10
            r1 = r8
            long r0 = r0 >> r1
            r15 = r0
            r0 = r12
            if (r0 == 0) goto L_0x0065
            r0 = r12
            long r0 = r0.lvIndex()
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0072
            r0 = r5
            r1 = r12
            r2 = r15
            org.jctools.queues.MpUnboundedXaddChunk r0 = r0.producerChunkForIndex(r1, r2)
            org.jctools.queues.MpscUnboundedXaddChunk r0 = (org.jctools.queues.MpscUnboundedXaddChunk) r0
            r12 = r0
            r0 = r12
            r1 = r14
            r2 = r6
            java.lang.Object r2 = r2.get()
            r0.soElement(r1, r2)
            r0 = r10
            r1 = 1
            long r0 = r0 + r1
            r10 = r0
            int r13 = r13 + 1
            goto L_0x0040
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jctools.queues.MpscUnboundedXaddArrayQueue.fill(org.jctools.queues.MessagePassingQueue$Supplier, int):int");
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.lang.Object
    public /* bridge */ /* synthetic */ String toString() {
        return toString();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void fill(MessagePassingQueue.Supplier supplier, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        fill(supplier, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ void drain(MessagePassingQueue.Consumer consumer, MessagePassingQueue.WaitStrategy waitStrategy, MessagePassingQueue.ExitCondition exitCondition) {
        drain(consumer, waitStrategy, exitCondition);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int drain(MessagePassingQueue.Consumer consumer) {
        return drain(consumer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean relaxedOffer(Object obj) {
        return relaxedOffer(obj);
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.IndexedQueueSizeUtil.IndexedQueue, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int capacity() {
        return capacity();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return isEmpty();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, org.jctools.queues.MessagePassingQueue
    public /* bridge */ /* synthetic */ int size() {
        return size();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentConsumerIndex() {
        return currentConsumerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.QueueProgressIndicators
    public /* bridge */ /* synthetic */ long currentProducerIndex() {
        return currentProducerIndex();
    }

    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue
    /* bridge */ /* synthetic */ MpUnboundedXaddChunk newChunk(long j, MpUnboundedXaddChunk mpUnboundedXaddChunk, int i, boolean z) {
        return newChunk(j, (MpscUnboundedXaddChunk) ((MpscUnboundedXaddChunk) mpUnboundedXaddChunk), i, z);
    }

    static {
        $assertionsDisabled = !MpscUnboundedXaddArrayQueue.class.desiredAssertionStatus();
    }

    public MpscUnboundedXaddArrayQueue(int chunkSize, int maxPooledChunks) {
        super(chunkSize, maxPooledChunks);
    }

    public MpscUnboundedXaddArrayQueue(int chunkSize) {
        this(chunkSize, 2);
    }

    final MpscUnboundedXaddChunk<E> newChunk(long index, MpscUnboundedXaddChunk<E> prev, int chunkSize, boolean pooled) {
        return new MpscUnboundedXaddChunk<>(index, prev, chunkSize, pooled);
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public boolean offer(E e) {
        if (null == e) {
            throw new NullPointerException();
        }
        int chunkMask = this.chunkMask;
        int chunkShift = this.chunkShift;
        long pIndex = getAndIncrementProducerIndex();
        int piChunkOffset = (int) (pIndex & ((long) chunkMask));
        long piChunkIndex = pIndex >> chunkShift;
        MpscUnboundedXaddChunk<E> pChunk = (MpscUnboundedXaddChunk) lvProducerChunk();
        if (pChunk.lvIndex() != piChunkIndex) {
            pChunk = producerChunkForIndex(pChunk, piChunkIndex);
        }
        pChunk.soElement(piChunkOffset, e);
        return true;
    }

    private MpscUnboundedXaddChunk<E> pollNextBuffer(MpscUnboundedXaddChunk<E> cChunk, long cIndex) {
        MpscUnboundedXaddChunk<E> next = spinForNextIfNotEmpty(cChunk, cIndex);
        if (next == null) {
            return null;
        }
        moveToNextConsumerChunk(cChunk, next);
        if ($assertionsDisabled || next.lvIndex() == (cIndex >> this.chunkShift)) {
            return next;
        }
        throw new AssertionError();
    }

    private MpscUnboundedXaddChunk<E> spinForNextIfNotEmpty(MpscUnboundedXaddChunk<E> cChunk, long cIndex) {
        MpscUnboundedXaddChunk<E> next = cChunk.lvNext();
        if (next == null) {
            if (lvProducerIndex() == cIndex) {
                return null;
            }
            long ccChunkIndex = cChunk.lvIndex();
            if (lvProducerChunkIndex() == ccChunkIndex) {
                next = appendNextChunks(cChunk, ccChunkIndex, 1);
            }
            while (next == null) {
                next = cChunk.lvNext();
            }
        }
        return next;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E poll() {
        int chunkMask = this.chunkMask;
        long cIndex = lpConsumerIndex();
        int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
        MpscUnboundedXaddChunk<E> cChunk = (MpscUnboundedXaddChunk) lvConsumerChunk();
        if (ciChunkOffset == 0 && cIndex != 0) {
            cChunk = pollNextBuffer(cChunk, cIndex);
            if (cChunk == null) {
                return null;
            }
        }
        E e = cChunk.lvElement(ciChunkOffset);
        if (e == null) {
            if (lvProducerIndex() == cIndex) {
                return null;
            }
            e = cChunk.spinForElement(ciChunkOffset, false);
        }
        cChunk.soElement(ciChunkOffset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override // java.util.Queue, org.jctools.queues.MessagePassingQueue
    public E peek() {
        int chunkMask = this.chunkMask;
        long cIndex = lpConsumerIndex();
        int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
        MpscUnboundedXaddChunk<E> cChunk = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (ciChunkOffset == 0 && cIndex != 0) {
            cChunk = spinForNextIfNotEmpty(cChunk, cIndex);
            if (cChunk == null) {
                return null;
            }
        }
        E e = cChunk.lvElement(ciChunkOffset);
        if (e == null) {
            if (lvProducerIndex() == cIndex) {
                return null;
            }
            e = cChunk.spinForElement(ciChunkOffset, false);
        }
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPoll() {
        E e;
        int chunkMask = this.chunkMask;
        long cIndex = lpConsumerIndex();
        int ciChunkOffset = (int) (cIndex & ((long) chunkMask));
        MpscUnboundedXaddChunk<E> cChunk = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (ciChunkOffset != 0 || cIndex == 0) {
            e = cChunk.lvElement(ciChunkOffset);
            if (e == null) {
                return null;
            }
        } else {
            MpscUnboundedXaddChunk<E> next = cChunk.lvNext();
            if (next == null) {
                return null;
            }
            e = next.lvElement(0);
            if (e == null) {
                return null;
            }
            moveToNextConsumerChunk(cChunk, next);
            cChunk = next;
        }
        cChunk.soElement(ciChunkOffset, null);
        soConsumerIndex(cIndex + 1);
        return e;
    }

    @Override // org.jctools.queues.MessagePassingQueue
    public E relaxedPeek() {
        int chunkMask = this.chunkMask;
        long cIndex = lpConsumerIndex();
        int cChunkOffset = (int) (cIndex & ((long) chunkMask));
        MpscUnboundedXaddChunk<E> cChunk = (MpscUnboundedXaddChunk) lpConsumerChunk();
        if (cChunkOffset == 0 && cIndex != 0) {
            cChunk = cChunk.lvNext();
            if (cChunk == null) {
                return null;
            }
        }
        return cChunk.lvElement(cChunkOffset);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    @Override // org.jctools.queues.MpUnboundedXaddArrayQueue, org.jctools.queues.MessagePassingQueue
    public int fill(MessagePassingQueue.Supplier<E> s) {
        char c = 0;
        int capacity = this.chunkMask + 1;
        int offerBatch = Math.min(PortableJvmInfo.RECOMENDED_OFFER_BATCH, capacity);
        do {
            int filled = fill(s, offerBatch);
            if (filled == 0) {
                return (int) c;
            }
            c += (long) filled;
        } while (c <= ((long) capacity));
        return (int) c;
    }
}
