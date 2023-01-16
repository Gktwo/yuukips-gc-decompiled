package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UnlockNameCardNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockNameCardNotify.class */
public class PacketUnlockNameCardNotify extends BasePacket {
    public PacketUnlockNameCardNotify(int nameCard) {
        super(PacketOpcodes.UnlockNameCardNotify);
        setData(UnlockNameCardNotifyOuterClass.UnlockNameCardNotify.newBuilder().setNameCardId(nameCard).build());
    }
}
