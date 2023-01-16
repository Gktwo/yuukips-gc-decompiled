package emu.grasscutter.game.entity;

import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneNpcInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.scripts.data.SceneNPC;
import emu.grasscutter.utils.Position;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityNPC.class */
public class EntityNPC extends GameEntity {
    private final Position position;
    private final Position rotation;
    private final SceneNPC metaNpc;
    private final int suiteId;

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getPosition() {
        return this.position;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getRotation() {
        return this.rotation;
    }

    public int getSuiteId() {
        return this.suiteId;
    }

    public EntityNPC(Scene scene, SceneNPC metaNPC, int blockId, int suiteId) {
        super(scene);
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.NPC);
        setConfigId(metaNPC.config_id);
        setGroupId(metaNPC.group.f957id);
        setBlockId(blockId);
        this.suiteId = suiteId;
        this.position = metaNPC.pos.clone();
        this.rotation = metaNPC.rot.clone();
        this.metaNpc = metaNPC;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return null;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_NPC).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder())).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(getPosition().toProto())).setBornPos(getPosition().toProto()).build()).setLifeState(1);
        entityInfo.setNpc(SceneNpcInfoOuterClass.SceneNpcInfo.newBuilder().setNpcId(this.metaNpc.npc_id).setBlockId(getBlockId()).build());
        return entityInfo.build();
    }
}
