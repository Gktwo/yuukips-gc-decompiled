package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarTeamUpdateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarTeamUpdateNotify.class */
public class PacketAvatarTeamUpdateNotify extends BasePacket {
    public PacketAvatarTeamUpdateNotify(Player player) {
        super(PacketOpcodes.AvatarTeamUpdateNotify);
        AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.Builder proto = AvatarTeamUpdateNotifyOuterClass.AvatarTeamUpdateNotify.newBuilder();
        player.getTeamManager().getTeams().forEach(id, teamInfo -> {
            proto.putAvatarTeamMap(id.intValue(), teamInfo.toProto(player));
        });
        setData(proto);
    }
}
