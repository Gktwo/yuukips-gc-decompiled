package emu.grasscutter.game.props;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/BattlePassMissionRefreshType.class */
public enum BattlePassMissionRefreshType {
    BATTLE_PASS_MISSION_REFRESH_DAILY(0),
    BATTLE_PASS_MISSION_REFRESH_CYCLE_CROSS_SCHEDULE(1),
    BATTLE_PASS_MISSION_REFRESH_SCHEDULE(2),
    BATTLE_PASS_MISSION_REFRESH_CYCLE(1);
    
    private final int value;

    BattlePassMissionRefreshType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
