package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DeleteFriendNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDeleteFriendNotify.class */
public class PacketDeleteFriendNotify extends BasePacket {
    public PacketDeleteFriendNotify(int targetUid) {
        super(PacketOpcodes.DeleteFriendNotify);
        setData(DeleteFriendNotifyOuterClass.DeleteFriendNotify.newBuilder().setTargetUid(targetUid).build());
    }
}
