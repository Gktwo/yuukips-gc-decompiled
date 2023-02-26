package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneInitFinishRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneInitFinishRsp.class */
public class PacketSceneInitFinishRsp extends BasePacket {
    public PacketSceneInitFinishRsp(Player player) {
        super((int) PacketOpcodes.SceneInitFinishRsp, 11);
        setData(SceneInitFinishRspOuterClass.SceneInitFinishRsp.newBuilder().setEnterSceneToken(player.getEnterSceneToken()).build().toByteArray());
    }
}
