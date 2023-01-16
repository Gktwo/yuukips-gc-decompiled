package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.TeamInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetUpAvatarTeamRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetUpAvatarTeamRsp.class */
public class PacketSetUpAvatarTeamRsp extends BasePacket {
    public PacketSetUpAvatarTeamRsp(Player player, int teamId, TeamInfo teamInfo) {
        super(PacketOpcodes.SetUpAvatarTeamRsp);
        SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRsp.Builder proto = SetUpAvatarTeamRspOuterClass.SetUpAvatarTeamRsp.newBuilder().setTeamId(teamId).setCurAvatarGuid(player.getTeamManager().getCurrentCharacterGuid());
        for (Integer num : teamInfo.getAvatars()) {
            proto.addAvatarTeamGuidList(player.getAvatars().getAvatarById(num.intValue()).getGuid());
        }
        setData(proto);
    }
}
