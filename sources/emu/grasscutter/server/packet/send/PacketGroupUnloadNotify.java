package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GroupUnloadNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGroupUnloadNotify.class */
public class PacketGroupUnloadNotify extends BasePacket {
    public PacketGroupUnloadNotify(List<Integer> groupList) {
        super(PacketOpcodes.GroupUnloadNotify);
        GroupUnloadNotifyOuterClass.GroupUnloadNotify.Builder proto = GroupUnloadNotifyOuterClass.GroupUnloadNotify.newBuilder();
        proto.addAllGroupList(groupList);
        setData(proto);
    }
}
