package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EnterSceneDoneRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEnterSceneDoneRsp.class */
public class PacketEnterSceneDoneRsp extends BasePacket {
    public PacketEnterSceneDoneRsp(Player player) {
        super(PacketOpcodes.EnterSceneDoneRsp);
        setData(EnterSceneDoneRspOuterClass.EnterSceneDoneRsp.newBuilder().setEnterSceneToken(player.getEnterSceneToken()).build());
    }
}
