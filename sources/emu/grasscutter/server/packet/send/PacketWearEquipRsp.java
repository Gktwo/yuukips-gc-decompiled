package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WearEquipRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWearEquipRsp.class */
public class PacketWearEquipRsp extends BasePacket {
    public PacketWearEquipRsp(long avatarGuid, long equipGuid) {
        super(625);
        setData(WearEquipRspOuterClass.WearEquipRsp.newBuilder().setAvatarGuid(avatarGuid).setEquipGuid(equipGuid).build());
    }
}
