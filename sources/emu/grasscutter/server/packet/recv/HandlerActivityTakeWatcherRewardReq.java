package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityTakeWatcherRewardReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketActivityTakeWatcherRewardRsp;
import java.util.Optional;

@Opcodes(PacketOpcodes.ActivityTakeWatcherRewardReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerActivityTakeWatcherRewardReq.class */
public class HandlerActivityTakeWatcherRewardReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReq req = ActivityTakeWatcherRewardReqOuterClass.ActivityTakeWatcherRewardReq.parseFrom(payload);
        Optional.ofNullable(session.getPlayer().getActivityManager().getPlayerActivityDataMap().get(Integer.valueOf(req.getActivityId()))).ifPresent(x -> {
            x.takeWatcherReward(req.getWatcherId());
        });
        session.send(new PacketActivityTakeWatcherRewardRsp(req.getActivityId(), req.getWatcherId()));
    }
}
