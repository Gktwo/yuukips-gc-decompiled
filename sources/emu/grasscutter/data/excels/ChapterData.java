package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.HashMap;
import java.util.Map;

@ResourceType(name = {"ChapterExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ChapterData.class */
public class ChapterData extends GameResource {

    /* renamed from: id */
    private int f517id;
    private int beginQuestId;
    private int endQuestId;
    private int needPlayerLevel;
    public static final Map<Integer, ChapterData> beginQuestChapterMap = new HashMap();
    public static final Map<Integer, ChapterData> endQuestChapterMap = new HashMap();

    public void setId(int id) {
        this.f517id = id;
    }

    public void setBeginQuestId(int beginQuestId) {
        this.beginQuestId = beginQuestId;
    }

    public void setEndQuestId(int endQuestId) {
        this.endQuestId = endQuestId;
    }

    public void setNeedPlayerLevel(int needPlayerLevel) {
        this.needPlayerLevel = needPlayerLevel;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f517id;
    }

    public int getBeginQuestId() {
        return this.beginQuestId;
    }

    public int getEndQuestId() {
        return this.endQuestId;
    }

    public int getNeedPlayerLevel() {
        return this.needPlayerLevel;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        beginQuestChapterMap.put(Integer.valueOf(this.beginQuestId), this);
        beginQuestChapterMap.put(Integer.valueOf(this.endQuestId), this);
    }
}
