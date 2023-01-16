package emu.grasscutter.game.tower;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.TowerFloorData;
import emu.grasscutter.game.dungeons.DungeonSettleListener;
import emu.grasscutter.game.dungeons.TowerDungeonSettleListener;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketCanUseSkillNotify;
import emu.grasscutter.server.packet.send.PacketTowerCurLevelRecordChangeNotify;
import emu.grasscutter.server.packet.send.PacketTowerEnterLevelRsp;
import emu.grasscutter.server.packet.send.PacketTowerLevelStarCondNotify;
import emu.grasscutter.server.packet.send.PacketTowerMiddleLevelChangeTeamNotify;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/tower/TowerManager.class */
public class TowerManager extends BasePlayerManager {
    private static final List<DungeonSettleListener> towerDungeonSettleListener = List.of(new TowerDungeonSettleListener());

    public TowerManager(Player player) {
        super(player);
    }

    public TowerData getTowerData() {
        return getPlayer().getTowerData();
    }

    public int getCurrentFloorId() {
        return getTowerData().currentFloorId;
    }

    public int getCurrentLevelId() {
        return getTowerData().currentLevelId + getTowerData().currentLevel;
    }

    public int getCurrentLevel() {
        return getTowerData().currentLevel + 1;
    }

    public Map<Integer, TowerLevelRecord> getRecordMap() {
        Map<Integer, TowerLevelRecord> recordMap = getTowerData().recordMap;
        if (recordMap == null || recordMap.size() == 0) {
            recordMap = new HashMap();
            recordMap.put(1001, new TowerLevelRecord(1001));
            getTowerData().recordMap = recordMap;
        }
        return recordMap;
    }

    public void teamSelect(int floor, List<List<Long>> towerTeams) {
        TowerFloorData floorData = GameData.getTowerFloorDataMap().get(floor);
        getTowerData().currentFloorId = floorData.getFloorId();
        getTowerData().currentLevel = 0;
        getTowerData().currentLevelId = ((Integer) GameData.getTowerLevelDataMap().values().stream().filter(x -> {
            return x.getLevelGroupId() == floorData.getLevelGroupId() && x.getLevelIndex() == 1;
        }).findFirst().map((v0) -> {
            return v0.getId();
        }).orElse(0)).intValue();
        if (getTowerData().entryScene == 0) {
            getTowerData().entryScene = this.player.getSceneId();
        }
        this.player.getTeamManager().setupTemporaryTeam(towerTeams);
    }

    public void enterLevel(int enterPointId) {
        int dungeonId = GameData.getTowerLevelDataMap().get(getCurrentLevelId()).getDungeonId();
        notifyCurLevelRecordChange();
        this.player.getTeamManager().useTemporaryTeam(0);
        this.player.getServer().getDungeonSystem().handoffDungeon(this.player, dungeonId, towerDungeonSettleListener);
        this.player.getScene().setPrevScene(getTowerData().entryScene);
        this.player.getScene().setPrevScenePoint(enterPointId);
        this.player.getSession().send(new PacketTowerEnterLevelRsp(getTowerData().currentFloorId, getCurrentLevel()));
        this.player.getSession().send(new PacketCanUseSkillNotify(false));
        this.player.getSession().send(new PacketTowerLevelStarCondNotify(getTowerData().currentFloorId, getCurrentLevel()));
    }

    public void notifyCurLevelRecordChange() {
        this.player.getSession().send(new PacketTowerCurLevelRecordChangeNotify(getTowerData().currentFloorId, getCurrentLevel()));
    }

    public void notifyCurLevelRecordChangeWhenDone(int stars) {
        Map<Integer, TowerLevelRecord> recordMap = getRecordMap();
        int currentFloorId = getTowerData().currentFloorId;
        if (!recordMap.containsKey(Integer.valueOf(currentFloorId))) {
            recordMap.put(Integer.valueOf(currentFloorId), new TowerLevelRecord(currentFloorId).setLevelStars(getCurrentLevelId(), stars));
        } else {
            recordMap.put(Integer.valueOf(currentFloorId), recordMap.get(Integer.valueOf(currentFloorId)).setLevelStars(getCurrentLevelId(), stars));
        }
        getTowerData().currentLevel++;
        if (!hasNextLevel()) {
            int nextFloorId = getNextFloorId();
            recordMap.computeIfAbsent(Integer.valueOf(nextFloorId), (v1) -> {
                return new TowerLevelRecord(v1);
            });
            this.player.getSession().send(new PacketTowerCurLevelRecordChangeNotify(nextFloorId, 1));
            return;
        }
        this.player.getSession().send(new PacketTowerCurLevelRecordChangeNotify(currentFloorId, getCurrentLevel()));
    }

    public boolean hasNextLevel() {
        return getTowerData().currentLevel < 3;
    }

    public int getNextFloorId() {
        return this.player.getServer().getTowerSystem().getNextFloorId(getTowerData().currentFloorId);
    }

    public boolean hasNextFloor() {
        return this.player.getServer().getTowerSystem().getNextFloorId(getTowerData().currentFloorId) > 0;
    }

    public void clearEntry() {
        getTowerData().entryScene = 0;
    }

    public boolean canEnterScheduleFloor() {
        Map<Integer, TowerLevelRecord> recordMap = getRecordMap();
        return recordMap.containsKey(this.player.getServer().getTowerSystem().getLastEntranceFloor()) && recordMap.get(this.player.getServer().getTowerSystem().getLastEntranceFloor()).getStarCount() >= 6;
    }

    public void mirrorTeamSetUp(int teamId) {
        this.player.getTeamManager().useTemporaryTeam(teamId);
        this.player.sendPacket(new PacketTowerMiddleLevelChangeTeamNotify());
    }
}
