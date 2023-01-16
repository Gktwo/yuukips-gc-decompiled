package emu.grasscutter.game.dungeons;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonDropEntry.class */
public class DungeonDropEntry {
    private List<Integer> counts;
    private List<Integer> items;
    private List<Integer> probabilities;
    private List<Integer> itemProbabilities;
    private boolean mpDouble;

    public List<Integer> getCounts() {
        return this.counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    public List<Integer> getItems() {
        return this.items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    public List<Integer> getProbabilities() {
        return this.probabilities;
    }

    public void setProbabilities(List<Integer> probabilities) {
        this.probabilities = probabilities;
    }

    public List<Integer> getItemProbabilities() {
        return this.itemProbabilities;
    }

    public void setItemProbabilities(List<Integer> itemProbabilities) {
        this.itemProbabilities = itemProbabilities;
    }

    public boolean isMpDouble() {
        return this.mpDouble;
    }

    public void setMpDouble(boolean mpDouble) {
        this.mpDouble = mpDouble;
    }
}
