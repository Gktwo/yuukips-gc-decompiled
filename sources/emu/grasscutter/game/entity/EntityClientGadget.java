package emu.grasscutter.game.entity;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.ClientGadgetInfoOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.EvtCreateGadgetNotifyOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityClientGadget.class */
public class EntityClientGadget extends EntityBaseGadget {
    private final Player owner;
    private int gadgetId;
    private int campId;
    private int campType;
    private int ownerEntityId;
    private int targetEntityId;
    private boolean asyncLoad;
    private int originalOwnerEntityId;

    public Player getOwner() {
        return this.owner;
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public int getGadgetId() {
        return this.gadgetId;
    }

    public int getCampId() {
        return this.campId;
    }

    public int getCampType() {
        return this.campType;
    }

    public int getOwnerEntityId() {
        return this.ownerEntityId;
    }

    public int getTargetEntityId() {
        return this.targetEntityId;
    }

    public boolean isAsyncLoad() {
        return this.asyncLoad;
    }

    public int getOriginalOwnerEntityId() {
        return this.originalOwnerEntityId;
    }

    public EntityClientGadget(Scene scene, Player player, EvtCreateGadgetNotifyOuterClass.EvtCreateGadgetNotify notify) {
        super(scene, new Position(notify.getInitPos()), new Position(notify.getInitEulerAngles()));
        this.owner = player;
        this.f571id = notify.getEntityId();
        this.gadgetId = notify.getConfigId();
        this.campId = notify.getCampId();
        this.campType = notify.getCampType();
        this.ownerEntityId = notify.getPropOwnerEntityId();
        this.targetEntityId = notify.getTargetEntityId();
        this.asyncLoad = notify.getIsAsyncLoad();
        GameEntity owner = scene.getEntityById(this.ownerEntityId);
        if (owner instanceof EntityClientGadget) {
            this.originalOwnerEntityId = ((EntityClientGadget) owner).getOriginalOwnerEntityId();
        } else {
            this.originalOwnerEntityId = this.ownerEntityId;
        }
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget, emu.grasscutter.game.entity.GameEntity
    public void onDeath(int killerId) {
        onDeath(killerId);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return null;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder())).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(VectorOuterClass.Vector.newBuilder())).setBornPos(VectorOuterClass.Vector.newBuilder()).build()).setLifeState(1);
        entityInfo.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, 1)).build());
        entityInfo.setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getGadgetId()).setOwnerEntityId(getOwnerEntityId()).setIsEnableInteract(true).setClientGadget(ClientGadgetInfoOuterClass.ClientGadgetInfo.newBuilder().setCampId(getCampId()).setCampType(getCampType()).setOwnerEntityId(getOwnerEntityId()).setTargetEntityId(getTargetEntityId()).setAsyncLoad(isAsyncLoad()).build()).setPropOwnerEntityId(getOwnerEntityId()).setAuthorityPeerId(getOwner().getPeerId()));
        return entityInfo.build();
    }
}
