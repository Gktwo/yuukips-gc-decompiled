package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomePreChangeEditModeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomePreChangeEditModeNotify.class */
public class PacketHomePreChangeEditModeNotify extends BasePacket {
    public PacketHomePreChangeEditModeNotify(boolean isEnterEditMode) {
        super(PacketOpcodes.HomePreChangeEditModeNotify);
        HomePreChangeEditModeNotifyOuterClass.HomePreChangeEditModeNotify.Builder proto = HomePreChangeEditModeNotifyOuterClass.HomePreChangeEditModeNotify.newBuilder();
        proto.setIsEnterEditMode(isEnterEditMode);
        setData(proto);
    }
}
