package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCalcWeaponUpgradeReturnItemsRsp.class */
public class PacketCalcWeaponUpgradeReturnItemsRsp extends BasePacket {
    public PacketCalcWeaponUpgradeReturnItemsRsp(long itemGuid, List<ItemParamOuterClass.ItemParam> returnItems) {
        super(652);
        setData(CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRsp.newBuilder().setTargetWeaponGuid(itemGuid).addAllItemParamList(returnItems).build());
    }

    public PacketCalcWeaponUpgradeReturnItemsRsp() {
        super(652);
        setData(CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRsp.newBuilder().setRetcode(1).build());
    }
}
