package emu.grasscutter.data.binout;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/ConfigLevelEntity.class */
public class ConfigLevelEntity {
    private List<EntityAbilities> abilities;
    private List<EntityAbilities> avatarAbilities;

    public List<EntityAbilities> getAbilities() {
        return this.abilities;
    }

    public List<EntityAbilities> getAvatarAbilities() {
        return this.avatarAbilities;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/ConfigLevelEntity$EntityAbilities.class */
    public class EntityAbilities {
        private String abilityName;

        public EntityAbilities() {
        }

        public String getAbilityName() {
            return this.abilityName;
        }
    }
}
