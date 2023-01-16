package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketHomeUnknown2Rsp.class */
public class PacketHomeUnknown2Rsp extends BasePacket {
    public PacketHomeUnknown2Rsp() {
        super(PacketOpcodes.HomeEnterEditModeFinishRsp);
    }
}
