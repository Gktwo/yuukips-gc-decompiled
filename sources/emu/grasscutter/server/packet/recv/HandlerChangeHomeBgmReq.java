package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeChangeBgmReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketChangeHomeBgmNotify;
import emu.grasscutter.server.packet.send.PacketChangeHomeBgmRsp;

@Opcodes(PacketOpcodes.HomeChangeBgmReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerChangeHomeBgmReq.class */
public class HandlerChangeHomeBgmReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        int homeBgmId = HomeChangeBgmReqOuterClass.HomeChangeBgmReq.parseFrom(payload).getBgmId();
        GameHome home = session.getPlayer().getHome();
        home.getHomeSceneItem(session.getPlayer().getSceneId()).setHomeBgmId(homeBgmId);
        home.save();
        session.send(new PacketChangeHomeBgmNotify(homeBgmId));
        session.send(new PacketChangeHomeBgmRsp());
    }
}
