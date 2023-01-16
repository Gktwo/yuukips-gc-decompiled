package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WeaponAwakenRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWeaponAwakenRsp.class */
public class PacketWeaponAwakenRsp extends BasePacket {
    public PacketWeaponAwakenRsp(Avatar avatar, GameItem item, GameItem feedWeapon, int oldRefineLevel) {
        super(610);
        WeaponAwakenRspOuterClass.WeaponAwakenRsp.Builder proto = WeaponAwakenRspOuterClass.WeaponAwakenRsp.newBuilder().setTargetWeaponGuid(item.getGuid()).setTargetWeaponAwakenLevel(item.getRefinement());
        for (Integer num : item.getAffixes()) {
            int affixId = num.intValue();
            proto.putOldAffixLevelMap(affixId, oldRefineLevel);
            proto.putCurAffixLevelMap(affixId, item.getRefinement());
        }
        if (avatar != null) {
            proto.setAvatarGuid(avatar.getGuid());
        }
        setData(proto);
    }
}
