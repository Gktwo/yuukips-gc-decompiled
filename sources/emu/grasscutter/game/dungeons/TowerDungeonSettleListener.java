package emu.grasscutter.game.dungeons;

import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.game.dungeons.dungeon_results.BaseDungeonResult;
import emu.grasscutter.game.dungeons.dungeon_results.TowerResult;
import emu.grasscutter.game.tower.TowerManager;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.PacketDungeonSettleNotify;
import emu.grasscutter.server.packet.send.PacketTowerFloorRecordChangeNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/TowerDungeonSettleListener.class */
public class TowerDungeonSettleListener implements DungeonSettleListener {
    @Override // emu.grasscutter.game.dungeons.DungeonSettleListener
    public void onDungeonSettle(DungeonManager dungeonManager, BaseDungeonResult.DungeonEndReason endReason) {
        Scene scene = dungeonManager.getScene();
        DungeonData dungeonData = dungeonManager.getDungeonData();
        if (!scene.getScriptManager().getVariables().containsKey("stage") || scene.getScriptManager().getVariables().get("stage").intValue() != 1) {
            TowerManager towerManager = scene.getPlayers().get(0).getTowerManager();
            towerManager.notifyCurLevelRecordChangeWhenDone(3);
            scene.broadcastPacket(new PacketTowerFloorRecordChangeNotify(towerManager.getCurrentFloorId(), 3, towerManager.canEnterScheduleFloor()));
            WorldChallenge challenge = scene.getChallenge();
            if (challenge != null) {
                scene.broadcastPacket(new PacketDungeonSettleNotify(new TowerResult(dungeonData, new DungeonEndStats(scene.getKilledMonsterCount(), challenge.getFinishedTime(), 0, endReason), towerManager, challenge)));
            }
        }
    }
}
