package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeEditModeReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeBasicInfoNotify;
import emu.grasscutter.server.packet.send.PacketHomeChangeEditModeRsp;
import emu.grasscutter.server.packet.send.PacketHomeComfortInfoNotify;
import emu.grasscutter.server.packet.send.PacketHomePreChangeEditModeNotify;

@Opcodes(PacketOpcodes.HomeChangeEditModeReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeChangeEditModeReq.class */
public class HandlerHomeChangeEditModeReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        HomeChangeEditModeReqOuterClass.HomeChangeEditModeReq req = HomeChangeEditModeReqOuterClass.HomeChangeEditModeReq.parseFrom(payload);
        session.send(new PacketHomePreChangeEditModeNotify(req.getIsEnterEditMode()));
        session.send(new PacketHomeBasicInfoNotify(session.getPlayer(), req.getIsEnterEditMode()));
        session.send(new PacketHomeComfortInfoNotify(session.getPlayer()));
        session.send(new PacketHomeChangeEditModeRsp(req.getIsEnterEditMode()));
    }
}
