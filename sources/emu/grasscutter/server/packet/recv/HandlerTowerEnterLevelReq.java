package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;

@Opcodes(PacketOpcodes.TowerEnterLevelReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTowerEnterLevelReq.class */
public class HandlerTowerEnterLevelReq extends PacketHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0030: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0030: INVOKE_CUSTOM r1, method: emu.grasscutter.server.packet.recv.HandlerTowerEnterLevelReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DEBUG Abyse: Player Start  ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DEBUG Abyse: Player Start  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(emu.grasscutter.server.game.GameSession r4, byte[] r5, byte[] r6) throws java.lang.Exception {
        /*
            r3 = this;
            r0 = r4
            if (r0 != 0) goto L_0x0005
            return
            r0 = r6
            if (r0 != 0) goto L_0x000a
            return
            emu.grasscutter.config.ConfigContainer r0 = emu.grasscutter.Grasscutter.getConfig()
            emu.grasscutter.config.ConfigContainer$Server r0 = r0.server
            emu.grasscutter.config.ConfigContainer$Game r0 = r0.game
            emu.grasscutter.config.ConfigContainer$GameOptions r0 = r0.gameOptions
            boolean r0 = r0.AbyssMT
            if (r0 == 0) goto L_0x0026
            r0 = r4
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            java.lang.String r1 = "Sorry abyse has been temporarily turned off"
            emu.grasscutter.command.CommandHandler.sendMessage(r0, r1)
            return
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            emu.grasscutter.game.player.Player r1 = r1.getPlayer()
            java.lang.String r1 = r1.getNickname()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, DEBUG Abyse: Player Start  ]}
            r0.info(r1)
            r0 = r6
            emu.grasscutter.net.proto.TowerEnterLevelReqOuterClass$TowerEnterLevelReq r0 = emu.grasscutter.net.proto.TowerEnterLevelReqOuterClass.TowerEnterLevelReq.parseFrom(r0)
            r7 = r0
            r0 = r4
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.tower.TowerManager r0 = r0.getTowerManager()
            r1 = r7
            int r1 = r1.getEnterPointId()
            r0.enterLevel(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.recv.HandlerTowerEnterLevelReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void");
    }
}
