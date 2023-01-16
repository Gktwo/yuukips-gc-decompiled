package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.activity.condition.ActivityConditions;
import emu.grasscutter.game.quest.enums.LogicType;
import java.util.List;

@ResourceType(name = {"NewActivityCondExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityCondExcelConfigData.class */
public class ActivityCondExcelConfigData extends GameResource {
    private int condId;
    private LogicType condComb;
    private List<ActivityConfigCondition> cond;

    public int getCondId() {
        return this.condId;
    }

    public LogicType getCondComb() {
        return this.condComb;
    }

    public List<ActivityConfigCondition> getCond() {
        return this.cond;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ActivityCondExcelConfigData$ActivityConfigCondition.class */
    public static class ActivityConfigCondition {
        private ActivityConditions type;
        private List<Integer> param;

        public ActivityConditions getType() {
            return this.type;
        }

        public List<Integer> getParam() {
            return this.param;
        }

        public int[] paramArray() {
            return this.param.stream().mapToInt((v0) -> {
                return v0.intValue();
            }).toArray();
        }
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.condId;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.cond.removeIf(c -> {
            return c.type == null;
        });
    }
}
