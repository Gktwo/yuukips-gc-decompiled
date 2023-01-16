package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerMiddleLevelChangeTeamNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerMiddleLevelChangeTeamNotify.class */
public class PacketTowerMiddleLevelChangeTeamNotify extends BasePacket {
    public PacketTowerMiddleLevelChangeTeamNotify() {
        super(PacketOpcodes.TowerMiddleLevelChangeTeamNotify);
        setData(TowerMiddleLevelChangeTeamNotifyOuterClass.TowerMiddleLevelChangeTeamNotify.newBuilder().build());
    }
}
