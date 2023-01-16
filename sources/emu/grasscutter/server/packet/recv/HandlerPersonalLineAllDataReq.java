package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketPersonalLineAllDataRsp;

@Opcodes(434)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerPersonalLineAllDataReq.class */
public class HandlerPersonalLineAllDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketPersonalLineAllDataRsp(session.getPlayer().getQuestManager().getMainQuests().values()));
    }
}