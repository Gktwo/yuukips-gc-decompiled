package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.ItemParamData;
import java.util.List;

@ResourceType(name = {"EnvAnimalGatherExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/EnvAnimalGatherConfigData.class */
public class EnvAnimalGatherConfigData extends GameResource {
    private int animalId;
    private String entityType;
    private List<ItemParamData> gatherItemId;
    private String excludeWeathers;
    private int aliveTime;
    private int escapeTime;
    private int escapeRadius;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.animalId;
    }

    public int getAnimalId() {
        return this.animalId;
    }

    public String getEntityType() {
        return this.entityType;
    }

    public ItemParamData getGatherItem() {
        if (this.gatherItemId.size() > 0) {
            return this.gatherItemId.get(0);
        }
        return null;
    }
}
