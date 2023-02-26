package com.lmax.disruptor.dsl;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventProcessor;
import com.lmax.disruptor.Sequence;
import com.lmax.disruptor.SequenceBarrier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/lmax/disruptor/dsl/ConsumerRepository.class */
class ConsumerRepository<T> implements Iterable<ConsumerInfo> {
    private final Map<EventHandler<?>, EventProcessorInfo<T>> eventProcessorInfoByEventHandler = new IdentityHashMap();
    private final Map<Sequence, ConsumerInfo> eventProcessorInfoBySequence = new IdentityHashMap();
    private final Collection<ConsumerInfo> consumerInfos = new ArrayList();

    /*  JADX ERROR: Dependency scan failed at insn: 0x000F: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x000F: INVOKE_CUSTOM r2, method: com.lmax.disruptor.dsl.ConsumerRepository.getEventProcessorFor(com.lmax.disruptor.EventHandler<T>):com.lmax.disruptor.EventProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventHandler;)Ljava/lang/String;}, The event handler  is not processing events.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventHandler;)Ljava/lang/String;}, The event handler  is not processing events.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public com.lmax.disruptor.EventProcessor getEventProcessorFor(com.lmax.disruptor.EventHandler<T> r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            com.lmax.disruptor.dsl.EventProcessorInfo r0 = r0.getEventProcessorInfo(r1)
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L_0x0018
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lcom/lmax/disruptor/EventHandler;)Ljava/lang/String;}, The event handler  is not processing events.]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            com.lmax.disruptor.EventProcessor r0 = r0.getEventProcessor()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.dsl.ConsumerRepository.getEventProcessorFor(com.lmax.disruptor.EventHandler):com.lmax.disruptor.EventProcessor");
    }

    public void add(EventProcessor eventprocessor, EventHandler<? super T> handler, SequenceBarrier barrier) {
        EventProcessorInfo<T> consumerInfo = new EventProcessorInfo<>(eventprocessor, handler, barrier);
        this.eventProcessorInfoByEventHandler.put(handler, consumerInfo);
        this.eventProcessorInfoBySequence.put(eventprocessor.getSequence(), consumerInfo);
        this.consumerInfos.add(consumerInfo);
    }

    public void add(EventProcessor processor) {
        EventProcessorInfo<T> consumerInfo = new EventProcessorInfo<>(processor, null, null);
        this.eventProcessorInfoBySequence.put(processor.getSequence(), consumerInfo);
        this.consumerInfos.add(consumerInfo);
    }

    public boolean hasBacklog(long cursor, boolean includeStopped) {
        for (ConsumerInfo consumerInfo : this.consumerInfos) {
            if (includeStopped || consumerInfo.isRunning()) {
                if (consumerInfo.isEndOfChain()) {
                    for (Sequence sequence : consumerInfo.getSequences()) {
                        if (cursor > sequence.get()) {
                            return true;
                        }
                    }
                    continue;
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    @Deprecated
    public Sequence[] getLastSequenceInChain(boolean includeStopped) {
        List<Sequence> lastSequence = new ArrayList<>();
        for (ConsumerInfo consumerInfo : this.consumerInfos) {
            if (includeStopped || consumerInfo.isRunning()) {
                if (consumerInfo.isEndOfChain()) {
                    Collections.addAll(lastSequence, consumerInfo.getSequences());
                }
            }
        }
        return (Sequence[]) lastSequence.toArray(new Sequence[lastSequence.size()]);
    }

    public Sequence getSequenceFor(EventHandler<T> handler) {
        return getEventProcessorFor(handler).getSequence();
    }

    public void unMarkEventProcessorsAsEndOfChain(Sequence... barrierEventProcessors) {
        for (Sequence barrierEventProcessor : barrierEventProcessors) {
            getEventProcessorInfo(barrierEventProcessor).markAsUsedInBarrier();
        }
    }

    @Override // java.lang.Iterable
    public Iterator<ConsumerInfo> iterator() {
        return this.consumerInfos.iterator();
    }

    public SequenceBarrier getBarrierFor(EventHandler<T> handler) {
        ConsumerInfo consumerInfo = getEventProcessorInfo(handler);
        if (consumerInfo != null) {
            return consumerInfo.getBarrier();
        }
        return null;
    }

    private EventProcessorInfo<T> getEventProcessorInfo(EventHandler<T> handler) {
        return this.eventProcessorInfoByEventHandler.get(handler);
    }

    private ConsumerInfo getEventProcessorInfo(Sequence barrierEventProcessor) {
        return this.eventProcessorInfoBySequence.get(barrierEventProcessor);
    }
}
