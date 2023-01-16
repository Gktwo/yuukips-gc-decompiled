package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.WatcherTriggerType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/ActivityWatcherType.class */
public @interface ActivityWatcherType {
    WatcherTriggerType value();
}
