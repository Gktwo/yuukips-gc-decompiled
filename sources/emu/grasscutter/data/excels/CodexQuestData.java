package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"QuestCodexExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CodexQuestData.class */
public class CodexQuestData extends GameResource {

    /* renamed from: Id */
    private int f520Id;
    private int parentQuestId;
    private int chapterId;
    private int sortOrder;
    private boolean isDisuse;

    public int getParentQuestId() {
        return this.parentQuestId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f520Id;
    }

    public int getChapterId() {
        return this.chapterId;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public boolean getIsDisuse() {
        return this.isDisuse;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        if (!getIsDisuse()) {
            GameData.getCodexQuestDataIdMap().put(getParentQuestId(), (int) this);
        }
    }
}
