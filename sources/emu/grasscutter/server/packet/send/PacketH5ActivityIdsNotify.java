package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.H5ActivityIdsNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketH5ActivityIdsNotify.class */
public class PacketH5ActivityIdsNotify extends BasePacket {
    public PacketH5ActivityIdsNotify() {
        super(PacketOpcodes.H5ActivityIdsNotify);
        setData(H5ActivityIdsNotifyOuterClass.H5ActivityIdsNotify.newBuilder().build());
    }
}
