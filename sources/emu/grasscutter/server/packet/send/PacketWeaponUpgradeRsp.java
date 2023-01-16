package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWeaponUpgradeRsp.class */
public class PacketWeaponUpgradeRsp extends BasePacket {
    public PacketWeaponUpgradeRsp(GameItem item, int oldLevel, List<ItemParamOuterClass.ItemParam> leftoverOres) {
        super(673);
        setData(WeaponUpgradeRspOuterClass.WeaponUpgradeRsp.newBuilder().setTargetWeaponGuid(item.getGuid()).setCurLevel(item.getLevel()).setOldLevel(oldLevel).addAllItemParamList(leftoverOres).build());
    }
}
