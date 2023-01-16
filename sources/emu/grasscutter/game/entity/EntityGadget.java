package emu.grasscutter.game.entity;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.game.entity.gadget.GadgetChest;
import emu.grasscutter.game.entity.gadget.GadgetContent;
import emu.grasscutter.game.entity.gadget.GadgetGatherObject;
import emu.grasscutter.game.entity.gadget.GadgetGatherPoint;
import emu.grasscutter.game.entity.gadget.GadgetObject;
import emu.grasscutter.game.entity.gadget.GadgetRewardStatue;
import emu.grasscutter.game.entity.gadget.GadgetWorktop;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.server.packet.send.PacketGadgetStateNotify;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityGadget.class */
public class EntityGadget extends EntityBaseGadget {
    private final GadgetData gadgetData;
    private int gadgetId;
    private int state;
    private int pointType;
    private GadgetContent content;
    private final AtomicReference<Object> fightProperties;
    private SceneGadget metaGadget;
    @Nullable
    private ConfigGadget configGadget;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, method: emu.grasscutter.game.entity.EntityGadget.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Lemu/grasscutter/data/excels/GadgetData;, I, I, I, Lemu/grasscutter/game/entity/gadget/GadgetContent;, Lit/unimi/dsi/fastutil/ints/Int2FloatMap;, Lemu/grasscutter/scripts/data/SceneGadget;, Lemu/grasscutter/data/binout/ConfigGadget;)Ljava/lang/String;}, EntityGadget(super=, gadgetData=, gadgetId=, state=, pointType=, content=, fightProperties=, metaGadget=, configGadget=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Lemu/grasscutter/data/excels/GadgetData;, I, I, I, Lemu/grasscutter/game/entity/gadget/GadgetContent;, Lit/unimi/dsi/fastutil/ints/Int2FloatMap;, Lemu/grasscutter/scripts/data/SceneGadget;, Lemu/grasscutter/data/binout/ConfigGadget;)Ljava/lang/String;}, EntityGadget(super=, gadgetData=, gadgetId=, state=, pointType=, content=, fightProperties=, metaGadget=, configGadget=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r10 = this;
            r0 = r10
            java.lang.String r0 = r0.toString()
            r1 = r10
            emu.grasscutter.data.excels.GadgetData r1 = r1.getGadgetData()
            r2 = r10
            int r2 = r2.getGadgetId()
            r3 = r10
            int r3 = r3.getState()
            r4 = r10
            int r4 = r4.getPointType()
            r5 = r10
            emu.grasscutter.game.entity.gadget.GadgetContent r5 = r5.getContent()
            r6 = r10
            it.unimi.dsi.fastutil.ints.Int2FloatMap r6 = r6.getFightProperties()
            r7 = r10
            emu.grasscutter.scripts.data.SceneGadget r7 = r7.getMetaGadget()
            r8 = r10
            emu.grasscutter.data.binout.ConfigGadget r8 = r8.getConfigGadget()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Lemu/grasscutter/data/excels/GadgetData;, I, I, I, Lemu/grasscutter/game/entity/gadget/GadgetContent;, Lit/unimi/dsi/fastutil/ints/Int2FloatMap;, Lemu/grasscutter/scripts/data/SceneGadget;, Lemu/grasscutter/data/binout/ConfigGadget;)Ljava/lang/String;}, EntityGadget(super=, gadgetData=, gadgetId=, state=, pointType=, content=, fightProperties=, metaGadget=, configGadget=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.entity.EntityGadget.toString():java.lang.String");
    }

    public GadgetData getGadgetData() {
        return this.gadgetData;
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public int getGadgetId() {
        return this.gadgetId;
    }

    public void setGadgetId(int gadgetId) {
        this.gadgetId = gadgetId;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getPointType() {
        return this.pointType;
    }

    public void setPointType(int pointType) {
        this.pointType = pointType;
    }

    public GadgetContent getContent() {
        return this.content;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        Object value = this.fightProperties.get();
        if (value == null) {
            synchronized (this.fightProperties) {
                value = this.fightProperties.get();
                if (value == null) {
                    Int2FloatMap actualValue = new Int2FloatOpenHashMap();
                    value = actualValue == null ? this.fightProperties : actualValue;
                    this.fightProperties.set(value);
                }
            }
        }
        return (Int2FloatMap) (value == this.fightProperties ? null : value);
    }

    public SceneGadget getMetaGadget() {
        return this.metaGadget;
    }

    public void setMetaGadget(SceneGadget metaGadget) {
        this.metaGadget = metaGadget;
    }

    @Nullable
    public ConfigGadget getConfigGadget() {
        return this.configGadget;
    }

    public EntityGadget(Scene scene, int gadgetId, Position pos) {
        this(scene, gadgetId, pos, null, null);
    }

    public EntityGadget(Scene scene, int gadgetId, Position pos, Position rot) {
        this(scene, gadgetId, pos, rot, null);
    }

    public EntityGadget(Scene scene, int gadgetId, Position pos, Position rot, GadgetContent content) {
        super(scene, pos, rot);
        this.fightProperties = new AtomicReference<>();
        this.gadgetData = GameData.getGadgetDataMap().get(gadgetId);
        Optional map = Optional.ofNullable(this.gadgetData).map((v0) -> {
            return v0.getJsonName();
        });
        Map<String, ConfigGadget> gadgetConfigData = GameData.getGadgetConfigData();
        Objects.requireNonNull(gadgetConfigData);
        this.configGadget = (ConfigGadget) map.map((v1) -> {
            return r2.get(v1);
        }).orElse(null);
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.GADGET);
        this.gadgetId = gadgetId;
        this.content = content;
        fillFightProps(this.configGadget);
    }

    public void updateState(int state) {
        setState(state);
        getScene().broadcastPacket(new PacketGadgetStateNotify(this, state));
        getScene().getScriptManager().callEvent(new ScriptArgs(7, state, getConfigId()));
    }

    @Deprecated(forRemoval = true)
    public void setContent(GadgetContent content) {
        this.content = this.content == null ? content : this.content;
    }

    public void buildContent() {
        GadgetContent gadgetContent;
        if (getContent() == null && getGadgetData() != null && getGadgetData().getType() != null) {
            switch (getGadgetData().getType()) {
                case GatherPoint:
                    gadgetContent = new GadgetGatherPoint(this);
                    break;
                case GatherObject:
                    gadgetContent = new GadgetGatherObject(this);
                    break;
                case Worktop:
                case SealGadget:
                    gadgetContent = new GadgetWorktop(this);
                    break;
                case RewardStatue:
                    gadgetContent = new GadgetRewardStatue(this);
                    break;
                case Chest:
                    gadgetContent = new GadgetChest(this);
                    break;
                case Gadget:
                    gadgetContent = new GadgetObject(this);
                    break;
                default:
                    gadgetContent = null;
                    break;
            }
            this.content = gadgetContent;
        }
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq interactReq) {
        if (getContent() != null && getContent().onInteract(player, interactReq)) {
            getScene().killEntity(this);
        }
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onCreate() {
        getScene().getScriptManager().callEvent(new ScriptArgs(6, getConfigId()));
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget, emu.grasscutter.game.entity.GameEntity
    public void onDeath(int killerId) {
        onDeath(killerId);
        if (getSpawnEntry() != null) {
            getScene().getDeadSpawnedEntities().add(getSpawnEntry());
        }
        if (getScene().getChallenge() != null) {
            getScene().getChallenge().onGadgetDeath(this);
        }
        getScene().getScriptManager().callEvent(new ScriptArgs(2, getConfigId()));
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder())).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(VectorOuterClass.Vector.newBuilder())).setBornPos(VectorOuterClass.Vector.newBuilder()).build()).setLifeState(1);
        entityInfo.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, 1)).build());
        if (this.fightProperties != null) {
            addAllFightPropsToEntityInfo(entityInfo);
        }
        SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder gadgetInfo = SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getGadgetId()).setGroupId(getGroupId()).setConfigId(getConfigId()).setGadgetState(getState()).setIsEnableInteract(true).setAuthorityPeerId(getScene().getWorld().getHostPeerId());
        if (this.metaGadget != null) {
            gadgetInfo.setDraftId(this.metaGadget.draft_id);
        }
        if (getContent() != null) {
            getContent().onBuildProto(gadgetInfo);
        }
        entityInfo.setGadget(gadgetInfo);
        return entityInfo.build();
    }
}
