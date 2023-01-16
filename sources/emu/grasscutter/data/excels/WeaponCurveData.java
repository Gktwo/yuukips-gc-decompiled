package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.data.common.CurveInfo;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@ResourceType(name = {"WeaponCurveExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/WeaponCurveData.class */
public class WeaponCurveData extends GameResource {
    private int level;
    private CurveInfo[] curveInfos;
    private Map<String, Float> curveInfosMap;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.level;
    }

    public float getMultByProp(String fightProp) {
        return this.curveInfosMap.getOrDefault(fightProp, Float.valueOf(1.0f)).floatValue();
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.curveInfosMap = new HashMap();
        Stream.of((Object[]) this.curveInfos).forEach(info -> {
            this.curveInfosMap.put(info.getType(), Float.valueOf(info.getValue()));
        });
    }
}
