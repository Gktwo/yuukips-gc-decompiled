package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeSceneJumpRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeSceneJumpRsp.class */
public class PacketHomeSceneJumpRsp extends BasePacket {
    public PacketHomeSceneJumpRsp(boolean enterRoomScene) {
        super(PacketOpcodes.HomeSceneJumpRsp);
        HomeSceneJumpRspOuterClass.HomeSceneJumpRsp.Builder proto = HomeSceneJumpRspOuterClass.HomeSceneJumpRsp.newBuilder();
        proto.setIsEnterRoomScene(enterRoomScene);
        setData(proto);
    }
}
