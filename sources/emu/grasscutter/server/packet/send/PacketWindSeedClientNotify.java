package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWindSeedClientNotify.class */
public class PacketWindSeedClientNotify extends BasePacket {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, method: emu.grasscutter.server.packet.send.PacketWindSeedClientNotify.<init>(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, lua/.luac]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, lua/.luac]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public PacketWindSeedClientNotify(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = 1157(0x485, float:1.621E-42)
            r0.<init>(r1)
            r0 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, lua/.luac]}
            java.nio.file.Path r0 = emu.grasscutter.utils.FileUtils.getDataPath(r0)
            byte[] r0 = emu.grasscutter.utils.FileUtils.read(r0)
            r6 = r0
            goto L_0x0022
            r7 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Error Windy: "
            r2 = r7
            r0.error(r1, r2)
            return
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$Builder r0 = emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.newBuilder()
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify$Builder r1 = emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass.WindSeedClientNotify.AreaNotify.newBuilder()
            r2 = 1
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify$Builder r1 = r1.setAreaId(r2)
            r2 = 1
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify$Builder r1 = r1.setAreaType(r2)
            r2 = r6
            com.google.protobuf.ByteString r2 = com.google.protobuf.ByteString.copyFrom(r2)
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify$Builder r1 = r1.setAreaCode(r2)
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$AreaNotify r1 = r1.build()
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify$Builder r0 = r0.setAreaNotify(r1)
            emu.grasscutter.net.proto.WindSeedClientNotifyOuterClass$WindSeedClientNotify r0 = r0.build()
            r7 = r0
            r0 = r4
            r1 = r7
            r0.setData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.send.PacketWindSeedClientNotify.<init>(java.lang.String):void");
    }
}
