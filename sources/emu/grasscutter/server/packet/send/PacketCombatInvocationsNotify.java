package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass;
import emu.grasscutter.net.proto.CombatInvokeEntryOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCombatInvocationsNotify.class */
public class PacketCombatInvocationsNotify extends BasePacket {
    public PacketCombatInvocationsNotify(CombatInvokeEntryOuterClass.CombatInvokeEntry entry) {
        super(323, true);
        setData(CombatInvocationsNotifyOuterClass.CombatInvocationsNotify.newBuilder().addInvokeList(entry).build());
    }

    public PacketCombatInvocationsNotify(List<CombatInvokeEntryOuterClass.CombatInvokeEntry> entries) {
        super(323, true);
        setData(CombatInvocationsNotifyOuterClass.CombatInvocationsNotify.newBuilder().addAllInvokeList(entries).build());
    }
}
