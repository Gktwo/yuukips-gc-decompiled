package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GachaWishRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGachaWishRsp.class */
public class PacketGachaWishRsp extends BasePacket {
    public PacketGachaWishRsp(int gachaType, int scheduleId, int itemId, int progress, int maxProgress) {
        super(PacketOpcodes.GachaWishRsp);
        setData(GachaWishRspOuterClass.GachaWishRsp.newBuilder().setGachaType(gachaType).setGachaScheduleId(scheduleId).setWishItemId(itemId).setWishProgress(progress).setWishMaxProgress(maxProgress).build());
    }
}
