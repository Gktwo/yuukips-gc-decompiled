package emu.grasscutter.game.props;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.eclipse.jetty.websocket.api.StatusCode;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/GrowCurve.class */
public enum GrowCurve {
    GROW_CURVE_NONE(0),
    GROW_CURVE_HP(1),
    GROW_CURVE_ATTACK(2),
    GROW_CURVE_STAMINA(3),
    GROW_CURVE_STRIKE(4),
    GROW_CURVE_ANTI_STRIKE(5),
    GROW_CURVE_ANTI_STRIKE1(6),
    GROW_CURVE_ANTI_STRIKE2(7),
    GROW_CURVE_ANTI_STRIKE3(8),
    GROW_CURVE_STRIKE_HURT(9),
    GROW_CURVE_ELEMENT(10),
    GROW_CURVE_KILL_EXP(11),
    GROW_CURVE_DEFENSE(12),
    GROW_CURVE_ATTACK_BOMB(13),
    GROW_CURVE_HP_LITTLEMONSTER(14),
    GROW_CURVE_ELEMENT_MASTERY(15),
    GROW_CURVE_PROGRESSION(16),
    GROW_CURVE_DEFENDING(17),
    GROW_CURVE_MHP(18),
    GROW_CURVE_MATK(19),
    GROW_CURVE_TOWERATK(20),
    GROW_CURVE_HP_S5(21),
    GROW_CURVE_HP_S4(22),
    GROW_CURVE_HP_2(23),
    GROW_CURVE_ATTACK_S5(31),
    GROW_CURVE_ATTACK_S4(32),
    GROW_CURVE_ATTACK_S3(33),
    GROW_CURVE_STRIKE_S5(34),
    GROW_CURVE_DEFENSE_S5(41),
    GROW_CURVE_DEFENSE_S4(42),
    GROW_CURVE_ATTACK_101(RetcodeOuterClass.Retcode.RET_DUNGEON_ENTER_FAIL_VALUE),
    GROW_CURVE_ATTACK_102(RetcodeOuterClass.Retcode.RET_DUNGEON_QUIT_FAIL_VALUE),
    GROW_CURVE_ATTACK_103(RetcodeOuterClass.Retcode.RET_DUNGEON_ENTER_EXCEED_DAY_COUNT_VALUE),
    GROW_CURVE_ATTACK_104(RetcodeOuterClass.Retcode.RET_DUNGEON_REVIVE_EXCEED_MAX_COUNT_VALUE),
    GROW_CURVE_ATTACK_105(1105),
    GROW_CURVE_ATTACK_201(RetcodeOuterClass.Retcode.RET_MP_NOT_IN_MY_WORLD_VALUE),
    GROW_CURVE_ATTACK_202(RetcodeOuterClass.Retcode.RET_MP_IN_MP_MODE_VALUE),
    GROW_CURVE_ATTACK_203(RetcodeOuterClass.Retcode.RET_MP_SCENE_IS_FULL_VALUE),
    GROW_CURVE_ATTACK_204(RetcodeOuterClass.Retcode.RET_MP_MODE_NOT_AVAILABLE_VALUE),
    GROW_CURVE_ATTACK_205(1205),
    GROW_CURVE_ATTACK_301(RetcodeOuterClass.Retcode.RET_MAIL_PARA_ERR_VALUE),
    GROW_CURVE_ATTACK_302(RetcodeOuterClass.Retcode.RET_MAIL_MAX_NUM_VALUE),
    GROW_CURVE_ATTACK_303(RetcodeOuterClass.Retcode.RET_MAIL_ITEM_NUM_EXCEED_VALUE),
    GROW_CURVE_ATTACK_304(RetcodeOuterClass.Retcode.RET_MAIL_TITLE_LEN_EXCEED_VALUE),
    GROW_CURVE_ATTACK_305(1305),
    GROW_CURVE_CRITICAL_101(PacketOpcodes.SeaLampTakeContributionRewardRsp),
    GROW_CURVE_CRITICAL_102(PacketOpcodes.BlessingGetFriendPicListRsp),
    GROW_CURVE_CRITICAL_103(PacketOpcodes.SalesmanTakeSpecialRewardRsp),
    GROW_CURVE_CRITICAL_104(PacketOpcodes.BlessingRedeemRewardRsp),
    GROW_CURVE_CRITICAL_105(PacketOpcodes.FleurFairMusicGameStartReq),
    GROW_CURVE_CRITICAL_201(2201),
    GROW_CURVE_CRITICAL_202(2202),
    GROW_CURVE_CRITICAL_203(2203),
    GROW_CURVE_CRITICAL_204(2204),
    GROW_CURVE_CRITICAL_205(PacketOpcodes.WatcherAllDataNotify),
    GROW_CURVE_CRITICAL_301(2301),
    GROW_CURVE_CRITICAL_302(2302),
    GROW_CURVE_CRITICAL_303(2303),
    GROW_CURVE_CRITICAL_304(2304),
    GROW_CURVE_CRITICAL_305(PacketOpcodes.QueryPathReq);
    

    /* renamed from: id */
    private final int f588id;
    private static final Int2ObjectMap<GrowCurve> map = new Int2ObjectOpenHashMap();
    private static final Map<String, GrowCurve> stringMap = new HashMap();
    public static final int[] fightProps = {1, 4, 7, 20, 21, 22, 23, 26, 27, 28, 29, 30, 40, 41, 42, 43, 44, 45, 46, 50, 51, 52, 53, 54, 55, 56, 2000, RetcodeOuterClass.Retcode.RET_UID_NOT_EXIST_VALUE, 2002, 2003, StatusCode.REQUIRED_EXTENSION};

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getId(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    GrowCurve(int id) {
        this.f588id = id;
    }

    public int getId() {
        return this.f588id;
    }

    public static GrowCurve getPropById(int value) {
        return map.getOrDefault(value, (int) GROW_CURVE_NONE);
    }

    public static GrowCurve getPropByName(String name) {
        return stringMap.getOrDefault(name, GROW_CURVE_NONE);
    }
}
