package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSceneForceLockNotify.class */
public class PacketSceneForceLockNotify extends BasePacket {
    public PacketSceneForceLockNotify(Collection<Integer> locked) {
        super(PacketOpcodes.SceneForceLockNotify);
        setData(SceneForceLockNotifyOuterClass.SceneForceLockNotify.newBuilder().addAllForceIdList(locked));
    }

    public PacketSceneForceLockNotify(int locked) {
        super(PacketOpcodes.SceneForceLockNotify);
        setData(SceneForceLockNotifyOuterClass.SceneForceLockNotify.newBuilder().addForceIdList(locked));
    }
}
