package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerCookArgsRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerCookArgsRsp.class */
public class PacketPlayerCookArgsRsp extends BasePacket {
    public PacketPlayerCookArgsRsp() {
        super(111);
        setData(PlayerCookArgsRspOuterClass.PlayerCookArgsRsp.newBuilder().build());
    }
}
