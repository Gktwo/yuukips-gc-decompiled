package emu.grasscutter.game.entity;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.LifeState;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.game.world.SpawnDataEntry;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.proto.FightPropPairOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.MotionInfoOuterClass;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.server.event.entity.EntityDamageEvent;
import emu.grasscutter.server.event.entity.EntityDeathEvent;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.utils.Position;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/GameEntity.class */
public abstract class GameEntity {

    /* renamed from: id */
    protected int f571id;
    private final Scene scene;
    private SpawnDataEntry spawnEntry;
    private int blockId;
    private int configId;
    private int groupId;
    private MotionStateOuterClass.MotionState motionState = MotionStateOuterClass.MotionState.MOTION_STATE_NONE;
    private int lastMoveSceneTimeMs;
    private int lastMoveReliableSeq;
    private boolean lockHP;
    private Object2FloatMap<String> metaOverrideMap;
    private Int2ObjectMap<String> metaModifiers;

    public abstract Int2FloatMap getFightProperties();

    public abstract Position getPosition();

    public abstract Position getRotation();

    public abstract SceneEntityInfoOuterClass.SceneEntityInfo toProto();

    public int getId() {
        return this.f571id;
    }

    public Scene getScene() {
        return this.scene;
    }

    public SpawnDataEntry getSpawnEntry() {
        return this.spawnEntry;
    }

    public void setSpawnEntry(SpawnDataEntry spawnEntry) {
        this.spawnEntry = spawnEntry;
    }

    public int getBlockId() {
        return this.blockId;
    }

    public void setBlockId(int blockId) {
        this.blockId = blockId;
    }

    public int getConfigId() {
        return this.configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public MotionStateOuterClass.MotionState getMotionState() {
        return this.motionState;
    }

    public void setMotionState(MotionStateOuterClass.MotionState motionState) {
        this.motionState = motionState;
    }

    public int getLastMoveSceneTimeMs() {
        return this.lastMoveSceneTimeMs;
    }

    public void setLastMoveSceneTimeMs(int lastMoveSceneTimeMs) {
        this.lastMoveSceneTimeMs = lastMoveSceneTimeMs;
    }

    public int getLastMoveReliableSeq() {
        return this.lastMoveReliableSeq;
    }

    public void setLastMoveReliableSeq(int lastMoveReliableSeq) {
        this.lastMoveReliableSeq = lastMoveReliableSeq;
    }

    public boolean isLockHP() {
        return this.lockHP;
    }

    public void setLockHP(boolean lockHP) {
        this.lockHP = lockHP;
    }

    public GameEntity(Scene scene) {
        this.scene = scene;
    }

    public int getEntityType() {
        return getId() >> 24;
    }

    public World getWorld() {
        return getScene().getWorld();
    }

    public boolean isAlive() {
        return true;
    }

    public LifeState getLifeState() {
        return isAlive() ? LifeState.LIFE_ALIVE : LifeState.LIFE_DEAD;
    }

    public Object2FloatMap<String> getMetaOverrideMap() {
        if (this.metaOverrideMap == null) {
            this.metaOverrideMap = new Object2FloatOpenHashMap();
        }
        return this.metaOverrideMap;
    }

    public Int2ObjectMap<String> getMetaModifiers() {
        if (this.metaModifiers == null) {
            this.metaModifiers = new Int2ObjectOpenHashMap();
        }
        return this.metaModifiers;
    }

    public void setFightProperty(FightProperty prop, float value) {
        if (getFightProperties() != null) {
            getFightProperties().put(prop.getId(), value);
        }
    }

    public void setFightProperty(int id, float value) {
        if (getFightProperties() != null) {
            getFightProperties().put(id, value);
        }
    }

    public void addFightProperty(FightProperty prop, float value) {
        if (getFightProperties() != null) {
            getFightProperties().put(prop.getId(), getFightProperty(prop) + value);
        }
    }

    public float getFightProperty(FightProperty prop) {
        if (getFightProperties() != null) {
            return getFightProperties().getOrDefault(prop.getId(), 0.0f);
        }
        return 0.0f;
    }

    public boolean hasFightProperty(FightProperty prop) {
        if (getFightProperties() != null) {
            return getFightProperties().containsKey(prop.getId());
        }
        return false;
    }

    public void addAllFightPropsToEntityInfo(SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo) {
        if (getFightProperties() != null) {
            getFightProperties().forEach(key, value -> {
                if (key.intValue() != 0) {
                    entityInfo.addFightPropList(FightPropPairOuterClass.FightPropPair.newBuilder().setPropType(key.intValue()).setPropValue(value.floatValue()).build());
                }
            });
        }
    }

    protected MotionInfoOuterClass.MotionInfo getMotionInfo() {
        return MotionInfoOuterClass.MotionInfo.newBuilder().setPos(getPosition().toProto()).setRot(getRotation().toProto()).setSpeed(VectorOuterClass.Vector.newBuilder()).setState(getMotionState()).build();
    }

    public float heal(float amount) {
        if (getFightProperties() == null) {
            return 0.0f;
        }
        float curHp = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
        float maxHp = getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
        if (curHp >= maxHp) {
            return 0.0f;
        }
        float healed = Math.min(maxHp - curHp, amount);
        addFightProperty(FightProperty.FIGHT_PROP_CUR_HP, healed);
        getScene().broadcastPacket(new PacketEntityFightPropUpdateNotify(this, FightProperty.FIGHT_PROP_CUR_HP));
        return healed;
    }

    public void damage(float amount) {
        damage(amount, 0);
    }

    public void damage(float amount, int killerId) {
        if (getFightProperties() != null && hasFightProperty(FightProperty.FIGHT_PROP_CUR_HP)) {
            EntityDamageEvent event = new EntityDamageEvent(this, amount, getScene().getEntityById(killerId));
            event.call();
            if (!event.isCanceled()) {
                float curHp = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
                if ((curHp != Float.POSITIVE_INFINITY && !this.lockHP) || (this.lockHP && curHp <= event.getDamage())) {
                    addFightProperty(FightProperty.FIGHT_PROP_CUR_HP, -event.getDamage());
                }
                boolean isDead = false;
                if (getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) <= 0.0f) {
                    setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, 0.0f);
                    isDead = true;
                }
                callLuaHPEvent();
                getScene().broadcastPacket(new PacketEntityFightPropUpdateNotify(this, FightProperty.FIGHT_PROP_CUR_HP));
                if (isDead) {
                    getScene().killEntity(this, killerId);
                }
            }
        }
    }

    public void callLuaHPEvent() {
    }

    public void move(Position position, Position rotation) {
        getPosition().set(position);
        getRotation().set(rotation);
    }

    public void onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq interactReq) {
    }

    public void onCreate() {
    }

    public void onRemoved() {
    }

    public void onDeath(int killerId) {
        new EntityDeathEvent(this, killerId).call();
    }
}
