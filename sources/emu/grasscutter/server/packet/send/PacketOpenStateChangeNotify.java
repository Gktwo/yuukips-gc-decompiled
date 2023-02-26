package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.OpenStateChangeNotifyOuterClass;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketOpenStateChangeNotify.class */
public class PacketOpenStateChangeNotify extends BasePacket {
    public PacketOpenStateChangeNotify(int openState, int value) {
        super(118);
        setData(OpenStateChangeNotifyOuterClass.OpenStateChangeNotify.newBuilder().putOpenStateMap(openState, value).build());
    }

    public PacketOpenStateChangeNotify(Map<Integer, Integer> map) {
        super(118);
        setData(OpenStateChangeNotifyOuterClass.OpenStateChangeNotify.newBuilder().putAllOpenStateMap(map).build());
    }
}
