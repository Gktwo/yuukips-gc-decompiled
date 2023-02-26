package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.EvtAvatarLockChairReqOuterClass;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtAvatarLockChairRsp;

@Opcodes(337)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEvtAvatarLockChairReq.class */
public class HandlerEvtAvatarLockChairReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PacketHeadOuterClass.PacketHead head = PacketHeadOuterClass.PacketHead.parseFrom(header);
        EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReq lockChairReq = EvtAvatarLockChairReqOuterClass.EvtAvatarLockChairReq.parseFrom(payload);
        session.send(new PacketEvtAvatarLockChairRsp(head.getClientSequenceId(), session.getPlayer().getTeamManager().getCurrentAvatarEntity(), lockChairReq));
    }
}
