package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerTeamSelectRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketTowerTeamSelectRsp.class */
public class PacketTowerTeamSelectRsp extends BasePacket {
    public PacketTowerTeamSelectRsp() {
        super(PacketOpcodes.TowerTeamSelectRsp);
        setData(TowerTeamSelectRspOuterClass.TowerTeamSelectRsp.newBuilder().build());
    }
}
