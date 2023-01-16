package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DeleteFriendRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDeleteFriendRsp.class */
public class PacketDeleteFriendRsp extends BasePacket {
    public PacketDeleteFriendRsp(int targetUid) {
        super(PacketOpcodes.DeleteFriendRsp);
        setData(DeleteFriendRspOuterClass.DeleteFriendRsp.newBuilder().setTargetUid(targetUid).build());
    }
}
