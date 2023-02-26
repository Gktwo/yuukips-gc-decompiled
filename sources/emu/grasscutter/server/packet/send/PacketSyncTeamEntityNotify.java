package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass;
import emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass;
import emu.grasscutter.net.proto.TeamEntityInfoOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSyncTeamEntityNotify.class */
public class PacketSyncTeamEntityNotify extends BasePacket {
    public PacketSyncTeamEntityNotify(Player player) {
        super(327);
        SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotify.Builder proto = SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotify.newBuilder().setSceneId(player.getSceneId());
        if (player.getWorld().isMultiplayer()) {
            for (Player p : player.getWorld().getPlayers()) {
                if (player != p) {
                    proto.addTeamEntityInfoList(TeamEntityInfoOuterClass.TeamEntityInfo.newBuilder().setTeamEntityId(p.getTeamManager().getEntityId()).setAuthorityPeerId(p.getPeerId()).setTeamAbilityInfo(AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.newBuilder()).build());
                }
            }
        }
        setData(proto);
    }
}
