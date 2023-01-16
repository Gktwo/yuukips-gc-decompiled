package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SyncScenePlayTeamEntityNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSyncScenePlayTeamEntityNotify.class */
public class PacketSyncScenePlayTeamEntityNotify extends BasePacket {
    public PacketSyncScenePlayTeamEntityNotify(Player player) {
        super(PacketOpcodes.SyncScenePlayTeamEntityNotify);
        setData(SyncScenePlayTeamEntityNotifyOuterClass.SyncScenePlayTeamEntityNotify.newBuilder().setSceneId(player.getSceneId()).build());
    }
}
