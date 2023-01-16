package emu.grasscutter.server.packet.recv;

import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.musicgame.MusicGameActivityHandler;
import emu.grasscutter.game.activity.musicgame.MusicGameBeatmap;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketActivityInfoNotify;
import emu.grasscutter.server.packet.send.PacketMusicGameCreateBeatmapRsp;
import emu.grasscutter.utils.Utils;
import java.util.Objects;
import java.util.Optional;

@Opcodes(PacketOpcodes.GetUgcReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerMusicGameCreateBeatmapReq.class */
public class HandlerMusicGameCreateBeatmapReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReq req = MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReq.parseFrom(payload);
        MusicGameBeatmap musicGameBeatmap = MusicGameBeatmap.m1210of().maxScore(req.getMusicBriefInfo().getMaxScore()).authorUid(session.getPlayer().getUid()).beatmap(MusicGameBeatmap.parse(req.getMusicRecord().getBeatmapItemListList())).createTime(Utils.getCurrentSeconds()).build();
        musicGameBeatmap.save();
        Optional<PlayerActivityData> playerData = session.getPlayer().getActivityManager().getPlayerActivityDataByActivityType(ActivityType.NEW_ACTIVITY_MUSIC_GAME);
        if (!playerData.isEmpty()) {
            MusicGameActivityHandler handler = (MusicGameActivityHandler) playerData.get().getActivityHandler();
            handler.getMusicGamePlayerData(playerData.get()).getPersonalCustomBeatmapRecord().values().stream().map((v0) -> {
                return v0.getMusicShareId();
            }).map((v0) -> {
                return DatabaseHelper.getMusicGameBeatmap(v0);
            }).filter((v0) -> {
                return Objects.nonNull(v0);
            }).filter(item -> {
                return item.getAuthorUid() == session.getPlayer().getUid();
            }).findFirst().ifPresent(i -> {
                handler.removePersonalBeatmap((PlayerActivityData) playerData.get(), i);
            });
            handler.addPersonalBeatmap(playerData.get(), musicGameBeatmap);
            session.send(new PacketActivityInfoNotify(handler.toProto(playerData.get(), session.getPlayer().getActivityManager().getConditionExecutor())));
            session.send(new PacketMusicGameCreateBeatmapRsp(musicGameBeatmap.getMusicShareId(), req.getUnknownEnum1()));
        }
    }
}
