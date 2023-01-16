package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.OpenCondData;
import java.util.List;

@ResourceType(name = {"FetterInfoExcelConfigData.json", "FettersExcelConfigData.json", "FetterStoryExcelConfigData.json", "PhotographExpressionExcelConfigData.json", "PhotographPosenameExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/FetterData.class */
public class FetterData extends GameResource {
    private int avatarId;
    private int fetterId;
    private List<OpenCondData> openCond;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.fetterId;
    }

    public int getAvatarId() {
        return this.avatarId;
    }

    public List<OpenCondData> getOpenConds() {
        return this.openCond;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
