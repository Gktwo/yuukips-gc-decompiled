package kcp.highway.threadPool.disruptor;

import kcp.highway.threadPool.IMessageExecutor;

/* loaded from: grasscutter.jar:kcp/highway/threadPool/disruptor/DisruptorThread.class */
public class DisruptorThread extends Thread {
    private IMessageExecutor messageExecutor;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r0, method: kcp.highway.threadPool.disruptor.DisruptorThread.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lkcp/highway/threadPool/IMessageExecutor;)Ljava/lang/String;}, DisruptorThread{messageExecutor=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lkcp/highway/threadPool/IMessageExecutor;)Ljava/lang/String;}, DisruptorThread{messageExecutor=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.lang.Thread, java.lang.Object
    public java.lang.String toString() {
        /*
            r2 = this;
            r0 = r2
            kcp.highway.threadPool.IMessageExecutor r0 = r0.messageExecutor
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lkcp/highway/threadPool/IMessageExecutor;)Ljava/lang/String;}, DisruptorThread{messageExecutor=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.threadPool.disruptor.DisruptorThread.toString():java.lang.String");
    }

    public DisruptorThread(IMessageExecutor messageExecutor) {
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(Runnable target, IMessageExecutor messageExecutor) {
        super(target);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(ThreadGroup group, Runnable target, IMessageExecutor messageExecutor) {
        super(group, target);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(String name, IMessageExecutor messageExecutor) {
        super(name);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(ThreadGroup group, String name, IMessageExecutor messageExecutor) {
        super(group, name);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(Runnable target, String name, IMessageExecutor messageExecutor) {
        super(target, name);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(ThreadGroup group, Runnable target, String name, IMessageExecutor messageExecutor) {
        super(group, target, name);
        this.messageExecutor = messageExecutor;
    }

    public DisruptorThread(ThreadGroup group, Runnable target, String name, long stackSize, IMessageExecutor messageExecutor) {
        super(group, target, name, stackSize);
        this.messageExecutor = messageExecutor;
    }

    public IMessageExecutor getMessageExecutor() {
        return this.messageExecutor;
    }

    public void setMessageExecutor(IMessageExecutor messageExecutor) {
        this.messageExecutor = messageExecutor;
    }
}
