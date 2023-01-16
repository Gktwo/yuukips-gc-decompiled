package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.TakeoffEquipRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTakeoffEquipRsp.class */
public class PacketTakeoffEquipRsp extends BasePacket {
    public PacketTakeoffEquipRsp(long avatarGuid, int slot) {
        super(690);
        setData(TakeoffEquipRspOuterClass.TakeoffEquipRsp.newBuilder().setAvatarGuid(avatarGuid).setSlot(slot).build());
    }
}
