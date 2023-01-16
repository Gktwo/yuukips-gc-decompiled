package emu.grasscutter.game.inventory;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/ItemQuality.class */
public enum ItemQuality {
    QUALITY_NONE(0),
    QUALITY_WHITE(1),
    QUALITY_GREEN(2),
    QUALITY_BLUE(3),
    QUALITY_PURPLE(4),
    QUALITY_ORANGE(5),
    QUALITY_ORANGE_SP(105);
    
    private final int value;
    private static final Int2ObjectMap<ItemQuality> map = new Int2ObjectOpenHashMap();
    private static final Map<String, ItemQuality> stringMap = new HashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    ItemQuality(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ItemQuality getTypeByValue(int value) {
        return map.getOrDefault(value, (int) QUALITY_NONE);
    }

    public static ItemQuality getTypeByName(String name) {
        return stringMap.getOrDefault(name, QUALITY_NONE);
    }
}
