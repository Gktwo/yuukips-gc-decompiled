package emu.grasscutter.game.entity;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.PropGrowCurve;
import emu.grasscutter.data.excels.EnvAnimalGatherConfigData;
import emu.grasscutter.data.excels.MonsterCurveData;
import emu.grasscutter.data.excels.MonsterData;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.game.world.SpawnDataEntry;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.MonsterBornTypeOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.SceneMonsterInfoOuterClass;
import emu.grasscutter.net.proto.SceneWeaponInfoOuterClass;
import emu.grasscutter.scripts.SceneScriptManager;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.scripts.data.ScriptArgs;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityMonster.class */
public class EntityMonster extends GameEntity {
    private final MonsterData monsterData;
    private final Position position;
    private final int level;
    private int weaponEntityId;
    private int poseId;
    private SceneMonster metaMonster;
    private int aiId = -1;
    private final Int2FloatOpenHashMap fightProperties = new Int2FloatOpenHashMap();
    private final Position rotation = new Position();
    private final Position bornPos = getPosition().clone();

    public MonsterData getMonsterData() {
        return this.monsterData;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatOpenHashMap getFightProperties() {
        return this.fightProperties;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getPosition() {
        return this.position;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getRotation() {
        return this.rotation;
    }

    public Position getBornPos() {
        return this.bornPos;
    }

    public int getLevel() {
        return this.level;
    }

    public int getPoseId() {
        return this.poseId;
    }

    public void setPoseId(int poseId) {
        this.poseId = poseId;
    }

    public int getAiId() {
        return this.aiId;
    }

    public void setAiId(int aiId) {
        this.aiId = aiId;
    }

    public SceneMonster getMetaMonster() {
        return this.metaMonster;
    }

    public void setMetaMonster(SceneMonster metaMonster) {
        this.metaMonster = metaMonster;
    }

    public EntityMonster(Scene scene, MonsterData monsterData, Position pos, int level) {
        super(scene);
        this.f571id = getWorld().getNextEntityId(EntityIdType.MONSTER);
        this.monsterData = monsterData;
        this.position = new Position(pos);
        this.level = level;
        if (getMonsterWeaponId() > 0) {
            this.weaponEntityId = getWorld().getNextEntityId(EntityIdType.WEAPON);
        }
        recalcStats();
    }

    public int getMonsterWeaponId() {
        return getMonsterData().getWeaponId();
    }

    private int getMonsterId() {
        return getMonsterData().getId();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public boolean isAlive() {
        return getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) > 0.0f;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq interactReq) {
        EnvAnimalGatherConfigData gatherData = GameData.getEnvAnimalGatherConfigDataMap().get(getMonsterData().getId());
        if (gatherData != null) {
            player.getInventory().addItem(gatherData.getGatherItem(), ActionReason.SubfieldDrop);
            getScene().killEntity(this);
        }
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onCreate() {
        getScene().getScriptManager().callEvent(new ScriptArgs(11, getConfigId()));
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void damage(float amount, int killerId) {
        float hpBeforeDamage = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
        damage(amount, killerId);
        float hpAfterDamage = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
        for (Player player : getScene().getPlayers()) {
            player.getEnergyManager().handleMonsterEnergyDrop(this, hpBeforeDamage, hpAfterDamage);
        }
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void callLuaHPEvent() {
        getScene().getScriptManager().callEvent(new ScriptArgs(12, getConfigId(), this.monsterData.getId()).setSourceEntityId(getId()).setParam3((int) getFightProperty(FightProperty.FIGHT_PROP_CUR_HP)).setEventSource(Integer.toString(getConfigId())));
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onDeath(int killerId) {
        onDeath(killerId);
        Scene scene = getScene();
        Optional<WorldChallenge> challenge = Optional.ofNullable(scene.getChallenge());
        SceneScriptManager scriptManager = scene.getScriptManager();
        Optional ofNullable = Optional.ofNullable(getSpawnEntry());
        Set<SpawnDataEntry> deadSpawnedEntities = scene.getDeadSpawnedEntities();
        Objects.requireNonNull(deadSpawnedEntities);
        ofNullable.ifPresent((v1) -> {
            r1.add(v1);
        });
        challenge.ifPresent(c -> {
            c.onMonsterDeath(this);
        });
        if (scriptManager.isInit()) {
            Optional.ofNullable(scriptManager.getScriptMonsterSpawnService()).ifPresent(s -> {
                s.onMonsterDead(this);
            });
            if (((Boolean) challenge.map(c -> {
                return Boolean.valueOf(c.inProgress());
            }).orElse(true)).booleanValue()) {
                scriptManager.callEvent(new ScriptArgs(1).setParam1(getConfigId()));
            }
        }
        scene.getPlayers().forEach(p -> {
            p.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_MONSTER_DIE, getMonsterId(), 1);
        });
        scene.getPlayers().forEach(p -> {
            p.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_MONSTER_DIE, getMonsterId());
        });
        scene.getPlayers().forEach(p -> {
            p.getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_KILL_MONSTER, getMonsterId());
        });
        scene.triggerDungeonEvent(DungeonPassConditionType.DUNGEON_COND_KILL_GROUP_MONSTER, getGroupId());
        if (!(getMonsterData() == null || getMonsterData().getType() == null)) {
            scene.triggerDungeonEvent(DungeonPassConditionType.DUNGEON_COND_KILL_TYPE_MONSTER, getMonsterData().getType().getValue());
        }
        scene.triggerDungeonEvent(DungeonPassConditionType.DUNGEON_COND_KILL_MONSTER, getMonsterId());
    }

    public void recalcStats() {
        float hpPercent;
        MonsterData data = getMonsterData();
        if (getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) <= 0.0f) {
            hpPercent = 1.0f;
        } else {
            hpPercent = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) / getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
        }
        getFightProperties().clear();
        MonsterData.definedFightProperties.forEach(prop -> {
            setFightProperty(data, data.getFightProperty(data));
        });
        MonsterCurveData curve = GameData.getMonsterCurveDataMap().get(getLevel());
        if (curve != null) {
            for (PropGrowCurve growCurve : data.getPropGrowCurves()) {
                FightProperty prop = FightProperty.getPropByName(growCurve.getType());
                setFightProperty(prop, getFightProperty(prop) * curve.getMultByProp(growCurve.getGrowCurve()));
            }
        }
        FightProperty.forEachCompoundProperty(c -> {
            setFightProperty(c.getResult(), getFightProperty(c.getFlat()) + (getFightProperty(c.getBase()) * (1.0f + getFightProperty(c.getPercent()))));
        });
        setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) * hpPercent);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_MONSTER).setMotionInfo(getMotionInfo()).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(getBornPos().toProto())).setBornPos(getBornPos().toProto()).build()).setLifeState(getLifeState().getValue());
        addAllFightPropsToEntityInfo(entityInfo);
        entityInfo.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, getLevel())).build());
        SceneMonsterInfoOuterClass.SceneMonsterInfo.Builder monsterInfo = SceneMonsterInfoOuterClass.SceneMonsterInfo.newBuilder().setMonsterId(getMonsterId()).setGroupId(getGroupId()).setConfigId(getConfigId()).addAllAffixList(getMonsterData().getAffix()).setAuthorityPeerId(getWorld().getHostPeerId()).setPoseId(getPoseId()).setBlockId(getScene().getId()).setBornType(MonsterBornTypeOuterClass.MonsterBornType.MONSTER_BORN_TYPE_DEFAULT);
        if (getMonsterData().getId() == 29070103) {
            monsterInfo.setTitleId(161).setSpecialNameId(12);
        }
        if (getMonsterData().getDescribeData() != null) {
            monsterInfo.setTitleId(getMonsterData().getDescribeData().getTitleId()).setSpecialNameId(getMonsterData().getSpecialNameId());
        }
        if (getMonsterWeaponId() > 0) {
            monsterInfo.addWeaponList(SceneWeaponInfoOuterClass.SceneWeaponInfo.newBuilder().setEntityId(this.weaponEntityId).setGadgetId(getMonsterWeaponId()).setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).build());
        }
        if (this.aiId != -1) {
            monsterInfo.setAiConfigId(this.aiId);
        }
        entityInfo.setMonster(monsterInfo);
        return entityInfo.build();
    }
}
