package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTowerAllDataRsp;

@Opcodes(PacketOpcodes.TowerAllDataReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerTowerAllDataReq.class */
public class HandlerTowerAllDataReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketTowerAllDataRsp(session.getServer().getTowerSystem(), session.getPlayer().getTowerManager()));
    }
}
