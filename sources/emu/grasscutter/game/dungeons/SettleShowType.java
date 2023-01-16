package emu.grasscutter.game.dungeons;

/* loaded from: grasscutter.jar:emu/grasscutter/game/dungeons/SettleShowType.class */
public enum SettleShowType {
    SETTLE_SHOW_NONE(0),
    SETTLE_SHOW_TIME_COST(1),
    SETTLE_SHOW_OPEN_CHEST_COUNT(2),
    SETTLE_SHOW_KILL_MONSTER_COUNT(3),
    SETTLE_SHOW_BLACKSCREEN(4);
    

    /* renamed from: id */
    private final int f569id;

    public int getId() {
        return this.f569id;
    }

    SettleShowType(int id) {
        this.f569id = id;
    }
}
