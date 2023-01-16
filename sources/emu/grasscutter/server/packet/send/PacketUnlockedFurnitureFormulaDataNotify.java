package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.UnlockedFurnitureFormulaDataNotifyOuterClass;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketUnlockedFurnitureFormulaDataNotify.class */
public class PacketUnlockedFurnitureFormulaDataNotify extends BasePacket {
    public PacketUnlockedFurnitureFormulaDataNotify(Set<Integer> unlockList) {
        super(PacketOpcodes.UnlockedFurnitureFormulaDataNotify);
        UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotify.Builder proto = UnlockedFurnitureFormulaDataNotifyOuterClass.UnlockedFurnitureFormulaDataNotify.newBuilder();
        proto.addAllFurnitureIdList(unlockList);
        proto.setIsAll(true);
        setData(proto);
    }
}
