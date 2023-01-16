package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerApplyEnterMpResultRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerApplyEnterMpResultRsp.class */
public class PacketPlayerApplyEnterMpResultRsp extends BasePacket {
    public PacketPlayerApplyEnterMpResultRsp(int applyUid, boolean isAgreed) {
        super(PacketOpcodes.PlayerApplyEnterMpResultRsp);
        setData(PlayerApplyEnterMpResultRspOuterClass.PlayerApplyEnterMpResultRsp.newBuilder().setApplyUid(applyUid).setIsAgreed(isAgreed).build());
    }
}
