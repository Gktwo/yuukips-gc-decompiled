package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneEntityDrownRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneEntityDrownRsp.class */
public class PacketSceneEntityDrownRsp extends BasePacket {
    public PacketSceneEntityDrownRsp(int entityId) {
        super(PacketOpcodes.SceneEntityDrownRsp);
        setData(SceneEntityDrownRspOuterClass.SceneEntityDrownRsp.newBuilder().setEntityId(entityId).build());
    }
}
