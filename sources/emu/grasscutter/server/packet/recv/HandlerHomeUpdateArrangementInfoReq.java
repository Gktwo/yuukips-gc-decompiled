package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.home.HomeSceneItem;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.HomeUpdateArrangementInfoReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHomeUpdateArrangementInfoRsp;
import emu.grasscutter.server.packet.send.PacketTryEnterHomeRsp;

@Opcodes(PacketOpcodes.HomeUpdateArrangementInfoReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerHomeUpdateArrangementInfoReq.class */
public class HandlerHomeUpdateArrangementInfoReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReq req = HomeUpdateArrangementInfoReqOuterClass.HomeUpdateArrangementInfoReq.parseFrom(payload);
        HomeSceneItem homeScene = session.getPlayer().getHome().getHomeSceneItem(session.getPlayer().getSceneId());
        if (homeScene == null) {
            session.send(new PacketTryEnterHomeRsp());
            return;
        }
        homeScene.update(req.getSceneArrangementInfo());
        session.getPlayer().getHome().save();
        session.send(new PacketHomeUpdateArrangementInfoRsp());
    }
}
