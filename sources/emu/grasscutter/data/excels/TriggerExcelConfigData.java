package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"TriggerExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/TriggerExcelConfigData.class */
public class TriggerExcelConfigData extends GameResource {

    /* renamed from: id */
    private int f554id;
    private int sceneId;
    private int groupId;
    private String triggerName;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f554id;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public String getTriggerName() {
        return this.triggerName;
    }
}
