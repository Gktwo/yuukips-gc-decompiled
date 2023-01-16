package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneForceUnlockNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneForceUnlockNotify.class */
public class PacketSceneForceUnlockNotify extends BasePacket {
    public PacketSceneForceUnlockNotify(Collection<Integer> unlocked, boolean isAdd) {
        super(PacketOpcodes.SceneForceUnlockNotify);
        setData(SceneForceUnlockNotifyOuterClass.SceneForceUnlockNotify.newBuilder().addAllForceIdList(unlocked).setIsAdd(isAdd));
    }

    public PacketSceneForceUnlockNotify(int unlocked, boolean isAdd) {
        super(PacketOpcodes.SceneForceUnlockNotify);
        setData(SceneForceUnlockNotifyOuterClass.SceneForceUnlockNotify.newBuilder().addForceIdList(unlocked).setIsAdd(isAdd));
    }
}
