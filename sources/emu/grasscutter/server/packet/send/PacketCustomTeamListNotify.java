package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarTeamAllDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCustomTeamListNotify.class */
public class PacketCustomTeamListNotify extends BasePacket {
    public PacketCustomTeamListNotify(Player player) {
        super(PacketOpcodes.AvatarTeamAllDataNotify);
        AvatarTeamAllDataNotifyOuterClass.AvatarTeamAllDataNotify.Builder proto = AvatarTeamAllDataNotifyOuterClass.AvatarTeamAllDataNotify.newBuilder();
        for (Integer num : player.getTeamManager().getTeams().keySet()) {
            int id = num.intValue();
            if (id > 4) {
                proto.addBackupAvatarTeamOrderList(id);
            }
        }
        player.getTeamManager().getTeams().forEach(id2, teamInfo -> {
            proto.putAvatarTeamMap(id2.intValue(), teamInfo.toProto(player));
        });
        setData(proto);
    }
}
