package emu.grasscutter.game.dungeons;

import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonEndStats.class */
public class DungeonEndStats {
    private int killedMonsters;
    private int timeTaken;
    private int openChestCount;
    private BaseDungeonResult.DungeonEndReason dungeonResult;

    public int getKilledMonsters() {
        return this.killedMonsters;
    }

    public int getTimeTaken() {
        return this.timeTaken;
    }

    public int getOpenChestCount() {
        return this.openChestCount;
    }

    public BaseDungeonResult.DungeonEndReason getDungeonResult() {
        return this.dungeonResult;
    }

    public DungeonEndStats(int killedMonsters, int timeTaken, int openChestCount, BaseDungeonResult.DungeonEndReason dungeonResult) {
        this.killedMonsters = killedMonsters;
        this.timeTaken = timeTaken;
        this.dungeonResult = dungeonResult;
        this.openChestCount = openChestCount;
    }
}
