package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ScenePointUnlockNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketScenePointUnlockNotify.class */
public class PacketScenePointUnlockNotify extends BasePacket {
    public PacketScenePointUnlockNotify(int sceneId, int pointId) {
        super(PacketOpcodes.ScenePointUnlockNotify);
        setData(ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotify.newBuilder().setSceneId(sceneId).addPointList(pointId).addUnhidePointList(pointId));
    }

    public PacketScenePointUnlockNotify(int sceneId, Iterable<Integer> pointIds) {
        super(PacketOpcodes.ScenePointUnlockNotify);
        setData(ScenePointUnlockNotifyOuterClass.ScenePointUnlockNotify.newBuilder().setSceneId(sceneId).addAllPointList(pointIds).addAllUnhidePointList(pointIds));
    }
}
