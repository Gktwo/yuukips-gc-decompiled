package emu.grasscutter.game.props;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.stream.Stream;
import org.eclipse.jetty.websocket.api.StatusCode;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/PlayerProperty.class */
public enum PlayerProperty {
    PROP_NONE(0),
    PROP_EXP(1001, 0),
    PROP_BREAK_LEVEL(1002),
    PROP_SATIATION_VAL(1003),
    PROP_SATIATION_PENALTY_TIME(StatusCode.UNDEFINED),
    PROP_LEVEL(4001, 0, 90),
    PROP_LAST_CHANGE_AVATAR_TIME(RetcodeOuterClass.Retcode.RET_SUMO_ACTIVITY_SWITCH_TEAM_IN_CD_VALUE),
    PROP_MAX_SPRING_VOLUME(RetcodeOuterClass.Retcode.RET_SUMO_ACTIVITY_TEAM_NUM_INCORRECT_VALUE, 0, 8500000),
    PROP_CUR_SPRING_VOLUME(10003, true),
    PROP_IS_SPRING_AUTO_USE(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_AREA_ID_ERROR_VALUE, 0, 1),
    PROP_SPRING_AUTO_USE_PERCENT(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_BATTLE_NOT_FINISH_VALUE, 0, 100),
    PROP_IS_FLYABLE(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_ALREADY_SACRIFICE_VALUE, 0, 1),
    PROP_IS_WEATHER_LOCKED(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_ALREADY_TAKE_REWARD_VALUE, 0, 1),
    PROP_IS_GAME_TIME_LOCKED(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_SACRIFICE_NOT_ENOUGH_VALUE, 0, 1),
    PROP_IS_TRANSFERABLE(RetcodeOuterClass.Retcode.RET_LUNA_RITE_ACTIVITY_SEARCHING_COND_NOT_MEET_VALUE, 0, 1),
    PROP_MAX_STAMINA(10010, 0, 24000),
    PROP_CUR_PERSIST_STAMINA(10011, true),
    PROP_CUR_TEMPORARY_STAMINA(10012),
    PROP_PLAYER_LEVEL(10013, 1, 60),
    PROP_PLAYER_EXP(10014),
    PROP_PLAYER_HCOIN(RetcodeOuterClass.Retcode.RET_DIG_GADGET_CONFIG_ID_NOT_MATCH_VALUE),
    PROP_PLAYER_SCOIN((int) RetcodeOuterClass.Retcode.RET_DIG_FIND_NEAREST_POS_FAIL_VALUE, 0),
    PROP_PLAYER_MP_SETTING_TYPE(10017, 0, 2),
    PROP_IS_MP_MODE_AVAILABLE(10018, 0, 1),
    PROP_PLAYER_WORLD_LEVEL(10019, 0, 8),
    PROP_PLAYER_RESIN(10020, 0, PacketOpcodes.SetCoopChapterViewedRsp),
    PROP_PLAYER_WAIT_SUB_HCOIN(RetcodeOuterClass.Retcode.RET_MUSIC_GAME_LEVEL_NOT_UNLOCK_VALUE),
    PROP_PLAYER_WAIT_SUB_SCOIN(RetcodeOuterClass.Retcode.RET_MUSIC_GAME_LEVEL_NOT_STARTED_VALUE),
    PROP_IS_ONLY_MP_WITH_PS_PLAYER(RetcodeOuterClass.Retcode.RET_MUSIC_GAME_LEVEL_CONFIG_NOT_FOUND_VALUE, 0, 1),
    PROP_PLAYER_MCOIN(RetcodeOuterClass.Retcode.RET_MUSIC_GAME_LEVEL_ID_NOT_MATCH_VALUE),
    PROP_PLAYER_WAIT_SUB_MCOIN(10026),
    PROP_PLAYER_LEGENDARY_KEY(10027, 0),
    PROP_IS_HAS_FIRST_SHARE(10028),
    PROP_PLAYER_FORGE_POINT(10029, 0, 300000),
    PROP_CUR_CLIMATE_METER(RetcodeOuterClass.Retcode.RET_ROGUELIKE_COIN_B_EXCEED_LIMIT_VALUE),
    PROP_CUR_CLIMATE_TYPE(RetcodeOuterClass.Retcode.RET_ROGUELIKE_COIN_C_EXCEED_LIMIT_VALUE),
    PROP_CUR_CLIMATE_AREA_ID(RetcodeOuterClass.Retcode.RET_ROGUELIKE_RUNE_COUNT_NOT_ENOUGH_VALUE),
    PROP_CUR_CLIMATE_AREA_CLIMATE_TYPE(RetcodeOuterClass.Retcode.RET_ROGUELIKE_NOT_IN_ROGUE_DUNGEON_VALUE),
    PROP_PLAYER_WORLD_LEVEL_LIMIT(RetcodeOuterClass.Retcode.RET_ROGUELIKE_CELL_NOT_FOUND_VALUE),
    PROP_PLAYER_WORLD_LEVEL_ADJUST_CD(RetcodeOuterClass.Retcode.RET_ROGUELIKE_CELL_TYPE_INCORRECT_VALUE),
    PROP_PLAYER_LEGENDARY_DAILY_TASK_NUM(RetcodeOuterClass.Retcode.RET_ROGUELIKE_CELL_ALREADY_FINISHED_VALUE),
    PROP_PLAYER_HOME_COIN((int) RetcodeOuterClass.Retcode.RET_ROGUELIKE_DUNGEON_HAVE_UNFINISHED_PROGRESS_VALUE, 0),
    PROP_PLAYER_WAIT_SUB_HOME_COIN(RetcodeOuterClass.Retcode.RET_ROGUELIKE_STAGE_NOT_FINISHED_VALUE);
    
    private static final int inf = Integer.MAX_VALUE;

    /* renamed from: id */
    private final int f590id;
    private final int min;
    private final int max;
    private final boolean dynamicRange;
    private static final Int2ObjectMap<PlayerProperty> map = new Int2ObjectOpenHashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getId(), (int) e);
        });
    }

    public int getId() {
        return this.f590id;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public boolean isDynamicRange() {
        return this.dynamicRange;
    }

    PlayerProperty(int id, int min, int max, boolean dynamicRange) {
        this.f590id = id;
        this.min = min;
        this.max = max;
        this.dynamicRange = dynamicRange;
    }

    PlayerProperty(int id, int min) {
        this(id, min, Integer.MAX_VALUE, false);
    }

    PlayerProperty(int id, int min, int max) {
        this(id, min, max, false);
    }

    PlayerProperty(int id) {
        this(id, Integer.MIN_VALUE, Integer.MAX_VALUE, false);
    }

    PlayerProperty(int id, boolean dynamicRange) {
        this(id, Integer.MIN_VALUE, Integer.MAX_VALUE, dynamicRange);
    }

    public static PlayerProperty getPropById(int value) {
        return map.getOrDefault(value, (int) null);
    }
}
