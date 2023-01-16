package emu.grasscutter.game.quest.enums;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/enums/QuestShowType.class */
public enum QuestShowType {
    QUEST_SHOW(0),
    QUEST_HIDDEN(1);
    
    private final int value;

    QuestShowType(int id) {
        this.value = id;
    }

    public int getValue() {
        return this.value;
    }
}
