package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SceneAreaUnlockNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneAreaUnlockNotify.class */
public class PacketSceneAreaUnlockNotify extends BasePacket {
    public PacketSceneAreaUnlockNotify(int sceneId, int areaId) {
        super(207);
        setData(SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotify.newBuilder().setSceneId(sceneId).addAreaList(areaId));
    }

    public PacketSceneAreaUnlockNotify(int sceneId, Iterable<Integer> areaIds) {
        super(207);
        setData(SceneAreaUnlockNotifyOuterClass.SceneAreaUnlockNotify.newBuilder().setSceneId(sceneId).addAllAreaList(areaIds));
    }
}
