package org.jline.utils;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PlayerLoginRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import net.bytebuddy.description.modifier.ModifierContributor;
import okio.Utf8;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/WCWidth.class */
public final class WCWidth {
    static Interval[] combining = {new Interval(768, RetcodeOuterClass.Retcode.RET_FLIGHT_GROUP_ACTIVITY_NOT_STARTED_VALUE), new Interval(PacketOpcodes.AbilityInvocationsNotify, 1158), new Interval(1160, 1161), new Interval(1425, 1469), new Interval(1471, 1471), new Interval(1473, PacketOpcodes.DelMailReq), new Interval(1476, ActivityInfoOuterClass.ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER), new Interval(1479, 1479), new Interval(1536, 1539), new Interval(ActivityInfoOuterClass.ActivityInfo.POTION_INFO_FIELD_NUMBER, 1557), new Interval(PacketOpcodes.DelBackupAvatarTeamReq, 1630), new Interval(PacketOpcodes.AvatarChangeCostumeNotify, PacketOpcodes.AvatarChangeCostumeNotify), new Interval(1750, PacketOpcodes.SetUpAvatarTeamReq), new Interval(1767, 1768), new Interval(PacketOpcodes.ChooseCurAvatarTeamRsp, PacketOpcodes.AvatarWearFlycloakReq), new Interval(PacketOpcodes.MpPlayOwnerCheckRsp, PacketOpcodes.MpPlayOwnerCheckRsp), new Interval(ChatInfoOuterClass.ChatInfo.TEXT_FIELD_NUMBER, ChatInfoOuterClass.ChatInfo.TEXT_FIELD_NUMBER), new Interval(PacketOpcodes.PlayerSetOnlyMPWithPSPlayerRsp, 1866), new Interval(1958, 1968), new Interval(2027, PlayerLoginRspOuterClass.PlayerLoginRsp.FEATUREBLOCKINFOLIST_FIELD_NUMBER), new Interval(PacketOpcodes.QueryPathReq, 2306), new Interval(2364, 2364), new Interval(2369, 2376), new Interval(2381, 2381), new Interval(2385, 2388), new Interval(2402, 2403), new Interval(2433, 2433), new Interval(PacketOpcodes.TowerSurrenderReq, PacketOpcodes.TowerSurrenderReq), new Interval(2497, 2500), new Interval(2509, 2509), new Interval(2530, 2531), new Interval(2561, 2562), new Interval(2620, 2620), new Interval(PacketOpcodes.GetBattlePassProductRsp, 2626), new Interval(PacketOpcodes.TakeBattlePassMissionPointReq, 2632), new Interval(PacketOpcodes.TakeBattlePassMissionPointRsp, PacketOpcodes.SetBattlePassViewedReq), new Interval(2672, 2673), new Interval(2689, 2690), new Interval(2748, 2748), new Interval(2753, 2757), new Interval(2759, 2760), new Interval(2765, 2765), new Interval(2786, PacketOpcodes.BlossomBriefInfoNotify), new Interval(2817, 2817), new Interval(2876, 2876), new Interval(2879, 2879), new Interval(2881, 2883), new Interval(2893, 2893), new Interval(2902, 2902), new Interval(2946, 2946), new Interval(3008, 3008), new Interval(3021, 3021), new Interval(3134, 3136), new Interval(3142, PacketOpcodes.GroupUnloadNotify), new Interval(3146, PacketOpcodes.SetEntityClientDataNotify), new Interval(3157, 3158), new Interval(3260, 3260), new Interval(3263, 3263), new Interval(3270, 3270), new Interval(3276, PacketOpcodes.PlayerChatCDNotify), new Interval(3298, 3299), new Interval(3393, 3395), new Interval(3405, 3405), new Interval(3530, 3530), new Interval(PacketOpcodes.PlayerRoutineDataNotify, 3540), new Interval(3542, 3542), new Interval(3633, 3633), new Interval(3636, 3642), new Interval(3655, 3662), new Interval(3761, 3761), new Interval(3764, 3769), new Interval(3771, 3772), new Interval(3784, 3789), new Interval(3864, 3865), new Interval(3893, 3893), new Interval(3895, 3895), new Interval(3897, 3897), new Interval(3953, 3966), new Interval(Utf8.MASK_2BYTES, 3972), new Interval(PacketOpcodes.MechanicusCloseNotify, 3975), new Interval(3984, 3991), new Interval(3993, PacketOpcodes.AddBlacklistReq), new Interval(PacketOpcodes.ReadSignatureAuditRsp, PacketOpcodes.ReadSignatureAuditRsp), new Interval(PacketOpcodes.CardProductRewardNotify, 4144), new Interval(PacketOpcodes.OrderFinishNotify, PacketOpcodes.OrderFinishNotify), new Interval(4150, 4151), new Interval(4153, 4153), new Interval(4184, PacketOpcodes.PlayerConfirmMatchReq), new Interval(PacketOpcodes.ScenePlayOwnerStartInviteReq, PacketOpcodes.HomeBasicInfoNotify), new Interval(4959, 4959), new Interval(5906, PacketOpcodes.WidgetUpdateExtraCDRsp), new Interval(5938, 5940), new Interval(5970, 5971), new Interval(RetcodeOuterClass.Retcode.RET_PATHFINDING_DESTINATION_NOT_EXIST_VALUE, RetcodeOuterClass.Retcode.RET_PATHFINDING_ERROR_SCENE_VALUE), new Interval(PacketOpcodes.FireworkReq, 6069), new Interval(6071, 6077), new Interval(6086, 6086), new Interval(6089, PacketOpcodes.FireworkSetReq), new Interval(6109, 6109), new Interval(PacketOpcodes.ToTheMoonQueryPathRsp, 6157), new Interval(PacketOpcodes.MusicGameStartToPlayOthersBeatmapRsp, PacketOpcodes.MusicGameStartToPlayOthersBeatmapRsp), new Interval(6432, 6434), new Interval(6439, 6440), new Interval(6450, 6450), new Interval(6457, 6459), new Interval(6679, 6680), new Interval(6912, 6915), new Interval(6964, 6964), new Interval(6966, 6970), new Interval(6972, 6972), new Interval(6978, 6978), new Interval(RetcodeOuterClass.Retcode.RET_BLACKLIST_PLAYER_CANNOT_ADD_FRIEND_VALUE, RetcodeOuterClass.Retcode.RET_REPORT_CONTENT_ILLEGAL_VALUE), new Interval(7616, 7626), new Interval(7678, ModifierContributor.ForMethod.MASK), new Interval(8203, PacketOpcodes.RoguelikeEffectViewReq), new Interval(8234, 8238), new Interval(8288, 8291), new Interval(8298, 8303), new Interval(8400, 8431), new Interval(12330, 12335), new Interval(12441, 12442), new Interval(43014, 43014), new Interval(43019, 43019), new Interval(43045, 43046), new Interval(64286, 64286), new Interval(65024, 65039), new Interval(65056, 65059), new Interval(65279, 65279), new Interval(65529, 65531), new Interval(68097, 68099), new Interval(68101, 68102), new Interval(68108, 68111), new Interval(68152, 68154), new Interval(68159, 68159), new Interval(119143, 119145), new Interval(119155, 119170), new Interval(119173, 119179), new Interval(119210, 119213), new Interval(119362, 119364), new Interval(127995, 127999), new Interval(917505, 917505), new Interval(917536, 917631), new Interval(917760, 917999)};

