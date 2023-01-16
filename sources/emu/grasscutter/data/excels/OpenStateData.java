package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import java.util.ArrayList;
import java.util.List;

@ResourceType(name = {"OpenStateConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/OpenStateData.class */
public class OpenStateData extends GameResource {

    /* renamed from: id */
    private int f547id;
    private boolean defaultState;
    private boolean allowClientOpen;
    private int systemOpenUiId;
    private List<OpenStateCond> cond;

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/OpenStateData$OpenStateCondType.class */
    public enum OpenStateCondType {
        OPEN_STATE_COND_PLAYER_LEVEL,
        OPEN_STATE_COND_QUEST,
        OPEN_STATE_OFFERING_LEVEL,
        OPEN_STATE_CITY_REPUTATION_LEVEL,
        OPEN_STATE_COND_PARENT_QUEST
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f547id;
    }

    public boolean isDefaultState() {
        return this.defaultState;
    }

    public boolean isAllowClientOpen() {
        return this.allowClientOpen;
    }

    public int getSystemOpenUiId() {
        return this.systemOpenUiId;
    }

    public List<OpenStateCond> getCond() {
        return this.cond;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/OpenStateData$OpenStateCond.class */
    public static class OpenStateCond {
        private OpenStateCondType condType;
        private int param;
        private int param2;

        public OpenStateCondType getCondType() {
            return this.condType;
        }

        public int getParam() {
            return this.param;
        }

        public int getParam2() {
            return this.param2;
        }
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        GameData.getOpenStateList().add(this);
        if (this.cond != null) {
            this.cond.removeIf(c -> {
                return c.getCondType() == null;
            });
        } else {
            this.cond = new ArrayList();
        }
    }
}
