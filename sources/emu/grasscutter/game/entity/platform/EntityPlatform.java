package emu.grasscutter.game.entity.platform;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.game.entity.EntityBaseGadget;
import emu.grasscutter.game.entity.EntityClientGadget;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.MovingPlatformTypeOuterClass;
import emu.grasscutter.net.proto.PlatformInfoOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.utils.Position;
import javax.annotation.Nullable;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/platform/EntityPlatform.class */
public class EntityPlatform extends EntityBaseGadget {
    private final Player owner;
    private final int gadgetId;
    private final EntityClientGadget gadget;
    private final Int2FloatMap fightProperties = new Int2FloatOpenHashMap();
    @Nullable
    private ConfigGadget configGadget;
    private final MovingPlatformTypeOuterClass.MovingPlatformType movingPlatformType;
    private boolean isStarted;
    private boolean isActive;

    public Player getOwner() {
        return this.owner;
    }

    @Override // emu.grasscutter.game.entity.EntityBaseGadget
    public int getGadgetId() {
        return this.gadgetId;
    }

    public EntityClientGadget getGadget() {
        return this.gadget;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return this.fightProperties;
    }

    @Nullable
    public ConfigGadget getConfigGadget() {
        return this.configGadget;
    }

    public MovingPlatformTypeOuterClass.MovingPlatformType getMovingPlatformType() {
        return this.movingPlatformType;
    }

    public boolean isStarted() {
        return this.isStarted;
    }

    public void setStarted(boolean isStarted) {
        this.isStarted = isStarted;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public EntityPlatform(EntityClientGadget gadget, Scene scene, Player player, int gadgetId, Position pos, Position rot, MovingPlatformTypeOuterClass.MovingPlatformType movingPlatformType) {
        super(scene, pos, rot);
        this.gadget = gadget;
        this.owner = player;
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.GADGET);
        this.movingPlatformType = movingPlatformType;
        this.gadgetId = gadgetId;
        GadgetData data = GameData.getGadgetDataMap().get(gadgetId);
        if (!(data == null || data.getJsonName() == null)) {
            this.configGadget = GameData.getGadgetConfigData().get(data.getJsonName());
        }
        fillFightProps(this.configGadget);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_GADGET).setGadget(SceneGadgetInfoOuterClass.SceneGadgetInfo.newBuilder().setGadgetId(getGadgetId()).setAuthorityPeerId(getOwner().getPeerId()).setPlatform(PlatformInfoOuterClass.PlatformInfo.newBuilder().setMovingPlatformType(this.movingPlatformType).build())).setLifeState(1);
        addAllFightPropsToEntityInfo(entityInfo);
        return entityInfo.build();
    }

    public PlatformInfoOuterClass.PlatformInfo onStartRoute() {
        return PlatformInfoOuterClass.PlatformInfo.newBuilder().setStartSceneTime(getScene().getSceneTime()).setIsStarted(true).setPosOffset(getPosition().toProto()).setMovingPlatformType(getMovingPlatformType()).setIsActive(true).build();
    }

    public PlatformInfoOuterClass.PlatformInfo onStopRoute() {
        int sceneTime = getScene().getSceneTime();
        return PlatformInfoOuterClass.PlatformInfo.newBuilder().setStartSceneTime(sceneTime).setStopSceneTime(sceneTime).setPosOffset(getPosition().toProto()).setMovingPlatformType(getMovingPlatformType()).build();
    }
}
