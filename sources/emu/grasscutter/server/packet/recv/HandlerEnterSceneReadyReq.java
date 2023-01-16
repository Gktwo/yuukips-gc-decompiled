package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEnterScenePeerNotify;
import emu.grasscutter.server.packet.send.PacketEnterSceneReadyRsp;

@Opcodes(PacketOpcodes.EnterSceneReadyReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEnterSceneReadyReq.class */
public class HandlerEnterSceneReadyReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) {
        session.send(new PacketEnterScenePeerNotify(session.getPlayer()));
        session.send(new PacketEnterSceneReadyRsp(session.getPlayer()));
    }
}
