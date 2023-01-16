package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AddQuestContentProgressRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAddQuestContentProgressRsp.class */
public class PacketAddQuestContentProgressRsp extends BasePacket {
    public PacketAddQuestContentProgressRsp(int contentType) {
        super(PacketOpcodes.AddQuestContentProgressRsp);
        AddQuestContentProgressRspOuterClass.AddQuestContentProgressRsp.Builder proto = AddQuestContentProgressRspOuterClass.AddQuestContentProgressRsp.newBuilder();
        proto.setContentType(contentType);
        setData(proto);
    }
}
