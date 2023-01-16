package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetFriendShowAvatarInfoRspOuterClass;
import emu.grasscutter.net.proto.ShowAvatarInfoOuterClass;
import java.util.List;

@Opcodes(PacketOpcodes.GetFriendShowAvatarInfoRsp)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetFriendShowAvatarInfoRsp.class */
public class PacketGetFriendShowAvatarInfoRsp extends BasePacket {
    public PacketGetFriendShowAvatarInfoRsp(int uid, List<ShowAvatarInfoOuterClass.ShowAvatarInfo> showAvatarInfoList) {
        super(PacketOpcodes.GetFriendShowAvatarInfoRsp);
        setData(GetFriendShowAvatarInfoRspOuterClass.GetFriendShowAvatarInfoRsp.newBuilder().setUid(uid).addAllShowAvatarInfoList(showAvatarInfoList).build());
    }
}
