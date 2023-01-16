package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.ReliquaryUpgradeReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(644)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerReliquaryUpgradeReq.class */
public class HandlerReliquaryUpgradeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ReliquaryUpgradeReqOuterClass.ReliquaryUpgradeReq req = ReliquaryUpgradeReqOuterClass.ReliquaryUpgradeReq.parseFrom(payload);
        session.getServer().getInventorySystem().upgradeRelic(session.getPlayer(), req.getTargetReliquaryGuid(), req.getFoodReliquaryGuidListList(), req.getItemParamListList());
    }
}
