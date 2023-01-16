package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeBgmNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeHomeBgmNotify.class */
public class PacketChangeHomeBgmNotify extends BasePacket {
    public PacketChangeHomeBgmNotify(int homeBgmId) {
        super(PacketOpcodes.HomeChangeBgmNotify);
        setData(HomeChangeBgmNotifyOuterClass.HomeChangeBgmNotify.newBuilder().setBgmId(homeBgmId).build());
    }
}
