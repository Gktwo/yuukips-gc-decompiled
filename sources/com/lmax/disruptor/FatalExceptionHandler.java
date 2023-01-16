package com.lmax.disruptor;

import java.lang.System;

/* loaded from: grasscutter.jar:com/lmax/disruptor/FatalExceptionHandler.class */
public final class FatalExceptionHandler implements ExceptionHandler<Object> {
    private static final System.Logger LOGGER = System.getLogger(FatalExceptionHandler.class.getName());

    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleEventException(Throwable ex, long sequence, Object event) {
        LOGGER.log(System.Logger.Level.ERROR, () -> {
            /*  JADX ERROR: Dependency scan failed at insn: 0x0002: INVOKE_CUSTOM r-2, r0, r-1
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
            /*  JADX ERROR: Failed to decode insn: 0x0002: INVOKE_CUSTOM r0, r0, r1, method: com.lmax.disruptor.FatalExceptionHandler.lambda$handleEventException$0(long, java.lang.Object):java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, Ljava/lang/Object;)Ljava/lang/String;}, Exception processing:  ]}
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
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, Ljava/lang/Object;)Ljava/lang/String;}, Exception processing:  ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 11 more
                */
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Cannot invoke "jadx.core.dex.nodes.IContainer.get(jadx.api.plugins.input.data.attributes.IJadxAttrType)" because "cont" is null
                	at jadx.core.codegen.RegionGen.declareVars(RegionGen.java:69)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:64)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:913)
                	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                */
            /*
                r0 = r4
                r1 = r6
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, Ljava/lang/Object;)Ljava/lang/String;}, Exception processing:  ]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.FatalExceptionHandler.lambda$handleEventException$0(long, java.lang.Object):java.lang.String");
        }, ex);
        throw new RuntimeException(ex);
    }

    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleOnStartException(Throwable ex) {
        LOGGER.log(System.Logger.Level.ERROR, "Exception during onStart()", ex);
    }

    @Override // com.lmax.disruptor.ExceptionHandler
    public void handleOnShutdownException(Throwable ex) {
        LOGGER.log(System.Logger.Level.ERROR, "Exception during onShutdown()", ex);
    }
}
