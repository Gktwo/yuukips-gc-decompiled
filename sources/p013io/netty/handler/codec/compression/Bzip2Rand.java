package p013io.netty.handler.codec.compression;

import com.sun.jna.Function;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.MusicBriefInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameSettleReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import emu.grasscutter.net.proto.VintageMarketInfoOuterClass;
import javassist.compiler.TokenId;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.compression.Bzip2Rand */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2Rand.class */
public final class Bzip2Rand {
    private static final int[] RNUMS = {619, 720, 127, 481, 931, 816, RetcodeOuterClass.Retcode.RET_BOSS_CHEST_HAS_TAKEN_VALUE, 233, 566, 247, PacketOpcodes.DungeonRestartResultNotify, 724, 205, 454, RetcodeOuterClass.Retcode.RET_SEA_LAMP_PHASE_NOT_FINISH_VALUE, PacketOpcodes.GetParentQuestVideoKeyRsp, 741, 242, PacketOpcodes.DungeonSlipRevivePointActivateRsp, PacketOpcodes.SetSceneWeatherAreaReq, 733, 859, TokenId.STATIC, RetcodeOuterClass.Retcode.RET_SHOP_BATCH_BUY_SHOP_LIMIT_VALUE, 621, 574, 73, 654, PacketOpcodes.GetShopRsp, PacketOpcodes.GetBargainDataRsp, PacketOpcodes.FinishedParentQuestNotify, 436, PacketOpcodes.SceneEntityMoveRsp, 496, 867, PacketOpcodes.SceneForceUnlockNotify, PacketOpcodes.EvtBulletDeactiveNotify, 680, PacketOpcodes.QuestGlobalVarNotify, 51, 878, 465, RetcodeOuterClass.Retcode.RET_BOSS_CHEST_WEEK_NUM_LIMIT_VALUE, 169, RetcodeOuterClass.Retcode.RET_SALESMAN_REWARD_COUNT_NOT_ENOUGH_VALUE, 675, 611, 697, 867, 561, RetcodeOuterClass.Retcode.RET_ACTIVITY_CONTRIBUTION_NOT_ENOUGH_VALUE, 687, 507, PacketOpcodes.CutSceneBeginNotify, PacketOpcodes.QuestUpdateQuestTimeVarNotify, 129, 807, 591, 733, 623, 150, PacketOpcodes.HitClientTrivialNotify, 59, PacketOpcodes.EvtBeingHitNotify, RetcodeOuterClass.Retcode.RET_INVALID_WIDGET_MATERIAL_ID_VALUE, RetcodeOuterClass.Retcode.RET_ASTER_TOKEN_NOT_ENOUGH_VALUE, 625, 169, RetcodeOuterClass.Retcode.RET_ITEM_SHOULD_HAVE_NO_LEVEL_VALUE, 105, 170, 607, RetcodeOuterClass.Retcode.RET_DISTANCE_LONG_VALUE, 932, 727, 476, 693, 425, 174, 647, 73, 122, TokenId.STATIC, 530, PacketOpcodes.ChapterStateNotify, 853, 695, PacketOpcodes.BeginCameraSceneLookNotify, 445, RetcodeOuterClass.Retcode.RET_MARK_ALREADY_EXISTS_VALUE, 909, 545, RetcodeOuterClass.Retcode.RET_GOODS_NOT_IN_TIME_VALUE, PacketOpcodes.PlayerEnterDungeonRsp, 874, 474, RetcodeOuterClass.Retcode.RET_DRAGON_SPINE_WARM_ESSENCE_EXCEED_LIMIT_VALUE, 500, 594, 612, 641, RetcodeOuterClass.Retcode.RET_GADGET_NOT_EXIST_VALUE, 220, 162, 819, 984, 589, RetcodeOuterClass.Retcode.RET_GROUP_NOT_EXIST_VALUE, PacketOpcodes.PersonalLineAllDataRsp, 799, 161, 604, 958, 533, PacketOpcodes.ClientTransmitReq, 400, 386, 867, PacketOpcodes.GetSceneNpcPositionRsp, 782, PacketOpcodes.EvtAvatarStandUpNotify, 596, 414, 171, RetcodeOuterClass.Retcode.RET_MARK_OVERFLOW_VALUE, PacketOpcodes.EvtEntityRenderersChangedNotify, 682, 485, 911, PacketOpcodes.ScenePointUnlockNotify, 98, RetcodeOuterClass.Retcode.RET_INVALID_SCENE_TO_USE_ANCHOR_POINT_VALUE, 163, 354, 666, PacketOpcodes.DungeonCandidateTeamCreateReq, 424, 341, 533, RetcodeOuterClass.Retcode.RET_SALESMAN_POSITION_INVALID_VALUE, PacketOpcodes.SceneAvatarStaminaStepRsp, PacketOpcodes.GetShopRsp, PacketOpcodes.QuestTransmitRsp, 186, PacketOpcodes.ExecuteGroupTriggerReq, 647, 537, 686, PacketOpcodes.GetSceneNpcPositionRsp, PacketOpcodes.WorldPlayerLocationNotify, 469, 68, 770, PacketOpcodes.PlayerEnterDungeonRsp, 190, 373, PacketOpcodes.SceneCreateEntityReq, RetcodeOuterClass.Retcode.RET_GENERAL_REWARD_HAS_TAKEN_VALUE, 808, 206, 184, PacketOpcodes.PlayerQuitDungeonRsp, 795, Function.USE_VARARGS, 383, PacketOpcodes.AddQuestContentProgressRsp, 404, 758, 839, 887, 715, 67, RetcodeOuterClass.Retcode.RET_AVATAR_CAN_NOT_USE_VALUE, PacketOpcodes.ScenePointUnlockNotify, 204, 918, 873, ShopGoodsOuterClass.ShopGoods.UNK3300_MBGOMHNBHMG_FIELD_NUMBER, 604, 560, 951, 160, 578, 722, 79, RetcodeOuterClass.Retcode.RET_CHEST_IS_LOCKED_VALUE, 96, 409, 713, 940, 652, PacketOpcodes.DungeonCandidateTeamKickRsp, ActivityInfoOuterClass.ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER, PacketOpcodes.GetQuestTalkHistoryReq, TokenId.FOR, 353, 859, 672, 112, 785, 645, RetcodeOuterClass.Retcode.RET_SEA_LAMP_PHASE_NOT_FINISH_VALUE, 803, 350, 139, 93, 354, 99, RetcodeOuterClass.Retcode.RET_GENERAL_REWARD_NO_QUALIFICATION_VALUE, 908, 609, 772, 154, PacketOpcodes.PersonalSceneJumpRsp, 580, 184, 79, 626, 630, 742, RetcodeOuterClass.Retcode.RET_EQUIP_WEARED_CANNOT_DROP_VALUE, PacketOpcodes.EnterSceneWeatherAreaNotify, 762, 623, 680, 81, PacketOpcodes.DungeonPlayerDieNotify, 626, ActivityInfoOuterClass.ActivityInfo.SPICE_INFO_FIELD_NUMBER, 125, 411, RetcodeOuterClass.Retcode.RET_ENTER_SCENE_TOKEN_INVALID_VALUE, 938, 300, RetcodeOuterClass.Retcode.RET_GENERAL_REWARD_LIFE_TIME_OVER_VALUE, 78, 343, 175, 128, 250, 170, 774, PacketOpcodes.DungeonCandidateTeamPlayerLeaveNotify, 275, 999, RetcodeOuterClass.Retcode.RET_ITEM_EMPTY_VALUE, PacketOpcodes.PersonalLineAllDataRsp, 78, 352, 126, PacketOpcodes.GadgetPlayStopNotify, PacketOpcodes.PlayerEnterDungeonReq, TokenId.f3079EQ, 619, 580, 124, 737, 594, RetcodeOuterClass.Retcode.RET_GOODS_NOT_EXIST_VALUE, 612, RetcodeOuterClass.Retcode.RET_AUTO_RECOVER_BOUGHT_COUNT_EXCEEDED_VALUE, 112, 134, 694, 363, 992, RetcodeOuterClass.Retcode.RET_BOSS_CHEST_NO_QUALIFICATION_VALUE, PacketOpcodes.GetShopmallDataRsp, 168, 974, PacketOpcodes.DungeonGetStatueDropRsp, PacketOpcodes.EvtEntityRenderersChangedNotify, 748, 52, PacketOpcodes.GetSceneNpcPositionRsp, PacketOpcodes.GetActivityShopSheetInfoRsp, 642, 182, RetcodeOuterClass.Retcode.RET_ACTIVITY_CONTRIBUTION_NOT_ENOUGH_VALUE, 81, 344, 805, 988, 739, 511, RetcodeOuterClass.Retcode.RET_MCOIN_NOT_ENOUGH_VALUE, RetcodeOuterClass.Retcode.RET_BLOSSOM_CHEST_NO_QUALIFICATION_VALUE, 334, PacketOpcodes.BeginCameraSceneLookNotify, RetcodeOuterClass.Retcode.RET_MARK_ALREADY_EXISTS_VALUE, RetcodeOuterClass.Retcode.RET_SEA_LAMP_POPULARITY_EXCEED_LIMIT_VALUE, 955, 664, 981, RetcodeOuterClass.Retcode.RET_ITEM_EXCEED_OUTPUT_LIMIT_VALUE, 113, 974, 459, RetcodeOuterClass.Retcode.RET_TREASURE_MAP_ADD_TOKEN_EXCEED_LIMIT_VALUE, PacketOpcodes.AllSeenMonsterNotify, PacketOpcodes.GetAllActivatedBargainDataRsp, PacketOpcodes.GadgetChainLevelChangeNotify, RetcodeOuterClass.Retcode.RET_INVALID_SCENE_TO_USE_ANCHOR_POINT_VALUE, PacketOpcodes.EnterSceneDoneRsp, 926, PacketOpcodes.ExecuteGadgetLuaRsp, 102, 654, 459, 51, 686, 754, RetcodeOuterClass.Retcode.RET_WORKTOP_OPTION_NOT_EXIST_VALUE, VintageMarketInfoOuterClass.VintageMarketInfo.HELP_SKILL_ID_FIELD_NUMBER, PacketOpcodes.ParentQuestInferenceDataNotify, 403, 415, PacketOpcodes.AvatarBuffAddNotify, 687, 700, PacketOpcodes.DungeonCandidateTeamInviteRsp, RetcodeOuterClass.Retcode.RET_RESIN_GAIN_FAILED_VALUE, 656, 610, 738, 392, VintageMarketInfoOuterClass.VintageMarketInfo.HELP_SKILL_ID_FIELD_NUMBER, 799, 887, RetcodeOuterClass.Retcode.RET_EQUIP_WEARED_CANNOT_DROP_VALUE, PacketOpcodes.DungeonWayPointActivateRsp, 321, MusicBriefInfoOuterClass.MusicBriefInfo.UNK2700_KAMOCHAKPGP_FIELD_NUMBER, 617, 626, 502, 894, 679, PacketOpcodes.SceneEntityAppearNotify, 440, 680, 879, 194, 572, RetcodeOuterClass.Retcode.RET_VIRTUAL_EXCEED_LIMIT_VALUE, 724, 926, 56, 204, 700, RetcodeOuterClass.Retcode.RET_SHOP_CONTENT_NOT_MATCH_VALUE, 151, PacketOpcodes.QuestCreateEntityReq, PacketOpcodes.GetParentQuestVideoKeyReq, 797, 195, 791, RetcodeOuterClass.Retcode.RET_NO_SPRING_IN_AREA_VALUE, 945, 679, PacketOpcodes.JoinPlayerSceneReq, 59, 87, RetcodeOuterClass.Retcode.RET_VEHICLE_SLOT_OCCUPIED_VALUE, 713, 663, 412, 693, TokenId.TRANSIENT, RetcodeOuterClass.Retcode.RET_ITEM_INVALID_DROP_COUNT_VALUE, 134, 108, 571, 364, 631, PacketOpcodes.SceneKickPlayerReq, 174, RetcodeOuterClass.Retcode.RET_ITEM_SHOULD_HAVE_NO_LEVEL_VALUE, 304, TokenId.PACKAGE, 343, 97, PacketOpcodes.QuestListUpdateNotify, 751, 497, 314, 983, 374, RetcodeOuterClass.Retcode.RET_GENERAL_REWARD_HAS_TAKEN_VALUE, 928, 140, 206, 73, PacketOpcodes.ExecuteGroupTriggerReq, PacketOpcodes.DungeonCandidateTeamInviteReq, 736, 876, PacketOpcodes.GetQuestTalkHistoryRsp, PacketOpcodes.QuestListUpdateNotify, 305, 170, 514, 364, RetcodeOuterClass.Retcode.RET_FORGE_IS_LOCKED_VALUE, RetcodeOuterClass.Retcode.RET_GADGET_INTERACT_COND_NOT_MEET_VALUE, 82, 855, 953, 676, PacketOpcodes.EnterWorldAreaReq, TokenId.ANDAND, ActivityInfoOuterClass.ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER, PacketOpcodes.SceneCreateEntityReq, 750, 807, 827, 150, MusicGameSettleReqOuterClass.MusicGameSettleReq.SPEED_FIELD_NUMBER, PacketOpcodes.PlatformChangeRouteNotify, PacketOpcodes.DungeonRestartInviteReplyRsp, RetcodeOuterClass.Retcode.RET_CHEST_IS_LOCKED_VALUE, 378, 215, 828, 592, PacketOpcodes.CutSceneEndNotify, RetcodeOuterClass.Retcode.RET_INVALID_AREA_ID_VALUE, RetcodeOuterClass.Retcode.RET_CUR_SCENE_IS_NULL_VALUE, 710, 82, RetcodeOuterClass.Retcode.RET_SEA_LAMP_COIN_NOT_ENOUGH_VALUE, RetcodeOuterClass.Retcode.RET_GADGET_CUSTOM_COMBINATION_INVALID_VALUE, PacketOpcodes.MeetNpcRsp, PacketOpcodes.SceneEntityDisappearNotify, RetcodeOuterClass.Retcode.RET_GALLERY_NOT_START_VALUE, 462, PacketOpcodes.MarkEntityInMinMapNotify, 465, 502, 56, RetcodeOuterClass.Retcode.RET_RESIN_EXCEED_LIMIT_VALUE, RetcodeOuterClass.Retcode.RET_GENERAL_REWARD_LIFE_TIME_OVER_VALUE, PacketOpcodes.DungeonChallengeBeginNotify, PacketOpcodes.DungeonInterruptChallengeReq, 658, RetcodeOuterClass.Retcode.RET_SALESMAN_REWARD_COUNT_NOT_ENOUGH_VALUE, 905, 758, 745, 193, 768, 550, 608, PacketOpcodes.DungeonCandidateTeamCreateReq, 378, PacketOpcodes.WorldPlayerReviveRsp, 215, PacketOpcodes.DungeonEntryInfoReq, 792, PacketOpcodes.DungeonWayPointNotify, 61, 688, 793, 644, 986, 403, 106, 366, 905, 644, PacketOpcodes.AvatarBuffDelNotify, 567, 466, 434, 645, PacketOpcodes.SceneForceUnlockNotify, PacketOpcodes.EvtBulletMoveNotify, 550, PacketOpcodes.PlayerEnterDungeonRsp, 135, 780, 773, 635, PacketOpcodes.EvtBulletMoveNotify, RetcodeOuterClass.Retcode.RET_SHOP_CONTENT_NOT_MATCH_VALUE, 100, 626, 958, 165, 504, PacketOpcodes.DungeonRestartRsp, 176, 193, 713, PacketOpcodes.GadgetPlayStopNotify, PacketOpcodes.SealBattleProgressNotify, 203, 50, RetcodeOuterClass.Retcode.RET_AUTO_RECOVER_OPENSTATE_OFF_VALUE, 108, 645, 990, 626, 197, 510, 357, TokenId.f3079EQ, 850, 858, 364, 936, RetcodeOuterClass.Retcode.RET_NOT_SUPPORT_ITEM_VALUE};

    /* access modifiers changed from: package-private */
    public static int rNums(int i) {
        return RNUMS[i];
    }

    private Bzip2Rand() {
    }
}