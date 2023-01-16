package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.binout.AbilityEmbryoEntry;
import emu.grasscutter.data.common.PropGrowCurve;
import emu.grasscutter.game.props.FightProperty;
import emu.grasscutter.game.props.WeaponType;
import emu.grasscutter.utils.Utils;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@ResourceType(name = {"AvatarExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarData.class */
public class AvatarData extends GameResource {
    private String iconName;
    private String bodyType;
    private String qualityType;
    private int chargeEfficiency;
    private int initialWeapon;
    private WeaponType weaponType;
    private String imageName;
    private int avatarPromoteId;
    private String cutsceneShow;
    private int skillDepotId;
    private int staminaRecoverSpeed;
    private List<Integer> candSkillDepotIds;
    private String avatarIdentityType;
    private List<Integer> avatarPromoteRewardLevelList;
    private List<Integer> avatarPromoteRewardIdList;
    private long nameTextMapHash;
    private float hpBase;
    private float attackBase;
    private float defenseBase;
    private float critical;
    private float criticalHurt;
    private List<PropGrowCurve> propGrowCurves;

    /* renamed from: id */
    private int f512id;
    private String name;
    private Int2ObjectMap<String> growthCurveMap;
    private float[] hpGrowthCurve;
    private float[] attackGrowthCurve;
    private float[] defenseGrowthCurve;
    private AvatarSkillDepotData skillDepot;
    private IntList abilities;
    private List<Integer> fetters;
    private int nameCardRewardId;
    private int nameCardId;

    public String getBodyType() {
        return this.bodyType;
    }

    public String getQualityType() {
        return this.qualityType;
    }

    public int getChargeEfficiency() {
        return this.chargeEfficiency;
    }

    public int getInitialWeapon() {
        return this.initialWeapon;
    }

    public WeaponType getWeaponType() {
        return this.weaponType;
    }

    public String getImageName() {
        return this.imageName;
    }

    public int getAvatarPromoteId() {
        return this.avatarPromoteId;
    }

    public String getCutsceneShow() {
        return this.cutsceneShow;
    }

    public int getSkillDepotId() {
        return this.skillDepotId;
    }

    public int getStaminaRecoverSpeed() {
        return this.staminaRecoverSpeed;
    }

    public List<Integer> getCandSkillDepotIds() {
        return this.candSkillDepotIds;
    }

    public String getAvatarIdentityType() {
        return this.avatarIdentityType;
    }

    public List<Integer> getAvatarPromoteRewardLevelList() {
        return this.avatarPromoteRewardLevelList;
    }

    public List<Integer> getAvatarPromoteRewardIdList() {
        return this.avatarPromoteRewardIdList;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f512id;
    }

    public String getName() {
        return this.name;
    }

    public AvatarSkillDepotData getSkillDepot() {
        return this.skillDepot;
    }

    public IntList getAbilities() {
        return this.abilities;
    }

    public List<Integer> getFetters() {
        return this.fetters;
    }

    public int getNameCardRewardId() {
        return this.nameCardRewardId;
    }

    public int getNameCardId() {
        return this.nameCardId;
    }

    public float getBaseHp(int level) {
        try {
            return this.hpBase * this.hpGrowthCurve[level - 1];
        } catch (Exception e) {
            return this.hpBase;
        }
    }

    public float getBaseAttack(int level) {
        try {
            return this.attackBase * this.attackGrowthCurve[level - 1];
        } catch (Exception e) {
            return this.attackBase;
        }
    }

    public float getBaseDefense(int level) {
        try {
            return this.defenseBase * this.defenseGrowthCurve[level - 1];
        } catch (Exception e) {
            return this.defenseBase;
        }
    }

    public float getBaseCritical() {
        return this.critical;
    }

    public float getBaseCriticalHurt() {
        return this.criticalHurt;
    }

    public float getGrowthCurveById(int level, FightProperty prop) {
        AvatarCurveData curveData;
        String growCurve = this.growthCurveMap.get(prop.getId());
        if (growCurve == null || (curveData = GameData.getAvatarCurveDataMap().get(level)) == null) {
            return 1.0f;
        }
        return curveData.getCurveInfos().getOrDefault(growCurve, Float.valueOf(1.0f)).floatValue();
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.skillDepot = GameData.getAvatarSkillDepotDataMap().get(this.skillDepotId);
        this.fetters = GameData.getFetterDataEntries().get(Integer.valueOf(this.f512id));
        if (GameData.getFetterCharacterCardDataMap().get(this.f512id) != null) {
            this.nameCardRewardId = GameData.getFetterCharacterCardDataMap().get(this.f512id).getRewardId();
        }
        if (GameData.getRewardDataMap().get(this.nameCardRewardId) != null) {
            this.nameCardId = GameData.getRewardDataMap().get(this.nameCardRewardId).getRewardItemList().get(0).getItemId();
        }
        int size = GameData.getAvatarCurveDataMap().size();
        this.hpGrowthCurve = new float[size];
        this.attackGrowthCurve = new float[size];
        this.defenseGrowthCurve = new float[size];
        ObjectIterator<AvatarCurveData> it = GameData.getAvatarCurveDataMap().values().iterator();
        while (it.hasNext()) {
            AvatarCurveData curveData = it.next();
            int level = curveData.getLevel() - 1;
            for (PropGrowCurve growCurve : this.propGrowCurves) {
                switch (FightProperty.getPropByName(growCurve.getType())) {
                    case FIGHT_PROP_BASE_HP:
                        this.hpGrowthCurve[level] = curveData.getCurveInfos().get(growCurve.getGrowCurve()).floatValue();
                        break;
                    case FIGHT_PROP_BASE_ATTACK:
                        this.attackGrowthCurve[level] = curveData.getCurveInfos().get(growCurve.getGrowCurve()).floatValue();
                        break;
                    case FIGHT_PROP_BASE_DEFENSE:
                        this.defenseGrowthCurve[level] = curveData.getCurveInfos().get(growCurve.getGrowCurve()).floatValue();
                        break;
                }
            }
        }
        rebuildAbilityEmbryo();
    }

    public void rebuildAbilityEmbryo() {
        String[] split = this.iconName.split(JavaConstant.Dynamic.DEFAULT_NAME);
        if (split.length > 0) {
            this.name = split[split.length - 1];
            AbilityEmbryoEntry info = GameData.getAbilityEmbryoInfo().get(this.name);
            if (info != null) {
                this.abilities = new IntArrayList(info.getAbilities().length);
                for (String ability : info.getAbilities()) {
                    this.abilities.add(Utils.abilityHash(ability));
                }
            }
        }
    }
}
