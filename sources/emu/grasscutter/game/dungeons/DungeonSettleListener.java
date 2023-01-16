package emu.grasscutter.game.dungeons;

import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonSettleListener.class */
public interface DungeonSettleListener {
    void onDungeonSettle(DungeonManager dungeonManager, BaseDungeonResult.DungeonEndReason dungeonEndReason);
}
