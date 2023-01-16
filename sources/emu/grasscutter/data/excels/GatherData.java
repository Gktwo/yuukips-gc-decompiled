package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"GatherExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/GatherData.class */
public class GatherData extends GameResource {
    private int pointType;

    /* renamed from: id */
    private int f538id;
    private int gadgetId;
    private int itemId;

    /* renamed from: cd */
    private int f539cd;
    private boolean isForbidGuest;
    private boolean initDisableInteract;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.pointType;
    }

    public int getGatherId() {
        return this.f538id;
    }

    public int getGadgetId() {
        return this.gadgetId;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getCd() {
        return this.f539cd;
    }

    public boolean isForbidGuest() {
        return this.isForbidGuest;
    }

    public boolean initDisableInteract() {
        return this.initDisableInteract;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
