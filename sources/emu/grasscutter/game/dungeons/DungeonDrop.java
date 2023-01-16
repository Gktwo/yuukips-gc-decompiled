package emu.grasscutter.game.dungeons;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonDrop.class */
public class DungeonDrop {
    private int dungeonId;
    private List<DungeonDropEntry> drops;

    public int getDungeonId() {
        return this.dungeonId;
    }

    public void setDungeonId(int dungeonId) {
        this.dungeonId = dungeonId;
    }

    public List<DungeonDropEntry> getDrops() {
        return this.drops;
    }

    public void setDrops(List<DungeonDropEntry> drops) {
        this.drops = drops;
    }
}
