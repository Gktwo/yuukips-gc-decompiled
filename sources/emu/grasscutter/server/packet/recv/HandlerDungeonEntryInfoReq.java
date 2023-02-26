package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.DungeonEntryInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(905)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerDungeonEntryInfoReq.class */
public class HandlerDungeonEntryInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getServer().getDungeonSystem().getEntryInfo(session.getPlayer(), DungeonEntryInfoReqOuterClass.DungeonEntryInfoReq.parseFrom(payload).getPointId());
    }
}
