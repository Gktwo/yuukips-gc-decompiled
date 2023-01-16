package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"BlossomRefreshExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BlossomRefreshExcelConfigData.class */
public class BlossomRefreshExcelConfigData extends GameResource {

    /* renamed from: id */
    private int f516id;
    private long nameTextMapHash;
    private long descTextMapHash;
    private String icon;
    private String clientShowType;
    private String refreshType;
    private int refreshCount;
    private String refreshTime;
    private RefreshCond[] refreshCondVec;
    private int cityId;
    private int blossomChestId;
    private Drop[] dropVec;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f516id;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public long getDescTextMapHash() {
        return this.descTextMapHash;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getClientShowType() {
        return this.clientShowType;
    }

    public String getRefreshType() {
        return this.refreshType;
    }

    public int getRefreshCount() {
        return this.refreshCount;
    }

    public String getRefreshTime() {
        return this.refreshTime;
    }

    public RefreshCond[] getRefreshCondVec() {
        return this.refreshCondVec;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getBlossomChestId() {
        return this.blossomChestId;
    }

    public Drop[] getDropVec() {
        return this.dropVec;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BlossomRefreshExcelConfigData$Drop.class */
    public static class Drop {
        int dropId;
        int previewReward;

        public int getDropId() {
            return this.dropId;
        }

        public int getPreviewReward() {
            return this.previewReward;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BlossomRefreshExcelConfigData$RefreshCond.class */
    public static class RefreshCond {
        String type;
        List<Integer> param;

        public String getType() {
            return this.type;
        }

        public List<Integer> getParam() {
            return this.param;
        }
    }
}
