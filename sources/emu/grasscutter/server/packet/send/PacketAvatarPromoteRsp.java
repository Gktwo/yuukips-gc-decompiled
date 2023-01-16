package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarPromoteRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarPromoteRsp.class */
public class PacketAvatarPromoteRsp extends BasePacket {
    public PacketAvatarPromoteRsp(Avatar avatar) {
        super(PacketOpcodes.AvatarPromoteRsp);
        setData(AvatarPromoteRspOuterClass.AvatarPromoteRsp.newBuilder().setGuid(avatar.getGuid()).build());
    }
}
