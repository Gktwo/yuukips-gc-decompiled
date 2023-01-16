package emu.grasscutter.game.activity.musicgame;

import emu.grasscutter.game.activity.ActivityHandler;
import emu.grasscutter.game.activity.GameActivity;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.musicgame.MusicGamePlayerData;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass;
import emu.grasscutter.utils.JsonUtils;

@GameActivity(ActivityType.NEW_ACTIVITY_MUSIC_GAME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameActivityHandler.class */
public class MusicGameActivityHandler extends ActivityHandler {
    @Override // emu.grasscutter.game.activity.ActivityHandler
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {
        playerActivityData.setDetail(MusicGamePlayerData.create());
    }

    @Override // emu.grasscutter.game.activity.ActivityHandler
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfoOuterClass.ActivityInfo.Builder activityInfo) {
        getMusicGamePlayerData(playerActivityData);
        activityInfo.setMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.newBuilder());
    }

    public MusicGamePlayerData getMusicGamePlayerData(PlayerActivityData playerActivityData) {
        if (playerActivityData.getDetail() == null || playerActivityData.getDetail().isBlank()) {
            onInitPlayerActivityData(playerActivityData);
            playerActivityData.save();
        }
        return (MusicGamePlayerData) JsonUtils.decode(playerActivityData.getDetail(), MusicGamePlayerData.class);
    }

    public boolean setMusicGameRecord(PlayerActivityData playerActivityData, MusicGamePlayerData.MusicGameRecord newRecord) {
        MusicGamePlayerData musicGamePlayerData = getMusicGamePlayerData(playerActivityData);
        MusicGamePlayerData.MusicGameRecord saveRecord = musicGamePlayerData.getMusicGameRecord().get(Integer.valueOf(newRecord.getMusicId()));
        saveRecord.setMaxCombo(Math.max(newRecord.getMaxCombo(), saveRecord.getMaxCombo()));
        saveRecord.setMaxScore(Math.max(newRecord.getMaxScore(), saveRecord.getMaxScore()));
        playerActivityData.setDetail(musicGamePlayerData);
        playerActivityData.save();
        return newRecord.getMaxScore() > saveRecord.getMaxScore();
    }

    public void setMusicGameCustomBeatmapRecord(PlayerActivityData playerActivityData, MusicGamePlayerData.CustomBeatmapRecord newRecord) {
        MusicGamePlayerData musicGamePlayerData = getMusicGamePlayerData(playerActivityData);
        musicGamePlayerData.getOthersCustomBeatmapRecord().put(Long.valueOf(newRecord.getMusicShareId()), newRecord);
        playerActivityData.setDetail(musicGamePlayerData);
        playerActivityData.save();
    }

    public void addPersonalBeatmap(PlayerActivityData playerActivityData, MusicGameBeatmap musicGameBeatmap) {
        MusicGamePlayerData musicGamePlayerData = getMusicGamePlayerData(playerActivityData);
        musicGamePlayerData.getPersonalCustomBeatmapRecord().put(Long.valueOf(musicGameBeatmap.getMusicShareId()), MusicGamePlayerData.CustomBeatmapRecord.m1207of().musicShareId(musicGameBeatmap.getMusicShareId()).build());
        playerActivityData.setDetail(musicGamePlayerData);
        playerActivityData.save();
    }

    public void removePersonalBeatmap(PlayerActivityData playerActivityData, MusicGameBeatmap musicGameBeatmap) {
        MusicGamePlayerData musicGamePlayerData = getMusicGamePlayerData(playerActivityData);
        musicGamePlayerData.getPersonalCustomBeatmapRecord().remove(Long.valueOf(musicGameBeatmap.getMusicShareId()));
        playerActivityData.setDetail(musicGamePlayerData);
        playerActivityData.save();
    }
}
