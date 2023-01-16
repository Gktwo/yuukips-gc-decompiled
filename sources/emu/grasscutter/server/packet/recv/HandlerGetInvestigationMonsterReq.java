package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetInvestigationMonsterReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetInvestigationMonsterRsp;

@Opcodes(PacketOpcodes.GetInvestigationMonsterReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetInvestigationMonsterReq.class */
public class HandlerGetInvestigationMonsterReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetInvestigationMonsterRsp(session.getPlayer(), session.getServer().getWorldDataSystem(), GetInvestigationMonsterReqOuterClass.GetInvestigationMonsterReq.parseFrom(payload).getCityIdListList()));
    }
}
