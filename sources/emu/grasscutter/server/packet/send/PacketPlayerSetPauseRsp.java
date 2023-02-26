package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerSetPauseRsp.class */
public class PacketPlayerSetPauseRsp extends BasePacket {
    public PacketPlayerSetPauseRsp(int clientSequence) {
        super(136);
        buildHeader(clientSequence);
    }
}
