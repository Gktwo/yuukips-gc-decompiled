package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DailyTaskFilterCityRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDailyTaskFilterRsp.class */
public class PacketDailyTaskFilterRsp extends BasePacket {
    public PacketDailyTaskFilterRsp(int cityId) {
        super(172);
        setData(DailyTaskFilterCityRspOuterClass.DailyTaskFilterCityRsp.newBuilder().setCityId(cityId).build());
    }
}
