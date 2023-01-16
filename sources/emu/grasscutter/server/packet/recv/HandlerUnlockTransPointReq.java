package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.UnlockTransPointReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketUnlockTransPointRsp;

@Opcodes(PacketOpcodes.UnlockTransPointReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerUnlockTransPointReq.class */
public class HandlerUnlockTransPointReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        UnlockTransPointReqOuterClass.UnlockTransPointReq req = UnlockTransPointReqOuterClass.UnlockTransPointReq.parseFrom(payload);
        session.getPlayer().sendPacket(new PacketUnlockTransPointRsp(session.getPlayer().getProgressManager().unlockTransPoint(req.getSceneId(), req.getPointId(), false) ? RetcodeOuterClass.Retcode.RET_SUCC : RetcodeOuterClass.Retcode.RET_FAIL));
    }
}
