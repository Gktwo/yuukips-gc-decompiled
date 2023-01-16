package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemUseData;
import emu.grasscutter.game.inventory.EquipType;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.inventory.MaterialType;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.ItemUseAction.C1378ItemUseAction;
import emu.grasscutter.game.props.ItemUseOp;
import emu.grasscutter.game.props.ItemUseTarget;
import emu.grasscutter.game.props.WeaponType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;

@ResourceType(name = {"MaterialExcelConfigData.json", "WeaponExcelConfigData.json", "ReliquaryExcelConfigData.json", "HomeWorldFurnitureExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ItemData.class */
public class ItemData extends GameResource {

    /* renamed from: id */
    private int f541id;
    private int maxUseCount;
    private int rankLevel;
    private String effectName;
    private int rank;
    private int weight;
    private int gadgetId;
    private int[] destroyReturnMaterial;
    private int[] destroyReturnMaterialCount;
    private String effectType;
    private String destroyRule;
    private String foodQuality;
    private int[] satiationParams;
    private List<ItemUseData> itemUse;
    private List<C1378ItemUseAction> itemUseActions;
    private int mainPropDepotId;
    private int appendPropDepotId;
    private int appendPropNum;
    private int setId;
    private int[] addPropLevels;
    private int baseConvExp;
    private int maxLevel;
    private WeaponType weaponType;
    private int weaponPromoteId;
    private int weaponBaseExp;
    private int storyId;
    private int avatarPromoteId;
    private int awakenMaterial;
    private int[] awakenCosts;
    private int[] skillAffix;
    private WeaponProperty[] weaponProp;
    private long nameTextMapHash;
    private int comfort;
    private List<Integer> furnType;
    @SerializedName(value = "furnitureGadgetID", alternate = {"furnitureGadgetId"})
    private List<Integer> furnitureGadgetID;
    @SerializedName(value = "roomSceneId", alternate = {"BMEPAMCNABE", "DANFGGLKLNO", "JFDLJGDFIGL", "OHIANNAEEAK", "roomSceneID", "MFGACDIOHGF"})
    private int roomSceneId;
    private transient IntSet addPropLevelSet;
    private int stackLimit = 1;
    private ItemType itemType = ItemType.ITEM_NONE;
    private MaterialType materialType = MaterialType.MATERIAL_NONE;
    private EquipType equipType = EquipType.EQUIP_NONE;
    private ItemUseTarget useTarget = ItemUseTarget.ITEM_USE_TARGET_NONE;
    private boolean useOnGain = false;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f541id;
    }

    public int getStackLimit() {
        return this.stackLimit;
    }

    public int getMaxUseCount() {
        return this.maxUseCount;
    }

    public int getRankLevel() {
        return this.rankLevel;
    }

    public String getEffectName() {
        return this.effectName;
    }

    public int getRank() {
        return this.rank;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getGadgetId() {
        return this.gadgetId;
    }

    public int[] getDestroyReturnMaterial() {
        return this.destroyReturnMaterial;
    }

    public int[] getDestroyReturnMaterialCount() {
        return this.destroyReturnMaterialCount;
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public MaterialType getMaterialType() {
        return this.materialType;
    }

    public EquipType getEquipType() {
        return this.equipType;
    }

    public String getEffectType() {
        return this.effectType;
    }

    public String getDestroyRule() {
        return this.destroyRule;
    }

    public String getFoodQuality() {
        return this.foodQuality;
    }

    public int[] getSatiationParams() {
        return this.satiationParams;
    }

    public ItemUseTarget getUseTarget() {
        return this.useTarget;
    }

    public List<ItemUseData> getItemUse() {
        return this.itemUse;
    }

    public List<C1378ItemUseAction> getItemUseActions() {
        return this.itemUseActions;
    }

    public boolean isUseOnGain() {
        return this.useOnGain;
    }

    public int getMainPropDepotId() {
        return this.mainPropDepotId;
    }

    public int getAppendPropDepotId() {
        return this.appendPropDepotId;
    }

    public int getAppendPropNum() {
        return this.appendPropNum;
    }

    public int getSetId() {
        return this.setId;
    }

    public int[] getAddPropLevels() {
        return this.addPropLevels;
    }

    public int getBaseConvExp() {
        return this.baseConvExp;
    }

    public int getMaxLevel() {
        return this.maxLevel;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public int getWeaponPromoteId() {
        return this.weaponPromoteId;
    }

    public int getWeaponBaseExp() {
        return this.weaponBaseExp;
    }

    public int getStoryId() {
        return this.storyId;
    }

    public int getAvatarPromoteId() {
        return this.avatarPromoteId;
    }

    public int getAwakenMaterial() {
        return this.awakenMaterial;
    }

    public int[] getAwakenCosts() {
        return this.awakenCosts;
    }

    public int[] getSkillAffix() {
        return this.skillAffix;
    }

    public WeaponProperty[] getWeaponProp() {
        return this.weaponProp;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public int getComfort() {
        return this.comfort;
    }

    public List<Integer> getFurnType() {
        return this.furnType;
    }

    public List<Integer> getFurnitureGadgetID() {
        return this.furnitureGadgetID;
    }

    public int getRoomSceneId() {
        return this.roomSceneId;
    }

    public IntSet getAddPropLevelSet() {
        return this.addPropLevelSet;
    }

    public WeaponProperty[] getWeaponProperties() {
        return this.weaponProp;
    }

    public boolean canAddRelicProp(int level) {
        return this.addPropLevelSet != null && this.addPropLevelSet.contains(level);
    }

    public boolean isEquip() {
        return this.itemType == ItemType.ITEM_RELIQUARY || this.itemType == ItemType.ITEM_WEAPON;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        if (this.itemType == ItemType.ITEM_RELIQUARY) {
            if (this.addPropLevels != null && this.addPropLevels.length > 0) {
                this.addPropLevelSet = new IntOpenHashSet(this.addPropLevels);
            }
        } else if (this.itemType == ItemType.ITEM_WEAPON) {
            this.equipType = EquipType.EQUIP_WEAPON;
        } else {
            this.equipType = EquipType.EQUIP_NONE;
        }
        if (this.weaponProp != null) {
            this.weaponProp = (WeaponProperty[]) Arrays.stream(this.weaponProp).filter(prop -> {
                return prop.getPropType() != null;
            }).toArray(x$0 -> {
                return new WeaponProperty[x$0];
            });
        }
        if (getFurnType() != null) {
            this.furnType = this.furnType.stream().filter(x -> {
                return x.intValue() > 0;
            }).toList();
        }
        if (getFurnitureGadgetID() != null) {
            this.furnitureGadgetID = this.furnitureGadgetID.stream().filter(x -> {
                return x.intValue() > 0;
            }).toList();
        }
        this.materialType = this.materialType == null ? MaterialType.MATERIAL_NONE : this.materialType;
        if (this.itemUse != null && !this.itemUse.isEmpty()) {
            this.itemUseActions = this.itemUse.stream().filter(x -> {
                return x.getUseOp() != ItemUseOp.ITEM_USE_NONE;
            }).map(C1378ItemUseAction::fromItemUseData).filter((v0) -> {
                return Objects.nonNull(v0);
            }).toList();
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ItemData$WeaponProperty.class */
    public static class WeaponProperty {
        private FightProperty propType;
        private float initValue;
        private String type;

        public FightProperty getPropType() {
            return this.propType;
        }

        public float getInitValue() {
            return this.initValue;
        }

        public String getType() {
            return this.type;
        }
    }
}
