package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetAllUnlockNameCardRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetAllUnlockNameCardRsp.class */
public class PacketGetAllUnlockNameCardRsp extends BasePacket {
    public PacketGetAllUnlockNameCardRsp(Player player) {
        super(PacketOpcodes.GetAllUnlockNameCardRsp);
        setData(GetAllUnlockNameCardRspOuterClass.GetAllUnlockNameCardRsp.newBuilder().addAllNameCardList(player.getNameCardList()).build());
    }
}
