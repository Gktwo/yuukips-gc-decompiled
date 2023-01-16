package emu.grasscutter.game.entity;

import emu.grasscutter.GameConstants;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.EquipType;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.AbilityControlBlockOuterClass;
import emu.grasscutter.net.proto.AbilityEmbryoOuterClass;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.AnimatorParameterValueInfoPairOuterClass;
import emu.grasscutter.net.proto.ChangeEnergyReasonOuterClass;
import emu.grasscutter.net.proto.ChangeHpReasonOuterClass;
import emu.grasscutter.net.proto.EntityAuthorityInfoOuterClass;
import emu.grasscutter.net.proto.EntityClientDataOuterClass;
import emu.grasscutter.net.proto.EntityRendererChangedInfoOuterClass;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import emu.grasscutter.net.proto.PropPairOuterClass;
import emu.grasscutter.net.proto.ProtEntityTypeOuterClass;
import emu.grasscutter.net.proto.SceneAvatarInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityAiInfoOuterClass;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.server.event.player.PlayerMoveEvent;
import emu.grasscutter.server.packet.send.PacketAvatarFightPropUpdateNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropChangeReasonNotify;
import emu.grasscutter.server.packet.send.PacketEntityFightPropUpdateNotify;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.ProtoHelper;
import emu.grasscutter.utils.Utils;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntListIterator;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityAvatar.class */
public class EntityAvatar extends GameEntity {
    private final Avatar avatar;
    private PlayerDieTypeOuterClass.PlayerDieType killedType;
    private int killedBy;

    public Avatar getAvatar() {
        return this.avatar;
    }

    public PlayerDieTypeOuterClass.PlayerDieType getKilledType() {
        return this.killedType;
    }

    public int getKilledBy() {
        return this.killedBy;
    }

    public EntityAvatar(Avatar avatar) {
        this(null, avatar);
    }

