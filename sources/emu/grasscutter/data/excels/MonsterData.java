package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.PropGrowCurve;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.MonsterType;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@ResourceType(name = {"MonsterExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/MonsterData.class */
public class MonsterData extends GameResource {
    public static Set<FightProperty> definedFightProperties = Set.of((Object[]) new FightProperty[]{FightProperty.FIGHT_PROP_BASE_HP, FightProperty.FIGHT_PROP_BASE_ATTACK, FightProperty.FIGHT_PROP_BASE_DEFENSE, FightProperty.FIGHT_PROP_PHYSICAL_SUB_HURT, FightProperty.FIGHT_PROP_FIRE_SUB_HURT, FightProperty.FIGHT_PROP_ELEC_SUB_HURT, FightProperty.FIGHT_PROP_WATER_SUB_HURT, FightProperty.FIGHT_PROP_GRASS_SUB_HURT, FightProperty.FIGHT_PROP_WIND_SUB_HURT, FightProperty.FIGHT_PROP_ROCK_SUB_HURT, FightProperty.FIGHT_PROP_ICE_SUB_HURT});

    /* renamed from: id */
    private int f542id;
    private String monsterName;
    private MonsterType type;
    private String serverScript;
    private List<Integer> affix;

    /* renamed from: ai */
    private String f543ai;
    private int[] equips;
    private List<HpDrops> hpDrops;
    private int killDropId;
    private String excludeWeathers;
    private int featureTagGroupID;
    private int mpPropID;
    private String skin;
    private int describeId;
    private int combatBGMLevel;
    private int entityBudgetLevel;
    @SerializedName("hpBase")
    private float baseHp;
    @SerializedName("attackBase")
    private float baseAttack;
    @SerializedName("defenseBase")
    private float baseDefense;
    private float fireSubHurt;
    private float elecSubHurt;
    private float grassSubHurt;
    private float waterSubHurt;
    private float windSubHurt;
    private float rockSubHurt;
    private float iceSubHurt;
    private float physicalSubHurt;
    private List<PropGrowCurve> propGrowCurves;
    private long nameTextMapHash;
    private int campID;
    private int weaponId;
    private MonsterDescribeData describeData;
    private int specialNameId;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f542id;
    }

    public String getMonsterName() {
        return this.monsterName;
    }

    public MonsterType getType() {
        return this.type;
    }

    public String getServerScript() {
        return this.serverScript;
    }

    public List<Integer> getAffix() {
        return this.affix;
    }

    public String getAi() {
        return this.f543ai;
    }

    public int[] getEquips() {
        return this.equips;
    }

    public List<HpDrops> getHpDrops() {
        return this.hpDrops;
    }

    public int getKillDropId() {
        return this.killDropId;
    }

    public String getExcludeWeathers() {
        return this.excludeWeathers;
    }

    public int getFeatureTagGroupID() {
        return this.featureTagGroupID;
    }

    public int getMpPropID() {
        return this.mpPropID;
    }

    public String getSkin() {
        return this.skin;
    }

    public int getDescribeId() {
        return this.describeId;
    }

    public int getCombatBGMLevel() {
        return this.combatBGMLevel;
    }

    public int getEntityBudgetLevel() {
        return this.entityBudgetLevel;
    }

    public float getBaseHp() {
        return this.baseHp;
    }

    public float getBaseAttack() {
        return this.baseAttack;
    }

    public float getBaseDefense() {
        return this.baseDefense;
    }

    public float getFireSubHurt() {
        return this.fireSubHurt;
    }

    public float getElecSubHurt() {
        return this.elecSubHurt;
    }

    public float getGrassSubHurt() {
        return this.grassSubHurt;
    }

    public float getWaterSubHurt() {
        return this.waterSubHurt;
    }

    public float getWindSubHurt() {
        return this.windSubHurt;
    }

    public float getRockSubHurt() {
        return this.rockSubHurt;
    }

    public float getIceSubHurt() {
        return this.iceSubHurt;
    }

    public float getPhysicalSubHurt() {
        return this.physicalSubHurt;
    }

    public List<PropGrowCurve> getPropGrowCurves() {
        return this.propGrowCurves;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public int getCampID() {
        return this.campID;
    }

    public int getWeaponId() {
        return this.weaponId;
    }

    public MonsterDescribeData getDescribeData() {
        return this.describeData;
    }

    public int getSpecialNameId() {
        return this.specialNameId;
    }

    public float getFightProperty(FightProperty prop) {
        switch (prop) {
            case FIGHT_PROP_BASE_HP:
                return this.baseHp;
            case FIGHT_PROP_BASE_ATTACK:
                return this.baseAttack;
            case FIGHT_PROP_BASE_DEFENSE:
                return this.baseDefense;
            case FIGHT_PROP_PHYSICAL_SUB_HURT:
                return this.physicalSubHurt;
            case FIGHT_PROP_FIRE_SUB_HURT:
                return this.fireSubHurt;
            case FIGHT_PROP_ELEC_SUB_HURT:
                return this.elecSubHurt;
            case FIGHT_PROP_WATER_SUB_HURT:
                return this.waterSubHurt;
            case FIGHT_PROP_GRASS_SUB_HURT:
                return this.grassSubHurt;
            case FIGHT_PROP_WIND_SUB_HURT:
                return this.windSubHurt;
            case FIGHT_PROP_ROCK_SUB_HURT:
                return this.rockSubHurt;
            case FIGHT_PROP_ICE_SUB_HURT:
                return this.iceSubHurt;
            default:
                return 0.0f;
        }
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        GadgetData gadget;
        int[] iArr = this.equips;
        for (int id : iArr) {
            if (!(id == 0 || (gadget = GameData.getGadgetDataMap().get(id)) == null || !gadget.getItemJsonName().equals("Default_MonsterWeapon"))) {
                this.weaponId = id;
            }
        }
        this.describeData = GameData.getMonsterDescribeDataMap().get(getDescribeId());
        if (this.describeData != null) {
            ObjectIterator<Map.Entry<Integer, MonsterSpecialNameData>> it = GameData.getMonsterSpecialNameDataMap().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, MonsterSpecialNameData> entry = it.next();
                if (entry.getValue().getSpecialNameLabId() == getDescribeData().getSpecialNameLabId()) {
                    this.specialNameId = entry.getKey().intValue();
                    return;
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/MonsterData$HpDrops.class */
    public class HpDrops {
        private int DropId;
        private int HpPercent;

        public HpDrops() {
        }

        public int getDropId() {
            return this.DropId;
        }

        public int getHpPercent() {
            return this.HpPercent;
        }
    }
}
