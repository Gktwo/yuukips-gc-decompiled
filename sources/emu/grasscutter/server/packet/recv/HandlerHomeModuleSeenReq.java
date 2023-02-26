package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeModuleSeenReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeModuleSeenRsp;
import emu.grasscutter.server.packet.send.PacketPlayerHomeCompInfoNotify;
import java.util.List;

@Opcodes(PacketOpcodes.HomeModuleSeenReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeModuleSeenReq.class */
public class HandlerHomeModuleSeenReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        List<Integer> seen = HomeModuleSeenReqOuterClass.HomeModuleSeenReq.parseFrom(payload).getSeenModuleIdListList();
        for (Integer num : seen) {
            session.getPlayer().addSeenRealmList(num.intValue());
        }
        session.send(new PacketPlayerHomeCompInfoNotify(session.getPlayer()));
        session.send(new PacketHomeModuleSeenRsp(seen));
    }
}
