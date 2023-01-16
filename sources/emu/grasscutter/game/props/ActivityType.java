package emu.grasscutter.game.props;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ActivityType.class */
public enum ActivityType {
    NONE(0),
    NEW_ACTIVITY_MUSIC_GAME(2202);
    
    private final int value;
    private static final Int2ObjectMap<ActivityType> map = new Int2ObjectOpenHashMap();
    private static final Map<String, ActivityType> stringMap = new HashMap();

    ActivityType(int value) {
        this.value = value;
    }

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    public int getValue() {
        return this.value;
    }

    public static ActivityType getTypeByValue(int value) {
        return map.getOrDefault(value, (int) NONE);
    }

    public static ActivityType getTypeByName(String name) {
        return stringMap.getOrDefault(name, NONE);
    }
}
