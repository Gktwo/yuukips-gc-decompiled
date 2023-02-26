package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SceneTransToPointRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneTransToPointRsp.class */
public class PacketSceneTransToPointRsp extends BasePacket {
    public PacketSceneTransToPointRsp(Player player, int pointId, int sceneId) {
        super(300);
        setData(SceneTransToPointRspOuterClass.SceneTransToPointRsp.newBuilder().setRetcode(0).setPointId(pointId).setSceneId(sceneId).build());
    }

    public PacketSceneTransToPointRsp() {
        super(300);
        setData(SceneTransToPointRspOuterClass.SceneTransToPointRsp.newBuilder().setRetcode(1).build());
    }
}
