package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SetPlayerNameRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetPlayerNameRsp.class */
public class PacketSetPlayerNameRsp extends BasePacket {
    public PacketSetPlayerNameRsp(Player player) {
        super(192);
        setData(SetPlayerNameRspOuterClass.SetPlayerNameRsp.newBuilder().setNickName(player.getNickname()).build());
    }
}
