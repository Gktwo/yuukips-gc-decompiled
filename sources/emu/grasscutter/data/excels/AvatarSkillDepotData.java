package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameDepot;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceLoader;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.binout.AbilityEmbryoEntry;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.utils.Utils;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;

@ResourceType(name = {"AvatarSkillDepotExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarSkillDepotData.class */
public class AvatarSkillDepotData extends GameResource {

    /* renamed from: id */
    private int f514id;
    private int energySkill;
    private int attackModeSkill;
    private List<Integer> skills;
    private List<Integer> subSkills;
    private List<String> extraAbilities;
    private List<Integer> talents;
    private List<InherentProudSkillOpens> inherentProudSkillOpens;
    private String talentStarName;
    private String skillDepotAbilityGroup;
    private AvatarSkillData energySkillData;
    private ElementType elementType;
    private IntList abilities;
    private int talentCostItemId;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f514id;
    }

    public int getEnergySkill() {
        return this.energySkill;
    }

    public int getAttackModeSkill() {
        return this.attackModeSkill;
    }

    public List<Integer> getSkills() {
        return this.skills;
    }

    public List<Integer> getSubSkills() {
        return this.subSkills;
    }

    public List<String> getExtraAbilities() {
        return this.extraAbilities;
    }

    public List<Integer> getTalents() {
        return this.talents;
    }

    public List<InherentProudSkillOpens> getInherentProudSkillOpens() {
        return this.inherentProudSkillOpens;
    }

    public String getTalentStarName() {
        return this.talentStarName;
    }

    public String getSkillDepotAbilityGroup() {
        return this.skillDepotAbilityGroup;
    }

    public AvatarSkillData getEnergySkillData() {
        return this.energySkillData;
    }

    public ElementType getElementType() {
        return this.elementType;
    }

    public IntList getAbilities() {
        return this.abilities;
    }

    public int getTalentCostItemId() {
        return this.talentCostItemId;
    }

    public void setAbilities(AbilityEmbryoEntry info) {
        this.abilities = new IntArrayList(info.getAbilities().length);
        for (String ability : info.getAbilities()) {
            this.abilities.add(Utils.abilityHash(ability));
        }
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        ResourceLoader.AvatarConfig config;
        this.energySkillData = GameData.getAvatarSkillDataMap().get(this.energySkill);
        if (this.energySkillData != null) {
            this.elementType = this.energySkillData.getCostElemType();
        } else {
            this.elementType = ElementType.None;
        }
        if (!(getSkillDepotAbilityGroup() == null || getSkillDepotAbilityGroup().length() <= 0 || (config = GameDepot.getPlayerAbilities().get(getSkillDepotAbilityGroup())) == null)) {
            setAbilities(new AbilityEmbryoEntry(getSkillDepotAbilityGroup(), (String[]) config.abilities.stream().map((v0) -> {
                return v0.toString();
            }).toArray(x$0 -> {
                return new String[x$0];
            })));
        }
        Optional.ofNullable(this.talents).map(talents -> {
            return (Integer) talents.get(0);
        }).map(i -> {
            return GameData.getAvatarTalentDataMap().get(i.intValue());
        }).map(talentData -> {
            return Integer.valueOf(talentData.getMainCostItemId());
        }).ifPresent(itemId -> {
            this.talentCostItemId = itemId.intValue();
        });
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarSkillDepotData$InherentProudSkillOpens.class */
    public static class InherentProudSkillOpens {
        private int proudSkillGroupId;
        private int needAvatarPromoteLevel;

        public int getProudSkillGroupId() {
            return this.proudSkillGroupId;
        }

        public int getNeedAvatarPromoteLevel() {
            return this.needAvatarPromoteLevel;
        }
    }

    public IntStream getSkillsAndEnergySkill() {
        return IntStream.concat(this.skills.stream().mapToInt(i -> {
            return i.intValue();
        }), IntStream.of(this.energySkill)).filter(skillId -> {
            return skillId > 0;
        });
    }
}
