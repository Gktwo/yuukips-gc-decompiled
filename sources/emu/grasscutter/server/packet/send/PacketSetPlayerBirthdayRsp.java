package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetPlayerBirthdayRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetPlayerBirthdayRsp.class */
public class PacketSetPlayerBirthdayRsp extends BasePacket {
    public PacketSetPlayerBirthdayRsp(int retCode) {
        super(PacketOpcodes.SetPlayerBirthdayRsp);
        setData(SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRsp.newBuilder().setRetcode(retCode).build());
    }

    public PacketSetPlayerBirthdayRsp(Player player) {
        super(PacketOpcodes.SetPlayerBirthdayRsp);
        setData(SetPlayerBirthdayRspOuterClass.SetPlayerBirthdayRsp.newBuilder().setBirthday(player.getBirthday().toProto()).build());
    }
}
