package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TakeBattlePassRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.TakeBattlePassRewardReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTakeBattlePassRewardReq.class */
public class HandlerTakeBattlePassRewardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getBattlePassManager().takeReward(TakeBattlePassRewardReqOuterClass.TakeBattlePassRewardReq.parseFrom(payload).getTakeOptionListList());
    }
}
