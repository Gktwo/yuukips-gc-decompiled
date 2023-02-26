package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.VehicleInteractReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketVehicleInteractRsp;

@Opcodes(888)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerVehicleInteractReq.class */
public class HandlerVehicleInteractReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        VehicleInteractReqOuterClass.VehicleInteractReq req = VehicleInteractReqOuterClass.VehicleInteractReq.parseFrom(payload);
        session.getPlayer().getStaminaManager().handleVehicleInteractReq(session, req.getEntityId(), req.getInteractType());
        session.send(new PacketVehicleInteractRsp(session.getPlayer(), req.getEntityId(), req.getInteractType()));
    }
}
