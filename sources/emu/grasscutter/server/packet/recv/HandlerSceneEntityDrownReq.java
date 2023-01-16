package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;

@Opcodes(PacketOpcodes.SceneEntityDrownReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSceneEntityDrownReq.class */
public class HandlerSceneEntityDrownReq extends PacketHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x003E: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x003E: INVOKE_CUSTOM r1, method: emu.grasscutter.server.packet.recv.HandlerSceneEntityDrownReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, SceneEntityDrownReq: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, SceneEntityDrownReq: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(emu.grasscutter.server.game.GameSession r6, byte[] r7, byte[] r8) throws java.lang.Exception {
        /*
            r5 = this;
            r0 = r8
            emu.grasscutter.net.proto.SceneEntityDrownReqOuterClass$SceneEntityDrownReq r0 = emu.grasscutter.net.proto.SceneEntityDrownReqOuterClass.SceneEntityDrownReq.parseFrom(r0)
            r9 = r0
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r1 = r9
            int r1 = r1.getEntityId()
            emu.grasscutter.game.entity.GameEntity r0 = r0.getEntityById(r1)
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L_0x002c
            r0 = r10
            boolean r0 = r0 instanceof emu.grasscutter.game.entity.EntityMonster
            if (r0 != 0) goto L_0x002d
            r0 = r10
            boolean r0 = r0 instanceof emu.grasscutter.game.entity.EntityAvatar
            if (r0 != 0) goto L_0x002d
            return
            r0 = r10
            emu.grasscutter.game.props.FightProperty r1 = emu.grasscutter.game.props.FightProperty.FIGHT_PROP_CUR_HP
            r2 = 0
            r0.setFightProperty(r1, r2)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r10
            int r1 = r1.getId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, SceneEntityDrownReq: ]}
            r0.debug(r1)
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r1 = r10
            r2 = 0
            r0.killEntity(r1, r2)
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.server.packet.send.PacketSceneEntityDrownRsp r1 = new emu.grasscutter.server.packet.send.PacketSceneEntityDrownRsp
            r2 = r1
            r3 = r9
            int r3 = r3.getEntityId()
            r2.<init>(r3)
            r0.broadcastPacket(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.recv.HandlerSceneEntityDrownReq.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void");
    }
}
