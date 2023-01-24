package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.GatherData;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.GatherGadgetInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.utils.Utils;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/GadgetGatherPoint.class */
public class GadgetGatherPoint extends GadgetContent {
    private int itemId;
    private boolean isForbidGuest;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-4, r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.entity.gadget.GadgetGatherPoint.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: GadgetObject  interact gadget with ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: GadgetObject  interact gadget with ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public boolean onInteract(emu.grasscutter.game.player.Player r6, emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReq r7) {
        /*
            r5 = this;
            emu.grasscutter.game.inventory.GameItem r0 = new emu.grasscutter.game.inventory.GameItem
            r1 = r0
            r2 = r5
            int r2 = r2.getItemId()
            r3 = 1
            r1.<init>(r2, r3)
            r8 = r0
            r0 = r6
            emu.grasscutter.game.inventory.Inventory r0 = r0.getInventory()
            r1 = r8
            emu.grasscutter.game.props.ActionReason r2 = emu.grasscutter.game.props.ActionReason.Gather
            boolean r0 = r0.addItem(r1, r2)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.getUid()
            r2 = r7
            int r2 = r2.getGadgetId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: GadgetObject  interact gadget with ]}
            r0.warn(r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.entity.gadget.GadgetGatherPoint.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean");
    }

    public GadgetGatherPoint(EntityGadget gadget) {
        super(gadget);
        if (gadget.getSpawnEntry() != null) {
            this.itemId = gadget.getSpawnEntry().getGatherItemId();
            return;
        }
        GatherData gatherData = GameData.getGatherDataMap().get(gadget.getPointType());
        if (gatherData != null) {
            this.itemId = gatherData.getItemId();
            this.isForbidGuest = gatherData.isForbidGuest();
        }
    }

    public int getItemId() {
        return this.itemId;
    }

    public boolean isForbidGuest() {
        return this.isForbidGuest;
    }

    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public void onBuildProto(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder gadgetInfo) {
        gadgetInfo.setGatherGadget(GatherGadgetInfoOuterClass.GatherGadgetInfo.newBuilder().setItemId(getItemId()).setIsForbidGuest(isForbidGuest()).build());
    }

    public void dropItems(Player player) {
        Scene scene = getGadget().getScene();
        int times = Utils.randomRange(1, 2);
        for (int i = 0; i < times; i++) {
            scene.addEntity(new EntityItem(scene, player, GameData.getItemDataMap().get(this.itemId), getGadget().getPosition().clone().addY(2.0f).addX(Utils.randomFloatRange(-1.0f, 1.0f)).addZ(Utils.randomFloatRange(-1.0f, 1.0f)), 1, true));
        }
        scene.killEntity(getGadget(), player.getTeamManager().getCurrentAvatarEntity().getId());
    }
}
