package emu.grasscutter.server.packet.send;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.GetOnlinePlayerListRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetOnlinePlayerListRsp.class */
public class PacketGetOnlinePlayerListRsp extends BasePacket {
    public PacketGetOnlinePlayerListRsp(Player session) {
        super(62);
        List<Player> players = Grasscutter.getGameServer().getPlayers().values().stream().limit(50).toList();
        GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRsp.Builder proto = GetOnlinePlayerListRspOuterClass.GetOnlinePlayerListRsp.newBuilder();
        if (players.size() != 0) {
            for (Player player : players) {
                if (player.getUid() != session.getUid()) {
                    proto.addPlayerInfoList(player.getOnlinePlayerInfo());
                }
            }
        }
        setData(proto);
    }
}
