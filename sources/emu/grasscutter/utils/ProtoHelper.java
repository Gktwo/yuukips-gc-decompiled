package emu.grasscutter.utils;

import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.net.proto.PropValueOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/utils/ProtoHelper.class */
public final class ProtoHelper {
    public static PropValueOuterClass.PropValue newPropValue(PlayerProperty key, int value) {
        return PropValueOuterClass.PropValue.newBuilder().setType(key.getId()).setIval((long) value).setVal((long) value).build();
    }
}
