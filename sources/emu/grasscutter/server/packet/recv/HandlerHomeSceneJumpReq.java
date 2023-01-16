package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;

@Opcodes(PacketOpcodes.HomeSceneJumpReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeSceneJumpReq.class */
public class HandlerHomeSceneJumpReq extends PacketHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x006D: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x006D: INVOKE_CUSTOM r1, method: emu.grasscutter.server.packet.recv.HandlerHomeSceneJumpReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, No Found scene: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, No Found scene: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(emu.grasscutter.server.game.GameSession r6, byte[] r7, byte[] r8) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = r8
            emu.grasscutter.net.proto.HomeSceneJumpReqOuterClass$HomeSceneJumpReq r0 = emu.grasscutter.net.proto.HomeSceneJumpReqOuterClass.HomeSceneJumpReq.parseFrom(r0)
            r9 = r0
            r0 = 2000(0x7d0, float:2.803E-42)
            r1 = r6
            emu.grasscutter.game.player.Player r1 = r1.getPlayer()
            int r1 = r1.getCurrentRealmId()
            int r0 = r0 + r1
            r10 = r0
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.home.GameHome r0 = r0.getHome()
            r11 = r0
            r0 = r11
            r1 = r10
            emu.grasscutter.game.home.HomeSceneItem r0 = r0.getHomeSceneItem(r1)
            r12 = r0
            r0 = r12
            if (r0 != 0) goto L_0x0036
            r0 = r6
            emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp r1 = new emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp
            r2 = r1
            r2.<init>()
            r0.send(r1)
            return
            r0 = r9
            boolean r0 = r0.getIsEnterRoomScene()
            if (r0 == 0) goto L_0x0046
            r0 = r12
            int r0 = r0.getRoomSceneId()
            goto L_0x0048
            r0 = r10
            r13 = r0
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.World r0 = r0.getWorld()
            r1 = r13
            emu.grasscutter.game.world.Scene r0 = r0.getSceneById(r1)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x0076
            r0 = r6
            emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp r1 = new emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp
            r2 = r1
            r2.<init>()
            r0.send(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r13
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, No Found scene: ]}
            r0.error(r1)
            return
            r0 = r11
            r0.save()
            r0 = r14
            emu.grasscutter.scripts.SceneScriptManager r0 = r0.getScriptManager()
            emu.grasscutter.scripts.data.SceneConfig r0 = r0.getConfig()
            emu.grasscutter.utils.Position r0 = r0.born_pos
            r15 = r0
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.World r0 = r0.getWorld()
            r1 = r6
            emu.grasscutter.game.player.Player r1 = r1.getPlayer()
            r2 = r9
            boolean r2 = r2.getIsEnterRoomScene()
            if (r2 == 0) goto L_0x00a3
            r2 = r12
            int r2 = r2.getRoomSceneId()
            goto L_0x00a5
            r2 = r10
            r3 = r15
            boolean r0 = r0.transferPlayerToScene(r1, r2, r3)
            r0 = r6
            emu.grasscutter.server.packet.send.PacketHomeSceneJumpRsp r1 = new emu.grasscutter.server.packet.send.PacketHomeSceneJumpRsp
            r2 = r1
            r3 = r9
            boolean r3 = r3.getIsEnterRoomScene()
            r2.<init>(r3)
            r0.send(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.recv.HandlerHomeSceneJumpReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void");
    }
}
