package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerChatRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerChatRsp.class */
public class PacketPlayerChatRsp extends BasePacket {
    public PacketPlayerChatRsp() {
        super(PacketOpcodes.PlayerChatRsp);
        setData(PlayerChatRspOuterClass.PlayerChatRsp.newBuilder().build());
    }
}
