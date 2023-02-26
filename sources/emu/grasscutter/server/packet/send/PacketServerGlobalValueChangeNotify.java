package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ServerGlobalValueChangeNotifyOuterClass;
import emu.grasscutter.utils.Utils;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerGlobalValueChangeNotify.class */
public class PacketServerGlobalValueChangeNotify extends BasePacket {
    public PacketServerGlobalValueChangeNotify(int entityId, int value, String name_hash) {
        super(1116);
        setData(ServerGlobalValueChangeNotifyOuterClass.ServerGlobalValueChangeNotify.newBuilder().setEntityId(entityId).setValue((float) value).setKeyHash(Utils.abilityHash(name_hash)).build());
    }
}
