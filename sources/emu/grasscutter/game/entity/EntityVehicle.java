package emu.grasscutter.game.entity;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.net.proto.VehicleInfoOuterClass;
import emu.grasscutter.net.proto.VehicleMemberOuterClass;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityVehicle.class */
public class EntityVehicle extends EntityBaseGadget {
    private final Player owner;
    private final int pointId;
    private final int gadgetId;
    @Nullable
    private ConfigGadget configGadget;
    private final Int2FloatMap fightProperties = new Int2FloatOpenHashMap();
    private float curStamina = 240.0f;
    private List<VehicleMemberOuterClass.VehicleMember> vehicleMembers = new ArrayList();

    public Player getOwner() {
        return this.owner;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return this.fightProperties;
    }

    public int getPointId() {
        return this.pointId;
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public int getGadgetId() {
        return this.gadgetId;
    }

    public float getCurStamina() {
        return this.curStamina;
    }

    public void setCurStamina(float curStamina) {
        this.curStamina = curStamina;
    }

    public List<VehicleMemberOuterClass.VehicleMember> getVehicleMembers() {
        return this.vehicleMembers;
    }

    @Nullable
    public ConfigGadget getConfigGadget() {
        return this.configGadget;
    }

    public EntityVehicle(Scene scene, Player player, int gadgetId, int pointId, Position pos, Position rot) {
        super(scene, pos, rot);
        this.owner = player;
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.GADGET);
        this.gadgetId = gadgetId;
        this.pointId = pointId;
        GadgetData data = GameData.getGadgetDataMap().get(gadgetId);
        if (!(data == null || data.getJsonName() == null)) {
            this.configGadget = GameData.getGadgetConfigData().get(data.getJsonName());
        }
        fillFightProps(this.configGadget);
    }

    /* access modifiers changed from: protected */
    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public void fillFightProps(ConfigGadget configGadget) {
        fillFightProps(configGadget);
        addFightProperty(FightProperty.FIGHT_PROP_CUR_SPEED, 0.0f);
        addFightProperty(FightProperty.FIGHT_PROP_CHARGE_EFFICIENCY, 0.0f);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        VehicleInfoOuterClass.VehicleInfo vehicle = VehicleInfoOuterClass.VehicleInfo.newBuilder().setOwnerUid(this.owner.getUid()).setCurStamina(getCurStamina()).build();
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder())).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getGadgetId()).setAuthorityPeerId(getOwner().getPeerId()).setIsEnableInteract(true).setVehicleInfo(vehicle)).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(getPosition().toProto())).setBornPos(getPosition().toProto()).build()).setLifeState(1);
        PropPairOuterClass.PropPair pair = PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, 47)).build();
        addAllFightPropsToEntityInfo(entityInfo);
        entityInfo.addPropList(pair);
        return entityInfo.build();
    }
}
