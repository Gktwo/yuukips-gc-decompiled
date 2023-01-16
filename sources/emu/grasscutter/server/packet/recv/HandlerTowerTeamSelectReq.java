package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.TowerTeamSelectReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTowerTeamSelectRsp;

@Opcodes(PacketOpcodes.TowerTeamSelectReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTowerTeamSelectReq.class */
public class HandlerTowerTeamSelectReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        TowerTeamSelectReqOuterClass.TowerTeamSelectReq req = TowerTeamSelectReqOuterClass.TowerTeamSelectReq.parseFrom(payload);
        session.getPlayer().getTowerManager().teamSelect(req.getFloorId(), req.getTowerTeamListList().stream().map((v0) -> {
            return v0.getAvatarGuidListList();
        }).toList());
        session.send(new PacketTowerTeamSelectRsp());
    }
}
