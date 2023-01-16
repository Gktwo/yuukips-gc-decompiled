package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FireWorkReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketFireworkNotify;
import emu.grasscutter.server.packet.send.PacketFireworkRsp;

@Opcodes(PacketOpcodes.FireworkReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerFireWorkReq.class */
public class HandlerFireWorkReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketFireworkNotify(FireWorkReqOuterClass.FireWorkReq.parseFrom(payload).getFireWorkData()));
        session.send(new PacketFireworkRsp());
    }
}
