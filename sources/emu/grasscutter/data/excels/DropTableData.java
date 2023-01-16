package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.DropItemData;
import java.util.List;

@ResourceType(name = {"DropTableExcelConfigData.json", "DropSubTableExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DropTableData.class */
public class DropTableData extends GameResource {

    /* renamed from: id */
    private int f530id;
    private int randomType;
    private int dropLevel;
    private List<DropItemData> dropVec;
    private int nodeType;
    private boolean fallToGround;
    private int sourceType;
    private int everydayLimit;
    private int historyLimit;
    private int activityLimit;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f530id;
    }

    public int getRandomType() {
        return this.randomType;
    }

    public int getDropLevel() {
        return this.dropLevel;
    }

    public List<DropItemData> getDropVec() {
        return this.dropVec;
    }

    public int getNodeType() {
        return this.nodeType;
    }

    public boolean isFallToGround() {
        return this.fallToGround;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public int getEverydayLimit() {
        return this.everydayLimit;
    }

    public int getHistoryLimit() {
        return this.historyLimit;
    }

    public int getActivityLimit() {
        return this.activityLimit;
    }
}
