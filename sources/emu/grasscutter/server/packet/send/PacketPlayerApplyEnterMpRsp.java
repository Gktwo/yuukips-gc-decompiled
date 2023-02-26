package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerApplyEnterMpRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerApplyEnterMpRsp.class */
public class PacketPlayerApplyEnterMpRsp extends BasePacket {
    public PacketPlayerApplyEnterMpRsp(int targetUid) {
        super(1846);
        setData(PlayerApplyEnterMpRspOuterClass.PlayerApplyEnterMpRsp.newBuilder().setTargetUid(targetUid).build());
    }
}
