package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QueryPathReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketQueryPathRsp;

@Opcodes(PacketOpcodes.QueryPathReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerQueryPathReq.class */
public class HandlerQueryPathReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        QueryPathReqOuterClass.QueryPathReq req = QueryPathReqOuterClass.QueryPathReq.parseFrom(payload);
        if (req.getDestinationPosList().size() > 0) {
            session.send(new PacketQueryPathRsp(req));
        }
    }
}
