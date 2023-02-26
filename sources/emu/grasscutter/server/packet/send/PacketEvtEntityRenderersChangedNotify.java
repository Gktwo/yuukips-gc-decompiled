package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EvtEntityRenderersChangedNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEvtEntityRenderersChangedNotify.class */
public class PacketEvtEntityRenderersChangedNotify extends BasePacket {
    public PacketEvtEntityRenderersChangedNotify(EvtEntityRenderersChangedNotifyOuterClass.EvtEntityRenderersChangedNotify req) {
        super(350, true);
        setData(req);
    }
}
