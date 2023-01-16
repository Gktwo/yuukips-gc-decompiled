package emu.grasscutter.game.props;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/FetterState.class */
public enum FetterState {
    NONE(0),
    NOT_OPEN(1),
    OPEN(1),
    FINISH(3);
    
    private final int value;
    private static final Int2ObjectMap<FetterState> map = new Int2ObjectOpenHashMap();
    private static final Map<String, FetterState> stringMap = new HashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    FetterState(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static FetterState getTypeByValue(int value) {
        return map.getOrDefault(value, (int) NONE);
    }

    public static FetterState getTypeByName(String name) {
        return stringMap.getOrDefault(name, NONE);
    }
}
