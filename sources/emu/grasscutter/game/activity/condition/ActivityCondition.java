package emu.grasscutter.game.activity.condition;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/ActivityCondition.class */
public @interface ActivityCondition {
    ActivityConditions value();
}
