package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.EquipType;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AvatarEquipChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarEquipChangeNotify.class */
public class PacketAvatarEquipChangeNotify extends BasePacket {
    public PacketAvatarEquipChangeNotify(Avatar avatar, GameItem item) {
        super(676);
        AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotify.Builder proto = AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setEquipType(item.getEquipSlot()).setItemId(item.getItemId()).setEquipGuid(item.getGuid());
        if (item.getItemData().getEquipType() == EquipType.EQUIP_WEAPON) {
            proto.setWeapon(item.createSceneWeaponInfo());
        } else {
            proto.setReliquary(item.createSceneReliquaryInfo());
        }
        setData(proto);
    }

    public PacketAvatarEquipChangeNotify(Avatar avatar, EquipType slot) {
        super(676);
        setData(AvatarEquipChangeNotifyOuterClass.AvatarEquipChangeNotify.newBuilder().setAvatarGuid(avatar.getGuid()).setEquipType(slot.getValue()));
    }
}
