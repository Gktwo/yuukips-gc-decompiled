package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.BuyBattlePassLevelReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketBuyBattlePassLevelRsp;

@Opcodes(PacketOpcodes.BuyBattlePassLevelReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerBuyBattlePassLevelReq.class */
public class HandlerBuyBattlePassLevelReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketBuyBattlePassLevelRsp(session.getPlayer().getBattlePassManager().buyLevels(BuyBattlePassLevelReqOuterClass.BuyBattlePassLevelReq.parseFrom(payload).getBuyLevel())));
    }
}
