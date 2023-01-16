package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPathfindingEnterSceneRsp;

@Opcodes(PacketOpcodes.PathfindingEnterSceneReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPathfindingEnterSceneReq.class */
public class HandlerPathfindingEnterSceneReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketPathfindingEnterSceneRsp(PacketHeadOuterClass.PacketHead.parseFrom(header).getClientSequenceId()));
    }
}
