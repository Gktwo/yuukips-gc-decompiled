package emu.grasscutter.data.binout;

import emu.grasscutter.data.binout.AbilityModifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/AbilityModifierEntry.class */
public class AbilityModifierEntry {
    private String name;
    public List<AbilityModifier.AbilityModifierAction> onModifierAdded = new ArrayList();
    public List<AbilityModifier.AbilityModifierAction> onThinkInterval = new ArrayList();
    public List<AbilityModifier.AbilityModifierAction> onRemoved = new ArrayList();

    public AbilityModifierEntry(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public List<AbilityModifier.AbilityModifierAction> getOnAdded() {
        return this.onModifierAdded;
    }

    public List<AbilityModifier.AbilityModifierAction> getOnThinkInterval() {
        return this.onThinkInterval;
    }

    public List<AbilityModifier.AbilityModifierAction> getOnRemoved() {
        return this.onRemoved;
    }
}