    private WCWidth() {
    }

    public static int wcwidth(int ucs) {
        if (ucs == 0) {
            return 0;
        }
        if (ucs < 32) {
            return -1;
        }
        if (ucs >= 127 && ucs < 160) {
            return -1;
        }
        if (bisearch(ucs, combining, combining.length - 1)) {
            return 0;
        }
        return 1 + ((ucs < 4352 || (ucs > 4447 && ucs != 9001 && ucs != 9002 && ((ucs < 11904 || ucs > 42191 || ucs == 12351) && ((ucs < 44032 || ucs > 55203) && ((ucs < 63744 || ucs > 64255) && ((ucs < 65040 || ucs > 65049) && ((ucs < 65072 || ucs > 65135) && ((ucs < 65280 || ucs > 65376) && ((ucs < 65504 || ucs > 65510) && ((ucs < 126976 || ucs > 130798) && ((ucs < 131072 || ucs > 196605) && (ucs < 196608 || ucs > 262141)))))))))))) ? 0 : 1);
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/utils/WCWidth$Interval.class */
    public static class Interval {
        public final int first;
        public final int last;

        public Interval(int first, int last) {
            this.first = first;
            this.last = last;
        }
    }

    private static boolean bisearch(int ucs, Interval[] table, int max) {
        int min = 0;
        if (ucs < table[0].first || ucs > table[max].last) {
            return false;
        }
        while (max >= min) {
            int mid = (min + max) / 2;
            if (ucs > table[mid].last) {
                min = mid + 1;
            } else if (ucs >= table[mid].first) {
                return true;
            } else {
                max = mid - 1;
            }
        }
        return false;
    }
}
