package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityChangeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAbilityChangeNotify.class */
public class PacketAbilityChangeNotify extends BasePacket {
    public PacketAbilityChangeNotify(EntityAvatar entity) {
        super((int) PacketOpcodes.AbilityChangeNotify, true);
        setData(AbilityChangeNotifyOuterClass.AbilityChangeNotify.newBuilder().setEntityId(entity.getId()).setAbilityControlBlock(entity.getAbilityControlBlock()).build());
    }
}
