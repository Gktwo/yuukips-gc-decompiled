package emu.grasscutter.game.managers.energy;

import com.google.protobuf.InvalidProtocolBufferException;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.MonsterData;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.EntityClientGadget;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.MonsterType;
import emu.grasscutter.game.props.WeaponType;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityActionGenerateElemBallOuterClass;
import emu.grasscutter.net.proto.AbilityIdentifierOuterClass;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import emu.grasscutter.net.proto.ChangeEnergyReasonOuterClass;
import emu.grasscutter.net.proto.EvtBeingHitInfoOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.utils.Position;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.objects.Object2IntMap;
import p014it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/energy/EnergyManager.class */
public class EnergyManager extends BasePlayerManager {
    private final Object2IntMap<EntityAvatar> avatarNormalProbabilities = new Object2IntOpenHashMap();
    private boolean energyUsage = Configuration.GAME_OPTIONS.energyUsage;
    private static final Int2ObjectMap<List<EnergyDropInfo>> energyDropData = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<List<SkillParticleGenerationInfo>> skillParticleGenerationData = new Int2ObjectOpenHashMap();

    public EnergyManager(Player player) {
        super(player);
    }

    public static void initialize() {
        try {
            DataLoader.loadList("EnergyDrop.json", EnergyDropEntry.class).forEach(entry -> {
                energyDropData.put(entry.getDropId(), (int) entry.getDropList());
            });
            Grasscutter.getLogger().debug("Energy drop data successfully loaded.");
        } catch (Exception ex) {
            Grasscutter.getLogger().error("Unable to load energy drop data.", (Throwable) ex);
        }
        try {
            DataLoader.loadList("SkillParticleGeneration.json", SkillParticleGenerationEntry.class).forEach(entry -> {
                skillParticleGenerationData.put(entry.getAvatarId(), (int) entry.getAmountList());
            });
            Grasscutter.getLogger().debug("Skill particle generation data successfully loaded.");
        } catch (Exception ex2) {
            Grasscutter.getLogger().error("Unable to load skill particle generation data data.", (Throwable) ex2);
        }
    }

