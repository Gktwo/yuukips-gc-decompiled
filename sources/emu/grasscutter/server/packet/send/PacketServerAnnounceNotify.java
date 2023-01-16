package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AnnounceDataOuterClass;
import emu.grasscutter.net.proto.ServerAnnounceNotifyOuterClass;
import emu.grasscutter.utils.Utils;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerAnnounceNotify.class */
public class PacketServerAnnounceNotify extends BasePacket {
    public PacketServerAnnounceNotify(List<AnnounceDataOuterClass.AnnounceData> data) {
        super(PacketOpcodes.ServerAnnounceNotify);
        ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.Builder proto = ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.newBuilder();
        proto.addAllAnnounceDataList(data);
        setData(proto);
    }

    public PacketServerAnnounceNotify(String msg, int configId) {
        super(PacketOpcodes.ServerAnnounceNotify);
        ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.Builder proto = ServerAnnounceNotifyOuterClass.ServerAnnounceNotify.newBuilder();
        proto.addAnnounceDataList(AnnounceDataOuterClass.AnnounceData.newBuilder().setConfigId(configId).setBeginTime(Utils.getCurrentSeconds() + 1).setEndTime(Utils.getCurrentSeconds() + 2).setCenterSystemText(msg).setCenterSystemFrequency(1).build());
        setData(proto);
    }
}
