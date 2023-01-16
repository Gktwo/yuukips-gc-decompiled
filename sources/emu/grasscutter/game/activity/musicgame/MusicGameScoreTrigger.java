package emu.grasscutter.game.activity.musicgame;

import emu.grasscutter.game.activity.ActivityWatcher;
import emu.grasscutter.game.activity.ActivityWatcherType;
import emu.grasscutter.game.props.WatcherTriggerType;
import java.util.List;

@ActivityWatcherType(WatcherTriggerType.TRIGGER_FLEUR_FAIR_MUSIC_GAME_REACH_SCORE)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameScoreTrigger.class */
public class MusicGameScoreTrigger extends ActivityWatcher {
    @Override // emu.grasscutter.game.activity.ActivityWatcher
    protected boolean isMeet(String... param) {
        if (param.length != 2) {
            return false;
        }
        List<String> paramList = getActivityWatcherData().getTriggerConfig().getParamList();
        return paramList.get(0).equals(param[0]) && Integer.parseInt(param[1]) >= Integer.parseInt(paramList.get(1));
    }
}
