package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ChangeGameTimeRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeGameTimeRsp.class */
public class PacketChangeGameTimeRsp extends BasePacket {
    public PacketChangeGameTimeRsp(Player player) {
        super(114);
        setData(ChangeGameTimeRspOuterClass.ChangeGameTimeRsp.newBuilder().setCurGameTime(player.getScene().getTime()).build());
    }
}
