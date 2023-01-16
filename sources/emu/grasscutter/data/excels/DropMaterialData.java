package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"DropMaterialExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DropMaterialData.class */
public class DropMaterialData extends GameResource {

    /* renamed from: id */
    private int f529id;
    private boolean useOnGain;
    private boolean disableFirstGainHint;
    private boolean autoPick;
    private boolean dropSeparately;
    private int groupId;
    private boolean forceGainHint;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f529id;
    }

    public boolean isUseOnGain() {
        return this.useOnGain;
    }

    public boolean isDisableFirstGainHint() {
        return this.disableFirstGainHint;
    }

    public boolean isAutoPick() {
        return this.autoPick;
    }

    public boolean isDropSeparately() {
        return this.dropSeparately;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public boolean isForceGainHint() {
        return this.forceGainHint;
    }
}
