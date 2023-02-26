package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GetActivityInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetActivityInfoRsp;
import java.util.HashSet;

@Opcodes(PacketOpcodes.GetActivityInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerGetActivityInfoReq.class */
public class HandlerGetActivityInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketGetActivityInfoRsp(new HashSet(GetActivityInfoReqOuterClass.GetActivityInfoReq.parseFrom(payload).getActivityIdListList()), session.getPlayer().getActivityManager()));
    }
}
