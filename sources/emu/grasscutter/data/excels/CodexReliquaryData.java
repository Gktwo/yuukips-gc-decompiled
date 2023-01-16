package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import p014it.unimi.dsi.fastutil.ints.IntCollection;
import p014it.unimi.dsi.fastutil.ints.IntList;

@ResourceType(name = {"ReliquaryCodexExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexReliquaryData.class */
public class CodexReliquaryData extends GameResource {

    /* renamed from: Id */
    private int f521Id;
    private int suitId;
    private int level;
    private int cupId;
    private int leatherId;
    private int capId;
    private int flowerId;
    private int sandId;
    private int sortOrder;
    private transient IntCollection ids;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f521Id;
    }

    public int getSuitId() {
        return this.suitId;
    }

    public int getLevel() {
        return this.level;
    }

    public int getCupId() {
        return this.cupId;
    }

    public int getLeatherId() {
        return this.leatherId;
    }

    public int getCapId() {
        return this.capId;
    }

    public int getFlowerId() {
        return this.flowerId;
    }

    public int getSandId() {
        return this.sandId;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public boolean containsId(int id) {
        return getIds().contains(id);
    }

    public IntCollection getIds() {
        if (this.ids == null) {
            this.ids = IntList.m717of(this.cupId, this.leatherId, this.capId, this.flowerId, this.sandId);
        }
        return this.ids;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.cupId = (this.cupId / 10) * 10;
        this.leatherId = (this.leatherId / 10) * 10;
        this.capId = (this.capId / 10) * 10;
        this.flowerId = (this.flowerId / 10) * 10;
        this.sandId = (this.sandId / 10) * 10;
        GameData.getCodexReliquaryArrayList().add(this);
        GameData.getCodexReliquaryDataIdMap().put(getSuitId(), (int) this);
    }
}
