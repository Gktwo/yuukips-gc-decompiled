package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.ActivityType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/GameActivity.class */
public @interface GameActivity {
    ActivityType value();
}
