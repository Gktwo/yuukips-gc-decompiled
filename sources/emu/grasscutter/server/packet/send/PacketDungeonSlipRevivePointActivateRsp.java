package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DungeonSlipRevivePointActivateRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDungeonSlipRevivePointActivateRsp.class */
public class PacketDungeonSlipRevivePointActivateRsp extends BasePacket {
    public PacketDungeonSlipRevivePointActivateRsp(boolean success, int pointId) {
        super(979);
        setData(DungeonSlipRevivePointActivateRspOuterClass.DungeonSlipRevivePointActivateRsp.newBuilder().setSlipRevivePointId(pointId).setRetcode(success ? 0 : -1));
    }
}
