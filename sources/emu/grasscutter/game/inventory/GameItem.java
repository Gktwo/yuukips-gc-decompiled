package emu.grasscutter.game.inventory;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameDepot;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.ReliquaryAffixData;
import emu.grasscutter.data.excels.ReliquaryMainPropData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.EquipOuterClass;
import emu.grasscutter.net.proto.FurnitureOuterClass;
import emu.grasscutter.net.proto.ItemHintOuterClass;
import emu.grasscutter.net.proto.ItemOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.MaterialOuterClass;
import emu.grasscutter.net.proto.ReliquaryOuterClass;
import emu.grasscutter.net.proto.SceneReliquaryInfoOuterClass;
import emu.grasscutter.net.proto.SceneWeaponInfoOuterClass;
import emu.grasscutter.net.proto.WeaponOuterClass;
import emu.grasscutter.utils.WeightedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.types.ObjectId;

@Entity(value = "items", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/GameItem.class */
public class GameItem {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f576id;
    @Indexed
    private int ownerId;
    private int itemId;
    private int count;
    @Transient
    private long guid;
    @Transient
    private ItemData itemData;
    private int level;
    private int exp;
    private int totalExp;
    private int promoteLevel;
    private boolean locked;
    private List<Integer> affixes;
    private int refinement;
    private int mainPropId;
    private List<Integer> appendPropIdList;
    private int equipCharacter;
    @Transient
    private int weaponEntityId;

    public int getItemId() {
        return this.itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getGuid() {
        return this.guid;
    }

    public ItemData getItemData() {
        return this.itemData;
    }

    public void setItemData(ItemData itemData) {
        this.itemData = itemData;
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

    public int getTotalExp() {
        return this.totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public int getPromoteLevel() {
        return this.promoteLevel;
    }

    public void setPromoteLevel(int promoteLevel) {
        this.promoteLevel = promoteLevel;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public List<Integer> getAffixes() {
        return this.affixes;
    }

    public int getRefinement() {
        return this.refinement;
    }

    public void setRefinement(int refinement) {
        this.refinement = refinement;
    }

    public int getMainPropId() {
        return this.mainPropId;
    }

    public void setMainPropId(int mainPropId) {
        this.mainPropId = mainPropId;
    }

    public List<Integer> getAppendPropIdList() {
        return this.appendPropIdList;
    }

    public int getEquipCharacter() {
        return this.equipCharacter;
    }

    public void setEquipCharacter(int equipCharacter) {
        this.equipCharacter = equipCharacter;
    }

    public int getWeaponEntityId() {
        return this.weaponEntityId;
    }

    public void setWeaponEntityId(int weaponEntityId) {
        this.weaponEntityId = weaponEntityId;
    }

    public GameItem() {
        this.refinement = 0;
    }

    public GameItem(int itemId) {
        this(GameData.getItemDataMap().get(itemId));
    }

    public GameItem(int itemId, int count) {
        this(GameData.getItemDataMap().get(itemId), count);
    }

    public GameItem(ItemParamData itemParamData) {
        this(itemParamData.getId(), itemParamData.getCount());
    }

    public GameItem(ItemData data) {
        this(data, 1);
    }

    public GameItem(ItemData data, int count) {
        this.refinement = 0;
        if (data != null) {
            this.itemId = data.getId();
            this.itemData = data;
            switch (data.getItemType()) {
                case ITEM_VIRTUAL:
                    this.count = count;
                    return;
                case ITEM_WEAPON:
                    this.count = 1;
                    this.level = Math.max(this.count, 1);
                    this.affixes = new ArrayList(2);
                    if (data.getSkillAffix() != null) {
                        int[] skillAffix = data.getSkillAffix();
                        for (int skillAffix2 : skillAffix) {
                            if (skillAffix2 > 0) {
                                this.affixes.add(Integer.valueOf(skillAffix2));
                            }
                        }
                        return;
                    }
                    return;
                case ITEM_RELIQUARY:
                    this.count = 1;
                    this.level = 1;
                    this.appendPropIdList = new ArrayList();
                    ReliquaryMainPropData mainPropData = GameDepot.getRandomRelicMainProp(data.getMainPropDepotId());
                    if (mainPropData != null) {
                        this.mainPropId = mainPropData.getId();
                    }
                    addAppendProps(data.getAppendPropNum());
                    return;
                default:
                    this.count = Math.min(count, data.getStackLimit());
                    return;
            }
        }
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public void setOwner(Player player) {
        this.ownerId = player.getUid();
        this.guid = player.getNextGameGuid();
    }

    public ObjectId getObjectId() {
        return this.f576id;
    }

    public ItemType getItemType() {
        return this.itemData.getItemType();
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

    public int getEquipSlot() {
        return getItemData().getEquipType().getValue();
    }

    public boolean isEquipped() {
        return getEquipCharacter() > 0;
    }

    public boolean isDestroyable() {
        return !isLocked() && !isEquipped();
    }

    public void addAppendProp() {
        if (this.appendPropIdList == null) {
            this.appendPropIdList = new ArrayList();
        }
        if (this.appendPropIdList.size() < 4) {
            addNewAppendProp();
        } else {
            upgradeRandomAppendProp();
        }
    }

    public void addAppendProps(int quantity) {
        int num = Math.max(quantity, 0);
        for (int i = 0; i < num; i++) {
            addAppendProp();
        }
    }

    private Set<FightProperty> getAppendFightProperties() {
        Set<FightProperty> props = new HashSet<>();
        for (Integer num : this.appendPropIdList) {
            ReliquaryAffixData affixData = GameData.getReliquaryAffixDataMap().get(num.intValue());
            if (affixData != null) {
                props.add(affixData.getFightProp());
            }
        }
        return props;
    }

    private void addNewAppendProp() {
        List<ReliquaryAffixData> affixList = GameDepot.getRelicAffixList(this.itemData.getAppendPropDepotId());
        if (affixList != null) {
            Set<FightProperty> blacklist = getAppendFightProperties();
            ReliquaryMainPropData mainPropData = GameData.getReliquaryMainPropDataMap().get(this.mainPropId);
            if (mainPropData != null) {
                blacklist.add(mainPropData.getFightProp());
            }
            WeightedList<ReliquaryAffixData> randomList = new WeightedList<>();
            for (ReliquaryAffixData affix : affixList) {
                if (!blacklist.contains(affix.getFightProp())) {
                    randomList.add((double) affix.getWeight(), affix);
                }
            }
            if (randomList.size() != 0) {
                this.appendPropIdList.add(Integer.valueOf(randomList.next().getId()));
            }
        }
    }

    private void upgradeRandomAppendProp() {
        List<ReliquaryAffixData> affixList = GameDepot.getRelicAffixList(this.itemData.getAppendPropDepotId());
        if (affixList != null) {
            Set<FightProperty> whitelist = getAppendFightProperties();
            WeightedList<ReliquaryAffixData> randomList = new WeightedList<>();
            for (ReliquaryAffixData affix : affixList) {
                if (whitelist.contains(affix.getFightProp())) {
                    randomList.add((double) affix.getUpgradeWeight(), affix);
                }
            }
            if (randomList.size() != 0) {
                this.appendPropIdList.add(Integer.valueOf(randomList.next().getId()));
            }
        }
    }

    @PostLoad
    public void onLoad() {
        if (this.itemData == null) {
            this.itemData = GameData.getItemDataMap().get(getItemId());
        }
    }

    public void save() {
        if (this.count > 0 && this.ownerId > 0) {
            DatabaseHelper.saveItem(this);
        } else if (getObjectId() != null) {
            DatabaseHelper.deleteItem(this);
        }
    }

    public SceneWeaponInfoOuterClass.SceneWeaponInfo createSceneWeaponInfo() {
        SceneWeaponInfoOuterClass.SceneWeaponInfo.Builder weaponInfo = SceneWeaponInfoOuterClass.SceneWeaponInfo.newBuilder().setEntityId(getWeaponEntityId()).setItemId(getItemId()).setGuid(getGuid()).setLevel(getLevel()).setGadgetId(getItemData().getGadgetId()).setAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder().setIsInited(getAffixes().size() > 0));
        if (getAffixes() != null && getAffixes().size() > 0) {
            for (Integer num : getAffixes()) {
                weaponInfo.putAffixMap(num.intValue(), getRefinement());
            }
        }
        return weaponInfo.build();
    }

    public SceneReliquaryInfoOuterClass.SceneReliquaryInfo createSceneReliquaryInfo() {
        return SceneReliquaryInfoOuterClass.SceneReliquaryInfo.newBuilder().setItemId(getItemId()).setGuid(getGuid()).setLevel(getLevel()).build();
    }

    public WeaponOuterClass.Weapon toWeaponProto() {
        WeaponOuterClass.Weapon.Builder weapon = WeaponOuterClass.Weapon.newBuilder().setLevel(getLevel()).setExp(getExp()).setPromoteLevel(getPromoteLevel());
        if (getAffixes() != null && getAffixes().size() > 0) {
            for (Integer num : getAffixes()) {
                weapon.putAffixMap(num.intValue(), getRefinement());
            }
        }
        return weapon.build();
    }

    public ReliquaryOuterClass.Reliquary toReliquaryProto() {
        return ReliquaryOuterClass.Reliquary.newBuilder().setLevel(getLevel()).setExp(getExp()).setPromoteLevel(getPromoteLevel()).setMainPropId(getMainPropId()).addAllAppendPropIdList(getAppendPropIdList()).build();
    }

    public ItemOuterClass.Item toProto() {
        ItemOuterClass.Item.Builder proto = ItemOuterClass.Item.newBuilder().setGuid(getGuid()).setItemId(getItemId());
        switch (getItemType()) {
            case ITEM_WEAPON:
                proto.setEquip(EquipOuterClass.Equip.newBuilder().setWeapon(toWeaponProto()).setIsLocked(isLocked()).build());
                break;
            case ITEM_RELIQUARY:
                proto.setEquip(EquipOuterClass.Equip.newBuilder().setReliquary(toReliquaryProto()).setIsLocked(isLocked()).build());
                break;
            case ITEM_FURNITURE:
                proto.setFurniture(FurnitureOuterClass.Furniture.newBuilder().setCount(getCount()).build());
                break;
            default:
                proto.setMaterial(MaterialOuterClass.Material.newBuilder().setCount(getCount()).build());
                break;
        }
        return proto.build();
    }

    public ItemHintOuterClass.ItemHint toItemHintProto() {
        return ItemHintOuterClass.ItemHint.newBuilder().setItemId(getItemId()).setCount(getCount()).setIsNew(false).build();
    }

    public ItemParamOuterClass.ItemParam toItemParam() {
        return ItemParamOuterClass.ItemParam.newBuilder().setItemId(getItemId()).setCount(getCount()).build();
    }
}
