package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetActivityShopSheetInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetActivityShopSheetInfoRsp;

@Opcodes(PacketOpcodes.GetActivityShopSheetInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetActivityShopSheetInfoReq.class */
public class HandlerGetActivityShopSheetInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().sendPacket(new PacketGetActivityShopSheetInfoRsp(GetActivityShopSheetInfoReqOuterClass.GetActivityShopSheetInfoReq.parseFrom(payload).getShopType()));
    }
}
