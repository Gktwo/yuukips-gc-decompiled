package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SelectWorktopOptionRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSelectWorktopOptionRsp.class */
public class PacketSelectWorktopOptionRsp extends BasePacket {
    public PacketSelectWorktopOptionRsp(int entityId, int optionId) {
        super(PacketOpcodes.SelectWorktopOptionRsp);
        setData(SelectWorktopOptionRspOuterClass.SelectWorktopOptionRsp.newBuilder().setGadgetEntityId(entityId).setOptionId(optionId).build());
    }
}
