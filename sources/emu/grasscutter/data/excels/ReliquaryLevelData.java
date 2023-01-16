package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.FightProperty;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatOpenHashMap;

@ResourceType(name = {"ReliquaryLevelExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ReliquaryLevelData.class */
public class ReliquaryLevelData extends GameResource {

    /* renamed from: id */
    private int f550id;
    private Int2FloatMap propMap;
    private int rank;
    private int level;
    private int exp;
    private List<RelicLevelProperty> addProps;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f550id;
    }

    public int getRank() {
        return this.rank;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public float getPropValue(FightProperty prop) {
        return getPropValue(prop.getId());
    }

    public float getPropValue(int id) {
        return this.propMap.getOrDefault(id, 0.0f);
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.f550id = (this.rank << 8) + getLevel();
        this.propMap = new Int2FloatOpenHashMap();
        for (RelicLevelProperty p : this.addProps) {
            this.propMap.put(FightProperty.getPropByName(p.getPropType()).getId(), p.getValue());
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/ReliquaryLevelData$RelicLevelProperty.class */
    public class RelicLevelProperty {
        private String propType;
        private float value;

        public RelicLevelProperty() {
        }

        public String getPropType() {
            return this.propType;
        }

        public float getValue() {
            return this.value;
        }
    }
}
