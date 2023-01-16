package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/GadgetRewardStatue.class */
public class GadgetRewardStatue extends GadgetContent {
    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.entity.gadget.GadgetRewardStatue.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetGatherObject2: player  interact gadget with ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetGatherObject2: player  interact gadget with ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public boolean onInteract(emu.grasscutter.game.player.Player r7, emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReq r8) {
        /*
            r6 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r7
            int r1 = r1.getUid()
            r2 = r8
            int r2 = r2.getGadgetId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetGatherObject2: player  interact gadget with ]}
            r0.debug(r1)
            r0 = r7
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.game.dungeons.DungeonManager r0 = r0.getDungeonManager()
            if (r0 != 0) goto L_0x0034
            r0 = r7
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.game.dungeons.challenge.WorldChallenge r0 = r0.getChallenge()
            r10 = r0
            r0 = r10
            boolean r0 = r0 instanceof emu.grasscutter.game.dungeons.challenge.DungeonChallenge
            if (r0 == 0) goto L_0x0053
            r0 = r10
            emu.grasscutter.game.dungeons.challenge.DungeonChallenge r0 = (emu.grasscutter.game.dungeons.challenge.DungeonChallenge) r0
            r9 = r0
            r0 = r8
            emu.grasscutter.net.proto.ResinCostTypeOuterClass$ResinCostType r0 = r0.getResinCostType()
            emu.grasscutter.net.proto.ResinCostTypeOuterClass$ResinCostType r1 = emu.grasscutter.net.proto.ResinCostTypeOuterClass.ResinCostType.RESIN_COST_TYPE_CONDENSE
            if (r0 != r1) goto L_0x0042
            r0 = 1
            goto L_0x0043
            r0 = 0
            r10 = r0
            r0 = r7
            emu.grasscutter.game.world.Scene r0 = r0.getScene()
            emu.grasscutter.game.dungeons.DungeonManager r0 = r0.getDungeonManager()
            r1 = r7
            r2 = r10
            boolean r0 = r0.getStatueDrops(r1, r2)
            r0 = r7
            emu.grasscutter.server.packet.send.PacketGadgetInteractRsp r1 = new emu.grasscutter.server.packet.send.PacketGadgetInteractRsp
            r2 = r1
            r3 = r6
            emu.grasscutter.game.entity.EntityGadget r3 = r3.getGadget()
            emu.grasscutter.net.proto.InteractTypeOuterClass$InteractType r4 = emu.grasscutter.net.proto.InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_STATUE
            r2.<init>(r3, r4)
            r0.sendPacket(r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.entity.gadget.GadgetRewardStatue.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean");
    }

    public GadgetRewardStatue(EntityGadget gadget) {
        super(gadget);
    }

    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public void onBuildProto(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder gadgetInfo) {
    }
}
