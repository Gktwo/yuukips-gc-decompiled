package emu.grasscutter.data.binout;

import emu.grasscutter.data.ResourceLoader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/OpenConfigEntry.class */
public class OpenConfigEntry {
    private String name;
    private String[] addAbilities;
    private int extraTalentIndex;
    private SkillPointModifier[] skillPointModifiers;

    public OpenConfigEntry(String name, ResourceLoader.OpenConfigData[] data) {
        this.name = name;
        List<String> abilityList = new ArrayList<>();
        List<SkillPointModifier> modList = new ArrayList<>();
        for (ResourceLoader.OpenConfigData entry : data) {
            if (entry.$type.contains("AddAbility")) {
                abilityList.add(entry.abilityName);
            } else if (entry.talentIndex > 0) {
                this.extraTalentIndex = entry.talentIndex;
            } else if (entry.$type.contains("ModifySkillPoint")) {
                modList.add(new SkillPointModifier(entry.skillID, entry.pointDelta));
            }
        }
        if (abilityList.size() > 0) {
            this.addAbilities = (String[]) abilityList.toArray(new String[0]);
        }
        if (modList.size() > 0) {
            this.skillPointModifiers = (SkillPointModifier[]) modList.toArray(new SkillPointModifier[0]);
        }
    }

    public String getName() {
        return this.name;
    }

    public String[] getAddAbilities() {
        return this.addAbilities;
    }

    public int getExtraTalentIndex() {
        return this.extraTalentIndex;
    }

    public SkillPointModifier[] getSkillPointModifiers() {
        return this.skillPointModifiers;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/OpenConfigEntry$SkillPointModifier.class */
    public static class SkillPointModifier {
        private int skillId;
        private int delta;

        public SkillPointModifier(int skillId, int delta) {
            this.skillId = skillId;
            this.delta = delta;
        }

        public int getSkillId() {
            return this.skillId;
        }

        public int getDelta() {
            return this.delta;
        }
    }
}
