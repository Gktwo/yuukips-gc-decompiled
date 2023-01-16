package kcp.highway.threadPool.disruptor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kcp.highway.threadPool.IMessageExecutor;
import kcp.highway.threadPool.IMessageExecutorPool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DisruptorExecutorPool.class */
public class DisruptorExecutorPool implements IMessageExecutorPool {
    private static final Logger log = LoggerFactory.getLogger(DisruptorExecutorPool.class);
    protected List<IMessageExecutor> executor;
    protected AtomicInteger index;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0023: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x0023: INVOKE_CUSTOM r1, method: kcp.highway.threadPool.disruptor.DisruptorExecutorPool.<init>(int):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, DisruptorExecutorPool-]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, DisruptorExecutorPool-]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public DisruptorExecutorPool(int r5) {
        /*
            r4 = this;
            r0 = r4
            r0.<init>()
            r0 = r4
            java.util.Vector r1 = new java.util.Vector
            r2 = r1
            r2.<init>()
            r0.executor = r1
            r0 = r4
            java.util.concurrent.atomic.AtomicInteger r1 = new java.util.concurrent.atomic.AtomicInteger
            r2 = r1
            r2.<init>()
            r0.index = r1
            r0 = 0
            r6 = r0
            r0 = r6
            r1 = r5
            if (r0 >= r1) goto L_0x0032
            r0 = r4
            r1 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, DisruptorExecutorPool-]}
            kcp.highway.threadPool.IMessageExecutor r0 = r0.createDisruptorProcessor(r1)
            int r6 = r6 + 1
            goto L_0x001c
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.disruptor.DisruptorExecutorPool.<init>(int):void");
    }

    private IMessageExecutor createDisruptorProcessor(String threadName) {
        DisruptorSingleExecutor singleProcess = new DisruptorSingleExecutor(threadName);
        this.executor.add(singleProcess);
        singleProcess.start();
        return singleProcess;
    }

    @Override // kcp.highway.threadPool.IMessageExecutorPool
    public void stop() {
        for (IMessageExecutor process : this.executor) {
            process.stop();
        }
    }

    @Override // kcp.highway.threadPool.IMessageExecutorPool
    public IMessageExecutor getIMessageExecutor() {
        return this.executor.get(this.index.incrementAndGet() % this.executor.size());
    }
}
