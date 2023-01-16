package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketFireworkRsp.class */
public class PacketFireworkRsp extends BasePacket {
    public PacketFireworkRsp() {
        super(PacketOpcodes.FireworkRsp);
    }
}
