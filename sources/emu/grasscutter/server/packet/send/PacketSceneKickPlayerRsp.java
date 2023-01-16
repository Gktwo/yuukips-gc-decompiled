package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneKickPlayerRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneKickPlayerRsp.class */
public class PacketSceneKickPlayerRsp extends BasePacket {
    public PacketSceneKickPlayerRsp(int targetUid) {
        super(PacketOpcodes.SceneKickPlayerRsp);
        setData(SceneKickPlayerRspOuterClass.SceneKickPlayerRsp.newBuilder().setTargetUid(targetUid).build());
    }

    public PacketSceneKickPlayerRsp() {
        super(PacketOpcodes.SceneKickPlayerRsp);
        setData(SceneKickPlayerRspOuterClass.SceneKickPlayerRsp.newBuilder().setRetcode(1).build());
    }
}
