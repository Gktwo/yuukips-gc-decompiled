package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ServerTimeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerTimeNotify.class */
public class PacketServerTimeNotify extends BasePacket {
    public PacketServerTimeNotify() {
        super(57);
        setData(ServerTimeNotifyOuterClass.ServerTimeNotify.newBuilder().setServerTime(System.currentTimeMillis()).build());
    }
}
