package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeModuleUnlockNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeModuleUnlockNotify.class */
public class PacketHomeModuleUnlockNotify extends BasePacket {
    public PacketHomeModuleUnlockNotify(int targetModuleId) {
        super(PacketOpcodes.HomeModuleUnlockNotify);
        setData(HomeModuleUnlockNotifyOuterClass.HomeModuleUnlockNotify.newBuilder().setModuleId(targetModuleId).build());
    }
}
