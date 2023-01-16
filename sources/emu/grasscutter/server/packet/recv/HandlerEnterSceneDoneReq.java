package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEnterSceneDoneRsp;
import emu.grasscutter.server.packet.send.PacketPlayerTimeNotify;
import emu.grasscutter.server.packet.send.PacketScenePlayerLocationNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerLocationNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerRTTNotify;

@Opcodes(PacketOpcodes.EnterSceneDoneReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerEnterSceneDoneReq.class */
public class HandlerEnterSceneDoneReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().setSceneLoadState(Player.SceneLoadState.LOADED);
        session.send(new PacketPlayerTimeNotify(session.getPlayer()));
        session.getPlayer().getScene().spawnPlayer(session.getPlayer());
        session.getPlayer().getScene().loadNpcQuestForPlayerEnter(session.getPlayer());
        session.getPlayer().getScene().loadNpcForPlayerEnter(session.getPlayer());
        session.getPlayer().getScene().showOtherEntities(session.getPlayer());
        session.send(new PacketWorldPlayerLocationNotify(session.getPlayer().getWorld()));
        session.send(new PacketScenePlayerLocationNotify(session.getPlayer().getScene()));
        session.send(new PacketWorldPlayerRTTNotify(session.getPlayer().getWorld()));
        session.getPlayer().resetSendPlayerLocTime();
        session.send(new PacketEnterSceneDoneRsp(session.getPlayer()));
    }
}
