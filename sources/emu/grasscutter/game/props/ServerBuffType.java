package emu.grasscutter.game.props;

import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ServerBuffType.class */
public enum ServerBuffType {
    SERVER_BUFF_NONE(0),
    SERVER_BUFF_AVATAR(1),
    SERVER_BUFF_TEAM(2),
    SERVER_BUFF_TOWER(3);
    
    private final int value;
    private static final Int2ObjectMap<ServerBuffType> map = new Int2ObjectOpenHashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
        });
    }

    ServerBuffType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ServerBuffType getTypeByValue(int value) {
        return map.getOrDefault(value, (int) SERVER_BUFF_NONE);
    }
}
