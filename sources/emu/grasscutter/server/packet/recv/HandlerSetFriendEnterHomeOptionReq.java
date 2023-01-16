package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetFriendEnterHomeOptionReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPlayerHomeCompInfoNotify;
import emu.grasscutter.server.packet.send.PacketSetFriendEnterHomeOptionRsp;

@Opcodes(PacketOpcodes.SetFriendEnterHomeOptionReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetFriendEnterHomeOptionReq.class */
public class HandlerSetFriendEnterHomeOptionReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().getHome().setEnterHomeOption(SetFriendEnterHomeOptionReqOuterClass.SetFriendEnterHomeOptionReq.parseFrom(payload).getOptionValue());
        session.getPlayer().getHome().save();
        session.send(new PacketPlayerHomeCompInfoNotify(session.getPlayer()));
        session.send(new PacketSetFriendEnterHomeOptionRsp());
    }
}
