package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetScenePointReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetScenePointRsp;

@Opcodes(PacketOpcodes.GetScenePointReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetScenePointReq.class */
public class HandlerGetScenePointReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetScenePointRsp(session.getPlayer(), GetScenePointReqOuterClass.GetScenePointReq.parseFrom(payload).getSceneId()));
    }
}
