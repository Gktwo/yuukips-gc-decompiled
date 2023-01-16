package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EndCameraSceneLookNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEndCameraSceneLookNotify.class */
public class PacketEndCameraSceneLookNotify extends BasePacket {
    public PacketEndCameraSceneLookNotify() {
        super(291);
        setData(EndCameraSceneLookNotifyOuterClass.EndCameraSceneLookNotify.newBuilder());
    }
}
