package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetSceneAreaReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetSceneAreaRsp;

@Opcodes(PacketOpcodes.GetSceneAreaReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetSceneAreaReq.class */
public class HandlerGetSceneAreaReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetSceneAreaRsp(session.getPlayer(), GetSceneAreaReqOuterClass.GetSceneAreaReq.parseFrom(payload).getSceneId()));
    }
}
