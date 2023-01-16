package emu.grasscutter.game.dungeons.handlers;

import emu.grasscutter.data.excels.DungeonPassConfigData;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/handlers/DungeonBaseHandler.class */
public abstract class DungeonBaseHandler {
    public abstract boolean execute(DungeonPassConfigData.DungeonPassCondition dungeonPassCondition, int... iArr);
}
