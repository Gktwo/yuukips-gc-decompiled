package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetFriendShowNameCardInfoRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetFriendShowNameCardInfoRsp.class */
public class PacketGetFriendShowNameCardInfoRsp extends BasePacket {
    public PacketGetFriendShowNameCardInfoRsp(int uid, List<Integer> cardIds) {
        super(PacketOpcodes.GetFriendShowNameCardInfoRsp);
        setData(GetFriendShowNameCardInfoRspOuterClass.GetFriendShowNameCardInfoRsp.newBuilder().setUid(uid).addAllShowNameCardIdList(cardIds).setRetcode(0).build());
    }
}
