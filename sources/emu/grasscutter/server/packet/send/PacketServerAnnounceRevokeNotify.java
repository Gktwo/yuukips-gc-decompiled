package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ServerAnnounceRevokeNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketServerAnnounceRevokeNotify.class */
public class PacketServerAnnounceRevokeNotify extends BasePacket {
    public PacketServerAnnounceRevokeNotify(int tplId) {
        super(PacketOpcodes.ServerAnnounceRevokeNotify);
        ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotify.Builder proto = ServerAnnounceRevokeNotifyOuterClass.ServerAnnounceRevokeNotify.newBuilder();
        proto.addConfigIdList(tplId);
        setData(proto);
    }
}
