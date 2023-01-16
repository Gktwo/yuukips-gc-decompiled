package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.FireworkSetReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketFireworkSetNotify;
import emu.grasscutter.server.packet.send.PacketFireworkSetRsp;

@Opcodes(PacketOpcodes.FireworkSetReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerFireworkSetReq.class */
public class HandlerFireworkSetReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketFireworkSetNotify(FireworkSetReqOuterClass.FireworkSetReq.parseFrom(payload).getData()));
        session.send(new PacketFireworkSetRsp());
    }
}
