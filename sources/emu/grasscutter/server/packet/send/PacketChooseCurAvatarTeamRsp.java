package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChooseCurAvatarTeamRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChooseCurAvatarTeamRsp.class */
public class PacketChooseCurAvatarTeamRsp extends BasePacket {
    public PacketChooseCurAvatarTeamRsp(int teamId) {
        super(PacketOpcodes.ChooseCurAvatarTeamRsp);
        setData(ChooseCurAvatarTeamRspOuterClass.ChooseCurAvatarTeamRsp.newBuilder().setCurTeamId(teamId).build());
    }
}
