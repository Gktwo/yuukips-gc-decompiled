package emu.grasscutter.game.dungeons;

import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.PacketDungeonSettleNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/BasicDungeonSettleListener.class */
public class BasicDungeonSettleListener implements DungeonSettleListener {
    @Override // emu.grasscutter.game.dungeons.DungeonSettleListener
    public void onDungeonSettle(DungeonManager dungeonManager, BaseDungeonResult.DungeonEndReason endReason) {
        Scene scene = dungeonManager.getScene();
        scene.broadcastPacket(new PacketDungeonSettleNotify(new BaseDungeonResult(dungeonManager.getDungeonData(), new DungeonEndStats(scene.getKilledMonsterCount(), 0, 0, endReason))));
    }
}
