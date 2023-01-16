package emu.grasscutter.game.props;

import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseTarget.class */
public enum ItemUseTarget {
    ITEM_USE_TARGET_NONE(0),
    ITEM_USE_TARGET_CUR_AVATAR(1),
    ITEM_USE_TARGET_CUR_TEAM(2),
    ITEM_USE_TARGET_SPECIFY_AVATAR(3),
    ITEM_USE_TARGET_SPECIFY_ALIVE_AVATAR(4),
    ITEM_USE_TARGET_SPECIFY_DEAD_AVATAR(5);
    
    private final int value;
    private static final Int2ObjectMap<ItemUseTarget> map = new Int2ObjectOpenHashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
        });
    }

    ItemUseTarget(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ItemUseTarget getTypeByValue(int value) {
        return map.getOrDefault(value, (int) ITEM_USE_TARGET_NONE);
    }
}
