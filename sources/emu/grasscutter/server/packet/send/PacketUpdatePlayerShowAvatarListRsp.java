package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UpdatePlayerShowAvatarListRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUpdatePlayerShowAvatarListRsp.class */
public class PacketUpdatePlayerShowAvatarListRsp extends BasePacket {
    public PacketUpdatePlayerShowAvatarListRsp(boolean isShowAvatar, List<Integer> avatarIds) {
        super(PacketOpcodes.UpdatePlayerShowAvatarListRsp);
        setData(UpdatePlayerShowAvatarListRspOuterClass.UpdatePlayerShowAvatarListRsp.newBuilder().setIsShowAvatar(isShowAvatar).addAllShowAvatarIdList(avatarIds).setRetcode(0).build());
    }
}
