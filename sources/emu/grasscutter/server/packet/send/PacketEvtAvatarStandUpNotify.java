package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.EvtAvatarStandUpNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketEvtAvatarStandUpNotify.class */
public class PacketEvtAvatarStandUpNotify extends BasePacket {
    public PacketEvtAvatarStandUpNotify(EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotify notify) {
        super(336);
        setData(EvtAvatarStandUpNotifyOuterClass.EvtAvatarStandUpNotify.newBuilder().setEntityId(notify.getEntityId()).setDirection(notify.getDirection()).setPerformId(notify.getPerformId()).setChairId(notify.getChairId()).build());
    }
}
