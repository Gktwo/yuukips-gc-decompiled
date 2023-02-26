package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.SetEquipLockStateRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetEquipLockStateRsp.class */
public class PacketSetEquipLockStateRsp extends BasePacket {
    public PacketSetEquipLockStateRsp(GameItem equip) {
        super(611);
        buildHeader(0);
        setData(SetEquipLockStateRspOuterClass.SetEquipLockStateRsp.newBuilder().setTargetEquipGuid(equip.getGuid()).setIsLocked(equip.isLocked()).build());
    }
}
