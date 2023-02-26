package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.TryEnterHomeReqOuterClass;
import emu.grasscutter.server.event.player.PlayerTeleportEvent;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp;

@Opcodes(PacketOpcodes.TryEnterHomeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTryEnterHomeReq.class */
public class HandlerTryEnterHomeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        TryEnterHomeReqOuterClass.TryEnterHomeReq req = TryEnterHomeReqOuterClass.TryEnterHomeReq.parseFrom(payload);
        Player targetPlayer = session.getServer().getPlayerByUid(req.getTargetUid(), true);
        if (req.getTargetUid() != session.getPlayer().getUid()) {
            switch (GameHome.getByUid(Integer.valueOf(req.getTargetUid())).getEnterHomeOption()) {
                case 1:
                    session.send(new PacketTryEnterHomeRsp(RetcodeOuterClass.Retcode.RET_HOME_HOME_REFUSE_GUEST_ENTER_VALUE, req.getTargetUid()));
                    return;
                case 0:
                    if (!targetPlayer.isOnline()) {
                        session.send(new PacketTryEnterHomeRsp(RetcodeOuterClass.Retcode.RET_HOME_OWNER_OFFLINE_VALUE, req.getTargetUid()));
                        return;
                    }
                    break;
            }
            session.send(new PacketTryEnterHomeRsp());
            return;
        }
        int realmId = 2000 + session.getPlayer().getCurrentRealmId();
        GameHome home = session.getPlayer().getHome();
        if (home.getHomeSceneItem(realmId) == null) {
            session.send(new PacketTryEnterHomeRsp());
            return;
        }
        home.save();
        if (session.getPlayer().getWorld().transferPlayerToScene(session.getPlayer(), realmId, PlayerTeleportEvent.TeleportType.WAYPOINT, session.getPlayer().getWorld().getSceneById(realmId).getScriptManager().getConfig().born_pos)) {
            session.send(new PacketTryEnterHomeRsp(req.getTargetUid()));
        }
    }
}
