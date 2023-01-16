package emu.grasscutter.game.activity.condition;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/ActivityConditionExecutor.class */
public interface ActivityConditionExecutor {
    List<Integer> getMeetActivitiesConditions(List<Integer> list);

    boolean meetsCondition(int i);
}