    private int getBallCountForAvatar(int avatarId) {
        int count = 2;
        if (skillParticleGenerationData.containsKey(avatarId)) {
            int roll = ThreadLocalRandom.current().nextInt(0, 100);
            int percentageStack = 0;
            Iterator<SkillParticleGenerationInfo> it = skillParticleGenerationData.get(avatarId).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SkillParticleGenerationInfo info = it.next();
                percentageStack += info.getChance();
                if (roll < percentageStack) {
                    count = info.getValue();
                    break;
                }
            }
        } else {
            Grasscutter.getLogger().warn("No particle generation data for avatarId {} found.", Integer.valueOf(avatarId));
        }
        return count;
    }

    private int getBallIdForElement(ElementType element) {
        if (element == null) {
            return 2024;
        }
        switch (element) {
            case Fire:
                return 2017;
            case Water:
                return 2018;
            case Grass:
                return PacketOpcodes.TakeAsterSpecialRewardReq;
            case Electric:
                return 2020;
            case Wind:
                return PacketOpcodes.TreasureMapMpChallengeNotify;
            case Ice:
                return PacketOpcodes.EffigyChallengeResultNotify;
            case Rock:
                return PacketOpcodes.AsterLargeInfoNotify;
            default:
                return 2024;
        }
    }

    public void handleGenerateElemBall(AbilityInvokeEntryOuterClass.AbilityInvokeEntry invoke) throws InvalidProtocolBufferException {
        Avatar avatar;
        AbilityActionGenerateElemBallOuterClass.AbilityActionGenerateElemBall action = AbilityActionGenerateElemBallOuterClass.AbilityActionGenerateElemBall.parseFrom(invoke.getAbilityData());
        if (action != null) {
            int itemId = 2024;
            int amount = 2;
            Optional<EntityAvatar> avatarEntity = getCastingAvatarEntityForEnergy(invoke.getEntityId());
            if (avatarEntity.isPresent() && (avatar = avatarEntity.get().getAvatar()) != null) {
                int avatarId = avatar.getAvatarId();
                AvatarSkillDepotData skillDepotData = avatar.getSkillDepot();
                amount = getBallCountForAvatar(avatarId);
                if (skillDepotData != null) {
                    itemId = getBallIdForElement(skillDepotData.getElementType());
                }
            }
            Position pos = new Position(action.getPos());
            for (int i = 0; i < amount; i++) {
                generateElemBall(itemId, pos, 1);
            }
        }
    }

    private void generateEnergyForNormalAndCharged(EntityAvatar avatar) {
        WeaponType weaponType = avatar.getAvatar().getAvatarData().getWeaponType();
        if (!this.avatarNormalProbabilities.containsKey(avatar)) {
            this.avatarNormalProbabilities.put((Object2IntMap<EntityAvatar>) avatar, weaponType.getEnergyGainInitialProbability());
        }
        int currentProbability = this.avatarNormalProbabilities.getInt(avatar);
        if (ThreadLocalRandom.current().nextInt(0, 100) < currentProbability) {
            avatar.addEnergy(1.0f, PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_ABILITY, true);
            this.avatarNormalProbabilities.put((Object2IntMap<EntityAvatar>) avatar, weaponType.getEnergyGainInitialProbability());
            return;
        }
        this.avatarNormalProbabilities.put((Object2IntMap<EntityAvatar>) avatar, currentProbability + weaponType.getEnergyGainIncreaseProbability());
    }

    public void handleAttackHit(EvtBeingHitInfoOuterClass.EvtBeingHitInfo hitInfo) {
        AttackResultOuterClass.AttackResult attackRes = hitInfo.getAttackResult();
        Optional<EntityAvatar> attackerEntity = getCastingAvatarEntityForEnergy(attackRes.getAttackerId());
        if (!attackerEntity.isEmpty() && this.player.getTeamManager().getCurrentAvatarEntity().getId() == attackerEntity.get().getId()) {
            GameEntity targetEntity = this.player.getScene().getEntityById(attackRes.getDefenseId());
            if (targetEntity instanceof EntityMonster) {
                MonsterType targetType = ((EntityMonster) targetEntity).getMonsterData().getType();
                if ((targetType == MonsterType.MONSTER_ORDINARY || targetType == MonsterType.MONSTER_BOSS) && attackRes.getAbilityIdentifier() == AbilityIdentifierOuterClass.AbilityIdentifier.getDefaultInstance()) {
                    generateEnergyForNormalAndCharged(attackerEntity.get());
                }
            }
        }
    }

    private void handleBurstCast(Avatar avatar, int skillId) {
        if (Configuration.GAME_OPTIONS.energyUsage && this.energyUsage && avatar.getSkillDepot() != null && skillId == avatar.getSkillDepot().getEnergySkill()) {
            avatar.getAsEntity().clearEnergy(ChangeEnergyReasonOuterClass.ChangeEnergyReason.CHANGE_ENERGY_REASON_SKILL_START);
        }
    }

    public void handleEvtDoSkillSuccNotify(GameSession session, int skillId, int casterId) {
        Optional<EntityAvatar> caster = this.player.getTeamManager().getActiveTeam().stream().filter(character -> {
            return character.getId() == casterId;
        }).findFirst();
        if (!caster.isEmpty()) {
            handleBurstCast(caster.get().getAvatar(), skillId);
        }
    }

    private void generateElemBallDrops(EntityMonster monster, int dropId) {
        if (!energyDropData.containsKey(dropId)) {
            Grasscutter.getLogger().warn("generateElemBallDrops: No drop data for dropId {} found.", Integer.valueOf(dropId));
            return;
        }
        Grasscutter.getLogger().debug("generateElemBallDrops: {} found.", Integer.valueOf(dropId));
        for (EnergyDropInfo info : energyDropData.get(dropId)) {
            generateElemBall(info.getBallId(), monster.getPosition(), info.getCount());
        }
    }

    public void handleMonsterEnergyDrop(EntityMonster monster, float hpBeforeDamage, float hpAfterDamage) {
        MonsterType type = monster.getMonsterData().getType();
        if (type == MonsterType.MONSTER_ORDINARY || type == MonsterType.MONSTER_BOSS) {
            float maxHp = monster.getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
            float thresholdBefore = hpBeforeDamage / maxHp;
            float thresholdAfter = hpAfterDamage / maxHp;
            for (MonsterData.HpDrops drop : monster.getMonsterData().getHpDrops()) {
                if (drop.getDropId() != 0) {
                    float threshold = ((float) drop.getHpPercent()) / 100.0f;
                    if (threshold < thresholdBefore && threshold >= thresholdAfter) {
                        generateElemBallDrops(monster, drop.getDropId());
                    }
                }
            }
            if (hpAfterDamage <= 0.0f && monster.getMonsterData().getKillDropId() != 0) {
                generateElemBallDrops(monster, monster.getMonsterData().getKillDropId());
            }
        }
    }

    private void generateElemBall(int ballId, Position position, int count) {
        ItemData itemData = GameData.getItemDataMap().get(ballId);
        if (itemData != null) {
            getPlayer().getScene().addEntity(new EntityItem(getPlayer().getScene(), getPlayer(), itemData, position, count));
        }
    }

    private Optional<EntityAvatar> getCastingAvatarEntityForEnergy(int invokeEntityId) {
        int avatarEntityId;
        GameEntity entity = this.player.getScene().getEntityById(invokeEntityId);
        if (!(entity instanceof EntityClientGadget)) {
            avatarEntityId = invokeEntityId;
        } else {
            avatarEntityId = ((EntityClientGadget) entity).getOriginalOwnerEntityId();
        }
        return this.player.getTeamManager().getActiveTeam().stream().filter(character -> {
            return character.getId() == avatarEntityId;
        }).findFirst();
    }

    public boolean getEnergyUsage() {
        return this.energyUsage;
    }

    public boolean refillEntityAvatarEnergy() {
        try {
            EntityAvatar activeEntity = this.player.getTeamManager().getCurrentAvatarEntity();
            return activeEntity.addEnergy(activeEntity.getAvatar().getSkillDepot().getEnergySkillData().getCostElemVal());
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error refillEntityAvatarEnergy: ", (Throwable) e);
            return false;
        }
    }

    public void refillTeamEnergy(PropChangeReasonOuterClass.PropChangeReason changeReason, boolean isFlat) {
        for (EntityAvatar entityAvatar : this.player.getTeamManager().getActiveTeam()) {
            try {
                entityAvatar.addEnergy(entityAvatar.getAvatar().getSkillDepot().getEnergySkillData().getCostElemVal(), changeReason, isFlat);
            } catch (Exception e) {
                Grasscutter.getLogger().error("Error refillTeamEnergy: ", (Throwable) e);
            }
        }
    }

    public void setEnergyUsage(boolean energyUsage) {
        this.energyUsage = energyUsage;
        if (!energyUsage) {
            refillTeamEnergy(PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_GM, true);
        }
    }
}
