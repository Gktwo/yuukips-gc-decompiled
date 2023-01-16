package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.List;

@ResourceType(name = {"DailyTaskRewardExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DailyTaskRewardData.class */
public class DailyTaskRewardData extends GameResource {
    @SerializedName(value = "id", alternate = {"ID"})

    /* renamed from: id */
    private int f528id;
    private List<DropVec> dropVec;

    public List<DropVec> getDropVec() {
        return this.dropVec;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f528id;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DailyTaskRewardData$DropVec.class */
    public static class DropVec {
        private int dropId;
        private int previewRewardId;

        public int getDropId() {
            return this.dropId;
        }

        public int getPreviewRewardId() {
            return this.previewRewardId;
        }
    }
}
