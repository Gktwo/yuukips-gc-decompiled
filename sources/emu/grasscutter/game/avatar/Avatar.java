package emu.grasscutter.game.avatar;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.PrePersist;
import dev.morphia.annotations.Transient;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.OpenConfigEntry;
import emu.grasscutter.data.common.FightPropData;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.AvatarPromoteData;
import emu.grasscutter.data.excels.AvatarSkillData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.data.excels.AvatarTalentData;
import emu.grasscutter.data.excels.EquipAffixData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.ProudSkillData;
import emu.grasscutter.data.excels.ReliquaryAffixData;
import emu.grasscutter.data.excels.ReliquaryLevelData;
import emu.grasscutter.data.excels.ReliquaryMainPropData;
import emu.grasscutter.data.excels.ReliquarySetData;
import emu.grasscutter.data.excels.WeaponCurveData;
import emu.grasscutter.data.excels.WeaponPromoteData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.inventory.EquipType;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.props.FetterState;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.proto.AvatarFetterInfoOuterClass;
import emu.grasscutter.net.proto.AvatarInfoOuterClass;
import emu.grasscutter.net.proto.AvatarSkillInfoOuterClass;
import emu.grasscutter.net.proto.FetterDataOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.ShowAvatarInfoOuterClass;
import emu.grasscutter.net.proto.ShowEquipOuterClass;
import emu.grasscutter.server.packet.send.PacketAbilityChangeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarEquipChangeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarFightPropNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSkillChangeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSkillDepotChangeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSkillInfoNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSkillMaxChargeCountNotify;
import emu.grasscutter.server.packet.send.PacketAvatarSkillUpgradeRsp;
import emu.grasscutter.server.packet.send.PacketAvatarUnlockTalentNotify;
import emu.grasscutter.server.packet.send.PacketProudSkillExtraLevelNotify;
import emu.grasscutter.server.packet.send.PacketUnlockAvatarTalentRsp;
import emu.grasscutter.utils.ProtoHelper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import org.bson.types.ObjectId;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@Entity(value = "avatars", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/avatar/Avatar.class */
public class Avatar {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f564id;
    @Indexed
    private int ownerId;
    @Transient
    private Player owner;
    @Transient
    private AvatarData data;
    @Transient
    private AvatarSkillDepotData skillDepot;
    @Transient
    private long guid;
    private int avatarId;
    private int level;
    private int exp;
    private int promoteLevel;
    private int satiation;
    private int satiationPenalty;
    private float currentHp;
    private float currentEnergy;
    @Transient
    private final Int2ObjectMap<GameItem> equips;
    @Transient
    private final Int2FloatOpenHashMap fightProperties;
    @Transient
    private final Int2FloatOpenHashMap fightPropOverrides;
    @Transient
    private Set<String> extraAbilityEmbryos;
    private List<Integer> fetters;
    private Map<Integer, Integer> skillLevelMap;
    @Transient
    private Map<Integer, Integer> skillExtraChargeMap;
    @Transient
    private Map<Integer, Integer> proudSkillBonusMap;
    private int skillDepotId;
    private Set<Integer> talentIdList;
    private Set<Integer> proudSkillList;
    private int flyCloak;
    private int costume;
    private int bornTime;
    private int fetterLevel;
    private int fetterExp;
    private int nameCardRewardId;
    private int nameCardId;

    public int getOwnerId() {
        return this.ownerId;
    }

    public AvatarData getData() {
        return this.data;
    }

    public AvatarSkillDepotData getSkillDepot() {
        return this.skillDepot;
    }

    public long getGuid() {
        return this.guid;
    }

    public int getAvatarId() {
        return this.avatarId;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return this.exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getPromoteLevel() {
        return this.promoteLevel;
    }

    public void setPromoteLevel(int promoteLevel) {
        this.promoteLevel = promoteLevel;
    }

    public int getSatiation() {
        return this.satiation;
    }

    public void setSatiation(int satiation) {
        this.satiation = satiation;
    }

    public int getSatiationPenalty() {
        return this.satiationPenalty;
    }

    public void setSatiationPenalty(int satiationPenalty) {
        this.satiationPenalty = satiationPenalty;
    }

    public float getCurrentHp() {
        return this.currentHp;
    }

    public void setCurrentHp(float currentHp) {
        this.currentHp = currentHp;
    }

    public Int2ObjectMap<GameItem> getEquips() {
        return this.equips;
    }

    public Int2FloatOpenHashMap getFightProperties() {
        return this.fightProperties;
    }

    public Int2FloatOpenHashMap getFightPropOverrides() {
        return this.fightPropOverrides;
    }

    public Set<String> getExtraAbilityEmbryos() {
        return this.extraAbilityEmbryos;
    }

    public Map<Integer, Integer> getSkillExtraChargeMap() {
        return this.skillExtraChargeMap;
    }

    public int getSkillDepotId() {
        return this.skillDepotId;
    }

    public Set<Integer> getProudSkillList() {
        return this.proudSkillList;
    }

    public int getFlyCloak() {
        return this.flyCloak;
    }

    public void setFlyCloak(int flyCloak) {
        this.flyCloak = flyCloak;
    }

    public int getCostume() {
        return this.costume;
    }

    public void setCostume(int costume) {
        this.costume = costume;
    }

    public int getBornTime() {
        return this.bornTime;
    }

    public int getFetterLevel() {
        return this.fetterLevel;
    }

    public void setFetterLevel(int fetterLevel) {
        this.fetterLevel = fetterLevel;
    }

    public int getFetterExp() {
        return this.fetterExp;
    }

    public void setFetterExp(int fetterExp) {
        this.fetterExp = fetterExp;
    }

    public int getNameCardRewardId() {
        return this.nameCardRewardId;
    }

    public void setNameCardRewardId(int nameCardRewardId) {
        this.nameCardRewardId = nameCardRewardId;
    }

    public int getNameCardId() {
        return this.nameCardId;
    }

    public void setNameCardId(int nameCardId) {
        this.nameCardId = nameCardId;
    }

    @Deprecated
    public Avatar() {
        this.level = 1;
        this.skillLevelMap = new Int2IntArrayMap(7);
        this.skillExtraChargeMap = new Int2IntArrayMap(2);
        this.proudSkillBonusMap = new Int2IntArrayMap(2);
        this.fetterLevel = 1;
        this.equips = new Int2ObjectOpenHashMap();
        this.fightProperties = new Int2FloatOpenHashMap();
        this.fightPropOverrides = new Int2FloatOpenHashMap();
        this.extraAbilityEmbryos = new HashSet();
        this.fetters = new ArrayList();
    }

    public Avatar(int avatarId) {
        this(GameData.getAvatarDataMap().get(avatarId));
    }

    public Avatar(AvatarData data) {
        this();
        this.avatarId = data.getId();
        this.nameCardRewardId = data.getNameCardRewardId();
        this.nameCardId = data.getNameCardId();
        this.data = data;
        this.bornTime = (int) (System.currentTimeMillis() / 1000);
        this.flyCloak = 140001;
        this.talentIdList = new HashSet();
        this.proudSkillList = new HashSet();
        Stream.of((Object[]) FightProperty.values()).map((v0) -> {
            return v0.getId();
        }).filter(id -> {
            return id.intValue() > 0 && id.intValue() < 3000;
        }).forEach(id -> {
            setFightProperty(id.intValue(), 0.0f);
        });
        setSkillDepotData(data.getSkillDepot(), false);
        recalcStats();
        this.currentHp = getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
        setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, this.currentHp);
        this.currentEnergy = 0.0f;
        onLoad();
    }

    public Player getPlayer() {
        return this.owner;
    }

    public ObjectId getObjectId() {
        return this.f564id;
    }

    public AvatarData getAvatarData() {
        return this.data;
    }

    /* access modifiers changed from: protected */
    public void setAvatarData(AvatarData data) {
        if (this.data == null) {
            this.data = data;
        }
    }

    public void setOwner(Player player) {
        this.owner = player;
        this.ownerId = player.getUid();
        this.guid = player.getNextGameGuid();
    }

    public static int getMinPromoteLevel(int level) {
        if (level > 80) {
            return 6;
        }
        if (level > 70) {
            return 5;
        }
        if (level > 60) {
            return 4;
        }
        if (level > 50) {
            return 3;
        }
        if (level > 40) {
            return 2;
        }
        if (level > 20) {
            return 1;
        }
        return 0;
    }

    public boolean addSatiation(float value) {
        if (this.satiation >= 100) {
            return false;
        }
        this.satiation = (int) (((float) this.satiation) + value);
        return true;
    }

    public GameItem getEquipBySlot(EquipType slot) {
        return getEquips().get(slot.getValue());
    }

    private GameItem getEquipBySlot(int slotId) {
        return getEquips().get(slotId);
    }

    public GameItem getWeapon() {
        return getEquipBySlot(EquipType.EQUIP_WEAPON);
    }

    /* access modifiers changed from: protected */
    public void setSkillDepot(AvatarSkillDepotData skillDepot) {
        if (this.skillDepot == null) {
            this.skillDepot = skillDepot;
        }
    }

    public boolean changeElement(@Nonnull ElementType elementTypeToChange) {
        AvatarSkillDepotData skillDepot;
        List<Integer> candSkillDepotIdsList = this.data.getCandSkillDepotIds();
        int candSkillDepotIndex = elementTypeToChange.getDepotIndex();
        if (candSkillDepotIdsList == null || candSkillDepotIndex >= candSkillDepotIdsList.size() || (skillDepot = GameData.getAvatarSkillDepotDataMap().get(candSkillDepotIdsList.get(candSkillDepotIndex).intValue())) == null || skillDepot.getId() == this.skillDepotId) {
            return false;
        }
        setSkillDepotData(skillDepot, true);
        return true;
    }

    public void setSkillDepotData(AvatarSkillDepotData skillDepot, boolean notifyChange) {
        if (skillDepot == null) {
            Grasscutter.getLogger().error("ID null");
            skillDepot = GameData.getAvatarSkillDepotDataMap().get((int) RetcodeOuterClass.Retcode.RET_GOODS_BUY_NUM_NOT_ENOUGH_VALUE);
        }
        this.skillDepotId = skillDepot.getId();
        this.skillDepot = skillDepot;
        this.skillDepot.getSkillsAndEnergySkill().forEach(skillId -> {
            this.skillLevelMap.putIfAbsent(Integer.valueOf(skillId), 1);
        });
        this.proudSkillList.clear();
        skillDepot.getInherentProudSkillOpens().stream().filter(openData -> {
            return openData.getProudSkillGroupId() > 0;
        }).filter(openData -> {
            return openData.getNeedAvatarPromoteLevel() <= getPromoteLevel();
        }).mapToInt(openData -> {
            return (openData.getProudSkillGroupId() * 100) + 1;
        }).filter(proudSkillId -> {
            return GameData.getProudSkillDataMap().containsKey(proudSkillId);
        }).forEach(proudSkillId -> {
            this.proudSkillList.add(Integer.valueOf(proudSkillId));
        });
        recalcStats(notifyChange);
        if (notifyChange) {
            this.owner.sendPacket(new PacketAvatarSkillDepotChangeNotify(this));
        }
    }

    public void setFetterList(List<Integer> fetterList) {
        this.fetters = fetterList;
    }

    public List<Integer> getFetterList() {
        return this.fetters;
    }

    public void setCurrentEnergy() {
        if (Configuration.GAME_OPTIONS.energyUsage) {
            setCurrentEnergy(this.currentEnergy);
        }
    }

    public void setCurrentEnergy(float currentEnergy) {
        AvatarSkillDepotData depot = this.skillDepot;
        if (depot != null && depot.getEnergySkillData() != null) {
            ElementType element = depot.getElementType();
            float maxEnergy = depot.getEnergySkillData().getCostElemVal();
            setFightProperty(element.getMaxEnergyProp(), maxEnergy);
            setFightProperty(element.getCurEnergyProp(), Configuration.GAME_OPTIONS.energyUsage ? currentEnergy : maxEnergy);
        }
    }

    public void setCurrentEnergy(FightProperty curEnergyProp, float currentEnergy) {
        if (Configuration.GAME_OPTIONS.energyUsage) {
            setFightProperty(curEnergyProp, currentEnergy);
            this.currentEnergy = currentEnergy;
            save();
        }
    }

    public void setFightProperty(FightProperty prop, float value) {
        getFightProperties().put(prop.getId(), value);
    }

    private void setFightProperty(int id, float value) {
        getFightProperties().put(id, value);
    }

    public void addFightProperty(FightProperty prop, float value) {
        getFightProperties().put(prop.getId(), getFightProperty(prop) + value);
    }

    public float getFightProperty(FightProperty prop) {
        return getFightProperties().getOrDefault(prop.getId(), 0.0f);
    }

    public Map<Integer, Integer> getSkillLevelMap() {
        Int2IntOpenHashMap map = new Int2IntOpenHashMap();
        this.skillDepot.getSkillsAndEnergySkill().forEach(skillId -> {
            map.put(map, this.skillLevelMap.putIfAbsent(Integer.valueOf(map), 1).intValue());
        });
        return map;
    }

    public Map<Integer, Integer> getProudSkillBonusMap() {
        Int2IntArrayMap map = new Int2IntArrayMap();
        this.skillDepot.getSkillsAndEnergySkill().forEach(skillId -> {
            AvatarSkillData skillData = GameData.getAvatarSkillDataMap().get(map);
            if (skillData != null) {
                int proudSkillGroupId = skillData.getProudSkillGroupId();
                int bonus = this.proudSkillBonusMap.getOrDefault(Integer.valueOf(proudSkillGroupId), 0).intValue();
                int maxLevel = GameData.getProudSkillGroupMaxLevel(proudSkillGroupId);
                int curLevel = this.skillLevelMap.getOrDefault(Integer.valueOf(map), 0).intValue();
                if (maxLevel > 0) {
                    bonus = Math.min(bonus, maxLevel - curLevel);
                }
                map.put(proudSkillGroupId, bonus);
            }
        });
        return map;
    }

    public IntSet getTalentIdList() {
        IntOpenHashSet talents = new IntOpenHashSet(getSkillDepot().getTalents());
        talents.removeIf(id -> {
            return !this.talentIdList.contains(Integer.valueOf(id));
        });
        return talents;
    }

    public int getCoreProudSkillLevel() {
        IntOpenHashSet lockedTalents = new IntOpenHashSet(getSkillDepot().getTalents());
        lockedTalents.removeAll((IntCollection) getTalentIdList());
        return lockedTalents.intStream().map(i -> {
            return i % 10;
        }).min().orElse(7) - 1;
    }

    public boolean equipItem(GameItem item, boolean shouldRecalc) {
        EquipType itemEquipType = item.getItemData().getEquipType();
        if (itemEquipType == EquipType.EQUIP_NONE) {
            return false;
        }
        Avatar otherAvatar = getPlayer().getAvatars().getAvatarById(item.getEquipCharacter());
        if (otherAvatar != null) {
            if (otherAvatar.unequipItem(item.getItemData().getEquipType())) {
                getPlayer().sendPacket(new PacketAvatarEquipChangeNotify(otherAvatar, item.getItemData().getEquipType()));
            }
            if (getEquips().containsKey(itemEquipType.getValue())) {
                otherAvatar.equipItem(getEquipBySlot(itemEquipType), false);
            }
            otherAvatar.recalcStats();
        } else if (getEquips().containsKey(itemEquipType.getValue())) {
            unequipItem(itemEquipType);
        }
        getEquips().put(itemEquipType.getValue(), (int) item);
        if (itemEquipType == EquipType.EQUIP_WEAPON && getPlayer().getWorld() != null) {
            item.setWeaponEntityId(getPlayer().getWorld().getNextEntityId(EntityIdType.WEAPON));
        }
        item.setEquipCharacter(getAvatarId());
        item.save();
        if (getPlayer().hasSentLoginPackets()) {
            getPlayer().sendPacket(new PacketAvatarEquipChangeNotify(this, item));
        }
        if (!shouldRecalc) {
            return true;
        }
        recalcStats();
        return true;
    }

    public boolean unequipItem(EquipType slot) {
        GameItem item = getEquips().remove(slot.getValue());
        if (item == null) {
            return false;
        }
        item.setEquipCharacter(0);
        item.save();
        return true;
    }

    public void recalcStats() {
        recalcStats(false);
    }

    public void recalcStats(boolean forceSendAbilityChange) {
        float hpPercent;
        float currentEnergy;
        EquipAffixData affix;
        ReliquaryLevelData levelData;
        AvatarData data = getAvatarData();
        AvatarPromoteData promoteData = GameData.getAvatarPromoteData(data.getAvatarPromoteId(), getPromoteLevel());
        Int2IntOpenHashMap setMap = new Int2IntOpenHashMap();
        Set<String> prevExtraAbilityEmbryos = getExtraAbilityEmbryos();
        this.extraAbilityEmbryos = new HashSet();
        setFetterList(data.getFetters());
        setNameCardRewardId(data.getNameCardRewardId());
        setNameCardId(data.getNameCardId());
        if (getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) <= 0.0f) {
            hpPercent = 1.0f;
        } else {
            hpPercent = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP) / getFightProperty(FightProperty.FIGHT_PROP_MAX_HP);
        }
        if (getSkillDepot() != null) {
            currentEnergy = getFightProperty(getSkillDepot().getElementType().getCurEnergyProp());
        } else {
            currentEnergy = 0.0f;
        }
        getFightProperties().clear();
        setFightProperty(FightProperty.FIGHT_PROP_BASE_HP, data.getBaseHp(getLevel()));
        setFightProperty(FightProperty.FIGHT_PROP_BASE_ATTACK, data.getBaseAttack(getLevel()));
        setFightProperty(FightProperty.FIGHT_PROP_BASE_DEFENSE, data.getBaseDefense(getLevel()));
        setFightProperty(FightProperty.FIGHT_PROP_CRITICAL, data.getBaseCritical());
        setFightProperty(FightProperty.FIGHT_PROP_CRITICAL_HURT, data.getBaseCriticalHurt());
        setFightProperty(FightProperty.FIGHT_PROP_CHARGE_EFFICIENCY, 1.0f);
        if (promoteData != null) {
            FightPropData[] addProps = promoteData.getAddProps();
            for (FightPropData fightPropData : addProps) {
                addFightProperty(fightPropData.getProp(), fightPropData.getValue());
            }
        }
        setCurrentEnergy(currentEnergy);
        for (int slotId = 1; slotId <= 5; slotId++) {
            GameItem equip = getEquipBySlot(slotId);
            if (equip != null) {
                ReliquaryMainPropData mainPropData = GameData.getReliquaryMainPropDataMap().get(equip.getMainPropId());
                if (!(mainPropData == null || (levelData = GameData.getRelicLevelData(equip.getItemData().getRankLevel(), equip.getLevel())) == null)) {
                    addFightProperty(mainPropData.getFightProp(), levelData.getPropValue(mainPropData.getFightProp()));
                }
                for (Integer num : equip.getAppendPropIdList()) {
                    ReliquaryAffixData affixData = GameData.getReliquaryAffixDataMap().get(num.intValue());
                    if (affixData != null) {
                        addFightProperty(affixData.getFightProp(), affixData.getPropValue());
                    }
                }
                if (equip.getItemData().getSetId() > 0) {
                    setMap.addTo(equip.getItemData().getSetId(), 1);
                }
            }
        }
        setMap.forEach(setId, amount -> {
            ReliquarySetData setData = GameData.getReliquarySetDataMap().get(setId.intValue());
            if (setData != null) {
                int[] setNeedNum = setData.getSetNeedNum();
                int setIndex = 0;
                while (setIndex < setNeedNum.length && amount.intValue() >= setNeedNum[setIndex]) {
                    EquipAffixData affix2 = GameData.getEquipAffixDataMap().get((setData.getEquipAffixId() * 10) + setIndex);
                    if (affix2 != null) {
                        FightPropData[] addProps2 = affix2.getAddProps();
                        for (FightPropData prop : addProps2) {
                            addFightProperty(prop.getProp(), prop.getValue());
                        }
                        addToExtraAbilityEmbryos(affix2.getOpenConfig(), true);
                    }
                    setIndex++;
                }
            }
        });
        GameItem weapon = getWeapon();
        if (weapon != null) {
            WeaponCurveData curveData = GameData.getWeaponCurveDataMap().get(weapon.getLevel());
            if (curveData != null) {
                ItemData.WeaponProperty[] weaponProperties = weapon.getItemData().getWeaponProperties();
                for (ItemData.WeaponProperty weaponProperty : weaponProperties) {
                    addFightProperty(weaponProperty.getPropType(), weaponProperty.getInitValue() * curveData.getMultByProp(weaponProperty.getType()));
                }
            }
            WeaponPromoteData wepPromoteData = GameData.getWeaponPromoteData(weapon.getItemData().getWeaponPromoteId(), weapon.getPromoteLevel());
            if (wepPromoteData != null) {
                FightPropData[] addProps2 = wepPromoteData.getAddProps();
                for (FightPropData prop : addProps2) {
                    if (!(prop.getValue() == 0.0f || prop.getProp() == null)) {
                        addFightProperty(prop.getProp(), prop.getValue());
                    }
                }
            }
            if (weapon.getAffixes() != null && weapon.getAffixes().size() > 0) {
                for (Integer num2 : weapon.getAffixes()) {
                    int af = num2.intValue();
                    if (!(af == 0 || (affix = GameData.getEquipAffixDataMap().get((af * 10) + weapon.getRefinement())) == null)) {
                        FightPropData[] addProps3 = affix.getAddProps();
                        for (FightPropData prop2 : addProps3) {
                            addFightProperty(prop2.getProp(), prop2.getValue());
                        }
                        addToExtraAbilityEmbryos(affix.getOpenConfig(), true);
                    }
                }
            }
        }
        AvatarSkillDepotData skillDepot = GameData.getAvatarSkillDepotDataMap().get(getSkillDepotId());
        getProudSkillList().clear();
        if (!(skillDepot == null || skillDepot.getInherentProudSkillOpens() == null)) {
            for (AvatarSkillDepotData.InherentProudSkillOpens openData : skillDepot.getInherentProudSkillOpens()) {
                if (openData.getProudSkillGroupId() != 0 && openData.getNeedAvatarPromoteLevel() <= getPromoteLevel()) {
                    int proudSkillId = (openData.getProudSkillGroupId() * 100) + 1;
                    if (GameData.getProudSkillDataMap().containsKey(proudSkillId)) {
                        getProudSkillList().add(Integer.valueOf(proudSkillId));
                    }
                }
            }
        }
        for (Integer num3 : getProudSkillList()) {
            ProudSkillData proudSkillData = GameData.getProudSkillDataMap().get(num3.intValue());
            if (proudSkillData != null) {
                FightPropData[] addProps4 = proudSkillData.getAddProps();
                for (FightPropData prop3 : addProps4) {
                    addFightProperty(prop3.getProp(), prop3.getValue());
                }
                addToExtraAbilityEmbryos(proudSkillData.getOpenConfig());
            }
        }
        IntStream intStream = getTalentIdList().intStream();
        Int2ObjectMap<AvatarTalentData> avatarTalentDataMap = GameData.getAvatarTalentDataMap();
        Objects.requireNonNull(avatarTalentDataMap);
        intStream.mapToObj(this::get).filter((v0) -> {
            return Objects.nonNull(v0);
        }).map((v0) -> {
            return v0.getOpenConfig();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).forEach(this::addToExtraAbilityEmbryos);
        FightProperty.forEachCompoundProperty(c -> {
            setFightProperty(c.getResult(), getFightProperty(c.getFlat()) + (getFightProperty(c.getBase()) * (1.0f + getFightProperty(c.getPercent()))));
        });
        this.fightProperties.putAll(this.fightPropOverrides);
        setFightProperty(FightProperty.FIGHT_PROP_CUR_HP, getFightProperty(FightProperty.FIGHT_PROP_MAX_HP) * hpPercent);
        if (getPlayer() != null && getPlayer().hasSentLoginPackets()) {
            getPlayer().sendPacket(new PacketAvatarFightPropNotify(this));
            EntityAvatar entity = getAsEntity();
            if (entity == null) {
                return;
            }
            if (!getExtraAbilityEmbryos().equals(prevExtraAbilityEmbryos) || forceSendAbilityChange) {
                getPlayer().sendPacket(new PacketAbilityChangeNotify(entity));
            }
        }
    }

    public void addToExtraAbilityEmbryos(String openConfig) {
        addToExtraAbilityEmbryos(openConfig, false);
    }

    public void addToExtraAbilityEmbryos(String openConfig, boolean forceAdd) {
        if (openConfig != null && openConfig.length() != 0) {
            OpenConfigEntry entry = GameData.getOpenConfigEntries().get(openConfig);
            if (entry == null) {
                if (forceAdd) {
                    getExtraAbilityEmbryos().add(openConfig);
                }
            } else if (entry.getAddAbilities() != null) {
                for (String ability : entry.getAddAbilities()) {
                    getExtraAbilityEmbryos().add(ability);
                }
            }
        }
    }

    public void calcConstellation(OpenConfigEntry entry, boolean notifyClient) {
        if (entry != null) {
            if (getPlayer() == null) {
                notifyClient = false;
            }
            if (calcConstellationExtraLevels(entry) && notifyClient) {
                getPlayer().sendPacket(new PacketProudSkillExtraLevelNotify(this, entry.getExtraTalentIndex()));
            }
            if (calcConstellationExtraCharges(entry) && notifyClient) {
                Stream.of((Object[]) entry.getSkillPointModifiers()).mapToInt((v0) -> {
                    return v0.getSkillId();
                }).forEach(skillId -> {
                    getPlayer().sendPacket(new PacketAvatarSkillMaxChargeCountNotify(this, skillId, getSkillExtraChargeMap().getOrDefault(Integer.valueOf(skillId), 0).intValue()));
                });
            }
        }
    }

    public void recalcConstellations() {
        this.proudSkillBonusMap.clear();
        this.skillExtraChargeMap.clear();
        if (this.data != null && this.skillDepot != null) {
            IntStream intStream = getTalentIdList().intStream();
            Int2ObjectMap<AvatarTalentData> avatarTalentDataMap = GameData.getAvatarTalentDataMap();
            Objects.requireNonNull(avatarTalentDataMap);
            Stream filter = intStream.mapToObj(this::get).filter((v0) -> {
                return Objects.nonNull(v0);
            }).map((v0) -> {
                return v0.getOpenConfig();
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).filter(openConfig -> {
                return openConfig.length() > 0;
            });
            Map<String, OpenConfigEntry> openConfigEntries = GameData.getOpenConfigEntries();
            Objects.requireNonNull(openConfigEntries);
            filter.map((v1) -> {
                return r1.get(v1);
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).forEach(e -> {
                calcConstellation(e, false);
            });
        }
    }

    private boolean calcConstellationExtraCharges(OpenConfigEntry entry) {
        OpenConfigEntry.SkillPointModifier[] skillPointModifiers = entry.getSkillPointModifiers();
        if (skillPointModifiers == null) {
            return false;
        }
        for (OpenConfigEntry.SkillPointModifier mod : skillPointModifiers) {
            AvatarSkillData skillData = GameData.getAvatarSkillDataMap().get(mod.getSkillId());
            if (skillData != null) {
                getSkillExtraChargeMap().put(Integer.valueOf(mod.getSkillId()), Integer.valueOf(skillData.getMaxChargeNum() + mod.getDelta()));
            }
        }
        return true;
    }

    private boolean calcConstellationExtraLevels(OpenConfigEntry entry) {
        int skillId;
        AvatarSkillData skillData;
        switch (entry.getExtraTalentIndex()) {
            case 2:
                if (this.skillDepot.getSkills().size() < 2) {
                    skillId = 0;
                    break;
                } else {
                    skillId = this.skillDepot.getSkills().get(1).intValue();
                    break;
                }
            case 9:
                skillId = this.skillDepot.getEnergySkill();
                break;
            default:
                skillId = 0;
                break;
        }
        if (skillId == 0 || (skillData = GameData.getAvatarSkillDataMap().get(skillId)) == null) {
            return false;
        }
        addProudSkillLevelBonus(skillData.getProudSkillGroupId(), 3);
        return true;
    }

    private int addProudSkillLevelBonus(int proudSkillGroupId, int bonus) {
        return this.proudSkillBonusMap.compute(Integer.valueOf(proudSkillGroupId), k, v -> {
            return Integer.valueOf(v == null ? bonus : v.intValue() + bonus);
        }).intValue();
    }

    public boolean upgradeSkill(int skillId) {
        int newLevel;
        ProudSkillData proudSkill;
        AvatarSkillData skillData = GameData.getAvatarSkillDataMap().get(skillId);
        if (skillData == null || (newLevel = this.skillLevelMap.getOrDefault(Integer.valueOf(skillId), 0).intValue() + 1) > 10 || (proudSkill = GameData.getProudSkillDataMap().get((skillData.getProudSkillGroupId() * 100) + newLevel)) == null || getPromoteLevel() < proudSkill.getBreakLevel() || !getPlayer().getInventory().payItems(proudSkill.getTotalCostItems())) {
            return false;
        }
        setSkillLevel(skillId, newLevel);
        return true;
    }

    public boolean setSkillLevel(int skillId, int level) {
        if (level < 0 || level > 15) {
            return false;
        }
        IntSet validLevels = GameData.getAvatarSkillLevels(skillId);
        if (validLevels != null && !validLevels.contains(level)) {
            return false;
        }
        int oldLevel = this.skillLevelMap.getOrDefault(Integer.valueOf(skillId), 0).intValue();
        this.skillLevelMap.put(Integer.valueOf(skillId), Integer.valueOf(level));
        save();
        Player player = getPlayer();
        if (player == null) {
            return true;
        }
        player.sendPacket(new PacketAvatarSkillChangeNotify(this, skillId, oldLevel, level));
        player.sendPacket(new PacketAvatarSkillUpgradeRsp(this, skillId, oldLevel, level));
        return true;
    }

    public boolean unlockConstellation() {
        return unlockConstellation(false);
    }

    public boolean unlockConstellation(boolean skipPayment) {
        try {
            int currentTalentLevel = getCoreProudSkillLevel();
            if (currentTalentLevel == -1) {
                return false;
            }
            return unlockConstellation(this.skillDepot.getTalents().get(currentTalentLevel).intValue(), skipPayment);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean unlockConstellation(int talentId) {
        return unlockConstellation(talentId, false);
    }

    public boolean unlockConstellation(int talentId, boolean skipPayment) {
        AvatarTalentData talentData = GameData.getAvatarTalentDataMap().get(talentId);
        if (talentData == null) {
            return false;
        }
        Player player = getPlayer();
        if (!skipPayment && player != null && !player.getInventory().payItem(talentData.getMainCostItemId(), 1)) {
            return false;
        }
        this.talentIdList.add(Integer.valueOf(talentData.getId()));
        if (player != null) {
            player.sendPacket(new PacketAvatarUnlockTalentNotify(this, talentId));
            player.sendPacket(new PacketUnlockAvatarTalentRsp(this, talentId));
        }
        calcConstellation(GameData.getOpenConfigEntries().get(talentData.getOpenConfig()), true);
        recalcStats(true);
        save();
        return true;
    }

    public void forceConstellationLevel(int level) {
        if (level <= 6) {
            if (level < 0) {
                this.talentIdList.clear();
                recalcStats();
                save();
                return;
            }
            this.talentIdList.removeAll(getTalentIdList());
            for (int i = 0; i < level; i++) {
                unlockConstellation(true);
            }
            recalcStats();
            save();
        }
    }

    public boolean sendSkillExtraChargeMap() {
        Map<Integer, Integer> map = getSkillExtraChargeMap();
        if (map.isEmpty()) {
            return false;
        }
        getPlayer().sendPacket(new PacketAvatarSkillInfoNotify(this.guid, new Int2IntArrayMap(map)));
        return true;
    }

    public EntityAvatar getAsEntity() {
        if (getPlayer() == null || getPlayer().getTeamManager() == null) {
            return null;
        }
        for (EntityAvatar entity : getPlayer().getTeamManager().getActiveTeam()) {
            if (entity.getAvatar() == this) {
                return entity;
            }
        }
        return null;
    }

    public int getEntityId() {
        EntityAvatar entity = getAsEntity();
        if (entity != null) {
            return entity.getId();
        }
        return 0;
    }

    public void save() {
        DatabaseHelper.saveAvatar(this);
    }

    public AvatarInfoOuterClass.AvatarInfo toProto() {
        int fetterLevel = getFetterLevel();
        AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder avatarFetter = AvatarFetterInfoOuterClass.AvatarFetterInfo.newBuilder().setExpLevel(fetterLevel);
        if (fetterLevel != 10) {
            avatarFetter.setExpNumber(getFetterExp());
        }
        if (this.fetters != null) {
            this.fetters.forEach(fetterId -> {
                avatarFetter.addFetterList(FetterDataOuterClass.FetterData.newBuilder().setFetterId(fetterId.intValue()).setFetterState(FetterState.FINISH.getValue()));
            });
        }
        if (getPlayer().getNameCardList().contains(Integer.valueOf(getNameCardId()))) {
            avatarFetter.addRewardedFetterLevelList(10);
        }
        AvatarInfoOuterClass.AvatarInfo.Builder avatarInfo = AvatarInfoOuterClass.AvatarInfo.newBuilder().setAvatarId(getAvatarId()).setGuid(getGuid()).setLifeState(1).addAllTalentIdList(getTalentIdList()).putAllFightPropMap(getFightProperties()).setSkillDepotId(getSkillDepotId()).setCoreProudSkillLevel(getCoreProudSkillLevel()).putAllSkillLevelMap(getSkillLevelMap()).addAllInherentProudSkillList(getProudSkillList()).putAllProudSkillExtraLevelMap(getProudSkillBonusMap()).setAvatarType(1).setBornTime(getBornTime()).setFetterInfo(avatarFetter).setWearingFlycloakId(getFlyCloak()).setCostumeId(getCostume());
        getSkillExtraChargeMap().forEach(skillId, count -> {
            avatarInfo.putSkillMap(skillId.intValue(), AvatarSkillInfoOuterClass.AvatarSkillInfo.newBuilder().setMaxChargeCount(count.intValue()).build());
        });
        getEquips().forEach(k, item -> {
            avatarInfo.addEquipGuidList(item.getGuid());
        });
        avatarInfo.putPropMap(PlayerProperty.PROP_LEVEL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, getLevel()));
        avatarInfo.putPropMap(PlayerProperty.PROP_EXP.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_EXP, getExp()));
        avatarInfo.putPropMap(PlayerProperty.PROP_BREAK_LEVEL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_BREAK_LEVEL, getPromoteLevel()));
        avatarInfo.putPropMap(PlayerProperty.PROP_SATIATION_VAL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_SATIATION_VAL, 0));
        avatarInfo.putPropMap(PlayerProperty.PROP_SATIATION_PENALTY_TIME.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_SATIATION_PENALTY_TIME, 0));
        return avatarInfo.build();
    }

    public ShowAvatarInfoOuterClass.ShowAvatarInfo toShowAvatarInfoProto() {
        ShowAvatarInfoOuterClass.ShowAvatarInfo.Builder showAvatarInfo = ShowAvatarInfoOuterClass.ShowAvatarInfo.newBuilder().setAvatarId(this.avatarId).addAllTalentIdList(getTalentIdList()).putAllFightPropMap(getFightProperties()).setSkillDepotId(getSkillDepotId()).setCoreProudSkillLevel(getCoreProudSkillLevel()).addAllInherentProudSkillList(getProudSkillList()).putAllSkillLevelMap(getSkillLevelMap()).putAllProudSkillExtraLevelMap(getProudSkillBonusMap()).setFetterInfo(AvatarFetterInfoOuterClass.AvatarFetterInfo.newBuilder().setExpLevel(getFetterLevel())).setCostumeId(getCostume());
        showAvatarInfo.putPropMap(PlayerProperty.PROP_LEVEL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_LEVEL, getLevel()));
        showAvatarInfo.putPropMap(PlayerProperty.PROP_EXP.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_EXP, getExp()));
        showAvatarInfo.putPropMap(PlayerProperty.PROP_BREAK_LEVEL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_BREAK_LEVEL, getPromoteLevel()));
        showAvatarInfo.putPropMap(PlayerProperty.PROP_SATIATION_VAL.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_SATIATION_VAL, getSatiation()));
        showAvatarInfo.putPropMap(PlayerProperty.PROP_SATIATION_PENALTY_TIME.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_SATIATION_PENALTY_TIME, getSatiationPenalty()));
        showAvatarInfo.putPropMap(PlayerProperty.PROP_MAX_STAMINA.getId(), ProtoHelper.newPropValue(PlayerProperty.PROP_MAX_STAMINA, getPlayer().getProperty(PlayerProperty.PROP_MAX_STAMINA)));
        ObjectIterator<GameItem> it = getEquips().values().iterator();
        while (it.hasNext()) {
            GameItem item = it.next();
            if (item.getItemType() == ItemType.ITEM_RELIQUARY) {
                showAvatarInfo.addEquipList(ShowEquipOuterClass.ShowEquip.newBuilder().setItemId(item.getItemId()).setReliquary(item.toReliquaryProto()));
            } else if (item.getItemType() == ItemType.ITEM_WEAPON) {
                showAvatarInfo.addEquipList(ShowEquipOuterClass.ShowEquip.newBuilder().setItemId(item.getItemId()).setWeapon(item.toWeaponProto()));
            }
        }
        return showAvatarInfo.build();
    }

    @PostLoad
    private void onLoad() {
    }

    @PrePersist
    private void prePersist() {
        this.currentHp = getFightProperty(FightProperty.FIGHT_PROP_CUR_HP);
    }
}
