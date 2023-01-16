package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetUpLunchBoxWidgetReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetUpLunchBoxWidgetRsp;

@Opcodes(PacketOpcodes.SetUpLunchBoxWidgetReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetUpLunchBoxWidgetReq.class */
public class HandlerSetUpLunchBoxWidgetReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketSetUpLunchBoxWidgetRsp(SetUpLunchBoxWidgetReqOuterClass.SetUpLunchBoxWidgetReq.parseFrom(payload).getLunchBoxData()));
    }
}
