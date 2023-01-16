package emu.grasscutter.game.dungeons;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.PacketDungeonSettleNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/BasicDungeonSettleListener.class */
public class BasicDungeonSettleListener implements DungeonSettleListener {
    @Override // emu.grasscutter.game.dungeons.DungeonSettleListener
    public void onDungeonSettle(DungeonManager dungeonManager, BaseDungeonResult.DungeonEndReason endReason) {
        Scene scene = dungeonManager.getScene();
        scene.broadcastPacket(new PacketDungeonSettleNotify(new BaseDungeonResult(dungeonManager.getDungeonData(), new DungeonEndStats(scene.getKilledMonsterCount(), 0, 0, endReason))));
        for (GameEntity entry : scene.getEntities().values().stream().filter(gameEntity -> {
            return gameEntity instanceof EntityGadget;
        }).toList()) {
            Grasscutter.getLogger().warn("Get DGT {} -> {},{},{}", Integer.valueOf(entry.getId()), Integer.valueOf(entry.getEntityType()), Integer.valueOf(entry.getBlockId()), Integer.valueOf(entry.getConfigId()));
        }
    }
}
