package emu.grasscutter.game.activity.condition;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ActivityCondExcelConfigData;
import emu.grasscutter.game.activity.PlayerActivityData;
import java.util.Map;
import p014it.unimi.dsi.fastutil.ints.AbstractInt2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/PlayerActivityDataMappingBuilder.class */
public class PlayerActivityDataMappingBuilder {
    private final Map<Integer, PlayerActivityData> playerActivityDataMap;
    private final Int2ObjectMap<ActivityCondExcelConfigData> activityCondMap = GameData.getActivityCondExcelConfigDataMap();

    public static Int2ObjectMap<PlayerActivityData> buildPlayerActivityDataByActivityCondId(Map<Integer, PlayerActivityData> activities) {
        return new PlayerActivityDataMappingBuilder(activities).buildMappings();
    }

    public PlayerActivityDataMappingBuilder(Map<Integer, PlayerActivityData> playerActivityDataMap) {
        this.playerActivityDataMap = playerActivityDataMap;
    }

    private Int2ObjectMap<PlayerActivityData> buildMappings() {
        Int2ObjectMap<PlayerActivityData> result = new Int2ObjectRBTreeMap<>();
        this.activityCondMap.int2ObjectEntrySet().stream().map(entry -> {
            return new AbstractInt2ObjectMap.BasicEntry(entry.getIntKey(), getPlayerActivityDataByCondId(Integer.valueOf(entry.getIntKey())));
        }).filter(entry -> {
            return entry.getValue() != null;
        }).forEach(entry -> {
            result.put(entry.getIntKey(), (int) ((PlayerActivityData) entry.getValue()));
        });
        return result;
    }

    private PlayerActivityData getPlayerActivityDataByCondId(Integer key) {
        return this.playerActivityDataMap.get(detectActivityDataIdByCondId(key));
    }

    private Integer detectActivityDataIdByCondId(Integer key) {
        if (key.intValue() / 10 == 1001 || key.intValue() / 10 == 1002) {
            return 1001;
        }
        if (key.intValue() / 100 == 5001) {
            return Integer.valueOf(key.intValue() / 100);
        }
        return Integer.valueOf(key.intValue() / 1000);
    }
}
