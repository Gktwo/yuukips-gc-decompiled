package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetBattlePassViewedRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetBattlePassViewedRsp.class */
public class PacketSetBattlePassViewedRsp extends BasePacket {
    public PacketSetBattlePassViewedRsp(int scheduleId) {
        super(PacketOpcodes.SetBattlePassViewedRsp);
        setData(SetBattlePassViewedRspOuterClass.SetBattlePassViewedRsp.newBuilder().setScheduleId(scheduleId).build());
    }
}
