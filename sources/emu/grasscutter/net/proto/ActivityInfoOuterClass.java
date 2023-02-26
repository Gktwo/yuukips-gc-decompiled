package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityPushTipsDataOuterClass;
import emu.grasscutter.net.proto.ActivityWatcherInfoOuterClass;
import emu.grasscutter.net.proto.ArenaChallengeInfoOuterClass;
import emu.grasscutter.net.proto.AsterInfoOuterClass;
import emu.grasscutter.net.proto.BartenderInfoOuterClass;
import emu.grasscutter.net.proto.BlessingInfoOuterClass;
import emu.grasscutter.net.proto.BlitzRushInfoOuterClass;
import emu.grasscutter.net.proto.BounceConjuringInfoOuterClass;
import emu.grasscutter.net.proto.BrickBreakerInfoOuterClass;
import emu.grasscutter.net.proto.BuoyantCombatInfoOuterClass;
import emu.grasscutter.net.proto.ChallnelerSlabInfoOuterClass;
import emu.grasscutter.net.proto.CharAmusementInfoOuterClass;
import emu.grasscutter.net.proto.ChessInfoOuterClass;
import emu.grasscutter.net.proto.CoinCollectInfoOuterClass;
import emu.grasscutter.net.proto.CrucibleInfoOuterClass;
import emu.grasscutter.net.proto.CrystalLinkInfoOuterClass;
import emu.grasscutter.net.proto.DeliveryInfoOuterClass;
import emu.grasscutter.net.proto.DigInfoOuterClass;
import emu.grasscutter.net.proto.DragonSpineInfoOuterClass;
import emu.grasscutter.net.proto.DuelHeartInfoOuterClass;
import emu.grasscutter.net.proto.EchoShellInfoOuterClass;
import emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass;
import emu.grasscutter.net.proto.EffigyInfoOuterClass;
import emu.grasscutter.net.proto.ExpeditionInfoOuterClass;
import emu.grasscutter.net.proto.FindHilichurlInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairInfoOuterClass;
import emu.grasscutter.net.proto.FlightInfoOuterClass;
import emu.grasscutter.net.proto.FungusFighterInfoOuterClass;
import emu.grasscutter.net.proto.GachaInfoOuterClass;
import emu.grasscutter.net.proto.GcgFestivalInfoOuterClass;
import emu.grasscutter.net.proto.GearInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass;
import emu.grasscutter.net.proto.HachiInfoOuterClass;
import emu.grasscutter.net.proto.HideAndSeekInfoOuterClass;
import emu.grasscutter.net.proto.InstableSprayInfoOuterClass;
import emu.grasscutter.net.proto.IrodoriInfoOuterClass;
import emu.grasscutter.net.proto.IslandPartyInfoOuterClass;
import emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass;
import emu.grasscutter.net.proto.LuminanceStoneChallengeInfoOuterClass;
import emu.grasscutter.net.proto.LunaRiteInfoOuterClass;
import emu.grasscutter.net.proto.MichiaeMatsuriInfoOuterClass;
import emu.grasscutter.net.proto.MistTrialActivityInfoOuterClass;
import emu.grasscutter.net.proto.MoonfinTrialInfoOuterClass;
import emu.grasscutter.net.proto.MuqadasPotionInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.PhotoInfoOuterClass;
import emu.grasscutter.net.proto.PlantFlowerInfoOuterClass;
import emu.grasscutter.net.proto.PotionInfoOuterClass;
import emu.grasscutter.net.proto.RockBoardExploreInfoOuterClass;
import emu.grasscutter.net.proto.RogueDiaryInfoOuterClass;
import emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass;
import emu.grasscutter.net.proto.SalesmanInfoOuterClass;
import emu.grasscutter.net.proto.SamLampInfoOuterClass;
import emu.grasscutter.net.proto.SeaLampInfoOuterClass;
import emu.grasscutter.net.proto.SeaLampV3InfoOuterClass;
import emu.grasscutter.net.proto.SpiceInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass;
import emu.grasscutter.net.proto.SumoInfoOuterClass;
import emu.grasscutter.net.proto.TanukiTravelActivityInfoOuterClass;
import emu.grasscutter.net.proto.TeamChainInfoOuterClass;
import emu.grasscutter.net.proto.TreasureMapInfoOuterClass;
import emu.grasscutter.net.proto.TreasureSeelieInfoOuterClass;
import emu.grasscutter.net.proto.TrialAvatarInfoOuterClass;
import emu.grasscutter.net.proto.UgcInfoOuterClass;
import emu.grasscutter.net.proto.VintageInfoOuterClass;
import emu.grasscutter.net.proto.WaterSpiritInfoOuterClass;
import emu.grasscutter.net.proto.WindFieldInfoOuterClass;
import emu.grasscutter.net.proto.WinterCampInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass.class */
public final class ActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012ActivityInfo.proto\u001a\u0011SamLampInfo.proto\u001a\u0012CrucibleInfo.proto\u001a\u0012SalesmanInfo.proto\u001a\u0015TrialAvatarInfo.proto\u001a\u0012DeliveryInfo.proto\u001a\u000fAsterInfo.proto\u001a\u0010FlightInfo.proto\u001a\u0015DragonSpineInfo.proto\u001a\u0010EffigyInfo.proto\u001a\u0015TreasureMapInfo.proto\u001a\u0012BlessingInfo.proto\u001a\u0011SeaLampInfo.proto\u001a\u0014ExpeditionInfo.proto\u001a\u0018ArenaChallengeInfo.proto\u001a\u0013FleurFairInfo.proto\u001a\u0015WaterSpiritInfo.proto\u001a\u0018ChallnelerSlabInfo.proto\u001a\u001bMistTrialActivityInfo.proto\u001a\u0015HideAndSeekInfo.proto\u001a\u0017FindHilichurlInfo.proto\u001a\u0014SummerTimeInfo.proto\u001a\u0017BuoyantCombatInfo.proto\u001a\u0013EchoShellInfo.proto\u001a\u0019BounceConjuringInfo.proto\u001a\u0013BlitzRushInfo.proto\u001a\u000fChessInfo.proto\u001a\u000eSumoInfo.proto\u001a\u0016MoonfinTrialInfo.proto\u001a\u0012LunaRiteInfo.proto\u001a\u0015PlantFlowerInfo.proto\u001a!MusicGameActivityDetailInfo.proto\u001a\u001aRoguelikeDungoenInfo.proto\u001a\rDigInfo.proto\u001a\u000fHachiInfo.proto\u001a\u0014WinterCampInfo.proto\u001a\u0010PotionInfo.proto\u001a\u001eTanukiTravelActivityInfo.proto\u001a\u001dLanternRiteActivityInfo.proto\u001a\u0018MichiaeMatsuriInfo.proto\u001a\u0013BartenderInfo.proto\u001a\rUgcInfo.proto\u001a\u0015CrystalLinkInfo.proto\u001a\u0011IrodoriInfo.proto\u001a\u000fPhotoInfo.proto\u001a\u000fSpiceInfo.proto\u001a\u000fGachaInfo.proto\u001a!LuminanceStoneChallengeInfo.proto\u001a\u0014RogueDiaryInfo.proto\u001a\u0016SummerTimeV2Info.proto\u001a\u0015IslandPartyInfo.proto\u001a\u000eGearInfo.proto\u001a\u0019GravenInnocenceInfo.proto\u001a\u0017InstableSprayInfo.proto\u001a\u0017MuqadasPotionInfo.proto\u001a\u0018TreasureSeelieInfo.proto\u001a\u001aRockBoardExploreInfo.proto\u001a\u0011VintageInfo.proto\u001a\u0013WindFieldInfo.proto\u001a\u0017FungusFighterInfo.proto\u001a\u0017CharAmusementInfo.proto\u001a\u0019EffigyChallengeInfo.proto\u001a\u0015CoinCollectInfo.proto\u001a\u0016BrickBreakerInfo.proto\u001a\u0013DuelHeartInfo.proto\u001a\u0013SeaLampV3Info.proto\u001a\u0013TeamChainInfo.proto\u001a\u0015GcgFestivalInfo.proto\u001a\u001aActivityPushTipsData.proto\u001a\u0019ActivityWatcherInfo.proto\"÷\u001e\n\fActivityInfo\u0012<\n\u000factivityCoinMap\u0018\u0003 \u0003(\u000b2\".ActivityInfo.ActivityCoinMapEntry\u0012\u0013\n\nscoreLimit\u0018Ù\u000b \u0001(\r\u0012\u0018\n\u000ftakenRewardList\u0018\u0005 \u0003(\r\u0012\u001b\n\u0013Unk3300_MDBDPIBEGGH\u0018\u0007 \u0001(\b\u0012\u001c\n\u0013Unk3300_MJNPGEKLOCG\u0018ò\u0005 \u0001(\b\u0012\u000f\n\u0007endTime\u0018\f \u0001(\r\u0012\u0014\n\factivityType\u0018\n \u0001(\r\u0012\u001f\n\u0016selectedAvatarRewardId\u0018\u0004 \u0001(\r\u0012\u0014\n\fmeetCondList\u0018\u0002 \u0003(\r\u0012\u0012\n\nactivityId\u0018\u000f \u0001(\r\u0012\u001c\n\u0013Unk3300_ABJKLALKLDG\u0018\u0004 \u0001(\b\u0012\u0012\n\nisFinished\u0018\u0003 \u0001(\b\u00128\n\u0018activityPushTipsDataList\u0018Ð\u0002 \u0003(\u000b2\u0015.ActivityPushTipsData\u0012-\n\u000fwatcherInfoList\u0018\u000e \u0003(\u000b2\u0014.ActivityWatcherInfo\u0012\u001c\n\u0013Unk3300_CBCEHLJJOGI\u0018æ\b \u0001(\b\u0012\u0012\n\nscheduleId\u0018\u0006 \u0001(\r\u0012\u0016\n\u000eexpireCondList\u0018\t \u0003(\r\u0012\u0014\n\u000bfdjefldhela\u0018å\u000f \u0003(\r\u0012\u001b\n\u0013Unk3300_ICNJJKDHPCH\u0018\u000b \u0001(\b\u0012\u001a\n\u0011firstDayStartTime\u0018Ö\u0004 \u0001(\r\u0012\u0011\n\bcurScore\u0018\u0003 \u0001(\r\u0012:\n\u000ewishGiftNumMap\u0018\b \u0003(\u000b2!.ActivityInfo.WishGiftNumMapEntry\u0012\u001c\n\u0013Unk3300_NEPKLLBJFKK\u0018å\f \u0001(\b\u0012\u0011\n\tbeginTime\u0018\u0005 \u0001(\r\u0012%\n\rsam_lamp_info\u0018\u0004 \u0001(\u000b2\f.SamLampInfoH��\u0012&\n\rcrucible_info\u0018\r \u0001(\u000b2\r.CrucibleInfoH��\u0012&\n\rsalesman_info\u0018\u0001 \u0001(\u000b2\r.SalesmanInfoH��\u0012-\n\u0011trial_avatar_info\u0018\b \u0001(\u000b2\u0010.TrialAvatarInfoH��\u0012&\n\rdelivery_info\u0018  \u0001(\u000b2\r.DeliveryInfoH��\u0012!\n\naster_info\u0018\u000e \u0001(\u000b2\n.AsterInfoH��\u0012#\n\u000bflight_info\u0018¦\b \u0001(\u000b2\u000b.FlightInfoH��\u0012.\n\u0011dragon_spine_info\u0018ú\u0002 \u0001(\u000b2\u0010.DragonSpineInfoH��\u0012#\n\u000beffigy_info\u0018Ç\u000f \u0001(\u000b2\u000b.EffigyInfoH��\u0012.\n\u0011treasure_map_info\u0018¢\u0004 \u0001(\u000b2\u0010.TreasureMapInfoH��\u0012'\n\rblessing_info\u0018®\t \u0001(\u000b2\r.BlessingInfoH��\u0012&\n\rsea_lamp_info\u0018Â\u0004 \u0001(\u000b2\f.SeaLampInfoH��\u0012+\n\u000fexpedition_info\u0018¢\u0007 \u0001(\u000b2\u000f.ExpeditionInfoH��\u00124\n\u0014arena_challenge_info\u0018»\u0005 \u0001(\u000b2\u0013.ArenaChallengeInfoH��\u0012*\n\u000ffleur_fair_info\u0018Ü\b \u0001(\u000b2\u000e.FleurFairInfoH��\u0012.\n\u0011water_spirit_info\u0018ó\f \u0001(\u000b2\u0010.WaterSpiritInfoH��\u00124\n\u0014challneler_slab_info\u0018ï\b \u0001(\u000b2\u0013.ChallnelerSlabInfoH��\u0012;\n\u0018mist_trial_activity_info\u0018¨\n \u0001(\u000b2\u0016.MistTrialActivityInfoH��\u0012/\n\u0012hide_and_seek_info\u0018µ\b \u0001(\u000b2\u0010.HideAndSeekInfoH��\u00122\n\u0013find_hilichurl_info\u0018¡\u0003 \u0001(\u000b2\u0012.FindHilichurlInfoH��\u0012,\n\u0010summer_time_info\u0018Å\u000b \u0001(\u000b2\u000f.SummerTimeInfoH��\u00122\n\u0013buoyant_combat_info\u0018ý\t \u0001(\u000b2\u0012.BuoyantCombatInfoH��\u0012*\n\u000fecho_shell_info\u0018\t \u0001(\u000b2\u000e.EchoShellInfoH��\u00126\n\u0015bounce_conjuring_info\u0018\u0002 \u0001(\u000b2\u0014.BounceConjuringInfoH��\u0012*\n\u000fblitz_rush_info\u0018À\u0001 \u0001(\u000b2\u000e.BlitzRushInfoH��\u0012!\n\nchess_info\u0018\u000e \u0001(\u000b2\n.ChessInfoH��\u0012\u001f\n\tsumo_info\u0018ã\n \u0001(\u000b2\t.SumoInfoH��\u00120\n\u0012moonfin_trial_info\u0018â\b \u0001(\u000b2\u0011.MoonfinTrialInfoH��\u0012'\n\u000eluna_rite_info\u0018R \u0001(\u000b2\r.LunaRiteInfoH��\u0012.\n\u0011plant_flower_info\u0018È\u000e \u0001(\u000b2\u0010.PlantFlowerInfoH��\u00128\n\u000fmusic_game_info\u0018Ä\t \u0001(\u000b2\u001c.MusicGameActivityDetailInfoH��\u00128\n\u0016roguelike_dungoen_info\u0018\u000e \u0001(\u000b2\u0015.RoguelikeDungoenInfoH��\u0012\u001d\n\bdig_info\u0018¨\u0001 \u0001(\u000b2\b.DigInfoH��\u0012!\n\nhachi_info\u0018ÿ\f \u0001(\u000b2\n.HachiInfoH��\u0012+\n\u0010winter_camp_info\u0018r \u0001(\u000b2\u000f.WinterCampInfoH��\u0012#\n\u000bpotion_info\u0018\f \u0001(\u000b2\u000b.PotionInfoH��\u0012A\n\u001btanuki_travel_activity_info\u0018­\u000b \u0001(\u000b2\u0019.TanukiTravelActivityInfoH��\u0012?\n\u001alantern_rite_activity_info\u0018Ü\n \u0001(\u000b2\u0018.LanternRiteActivityInfoH��\u00124\n\u0014michiae_matsuri_info\u0018¬\u0003 \u0001(\u000b2\u0013.MichiaeMatsuriInfoH��\u0012(\n\u000ebartender_info\u0018# \u0001(\u000b2\u000e.BartenderInfoH��\u0012\u001d\n\bugc_info\u0018Í\u0004 \u0001(\u000b2\b.UgcInfoH��\u0012.\n\u0011crystal_link_info\u0018ß\n \u0001(\u000b2\u0010.CrystalLinkInfoH��\u0012%\n\firodori_info\u0018ö\u0007 \u0001(\u000b2\f.IrodoriInfoH��\u0012!\n\nphoto_info\u0018µ\u0002 \u0001(\u000b2\n.PhotoInfoH��\u0012!\n\nspice_info\u0018¦\u000b \u0001(\u000b2\n.SpiceInfoH��\u0012!\n\ngacha_info\u0018\t \u0001(\u000b2\n.GachaInfoH��\u0012G\n\u001eluminance_stone_challenge_info\u0018\u0001 \u0001(\u000b2\u001c.LuminanceStoneChallengeInfoH��\u0012,\n\u0010rogue_diary_info\u0018\u0003 \u0001(\u000b2\u000f.RogueDiaryInfoH��\u00120\n\u0012summer_time_v2info\u0018·\u0007 \u0001(\u000b2\u0011.SummerTimeV2InfoH��\u0012.\n\u0011island_party_info\u0018ß\f \u0001(\u000b2\u0010.IslandPartyInfoH��\u0012\u001f\n\tgear_info\u0018\u000e \u0001(\u000b2\t.GearInfoH��\u00126\n\u0015graven_innocence_info\u0018\t \u0001(\u000b2\u0014.GravenInnocenceInfoH��\u00122\n\u0013instable_spray_info\u0018°\u0007 \u0001(\u000b2\u0012.InstableSprayInfoH��\u00122\n\u0013muqadas_potion_info\u0018Æ\n \u0001(\u000b2\u0012.MuqadasPotionInfoH��\u00124\n\u0014treasure_seelie_info\u0018ö\b \u0001(\u000b2\u0013.TreasureSeelieInfoH��\u00129\n\u0017rock_board_explore_info\u0018ù\t \u0001(\u000b2\u0015.RockBoardExploreInfoH��\u0012%\n\fvintage_info\u0018¤\n \u0001(\u000b2\f.VintageInfoH��\u0012*\n\u000fwind_field_info\u0018í\u000f \u0001(\u000b2\u000e.WindFieldInfoH��\u00122\n\u0013fungus_fighter_info\u0018\f \u0001(\u000b2\u0012.FungusFighterInfoH��\u00122\n\u0013char_amusement_info\u0018ø\u0003 \u0001(\u000b2\u0012.CharAmusementInfoH��\u00126\n\u0015effigy_challenge_info\u0018ø\b \u0001(\u000b2\u0014.EffigyChallengeInfoH��\u0012.\n\u0011coin_collect_info\u0018¯\u0004 \u0001(\u000b2\u0010.CoinCollectInfoH��\u00120\n\u0012brick_breaker_info\u0018û\t \u0001(\u000b2\u0011.BrickBreakerInfoH��\u0012*\n\u000fduel_heart_info\u0018Ý\u0001 \u0001(\u000b2\u000e.DuelHeartInfoH��\u0012*\n\u000fsea_lamp_v3info\u0018¸\b \u0001(\u000b2\u000e.SeaLampV3InfoH��\u0012*\n\u000fteam_chain_info\u0018\u0001 \u0001(\u000b2\u000e.TeamChainInfoH��\u0012-\n\u0011gcg_festival_info\u0018G \u0001(\u000b2\u0010.GcgFestivalInfoH��\u001a6\n\u0014ActivityCoinMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a5\n\u0013WishGiftNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SamLampInfoOuterClass.getDescriptor(), CrucibleInfoOuterClass.getDescriptor(), SalesmanInfoOuterClass.getDescriptor(), TrialAvatarInfoOuterClass.getDescriptor(), DeliveryInfoOuterClass.getDescriptor(), AsterInfoOuterClass.getDescriptor(), FlightInfoOuterClass.getDescriptor(), DragonSpineInfoOuterClass.getDescriptor(), EffigyInfoOuterClass.getDescriptor(), TreasureMapInfoOuterClass.getDescriptor(), BlessingInfoOuterClass.getDescriptor(), SeaLampInfoOuterClass.getDescriptor(), ExpeditionInfoOuterClass.getDescriptor(), ArenaChallengeInfoOuterClass.getDescriptor(), FleurFairInfoOuterClass.getDescriptor(), WaterSpiritInfoOuterClass.getDescriptor(), ChallnelerSlabInfoOuterClass.getDescriptor(), MistTrialActivityInfoOuterClass.getDescriptor(), HideAndSeekInfoOuterClass.getDescriptor(), FindHilichurlInfoOuterClass.getDescriptor(), SummerTimeInfoOuterClass.getDescriptor(), BuoyantCombatInfoOuterClass.getDescriptor(), EchoShellInfoOuterClass.getDescriptor(), BounceConjuringInfoOuterClass.getDescriptor(), BlitzRushInfoOuterClass.getDescriptor(), ChessInfoOuterClass.getDescriptor(), SumoInfoOuterClass.getDescriptor(), MoonfinTrialInfoOuterClass.getDescriptor(), LunaRiteInfoOuterClass.getDescriptor(), PlantFlowerInfoOuterClass.getDescriptor(), MusicGameActivityDetailInfoOuterClass.getDescriptor(), RoguelikeDungoenInfoOuterClass.getDescriptor(), DigInfoOuterClass.getDescriptor(), HachiInfoOuterClass.getDescriptor(), WinterCampInfoOuterClass.getDescriptor(), PotionInfoOuterClass.getDescriptor(), TanukiTravelActivityInfoOuterClass.getDescriptor(), LanternRiteActivityInfoOuterClass.getDescriptor(), MichiaeMatsuriInfoOuterClass.getDescriptor(), BartenderInfoOuterClass.getDescriptor(), UgcInfoOuterClass.getDescriptor(), CrystalLinkInfoOuterClass.getDescriptor(), IrodoriInfoOuterClass.getDescriptor(), PhotoInfoOuterClass.getDescriptor(), SpiceInfoOuterClass.getDescriptor(), GachaInfoOuterClass.getDescriptor(), LuminanceStoneChallengeInfoOuterClass.getDescriptor(), RogueDiaryInfoOuterClass.getDescriptor(), SummerTimeV2InfoOuterClass.getDescriptor(), IslandPartyInfoOuterClass.getDescriptor(), GearInfoOuterClass.getDescriptor(), GravenInnocenceInfoOuterClass.getDescriptor(), InstableSprayInfoOuterClass.getDescriptor(), MuqadasPotionInfoOuterClass.getDescriptor(), TreasureSeelieInfoOuterClass.getDescriptor(), RockBoardExploreInfoOuterClass.getDescriptor(), VintageInfoOuterClass.getDescriptor(), WindFieldInfoOuterClass.getDescriptor(), FungusFighterInfoOuterClass.getDescriptor(), CharAmusementInfoOuterClass.getDescriptor(), EffigyChallengeInfoOuterClass.getDescriptor(), CoinCollectInfoOuterClass.getDescriptor(), BrickBreakerInfoOuterClass.getDescriptor(), DuelHeartInfoOuterClass.getDescriptor(), SeaLampV3InfoOuterClass.getDescriptor(), TeamChainInfoOuterClass.getDescriptor(), GcgFestivalInfoOuterClass.getDescriptor(), ActivityPushTipsDataOuterClass.getDescriptor(), ActivityWatcherInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_descriptor, new String[]{"ActivityCoinMap", "ScoreLimit", "TakenRewardList", "Unk3300MDBDPIBEGGH", "Unk3300MJNPGEKLOCG", "EndTime", "ActivityType", "SelectedAvatarRewardId", "MeetCondList", "ActivityId", "Unk3300ABJKLALKLDG", "IsFinished", "ActivityPushTipsDataList", "WatcherInfoList", "Unk3300CBCEHLJJOGI", "ScheduleId", "ExpireCondList", "Fdjefldhela", "Unk3300ICNJJKDHPCH", "FirstDayStartTime", "CurScore", "WishGiftNumMap", "Unk3300NEPKLLBJFKK", "BeginTime", "SamLampInfo", "CrucibleInfo", "SalesmanInfo", "TrialAvatarInfo", "DeliveryInfo", "AsterInfo", "FlightInfo", "DragonSpineInfo", "EffigyInfo", "TreasureMapInfo", "BlessingInfo", "SeaLampInfo", "ExpeditionInfo", "ArenaChallengeInfo", "FleurFairInfo", "WaterSpiritInfo", "ChallnelerSlabInfo", "MistTrialActivityInfo", "HideAndSeekInfo", "FindHilichurlInfo", "SummerTimeInfo", "BuoyantCombatInfo", "EchoShellInfo", "BounceConjuringInfo", "BlitzRushInfo", "ChessInfo", "SumoInfo", "MoonfinTrialInfo", "LunaRiteInfo", "PlantFlowerInfo", "MusicGameInfo", "RoguelikeDungoenInfo", "DigInfo", "HachiInfo", "WinterCampInfo", "PotionInfo", "TanukiTravelActivityInfo", "LanternRiteActivityInfo", "MichiaeMatsuriInfo", "BartenderInfo", "UgcInfo", "CrystalLinkInfo", "IrodoriInfo", "PhotoInfo", "SpiceInfo", "GachaInfo", "LuminanceStoneChallengeInfo", "RogueDiaryInfo", "SummerTimeV2Info", "IslandPartyInfo", "GearInfo", "GravenInnocenceInfo", "InstableSprayInfo", "MuqadasPotionInfo", "TreasureSeelieInfo", "RockBoardExploreInfo", "VintageInfo", "WindFieldInfo", "FungusFighterInfo", "CharAmusementInfo", "EffigyChallengeInfo", "CoinCollectInfo", "BrickBreakerInfo", "DuelHeartInfo", "SeaLampV3Info", "TeamChainInfo", "GcgFestivalInfo", "Detail"});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_ActivityCoinMapEntry_descriptor = internal_static_ActivityInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ActivityInfo_ActivityCoinMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f616x9eedbfc3 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_ActivityCoinMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_WishGiftNumMapEntry_descriptor = internal_static_ActivityInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_ActivityInfo_WishGiftNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f617xbf0b43da = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_WishGiftNumMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfoOrBuilder.class */
    public interface ActivityInfoOrBuilder extends MessageOrBuilder {
        int getActivityCoinMapCount();

        boolean containsActivityCoinMap(int i);

        @Deprecated
        Map<Integer, Integer> getActivityCoinMap();

        Map<Integer, Integer> getActivityCoinMapMap();

        int getActivityCoinMapOrDefault(int i, int i2);

        int getActivityCoinMapOrThrow(int i);

        int getScoreLimit();

        List<Integer> getTakenRewardListList();

        int getTakenRewardListCount();

        int getTakenRewardList(int i);

        boolean getUnk3300MDBDPIBEGGH();

        boolean getUnk3300MJNPGEKLOCG();

        int getEndTime();

        int getActivityType();

        int getSelectedAvatarRewardId();

        List<Integer> getMeetCondListList();

        int getMeetCondListCount();

        int getMeetCondList(int i);

        int getActivityId();

        boolean getUnk3300ABJKLALKLDG();

        boolean getIsFinished();

        List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> getActivityPushTipsDataListList();

        ActivityPushTipsDataOuterClass.ActivityPushTipsData getActivityPushTipsDataList(int i);

        int getActivityPushTipsDataListCount();

        List<? extends ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> getActivityPushTipsDataListOrBuilderList();

        ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder getActivityPushTipsDataListOrBuilder(int i);

        List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> getWatcherInfoListList();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfoList(int i);

        int getWatcherInfoListCount();

        List<? extends ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoListOrBuilderList();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoListOrBuilder(int i);

        boolean getUnk3300CBCEHLJJOGI();

        int getScheduleId();

        List<Integer> getExpireCondListList();

        int getExpireCondListCount();

        int getExpireCondList(int i);

        List<Integer> getFdjefldhelaList();

        int getFdjefldhelaCount();

        int getFdjefldhela(int i);

        boolean getUnk3300ICNJJKDHPCH();

        int getFirstDayStartTime();

        int getCurScore();

        int getWishGiftNumMapCount();

        boolean containsWishGiftNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getWishGiftNumMap();

        Map<Integer, Integer> getWishGiftNumMapMap();

        int getWishGiftNumMapOrDefault(int i, int i2);

        int getWishGiftNumMapOrThrow(int i);

        boolean getUnk3300NEPKLLBJFKK();

        int getBeginTime();

        boolean hasSamLampInfo();

        SamLampInfoOuterClass.SamLampInfo getSamLampInfo();

        SamLampInfoOuterClass.SamLampInfoOrBuilder getSamLampInfoOrBuilder();

        boolean hasCrucibleInfo();

        CrucibleInfoOuterClass.CrucibleInfo getCrucibleInfo();

        CrucibleInfoOuterClass.CrucibleInfoOrBuilder getCrucibleInfoOrBuilder();

        boolean hasSalesmanInfo();

        SalesmanInfoOuterClass.SalesmanInfo getSalesmanInfo();

        SalesmanInfoOuterClass.SalesmanInfoOrBuilder getSalesmanInfoOrBuilder();

        boolean hasTrialAvatarInfo();

        TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo();

        TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder();

        boolean hasDeliveryInfo();

        DeliveryInfoOuterClass.DeliveryInfo getDeliveryInfo();

        DeliveryInfoOuterClass.DeliveryInfoOrBuilder getDeliveryInfoOrBuilder();

        boolean hasAsterInfo();

        AsterInfoOuterClass.AsterInfo getAsterInfo();

        AsterInfoOuterClass.AsterInfoOrBuilder getAsterInfoOrBuilder();

        boolean hasFlightInfo();

        FlightInfoOuterClass.FlightInfo getFlightInfo();

        FlightInfoOuterClass.FlightInfoOrBuilder getFlightInfoOrBuilder();

        boolean hasDragonSpineInfo();

        DragonSpineInfoOuterClass.DragonSpineInfo getDragonSpineInfo();

        DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder getDragonSpineInfoOrBuilder();

        boolean hasEffigyInfo();

        EffigyInfoOuterClass.EffigyInfo getEffigyInfo();

        EffigyInfoOuterClass.EffigyInfoOrBuilder getEffigyInfoOrBuilder();

        boolean hasTreasureMapInfo();

        TreasureMapInfoOuterClass.TreasureMapInfo getTreasureMapInfo();

        TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder getTreasureMapInfoOrBuilder();

        boolean hasBlessingInfo();

        BlessingInfoOuterClass.BlessingInfo getBlessingInfo();

        BlessingInfoOuterClass.BlessingInfoOrBuilder getBlessingInfoOrBuilder();

        boolean hasSeaLampInfo();

        SeaLampInfoOuterClass.SeaLampInfo getSeaLampInfo();

        SeaLampInfoOuterClass.SeaLampInfoOrBuilder getSeaLampInfoOrBuilder();

        boolean hasExpeditionInfo();

        ExpeditionInfoOuterClass.ExpeditionInfo getExpeditionInfo();

        ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder getExpeditionInfoOrBuilder();

        boolean hasArenaChallengeInfo();

        ArenaChallengeInfoOuterClass.ArenaChallengeInfo getArenaChallengeInfo();

        ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder getArenaChallengeInfoOrBuilder();

        boolean hasFleurFairInfo();

        FleurFairInfoOuterClass.FleurFairInfo getFleurFairInfo();

        FleurFairInfoOuterClass.FleurFairInfoOrBuilder getFleurFairInfoOrBuilder();

        boolean hasWaterSpiritInfo();

        WaterSpiritInfoOuterClass.WaterSpiritInfo getWaterSpiritInfo();

        WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder getWaterSpiritInfoOrBuilder();

        boolean hasChallnelerSlabInfo();

        ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo getChallnelerSlabInfo();

        ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder getChallnelerSlabInfoOrBuilder();

        boolean hasMistTrialActivityInfo();

        MistTrialActivityInfoOuterClass.MistTrialActivityInfo getMistTrialActivityInfo();

        MistTrialActivityInfoOuterClass.MistTrialActivityInfoOrBuilder getMistTrialActivityInfoOrBuilder();

        boolean hasHideAndSeekInfo();

        HideAndSeekInfoOuterClass.HideAndSeekInfo getHideAndSeekInfo();

        HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder getHideAndSeekInfoOrBuilder();

        boolean hasFindHilichurlInfo();

        FindHilichurlInfoOuterClass.FindHilichurlInfo getFindHilichurlInfo();

        FindHilichurlInfoOuterClass.FindHilichurlInfoOrBuilder getFindHilichurlInfoOrBuilder();

        boolean hasSummerTimeInfo();

        SummerTimeInfoOuterClass.SummerTimeInfo getSummerTimeInfo();

        SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder getSummerTimeInfoOrBuilder();

        boolean hasBuoyantCombatInfo();

        BuoyantCombatInfoOuterClass.BuoyantCombatInfo getBuoyantCombatInfo();

        BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder getBuoyantCombatInfoOrBuilder();

        boolean hasEchoShellInfo();

        EchoShellInfoOuterClass.EchoShellInfo getEchoShellInfo();

        EchoShellInfoOuterClass.EchoShellInfoOrBuilder getEchoShellInfoOrBuilder();

        boolean hasBounceConjuringInfo();

        BounceConjuringInfoOuterClass.BounceConjuringInfo getBounceConjuringInfo();

        BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder getBounceConjuringInfoOrBuilder();

        boolean hasBlitzRushInfo();

        BlitzRushInfoOuterClass.BlitzRushInfo getBlitzRushInfo();

        BlitzRushInfoOuterClass.BlitzRushInfoOrBuilder getBlitzRushInfoOrBuilder();

        boolean hasChessInfo();

        ChessInfoOuterClass.ChessInfo getChessInfo();

        ChessInfoOuterClass.ChessInfoOrBuilder getChessInfoOrBuilder();

        boolean hasSumoInfo();

        SumoInfoOuterClass.SumoInfo getSumoInfo();

        SumoInfoOuterClass.SumoInfoOrBuilder getSumoInfoOrBuilder();

        boolean hasMoonfinTrialInfo();

        MoonfinTrialInfoOuterClass.MoonfinTrialInfo getMoonfinTrialInfo();

        MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder getMoonfinTrialInfoOrBuilder();

        boolean hasLunaRiteInfo();

        LunaRiteInfoOuterClass.LunaRiteInfo getLunaRiteInfo();

        LunaRiteInfoOuterClass.LunaRiteInfoOrBuilder getLunaRiteInfoOrBuilder();

        boolean hasPlantFlowerInfo();

        PlantFlowerInfoOuterClass.PlantFlowerInfo getPlantFlowerInfo();

        PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder getPlantFlowerInfoOrBuilder();

        boolean hasMusicGameInfo();

        MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo();

        MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder getMusicGameInfoOrBuilder();

        boolean hasRoguelikeDungoenInfo();

        RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo getRoguelikeDungoenInfo();

        RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder getRoguelikeDungoenInfoOrBuilder();

        boolean hasDigInfo();

        DigInfoOuterClass.DigInfo getDigInfo();

        DigInfoOuterClass.DigInfoOrBuilder getDigInfoOrBuilder();

        boolean hasHachiInfo();

        HachiInfoOuterClass.HachiInfo getHachiInfo();

        HachiInfoOuterClass.HachiInfoOrBuilder getHachiInfoOrBuilder();

        boolean hasWinterCampInfo();

        WinterCampInfoOuterClass.WinterCampInfo getWinterCampInfo();

        WinterCampInfoOuterClass.WinterCampInfoOrBuilder getWinterCampInfoOrBuilder();

        boolean hasPotionInfo();

        PotionInfoOuterClass.PotionInfo getPotionInfo();

        PotionInfoOuterClass.PotionInfoOrBuilder getPotionInfoOrBuilder();

        boolean hasTanukiTravelActivityInfo();

        TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo getTanukiTravelActivityInfo();

        TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder getTanukiTravelActivityInfoOrBuilder();

        boolean hasLanternRiteActivityInfo();

        LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo getLanternRiteActivityInfo();

        LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder getLanternRiteActivityInfoOrBuilder();

        boolean hasMichiaeMatsuriInfo();

        MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo getMichiaeMatsuriInfo();

        MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder getMichiaeMatsuriInfoOrBuilder();

        boolean hasBartenderInfo();

        BartenderInfoOuterClass.BartenderInfo getBartenderInfo();

        BartenderInfoOuterClass.BartenderInfoOrBuilder getBartenderInfoOrBuilder();

        boolean hasUgcInfo();

        UgcInfoOuterClass.UgcInfo getUgcInfo();

        UgcInfoOuterClass.UgcInfoOrBuilder getUgcInfoOrBuilder();

        boolean hasCrystalLinkInfo();

        CrystalLinkInfoOuterClass.CrystalLinkInfo getCrystalLinkInfo();

        CrystalLinkInfoOuterClass.CrystalLinkInfoOrBuilder getCrystalLinkInfoOrBuilder();

        boolean hasIrodoriInfo();

        IrodoriInfoOuterClass.IrodoriInfo getIrodoriInfo();

        IrodoriInfoOuterClass.IrodoriInfoOrBuilder getIrodoriInfoOrBuilder();

        boolean hasPhotoInfo();

        PhotoInfoOuterClass.PhotoInfo getPhotoInfo();

        PhotoInfoOuterClass.PhotoInfoOrBuilder getPhotoInfoOrBuilder();

        boolean hasSpiceInfo();

        SpiceInfoOuterClass.SpiceInfo getSpiceInfo();

        SpiceInfoOuterClass.SpiceInfoOrBuilder getSpiceInfoOrBuilder();

        boolean hasGachaInfo();

        GachaInfoOuterClass.GachaInfo getGachaInfo();

        GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoOrBuilder();

        boolean hasLuminanceStoneChallengeInfo();

        LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo getLuminanceStoneChallengeInfo();

        LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder();

        boolean hasRogueDiaryInfo();

        RogueDiaryInfoOuterClass.RogueDiaryInfo getRogueDiaryInfo();

        RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder getRogueDiaryInfoOrBuilder();

        boolean hasSummerTimeV2Info();

        SummerTimeV2InfoOuterClass.SummerTimeV2Info getSummerTimeV2Info();

        SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder getSummerTimeV2InfoOrBuilder();

        boolean hasIslandPartyInfo();

        IslandPartyInfoOuterClass.IslandPartyInfo getIslandPartyInfo();

        IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder getIslandPartyInfoOrBuilder();

        boolean hasGearInfo();

        GearInfoOuterClass.GearInfo getGearInfo();

        GearInfoOuterClass.GearInfoOrBuilder getGearInfoOrBuilder();

        boolean hasGravenInnocenceInfo();

        GravenInnocenceInfoOuterClass.GravenInnocenceInfo getGravenInnocenceInfo();

        GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder getGravenInnocenceInfoOrBuilder();

        boolean hasInstableSprayInfo();

        InstableSprayInfoOuterClass.InstableSprayInfo getInstableSprayInfo();

        InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder getInstableSprayInfoOrBuilder();

        boolean hasMuqadasPotionInfo();

        MuqadasPotionInfoOuterClass.MuqadasPotionInfo getMuqadasPotionInfo();

        MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder getMuqadasPotionInfoOrBuilder();

        boolean hasTreasureSeelieInfo();

        TreasureSeelieInfoOuterClass.TreasureSeelieInfo getTreasureSeelieInfo();

        TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder getTreasureSeelieInfoOrBuilder();

        boolean hasRockBoardExploreInfo();

        RockBoardExploreInfoOuterClass.RockBoardExploreInfo getRockBoardExploreInfo();

        RockBoardExploreInfoOuterClass.RockBoardExploreInfoOrBuilder getRockBoardExploreInfoOrBuilder();

        boolean hasVintageInfo();

        VintageInfoOuterClass.VintageInfo getVintageInfo();

        VintageInfoOuterClass.VintageInfoOrBuilder getVintageInfoOrBuilder();

        boolean hasWindFieldInfo();

        WindFieldInfoOuterClass.WindFieldInfo getWindFieldInfo();

        WindFieldInfoOuterClass.WindFieldInfoOrBuilder getWindFieldInfoOrBuilder();

        boolean hasFungusFighterInfo();

        FungusFighterInfoOuterClass.FungusFighterInfo getFungusFighterInfo();

        FungusFighterInfoOuterClass.FungusFighterInfoOrBuilder getFungusFighterInfoOrBuilder();

        boolean hasCharAmusementInfo();

        CharAmusementInfoOuterClass.CharAmusementInfo getCharAmusementInfo();

        CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder getCharAmusementInfoOrBuilder();

        boolean hasEffigyChallengeInfo();

        EffigyChallengeInfoOuterClass.EffigyChallengeInfo getEffigyChallengeInfo();

        EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder getEffigyChallengeInfoOrBuilder();

        boolean hasCoinCollectInfo();

        CoinCollectInfoOuterClass.CoinCollectInfo getCoinCollectInfo();

        CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder getCoinCollectInfoOrBuilder();

        boolean hasBrickBreakerInfo();

        BrickBreakerInfoOuterClass.BrickBreakerInfo getBrickBreakerInfo();

        BrickBreakerInfoOuterClass.BrickBreakerInfoOrBuilder getBrickBreakerInfoOrBuilder();

        boolean hasDuelHeartInfo();

        DuelHeartInfoOuterClass.DuelHeartInfo getDuelHeartInfo();

        DuelHeartInfoOuterClass.DuelHeartInfoOrBuilder getDuelHeartInfoOrBuilder();

        boolean hasSeaLampV3Info();

        SeaLampV3InfoOuterClass.SeaLampV3Info getSeaLampV3Info();

        SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder getSeaLampV3InfoOrBuilder();

        boolean hasTeamChainInfo();

        TeamChainInfoOuterClass.TeamChainInfo getTeamChainInfo();

        TeamChainInfoOuterClass.TeamChainInfoOrBuilder getTeamChainInfoOrBuilder();

        boolean hasGcgFestivalInfo();

        GcgFestivalInfoOuterClass.GcgFestivalInfo getGcgFestivalInfo();

        GcgFestivalInfoOuterClass.GcgFestivalInfoOrBuilder getGcgFestivalInfoOrBuilder();

        ActivityInfo.DetailCase getDetailCase();
    }

    private ActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfo.class */
    public static final class ActivityInfo extends GeneratedMessageV3 implements ActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int detailCase_;
        private Object detail_;
        public static final int ACTIVITYCOINMAP_FIELD_NUMBER = 406;
        private MapField<Integer, Integer> activityCoinMap_;
        public static final int SCORELIMIT_FIELD_NUMBER = 1497;
        private int scoreLimit_;
        public static final int TAKENREWARDLIST_FIELD_NUMBER = 644;
        private Internal.IntList takenRewardList_;
        private int takenRewardListMemoizedSerializedSize;
        public static final int UNK3300_MDBDPIBEGGH_FIELD_NUMBER = 7;
        private boolean unk3300MDBDPIBEGGH_;
        public static final int UNK3300_MJNPGEKLOCG_FIELD_NUMBER = 754;
        private boolean unk3300MJNPGEKLOCG_;
        public static final int ENDTIME_FIELD_NUMBER = 12;
        private int endTime_;
        public static final int ACTIVITYTYPE_FIELD_NUMBER = 10;
        private int activityType_;
        public static final int SELECTEDAVATARREWARDID_FIELD_NUMBER = 519;
        private int selectedAvatarRewardId_;
        public static final int MEETCONDLIST_FIELD_NUMBER = 2;
        private Internal.IntList meetCondList_;
        private int meetCondListMemoizedSerializedSize;
        public static final int ACTIVITYID_FIELD_NUMBER = 15;
        private int activityId_;
        public static final int UNK3300_ABJKLALKLDG_FIELD_NUMBER = 537;
        private boolean unk3300ABJKLALKLDG_;
        public static final int ISFINISHED_FIELD_NUMBER = 3;
        private boolean isFinished_;
        public static final int ACTIVITYPUSHTIPSDATALIST_FIELD_NUMBER = 336;
        private List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> activityPushTipsDataList_;
        public static final int WATCHERINFOLIST_FIELD_NUMBER = 14;
        private List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> watcherInfoList_;
        public static final int UNK3300_CBCEHLJJOGI_FIELD_NUMBER = 1126;
        private boolean unk3300CBCEHLJJOGI_;
        public static final int SCHEDULEID_FIELD_NUMBER = 6;
        private int scheduleId_;
        public static final int EXPIRECONDLIST_FIELD_NUMBER = 9;
        private Internal.IntList expireCondList_;
        private int expireCondListMemoizedSerializedSize;
        public static final int FDJEFLDHELA_FIELD_NUMBER = 2021;
        private Internal.IntList fdjefldhela_;
        private int fdjefldhelaMemoizedSerializedSize;
        public static final int UNK3300_ICNJJKDHPCH_FIELD_NUMBER = 11;
        private boolean unk3300ICNJJKDHPCH_;
        public static final int FIRSTDAYSTARTTIME_FIELD_NUMBER = 598;
        private int firstDayStartTime_;
        public static final int CURSCORE_FIELD_NUMBER = 396;
        private int curScore_;
        public static final int WISHGIFTNUMMAP_FIELD_NUMBER = 1052;
        private MapField<Integer, Integer> wishGiftNumMap_;
        public static final int UNK3300_NEPKLLBJFKK_FIELD_NUMBER = 1637;
        private boolean unk3300NEPKLLBJFKK_;
        public static final int BEGINTIME_FIELD_NUMBER = 5;
        private int beginTime_;
        public static final int SAM_LAMP_INFO_FIELD_NUMBER = 4;
        public static final int CRUCIBLE_INFO_FIELD_NUMBER = 13;
        public static final int SALESMAN_INFO_FIELD_NUMBER = 1;
        public static final int TRIAL_AVATAR_INFO_FIELD_NUMBER = 8;
        public static final int DELIVERY_INFO_FIELD_NUMBER = 32;
        public static final int ASTER_INFO_FIELD_NUMBER = 1808;
        public static final int FLIGHT_INFO_FIELD_NUMBER = 1062;
        public static final int DRAGON_SPINE_INFO_FIELD_NUMBER = 378;
        public static final int EFFIGY_INFO_FIELD_NUMBER = 1991;
        public static final int TREASURE_MAP_INFO_FIELD_NUMBER = 546;
        public static final int BLESSING_INFO_FIELD_NUMBER = 1198;
        public static final int SEA_LAMP_INFO_FIELD_NUMBER = 578;
        public static final int EXPEDITION_INFO_FIELD_NUMBER = 930;
        public static final int ARENA_CHALLENGE_INFO_FIELD_NUMBER = 699;
        public static final int FLEUR_FAIR_INFO_FIELD_NUMBER = 1116;
        public static final int WATER_SPIRIT_INFO_FIELD_NUMBER = 1651;
        public static final int CHALLNELER_SLAB_INFO_FIELD_NUMBER = 1135;
        public static final int MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER = 1320;
        public static final int HIDE_AND_SEEK_INFO_FIELD_NUMBER = 1077;
        public static final int FIND_HILICHURL_INFO_FIELD_NUMBER = 417;
        public static final int SUMMER_TIME_INFO_FIELD_NUMBER = 1477;
        public static final int BUOYANT_COMBAT_INFO_FIELD_NUMBER = 1277;
        public static final int ECHO_SHELL_INFO_FIELD_NUMBER = 1172;
        public static final int BOUNCE_CONJURING_INFO_FIELD_NUMBER = 278;
        public static final int BLITZ_RUSH_INFO_FIELD_NUMBER = 192;
        public static final int CHESS_INFO_FIELD_NUMBER = 1797;
        public static final int SUMO_INFO_FIELD_NUMBER = 1379;
        public static final int MOONFIN_TRIAL_INFO_FIELD_NUMBER = 1122;
        public static final int LUNA_RITE_INFO_FIELD_NUMBER = 82;
        public static final int PLANT_FLOWER_INFO_FIELD_NUMBER = 1864;
        public static final int MUSIC_GAME_INFO_FIELD_NUMBER = 1220;
        public static final int ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER = 1817;
        public static final int DIG_INFO_FIELD_NUMBER = 168;
        public static final int HACHI_INFO_FIELD_NUMBER = 1663;
        public static final int WINTER_CAMP_INFO_FIELD_NUMBER = 114;
        public static final int POTION_INFO_FIELD_NUMBER = 1552;
        public static final int TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER = 1453;
        public static final int LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER = 1372;
        public static final int MICHIAE_MATSURI_INFO_FIELD_NUMBER = 428;
        public static final int BARTENDER_INFO_FIELD_NUMBER = 35;
        public static final int UGC_INFO_FIELD_NUMBER = 589;
        public static final int CRYSTAL_LINK_INFO_FIELD_NUMBER = 1375;
        public static final int IRODORI_INFO_FIELD_NUMBER = 1014;
        public static final int PHOTO_INFO_FIELD_NUMBER = 309;
        public static final int SPICE_INFO_FIELD_NUMBER = 1446;
        public static final int GACHA_INFO_FIELD_NUMBER = 1177;
        public static final int LUMINANCE_STONE_CHALLENGE_INFO_FIELD_NUMBER = 142;
        public static final int ROGUE_DIARY_INFO_FIELD_NUMBER = 397;
        public static final int SUMMER_TIME_V2INFO_FIELD_NUMBER = 951;
        public static final int ISLAND_PARTY_INFO_FIELD_NUMBER = 1631;
        public static final int GEAR_INFO_FIELD_NUMBER = 1801;
        public static final int GRAVEN_INNOCENCE_INFO_FIELD_NUMBER = 1173;
        public static final int INSTABLE_SPRAY_INFO_FIELD_NUMBER = 944;
        public static final int MUQADAS_POTION_INFO_FIELD_NUMBER = 1350;
        public static final int TREASURE_SEELIE_INFO_FIELD_NUMBER = 1142;
        public static final int ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER = 1273;
        public static final int VINTAGE_INFO_FIELD_NUMBER = 1316;
        public static final int WIND_FIELD_INFO_FIELD_NUMBER = 2029;
        public static final int FUNGUS_FIGHTER_INFO_FIELD_NUMBER = 1543;
        public static final int CHAR_AMUSEMENT_INFO_FIELD_NUMBER = 504;
        public static final int EFFIGY_CHALLENGE_INFO_FIELD_NUMBER = 1144;
        public static final int COIN_COLLECT_INFO_FIELD_NUMBER = 559;
        public static final int BRICK_BREAKER_INFO_FIELD_NUMBER = 1275;
        public static final int DUEL_HEART_INFO_FIELD_NUMBER = 221;
        public static final int SEA_LAMP_V3INFO_FIELD_NUMBER = 1080;
        public static final int TEAM_CHAIN_INFO_FIELD_NUMBER = 144;
        public static final int GCG_FESTIVAL_INFO_FIELD_NUMBER = 71;
        private byte memoizedIsInitialized;
        private static final ActivityInfo DEFAULT_INSTANCE = new ActivityInfo();
        private static final Parser<ActivityInfo> PARSER = new AbstractParser<ActivityInfo>() { // from class: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.1
            @Override // com.google.protobuf.Parser
            public ActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ActivityInfo(input, extensionRegistry);
            }
        };

        /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
            java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
            	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
            	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
            */
        /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.internalGetMapField(int):com.google.protobuf.MapField
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        @Override // com.google.protobuf.GeneratedMessageV3
        protected com.google.protobuf.MapField internalGetMapField(int r5) {
            /*
                r4 = this;
                r0 = r5
                switch(r0) {
                    case 406: goto L_0x001c;
                    case 1052: goto L_0x0021;
                    default: goto L_0x0026;
                }
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetActivityCoinMap()
                return r0
                r0 = r4
                com.google.protobuf.MapField r0 = r0.internalGetWishGiftNumMap()
                return r0
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r1 = r0
                r2 = r5
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.internalGetMapField(int):com.google.protobuf.MapField");
        }

        private ActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.detailCase_ = 0;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.meetCondListMemoizedSerializedSize = -1;
            this.expireCondListMemoizedSerializedSize = -1;
            this.fdjefldhelaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ActivityInfo() {
            this.detailCase_ = 0;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.meetCondListMemoizedSerializedSize = -1;
            this.expireCondListMemoizedSerializedSize = -1;
            this.fdjefldhelaMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.takenRewardList_ = emptyIntList();
            this.meetCondList_ = emptyIntList();
            this.activityPushTipsDataList_ = Collections.emptyList();
            this.watcherInfoList_ = Collections.emptyList();
            this.expireCondList_ = emptyIntList();
            this.fdjefldhela_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:720:0x19cc */
        private ActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 10:
                                SalesmanInfoOuterClass.SalesmanInfo.Builder subBuilder = this.detailCase_ == 1 ? ((SalesmanInfoOuterClass.SalesmanInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SalesmanInfoOuterClass.SalesmanInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((SalesmanInfoOuterClass.SalesmanInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 1;
                                break;
                            case 16:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.meetCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.meetCondList_.addInt(input.readUInt32());
                                break;
                            case 18:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.meetCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.meetCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 24:
                                this.isFinished_ = input.readBool();
                                break;
                            case 34:
                                SamLampInfoOuterClass.SamLampInfo.Builder subBuilder2 = this.detailCase_ == 4 ? ((SamLampInfoOuterClass.SamLampInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SamLampInfoOuterClass.SamLampInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((SamLampInfoOuterClass.SamLampInfo) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 4;
                                break;
                            case 40:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 48:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 56:
                                this.unk3300MDBDPIBEGGH_ = input.readBool();
                                break;
                            case 66:
                                TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder subBuilder3 = this.detailCase_ == 8 ? ((TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TrialAvatarInfoOuterClass.TrialAvatarInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 8;
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.expireCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                this.expireCondList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.expireCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.expireCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 80:
                                this.activityType_ = input.readUInt32();
                                break;
                            case 88:
                                this.unk3300ICNJJKDHPCH_ = input.readBool();
                                break;
                            case 96:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 106:
                                CrucibleInfoOuterClass.CrucibleInfo.Builder subBuilder4 = this.detailCase_ == 13 ? ((CrucibleInfoOuterClass.CrucibleInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CrucibleInfoOuterClass.CrucibleInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((CrucibleInfoOuterClass.CrucibleInfo) this.detail_);
                                    this.detail_ = subBuilder4.buildPartial();
                                }
                                this.detailCase_ = 13;
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.watcherInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                this.watcherInfoList_.add((ActivityWatcherInfoOuterClass.ActivityWatcherInfo) input.readMessage(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.parser(), extensionRegistry));
                                break;
                            case 120:
                                this.activityId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.SceneAreaUnlockNotify:
                                DeliveryInfoOuterClass.DeliveryInfo.Builder subBuilder5 = this.detailCase_ == 32 ? ((DeliveryInfoOuterClass.DeliveryInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DeliveryInfoOuterClass.DeliveryInfo.parser(), extensionRegistry);
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((DeliveryInfoOuterClass.DeliveryInfo) this.detail_);
                                    this.detail_ = subBuilder5.buildPartial();
                                }
                                this.detailCase_ = 32;
                                break;
                            case PacketOpcodes.SceneKickPlayerNotify:
                                BartenderInfoOuterClass.BartenderInfo.Builder subBuilder6 = this.detailCase_ == 35 ? ((BartenderInfoOuterClass.BartenderInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BartenderInfoOuterClass.BartenderInfo.parser(), extensionRegistry);
                                if (subBuilder6 != null) {
                                    subBuilder6.mergeFrom((BartenderInfoOuterClass.BartenderInfo) this.detail_);
                                    this.detail_ = subBuilder6.buildPartial();
                                }
                                this.detailCase_ = 35;
                                break;
                            case PacketOpcodes.MeetNpcRsp:
                                GcgFestivalInfoOuterClass.GcgFestivalInfo.Builder subBuilder7 = this.detailCase_ == 71 ? ((GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GcgFestivalInfoOuterClass.GcgFestivalInfo.parser(), extensionRegistry);
                                if (subBuilder7 != null) {
                                    subBuilder7.mergeFrom((GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_);
                                    this.detail_ = subBuilder7.buildPartial();
                                }
                                this.detailCase_ = 71;
                                break;
                            case PacketOpcodes.ReliquaryUpgradeRsp:
                                LunaRiteInfoOuterClass.LunaRiteInfo.Builder subBuilder8 = this.detailCase_ == 82 ? ((LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LunaRiteInfoOuterClass.LunaRiteInfo.parser(), extensionRegistry);
                                if (subBuilder8 != null) {
                                    subBuilder8.mergeFrom((LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_);
                                    this.detail_ = subBuilder8.buildPartial();
                                }
                                this.detailCase_ = 82;
                                break;
                            case PacketOpcodes.DungeonSettleNotify:
                                WinterCampInfoOuterClass.WinterCampInfo.Builder subBuilder9 = this.detailCase_ == 114 ? ((WinterCampInfoOuterClass.WinterCampInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WinterCampInfoOuterClass.WinterCampInfo.parser(), extensionRegistry);
                                if (subBuilder9 != null) {
                                    subBuilder9.mergeFrom((WinterCampInfoOuterClass.WinterCampInfo) this.detail_);
                                    this.detail_ = subBuilder9.buildPartial();
                                }
                                this.detailCase_ = 114;
                                break;
                            case 1138:
                                LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.Builder subBuilder10 = this.detailCase_ == 142 ? ((LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.parser(), extensionRegistry);
                                if (subBuilder10 != null) {
                                    subBuilder10.mergeFrom((LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_);
                                    this.detail_ = subBuilder10.buildPartial();
                                }
                                this.detailCase_ = 142;
                                break;
                            case 1154:
                                TeamChainInfoOuterClass.TeamChainInfo.Builder subBuilder11 = this.detailCase_ == 144 ? ((TeamChainInfoOuterClass.TeamChainInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TeamChainInfoOuterClass.TeamChainInfo.parser(), extensionRegistry);
                                if (subBuilder11 != null) {
                                    subBuilder11.mergeFrom((TeamChainInfoOuterClass.TeamChainInfo) this.detail_);
                                    this.detail_ = subBuilder11.buildPartial();
                                }
                                this.detailCase_ = 144;
                                break;
                            case 1346:
                                DigInfoOuterClass.DigInfo.Builder subBuilder12 = this.detailCase_ == 168 ? ((DigInfoOuterClass.DigInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DigInfoOuterClass.DigInfo.parser(), extensionRegistry);
                                if (subBuilder12 != null) {
                                    subBuilder12.mergeFrom((DigInfoOuterClass.DigInfo) this.detail_);
                                    this.detail_ = subBuilder12.buildPartial();
                                }
                                this.detailCase_ = 168;
                                break;
                            case 1538:
                                BlitzRushInfoOuterClass.BlitzRushInfo.Builder subBuilder13 = this.detailCase_ == 192 ? ((BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BlitzRushInfoOuterClass.BlitzRushInfo.parser(), extensionRegistry);
                                if (subBuilder13 != null) {
                                    subBuilder13.mergeFrom((BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_);
                                    this.detail_ = subBuilder13.buildPartial();
                                }
                                this.detailCase_ = 192;
                                break;
                            case PacketOpcodes.ChooseCurAvatarTeamRsp:
                                DuelHeartInfoOuterClass.DuelHeartInfo.Builder subBuilder14 = this.detailCase_ == 221 ? ((DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DuelHeartInfoOuterClass.DuelHeartInfo.parser(), extensionRegistry);
                                if (subBuilder14 != null) {
                                    subBuilder14.mergeFrom((DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_);
                                    this.detail_ = subBuilder14.buildPartial();
                                }
                                this.detailCase_ = 221;
                                break;
                            case 2226:
                                BounceConjuringInfoOuterClass.BounceConjuringInfo.Builder subBuilder15 = this.detailCase_ == 278 ? ((BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BounceConjuringInfoOuterClass.BounceConjuringInfo.parser(), extensionRegistry);
                                if (subBuilder15 != null) {
                                    subBuilder15.mergeFrom((BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_);
                                    this.detail_ = subBuilder15.buildPartial();
                                }
                                this.detailCase_ = 278;
                                break;
                            case PacketOpcodes.TowerTeamSelectReq:
                                PhotoInfoOuterClass.PhotoInfo.Builder subBuilder16 = this.detailCase_ == 309 ? ((PhotoInfoOuterClass.PhotoInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PhotoInfoOuterClass.PhotoInfo.parser(), extensionRegistry);
                                if (subBuilder16 != null) {
                                    subBuilder16.mergeFrom((PhotoInfoOuterClass.PhotoInfo) this.detail_);
                                    this.detail_ = subBuilder16.buildPartial();
                                }
                                this.detailCase_ = 309;
                                break;
                            case 2690:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.activityPushTipsDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.activityPushTipsDataList_.add((ActivityPushTipsDataOuterClass.ActivityPushTipsData) input.readMessage(ActivityPushTipsDataOuterClass.ActivityPushTipsData.parser(), extensionRegistry));
                                break;
                            case 3026:
                                DragonSpineInfoOuterClass.DragonSpineInfo.Builder subBuilder17 = this.detailCase_ == 378 ? ((DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DragonSpineInfoOuterClass.DragonSpineInfo.parser(), extensionRegistry);
                                if (subBuilder17 != null) {
                                    subBuilder17.mergeFrom((DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_);
                                    this.detail_ = subBuilder17.buildPartial();
                                }
                                this.detailCase_ = 378;
                                break;
                            case 3168:
                                this.curScore_ = input.readUInt32();
                                break;
                            case 3178:
                                RogueDiaryInfoOuterClass.RogueDiaryInfo.Builder subBuilder18 = this.detailCase_ == 397 ? ((RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RogueDiaryInfoOuterClass.RogueDiaryInfo.parser(), extensionRegistry);
                                if (subBuilder18 != null) {
                                    subBuilder18.mergeFrom((RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_);
                                    this.detail_ = subBuilder18.buildPartial();
                                }
                                this.detailCase_ = 397;
                                break;
                            case 3250:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.activityCoinMap_ = MapField.newMapField(ActivityCoinMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> activityCoinMap__ = (MapEntry) input.readMessage(ActivityCoinMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.activityCoinMap_.getMutableMap().put(activityCoinMap__.getKey(), activityCoinMap__.getValue());
                                break;
                            case 3338:
                                FindHilichurlInfoOuterClass.FindHilichurlInfo.Builder subBuilder19 = this.detailCase_ == 417 ? ((FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FindHilichurlInfoOuterClass.FindHilichurlInfo.parser(), extensionRegistry);
                                if (subBuilder19 != null) {
                                    subBuilder19.mergeFrom((FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_);
                                    this.detail_ = subBuilder19.buildPartial();
                                }
                                this.detailCase_ = 417;
                                break;
                            case 3426:
                                MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.Builder subBuilder20 = this.detailCase_ == 428 ? ((MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.parser(), extensionRegistry);
                                if (subBuilder20 != null) {
                                    subBuilder20.mergeFrom((MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_);
                                    this.detail_ = subBuilder20.buildPartial();
                                }
                                this.detailCase_ = 428;
                                break;
                            case PacketOpcodes.SignatureAuditConfigNotify:
                                CharAmusementInfoOuterClass.CharAmusementInfo.Builder subBuilder21 = this.detailCase_ == 504 ? ((CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CharAmusementInfoOuterClass.CharAmusementInfo.parser(), extensionRegistry);
                                if (subBuilder21 != null) {
                                    subBuilder21.mergeFrom((CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_);
                                    this.detail_ = subBuilder21.buildPartial();
                                }
                                this.detailCase_ = 504;
                                break;
                            case PacketOpcodes.PlayerMatchAgreedResultNotify:
                                this.selectedAvatarRewardId_ = input.readUInt32();
                                break;
                            case 4296:
                                this.unk3300ABJKLALKLDG_ = input.readBool();
                                break;
                            case PacketOpcodes.ScenePlayOwnerStartInviteRsp:
                                TreasureMapInfoOuterClass.TreasureMapInfo.Builder subBuilder22 = this.detailCase_ == 546 ? ((TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TreasureMapInfoOuterClass.TreasureMapInfo.parser(), extensionRegistry);
                                if (subBuilder22 != null) {
                                    subBuilder22.mergeFrom((TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_);
                                    this.detail_ = subBuilder22.buildPartial();
                                }
                                this.detailCase_ = TREASURE_MAP_INFO_FIELD_NUMBER;
                                break;
                            case 4474:
                                CoinCollectInfoOuterClass.CoinCollectInfo.Builder subBuilder23 = this.detailCase_ == 559 ? ((CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CoinCollectInfoOuterClass.CoinCollectInfo.parser(), extensionRegistry);
                                if (subBuilder23 != null) {
                                    subBuilder23.mergeFrom((CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_);
                                    this.detail_ = subBuilder23.buildPartial();
                                }
                                this.detailCase_ = 559;
                                break;
                            case 4626:
                                SeaLampInfoOuterClass.SeaLampInfo.Builder subBuilder24 = this.detailCase_ == 578 ? ((SeaLampInfoOuterClass.SeaLampInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SeaLampInfoOuterClass.SeaLampInfo.parser(), extensionRegistry);
                                if (subBuilder24 != null) {
                                    subBuilder24.mergeFrom((SeaLampInfoOuterClass.SeaLampInfo) this.detail_);
                                    this.detail_ = subBuilder24.buildPartial();
                                }
                                this.detailCase_ = SEA_LAMP_INFO_FIELD_NUMBER;
                                break;
                            case 4714:
                                UgcInfoOuterClass.UgcInfo.Builder subBuilder25 = this.detailCase_ == 589 ? ((UgcInfoOuterClass.UgcInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(UgcInfoOuterClass.UgcInfo.parser(), extensionRegistry);
                                if (subBuilder25 != null) {
                                    subBuilder25.mergeFrom((UgcInfoOuterClass.UgcInfo) this.detail_);
                                    this.detail_ = subBuilder25.buildPartial();
                                }
                                this.detailCase_ = UGC_INFO_FIELD_NUMBER;
                                break;
                            case PacketOpcodes.HomeCustomFurnitureInfoNotify:
                                this.firstDayStartTime_ = input.readUInt32();
                                break;
                            case 5152:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.takenRewardList_.addInt(input.readUInt32());
                                break;
                            case 5154:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 5594:
                                ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder subBuilder26 = this.detailCase_ == 699 ? ((ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ArenaChallengeInfoOuterClass.ArenaChallengeInfo.parser(), extensionRegistry);
                                if (subBuilder26 != null) {
                                    subBuilder26.mergeFrom((ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_);
                                    this.detail_ = subBuilder26.buildPartial();
                                }
                                this.detailCase_ = 699;
                                break;
                            case 6032:
                                this.unk3300MJNPGEKLOCG_ = input.readBool();
                                break;
                            case 7442:
                                ExpeditionInfoOuterClass.ExpeditionInfo.Builder subBuilder27 = this.detailCase_ == 930 ? ((ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ExpeditionInfoOuterClass.ExpeditionInfo.parser(), extensionRegistry);
                                if (subBuilder27 != null) {
                                    subBuilder27.mergeFrom((ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_);
                                    this.detail_ = subBuilder27.buildPartial();
                                }
                                this.detailCase_ = 930;
                                break;
                            case 7554:
                                InstableSprayInfoOuterClass.InstableSprayInfo.Builder subBuilder28 = this.detailCase_ == 944 ? ((InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(InstableSprayInfoOuterClass.InstableSprayInfo.parser(), extensionRegistry);
                                if (subBuilder28 != null) {
                                    subBuilder28.mergeFrom((InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_);
                                    this.detail_ = subBuilder28.buildPartial();
                                }
                                this.detailCase_ = INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                                break;
                            case 7610:
                                SummerTimeV2InfoOuterClass.SummerTimeV2Info.Builder subBuilder29 = this.detailCase_ == 951 ? ((SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SummerTimeV2InfoOuterClass.SummerTimeV2Info.parser(), extensionRegistry);
                                if (subBuilder29 != null) {
                                    subBuilder29.mergeFrom((SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_);
                                    this.detail_ = subBuilder29.buildPartial();
                                }
                                this.detailCase_ = 951;
                                break;
                            case PacketOpcodes.LanternRiteEndFireworksReformRsp:
                                IrodoriInfoOuterClass.IrodoriInfo.Builder subBuilder30 = this.detailCase_ == 1014 ? ((IrodoriInfoOuterClass.IrodoriInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(IrodoriInfoOuterClass.IrodoriInfo.parser(), extensionRegistry);
                                if (subBuilder30 != null) {
                                    subBuilder30.mergeFrom((IrodoriInfoOuterClass.IrodoriInfo) this.detail_);
                                    this.detail_ = subBuilder30.buildPartial();
                                }
                                this.detailCase_ = 1014;
                                break;
                            case 8418:
                                if ((mutable_bitField0_ & 128) == 0) {
                                    this.wishGiftNumMap_ = MapField.newMapField(WishGiftNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> wishGiftNumMap__ = (MapEntry) input.readMessage(WishGiftNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.wishGiftNumMap_.getMutableMap().put(wishGiftNumMap__.getKey(), wishGiftNumMap__.getValue());
                                break;
                            case 8498:
                                FlightInfoOuterClass.FlightInfo.Builder subBuilder31 = this.detailCase_ == 1062 ? ((FlightInfoOuterClass.FlightInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FlightInfoOuterClass.FlightInfo.parser(), extensionRegistry);
                                if (subBuilder31 != null) {
                                    subBuilder31.mergeFrom((FlightInfoOuterClass.FlightInfo) this.detail_);
                                    this.detail_ = subBuilder31.buildPartial();
                                }
                                this.detailCase_ = 1062;
                                break;
                            case PacketOpcodes.MichiaeMatsuriDarkPressureLevelUpdateNotify:
                                HideAndSeekInfoOuterClass.HideAndSeekInfo.Builder subBuilder32 = this.detailCase_ == 1077 ? ((HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(HideAndSeekInfoOuterClass.HideAndSeekInfo.parser(), extensionRegistry);
                                if (subBuilder32 != null) {
                                    subBuilder32.mergeFrom((HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_);
                                    this.detail_ = subBuilder32.buildPartial();
                                }
                                this.detailCase_ = HIDE_AND_SEEK_INFO_FIELD_NUMBER;
                                break;
                            case PacketOpcodes.TriggerRoguelikeCurseNotify:
                                SeaLampV3InfoOuterClass.SeaLampV3Info.Builder subBuilder33 = this.detailCase_ == 1080 ? ((SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SeaLampV3InfoOuterClass.SeaLampV3Info.parser(), extensionRegistry);
                                if (subBuilder33 != null) {
                                    subBuilder33.mergeFrom((SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_);
                                    this.detail_ = subBuilder33.buildPartial();
                                }
                                this.detailCase_ = 1080;
                                break;
                            case 8930:
                                FleurFairInfoOuterClass.FleurFairInfo.Builder subBuilder34 = this.detailCase_ == 1116 ? ((FleurFairInfoOuterClass.FleurFairInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FleurFairInfoOuterClass.FleurFairInfo.parser(), extensionRegistry);
                                if (subBuilder34 != null) {
                                    subBuilder34.mergeFrom((FleurFairInfoOuterClass.FleurFairInfo) this.detail_);
                                    this.detail_ = subBuilder34.buildPartial();
                                }
                                this.detailCase_ = 1116;
                                break;
                            case 8978:
                                MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder subBuilder35 = this.detailCase_ == 1122 ? ((MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MoonfinTrialInfoOuterClass.MoonfinTrialInfo.parser(), extensionRegistry);
                                if (subBuilder35 != null) {
                                    subBuilder35.mergeFrom((MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_);
                                    this.detail_ = subBuilder35.buildPartial();
                                }
                                this.detailCase_ = 1122;
                                break;
                            case RET_REUNION_MISSION_NOT_FINISH_VALUE:
                                this.unk3300CBCEHLJJOGI_ = input.readBool();
                                break;
                            case 9082:
                                ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.Builder subBuilder36 = this.detailCase_ == 1135 ? ((ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.parser(), extensionRegistry);
                                if (subBuilder36 != null) {
                                    subBuilder36.mergeFrom((ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_);
                                    this.detail_ = subBuilder36.buildPartial();
                                }
                                this.detailCase_ = CHALLNELER_SLAB_INFO_FIELD_NUMBER;
                                break;
                            case RET_CHANNELLER_SLAB_TOKEN_NOT_ENOUGH_VALUE:
                                TreasureSeelieInfoOuterClass.TreasureSeelieInfo.Builder subBuilder37 = this.detailCase_ == 1142 ? ((TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TreasureSeelieInfoOuterClass.TreasureSeelieInfo.parser(), extensionRegistry);
                                if (subBuilder37 != null) {
                                    subBuilder37.mergeFrom((TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_);
                                    this.detail_ = subBuilder37.buildPartial();
                                }
                                this.detailCase_ = TREASURE_SEELIE_INFO_FIELD_NUMBER;
                                break;
                            case 9154:
                                EffigyChallengeInfoOuterClass.EffigyChallengeInfo.Builder subBuilder38 = this.detailCase_ == 1144 ? ((EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyChallengeInfoOuterClass.EffigyChallengeInfo.parser(), extensionRegistry);
                                if (subBuilder38 != null) {
                                    subBuilder38.mergeFrom((EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_);
                                    this.detail_ = subBuilder38.buildPartial();
                                }
                                this.detailCase_ = EFFIGY_CHALLENGE_INFO_FIELD_NUMBER;
                                break;
                            case 9378:
                                EchoShellInfoOuterClass.EchoShellInfo.Builder subBuilder39 = this.detailCase_ == 1172 ? ((EchoShellInfoOuterClass.EchoShellInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EchoShellInfoOuterClass.EchoShellInfo.parser(), extensionRegistry);
                                if (subBuilder39 != null) {
                                    subBuilder39.mergeFrom((EchoShellInfoOuterClass.EchoShellInfo) this.detail_);
                                    this.detail_ = subBuilder39.buildPartial();
                                }
                                this.detailCase_ = ECHO_SHELL_INFO_FIELD_NUMBER;
                                break;
                            case 9386:
                                GravenInnocenceInfoOuterClass.GravenInnocenceInfo.Builder subBuilder40 = this.detailCase_ == 1173 ? ((GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GravenInnocenceInfoOuterClass.GravenInnocenceInfo.parser(), extensionRegistry);
                                if (subBuilder40 != null) {
                                    subBuilder40.mergeFrom((GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_);
                                    this.detail_ = subBuilder40.buildPartial();
                                }
                                this.detailCase_ = GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                                break;
                            case 9418:
                                GachaInfoOuterClass.GachaInfo.Builder subBuilder41 = this.detailCase_ == 1177 ? ((GachaInfoOuterClass.GachaInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GachaInfoOuterClass.GachaInfo.parser(), extensionRegistry);
                                if (subBuilder41 != null) {
                                    subBuilder41.mergeFrom((GachaInfoOuterClass.GachaInfo) this.detail_);
                                    this.detail_ = subBuilder41.buildPartial();
                                }
                                this.detailCase_ = GACHA_INFO_FIELD_NUMBER;
                                break;
                            case 9586:
                                BlessingInfoOuterClass.BlessingInfo.Builder subBuilder42 = this.detailCase_ == 1198 ? ((BlessingInfoOuterClass.BlessingInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BlessingInfoOuterClass.BlessingInfo.parser(), extensionRegistry);
                                if (subBuilder42 != null) {
                                    subBuilder42.mergeFrom((BlessingInfoOuterClass.BlessingInfo) this.detail_);
                                    this.detail_ = subBuilder42.buildPartial();
                                }
                                this.detailCase_ = 1198;
                                break;
                            case RET_HOME_AVATAR_NOT_SHOW_VALUE:
                                MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder subBuilder43 = this.detailCase_ == 1220 ? ((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder43 != null) {
                                    subBuilder43.mergeFrom((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder43.buildPartial();
                                }
                                this.detailCase_ = 1220;
                                break;
                            case 10186:
                                RockBoardExploreInfoOuterClass.RockBoardExploreInfo.Builder subBuilder44 = this.detailCase_ == 1273 ? ((RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RockBoardExploreInfoOuterClass.RockBoardExploreInfo.parser(), extensionRegistry);
                                if (subBuilder44 != null) {
                                    subBuilder44.mergeFrom((RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_);
                                    this.detail_ = subBuilder44.buildPartial();
                                }
                                this.detailCase_ = ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                                break;
                            case 10202:
                                BrickBreakerInfoOuterClass.BrickBreakerInfo.Builder subBuilder45 = this.detailCase_ == 1275 ? ((BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BrickBreakerInfoOuterClass.BrickBreakerInfo.parser(), extensionRegistry);
                                if (subBuilder45 != null) {
                                    subBuilder45.mergeFrom((BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_);
                                    this.detail_ = subBuilder45.buildPartial();
                                }
                                this.detailCase_ = BRICK_BREAKER_INFO_FIELD_NUMBER;
                                break;
                            case 10218:
                                BuoyantCombatInfoOuterClass.BuoyantCombatInfo.Builder subBuilder46 = this.detailCase_ == 1277 ? ((BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BuoyantCombatInfoOuterClass.BuoyantCombatInfo.parser(), extensionRegistry);
                                if (subBuilder46 != null) {
                                    subBuilder46.mergeFrom((BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_);
                                    this.detail_ = subBuilder46.buildPartial();
                                }
                                this.detailCase_ = BUOYANT_COMBAT_INFO_FIELD_NUMBER;
                                break;
                            case 10530:
                                VintageInfoOuterClass.VintageInfo.Builder subBuilder47 = this.detailCase_ == 1316 ? ((VintageInfoOuterClass.VintageInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(VintageInfoOuterClass.VintageInfo.parser(), extensionRegistry);
                                if (subBuilder47 != null) {
                                    subBuilder47.mergeFrom((VintageInfoOuterClass.VintageInfo) this.detail_);
                                    this.detail_ = subBuilder47.buildPartial();
                                }
                                this.detailCase_ = 1316;
                                break;
                            case 10562:
                                MistTrialActivityInfoOuterClass.MistTrialActivityInfo.Builder subBuilder48 = this.detailCase_ == 1320 ? ((MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MistTrialActivityInfoOuterClass.MistTrialActivityInfo.parser(), extensionRegistry);
                                if (subBuilder48 != null) {
                                    subBuilder48.mergeFrom((MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_);
                                    this.detail_ = subBuilder48.buildPartial();
                                }
                                this.detailCase_ = 1320;
                                break;
                            case 10802:
                                MuqadasPotionInfoOuterClass.MuqadasPotionInfo.Builder subBuilder49 = this.detailCase_ == 1350 ? ((MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MuqadasPotionInfoOuterClass.MuqadasPotionInfo.parser(), extensionRegistry);
                                if (subBuilder49 != null) {
                                    subBuilder49.mergeFrom((MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_);
                                    this.detail_ = subBuilder49.buildPartial();
                                }
                                this.detailCase_ = MUQADAS_POTION_INFO_FIELD_NUMBER;
                                break;
                            case 10978:
                                LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.Builder subBuilder50 = this.detailCase_ == 1372 ? ((LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.parser(), extensionRegistry);
                                if (subBuilder50 != null) {
                                    subBuilder50.mergeFrom((LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_);
                                    this.detail_ = subBuilder50.buildPartial();
                                }
                                this.detailCase_ = LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER;
                                break;
                            case RET_FISH_STATE_ERROR_VALUE:
                                CrystalLinkInfoOuterClass.CrystalLinkInfo.Builder subBuilder51 = this.detailCase_ == 1375 ? ((CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CrystalLinkInfoOuterClass.CrystalLinkInfo.parser(), extensionRegistry);
                                if (subBuilder51 != null) {
                                    subBuilder51.mergeFrom((CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_);
                                    this.detail_ = subBuilder51.buildPartial();
                                }
                                this.detailCase_ = CRYSTAL_LINK_INFO_FIELD_NUMBER;
                                break;
                            case 11034:
                                SumoInfoOuterClass.SumoInfo.Builder subBuilder52 = this.detailCase_ == 1379 ? ((SumoInfoOuterClass.SumoInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SumoInfoOuterClass.SumoInfo.parser(), extensionRegistry);
                                if (subBuilder52 != null) {
                                    subBuilder52.mergeFrom((SumoInfoOuterClass.SumoInfo) this.detail_);
                                    this.detail_ = subBuilder52.buildPartial();
                                }
                                this.detailCase_ = SUMO_INFO_FIELD_NUMBER;
                                break;
                            case 11570:
                                SpiceInfoOuterClass.SpiceInfo.Builder subBuilder53 = this.detailCase_ == 1446 ? ((SpiceInfoOuterClass.SpiceInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SpiceInfoOuterClass.SpiceInfo.parser(), extensionRegistry);
                                if (subBuilder53 != null) {
                                    subBuilder53.mergeFrom((SpiceInfoOuterClass.SpiceInfo) this.detail_);
                                    this.detail_ = subBuilder53.buildPartial();
                                }
                                this.detailCase_ = SPICE_INFO_FIELD_NUMBER;
                                break;
                            case 11626:
                                TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.Builder subBuilder54 = this.detailCase_ == 1453 ? ((TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.parser(), extensionRegistry);
                                if (subBuilder54 != null) {
                                    subBuilder54.mergeFrom((TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_);
                                    this.detail_ = subBuilder54.buildPartial();
                                }
                                this.detailCase_ = TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                                break;
                            case 11818:
                                SummerTimeInfoOuterClass.SummerTimeInfo.Builder subBuilder55 = this.detailCase_ == 1477 ? ((SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SummerTimeInfoOuterClass.SummerTimeInfo.parser(), extensionRegistry);
                                if (subBuilder55 != null) {
                                    subBuilder55.mergeFrom((SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_);
                                    this.detail_ = subBuilder55.buildPartial();
                                }
                                this.detailCase_ = SUMMER_TIME_INFO_FIELD_NUMBER;
                                break;
                            case 11976:
                                this.scoreLimit_ = input.readUInt32();
                                break;
                            case 12346:
                                FungusFighterInfoOuterClass.FungusFighterInfo.Builder subBuilder56 = this.detailCase_ == 1543 ? ((FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FungusFighterInfoOuterClass.FungusFighterInfo.parser(), extensionRegistry);
                                if (subBuilder56 != null) {
                                    subBuilder56.mergeFrom((FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_);
                                    this.detail_ = subBuilder56.buildPartial();
                                }
                                this.detailCase_ = 1543;
                                break;
                            case 12418:
                                PotionInfoOuterClass.PotionInfo.Builder subBuilder57 = this.detailCase_ == 1552 ? ((PotionInfoOuterClass.PotionInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PotionInfoOuterClass.PotionInfo.parser(), extensionRegistry);
                                if (subBuilder57 != null) {
                                    subBuilder57.mergeFrom((PotionInfoOuterClass.PotionInfo) this.detail_);
                                    this.detail_ = subBuilder57.buildPartial();
                                }
                                this.detailCase_ = POTION_INFO_FIELD_NUMBER;
                                break;
                            case 13050:
                                IslandPartyInfoOuterClass.IslandPartyInfo.Builder subBuilder58 = this.detailCase_ == 1631 ? ((IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(IslandPartyInfoOuterClass.IslandPartyInfo.parser(), extensionRegistry);
                                if (subBuilder58 != null) {
                                    subBuilder58.mergeFrom((IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_);
                                    this.detail_ = subBuilder58.buildPartial();
                                }
                                this.detailCase_ = 1631;
                                break;
                            case 13096:
                                this.unk3300NEPKLLBJFKK_ = input.readBool();
                                break;
                            case 13210:
                                WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder subBuilder59 = this.detailCase_ == 1651 ? ((WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WaterSpiritInfoOuterClass.WaterSpiritInfo.parser(), extensionRegistry);
                                if (subBuilder59 != null) {
                                    subBuilder59.mergeFrom((WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_);
                                    this.detail_ = subBuilder59.buildPartial();
                                }
                                this.detailCase_ = WATER_SPIRIT_INFO_FIELD_NUMBER;
                                break;
                            case 13306:
                                HachiInfoOuterClass.HachiInfo.Builder subBuilder60 = this.detailCase_ == 1663 ? ((HachiInfoOuterClass.HachiInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(HachiInfoOuterClass.HachiInfo.parser(), extensionRegistry);
                                if (subBuilder60 != null) {
                                    subBuilder60.mergeFrom((HachiInfoOuterClass.HachiInfo) this.detail_);
                                    this.detail_ = subBuilder60.buildPartial();
                                }
                                this.detailCase_ = 1663;
                                break;
                            case 14378:
                                ChessInfoOuterClass.ChessInfo.Builder subBuilder61 = this.detailCase_ == 1797 ? ((ChessInfoOuterClass.ChessInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChessInfoOuterClass.ChessInfo.parser(), extensionRegistry);
                                if (subBuilder61 != null) {
                                    subBuilder61.mergeFrom((ChessInfoOuterClass.ChessInfo) this.detail_);
                                    this.detail_ = subBuilder61.buildPartial();
                                }
                                this.detailCase_ = 1797;
                                break;
                            case 14410:
                                GearInfoOuterClass.GearInfo.Builder subBuilder62 = this.detailCase_ == 1801 ? ((GearInfoOuterClass.GearInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GearInfoOuterClass.GearInfo.parser(), extensionRegistry);
                                if (subBuilder62 != null) {
                                    subBuilder62.mergeFrom((GearInfoOuterClass.GearInfo) this.detail_);
                                    this.detail_ = subBuilder62.buildPartial();
                                }
                                this.detailCase_ = GEAR_INFO_FIELD_NUMBER;
                                break;
                            case 14466:
                                AsterInfoOuterClass.AsterInfo.Builder subBuilder63 = this.detailCase_ == 1808 ? ((AsterInfoOuterClass.AsterInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(AsterInfoOuterClass.AsterInfo.parser(), extensionRegistry);
                                if (subBuilder63 != null) {
                                    subBuilder63.mergeFrom((AsterInfoOuterClass.AsterInfo) this.detail_);
                                    this.detail_ = subBuilder63.buildPartial();
                                }
                                this.detailCase_ = ASTER_INFO_FIELD_NUMBER;
                                break;
                            case 14538:
                                RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.Builder subBuilder64 = this.detailCase_ == 1817 ? ((RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.parser(), extensionRegistry);
                                if (subBuilder64 != null) {
                                    subBuilder64.mergeFrom((RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_);
                                    this.detail_ = subBuilder64.buildPartial();
                                }
                                this.detailCase_ = ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER;
                                break;
                            case 14914:
                                PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder subBuilder65 = this.detailCase_ == 1864 ? ((PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PlantFlowerInfoOuterClass.PlantFlowerInfo.parser(), extensionRegistry);
                                if (subBuilder65 != null) {
                                    subBuilder65.mergeFrom((PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_);
                                    this.detail_ = subBuilder65.buildPartial();
                                }
                                this.detailCase_ = PLANT_FLOWER_INFO_FIELD_NUMBER;
                                break;
                            case 15930:
                                EffigyInfoOuterClass.EffigyInfo.Builder subBuilder66 = this.detailCase_ == 1991 ? ((EffigyInfoOuterClass.EffigyInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyInfoOuterClass.EffigyInfo.parser(), extensionRegistry);
                                if (subBuilder66 != null) {
                                    subBuilder66.mergeFrom((EffigyInfoOuterClass.EffigyInfo) this.detail_);
                                    this.detail_ = subBuilder66.buildPartial();
                                }
                                this.detailCase_ = 1991;
                                break;
                            case 16168:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.fdjefldhela_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.fdjefldhela_.addInt(input.readUInt32());
                                break;
                            case 16170:
                                int limit4 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.fdjefldhela_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.fdjefldhela_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit4);
                                break;
                            case 16234:
                                WindFieldInfoOuterClass.WindFieldInfo.Builder subBuilder67 = this.detailCase_ == 2029 ? ((WindFieldInfoOuterClass.WindFieldInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WindFieldInfoOuterClass.WindFieldInfo.parser(), extensionRegistry);
                                if (subBuilder67 != null) {
                                    subBuilder67.mergeFrom((WindFieldInfoOuterClass.WindFieldInfo) this.detail_);
                                    this.detail_ = subBuilder67.buildPartial();
                                }
                                this.detailCase_ = WIND_FIELD_INFO_FIELD_NUMBER;
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 4) != 0) {
                    this.meetCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.expireCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.watcherInfoList_ = Collections.unmodifiableList(this.watcherInfoList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.activityPushTipsDataList_ = Collections.unmodifiableList(this.activityPushTipsDataList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.takenRewardList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.fdjefldhela_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ActivityInfoOuterClass.internal_static_ActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ActivityInfoOuterClass.internal_static_ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfo$DetailCase.class */
        public enum DetailCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            SAM_LAMP_INFO(4),
            CRUCIBLE_INFO(13),
            SALESMAN_INFO(1),
            TRIAL_AVATAR_INFO(8),
            DELIVERY_INFO(32),
            ASTER_INFO(ActivityInfo.ASTER_INFO_FIELD_NUMBER),
            FLIGHT_INFO(1062),
            DRAGON_SPINE_INFO(378),
            EFFIGY_INFO(1991),
            TREASURE_MAP_INFO(ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER),
            BLESSING_INFO(1198),
            SEA_LAMP_INFO(ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER),
            EXPEDITION_INFO(930),
            ARENA_CHALLENGE_INFO(699),
            FLEUR_FAIR_INFO(1116),
            WATER_SPIRIT_INFO(ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER),
            CHALLNELER_SLAB_INFO(ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER),
            MIST_TRIAL_ACTIVITY_INFO(1320),
            HIDE_AND_SEEK_INFO(ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER),
            FIND_HILICHURL_INFO(417),
            SUMMER_TIME_INFO(ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER),
            BUOYANT_COMBAT_INFO(ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER),
            ECHO_SHELL_INFO(ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER),
            BOUNCE_CONJURING_INFO(278),
            BLITZ_RUSH_INFO(192),
            CHESS_INFO(1797),
            SUMO_INFO(ActivityInfo.SUMO_INFO_FIELD_NUMBER),
            MOONFIN_TRIAL_INFO(1122),
            LUNA_RITE_INFO(82),
            PLANT_FLOWER_INFO(ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER),
            MUSIC_GAME_INFO(1220),
            ROGUELIKE_DUNGOEN_INFO(ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER),
            DIG_INFO(168),
            HACHI_INFO(1663),
            WINTER_CAMP_INFO(114),
            POTION_INFO(ActivityInfo.POTION_INFO_FIELD_NUMBER),
            TANUKI_TRAVEL_ACTIVITY_INFO(ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER),
            LANTERN_RITE_ACTIVITY_INFO(ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER),
            MICHIAE_MATSURI_INFO(428),
            BARTENDER_INFO(35),
            UGC_INFO(ActivityInfo.UGC_INFO_FIELD_NUMBER),
            CRYSTAL_LINK_INFO(ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER),
            IRODORI_INFO(1014),
            PHOTO_INFO(309),
            SPICE_INFO(ActivityInfo.SPICE_INFO_FIELD_NUMBER),
            GACHA_INFO(ActivityInfo.GACHA_INFO_FIELD_NUMBER),
            LUMINANCE_STONE_CHALLENGE_INFO(142),
            ROGUE_DIARY_INFO(397),
            SUMMER_TIME_V2INFO(951),
            ISLAND_PARTY_INFO(1631),
            GEAR_INFO(ActivityInfo.GEAR_INFO_FIELD_NUMBER),
            GRAVEN_INNOCENCE_INFO(ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER),
            INSTABLE_SPRAY_INFO(ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER),
            MUQADAS_POTION_INFO(ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER),
            TREASURE_SEELIE_INFO(ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER),
            ROCK_BOARD_EXPLORE_INFO(ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER),
            VINTAGE_INFO(1316),
            WIND_FIELD_INFO(ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER),
            FUNGUS_FIGHTER_INFO(1543),
            CHAR_AMUSEMENT_INFO(504),
            EFFIGY_CHALLENGE_INFO(ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER),
            COIN_COLLECT_INFO(559),
            BRICK_BREAKER_INFO(ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER),
            DUEL_HEART_INFO(221),
            SEA_LAMP_V3INFO(1080),
            TEAM_CHAIN_INFO(144),
            GCG_FESTIVAL_INFO(71),
            DETAIL_NOT_SET(0);
            
            private final int value;

            DetailCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DetailCase valueOf(int value) {
                return forNumber(value);
            }

            public static DetailCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DETAIL_NOT_SET;
                    case 1:
                        return SALESMAN_INFO;
                    case 4:
                        return SAM_LAMP_INFO;
                    case 8:
                        return TRIAL_AVATAR_INFO;
                    case 13:
                        return CRUCIBLE_INFO;
                    case 32:
                        return DELIVERY_INFO;
                    case 35:
                        return BARTENDER_INFO;
                    case 71:
                        return GCG_FESTIVAL_INFO;
                    case 82:
                        return LUNA_RITE_INFO;
                    case 114:
                        return WINTER_CAMP_INFO;
                    case 142:
                        return LUMINANCE_STONE_CHALLENGE_INFO;
                    case 144:
                        return TEAM_CHAIN_INFO;
                    case 168:
                        return DIG_INFO;
                    case 192:
                        return BLITZ_RUSH_INFO;
                    case 221:
                        return DUEL_HEART_INFO;
                    case 278:
                        return BOUNCE_CONJURING_INFO;
                    case 309:
                        return PHOTO_INFO;
                    case 378:
                        return DRAGON_SPINE_INFO;
                    case 397:
                        return ROGUE_DIARY_INFO;
                    case 417:
                        return FIND_HILICHURL_INFO;
                    case 428:
                        return MICHIAE_MATSURI_INFO;
                    case 504:
                        return CHAR_AMUSEMENT_INFO;
                    case ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER /* 546 */:
                        return TREASURE_MAP_INFO;
                    case 559:
                        return COIN_COLLECT_INFO;
                    case ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER /* 578 */:
                        return SEA_LAMP_INFO;
                    case ActivityInfo.UGC_INFO_FIELD_NUMBER /* 589 */:
                        return UGC_INFO;
                    case 699:
                        return ARENA_CHALLENGE_INFO;
                    case 930:
                        return EXPEDITION_INFO;
                    case ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 944 */:
                        return INSTABLE_SPRAY_INFO;
                    case 951:
                        return SUMMER_TIME_V2INFO;
                    case 1014:
                        return IRODORI_INFO;
                    case 1062:
                        return FLIGHT_INFO;
                    case ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER /* 1077 */:
                        return HIDE_AND_SEEK_INFO;
                    case 1080:
                        return SEA_LAMP_V3INFO;
                    case 1116:
                        return FLEUR_FAIR_INFO;
                    case 1122:
                        return MOONFIN_TRIAL_INFO;
                    case ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER /* 1135 */:
                        return CHALLNELER_SLAB_INFO;
                    case ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1142 */:
                        return TREASURE_SEELIE_INFO;
                    case ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER /* 1144 */:
                        return EFFIGY_CHALLENGE_INFO;
                    case ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER /* 1172 */:
                        return ECHO_SHELL_INFO;
                    case ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1173 */:
                        return GRAVEN_INNOCENCE_INFO;
                    case ActivityInfo.GACHA_INFO_FIELD_NUMBER /* 1177 */:
                        return GACHA_INFO;
                    case 1198:
                        return BLESSING_INFO;
                    case 1220:
                        return MUSIC_GAME_INFO;
                    case ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1273 */:
                        return ROCK_BOARD_EXPLORE_INFO;
                    case ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER /* 1275 */:
                        return BRICK_BREAKER_INFO;
                    case ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER /* 1277 */:
                        return BUOYANT_COMBAT_INFO;
                    case 1316:
                        return VINTAGE_INFO;
                    case 1320:
                        return MIST_TRIAL_ACTIVITY_INFO;
                    case ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER /* 1350 */:
                        return MUQADAS_POTION_INFO;
                    case ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER /* 1372 */:
                        return LANTERN_RITE_ACTIVITY_INFO;
                    case ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER /* 1375 */:
                        return CRYSTAL_LINK_INFO;
                    case ActivityInfo.SUMO_INFO_FIELD_NUMBER /* 1379 */:
                        return SUMO_INFO;
                    case ActivityInfo.SPICE_INFO_FIELD_NUMBER /* 1446 */:
                        return SPICE_INFO;
                    case ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1453 */:
                        return TANUKI_TRAVEL_ACTIVITY_INFO;
                    case ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER /* 1477 */:
                        return SUMMER_TIME_INFO;
                    case 1543:
                        return FUNGUS_FIGHTER_INFO;
                    case ActivityInfo.POTION_INFO_FIELD_NUMBER /* 1552 */:
                        return POTION_INFO;
                    case 1631:
                        return ISLAND_PARTY_INFO;
                    case ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER /* 1651 */:
                        return WATER_SPIRIT_INFO;
                    case 1663:
                        return HACHI_INFO;
                    case 1797:
                        return CHESS_INFO;
                    case ActivityInfo.GEAR_INFO_FIELD_NUMBER /* 1801 */:
                        return GEAR_INFO;
                    case ActivityInfo.ASTER_INFO_FIELD_NUMBER /* 1808 */:
                        return ASTER_INFO;
                    case ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER /* 1817 */:
                        return ROGUELIKE_DUNGOEN_INFO;
                    case ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER /* 1864 */:
                        return PLANT_FLOWER_INFO;
                    case 1991:
                        return EFFIGY_INFO;
                    case ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER /* 2029 */:
                        return WIND_FIELD_INFO;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DetailCase getDetailCase() {
            return DetailCase.forNumber(this.detailCase_);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfo$ActivityCoinMapDefaultEntryHolder.class */
        public static final class ActivityCoinMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ActivityInfoOuterClass.internal_static_ActivityInfo_ActivityCoinMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private ActivityCoinMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetActivityCoinMap() {
            if (this.activityCoinMap_ == null) {
                return MapField.emptyMapField(ActivityCoinMapDefaultEntryHolder.defaultEntry);
            }
            return this.activityCoinMap_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityCoinMapCount() {
            return internalGetActivityCoinMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean containsActivityCoinMap(int key) {
            return internalGetActivityCoinMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getActivityCoinMap() {
            return getActivityCoinMapMap();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public Map<Integer, Integer> getActivityCoinMapMap() {
            return internalGetActivityCoinMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityCoinMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetActivityCoinMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityCoinMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetActivityCoinMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getScoreLimit() {
            return this.scoreLimit_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<Integer> getTakenRewardListList() {
            return this.takenRewardList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getTakenRewardListCount() {
            return this.takenRewardList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getTakenRewardList(int index) {
            return this.takenRewardList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300MDBDPIBEGGH() {
            return this.unk3300MDBDPIBEGGH_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300MJNPGEKLOCG() {
            return this.unk3300MJNPGEKLOCG_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityType() {
            return this.activityType_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getSelectedAvatarRewardId() {
            return this.selectedAvatarRewardId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<Integer> getMeetCondListList() {
            return this.meetCondList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getMeetCondListCount() {
            return this.meetCondList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getMeetCondList(int index) {
            return this.meetCondList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityId() {
            return this.activityId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300ABJKLALKLDG() {
            return this.unk3300ABJKLALKLDG_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> getActivityPushTipsDataListList() {
            return this.activityPushTipsDataList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<? extends ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> getActivityPushTipsDataListOrBuilderList() {
            return this.activityPushTipsDataList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityPushTipsDataListCount() {
            return this.activityPushTipsDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ActivityPushTipsDataOuterClass.ActivityPushTipsData getActivityPushTipsDataList(int index) {
            return this.activityPushTipsDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder getActivityPushTipsDataListOrBuilder(int index) {
            return this.activityPushTipsDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> getWatcherInfoListList() {
            return this.watcherInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<? extends ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoListOrBuilderList() {
            return this.watcherInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getWatcherInfoListCount() {
            return this.watcherInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfoList(int index) {
            return this.watcherInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoListOrBuilder(int index) {
            return this.watcherInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300CBCEHLJJOGI() {
            return this.unk3300CBCEHLJJOGI_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<Integer> getExpireCondListList() {
            return this.expireCondList_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getExpireCondListCount() {
            return this.expireCondList_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getExpireCondList(int index) {
            return this.expireCondList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public List<Integer> getFdjefldhelaList() {
            return this.fdjefldhela_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getFdjefldhelaCount() {
            return this.fdjefldhela_.size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getFdjefldhela(int index) {
            return this.fdjefldhela_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300ICNJJKDHPCH() {
            return this.unk3300ICNJJKDHPCH_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getFirstDayStartTime() {
            return this.firstDayStartTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getCurScore() {
            return this.curScore_;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfo$WishGiftNumMapDefaultEntryHolder.class */
        public static final class WishGiftNumMapDefaultEntryHolder {
            static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(ActivityInfoOuterClass.internal_static_ActivityInfo_WishGiftNumMapEntry_descriptor, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

            private WishGiftNumMapDefaultEntryHolder() {
            }
        }

        private MapField<Integer, Integer> internalGetWishGiftNumMap() {
            if (this.wishGiftNumMap_ == null) {
                return MapField.emptyMapField(WishGiftNumMapDefaultEntryHolder.defaultEntry);
            }
            return this.wishGiftNumMap_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getWishGiftNumMapCount() {
            return internalGetWishGiftNumMap().getMap().size();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean containsWishGiftNumMap(int key) {
            return internalGetWishGiftNumMap().getMap().containsKey(Integer.valueOf(key));
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        @Deprecated
        public Map<Integer, Integer> getWishGiftNumMap() {
            return getWishGiftNumMapMap();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public Map<Integer, Integer> getWishGiftNumMapMap() {
            return internalGetWishGiftNumMap().getMap();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getWishGiftNumMapOrDefault(int key, int defaultValue) {
            Map<Integer, Integer> map = internalGetWishGiftNumMap().getMap();
            return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getWishGiftNumMapOrThrow(int key) {
            Map<Integer, Integer> map = internalGetWishGiftNumMap().getMap();
            if (map.containsKey(Integer.valueOf(key))) {
                return map.get(Integer.valueOf(key)).intValue();
            }
            throw new IllegalArgumentException();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300NEPKLLBJFKK() {
            return this.unk3300NEPKLLBJFKK_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSamLampInfo() {
            return this.detailCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SamLampInfoOuterClass.SamLampInfo getSamLampInfo() {
            if (this.detailCase_ == 4) {
                return (SamLampInfoOuterClass.SamLampInfo) this.detail_;
            }
            return SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SamLampInfoOuterClass.SamLampInfoOrBuilder getSamLampInfoOrBuilder() {
            if (this.detailCase_ == 4) {
                return (SamLampInfoOuterClass.SamLampInfo) this.detail_;
            }
            return SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCrucibleInfo() {
            return this.detailCase_ == 13;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrucibleInfoOuterClass.CrucibleInfo getCrucibleInfo() {
            if (this.detailCase_ == 13) {
                return (CrucibleInfoOuterClass.CrucibleInfo) this.detail_;
            }
            return CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrucibleInfoOuterClass.CrucibleInfoOrBuilder getCrucibleInfoOrBuilder() {
            if (this.detailCase_ == 13) {
                return (CrucibleInfoOuterClass.CrucibleInfo) this.detail_;
            }
            return CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSalesmanInfo() {
            return this.detailCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SalesmanInfoOuterClass.SalesmanInfo getSalesmanInfo() {
            if (this.detailCase_ == 1) {
                return (SalesmanInfoOuterClass.SalesmanInfo) this.detail_;
            }
            return SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SalesmanInfoOuterClass.SalesmanInfoOrBuilder getSalesmanInfoOrBuilder() {
            if (this.detailCase_ == 1) {
                return (SalesmanInfoOuterClass.SalesmanInfo) this.detail_;
            }
            return SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTrialAvatarInfo() {
            return this.detailCase_ == 8;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo() {
            if (this.detailCase_ == 8) {
                return (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_;
            }
            return TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder() {
            if (this.detailCase_ == 8) {
                return (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_;
            }
            return TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDeliveryInfo() {
            return this.detailCase_ == 32;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DeliveryInfoOuterClass.DeliveryInfo getDeliveryInfo() {
            if (this.detailCase_ == 32) {
                return (DeliveryInfoOuterClass.DeliveryInfo) this.detail_;
            }
            return DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DeliveryInfoOuterClass.DeliveryInfoOrBuilder getDeliveryInfoOrBuilder() {
            if (this.detailCase_ == 32) {
                return (DeliveryInfoOuterClass.DeliveryInfo) this.detail_;
            }
            return DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasAsterInfo() {
            return this.detailCase_ == 1808;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public AsterInfoOuterClass.AsterInfo getAsterInfo() {
            if (this.detailCase_ == 1808) {
                return (AsterInfoOuterClass.AsterInfo) this.detail_;
            }
            return AsterInfoOuterClass.AsterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public AsterInfoOuterClass.AsterInfoOrBuilder getAsterInfoOrBuilder() {
            if (this.detailCase_ == 1808) {
                return (AsterInfoOuterClass.AsterInfo) this.detail_;
            }
            return AsterInfoOuterClass.AsterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFlightInfo() {
            return this.detailCase_ == 1062;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FlightInfoOuterClass.FlightInfo getFlightInfo() {
            if (this.detailCase_ == 1062) {
                return (FlightInfoOuterClass.FlightInfo) this.detail_;
            }
            return FlightInfoOuterClass.FlightInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FlightInfoOuterClass.FlightInfoOrBuilder getFlightInfoOrBuilder() {
            if (this.detailCase_ == 1062) {
                return (FlightInfoOuterClass.FlightInfo) this.detail_;
            }
            return FlightInfoOuterClass.FlightInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDragonSpineInfo() {
            return this.detailCase_ == 378;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DragonSpineInfoOuterClass.DragonSpineInfo getDragonSpineInfo() {
            if (this.detailCase_ == 378) {
                return (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_;
            }
            return DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder getDragonSpineInfoOrBuilder() {
            if (this.detailCase_ == 378) {
                return (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_;
            }
            return DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEffigyInfo() {
            return this.detailCase_ == 1991;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyInfoOuterClass.EffigyInfo getEffigyInfo() {
            if (this.detailCase_ == 1991) {
                return (EffigyInfoOuterClass.EffigyInfo) this.detail_;
            }
            return EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyInfoOuterClass.EffigyInfoOrBuilder getEffigyInfoOrBuilder() {
            if (this.detailCase_ == 1991) {
                return (EffigyInfoOuterClass.EffigyInfo) this.detail_;
            }
            return EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTreasureMapInfo() {
            return this.detailCase_ == 546;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureMapInfoOuterClass.TreasureMapInfo getTreasureMapInfo() {
            if (this.detailCase_ == 546) {
                return (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_;
            }
            return TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder getTreasureMapInfoOrBuilder() {
            if (this.detailCase_ == 546) {
                return (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_;
            }
            return TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBlessingInfo() {
            return this.detailCase_ == 1198;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlessingInfoOuterClass.BlessingInfo getBlessingInfo() {
            if (this.detailCase_ == 1198) {
                return (BlessingInfoOuterClass.BlessingInfo) this.detail_;
            }
            return BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlessingInfoOuterClass.BlessingInfoOrBuilder getBlessingInfoOrBuilder() {
            if (this.detailCase_ == 1198) {
                return (BlessingInfoOuterClass.BlessingInfo) this.detail_;
            }
            return BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSeaLampInfo() {
            return this.detailCase_ == 578;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampInfoOuterClass.SeaLampInfo getSeaLampInfo() {
            if (this.detailCase_ == 578) {
                return (SeaLampInfoOuterClass.SeaLampInfo) this.detail_;
            }
            return SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampInfoOuterClass.SeaLampInfoOrBuilder getSeaLampInfoOrBuilder() {
            if (this.detailCase_ == 578) {
                return (SeaLampInfoOuterClass.SeaLampInfo) this.detail_;
            }
            return SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasExpeditionInfo() {
            return this.detailCase_ == 930;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ExpeditionInfoOuterClass.ExpeditionInfo getExpeditionInfo() {
            if (this.detailCase_ == 930) {
                return (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_;
            }
            return ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder getExpeditionInfoOrBuilder() {
            if (this.detailCase_ == 930) {
                return (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_;
            }
            return ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasArenaChallengeInfo() {
            return this.detailCase_ == 699;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ArenaChallengeInfoOuterClass.ArenaChallengeInfo getArenaChallengeInfo() {
            if (this.detailCase_ == 699) {
                return (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_;
            }
            return ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder getArenaChallengeInfoOrBuilder() {
            if (this.detailCase_ == 699) {
                return (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_;
            }
            return ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFleurFairInfo() {
            return this.detailCase_ == 1116;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FleurFairInfoOuterClass.FleurFairInfo getFleurFairInfo() {
            if (this.detailCase_ == 1116) {
                return (FleurFairInfoOuterClass.FleurFairInfo) this.detail_;
            }
            return FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FleurFairInfoOuterClass.FleurFairInfoOrBuilder getFleurFairInfoOrBuilder() {
            if (this.detailCase_ == 1116) {
                return (FleurFairInfoOuterClass.FleurFairInfo) this.detail_;
            }
            return FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWaterSpiritInfo() {
            return this.detailCase_ == 1651;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WaterSpiritInfoOuterClass.WaterSpiritInfo getWaterSpiritInfo() {
            if (this.detailCase_ == 1651) {
                return (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_;
            }
            return WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder getWaterSpiritInfoOrBuilder() {
            if (this.detailCase_ == 1651) {
                return (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_;
            }
            return WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasChallnelerSlabInfo() {
            return this.detailCase_ == 1135;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo getChallnelerSlabInfo() {
            if (this.detailCase_ == 1135) {
                return (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_;
            }
            return ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder getChallnelerSlabInfoOrBuilder() {
            if (this.detailCase_ == 1135) {
                return (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_;
            }
            return ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMistTrialActivityInfo() {
            return this.detailCase_ == 1320;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MistTrialActivityInfoOuterClass.MistTrialActivityInfo getMistTrialActivityInfo() {
            if (this.detailCase_ == 1320) {
                return (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_;
            }
            return MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MistTrialActivityInfoOuterClass.MistTrialActivityInfoOrBuilder getMistTrialActivityInfoOrBuilder() {
            if (this.detailCase_ == 1320) {
                return (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_;
            }
            return MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasHideAndSeekInfo() {
            return this.detailCase_ == 1077;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HideAndSeekInfoOuterClass.HideAndSeekInfo getHideAndSeekInfo() {
            if (this.detailCase_ == 1077) {
                return (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_;
            }
            return HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder getHideAndSeekInfoOrBuilder() {
            if (this.detailCase_ == 1077) {
                return (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_;
            }
            return HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFindHilichurlInfo() {
            return this.detailCase_ == 417;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FindHilichurlInfoOuterClass.FindHilichurlInfo getFindHilichurlInfo() {
            if (this.detailCase_ == 417) {
                return (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_;
            }
            return FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FindHilichurlInfoOuterClass.FindHilichurlInfoOrBuilder getFindHilichurlInfoOrBuilder() {
            if (this.detailCase_ == 417) {
                return (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_;
            }
            return FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSummerTimeInfo() {
            return this.detailCase_ == 1477;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeInfoOuterClass.SummerTimeInfo getSummerTimeInfo() {
            if (this.detailCase_ == 1477) {
                return (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_;
            }
            return SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder getSummerTimeInfoOrBuilder() {
            if (this.detailCase_ == 1477) {
                return (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_;
            }
            return SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBuoyantCombatInfo() {
            return this.detailCase_ == 1277;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BuoyantCombatInfoOuterClass.BuoyantCombatInfo getBuoyantCombatInfo() {
            if (this.detailCase_ == 1277) {
                return (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_;
            }
            return BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder getBuoyantCombatInfoOrBuilder() {
            if (this.detailCase_ == 1277) {
                return (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_;
            }
            return BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEchoShellInfo() {
            return this.detailCase_ == 1172;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EchoShellInfoOuterClass.EchoShellInfo getEchoShellInfo() {
            if (this.detailCase_ == 1172) {
                return (EchoShellInfoOuterClass.EchoShellInfo) this.detail_;
            }
            return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EchoShellInfoOuterClass.EchoShellInfoOrBuilder getEchoShellInfoOrBuilder() {
            if (this.detailCase_ == 1172) {
                return (EchoShellInfoOuterClass.EchoShellInfo) this.detail_;
            }
            return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBounceConjuringInfo() {
            return this.detailCase_ == 278;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BounceConjuringInfoOuterClass.BounceConjuringInfo getBounceConjuringInfo() {
            if (this.detailCase_ == 278) {
                return (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_;
            }
            return BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder getBounceConjuringInfoOrBuilder() {
            if (this.detailCase_ == 278) {
                return (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_;
            }
            return BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBlitzRushInfo() {
            return this.detailCase_ == 192;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlitzRushInfoOuterClass.BlitzRushInfo getBlitzRushInfo() {
            if (this.detailCase_ == 192) {
                return (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_;
            }
            return BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlitzRushInfoOuterClass.BlitzRushInfoOrBuilder getBlitzRushInfoOrBuilder() {
            if (this.detailCase_ == 192) {
                return (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_;
            }
            return BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasChessInfo() {
            return this.detailCase_ == 1797;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChessInfoOuterClass.ChessInfo getChessInfo() {
            if (this.detailCase_ == 1797) {
                return (ChessInfoOuterClass.ChessInfo) this.detail_;
            }
            return ChessInfoOuterClass.ChessInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChessInfoOuterClass.ChessInfoOrBuilder getChessInfoOrBuilder() {
            if (this.detailCase_ == 1797) {
                return (ChessInfoOuterClass.ChessInfo) this.detail_;
            }
            return ChessInfoOuterClass.ChessInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSumoInfo() {
            return this.detailCase_ == 1379;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SumoInfoOuterClass.SumoInfo getSumoInfo() {
            if (this.detailCase_ == 1379) {
                return (SumoInfoOuterClass.SumoInfo) this.detail_;
            }
            return SumoInfoOuterClass.SumoInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SumoInfoOuterClass.SumoInfoOrBuilder getSumoInfoOrBuilder() {
            if (this.detailCase_ == 1379) {
                return (SumoInfoOuterClass.SumoInfo) this.detail_;
            }
            return SumoInfoOuterClass.SumoInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMoonfinTrialInfo() {
            return this.detailCase_ == 1122;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MoonfinTrialInfoOuterClass.MoonfinTrialInfo getMoonfinTrialInfo() {
            if (this.detailCase_ == 1122) {
                return (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_;
            }
            return MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder getMoonfinTrialInfoOrBuilder() {
            if (this.detailCase_ == 1122) {
                return (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_;
            }
            return MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLunaRiteInfo() {
            return this.detailCase_ == 82;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LunaRiteInfoOuterClass.LunaRiteInfo getLunaRiteInfo() {
            if (this.detailCase_ == 82) {
                return (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_;
            }
            return LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LunaRiteInfoOuterClass.LunaRiteInfoOrBuilder getLunaRiteInfoOrBuilder() {
            if (this.detailCase_ == 82) {
                return (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_;
            }
            return LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPlantFlowerInfo() {
            return this.detailCase_ == 1864;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PlantFlowerInfoOuterClass.PlantFlowerInfo getPlantFlowerInfo() {
            if (this.detailCase_ == 1864) {
                return (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_;
            }
            return PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder getPlantFlowerInfoOrBuilder() {
            if (this.detailCase_ == 1864) {
                return (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_;
            }
            return PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMusicGameInfo() {
            return this.detailCase_ == 1220;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo() {
            if (this.detailCase_ == 1220) {
                return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
            }
            return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder getMusicGameInfoOrBuilder() {
            if (this.detailCase_ == 1220) {
                return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
            }
            return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRoguelikeDungoenInfo() {
            return this.detailCase_ == 1817;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo getRoguelikeDungoenInfo() {
            if (this.detailCase_ == 1817) {
                return (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_;
            }
            return RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder getRoguelikeDungoenInfoOrBuilder() {
            if (this.detailCase_ == 1817) {
                return (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_;
            }
            return RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDigInfo() {
            return this.detailCase_ == 168;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DigInfoOuterClass.DigInfo getDigInfo() {
            if (this.detailCase_ == 168) {
                return (DigInfoOuterClass.DigInfo) this.detail_;
            }
            return DigInfoOuterClass.DigInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DigInfoOuterClass.DigInfoOrBuilder getDigInfoOrBuilder() {
            if (this.detailCase_ == 168) {
                return (DigInfoOuterClass.DigInfo) this.detail_;
            }
            return DigInfoOuterClass.DigInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasHachiInfo() {
            return this.detailCase_ == 1663;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HachiInfoOuterClass.HachiInfo getHachiInfo() {
            if (this.detailCase_ == 1663) {
                return (HachiInfoOuterClass.HachiInfo) this.detail_;
            }
            return HachiInfoOuterClass.HachiInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HachiInfoOuterClass.HachiInfoOrBuilder getHachiInfoOrBuilder() {
            if (this.detailCase_ == 1663) {
                return (HachiInfoOuterClass.HachiInfo) this.detail_;
            }
            return HachiInfoOuterClass.HachiInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWinterCampInfo() {
            return this.detailCase_ == 114;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WinterCampInfoOuterClass.WinterCampInfo getWinterCampInfo() {
            if (this.detailCase_ == 114) {
                return (WinterCampInfoOuterClass.WinterCampInfo) this.detail_;
            }
            return WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WinterCampInfoOuterClass.WinterCampInfoOrBuilder getWinterCampInfoOrBuilder() {
            if (this.detailCase_ == 114) {
                return (WinterCampInfoOuterClass.WinterCampInfo) this.detail_;
            }
            return WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPotionInfo() {
            return this.detailCase_ == 1552;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PotionInfoOuterClass.PotionInfo getPotionInfo() {
            if (this.detailCase_ == 1552) {
                return (PotionInfoOuterClass.PotionInfo) this.detail_;
            }
            return PotionInfoOuterClass.PotionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PotionInfoOuterClass.PotionInfoOrBuilder getPotionInfoOrBuilder() {
            if (this.detailCase_ == 1552) {
                return (PotionInfoOuterClass.PotionInfo) this.detail_;
            }
            return PotionInfoOuterClass.PotionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTanukiTravelActivityInfo() {
            return this.detailCase_ == 1453;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo getTanukiTravelActivityInfo() {
            if (this.detailCase_ == 1453) {
                return (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_;
            }
            return TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder getTanukiTravelActivityInfoOrBuilder() {
            if (this.detailCase_ == 1453) {
                return (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_;
            }
            return TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLanternRiteActivityInfo() {
            return this.detailCase_ == 1372;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo getLanternRiteActivityInfo() {
            if (this.detailCase_ == 1372) {
                return (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_;
            }
            return LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder getLanternRiteActivityInfoOrBuilder() {
            if (this.detailCase_ == 1372) {
                return (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_;
            }
            return LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMichiaeMatsuriInfo() {
            return this.detailCase_ == 428;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo getMichiaeMatsuriInfo() {
            if (this.detailCase_ == 428) {
                return (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_;
            }
            return MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder getMichiaeMatsuriInfoOrBuilder() {
            if (this.detailCase_ == 428) {
                return (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_;
            }
            return MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBartenderInfo() {
            return this.detailCase_ == 35;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BartenderInfoOuterClass.BartenderInfo getBartenderInfo() {
            if (this.detailCase_ == 35) {
                return (BartenderInfoOuterClass.BartenderInfo) this.detail_;
            }
            return BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BartenderInfoOuterClass.BartenderInfoOrBuilder getBartenderInfoOrBuilder() {
            if (this.detailCase_ == 35) {
                return (BartenderInfoOuterClass.BartenderInfo) this.detail_;
            }
            return BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasUgcInfo() {
            return this.detailCase_ == 589;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public UgcInfoOuterClass.UgcInfo getUgcInfo() {
            if (this.detailCase_ == 589) {
                return (UgcInfoOuterClass.UgcInfo) this.detail_;
            }
            return UgcInfoOuterClass.UgcInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public UgcInfoOuterClass.UgcInfoOrBuilder getUgcInfoOrBuilder() {
            if (this.detailCase_ == 589) {
                return (UgcInfoOuterClass.UgcInfo) this.detail_;
            }
            return UgcInfoOuterClass.UgcInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCrystalLinkInfo() {
            return this.detailCase_ == 1375;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrystalLinkInfoOuterClass.CrystalLinkInfo getCrystalLinkInfo() {
            if (this.detailCase_ == 1375) {
                return (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_;
            }
            return CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrystalLinkInfoOuterClass.CrystalLinkInfoOrBuilder getCrystalLinkInfoOrBuilder() {
            if (this.detailCase_ == 1375) {
                return (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_;
            }
            return CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasIrodoriInfo() {
            return this.detailCase_ == 1014;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IrodoriInfoOuterClass.IrodoriInfo getIrodoriInfo() {
            if (this.detailCase_ == 1014) {
                return (IrodoriInfoOuterClass.IrodoriInfo) this.detail_;
            }
            return IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IrodoriInfoOuterClass.IrodoriInfoOrBuilder getIrodoriInfoOrBuilder() {
            if (this.detailCase_ == 1014) {
                return (IrodoriInfoOuterClass.IrodoriInfo) this.detail_;
            }
            return IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPhotoInfo() {
            return this.detailCase_ == 309;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PhotoInfoOuterClass.PhotoInfo getPhotoInfo() {
            if (this.detailCase_ == 309) {
                return (PhotoInfoOuterClass.PhotoInfo) this.detail_;
            }
            return PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PhotoInfoOuterClass.PhotoInfoOrBuilder getPhotoInfoOrBuilder() {
            if (this.detailCase_ == 309) {
                return (PhotoInfoOuterClass.PhotoInfo) this.detail_;
            }
            return PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSpiceInfo() {
            return this.detailCase_ == 1446;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SpiceInfoOuterClass.SpiceInfo getSpiceInfo() {
            if (this.detailCase_ == 1446) {
                return (SpiceInfoOuterClass.SpiceInfo) this.detail_;
            }
            return SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SpiceInfoOuterClass.SpiceInfoOrBuilder getSpiceInfoOrBuilder() {
            if (this.detailCase_ == 1446) {
                return (SpiceInfoOuterClass.SpiceInfo) this.detail_;
            }
            return SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGachaInfo() {
            return this.detailCase_ == 1177;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GachaInfoOuterClass.GachaInfo getGachaInfo() {
            if (this.detailCase_ == 1177) {
                return (GachaInfoOuterClass.GachaInfo) this.detail_;
            }
            return GachaInfoOuterClass.GachaInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoOrBuilder() {
            if (this.detailCase_ == 1177) {
                return (GachaInfoOuterClass.GachaInfo) this.detail_;
            }
            return GachaInfoOuterClass.GachaInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLuminanceStoneChallengeInfo() {
            return this.detailCase_ == 142;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo getLuminanceStoneChallengeInfo() {
            if (this.detailCase_ == 142) {
                return (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_;
            }
            return LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder() {
            if (this.detailCase_ == 142) {
                return (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_;
            }
            return LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRogueDiaryInfo() {
            return this.detailCase_ == 397;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RogueDiaryInfoOuterClass.RogueDiaryInfo getRogueDiaryInfo() {
            if (this.detailCase_ == 397) {
                return (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_;
            }
            return RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder getRogueDiaryInfoOrBuilder() {
            if (this.detailCase_ == 397) {
                return (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_;
            }
            return RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSummerTimeV2Info() {
            return this.detailCase_ == 951;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeV2InfoOuterClass.SummerTimeV2Info getSummerTimeV2Info() {
            if (this.detailCase_ == 951) {
                return (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_;
            }
            return SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder getSummerTimeV2InfoOrBuilder() {
            if (this.detailCase_ == 951) {
                return (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_;
            }
            return SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasIslandPartyInfo() {
            return this.detailCase_ == 1631;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IslandPartyInfoOuterClass.IslandPartyInfo getIslandPartyInfo() {
            if (this.detailCase_ == 1631) {
                return (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_;
            }
            return IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder getIslandPartyInfoOrBuilder() {
            if (this.detailCase_ == 1631) {
                return (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_;
            }
            return IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGearInfo() {
            return this.detailCase_ == 1801;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GearInfoOuterClass.GearInfo getGearInfo() {
            if (this.detailCase_ == 1801) {
                return (GearInfoOuterClass.GearInfo) this.detail_;
            }
            return GearInfoOuterClass.GearInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GearInfoOuterClass.GearInfoOrBuilder getGearInfoOrBuilder() {
            if (this.detailCase_ == 1801) {
                return (GearInfoOuterClass.GearInfo) this.detail_;
            }
            return GearInfoOuterClass.GearInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGravenInnocenceInfo() {
            return this.detailCase_ == 1173;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GravenInnocenceInfoOuterClass.GravenInnocenceInfo getGravenInnocenceInfo() {
            if (this.detailCase_ == 1173) {
                return (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_;
            }
            return GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder getGravenInnocenceInfoOrBuilder() {
            if (this.detailCase_ == 1173) {
                return (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_;
            }
            return GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasInstableSprayInfo() {
            return this.detailCase_ == 944;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public InstableSprayInfoOuterClass.InstableSprayInfo getInstableSprayInfo() {
            if (this.detailCase_ == 944) {
                return (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_;
            }
            return InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder getInstableSprayInfoOrBuilder() {
            if (this.detailCase_ == 944) {
                return (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_;
            }
            return InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMuqadasPotionInfo() {
            return this.detailCase_ == 1350;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MuqadasPotionInfoOuterClass.MuqadasPotionInfo getMuqadasPotionInfo() {
            if (this.detailCase_ == 1350) {
                return (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_;
            }
            return MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder getMuqadasPotionInfoOrBuilder() {
            if (this.detailCase_ == 1350) {
                return (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_;
            }
            return MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTreasureSeelieInfo() {
            return this.detailCase_ == 1142;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureSeelieInfoOuterClass.TreasureSeelieInfo getTreasureSeelieInfo() {
            if (this.detailCase_ == 1142) {
                return (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_;
            }
            return TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder getTreasureSeelieInfoOrBuilder() {
            if (this.detailCase_ == 1142) {
                return (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_;
            }
            return TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRockBoardExploreInfo() {
            return this.detailCase_ == 1273;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RockBoardExploreInfoOuterClass.RockBoardExploreInfo getRockBoardExploreInfo() {
            if (this.detailCase_ == 1273) {
                return (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_;
            }
            return RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RockBoardExploreInfoOuterClass.RockBoardExploreInfoOrBuilder getRockBoardExploreInfoOrBuilder() {
            if (this.detailCase_ == 1273) {
                return (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_;
            }
            return RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasVintageInfo() {
            return this.detailCase_ == 1316;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public VintageInfoOuterClass.VintageInfo getVintageInfo() {
            if (this.detailCase_ == 1316) {
                return (VintageInfoOuterClass.VintageInfo) this.detail_;
            }
            return VintageInfoOuterClass.VintageInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public VintageInfoOuterClass.VintageInfoOrBuilder getVintageInfoOrBuilder() {
            if (this.detailCase_ == 1316) {
                return (VintageInfoOuterClass.VintageInfo) this.detail_;
            }
            return VintageInfoOuterClass.VintageInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWindFieldInfo() {
            return this.detailCase_ == 2029;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WindFieldInfoOuterClass.WindFieldInfo getWindFieldInfo() {
            if (this.detailCase_ == 2029) {
                return (WindFieldInfoOuterClass.WindFieldInfo) this.detail_;
            }
            return WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WindFieldInfoOuterClass.WindFieldInfoOrBuilder getWindFieldInfoOrBuilder() {
            if (this.detailCase_ == 2029) {
                return (WindFieldInfoOuterClass.WindFieldInfo) this.detail_;
            }
            return WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFungusFighterInfo() {
            return this.detailCase_ == 1543;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FungusFighterInfoOuterClass.FungusFighterInfo getFungusFighterInfo() {
            if (this.detailCase_ == 1543) {
                return (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_;
            }
            return FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FungusFighterInfoOuterClass.FungusFighterInfoOrBuilder getFungusFighterInfoOrBuilder() {
            if (this.detailCase_ == 1543) {
                return (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_;
            }
            return FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCharAmusementInfo() {
            return this.detailCase_ == 504;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CharAmusementInfoOuterClass.CharAmusementInfo getCharAmusementInfo() {
            if (this.detailCase_ == 504) {
                return (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_;
            }
            return CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder getCharAmusementInfoOrBuilder() {
            if (this.detailCase_ == 504) {
                return (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_;
            }
            return CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEffigyChallengeInfo() {
            return this.detailCase_ == 1144;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyChallengeInfoOuterClass.EffigyChallengeInfo getEffigyChallengeInfo() {
            if (this.detailCase_ == 1144) {
                return (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_;
            }
            return EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder getEffigyChallengeInfoOrBuilder() {
            if (this.detailCase_ == 1144) {
                return (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_;
            }
            return EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCoinCollectInfo() {
            return this.detailCase_ == 559;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CoinCollectInfoOuterClass.CoinCollectInfo getCoinCollectInfo() {
            if (this.detailCase_ == 559) {
                return (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_;
            }
            return CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder getCoinCollectInfoOrBuilder() {
            if (this.detailCase_ == 559) {
                return (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_;
            }
            return CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBrickBreakerInfo() {
            return this.detailCase_ == 1275;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BrickBreakerInfoOuterClass.BrickBreakerInfo getBrickBreakerInfo() {
            if (this.detailCase_ == 1275) {
                return (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_;
            }
            return BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BrickBreakerInfoOuterClass.BrickBreakerInfoOrBuilder getBrickBreakerInfoOrBuilder() {
            if (this.detailCase_ == 1275) {
                return (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_;
            }
            return BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDuelHeartInfo() {
            return this.detailCase_ == 221;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DuelHeartInfoOuterClass.DuelHeartInfo getDuelHeartInfo() {
            if (this.detailCase_ == 221) {
                return (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_;
            }
            return DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DuelHeartInfoOuterClass.DuelHeartInfoOrBuilder getDuelHeartInfoOrBuilder() {
            if (this.detailCase_ == 221) {
                return (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_;
            }
            return DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSeaLampV3Info() {
            return this.detailCase_ == 1080;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampV3InfoOuterClass.SeaLampV3Info getSeaLampV3Info() {
            if (this.detailCase_ == 1080) {
                return (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_;
            }
            return SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder getSeaLampV3InfoOrBuilder() {
            if (this.detailCase_ == 1080) {
                return (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_;
            }
            return SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTeamChainInfo() {
            return this.detailCase_ == 144;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TeamChainInfoOuterClass.TeamChainInfo getTeamChainInfo() {
            if (this.detailCase_ == 144) {
                return (TeamChainInfoOuterClass.TeamChainInfo) this.detail_;
            }
            return TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TeamChainInfoOuterClass.TeamChainInfoOrBuilder getTeamChainInfoOrBuilder() {
            if (this.detailCase_ == 144) {
                return (TeamChainInfoOuterClass.TeamChainInfo) this.detail_;
            }
            return TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGcgFestivalInfo() {
            return this.detailCase_ == 71;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GcgFestivalInfoOuterClass.GcgFestivalInfo getGcgFestivalInfo() {
            if (this.detailCase_ == 71) {
                return (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_;
            }
            return GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GcgFestivalInfoOuterClass.GcgFestivalInfoOrBuilder getGcgFestivalInfoOrBuilder() {
            if (this.detailCase_ == 71) {
                return (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_;
            }
            return GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            getSerializedSize();
            if (this.detailCase_ == 1) {
                output.writeMessage(1, (SalesmanInfoOuterClass.SalesmanInfo) this.detail_);
            }
            if (getMeetCondListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.meetCondListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.meetCondList_.size(); i++) {
                output.writeUInt32NoTag(this.meetCondList_.getInt(i));
            }
            if (this.isFinished_) {
                output.writeBool(3, this.isFinished_);
            }
            if (this.detailCase_ == 4) {
                output.writeMessage(4, (SamLampInfoOuterClass.SamLampInfo) this.detail_);
            }
            if (this.beginTime_ != 0) {
                output.writeUInt32(5, this.beginTime_);
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(6, this.scheduleId_);
            }
            if (this.unk3300MDBDPIBEGGH_) {
                output.writeBool(7, this.unk3300MDBDPIBEGGH_);
            }
            if (this.detailCase_ == 8) {
                output.writeMessage(8, (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_);
            }
            if (getExpireCondListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.expireCondListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.expireCondList_.size(); i2++) {
                output.writeUInt32NoTag(this.expireCondList_.getInt(i2));
            }
            if (this.activityType_ != 0) {
                output.writeUInt32(10, this.activityType_);
            }
            if (this.unk3300ICNJJKDHPCH_) {
                output.writeBool(11, this.unk3300ICNJJKDHPCH_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(12, this.endTime_);
            }
            if (this.detailCase_ == 13) {
                output.writeMessage(13, (CrucibleInfoOuterClass.CrucibleInfo) this.detail_);
            }
            for (int i3 = 0; i3 < this.watcherInfoList_.size(); i3++) {
                output.writeMessage(14, this.watcherInfoList_.get(i3));
            }
            if (this.activityId_ != 0) {
                output.writeUInt32(15, this.activityId_);
            }
            if (this.detailCase_ == 32) {
                output.writeMessage(32, (DeliveryInfoOuterClass.DeliveryInfo) this.detail_);
            }
            if (this.detailCase_ == 35) {
                output.writeMessage(35, (BartenderInfoOuterClass.BartenderInfo) this.detail_);
            }
            if (this.detailCase_ == 71) {
                output.writeMessage(71, (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_);
            }
            if (this.detailCase_ == 82) {
                output.writeMessage(82, (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_);
            }
            if (this.detailCase_ == 114) {
                output.writeMessage(114, (WinterCampInfoOuterClass.WinterCampInfo) this.detail_);
            }
            if (this.detailCase_ == 142) {
                output.writeMessage(142, (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_);
            }
            if (this.detailCase_ == 144) {
                output.writeMessage(144, (TeamChainInfoOuterClass.TeamChainInfo) this.detail_);
            }
            if (this.detailCase_ == 168) {
                output.writeMessage(168, (DigInfoOuterClass.DigInfo) this.detail_);
            }
            if (this.detailCase_ == 192) {
                output.writeMessage(192, (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_);
            }
            if (this.detailCase_ == 221) {
                output.writeMessage(221, (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_);
            }
            if (this.detailCase_ == 278) {
                output.writeMessage(278, (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_);
            }
            if (this.detailCase_ == 309) {
                output.writeMessage(309, (PhotoInfoOuterClass.PhotoInfo) this.detail_);
            }
            for (int i4 = 0; i4 < this.activityPushTipsDataList_.size(); i4++) {
                output.writeMessage(336, this.activityPushTipsDataList_.get(i4));
            }
            if (this.detailCase_ == 378) {
                output.writeMessage(378, (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_);
            }
            if (this.curScore_ != 0) {
                output.writeUInt32(CURSCORE_FIELD_NUMBER, this.curScore_);
            }
            if (this.detailCase_ == 397) {
                output.writeMessage(397, (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetActivityCoinMap(), ActivityCoinMapDefaultEntryHolder.defaultEntry, 406);
            if (this.detailCase_ == 417) {
                output.writeMessage(417, (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_);
            }
            if (this.detailCase_ == 428) {
                output.writeMessage(428, (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_);
            }
            if (this.detailCase_ == 504) {
                output.writeMessage(504, (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_);
            }
            if (this.selectedAvatarRewardId_ != 0) {
                output.writeUInt32(519, this.selectedAvatarRewardId_);
            }
            if (this.unk3300ABJKLALKLDG_) {
                output.writeBool(UNK3300_ABJKLALKLDG_FIELD_NUMBER, this.unk3300ABJKLALKLDG_);
            }
            if (this.detailCase_ == 546) {
                output.writeMessage(TREASURE_MAP_INFO_FIELD_NUMBER, (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_);
            }
            if (this.detailCase_ == 559) {
                output.writeMessage(559, (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_);
            }
            if (this.detailCase_ == 578) {
                output.writeMessage(SEA_LAMP_INFO_FIELD_NUMBER, (SeaLampInfoOuterClass.SeaLampInfo) this.detail_);
            }
            if (this.detailCase_ == 589) {
                output.writeMessage(UGC_INFO_FIELD_NUMBER, (UgcInfoOuterClass.UgcInfo) this.detail_);
            }
            if (this.firstDayStartTime_ != 0) {
                output.writeUInt32(598, this.firstDayStartTime_);
            }
            if (getTakenRewardListList().size() > 0) {
                output.writeUInt32NoTag(5154);
                output.writeUInt32NoTag(this.takenRewardListMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.takenRewardList_.size(); i5++) {
                output.writeUInt32NoTag(this.takenRewardList_.getInt(i5));
            }
            if (this.detailCase_ == 699) {
                output.writeMessage(699, (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_);
            }
            if (this.unk3300MJNPGEKLOCG_) {
                output.writeBool(UNK3300_MJNPGEKLOCG_FIELD_NUMBER, this.unk3300MJNPGEKLOCG_);
            }
            if (this.detailCase_ == 930) {
                output.writeMessage(930, (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_);
            }
            if (this.detailCase_ == 944) {
                output.writeMessage(INSTABLE_SPRAY_INFO_FIELD_NUMBER, (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_);
            }
            if (this.detailCase_ == 951) {
                output.writeMessage(951, (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_);
            }
            if (this.detailCase_ == 1014) {
                output.writeMessage(1014, (IrodoriInfoOuterClass.IrodoriInfo) this.detail_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetWishGiftNumMap(), WishGiftNumMapDefaultEntryHolder.defaultEntry, WISHGIFTNUMMAP_FIELD_NUMBER);
            if (this.detailCase_ == 1062) {
                output.writeMessage(1062, (FlightInfoOuterClass.FlightInfo) this.detail_);
            }
            if (this.detailCase_ == 1077) {
                output.writeMessage(HIDE_AND_SEEK_INFO_FIELD_NUMBER, (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_);
            }
            if (this.detailCase_ == 1080) {
                output.writeMessage(1080, (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_);
            }
            if (this.detailCase_ == 1116) {
                output.writeMessage(1116, (FleurFairInfoOuterClass.FleurFairInfo) this.detail_);
            }
            if (this.detailCase_ == 1122) {
                output.writeMessage(1122, (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_);
            }
            if (this.unk3300CBCEHLJJOGI_) {
                output.writeBool(1126, this.unk3300CBCEHLJJOGI_);
            }
            if (this.detailCase_ == 1135) {
                output.writeMessage(CHALLNELER_SLAB_INFO_FIELD_NUMBER, (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_);
            }
            if (this.detailCase_ == 1142) {
                output.writeMessage(TREASURE_SEELIE_INFO_FIELD_NUMBER, (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_);
            }
            if (this.detailCase_ == 1144) {
                output.writeMessage(EFFIGY_CHALLENGE_INFO_FIELD_NUMBER, (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_);
            }
            if (this.detailCase_ == 1172) {
                output.writeMessage(ECHO_SHELL_INFO_FIELD_NUMBER, (EchoShellInfoOuterClass.EchoShellInfo) this.detail_);
            }
            if (this.detailCase_ == 1173) {
                output.writeMessage(GRAVEN_INNOCENCE_INFO_FIELD_NUMBER, (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_);
            }
            if (this.detailCase_ == 1177) {
                output.writeMessage(GACHA_INFO_FIELD_NUMBER, (GachaInfoOuterClass.GachaInfo) this.detail_);
            }
            if (this.detailCase_ == 1198) {
                output.writeMessage(1198, (BlessingInfoOuterClass.BlessingInfo) this.detail_);
            }
            if (this.detailCase_ == 1220) {
                output.writeMessage(1220, (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1273) {
                output.writeMessage(ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER, (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_);
            }
            if (this.detailCase_ == 1275) {
                output.writeMessage(BRICK_BREAKER_INFO_FIELD_NUMBER, (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_);
            }
            if (this.detailCase_ == 1277) {
                output.writeMessage(BUOYANT_COMBAT_INFO_FIELD_NUMBER, (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_);
            }
            if (this.detailCase_ == 1316) {
                output.writeMessage(1316, (VintageInfoOuterClass.VintageInfo) this.detail_);
            }
            if (this.detailCase_ == 1320) {
                output.writeMessage(1320, (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1350) {
                output.writeMessage(MUQADAS_POTION_INFO_FIELD_NUMBER, (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_);
            }
            if (this.detailCase_ == 1372) {
                output.writeMessage(LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER, (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1375) {
                output.writeMessage(CRYSTAL_LINK_INFO_FIELD_NUMBER, (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_);
            }
            if (this.detailCase_ == 1379) {
                output.writeMessage(SUMO_INFO_FIELD_NUMBER, (SumoInfoOuterClass.SumoInfo) this.detail_);
            }
            if (this.detailCase_ == 1446) {
                output.writeMessage(SPICE_INFO_FIELD_NUMBER, (SpiceInfoOuterClass.SpiceInfo) this.detail_);
            }
            if (this.detailCase_ == 1453) {
                output.writeMessage(TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER, (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1477) {
                output.writeMessage(SUMMER_TIME_INFO_FIELD_NUMBER, (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_);
            }
            if (this.scoreLimit_ != 0) {
                output.writeUInt32(SCORELIMIT_FIELD_NUMBER, this.scoreLimit_);
            }
            if (this.detailCase_ == 1543) {
                output.writeMessage(1543, (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_);
            }
            if (this.detailCase_ == 1552) {
                output.writeMessage(POTION_INFO_FIELD_NUMBER, (PotionInfoOuterClass.PotionInfo) this.detail_);
            }
            if (this.detailCase_ == 1631) {
                output.writeMessage(1631, (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_);
            }
            if (this.unk3300NEPKLLBJFKK_) {
                output.writeBool(UNK3300_NEPKLLBJFKK_FIELD_NUMBER, this.unk3300NEPKLLBJFKK_);
            }
            if (this.detailCase_ == 1651) {
                output.writeMessage(WATER_SPIRIT_INFO_FIELD_NUMBER, (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_);
            }
            if (this.detailCase_ == 1663) {
                output.writeMessage(1663, (HachiInfoOuterClass.HachiInfo) this.detail_);
            }
            if (this.detailCase_ == 1797) {
                output.writeMessage(1797, (ChessInfoOuterClass.ChessInfo) this.detail_);
            }
            if (this.detailCase_ == 1801) {
                output.writeMessage(GEAR_INFO_FIELD_NUMBER, (GearInfoOuterClass.GearInfo) this.detail_);
            }
            if (this.detailCase_ == 1808) {
                output.writeMessage(ASTER_INFO_FIELD_NUMBER, (AsterInfoOuterClass.AsterInfo) this.detail_);
            }
            if (this.detailCase_ == 1817) {
                output.writeMessage(ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER, (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_);
            }
            if (this.detailCase_ == 1864) {
                output.writeMessage(PLANT_FLOWER_INFO_FIELD_NUMBER, (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_);
            }
            if (this.detailCase_ == 1991) {
                output.writeMessage(1991, (EffigyInfoOuterClass.EffigyInfo) this.detail_);
            }
            if (getFdjefldhelaList().size() > 0) {
                output.writeUInt32NoTag(16170);
                output.writeUInt32NoTag(this.fdjefldhelaMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.fdjefldhela_.size(); i6++) {
                output.writeUInt32NoTag(this.fdjefldhela_.getInt(i6));
            }
            if (this.detailCase_ == 2029) {
                output.writeMessage(WIND_FIELD_INFO_FIELD_NUMBER, (WindFieldInfoOuterClass.WindFieldInfo) this.detail_);
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            if (this.detailCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeMessageSize(1, (SalesmanInfoOuterClass.SalesmanInfo) this.detail_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.meetCondList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.meetCondList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getMeetCondListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.meetCondListMemoizedSerializedSize = dataSize;
            if (this.isFinished_) {
                size3 += CodedOutputStream.computeBoolSize(3, this.isFinished_);
            }
            if (this.detailCase_ == 4) {
                size3 += CodedOutputStream.computeMessageSize(4, (SamLampInfoOuterClass.SamLampInfo) this.detail_);
            }
            if (this.beginTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(5, this.beginTime_);
            }
            if (this.scheduleId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(6, this.scheduleId_);
            }
            if (this.unk3300MDBDPIBEGGH_) {
                size3 += CodedOutputStream.computeBoolSize(7, this.unk3300MDBDPIBEGGH_);
            }
            if (this.detailCase_ == 8) {
                size3 += CodedOutputStream.computeMessageSize(8, (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.expireCondList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.expireCondList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getExpireCondListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.expireCondListMemoizedSerializedSize = dataSize2;
            if (this.activityType_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(10, this.activityType_);
            }
            if (this.unk3300ICNJJKDHPCH_) {
                size4 += CodedOutputStream.computeBoolSize(11, this.unk3300ICNJJKDHPCH_);
            }
            if (this.endTime_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(12, this.endTime_);
            }
            if (this.detailCase_ == 13) {
                size4 += CodedOutputStream.computeMessageSize(13, (CrucibleInfoOuterClass.CrucibleInfo) this.detail_);
            }
            for (int i3 = 0; i3 < this.watcherInfoList_.size(); i3++) {
                size4 += CodedOutputStream.computeMessageSize(14, this.watcherInfoList_.get(i3));
            }
            if (this.activityId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(15, this.activityId_);
            }
            if (this.detailCase_ == 32) {
                size4 += CodedOutputStream.computeMessageSize(32, (DeliveryInfoOuterClass.DeliveryInfo) this.detail_);
            }
            if (this.detailCase_ == 35) {
                size4 += CodedOutputStream.computeMessageSize(35, (BartenderInfoOuterClass.BartenderInfo) this.detail_);
            }
            if (this.detailCase_ == 71) {
                size4 += CodedOutputStream.computeMessageSize(71, (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_);
            }
            if (this.detailCase_ == 82) {
                size4 += CodedOutputStream.computeMessageSize(82, (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_);
            }
            if (this.detailCase_ == 114) {
                size4 += CodedOutputStream.computeMessageSize(114, (WinterCampInfoOuterClass.WinterCampInfo) this.detail_);
            }
            if (this.detailCase_ == 142) {
                size4 += CodedOutputStream.computeMessageSize(142, (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_);
            }
            if (this.detailCase_ == 144) {
                size4 += CodedOutputStream.computeMessageSize(144, (TeamChainInfoOuterClass.TeamChainInfo) this.detail_);
            }
            if (this.detailCase_ == 168) {
                size4 += CodedOutputStream.computeMessageSize(168, (DigInfoOuterClass.DigInfo) this.detail_);
            }
            if (this.detailCase_ == 192) {
                size4 += CodedOutputStream.computeMessageSize(192, (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_);
            }
            if (this.detailCase_ == 221) {
                size4 += CodedOutputStream.computeMessageSize(221, (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_);
            }
            if (this.detailCase_ == 278) {
                size4 += CodedOutputStream.computeMessageSize(278, (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_);
            }
            if (this.detailCase_ == 309) {
                size4 += CodedOutputStream.computeMessageSize(309, (PhotoInfoOuterClass.PhotoInfo) this.detail_);
            }
            for (int i4 = 0; i4 < this.activityPushTipsDataList_.size(); i4++) {
                size4 += CodedOutputStream.computeMessageSize(336, this.activityPushTipsDataList_.get(i4));
            }
            if (this.detailCase_ == 378) {
                size4 += CodedOutputStream.computeMessageSize(378, (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_);
            }
            if (this.curScore_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(CURSCORE_FIELD_NUMBER, this.curScore_);
            }
            if (this.detailCase_ == 397) {
                size4 += CodedOutputStream.computeMessageSize(397, (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetActivityCoinMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(406, ActivityCoinMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.detailCase_ == 417) {
                size4 += CodedOutputStream.computeMessageSize(417, (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_);
            }
            if (this.detailCase_ == 428) {
                size4 += CodedOutputStream.computeMessageSize(428, (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_);
            }
            if (this.detailCase_ == 504) {
                size4 += CodedOutputStream.computeMessageSize(504, (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_);
            }
            if (this.selectedAvatarRewardId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(519, this.selectedAvatarRewardId_);
            }
            if (this.unk3300ABJKLALKLDG_) {
                size4 += CodedOutputStream.computeBoolSize(UNK3300_ABJKLALKLDG_FIELD_NUMBER, this.unk3300ABJKLALKLDG_);
            }
            if (this.detailCase_ == 546) {
                size4 += CodedOutputStream.computeMessageSize(TREASURE_MAP_INFO_FIELD_NUMBER, (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_);
            }
            if (this.detailCase_ == 559) {
                size4 += CodedOutputStream.computeMessageSize(559, (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_);
            }
            if (this.detailCase_ == 578) {
                size4 += CodedOutputStream.computeMessageSize(SEA_LAMP_INFO_FIELD_NUMBER, (SeaLampInfoOuterClass.SeaLampInfo) this.detail_);
            }
            if (this.detailCase_ == 589) {
                size4 += CodedOutputStream.computeMessageSize(UGC_INFO_FIELD_NUMBER, (UgcInfoOuterClass.UgcInfo) this.detail_);
            }
            if (this.firstDayStartTime_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(598, this.firstDayStartTime_);
            }
            int dataSize3 = 0;
            for (int i5 = 0; i5 < this.takenRewardList_.size(); i5++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.takenRewardList_.getInt(i5));
            }
            int size5 = size4 + dataSize3;
            if (!getTakenRewardListList().isEmpty()) {
                size5 = size5 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.takenRewardListMemoizedSerializedSize = dataSize3;
            if (this.detailCase_ == 699) {
                size5 += CodedOutputStream.computeMessageSize(699, (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_);
            }
            if (this.unk3300MJNPGEKLOCG_) {
                size5 += CodedOutputStream.computeBoolSize(UNK3300_MJNPGEKLOCG_FIELD_NUMBER, this.unk3300MJNPGEKLOCG_);
            }
            if (this.detailCase_ == 930) {
                size5 += CodedOutputStream.computeMessageSize(930, (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_);
            }
            if (this.detailCase_ == 944) {
                size5 += CodedOutputStream.computeMessageSize(INSTABLE_SPRAY_INFO_FIELD_NUMBER, (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_);
            }
            if (this.detailCase_ == 951) {
                size5 += CodedOutputStream.computeMessageSize(951, (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_);
            }
            if (this.detailCase_ == 1014) {
                size5 += CodedOutputStream.computeMessageSize(1014, (IrodoriInfoOuterClass.IrodoriInfo) this.detail_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetWishGiftNumMap().getMap().entrySet()) {
                size5 += CodedOutputStream.computeMessageSize(WISHGIFTNUMMAP_FIELD_NUMBER, WishGiftNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.detailCase_ == 1062) {
                size5 += CodedOutputStream.computeMessageSize(1062, (FlightInfoOuterClass.FlightInfo) this.detail_);
            }
            if (this.detailCase_ == 1077) {
                size5 += CodedOutputStream.computeMessageSize(HIDE_AND_SEEK_INFO_FIELD_NUMBER, (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_);
            }
            if (this.detailCase_ == 1080) {
                size5 += CodedOutputStream.computeMessageSize(1080, (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_);
            }
            if (this.detailCase_ == 1116) {
                size5 += CodedOutputStream.computeMessageSize(1116, (FleurFairInfoOuterClass.FleurFairInfo) this.detail_);
            }
            if (this.detailCase_ == 1122) {
                size5 += CodedOutputStream.computeMessageSize(1122, (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_);
            }
            if (this.unk3300CBCEHLJJOGI_) {
                size5 += CodedOutputStream.computeBoolSize(1126, this.unk3300CBCEHLJJOGI_);
            }
            if (this.detailCase_ == 1135) {
                size5 += CodedOutputStream.computeMessageSize(CHALLNELER_SLAB_INFO_FIELD_NUMBER, (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_);
            }
            if (this.detailCase_ == 1142) {
                size5 += CodedOutputStream.computeMessageSize(TREASURE_SEELIE_INFO_FIELD_NUMBER, (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_);
            }
            if (this.detailCase_ == 1144) {
                size5 += CodedOutputStream.computeMessageSize(EFFIGY_CHALLENGE_INFO_FIELD_NUMBER, (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_);
            }
            if (this.detailCase_ == 1172) {
                size5 += CodedOutputStream.computeMessageSize(ECHO_SHELL_INFO_FIELD_NUMBER, (EchoShellInfoOuterClass.EchoShellInfo) this.detail_);
            }
            if (this.detailCase_ == 1173) {
                size5 += CodedOutputStream.computeMessageSize(GRAVEN_INNOCENCE_INFO_FIELD_NUMBER, (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_);
            }
            if (this.detailCase_ == 1177) {
                size5 += CodedOutputStream.computeMessageSize(GACHA_INFO_FIELD_NUMBER, (GachaInfoOuterClass.GachaInfo) this.detail_);
            }
            if (this.detailCase_ == 1198) {
                size5 += CodedOutputStream.computeMessageSize(1198, (BlessingInfoOuterClass.BlessingInfo) this.detail_);
            }
            if (this.detailCase_ == 1220) {
                size5 += CodedOutputStream.computeMessageSize(1220, (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1273) {
                size5 += CodedOutputStream.computeMessageSize(ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER, (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_);
            }
            if (this.detailCase_ == 1275) {
                size5 += CodedOutputStream.computeMessageSize(BRICK_BREAKER_INFO_FIELD_NUMBER, (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_);
            }
            if (this.detailCase_ == 1277) {
                size5 += CodedOutputStream.computeMessageSize(BUOYANT_COMBAT_INFO_FIELD_NUMBER, (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_);
            }
            if (this.detailCase_ == 1316) {
                size5 += CodedOutputStream.computeMessageSize(1316, (VintageInfoOuterClass.VintageInfo) this.detail_);
            }
            if (this.detailCase_ == 1320) {
                size5 += CodedOutputStream.computeMessageSize(1320, (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1350) {
                size5 += CodedOutputStream.computeMessageSize(MUQADAS_POTION_INFO_FIELD_NUMBER, (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_);
            }
            if (this.detailCase_ == 1372) {
                size5 += CodedOutputStream.computeMessageSize(LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER, (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1375) {
                size5 += CodedOutputStream.computeMessageSize(CRYSTAL_LINK_INFO_FIELD_NUMBER, (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_);
            }
            if (this.detailCase_ == 1379) {
                size5 += CodedOutputStream.computeMessageSize(SUMO_INFO_FIELD_NUMBER, (SumoInfoOuterClass.SumoInfo) this.detail_);
            }
            if (this.detailCase_ == 1446) {
                size5 += CodedOutputStream.computeMessageSize(SPICE_INFO_FIELD_NUMBER, (SpiceInfoOuterClass.SpiceInfo) this.detail_);
            }
            if (this.detailCase_ == 1453) {
                size5 += CodedOutputStream.computeMessageSize(TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER, (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_);
            }
            if (this.detailCase_ == 1477) {
                size5 += CodedOutputStream.computeMessageSize(SUMMER_TIME_INFO_FIELD_NUMBER, (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_);
            }
            if (this.scoreLimit_ != 0) {
                size5 += CodedOutputStream.computeUInt32Size(SCORELIMIT_FIELD_NUMBER, this.scoreLimit_);
            }
            if (this.detailCase_ == 1543) {
                size5 += CodedOutputStream.computeMessageSize(1543, (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_);
            }
            if (this.detailCase_ == 1552) {
                size5 += CodedOutputStream.computeMessageSize(POTION_INFO_FIELD_NUMBER, (PotionInfoOuterClass.PotionInfo) this.detail_);
            }
            if (this.detailCase_ == 1631) {
                size5 += CodedOutputStream.computeMessageSize(1631, (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_);
            }
            if (this.unk3300NEPKLLBJFKK_) {
                size5 += CodedOutputStream.computeBoolSize(UNK3300_NEPKLLBJFKK_FIELD_NUMBER, this.unk3300NEPKLLBJFKK_);
            }
            if (this.detailCase_ == 1651) {
                size5 += CodedOutputStream.computeMessageSize(WATER_SPIRIT_INFO_FIELD_NUMBER, (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_);
            }
            if (this.detailCase_ == 1663) {
                size5 += CodedOutputStream.computeMessageSize(1663, (HachiInfoOuterClass.HachiInfo) this.detail_);
            }
            if (this.detailCase_ == 1797) {
                size5 += CodedOutputStream.computeMessageSize(1797, (ChessInfoOuterClass.ChessInfo) this.detail_);
            }
            if (this.detailCase_ == 1801) {
                size5 += CodedOutputStream.computeMessageSize(GEAR_INFO_FIELD_NUMBER, (GearInfoOuterClass.GearInfo) this.detail_);
            }
            if (this.detailCase_ == 1808) {
                size5 += CodedOutputStream.computeMessageSize(ASTER_INFO_FIELD_NUMBER, (AsterInfoOuterClass.AsterInfo) this.detail_);
            }
            if (this.detailCase_ == 1817) {
                size5 += CodedOutputStream.computeMessageSize(ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER, (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_);
            }
            if (this.detailCase_ == 1864) {
                size5 += CodedOutputStream.computeMessageSize(PLANT_FLOWER_INFO_FIELD_NUMBER, (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_);
            }
            if (this.detailCase_ == 1991) {
                size5 += CodedOutputStream.computeMessageSize(1991, (EffigyInfoOuterClass.EffigyInfo) this.detail_);
            }
            int dataSize4 = 0;
            for (int i6 = 0; i6 < this.fdjefldhela_.size(); i6++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.fdjefldhela_.getInt(i6));
            }
            int size6 = size5 + dataSize4;
            if (!getFdjefldhelaList().isEmpty()) {
                size6 = size6 + 2 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.fdjefldhelaMemoizedSerializedSize = dataSize4;
            if (this.detailCase_ == 2029) {
                size6 += CodedOutputStream.computeMessageSize(WIND_FIELD_INFO_FIELD_NUMBER, (WindFieldInfoOuterClass.WindFieldInfo) this.detail_);
            }
            int size7 = size6 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size7;
            return size7;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ActivityInfo)) {
                return equals(obj);
            }
            ActivityInfo other = (ActivityInfo) obj;
            if (!internalGetActivityCoinMap().equals(other.internalGetActivityCoinMap()) || getScoreLimit() != other.getScoreLimit() || !getTakenRewardListList().equals(other.getTakenRewardListList()) || getUnk3300MDBDPIBEGGH() != other.getUnk3300MDBDPIBEGGH() || getUnk3300MJNPGEKLOCG() != other.getUnk3300MJNPGEKLOCG() || getEndTime() != other.getEndTime() || getActivityType() != other.getActivityType() || getSelectedAvatarRewardId() != other.getSelectedAvatarRewardId() || !getMeetCondListList().equals(other.getMeetCondListList()) || getActivityId() != other.getActivityId() || getUnk3300ABJKLALKLDG() != other.getUnk3300ABJKLALKLDG() || getIsFinished() != other.getIsFinished() || !getActivityPushTipsDataListList().equals(other.getActivityPushTipsDataListList()) || !getWatcherInfoListList().equals(other.getWatcherInfoListList()) || getUnk3300CBCEHLJJOGI() != other.getUnk3300CBCEHLJJOGI() || getScheduleId() != other.getScheduleId() || !getExpireCondListList().equals(other.getExpireCondListList()) || !getFdjefldhelaList().equals(other.getFdjefldhelaList()) || getUnk3300ICNJJKDHPCH() != other.getUnk3300ICNJJKDHPCH() || getFirstDayStartTime() != other.getFirstDayStartTime() || getCurScore() != other.getCurScore() || !internalGetWishGiftNumMap().equals(other.internalGetWishGiftNumMap()) || getUnk3300NEPKLLBJFKK() != other.getUnk3300NEPKLLBJFKK() || getBeginTime() != other.getBeginTime() || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 1:
                    if (!getSalesmanInfo().equals(other.getSalesmanInfo())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getSamLampInfo().equals(other.getSamLampInfo())) {
                        return false;
                    }
                    break;
                case 8:
                    if (!getTrialAvatarInfo().equals(other.getTrialAvatarInfo())) {
                        return false;
                    }
                    break;
                case 13:
                    if (!getCrucibleInfo().equals(other.getCrucibleInfo())) {
                        return false;
                    }
                    break;
                case 32:
                    if (!getDeliveryInfo().equals(other.getDeliveryInfo())) {
                        return false;
                    }
                    break;
                case 35:
                    if (!getBartenderInfo().equals(other.getBartenderInfo())) {
                        return false;
                    }
                    break;
                case 71:
                    if (!getGcgFestivalInfo().equals(other.getGcgFestivalInfo())) {
                        return false;
                    }
                    break;
                case 82:
                    if (!getLunaRiteInfo().equals(other.getLunaRiteInfo())) {
                        return false;
                    }
                    break;
                case 114:
                    if (!getWinterCampInfo().equals(other.getWinterCampInfo())) {
                        return false;
                    }
                    break;
                case 142:
                    if (!getLuminanceStoneChallengeInfo().equals(other.getLuminanceStoneChallengeInfo())) {
                        return false;
                    }
                    break;
                case 144:
                    if (!getTeamChainInfo().equals(other.getTeamChainInfo())) {
                        return false;
                    }
                    break;
                case 168:
                    if (!getDigInfo().equals(other.getDigInfo())) {
                        return false;
                    }
                    break;
                case 192:
                    if (!getBlitzRushInfo().equals(other.getBlitzRushInfo())) {
                        return false;
                    }
                    break;
                case 221:
                    if (!getDuelHeartInfo().equals(other.getDuelHeartInfo())) {
                        return false;
                    }
                    break;
                case 278:
                    if (!getBounceConjuringInfo().equals(other.getBounceConjuringInfo())) {
                        return false;
                    }
                    break;
                case 309:
                    if (!getPhotoInfo().equals(other.getPhotoInfo())) {
                        return false;
                    }
                    break;
                case 378:
                    if (!getDragonSpineInfo().equals(other.getDragonSpineInfo())) {
                        return false;
                    }
                    break;
                case 397:
                    if (!getRogueDiaryInfo().equals(other.getRogueDiaryInfo())) {
                        return false;
                    }
                    break;
                case 417:
                    if (!getFindHilichurlInfo().equals(other.getFindHilichurlInfo())) {
                        return false;
                    }
                    break;
                case 428:
                    if (!getMichiaeMatsuriInfo().equals(other.getMichiaeMatsuriInfo())) {
                        return false;
                    }
                    break;
                case 504:
                    if (!getCharAmusementInfo().equals(other.getCharAmusementInfo())) {
                        return false;
                    }
                    break;
                case TREASURE_MAP_INFO_FIELD_NUMBER /* 546 */:
                    if (!getTreasureMapInfo().equals(other.getTreasureMapInfo())) {
                        return false;
                    }
                    break;
                case 559:
                    if (!getCoinCollectInfo().equals(other.getCoinCollectInfo())) {
                        return false;
                    }
                    break;
                case SEA_LAMP_INFO_FIELD_NUMBER /* 578 */:
                    if (!getSeaLampInfo().equals(other.getSeaLampInfo())) {
                        return false;
                    }
                    break;
                case UGC_INFO_FIELD_NUMBER /* 589 */:
                    if (!getUgcInfo().equals(other.getUgcInfo())) {
                        return false;
                    }
                    break;
                case 699:
                    if (!getArenaChallengeInfo().equals(other.getArenaChallengeInfo())) {
                        return false;
                    }
                    break;
                case 930:
                    if (!getExpeditionInfo().equals(other.getExpeditionInfo())) {
                        return false;
                    }
                    break;
                case INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 944 */:
                    if (!getInstableSprayInfo().equals(other.getInstableSprayInfo())) {
                        return false;
                    }
                    break;
                case 951:
                    if (!getSummerTimeV2Info().equals(other.getSummerTimeV2Info())) {
                        return false;
                    }
                    break;
                case 1014:
                    if (!getIrodoriInfo().equals(other.getIrodoriInfo())) {
                        return false;
                    }
                    break;
                case 1062:
                    if (!getFlightInfo().equals(other.getFlightInfo())) {
                        return false;
                    }
                    break;
                case HIDE_AND_SEEK_INFO_FIELD_NUMBER /* 1077 */:
                    if (!getHideAndSeekInfo().equals(other.getHideAndSeekInfo())) {
                        return false;
                    }
                    break;
                case 1080:
                    if (!getSeaLampV3Info().equals(other.getSeaLampV3Info())) {
                        return false;
                    }
                    break;
                case 1116:
                    if (!getFleurFairInfo().equals(other.getFleurFairInfo())) {
                        return false;
                    }
                    break;
                case 1122:
                    if (!getMoonfinTrialInfo().equals(other.getMoonfinTrialInfo())) {
                        return false;
                    }
                    break;
                case CHALLNELER_SLAB_INFO_FIELD_NUMBER /* 1135 */:
                    if (!getChallnelerSlabInfo().equals(other.getChallnelerSlabInfo())) {
                        return false;
                    }
                    break;
                case TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1142 */:
                    if (!getTreasureSeelieInfo().equals(other.getTreasureSeelieInfo())) {
                        return false;
                    }
                    break;
                case EFFIGY_CHALLENGE_INFO_FIELD_NUMBER /* 1144 */:
                    if (!getEffigyChallengeInfo().equals(other.getEffigyChallengeInfo())) {
                        return false;
                    }
                    break;
                case ECHO_SHELL_INFO_FIELD_NUMBER /* 1172 */:
                    if (!getEchoShellInfo().equals(other.getEchoShellInfo())) {
                        return false;
                    }
                    break;
                case GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1173 */:
                    if (!getGravenInnocenceInfo().equals(other.getGravenInnocenceInfo())) {
                        return false;
                    }
                    break;
                case GACHA_INFO_FIELD_NUMBER /* 1177 */:
                    if (!getGachaInfo().equals(other.getGachaInfo())) {
                        return false;
                    }
                    break;
                case 1198:
                    if (!getBlessingInfo().equals(other.getBlessingInfo())) {
                        return false;
                    }
                    break;
                case 1220:
                    if (!getMusicGameInfo().equals(other.getMusicGameInfo())) {
                        return false;
                    }
                    break;
                case ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1273 */:
                    if (!getRockBoardExploreInfo().equals(other.getRockBoardExploreInfo())) {
                        return false;
                    }
                    break;
                case BRICK_BREAKER_INFO_FIELD_NUMBER /* 1275 */:
                    if (!getBrickBreakerInfo().equals(other.getBrickBreakerInfo())) {
                        return false;
                    }
                    break;
                case BUOYANT_COMBAT_INFO_FIELD_NUMBER /* 1277 */:
                    if (!getBuoyantCombatInfo().equals(other.getBuoyantCombatInfo())) {
                        return false;
                    }
                    break;
                case 1316:
                    if (!getVintageInfo().equals(other.getVintageInfo())) {
                        return false;
                    }
                    break;
                case 1320:
                    if (!getMistTrialActivityInfo().equals(other.getMistTrialActivityInfo())) {
                        return false;
                    }
                    break;
                case MUQADAS_POTION_INFO_FIELD_NUMBER /* 1350 */:
                    if (!getMuqadasPotionInfo().equals(other.getMuqadasPotionInfo())) {
                        return false;
                    }
                    break;
                case LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER /* 1372 */:
                    if (!getLanternRiteActivityInfo().equals(other.getLanternRiteActivityInfo())) {
                        return false;
                    }
                    break;
                case CRYSTAL_LINK_INFO_FIELD_NUMBER /* 1375 */:
                    if (!getCrystalLinkInfo().equals(other.getCrystalLinkInfo())) {
                        return false;
                    }
                    break;
                case SUMO_INFO_FIELD_NUMBER /* 1379 */:
                    if (!getSumoInfo().equals(other.getSumoInfo())) {
                        return false;
                    }
                    break;
                case SPICE_INFO_FIELD_NUMBER /* 1446 */:
                    if (!getSpiceInfo().equals(other.getSpiceInfo())) {
                        return false;
                    }
                    break;
                case TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1453 */:
                    if (!getTanukiTravelActivityInfo().equals(other.getTanukiTravelActivityInfo())) {
                        return false;
                    }
                    break;
                case SUMMER_TIME_INFO_FIELD_NUMBER /* 1477 */:
                    if (!getSummerTimeInfo().equals(other.getSummerTimeInfo())) {
                        return false;
                    }
                    break;
                case 1543:
                    if (!getFungusFighterInfo().equals(other.getFungusFighterInfo())) {
                        return false;
                    }
                    break;
                case POTION_INFO_FIELD_NUMBER /* 1552 */:
                    if (!getPotionInfo().equals(other.getPotionInfo())) {
                        return false;
                    }
                    break;
                case 1631:
                    if (!getIslandPartyInfo().equals(other.getIslandPartyInfo())) {
                        return false;
                    }
                    break;
                case WATER_SPIRIT_INFO_FIELD_NUMBER /* 1651 */:
                    if (!getWaterSpiritInfo().equals(other.getWaterSpiritInfo())) {
                        return false;
                    }
                    break;
                case 1663:
                    if (!getHachiInfo().equals(other.getHachiInfo())) {
                        return false;
                    }
                    break;
                case 1797:
                    if (!getChessInfo().equals(other.getChessInfo())) {
                        return false;
                    }
                    break;
                case GEAR_INFO_FIELD_NUMBER /* 1801 */:
                    if (!getGearInfo().equals(other.getGearInfo())) {
                        return false;
                    }
                    break;
                case ASTER_INFO_FIELD_NUMBER /* 1808 */:
                    if (!getAsterInfo().equals(other.getAsterInfo())) {
                        return false;
                    }
                    break;
                case ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER /* 1817 */:
                    if (!getRoguelikeDungoenInfo().equals(other.getRoguelikeDungoenInfo())) {
                        return false;
                    }
                    break;
                case PLANT_FLOWER_INFO_FIELD_NUMBER /* 1864 */:
                    if (!getPlantFlowerInfo().equals(other.getPlantFlowerInfo())) {
                        return false;
                    }
                    break;
                case 1991:
                    if (!getEffigyInfo().equals(other.getEffigyInfo())) {
                        return false;
                    }
                    break;
                case WIND_FIELD_INFO_FIELD_NUMBER /* 2029 */:
                    if (!getWindFieldInfo().equals(other.getWindFieldInfo())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (!internalGetActivityCoinMap().getMap().isEmpty()) {
                hash = (53 * ((37 * hash) + 406)) + internalGetActivityCoinMap().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + SCORELIMIT_FIELD_NUMBER)) + getScoreLimit();
            if (getTakenRewardListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 644)) + getTakenRewardListList().hashCode();
            }
            int hash3 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash2) + 7)) + Internal.hashBoolean(getUnk3300MDBDPIBEGGH()))) + UNK3300_MJNPGEKLOCG_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300MJNPGEKLOCG()))) + 12)) + getEndTime())) + 10)) + getActivityType())) + 519)) + getSelectedAvatarRewardId();
            if (getMeetCondListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 2)) + getMeetCondListList().hashCode();
            }
            int hash4 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash3) + 15)) + getActivityId())) + UNK3300_ABJKLALKLDG_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300ABJKLALKLDG()))) + 3)) + Internal.hashBoolean(getIsFinished());
            if (getActivityPushTipsDataListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 336)) + getActivityPushTipsDataListList().hashCode();
            }
            if (getWatcherInfoListCount() > 0) {
                hash4 = (53 * ((37 * hash4) + 14)) + getWatcherInfoListList().hashCode();
            }
            int hash5 = (53 * ((37 * ((53 * ((37 * hash4) + 1126)) + Internal.hashBoolean(getUnk3300CBCEHLJJOGI()))) + 6)) + getScheduleId();
            if (getExpireCondListCount() > 0) {
                hash5 = (53 * ((37 * hash5) + 9)) + getExpireCondListList().hashCode();
            }
            if (getFdjefldhelaCount() > 0) {
                hash5 = (53 * ((37 * hash5) + FDJEFLDHELA_FIELD_NUMBER)) + getFdjefldhelaList().hashCode();
            }
            int hash6 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash5) + 11)) + Internal.hashBoolean(getUnk3300ICNJJKDHPCH()))) + 598)) + getFirstDayStartTime())) + CURSCORE_FIELD_NUMBER)) + getCurScore();
            if (!internalGetWishGiftNumMap().getMap().isEmpty()) {
                hash6 = (53 * ((37 * hash6) + WISHGIFTNUMMAP_FIELD_NUMBER)) + internalGetWishGiftNumMap().hashCode();
            }
            int hash7 = (53 * ((37 * ((53 * ((37 * hash6) + UNK3300_NEPKLLBJFKK_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300NEPKLLBJFKK()))) + 5)) + getBeginTime();
            switch (this.detailCase_) {
                case 1:
                    hash7 = (53 * ((37 * hash7) + 1)) + getSalesmanInfo().hashCode();
                    break;
                case 4:
                    hash7 = (53 * ((37 * hash7) + 4)) + getSamLampInfo().hashCode();
                    break;
                case 8:
                    hash7 = (53 * ((37 * hash7) + 8)) + getTrialAvatarInfo().hashCode();
                    break;
                case 13:
                    hash7 = (53 * ((37 * hash7) + 13)) + getCrucibleInfo().hashCode();
                    break;
                case 32:
                    hash7 = (53 * ((37 * hash7) + 32)) + getDeliveryInfo().hashCode();
                    break;
                case 35:
                    hash7 = (53 * ((37 * hash7) + 35)) + getBartenderInfo().hashCode();
                    break;
                case 71:
                    hash7 = (53 * ((37 * hash7) + 71)) + getGcgFestivalInfo().hashCode();
                    break;
                case 82:
                    hash7 = (53 * ((37 * hash7) + 82)) + getLunaRiteInfo().hashCode();
                    break;
                case 114:
                    hash7 = (53 * ((37 * hash7) + 114)) + getWinterCampInfo().hashCode();
                    break;
                case 142:
                    hash7 = (53 * ((37 * hash7) + 142)) + getLuminanceStoneChallengeInfo().hashCode();
                    break;
                case 144:
                    hash7 = (53 * ((37 * hash7) + 144)) + getTeamChainInfo().hashCode();
                    break;
                case 168:
                    hash7 = (53 * ((37 * hash7) + 168)) + getDigInfo().hashCode();
                    break;
                case 192:
                    hash7 = (53 * ((37 * hash7) + 192)) + getBlitzRushInfo().hashCode();
                    break;
                case 221:
                    hash7 = (53 * ((37 * hash7) + 221)) + getDuelHeartInfo().hashCode();
                    break;
                case 278:
                    hash7 = (53 * ((37 * hash7) + 278)) + getBounceConjuringInfo().hashCode();
                    break;
                case 309:
                    hash7 = (53 * ((37 * hash7) + 309)) + getPhotoInfo().hashCode();
                    break;
                case 378:
                    hash7 = (53 * ((37 * hash7) + 378)) + getDragonSpineInfo().hashCode();
                    break;
                case 397:
                    hash7 = (53 * ((37 * hash7) + 397)) + getRogueDiaryInfo().hashCode();
                    break;
                case 417:
                    hash7 = (53 * ((37 * hash7) + 417)) + getFindHilichurlInfo().hashCode();
                    break;
                case 428:
                    hash7 = (53 * ((37 * hash7) + 428)) + getMichiaeMatsuriInfo().hashCode();
                    break;
                case 504:
                    hash7 = (53 * ((37 * hash7) + 504)) + getCharAmusementInfo().hashCode();
                    break;
                case TREASURE_MAP_INFO_FIELD_NUMBER /* 546 */:
                    hash7 = (53 * ((37 * hash7) + TREASURE_MAP_INFO_FIELD_NUMBER)) + getTreasureMapInfo().hashCode();
                    break;
                case 559:
                    hash7 = (53 * ((37 * hash7) + 559)) + getCoinCollectInfo().hashCode();
                    break;
                case SEA_LAMP_INFO_FIELD_NUMBER /* 578 */:
                    hash7 = (53 * ((37 * hash7) + SEA_LAMP_INFO_FIELD_NUMBER)) + getSeaLampInfo().hashCode();
                    break;
                case UGC_INFO_FIELD_NUMBER /* 589 */:
                    hash7 = (53 * ((37 * hash7) + UGC_INFO_FIELD_NUMBER)) + getUgcInfo().hashCode();
                    break;
                case 699:
                    hash7 = (53 * ((37 * hash7) + 699)) + getArenaChallengeInfo().hashCode();
                    break;
                case 930:
                    hash7 = (53 * ((37 * hash7) + 930)) + getExpeditionInfo().hashCode();
                    break;
                case INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 944 */:
                    hash7 = (53 * ((37 * hash7) + INSTABLE_SPRAY_INFO_FIELD_NUMBER)) + getInstableSprayInfo().hashCode();
                    break;
                case 951:
                    hash7 = (53 * ((37 * hash7) + 951)) + getSummerTimeV2Info().hashCode();
                    break;
                case 1014:
                    hash7 = (53 * ((37 * hash7) + 1014)) + getIrodoriInfo().hashCode();
                    break;
                case 1062:
                    hash7 = (53 * ((37 * hash7) + 1062)) + getFlightInfo().hashCode();
                    break;
                case HIDE_AND_SEEK_INFO_FIELD_NUMBER /* 1077 */:
                    hash7 = (53 * ((37 * hash7) + HIDE_AND_SEEK_INFO_FIELD_NUMBER)) + getHideAndSeekInfo().hashCode();
                    break;
                case 1080:
                    hash7 = (53 * ((37 * hash7) + 1080)) + getSeaLampV3Info().hashCode();
                    break;
                case 1116:
                    hash7 = (53 * ((37 * hash7) + 1116)) + getFleurFairInfo().hashCode();
                    break;
                case 1122:
                    hash7 = (53 * ((37 * hash7) + 1122)) + getMoonfinTrialInfo().hashCode();
                    break;
                case CHALLNELER_SLAB_INFO_FIELD_NUMBER /* 1135 */:
                    hash7 = (53 * ((37 * hash7) + CHALLNELER_SLAB_INFO_FIELD_NUMBER)) + getChallnelerSlabInfo().hashCode();
                    break;
                case TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1142 */:
                    hash7 = (53 * ((37 * hash7) + TREASURE_SEELIE_INFO_FIELD_NUMBER)) + getTreasureSeelieInfo().hashCode();
                    break;
                case EFFIGY_CHALLENGE_INFO_FIELD_NUMBER /* 1144 */:
                    hash7 = (53 * ((37 * hash7) + EFFIGY_CHALLENGE_INFO_FIELD_NUMBER)) + getEffigyChallengeInfo().hashCode();
                    break;
                case ECHO_SHELL_INFO_FIELD_NUMBER /* 1172 */:
                    hash7 = (53 * ((37 * hash7) + ECHO_SHELL_INFO_FIELD_NUMBER)) + getEchoShellInfo().hashCode();
                    break;
                case GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1173 */:
                    hash7 = (53 * ((37 * hash7) + GRAVEN_INNOCENCE_INFO_FIELD_NUMBER)) + getGravenInnocenceInfo().hashCode();
                    break;
                case GACHA_INFO_FIELD_NUMBER /* 1177 */:
                    hash7 = (53 * ((37 * hash7) + GACHA_INFO_FIELD_NUMBER)) + getGachaInfo().hashCode();
                    break;
                case 1198:
                    hash7 = (53 * ((37 * hash7) + 1198)) + getBlessingInfo().hashCode();
                    break;
                case 1220:
                    hash7 = (53 * ((37 * hash7) + 1220)) + getMusicGameInfo().hashCode();
                    break;
                case ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1273 */:
                    hash7 = (53 * ((37 * hash7) + ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER)) + getRockBoardExploreInfo().hashCode();
                    break;
                case BRICK_BREAKER_INFO_FIELD_NUMBER /* 1275 */:
                    hash7 = (53 * ((37 * hash7) + BRICK_BREAKER_INFO_FIELD_NUMBER)) + getBrickBreakerInfo().hashCode();
                    break;
                case BUOYANT_COMBAT_INFO_FIELD_NUMBER /* 1277 */:
                    hash7 = (53 * ((37 * hash7) + BUOYANT_COMBAT_INFO_FIELD_NUMBER)) + getBuoyantCombatInfo().hashCode();
                    break;
                case 1316:
                    hash7 = (53 * ((37 * hash7) + 1316)) + getVintageInfo().hashCode();
                    break;
                case 1320:
                    hash7 = (53 * ((37 * hash7) + 1320)) + getMistTrialActivityInfo().hashCode();
                    break;
                case MUQADAS_POTION_INFO_FIELD_NUMBER /* 1350 */:
                    hash7 = (53 * ((37 * hash7) + MUQADAS_POTION_INFO_FIELD_NUMBER)) + getMuqadasPotionInfo().hashCode();
                    break;
                case LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER /* 1372 */:
                    hash7 = (53 * ((37 * hash7) + LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER)) + getLanternRiteActivityInfo().hashCode();
                    break;
                case CRYSTAL_LINK_INFO_FIELD_NUMBER /* 1375 */:
                    hash7 = (53 * ((37 * hash7) + CRYSTAL_LINK_INFO_FIELD_NUMBER)) + getCrystalLinkInfo().hashCode();
                    break;
                case SUMO_INFO_FIELD_NUMBER /* 1379 */:
                    hash7 = (53 * ((37 * hash7) + SUMO_INFO_FIELD_NUMBER)) + getSumoInfo().hashCode();
                    break;
                case SPICE_INFO_FIELD_NUMBER /* 1446 */:
                    hash7 = (53 * ((37 * hash7) + SPICE_INFO_FIELD_NUMBER)) + getSpiceInfo().hashCode();
                    break;
                case TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1453 */:
                    hash7 = (53 * ((37 * hash7) + TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER)) + getTanukiTravelActivityInfo().hashCode();
                    break;
                case SUMMER_TIME_INFO_FIELD_NUMBER /* 1477 */:
                    hash7 = (53 * ((37 * hash7) + SUMMER_TIME_INFO_FIELD_NUMBER)) + getSummerTimeInfo().hashCode();
                    break;
                case 1543:
                    hash7 = (53 * ((37 * hash7) + 1543)) + getFungusFighterInfo().hashCode();
                    break;
                case POTION_INFO_FIELD_NUMBER /* 1552 */:
                    hash7 = (53 * ((37 * hash7) + POTION_INFO_FIELD_NUMBER)) + getPotionInfo().hashCode();
                    break;
                case 1631:
                    hash7 = (53 * ((37 * hash7) + 1631)) + getIslandPartyInfo().hashCode();
                    break;
                case WATER_SPIRIT_INFO_FIELD_NUMBER /* 1651 */:
                    hash7 = (53 * ((37 * hash7) + WATER_SPIRIT_INFO_FIELD_NUMBER)) + getWaterSpiritInfo().hashCode();
                    break;
                case 1663:
                    hash7 = (53 * ((37 * hash7) + 1663)) + getHachiInfo().hashCode();
                    break;
                case 1797:
                    hash7 = (53 * ((37 * hash7) + 1797)) + getChessInfo().hashCode();
                    break;
                case GEAR_INFO_FIELD_NUMBER /* 1801 */:
                    hash7 = (53 * ((37 * hash7) + GEAR_INFO_FIELD_NUMBER)) + getGearInfo().hashCode();
                    break;
                case ASTER_INFO_FIELD_NUMBER /* 1808 */:
                    hash7 = (53 * ((37 * hash7) + ASTER_INFO_FIELD_NUMBER)) + getAsterInfo().hashCode();
                    break;
                case ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER /* 1817 */:
                    hash7 = (53 * ((37 * hash7) + ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER)) + getRoguelikeDungoenInfo().hashCode();
                    break;
                case PLANT_FLOWER_INFO_FIELD_NUMBER /* 1864 */:
                    hash7 = (53 * ((37 * hash7) + PLANT_FLOWER_INFO_FIELD_NUMBER)) + getPlantFlowerInfo().hashCode();
                    break;
                case 1991:
                    hash7 = (53 * ((37 * hash7) + 1991)) + getEffigyInfo().hashCode();
                    break;
                case WIND_FIELD_INFO_FIELD_NUMBER /* 2029 */:
                    hash7 = (53 * ((37 * hash7) + WIND_FIELD_INFO_FIELD_NUMBER)) + getWindFieldInfo().hashCode();
                    break;
            }
            int hash8 = (29 * hash7) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash8;
            return hash8;
        }

        public static ActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ActivityInfo parseFrom(InputStream input) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ActivityInfo prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ActivityInfoOrBuilder {
            private Object detail_;
            private int bitField0_;
            private MapField<Integer, Integer> activityCoinMap_;
            private int scoreLimit_;
            private boolean unk3300MDBDPIBEGGH_;
            private boolean unk3300MJNPGEKLOCG_;
            private int endTime_;
            private int activityType_;
            private int selectedAvatarRewardId_;
            private int activityId_;
            private boolean unk3300ABJKLALKLDG_;
            private boolean isFinished_;
            private RepeatedFieldBuilderV3<ActivityPushTipsDataOuterClass.ActivityPushTipsData, ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder, ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> activityPushTipsDataListBuilder_;
            private RepeatedFieldBuilderV3<ActivityWatcherInfoOuterClass.ActivityWatcherInfo, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder, ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> watcherInfoListBuilder_;
            private boolean unk3300CBCEHLJJOGI_;
            private int scheduleId_;
            private boolean unk3300ICNJJKDHPCH_;
            private int firstDayStartTime_;
            private int curScore_;
            private MapField<Integer, Integer> wishGiftNumMap_;
            private boolean unk3300NEPKLLBJFKK_;
            private int beginTime_;
            private SingleFieldBuilderV3<SamLampInfoOuterClass.SamLampInfo, SamLampInfoOuterClass.SamLampInfo.Builder, SamLampInfoOuterClass.SamLampInfoOrBuilder> samLampInfoBuilder_;
            private SingleFieldBuilderV3<CrucibleInfoOuterClass.CrucibleInfo, CrucibleInfoOuterClass.CrucibleInfo.Builder, CrucibleInfoOuterClass.CrucibleInfoOrBuilder> crucibleInfoBuilder_;
            private SingleFieldBuilderV3<SalesmanInfoOuterClass.SalesmanInfo, SalesmanInfoOuterClass.SalesmanInfo.Builder, SalesmanInfoOuterClass.SalesmanInfoOrBuilder> salesmanInfoBuilder_;
            private SingleFieldBuilderV3<TrialAvatarInfoOuterClass.TrialAvatarInfo, TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder, TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder> trialAvatarInfoBuilder_;
            private SingleFieldBuilderV3<DeliveryInfoOuterClass.DeliveryInfo, DeliveryInfoOuterClass.DeliveryInfo.Builder, DeliveryInfoOuterClass.DeliveryInfoOrBuilder> deliveryInfoBuilder_;
            private SingleFieldBuilderV3<AsterInfoOuterClass.AsterInfo, AsterInfoOuterClass.AsterInfo.Builder, AsterInfoOuterClass.AsterInfoOrBuilder> asterInfoBuilder_;
            private SingleFieldBuilderV3<FlightInfoOuterClass.FlightInfo, FlightInfoOuterClass.FlightInfo.Builder, FlightInfoOuterClass.FlightInfoOrBuilder> flightInfoBuilder_;
            private SingleFieldBuilderV3<DragonSpineInfoOuterClass.DragonSpineInfo, DragonSpineInfoOuterClass.DragonSpineInfo.Builder, DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder> dragonSpineInfoBuilder_;
            private SingleFieldBuilderV3<EffigyInfoOuterClass.EffigyInfo, EffigyInfoOuterClass.EffigyInfo.Builder, EffigyInfoOuterClass.EffigyInfoOrBuilder> effigyInfoBuilder_;
            private SingleFieldBuilderV3<TreasureMapInfoOuterClass.TreasureMapInfo, TreasureMapInfoOuterClass.TreasureMapInfo.Builder, TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder> treasureMapInfoBuilder_;
            private SingleFieldBuilderV3<BlessingInfoOuterClass.BlessingInfo, BlessingInfoOuterClass.BlessingInfo.Builder, BlessingInfoOuterClass.BlessingInfoOrBuilder> blessingInfoBuilder_;
            private SingleFieldBuilderV3<SeaLampInfoOuterClass.SeaLampInfo, SeaLampInfoOuterClass.SeaLampInfo.Builder, SeaLampInfoOuterClass.SeaLampInfoOrBuilder> seaLampInfoBuilder_;
            private SingleFieldBuilderV3<ExpeditionInfoOuterClass.ExpeditionInfo, ExpeditionInfoOuterClass.ExpeditionInfo.Builder, ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder> expeditionInfoBuilder_;
            private SingleFieldBuilderV3<ArenaChallengeInfoOuterClass.ArenaChallengeInfo, ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder, ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder> arenaChallengeInfoBuilder_;
            private SingleFieldBuilderV3<FleurFairInfoOuterClass.FleurFairInfo, FleurFairInfoOuterClass.FleurFairInfo.Builder, FleurFairInfoOuterClass.FleurFairInfoOrBuilder> fleurFairInfoBuilder_;
            private SingleFieldBuilderV3<WaterSpiritInfoOuterClass.WaterSpiritInfo, WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder, WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder> waterSpiritInfoBuilder_;
            private SingleFieldBuilderV3<ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo, ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.Builder, ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder> challnelerSlabInfoBuilder_;
            private SingleFieldBuilderV3<MistTrialActivityInfoOuterClass.MistTrialActivityInfo, MistTrialActivityInfoOuterClass.MistTrialActivityInfo.Builder, MistTrialActivityInfoOuterClass.MistTrialActivityInfoOrBuilder> mistTrialActivityInfoBuilder_;
            private SingleFieldBuilderV3<HideAndSeekInfoOuterClass.HideAndSeekInfo, HideAndSeekInfoOuterClass.HideAndSeekInfo.Builder, HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder> hideAndSeekInfoBuilder_;
            private SingleFieldBuilderV3<FindHilichurlInfoOuterClass.FindHilichurlInfo, FindHilichurlInfoOuterClass.FindHilichurlInfo.Builder, FindHilichurlInfoOuterClass.FindHilichurlInfoOrBuilder> findHilichurlInfoBuilder_;
            private SingleFieldBuilderV3<SummerTimeInfoOuterClass.SummerTimeInfo, SummerTimeInfoOuterClass.SummerTimeInfo.Builder, SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder> summerTimeInfoBuilder_;
            private SingleFieldBuilderV3<BuoyantCombatInfoOuterClass.BuoyantCombatInfo, BuoyantCombatInfoOuterClass.BuoyantCombatInfo.Builder, BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder> buoyantCombatInfoBuilder_;
            private SingleFieldBuilderV3<EchoShellInfoOuterClass.EchoShellInfo, EchoShellInfoOuterClass.EchoShellInfo.Builder, EchoShellInfoOuterClass.EchoShellInfoOrBuilder> echoShellInfoBuilder_;
            private SingleFieldBuilderV3<BounceConjuringInfoOuterClass.BounceConjuringInfo, BounceConjuringInfoOuterClass.BounceConjuringInfo.Builder, BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder> bounceConjuringInfoBuilder_;
            private SingleFieldBuilderV3<BlitzRushInfoOuterClass.BlitzRushInfo, BlitzRushInfoOuterClass.BlitzRushInfo.Builder, BlitzRushInfoOuterClass.BlitzRushInfoOrBuilder> blitzRushInfoBuilder_;
            private SingleFieldBuilderV3<ChessInfoOuterClass.ChessInfo, ChessInfoOuterClass.ChessInfo.Builder, ChessInfoOuterClass.ChessInfoOrBuilder> chessInfoBuilder_;
            private SingleFieldBuilderV3<SumoInfoOuterClass.SumoInfo, SumoInfoOuterClass.SumoInfo.Builder, SumoInfoOuterClass.SumoInfoOrBuilder> sumoInfoBuilder_;
            private SingleFieldBuilderV3<MoonfinTrialInfoOuterClass.MoonfinTrialInfo, MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder, MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder> moonfinTrialInfoBuilder_;
            private SingleFieldBuilderV3<LunaRiteInfoOuterClass.LunaRiteInfo, LunaRiteInfoOuterClass.LunaRiteInfo.Builder, LunaRiteInfoOuterClass.LunaRiteInfoOrBuilder> lunaRiteInfoBuilder_;
            private SingleFieldBuilderV3<PlantFlowerInfoOuterClass.PlantFlowerInfo, PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder, PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder> plantFlowerInfoBuilder_;
            private SingleFieldBuilderV3<MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder> musicGameInfoBuilder_;
            private SingleFieldBuilderV3<RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo, RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.Builder, RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder> roguelikeDungoenInfoBuilder_;
            private SingleFieldBuilderV3<DigInfoOuterClass.DigInfo, DigInfoOuterClass.DigInfo.Builder, DigInfoOuterClass.DigInfoOrBuilder> digInfoBuilder_;
            private SingleFieldBuilderV3<HachiInfoOuterClass.HachiInfo, HachiInfoOuterClass.HachiInfo.Builder, HachiInfoOuterClass.HachiInfoOrBuilder> hachiInfoBuilder_;
            private SingleFieldBuilderV3<WinterCampInfoOuterClass.WinterCampInfo, WinterCampInfoOuterClass.WinterCampInfo.Builder, WinterCampInfoOuterClass.WinterCampInfoOrBuilder> winterCampInfoBuilder_;
            private SingleFieldBuilderV3<PotionInfoOuterClass.PotionInfo, PotionInfoOuterClass.PotionInfo.Builder, PotionInfoOuterClass.PotionInfoOrBuilder> potionInfoBuilder_;
            private SingleFieldBuilderV3<TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo, TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.Builder, TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder> tanukiTravelActivityInfoBuilder_;
            private SingleFieldBuilderV3<LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo, LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.Builder, LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder> lanternRiteActivityInfoBuilder_;
            private SingleFieldBuilderV3<MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo, MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.Builder, MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder> michiaeMatsuriInfoBuilder_;
            private SingleFieldBuilderV3<BartenderInfoOuterClass.BartenderInfo, BartenderInfoOuterClass.BartenderInfo.Builder, BartenderInfoOuterClass.BartenderInfoOrBuilder> bartenderInfoBuilder_;
            private SingleFieldBuilderV3<UgcInfoOuterClass.UgcInfo, UgcInfoOuterClass.UgcInfo.Builder, UgcInfoOuterClass.UgcInfoOrBuilder> ugcInfoBuilder_;
            private SingleFieldBuilderV3<CrystalLinkInfoOuterClass.CrystalLinkInfo, CrystalLinkInfoOuterClass.CrystalLinkInfo.Builder, CrystalLinkInfoOuterClass.CrystalLinkInfoOrBuilder> crystalLinkInfoBuilder_;
            private SingleFieldBuilderV3<IrodoriInfoOuterClass.IrodoriInfo, IrodoriInfoOuterClass.IrodoriInfo.Builder, IrodoriInfoOuterClass.IrodoriInfoOrBuilder> irodoriInfoBuilder_;
            private SingleFieldBuilderV3<PhotoInfoOuterClass.PhotoInfo, PhotoInfoOuterClass.PhotoInfo.Builder, PhotoInfoOuterClass.PhotoInfoOrBuilder> photoInfoBuilder_;
            private SingleFieldBuilderV3<SpiceInfoOuterClass.SpiceInfo, SpiceInfoOuterClass.SpiceInfo.Builder, SpiceInfoOuterClass.SpiceInfoOrBuilder> spiceInfoBuilder_;
            private SingleFieldBuilderV3<GachaInfoOuterClass.GachaInfo, GachaInfoOuterClass.GachaInfo.Builder, GachaInfoOuterClass.GachaInfoOrBuilder> gachaInfoBuilder_;
            private SingleFieldBuilderV3<LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo, LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.Builder, LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder> luminanceStoneChallengeInfoBuilder_;
            private SingleFieldBuilderV3<RogueDiaryInfoOuterClass.RogueDiaryInfo, RogueDiaryInfoOuterClass.RogueDiaryInfo.Builder, RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder> rogueDiaryInfoBuilder_;
            private SingleFieldBuilderV3<SummerTimeV2InfoOuterClass.SummerTimeV2Info, SummerTimeV2InfoOuterClass.SummerTimeV2Info.Builder, SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder> summerTimeV2InfoBuilder_;
            private SingleFieldBuilderV3<IslandPartyInfoOuterClass.IslandPartyInfo, IslandPartyInfoOuterClass.IslandPartyInfo.Builder, IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder> islandPartyInfoBuilder_;
            private SingleFieldBuilderV3<GearInfoOuterClass.GearInfo, GearInfoOuterClass.GearInfo.Builder, GearInfoOuterClass.GearInfoOrBuilder> gearInfoBuilder_;
            private SingleFieldBuilderV3<GravenInnocenceInfoOuterClass.GravenInnocenceInfo, GravenInnocenceInfoOuterClass.GravenInnocenceInfo.Builder, GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder> gravenInnocenceInfoBuilder_;
            private SingleFieldBuilderV3<InstableSprayInfoOuterClass.InstableSprayInfo, InstableSprayInfoOuterClass.InstableSprayInfo.Builder, InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder> instableSprayInfoBuilder_;
            private SingleFieldBuilderV3<MuqadasPotionInfoOuterClass.MuqadasPotionInfo, MuqadasPotionInfoOuterClass.MuqadasPotionInfo.Builder, MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder> muqadasPotionInfoBuilder_;
            private SingleFieldBuilderV3<TreasureSeelieInfoOuterClass.TreasureSeelieInfo, TreasureSeelieInfoOuterClass.TreasureSeelieInfo.Builder, TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder> treasureSeelieInfoBuilder_;
            private SingleFieldBuilderV3<RockBoardExploreInfoOuterClass.RockBoardExploreInfo, RockBoardExploreInfoOuterClass.RockBoardExploreInfo.Builder, RockBoardExploreInfoOuterClass.RockBoardExploreInfoOrBuilder> rockBoardExploreInfoBuilder_;
            private SingleFieldBuilderV3<VintageInfoOuterClass.VintageInfo, VintageInfoOuterClass.VintageInfo.Builder, VintageInfoOuterClass.VintageInfoOrBuilder> vintageInfoBuilder_;
            private SingleFieldBuilderV3<WindFieldInfoOuterClass.WindFieldInfo, WindFieldInfoOuterClass.WindFieldInfo.Builder, WindFieldInfoOuterClass.WindFieldInfoOrBuilder> windFieldInfoBuilder_;
            private SingleFieldBuilderV3<FungusFighterInfoOuterClass.FungusFighterInfo, FungusFighterInfoOuterClass.FungusFighterInfo.Builder, FungusFighterInfoOuterClass.FungusFighterInfoOrBuilder> fungusFighterInfoBuilder_;
            private SingleFieldBuilderV3<CharAmusementInfoOuterClass.CharAmusementInfo, CharAmusementInfoOuterClass.CharAmusementInfo.Builder, CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder> charAmusementInfoBuilder_;
            private SingleFieldBuilderV3<EffigyChallengeInfoOuterClass.EffigyChallengeInfo, EffigyChallengeInfoOuterClass.EffigyChallengeInfo.Builder, EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder> effigyChallengeInfoBuilder_;
            private SingleFieldBuilderV3<CoinCollectInfoOuterClass.CoinCollectInfo, CoinCollectInfoOuterClass.CoinCollectInfo.Builder, CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder> coinCollectInfoBuilder_;
            private SingleFieldBuilderV3<BrickBreakerInfoOuterClass.BrickBreakerInfo, BrickBreakerInfoOuterClass.BrickBreakerInfo.Builder, BrickBreakerInfoOuterClass.BrickBreakerInfoOrBuilder> brickBreakerInfoBuilder_;
            private SingleFieldBuilderV3<DuelHeartInfoOuterClass.DuelHeartInfo, DuelHeartInfoOuterClass.DuelHeartInfo.Builder, DuelHeartInfoOuterClass.DuelHeartInfoOrBuilder> duelHeartInfoBuilder_;
            private SingleFieldBuilderV3<SeaLampV3InfoOuterClass.SeaLampV3Info, SeaLampV3InfoOuterClass.SeaLampV3Info.Builder, SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder> seaLampV3InfoBuilder_;
            private SingleFieldBuilderV3<TeamChainInfoOuterClass.TeamChainInfo, TeamChainInfoOuterClass.TeamChainInfo.Builder, TeamChainInfoOuterClass.TeamChainInfoOrBuilder> teamChainInfoBuilder_;
            private SingleFieldBuilderV3<GcgFestivalInfoOuterClass.GcgFestivalInfo, GcgFestivalInfoOuterClass.GcgFestivalInfo.Builder, GcgFestivalInfoOuterClass.GcgFestivalInfoOrBuilder> gcgFestivalInfoBuilder_;
            private int detailCase_ = 0;
            private Internal.IntList takenRewardList_ = ActivityInfo.emptyIntList();
            private Internal.IntList meetCondList_ = ActivityInfo.emptyIntList();
            private List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> activityPushTipsDataList_ = Collections.emptyList();
            private List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> watcherInfoList_ = Collections.emptyList();
            private Internal.IntList expireCondList_ = ActivityInfo.emptyIntList();
            private Internal.IntList fdjefldhela_ = ActivityInfo.emptyIntList();

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 406: goto L_0x001c;
                        case 1052: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetActivityCoinMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetWishGiftNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.Builder.internalGetMapField(int):com.google.protobuf.MapField");
            }

            /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 406: goto L_0x001c;
                        case 1052: goto L_0x0021;
                        default: goto L_0x0026;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableActivityCoinMap()
                    return r0
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetMutableWishGiftNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfo.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
            }

            public static final Descriptors.Descriptor getDescriptor() {
                return ActivityInfoOuterClass.internal_static_ActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ActivityInfoOuterClass.internal_static_ActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ActivityInfo.alwaysUseFieldBuilders) {
                    getActivityPushTipsDataListFieldBuilder();
                    getWatcherInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                internalGetMutableActivityCoinMap().clear();
                this.scoreLimit_ = 0;
                this.takenRewardList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unk3300MDBDPIBEGGH_ = false;
                this.unk3300MJNPGEKLOCG_ = false;
                this.endTime_ = 0;
                this.activityType_ = 0;
                this.selectedAvatarRewardId_ = 0;
                this.meetCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -5;
                this.activityId_ = 0;
                this.unk3300ABJKLALKLDG_ = false;
                this.isFinished_ = false;
                if (this.activityPushTipsDataListBuilder_ == null) {
                    this.activityPushTipsDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.activityPushTipsDataListBuilder_.clear();
                }
                if (this.watcherInfoListBuilder_ == null) {
                    this.watcherInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.watcherInfoListBuilder_.clear();
                }
                this.unk3300CBCEHLJJOGI_ = false;
                this.scheduleId_ = 0;
                this.expireCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -33;
                this.fdjefldhela_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -65;
                this.unk3300ICNJJKDHPCH_ = false;
                this.firstDayStartTime_ = 0;
                this.curScore_ = 0;
                internalGetMutableWishGiftNumMap().clear();
                this.unk3300NEPKLLBJFKK_ = false;
                this.beginTime_ = 0;
                this.detailCase_ = 0;
                this.detail_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ActivityInfoOuterClass.internal_static_ActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ActivityInfo getDefaultInstanceForType() {
                return ActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityInfo build() {
                ActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ActivityInfo buildPartial() {
                ActivityInfo result = new ActivityInfo(this);
                int i = this.bitField0_;
                result.activityCoinMap_ = internalGetActivityCoinMap();
                result.activityCoinMap_.makeImmutable();
                result.scoreLimit_ = this.scoreLimit_;
                if ((this.bitField0_ & 2) != 0) {
                    this.takenRewardList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.takenRewardList_ = this.takenRewardList_;
                result.unk3300MDBDPIBEGGH_ = this.unk3300MDBDPIBEGGH_;
                result.unk3300MJNPGEKLOCG_ = this.unk3300MJNPGEKLOCG_;
                result.endTime_ = this.endTime_;
                result.activityType_ = this.activityType_;
                result.selectedAvatarRewardId_ = this.selectedAvatarRewardId_;
                if ((this.bitField0_ & 4) != 0) {
                    this.meetCondList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.meetCondList_ = this.meetCondList_;
                result.activityId_ = this.activityId_;
                result.unk3300ABJKLALKLDG_ = this.unk3300ABJKLALKLDG_;
                result.isFinished_ = this.isFinished_;
                if (this.activityPushTipsDataListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.activityPushTipsDataList_ = Collections.unmodifiableList(this.activityPushTipsDataList_);
                        this.bitField0_ &= -9;
                    }
                    result.activityPushTipsDataList_ = this.activityPushTipsDataList_;
                } else {
                    result.activityPushTipsDataList_ = this.activityPushTipsDataListBuilder_.build();
                }
                if (this.watcherInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.watcherInfoList_ = Collections.unmodifiableList(this.watcherInfoList_);
                        this.bitField0_ &= -17;
                    }
                    result.watcherInfoList_ = this.watcherInfoList_;
                } else {
                    result.watcherInfoList_ = this.watcherInfoListBuilder_.build();
                }
                result.unk3300CBCEHLJJOGI_ = this.unk3300CBCEHLJJOGI_;
                result.scheduleId_ = this.scheduleId_;
                if ((this.bitField0_ & 32) != 0) {
                    this.expireCondList_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                result.expireCondList_ = this.expireCondList_;
                if ((this.bitField0_ & 64) != 0) {
                    this.fdjefldhela_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.fdjefldhela_ = this.fdjefldhela_;
                result.unk3300ICNJJKDHPCH_ = this.unk3300ICNJJKDHPCH_;
                result.firstDayStartTime_ = this.firstDayStartTime_;
                result.curScore_ = this.curScore_;
                result.wishGiftNumMap_ = internalGetWishGiftNumMap();
                result.wishGiftNumMap_.makeImmutable();
                result.unk3300NEPKLLBJFKK_ = this.unk3300NEPKLLBJFKK_;
                result.beginTime_ = this.beginTime_;
                if (this.detailCase_ == 4) {
                    if (this.samLampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.samLampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 13) {
                    if (this.crucibleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.crucibleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1) {
                    if (this.salesmanInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.salesmanInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 8) {
                    if (this.trialAvatarInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.trialAvatarInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 32) {
                    if (this.deliveryInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.deliveryInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1808) {
                    if (this.asterInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.asterInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1062) {
                    if (this.flightInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.flightInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 378) {
                    if (this.dragonSpineInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.dragonSpineInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1991) {
                    if (this.effigyInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 546) {
                    if (this.treasureMapInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.treasureMapInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1198) {
                    if (this.blessingInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.blessingInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 578) {
                    if (this.seaLampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.seaLampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 930) {
                    if (this.expeditionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.expeditionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 699) {
                    if (this.arenaChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.arenaChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1116) {
                    if (this.fleurFairInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fleurFairInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1651) {
                    if (this.waterSpiritInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.waterSpiritInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1135) {
                    if (this.challnelerSlabInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.challnelerSlabInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1320) {
                    if (this.mistTrialActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.mistTrialActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1077) {
                    if (this.hideAndSeekInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.hideAndSeekInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 417) {
                    if (this.findHilichurlInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.findHilichurlInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1477) {
                    if (this.summerTimeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.summerTimeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1277) {
                    if (this.buoyantCombatInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.buoyantCombatInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1172) {
                    if (this.echoShellInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.echoShellInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 278) {
                    if (this.bounceConjuringInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bounceConjuringInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 192) {
                    if (this.blitzRushInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.blitzRushInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1797) {
                    if (this.chessInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.chessInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1379) {
                    if (this.sumoInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.sumoInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1122) {
                    if (this.moonfinTrialInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.moonfinTrialInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 82) {
                    if (this.lunaRiteInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.lunaRiteInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1864) {
                    if (this.plantFlowerInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.plantFlowerInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1220) {
                    if (this.musicGameInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.musicGameInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1817) {
                    if (this.roguelikeDungoenInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.roguelikeDungoenInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 168) {
                    if (this.digInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.digInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1663) {
                    if (this.hachiInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.hachiInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 114) {
                    if (this.winterCampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.winterCampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1552) {
                    if (this.potionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.potionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1453) {
                    if (this.tanukiTravelActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.tanukiTravelActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1372) {
                    if (this.lanternRiteActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.lanternRiteActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 428) {
                    if (this.michiaeMatsuriInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.michiaeMatsuriInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 35) {
                    if (this.bartenderInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bartenderInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 589) {
                    if (this.ugcInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.ugcInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1375) {
                    if (this.crystalLinkInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.crystalLinkInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1014) {
                    if (this.irodoriInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.irodoriInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 309) {
                    if (this.photoInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.photoInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1446) {
                    if (this.spiceInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.spiceInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1177) {
                    if (this.gachaInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gachaInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 142) {
                    if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.luminanceStoneChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 397) {
                    if (this.rogueDiaryInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.rogueDiaryInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 951) {
                    if (this.summerTimeV2InfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.summerTimeV2InfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1631) {
                    if (this.islandPartyInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.islandPartyInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1801) {
                    if (this.gearInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gearInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1173) {
                    if (this.gravenInnocenceInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gravenInnocenceInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 944) {
                    if (this.instableSprayInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.instableSprayInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1350) {
                    if (this.muqadasPotionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.muqadasPotionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1142) {
                    if (this.treasureSeelieInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.treasureSeelieInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1273) {
                    if (this.rockBoardExploreInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.rockBoardExploreInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1316) {
                    if (this.vintageInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.vintageInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 2029) {
                    if (this.windFieldInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.windFieldInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1543) {
                    if (this.fungusFighterInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fungusFighterInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 504) {
                    if (this.charAmusementInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.charAmusementInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1144) {
                    if (this.effigyChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 559) {
                    if (this.coinCollectInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.coinCollectInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1275) {
                    if (this.brickBreakerInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.brickBreakerInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 221) {
                    if (this.duelHeartInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.duelHeartInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1080) {
                    if (this.seaLampV3InfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.seaLampV3InfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 144) {
                    if (this.teamChainInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.teamChainInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 71) {
                    if (this.gcgFestivalInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gcgFestivalInfoBuilder_.build();
                    }
                }
                result.detailCase_ = this.detailCase_;
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof ActivityInfo) {
                    return mergeFrom((ActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ActivityInfo other) {
                if (other == ActivityInfo.getDefaultInstance()) {
                    return this;
                }
                internalGetMutableActivityCoinMap().mergeFrom(other.internalGetActivityCoinMap());
                if (other.getScoreLimit() != 0) {
                    setScoreLimit(other.getScoreLimit());
                }
                if (!other.takenRewardList_.isEmpty()) {
                    if (this.takenRewardList_.isEmpty()) {
                        this.takenRewardList_ = other.takenRewardList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTakenRewardListIsMutable();
                        this.takenRewardList_.addAll(other.takenRewardList_);
                    }
                    onChanged();
                }
                if (other.getUnk3300MDBDPIBEGGH()) {
                    setUnk3300MDBDPIBEGGH(other.getUnk3300MDBDPIBEGGH());
                }
                if (other.getUnk3300MJNPGEKLOCG()) {
                    setUnk3300MJNPGEKLOCG(other.getUnk3300MJNPGEKLOCG());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getActivityType() != 0) {
                    setActivityType(other.getActivityType());
                }
                if (other.getSelectedAvatarRewardId() != 0) {
                    setSelectedAvatarRewardId(other.getSelectedAvatarRewardId());
                }
                if (!other.meetCondList_.isEmpty()) {
                    if (this.meetCondList_.isEmpty()) {
                        this.meetCondList_ = other.meetCondList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureMeetCondListIsMutable();
                        this.meetCondList_.addAll(other.meetCondList_);
                    }
                    onChanged();
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
                }
                if (other.getUnk3300ABJKLALKLDG()) {
                    setUnk3300ABJKLALKLDG(other.getUnk3300ABJKLALKLDG());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (this.activityPushTipsDataListBuilder_ == null) {
                    if (!other.activityPushTipsDataList_.isEmpty()) {
                        if (this.activityPushTipsDataList_.isEmpty()) {
                            this.activityPushTipsDataList_ = other.activityPushTipsDataList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureActivityPushTipsDataListIsMutable();
                            this.activityPushTipsDataList_.addAll(other.activityPushTipsDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.activityPushTipsDataList_.isEmpty()) {
                    if (this.activityPushTipsDataListBuilder_.isEmpty()) {
                        this.activityPushTipsDataListBuilder_.dispose();
                        this.activityPushTipsDataListBuilder_ = null;
                        this.activityPushTipsDataList_ = other.activityPushTipsDataList_;
                        this.bitField0_ &= -9;
                        this.activityPushTipsDataListBuilder_ = ActivityInfo.alwaysUseFieldBuilders ? getActivityPushTipsDataListFieldBuilder() : null;
                    } else {
                        this.activityPushTipsDataListBuilder_.addAllMessages(other.activityPushTipsDataList_);
                    }
                }
                if (this.watcherInfoListBuilder_ == null) {
                    if (!other.watcherInfoList_.isEmpty()) {
                        if (this.watcherInfoList_.isEmpty()) {
                            this.watcherInfoList_ = other.watcherInfoList_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureWatcherInfoListIsMutable();
                            this.watcherInfoList_.addAll(other.watcherInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.watcherInfoList_.isEmpty()) {
                    if (this.watcherInfoListBuilder_.isEmpty()) {
                        this.watcherInfoListBuilder_.dispose();
                        this.watcherInfoListBuilder_ = null;
                        this.watcherInfoList_ = other.watcherInfoList_;
                        this.bitField0_ &= -17;
                        this.watcherInfoListBuilder_ = ActivityInfo.alwaysUseFieldBuilders ? getWatcherInfoListFieldBuilder() : null;
                    } else {
                        this.watcherInfoListBuilder_.addAllMessages(other.watcherInfoList_);
                    }
                }
                if (other.getUnk3300CBCEHLJJOGI()) {
                    setUnk3300CBCEHLJJOGI(other.getUnk3300CBCEHLJJOGI());
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (!other.expireCondList_.isEmpty()) {
                    if (this.expireCondList_.isEmpty()) {
                        this.expireCondList_ = other.expireCondList_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureExpireCondListIsMutable();
                        this.expireCondList_.addAll(other.expireCondList_);
                    }
                    onChanged();
                }
                if (!other.fdjefldhela_.isEmpty()) {
                    if (this.fdjefldhela_.isEmpty()) {
                        this.fdjefldhela_ = other.fdjefldhela_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureFdjefldhelaIsMutable();
                        this.fdjefldhela_.addAll(other.fdjefldhela_);
                    }
                    onChanged();
                }
                if (other.getUnk3300ICNJJKDHPCH()) {
                    setUnk3300ICNJJKDHPCH(other.getUnk3300ICNJJKDHPCH());
                }
                if (other.getFirstDayStartTime() != 0) {
                    setFirstDayStartTime(other.getFirstDayStartTime());
                }
                if (other.getCurScore() != 0) {
                    setCurScore(other.getCurScore());
                }
                internalGetMutableWishGiftNumMap().mergeFrom(other.internalGetWishGiftNumMap());
                if (other.getUnk3300NEPKLLBJFKK()) {
                    setUnk3300NEPKLLBJFKK(other.getUnk3300NEPKLLBJFKK());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                switch (other.getDetailCase()) {
                    case SAM_LAMP_INFO:
                        mergeSamLampInfo(other.getSamLampInfo());
                        break;
                    case CRUCIBLE_INFO:
                        mergeCrucibleInfo(other.getCrucibleInfo());
                        break;
                    case SALESMAN_INFO:
                        mergeSalesmanInfo(other.getSalesmanInfo());
                        break;
                    case TRIAL_AVATAR_INFO:
                        mergeTrialAvatarInfo(other.getTrialAvatarInfo());
                        break;
                    case DELIVERY_INFO:
                        mergeDeliveryInfo(other.getDeliveryInfo());
                        break;
                    case ASTER_INFO:
                        mergeAsterInfo(other.getAsterInfo());
                        break;
                    case FLIGHT_INFO:
                        mergeFlightInfo(other.getFlightInfo());
                        break;
                    case DRAGON_SPINE_INFO:
                        mergeDragonSpineInfo(other.getDragonSpineInfo());
                        break;
                    case EFFIGY_INFO:
                        mergeEffigyInfo(other.getEffigyInfo());
                        break;
                    case TREASURE_MAP_INFO:
                        mergeTreasureMapInfo(other.getTreasureMapInfo());
                        break;
                    case BLESSING_INFO:
                        mergeBlessingInfo(other.getBlessingInfo());
                        break;
                    case SEA_LAMP_INFO:
                        mergeSeaLampInfo(other.getSeaLampInfo());
                        break;
                    case EXPEDITION_INFO:
                        mergeExpeditionInfo(other.getExpeditionInfo());
                        break;
                    case ARENA_CHALLENGE_INFO:
                        mergeArenaChallengeInfo(other.getArenaChallengeInfo());
                        break;
                    case FLEUR_FAIR_INFO:
                        mergeFleurFairInfo(other.getFleurFairInfo());
                        break;
                    case WATER_SPIRIT_INFO:
                        mergeWaterSpiritInfo(other.getWaterSpiritInfo());
                        break;
                    case CHALLNELER_SLAB_INFO:
                        mergeChallnelerSlabInfo(other.getChallnelerSlabInfo());
                        break;
                    case MIST_TRIAL_ACTIVITY_INFO:
                        mergeMistTrialActivityInfo(other.getMistTrialActivityInfo());
                        break;
                    case HIDE_AND_SEEK_INFO:
                        mergeHideAndSeekInfo(other.getHideAndSeekInfo());
                        break;
                    case FIND_HILICHURL_INFO:
                        mergeFindHilichurlInfo(other.getFindHilichurlInfo());
                        break;
                    case SUMMER_TIME_INFO:
                        mergeSummerTimeInfo(other.getSummerTimeInfo());
                        break;
                    case BUOYANT_COMBAT_INFO:
                        mergeBuoyantCombatInfo(other.getBuoyantCombatInfo());
                        break;
                    case ECHO_SHELL_INFO:
                        mergeEchoShellInfo(other.getEchoShellInfo());
                        break;
                    case BOUNCE_CONJURING_INFO:
                        mergeBounceConjuringInfo(other.getBounceConjuringInfo());
                        break;
                    case BLITZ_RUSH_INFO:
                        mergeBlitzRushInfo(other.getBlitzRushInfo());
                        break;
                    case CHESS_INFO:
                        mergeChessInfo(other.getChessInfo());
                        break;
                    case SUMO_INFO:
                        mergeSumoInfo(other.getSumoInfo());
                        break;
                    case MOONFIN_TRIAL_INFO:
                        mergeMoonfinTrialInfo(other.getMoonfinTrialInfo());
                        break;
                    case LUNA_RITE_INFO:
                        mergeLunaRiteInfo(other.getLunaRiteInfo());
                        break;
                    case PLANT_FLOWER_INFO:
                        mergePlantFlowerInfo(other.getPlantFlowerInfo());
                        break;
                    case MUSIC_GAME_INFO:
                        mergeMusicGameInfo(other.getMusicGameInfo());
                        break;
                    case ROGUELIKE_DUNGOEN_INFO:
                        mergeRoguelikeDungoenInfo(other.getRoguelikeDungoenInfo());
                        break;
                    case DIG_INFO:
                        mergeDigInfo(other.getDigInfo());
                        break;
                    case HACHI_INFO:
                        mergeHachiInfo(other.getHachiInfo());
                        break;
                    case WINTER_CAMP_INFO:
                        mergeWinterCampInfo(other.getWinterCampInfo());
                        break;
                    case POTION_INFO:
                        mergePotionInfo(other.getPotionInfo());
                        break;
                    case TANUKI_TRAVEL_ACTIVITY_INFO:
                        mergeTanukiTravelActivityInfo(other.getTanukiTravelActivityInfo());
                        break;
                    case LANTERN_RITE_ACTIVITY_INFO:
                        mergeLanternRiteActivityInfo(other.getLanternRiteActivityInfo());
                        break;
                    case MICHIAE_MATSURI_INFO:
                        mergeMichiaeMatsuriInfo(other.getMichiaeMatsuriInfo());
                        break;
                    case BARTENDER_INFO:
                        mergeBartenderInfo(other.getBartenderInfo());
                        break;
                    case UGC_INFO:
                        mergeUgcInfo(other.getUgcInfo());
                        break;
                    case CRYSTAL_LINK_INFO:
                        mergeCrystalLinkInfo(other.getCrystalLinkInfo());
                        break;
                    case IRODORI_INFO:
                        mergeIrodoriInfo(other.getIrodoriInfo());
                        break;
                    case PHOTO_INFO:
                        mergePhotoInfo(other.getPhotoInfo());
                        break;
                    case SPICE_INFO:
                        mergeSpiceInfo(other.getSpiceInfo());
                        break;
                    case GACHA_INFO:
                        mergeGachaInfo(other.getGachaInfo());
                        break;
                    case LUMINANCE_STONE_CHALLENGE_INFO:
                        mergeLuminanceStoneChallengeInfo(other.getLuminanceStoneChallengeInfo());
                        break;
                    case ROGUE_DIARY_INFO:
                        mergeRogueDiaryInfo(other.getRogueDiaryInfo());
                        break;
                    case SUMMER_TIME_V2INFO:
                        mergeSummerTimeV2Info(other.getSummerTimeV2Info());
                        break;
                    case ISLAND_PARTY_INFO:
                        mergeIslandPartyInfo(other.getIslandPartyInfo());
                        break;
                    case GEAR_INFO:
                        mergeGearInfo(other.getGearInfo());
                        break;
                    case GRAVEN_INNOCENCE_INFO:
                        mergeGravenInnocenceInfo(other.getGravenInnocenceInfo());
                        break;
                    case INSTABLE_SPRAY_INFO:
                        mergeInstableSprayInfo(other.getInstableSprayInfo());
                        break;
                    case MUQADAS_POTION_INFO:
                        mergeMuqadasPotionInfo(other.getMuqadasPotionInfo());
                        break;
                    case TREASURE_SEELIE_INFO:
                        mergeTreasureSeelieInfo(other.getTreasureSeelieInfo());
                        break;
                    case ROCK_BOARD_EXPLORE_INFO:
                        mergeRockBoardExploreInfo(other.getRockBoardExploreInfo());
                        break;
                    case VINTAGE_INFO:
                        mergeVintageInfo(other.getVintageInfo());
                        break;
                    case WIND_FIELD_INFO:
                        mergeWindFieldInfo(other.getWindFieldInfo());
                        break;
                    case FUNGUS_FIGHTER_INFO:
                        mergeFungusFighterInfo(other.getFungusFighterInfo());
                        break;
                    case CHAR_AMUSEMENT_INFO:
                        mergeCharAmusementInfo(other.getCharAmusementInfo());
                        break;
                    case EFFIGY_CHALLENGE_INFO:
                        mergeEffigyChallengeInfo(other.getEffigyChallengeInfo());
                        break;
                    case COIN_COLLECT_INFO:
                        mergeCoinCollectInfo(other.getCoinCollectInfo());
                        break;
                    case BRICK_BREAKER_INFO:
                        mergeBrickBreakerInfo(other.getBrickBreakerInfo());
                        break;
                    case DUEL_HEART_INFO:
                        mergeDuelHeartInfo(other.getDuelHeartInfo());
                        break;
                    case SEA_LAMP_V3INFO:
                        mergeSeaLampV3Info(other.getSeaLampV3Info());
                        break;
                    case TEAM_CHAIN_INFO:
                        mergeTeamChainInfo(other.getTeamChainInfo());
                        break;
                    case GCG_FESTIVAL_INFO:
                        mergeGcgFestivalInfo(other.getGcgFestivalInfo());
                        break;
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                ActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DetailCase getDetailCase() {
                return DetailCase.forNumber(this.detailCase_);
            }

            public Builder clearDetail() {
                this.detailCase_ = 0;
                this.detail_ = null;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetActivityCoinMap() {
                if (this.activityCoinMap_ == null) {
                    return MapField.emptyMapField(ActivityCoinMapDefaultEntryHolder.defaultEntry);
                }
                return this.activityCoinMap_;
            }

            private MapField<Integer, Integer> internalGetMutableActivityCoinMap() {
                onChanged();
                if (this.activityCoinMap_ == null) {
                    this.activityCoinMap_ = MapField.newMapField(ActivityCoinMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.activityCoinMap_.isMutable()) {
                    this.activityCoinMap_ = this.activityCoinMap_.copy();
                }
                return this.activityCoinMap_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityCoinMapCount() {
                return internalGetActivityCoinMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean containsActivityCoinMap(int key) {
                return internalGetActivityCoinMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getActivityCoinMap() {
                return getActivityCoinMapMap();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public Map<Integer, Integer> getActivityCoinMapMap() {
                return internalGetActivityCoinMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityCoinMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetActivityCoinMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityCoinMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetActivityCoinMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearActivityCoinMap() {
                internalGetMutableActivityCoinMap().getMutableMap().clear();
                return this;
            }

            public Builder removeActivityCoinMap(int key) {
                internalGetMutableActivityCoinMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableActivityCoinMap() {
                return internalGetMutableActivityCoinMap().getMutableMap();
            }

            public Builder putActivityCoinMap(int key, int value) {
                internalGetMutableActivityCoinMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllActivityCoinMap(Map<Integer, Integer> values) {
                internalGetMutableActivityCoinMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getScoreLimit() {
                return this.scoreLimit_;
            }

            public Builder setScoreLimit(int value) {
                this.scoreLimit_ = value;
                onChanged();
                return this;
            }

            public Builder clearScoreLimit() {
                this.scoreLimit_ = 0;
                onChanged();
                return this;
            }

            private void ensureTakenRewardListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.takenRewardList_ = ActivityInfo.mutableCopy(this.takenRewardList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getTakenRewardListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.takenRewardList_) : this.takenRewardList_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getTakenRewardListCount() {
                return this.takenRewardList_.size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getTakenRewardList(int index) {
                return this.takenRewardList_.getInt(index);
            }

            public Builder setTakenRewardList(int index, int value) {
                ensureTakenRewardListIsMutable();
                this.takenRewardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTakenRewardList(int value) {
                ensureTakenRewardListIsMutable();
                this.takenRewardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTakenRewardList(Iterable<? extends Integer> values) {
                ensureTakenRewardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takenRewardList_);
                onChanged();
                return this;
            }

            public Builder clearTakenRewardList() {
                this.takenRewardList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300MDBDPIBEGGH() {
                return this.unk3300MDBDPIBEGGH_;
            }

            public Builder setUnk3300MDBDPIBEGGH(boolean value) {
                this.unk3300MDBDPIBEGGH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MDBDPIBEGGH() {
                this.unk3300MDBDPIBEGGH_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300MJNPGEKLOCG() {
                return this.unk3300MJNPGEKLOCG_;
            }

            public Builder setUnk3300MJNPGEKLOCG(boolean value) {
                this.unk3300MJNPGEKLOCG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MJNPGEKLOCG() {
                this.unk3300MJNPGEKLOCG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityType() {
                return this.activityType_;
            }

            public Builder setActivityType(int value) {
                this.activityType_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityType() {
                this.activityType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getSelectedAvatarRewardId() {
                return this.selectedAvatarRewardId_;
            }

            public Builder setSelectedAvatarRewardId(int value) {
                this.selectedAvatarRewardId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSelectedAvatarRewardId() {
                this.selectedAvatarRewardId_ = 0;
                onChanged();
                return this;
            }

            private void ensureMeetCondListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.meetCondList_ = ActivityInfo.mutableCopy(this.meetCondList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getMeetCondListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.meetCondList_) : this.meetCondList_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getMeetCondListCount() {
                return this.meetCondList_.size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getMeetCondList(int index) {
                return this.meetCondList_.getInt(index);
            }

            public Builder setMeetCondList(int index, int value) {
                ensureMeetCondListIsMutable();
                this.meetCondList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addMeetCondList(int value) {
                ensureMeetCondListIsMutable();
                this.meetCondList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllMeetCondList(Iterable<? extends Integer> values) {
                ensureMeetCondListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.meetCondList_);
                onChanged();
                return this;
            }

            public Builder clearMeetCondList() {
                this.meetCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityId() {
                return this.activityId_;
            }

            public Builder setActivityId(int value) {
                this.activityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearActivityId() {
                this.activityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300ABJKLALKLDG() {
                return this.unk3300ABJKLALKLDG_;
            }

            public Builder setUnk3300ABJKLALKLDG(boolean value) {
                this.unk3300ABJKLALKLDG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ABJKLALKLDG() {
                this.unk3300ABJKLALKLDG_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
                onChanged();
                return this;
            }

            private void ensureActivityPushTipsDataListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.activityPushTipsDataList_ = new ArrayList(this.activityPushTipsDataList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> getActivityPushTipsDataListList() {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.activityPushTipsDataList_);
                }
                return this.activityPushTipsDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getActivityPushTipsDataListCount() {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    return this.activityPushTipsDataList_.size();
                }
                return this.activityPushTipsDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ActivityPushTipsDataOuterClass.ActivityPushTipsData getActivityPushTipsDataList(int index) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    return this.activityPushTipsDataList_.get(index);
                }
                return this.activityPushTipsDataListBuilder_.getMessage(index);
            }

            public Builder setActivityPushTipsDataList(int index, ActivityPushTipsDataOuterClass.ActivityPushTipsData value) {
                if (this.activityPushTipsDataListBuilder_ != null) {
                    this.activityPushTipsDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setActivityPushTipsDataList(int index, ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder builderForValue) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addActivityPushTipsDataList(ActivityPushTipsDataOuterClass.ActivityPushTipsData value) {
                if (this.activityPushTipsDataListBuilder_ != null) {
                    this.activityPushTipsDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityPushTipsDataList(int index, ActivityPushTipsDataOuterClass.ActivityPushTipsData value) {
                if (this.activityPushTipsDataListBuilder_ != null) {
                    this.activityPushTipsDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addActivityPushTipsDataList(ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder builderForValue) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addActivityPushTipsDataList(int index, ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder builderForValue) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllActivityPushTipsDataList(Iterable<? extends ActivityPushTipsDataOuterClass.ActivityPushTipsData> values) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    ensureActivityPushTipsDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.activityPushTipsDataList_);
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearActivityPushTipsDataList() {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    this.activityPushTipsDataList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeActivityPushTipsDataList(int index) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    ensureActivityPushTipsDataListIsMutable();
                    this.activityPushTipsDataList_.remove(index);
                    onChanged();
                } else {
                    this.activityPushTipsDataListBuilder_.remove(index);
                }
                return this;
            }

            public ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder getActivityPushTipsDataListBuilder(int index) {
                return getActivityPushTipsDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder getActivityPushTipsDataListOrBuilder(int index) {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    return this.activityPushTipsDataList_.get(index);
                }
                return this.activityPushTipsDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<? extends ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> getActivityPushTipsDataListOrBuilderList() {
                if (this.activityPushTipsDataListBuilder_ != null) {
                    return this.activityPushTipsDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.activityPushTipsDataList_);
            }

            public ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder addActivityPushTipsDataListBuilder() {
                return getActivityPushTipsDataListFieldBuilder().addBuilder(ActivityPushTipsDataOuterClass.ActivityPushTipsData.getDefaultInstance());
            }

            public ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder addActivityPushTipsDataListBuilder(int index) {
                return getActivityPushTipsDataListFieldBuilder().addBuilder(index, ActivityPushTipsDataOuterClass.ActivityPushTipsData.getDefaultInstance());
            }

            public List<ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder> getActivityPushTipsDataListBuilderList() {
                return getActivityPushTipsDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ActivityPushTipsDataOuterClass.ActivityPushTipsData, ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder, ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> getActivityPushTipsDataListFieldBuilder() {
                if (this.activityPushTipsDataListBuilder_ == null) {
                    this.activityPushTipsDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.activityPushTipsDataList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.activityPushTipsDataList_ = null;
                }
                return this.activityPushTipsDataListBuilder_;
            }

            private void ensureWatcherInfoListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.watcherInfoList_ = new ArrayList(this.watcherInfoList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> getWatcherInfoListList() {
                if (this.watcherInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.watcherInfoList_);
                }
                return this.watcherInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getWatcherInfoListCount() {
                if (this.watcherInfoListBuilder_ == null) {
                    return this.watcherInfoList_.size();
                }
                return this.watcherInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfoList(int index) {
                if (this.watcherInfoListBuilder_ == null) {
                    return this.watcherInfoList_.get(index);
                }
                return this.watcherInfoListBuilder_.getMessage(index);
            }

            public Builder setWatcherInfoList(int index, ActivityWatcherInfoOuterClass.ActivityWatcherInfo value) {
                if (this.watcherInfoListBuilder_ != null) {
                    this.watcherInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setWatcherInfoList(int index, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder builderForValue) {
                if (this.watcherInfoListBuilder_ == null) {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addWatcherInfoList(ActivityWatcherInfoOuterClass.ActivityWatcherInfo value) {
                if (this.watcherInfoListBuilder_ != null) {
                    this.watcherInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addWatcherInfoList(int index, ActivityWatcherInfoOuterClass.ActivityWatcherInfo value) {
                if (this.watcherInfoListBuilder_ != null) {
                    this.watcherInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addWatcherInfoList(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder builderForValue) {
                if (this.watcherInfoListBuilder_ == null) {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addWatcherInfoList(int index, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder builderForValue) {
                if (this.watcherInfoListBuilder_ == null) {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllWatcherInfoList(Iterable<? extends ActivityWatcherInfoOuterClass.ActivityWatcherInfo> values) {
                if (this.watcherInfoListBuilder_ == null) {
                    ensureWatcherInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.watcherInfoList_);
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearWatcherInfoList() {
                if (this.watcherInfoListBuilder_ == null) {
                    this.watcherInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeWatcherInfoList(int index) {
                if (this.watcherInfoListBuilder_ == null) {
                    ensureWatcherInfoListIsMutable();
                    this.watcherInfoList_.remove(index);
                    onChanged();
                } else {
                    this.watcherInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder getWatcherInfoListBuilder(int index) {
                return getWatcherInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoListOrBuilder(int index) {
                if (this.watcherInfoListBuilder_ == null) {
                    return this.watcherInfoList_.get(index);
                }
                return this.watcherInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<? extends ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoListOrBuilderList() {
                if (this.watcherInfoListBuilder_ != null) {
                    return this.watcherInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.watcherInfoList_);
            }

            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder addWatcherInfoListBuilder() {
                return getWatcherInfoListFieldBuilder().addBuilder(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.getDefaultInstance());
            }

            public ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder addWatcherInfoListBuilder(int index) {
                return getWatcherInfoListFieldBuilder().addBuilder(index, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.getDefaultInstance());
            }

            public List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder> getWatcherInfoListBuilderList() {
                return getWatcherInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ActivityWatcherInfoOuterClass.ActivityWatcherInfo, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder, ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoListFieldBuilder() {
                if (this.watcherInfoListBuilder_ == null) {
                    this.watcherInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.watcherInfoList_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.watcherInfoList_ = null;
                }
                return this.watcherInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300CBCEHLJJOGI() {
                return this.unk3300CBCEHLJJOGI_;
            }

            public Builder setUnk3300CBCEHLJJOGI(boolean value) {
                this.unk3300CBCEHLJJOGI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CBCEHLJJOGI() {
                this.unk3300CBCEHLJJOGI_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getScheduleId() {
                return this.scheduleId_;
            }

            public Builder setScheduleId(int value) {
                this.scheduleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearScheduleId() {
                this.scheduleId_ = 0;
                onChanged();
                return this;
            }

            private void ensureExpireCondListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.expireCondList_ = ActivityInfo.mutableCopy(this.expireCondList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getExpireCondListList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.expireCondList_) : this.expireCondList_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getExpireCondListCount() {
                return this.expireCondList_.size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getExpireCondList(int index) {
                return this.expireCondList_.getInt(index);
            }

            public Builder setExpireCondList(int index, int value) {
                ensureExpireCondListIsMutable();
                this.expireCondList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addExpireCondList(int value) {
                ensureExpireCondListIsMutable();
                this.expireCondList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllExpireCondList(Iterable<? extends Integer> values) {
                ensureExpireCondListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.expireCondList_);
                onChanged();
                return this;
            }

            public Builder clearExpireCondList() {
                this.expireCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private void ensureFdjefldhelaIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.fdjefldhela_ = ActivityInfo.mutableCopy(this.fdjefldhela_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getFdjefldhelaList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.fdjefldhela_) : this.fdjefldhela_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getFdjefldhelaCount() {
                return this.fdjefldhela_.size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getFdjefldhela(int index) {
                return this.fdjefldhela_.getInt(index);
            }

            public Builder setFdjefldhela(int index, int value) {
                ensureFdjefldhelaIsMutable();
                this.fdjefldhela_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFdjefldhela(int value) {
                ensureFdjefldhelaIsMutable();
                this.fdjefldhela_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFdjefldhela(Iterable<? extends Integer> values) {
                ensureFdjefldhelaIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fdjefldhela_);
                onChanged();
                return this;
            }

            public Builder clearFdjefldhela() {
                this.fdjefldhela_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300ICNJJKDHPCH() {
                return this.unk3300ICNJJKDHPCH_;
            }

            public Builder setUnk3300ICNJJKDHPCH(boolean value) {
                this.unk3300ICNJJKDHPCH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ICNJJKDHPCH() {
                this.unk3300ICNJJKDHPCH_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getFirstDayStartTime() {
                return this.firstDayStartTime_;
            }

            public Builder setFirstDayStartTime(int value) {
                this.firstDayStartTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstDayStartTime() {
                this.firstDayStartTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getCurScore() {
                return this.curScore_;
            }

            public Builder setCurScore(int value) {
                this.curScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurScore() {
                this.curScore_ = 0;
                onChanged();
                return this;
            }

            private MapField<Integer, Integer> internalGetWishGiftNumMap() {
                if (this.wishGiftNumMap_ == null) {
                    return MapField.emptyMapField(WishGiftNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.wishGiftNumMap_;
            }

            private MapField<Integer, Integer> internalGetMutableWishGiftNumMap() {
                onChanged();
                if (this.wishGiftNumMap_ == null) {
                    this.wishGiftNumMap_ = MapField.newMapField(WishGiftNumMapDefaultEntryHolder.defaultEntry);
                }
                if (!this.wishGiftNumMap_.isMutable()) {
                    this.wishGiftNumMap_ = this.wishGiftNumMap_.copy();
                }
                return this.wishGiftNumMap_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getWishGiftNumMapCount() {
                return internalGetWishGiftNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean containsWishGiftNumMap(int key) {
                return internalGetWishGiftNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            @Deprecated
            public Map<Integer, Integer> getWishGiftNumMap() {
                return getWishGiftNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public Map<Integer, Integer> getWishGiftNumMapMap() {
                return internalGetWishGiftNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getWishGiftNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetWishGiftNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getWishGiftNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetWishGiftNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            public Builder clearWishGiftNumMap() {
                internalGetMutableWishGiftNumMap().getMutableMap().clear();
                return this;
            }

            public Builder removeWishGiftNumMap(int key) {
                internalGetMutableWishGiftNumMap().getMutableMap().remove(Integer.valueOf(key));
                return this;
            }

            @Deprecated
            public Map<Integer, Integer> getMutableWishGiftNumMap() {
                return internalGetMutableWishGiftNumMap().getMutableMap();
            }

            public Builder putWishGiftNumMap(int key, int value) {
                internalGetMutableWishGiftNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                return this;
            }

            public Builder putAllWishGiftNumMap(Map<Integer, Integer> values) {
                internalGetMutableWishGiftNumMap().getMutableMap().putAll(values);
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean getUnk3300NEPKLLBJFKK() {
                return this.unk3300NEPKLLBJFKK_;
            }

            public Builder setUnk3300NEPKLLBJFKK(boolean value) {
                this.unk3300NEPKLLBJFKK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NEPKLLBJFKK() {
                this.unk3300NEPKLLBJFKK_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public int getBeginTime() {
                return this.beginTime_;
            }

            public Builder setBeginTime(int value) {
                this.beginTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearBeginTime() {
                this.beginTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSamLampInfo() {
                return this.detailCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SamLampInfoOuterClass.SamLampInfo getSamLampInfo() {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ == 4) {
                        return (SamLampInfoOuterClass.SamLampInfo) this.detail_;
                    }
                    return SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
                } else if (this.detailCase_ == 4) {
                    return this.samLampInfoBuilder_.getMessage();
                } else {
                    return SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
                }
            }

            public Builder setSamLampInfo(SamLampInfoOuterClass.SamLampInfo value) {
                if (this.samLampInfoBuilder_ != null) {
                    this.samLampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder setSamLampInfo(SamLampInfoOuterClass.SamLampInfo.Builder builderForValue) {
                if (this.samLampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.samLampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder mergeSamLampInfo(SamLampInfoOuterClass.SamLampInfo value) {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 4 || this.detail_ == SamLampInfoOuterClass.SamLampInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SamLampInfoOuterClass.SamLampInfo.newBuilder((SamLampInfoOuterClass.SamLampInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 4) {
                        this.samLampInfoBuilder_.mergeFrom(value);
                    }
                    this.samLampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder clearSamLampInfo() {
                if (this.samLampInfoBuilder_ != null) {
                    if (this.detailCase_ == 4) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.samLampInfoBuilder_.clear();
                } else if (this.detailCase_ == 4) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SamLampInfoOuterClass.SamLampInfo.Builder getSamLampInfoBuilder() {
                return getSamLampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SamLampInfoOuterClass.SamLampInfoOrBuilder getSamLampInfoOrBuilder() {
                if (this.detailCase_ == 4 && this.samLampInfoBuilder_ != null) {
                    return this.samLampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 4) {
                    return (SamLampInfoOuterClass.SamLampInfo) this.detail_;
                }
                return SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SamLampInfoOuterClass.SamLampInfo, SamLampInfoOuterClass.SamLampInfo.Builder, SamLampInfoOuterClass.SamLampInfoOrBuilder> getSamLampInfoFieldBuilder() {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 4) {
                        this.detail_ = SamLampInfoOuterClass.SamLampInfo.getDefaultInstance();
                    }
                    this.samLampInfoBuilder_ = new SingleFieldBuilderV3<>((SamLampInfoOuterClass.SamLampInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 4;
                onChanged();
                return this.samLampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCrucibleInfo() {
                return this.detailCase_ == 13;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrucibleInfoOuterClass.CrucibleInfo getCrucibleInfo() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ == 13) {
                        return (CrucibleInfoOuterClass.CrucibleInfo) this.detail_;
                    }
                    return CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
                } else if (this.detailCase_ == 13) {
                    return this.crucibleInfoBuilder_.getMessage();
                } else {
                    return CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
                }
            }

            public Builder setCrucibleInfo(CrucibleInfoOuterClass.CrucibleInfo value) {
                if (this.crucibleInfoBuilder_ != null) {
                    this.crucibleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder setCrucibleInfo(CrucibleInfoOuterClass.CrucibleInfo.Builder builderForValue) {
                if (this.crucibleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crucibleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder mergeCrucibleInfo(CrucibleInfoOuterClass.CrucibleInfo value) {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ != 13 || this.detail_ == CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CrucibleInfoOuterClass.CrucibleInfo.newBuilder((CrucibleInfoOuterClass.CrucibleInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 13) {
                        this.crucibleInfoBuilder_.mergeFrom(value);
                    }
                    this.crucibleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 13;
                return this;
            }

            public Builder clearCrucibleInfo() {
                if (this.crucibleInfoBuilder_ != null) {
                    if (this.detailCase_ == 13) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.crucibleInfoBuilder_.clear();
                } else if (this.detailCase_ == 13) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CrucibleInfoOuterClass.CrucibleInfo.Builder getCrucibleInfoBuilder() {
                return getCrucibleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrucibleInfoOuterClass.CrucibleInfoOrBuilder getCrucibleInfoOrBuilder() {
                if (this.detailCase_ == 13 && this.crucibleInfoBuilder_ != null) {
                    return this.crucibleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 13) {
                    return (CrucibleInfoOuterClass.CrucibleInfo) this.detail_;
                }
                return CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CrucibleInfoOuterClass.CrucibleInfo, CrucibleInfoOuterClass.CrucibleInfo.Builder, CrucibleInfoOuterClass.CrucibleInfoOrBuilder> getCrucibleInfoFieldBuilder() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ != 13) {
                        this.detail_ = CrucibleInfoOuterClass.CrucibleInfo.getDefaultInstance();
                    }
                    this.crucibleInfoBuilder_ = new SingleFieldBuilderV3<>((CrucibleInfoOuterClass.CrucibleInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 13;
                onChanged();
                return this.crucibleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSalesmanInfo() {
                return this.detailCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SalesmanInfoOuterClass.SalesmanInfo getSalesmanInfo() {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ == 1) {
                        return (SalesmanInfoOuterClass.SalesmanInfo) this.detail_;
                    }
                    return SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1) {
                    return this.salesmanInfoBuilder_.getMessage();
                } else {
                    return SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
                }
            }

            public Builder setSalesmanInfo(SalesmanInfoOuterClass.SalesmanInfo value) {
                if (this.salesmanInfoBuilder_ != null) {
                    this.salesmanInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder setSalesmanInfo(SalesmanInfoOuterClass.SalesmanInfo.Builder builderForValue) {
                if (this.salesmanInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.salesmanInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder mergeSalesmanInfo(SalesmanInfoOuterClass.SalesmanInfo value) {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ != 1 || this.detail_ == SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SalesmanInfoOuterClass.SalesmanInfo.newBuilder((SalesmanInfoOuterClass.SalesmanInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1) {
                        this.salesmanInfoBuilder_.mergeFrom(value);
                    }
                    this.salesmanInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1;
                return this;
            }

            public Builder clearSalesmanInfo() {
                if (this.salesmanInfoBuilder_ != null) {
                    if (this.detailCase_ == 1) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.salesmanInfoBuilder_.clear();
                } else if (this.detailCase_ == 1) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SalesmanInfoOuterClass.SalesmanInfo.Builder getSalesmanInfoBuilder() {
                return getSalesmanInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SalesmanInfoOuterClass.SalesmanInfoOrBuilder getSalesmanInfoOrBuilder() {
                if (this.detailCase_ == 1 && this.salesmanInfoBuilder_ != null) {
                    return this.salesmanInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1) {
                    return (SalesmanInfoOuterClass.SalesmanInfo) this.detail_;
                }
                return SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SalesmanInfoOuterClass.SalesmanInfo, SalesmanInfoOuterClass.SalesmanInfo.Builder, SalesmanInfoOuterClass.SalesmanInfoOrBuilder> getSalesmanInfoFieldBuilder() {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ != 1) {
                        this.detail_ = SalesmanInfoOuterClass.SalesmanInfo.getDefaultInstance();
                    }
                    this.salesmanInfoBuilder_ = new SingleFieldBuilderV3<>((SalesmanInfoOuterClass.SalesmanInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1;
                onChanged();
                return this.salesmanInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTrialAvatarInfo() {
                return this.detailCase_ == 8;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TrialAvatarInfoOuterClass.TrialAvatarInfo getTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ == 8) {
                        return (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_;
                    }
                    return TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
                } else if (this.detailCase_ == 8) {
                    return this.trialAvatarInfoBuilder_.getMessage();
                } else {
                    return TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
                }
            }

            public Builder setTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo value) {
                if (this.trialAvatarInfoBuilder_ != null) {
                    this.trialAvatarInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 8;
                return this;
            }

            public Builder setTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder builderForValue) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trialAvatarInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 8;
                return this;
            }

            public Builder mergeTrialAvatarInfo(TrialAvatarInfoOuterClass.TrialAvatarInfo value) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ != 8 || this.detail_ == TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TrialAvatarInfoOuterClass.TrialAvatarInfo.newBuilder((TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 8) {
                        this.trialAvatarInfoBuilder_.mergeFrom(value);
                    }
                    this.trialAvatarInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 8;
                return this;
            }

            public Builder clearTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ != null) {
                    if (this.detailCase_ == 8) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.trialAvatarInfoBuilder_.clear();
                } else if (this.detailCase_ == 8) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder getTrialAvatarInfoBuilder() {
                return getTrialAvatarInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder getTrialAvatarInfoOrBuilder() {
                if (this.detailCase_ == 8 && this.trialAvatarInfoBuilder_ != null) {
                    return this.trialAvatarInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 8) {
                    return (TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_;
                }
                return TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TrialAvatarInfoOuterClass.TrialAvatarInfo, TrialAvatarInfoOuterClass.TrialAvatarInfo.Builder, TrialAvatarInfoOuterClass.TrialAvatarInfoOrBuilder> getTrialAvatarInfoFieldBuilder() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ != 8) {
                        this.detail_ = TrialAvatarInfoOuterClass.TrialAvatarInfo.getDefaultInstance();
                    }
                    this.trialAvatarInfoBuilder_ = new SingleFieldBuilderV3<>((TrialAvatarInfoOuterClass.TrialAvatarInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 8;
                onChanged();
                return this.trialAvatarInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDeliveryInfo() {
                return this.detailCase_ == 32;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DeliveryInfoOuterClass.DeliveryInfo getDeliveryInfo() {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ == 32) {
                        return (DeliveryInfoOuterClass.DeliveryInfo) this.detail_;
                    }
                    return DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
                } else if (this.detailCase_ == 32) {
                    return this.deliveryInfoBuilder_.getMessage();
                } else {
                    return DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
                }
            }

            public Builder setDeliveryInfo(DeliveryInfoOuterClass.DeliveryInfo value) {
                if (this.deliveryInfoBuilder_ != null) {
                    this.deliveryInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 32;
                return this;
            }

            public Builder setDeliveryInfo(DeliveryInfoOuterClass.DeliveryInfo.Builder builderForValue) {
                if (this.deliveryInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.deliveryInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 32;
                return this;
            }

            public Builder mergeDeliveryInfo(DeliveryInfoOuterClass.DeliveryInfo value) {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ != 32 || this.detail_ == DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DeliveryInfoOuterClass.DeliveryInfo.newBuilder((DeliveryInfoOuterClass.DeliveryInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 32) {
                        this.deliveryInfoBuilder_.mergeFrom(value);
                    }
                    this.deliveryInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 32;
                return this;
            }

            public Builder clearDeliveryInfo() {
                if (this.deliveryInfoBuilder_ != null) {
                    if (this.detailCase_ == 32) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.deliveryInfoBuilder_.clear();
                } else if (this.detailCase_ == 32) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DeliveryInfoOuterClass.DeliveryInfo.Builder getDeliveryInfoBuilder() {
                return getDeliveryInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DeliveryInfoOuterClass.DeliveryInfoOrBuilder getDeliveryInfoOrBuilder() {
                if (this.detailCase_ == 32 && this.deliveryInfoBuilder_ != null) {
                    return this.deliveryInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 32) {
                    return (DeliveryInfoOuterClass.DeliveryInfo) this.detail_;
                }
                return DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DeliveryInfoOuterClass.DeliveryInfo, DeliveryInfoOuterClass.DeliveryInfo.Builder, DeliveryInfoOuterClass.DeliveryInfoOrBuilder> getDeliveryInfoFieldBuilder() {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ != 32) {
                        this.detail_ = DeliveryInfoOuterClass.DeliveryInfo.getDefaultInstance();
                    }
                    this.deliveryInfoBuilder_ = new SingleFieldBuilderV3<>((DeliveryInfoOuterClass.DeliveryInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 32;
                onChanged();
                return this.deliveryInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasAsterInfo() {
                return this.detailCase_ == 1808;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public AsterInfoOuterClass.AsterInfo getAsterInfo() {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ == 1808) {
                        return (AsterInfoOuterClass.AsterInfo) this.detail_;
                    }
                    return AsterInfoOuterClass.AsterInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1808) {
                    return this.asterInfoBuilder_.getMessage();
                } else {
                    return AsterInfoOuterClass.AsterInfo.getDefaultInstance();
                }
            }

            public Builder setAsterInfo(AsterInfoOuterClass.AsterInfo value) {
                if (this.asterInfoBuilder_ != null) {
                    this.asterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ASTER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setAsterInfo(AsterInfoOuterClass.AsterInfo.Builder builderForValue) {
                if (this.asterInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ASTER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeAsterInfo(AsterInfoOuterClass.AsterInfo value) {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1808 || this.detail_ == AsterInfoOuterClass.AsterInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = AsterInfoOuterClass.AsterInfo.newBuilder((AsterInfoOuterClass.AsterInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1808) {
                        this.asterInfoBuilder_.mergeFrom(value);
                    }
                    this.asterInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ASTER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearAsterInfo() {
                if (this.asterInfoBuilder_ != null) {
                    if (this.detailCase_ == 1808) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.asterInfoBuilder_.clear();
                } else if (this.detailCase_ == 1808) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public AsterInfoOuterClass.AsterInfo.Builder getAsterInfoBuilder() {
                return getAsterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public AsterInfoOuterClass.AsterInfoOrBuilder getAsterInfoOrBuilder() {
                if (this.detailCase_ == 1808 && this.asterInfoBuilder_ != null) {
                    return this.asterInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1808) {
                    return (AsterInfoOuterClass.AsterInfo) this.detail_;
                }
                return AsterInfoOuterClass.AsterInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AsterInfoOuterClass.AsterInfo, AsterInfoOuterClass.AsterInfo.Builder, AsterInfoOuterClass.AsterInfoOrBuilder> getAsterInfoFieldBuilder() {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1808) {
                        this.detail_ = AsterInfoOuterClass.AsterInfo.getDefaultInstance();
                    }
                    this.asterInfoBuilder_ = new SingleFieldBuilderV3<>((AsterInfoOuterClass.AsterInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ASTER_INFO_FIELD_NUMBER;
                onChanged();
                return this.asterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFlightInfo() {
                return this.detailCase_ == 1062;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FlightInfoOuterClass.FlightInfo getFlightInfo() {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ == 1062) {
                        return (FlightInfoOuterClass.FlightInfo) this.detail_;
                    }
                    return FlightInfoOuterClass.FlightInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1062) {
                    return this.flightInfoBuilder_.getMessage();
                } else {
                    return FlightInfoOuterClass.FlightInfo.getDefaultInstance();
                }
            }

            public Builder setFlightInfo(FlightInfoOuterClass.FlightInfo value) {
                if (this.flightInfoBuilder_ != null) {
                    this.flightInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1062;
                return this;
            }

            public Builder setFlightInfo(FlightInfoOuterClass.FlightInfo.Builder builderForValue) {
                if (this.flightInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.flightInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1062;
                return this;
            }

            public Builder mergeFlightInfo(FlightInfoOuterClass.FlightInfo value) {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ != 1062 || this.detail_ == FlightInfoOuterClass.FlightInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FlightInfoOuterClass.FlightInfo.newBuilder((FlightInfoOuterClass.FlightInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1062) {
                        this.flightInfoBuilder_.mergeFrom(value);
                    }
                    this.flightInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1062;
                return this;
            }

            public Builder clearFlightInfo() {
                if (this.flightInfoBuilder_ != null) {
                    if (this.detailCase_ == 1062) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.flightInfoBuilder_.clear();
                } else if (this.detailCase_ == 1062) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FlightInfoOuterClass.FlightInfo.Builder getFlightInfoBuilder() {
                return getFlightInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FlightInfoOuterClass.FlightInfoOrBuilder getFlightInfoOrBuilder() {
                if (this.detailCase_ == 1062 && this.flightInfoBuilder_ != null) {
                    return this.flightInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1062) {
                    return (FlightInfoOuterClass.FlightInfo) this.detail_;
                }
                return FlightInfoOuterClass.FlightInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FlightInfoOuterClass.FlightInfo, FlightInfoOuterClass.FlightInfo.Builder, FlightInfoOuterClass.FlightInfoOrBuilder> getFlightInfoFieldBuilder() {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ != 1062) {
                        this.detail_ = FlightInfoOuterClass.FlightInfo.getDefaultInstance();
                    }
                    this.flightInfoBuilder_ = new SingleFieldBuilderV3<>((FlightInfoOuterClass.FlightInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1062;
                onChanged();
                return this.flightInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDragonSpineInfo() {
                return this.detailCase_ == 378;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DragonSpineInfoOuterClass.DragonSpineInfo getDragonSpineInfo() {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ == 378) {
                        return (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_;
                    }
                    return DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
                } else if (this.detailCase_ == 378) {
                    return this.dragonSpineInfoBuilder_.getMessage();
                } else {
                    return DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
                }
            }

            public Builder setDragonSpineInfo(DragonSpineInfoOuterClass.DragonSpineInfo value) {
                if (this.dragonSpineInfoBuilder_ != null) {
                    this.dragonSpineInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder setDragonSpineInfo(DragonSpineInfoOuterClass.DragonSpineInfo.Builder builderForValue) {
                if (this.dragonSpineInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dragonSpineInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder mergeDragonSpineInfo(DragonSpineInfoOuterClass.DragonSpineInfo value) {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ != 378 || this.detail_ == DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DragonSpineInfoOuterClass.DragonSpineInfo.newBuilder((DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 378) {
                        this.dragonSpineInfoBuilder_.mergeFrom(value);
                    }
                    this.dragonSpineInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder clearDragonSpineInfo() {
                if (this.dragonSpineInfoBuilder_ != null) {
                    if (this.detailCase_ == 378) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.dragonSpineInfoBuilder_.clear();
                } else if (this.detailCase_ == 378) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DragonSpineInfoOuterClass.DragonSpineInfo.Builder getDragonSpineInfoBuilder() {
                return getDragonSpineInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder getDragonSpineInfoOrBuilder() {
                if (this.detailCase_ == 378 && this.dragonSpineInfoBuilder_ != null) {
                    return this.dragonSpineInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 378) {
                    return (DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_;
                }
                return DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DragonSpineInfoOuterClass.DragonSpineInfo, DragonSpineInfoOuterClass.DragonSpineInfo.Builder, DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder> getDragonSpineInfoFieldBuilder() {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ != 378) {
                        this.detail_ = DragonSpineInfoOuterClass.DragonSpineInfo.getDefaultInstance();
                    }
                    this.dragonSpineInfoBuilder_ = new SingleFieldBuilderV3<>((DragonSpineInfoOuterClass.DragonSpineInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 378;
                onChanged();
                return this.dragonSpineInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEffigyInfo() {
                return this.detailCase_ == 1991;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyInfoOuterClass.EffigyInfo getEffigyInfo() {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ == 1991) {
                        return (EffigyInfoOuterClass.EffigyInfo) this.detail_;
                    }
                    return EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1991) {
                    return this.effigyInfoBuilder_.getMessage();
                } else {
                    return EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyInfo(EffigyInfoOuterClass.EffigyInfo value) {
                if (this.effigyInfoBuilder_ != null) {
                    this.effigyInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1991;
                return this;
            }

            public Builder setEffigyInfo(EffigyInfoOuterClass.EffigyInfo.Builder builderForValue) {
                if (this.effigyInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1991;
                return this;
            }

            public Builder mergeEffigyInfo(EffigyInfoOuterClass.EffigyInfo value) {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1991 || this.detail_ == EffigyInfoOuterClass.EffigyInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyInfoOuterClass.EffigyInfo.newBuilder((EffigyInfoOuterClass.EffigyInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1991) {
                        this.effigyInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1991;
                return this;
            }

            public Builder clearEffigyInfo() {
                if (this.effigyInfoBuilder_ != null) {
                    if (this.detailCase_ == 1991) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyInfoBuilder_.clear();
                } else if (this.detailCase_ == 1991) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyInfoOuterClass.EffigyInfo.Builder getEffigyInfoBuilder() {
                return getEffigyInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyInfoOuterClass.EffigyInfoOrBuilder getEffigyInfoOrBuilder() {
                if (this.detailCase_ == 1991 && this.effigyInfoBuilder_ != null) {
                    return this.effigyInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1991) {
                    return (EffigyInfoOuterClass.EffigyInfo) this.detail_;
                }
                return EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyInfoOuterClass.EffigyInfo, EffigyInfoOuterClass.EffigyInfo.Builder, EffigyInfoOuterClass.EffigyInfoOrBuilder> getEffigyInfoFieldBuilder() {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1991) {
                        this.detail_ = EffigyInfoOuterClass.EffigyInfo.getDefaultInstance();
                    }
                    this.effigyInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyInfoOuterClass.EffigyInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1991;
                onChanged();
                return this.effigyInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTreasureMapInfo() {
                return this.detailCase_ == 546;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureMapInfoOuterClass.TreasureMapInfo getTreasureMapInfo() {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ == 546) {
                        return (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_;
                    }
                    return TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
                } else if (this.detailCase_ == 546) {
                    return this.treasureMapInfoBuilder_.getMessage();
                } else {
                    return TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
                }
            }

            public Builder setTreasureMapInfo(TreasureMapInfoOuterClass.TreasureMapInfo value) {
                if (this.treasureMapInfoBuilder_ != null) {
                    this.treasureMapInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setTreasureMapInfo(TreasureMapInfoOuterClass.TreasureMapInfo.Builder builderForValue) {
                if (this.treasureMapInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.treasureMapInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTreasureMapInfo(TreasureMapInfoOuterClass.TreasureMapInfo value) {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ != 546 || this.detail_ == TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TreasureMapInfoOuterClass.TreasureMapInfo.newBuilder((TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 546) {
                        this.treasureMapInfoBuilder_.mergeFrom(value);
                    }
                    this.treasureMapInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTreasureMapInfo() {
                if (this.treasureMapInfoBuilder_ != null) {
                    if (this.detailCase_ == 546) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.treasureMapInfoBuilder_.clear();
                } else if (this.detailCase_ == 546) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TreasureMapInfoOuterClass.TreasureMapInfo.Builder getTreasureMapInfoBuilder() {
                return getTreasureMapInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder getTreasureMapInfoOrBuilder() {
                if (this.detailCase_ == 546 && this.treasureMapInfoBuilder_ != null) {
                    return this.treasureMapInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 546) {
                    return (TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_;
                }
                return TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TreasureMapInfoOuterClass.TreasureMapInfo, TreasureMapInfoOuterClass.TreasureMapInfo.Builder, TreasureMapInfoOuterClass.TreasureMapInfoOrBuilder> getTreasureMapInfoFieldBuilder() {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ != 546) {
                        this.detail_ = TreasureMapInfoOuterClass.TreasureMapInfo.getDefaultInstance();
                    }
                    this.treasureMapInfoBuilder_ = new SingleFieldBuilderV3<>((TreasureMapInfoOuterClass.TreasureMapInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                onChanged();
                return this.treasureMapInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBlessingInfo() {
                return this.detailCase_ == 1198;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlessingInfoOuterClass.BlessingInfo getBlessingInfo() {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ == 1198) {
                        return (BlessingInfoOuterClass.BlessingInfo) this.detail_;
                    }
                    return BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1198) {
                    return this.blessingInfoBuilder_.getMessage();
                } else {
                    return BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
                }
            }

            public Builder setBlessingInfo(BlessingInfoOuterClass.BlessingInfo value) {
                if (this.blessingInfoBuilder_ != null) {
                    this.blessingInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1198;
                return this;
            }

            public Builder setBlessingInfo(BlessingInfoOuterClass.BlessingInfo.Builder builderForValue) {
                if (this.blessingInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blessingInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1198;
                return this;
            }

            public Builder mergeBlessingInfo(BlessingInfoOuterClass.BlessingInfo value) {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ != 1198 || this.detail_ == BlessingInfoOuterClass.BlessingInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BlessingInfoOuterClass.BlessingInfo.newBuilder((BlessingInfoOuterClass.BlessingInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1198) {
                        this.blessingInfoBuilder_.mergeFrom(value);
                    }
                    this.blessingInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1198;
                return this;
            }

            public Builder clearBlessingInfo() {
                if (this.blessingInfoBuilder_ != null) {
                    if (this.detailCase_ == 1198) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.blessingInfoBuilder_.clear();
                } else if (this.detailCase_ == 1198) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BlessingInfoOuterClass.BlessingInfo.Builder getBlessingInfoBuilder() {
                return getBlessingInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlessingInfoOuterClass.BlessingInfoOrBuilder getBlessingInfoOrBuilder() {
                if (this.detailCase_ == 1198 && this.blessingInfoBuilder_ != null) {
                    return this.blessingInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1198) {
                    return (BlessingInfoOuterClass.BlessingInfo) this.detail_;
                }
                return BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BlessingInfoOuterClass.BlessingInfo, BlessingInfoOuterClass.BlessingInfo.Builder, BlessingInfoOuterClass.BlessingInfoOrBuilder> getBlessingInfoFieldBuilder() {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ != 1198) {
                        this.detail_ = BlessingInfoOuterClass.BlessingInfo.getDefaultInstance();
                    }
                    this.blessingInfoBuilder_ = new SingleFieldBuilderV3<>((BlessingInfoOuterClass.BlessingInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1198;
                onChanged();
                return this.blessingInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSeaLampInfo() {
                return this.detailCase_ == 578;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampInfoOuterClass.SeaLampInfo getSeaLampInfo() {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ == 578) {
                        return (SeaLampInfoOuterClass.SeaLampInfo) this.detail_;
                    }
                    return SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
                } else if (this.detailCase_ == 578) {
                    return this.seaLampInfoBuilder_.getMessage();
                } else {
                    return SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
                }
            }

            public Builder setSeaLampInfo(SeaLampInfoOuterClass.SeaLampInfo value) {
                if (this.seaLampInfoBuilder_ != null) {
                    this.seaLampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setSeaLampInfo(SeaLampInfoOuterClass.SeaLampInfo.Builder builderForValue) {
                if (this.seaLampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.seaLampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSeaLampInfo(SeaLampInfoOuterClass.SeaLampInfo value) {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 578 || this.detail_ == SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SeaLampInfoOuterClass.SeaLampInfo.newBuilder((SeaLampInfoOuterClass.SeaLampInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 578) {
                        this.seaLampInfoBuilder_.mergeFrom(value);
                    }
                    this.seaLampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearSeaLampInfo() {
                if (this.seaLampInfoBuilder_ != null) {
                    if (this.detailCase_ == 578) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.seaLampInfoBuilder_.clear();
                } else if (this.detailCase_ == 578) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SeaLampInfoOuterClass.SeaLampInfo.Builder getSeaLampInfoBuilder() {
                return getSeaLampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampInfoOuterClass.SeaLampInfoOrBuilder getSeaLampInfoOrBuilder() {
                if (this.detailCase_ == 578 && this.seaLampInfoBuilder_ != null) {
                    return this.seaLampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 578) {
                    return (SeaLampInfoOuterClass.SeaLampInfo) this.detail_;
                }
                return SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SeaLampInfoOuterClass.SeaLampInfo, SeaLampInfoOuterClass.SeaLampInfo.Builder, SeaLampInfoOuterClass.SeaLampInfoOrBuilder> getSeaLampInfoFieldBuilder() {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 578) {
                        this.detail_ = SeaLampInfoOuterClass.SeaLampInfo.getDefaultInstance();
                    }
                    this.seaLampInfoBuilder_ = new SingleFieldBuilderV3<>((SeaLampInfoOuterClass.SeaLampInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.SEA_LAMP_INFO_FIELD_NUMBER;
                onChanged();
                return this.seaLampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasExpeditionInfo() {
                return this.detailCase_ == 930;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ExpeditionInfoOuterClass.ExpeditionInfo getExpeditionInfo() {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ == 930) {
                        return (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_;
                    }
                    return ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
                } else if (this.detailCase_ == 930) {
                    return this.expeditionInfoBuilder_.getMessage();
                } else {
                    return ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
                }
            }

            public Builder setExpeditionInfo(ExpeditionInfoOuterClass.ExpeditionInfo value) {
                if (this.expeditionInfoBuilder_ != null) {
                    this.expeditionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 930;
                return this;
            }

            public Builder setExpeditionInfo(ExpeditionInfoOuterClass.ExpeditionInfo.Builder builderForValue) {
                if (this.expeditionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.expeditionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 930;
                return this;
            }

            public Builder mergeExpeditionInfo(ExpeditionInfoOuterClass.ExpeditionInfo value) {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ != 930 || this.detail_ == ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ExpeditionInfoOuterClass.ExpeditionInfo.newBuilder((ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 930) {
                        this.expeditionInfoBuilder_.mergeFrom(value);
                    }
                    this.expeditionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 930;
                return this;
            }

            public Builder clearExpeditionInfo() {
                if (this.expeditionInfoBuilder_ != null) {
                    if (this.detailCase_ == 930) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.expeditionInfoBuilder_.clear();
                } else if (this.detailCase_ == 930) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ExpeditionInfoOuterClass.ExpeditionInfo.Builder getExpeditionInfoBuilder() {
                return getExpeditionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder getExpeditionInfoOrBuilder() {
                if (this.detailCase_ == 930 && this.expeditionInfoBuilder_ != null) {
                    return this.expeditionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 930) {
                    return (ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_;
                }
                return ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ExpeditionInfoOuterClass.ExpeditionInfo, ExpeditionInfoOuterClass.ExpeditionInfo.Builder, ExpeditionInfoOuterClass.ExpeditionInfoOrBuilder> getExpeditionInfoFieldBuilder() {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ != 930) {
                        this.detail_ = ExpeditionInfoOuterClass.ExpeditionInfo.getDefaultInstance();
                    }
                    this.expeditionInfoBuilder_ = new SingleFieldBuilderV3<>((ExpeditionInfoOuterClass.ExpeditionInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 930;
                onChanged();
                return this.expeditionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasArenaChallengeInfo() {
                return this.detailCase_ == 699;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ArenaChallengeInfoOuterClass.ArenaChallengeInfo getArenaChallengeInfo() {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 699) {
                        return (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_;
                    }
                    return ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
                } else if (this.detailCase_ == 699) {
                    return this.arenaChallengeInfoBuilder_.getMessage();
                } else {
                    return ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
                }
            }

            public Builder setArenaChallengeInfo(ArenaChallengeInfoOuterClass.ArenaChallengeInfo value) {
                if (this.arenaChallengeInfoBuilder_ != null) {
                    this.arenaChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder setArenaChallengeInfo(ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder builderForValue) {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.arenaChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder mergeArenaChallengeInfo(ArenaChallengeInfoOuterClass.ArenaChallengeInfo value) {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 699 || this.detail_ == ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ArenaChallengeInfoOuterClass.ArenaChallengeInfo.newBuilder((ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 699) {
                        this.arenaChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.arenaChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder clearArenaChallengeInfo() {
                if (this.arenaChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 699) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.arenaChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 699) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder getArenaChallengeInfoBuilder() {
                return getArenaChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder getArenaChallengeInfoOrBuilder() {
                if (this.detailCase_ == 699 && this.arenaChallengeInfoBuilder_ != null) {
                    return this.arenaChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 699) {
                    return (ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_;
                }
                return ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ArenaChallengeInfoOuterClass.ArenaChallengeInfo, ArenaChallengeInfoOuterClass.ArenaChallengeInfo.Builder, ArenaChallengeInfoOuterClass.ArenaChallengeInfoOrBuilder> getArenaChallengeInfoFieldBuilder() {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 699) {
                        this.detail_ = ArenaChallengeInfoOuterClass.ArenaChallengeInfo.getDefaultInstance();
                    }
                    this.arenaChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((ArenaChallengeInfoOuterClass.ArenaChallengeInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 699;
                onChanged();
                return this.arenaChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFleurFairInfo() {
                return this.detailCase_ == 1116;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FleurFairInfoOuterClass.FleurFairInfo getFleurFairInfo() {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ == 1116) {
                        return (FleurFairInfoOuterClass.FleurFairInfo) this.detail_;
                    }
                    return FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1116) {
                    return this.fleurFairInfoBuilder_.getMessage();
                } else {
                    return FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
                }
            }

            public Builder setFleurFairInfo(FleurFairInfoOuterClass.FleurFairInfo value) {
                if (this.fleurFairInfoBuilder_ != null) {
                    this.fleurFairInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1116;
                return this;
            }

            public Builder setFleurFairInfo(FleurFairInfoOuterClass.FleurFairInfo.Builder builderForValue) {
                if (this.fleurFairInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fleurFairInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1116;
                return this;
            }

            public Builder mergeFleurFairInfo(FleurFairInfoOuterClass.FleurFairInfo value) {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ != 1116 || this.detail_ == FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FleurFairInfoOuterClass.FleurFairInfo.newBuilder((FleurFairInfoOuterClass.FleurFairInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1116) {
                        this.fleurFairInfoBuilder_.mergeFrom(value);
                    }
                    this.fleurFairInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1116;
                return this;
            }

            public Builder clearFleurFairInfo() {
                if (this.fleurFairInfoBuilder_ != null) {
                    if (this.detailCase_ == 1116) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fleurFairInfoBuilder_.clear();
                } else if (this.detailCase_ == 1116) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FleurFairInfoOuterClass.FleurFairInfo.Builder getFleurFairInfoBuilder() {
                return getFleurFairInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FleurFairInfoOuterClass.FleurFairInfoOrBuilder getFleurFairInfoOrBuilder() {
                if (this.detailCase_ == 1116 && this.fleurFairInfoBuilder_ != null) {
                    return this.fleurFairInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1116) {
                    return (FleurFairInfoOuterClass.FleurFairInfo) this.detail_;
                }
                return FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FleurFairInfoOuterClass.FleurFairInfo, FleurFairInfoOuterClass.FleurFairInfo.Builder, FleurFairInfoOuterClass.FleurFairInfoOrBuilder> getFleurFairInfoFieldBuilder() {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ != 1116) {
                        this.detail_ = FleurFairInfoOuterClass.FleurFairInfo.getDefaultInstance();
                    }
                    this.fleurFairInfoBuilder_ = new SingleFieldBuilderV3<>((FleurFairInfoOuterClass.FleurFairInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1116;
                onChanged();
                return this.fleurFairInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWaterSpiritInfo() {
                return this.detailCase_ == 1651;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WaterSpiritInfoOuterClass.WaterSpiritInfo getWaterSpiritInfo() {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ == 1651) {
                        return (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_;
                    }
                    return WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1651) {
                    return this.waterSpiritInfoBuilder_.getMessage();
                } else {
                    return WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
                }
            }

            public Builder setWaterSpiritInfo(WaterSpiritInfoOuterClass.WaterSpiritInfo value) {
                if (this.waterSpiritInfoBuilder_ != null) {
                    this.waterSpiritInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setWaterSpiritInfo(WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder builderForValue) {
                if (this.waterSpiritInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.waterSpiritInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeWaterSpiritInfo(WaterSpiritInfoOuterClass.WaterSpiritInfo value) {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ != 1651 || this.detail_ == WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WaterSpiritInfoOuterClass.WaterSpiritInfo.newBuilder((WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1651) {
                        this.waterSpiritInfoBuilder_.mergeFrom(value);
                    }
                    this.waterSpiritInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearWaterSpiritInfo() {
                if (this.waterSpiritInfoBuilder_ != null) {
                    if (this.detailCase_ == 1651) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.waterSpiritInfoBuilder_.clear();
                } else if (this.detailCase_ == 1651) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder getWaterSpiritInfoBuilder() {
                return getWaterSpiritInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder getWaterSpiritInfoOrBuilder() {
                if (this.detailCase_ == 1651 && this.waterSpiritInfoBuilder_ != null) {
                    return this.waterSpiritInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1651) {
                    return (WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_;
                }
                return WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WaterSpiritInfoOuterClass.WaterSpiritInfo, WaterSpiritInfoOuterClass.WaterSpiritInfo.Builder, WaterSpiritInfoOuterClass.WaterSpiritInfoOrBuilder> getWaterSpiritInfoFieldBuilder() {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ != 1651) {
                        this.detail_ = WaterSpiritInfoOuterClass.WaterSpiritInfo.getDefaultInstance();
                    }
                    this.waterSpiritInfoBuilder_ = new SingleFieldBuilderV3<>((WaterSpiritInfoOuterClass.WaterSpiritInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.WATER_SPIRIT_INFO_FIELD_NUMBER;
                onChanged();
                return this.waterSpiritInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasChallnelerSlabInfo() {
                return this.detailCase_ == 1135;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo getChallnelerSlabInfo() {
                if (this.challnelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ == 1135) {
                        return (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_;
                    }
                    return ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1135) {
                    return this.challnelerSlabInfoBuilder_.getMessage();
                } else {
                    return ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
                }
            }

            public Builder setChallnelerSlabInfo(ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo value) {
                if (this.challnelerSlabInfoBuilder_ != null) {
                    this.challnelerSlabInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setChallnelerSlabInfo(ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.Builder builderForValue) {
                if (this.challnelerSlabInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.challnelerSlabInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeChallnelerSlabInfo(ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo value) {
                if (this.challnelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ != 1135 || this.detail_ == ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.newBuilder((ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1135) {
                        this.challnelerSlabInfoBuilder_.mergeFrom(value);
                    }
                    this.challnelerSlabInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearChallnelerSlabInfo() {
                if (this.challnelerSlabInfoBuilder_ != null) {
                    if (this.detailCase_ == 1135) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.challnelerSlabInfoBuilder_.clear();
                } else if (this.detailCase_ == 1135) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.Builder getChallnelerSlabInfoBuilder() {
                return getChallnelerSlabInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder getChallnelerSlabInfoOrBuilder() {
                if (this.detailCase_ == 1135 && this.challnelerSlabInfoBuilder_ != null) {
                    return this.challnelerSlabInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1135) {
                    return (ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_;
                }
                return ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo, ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.Builder, ChallnelerSlabInfoOuterClass.ChallnelerSlabInfoOrBuilder> getChallnelerSlabInfoFieldBuilder() {
                if (this.challnelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ != 1135) {
                        this.detail_ = ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo.getDefaultInstance();
                    }
                    this.challnelerSlabInfoBuilder_ = new SingleFieldBuilderV3<>((ChallnelerSlabInfoOuterClass.ChallnelerSlabInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.CHALLNELER_SLAB_INFO_FIELD_NUMBER;
                onChanged();
                return this.challnelerSlabInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMistTrialActivityInfo() {
                return this.detailCase_ == 1320;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MistTrialActivityInfoOuterClass.MistTrialActivityInfo getMistTrialActivityInfo() {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 1320) {
                        return (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_;
                    }
                    return MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1320) {
                    return this.mistTrialActivityInfoBuilder_.getMessage();
                } else {
                    return MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
                }
            }

            public Builder setMistTrialActivityInfo(MistTrialActivityInfoOuterClass.MistTrialActivityInfo value) {
                if (this.mistTrialActivityInfoBuilder_ != null) {
                    this.mistTrialActivityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder setMistTrialActivityInfo(MistTrialActivityInfoOuterClass.MistTrialActivityInfo.Builder builderForValue) {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mistTrialActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder mergeMistTrialActivityInfo(MistTrialActivityInfoOuterClass.MistTrialActivityInfo value) {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1320 || this.detail_ == MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MistTrialActivityInfoOuterClass.MistTrialActivityInfo.newBuilder((MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1320) {
                        this.mistTrialActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.mistTrialActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1320;
                return this;
            }

            public Builder clearMistTrialActivityInfo() {
                if (this.mistTrialActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 1320) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.mistTrialActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 1320) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MistTrialActivityInfoOuterClass.MistTrialActivityInfo.Builder getMistTrialActivityInfoBuilder() {
                return getMistTrialActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MistTrialActivityInfoOuterClass.MistTrialActivityInfoOrBuilder getMistTrialActivityInfoOrBuilder() {
                if (this.detailCase_ == 1320 && this.mistTrialActivityInfoBuilder_ != null) {
                    return this.mistTrialActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1320) {
                    return (MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_;
                }
                return MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MistTrialActivityInfoOuterClass.MistTrialActivityInfo, MistTrialActivityInfoOuterClass.MistTrialActivityInfo.Builder, MistTrialActivityInfoOuterClass.MistTrialActivityInfoOrBuilder> getMistTrialActivityInfoFieldBuilder() {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1320) {
                        this.detail_ = MistTrialActivityInfoOuterClass.MistTrialActivityInfo.getDefaultInstance();
                    }
                    this.mistTrialActivityInfoBuilder_ = new SingleFieldBuilderV3<>((MistTrialActivityInfoOuterClass.MistTrialActivityInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1320;
                onChanged();
                return this.mistTrialActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasHideAndSeekInfo() {
                return this.detailCase_ == 1077;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HideAndSeekInfoOuterClass.HideAndSeekInfo getHideAndSeekInfo() {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ == 1077) {
                        return (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_;
                    }
                    return HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1077) {
                    return this.hideAndSeekInfoBuilder_.getMessage();
                } else {
                    return HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
                }
            }

            public Builder setHideAndSeekInfo(HideAndSeekInfoOuterClass.HideAndSeekInfo value) {
                if (this.hideAndSeekInfoBuilder_ != null) {
                    this.hideAndSeekInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setHideAndSeekInfo(HideAndSeekInfoOuterClass.HideAndSeekInfo.Builder builderForValue) {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hideAndSeekInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeHideAndSeekInfo(HideAndSeekInfoOuterClass.HideAndSeekInfo value) {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ != 1077 || this.detail_ == HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = HideAndSeekInfoOuterClass.HideAndSeekInfo.newBuilder((HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1077) {
                        this.hideAndSeekInfoBuilder_.mergeFrom(value);
                    }
                    this.hideAndSeekInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearHideAndSeekInfo() {
                if (this.hideAndSeekInfoBuilder_ != null) {
                    if (this.detailCase_ == 1077) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.hideAndSeekInfoBuilder_.clear();
                } else if (this.detailCase_ == 1077) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public HideAndSeekInfoOuterClass.HideAndSeekInfo.Builder getHideAndSeekInfoBuilder() {
                return getHideAndSeekInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder getHideAndSeekInfoOrBuilder() {
                if (this.detailCase_ == 1077 && this.hideAndSeekInfoBuilder_ != null) {
                    return this.hideAndSeekInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1077) {
                    return (HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_;
                }
                return HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HideAndSeekInfoOuterClass.HideAndSeekInfo, HideAndSeekInfoOuterClass.HideAndSeekInfo.Builder, HideAndSeekInfoOuterClass.HideAndSeekInfoOrBuilder> getHideAndSeekInfoFieldBuilder() {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ != 1077) {
                        this.detail_ = HideAndSeekInfoOuterClass.HideAndSeekInfo.getDefaultInstance();
                    }
                    this.hideAndSeekInfoBuilder_ = new SingleFieldBuilderV3<>((HideAndSeekInfoOuterClass.HideAndSeekInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.HIDE_AND_SEEK_INFO_FIELD_NUMBER;
                onChanged();
                return this.hideAndSeekInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFindHilichurlInfo() {
                return this.detailCase_ == 417;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FindHilichurlInfoOuterClass.FindHilichurlInfo getFindHilichurlInfo() {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ == 417) {
                        return (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_;
                    }
                    return FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
                } else if (this.detailCase_ == 417) {
                    return this.findHilichurlInfoBuilder_.getMessage();
                } else {
                    return FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
                }
            }

            public Builder setFindHilichurlInfo(FindHilichurlInfoOuterClass.FindHilichurlInfo value) {
                if (this.findHilichurlInfoBuilder_ != null) {
                    this.findHilichurlInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 417;
                return this;
            }

            public Builder setFindHilichurlInfo(FindHilichurlInfoOuterClass.FindHilichurlInfo.Builder builderForValue) {
                if (this.findHilichurlInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.findHilichurlInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 417;
                return this;
            }

            public Builder mergeFindHilichurlInfo(FindHilichurlInfoOuterClass.FindHilichurlInfo value) {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ != 417 || this.detail_ == FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FindHilichurlInfoOuterClass.FindHilichurlInfo.newBuilder((FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 417) {
                        this.findHilichurlInfoBuilder_.mergeFrom(value);
                    }
                    this.findHilichurlInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 417;
                return this;
            }

            public Builder clearFindHilichurlInfo() {
                if (this.findHilichurlInfoBuilder_ != null) {
                    if (this.detailCase_ == 417) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.findHilichurlInfoBuilder_.clear();
                } else if (this.detailCase_ == 417) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FindHilichurlInfoOuterClass.FindHilichurlInfo.Builder getFindHilichurlInfoBuilder() {
                return getFindHilichurlInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FindHilichurlInfoOuterClass.FindHilichurlInfoOrBuilder getFindHilichurlInfoOrBuilder() {
                if (this.detailCase_ == 417 && this.findHilichurlInfoBuilder_ != null) {
                    return this.findHilichurlInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 417) {
                    return (FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_;
                }
                return FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FindHilichurlInfoOuterClass.FindHilichurlInfo, FindHilichurlInfoOuterClass.FindHilichurlInfo.Builder, FindHilichurlInfoOuterClass.FindHilichurlInfoOrBuilder> getFindHilichurlInfoFieldBuilder() {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ != 417) {
                        this.detail_ = FindHilichurlInfoOuterClass.FindHilichurlInfo.getDefaultInstance();
                    }
                    this.findHilichurlInfoBuilder_ = new SingleFieldBuilderV3<>((FindHilichurlInfoOuterClass.FindHilichurlInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 417;
                onChanged();
                return this.findHilichurlInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSummerTimeInfo() {
                return this.detailCase_ == 1477;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeInfoOuterClass.SummerTimeInfo getSummerTimeInfo() {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ == 1477) {
                        return (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_;
                    }
                    return SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1477) {
                    return this.summerTimeInfoBuilder_.getMessage();
                } else {
                    return SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
                }
            }

            public Builder setSummerTimeInfo(SummerTimeInfoOuterClass.SummerTimeInfo value) {
                if (this.summerTimeInfoBuilder_ != null) {
                    this.summerTimeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setSummerTimeInfo(SummerTimeInfoOuterClass.SummerTimeInfo.Builder builderForValue) {
                if (this.summerTimeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.summerTimeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSummerTimeInfo(SummerTimeInfoOuterClass.SummerTimeInfo value) {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1477 || this.detail_ == SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SummerTimeInfoOuterClass.SummerTimeInfo.newBuilder((SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1477) {
                        this.summerTimeInfoBuilder_.mergeFrom(value);
                    }
                    this.summerTimeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearSummerTimeInfo() {
                if (this.summerTimeInfoBuilder_ != null) {
                    if (this.detailCase_ == 1477) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.summerTimeInfoBuilder_.clear();
                } else if (this.detailCase_ == 1477) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SummerTimeInfoOuterClass.SummerTimeInfo.Builder getSummerTimeInfoBuilder() {
                return getSummerTimeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder getSummerTimeInfoOrBuilder() {
                if (this.detailCase_ == 1477 && this.summerTimeInfoBuilder_ != null) {
                    return this.summerTimeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1477) {
                    return (SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_;
                }
                return SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SummerTimeInfoOuterClass.SummerTimeInfo, SummerTimeInfoOuterClass.SummerTimeInfo.Builder, SummerTimeInfoOuterClass.SummerTimeInfoOrBuilder> getSummerTimeInfoFieldBuilder() {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1477) {
                        this.detail_ = SummerTimeInfoOuterClass.SummerTimeInfo.getDefaultInstance();
                    }
                    this.summerTimeInfoBuilder_ = new SingleFieldBuilderV3<>((SummerTimeInfoOuterClass.SummerTimeInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.SUMMER_TIME_INFO_FIELD_NUMBER;
                onChanged();
                return this.summerTimeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBuoyantCombatInfo() {
                return this.detailCase_ == 1277;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BuoyantCombatInfoOuterClass.BuoyantCombatInfo getBuoyantCombatInfo() {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ == 1277) {
                        return (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_;
                    }
                    return BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1277) {
                    return this.buoyantCombatInfoBuilder_.getMessage();
                } else {
                    return BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
                }
            }

            public Builder setBuoyantCombatInfo(BuoyantCombatInfoOuterClass.BuoyantCombatInfo value) {
                if (this.buoyantCombatInfoBuilder_ != null) {
                    this.buoyantCombatInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setBuoyantCombatInfo(BuoyantCombatInfoOuterClass.BuoyantCombatInfo.Builder builderForValue) {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.buoyantCombatInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeBuoyantCombatInfo(BuoyantCombatInfoOuterClass.BuoyantCombatInfo value) {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ != 1277 || this.detail_ == BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BuoyantCombatInfoOuterClass.BuoyantCombatInfo.newBuilder((BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1277) {
                        this.buoyantCombatInfoBuilder_.mergeFrom(value);
                    }
                    this.buoyantCombatInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearBuoyantCombatInfo() {
                if (this.buoyantCombatInfoBuilder_ != null) {
                    if (this.detailCase_ == 1277) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.buoyantCombatInfoBuilder_.clear();
                } else if (this.detailCase_ == 1277) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BuoyantCombatInfoOuterClass.BuoyantCombatInfo.Builder getBuoyantCombatInfoBuilder() {
                return getBuoyantCombatInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder getBuoyantCombatInfoOrBuilder() {
                if (this.detailCase_ == 1277 && this.buoyantCombatInfoBuilder_ != null) {
                    return this.buoyantCombatInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1277) {
                    return (BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_;
                }
                return BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BuoyantCombatInfoOuterClass.BuoyantCombatInfo, BuoyantCombatInfoOuterClass.BuoyantCombatInfo.Builder, BuoyantCombatInfoOuterClass.BuoyantCombatInfoOrBuilder> getBuoyantCombatInfoFieldBuilder() {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ != 1277) {
                        this.detail_ = BuoyantCombatInfoOuterClass.BuoyantCombatInfo.getDefaultInstance();
                    }
                    this.buoyantCombatInfoBuilder_ = new SingleFieldBuilderV3<>((BuoyantCombatInfoOuterClass.BuoyantCombatInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.BUOYANT_COMBAT_INFO_FIELD_NUMBER;
                onChanged();
                return this.buoyantCombatInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEchoShellInfo() {
                return this.detailCase_ == 1172;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EchoShellInfoOuterClass.EchoShellInfo getEchoShellInfo() {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ == 1172) {
                        return (EchoShellInfoOuterClass.EchoShellInfo) this.detail_;
                    }
                    return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1172) {
                    return this.echoShellInfoBuilder_.getMessage();
                } else {
                    return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                }
            }

            public Builder setEchoShellInfo(EchoShellInfoOuterClass.EchoShellInfo value) {
                if (this.echoShellInfoBuilder_ != null) {
                    this.echoShellInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setEchoShellInfo(EchoShellInfoOuterClass.EchoShellInfo.Builder builderForValue) {
                if (this.echoShellInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.echoShellInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeEchoShellInfo(EchoShellInfoOuterClass.EchoShellInfo value) {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ != 1172 || this.detail_ == EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EchoShellInfoOuterClass.EchoShellInfo.newBuilder((EchoShellInfoOuterClass.EchoShellInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1172) {
                        this.echoShellInfoBuilder_.mergeFrom(value);
                    }
                    this.echoShellInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearEchoShellInfo() {
                if (this.echoShellInfoBuilder_ != null) {
                    if (this.detailCase_ == 1172) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.echoShellInfoBuilder_.clear();
                } else if (this.detailCase_ == 1172) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EchoShellInfoOuterClass.EchoShellInfo.Builder getEchoShellInfoBuilder() {
                return getEchoShellInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EchoShellInfoOuterClass.EchoShellInfoOrBuilder getEchoShellInfoOrBuilder() {
                if (this.detailCase_ == 1172 && this.echoShellInfoBuilder_ != null) {
                    return this.echoShellInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1172) {
                    return (EchoShellInfoOuterClass.EchoShellInfo) this.detail_;
                }
                return EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EchoShellInfoOuterClass.EchoShellInfo, EchoShellInfoOuterClass.EchoShellInfo.Builder, EchoShellInfoOuterClass.EchoShellInfoOrBuilder> getEchoShellInfoFieldBuilder() {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ != 1172) {
                        this.detail_ = EchoShellInfoOuterClass.EchoShellInfo.getDefaultInstance();
                    }
                    this.echoShellInfoBuilder_ = new SingleFieldBuilderV3<>((EchoShellInfoOuterClass.EchoShellInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                onChanged();
                return this.echoShellInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBounceConjuringInfo() {
                return this.detailCase_ == 278;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BounceConjuringInfoOuterClass.BounceConjuringInfo getBounceConjuringInfo() {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ == 278) {
                        return (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_;
                    }
                    return BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
                } else if (this.detailCase_ == 278) {
                    return this.bounceConjuringInfoBuilder_.getMessage();
                } else {
                    return BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
                }
            }

            public Builder setBounceConjuringInfo(BounceConjuringInfoOuterClass.BounceConjuringInfo value) {
                if (this.bounceConjuringInfoBuilder_ != null) {
                    this.bounceConjuringInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 278;
                return this;
            }

            public Builder setBounceConjuringInfo(BounceConjuringInfoOuterClass.BounceConjuringInfo.Builder builderForValue) {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bounceConjuringInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 278;
                return this;
            }

            public Builder mergeBounceConjuringInfo(BounceConjuringInfoOuterClass.BounceConjuringInfo value) {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ != 278 || this.detail_ == BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BounceConjuringInfoOuterClass.BounceConjuringInfo.newBuilder((BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 278) {
                        this.bounceConjuringInfoBuilder_.mergeFrom(value);
                    }
                    this.bounceConjuringInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 278;
                return this;
            }

            public Builder clearBounceConjuringInfo() {
                if (this.bounceConjuringInfoBuilder_ != null) {
                    if (this.detailCase_ == 278) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bounceConjuringInfoBuilder_.clear();
                } else if (this.detailCase_ == 278) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BounceConjuringInfoOuterClass.BounceConjuringInfo.Builder getBounceConjuringInfoBuilder() {
                return getBounceConjuringInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder getBounceConjuringInfoOrBuilder() {
                if (this.detailCase_ == 278 && this.bounceConjuringInfoBuilder_ != null) {
                    return this.bounceConjuringInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 278) {
                    return (BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_;
                }
                return BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BounceConjuringInfoOuterClass.BounceConjuringInfo, BounceConjuringInfoOuterClass.BounceConjuringInfo.Builder, BounceConjuringInfoOuterClass.BounceConjuringInfoOrBuilder> getBounceConjuringInfoFieldBuilder() {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ != 278) {
                        this.detail_ = BounceConjuringInfoOuterClass.BounceConjuringInfo.getDefaultInstance();
                    }
                    this.bounceConjuringInfoBuilder_ = new SingleFieldBuilderV3<>((BounceConjuringInfoOuterClass.BounceConjuringInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 278;
                onChanged();
                return this.bounceConjuringInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBlitzRushInfo() {
                return this.detailCase_ == 192;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlitzRushInfoOuterClass.BlitzRushInfo getBlitzRushInfo() {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ == 192) {
                        return (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_;
                    }
                    return BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
                } else if (this.detailCase_ == 192) {
                    return this.blitzRushInfoBuilder_.getMessage();
                } else {
                    return BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
                }
            }

            public Builder setBlitzRushInfo(BlitzRushInfoOuterClass.BlitzRushInfo value) {
                if (this.blitzRushInfoBuilder_ != null) {
                    this.blitzRushInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 192;
                return this;
            }

            public Builder setBlitzRushInfo(BlitzRushInfoOuterClass.BlitzRushInfo.Builder builderForValue) {
                if (this.blitzRushInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blitzRushInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 192;
                return this;
            }

            public Builder mergeBlitzRushInfo(BlitzRushInfoOuterClass.BlitzRushInfo value) {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ != 192 || this.detail_ == BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BlitzRushInfoOuterClass.BlitzRushInfo.newBuilder((BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 192) {
                        this.blitzRushInfoBuilder_.mergeFrom(value);
                    }
                    this.blitzRushInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 192;
                return this;
            }

            public Builder clearBlitzRushInfo() {
                if (this.blitzRushInfoBuilder_ != null) {
                    if (this.detailCase_ == 192) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.blitzRushInfoBuilder_.clear();
                } else if (this.detailCase_ == 192) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BlitzRushInfoOuterClass.BlitzRushInfo.Builder getBlitzRushInfoBuilder() {
                return getBlitzRushInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlitzRushInfoOuterClass.BlitzRushInfoOrBuilder getBlitzRushInfoOrBuilder() {
                if (this.detailCase_ == 192 && this.blitzRushInfoBuilder_ != null) {
                    return this.blitzRushInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 192) {
                    return (BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_;
                }
                return BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BlitzRushInfoOuterClass.BlitzRushInfo, BlitzRushInfoOuterClass.BlitzRushInfo.Builder, BlitzRushInfoOuterClass.BlitzRushInfoOrBuilder> getBlitzRushInfoFieldBuilder() {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ != 192) {
                        this.detail_ = BlitzRushInfoOuterClass.BlitzRushInfo.getDefaultInstance();
                    }
                    this.blitzRushInfoBuilder_ = new SingleFieldBuilderV3<>((BlitzRushInfoOuterClass.BlitzRushInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 192;
                onChanged();
                return this.blitzRushInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasChessInfo() {
                return this.detailCase_ == 1797;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChessInfoOuterClass.ChessInfo getChessInfo() {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ == 1797) {
                        return (ChessInfoOuterClass.ChessInfo) this.detail_;
                    }
                    return ChessInfoOuterClass.ChessInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1797) {
                    return this.chessInfoBuilder_.getMessage();
                } else {
                    return ChessInfoOuterClass.ChessInfo.getDefaultInstance();
                }
            }

            public Builder setChessInfo(ChessInfoOuterClass.ChessInfo value) {
                if (this.chessInfoBuilder_ != null) {
                    this.chessInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder setChessInfo(ChessInfoOuterClass.ChessInfo.Builder builderForValue) {
                if (this.chessInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chessInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder mergeChessInfo(ChessInfoOuterClass.ChessInfo value) {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ != 1797 || this.detail_ == ChessInfoOuterClass.ChessInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChessInfoOuterClass.ChessInfo.newBuilder((ChessInfoOuterClass.ChessInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1797) {
                        this.chessInfoBuilder_.mergeFrom(value);
                    }
                    this.chessInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1797;
                return this;
            }

            public Builder clearChessInfo() {
                if (this.chessInfoBuilder_ != null) {
                    if (this.detailCase_ == 1797) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.chessInfoBuilder_.clear();
                } else if (this.detailCase_ == 1797) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChessInfoOuterClass.ChessInfo.Builder getChessInfoBuilder() {
                return getChessInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChessInfoOuterClass.ChessInfoOrBuilder getChessInfoOrBuilder() {
                if (this.detailCase_ == 1797 && this.chessInfoBuilder_ != null) {
                    return this.chessInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1797) {
                    return (ChessInfoOuterClass.ChessInfo) this.detail_;
                }
                return ChessInfoOuterClass.ChessInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChessInfoOuterClass.ChessInfo, ChessInfoOuterClass.ChessInfo.Builder, ChessInfoOuterClass.ChessInfoOrBuilder> getChessInfoFieldBuilder() {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ != 1797) {
                        this.detail_ = ChessInfoOuterClass.ChessInfo.getDefaultInstance();
                    }
                    this.chessInfoBuilder_ = new SingleFieldBuilderV3<>((ChessInfoOuterClass.ChessInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1797;
                onChanged();
                return this.chessInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSumoInfo() {
                return this.detailCase_ == 1379;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SumoInfoOuterClass.SumoInfo getSumoInfo() {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ == 1379) {
                        return (SumoInfoOuterClass.SumoInfo) this.detail_;
                    }
                    return SumoInfoOuterClass.SumoInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1379) {
                    return this.sumoInfoBuilder_.getMessage();
                } else {
                    return SumoInfoOuterClass.SumoInfo.getDefaultInstance();
                }
            }

            public Builder setSumoInfo(SumoInfoOuterClass.SumoInfo value) {
                if (this.sumoInfoBuilder_ != null) {
                    this.sumoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.SUMO_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setSumoInfo(SumoInfoOuterClass.SumoInfo.Builder builderForValue) {
                if (this.sumoInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sumoInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.SUMO_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSumoInfo(SumoInfoOuterClass.SumoInfo value) {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ != 1379 || this.detail_ == SumoInfoOuterClass.SumoInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SumoInfoOuterClass.SumoInfo.newBuilder((SumoInfoOuterClass.SumoInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1379) {
                        this.sumoInfoBuilder_.mergeFrom(value);
                    }
                    this.sumoInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.SUMO_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearSumoInfo() {
                if (this.sumoInfoBuilder_ != null) {
                    if (this.detailCase_ == 1379) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.sumoInfoBuilder_.clear();
                } else if (this.detailCase_ == 1379) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SumoInfoOuterClass.SumoInfo.Builder getSumoInfoBuilder() {
                return getSumoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SumoInfoOuterClass.SumoInfoOrBuilder getSumoInfoOrBuilder() {
                if (this.detailCase_ == 1379 && this.sumoInfoBuilder_ != null) {
                    return this.sumoInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1379) {
                    return (SumoInfoOuterClass.SumoInfo) this.detail_;
                }
                return SumoInfoOuterClass.SumoInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SumoInfoOuterClass.SumoInfo, SumoInfoOuterClass.SumoInfo.Builder, SumoInfoOuterClass.SumoInfoOrBuilder> getSumoInfoFieldBuilder() {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ != 1379) {
                        this.detail_ = SumoInfoOuterClass.SumoInfo.getDefaultInstance();
                    }
                    this.sumoInfoBuilder_ = new SingleFieldBuilderV3<>((SumoInfoOuterClass.SumoInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.SUMO_INFO_FIELD_NUMBER;
                onChanged();
                return this.sumoInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMoonfinTrialInfo() {
                return this.detailCase_ == 1122;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MoonfinTrialInfoOuterClass.MoonfinTrialInfo getMoonfinTrialInfo() {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ == 1122) {
                        return (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_;
                    }
                    return MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1122) {
                    return this.moonfinTrialInfoBuilder_.getMessage();
                } else {
                    return MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
                }
            }

            public Builder setMoonfinTrialInfo(MoonfinTrialInfoOuterClass.MoonfinTrialInfo value) {
                if (this.moonfinTrialInfoBuilder_ != null) {
                    this.moonfinTrialInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1122;
                return this;
            }

            public Builder setMoonfinTrialInfo(MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder builderForValue) {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.moonfinTrialInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1122;
                return this;
            }

            public Builder mergeMoonfinTrialInfo(MoonfinTrialInfoOuterClass.MoonfinTrialInfo value) {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ != 1122 || this.detail_ == MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MoonfinTrialInfoOuterClass.MoonfinTrialInfo.newBuilder((MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1122) {
                        this.moonfinTrialInfoBuilder_.mergeFrom(value);
                    }
                    this.moonfinTrialInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1122;
                return this;
            }

            public Builder clearMoonfinTrialInfo() {
                if (this.moonfinTrialInfoBuilder_ != null) {
                    if (this.detailCase_ == 1122) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.moonfinTrialInfoBuilder_.clear();
                } else if (this.detailCase_ == 1122) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder getMoonfinTrialInfoBuilder() {
                return getMoonfinTrialInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder getMoonfinTrialInfoOrBuilder() {
                if (this.detailCase_ == 1122 && this.moonfinTrialInfoBuilder_ != null) {
                    return this.moonfinTrialInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1122) {
                    return (MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_;
                }
                return MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MoonfinTrialInfoOuterClass.MoonfinTrialInfo, MoonfinTrialInfoOuterClass.MoonfinTrialInfo.Builder, MoonfinTrialInfoOuterClass.MoonfinTrialInfoOrBuilder> getMoonfinTrialInfoFieldBuilder() {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ != 1122) {
                        this.detail_ = MoonfinTrialInfoOuterClass.MoonfinTrialInfo.getDefaultInstance();
                    }
                    this.moonfinTrialInfoBuilder_ = new SingleFieldBuilderV3<>((MoonfinTrialInfoOuterClass.MoonfinTrialInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1122;
                onChanged();
                return this.moonfinTrialInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLunaRiteInfo() {
                return this.detailCase_ == 82;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LunaRiteInfoOuterClass.LunaRiteInfo getLunaRiteInfo() {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ == 82) {
                        return (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_;
                    }
                    return LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
                } else if (this.detailCase_ == 82) {
                    return this.lunaRiteInfoBuilder_.getMessage();
                } else {
                    return LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
                }
            }

            public Builder setLunaRiteInfo(LunaRiteInfoOuterClass.LunaRiteInfo value) {
                if (this.lunaRiteInfoBuilder_ != null) {
                    this.lunaRiteInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 82;
                return this;
            }

            public Builder setLunaRiteInfo(LunaRiteInfoOuterClass.LunaRiteInfo.Builder builderForValue) {
                if (this.lunaRiteInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lunaRiteInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 82;
                return this;
            }

            public Builder mergeLunaRiteInfo(LunaRiteInfoOuterClass.LunaRiteInfo value) {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ != 82 || this.detail_ == LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LunaRiteInfoOuterClass.LunaRiteInfo.newBuilder((LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 82) {
                        this.lunaRiteInfoBuilder_.mergeFrom(value);
                    }
                    this.lunaRiteInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 82;
                return this;
            }

            public Builder clearLunaRiteInfo() {
                if (this.lunaRiteInfoBuilder_ != null) {
                    if (this.detailCase_ == 82) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.lunaRiteInfoBuilder_.clear();
                } else if (this.detailCase_ == 82) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LunaRiteInfoOuterClass.LunaRiteInfo.Builder getLunaRiteInfoBuilder() {
                return getLunaRiteInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LunaRiteInfoOuterClass.LunaRiteInfoOrBuilder getLunaRiteInfoOrBuilder() {
                if (this.detailCase_ == 82 && this.lunaRiteInfoBuilder_ != null) {
                    return this.lunaRiteInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 82) {
                    return (LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_;
                }
                return LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LunaRiteInfoOuterClass.LunaRiteInfo, LunaRiteInfoOuterClass.LunaRiteInfo.Builder, LunaRiteInfoOuterClass.LunaRiteInfoOrBuilder> getLunaRiteInfoFieldBuilder() {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ != 82) {
                        this.detail_ = LunaRiteInfoOuterClass.LunaRiteInfo.getDefaultInstance();
                    }
                    this.lunaRiteInfoBuilder_ = new SingleFieldBuilderV3<>((LunaRiteInfoOuterClass.LunaRiteInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 82;
                onChanged();
                return this.lunaRiteInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPlantFlowerInfo() {
                return this.detailCase_ == 1864;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PlantFlowerInfoOuterClass.PlantFlowerInfo getPlantFlowerInfo() {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ == 1864) {
                        return (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_;
                    }
                    return PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1864) {
                    return this.plantFlowerInfoBuilder_.getMessage();
                } else {
                    return PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
                }
            }

            public Builder setPlantFlowerInfo(PlantFlowerInfoOuterClass.PlantFlowerInfo value) {
                if (this.plantFlowerInfoBuilder_ != null) {
                    this.plantFlowerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setPlantFlowerInfo(PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder builderForValue) {
                if (this.plantFlowerInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.plantFlowerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergePlantFlowerInfo(PlantFlowerInfoOuterClass.PlantFlowerInfo value) {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1864 || this.detail_ == PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PlantFlowerInfoOuterClass.PlantFlowerInfo.newBuilder((PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1864) {
                        this.plantFlowerInfoBuilder_.mergeFrom(value);
                    }
                    this.plantFlowerInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearPlantFlowerInfo() {
                if (this.plantFlowerInfoBuilder_ != null) {
                    if (this.detailCase_ == 1864) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.plantFlowerInfoBuilder_.clear();
                } else if (this.detailCase_ == 1864) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder getPlantFlowerInfoBuilder() {
                return getPlantFlowerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder getPlantFlowerInfoOrBuilder() {
                if (this.detailCase_ == 1864 && this.plantFlowerInfoBuilder_ != null) {
                    return this.plantFlowerInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1864) {
                    return (PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_;
                }
                return PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PlantFlowerInfoOuterClass.PlantFlowerInfo, PlantFlowerInfoOuterClass.PlantFlowerInfo.Builder, PlantFlowerInfoOuterClass.PlantFlowerInfoOrBuilder> getPlantFlowerInfoFieldBuilder() {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1864) {
                        this.detail_ = PlantFlowerInfoOuterClass.PlantFlowerInfo.getDefaultInstance();
                    }
                    this.plantFlowerInfoBuilder_ = new SingleFieldBuilderV3<>((PlantFlowerInfoOuterClass.PlantFlowerInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                onChanged();
                return this.plantFlowerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMusicGameInfo() {
                return this.detailCase_ == 1220;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo() {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ == 1220) {
                        return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
                    }
                    return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1220) {
                    return this.musicGameInfoBuilder_.getMessage();
                } else {
                    return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo value) {
                if (this.musicGameInfoBuilder_ != null) {
                    this.musicGameInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1220;
                return this;
            }

            public Builder setMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder builderForValue) {
                if (this.musicGameInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicGameInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1220;
                return this;
            }

            public Builder mergeMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo value) {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ != 1220 || this.detail_ == MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.newBuilder((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1220) {
                        this.musicGameInfoBuilder_.mergeFrom(value);
                    }
                    this.musicGameInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1220;
                return this;
            }

            public Builder clearMusicGameInfo() {
                if (this.musicGameInfoBuilder_ != null) {
                    if (this.detailCase_ == 1220) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.musicGameInfoBuilder_.clear();
                } else if (this.detailCase_ == 1220) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder getMusicGameInfoBuilder() {
                return getMusicGameInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder getMusicGameInfoOrBuilder() {
                if (this.detailCase_ == 1220 && this.musicGameInfoBuilder_ != null) {
                    return this.musicGameInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1220) {
                    return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
                }
                return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder> getMusicGameInfoFieldBuilder() {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ != 1220) {
                        this.detail_ = MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
                    }
                    this.musicGameInfoBuilder_ = new SingleFieldBuilderV3<>((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1220;
                onChanged();
                return this.musicGameInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRoguelikeDungoenInfo() {
                return this.detailCase_ == 1817;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo getRoguelikeDungoenInfo() {
                if (this.roguelikeDungoenInfoBuilder_ == null) {
                    if (this.detailCase_ == 1817) {
                        return (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_;
                    }
                    return RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1817) {
                    return this.roguelikeDungoenInfoBuilder_.getMessage();
                } else {
                    return RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
                }
            }

            public Builder setRoguelikeDungoenInfo(RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo value) {
                if (this.roguelikeDungoenInfoBuilder_ != null) {
                    this.roguelikeDungoenInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setRoguelikeDungoenInfo(RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.Builder builderForValue) {
                if (this.roguelikeDungoenInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.roguelikeDungoenInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRoguelikeDungoenInfo(RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo value) {
                if (this.roguelikeDungoenInfoBuilder_ == null) {
                    if (this.detailCase_ != 1817 || this.detail_ == RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.newBuilder((RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1817) {
                        this.roguelikeDungoenInfoBuilder_.mergeFrom(value);
                    }
                    this.roguelikeDungoenInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearRoguelikeDungoenInfo() {
                if (this.roguelikeDungoenInfoBuilder_ != null) {
                    if (this.detailCase_ == 1817) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.roguelikeDungoenInfoBuilder_.clear();
                } else if (this.detailCase_ == 1817) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.Builder getRoguelikeDungoenInfoBuilder() {
                return getRoguelikeDungoenInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder getRoguelikeDungoenInfoOrBuilder() {
                if (this.detailCase_ == 1817 && this.roguelikeDungoenInfoBuilder_ != null) {
                    return this.roguelikeDungoenInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1817) {
                    return (RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_;
                }
                return RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo, RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.Builder, RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder> getRoguelikeDungoenInfoFieldBuilder() {
                if (this.roguelikeDungoenInfoBuilder_ == null) {
                    if (this.detailCase_ != 1817) {
                        this.detail_ = RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.getDefaultInstance();
                    }
                    this.roguelikeDungoenInfoBuilder_ = new SingleFieldBuilderV3<>((RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGOEN_INFO_FIELD_NUMBER;
                onChanged();
                return this.roguelikeDungoenInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDigInfo() {
                return this.detailCase_ == 168;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DigInfoOuterClass.DigInfo getDigInfo() {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ == 168) {
                        return (DigInfoOuterClass.DigInfo) this.detail_;
                    }
                    return DigInfoOuterClass.DigInfo.getDefaultInstance();
                } else if (this.detailCase_ == 168) {
                    return this.digInfoBuilder_.getMessage();
                } else {
                    return DigInfoOuterClass.DigInfo.getDefaultInstance();
                }
            }

            public Builder setDigInfo(DigInfoOuterClass.DigInfo value) {
                if (this.digInfoBuilder_ != null) {
                    this.digInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 168;
                return this;
            }

            public Builder setDigInfo(DigInfoOuterClass.DigInfo.Builder builderForValue) {
                if (this.digInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.digInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 168;
                return this;
            }

            public Builder mergeDigInfo(DigInfoOuterClass.DigInfo value) {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ != 168 || this.detail_ == DigInfoOuterClass.DigInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DigInfoOuterClass.DigInfo.newBuilder((DigInfoOuterClass.DigInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 168) {
                        this.digInfoBuilder_.mergeFrom(value);
                    }
                    this.digInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 168;
                return this;
            }

            public Builder clearDigInfo() {
                if (this.digInfoBuilder_ != null) {
                    if (this.detailCase_ == 168) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.digInfoBuilder_.clear();
                } else if (this.detailCase_ == 168) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DigInfoOuterClass.DigInfo.Builder getDigInfoBuilder() {
                return getDigInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DigInfoOuterClass.DigInfoOrBuilder getDigInfoOrBuilder() {
                if (this.detailCase_ == 168 && this.digInfoBuilder_ != null) {
                    return this.digInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 168) {
                    return (DigInfoOuterClass.DigInfo) this.detail_;
                }
                return DigInfoOuterClass.DigInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DigInfoOuterClass.DigInfo, DigInfoOuterClass.DigInfo.Builder, DigInfoOuterClass.DigInfoOrBuilder> getDigInfoFieldBuilder() {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ != 168) {
                        this.detail_ = DigInfoOuterClass.DigInfo.getDefaultInstance();
                    }
                    this.digInfoBuilder_ = new SingleFieldBuilderV3<>((DigInfoOuterClass.DigInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 168;
                onChanged();
                return this.digInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasHachiInfo() {
                return this.detailCase_ == 1663;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HachiInfoOuterClass.HachiInfo getHachiInfo() {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ == 1663) {
                        return (HachiInfoOuterClass.HachiInfo) this.detail_;
                    }
                    return HachiInfoOuterClass.HachiInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1663) {
                    return this.hachiInfoBuilder_.getMessage();
                } else {
                    return HachiInfoOuterClass.HachiInfo.getDefaultInstance();
                }
            }

            public Builder setHachiInfo(HachiInfoOuterClass.HachiInfo value) {
                if (this.hachiInfoBuilder_ != null) {
                    this.hachiInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1663;
                return this;
            }

            public Builder setHachiInfo(HachiInfoOuterClass.HachiInfo.Builder builderForValue) {
                if (this.hachiInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hachiInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1663;
                return this;
            }

            public Builder mergeHachiInfo(HachiInfoOuterClass.HachiInfo value) {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ != 1663 || this.detail_ == HachiInfoOuterClass.HachiInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = HachiInfoOuterClass.HachiInfo.newBuilder((HachiInfoOuterClass.HachiInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1663) {
                        this.hachiInfoBuilder_.mergeFrom(value);
                    }
                    this.hachiInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1663;
                return this;
            }

            public Builder clearHachiInfo() {
                if (this.hachiInfoBuilder_ != null) {
                    if (this.detailCase_ == 1663) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.hachiInfoBuilder_.clear();
                } else if (this.detailCase_ == 1663) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public HachiInfoOuterClass.HachiInfo.Builder getHachiInfoBuilder() {
                return getHachiInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HachiInfoOuterClass.HachiInfoOrBuilder getHachiInfoOrBuilder() {
                if (this.detailCase_ == 1663 && this.hachiInfoBuilder_ != null) {
                    return this.hachiInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1663) {
                    return (HachiInfoOuterClass.HachiInfo) this.detail_;
                }
                return HachiInfoOuterClass.HachiInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HachiInfoOuterClass.HachiInfo, HachiInfoOuterClass.HachiInfo.Builder, HachiInfoOuterClass.HachiInfoOrBuilder> getHachiInfoFieldBuilder() {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ != 1663) {
                        this.detail_ = HachiInfoOuterClass.HachiInfo.getDefaultInstance();
                    }
                    this.hachiInfoBuilder_ = new SingleFieldBuilderV3<>((HachiInfoOuterClass.HachiInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1663;
                onChanged();
                return this.hachiInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWinterCampInfo() {
                return this.detailCase_ == 114;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WinterCampInfoOuterClass.WinterCampInfo getWinterCampInfo() {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ == 114) {
                        return (WinterCampInfoOuterClass.WinterCampInfo) this.detail_;
                    }
                    return WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
                } else if (this.detailCase_ == 114) {
                    return this.winterCampInfoBuilder_.getMessage();
                } else {
                    return WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
                }
            }

            public Builder setWinterCampInfo(WinterCampInfoOuterClass.WinterCampInfo value) {
                if (this.winterCampInfoBuilder_ != null) {
                    this.winterCampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 114;
                return this;
            }

            public Builder setWinterCampInfo(WinterCampInfoOuterClass.WinterCampInfo.Builder builderForValue) {
                if (this.winterCampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.winterCampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 114;
                return this;
            }

            public Builder mergeWinterCampInfo(WinterCampInfoOuterClass.WinterCampInfo value) {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ != 114 || this.detail_ == WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WinterCampInfoOuterClass.WinterCampInfo.newBuilder((WinterCampInfoOuterClass.WinterCampInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 114) {
                        this.winterCampInfoBuilder_.mergeFrom(value);
                    }
                    this.winterCampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 114;
                return this;
            }

            public Builder clearWinterCampInfo() {
                if (this.winterCampInfoBuilder_ != null) {
                    if (this.detailCase_ == 114) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.winterCampInfoBuilder_.clear();
                } else if (this.detailCase_ == 114) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WinterCampInfoOuterClass.WinterCampInfo.Builder getWinterCampInfoBuilder() {
                return getWinterCampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WinterCampInfoOuterClass.WinterCampInfoOrBuilder getWinterCampInfoOrBuilder() {
                if (this.detailCase_ == 114 && this.winterCampInfoBuilder_ != null) {
                    return this.winterCampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 114) {
                    return (WinterCampInfoOuterClass.WinterCampInfo) this.detail_;
                }
                return WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WinterCampInfoOuterClass.WinterCampInfo, WinterCampInfoOuterClass.WinterCampInfo.Builder, WinterCampInfoOuterClass.WinterCampInfoOrBuilder> getWinterCampInfoFieldBuilder() {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ != 114) {
                        this.detail_ = WinterCampInfoOuterClass.WinterCampInfo.getDefaultInstance();
                    }
                    this.winterCampInfoBuilder_ = new SingleFieldBuilderV3<>((WinterCampInfoOuterClass.WinterCampInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 114;
                onChanged();
                return this.winterCampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPotionInfo() {
                return this.detailCase_ == 1552;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PotionInfoOuterClass.PotionInfo getPotionInfo() {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ == 1552) {
                        return (PotionInfoOuterClass.PotionInfo) this.detail_;
                    }
                    return PotionInfoOuterClass.PotionInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1552) {
                    return this.potionInfoBuilder_.getMessage();
                } else {
                    return PotionInfoOuterClass.PotionInfo.getDefaultInstance();
                }
            }

            public Builder setPotionInfo(PotionInfoOuterClass.PotionInfo value) {
                if (this.potionInfoBuilder_ != null) {
                    this.potionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setPotionInfo(PotionInfoOuterClass.PotionInfo.Builder builderForValue) {
                if (this.potionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.potionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergePotionInfo(PotionInfoOuterClass.PotionInfo value) {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1552 || this.detail_ == PotionInfoOuterClass.PotionInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PotionInfoOuterClass.PotionInfo.newBuilder((PotionInfoOuterClass.PotionInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1552) {
                        this.potionInfoBuilder_.mergeFrom(value);
                    }
                    this.potionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearPotionInfo() {
                if (this.potionInfoBuilder_ != null) {
                    if (this.detailCase_ == 1552) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.potionInfoBuilder_.clear();
                } else if (this.detailCase_ == 1552) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PotionInfoOuterClass.PotionInfo.Builder getPotionInfoBuilder() {
                return getPotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PotionInfoOuterClass.PotionInfoOrBuilder getPotionInfoOrBuilder() {
                if (this.detailCase_ == 1552 && this.potionInfoBuilder_ != null) {
                    return this.potionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1552) {
                    return (PotionInfoOuterClass.PotionInfo) this.detail_;
                }
                return PotionInfoOuterClass.PotionInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PotionInfoOuterClass.PotionInfo, PotionInfoOuterClass.PotionInfo.Builder, PotionInfoOuterClass.PotionInfoOrBuilder> getPotionInfoFieldBuilder() {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1552) {
                        this.detail_ = PotionInfoOuterClass.PotionInfo.getDefaultInstance();
                    }
                    this.potionInfoBuilder_ = new SingleFieldBuilderV3<>((PotionInfoOuterClass.PotionInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                onChanged();
                return this.potionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTanukiTravelActivityInfo() {
                return this.detailCase_ == 1453;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo getTanukiTravelActivityInfo() {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 1453) {
                        return (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_;
                    }
                    return TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1453) {
                    return this.tanukiTravelActivityInfoBuilder_.getMessage();
                } else {
                    return TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
                }
            }

            public Builder setTanukiTravelActivityInfo(TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo value) {
                if (this.tanukiTravelActivityInfoBuilder_ != null) {
                    this.tanukiTravelActivityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setTanukiTravelActivityInfo(TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.Builder builderForValue) {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.tanukiTravelActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTanukiTravelActivityInfo(TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo value) {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1453 || this.detail_ == TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.newBuilder((TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1453) {
                        this.tanukiTravelActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.tanukiTravelActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTanukiTravelActivityInfo() {
                if (this.tanukiTravelActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 1453) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.tanukiTravelActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 1453) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.Builder getTanukiTravelActivityInfoBuilder() {
                return getTanukiTravelActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder getTanukiTravelActivityInfoOrBuilder() {
                if (this.detailCase_ == 1453 && this.tanukiTravelActivityInfoBuilder_ != null) {
                    return this.tanukiTravelActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1453) {
                    return (TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_;
                }
                return TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo, TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.Builder, TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfoOrBuilder> getTanukiTravelActivityInfoFieldBuilder() {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1453) {
                        this.detail_ = TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo.getDefaultInstance();
                    }
                    this.tanukiTravelActivityInfoBuilder_ = new SingleFieldBuilderV3<>((TanukiTravelActivityInfoOuterClass.TanukiTravelActivityInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                onChanged();
                return this.tanukiTravelActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLanternRiteActivityInfo() {
                return this.detailCase_ == 1372;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo getLanternRiteActivityInfo() {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 1372) {
                        return (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_;
                    }
                    return LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1372) {
                    return this.lanternRiteActivityInfoBuilder_.getMessage();
                } else {
                    return LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
                }
            }

            public Builder setLanternRiteActivityInfo(LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo value) {
                if (this.lanternRiteActivityInfoBuilder_ != null) {
                    this.lanternRiteActivityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setLanternRiteActivityInfo(LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.Builder builderForValue) {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lanternRiteActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeLanternRiteActivityInfo(LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo value) {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1372 || this.detail_ == LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.newBuilder((LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1372) {
                        this.lanternRiteActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.lanternRiteActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearLanternRiteActivityInfo() {
                if (this.lanternRiteActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 1372) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.lanternRiteActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 1372) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.Builder getLanternRiteActivityInfoBuilder() {
                return getLanternRiteActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder getLanternRiteActivityInfoOrBuilder() {
                if (this.detailCase_ == 1372 && this.lanternRiteActivityInfoBuilder_ != null) {
                    return this.lanternRiteActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1372) {
                    return (LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_;
                }
                return LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo, LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.Builder, LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder> getLanternRiteActivityInfoFieldBuilder() {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1372) {
                        this.detail_ = LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.getDefaultInstance();
                    }
                    this.lanternRiteActivityInfoBuilder_ = new SingleFieldBuilderV3<>((LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER;
                onChanged();
                return this.lanternRiteActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMichiaeMatsuriInfo() {
                return this.detailCase_ == 428;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo getMichiaeMatsuriInfo() {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ == 428) {
                        return (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_;
                    }
                    return MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
                } else if (this.detailCase_ == 428) {
                    return this.michiaeMatsuriInfoBuilder_.getMessage();
                } else {
                    return MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
                }
            }

            public Builder setMichiaeMatsuriInfo(MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo value) {
                if (this.michiaeMatsuriInfoBuilder_ != null) {
                    this.michiaeMatsuriInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 428;
                return this;
            }

            public Builder setMichiaeMatsuriInfo(MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.Builder builderForValue) {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.michiaeMatsuriInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 428;
                return this;
            }

            public Builder mergeMichiaeMatsuriInfo(MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo value) {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ != 428 || this.detail_ == MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.newBuilder((MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 428) {
                        this.michiaeMatsuriInfoBuilder_.mergeFrom(value);
                    }
                    this.michiaeMatsuriInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 428;
                return this;
            }

            public Builder clearMichiaeMatsuriInfo() {
                if (this.michiaeMatsuriInfoBuilder_ != null) {
                    if (this.detailCase_ == 428) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.michiaeMatsuriInfoBuilder_.clear();
                } else if (this.detailCase_ == 428) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.Builder getMichiaeMatsuriInfoBuilder() {
                return getMichiaeMatsuriInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder getMichiaeMatsuriInfoOrBuilder() {
                if (this.detailCase_ == 428 && this.michiaeMatsuriInfoBuilder_ != null) {
                    return this.michiaeMatsuriInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 428) {
                    return (MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_;
                }
                return MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo, MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.Builder, MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfoOrBuilder> getMichiaeMatsuriInfoFieldBuilder() {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ != 428) {
                        this.detail_ = MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo.getDefaultInstance();
                    }
                    this.michiaeMatsuriInfoBuilder_ = new SingleFieldBuilderV3<>((MichiaeMatsuriInfoOuterClass.MichiaeMatsuriInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 428;
                onChanged();
                return this.michiaeMatsuriInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBartenderInfo() {
                return this.detailCase_ == 35;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BartenderInfoOuterClass.BartenderInfo getBartenderInfo() {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ == 35) {
                        return (BartenderInfoOuterClass.BartenderInfo) this.detail_;
                    }
                    return BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
                } else if (this.detailCase_ == 35) {
                    return this.bartenderInfoBuilder_.getMessage();
                } else {
                    return BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
                }
            }

            public Builder setBartenderInfo(BartenderInfoOuterClass.BartenderInfo value) {
                if (this.bartenderInfoBuilder_ != null) {
                    this.bartenderInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 35;
                return this;
            }

            public Builder setBartenderInfo(BartenderInfoOuterClass.BartenderInfo.Builder builderForValue) {
                if (this.bartenderInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bartenderInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 35;
                return this;
            }

            public Builder mergeBartenderInfo(BartenderInfoOuterClass.BartenderInfo value) {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ != 35 || this.detail_ == BartenderInfoOuterClass.BartenderInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BartenderInfoOuterClass.BartenderInfo.newBuilder((BartenderInfoOuterClass.BartenderInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 35) {
                        this.bartenderInfoBuilder_.mergeFrom(value);
                    }
                    this.bartenderInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 35;
                return this;
            }

            public Builder clearBartenderInfo() {
                if (this.bartenderInfoBuilder_ != null) {
                    if (this.detailCase_ == 35) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bartenderInfoBuilder_.clear();
                } else if (this.detailCase_ == 35) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BartenderInfoOuterClass.BartenderInfo.Builder getBartenderInfoBuilder() {
                return getBartenderInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BartenderInfoOuterClass.BartenderInfoOrBuilder getBartenderInfoOrBuilder() {
                if (this.detailCase_ == 35 && this.bartenderInfoBuilder_ != null) {
                    return this.bartenderInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 35) {
                    return (BartenderInfoOuterClass.BartenderInfo) this.detail_;
                }
                return BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BartenderInfoOuterClass.BartenderInfo, BartenderInfoOuterClass.BartenderInfo.Builder, BartenderInfoOuterClass.BartenderInfoOrBuilder> getBartenderInfoFieldBuilder() {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ != 35) {
                        this.detail_ = BartenderInfoOuterClass.BartenderInfo.getDefaultInstance();
                    }
                    this.bartenderInfoBuilder_ = new SingleFieldBuilderV3<>((BartenderInfoOuterClass.BartenderInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 35;
                onChanged();
                return this.bartenderInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasUgcInfo() {
                return this.detailCase_ == 589;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public UgcInfoOuterClass.UgcInfo getUgcInfo() {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ == 589) {
                        return (UgcInfoOuterClass.UgcInfo) this.detail_;
                    }
                    return UgcInfoOuterClass.UgcInfo.getDefaultInstance();
                } else if (this.detailCase_ == 589) {
                    return this.ugcInfoBuilder_.getMessage();
                } else {
                    return UgcInfoOuterClass.UgcInfo.getDefaultInstance();
                }
            }

            public Builder setUgcInfo(UgcInfoOuterClass.UgcInfo value) {
                if (this.ugcInfoBuilder_ != null) {
                    this.ugcInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.UGC_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setUgcInfo(UgcInfoOuterClass.UgcInfo.Builder builderForValue) {
                if (this.ugcInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.ugcInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.UGC_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeUgcInfo(UgcInfoOuterClass.UgcInfo value) {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ != 589 || this.detail_ == UgcInfoOuterClass.UgcInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = UgcInfoOuterClass.UgcInfo.newBuilder((UgcInfoOuterClass.UgcInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 589) {
                        this.ugcInfoBuilder_.mergeFrom(value);
                    }
                    this.ugcInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.UGC_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearUgcInfo() {
                if (this.ugcInfoBuilder_ != null) {
                    if (this.detailCase_ == 589) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.ugcInfoBuilder_.clear();
                } else if (this.detailCase_ == 589) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public UgcInfoOuterClass.UgcInfo.Builder getUgcInfoBuilder() {
                return getUgcInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public UgcInfoOuterClass.UgcInfoOrBuilder getUgcInfoOrBuilder() {
                if (this.detailCase_ == 589 && this.ugcInfoBuilder_ != null) {
                    return this.ugcInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 589) {
                    return (UgcInfoOuterClass.UgcInfo) this.detail_;
                }
                return UgcInfoOuterClass.UgcInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<UgcInfoOuterClass.UgcInfo, UgcInfoOuterClass.UgcInfo.Builder, UgcInfoOuterClass.UgcInfoOrBuilder> getUgcInfoFieldBuilder() {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ != 589) {
                        this.detail_ = UgcInfoOuterClass.UgcInfo.getDefaultInstance();
                    }
                    this.ugcInfoBuilder_ = new SingleFieldBuilderV3<>((UgcInfoOuterClass.UgcInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.UGC_INFO_FIELD_NUMBER;
                onChanged();
                return this.ugcInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCrystalLinkInfo() {
                return this.detailCase_ == 1375;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrystalLinkInfoOuterClass.CrystalLinkInfo getCrystalLinkInfo() {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ == 1375) {
                        return (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_;
                    }
                    return CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1375) {
                    return this.crystalLinkInfoBuilder_.getMessage();
                } else {
                    return CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
                }
            }

            public Builder setCrystalLinkInfo(CrystalLinkInfoOuterClass.CrystalLinkInfo value) {
                if (this.crystalLinkInfoBuilder_ != null) {
                    this.crystalLinkInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setCrystalLinkInfo(CrystalLinkInfoOuterClass.CrystalLinkInfo.Builder builderForValue) {
                if (this.crystalLinkInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crystalLinkInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeCrystalLinkInfo(CrystalLinkInfoOuterClass.CrystalLinkInfo value) {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ != 1375 || this.detail_ == CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CrystalLinkInfoOuterClass.CrystalLinkInfo.newBuilder((CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1375) {
                        this.crystalLinkInfoBuilder_.mergeFrom(value);
                    }
                    this.crystalLinkInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearCrystalLinkInfo() {
                if (this.crystalLinkInfoBuilder_ != null) {
                    if (this.detailCase_ == 1375) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.crystalLinkInfoBuilder_.clear();
                } else if (this.detailCase_ == 1375) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CrystalLinkInfoOuterClass.CrystalLinkInfo.Builder getCrystalLinkInfoBuilder() {
                return getCrystalLinkInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrystalLinkInfoOuterClass.CrystalLinkInfoOrBuilder getCrystalLinkInfoOrBuilder() {
                if (this.detailCase_ == 1375 && this.crystalLinkInfoBuilder_ != null) {
                    return this.crystalLinkInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1375) {
                    return (CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_;
                }
                return CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CrystalLinkInfoOuterClass.CrystalLinkInfo, CrystalLinkInfoOuterClass.CrystalLinkInfo.Builder, CrystalLinkInfoOuterClass.CrystalLinkInfoOrBuilder> getCrystalLinkInfoFieldBuilder() {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ != 1375) {
                        this.detail_ = CrystalLinkInfoOuterClass.CrystalLinkInfo.getDefaultInstance();
                    }
                    this.crystalLinkInfoBuilder_ = new SingleFieldBuilderV3<>((CrystalLinkInfoOuterClass.CrystalLinkInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.CRYSTAL_LINK_INFO_FIELD_NUMBER;
                onChanged();
                return this.crystalLinkInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasIrodoriInfo() {
                return this.detailCase_ == 1014;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IrodoriInfoOuterClass.IrodoriInfo getIrodoriInfo() {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ == 1014) {
                        return (IrodoriInfoOuterClass.IrodoriInfo) this.detail_;
                    }
                    return IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1014) {
                    return this.irodoriInfoBuilder_.getMessage();
                } else {
                    return IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
                }
            }

            public Builder setIrodoriInfo(IrodoriInfoOuterClass.IrodoriInfo value) {
                if (this.irodoriInfoBuilder_ != null) {
                    this.irodoriInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1014;
                return this;
            }

            public Builder setIrodoriInfo(IrodoriInfoOuterClass.IrodoriInfo.Builder builderForValue) {
                if (this.irodoriInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.irodoriInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1014;
                return this;
            }

            public Builder mergeIrodoriInfo(IrodoriInfoOuterClass.IrodoriInfo value) {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1014 || this.detail_ == IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = IrodoriInfoOuterClass.IrodoriInfo.newBuilder((IrodoriInfoOuterClass.IrodoriInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1014) {
                        this.irodoriInfoBuilder_.mergeFrom(value);
                    }
                    this.irodoriInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1014;
                return this;
            }

            public Builder clearIrodoriInfo() {
                if (this.irodoriInfoBuilder_ != null) {
                    if (this.detailCase_ == 1014) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.irodoriInfoBuilder_.clear();
                } else if (this.detailCase_ == 1014) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public IrodoriInfoOuterClass.IrodoriInfo.Builder getIrodoriInfoBuilder() {
                return getIrodoriInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IrodoriInfoOuterClass.IrodoriInfoOrBuilder getIrodoriInfoOrBuilder() {
                if (this.detailCase_ == 1014 && this.irodoriInfoBuilder_ != null) {
                    return this.irodoriInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1014) {
                    return (IrodoriInfoOuterClass.IrodoriInfo) this.detail_;
                }
                return IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<IrodoriInfoOuterClass.IrodoriInfo, IrodoriInfoOuterClass.IrodoriInfo.Builder, IrodoriInfoOuterClass.IrodoriInfoOrBuilder> getIrodoriInfoFieldBuilder() {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1014) {
                        this.detail_ = IrodoriInfoOuterClass.IrodoriInfo.getDefaultInstance();
                    }
                    this.irodoriInfoBuilder_ = new SingleFieldBuilderV3<>((IrodoriInfoOuterClass.IrodoriInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1014;
                onChanged();
                return this.irodoriInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPhotoInfo() {
                return this.detailCase_ == 309;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PhotoInfoOuterClass.PhotoInfo getPhotoInfo() {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ == 309) {
                        return (PhotoInfoOuterClass.PhotoInfo) this.detail_;
                    }
                    return PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
                } else if (this.detailCase_ == 309) {
                    return this.photoInfoBuilder_.getMessage();
                } else {
                    return PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
                }
            }

            public Builder setPhotoInfo(PhotoInfoOuterClass.PhotoInfo value) {
                if (this.photoInfoBuilder_ != null) {
                    this.photoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 309;
                return this;
            }

            public Builder setPhotoInfo(PhotoInfoOuterClass.PhotoInfo.Builder builderForValue) {
                if (this.photoInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.photoInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 309;
                return this;
            }

            public Builder mergePhotoInfo(PhotoInfoOuterClass.PhotoInfo value) {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ != 309 || this.detail_ == PhotoInfoOuterClass.PhotoInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PhotoInfoOuterClass.PhotoInfo.newBuilder((PhotoInfoOuterClass.PhotoInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 309) {
                        this.photoInfoBuilder_.mergeFrom(value);
                    }
                    this.photoInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 309;
                return this;
            }

            public Builder clearPhotoInfo() {
                if (this.photoInfoBuilder_ != null) {
                    if (this.detailCase_ == 309) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.photoInfoBuilder_.clear();
                } else if (this.detailCase_ == 309) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PhotoInfoOuterClass.PhotoInfo.Builder getPhotoInfoBuilder() {
                return getPhotoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PhotoInfoOuterClass.PhotoInfoOrBuilder getPhotoInfoOrBuilder() {
                if (this.detailCase_ == 309 && this.photoInfoBuilder_ != null) {
                    return this.photoInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 309) {
                    return (PhotoInfoOuterClass.PhotoInfo) this.detail_;
                }
                return PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PhotoInfoOuterClass.PhotoInfo, PhotoInfoOuterClass.PhotoInfo.Builder, PhotoInfoOuterClass.PhotoInfoOrBuilder> getPhotoInfoFieldBuilder() {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ != 309) {
                        this.detail_ = PhotoInfoOuterClass.PhotoInfo.getDefaultInstance();
                    }
                    this.photoInfoBuilder_ = new SingleFieldBuilderV3<>((PhotoInfoOuterClass.PhotoInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 309;
                onChanged();
                return this.photoInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSpiceInfo() {
                return this.detailCase_ == 1446;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SpiceInfoOuterClass.SpiceInfo getSpiceInfo() {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ == 1446) {
                        return (SpiceInfoOuterClass.SpiceInfo) this.detail_;
                    }
                    return SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1446) {
                    return this.spiceInfoBuilder_.getMessage();
                } else {
                    return SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
                }
            }

            public Builder setSpiceInfo(SpiceInfoOuterClass.SpiceInfo value) {
                if (this.spiceInfoBuilder_ != null) {
                    this.spiceInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setSpiceInfo(SpiceInfoOuterClass.SpiceInfo.Builder builderForValue) {
                if (this.spiceInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spiceInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSpiceInfo(SpiceInfoOuterClass.SpiceInfo value) {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1446 || this.detail_ == SpiceInfoOuterClass.SpiceInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SpiceInfoOuterClass.SpiceInfo.newBuilder((SpiceInfoOuterClass.SpiceInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1446) {
                        this.spiceInfoBuilder_.mergeFrom(value);
                    }
                    this.spiceInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearSpiceInfo() {
                if (this.spiceInfoBuilder_ != null) {
                    if (this.detailCase_ == 1446) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.spiceInfoBuilder_.clear();
                } else if (this.detailCase_ == 1446) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SpiceInfoOuterClass.SpiceInfo.Builder getSpiceInfoBuilder() {
                return getSpiceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SpiceInfoOuterClass.SpiceInfoOrBuilder getSpiceInfoOrBuilder() {
                if (this.detailCase_ == 1446 && this.spiceInfoBuilder_ != null) {
                    return this.spiceInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1446) {
                    return (SpiceInfoOuterClass.SpiceInfo) this.detail_;
                }
                return SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SpiceInfoOuterClass.SpiceInfo, SpiceInfoOuterClass.SpiceInfo.Builder, SpiceInfoOuterClass.SpiceInfoOrBuilder> getSpiceInfoFieldBuilder() {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1446) {
                        this.detail_ = SpiceInfoOuterClass.SpiceInfo.getDefaultInstance();
                    }
                    this.spiceInfoBuilder_ = new SingleFieldBuilderV3<>((SpiceInfoOuterClass.SpiceInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                onChanged();
                return this.spiceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGachaInfo() {
                return this.detailCase_ == 1177;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GachaInfoOuterClass.GachaInfo getGachaInfo() {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ == 1177) {
                        return (GachaInfoOuterClass.GachaInfo) this.detail_;
                    }
                    return GachaInfoOuterClass.GachaInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1177) {
                    return this.gachaInfoBuilder_.getMessage();
                } else {
                    return GachaInfoOuterClass.GachaInfo.getDefaultInstance();
                }
            }

            public Builder setGachaInfo(GachaInfoOuterClass.GachaInfo value) {
                if (this.gachaInfoBuilder_ != null) {
                    this.gachaInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setGachaInfo(GachaInfoOuterClass.GachaInfo.Builder builderForValue) {
                if (this.gachaInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gachaInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGachaInfo(GachaInfoOuterClass.GachaInfo value) {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ != 1177 || this.detail_ == GachaInfoOuterClass.GachaInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GachaInfoOuterClass.GachaInfo.newBuilder((GachaInfoOuterClass.GachaInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1177) {
                        this.gachaInfoBuilder_.mergeFrom(value);
                    }
                    this.gachaInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGachaInfo() {
                if (this.gachaInfoBuilder_ != null) {
                    if (this.detailCase_ == 1177) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gachaInfoBuilder_.clear();
                } else if (this.detailCase_ == 1177) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GachaInfoOuterClass.GachaInfo.Builder getGachaInfoBuilder() {
                return getGachaInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GachaInfoOuterClass.GachaInfoOrBuilder getGachaInfoOrBuilder() {
                if (this.detailCase_ == 1177 && this.gachaInfoBuilder_ != null) {
                    return this.gachaInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1177) {
                    return (GachaInfoOuterClass.GachaInfo) this.detail_;
                }
                return GachaInfoOuterClass.GachaInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GachaInfoOuterClass.GachaInfo, GachaInfoOuterClass.GachaInfo.Builder, GachaInfoOuterClass.GachaInfoOrBuilder> getGachaInfoFieldBuilder() {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ != 1177) {
                        this.detail_ = GachaInfoOuterClass.GachaInfo.getDefaultInstance();
                    }
                    this.gachaInfoBuilder_ = new SingleFieldBuilderV3<>((GachaInfoOuterClass.GachaInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                onChanged();
                return this.gachaInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLuminanceStoneChallengeInfo() {
                return this.detailCase_ == 142;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo getLuminanceStoneChallengeInfo() {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 142) {
                        return (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_;
                    }
                    return LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
                } else if (this.detailCase_ == 142) {
                    return this.luminanceStoneChallengeInfoBuilder_.getMessage();
                } else {
                    return LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
                }
            }

            public Builder setLuminanceStoneChallengeInfo(LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo value) {
                if (this.luminanceStoneChallengeInfoBuilder_ != null) {
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 142;
                return this;
            }

            public Builder setLuminanceStoneChallengeInfo(LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.Builder builderForValue) {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 142;
                return this;
            }

            public Builder mergeLuminanceStoneChallengeInfo(LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo value) {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 142 || this.detail_ == LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.newBuilder((LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 142) {
                        this.luminanceStoneChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 142;
                return this;
            }

            public Builder clearLuminanceStoneChallengeInfo() {
                if (this.luminanceStoneChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 142) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.luminanceStoneChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 142) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.Builder getLuminanceStoneChallengeInfoBuilder() {
                return getLuminanceStoneChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder() {
                if (this.detailCase_ == 142 && this.luminanceStoneChallengeInfoBuilder_ != null) {
                    return this.luminanceStoneChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 142) {
                    return (LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_;
                }
                return LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo, LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.Builder, LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfoOrBuilder> getLuminanceStoneChallengeInfoFieldBuilder() {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 142) {
                        this.detail_ = LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo.getDefaultInstance();
                    }
                    this.luminanceStoneChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((LuminanceStoneChallengeInfoOuterClass.LuminanceStoneChallengeInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 142;
                onChanged();
                return this.luminanceStoneChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRogueDiaryInfo() {
                return this.detailCase_ == 397;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RogueDiaryInfoOuterClass.RogueDiaryInfo getRogueDiaryInfo() {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ == 397) {
                        return (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_;
                    }
                    return RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
                } else if (this.detailCase_ == 397) {
                    return this.rogueDiaryInfoBuilder_.getMessage();
                } else {
                    return RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
                }
            }

            public Builder setRogueDiaryInfo(RogueDiaryInfoOuterClass.RogueDiaryInfo value) {
                if (this.rogueDiaryInfoBuilder_ != null) {
                    this.rogueDiaryInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 397;
                return this;
            }

            public Builder setRogueDiaryInfo(RogueDiaryInfoOuterClass.RogueDiaryInfo.Builder builderForValue) {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rogueDiaryInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 397;
                return this;
            }

            public Builder mergeRogueDiaryInfo(RogueDiaryInfoOuterClass.RogueDiaryInfo value) {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ != 397 || this.detail_ == RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RogueDiaryInfoOuterClass.RogueDiaryInfo.newBuilder((RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 397) {
                        this.rogueDiaryInfoBuilder_.mergeFrom(value);
                    }
                    this.rogueDiaryInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 397;
                return this;
            }

            public Builder clearRogueDiaryInfo() {
                if (this.rogueDiaryInfoBuilder_ != null) {
                    if (this.detailCase_ == 397) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.rogueDiaryInfoBuilder_.clear();
                } else if (this.detailCase_ == 397) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RogueDiaryInfoOuterClass.RogueDiaryInfo.Builder getRogueDiaryInfoBuilder() {
                return getRogueDiaryInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder getRogueDiaryInfoOrBuilder() {
                if (this.detailCase_ == 397 && this.rogueDiaryInfoBuilder_ != null) {
                    return this.rogueDiaryInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 397) {
                    return (RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_;
                }
                return RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RogueDiaryInfoOuterClass.RogueDiaryInfo, RogueDiaryInfoOuterClass.RogueDiaryInfo.Builder, RogueDiaryInfoOuterClass.RogueDiaryInfoOrBuilder> getRogueDiaryInfoFieldBuilder() {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ != 397) {
                        this.detail_ = RogueDiaryInfoOuterClass.RogueDiaryInfo.getDefaultInstance();
                    }
                    this.rogueDiaryInfoBuilder_ = new SingleFieldBuilderV3<>((RogueDiaryInfoOuterClass.RogueDiaryInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 397;
                onChanged();
                return this.rogueDiaryInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSummerTimeV2Info() {
                return this.detailCase_ == 951;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeV2InfoOuterClass.SummerTimeV2Info getSummerTimeV2Info() {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ == 951) {
                        return (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_;
                    }
                    return SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
                } else if (this.detailCase_ == 951) {
                    return this.summerTimeV2InfoBuilder_.getMessage();
                } else {
                    return SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
                }
            }

            public Builder setSummerTimeV2Info(SummerTimeV2InfoOuterClass.SummerTimeV2Info value) {
                if (this.summerTimeV2InfoBuilder_ != null) {
                    this.summerTimeV2InfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 951;
                return this;
            }

            public Builder setSummerTimeV2Info(SummerTimeV2InfoOuterClass.SummerTimeV2Info.Builder builderForValue) {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.summerTimeV2InfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 951;
                return this;
            }

            public Builder mergeSummerTimeV2Info(SummerTimeV2InfoOuterClass.SummerTimeV2Info value) {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ != 951 || this.detail_ == SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SummerTimeV2InfoOuterClass.SummerTimeV2Info.newBuilder((SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 951) {
                        this.summerTimeV2InfoBuilder_.mergeFrom(value);
                    }
                    this.summerTimeV2InfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 951;
                return this;
            }

            public Builder clearSummerTimeV2Info() {
                if (this.summerTimeV2InfoBuilder_ != null) {
                    if (this.detailCase_ == 951) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.summerTimeV2InfoBuilder_.clear();
                } else if (this.detailCase_ == 951) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SummerTimeV2InfoOuterClass.SummerTimeV2Info.Builder getSummerTimeV2InfoBuilder() {
                return getSummerTimeV2InfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder getSummerTimeV2InfoOrBuilder() {
                if (this.detailCase_ == 951 && this.summerTimeV2InfoBuilder_ != null) {
                    return this.summerTimeV2InfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 951) {
                    return (SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_;
                }
                return SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SummerTimeV2InfoOuterClass.SummerTimeV2Info, SummerTimeV2InfoOuterClass.SummerTimeV2Info.Builder, SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder> getSummerTimeV2InfoFieldBuilder() {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ != 951) {
                        this.detail_ = SummerTimeV2InfoOuterClass.SummerTimeV2Info.getDefaultInstance();
                    }
                    this.summerTimeV2InfoBuilder_ = new SingleFieldBuilderV3<>((SummerTimeV2InfoOuterClass.SummerTimeV2Info) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 951;
                onChanged();
                return this.summerTimeV2InfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasIslandPartyInfo() {
                return this.detailCase_ == 1631;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IslandPartyInfoOuterClass.IslandPartyInfo getIslandPartyInfo() {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ == 1631) {
                        return (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_;
                    }
                    return IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1631) {
                    return this.islandPartyInfoBuilder_.getMessage();
                } else {
                    return IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
                }
            }

            public Builder setIslandPartyInfo(IslandPartyInfoOuterClass.IslandPartyInfo value) {
                if (this.islandPartyInfoBuilder_ != null) {
                    this.islandPartyInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1631;
                return this;
            }

            public Builder setIslandPartyInfo(IslandPartyInfoOuterClass.IslandPartyInfo.Builder builderForValue) {
                if (this.islandPartyInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.islandPartyInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1631;
                return this;
            }

            public Builder mergeIslandPartyInfo(IslandPartyInfoOuterClass.IslandPartyInfo value) {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1631 || this.detail_ == IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = IslandPartyInfoOuterClass.IslandPartyInfo.newBuilder((IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1631) {
                        this.islandPartyInfoBuilder_.mergeFrom(value);
                    }
                    this.islandPartyInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1631;
                return this;
            }

            public Builder clearIslandPartyInfo() {
                if (this.islandPartyInfoBuilder_ != null) {
                    if (this.detailCase_ == 1631) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.islandPartyInfoBuilder_.clear();
                } else if (this.detailCase_ == 1631) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public IslandPartyInfoOuterClass.IslandPartyInfo.Builder getIslandPartyInfoBuilder() {
                return getIslandPartyInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder getIslandPartyInfoOrBuilder() {
                if (this.detailCase_ == 1631 && this.islandPartyInfoBuilder_ != null) {
                    return this.islandPartyInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1631) {
                    return (IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_;
                }
                return IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<IslandPartyInfoOuterClass.IslandPartyInfo, IslandPartyInfoOuterClass.IslandPartyInfo.Builder, IslandPartyInfoOuterClass.IslandPartyInfoOrBuilder> getIslandPartyInfoFieldBuilder() {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1631) {
                        this.detail_ = IslandPartyInfoOuterClass.IslandPartyInfo.getDefaultInstance();
                    }
                    this.islandPartyInfoBuilder_ = new SingleFieldBuilderV3<>((IslandPartyInfoOuterClass.IslandPartyInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1631;
                onChanged();
                return this.islandPartyInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGearInfo() {
                return this.detailCase_ == 1801;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GearInfoOuterClass.GearInfo getGearInfo() {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ == 1801) {
                        return (GearInfoOuterClass.GearInfo) this.detail_;
                    }
                    return GearInfoOuterClass.GearInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1801) {
                    return this.gearInfoBuilder_.getMessage();
                } else {
                    return GearInfoOuterClass.GearInfo.getDefaultInstance();
                }
            }

            public Builder setGearInfo(GearInfoOuterClass.GearInfo value) {
                if (this.gearInfoBuilder_ != null) {
                    this.gearInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setGearInfo(GearInfoOuterClass.GearInfo.Builder builderForValue) {
                if (this.gearInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gearInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGearInfo(GearInfoOuterClass.GearInfo value) {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ != 1801 || this.detail_ == GearInfoOuterClass.GearInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GearInfoOuterClass.GearInfo.newBuilder((GearInfoOuterClass.GearInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1801) {
                        this.gearInfoBuilder_.mergeFrom(value);
                    }
                    this.gearInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGearInfo() {
                if (this.gearInfoBuilder_ != null) {
                    if (this.detailCase_ == 1801) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gearInfoBuilder_.clear();
                } else if (this.detailCase_ == 1801) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GearInfoOuterClass.GearInfo.Builder getGearInfoBuilder() {
                return getGearInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GearInfoOuterClass.GearInfoOrBuilder getGearInfoOrBuilder() {
                if (this.detailCase_ == 1801 && this.gearInfoBuilder_ != null) {
                    return this.gearInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1801) {
                    return (GearInfoOuterClass.GearInfo) this.detail_;
                }
                return GearInfoOuterClass.GearInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GearInfoOuterClass.GearInfo, GearInfoOuterClass.GearInfo.Builder, GearInfoOuterClass.GearInfoOrBuilder> getGearInfoFieldBuilder() {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ != 1801) {
                        this.detail_ = GearInfoOuterClass.GearInfo.getDefaultInstance();
                    }
                    this.gearInfoBuilder_ = new SingleFieldBuilderV3<>((GearInfoOuterClass.GearInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                onChanged();
                return this.gearInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGravenInnocenceInfo() {
                return this.detailCase_ == 1173;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GravenInnocenceInfoOuterClass.GravenInnocenceInfo getGravenInnocenceInfo() {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ == 1173) {
                        return (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_;
                    }
                    return GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1173) {
                    return this.gravenInnocenceInfoBuilder_.getMessage();
                } else {
                    return GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
                }
            }

            public Builder setGravenInnocenceInfo(GravenInnocenceInfoOuterClass.GravenInnocenceInfo value) {
                if (this.gravenInnocenceInfoBuilder_ != null) {
                    this.gravenInnocenceInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setGravenInnocenceInfo(GravenInnocenceInfoOuterClass.GravenInnocenceInfo.Builder builderForValue) {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gravenInnocenceInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGravenInnocenceInfo(GravenInnocenceInfoOuterClass.GravenInnocenceInfo value) {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1173 || this.detail_ == GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GravenInnocenceInfoOuterClass.GravenInnocenceInfo.newBuilder((GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1173) {
                        this.gravenInnocenceInfoBuilder_.mergeFrom(value);
                    }
                    this.gravenInnocenceInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGravenInnocenceInfo() {
                if (this.gravenInnocenceInfoBuilder_ != null) {
                    if (this.detailCase_ == 1173) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gravenInnocenceInfoBuilder_.clear();
                } else if (this.detailCase_ == 1173) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GravenInnocenceInfoOuterClass.GravenInnocenceInfo.Builder getGravenInnocenceInfoBuilder() {
                return getGravenInnocenceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder getGravenInnocenceInfoOrBuilder() {
                if (this.detailCase_ == 1173 && this.gravenInnocenceInfoBuilder_ != null) {
                    return this.gravenInnocenceInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1173) {
                    return (GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_;
                }
                return GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GravenInnocenceInfoOuterClass.GravenInnocenceInfo, GravenInnocenceInfoOuterClass.GravenInnocenceInfo.Builder, GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder> getGravenInnocenceInfoFieldBuilder() {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1173) {
                        this.detail_ = GravenInnocenceInfoOuterClass.GravenInnocenceInfo.getDefaultInstance();
                    }
                    this.gravenInnocenceInfoBuilder_ = new SingleFieldBuilderV3<>((GravenInnocenceInfoOuterClass.GravenInnocenceInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                onChanged();
                return this.gravenInnocenceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasInstableSprayInfo() {
                return this.detailCase_ == 944;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public InstableSprayInfoOuterClass.InstableSprayInfo getInstableSprayInfo() {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ == 944) {
                        return (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_;
                    }
                    return InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
                } else if (this.detailCase_ == 944) {
                    return this.instableSprayInfoBuilder_.getMessage();
                } else {
                    return InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
                }
            }

            public Builder setInstableSprayInfo(InstableSprayInfoOuterClass.InstableSprayInfo value) {
                if (this.instableSprayInfoBuilder_ != null) {
                    this.instableSprayInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setInstableSprayInfo(InstableSprayInfoOuterClass.InstableSprayInfo.Builder builderForValue) {
                if (this.instableSprayInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.instableSprayInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeInstableSprayInfo(InstableSprayInfoOuterClass.InstableSprayInfo value) {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ != 944 || this.detail_ == InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = InstableSprayInfoOuterClass.InstableSprayInfo.newBuilder((InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 944) {
                        this.instableSprayInfoBuilder_.mergeFrom(value);
                    }
                    this.instableSprayInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearInstableSprayInfo() {
                if (this.instableSprayInfoBuilder_ != null) {
                    if (this.detailCase_ == 944) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.instableSprayInfoBuilder_.clear();
                } else if (this.detailCase_ == 944) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public InstableSprayInfoOuterClass.InstableSprayInfo.Builder getInstableSprayInfoBuilder() {
                return getInstableSprayInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder getInstableSprayInfoOrBuilder() {
                if (this.detailCase_ == 944 && this.instableSprayInfoBuilder_ != null) {
                    return this.instableSprayInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 944) {
                    return (InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_;
                }
                return InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<InstableSprayInfoOuterClass.InstableSprayInfo, InstableSprayInfoOuterClass.InstableSprayInfo.Builder, InstableSprayInfoOuterClass.InstableSprayInfoOrBuilder> getInstableSprayInfoFieldBuilder() {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ != 944) {
                        this.detail_ = InstableSprayInfoOuterClass.InstableSprayInfo.getDefaultInstance();
                    }
                    this.instableSprayInfoBuilder_ = new SingleFieldBuilderV3<>((InstableSprayInfoOuterClass.InstableSprayInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                onChanged();
                return this.instableSprayInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMuqadasPotionInfo() {
                return this.detailCase_ == 1350;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MuqadasPotionInfoOuterClass.MuqadasPotionInfo getMuqadasPotionInfo() {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ == 1350) {
                        return (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_;
                    }
                    return MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1350) {
                    return this.muqadasPotionInfoBuilder_.getMessage();
                } else {
                    return MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
                }
            }

            public Builder setMuqadasPotionInfo(MuqadasPotionInfoOuterClass.MuqadasPotionInfo value) {
                if (this.muqadasPotionInfoBuilder_ != null) {
                    this.muqadasPotionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setMuqadasPotionInfo(MuqadasPotionInfoOuterClass.MuqadasPotionInfo.Builder builderForValue) {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.muqadasPotionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeMuqadasPotionInfo(MuqadasPotionInfoOuterClass.MuqadasPotionInfo value) {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1350 || this.detail_ == MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MuqadasPotionInfoOuterClass.MuqadasPotionInfo.newBuilder((MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1350) {
                        this.muqadasPotionInfoBuilder_.mergeFrom(value);
                    }
                    this.muqadasPotionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearMuqadasPotionInfo() {
                if (this.muqadasPotionInfoBuilder_ != null) {
                    if (this.detailCase_ == 1350) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.muqadasPotionInfoBuilder_.clear();
                } else if (this.detailCase_ == 1350) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MuqadasPotionInfoOuterClass.MuqadasPotionInfo.Builder getMuqadasPotionInfoBuilder() {
                return getMuqadasPotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder getMuqadasPotionInfoOrBuilder() {
                if (this.detailCase_ == 1350 && this.muqadasPotionInfoBuilder_ != null) {
                    return this.muqadasPotionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1350) {
                    return (MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_;
                }
                return MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MuqadasPotionInfoOuterClass.MuqadasPotionInfo, MuqadasPotionInfoOuterClass.MuqadasPotionInfo.Builder, MuqadasPotionInfoOuterClass.MuqadasPotionInfoOrBuilder> getMuqadasPotionInfoFieldBuilder() {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1350) {
                        this.detail_ = MuqadasPotionInfoOuterClass.MuqadasPotionInfo.getDefaultInstance();
                    }
                    this.muqadasPotionInfoBuilder_ = new SingleFieldBuilderV3<>((MuqadasPotionInfoOuterClass.MuqadasPotionInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                onChanged();
                return this.muqadasPotionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTreasureSeelieInfo() {
                return this.detailCase_ == 1142;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureSeelieInfoOuterClass.TreasureSeelieInfo getTreasureSeelieInfo() {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ == 1142) {
                        return (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_;
                    }
                    return TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1142) {
                    return this.treasureSeelieInfoBuilder_.getMessage();
                } else {
                    return TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
                }
            }

            public Builder setTreasureSeelieInfo(TreasureSeelieInfoOuterClass.TreasureSeelieInfo value) {
                if (this.treasureSeelieInfoBuilder_ != null) {
                    this.treasureSeelieInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setTreasureSeelieInfo(TreasureSeelieInfoOuterClass.TreasureSeelieInfo.Builder builderForValue) {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.treasureSeelieInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTreasureSeelieInfo(TreasureSeelieInfoOuterClass.TreasureSeelieInfo value) {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ != 1142 || this.detail_ == TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TreasureSeelieInfoOuterClass.TreasureSeelieInfo.newBuilder((TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1142) {
                        this.treasureSeelieInfoBuilder_.mergeFrom(value);
                    }
                    this.treasureSeelieInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTreasureSeelieInfo() {
                if (this.treasureSeelieInfoBuilder_ != null) {
                    if (this.detailCase_ == 1142) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.treasureSeelieInfoBuilder_.clear();
                } else if (this.detailCase_ == 1142) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TreasureSeelieInfoOuterClass.TreasureSeelieInfo.Builder getTreasureSeelieInfoBuilder() {
                return getTreasureSeelieInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder getTreasureSeelieInfoOrBuilder() {
                if (this.detailCase_ == 1142 && this.treasureSeelieInfoBuilder_ != null) {
                    return this.treasureSeelieInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1142) {
                    return (TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_;
                }
                return TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TreasureSeelieInfoOuterClass.TreasureSeelieInfo, TreasureSeelieInfoOuterClass.TreasureSeelieInfo.Builder, TreasureSeelieInfoOuterClass.TreasureSeelieInfoOrBuilder> getTreasureSeelieInfoFieldBuilder() {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ != 1142) {
                        this.detail_ = TreasureSeelieInfoOuterClass.TreasureSeelieInfo.getDefaultInstance();
                    }
                    this.treasureSeelieInfoBuilder_ = new SingleFieldBuilderV3<>((TreasureSeelieInfoOuterClass.TreasureSeelieInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                onChanged();
                return this.treasureSeelieInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRockBoardExploreInfo() {
                return this.detailCase_ == 1273;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RockBoardExploreInfoOuterClass.RockBoardExploreInfo getRockBoardExploreInfo() {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ == 1273) {
                        return (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_;
                    }
                    return RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1273) {
                    return this.rockBoardExploreInfoBuilder_.getMessage();
                } else {
                    return RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
                }
            }

            public Builder setRockBoardExploreInfo(RockBoardExploreInfoOuterClass.RockBoardExploreInfo value) {
                if (this.rockBoardExploreInfoBuilder_ != null) {
                    this.rockBoardExploreInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setRockBoardExploreInfo(RockBoardExploreInfoOuterClass.RockBoardExploreInfo.Builder builderForValue) {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rockBoardExploreInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRockBoardExploreInfo(RockBoardExploreInfoOuterClass.RockBoardExploreInfo value) {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ != 1273 || this.detail_ == RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RockBoardExploreInfoOuterClass.RockBoardExploreInfo.newBuilder((RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1273) {
                        this.rockBoardExploreInfoBuilder_.mergeFrom(value);
                    }
                    this.rockBoardExploreInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearRockBoardExploreInfo() {
                if (this.rockBoardExploreInfoBuilder_ != null) {
                    if (this.detailCase_ == 1273) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.rockBoardExploreInfoBuilder_.clear();
                } else if (this.detailCase_ == 1273) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RockBoardExploreInfoOuterClass.RockBoardExploreInfo.Builder getRockBoardExploreInfoBuilder() {
                return getRockBoardExploreInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RockBoardExploreInfoOuterClass.RockBoardExploreInfoOrBuilder getRockBoardExploreInfoOrBuilder() {
                if (this.detailCase_ == 1273 && this.rockBoardExploreInfoBuilder_ != null) {
                    return this.rockBoardExploreInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1273) {
                    return (RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_;
                }
                return RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RockBoardExploreInfoOuterClass.RockBoardExploreInfo, RockBoardExploreInfoOuterClass.RockBoardExploreInfo.Builder, RockBoardExploreInfoOuterClass.RockBoardExploreInfoOrBuilder> getRockBoardExploreInfoFieldBuilder() {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ != 1273) {
                        this.detail_ = RockBoardExploreInfoOuterClass.RockBoardExploreInfo.getDefaultInstance();
                    }
                    this.rockBoardExploreInfoBuilder_ = new SingleFieldBuilderV3<>((RockBoardExploreInfoOuterClass.RockBoardExploreInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                onChanged();
                return this.rockBoardExploreInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasVintageInfo() {
                return this.detailCase_ == 1316;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public VintageInfoOuterClass.VintageInfo getVintageInfo() {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ == 1316) {
                        return (VintageInfoOuterClass.VintageInfo) this.detail_;
                    }
                    return VintageInfoOuterClass.VintageInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1316) {
                    return this.vintageInfoBuilder_.getMessage();
                } else {
                    return VintageInfoOuterClass.VintageInfo.getDefaultInstance();
                }
            }

            public Builder setVintageInfo(VintageInfoOuterClass.VintageInfo value) {
                if (this.vintageInfoBuilder_ != null) {
                    this.vintageInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1316;
                return this;
            }

            public Builder setVintageInfo(VintageInfoOuterClass.VintageInfo.Builder builderForValue) {
                if (this.vintageInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.vintageInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1316;
                return this;
            }

            public Builder mergeVintageInfo(VintageInfoOuterClass.VintageInfo value) {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ != 1316 || this.detail_ == VintageInfoOuterClass.VintageInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = VintageInfoOuterClass.VintageInfo.newBuilder((VintageInfoOuterClass.VintageInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1316) {
                        this.vintageInfoBuilder_.mergeFrom(value);
                    }
                    this.vintageInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1316;
                return this;
            }

            public Builder clearVintageInfo() {
                if (this.vintageInfoBuilder_ != null) {
                    if (this.detailCase_ == 1316) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.vintageInfoBuilder_.clear();
                } else if (this.detailCase_ == 1316) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public VintageInfoOuterClass.VintageInfo.Builder getVintageInfoBuilder() {
                return getVintageInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public VintageInfoOuterClass.VintageInfoOrBuilder getVintageInfoOrBuilder() {
                if (this.detailCase_ == 1316 && this.vintageInfoBuilder_ != null) {
                    return this.vintageInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1316) {
                    return (VintageInfoOuterClass.VintageInfo) this.detail_;
                }
                return VintageInfoOuterClass.VintageInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<VintageInfoOuterClass.VintageInfo, VintageInfoOuterClass.VintageInfo.Builder, VintageInfoOuterClass.VintageInfoOrBuilder> getVintageInfoFieldBuilder() {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ != 1316) {
                        this.detail_ = VintageInfoOuterClass.VintageInfo.getDefaultInstance();
                    }
                    this.vintageInfoBuilder_ = new SingleFieldBuilderV3<>((VintageInfoOuterClass.VintageInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1316;
                onChanged();
                return this.vintageInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWindFieldInfo() {
                return this.detailCase_ == 2029;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WindFieldInfoOuterClass.WindFieldInfo getWindFieldInfo() {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ == 2029) {
                        return (WindFieldInfoOuterClass.WindFieldInfo) this.detail_;
                    }
                    return WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
                } else if (this.detailCase_ == 2029) {
                    return this.windFieldInfoBuilder_.getMessage();
                } else {
                    return WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
                }
            }

            public Builder setWindFieldInfo(WindFieldInfoOuterClass.WindFieldInfo value) {
                if (this.windFieldInfoBuilder_ != null) {
                    this.windFieldInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setWindFieldInfo(WindFieldInfoOuterClass.WindFieldInfo.Builder builderForValue) {
                if (this.windFieldInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.windFieldInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeWindFieldInfo(WindFieldInfoOuterClass.WindFieldInfo value) {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ != 2029 || this.detail_ == WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WindFieldInfoOuterClass.WindFieldInfo.newBuilder((WindFieldInfoOuterClass.WindFieldInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2029) {
                        this.windFieldInfoBuilder_.mergeFrom(value);
                    }
                    this.windFieldInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearWindFieldInfo() {
                if (this.windFieldInfoBuilder_ != null) {
                    if (this.detailCase_ == 2029) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.windFieldInfoBuilder_.clear();
                } else if (this.detailCase_ == 2029) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WindFieldInfoOuterClass.WindFieldInfo.Builder getWindFieldInfoBuilder() {
                return getWindFieldInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WindFieldInfoOuterClass.WindFieldInfoOrBuilder getWindFieldInfoOrBuilder() {
                if (this.detailCase_ == 2029 && this.windFieldInfoBuilder_ != null) {
                    return this.windFieldInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2029) {
                    return (WindFieldInfoOuterClass.WindFieldInfo) this.detail_;
                }
                return WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WindFieldInfoOuterClass.WindFieldInfo, WindFieldInfoOuterClass.WindFieldInfo.Builder, WindFieldInfoOuterClass.WindFieldInfoOrBuilder> getWindFieldInfoFieldBuilder() {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ != 2029) {
                        this.detail_ = WindFieldInfoOuterClass.WindFieldInfo.getDefaultInstance();
                    }
                    this.windFieldInfoBuilder_ = new SingleFieldBuilderV3<>((WindFieldInfoOuterClass.WindFieldInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                onChanged();
                return this.windFieldInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFungusFighterInfo() {
                return this.detailCase_ == 1543;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FungusFighterInfoOuterClass.FungusFighterInfo getFungusFighterInfo() {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ == 1543) {
                        return (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_;
                    }
                    return FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1543) {
                    return this.fungusFighterInfoBuilder_.getMessage();
                } else {
                    return FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
                }
            }

            public Builder setFungusFighterInfo(FungusFighterInfoOuterClass.FungusFighterInfo value) {
                if (this.fungusFighterInfoBuilder_ != null) {
                    this.fungusFighterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1543;
                return this;
            }

            public Builder setFungusFighterInfo(FungusFighterInfoOuterClass.FungusFighterInfo.Builder builderForValue) {
                if (this.fungusFighterInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fungusFighterInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1543;
                return this;
            }

            public Builder mergeFungusFighterInfo(FungusFighterInfoOuterClass.FungusFighterInfo value) {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1543 || this.detail_ == FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FungusFighterInfoOuterClass.FungusFighterInfo.newBuilder((FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1543) {
                        this.fungusFighterInfoBuilder_.mergeFrom(value);
                    }
                    this.fungusFighterInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1543;
                return this;
            }

            public Builder clearFungusFighterInfo() {
                if (this.fungusFighterInfoBuilder_ != null) {
                    if (this.detailCase_ == 1543) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fungusFighterInfoBuilder_.clear();
                } else if (this.detailCase_ == 1543) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FungusFighterInfoOuterClass.FungusFighterInfo.Builder getFungusFighterInfoBuilder() {
                return getFungusFighterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FungusFighterInfoOuterClass.FungusFighterInfoOrBuilder getFungusFighterInfoOrBuilder() {
                if (this.detailCase_ == 1543 && this.fungusFighterInfoBuilder_ != null) {
                    return this.fungusFighterInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1543) {
                    return (FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_;
                }
                return FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FungusFighterInfoOuterClass.FungusFighterInfo, FungusFighterInfoOuterClass.FungusFighterInfo.Builder, FungusFighterInfoOuterClass.FungusFighterInfoOrBuilder> getFungusFighterInfoFieldBuilder() {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1543) {
                        this.detail_ = FungusFighterInfoOuterClass.FungusFighterInfo.getDefaultInstance();
                    }
                    this.fungusFighterInfoBuilder_ = new SingleFieldBuilderV3<>((FungusFighterInfoOuterClass.FungusFighterInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1543;
                onChanged();
                return this.fungusFighterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCharAmusementInfo() {
                return this.detailCase_ == 504;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CharAmusementInfoOuterClass.CharAmusementInfo getCharAmusementInfo() {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ == 504) {
                        return (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_;
                    }
                    return CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
                } else if (this.detailCase_ == 504) {
                    return this.charAmusementInfoBuilder_.getMessage();
                } else {
                    return CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
                }
            }

            public Builder setCharAmusementInfo(CharAmusementInfoOuterClass.CharAmusementInfo value) {
                if (this.charAmusementInfoBuilder_ != null) {
                    this.charAmusementInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 504;
                return this;
            }

            public Builder setCharAmusementInfo(CharAmusementInfoOuterClass.CharAmusementInfo.Builder builderForValue) {
                if (this.charAmusementInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.charAmusementInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 504;
                return this;
            }

            public Builder mergeCharAmusementInfo(CharAmusementInfoOuterClass.CharAmusementInfo value) {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ != 504 || this.detail_ == CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CharAmusementInfoOuterClass.CharAmusementInfo.newBuilder((CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 504) {
                        this.charAmusementInfoBuilder_.mergeFrom(value);
                    }
                    this.charAmusementInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 504;
                return this;
            }

            public Builder clearCharAmusementInfo() {
                if (this.charAmusementInfoBuilder_ != null) {
                    if (this.detailCase_ == 504) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.charAmusementInfoBuilder_.clear();
                } else if (this.detailCase_ == 504) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CharAmusementInfoOuterClass.CharAmusementInfo.Builder getCharAmusementInfoBuilder() {
                return getCharAmusementInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder getCharAmusementInfoOrBuilder() {
                if (this.detailCase_ == 504 && this.charAmusementInfoBuilder_ != null) {
                    return this.charAmusementInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 504) {
                    return (CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_;
                }
                return CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CharAmusementInfoOuterClass.CharAmusementInfo, CharAmusementInfoOuterClass.CharAmusementInfo.Builder, CharAmusementInfoOuterClass.CharAmusementInfoOrBuilder> getCharAmusementInfoFieldBuilder() {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ != 504) {
                        this.detail_ = CharAmusementInfoOuterClass.CharAmusementInfo.getDefaultInstance();
                    }
                    this.charAmusementInfoBuilder_ = new SingleFieldBuilderV3<>((CharAmusementInfoOuterClass.CharAmusementInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 504;
                onChanged();
                return this.charAmusementInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEffigyChallengeInfo() {
                return this.detailCase_ == 1144;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyChallengeInfoOuterClass.EffigyChallengeInfo getEffigyChallengeInfo() {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 1144) {
                        return (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_;
                    }
                    return EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1144) {
                    return this.effigyChallengeInfoBuilder_.getMessage();
                } else {
                    return EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyChallengeInfo(EffigyChallengeInfoOuterClass.EffigyChallengeInfo value) {
                if (this.effigyChallengeInfoBuilder_ != null) {
                    this.effigyChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setEffigyChallengeInfo(EffigyChallengeInfoOuterClass.EffigyChallengeInfo.Builder builderForValue) {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeEffigyChallengeInfo(EffigyChallengeInfoOuterClass.EffigyChallengeInfo value) {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1144 || this.detail_ == EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyChallengeInfoOuterClass.EffigyChallengeInfo.newBuilder((EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1144) {
                        this.effigyChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearEffigyChallengeInfo() {
                if (this.effigyChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 1144) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 1144) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyChallengeInfoOuterClass.EffigyChallengeInfo.Builder getEffigyChallengeInfoBuilder() {
                return getEffigyChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder getEffigyChallengeInfoOrBuilder() {
                if (this.detailCase_ == 1144 && this.effigyChallengeInfoBuilder_ != null) {
                    return this.effigyChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1144) {
                    return (EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_;
                }
                return EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyChallengeInfoOuterClass.EffigyChallengeInfo, EffigyChallengeInfoOuterClass.EffigyChallengeInfo.Builder, EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder> getEffigyChallengeInfoFieldBuilder() {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1144) {
                        this.detail_ = EffigyChallengeInfoOuterClass.EffigyChallengeInfo.getDefaultInstance();
                    }
                    this.effigyChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyChallengeInfoOuterClass.EffigyChallengeInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.EFFIGY_CHALLENGE_INFO_FIELD_NUMBER;
                onChanged();
                return this.effigyChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCoinCollectInfo() {
                return this.detailCase_ == 559;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CoinCollectInfoOuterClass.CoinCollectInfo getCoinCollectInfo() {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ == 559) {
                        return (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_;
                    }
                    return CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
                } else if (this.detailCase_ == 559) {
                    return this.coinCollectInfoBuilder_.getMessage();
                } else {
                    return CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
                }
            }

            public Builder setCoinCollectInfo(CoinCollectInfoOuterClass.CoinCollectInfo value) {
                if (this.coinCollectInfoBuilder_ != null) {
                    this.coinCollectInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 559;
                return this;
            }

            public Builder setCoinCollectInfo(CoinCollectInfoOuterClass.CoinCollectInfo.Builder builderForValue) {
                if (this.coinCollectInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.coinCollectInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 559;
                return this;
            }

            public Builder mergeCoinCollectInfo(CoinCollectInfoOuterClass.CoinCollectInfo value) {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ != 559 || this.detail_ == CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CoinCollectInfoOuterClass.CoinCollectInfo.newBuilder((CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 559) {
                        this.coinCollectInfoBuilder_.mergeFrom(value);
                    }
                    this.coinCollectInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 559;
                return this;
            }

            public Builder clearCoinCollectInfo() {
                if (this.coinCollectInfoBuilder_ != null) {
                    if (this.detailCase_ == 559) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.coinCollectInfoBuilder_.clear();
                } else if (this.detailCase_ == 559) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CoinCollectInfoOuterClass.CoinCollectInfo.Builder getCoinCollectInfoBuilder() {
                return getCoinCollectInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder getCoinCollectInfoOrBuilder() {
                if (this.detailCase_ == 559 && this.coinCollectInfoBuilder_ != null) {
                    return this.coinCollectInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 559) {
                    return (CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_;
                }
                return CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CoinCollectInfoOuterClass.CoinCollectInfo, CoinCollectInfoOuterClass.CoinCollectInfo.Builder, CoinCollectInfoOuterClass.CoinCollectInfoOrBuilder> getCoinCollectInfoFieldBuilder() {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ != 559) {
                        this.detail_ = CoinCollectInfoOuterClass.CoinCollectInfo.getDefaultInstance();
                    }
                    this.coinCollectInfoBuilder_ = new SingleFieldBuilderV3<>((CoinCollectInfoOuterClass.CoinCollectInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 559;
                onChanged();
                return this.coinCollectInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBrickBreakerInfo() {
                return this.detailCase_ == 1275;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BrickBreakerInfoOuterClass.BrickBreakerInfo getBrickBreakerInfo() {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ == 1275) {
                        return (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_;
                    }
                    return BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1275) {
                    return this.brickBreakerInfoBuilder_.getMessage();
                } else {
                    return BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
                }
            }

            public Builder setBrickBreakerInfo(BrickBreakerInfoOuterClass.BrickBreakerInfo value) {
                if (this.brickBreakerInfoBuilder_ != null) {
                    this.brickBreakerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setBrickBreakerInfo(BrickBreakerInfoOuterClass.BrickBreakerInfo.Builder builderForValue) {
                if (this.brickBreakerInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.brickBreakerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeBrickBreakerInfo(BrickBreakerInfoOuterClass.BrickBreakerInfo value) {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1275 || this.detail_ == BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BrickBreakerInfoOuterClass.BrickBreakerInfo.newBuilder((BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1275) {
                        this.brickBreakerInfoBuilder_.mergeFrom(value);
                    }
                    this.brickBreakerInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearBrickBreakerInfo() {
                if (this.brickBreakerInfoBuilder_ != null) {
                    if (this.detailCase_ == 1275) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.brickBreakerInfoBuilder_.clear();
                } else if (this.detailCase_ == 1275) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BrickBreakerInfoOuterClass.BrickBreakerInfo.Builder getBrickBreakerInfoBuilder() {
                return getBrickBreakerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BrickBreakerInfoOuterClass.BrickBreakerInfoOrBuilder getBrickBreakerInfoOrBuilder() {
                if (this.detailCase_ == 1275 && this.brickBreakerInfoBuilder_ != null) {
                    return this.brickBreakerInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1275) {
                    return (BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_;
                }
                return BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BrickBreakerInfoOuterClass.BrickBreakerInfo, BrickBreakerInfoOuterClass.BrickBreakerInfo.Builder, BrickBreakerInfoOuterClass.BrickBreakerInfoOrBuilder> getBrickBreakerInfoFieldBuilder() {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1275) {
                        this.detail_ = BrickBreakerInfoOuterClass.BrickBreakerInfo.getDefaultInstance();
                    }
                    this.brickBreakerInfoBuilder_ = new SingleFieldBuilderV3<>((BrickBreakerInfoOuterClass.BrickBreakerInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.BRICK_BREAKER_INFO_FIELD_NUMBER;
                onChanged();
                return this.brickBreakerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDuelHeartInfo() {
                return this.detailCase_ == 221;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DuelHeartInfoOuterClass.DuelHeartInfo getDuelHeartInfo() {
                if (this.duelHeartInfoBuilder_ == null) {
                    if (this.detailCase_ == 221) {
                        return (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_;
                    }
                    return DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
                } else if (this.detailCase_ == 221) {
                    return this.duelHeartInfoBuilder_.getMessage();
                } else {
                    return DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
                }
            }

            public Builder setDuelHeartInfo(DuelHeartInfoOuterClass.DuelHeartInfo value) {
                if (this.duelHeartInfoBuilder_ != null) {
                    this.duelHeartInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 221;
                return this;
            }

            public Builder setDuelHeartInfo(DuelHeartInfoOuterClass.DuelHeartInfo.Builder builderForValue) {
                if (this.duelHeartInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.duelHeartInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 221;
                return this;
            }

            public Builder mergeDuelHeartInfo(DuelHeartInfoOuterClass.DuelHeartInfo value) {
                if (this.duelHeartInfoBuilder_ == null) {
                    if (this.detailCase_ != 221 || this.detail_ == DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DuelHeartInfoOuterClass.DuelHeartInfo.newBuilder((DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 221) {
                        this.duelHeartInfoBuilder_.mergeFrom(value);
                    }
                    this.duelHeartInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 221;
                return this;
            }

            public Builder clearDuelHeartInfo() {
                if (this.duelHeartInfoBuilder_ != null) {
                    if (this.detailCase_ == 221) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.duelHeartInfoBuilder_.clear();
                } else if (this.detailCase_ == 221) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DuelHeartInfoOuterClass.DuelHeartInfo.Builder getDuelHeartInfoBuilder() {
                return getDuelHeartInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DuelHeartInfoOuterClass.DuelHeartInfoOrBuilder getDuelHeartInfoOrBuilder() {
                if (this.detailCase_ == 221 && this.duelHeartInfoBuilder_ != null) {
                    return this.duelHeartInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 221) {
                    return (DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_;
                }
                return DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DuelHeartInfoOuterClass.DuelHeartInfo, DuelHeartInfoOuterClass.DuelHeartInfo.Builder, DuelHeartInfoOuterClass.DuelHeartInfoOrBuilder> getDuelHeartInfoFieldBuilder() {
                if (this.duelHeartInfoBuilder_ == null) {
                    if (this.detailCase_ != 221) {
                        this.detail_ = DuelHeartInfoOuterClass.DuelHeartInfo.getDefaultInstance();
                    }
                    this.duelHeartInfoBuilder_ = new SingleFieldBuilderV3<>((DuelHeartInfoOuterClass.DuelHeartInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 221;
                onChanged();
                return this.duelHeartInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSeaLampV3Info() {
                return this.detailCase_ == 1080;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampV3InfoOuterClass.SeaLampV3Info getSeaLampV3Info() {
                if (this.seaLampV3InfoBuilder_ == null) {
                    if (this.detailCase_ == 1080) {
                        return (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_;
                    }
                    return SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
                } else if (this.detailCase_ == 1080) {
                    return this.seaLampV3InfoBuilder_.getMessage();
                } else {
                    return SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
                }
            }

            public Builder setSeaLampV3Info(SeaLampV3InfoOuterClass.SeaLampV3Info value) {
                if (this.seaLampV3InfoBuilder_ != null) {
                    this.seaLampV3InfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1080;
                return this;
            }

            public Builder setSeaLampV3Info(SeaLampV3InfoOuterClass.SeaLampV3Info.Builder builderForValue) {
                if (this.seaLampV3InfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.seaLampV3InfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1080;
                return this;
            }

            public Builder mergeSeaLampV3Info(SeaLampV3InfoOuterClass.SeaLampV3Info value) {
                if (this.seaLampV3InfoBuilder_ == null) {
                    if (this.detailCase_ != 1080 || this.detail_ == SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SeaLampV3InfoOuterClass.SeaLampV3Info.newBuilder((SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1080) {
                        this.seaLampV3InfoBuilder_.mergeFrom(value);
                    }
                    this.seaLampV3InfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1080;
                return this;
            }

            public Builder clearSeaLampV3Info() {
                if (this.seaLampV3InfoBuilder_ != null) {
                    if (this.detailCase_ == 1080) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.seaLampV3InfoBuilder_.clear();
                } else if (this.detailCase_ == 1080) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SeaLampV3InfoOuterClass.SeaLampV3Info.Builder getSeaLampV3InfoBuilder() {
                return getSeaLampV3InfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder getSeaLampV3InfoOrBuilder() {
                if (this.detailCase_ == 1080 && this.seaLampV3InfoBuilder_ != null) {
                    return this.seaLampV3InfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1080) {
                    return (SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_;
                }
                return SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SeaLampV3InfoOuterClass.SeaLampV3Info, SeaLampV3InfoOuterClass.SeaLampV3Info.Builder, SeaLampV3InfoOuterClass.SeaLampV3InfoOrBuilder> getSeaLampV3InfoFieldBuilder() {
                if (this.seaLampV3InfoBuilder_ == null) {
                    if (this.detailCase_ != 1080) {
                        this.detail_ = SeaLampV3InfoOuterClass.SeaLampV3Info.getDefaultInstance();
                    }
                    this.seaLampV3InfoBuilder_ = new SingleFieldBuilderV3<>((SeaLampV3InfoOuterClass.SeaLampV3Info) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1080;
                onChanged();
                return this.seaLampV3InfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTeamChainInfo() {
                return this.detailCase_ == 144;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TeamChainInfoOuterClass.TeamChainInfo getTeamChainInfo() {
                if (this.teamChainInfoBuilder_ == null) {
                    if (this.detailCase_ == 144) {
                        return (TeamChainInfoOuterClass.TeamChainInfo) this.detail_;
                    }
                    return TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
                } else if (this.detailCase_ == 144) {
                    return this.teamChainInfoBuilder_.getMessage();
                } else {
                    return TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
                }
            }

            public Builder setTeamChainInfo(TeamChainInfoOuterClass.TeamChainInfo value) {
                if (this.teamChainInfoBuilder_ != null) {
                    this.teamChainInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 144;
                return this;
            }

            public Builder setTeamChainInfo(TeamChainInfoOuterClass.TeamChainInfo.Builder builderForValue) {
                if (this.teamChainInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.teamChainInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 144;
                return this;
            }

            public Builder mergeTeamChainInfo(TeamChainInfoOuterClass.TeamChainInfo value) {
                if (this.teamChainInfoBuilder_ == null) {
                    if (this.detailCase_ != 144 || this.detail_ == TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TeamChainInfoOuterClass.TeamChainInfo.newBuilder((TeamChainInfoOuterClass.TeamChainInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 144) {
                        this.teamChainInfoBuilder_.mergeFrom(value);
                    }
                    this.teamChainInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 144;
                return this;
            }

            public Builder clearTeamChainInfo() {
                if (this.teamChainInfoBuilder_ != null) {
                    if (this.detailCase_ == 144) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.teamChainInfoBuilder_.clear();
                } else if (this.detailCase_ == 144) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TeamChainInfoOuterClass.TeamChainInfo.Builder getTeamChainInfoBuilder() {
                return getTeamChainInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TeamChainInfoOuterClass.TeamChainInfoOrBuilder getTeamChainInfoOrBuilder() {
                if (this.detailCase_ == 144 && this.teamChainInfoBuilder_ != null) {
                    return this.teamChainInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 144) {
                    return (TeamChainInfoOuterClass.TeamChainInfo) this.detail_;
                }
                return TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TeamChainInfoOuterClass.TeamChainInfo, TeamChainInfoOuterClass.TeamChainInfo.Builder, TeamChainInfoOuterClass.TeamChainInfoOrBuilder> getTeamChainInfoFieldBuilder() {
                if (this.teamChainInfoBuilder_ == null) {
                    if (this.detailCase_ != 144) {
                        this.detail_ = TeamChainInfoOuterClass.TeamChainInfo.getDefaultInstance();
                    }
                    this.teamChainInfoBuilder_ = new SingleFieldBuilderV3<>((TeamChainInfoOuterClass.TeamChainInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 144;
                onChanged();
                return this.teamChainInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGcgFestivalInfo() {
                return this.detailCase_ == 71;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GcgFestivalInfoOuterClass.GcgFestivalInfo getGcgFestivalInfo() {
                if (this.gcgFestivalInfoBuilder_ == null) {
                    if (this.detailCase_ == 71) {
                        return (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_;
                    }
                    return GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
                } else if (this.detailCase_ == 71) {
                    return this.gcgFestivalInfoBuilder_.getMessage();
                } else {
                    return GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
                }
            }

            public Builder setGcgFestivalInfo(GcgFestivalInfoOuterClass.GcgFestivalInfo value) {
                if (this.gcgFestivalInfoBuilder_ != null) {
                    this.gcgFestivalInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 71;
                return this;
            }

            public Builder setGcgFestivalInfo(GcgFestivalInfoOuterClass.GcgFestivalInfo.Builder builderForValue) {
                if (this.gcgFestivalInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gcgFestivalInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 71;
                return this;
            }

            public Builder mergeGcgFestivalInfo(GcgFestivalInfoOuterClass.GcgFestivalInfo value) {
                if (this.gcgFestivalInfoBuilder_ == null) {
                    if (this.detailCase_ != 71 || this.detail_ == GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GcgFestivalInfoOuterClass.GcgFestivalInfo.newBuilder((GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 71) {
                        this.gcgFestivalInfoBuilder_.mergeFrom(value);
                    }
                    this.gcgFestivalInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 71;
                return this;
            }

            public Builder clearGcgFestivalInfo() {
                if (this.gcgFestivalInfoBuilder_ != null) {
                    if (this.detailCase_ == 71) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gcgFestivalInfoBuilder_.clear();
                } else if (this.detailCase_ == 71) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GcgFestivalInfoOuterClass.GcgFestivalInfo.Builder getGcgFestivalInfoBuilder() {
                return getGcgFestivalInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GcgFestivalInfoOuterClass.GcgFestivalInfoOrBuilder getGcgFestivalInfoOrBuilder() {
                if (this.detailCase_ == 71 && this.gcgFestivalInfoBuilder_ != null) {
                    return this.gcgFestivalInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 71) {
                    return (GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_;
                }
                return GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GcgFestivalInfoOuterClass.GcgFestivalInfo, GcgFestivalInfoOuterClass.GcgFestivalInfo.Builder, GcgFestivalInfoOuterClass.GcgFestivalInfoOrBuilder> getGcgFestivalInfoFieldBuilder() {
                if (this.gcgFestivalInfoBuilder_ == null) {
                    if (this.detailCase_ != 71) {
                        this.detail_ = GcgFestivalInfoOuterClass.GcgFestivalInfo.getDefaultInstance();
                    }
                    this.gcgFestivalInfoBuilder_ = new SingleFieldBuilderV3<>((GcgFestivalInfoOuterClass.GcgFestivalInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 71;
                onChanged();
                return this.gcgFestivalInfoBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static ActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SamLampInfoOuterClass.getDescriptor();
        CrucibleInfoOuterClass.getDescriptor();
        SalesmanInfoOuterClass.getDescriptor();
        TrialAvatarInfoOuterClass.getDescriptor();
        DeliveryInfoOuterClass.getDescriptor();
        AsterInfoOuterClass.getDescriptor();
        FlightInfoOuterClass.getDescriptor();
        DragonSpineInfoOuterClass.getDescriptor();
        EffigyInfoOuterClass.getDescriptor();
        TreasureMapInfoOuterClass.getDescriptor();
        BlessingInfoOuterClass.getDescriptor();
        SeaLampInfoOuterClass.getDescriptor();
        ExpeditionInfoOuterClass.getDescriptor();
        ArenaChallengeInfoOuterClass.getDescriptor();
        FleurFairInfoOuterClass.getDescriptor();
        WaterSpiritInfoOuterClass.getDescriptor();
        ChallnelerSlabInfoOuterClass.getDescriptor();
        MistTrialActivityInfoOuterClass.getDescriptor();
        HideAndSeekInfoOuterClass.getDescriptor();
        FindHilichurlInfoOuterClass.getDescriptor();
        SummerTimeInfoOuterClass.getDescriptor();
        BuoyantCombatInfoOuterClass.getDescriptor();
        EchoShellInfoOuterClass.getDescriptor();
        BounceConjuringInfoOuterClass.getDescriptor();
        BlitzRushInfoOuterClass.getDescriptor();
        ChessInfoOuterClass.getDescriptor();
        SumoInfoOuterClass.getDescriptor();
        MoonfinTrialInfoOuterClass.getDescriptor();
        LunaRiteInfoOuterClass.getDescriptor();
        PlantFlowerInfoOuterClass.getDescriptor();
        MusicGameActivityDetailInfoOuterClass.getDescriptor();
        RoguelikeDungoenInfoOuterClass.getDescriptor();
        DigInfoOuterClass.getDescriptor();
        HachiInfoOuterClass.getDescriptor();
        WinterCampInfoOuterClass.getDescriptor();
        PotionInfoOuterClass.getDescriptor();
        TanukiTravelActivityInfoOuterClass.getDescriptor();
        LanternRiteActivityInfoOuterClass.getDescriptor();
        MichiaeMatsuriInfoOuterClass.getDescriptor();
        BartenderInfoOuterClass.getDescriptor();
        UgcInfoOuterClass.getDescriptor();
        CrystalLinkInfoOuterClass.getDescriptor();
        IrodoriInfoOuterClass.getDescriptor();
        PhotoInfoOuterClass.getDescriptor();
        SpiceInfoOuterClass.getDescriptor();
        GachaInfoOuterClass.getDescriptor();
        LuminanceStoneChallengeInfoOuterClass.getDescriptor();
        RogueDiaryInfoOuterClass.getDescriptor();
        SummerTimeV2InfoOuterClass.getDescriptor();
        IslandPartyInfoOuterClass.getDescriptor();
        GearInfoOuterClass.getDescriptor();
        GravenInnocenceInfoOuterClass.getDescriptor();
        InstableSprayInfoOuterClass.getDescriptor();
        MuqadasPotionInfoOuterClass.getDescriptor();
        TreasureSeelieInfoOuterClass.getDescriptor();
        RockBoardExploreInfoOuterClass.getDescriptor();
        VintageInfoOuterClass.getDescriptor();
        WindFieldInfoOuterClass.getDescriptor();
        FungusFighterInfoOuterClass.getDescriptor();
        CharAmusementInfoOuterClass.getDescriptor();
        EffigyChallengeInfoOuterClass.getDescriptor();
        CoinCollectInfoOuterClass.getDescriptor();
        BrickBreakerInfoOuterClass.getDescriptor();
        DuelHeartInfoOuterClass.getDescriptor();
        SeaLampV3InfoOuterClass.getDescriptor();
        TeamChainInfoOuterClass.getDescriptor();
        GcgFestivalInfoOuterClass.getDescriptor();
        ActivityPushTipsDataOuterClass.getDescriptor();
        ActivityWatcherInfoOuterClass.getDescriptor();
    }
}
