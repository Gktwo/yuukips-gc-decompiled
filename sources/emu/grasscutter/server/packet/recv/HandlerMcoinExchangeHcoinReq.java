package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.McoinExchangeHcoinReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketMcoinExchangeHcoinRsp;

@Opcodes(623)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMcoinExchangeHcoinReq.class */
public class HandlerMcoinExchangeHcoinReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReq exchangeReq = McoinExchangeHcoinReqOuterClass.McoinExchangeHcoinReq.parseFrom(payload);
        if (session.getPlayer().getCrystals() >= exchangeReq.getMcoinCost() || exchangeReq.getMcoinCost() != exchangeReq.getHcoin()) {
            session.getPlayer().setCrystals(session.getPlayer().getCrystals() - exchangeReq.getMcoinCost());
            session.getPlayer().setPrimogems(session.getPlayer().getPrimogems() + exchangeReq.getHcoin());
            session.getPlayer().save();
            session.send(new PacketMcoinExchangeHcoinRsp(0));
            return;
        }
        session.send(new PacketMcoinExchangeHcoinRsp(2));
    }
}
