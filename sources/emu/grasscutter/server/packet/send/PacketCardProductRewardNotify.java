package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CardProductRewardNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCardProductRewardNotify.class */
public class PacketCardProductRewardNotify extends BasePacket {
    public PacketCardProductRewardNotify(int remainsDay) {
        super(PacketOpcodes.CardProductRewardNotify);
        setData(CardProductRewardNotifyOuterClass.CardProductRewardNotify.newBuilder().setProductId("ys_chn_blessofmoon_tier5").setHcoin(90).setRemainDays(remainsDay).build());
    }
}
