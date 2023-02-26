package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SceneKickPlayerReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSceneKickPlayerRsp;

@Opcodes(238)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSceneKickPlayerReq.class */
public class HandlerSceneKickPlayerReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SceneKickPlayerReqOuterClass.SceneKickPlayerReq req = SceneKickPlayerReqOuterClass.SceneKickPlayerReq.parseFrom(payload);
        if (session.getServer().getMultiplayerSystem().kickPlayer(session.getPlayer(), req.getTargetUid())) {
            session.send(new PacketSceneKickPlayerRsp(req.getTargetUid()));
        } else {
            session.send(new PacketSceneKickPlayerRsp());
        }
    }
}
