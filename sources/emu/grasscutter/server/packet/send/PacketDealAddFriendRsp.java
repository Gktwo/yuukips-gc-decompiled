package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DealAddFriendResultTypeOuterClass;
import emu.grasscutter.net.proto.DealAddFriendRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDealAddFriendRsp.class */
public class PacketDealAddFriendRsp extends BasePacket {
    public PacketDealAddFriendRsp(int targetUid, DealAddFriendResultTypeOuterClass.DealAddFriendResultType result) {
        super(PacketOpcodes.DealAddFriendRsp);
        setData(DealAddFriendRspOuterClass.DealAddFriendRsp.newBuilder().setTargetUid(targetUid).setDealAddFriendResult(result).build());
    }
}
