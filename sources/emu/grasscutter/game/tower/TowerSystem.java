package emu.grasscutter.game.tower;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.TowerScheduleData;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/tower/TowerSystem.class */
public class TowerSystem extends BaseGameSystem {
    private TowerScheduleConfig towerScheduleConfig;

    public TowerSystem(GameServer server) {
        super(server);
        load();
    }

    public synchronized void load() {
        try {
            this.towerScheduleConfig = (TowerScheduleConfig) DataLoader.loadClass("TowerSchedule.json", TowerScheduleConfig.class);
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load tower schedule config.", (Throwable) e);
        }
    }

    public TowerScheduleConfig getTowerScheduleConfig() {
        return this.towerScheduleConfig;
    }

    public TowerScheduleData getCurrentTowerScheduleData() {
        TowerScheduleData data = GameData.getTowerScheduleDataMap().get(this.towerScheduleConfig.getScheduleId());
        if (data == null) {
            Grasscutter.getLogger().error("Could not get current tower schedule data by schedule id {}, please check your resource files", Integer.valueOf(this.towerScheduleConfig.getScheduleId()));
        }
        return data;
    }

    public List<Integer> getAllFloors() {
        List<Integer> floors = new ArrayList<>(getCurrentTowerScheduleData().getEntranceFloorId());
        floors.addAll(getScheduleFloors());
        return floors;
    }

    public List<Integer> getScheduleFloors() {
        return getCurrentTowerScheduleData().getSchedules().get(0).getFloorList();
    }

    public int getNextFloorId(int floorId) {
        List<Integer> entranceFloors = getCurrentTowerScheduleData().getEntranceFloorId();
        List<Integer> scheduleFloors = getScheduleFloors();
        int nextId = 0;
        for (int i = 0; i < entranceFloors.size() - 1; i++) {
            if (floorId == entranceFloors.get(i).intValue()) {
                nextId = entranceFloors.get(i + 1).intValue();
            }
        }
        if (floorId == entranceFloors.get(entranceFloors.size() - 1).intValue()) {
            nextId = scheduleFloors.get(0).intValue();
        }
        if (nextId != 0) {
            return nextId;
        }
        for (int i2 = 0; i2 < scheduleFloors.size() - 1; i2++) {
            if (floorId == scheduleFloors.get(i2).intValue()) {
                nextId = scheduleFloors.get(i2 + 1).intValue();
            }
        }
        return nextId;
    }

    public Integer getLastEntranceFloor() {
        return getCurrentTowerScheduleData().getEntranceFloorId().get(getCurrentTowerScheduleData().getEntranceFloorId().size() - 1);
    }
}
