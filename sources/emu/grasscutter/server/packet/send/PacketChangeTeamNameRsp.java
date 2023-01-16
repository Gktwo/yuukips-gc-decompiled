package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChangeTeamNameRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeTeamNameRsp.class */
public class PacketChangeTeamNameRsp extends BasePacket {
    public PacketChangeTeamNameRsp(int teamId, String teamName) {
        super(PacketOpcodes.ChangeTeamNameRsp);
        setData(ChangeTeamNameRspOuterClass.ChangeTeamNameRsp.newBuilder().setTeamId(teamId).setTeamName(teamName).build());
    }
}
