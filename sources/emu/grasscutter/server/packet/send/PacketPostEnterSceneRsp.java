package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PostEnterSceneRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPostEnterSceneRsp.class */
public class PacketPostEnterSceneRsp extends BasePacket {
    public PacketPostEnterSceneRsp(Player player) {
        super(PacketOpcodes.PostEnterSceneRsp);
        setData(PostEnterSceneRspOuterClass.PostEnterSceneRsp.newBuilder().setEnterSceneToken(player.getEnterSceneToken()).build());
    }
}
