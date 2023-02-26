package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CombineFormulaDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCombineFormulaDataNotify.class */
public class PacketCombineFormulaDataNotify extends BasePacket {
    public PacketCombineFormulaDataNotify(int combineId) {
        super(626);
        setData(CombineFormulaDataNotifyOuterClass.CombineFormulaDataNotify.newBuilder().setCombineId(combineId).setIsLocked(false).build());
    }
}
