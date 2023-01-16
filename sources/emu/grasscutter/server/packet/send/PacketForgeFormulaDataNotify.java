package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForgeFormulaDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketForgeFormulaDataNotify.class */
public class PacketForgeFormulaDataNotify extends BasePacket {
    public PacketForgeFormulaDataNotify(int itemId) {
        super(626);
        setData(ForgeFormulaDataNotifyOuterClass.ForgeFormulaDataNotify.newBuilder().setForgeId(itemId).setIsLocked(false).build());
    }
}
