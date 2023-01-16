package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.quest.enums.LogicType;
import java.util.List;

@ResourceType(name = {"DungeonPassExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DungeonPassConfigData.class */
public class DungeonPassConfigData extends GameResource {

    /* renamed from: id */
    private int f534id;
    private LogicType logicType;
    private List<DungeonPassCondition> conds;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f534id;
    }

    public LogicType getLogicType() {
        return this.logicType;
    }

    public List<DungeonPassCondition> getConds() {
        return this.conds;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DungeonPassConfigData$DungeonPassCondition.class */
    public static class DungeonPassCondition {
        private DungeonPassConditionType condType;
        int[] param;

        public DungeonPassConditionType getCondType() {
            return this.condType;
        }

        public int[] getParam() {
            return this.param;
        }
    }
}
