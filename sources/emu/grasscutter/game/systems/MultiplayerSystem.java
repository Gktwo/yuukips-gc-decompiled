package emu.grasscutter.game.systems;

import emu.grasscutter.game.CoopRequest;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.EnterReason;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.proto.EnterTypeOuterClass;
import emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketPlayerApplyEnterMpNotify;
import emu.grasscutter.server.packet.send.PacketPlayerApplyEnterMpResultNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneNotify;

/* loaded from: grasscutter.jar:emu/grasscutter/game/systems/MultiplayerSystem.class */
public class MultiplayerSystem extends BaseGameSystem {
    public MultiplayerSystem(GameServer server) {
        super(server);
    }

    public void applyEnterMp(Player player, int targetUid) {
        Player target = getServer().getPlayerByUid(targetUid);
        if (target == null) {
            player.sendPacket(new PacketPlayerApplyEnterMpResultNotify(targetUid, "", false, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason.REASON_PLAYER_CANNOT_ENTER_MP));
        } else if (!player.getWorld().isMultiplayer()) {
            CoopRequest request = target.getCoopRequests().get(player.getUid());
            if (request == null || request.isExpired()) {
                target.getCoopRequests().put(player.getUid(), (int) new CoopRequest(player));
                target.sendPacket(new PacketPlayerApplyEnterMpNotify(player));
            }
        }
    }

    public void applyEnterMpReply(Player hostPlayer, int applyUid, boolean isAgreed) {
        CoopRequest request = hostPlayer.getCoopRequests().get(applyUid);
        if (request != null && !request.isExpired()) {
            Player requester = request.getRequester();
            hostPlayer.getCoopRequests().remove(applyUid);
            if (requester.getWorld().isMultiplayer()) {
                request.getRequester().sendPacket(new PacketPlayerApplyEnterMpResultNotify(hostPlayer, false, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason.REASON_PLAYER_CANNOT_ENTER_MP));
                return;
            }
            request.getRequester().sendPacket(new PacketPlayerApplyEnterMpResultNotify(hostPlayer, isAgreed, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason.REASON_PLAYER_JUDGE));
            if (isAgreed) {
                if (!hostPlayer.getWorld().isMultiplayer()) {
                    new World(hostPlayer, true).addPlayer(hostPlayer);
                    hostPlayer.sendPacket(new PacketPlayerEnterSceneNotify(hostPlayer, hostPlayer, EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.HostFromSingleToMp, hostPlayer.getScene().getId(), hostPlayer.getPosition()));
                }
                requester.getPosition().set(hostPlayer.getPosition());
                requester.getRotation().set(hostPlayer.getRotation());
                requester.setSceneId(hostPlayer.getSceneId());
                hostPlayer.getWorld().addPlayer(requester);
                requester.sendPacket(new PacketPlayerEnterSceneNotify(requester, hostPlayer, EnterTypeOuterClass.EnterType.ENTER_TYPE_OTHER, EnterReason.TeamJoin, hostPlayer.getScene().getId(), hostPlayer.getPosition()));
            }
        }
    }

    public boolean leaveCoop(Player player) {
        if (!player.getWorld().isMultiplayer()) {
            return false;
        }
        for (Player p : player.getWorld().getPlayers()) {
            if (p.getSceneLoadState() != Player.SceneLoadState.LOADED) {
                return false;
            }
        }
        new World(player).addPlayer(player);
        player.sendPacket(new PacketPlayerEnterSceneNotify(player, EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.TeamBack, player.getScene().getId(), player.getPosition()));
        return true;
    }

    public boolean kickPlayer(Player player, int targetUid) {
        Player victim;
        if (!player.getWorld().isMultiplayer() || player.getWorld().getHost() != player || (victim = player.getServer().getPlayerByUid(targetUid)) == null || victim == player || victim.getSceneLoadState() != Player.SceneLoadState.LOADED) {
            return false;
        }
        new World(victim).addPlayer(victim);
        victim.sendPacket(new PacketPlayerEnterSceneNotify(victim, EnterTypeOuterClass.EnterType.ENTER_TYPE_SELF, EnterReason.TeamKick, victim.getScene().getId(), victim.getPosition()));
        return true;
    }
}
