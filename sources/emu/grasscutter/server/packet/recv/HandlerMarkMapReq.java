package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MarkMapReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.MarkMapReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMarkMapReq.class */
public class HandlerMarkMapReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getMapMarksManager().handleMapMarkReq(MarkMapReqOuterClass.MarkMapReq.parseFrom(payload));
    }
}
