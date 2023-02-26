package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.utils.Position;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerEnterSceneNotify.class */
public class PacketPlayerEnterSceneNotify extends BasePacket {
    /*  JADX ERROR: Dependency scan failed at insn: 0x006F: INVOKE_CUSTOM r-13, r-12
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
    /*  JADX ERROR: Failed to decode insn: 0x006F: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify.<init>(emu.grasscutter.game.player.Player):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, 3---18402]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, 3---18402]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public PacketPlayerEnterSceneNotify(emu.grasscutter.game.player.Player r8) {
        /*
            r7 = this;
            r0 = r7
            r1 = 205(0xcd, float:2.87E-43)
            r0.<init>(r1)
            r0 = r8
            emu.grasscutter.game.player.Player$SceneLoadState r1 = emu.grasscutter.game.player.Player.SceneLoadState.LOADING
            r0.setSceneLoadState(r1)
            r0 = r8
            r1 = 1000(0x3e8, float:1.401E-42)
            r2 = 99999(0x1869f, float:1.40128E-40)
            int r1 = emu.grasscutter.utils.Utils.randomRange(r1, r2)
            r0.setEnterSceneToken(r1)
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotify.newBuilder()
            r1 = r8
            int r1 = r1.getSceneId()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneId(r1)
            r1 = r8
            emu.grasscutter.utils.Position r1 = r1.getPosition()
            emu.grasscutter.net.proto.VectorOuterClass$Vector r1 = r1.toProto()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setPos(r1)
            long r1 = java.lang.System.currentTimeMillis()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneBeginTime(r1)
            emu.grasscutter.net.proto.EnterTypeOuterClass$EnterType r1 = emu.grasscutter.net.proto.EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setType(r1)
            r1 = r8
            int r1 = r1.getUid()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setTargetUid(r1)
            r1 = r8
            int r1 = r1.getEnterSceneToken()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setEnterSceneToken(r1)
            r1 = r8
            int r1 = r1.getWorldLevel()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setWorldLevel(r1)
            emu.grasscutter.game.props.EnterReason r1 = emu.grasscutter.game.props.EnterReason.Login
            int r1 = r1.getValue()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setEnterReason(r1)
            r1 = r8
            boolean r1 = r1.isFirstLoginEnterScene()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setIsFirstLoginEnterScene(r1)
            r1 = 1
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setWorldType(r1)
            r1 = r8
            int r1 = r1.getUid()
            long r2 = java.lang.System.currentTimeMillis()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r3
            int r2 = (int) r2
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, 3---18402]}
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneTransaction(r1)
            r9 = r0
            r0 = r7
            r1 = r9
            r0.setData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify.<init>(emu.grasscutter.game.player.Player):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0088: INVOKE_CUSTOM r-19, r-18, r-17
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
    /*  JADX ERROR: Failed to decode insn: 0x0088: INVOKE_CUSTOM r1, r2, r3, method: emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify.<init>(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.EnterTypeOuterClass$EnterType, emu.grasscutter.game.props.EnterReason, int, emu.grasscutter.utils.Position):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, ---18402]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, ---18402]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public PacketPlayerEnterSceneNotify(emu.grasscutter.game.player.Player r9, emu.grasscutter.game.player.Player r10, emu.grasscutter.net.proto.EnterTypeOuterClass.EnterType r11, emu.grasscutter.game.props.EnterReason r12, int r13, emu.grasscutter.utils.Position r14) {
        /*
            r8 = this;
            r0 = r8
            r1 = 205(0xcd, float:2.87E-43)
            r0.<init>(r1)
            r0 = r13
            r1 = 3
            if (r0 == r1) goto L_0x0010
            goto L_0x0018
            r0 = r9
            r1 = r9
            emu.grasscutter.utils.Position r1 = r1.getPosition()
            r0.setPrevPos(r1)
            r0 = r9
            emu.grasscutter.game.player.Player$SceneLoadState r1 = emu.grasscutter.game.player.Player.SceneLoadState.LOADING
            r0.setSceneLoadState(r1)
            r0 = r9
            r1 = 1000(0x3e8, float:1.401E-42)
            r2 = 99999(0x1869f, float:1.40128E-40)
            int r1 = emu.grasscutter.utils.Utils.randomRange(r1, r2)
            r0.setEnterSceneToken(r1)
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass.PlayerEnterSceneNotify.newBuilder()
            r1 = r9
            int r1 = r1.getSceneId()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setPrevSceneId(r1)
            r1 = r9
            emu.grasscutter.utils.Position r1 = r1.getPosition()
            emu.grasscutter.net.proto.VectorOuterClass$Vector r1 = r1.toProto()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setPrevPos(r1)
            r1 = r13
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneId(r1)
            r1 = r14
            emu.grasscutter.net.proto.VectorOuterClass$Vector r1 = r1.toProto()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setPos(r1)
            long r1 = java.lang.System.currentTimeMillis()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneBeginTime(r1)
            r1 = r11
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setType(r1)
            r1 = r10
            int r1 = r1.getUid()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setTargetUid(r1)
            r1 = r9
            int r1 = r1.getEnterSceneToken()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setEnterSceneToken(r1)
            r1 = r10
            emu.grasscutter.game.world.World r1 = r1.getWorld()
            int r1 = r1.getWorldLevel()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setWorldLevel(r1)
            r1 = r12
            int r1 = r1.getValue()
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setEnterReason(r1)
            r1 = 1
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setWorldType(r1)
            r1 = r13
            r2 = r10
            int r2 = r2.getUid()
            long r3 = java.lang.System.currentTimeMillis()
            r4 = 1000(0x3e8, double:4.94E-321)
            long r3 = r3 / r4
            int r3 = (int) r3
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, ---18402]}
            emu.grasscutter.net.proto.PlayerEnterSceneNotifyOuterClass$PlayerEnterSceneNotify$Builder r0 = r0.setSceneTransaction(r1)
            r15 = r0
            r0 = r8
            r1 = r15
            r0.setData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify.<init>(emu.grasscutter.game.player.Player, emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.EnterTypeOuterClass$EnterType, emu.grasscutter.game.props.EnterReason, int, emu.grasscutter.utils.Position):void");
    }

    public PacketPlayerEnterSceneNotify(Player player, EnterTypeOuterClass.EnterType type, EnterReason reason, int newScene, Position newPos) {
        this(player, player, type, reason, newScene, newPos);
    }
}
