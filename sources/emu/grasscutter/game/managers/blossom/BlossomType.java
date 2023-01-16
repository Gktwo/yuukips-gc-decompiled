package emu.grasscutter.game.managers.blossom;

import emu.grasscutter.utils.Utils;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/blossom/BlossomType.class */
public enum BlossomType {
    GOLD(70360056, 101001001, 1),
    BLUE(70360057, 101002003, 2);
    
    private final int gadgetId;
    private final int circleCampId;
    private final int blossomChestId;
    private static final Int2ObjectMap<BlossomType> map = new Int2ObjectOpenHashMap((Map) Stream.of((Object[]) values()).collect(Collectors.toMap(x -> {
        return Integer.valueOf(x.getGadgetId());
    }, x -> {
        return x;
    })));

    public int getGadgetId() {
        return this.gadgetId;
    }

    public int getCircleCampId() {
        return this.circleCampId;
    }

    public int getBlossomChestId() {
        return this.blossomChestId;
    }

    BlossomType(int gadgetId, int circleCampId, int blossomChestId) {
        this.gadgetId = gadgetId;
        this.circleCampId = circleCampId;
        this.blossomChestId = blossomChestId;
    }

    public static BlossomType valueOf(int i) {
        return map.get(i);
    }

    public static BlossomType random() {
        BlossomType[] values = values();
        return values[Utils.randomRange(0, values.length)];
    }
}
