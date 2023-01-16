package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.musicgame.MusicGameActivityHandler;
import emu.grasscutter.game.activity.musicgame.MusicGamePlayerData;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameSettleReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketActivityInfoNotify;
import emu.grasscutter.server.packet.send.PacketMusicGameSettleRsp;
import java.util.Optional;

@Opcodes(PacketOpcodes.MusicGameSettleReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMusicGameSettleReq.class */
public class HandlerMusicGameSettleReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        MusicGameSettleReqOuterClass.MusicGameSettleReq req = MusicGameSettleReqOuterClass.MusicGameSettleReq.parseFrom(payload);
        Optional<PlayerActivityData> playerData = session.getPlayer().getActivityManager().getPlayerActivityDataByActivityType(ActivityType.NEW_ACTIVITY_MUSIC_GAME);
        if (!playerData.isEmpty()) {
            MusicGameActivityHandler handler = (MusicGameActivityHandler) playerData.get().getActivityHandler();
            boolean isNewRecord = false;
            if (req.getUgcGuid() == 0) {
                session.getPlayer().getActivityManager().triggerWatcher(WatcherTriggerType.TRIGGER_FLEUR_FAIR_MUSIC_GAME_REACH_SCORE, String.valueOf(req.getMusicBasicId()), String.valueOf(req.getScore()));
                isNewRecord = handler.setMusicGameRecord(playerData.get(), MusicGamePlayerData.MusicGameRecord.m1206of().musicId(req.getMusicBasicId()).maxCombo(req.getMaxCombo()).maxScore(req.getScore()).build());
                session.send(new PacketActivityInfoNotify(handler.toProto(playerData.get(), session.getPlayer().getActivityManager().getConditionExecutor())));
            } else {
                handler.setMusicGameCustomBeatmapRecord(playerData.get(), MusicGamePlayerData.CustomBeatmapRecord.m1207of().musicShareId(req.getUgcGuid()).score(req.getMaxCombo()).build());
            }
            session.send(new PacketMusicGameSettleRsp(req.getMusicBasicId(), req.getUgcGuid(), isNewRecord));
        }
    }
}
