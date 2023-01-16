package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"PersonalLineExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/PersonalLineData.class */
public class PersonalLineData extends GameResource {

    /* renamed from: id */
    private int f548id;
    private int avatarID;
    private List<Integer> preQuestId;
    private int startQuestId;
    private int chapterId;

    public void setId(int id) {
        this.f548id = id;
    }

    public void setAvatarID(int avatarID) {
        this.avatarID = avatarID;
    }

    public void setPreQuestId(List<Integer> preQuestId) {
        this.preQuestId = preQuestId;
    }

    public void setStartQuestId(int startQuestId) {
        this.startQuestId = startQuestId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f548id;
    }

    public int getAvatarID() {
        return this.avatarID;
    }

    public List<Integer> getPreQuestId() {
        return this.preQuestId;
    }

    public int getStartQuestId() {
        return this.startQuestId;
    }

    public int getChapterId() {
        return this.chapterId;
    }
}
