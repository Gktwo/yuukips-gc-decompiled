package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WeaponPromoteRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWeaponPromoteRsp.class */
public class PacketWeaponPromoteRsp extends BasePacket {
    public PacketWeaponPromoteRsp(GameItem item, int oldPromoteLevel) {
        super(689);
        setData(WeaponPromoteRspOuterClass.WeaponPromoteRsp.newBuilder().setTargetWeaponGuid(item.getGuid()).setCurPromoteLevel(item.getPromoteLevel()).setOldPromoteLevel(oldPromoteLevel).build());
    }
}
