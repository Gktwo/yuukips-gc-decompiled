package emu.grasscutter.data.binout;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/AbilityEmbryoEntry.class */
public class AbilityEmbryoEntry {
    private String name;
    private String[] abilities;

    public AbilityEmbryoEntry() {
    }

    public AbilityEmbryoEntry(String avatarName, String[] array) {
        this.name = avatarName;
        this.abilities = array;
    }

    public String getName() {
        return this.name;
    }

    public String[] getAbilities() {
        return this.abilities;
    }
}
