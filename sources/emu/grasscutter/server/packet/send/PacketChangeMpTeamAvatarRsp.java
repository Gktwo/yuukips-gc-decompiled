package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.TeamInfo;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChangeMpTeamAvatarRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChangeMpTeamAvatarRsp.class */
public class PacketChangeMpTeamAvatarRsp extends BasePacket {
    public PacketChangeMpTeamAvatarRsp(Player player, TeamInfo teamInfo) {
        super(PacketOpcodes.ChangeMpTeamAvatarRsp);
        ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRsp.Builder proto = ChangeMpTeamAvatarRspOuterClass.ChangeMpTeamAvatarRsp.newBuilder().setCurAvatarGuid(player.getTeamManager().getCurrentCharacterGuid());
        for (Integer num : teamInfo.getAvatars()) {
            proto.addAvatarGuidList(player.getAvatars().getAvatarById(num.intValue()).getGuid());
        }
        setData(proto);
    }
}
