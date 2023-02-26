package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CutSceneBeginNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCutSceneBeginNotify.class */
public class PacketCutSceneBeginNotify extends BasePacket {
    public PacketCutSceneBeginNotify(boolean isWaitOthers, int cutsceneId) {
        super(PacketOpcodes.CutSceneBeginNotify);
        setData(CutSceneBeginNotifyOuterClass.CutSceneBeginNotify.newBuilder().setIsWaitOthers(isWaitOthers).setCutsceneId(cutsceneId).build());
    }
}
