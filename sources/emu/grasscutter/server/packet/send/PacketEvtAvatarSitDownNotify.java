package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EvtAvatarSitDownNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEvtAvatarSitDownNotify.class */
public class PacketEvtAvatarSitDownNotify extends BasePacket {
    public PacketEvtAvatarSitDownNotify(EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotify notify) {
        super(322);
        setData(EvtAvatarSitDownNotifyOuterClass.EvtAvatarSitDownNotify.newBuilder().setEntityId(notify.getEntityId()).setPosition(notify.getPosition()).setChairId(notify.getChairId()).build());
    }
}
