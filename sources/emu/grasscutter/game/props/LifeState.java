package emu.grasscutter.game.props;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/LifeState.class */
public enum LifeState {
    LIFE_NONE(0),
    LIFE_ALIVE(1),
    LIFE_DEAD(2),
    LIFE_REVIVE(3);
    
    private final int value;
    private static final Int2ObjectMap<LifeState> map = new Int2ObjectOpenHashMap();
    private static final Map<String, LifeState> stringMap = new HashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    LifeState(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static LifeState getTypeByValue(int value) {
        return map.getOrDefault(value, (int) LIFE_NONE);
    }

    public static LifeState getTypeByName(String name) {
        return stringMap.getOrDefault(name, LIFE_NONE);
    }
}