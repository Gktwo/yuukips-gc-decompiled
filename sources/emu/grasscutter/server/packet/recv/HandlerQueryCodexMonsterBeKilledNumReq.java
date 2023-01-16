package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QueryCodexMonsterBeKilledNumReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketQueryCodexMonsterBeKilledNumRsp;

@Opcodes(PacketOpcodes.QueryCodexMonsterBeKilledNumReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQueryCodexMonsterBeKilledNumReq.class */
public class HandlerQueryCodexMonsterBeKilledNumReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketQueryCodexMonsterBeKilledNumRsp(session.getPlayer(), QueryCodexMonsterBeKilledNumReqOuterClass.QueryCodexMonsterBeKilledNumReq.parseFrom(payload).getCodexIdListList()));
    }
}
