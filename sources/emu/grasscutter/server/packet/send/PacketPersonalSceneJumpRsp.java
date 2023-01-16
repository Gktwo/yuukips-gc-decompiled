package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PersonalSceneJumpRspOuterClass;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPersonalSceneJumpRsp.class */
public class PacketPersonalSceneJumpRsp extends BasePacket {
    public PacketPersonalSceneJumpRsp(int sceneId, Position pos) {
        super(PacketOpcodes.PersonalSceneJumpRsp);
        setData(PersonalSceneJumpRspOuterClass.PersonalSceneJumpRsp.newBuilder().setDestSceneId(sceneId).setDestPos(pos.toProto()).build());
    }
}
