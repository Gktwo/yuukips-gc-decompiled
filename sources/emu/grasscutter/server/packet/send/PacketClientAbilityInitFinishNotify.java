package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.ClientAbilityInitFinishNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketClientAbilityInitFinishNotify.class */
public class PacketClientAbilityInitFinishNotify extends BasePacket {
    public PacketClientAbilityInitFinishNotify(List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> entries) {
        super(1119, true);
        setData(ClientAbilityInitFinishNotifyOuterClass.ClientAbilityInitFinishNotify.newBuilder().setEntityId(entries.size() > 0 ? entries.get(0).getEntityId() : 0).addAllInvokes(entries).build());
    }
}
