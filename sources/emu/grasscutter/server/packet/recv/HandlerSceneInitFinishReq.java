package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketHostPlayerNotify;
import emu.grasscutter.server.packet.send.PacketPlayerEnterSceneInfoNotify;
import emu.grasscutter.server.packet.send.PacketPlayerGameTimeNotify;
import emu.grasscutter.server.packet.send.PacketPlayerWorldSceneInfoListNotify;
import emu.grasscutter.server.packet.send.PacketSceneAreaWeatherNotify;
import emu.grasscutter.server.packet.send.PacketSceneInitFinishRsp;
import emu.grasscutter.server.packet.send.PacketScenePlayerInfoNotify;
import emu.grasscutter.server.packet.send.PacketSceneTeamUpdateNotify;
import emu.grasscutter.server.packet.send.PacketSceneTimeNotify;
import emu.grasscutter.server.packet.send.PacketServerTimeNotify;
import emu.grasscutter.server.packet.send.PacketSyncScenePlayTeamEntityNotify;
import emu.grasscutter.server.packet.send.PacketSyncTeamEntityNotify;
import emu.grasscutter.server.packet.send.PacketWorldDataNotify;
import emu.grasscutter.server.packet.send.PacketWorldOwnerDailyTaskNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerInfoNotify;

@Opcodes(PacketOpcodes.SceneInitFinishReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSceneInitFinishReq.class */
public class HandlerSceneInitFinishReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.send(new PacketServerTimeNotify());
        session.send(new PacketWorldPlayerInfoNotify(session.getPlayer().getWorld()));
        session.send(new PacketWorldOwnerDailyTaskNotify(session.getPlayer()));
        session.send(new PacketWorldDataNotify(session.getPlayer().getWorld()));
        session.send(new PacketPlayerWorldSceneInfoListNotify());
        session.send(new BasePacket(PacketOpcodes.SceneForceUnlockNotify));
        session.send(new PacketHostPlayerNotify(session.getPlayer().getWorld()));
        session.send(new PacketSceneTimeNotify(session.getPlayer()));
        session.send(new PacketPlayerGameTimeNotify(session.getPlayer()));
        session.send(new PacketPlayerEnterSceneInfoNotify(session.getPlayer()));
        session.send(new PacketSceneAreaWeatherNotify(session.getPlayer()));
        session.send(new PacketScenePlayerInfoNotify(session.getPlayer().getWorld()));
        session.send(new PacketSceneTeamUpdateNotify(session.getPlayer()));
        session.send(new PacketSyncTeamEntityNotify(session.getPlayer()));
        session.send(new PacketSyncScenePlayTeamEntityNotify(session.getPlayer()));
        session.send(new PacketSceneInitFinishRsp(session.getPlayer()));
        session.getPlayer().setSceneLoadState(Player.SceneLoadState.INIT);
    }
}
