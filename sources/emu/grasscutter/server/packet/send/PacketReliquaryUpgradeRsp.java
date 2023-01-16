package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ReliquaryUpgradeRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketReliquaryUpgradeRsp.class */
public class PacketReliquaryUpgradeRsp extends BasePacket {
    public PacketReliquaryUpgradeRsp(GameItem relic, int rate, int oldLevel, List<Integer> oldAppendPropIdList) {
        super(607);
        setData(ReliquaryUpgradeRspOuterClass.ReliquaryUpgradeRsp.newBuilder().setTargetReliquaryGuid(relic.getGuid()).setOldLevel(oldLevel).setCurLevel(relic.getLevel()).setPowerUpRate(rate).addAllOldAppendPropList(oldAppendPropIdList).addAllCurAppendPropList(relic.getAppendPropIdList()).build());
    }
}