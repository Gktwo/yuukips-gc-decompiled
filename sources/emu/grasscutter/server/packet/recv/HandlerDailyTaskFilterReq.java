package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.DailyTaskFilterCityReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDailyTaskFilterRsp;

@Opcodes(182)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDailyTaskFilterReq.class */
public class HandlerDailyTaskFilterReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        DailyTaskFilterCityReqOuterClass.DailyTaskFilterCityReq req = DailyTaskFilterCityReqOuterClass.DailyTaskFilterCityReq.parseFrom(payload);
        if (session.getPlayer().getWorld().getHost().getUid() == session.getPlayer().getUid()) {
            session.getPlayer().getDailyTaskManager().filterCityId(req.getCityId());
            session.send(new PacketDailyTaskFilterRsp(req.getCityId()));
        }
    }
}
