package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AskAddFriendRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAskAddFriendRsp.class */
public class PacketAskAddFriendRsp extends BasePacket {
    public PacketAskAddFriendRsp(int targetUid) {
        super(PacketOpcodes.AskAddFriendRsp);
        setData(AskAddFriendRspOuterClass.AskAddFriendRsp.newBuilder().setTargetUid(targetUid).build());
    }
}
