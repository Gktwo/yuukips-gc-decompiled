package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.CreateVehicleReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketCreateVehicleRsp;
import emu.grasscutter.utils.Position;

@Opcodes(807)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerCreateVehicleReq.class */
public class HandlerCreateVehicleReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        CreateVehicleReqOuterClass.CreateVehicleReq req = CreateVehicleReqOuterClass.CreateVehicleReq.parseFrom(payload);
        session.send(new PacketCreateVehicleRsp(session.getPlayer(), req.getVehicleId(), req.getScenePointId(), new Position(req.getPos()), new Position(req.getRot())));
    }
}
