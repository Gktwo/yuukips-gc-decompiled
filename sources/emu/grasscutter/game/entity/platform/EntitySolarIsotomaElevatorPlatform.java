package emu.grasscutter.game.entity.platform;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.binout.ConfigGadgetCombat;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.EntitySolarIsotomaClientGadget;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilityGadgetInfoOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.MathQuaternionOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.MovingPlatformTypeOuterClass;
import emu.grasscutter.net.proto.PlatformInfoOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.server.packet.send.PacketSceneTimeNotify;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/platform/EntitySolarIsotomaElevatorPlatform.class */
public class EntitySolarIsotomaElevatorPlatform extends EntityPlatform {
    public EntitySolarIsotomaElevatorPlatform(EntitySolarIsotomaClientGadget isotoma, Scene scene, Player player, int gadgetId, Position pos, Position rot) {
        super(isotoma, scene, player, gadgetId, pos, rot, MovingPlatformTypeOuterClass.MovingPlatformType.MOVING_PLATFORM_TYPE_ABILITY);
    }

    /* access modifiers changed from: protected */
    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public void fillFightProps(ConfigGadget configGadget) {
        ConfigGadgetCombat combatData;
        if (configGadget != null && (combatData = configGadget.getCombat()) != null) {
            if (combatData.getProperty().isUseCreatorProperty()) {
                GameEntity ownerAvatar = getScene().getEntityById(getGadget().getOwnerEntityId());
                if (ownerAvatar != null) {
                    getFightProperties().putAll(ownerAvatar.getFightProperties());
                    return;
                }
                Grasscutter.getLogger().warn("Why gadget owner is null?");
            }
            fillFightProps(configGadget);
        }
    }

    @Override // emu.grasscutter.game.entity.platform.EntityPlatform, emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneGadgetInfoOuterClass.SceneGadgetInfo gadget = SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getGadgetId()).setOwnerEntityId(getGadget().getId()).setAuthorityPeerId(getOwner().getPeerId()).setIsEnableInteract(true).setAbilityGadget(AbilityGadgetInfoOuterClass.AbilityGadgetInfo.newBuilder().setCampId(getGadget().getCampId()).setCampTargetType(getGadget().getCampType()).setTargetEntityId(getGadget().getId()).build()).setPlatform(PlatformInfoOuterClass.PlatformInfo.newBuilder().setStartRot(MathQuaternionOuterClass.MathQuaternion.newBuilder().setW(1.0f).build()).setPosOffset(getGadget().getPosition().toProto()).setRotOffset(MathQuaternionOuterClass.MathQuaternion.newBuilder().setW(1.0f).build()).setMovingPlatformType(MovingPlatformTypeOuterClass.MovingPlatformType.MOVING_PLATFORM_TYPE_ABILITY).build()).build();
        EntityAuthorityInfoOuterClass.EntityAuthorityInfo authority = EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(getGadget().getPosition().toProto())).setBornPos(getGadget().getPosition().toProto()).build();
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder info = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setEntityId(getId()).setMotionInfo(MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getGadget().getPosition().toProto()).setRot(getGadget().getRotation().toProto()).build());
        GameEntity entity = getScene().getEntityById(getGadget().getOwnerEntityId());
        if (entity instanceof EntityAvatar) {
            info.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, ((EntityAvatar) entity).getAvatar().getLevel())).build());
        } else {
            Grasscutter.getLogger().warn("Why gadget owner doesn't exist?");
        }
        addAllFightPropsToEntityInfo(info);
        info.setLifeState(1).setGadget(gadget).setEntityAuthorityInfo(authority);
        return info.build();
    }

    @Override // emu.grasscutter.game.entity.platform.EntityPlatform
    public PlatformInfoOuterClass.PlatformInfo onStartRoute() {
        setStarted(true);
        setActive(true);
        int sceneTime = getScene().getSceneTime();
        getOwner().sendPacket(new PacketSceneTimeNotify(getOwner()));
        return PlatformInfoOuterClass.PlatformInfo.newBuilder().setStartSceneTime(sceneTime + 300).setIsStarted(true).setPosOffset(getPosition().toProto()).setRotOffset(MathQuaternionOuterClass.MathQuaternion.newBuilder().setW(1.0f).build()).setMovingPlatformType(getMovingPlatformType()).setIsActive(true).build();
    }

    @Override // emu.grasscutter.game.entity.platform.EntityPlatform
    public PlatformInfoOuterClass.PlatformInfo onStopRoute() {
        setStarted(false);
        setActive(false);
        return PlatformInfoOuterClass.PlatformInfo.newBuilder().setStartSceneTime(getScene().getSceneTime()).setStopSceneTime(getScene().getSceneTime()).setPosOffset(getPosition().toProto()).setRotOffset(MathQuaternionOuterClass.MathQuaternion.newBuilder().setW(1.0f).build()).setMovingPlatformType(getMovingPlatformType()).build();
    }
}
