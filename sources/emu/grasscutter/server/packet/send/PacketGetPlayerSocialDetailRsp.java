package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetPlayerSocialDetailRspOuterClass;
import emu.grasscutter.net.proto.SocialDetailOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetPlayerSocialDetailRsp.class */
public class PacketGetPlayerSocialDetailRsp extends BasePacket {
    public PacketGetPlayerSocialDetailRsp(SocialDetailOuterClass.SocialDetail.Builder detail) {
        super(PacketOpcodes.GetPlayerSocialDetailRsp);
        GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRsp.Builder proto = GetPlayerSocialDetailRspOuterClass.GetPlayerSocialDetailRsp.newBuilder();
        if (detail != null) {
            proto.setDetailData(detail);
        } else {
            proto.setRetcode(1);
        }
        setData(proto);
    }
}
