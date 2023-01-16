package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetPlayerSignatureRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetPlayerSignatureRsp.class */
public class PacketSetPlayerSignatureRsp extends BasePacket {
    public PacketSetPlayerSignatureRsp(Player player) {
        super(PacketOpcodes.SetPlayerSignatureRsp);
        setData(SetPlayerSignatureRspOuterClass.SetPlayerSignatureRsp.newBuilder().setSignature(player.getSignature()).build());
    }
}
