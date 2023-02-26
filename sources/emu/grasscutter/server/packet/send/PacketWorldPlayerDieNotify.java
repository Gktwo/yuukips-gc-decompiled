package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerDieTypeOuterClass;
import emu.grasscutter.net.proto.WorldPlayerDieNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldPlayerDieNotify.class */
public class PacketWorldPlayerDieNotify extends BasePacket {
    public PacketWorldPlayerDieNotify(PlayerDieTypeOuterClass.PlayerDieType playerDieType, int killerId) {
        super(202);
        setData(WorldPlayerDieNotifyOuterClass.WorldPlayerDieNotify.newBuilder().setDieType(playerDieType).setMonsterId(killerId).build());
    }
}
