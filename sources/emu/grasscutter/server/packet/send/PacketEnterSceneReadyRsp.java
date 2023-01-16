package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EnterSceneReadyRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEnterSceneReadyRsp.class */
public class PacketEnterSceneReadyRsp extends BasePacket {
    public PacketEnterSceneReadyRsp(Player player) {
        super((int) PacketOpcodes.EnterSceneReadyRsp, 11);
        setData(EnterSceneReadyRspOuterClass.EnterSceneReadyRsp.newBuilder().setEnterSceneToken(player.getEnterSceneToken()).build().toByteArray());
    }
}
