package emu.grasscutter.data.common;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DailyDungeonData;
import emu.grasscutter.utils.Position;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/PointData.class */
public class PointData {

    /* renamed from: id */
    private int f510id;
    private String $type;
    private Position tranPos;
    @SerializedName(value = "dungeonIds", alternate = {"JHHFPGJNMIN"})
    private int[] dungeonIds;
    @SerializedName(value = "dungeonRandomList", alternate = {"OIBKFJNBLHO"})
    private int[] dungeonRandomList;
    @SerializedName(value = "tranSceneId", alternate = {"JHBICGBAPIH"})
    private int tranSceneId;

    public int getId() {
        return this.f510id;
    }

    public void setId(int id) {
        this.f510id = id;
    }

    public Position getTranPos() {
        return this.tranPos;
    }

    public int[] getDungeonIds() {
        return this.dungeonIds;
    }

    public int[] getDungeonRandomList() {
        return this.dungeonRandomList;
    }

    public int getTranSceneId() {
        return this.tranSceneId;
    }

    public void setTranSceneId(int tranSceneId) {
        this.tranSceneId = tranSceneId;
    }

    public String getType() {
        return this.$type;
    }

    public void updateDailyDungeon() {
        if (!(this.dungeonRandomList == null || this.dungeonRandomList.length == 0)) {
            IntList newDungeons = new IntArrayList();
            int day = Grasscutter.getCurrentDayOfWeek();
            for (int randomId : this.dungeonRandomList) {
                DailyDungeonData data = GameData.getDailyDungeonDataMap().get(randomId);
                if (data != null) {
                    for (int d : data.getDungeonsByDay(day)) {
                        newDungeons.add(d);
                    }
                }
            }
            this.dungeonIds = newDungeons.toIntArray();
        }
    }
}
