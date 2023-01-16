package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerEnterDungeonReqOuterClass;
import emu.grasscutter.server.game.GameSession;

@Opcodes(PacketOpcodes.PlayerEnterDungeonReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPlayerEnterDungeonReq.class */
public class HandlerPlayerEnterDungeonReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReq req = PlayerEnterDungeonReqOuterClass.PlayerEnterDungeonReq.parseFrom(payload);
        session.getServer().getDungeonSystem().enterDungeon(session.getPlayer(), req.getPointId(), req.getDungeonId());
    }
}
