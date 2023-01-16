package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetShopReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetShopRsp;

@Opcodes(PacketOpcodes.GetShopReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetShopReq.class */
public class HandlerGetShopReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetShopRsp(session.getPlayer(), GetShopReqOuterClass.GetShopReq.parseFrom(payload).getShopType()));
    }
}
