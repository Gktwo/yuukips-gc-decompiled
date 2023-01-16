package emu.grasscutter.game.dungeons;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/DungeonValue.class */
public @interface DungeonValue {
    DungeonPassConditionType value();
}
