package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetBattlePassViewedReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetBattlePassViewedRsp;

@Opcodes(PacketOpcodes.SetBattlePassViewedReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetBattlePassViewedReq.class */
public class HandlerSetBattlePassViewedReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetBattlePassViewedReqOuterClass.SetBattlePassViewedReq req = SetBattlePassViewedReqOuterClass.SetBattlePassViewedReq.parseFrom(payload);
        session.getPlayer().getBattlePassManager().updateViewed();
        session.send(new PacketSetBattlePassViewedRsp(req.getScheduleId()));
    }
}
