package emu.grasscutter.game.quest;

import emu.grasscutter.game.quest.enums.QuestTrigger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/QuestValue.class */
public @interface QuestValue {
    QuestTrigger value();
}