    public EntityAvatar(Scene scene, Avatar avatar) {
        super(scene);
        this.avatar = avatar;
        this.avatar.setCurrentEnergy();
        if (scene != null) {
            this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.AVATAR);
        }
        GameItem weapon = getAvatar().getWeapon();
        if (weapon != null && scene != null) {
            weapon.setWeaponEntityId(getScene().getWorld().getNextEntityId(EntityIdType.WEAPON));
        }
    }

    public Player getPlayer() {
        return this.avatar.getPlayer();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getPosition() {
        return getPlayer().getPosition();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getRotation() {
        return getPlayer().getRotation();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public boolean isAlive() {
        return getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) > 0.0f;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return getAvatar().getFightProperties();
    }

    public int getWeaponEntityId() {
        if (getAvatar().getWeapon() != null) {
            return getAvatar().getWeapon().getWeaponEntityId();
        }
        return 0;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void onDeath(int killerId) {
        onDeath(killerId);
        this.killedType = PlayerDieTypeOuterClass.PlayerDieType.PLAYER_DIE_TYPE_KILL_BY_MONSTER;
        this.killedBy = killerId;
        clearEnergy(ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_NONE);
    }

    public void onDeath(PlayerDieTypeOuterClass.PlayerDieType dieType, int killerId) {
        onDeath(killerId);
        this.killedType = dieType;
        this.killedBy = killerId;
        clearEnergy(ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_NONE);
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public float heal(float amount) {
        if (!isAlive()) {
            return 0.0f;
        }
        float healed = heal(amount);
        if (healed > 0.0f) {
            getScene().broadcastPacket(new PacketEntityFightPropChangeReasonNotify(this, FightProperty.FIGHT_PROP_CUR_HP, Float.valueOf(healed), PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_ABILITY, ChangeHpReasonOuterClass.ChangeHpReason.CHANGE_HP_REASON_ADD_ABILITY));
        }
        return healed;
    }

    public void clearEnergy(ChangeEnergyReasonOuterClass.ChangeEnergyReason reason) {
        FightProperty curEnergyProp = getAvatar().getSkillDepot().getElementType().getCurEnergyProp();
        float curEnergy = getFightProperty(curEnergyProp);
        this.avatar.setCurrentEnergy(curEnergyProp, 0.0f);
        getScene().broadcastPacket(new PacketEntityFightPropUpdateNotify(this, curEnergyProp));
        if (reason == ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_SKILL_START) {
            getScene().broadcastPacket(new PacketEntityFightPropChangeReasonNotify(this, curEnergyProp, Float.valueOf(-curEnergy), reason));
        }
    }

    public boolean addEnergy(float amount) {
        FightProperty curEnergyProp = getAvatar().getSkillDepot().getElementType().getCurEnergyProp();
        if (getFightProperty(curEnergyProp) == amount) {
            return false;
        }
        getAvatar().setCurrentEnergy(curEnergyProp, amount);
        getScene().broadcastPacket(new PacketEntityFightPropUpdateNotify(this, curEnergyProp));
        return true;
    }

    public void addEnergy(float amount, PropChangeReasonOuterClass.PropChangeReason reason) {
        addEnergy(amount, reason, false);
    }

    public void addEnergy(float amount, PropChangeReasonOuterClass.PropChangeReason reason, boolean isFlat) {
        ElementType elementType = getAvatar().getSkillDepot().getElementType();
        FightProperty curEnergyProp = elementType.getCurEnergyProp();
        FightProperty maxEnergyProp = elementType.getMaxEnergyProp();
        float curEnergy = getFightProperty(curEnergyProp);
        float maxEnergy = getFightProperty(maxEnergyProp);
        if (!isFlat) {
            amount *= getFightProperty(FightProperty.FIGHT_PROP_CHARGE_EFFICIENCY);
        }
        float newEnergy = Math.min(curEnergy + amount, maxEnergy);
        if (newEnergy != curEnergy) {
            this.avatar.setCurrentEnergy(curEnergyProp, newEnergy);
            getScene().broadcastPacket(new PacketAvatarFightPropUpdateNotify(getAvatar(), curEnergyProp));
            getScene().broadcastPacket(new PacketEntityFightPropChangeReasonNotify(this, curEnergyProp, Float.valueOf(newEnergy), reason));
        }
    }

    public SceneAvatarInfoOuterClass.SceneAvatarInfo getSceneAvatarInfo() {
        Avatar avatar = getAvatar();
        Player player = getPlayer();
        SceneAvatarInfoOuterClass.SceneAvatarInfo.Builder avatarInfo = SceneAvatarInfoOuterClass.SceneAvatarInfo.newBuilder().setUid(player.getUid()).setAvatarId(avatar.getAvatarId()).setGuid(avatar.getGuid()).setPeerId(player.getPeerId()).addAllTalentIdList(avatar.getTalentIdList()).setCoreProudSkillLevel(avatar.getCoreProudSkillLevel()).putAllSkillLevelMap(avatar.getSkillLevelMap()).setSkillDepotId(avatar.getSkillDepotId()).addAllInherentProudSkillList(avatar.getProudSkillList()).putAllProudSkillExtraLevelMap(avatar.getProudSkillBonusMap()).addAllTeamResonanceList(player.getTeamManager().getTeamResonances()).setWearingFlycloakId(avatar.getFlyCloak()).setCostumeId(avatar.getCostume()).setBornTime(avatar.getBornTime());
        ObjectIterator<GameItem> it = avatar.getEquips().values().iterator();
        while (it.hasNext()) {
            GameItem item = it.next();
            if (item.getItemData().getEquipType() == EquipType.EQUIP_WEAPON) {
                avatarInfo.setWeapon(item.createSceneWeaponInfo());
            } else {
                avatarInfo.addReliquaryList(item.createSceneReliquaryInfo());
            }
            avatarInfo.addEquipIdList(item.getItemId());
        }
        return avatarInfo.build();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        SceneEntityInfoOuterClass.SceneEntityInfo.Builder entityInfo = SceneEntityInfoOuterClass.SceneEntityInfo.newBuilder().setEntityId(getId()).setEntityType(ProtEntityTypeOuterClass.ProtEntityType.PROT_ENTITY_TYPE_AVATAR).addAnimatorParaList(AnimatorParameterValueInfoPairOuterClass.AnimatorParameterValueInfoPair.newBuilder()).setEntityClientData(EntityClientDataOuterClass.EntityClientData.newBuilder()).setEntityAuthorityInfo(EntityAuthorityInfoOuterClass.EntityAuthorityInfo.newBuilder().setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).setRendererChangedInfo(EntityRendererChangedInfoOuterClass.EntityRendererChangedInfo.newBuilder()).setAiInfo(SceneEntityAiInfoOuterClass.SceneEntityAiInfo.newBuilder().setIsAiOpen(true).setBornPos(VectorOuterClass.Vector.newBuilder())).setBornPos(VectorOuterClass.Vector.newBuilder()).build()).setLastMoveSceneTimeMs(getLastMoveSceneTimeMs()).setLastMoveReliableSeq(getLastMoveReliableSeq()).setLifeState(getLifeState().getValue());
        if (getScene() != null) {
            entityInfo.setMotionInfo(getMotionInfo());
        }
        addAllFightPropsToEntityInfo(entityInfo);
        entityInfo.addPropList(PropPairOuterClass.PropPair.newBuilder().setType(PlayerProperty.PROP_LEVEL.getId()).setPropValue(ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, getAvatar().getLevel())).build());
        entityInfo.setAvatar(getSceneAvatarInfo());
        return entityInfo.build();
    }

    public AbilityControlBlockOuterClass.AbilityControlBlock getAbilityControlBlock() {
        AvatarData data = getAvatar().getAvatarData();
        AbilityControlBlockOuterClass.AbilityControlBlock.Builder abilityControlBlock = AbilityControlBlockOuterClass.AbilityControlBlock.newBuilder();
        int embryoId = 0;
        if (data.getAbilities() != null) {
            IntListIterator it = data.getAbilities().iterator();
            while (it.hasNext()) {
                embryoId++;
                abilityControlBlock.addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.newBuilder().setAbilityId(embryoId).setAbilityNameHash(it.next().intValue()).setAbilityOverrideNameHash(GameConstants.DEFAULT_ABILITY_NAME).build());
            }
        }
        for (int id : GameConstants.DEFAULT_ABILITY_HASHES) {
            embryoId++;
            abilityControlBlock.addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.newBuilder().setAbilityId(embryoId).setAbilityNameHash(id).setAbilityOverrideNameHash(GameConstants.DEFAULT_ABILITY_NAME).build());
        }
        IntIterator it2 = getPlayer().getTeamManager().getTeamResonancesConfig().iterator();
        while (it2.hasNext()) {
            embryoId++;
            abilityControlBlock.addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.newBuilder().setAbilityId(embryoId).setAbilityNameHash(it2.next().intValue()).setAbilityOverrideNameHash(GameConstants.DEFAULT_ABILITY_NAME).build());
        }
        AvatarSkillDepotData skillDepot = GameData.getAvatarSkillDepotDataMap().get(getAvatar().getSkillDepotId());
        if (!(skillDepot == null || skillDepot.getAbilities() == null)) {
            IntListIterator it3 = skillDepot.getAbilities().iterator();
            while (it3.hasNext()) {
                embryoId++;
                abilityControlBlock.addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.newBuilder().setAbilityId(embryoId).setAbilityNameHash(it3.next().intValue()).setAbilityOverrideNameHash(GameConstants.DEFAULT_ABILITY_NAME).build());
            }
        }
        if (getAvatar().getExtraAbilityEmbryos().size() > 0) {
            for (String skill : getAvatar().getExtraAbilityEmbryos()) {
                embryoId++;
                abilityControlBlock.addAbilityEmbryoList(AbilityEmbryoOuterClass.AbilityEmbryo.newBuilder().setAbilityId(embryoId).setAbilityNameHash(Utils.abilityHash(skill)).setAbilityOverrideNameHash(GameConstants.DEFAULT_ABILITY_NAME).build());
            }
        }
        return abilityControlBlock.build();
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public void move(Position newPosition, Position rotation) {
        PlayerMoveEvent event = new PlayerMoveEvent(getPlayer(), PlayerMoveEvent.MoveType.PLAYER, getPosition(), newPosition);
        event.call();
        move(event.getDestination(), rotation);
    }
}
