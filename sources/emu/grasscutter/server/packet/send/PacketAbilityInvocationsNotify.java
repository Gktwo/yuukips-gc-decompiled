package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilityInvocationsNotifyOuterClass;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAbilityInvocationsNotify.class */
public class PacketAbilityInvocationsNotify extends BasePacket {
    public PacketAbilityInvocationsNotify(AbilityInvokeEntryOuterClass.AbilityInvokeEntry entry) {
        super((int) PacketOpcodes.AbilityInvocationsNotify, true);
        setData(AbilityInvocationsNotifyOuterClass.AbilityInvocationsNotify.newBuilder().addInvokes(entry).build());
    }

    public PacketAbilityInvocationsNotify(List<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> entries) {
        super((int) PacketOpcodes.AbilityInvocationsNotify, true);
        setData(AbilityInvocationsNotifyOuterClass.AbilityInvocationsNotify.newBuilder().addAllInvokes(entries).build());
    }
}
