package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.common.ItemParamStringData;
import java.util.Arrays;

@ResourceType(name = {"RewardPreviewExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGH)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/RewardPreviewData.class */
public class RewardPreviewData extends GameResource {

    /* renamed from: id */
    private int f552id;
    private ItemParamStringData[] previewItems;
    private ItemParamData[] previewItemsArray;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f552id;
    }

    public ItemParamData[] getPreviewItems() {
        return this.previewItemsArray;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        if (this.previewItems == null || this.previewItems.length <= 0) {
            this.previewItemsArray = new ItemParamData[0];
        } else {
            this.previewItemsArray = (ItemParamData[]) Arrays.stream(this.previewItems).filter(d -> {
                return d.getId() > 0 && d.getCount() != null && !d.getCount().isEmpty();
            }).map((v0) -> {
                return v0.toItemParamData();
            }).toArray(size -> {
                return new ItemParamData[size];
            });
        }
    }
}
