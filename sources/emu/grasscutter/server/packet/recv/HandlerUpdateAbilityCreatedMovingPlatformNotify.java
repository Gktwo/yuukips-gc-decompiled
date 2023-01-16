package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass;

@Opcodes(825)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUpdateAbilityCreatedMovingPlatformNotify.class */
public class HandlerUpdateAbilityCreatedMovingPlatformNotify extends PacketHandler {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0089: INVOKE_CUSTOM r-8
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
    /*  JADX ERROR: Failed to decode insn: 0x0089: INVOKE_CUSTOM r2, method: emu.grasscutter.server.packet.recv.HandlerUpdateAbilityCreatedMovingPlatformNotify.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType;)Ljava/lang/String;}, Unexpected value: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType;)Ljava/lang/String;}, Unexpected value: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(emu.grasscutter.server.game.GameSession r7, byte[] r8, byte[] r9) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = r9
            emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify r0 = emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.parseFrom(r0)
            r10 = r0
            r0 = r7
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r1 = r10
            int r1 = r1.getEntityId()
            emu.grasscutter.game.entity.GameEntity r0 = r0.getEntityById(r1)
            r11 = r0
            r0 = r11
            boolean r0 = r0 instanceof emu.grasscutter.game.entity.platform.EntityPlatform
            if (r0 != 0) goto L_0x0020
            return
            r0 = r11
            emu.grasscutter.game.entity.platform.EntityPlatform r0 = (emu.grasscutter.game.entity.platform.EntityPlatform) r0
            emu.grasscutter.game.player.Player r0 = r0.getOwner()
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            r12 = r0
            int[] r0 = emu.grasscutter.server.packet.recv.HandlerUpdateAbilityCreatedMovingPlatformNotify.C27041.f966x3b60ef81
            r1 = r10
            emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType r1 = r1.getOpType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0054;
                case 2: goto L_0x006a;
                default: goto L_0x0080;
            }
            r0 = r12
            emu.grasscutter.server.packet.send.PacketPlatformStartRouteNotify r1 = new emu.grasscutter.server.packet.send.PacketPlatformStartRouteNotify
            r2 = r1
            r3 = r11
            emu.grasscutter.game.entity.platform.EntityPlatform r3 = (emu.grasscutter.game.entity.platform.EntityPlatform) r3
            r4 = r12
            r2.<init>(r3, r4)
            r0.broadcastPacket(r1)
            goto L_0x0092
            r0 = r12
            emu.grasscutter.server.packet.send.PacketPlatformStopRouteNotify r1 = new emu.grasscutter.server.packet.send.PacketPlatformStopRouteNotify
            r2 = r1
            r3 = r11
            emu.grasscutter.game.entity.platform.EntityPlatform r3 = (emu.grasscutter.game.entity.platform.EntityPlatform) r3
            r4 = r12
            r2.<init>(r3, r4)
            r0.broadcastPacket(r1)
            goto L_0x0092
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r10
            emu.grasscutter.net.proto.UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType r2 = r2.getOpType()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/net/proto/UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType;)Ljava/lang/String;}, Unexpected value: ]}
            r1.<init>(r2)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.recv.HandlerUpdateAbilityCreatedMovingPlatformNotify.handle(emu.grasscutter.server.game.GameSession, byte[], byte[]):void");
    }

    /* renamed from: emu.grasscutter.server.packet.recv.HandlerUpdateAbilityCreatedMovingPlatformNotify$1 */
    /* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUpdateAbilityCreatedMovingPlatformNotify$1.class */
    static /* synthetic */ class C27041 {

        /* renamed from: $SwitchMap$emu$grasscutter$net$proto$UpdateAbilityCreatedMovingPlatformNotifyOuterClass$UpdateAbilityCreatedMovingPlatformNotify$OpType */
        static final /* synthetic */ int[] f966x3b60ef81 = new int[UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.OpType.values().length];

        static {
            try {
                f966x3b60ef81[UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.OpType.OP_TYPE_ACTIVATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f966x3b60ef81[UpdateAbilityCreatedMovingPlatformNotifyOuterClass.UpdateAbilityCreatedMovingPlatformNotify.OpType.OP_TYPE_DEACTIVATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
