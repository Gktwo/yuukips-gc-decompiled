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
import emu.grasscutter.net.proto.ArenaChallengeActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.AsterActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.BlessingActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.BlitzRushActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.BounceConjuringActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.BrickBreakerDetailInfoOuterClass;
import emu.grasscutter.net.proto.BuoyantCombatDetailInfoOuterClass;
import emu.grasscutter.net.proto.ChannelerSlabActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.CharAmusementDetailInfoOuterClass;
import emu.grasscutter.net.proto.ChessActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.CoinCollectDetailInfoOuterClass;
import emu.grasscutter.net.proto.CrucibleActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.CrystalLinkActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.DeliveryActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.DigActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass;
import emu.grasscutter.net.proto.EffigyActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.EffigyChallengeV2DetailInfoOuterClass;
import emu.grasscutter.net.proto.ExpeditionActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.FindHilichurlDetailInfoOuterClass;
import emu.grasscutter.net.proto.FleurFairActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.FlightActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.FungusFighterDetailInfoOuterClass;
import emu.grasscutter.net.proto.GachaActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.GearActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass;
import emu.grasscutter.net.proto.HachiActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.InstableSprayDetailInfoOuterClass;
import emu.grasscutter.net.proto.IrodoriActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.IslandPartyDetailInfoOuterClass;
import emu.grasscutter.net.proto.LanternRiteActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.LuminanceStoneChallengeActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.LunaRiteDetailInfoOuterClass;
import emu.grasscutter.net.proto.MichiaeMatsuriActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.MistTrialActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.MoonfinTrialActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.MuqadasPotionActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.MusicGameActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.PhotoActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.PlantFlowerActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.PotionActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.RockBoardExploreDetailInfoOuterClass;
import emu.grasscutter.net.proto.RogueDiaryActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.SalesmanActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.SeaLampActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass;
import emu.grasscutter.net.proto.SpiceActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeDetailInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass;
import emu.grasscutter.net.proto.SumoActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.TanukiTravelActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.TreasureMapActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.TreasureSeelieActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.TrialAvatarActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.UgcActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.VintageActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.WaterSpiritActivityDetailInfoOuterClass;
import emu.grasscutter.net.proto.WindFieldDetailInfoOuterClass;
import emu.grasscutter.net.proto.WinterCampActivityDetailInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass.class */
public final class ActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012ActivityInfo.proto\u001a\u001aActivityPushTipsData.proto\u001a\u0019ActivityWatcherInfo.proto\u001a&ArenaChallengeActivityDetailInfo.proto\u001a\u001dAsterActivityDetailInfo.proto\u001a!BartenderActivityDetailInfo.proto\u001a BlessingActivityDetailInfo.proto\u001a!BlitzRushActivityDetailInfo.proto\u001a'BounceConjuringActivityDetailInfo.proto\u001a\u001cBrickBreakerDetailInfo.proto\u001a\u001dBuoyantCombatDetailInfo.proto\u001a%ChannelerSlabActivityDetailInfo.proto\u001a\u001dCharAmusementDetailInfo.proto\u001a\u001dChessActivityDetailInfo.proto\u001a\u001bCoinCollectDetailInfo.proto\u001a CrucibleActivityDetailInfo.proto\u001a#CrystalLinkActivityDetailInfo.proto\u001a DeliveryActivityDetailInfo.proto\u001a\u001bDigActivityDetailInfo.proto\u001a#DragonSpineActivityDetailInfo.proto\u001a\u0019EchoShellDetailInfo.proto\u001a\u001eEffigyActivityDetailInfo.proto\u001a!EffigyChallengeV2DetailInfo.proto\u001a\"ExpeditionActivityDetailInfo.proto\u001a\u001dFindHilichurlDetailInfo.proto\u001a!FleurFairActivityDetailInfo.proto\u001a\u001eFlightActivityDetailInfo.proto\u001a\u001dFungusFighterDetailInfo.proto\u001a\u001dGachaActivityDetailInfo.proto\u001a\u001cGearActivityDetailInfo.proto\u001a\u001fGravenInnocenceDetailInfo.proto\u001a\u001dHachiActivityDetailInfo.proto\u001a#HideAndSeekActivityDetailInfo.proto\u001a\u001dInstableSprayDetailInfo.proto\u001a\u001fIrodoriActivityDetailInfo.proto\u001a\u001bIslandPartyDetailInfo.proto\u001a#LanternRiteActivityDetailInfo.proto\u001a/LuminanceStoneChallengeActivityDetailInfo.proto\u001a\u0018LunaRiteDetailInfo.proto\u001a&MichiaeMatsuriActivityDetailInfo.proto\u001a!MistTrialActivityDetailInfo.proto\u001a$MoonfinTrialActivityDetailInfo.proto\u001a%MuqadasPotionActivityDetailInfo.proto\u001a!MusicGameActivityDetailInfo.proto\u001a\u001dPhotoActivityDetailInfo.proto\u001a#PlantFlowerActivityDetailInfo.proto\u001a\u001ePotionActivityDetailInfo.proto\u001a RockBoardExploreDetailInfo.proto\u001a\"RogueDiaryActivityDetailInfo.proto\u001a(RoguelikeDungeonActivityDetailInfo.proto\u001a SalesmanActivityDetailInfo.proto\u001a\u001fSeaLampActivityDetailInfo.proto\u001a\u0019SeaLampActivityInfo.proto\u001a\u001dSpiceActivityDetailInfo.proto\u001a\u001aSummerTimeDetailInfo.proto\u001a\u001cSummerTimeV2DetailInfo.proto\u001a\u001cSumoActivityDetailInfo.proto\u001a$TanukiTravelActivityDetailInfo.proto\u001a#TreasureMapActivityDetailInfo.proto\u001a&TreasureSeelieActivityDetailInfo.proto\u001a#TrialAvatarActivityDetailInfo.proto\u001a\u001bUgcActivityDetailInfo.proto\u001a\u001fVintageActivityDetailInfo.proto\u001a#WaterSpiritActivityDetailInfo.proto\u001a\u0019WindFieldDetailInfo.proto\u001a\"WinterCampActivityDetailInfo.proto\"#\n\fActivityInfo\u0012\u001c\n\u0013Unk3300_MJNPGEKLOCG\u0018è\u0002 \u0001(\b\u0012\u0013\n\u000bis_finished\u0018\b \u0001(\b\u0012\u0012\n\tcur_score\u0018ô\t \u0001(\r\u0012\u0013\n\u000bschedule_id\u0018\u0007 \u0001(\r\u0012\u0014\n\u000bscore_limit\u0018Î\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_ICNJJKDHPCH\u0018\u000e \u0001(\b\u0012\u0016\n\u000emeet_cond_list\u0018\u000b \u0003(\r\u0012\u001c\n\u0013Unk3300_NEPKLLBJFKK\u0018í\f \u0001(\b\u0012/\n\u0011watcher_info_list\u0018\u0006 \u0003(\u000b2\u0014.ActivityWatcherInfo\u0012<\n\u001cactivity_push_tips_data_list\u0018Ë\u000e \u0003(\u000b2\u0015.ActivityPushTipsData\u0012\u0013\n\u000bactivity_id\u0018\r \u0001(\r\u0012\u001a\n\u0011taken_reward_list\u0018á\u000e \u0003(\r\u0012\"\n\u0019selected_avatar_reward_id\u0018¹\u0005 \u0001(\r\u0012=\n\u0011activity_coin_map\u0018$ \u0003(\u000b2\".ActivityInfo.ActivityCoinMapEntry\u0012\u001d\n\u0014first_day_start_time\u0018\u0006 \u0001(\r\u0012\u001c\n\u0013Unk3300_ABJKLALKLDG\u0018Î\u000b \u0001(\b\u0012\u0015\n\ractivity_type\u0018\u0003 \u0001(\r\u0012\u001c\n\u0013Unk3300_CBCEHLJJOGI\u0018ß\n \u0001(\b\u0012\u0012\n\nbegin_time\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_MDBDPIBEGGH\u0018\f \u0001(\b\u0012=\n\u0011wish_gift_num_map\u0018«\u0007 \u0003(\u000b2!.ActivityInfo.WishGiftNumMapEntry\u0012\u0010\n\bend_time\u0018\n \u0001(\r\u0012\u0018\n\u0010expire_cond_list\u0018\u0005 \u0003(\r\u00123\n\rsam_lamp_info\u0018\u0002 \u0001(\u000b2\u001a.SeaLampActivityDetailInfoH��\u00124\n\rcrucible_info\u0018\u000f \u0001(\u000b2\u001b.CrucibleActivityDetailInfoH��\u00124\n\rsalesman_info\u0018\t \u0001(\u000b2\u001b.SalesmanActivityDetailInfoH��\u0012;\n\u0011trial_avatar_info\u0018\u0004 \u0001(\u000b2\u001e.TrialAvatarActivityDetailInfoH��\u00125\n\rdelivery_info\u0018õ\b \u0001(\u000b2\u001b.DeliveryActivityDetailInfoH��\u0012/\n\naster_info\u0018¹\u000f \u0001(\u000b2\u0018.AsterActivityDetailInfoH��\u00121\n\u000bflight_info\u0018Û\u000f \u0001(\u000b2\u0019.FlightActivityDetailInfoH��\u0012<\n\u0011dragon_spine_info\u0018\n \u0001(\u000b2\u001e.DragonSpineActivityDetailInfoH��\u00121\n\u000beffigy_info\u0018Þ\n \u0001(\u000b2\u0019.EffigyActivityDetailInfoH��\u0012<\n\u0011treasure_map_info\u0018\u000f \u0001(\u000b2\u001e.TreasureMapActivityDetailInfoH��\u00125\n\rblessing_info\u0018ª\u000f \u0001(\u000b2\u001b.BlessingActivityDetailInfoH��\u0012.\n\rsea_lamp_info\u0018÷\u0001 \u0001(\u000b2\u0014.SeaLampActivityInfoH��\u00129\n\u000fexpedition_info\u0018Ø\r \u0001(\u000b2\u001d.ExpeditionActivityDetailInfoH��\u0012B\n\u0014arena_challenge_info\u0018\u0004 \u0001(\u000b2!.ArenaChallengeActivityDetailInfoH��\u00128\n\u000ffleur_fair_info\u0018§\u000b \u0001(\u000b2\u001c.FleurFairActivityDetailInfoH��\u0012<\n\u0011water_spirit_info\u0018û\u0004 \u0001(\u000b2\u001e.WaterSpiritActivityDetailInfoH��\u0012@\n\u0013channeler_slab_info\u0018Î\u0006 \u0001(\u000b2 .ChannelerSlabActivityDetailInfoH��\u0012A\n\u0018mist_trial_activity_info\u0018°\u0003 \u0001(\u000b2\u001c.MistTrialActivityDetailInfoH��\u0012=\n\u0012hide_and_seek_info\u0018Ç\u0006 \u0001(\u000b2\u001e.HideAndSeekActivityDetailInfoH��\u00128\n\u0013find_hilichurl_info\u0018ú\u0002 \u0001(\u000b2\u0018.FindHilichurlDetailInfoH��\u00122\n\u0010summer_time_info\u0018ö\u000e \u0001(\u000b2\u0015.SummerTimeDetailInfoH��\u00128\n\u0013buoyant_combat_info\u0018®\u0005 \u0001(\u000b2\u0018.BuoyantCombatDetailInfoH��\u00120\n\u000fecho_shell_info\u0018\t \u0001(\u000b2\u0014.EchoShellDetailInfoH��\u0012D\n\u0015bounce_conjuring_info\u0018\u0007 \u0001(\u000b2\".BounceConjuringActivityDetailInfoH��\u00127\n\u000fblitz_rush_info\u0018@ \u0001(\u000b2\u001c.BlitzRushActivityDetailInfoH��\u0012/\n\nchess_info\u0018î\u0007 \u0001(\u000b2\u0018.ChessActivityDetailInfoH��\u0012-\n\tsumo_info\u0018ù\u0003 \u0001(\u000b2\u0017.SumoActivityDetailInfoH��\u0012>\n\u0012moonfin_trial_info\u0018þ\u0005 \u0001(\u000b2\u001f.MoonfinTrialActivityDetailInfoH��\u0012.\n\u000eluna_rite_info\u0018\f \u0001(\u000b2\u0013.LunaRiteDetailInfoH��\u0012<\n\u0011plant_flower_info\u0018ú\t \u0001(\u000b2\u001e.PlantFlowerActivityDetailInfoH��\u00128\n\u000fmusic_game_info\u0018Å\u000f \u0001(\u000b2\u001c.MusicGameActivityDetailInfoH��\u0012F\n\u0016roguelike_dungeon_info\u0018Ê\u0007 \u0001(\u000b2#.RoguelikeDungeonActivityDetailInfoH��\u0012+\n\bdig_info\u0018Æ\u000e \u0001(\u000b2\u0016.DigActivityDetailInfoH��\u0012/\n\nhachi_info\u0018ÿ\u0003 \u0001(\u000b2\u0018.HachiActivityDetailInfoH��\u0012:\n\u0010winter_camp_info\u0018»\u0005 \u0001(\u000b2\u001d.WinterCampActivityDetailInfoH��\u00121\n\u000bpotion_info\u0018\f \u0001(\u000b2\u0019.PotionActivityDetailInfoH��\u0012G\n\u001btanuki_travel_activity_info\u0018Ä\n \u0001(\u000b2\u001f.TanukiTravelActivityDetailInfoH��\u0012E\n\u001alantern_rite_activity_info\u0018í\u0001 \u0001(\u000b2\u001e.LanternRiteActivityDetailInfoH��\u0012B\n\u0014michiae_matsuri_info\u0018¯\u000e \u0001(\u000b2!.MichiaeMatsuriActivityDetailInfoH��\u00127\n\u000ebartender_info\u0018§\u0004 \u0001(\u000b2\u001c.BartenderActivityDetailInfoH��\u0012+\n\bugc_info\u0018\t \u0001(\u000b2\u0016.UgcActivityDetailInfoH��\u0012<\n\u0011crystal_link_info\u0018¬\u0006 \u0001(\u000b2\u001e.CrystalLinkActivityDetailInfoH��\u00123\n\firodori_info\u0018 \b \u0001(\u000b2\u001a.IrodoriActivityDetailInfoH��\u0012/\n\nphoto_info\u0018\u000e \u0001(\u000b2\u0018.PhotoActivityDetailInfoH��\u0012/\n\nspice_info\u0018\u0006 \u0001(\u000b2\u0018.SpiceActivityDetailInfoH��\u0012/\n\ngacha_info\u0018\n \u0001(\u000b2\u0018.GachaActivityDetailInfoH��\u0012U\n\u001eluminance_stone_challenge_info\u0018¼\u0003 \u0001(\u000b2*.LuminanceStoneChallengeActivityDetailInfoH��\u0012:\n\u0010rogue_diary_info\u0018°\u0004 \u0001(\u000b2\u001d.RogueDiaryActivityDetailInfoH��\u00127\n\u0013summer_time_v2_info\u0018\u0003 \u0001(\u000b2\u0017.SummerTimeV2DetailInfoH��\u00124\n\u0011island_party_info\u0018ä\u0005 \u0001(\u000b2\u0016.IslandPartyDetailInfoH��\u0012-\n\tgear_info\u0018Ê\u000b \u0001(\u000b2\u0017.GearActivityDetailInfoH��\u0012<\n\u0015graven_innocence_info\u0018\u000f \u0001(\u000b2\u001a.GravenInnocenceDetailInfoH��\u00128\n\u0013instable_spray_info\u0018ù\b \u0001(\u000b2\u0018.InstableSprayDetailInfoH��\u0012@\n\u0013muqadas_potion_info\u0018þ\f \u0001(\u000b2 .MuqadasPotionActivityDetailInfoH��\u0012B\n\u0014treasure_seelie_info\u0018\b \u0001(\u000b2!.TreasureSeelieActivityDetailInfoH��\u0012?\n\u0017rock_board_explore_info\u0018ñ\t \u0001(\u000b2\u001b.RockBoardExploreDetailInfoH��\u00123\n\fvintage_info\u0018\n \u0001(\u000b2\u001a.VintageActivityDetailInfoH��\u00120\n\u000fwind_field_info\u0018Ô\u0003 \u0001(\u000b2\u0014.WindFieldDetailInfoH��\u00128\n\u0013fungus_fighter_info\u0018Ý\r \u0001(\u000b2\u0018.FungusFighterDetailInfoH��\u00128\n\u0013char_amusement_info\u0018í\u0004 \u0001(\u000b2\u0018.CharAmusementDetailInfoH��\u0012>\n\u0015effigy_challenge_info\u0018é\u0001 \u0001(\u000b2\u001c.EffigyChallengeV2DetailInfoH��\u00124\n\u0011coin_collect_info\u0018Ò\u000f \u0001(\u000b2\u0016.CoinCollectDetailInfoH��\u00126\n\u0012brick_breaker_info\u0018ò\u000b \u0001(\u000b2\u0017.BrickBreakerDetailInfoH��\u001a6\n\u0014ActivityCoinMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a5\n\u0013WishGiftNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\b\n\u0006detailB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ActivityPushTipsDataOuterClass.getDescriptor(), ActivityWatcherInfoOuterClass.getDescriptor(), ArenaChallengeActivityDetailInfoOuterClass.getDescriptor(), AsterActivityDetailInfoOuterClass.getDescriptor(), BartenderActivityDetailInfoOuterClass.getDescriptor(), BlessingActivityDetailInfoOuterClass.getDescriptor(), BlitzRushActivityDetailInfoOuterClass.getDescriptor(), BounceConjuringActivityDetailInfoOuterClass.getDescriptor(), BrickBreakerDetailInfoOuterClass.getDescriptor(), BuoyantCombatDetailInfoOuterClass.getDescriptor(), ChannelerSlabActivityDetailInfoOuterClass.getDescriptor(), CharAmusementDetailInfoOuterClass.getDescriptor(), ChessActivityDetailInfoOuterClass.getDescriptor(), CoinCollectDetailInfoOuterClass.getDescriptor(), CrucibleActivityDetailInfoOuterClass.getDescriptor(), CrystalLinkActivityDetailInfoOuterClass.getDescriptor(), DeliveryActivityDetailInfoOuterClass.getDescriptor(), DigActivityDetailInfoOuterClass.getDescriptor(), DragonSpineActivityDetailInfoOuterClass.getDescriptor(), EchoShellDetailInfoOuterClass.getDescriptor(), EffigyActivityDetailInfoOuterClass.getDescriptor(), EffigyChallengeV2DetailInfoOuterClass.getDescriptor(), ExpeditionActivityDetailInfoOuterClass.getDescriptor(), FindHilichurlDetailInfoOuterClass.getDescriptor(), FleurFairActivityDetailInfoOuterClass.getDescriptor(), FlightActivityDetailInfoOuterClass.getDescriptor(), FungusFighterDetailInfoOuterClass.getDescriptor(), GachaActivityDetailInfoOuterClass.getDescriptor(), GearActivityDetailInfoOuterClass.getDescriptor(), GravenInnocenceDetailInfoOuterClass.getDescriptor(), HachiActivityDetailInfoOuterClass.getDescriptor(), HideAndSeekActivityDetailInfoOuterClass.getDescriptor(), InstableSprayDetailInfoOuterClass.getDescriptor(), IrodoriActivityDetailInfoOuterClass.getDescriptor(), IslandPartyDetailInfoOuterClass.getDescriptor(), LanternRiteActivityDetailInfoOuterClass.getDescriptor(), LuminanceStoneChallengeActivityDetailInfoOuterClass.getDescriptor(), LunaRiteDetailInfoOuterClass.getDescriptor(), MichiaeMatsuriActivityDetailInfoOuterClass.getDescriptor(), MistTrialActivityDetailInfoOuterClass.getDescriptor(), MoonfinTrialActivityDetailInfoOuterClass.getDescriptor(), MuqadasPotionActivityDetailInfoOuterClass.getDescriptor(), MusicGameActivityDetailInfoOuterClass.getDescriptor(), PhotoActivityDetailInfoOuterClass.getDescriptor(), PlantFlowerActivityDetailInfoOuterClass.getDescriptor(), PotionActivityDetailInfoOuterClass.getDescriptor(), RockBoardExploreDetailInfoOuterClass.getDescriptor(), RogueDiaryActivityDetailInfoOuterClass.getDescriptor(), RoguelikeDungeonActivityDetailInfoOuterClass.getDescriptor(), SalesmanActivityDetailInfoOuterClass.getDescriptor(), SeaLampActivityDetailInfoOuterClass.getDescriptor(), SeaLampActivityInfoOuterClass.getDescriptor(), SpiceActivityDetailInfoOuterClass.getDescriptor(), SummerTimeDetailInfoOuterClass.getDescriptor(), SummerTimeV2DetailInfoOuterClass.getDescriptor(), SumoActivityDetailInfoOuterClass.getDescriptor(), TanukiTravelActivityDetailInfoOuterClass.getDescriptor(), TreasureMapActivityDetailInfoOuterClass.getDescriptor(), TreasureSeelieActivityDetailInfoOuterClass.getDescriptor(), TrialAvatarActivityDetailInfoOuterClass.getDescriptor(), UgcActivityDetailInfoOuterClass.getDescriptor(), VintageActivityDetailInfoOuterClass.getDescriptor(), WaterSpiritActivityDetailInfoOuterClass.getDescriptor(), WindFieldDetailInfoOuterClass.getDescriptor(), WinterCampActivityDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_descriptor, new String[]{"Unk3300MJNPGEKLOCG", "IsFinished", "CurScore", "ScheduleId", "ScoreLimit", "Unk3300ICNJJKDHPCH", "MeetCondList", "Unk3300NEPKLLBJFKK", "WatcherInfoList", "ActivityPushTipsDataList", "ActivityId", "TakenRewardList", "SelectedAvatarRewardId", "ActivityCoinMap", "FirstDayStartTime", "Unk3300ABJKLALKLDG", "ActivityType", "Unk3300CBCEHLJJOGI", "BeginTime", "Unk3300MDBDPIBEGGH", "WishGiftNumMap", "EndTime", "ExpireCondList", "SamLampInfo", "CrucibleInfo", "SalesmanInfo", "TrialAvatarInfo", "DeliveryInfo", "AsterInfo", "FlightInfo", "DragonSpineInfo", "EffigyInfo", "TreasureMapInfo", "BlessingInfo", "SeaLampInfo", "ExpeditionInfo", "ArenaChallengeInfo", "FleurFairInfo", "WaterSpiritInfo", "ChannelerSlabInfo", "MistTrialActivityInfo", "HideAndSeekInfo", "FindHilichurlInfo", "SummerTimeInfo", "BuoyantCombatInfo", "EchoShellInfo", "BounceConjuringInfo", "BlitzRushInfo", "ChessInfo", "SumoInfo", "MoonfinTrialInfo", "LunaRiteInfo", "PlantFlowerInfo", "MusicGameInfo", "RoguelikeDungeonInfo", "DigInfo", "HachiInfo", "WinterCampInfo", "PotionInfo", "TanukiTravelActivityInfo", "LanternRiteActivityInfo", "MichiaeMatsuriInfo", "BartenderInfo", "UgcInfo", "CrystalLinkInfo", "IrodoriInfo", "PhotoInfo", "SpiceInfo", "GachaInfo", "LuminanceStoneChallengeInfo", "RogueDiaryInfo", "SummerTimeV2Info", "IslandPartyInfo", "GearInfo", "GravenInnocenceInfo", "InstableSprayInfo", "MuqadasPotionInfo", "TreasureSeelieInfo", "RockBoardExploreInfo", "VintageInfo", "WindFieldInfo", "FungusFighterInfo", "CharAmusementInfo", "EffigyChallengeInfo", "CoinCollectInfo", "BrickBreakerInfo", "Detail"});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_ActivityCoinMapEntry_descriptor = internal_static_ActivityInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_ActivityInfo_ActivityCoinMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f616x9eedbfc3 = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_ActivityCoinMapEntry_descriptor, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_ActivityInfo_WishGiftNumMapEntry_descriptor = internal_static_ActivityInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_ActivityInfo_WishGiftNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f617xbf0b43da = new GeneratedMessageV3.FieldAccessorTable(internal_static_ActivityInfo_WishGiftNumMapEntry_descriptor, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ActivityInfoOuterClass$ActivityInfoOrBuilder.class */
    public interface ActivityInfoOrBuilder extends MessageOrBuilder {
        boolean getUnk3300MJNPGEKLOCG();

        boolean getIsFinished();

        int getCurScore();

        int getScheduleId();

        int getScoreLimit();

        boolean getUnk3300ICNJJKDHPCH();

        List<Integer> getMeetCondListList();

        int getMeetCondListCount();

        int getMeetCondList(int i);

        boolean getUnk3300NEPKLLBJFKK();

        List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> getWatcherInfoListList();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfo getWatcherInfoList(int i);

        int getWatcherInfoListCount();

        List<? extends ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> getWatcherInfoListOrBuilderList();

        ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder getWatcherInfoListOrBuilder(int i);

        List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> getActivityPushTipsDataListList();

        ActivityPushTipsDataOuterClass.ActivityPushTipsData getActivityPushTipsDataList(int i);

        int getActivityPushTipsDataListCount();

        List<? extends ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> getActivityPushTipsDataListOrBuilderList();

        ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder getActivityPushTipsDataListOrBuilder(int i);

        int getActivityId();

        List<Integer> getTakenRewardListList();

        int getTakenRewardListCount();

        int getTakenRewardList(int i);

        int getSelectedAvatarRewardId();

        int getActivityCoinMapCount();

        boolean containsActivityCoinMap(int i);

        @Deprecated
        Map<Integer, Integer> getActivityCoinMap();

        Map<Integer, Integer> getActivityCoinMapMap();

        int getActivityCoinMapOrDefault(int i, int i2);

        int getActivityCoinMapOrThrow(int i);

        int getFirstDayStartTime();

        boolean getUnk3300ABJKLALKLDG();

        int getActivityType();

        boolean getUnk3300CBCEHLJJOGI();

        int getBeginTime();

        boolean getUnk3300MDBDPIBEGGH();

        int getWishGiftNumMapCount();

        boolean containsWishGiftNumMap(int i);

        @Deprecated
        Map<Integer, Integer> getWishGiftNumMap();

        Map<Integer, Integer> getWishGiftNumMapMap();

        int getWishGiftNumMapOrDefault(int i, int i2);

        int getWishGiftNumMapOrThrow(int i);

        int getEndTime();

        List<Integer> getExpireCondListList();

        int getExpireCondListCount();

        int getExpireCondList(int i);

        boolean hasSamLampInfo();

        SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo getSamLampInfo();

        SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfoOrBuilder getSamLampInfoOrBuilder();

        boolean hasCrucibleInfo();

        CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo getCrucibleInfo();

        CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder getCrucibleInfoOrBuilder();

        boolean hasSalesmanInfo();

        SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo getSalesmanInfo();

        SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder getSalesmanInfoOrBuilder();

        boolean hasTrialAvatarInfo();

        TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo getTrialAvatarInfo();

        TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder getTrialAvatarInfoOrBuilder();

        boolean hasDeliveryInfo();

        DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo getDeliveryInfo();

        DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder getDeliveryInfoOrBuilder();

        boolean hasAsterInfo();

        AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo getAsterInfo();

        AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder getAsterInfoOrBuilder();

        boolean hasFlightInfo();

        FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo getFlightInfo();

        FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder getFlightInfoOrBuilder();

        boolean hasDragonSpineInfo();

        DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo getDragonSpineInfo();

        DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder getDragonSpineInfoOrBuilder();

        boolean hasEffigyInfo();

        EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo getEffigyInfo();

        EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfoOrBuilder getEffigyInfoOrBuilder();

        boolean hasTreasureMapInfo();

        TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo getTreasureMapInfo();

        TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder getTreasureMapInfoOrBuilder();

        boolean hasBlessingInfo();

        BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo getBlessingInfo();

        BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder getBlessingInfoOrBuilder();

        boolean hasSeaLampInfo();

        SeaLampActivityInfoOuterClass.SeaLampActivityInfo getSeaLampInfo();

        SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder getSeaLampInfoOrBuilder();

        boolean hasExpeditionInfo();

        ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo getExpeditionInfo();

        ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder getExpeditionInfoOrBuilder();

        boolean hasArenaChallengeInfo();

        ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo getArenaChallengeInfo();

        ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfoOrBuilder getArenaChallengeInfoOrBuilder();

        boolean hasFleurFairInfo();

        FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo getFleurFairInfo();

        FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder getFleurFairInfoOrBuilder();

        boolean hasWaterSpiritInfo();

        WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo getWaterSpiritInfo();

        WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfoOrBuilder getWaterSpiritInfoOrBuilder();

        boolean hasChannelerSlabInfo();

        ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo getChannelerSlabInfo();

        ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfoOrBuilder getChannelerSlabInfoOrBuilder();

        boolean hasMistTrialActivityInfo();

        MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo getMistTrialActivityInfo();

        MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder getMistTrialActivityInfoOrBuilder();

        boolean hasHideAndSeekInfo();

        HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo getHideAndSeekInfo();

        HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder getHideAndSeekInfoOrBuilder();

        boolean hasFindHilichurlInfo();

        FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo getFindHilichurlInfo();

        FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder getFindHilichurlInfoOrBuilder();

        boolean hasSummerTimeInfo();

        SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo getSummerTimeInfo();

        SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder getSummerTimeInfoOrBuilder();

        boolean hasBuoyantCombatInfo();

        BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo getBuoyantCombatInfo();

        BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder getBuoyantCombatInfoOrBuilder();

        boolean hasEchoShellInfo();

        EchoShellDetailInfoOuterClass.EchoShellDetailInfo getEchoShellInfo();

        EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder getEchoShellInfoOrBuilder();

        boolean hasBounceConjuringInfo();

        BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo getBounceConjuringInfo();

        BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder getBounceConjuringInfoOrBuilder();

        boolean hasBlitzRushInfo();

        BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo getBlitzRushInfo();

        BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder getBlitzRushInfoOrBuilder();

        boolean hasChessInfo();

        ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo getChessInfo();

        ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder getChessInfoOrBuilder();

        boolean hasSumoInfo();

        SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo getSumoInfo();

        SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder getSumoInfoOrBuilder();

        boolean hasMoonfinTrialInfo();

        MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo getMoonfinTrialInfo();

        MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfoOrBuilder getMoonfinTrialInfoOrBuilder();

        boolean hasLunaRiteInfo();

        LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo getLunaRiteInfo();

        LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder getLunaRiteInfoOrBuilder();

        boolean hasPlantFlowerInfo();

        PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo getPlantFlowerInfo();

        PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder getPlantFlowerInfoOrBuilder();

        boolean hasMusicGameInfo();

        MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo();

        MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder getMusicGameInfoOrBuilder();

        boolean hasRoguelikeDungeonInfo();

        RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo getRoguelikeDungeonInfo();

        RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder getRoguelikeDungeonInfoOrBuilder();

        boolean hasDigInfo();

        DigActivityDetailInfoOuterClass.DigActivityDetailInfo getDigInfo();

        DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder getDigInfoOrBuilder();

        boolean hasHachiInfo();

        HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo getHachiInfo();

        HachiActivityDetailInfoOuterClass.HachiActivityDetailInfoOrBuilder getHachiInfoOrBuilder();

        boolean hasWinterCampInfo();

        WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo getWinterCampInfo();

        WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder getWinterCampInfoOrBuilder();

        boolean hasPotionInfo();

        PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo getPotionInfo();

        PotionActivityDetailInfoOuterClass.PotionActivityDetailInfoOrBuilder getPotionInfoOrBuilder();

        boolean hasTanukiTravelActivityInfo();

        TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo getTanukiTravelActivityInfo();

        TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder getTanukiTravelActivityInfoOrBuilder();

        boolean hasLanternRiteActivityInfo();

        LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo getLanternRiteActivityInfo();

        LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder getLanternRiteActivityInfoOrBuilder();

        boolean hasMichiaeMatsuriInfo();

        MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo getMichiaeMatsuriInfo();

        MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder getMichiaeMatsuriInfoOrBuilder();

        boolean hasBartenderInfo();

        BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo getBartenderInfo();

        BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder getBartenderInfoOrBuilder();

        boolean hasUgcInfo();

        UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo getUgcInfo();

        UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder getUgcInfoOrBuilder();

        boolean hasCrystalLinkInfo();

        CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo getCrystalLinkInfo();

        CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfoOrBuilder getCrystalLinkInfoOrBuilder();

        boolean hasIrodoriInfo();

        IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo getIrodoriInfo();

        IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder getIrodoriInfoOrBuilder();

        boolean hasPhotoInfo();

        PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo getPhotoInfo();

        PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder getPhotoInfoOrBuilder();

        boolean hasSpiceInfo();

        SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo getSpiceInfo();

        SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfoOrBuilder getSpiceInfoOrBuilder();

        boolean hasGachaInfo();

        GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo getGachaInfo();

        GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder getGachaInfoOrBuilder();

        boolean hasLuminanceStoneChallengeInfo();

        LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo getLuminanceStoneChallengeInfo();

        LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder();

        boolean hasRogueDiaryInfo();

        RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo getRogueDiaryInfo();

        RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder getRogueDiaryInfoOrBuilder();

        boolean hasSummerTimeV2Info();

        SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo getSummerTimeV2Info();

        SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder getSummerTimeV2InfoOrBuilder();

        boolean hasIslandPartyInfo();

        IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo getIslandPartyInfo();

        IslandPartyDetailInfoOuterClass.IslandPartyDetailInfoOrBuilder getIslandPartyInfoOrBuilder();

        boolean hasGearInfo();

        GearActivityDetailInfoOuterClass.GearActivityDetailInfo getGearInfo();

        GearActivityDetailInfoOuterClass.GearActivityDetailInfoOrBuilder getGearInfoOrBuilder();

        boolean hasGravenInnocenceInfo();

        GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo getGravenInnocenceInfo();

        GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder getGravenInnocenceInfoOrBuilder();

        boolean hasInstableSprayInfo();

        InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo getInstableSprayInfo();

        InstableSprayDetailInfoOuterClass.InstableSprayDetailInfoOrBuilder getInstableSprayInfoOrBuilder();

        boolean hasMuqadasPotionInfo();

        MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo getMuqadasPotionInfo();

        MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder getMuqadasPotionInfoOrBuilder();

        boolean hasTreasureSeelieInfo();

        TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo getTreasureSeelieInfo();

        TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder getTreasureSeelieInfoOrBuilder();

        boolean hasRockBoardExploreInfo();

        RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo getRockBoardExploreInfo();

        RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfoOrBuilder getRockBoardExploreInfoOrBuilder();

        boolean hasVintageInfo();

        VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo getVintageInfo();

        VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder getVintageInfoOrBuilder();

        boolean hasWindFieldInfo();

        WindFieldDetailInfoOuterClass.WindFieldDetailInfo getWindFieldInfo();

        WindFieldDetailInfoOuterClass.WindFieldDetailInfoOrBuilder getWindFieldInfoOrBuilder();

        boolean hasFungusFighterInfo();

        FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo getFungusFighterInfo();

        FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder getFungusFighterInfoOrBuilder();

        boolean hasCharAmusementInfo();

        CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo getCharAmusementInfo();

        CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder getCharAmusementInfoOrBuilder();

        boolean hasEffigyChallengeInfo();

        EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo getEffigyChallengeInfo();

        EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder getEffigyChallengeInfoOrBuilder();

        boolean hasCoinCollectInfo();

        CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo getCoinCollectInfo();

        CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder getCoinCollectInfoOrBuilder();

        boolean hasBrickBreakerInfo();

        BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo getBrickBreakerInfo();

        BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder getBrickBreakerInfoOrBuilder();

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
        public static final int UNK3300_MJNPGEKLOCG_FIELD_NUMBER = 360;
        private boolean unk3300MJNPGEKLOCG_;
        public static final int IS_FINISHED_FIELD_NUMBER = 8;
        private boolean isFinished_;
        public static final int CUR_SCORE_FIELD_NUMBER = 1268;
        private int curScore_;
        public static final int SCHEDULE_ID_FIELD_NUMBER = 7;
        private int scheduleId_;
        public static final int SCORE_LIMIT_FIELD_NUMBER = 1870;
        private int scoreLimit_;
        public static final int UNK3300_ICNJJKDHPCH_FIELD_NUMBER = 14;
        private boolean unk3300ICNJJKDHPCH_;
        public static final int MEET_COND_LIST_FIELD_NUMBER = 11;
        private Internal.IntList meetCondList_;
        private int meetCondListMemoizedSerializedSize;
        public static final int UNK3300_NEPKLLBJFKK_FIELD_NUMBER = 1645;
        private boolean unk3300NEPKLLBJFKK_;
        public static final int WATCHER_INFO_LIST_FIELD_NUMBER = 6;
        private List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> watcherInfoList_;
        public static final int ACTIVITY_PUSH_TIPS_DATA_LIST_FIELD_NUMBER = 1867;
        private List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> activityPushTipsDataList_;
        public static final int ACTIVITY_ID_FIELD_NUMBER = 13;
        private int activityId_;
        public static final int TAKEN_REWARD_LIST_FIELD_NUMBER = 1889;
        private Internal.IntList takenRewardList_;
        private int takenRewardListMemoizedSerializedSize;
        public static final int SELECTED_AVATAR_REWARD_ID_FIELD_NUMBER = 697;
        private int selectedAvatarRewardId_;
        public static final int ACTIVITY_COIN_MAP_FIELD_NUMBER = 36;
        private MapField<Integer, Integer> activityCoinMap_;
        public static final int FIRST_DAY_START_TIME_FIELD_NUMBER = 786;
        private int firstDayStartTime_;
        public static final int UNK3300_ABJKLALKLDG_FIELD_NUMBER = 1486;
        private boolean unk3300ABJKLALKLDG_;
        public static final int ACTIVITY_TYPE_FIELD_NUMBER = 3;
        private int activityType_;
        public static final int UNK3300_CBCEHLJJOGI_FIELD_NUMBER = 1375;
        private boolean unk3300CBCEHLJJOGI_;
        public static final int BEGIN_TIME_FIELD_NUMBER = 1;
        private int beginTime_;
        public static final int UNK3300_MDBDPIBEGGH_FIELD_NUMBER = 12;
        private boolean unk3300MDBDPIBEGGH_;
        public static final int WISH_GIFT_NUM_MAP_FIELD_NUMBER = 939;
        private MapField<Integer, Integer> wishGiftNumMap_;
        public static final int END_TIME_FIELD_NUMBER = 10;
        private int endTime_;
        public static final int EXPIRE_COND_LIST_FIELD_NUMBER = 5;
        private Internal.IntList expireCondList_;
        private int expireCondListMemoizedSerializedSize;
        public static final int SAM_LAMP_INFO_FIELD_NUMBER = 2;
        public static final int CRUCIBLE_INFO_FIELD_NUMBER = 15;
        public static final int SALESMAN_INFO_FIELD_NUMBER = 9;
        public static final int TRIAL_AVATAR_INFO_FIELD_NUMBER = 4;
        public static final int DELIVERY_INFO_FIELD_NUMBER = 1141;
        public static final int ASTER_INFO_FIELD_NUMBER = 1977;
        public static final int FLIGHT_INFO_FIELD_NUMBER = 2011;
        public static final int DRAGON_SPINE_INFO_FIELD_NUMBER = 1310;
        public static final int EFFIGY_INFO_FIELD_NUMBER = 1374;
        public static final int TREASURE_MAP_INFO_FIELD_NUMBER = 1925;
        public static final int BLESSING_INFO_FIELD_NUMBER = 1962;
        public static final int SEA_LAMP_INFO_FIELD_NUMBER = 247;
        public static final int EXPEDITION_INFO_FIELD_NUMBER = 1752;
        public static final int ARENA_CHALLENGE_INFO_FIELD_NUMBER = 538;
        public static final int FLEUR_FAIR_INFO_FIELD_NUMBER = 1447;
        public static final int WATER_SPIRIT_INFO_FIELD_NUMBER = 635;
        public static final int CHANNELER_SLAB_INFO_FIELD_NUMBER = 846;
        public static final int MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER = 432;
        public static final int HIDE_AND_SEEK_INFO_FIELD_NUMBER = 839;
        public static final int FIND_HILICHURL_INFO_FIELD_NUMBER = 378;
        public static final int SUMMER_TIME_INFO_FIELD_NUMBER = 1910;
        public static final int BUOYANT_COMBAT_INFO_FIELD_NUMBER = 686;
        public static final int ECHO_SHELL_INFO_FIELD_NUMBER = 1162;
        public static final int BOUNCE_CONJURING_INFO_FIELD_NUMBER = 922;
        public static final int BLITZ_RUSH_INFO_FIELD_NUMBER = 64;
        public static final int CHESS_INFO_FIELD_NUMBER = 1006;
        public static final int SUMO_INFO_FIELD_NUMBER = 505;
        public static final int MOONFIN_TRIAL_INFO_FIELD_NUMBER = 766;
        public static final int LUNA_RITE_INFO_FIELD_NUMBER = 1545;
        public static final int PLANT_FLOWER_INFO_FIELD_NUMBER = 1274;
        public static final int MUSIC_GAME_INFO_FIELD_NUMBER = 1989;
        public static final int ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER = 970;
        public static final int DIG_INFO_FIELD_NUMBER = 1862;
        public static final int HACHI_INFO_FIELD_NUMBER = 511;
        public static final int WINTER_CAMP_INFO_FIELD_NUMBER = 699;
        public static final int POTION_INFO_FIELD_NUMBER = 1567;
        public static final int TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER = 1348;
        public static final int LANTERN_RITE_ACTIVITY_INFO_FIELD_NUMBER = 237;
        public static final int MICHIAE_MATSURI_INFO_FIELD_NUMBER = 1839;
        public static final int BARTENDER_INFO_FIELD_NUMBER = 551;
        public static final int UGC_INFO_FIELD_NUMBER = 1182;
        public static final int CRYSTAL_LINK_INFO_FIELD_NUMBER = 812;
        public static final int IRODORI_INFO_FIELD_NUMBER = 1056;
        public static final int PHOTO_INFO_FIELD_NUMBER = 1822;
        public static final int SPICE_INFO_FIELD_NUMBER = 789;
        public static final int GACHA_INFO_FIELD_NUMBER = 1297;
        public static final int LUMINANCE_STONE_CHALLENGE_INFO_FIELD_NUMBER = 444;
        public static final int ROGUE_DIARY_INFO_FIELD_NUMBER = 560;
        public static final int SUMMER_TIME_V2_INFO_FIELD_NUMBER = 411;
        public static final int ISLAND_PARTY_INFO_FIELD_NUMBER = 740;
        public static final int GEAR_INFO_FIELD_NUMBER = 1482;
        public static final int GRAVEN_INNOCENCE_INFO_FIELD_NUMBER = 1928;
        public static final int INSTABLE_SPRAY_INFO_FIELD_NUMBER = 1145;
        public static final int MUQADAS_POTION_INFO_FIELD_NUMBER = 1662;
        public static final int TREASURE_SEELIE_INFO_FIELD_NUMBER = 1032;
        public static final int ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER = 1265;
        public static final int VINTAGE_INFO_FIELD_NUMBER = 1308;
        public static final int WIND_FIELD_INFO_FIELD_NUMBER = 468;
        public static final int FUNGUS_FIGHTER_INFO_FIELD_NUMBER = 1757;
        public static final int CHAR_AMUSEMENT_INFO_FIELD_NUMBER = 621;
        public static final int EFFIGY_CHALLENGE_INFO_FIELD_NUMBER = 233;
        public static final int COIN_COLLECT_INFO_FIELD_NUMBER = 2002;
        public static final int BRICK_BREAKER_INFO_FIELD_NUMBER = 1522;
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
                    case 36: goto L_0x001c;
                    case 939: goto L_0x0021;
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
            this.meetCondListMemoizedSerializedSize = -1;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.expireCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ActivityInfo() {
            this.detailCase_ = 0;
            this.meetCondListMemoizedSerializedSize = -1;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.expireCondListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.meetCondList_ = emptyIntList();
            this.watcherInfoList_ = Collections.emptyList();
            this.activityPushTipsDataList_ = Collections.emptyList();
            this.takenRewardList_ = emptyIntList();
            this.expireCondList_ = emptyIntList();
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

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:667:0x1811 */
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
                            case 8:
                                this.beginTime_ = input.readUInt32();
                                break;
                            case 18:
                                SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.Builder subBuilder = this.detailCase_ == 2 ? ((SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder.buildPartial();
                                }
                                this.detailCase_ = 2;
                                break;
                            case 24:
                                this.activityType_ = input.readUInt32();
                                break;
                            case 34:
                                TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.Builder subBuilder2 = this.detailCase_ == 4 ? ((TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder2.buildPartial();
                                }
                                this.detailCase_ = 4;
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 64) == 0) {
                                    this.expireCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                this.expireCondList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.expireCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.expireCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.watcherInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.watcherInfoList_.add((ActivityWatcherInfoOuterClass.ActivityWatcherInfo) input.readMessage(ActivityWatcherInfoOuterClass.ActivityWatcherInfo.parser(), extensionRegistry));
                                break;
                            case 56:
                                this.scheduleId_ = input.readUInt32();
                                break;
                            case 64:
                                this.isFinished_ = input.readBool();
                                break;
                            case 74:
                                SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder subBuilder3 = this.detailCase_ == 9 ? ((SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder3.buildPartial();
                                }
                                this.detailCase_ = 9;
                                break;
                            case 80:
                                this.endTime_ = input.readUInt32();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.meetCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.meetCondList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.meetCondList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.meetCondList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 96:
                                this.unk3300MDBDPIBEGGH_ = input.readBool();
                                break;
                            case 104:
                                this.activityId_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300ICNJJKDHPCH_ = input.readBool();
                                break;
                            case 122:
                                CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.Builder subBuilder4 = this.detailCase_ == 15 ? ((CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder4 != null) {
                                    subBuilder4.mergeFrom((CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder4.buildPartial();
                                }
                                this.detailCase_ = 15;
                                break;
                            case PacketOpcodes.ExitTransPointRegionNotify:
                                if ((mutable_bitField0_ & 16) == 0) {
                                    this.activityCoinMap_ = MapField.newMapField(ActivityCoinMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> activityCoinMap__ = (MapEntry) input.readMessage(ActivityCoinMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.activityCoinMap_.getMutableMap().put(activityCoinMap__.getKey(), activityCoinMap__.getValue());
                                break;
                            case 514:
                                BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.Builder subBuilder5 = this.detailCase_ == 64 ? ((BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder5 != null) {
                                    subBuilder5.mergeFrom((BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder5.buildPartial();
                                }
                                this.detailCase_ = 64;
                                break;
                            case 1866:
                                EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.Builder subBuilder6 = this.detailCase_ == 233 ? ((EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.parser(), extensionRegistry);
                                if (subBuilder6 != null) {
                                    subBuilder6.mergeFrom((EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_);
                                    this.detail_ = subBuilder6.buildPartial();
                                }
                                this.detailCase_ = 233;
                                break;
                            case 1898:
                                LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.Builder subBuilder7 = this.detailCase_ == 237 ? ((LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder7 != null) {
                                    subBuilder7.mergeFrom((LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder7.buildPartial();
                                }
                                this.detailCase_ = 237;
                                break;
                            case 1978:
                                SeaLampActivityInfoOuterClass.SeaLampActivityInfo.Builder subBuilder8 = this.detailCase_ == 247 ? ((SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SeaLampActivityInfoOuterClass.SeaLampActivityInfo.parser(), extensionRegistry);
                                if (subBuilder8 != null) {
                                    subBuilder8.mergeFrom((SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_);
                                    this.detail_ = subBuilder8.buildPartial();
                                }
                                this.detailCase_ = 247;
                                break;
                            case 2880:
                                this.unk3300MJNPGEKLOCG_ = input.readBool();
                                break;
                            case 3026:
                                FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.Builder subBuilder9 = this.detailCase_ == 378 ? ((FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.parser(), extensionRegistry);
                                if (subBuilder9 != null) {
                                    subBuilder9.mergeFrom((FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_);
                                    this.detail_ = subBuilder9.buildPartial();
                                }
                                this.detailCase_ = 378;
                                break;
                            case 3290:
                                SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.Builder subBuilder10 = this.detailCase_ == 411 ? ((SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.parser(), extensionRegistry);
                                if (subBuilder10 != null) {
                                    subBuilder10.mergeFrom((SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_);
                                    this.detail_ = subBuilder10.buildPartial();
                                }
                                this.detailCase_ = 411;
                                break;
                            case 3458:
                                MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.Builder subBuilder11 = this.detailCase_ == 432 ? ((MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder11 != null) {
                                    subBuilder11.mergeFrom((MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder11.buildPartial();
                                }
                                this.detailCase_ = MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER;
                                break;
                            case 3554:
                                LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.Builder subBuilder12 = this.detailCase_ == 444 ? ((LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder12 != null) {
                                    subBuilder12.mergeFrom((LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder12.buildPartial();
                                }
                                this.detailCase_ = 444;
                                break;
                            case 3746:
                                WindFieldDetailInfoOuterClass.WindFieldDetailInfo.Builder subBuilder13 = this.detailCase_ == 468 ? ((WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WindFieldDetailInfoOuterClass.WindFieldDetailInfo.parser(), extensionRegistry);
                                if (subBuilder13 != null) {
                                    subBuilder13.mergeFrom((WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_);
                                    this.detail_ = subBuilder13.buildPartial();
                                }
                                this.detailCase_ = WIND_FIELD_INFO_FIELD_NUMBER;
                                break;
                            case PacketOpcodes.SetPlayerSignatureRsp:
                                SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder subBuilder14 = this.detailCase_ == 505 ? ((SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder14 != null) {
                                    subBuilder14.mergeFrom((SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder14.buildPartial();
                                }
                                this.detailCase_ = 505;
                                break;
                            case PacketOpcodes.SetPlayerHeadImageReq:
                                HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.Builder subBuilder15 = this.detailCase_ == 511 ? ((HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder15 != null) {
                                    subBuilder15.mergeFrom((HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder15.buildPartial();
                                }
                                this.detailCase_ = 511;
                                break;
                            case 4306:
                                ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.Builder subBuilder16 = this.detailCase_ == 538 ? ((ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder16 != null) {
                                    subBuilder16.mergeFrom((ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder16.buildPartial();
                                }
                                this.detailCase_ = ARENA_CHALLENGE_INFO_FIELD_NUMBER;
                                break;
                            case 4410:
                                BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.Builder subBuilder17 = this.detailCase_ == 551 ? ((BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder17 != null) {
                                    subBuilder17.mergeFrom((BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder17.buildPartial();
                                }
                                this.detailCase_ = 551;
                                break;
                            case 4482:
                                RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.Builder subBuilder18 = this.detailCase_ == 560 ? ((RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder18 != null) {
                                    subBuilder18.mergeFrom((RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder18.buildPartial();
                                }
                                this.detailCase_ = 560;
                                break;
                            case 4970:
                                CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.Builder subBuilder19 = this.detailCase_ == 621 ? ((CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.parser(), extensionRegistry);
                                if (subBuilder19 != null) {
                                    subBuilder19.mergeFrom((CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_);
                                    this.detail_ = subBuilder19.buildPartial();
                                }
                                this.detailCase_ = 621;
                                break;
                            case 5082:
                                WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.Builder subBuilder20 = this.detailCase_ == 635 ? ((WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder20 != null) {
                                    subBuilder20.mergeFrom((WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder20.buildPartial();
                                }
                                this.detailCase_ = 635;
                                break;
                            case 5490:
                                BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.Builder subBuilder21 = this.detailCase_ == 686 ? ((BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.parser(), extensionRegistry);
                                if (subBuilder21 != null) {
                                    subBuilder21.mergeFrom((BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_);
                                    this.detail_ = subBuilder21.buildPartial();
                                }
                                this.detailCase_ = 686;
                                break;
                            case PacketOpcodes.GalleryCrystalLinkKillMonsterNotify:
                                this.selectedAvatarRewardId_ = input.readUInt32();
                                break;
                            case PacketOpcodes.InstableSprayGalleryInfoNotify:
                                WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.Builder subBuilder22 = this.detailCase_ == 699 ? ((WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder22 != null) {
                                    subBuilder22.mergeFrom((WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder22.buildPartial();
                                }
                                this.detailCase_ = 699;
                                break;
                            case 5922:
                                IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.Builder subBuilder23 = this.detailCase_ == 740 ? ((IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.parser(), extensionRegistry);
                                if (subBuilder23 != null) {
                                    subBuilder23.mergeFrom((IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_);
                                    this.detail_ = subBuilder23.buildPartial();
                                }
                                this.detailCase_ = ISLAND_PARTY_INFO_FIELD_NUMBER;
                                break;
                            case PacketOpcodes.ToTheMoonQueryPathRsp:
                                MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.Builder subBuilder24 = this.detailCase_ == 766 ? ((MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder24 != null) {
                                    subBuilder24.mergeFrom((MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder24.buildPartial();
                                }
                                this.detailCase_ = MOONFIN_TRIAL_INFO_FIELD_NUMBER;
                                break;
                            case 6288:
                                this.firstDayStartTime_ = input.readUInt32();
                                break;
                            case 6314:
                                SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.Builder subBuilder25 = this.detailCase_ == 789 ? ((SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder25 != null) {
                                    subBuilder25.mergeFrom((SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder25.buildPartial();
                                }
                                this.detailCase_ = SPICE_INFO_FIELD_NUMBER;
                                break;
                            case 6498:
                                CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.Builder subBuilder26 = this.detailCase_ == 812 ? ((CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder26 != null) {
                                    subBuilder26.mergeFrom((CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder26.buildPartial();
                                }
                                this.detailCase_ = 812;
                                break;
                            case 6714:
                                HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.Builder subBuilder27 = this.detailCase_ == 839 ? ((HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder27 != null) {
                                    subBuilder27.mergeFrom((HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder27.buildPartial();
                                }
                                this.detailCase_ = 839;
                                break;
                            case 6770:
                                ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.Builder subBuilder28 = this.detailCase_ == 846 ? ((ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder28 != null) {
                                    subBuilder28.mergeFrom((ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder28.buildPartial();
                                }
                                this.detailCase_ = 846;
                                break;
                            case 7378:
                                BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.Builder subBuilder29 = this.detailCase_ == 922 ? ((BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder29 != null) {
                                    subBuilder29.mergeFrom((BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder29.buildPartial();
                                }
                                this.detailCase_ = 922;
                                break;
                            case 7514:
                                if ((mutable_bitField0_ & 32) == 0) {
                                    this.wishGiftNumMap_ = MapField.newMapField(WishGiftNumMapDefaultEntryHolder.defaultEntry);
                                    mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                }
                                MapEntry<Integer, Integer> wishGiftNumMap__ = (MapEntry) input.readMessage(WishGiftNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                this.wishGiftNumMap_.getMutableMap().put(wishGiftNumMap__.getKey(), wishGiftNumMap__.getValue());
                                break;
                            case 7762:
                                RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.Builder subBuilder30 = this.detailCase_ == 970 ? ((RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder30 != null) {
                                    subBuilder30.mergeFrom((RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder30.buildPartial();
                                }
                                this.detailCase_ = ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER;
                                break;
                            case PacketOpcodes.IrodoriMasterGalleryCgEndNotify:
                                ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.Builder subBuilder31 = this.detailCase_ == 1006 ? ((ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder31 != null) {
                                    subBuilder31.mergeFrom((ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder31.buildPartial();
                                }
                                this.detailCase_ = 1006;
                                break;
                            case 8258:
                                TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.Builder subBuilder32 = this.detailCase_ == 1032 ? ((TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder32 != null) {
                                    subBuilder32.mergeFrom((TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder32.buildPartial();
                                }
                                this.detailCase_ = TREASURE_SEELIE_INFO_FIELD_NUMBER;
                                break;
                            case 8450:
                                IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.Builder subBuilder33 = this.detailCase_ == 1056 ? ((IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder33 != null) {
                                    subBuilder33.mergeFrom((IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder33.buildPartial();
                                }
                                this.detailCase_ = 1056;
                                break;
                            case RET_CHANNELLER_SLAB_LOOP_DUNGEON_STAGE_NOT_OPEN_VALUE:
                                DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.Builder subBuilder34 = this.detailCase_ == 1141 ? ((DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder34 != null) {
                                    subBuilder34.mergeFrom((DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder34.buildPartial();
                                }
                                this.detailCase_ = DELIVERY_INFO_FIELD_NUMBER;
                                break;
                            case RET_HIDE_AND_SEEK_PLAY_MAP_NOT_CHOSEN_VALUE:
                                InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.Builder subBuilder35 = this.detailCase_ == 1145 ? ((InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.parser(), extensionRegistry);
                                if (subBuilder35 != null) {
                                    subBuilder35.mergeFrom((InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_);
                                    this.detail_ = subBuilder35.buildPartial();
                                }
                                this.detailCase_ = INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                                break;
                            case 9298:
                                EchoShellDetailInfoOuterClass.EchoShellDetailInfo.Builder subBuilder36 = this.detailCase_ == 1162 ? ((EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EchoShellDetailInfoOuterClass.EchoShellDetailInfo.parser(), extensionRegistry);
                                if (subBuilder36 != null) {
                                    subBuilder36.mergeFrom((EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_);
                                    this.detail_ = subBuilder36.buildPartial();
                                }
                                this.detailCase_ = ECHO_SHELL_INFO_FIELD_NUMBER;
                                break;
                            case 9458:
                                UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.Builder subBuilder37 = this.detailCase_ == 1182 ? ((UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder37 != null) {
                                    subBuilder37.mergeFrom((UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder37.buildPartial();
                                }
                                this.detailCase_ = 1182;
                                break;
                            case RET_IRODORI_POETRY_NOT_GET_ALL_INSPIRATION_VALUE:
                                RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.Builder subBuilder38 = this.detailCase_ == 1265 ? ((RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.parser(), extensionRegistry);
                                if (subBuilder38 != null) {
                                    subBuilder38.mergeFrom((RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_);
                                    this.detail_ = subBuilder38.buildPartial();
                                }
                                this.detailCase_ = ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                                break;
                            case 10144:
                                this.curScore_ = input.readUInt32();
                                break;
                            case 10194:
                                PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder subBuilder39 = this.detailCase_ == 1274 ? ((PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder39 != null) {
                                    subBuilder39.mergeFrom((PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder39.buildPartial();
                                }
                                this.detailCase_ = PLANT_FLOWER_INFO_FIELD_NUMBER;
                                break;
                            case 10378:
                                GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder subBuilder40 = this.detailCase_ == 1297 ? ((GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder40 != null) {
                                    subBuilder40.mergeFrom((GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder40.buildPartial();
                                }
                                this.detailCase_ = GACHA_INFO_FIELD_NUMBER;
                                break;
                            case 10466:
                                VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder subBuilder41 = this.detailCase_ == 1308 ? ((VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder41 != null) {
                                    subBuilder41.mergeFrom((VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder41.buildPartial();
                                }
                                this.detailCase_ = 1308;
                                break;
                            case 10482:
                                DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.Builder subBuilder42 = this.detailCase_ == 1310 ? ((DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder42 != null) {
                                    subBuilder42.mergeFrom((DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder42.buildPartial();
                                }
                                this.detailCase_ = 1310;
                                break;
                            case 10786:
                                TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.Builder subBuilder43 = this.detailCase_ == 1348 ? ((TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder43 != null) {
                                    subBuilder43.mergeFrom((TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder43.buildPartial();
                                }
                                this.detailCase_ = TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                                break;
                            case 10994:
                                EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.Builder subBuilder44 = this.detailCase_ == 1374 ? ((EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder44 != null) {
                                    subBuilder44.mergeFrom((EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder44.buildPartial();
                                }
                                this.detailCase_ = EFFIGY_INFO_FIELD_NUMBER;
                                break;
                            case 11000:
                                this.unk3300CBCEHLJJOGI_ = input.readBool();
                                break;
                            case 11578:
                                FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder subBuilder45 = this.detailCase_ == 1447 ? ((FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder45 != null) {
                                    subBuilder45.mergeFrom((FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder45.buildPartial();
                                }
                                this.detailCase_ = 1447;
                                break;
                            case 11858:
                                GearActivityDetailInfoOuterClass.GearActivityDetailInfo.Builder subBuilder46 = this.detailCase_ == 1482 ? ((GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GearActivityDetailInfoOuterClass.GearActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder46 != null) {
                                    subBuilder46.mergeFrom((GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder46.buildPartial();
                                }
                                this.detailCase_ = GEAR_INFO_FIELD_NUMBER;
                                break;
                            case 11888:
                                this.unk3300ABJKLALKLDG_ = input.readBool();
                                break;
                            case 12178:
                                BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder subBuilder47 = this.detailCase_ == 1522 ? ((BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.parser(), extensionRegistry);
                                if (subBuilder47 != null) {
                                    subBuilder47.mergeFrom((BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_);
                                    this.detail_ = subBuilder47.buildPartial();
                                }
                                this.detailCase_ = 1522;
                                break;
                            case 12362:
                                LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.Builder subBuilder48 = this.detailCase_ == 1545 ? ((LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.parser(), extensionRegistry);
                                if (subBuilder48 != null) {
                                    subBuilder48.mergeFrom((LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_);
                                    this.detail_ = subBuilder48.buildPartial();
                                }
                                this.detailCase_ = 1545;
                                break;
                            case 12538:
                                PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.Builder subBuilder49 = this.detailCase_ == 1567 ? ((PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder49 != null) {
                                    subBuilder49.mergeFrom((PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder49.buildPartial();
                                }
                                this.detailCase_ = POTION_INFO_FIELD_NUMBER;
                                break;
                            case 13160:
                                this.unk3300NEPKLLBJFKK_ = input.readBool();
                                break;
                            case 13298:
                                MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.Builder subBuilder50 = this.detailCase_ == 1662 ? ((MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder50 != null) {
                                    subBuilder50.mergeFrom((MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder50.buildPartial();
                                }
                                this.detailCase_ = MUQADAS_POTION_INFO_FIELD_NUMBER;
                                break;
                            case 14018:
                                ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.Builder subBuilder51 = this.detailCase_ == 1752 ? ((ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder51 != null) {
                                    subBuilder51.mergeFrom((ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder51.buildPartial();
                                }
                                this.detailCase_ = EXPEDITION_INFO_FIELD_NUMBER;
                                break;
                            case 14058:
                                FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.Builder subBuilder52 = this.detailCase_ == 1757 ? ((FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.parser(), extensionRegistry);
                                if (subBuilder52 != null) {
                                    subBuilder52.mergeFrom((FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_);
                                    this.detail_ = subBuilder52.buildPartial();
                                }
                                this.detailCase_ = 1757;
                                break;
                            case 14578:
                                PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.Builder subBuilder53 = this.detailCase_ == 1822 ? ((PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder53 != null) {
                                    subBuilder53.mergeFrom((PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder53.buildPartial();
                                }
                                this.detailCase_ = 1822;
                                break;
                            case 14714:
                                MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.Builder subBuilder54 = this.detailCase_ == 1839 ? ((MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder54 != null) {
                                    subBuilder54.mergeFrom((MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder54.buildPartial();
                                }
                                this.detailCase_ = 1839;
                                break;
                            case 14898:
                                DigActivityDetailInfoOuterClass.DigActivityDetailInfo.Builder subBuilder55 = this.detailCase_ == 1862 ? ((DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(DigActivityDetailInfoOuterClass.DigActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder55 != null) {
                                    subBuilder55.mergeFrom((DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder55.buildPartial();
                                }
                                this.detailCase_ = DIG_INFO_FIELD_NUMBER;
                                break;
                            case 14938:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.activityPushTipsDataList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.activityPushTipsDataList_.add((ActivityPushTipsDataOuterClass.ActivityPushTipsData) input.readMessage(ActivityPushTipsDataOuterClass.ActivityPushTipsData.parser(), extensionRegistry));
                                break;
                            case 14960:
                                this.scoreLimit_ = input.readUInt32();
                                break;
                            case 15112:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.takenRewardList_.addInt(input.readUInt32());
                                break;
                            case 15114:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 15282:
                                SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder subBuilder56 = this.detailCase_ == 1910 ? ((SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.parser(), extensionRegistry);
                                if (subBuilder56 != null) {
                                    subBuilder56.mergeFrom((SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_);
                                    this.detail_ = subBuilder56.buildPartial();
                                }
                                this.detailCase_ = 1910;
                                break;
                            case 15402:
                                TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.Builder subBuilder57 = this.detailCase_ == 1925 ? ((TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder57 != null) {
                                    subBuilder57.mergeFrom((TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder57.buildPartial();
                                }
                                this.detailCase_ = TREASURE_MAP_INFO_FIELD_NUMBER;
                                break;
                            case 15426:
                                GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.Builder subBuilder58 = this.detailCase_ == 1928 ? ((GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.parser(), extensionRegistry);
                                if (subBuilder58 != null) {
                                    subBuilder58.mergeFrom((GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_);
                                    this.detail_ = subBuilder58.buildPartial();
                                }
                                this.detailCase_ = GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                                break;
                            case 15698:
                                BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder subBuilder59 = this.detailCase_ == 1962 ? ((BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder59 != null) {
                                    subBuilder59.mergeFrom((BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder59.buildPartial();
                                }
                                this.detailCase_ = 1962;
                                break;
                            case 15818:
                                AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.Builder subBuilder60 = this.detailCase_ == 1977 ? ((AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder60 != null) {
                                    subBuilder60.mergeFrom((AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder60.buildPartial();
                                }
                                this.detailCase_ = 1977;
                                break;
                            case 15914:
                                MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder subBuilder61 = this.detailCase_ == 1989 ? ((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder61 != null) {
                                    subBuilder61.mergeFrom((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder61.buildPartial();
                                }
                                this.detailCase_ = 1989;
                                break;
                            case 16018:
                                CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.Builder subBuilder62 = this.detailCase_ == 2002 ? ((CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.parser(), extensionRegistry);
                                if (subBuilder62 != null) {
                                    subBuilder62.mergeFrom((CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_);
                                    this.detail_ = subBuilder62.buildPartial();
                                }
                                this.detailCase_ = 2002;
                                break;
                            case 16090:
                                FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.Builder subBuilder63 = this.detailCase_ == 2011 ? ((FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_).toBuilder() : null;
                                this.detail_ = input.readMessage(FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.parser(), extensionRegistry);
                                if (subBuilder63 != null) {
                                    subBuilder63.mergeFrom((FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_);
                                    this.detail_ = subBuilder63.buildPartial();
                                }
                                this.detailCase_ = 2011;
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
                if ((mutable_bitField0_ & 64) != 0) {
                    this.expireCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.watcherInfoList_ = Collections.unmodifiableList(this.watcherInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.meetCondList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.activityPushTipsDataList_ = Collections.unmodifiableList(this.activityPushTipsDataList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.takenRewardList_.makeImmutable();
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
            SAM_LAMP_INFO(2),
            CRUCIBLE_INFO(15),
            SALESMAN_INFO(9),
            TRIAL_AVATAR_INFO(4),
            DELIVERY_INFO(ActivityInfo.DELIVERY_INFO_FIELD_NUMBER),
            ASTER_INFO(1977),
            FLIGHT_INFO(2011),
            DRAGON_SPINE_INFO(1310),
            EFFIGY_INFO(ActivityInfo.EFFIGY_INFO_FIELD_NUMBER),
            TREASURE_MAP_INFO(ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER),
            BLESSING_INFO(1962),
            SEA_LAMP_INFO(247),
            EXPEDITION_INFO(ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER),
            ARENA_CHALLENGE_INFO(ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER),
            FLEUR_FAIR_INFO(1447),
            WATER_SPIRIT_INFO(635),
            CHANNELER_SLAB_INFO(846),
            MIST_TRIAL_ACTIVITY_INFO(ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER),
            HIDE_AND_SEEK_INFO(839),
            FIND_HILICHURL_INFO(378),
            SUMMER_TIME_INFO(1910),
            BUOYANT_COMBAT_INFO(686),
            ECHO_SHELL_INFO(ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER),
            BOUNCE_CONJURING_INFO(922),
            BLITZ_RUSH_INFO(64),
            CHESS_INFO(1006),
            SUMO_INFO(505),
            MOONFIN_TRIAL_INFO(ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER),
            LUNA_RITE_INFO(1545),
            PLANT_FLOWER_INFO(ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER),
            MUSIC_GAME_INFO(1989),
            ROGUELIKE_DUNGEON_INFO(ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER),
            DIG_INFO(ActivityInfo.DIG_INFO_FIELD_NUMBER),
            HACHI_INFO(511),
            WINTER_CAMP_INFO(699),
            POTION_INFO(ActivityInfo.POTION_INFO_FIELD_NUMBER),
            TANUKI_TRAVEL_ACTIVITY_INFO(ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER),
            LANTERN_RITE_ACTIVITY_INFO(237),
            MICHIAE_MATSURI_INFO(1839),
            BARTENDER_INFO(551),
            UGC_INFO(1182),
            CRYSTAL_LINK_INFO(812),
            IRODORI_INFO(1056),
            PHOTO_INFO(1822),
            SPICE_INFO(ActivityInfo.SPICE_INFO_FIELD_NUMBER),
            GACHA_INFO(ActivityInfo.GACHA_INFO_FIELD_NUMBER),
            LUMINANCE_STONE_CHALLENGE_INFO(444),
            ROGUE_DIARY_INFO(560),
            SUMMER_TIME_V2_INFO(411),
            ISLAND_PARTY_INFO(ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER),
            GEAR_INFO(ActivityInfo.GEAR_INFO_FIELD_NUMBER),
            GRAVEN_INNOCENCE_INFO(ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER),
            INSTABLE_SPRAY_INFO(ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER),
            MUQADAS_POTION_INFO(ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER),
            TREASURE_SEELIE_INFO(ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER),
            ROCK_BOARD_EXPLORE_INFO(ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER),
            VINTAGE_INFO(1308),
            WIND_FIELD_INFO(ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER),
            FUNGUS_FIGHTER_INFO(1757),
            CHAR_AMUSEMENT_INFO(621),
            EFFIGY_CHALLENGE_INFO(233),
            COIN_COLLECT_INFO(2002),
            BRICK_BREAKER_INFO(1522),
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
                    case 2:
                        return SAM_LAMP_INFO;
                    case 4:
                        return TRIAL_AVATAR_INFO;
                    case 9:
                        return SALESMAN_INFO;
                    case 15:
                        return CRUCIBLE_INFO;
                    case 64:
                        return BLITZ_RUSH_INFO;
                    case 233:
                        return EFFIGY_CHALLENGE_INFO;
                    case 237:
                        return LANTERN_RITE_ACTIVITY_INFO;
                    case 247:
                        return SEA_LAMP_INFO;
                    case 378:
                        return FIND_HILICHURL_INFO;
                    case 411:
                        return SUMMER_TIME_V2_INFO;
                    case ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER /* 432 */:
                        return MIST_TRIAL_ACTIVITY_INFO;
                    case 444:
                        return LUMINANCE_STONE_CHALLENGE_INFO;
                    case ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER /* 468 */:
                        return WIND_FIELD_INFO;
                    case 505:
                        return SUMO_INFO;
                    case 511:
                        return HACHI_INFO;
                    case ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER /* 538 */:
                        return ARENA_CHALLENGE_INFO;
                    case 551:
                        return BARTENDER_INFO;
                    case 560:
                        return ROGUE_DIARY_INFO;
                    case 621:
                        return CHAR_AMUSEMENT_INFO;
                    case 635:
                        return WATER_SPIRIT_INFO;
                    case 686:
                        return BUOYANT_COMBAT_INFO;
                    case 699:
                        return WINTER_CAMP_INFO;
                    case ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER /* 740 */:
                        return ISLAND_PARTY_INFO;
                    case ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER /* 766 */:
                        return MOONFIN_TRIAL_INFO;
                    case ActivityInfo.SPICE_INFO_FIELD_NUMBER /* 789 */:
                        return SPICE_INFO;
                    case 812:
                        return CRYSTAL_LINK_INFO;
                    case 839:
                        return HIDE_AND_SEEK_INFO;
                    case 846:
                        return CHANNELER_SLAB_INFO;
                    case 922:
                        return BOUNCE_CONJURING_INFO;
                    case ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER /* 970 */:
                        return ROGUELIKE_DUNGEON_INFO;
                    case 1006:
                        return CHESS_INFO;
                    case ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1032 */:
                        return TREASURE_SEELIE_INFO;
                    case 1056:
                        return IRODORI_INFO;
                    case ActivityInfo.DELIVERY_INFO_FIELD_NUMBER /* 1141 */:
                        return DELIVERY_INFO;
                    case ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 1145 */:
                        return INSTABLE_SPRAY_INFO;
                    case ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER /* 1162 */:
                        return ECHO_SHELL_INFO;
                    case 1182:
                        return UGC_INFO;
                    case ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1265 */:
                        return ROCK_BOARD_EXPLORE_INFO;
                    case ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER /* 1274 */:
                        return PLANT_FLOWER_INFO;
                    case ActivityInfo.GACHA_INFO_FIELD_NUMBER /* 1297 */:
                        return GACHA_INFO;
                    case 1308:
                        return VINTAGE_INFO;
                    case 1310:
                        return DRAGON_SPINE_INFO;
                    case ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1348 */:
                        return TANUKI_TRAVEL_ACTIVITY_INFO;
                    case ActivityInfo.EFFIGY_INFO_FIELD_NUMBER /* 1374 */:
                        return EFFIGY_INFO;
                    case 1447:
                        return FLEUR_FAIR_INFO;
                    case ActivityInfo.GEAR_INFO_FIELD_NUMBER /* 1482 */:
                        return GEAR_INFO;
                    case 1522:
                        return BRICK_BREAKER_INFO;
                    case 1545:
                        return LUNA_RITE_INFO;
                    case ActivityInfo.POTION_INFO_FIELD_NUMBER /* 1567 */:
                        return POTION_INFO;
                    case ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER /* 1662 */:
                        return MUQADAS_POTION_INFO;
                    case ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER /* 1752 */:
                        return EXPEDITION_INFO;
                    case 1757:
                        return FUNGUS_FIGHTER_INFO;
                    case 1822:
                        return PHOTO_INFO;
                    case 1839:
                        return MICHIAE_MATSURI_INFO;
                    case ActivityInfo.DIG_INFO_FIELD_NUMBER /* 1862 */:
                        return DIG_INFO;
                    case 1910:
                        return SUMMER_TIME_INFO;
                    case ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER /* 1925 */:
                        return TREASURE_MAP_INFO;
                    case ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1928 */:
                        return GRAVEN_INNOCENCE_INFO;
                    case 1962:
                        return BLESSING_INFO;
                    case 1977:
                        return ASTER_INFO;
                    case 1989:
                        return MUSIC_GAME_INFO;
                    case 2002:
                        return COIN_COLLECT_INFO;
                    case 2011:
                        return FLIGHT_INFO;
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

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300MJNPGEKLOCG() {
            return this.unk3300MJNPGEKLOCG_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getCurScore() {
            return this.curScore_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getScheduleId() {
            return this.scheduleId_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getScoreLimit() {
            return this.scoreLimit_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300ICNJJKDHPCH() {
            return this.unk3300ICNJJKDHPCH_;
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
        public boolean getUnk3300NEPKLLBJFKK() {
            return this.unk3300NEPKLLBJFKK_;
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
        public int getActivityId() {
            return this.activityId_;
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
        public int getSelectedAvatarRewardId() {
            return this.selectedAvatarRewardId_;
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
        public int getFirstDayStartTime() {
            return this.firstDayStartTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300ABJKLALKLDG() {
            return this.unk3300ABJKLALKLDG_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getActivityType() {
            return this.activityType_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300CBCEHLJJOGI() {
            return this.unk3300CBCEHLJJOGI_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public int getBeginTime() {
            return this.beginTime_;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean getUnk3300MDBDPIBEGGH() {
            return this.unk3300MDBDPIBEGGH_;
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
        public int getEndTime() {
            return this.endTime_;
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
        public boolean hasSamLampInfo() {
            return this.detailCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo getSamLampInfo() {
            if (this.detailCase_ == 2) {
                return (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_;
            }
            return SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfoOrBuilder getSamLampInfoOrBuilder() {
            if (this.detailCase_ == 2) {
                return (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_;
            }
            return SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCrucibleInfo() {
            return this.detailCase_ == 15;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo getCrucibleInfo() {
            if (this.detailCase_ == 15) {
                return (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_;
            }
            return CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder getCrucibleInfoOrBuilder() {
            if (this.detailCase_ == 15) {
                return (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_;
            }
            return CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSalesmanInfo() {
            return this.detailCase_ == 9;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo getSalesmanInfo() {
            if (this.detailCase_ == 9) {
                return (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_;
            }
            return SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder getSalesmanInfoOrBuilder() {
            if (this.detailCase_ == 9) {
                return (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_;
            }
            return SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTrialAvatarInfo() {
            return this.detailCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo getTrialAvatarInfo() {
            if (this.detailCase_ == 4) {
                return (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_;
            }
            return TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder getTrialAvatarInfoOrBuilder() {
            if (this.detailCase_ == 4) {
                return (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_;
            }
            return TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDeliveryInfo() {
            return this.detailCase_ == 1141;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo getDeliveryInfo() {
            if (this.detailCase_ == 1141) {
                return (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_;
            }
            return DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder getDeliveryInfoOrBuilder() {
            if (this.detailCase_ == 1141) {
                return (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_;
            }
            return DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasAsterInfo() {
            return this.detailCase_ == 1977;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo getAsterInfo() {
            if (this.detailCase_ == 1977) {
                return (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_;
            }
            return AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder getAsterInfoOrBuilder() {
            if (this.detailCase_ == 1977) {
                return (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_;
            }
            return AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFlightInfo() {
            return this.detailCase_ == 2011;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo getFlightInfo() {
            if (this.detailCase_ == 2011) {
                return (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_;
            }
            return FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder getFlightInfoOrBuilder() {
            if (this.detailCase_ == 2011) {
                return (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_;
            }
            return FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDragonSpineInfo() {
            return this.detailCase_ == 1310;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo getDragonSpineInfo() {
            if (this.detailCase_ == 1310) {
                return (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_;
            }
            return DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder getDragonSpineInfoOrBuilder() {
            if (this.detailCase_ == 1310) {
                return (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_;
            }
            return DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEffigyInfo() {
            return this.detailCase_ == 1374;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo getEffigyInfo() {
            if (this.detailCase_ == 1374) {
                return (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_;
            }
            return EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfoOrBuilder getEffigyInfoOrBuilder() {
            if (this.detailCase_ == 1374) {
                return (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_;
            }
            return EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTreasureMapInfo() {
            return this.detailCase_ == 1925;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo getTreasureMapInfo() {
            if (this.detailCase_ == 1925) {
                return (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_;
            }
            return TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder getTreasureMapInfoOrBuilder() {
            if (this.detailCase_ == 1925) {
                return (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_;
            }
            return TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBlessingInfo() {
            return this.detailCase_ == 1962;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo getBlessingInfo() {
            if (this.detailCase_ == 1962) {
                return (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_;
            }
            return BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder getBlessingInfoOrBuilder() {
            if (this.detailCase_ == 1962) {
                return (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_;
            }
            return BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSeaLampInfo() {
            return this.detailCase_ == 247;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampActivityInfoOuterClass.SeaLampActivityInfo getSeaLampInfo() {
            if (this.detailCase_ == 247) {
                return (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_;
            }
            return SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder getSeaLampInfoOrBuilder() {
            if (this.detailCase_ == 247) {
                return (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_;
            }
            return SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasExpeditionInfo() {
            return this.detailCase_ == 1752;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo getExpeditionInfo() {
            if (this.detailCase_ == 1752) {
                return (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_;
            }
            return ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder getExpeditionInfoOrBuilder() {
            if (this.detailCase_ == 1752) {
                return (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_;
            }
            return ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasArenaChallengeInfo() {
            return this.detailCase_ == 538;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo getArenaChallengeInfo() {
            if (this.detailCase_ == 538) {
                return (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_;
            }
            return ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfoOrBuilder getArenaChallengeInfoOrBuilder() {
            if (this.detailCase_ == 538) {
                return (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_;
            }
            return ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFleurFairInfo() {
            return this.detailCase_ == 1447;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo getFleurFairInfo() {
            if (this.detailCase_ == 1447) {
                return (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_;
            }
            return FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder getFleurFairInfoOrBuilder() {
            if (this.detailCase_ == 1447) {
                return (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_;
            }
            return FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWaterSpiritInfo() {
            return this.detailCase_ == 635;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo getWaterSpiritInfo() {
            if (this.detailCase_ == 635) {
                return (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_;
            }
            return WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfoOrBuilder getWaterSpiritInfoOrBuilder() {
            if (this.detailCase_ == 635) {
                return (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_;
            }
            return WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasChannelerSlabInfo() {
            return this.detailCase_ == 846;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo getChannelerSlabInfo() {
            if (this.detailCase_ == 846) {
                return (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_;
            }
            return ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfoOrBuilder getChannelerSlabInfoOrBuilder() {
            if (this.detailCase_ == 846) {
                return (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_;
            }
            return ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMistTrialActivityInfo() {
            return this.detailCase_ == 432;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo getMistTrialActivityInfo() {
            if (this.detailCase_ == 432) {
                return (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_;
            }
            return MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder getMistTrialActivityInfoOrBuilder() {
            if (this.detailCase_ == 432) {
                return (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_;
            }
            return MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasHideAndSeekInfo() {
            return this.detailCase_ == 839;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo getHideAndSeekInfo() {
            if (this.detailCase_ == 839) {
                return (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_;
            }
            return HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder getHideAndSeekInfoOrBuilder() {
            if (this.detailCase_ == 839) {
                return (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_;
            }
            return HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFindHilichurlInfo() {
            return this.detailCase_ == 378;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo getFindHilichurlInfo() {
            if (this.detailCase_ == 378) {
                return (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_;
            }
            return FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder getFindHilichurlInfoOrBuilder() {
            if (this.detailCase_ == 378) {
                return (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_;
            }
            return FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSummerTimeInfo() {
            return this.detailCase_ == 1910;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo getSummerTimeInfo() {
            if (this.detailCase_ == 1910) {
                return (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_;
            }
            return SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder getSummerTimeInfoOrBuilder() {
            if (this.detailCase_ == 1910) {
                return (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_;
            }
            return SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBuoyantCombatInfo() {
            return this.detailCase_ == 686;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo getBuoyantCombatInfo() {
            if (this.detailCase_ == 686) {
                return (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_;
            }
            return BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder getBuoyantCombatInfoOrBuilder() {
            if (this.detailCase_ == 686) {
                return (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_;
            }
            return BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEchoShellInfo() {
            return this.detailCase_ == 1162;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EchoShellDetailInfoOuterClass.EchoShellDetailInfo getEchoShellInfo() {
            if (this.detailCase_ == 1162) {
                return (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_;
            }
            return EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder getEchoShellInfoOrBuilder() {
            if (this.detailCase_ == 1162) {
                return (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_;
            }
            return EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBounceConjuringInfo() {
            return this.detailCase_ == 922;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo getBounceConjuringInfo() {
            if (this.detailCase_ == 922) {
                return (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_;
            }
            return BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder getBounceConjuringInfoOrBuilder() {
            if (this.detailCase_ == 922) {
                return (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_;
            }
            return BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBlitzRushInfo() {
            return this.detailCase_ == 64;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo getBlitzRushInfo() {
            if (this.detailCase_ == 64) {
                return (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_;
            }
            return BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder getBlitzRushInfoOrBuilder() {
            if (this.detailCase_ == 64) {
                return (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_;
            }
            return BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasChessInfo() {
            return this.detailCase_ == 1006;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo getChessInfo() {
            if (this.detailCase_ == 1006) {
                return (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_;
            }
            return ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder getChessInfoOrBuilder() {
            if (this.detailCase_ == 1006) {
                return (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_;
            }
            return ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSumoInfo() {
            return this.detailCase_ == 505;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo getSumoInfo() {
            if (this.detailCase_ == 505) {
                return (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_;
            }
            return SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder getSumoInfoOrBuilder() {
            if (this.detailCase_ == 505) {
                return (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_;
            }
            return SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMoonfinTrialInfo() {
            return this.detailCase_ == 766;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo getMoonfinTrialInfo() {
            if (this.detailCase_ == 766) {
                return (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_;
            }
            return MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfoOrBuilder getMoonfinTrialInfoOrBuilder() {
            if (this.detailCase_ == 766) {
                return (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_;
            }
            return MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLunaRiteInfo() {
            return this.detailCase_ == 1545;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo getLunaRiteInfo() {
            if (this.detailCase_ == 1545) {
                return (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_;
            }
            return LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder getLunaRiteInfoOrBuilder() {
            if (this.detailCase_ == 1545) {
                return (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_;
            }
            return LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPlantFlowerInfo() {
            return this.detailCase_ == 1274;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo getPlantFlowerInfo() {
            if (this.detailCase_ == 1274) {
                return (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_;
            }
            return PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder getPlantFlowerInfoOrBuilder() {
            if (this.detailCase_ == 1274) {
                return (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_;
            }
            return PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMusicGameInfo() {
            return this.detailCase_ == 1989;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo() {
            if (this.detailCase_ == 1989) {
                return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
            }
            return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder getMusicGameInfoOrBuilder() {
            if (this.detailCase_ == 1989) {
                return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
            }
            return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRoguelikeDungeonInfo() {
            return this.detailCase_ == 970;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo getRoguelikeDungeonInfo() {
            if (this.detailCase_ == 970) {
                return (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_;
            }
            return RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder getRoguelikeDungeonInfoOrBuilder() {
            if (this.detailCase_ == 970) {
                return (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_;
            }
            return RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasDigInfo() {
            return this.detailCase_ == 1862;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DigActivityDetailInfoOuterClass.DigActivityDetailInfo getDigInfo() {
            if (this.detailCase_ == 1862) {
                return (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_;
            }
            return DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder getDigInfoOrBuilder() {
            if (this.detailCase_ == 1862) {
                return (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_;
            }
            return DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasHachiInfo() {
            return this.detailCase_ == 511;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo getHachiInfo() {
            if (this.detailCase_ == 511) {
                return (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_;
            }
            return HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public HachiActivityDetailInfoOuterClass.HachiActivityDetailInfoOrBuilder getHachiInfoOrBuilder() {
            if (this.detailCase_ == 511) {
                return (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_;
            }
            return HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWinterCampInfo() {
            return this.detailCase_ == 699;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo getWinterCampInfo() {
            if (this.detailCase_ == 699) {
                return (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_;
            }
            return WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder getWinterCampInfoOrBuilder() {
            if (this.detailCase_ == 699) {
                return (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_;
            }
            return WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPotionInfo() {
            return this.detailCase_ == 1567;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo getPotionInfo() {
            if (this.detailCase_ == 1567) {
                return (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_;
            }
            return PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PotionActivityDetailInfoOuterClass.PotionActivityDetailInfoOrBuilder getPotionInfoOrBuilder() {
            if (this.detailCase_ == 1567) {
                return (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_;
            }
            return PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTanukiTravelActivityInfo() {
            return this.detailCase_ == 1348;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo getTanukiTravelActivityInfo() {
            if (this.detailCase_ == 1348) {
                return (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_;
            }
            return TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder getTanukiTravelActivityInfoOrBuilder() {
            if (this.detailCase_ == 1348) {
                return (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_;
            }
            return TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLanternRiteActivityInfo() {
            return this.detailCase_ == 237;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo getLanternRiteActivityInfo() {
            if (this.detailCase_ == 237) {
                return (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_;
            }
            return LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder getLanternRiteActivityInfoOrBuilder() {
            if (this.detailCase_ == 237) {
                return (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_;
            }
            return LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMichiaeMatsuriInfo() {
            return this.detailCase_ == 1839;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo getMichiaeMatsuriInfo() {
            if (this.detailCase_ == 1839) {
                return (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_;
            }
            return MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder getMichiaeMatsuriInfoOrBuilder() {
            if (this.detailCase_ == 1839) {
                return (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_;
            }
            return MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBartenderInfo() {
            return this.detailCase_ == 551;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo getBartenderInfo() {
            if (this.detailCase_ == 551) {
                return (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_;
            }
            return BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder getBartenderInfoOrBuilder() {
            if (this.detailCase_ == 551) {
                return (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_;
            }
            return BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasUgcInfo() {
            return this.detailCase_ == 1182;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo getUgcInfo() {
            if (this.detailCase_ == 1182) {
                return (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_;
            }
            return UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder getUgcInfoOrBuilder() {
            if (this.detailCase_ == 1182) {
                return (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_;
            }
            return UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCrystalLinkInfo() {
            return this.detailCase_ == 812;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo getCrystalLinkInfo() {
            if (this.detailCase_ == 812) {
                return (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_;
            }
            return CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfoOrBuilder getCrystalLinkInfoOrBuilder() {
            if (this.detailCase_ == 812) {
                return (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_;
            }
            return CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasIrodoriInfo() {
            return this.detailCase_ == 1056;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo getIrodoriInfo() {
            if (this.detailCase_ == 1056) {
                return (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_;
            }
            return IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder getIrodoriInfoOrBuilder() {
            if (this.detailCase_ == 1056) {
                return (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_;
            }
            return IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasPhotoInfo() {
            return this.detailCase_ == 1822;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo getPhotoInfo() {
            if (this.detailCase_ == 1822) {
                return (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_;
            }
            return PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder getPhotoInfoOrBuilder() {
            if (this.detailCase_ == 1822) {
                return (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_;
            }
            return PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSpiceInfo() {
            return this.detailCase_ == 789;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo getSpiceInfo() {
            if (this.detailCase_ == 789) {
                return (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_;
            }
            return SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfoOrBuilder getSpiceInfoOrBuilder() {
            if (this.detailCase_ == 789) {
                return (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_;
            }
            return SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGachaInfo() {
            return this.detailCase_ == 1297;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo getGachaInfo() {
            if (this.detailCase_ == 1297) {
                return (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_;
            }
            return GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder getGachaInfoOrBuilder() {
            if (this.detailCase_ == 1297) {
                return (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_;
            }
            return GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasLuminanceStoneChallengeInfo() {
            return this.detailCase_ == 444;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo getLuminanceStoneChallengeInfo() {
            if (this.detailCase_ == 444) {
                return (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_;
            }
            return LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder() {
            if (this.detailCase_ == 444) {
                return (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_;
            }
            return LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRogueDiaryInfo() {
            return this.detailCase_ == 560;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo getRogueDiaryInfo() {
            if (this.detailCase_ == 560) {
                return (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_;
            }
            return RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder getRogueDiaryInfoOrBuilder() {
            if (this.detailCase_ == 560) {
                return (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_;
            }
            return RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasSummerTimeV2Info() {
            return this.detailCase_ == 411;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo getSummerTimeV2Info() {
            if (this.detailCase_ == 411) {
                return (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_;
            }
            return SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder getSummerTimeV2InfoOrBuilder() {
            if (this.detailCase_ == 411) {
                return (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_;
            }
            return SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasIslandPartyInfo() {
            return this.detailCase_ == 740;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo getIslandPartyInfo() {
            if (this.detailCase_ == 740) {
                return (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_;
            }
            return IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public IslandPartyDetailInfoOuterClass.IslandPartyDetailInfoOrBuilder getIslandPartyInfoOrBuilder() {
            if (this.detailCase_ == 740) {
                return (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_;
            }
            return IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGearInfo() {
            return this.detailCase_ == 1482;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GearActivityDetailInfoOuterClass.GearActivityDetailInfo getGearInfo() {
            if (this.detailCase_ == 1482) {
                return (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_;
            }
            return GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GearActivityDetailInfoOuterClass.GearActivityDetailInfoOrBuilder getGearInfoOrBuilder() {
            if (this.detailCase_ == 1482) {
                return (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_;
            }
            return GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasGravenInnocenceInfo() {
            return this.detailCase_ == 1928;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo getGravenInnocenceInfo() {
            if (this.detailCase_ == 1928) {
                return (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_;
            }
            return GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder getGravenInnocenceInfoOrBuilder() {
            if (this.detailCase_ == 1928) {
                return (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_;
            }
            return GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasInstableSprayInfo() {
            return this.detailCase_ == 1145;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo getInstableSprayInfo() {
            if (this.detailCase_ == 1145) {
                return (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_;
            }
            return InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public InstableSprayDetailInfoOuterClass.InstableSprayDetailInfoOrBuilder getInstableSprayInfoOrBuilder() {
            if (this.detailCase_ == 1145) {
                return (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_;
            }
            return InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasMuqadasPotionInfo() {
            return this.detailCase_ == 1662;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo getMuqadasPotionInfo() {
            if (this.detailCase_ == 1662) {
                return (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_;
            }
            return MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder getMuqadasPotionInfoOrBuilder() {
            if (this.detailCase_ == 1662) {
                return (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_;
            }
            return MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasTreasureSeelieInfo() {
            return this.detailCase_ == 1032;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo getTreasureSeelieInfo() {
            if (this.detailCase_ == 1032) {
                return (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_;
            }
            return TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder getTreasureSeelieInfoOrBuilder() {
            if (this.detailCase_ == 1032) {
                return (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_;
            }
            return TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasRockBoardExploreInfo() {
            return this.detailCase_ == 1265;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo getRockBoardExploreInfo() {
            if (this.detailCase_ == 1265) {
                return (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_;
            }
            return RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfoOrBuilder getRockBoardExploreInfoOrBuilder() {
            if (this.detailCase_ == 1265) {
                return (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_;
            }
            return RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasVintageInfo() {
            return this.detailCase_ == 1308;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo getVintageInfo() {
            if (this.detailCase_ == 1308) {
                return (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_;
            }
            return VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder getVintageInfoOrBuilder() {
            if (this.detailCase_ == 1308) {
                return (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_;
            }
            return VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasWindFieldInfo() {
            return this.detailCase_ == 468;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WindFieldDetailInfoOuterClass.WindFieldDetailInfo getWindFieldInfo() {
            if (this.detailCase_ == 468) {
                return (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_;
            }
            return WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public WindFieldDetailInfoOuterClass.WindFieldDetailInfoOrBuilder getWindFieldInfoOrBuilder() {
            if (this.detailCase_ == 468) {
                return (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_;
            }
            return WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasFungusFighterInfo() {
            return this.detailCase_ == 1757;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo getFungusFighterInfo() {
            if (this.detailCase_ == 1757) {
                return (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_;
            }
            return FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder getFungusFighterInfoOrBuilder() {
            if (this.detailCase_ == 1757) {
                return (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_;
            }
            return FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCharAmusementInfo() {
            return this.detailCase_ == 621;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo getCharAmusementInfo() {
            if (this.detailCase_ == 621) {
                return (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_;
            }
            return CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder getCharAmusementInfoOrBuilder() {
            if (this.detailCase_ == 621) {
                return (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_;
            }
            return CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasEffigyChallengeInfo() {
            return this.detailCase_ == 233;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo getEffigyChallengeInfo() {
            if (this.detailCase_ == 233) {
                return (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_;
            }
            return EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder getEffigyChallengeInfoOrBuilder() {
            if (this.detailCase_ == 233) {
                return (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_;
            }
            return EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasCoinCollectInfo() {
            return this.detailCase_ == 2002;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo getCoinCollectInfo() {
            if (this.detailCase_ == 2002) {
                return (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_;
            }
            return CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder getCoinCollectInfoOrBuilder() {
            if (this.detailCase_ == 2002) {
                return (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_;
            }
            return CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public boolean hasBrickBreakerInfo() {
            return this.detailCase_ == 1522;
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo getBrickBreakerInfo() {
            if (this.detailCase_ == 1522) {
                return (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_;
            }
            return BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
        public BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder getBrickBreakerInfoOrBuilder() {
            if (this.detailCase_ == 1522) {
                return (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_;
            }
            return BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
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
            if (this.beginTime_ != 0) {
                output.writeUInt32(1, this.beginTime_);
            }
            if (this.detailCase_ == 2) {
                output.writeMessage(2, (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_);
            }
            if (this.activityType_ != 0) {
                output.writeUInt32(3, this.activityType_);
            }
            if (this.detailCase_ == 4) {
                output.writeMessage(4, (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_);
            }
            if (getExpireCondListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.expireCondListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.expireCondList_.size(); i++) {
                output.writeUInt32NoTag(this.expireCondList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.watcherInfoList_.size(); i2++) {
                output.writeMessage(6, this.watcherInfoList_.get(i2));
            }
            if (this.scheduleId_ != 0) {
                output.writeUInt32(7, this.scheduleId_);
            }
            if (this.isFinished_) {
                output.writeBool(8, this.isFinished_);
            }
            if (this.detailCase_ == 9) {
                output.writeMessage(9, (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_);
            }
            if (this.endTime_ != 0) {
                output.writeUInt32(10, this.endTime_);
            }
            if (getMeetCondListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.meetCondListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.meetCondList_.size(); i3++) {
                output.writeUInt32NoTag(this.meetCondList_.getInt(i3));
            }
            if (this.unk3300MDBDPIBEGGH_) {
                output.writeBool(12, this.unk3300MDBDPIBEGGH_);
            }
            if (this.activityId_ != 0) {
                output.writeUInt32(13, this.activityId_);
            }
            if (this.unk3300ICNJJKDHPCH_) {
                output.writeBool(14, this.unk3300ICNJJKDHPCH_);
            }
            if (this.detailCase_ == 15) {
                output.writeMessage(15, (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetActivityCoinMap(), ActivityCoinMapDefaultEntryHolder.defaultEntry, 36);
            if (this.detailCase_ == 64) {
                output.writeMessage(64, (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 233) {
                output.writeMessage(233, (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_);
            }
            if (this.detailCase_ == 237) {
                output.writeMessage(237, (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 247) {
                output.writeMessage(247, (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_);
            }
            if (this.unk3300MJNPGEKLOCG_) {
                output.writeBool(360, this.unk3300MJNPGEKLOCG_);
            }
            if (this.detailCase_ == 378) {
                output.writeMessage(378, (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 411) {
                output.writeMessage(411, (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_);
            }
            if (this.detailCase_ == 432) {
                output.writeMessage(MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER, (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 444) {
                output.writeMessage(444, (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 468) {
                output.writeMessage(WIND_FIELD_INFO_FIELD_NUMBER, (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 505) {
                output.writeMessage(505, (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 511) {
                output.writeMessage(511, (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 538) {
                output.writeMessage(ARENA_CHALLENGE_INFO_FIELD_NUMBER, (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 551) {
                output.writeMessage(551, (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 560) {
                output.writeMessage(560, (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 621) {
                output.writeMessage(621, (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 635) {
                output.writeMessage(635, (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 686) {
                output.writeMessage(686, (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_);
            }
            if (this.selectedAvatarRewardId_ != 0) {
                output.writeUInt32(697, this.selectedAvatarRewardId_);
            }
            if (this.detailCase_ == 699) {
                output.writeMessage(699, (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 740) {
                output.writeMessage(ISLAND_PARTY_INFO_FIELD_NUMBER, (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 766) {
                output.writeMessage(MOONFIN_TRIAL_INFO_FIELD_NUMBER, (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_);
            }
            if (this.firstDayStartTime_ != 0) {
                output.writeUInt32(FIRST_DAY_START_TIME_FIELD_NUMBER, this.firstDayStartTime_);
            }
            if (this.detailCase_ == 789) {
                output.writeMessage(SPICE_INFO_FIELD_NUMBER, (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 812) {
                output.writeMessage(812, (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 839) {
                output.writeMessage(839, (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 846) {
                output.writeMessage(846, (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 922) {
                output.writeMessage(922, (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_);
            }
            GeneratedMessageV3.serializeIntegerMapTo(output, internalGetWishGiftNumMap(), WishGiftNumMapDefaultEntryHolder.defaultEntry, 939);
            if (this.detailCase_ == 970) {
                output.writeMessage(ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER, (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1006) {
                output.writeMessage(1006, (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1032) {
                output.writeMessage(TREASURE_SEELIE_INFO_FIELD_NUMBER, (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1056) {
                output.writeMessage(1056, (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1141) {
                output.writeMessage(DELIVERY_INFO_FIELD_NUMBER, (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1145) {
                output.writeMessage(INSTABLE_SPRAY_INFO_FIELD_NUMBER, (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1162) {
                output.writeMessage(ECHO_SHELL_INFO_FIELD_NUMBER, (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1182) {
                output.writeMessage(1182, (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1265) {
                output.writeMessage(ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER, (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_);
            }
            if (this.curScore_ != 0) {
                output.writeUInt32(CUR_SCORE_FIELD_NUMBER, this.curScore_);
            }
            if (this.detailCase_ == 1274) {
                output.writeMessage(PLANT_FLOWER_INFO_FIELD_NUMBER, (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1297) {
                output.writeMessage(GACHA_INFO_FIELD_NUMBER, (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1308) {
                output.writeMessage(1308, (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1310) {
                output.writeMessage(1310, (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1348) {
                output.writeMessage(TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER, (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1374) {
                output.writeMessage(EFFIGY_INFO_FIELD_NUMBER, (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_);
            }
            if (this.unk3300CBCEHLJJOGI_) {
                output.writeBool(UNK3300_CBCEHLJJOGI_FIELD_NUMBER, this.unk3300CBCEHLJJOGI_);
            }
            if (this.detailCase_ == 1447) {
                output.writeMessage(1447, (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1482) {
                output.writeMessage(GEAR_INFO_FIELD_NUMBER, (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_);
            }
            if (this.unk3300ABJKLALKLDG_) {
                output.writeBool(UNK3300_ABJKLALKLDG_FIELD_NUMBER, this.unk3300ABJKLALKLDG_);
            }
            if (this.detailCase_ == 1522) {
                output.writeMessage(1522, (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1545) {
                output.writeMessage(1545, (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1567) {
                output.writeMessage(POTION_INFO_FIELD_NUMBER, (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_);
            }
            if (this.unk3300NEPKLLBJFKK_) {
                output.writeBool(1645, this.unk3300NEPKLLBJFKK_);
            }
            if (this.detailCase_ == 1662) {
                output.writeMessage(MUQADAS_POTION_INFO_FIELD_NUMBER, (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1752) {
                output.writeMessage(EXPEDITION_INFO_FIELD_NUMBER, (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1757) {
                output.writeMessage(1757, (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1822) {
                output.writeMessage(1822, (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1839) {
                output.writeMessage(1839, (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1862) {
                output.writeMessage(DIG_INFO_FIELD_NUMBER, (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_);
            }
            for (int i4 = 0; i4 < this.activityPushTipsDataList_.size(); i4++) {
                output.writeMessage(ACTIVITY_PUSH_TIPS_DATA_LIST_FIELD_NUMBER, this.activityPushTipsDataList_.get(i4));
            }
            if (this.scoreLimit_ != 0) {
                output.writeUInt32(1870, this.scoreLimit_);
            }
            if (getTakenRewardListList().size() > 0) {
                output.writeUInt32NoTag(15114);
                output.writeUInt32NoTag(this.takenRewardListMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.takenRewardList_.size(); i5++) {
                output.writeUInt32NoTag(this.takenRewardList_.getInt(i5));
            }
            if (this.detailCase_ == 1910) {
                output.writeMessage(1910, (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1925) {
                output.writeMessage(TREASURE_MAP_INFO_FIELD_NUMBER, (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1928) {
                output.writeMessage(GRAVEN_INNOCENCE_INFO_FIELD_NUMBER, (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1962) {
                output.writeMessage(1962, (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1977) {
                output.writeMessage(1977, (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1989) {
                output.writeMessage(1989, (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 2002) {
                output.writeMessage(2002, (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 2011) {
                output.writeMessage(2011, (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_);
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
            if (this.beginTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.beginTime_);
            }
            if (this.detailCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_);
            }
            if (this.activityType_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.activityType_);
            }
            if (this.detailCase_ == 4) {
                size2 += CodedOutputStream.computeMessageSize(4, (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.expireCondList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.expireCondList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getExpireCondListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.expireCondListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.watcherInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(6, this.watcherInfoList_.get(i2));
            }
            if (this.scheduleId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(7, this.scheduleId_);
            }
            if (this.isFinished_) {
                size3 += CodedOutputStream.computeBoolSize(8, this.isFinished_);
            }
            if (this.detailCase_ == 9) {
                size3 += CodedOutputStream.computeMessageSize(9, (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_);
            }
            if (this.endTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(10, this.endTime_);
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.meetCondList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.meetCondList_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getMeetCondListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.meetCondListMemoizedSerializedSize = dataSize2;
            if (this.unk3300MDBDPIBEGGH_) {
                size4 += CodedOutputStream.computeBoolSize(12, this.unk3300MDBDPIBEGGH_);
            }
            if (this.activityId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(13, this.activityId_);
            }
            if (this.unk3300ICNJJKDHPCH_) {
                size4 += CodedOutputStream.computeBoolSize(14, this.unk3300ICNJJKDHPCH_);
            }
            if (this.detailCase_ == 15) {
                size4 += CodedOutputStream.computeMessageSize(15, (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_);
            }
            for (Map.Entry<Integer, Integer> entry : internalGetActivityCoinMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(36, ActivityCoinMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
            }
            if (this.detailCase_ == 64) {
                size4 += CodedOutputStream.computeMessageSize(64, (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 233) {
                size4 += CodedOutputStream.computeMessageSize(233, (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_);
            }
            if (this.detailCase_ == 237) {
                size4 += CodedOutputStream.computeMessageSize(237, (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 247) {
                size4 += CodedOutputStream.computeMessageSize(247, (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_);
            }
            if (this.unk3300MJNPGEKLOCG_) {
                size4 += CodedOutputStream.computeBoolSize(360, this.unk3300MJNPGEKLOCG_);
            }
            if (this.detailCase_ == 378) {
                size4 += CodedOutputStream.computeMessageSize(378, (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 411) {
                size4 += CodedOutputStream.computeMessageSize(411, (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_);
            }
            if (this.detailCase_ == 432) {
                size4 += CodedOutputStream.computeMessageSize(MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER, (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 444) {
                size4 += CodedOutputStream.computeMessageSize(444, (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 468) {
                size4 += CodedOutputStream.computeMessageSize(WIND_FIELD_INFO_FIELD_NUMBER, (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 505) {
                size4 += CodedOutputStream.computeMessageSize(505, (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 511) {
                size4 += CodedOutputStream.computeMessageSize(511, (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 538) {
                size4 += CodedOutputStream.computeMessageSize(ARENA_CHALLENGE_INFO_FIELD_NUMBER, (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 551) {
                size4 += CodedOutputStream.computeMessageSize(551, (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 560) {
                size4 += CodedOutputStream.computeMessageSize(560, (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 621) {
                size4 += CodedOutputStream.computeMessageSize(621, (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 635) {
                size4 += CodedOutputStream.computeMessageSize(635, (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 686) {
                size4 += CodedOutputStream.computeMessageSize(686, (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_);
            }
            if (this.selectedAvatarRewardId_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(697, this.selectedAvatarRewardId_);
            }
            if (this.detailCase_ == 699) {
                size4 += CodedOutputStream.computeMessageSize(699, (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 740) {
                size4 += CodedOutputStream.computeMessageSize(ISLAND_PARTY_INFO_FIELD_NUMBER, (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 766) {
                size4 += CodedOutputStream.computeMessageSize(MOONFIN_TRIAL_INFO_FIELD_NUMBER, (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_);
            }
            if (this.firstDayStartTime_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(FIRST_DAY_START_TIME_FIELD_NUMBER, this.firstDayStartTime_);
            }
            if (this.detailCase_ == 789) {
                size4 += CodedOutputStream.computeMessageSize(SPICE_INFO_FIELD_NUMBER, (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 812) {
                size4 += CodedOutputStream.computeMessageSize(812, (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 839) {
                size4 += CodedOutputStream.computeMessageSize(839, (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 846) {
                size4 += CodedOutputStream.computeMessageSize(846, (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 922) {
                size4 += CodedOutputStream.computeMessageSize(922, (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_);
            }
            for (Map.Entry<Integer, Integer> entry2 : internalGetWishGiftNumMap().getMap().entrySet()) {
                size4 += CodedOutputStream.computeMessageSize(939, WishGiftNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry2.getKey()).setValue(entry2.getValue()).build());
            }
            if (this.detailCase_ == 970) {
                size4 += CodedOutputStream.computeMessageSize(ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER, (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1006) {
                size4 += CodedOutputStream.computeMessageSize(1006, (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1032) {
                size4 += CodedOutputStream.computeMessageSize(TREASURE_SEELIE_INFO_FIELD_NUMBER, (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1056) {
                size4 += CodedOutputStream.computeMessageSize(1056, (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1141) {
                size4 += CodedOutputStream.computeMessageSize(DELIVERY_INFO_FIELD_NUMBER, (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1145) {
                size4 += CodedOutputStream.computeMessageSize(INSTABLE_SPRAY_INFO_FIELD_NUMBER, (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1162) {
                size4 += CodedOutputStream.computeMessageSize(ECHO_SHELL_INFO_FIELD_NUMBER, (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1182) {
                size4 += CodedOutputStream.computeMessageSize(1182, (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1265) {
                size4 += CodedOutputStream.computeMessageSize(ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER, (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_);
            }
            if (this.curScore_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(CUR_SCORE_FIELD_NUMBER, this.curScore_);
            }
            if (this.detailCase_ == 1274) {
                size4 += CodedOutputStream.computeMessageSize(PLANT_FLOWER_INFO_FIELD_NUMBER, (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1297) {
                size4 += CodedOutputStream.computeMessageSize(GACHA_INFO_FIELD_NUMBER, (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1308) {
                size4 += CodedOutputStream.computeMessageSize(1308, (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1310) {
                size4 += CodedOutputStream.computeMessageSize(1310, (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1348) {
                size4 += CodedOutputStream.computeMessageSize(TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER, (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1374) {
                size4 += CodedOutputStream.computeMessageSize(EFFIGY_INFO_FIELD_NUMBER, (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_);
            }
            if (this.unk3300CBCEHLJJOGI_) {
                size4 += CodedOutputStream.computeBoolSize(UNK3300_CBCEHLJJOGI_FIELD_NUMBER, this.unk3300CBCEHLJJOGI_);
            }
            if (this.detailCase_ == 1447) {
                size4 += CodedOutputStream.computeMessageSize(1447, (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1482) {
                size4 += CodedOutputStream.computeMessageSize(GEAR_INFO_FIELD_NUMBER, (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_);
            }
            if (this.unk3300ABJKLALKLDG_) {
                size4 += CodedOutputStream.computeBoolSize(UNK3300_ABJKLALKLDG_FIELD_NUMBER, this.unk3300ABJKLALKLDG_);
            }
            if (this.detailCase_ == 1522) {
                size4 += CodedOutputStream.computeMessageSize(1522, (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1545) {
                size4 += CodedOutputStream.computeMessageSize(1545, (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1567) {
                size4 += CodedOutputStream.computeMessageSize(POTION_INFO_FIELD_NUMBER, (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_);
            }
            if (this.unk3300NEPKLLBJFKK_) {
                size4 += CodedOutputStream.computeBoolSize(1645, this.unk3300NEPKLLBJFKK_);
            }
            if (this.detailCase_ == 1662) {
                size4 += CodedOutputStream.computeMessageSize(MUQADAS_POTION_INFO_FIELD_NUMBER, (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1752) {
                size4 += CodedOutputStream.computeMessageSize(EXPEDITION_INFO_FIELD_NUMBER, (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1757) {
                size4 += CodedOutputStream.computeMessageSize(1757, (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1822) {
                size4 += CodedOutputStream.computeMessageSize(1822, (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1839) {
                size4 += CodedOutputStream.computeMessageSize(1839, (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1862) {
                size4 += CodedOutputStream.computeMessageSize(DIG_INFO_FIELD_NUMBER, (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_);
            }
            for (int i4 = 0; i4 < this.activityPushTipsDataList_.size(); i4++) {
                size4 += CodedOutputStream.computeMessageSize(ACTIVITY_PUSH_TIPS_DATA_LIST_FIELD_NUMBER, this.activityPushTipsDataList_.get(i4));
            }
            if (this.scoreLimit_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(1870, this.scoreLimit_);
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
            if (this.detailCase_ == 1910) {
                size5 += CodedOutputStream.computeMessageSize(1910, (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1925) {
                size5 += CodedOutputStream.computeMessageSize(TREASURE_MAP_INFO_FIELD_NUMBER, (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1928) {
                size5 += CodedOutputStream.computeMessageSize(GRAVEN_INNOCENCE_INFO_FIELD_NUMBER, (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1962) {
                size5 += CodedOutputStream.computeMessageSize(1962, (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1977) {
                size5 += CodedOutputStream.computeMessageSize(1977, (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 1989) {
                size5 += CodedOutputStream.computeMessageSize(1989, (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 2002) {
                size5 += CodedOutputStream.computeMessageSize(2002, (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_);
            }
            if (this.detailCase_ == 2011) {
                size5 += CodedOutputStream.computeMessageSize(2011, (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_);
            }
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
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
            if (getUnk3300MJNPGEKLOCG() != other.getUnk3300MJNPGEKLOCG() || getIsFinished() != other.getIsFinished() || getCurScore() != other.getCurScore() || getScheduleId() != other.getScheduleId() || getScoreLimit() != other.getScoreLimit() || getUnk3300ICNJJKDHPCH() != other.getUnk3300ICNJJKDHPCH() || !getMeetCondListList().equals(other.getMeetCondListList()) || getUnk3300NEPKLLBJFKK() != other.getUnk3300NEPKLLBJFKK() || !getWatcherInfoListList().equals(other.getWatcherInfoListList()) || !getActivityPushTipsDataListList().equals(other.getActivityPushTipsDataListList()) || getActivityId() != other.getActivityId() || !getTakenRewardListList().equals(other.getTakenRewardListList()) || getSelectedAvatarRewardId() != other.getSelectedAvatarRewardId() || !internalGetActivityCoinMap().equals(other.internalGetActivityCoinMap()) || getFirstDayStartTime() != other.getFirstDayStartTime() || getUnk3300ABJKLALKLDG() != other.getUnk3300ABJKLALKLDG() || getActivityType() != other.getActivityType() || getUnk3300CBCEHLJJOGI() != other.getUnk3300CBCEHLJJOGI() || getBeginTime() != other.getBeginTime() || getUnk3300MDBDPIBEGGH() != other.getUnk3300MDBDPIBEGGH() || !internalGetWishGiftNumMap().equals(other.internalGetWishGiftNumMap()) || getEndTime() != other.getEndTime() || !getExpireCondListList().equals(other.getExpireCondListList()) || !getDetailCase().equals(other.getDetailCase())) {
                return false;
            }
            switch (this.detailCase_) {
                case 2:
                    if (!getSamLampInfo().equals(other.getSamLampInfo())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getTrialAvatarInfo().equals(other.getTrialAvatarInfo())) {
                        return false;
                    }
                    break;
                case 9:
                    if (!getSalesmanInfo().equals(other.getSalesmanInfo())) {
                        return false;
                    }
                    break;
                case 15:
                    if (!getCrucibleInfo().equals(other.getCrucibleInfo())) {
                        return false;
                    }
                    break;
                case 64:
                    if (!getBlitzRushInfo().equals(other.getBlitzRushInfo())) {
                        return false;
                    }
                    break;
                case 233:
                    if (!getEffigyChallengeInfo().equals(other.getEffigyChallengeInfo())) {
                        return false;
                    }
                    break;
                case 237:
                    if (!getLanternRiteActivityInfo().equals(other.getLanternRiteActivityInfo())) {
                        return false;
                    }
                    break;
                case 247:
                    if (!getSeaLampInfo().equals(other.getSeaLampInfo())) {
                        return false;
                    }
                    break;
                case 378:
                    if (!getFindHilichurlInfo().equals(other.getFindHilichurlInfo())) {
                        return false;
                    }
                    break;
                case 411:
                    if (!getSummerTimeV2Info().equals(other.getSummerTimeV2Info())) {
                        return false;
                    }
                    break;
                case MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER /* 432 */:
                    if (!getMistTrialActivityInfo().equals(other.getMistTrialActivityInfo())) {
                        return false;
                    }
                    break;
                case 444:
                    if (!getLuminanceStoneChallengeInfo().equals(other.getLuminanceStoneChallengeInfo())) {
                        return false;
                    }
                    break;
                case WIND_FIELD_INFO_FIELD_NUMBER /* 468 */:
                    if (!getWindFieldInfo().equals(other.getWindFieldInfo())) {
                        return false;
                    }
                    break;
                case 505:
                    if (!getSumoInfo().equals(other.getSumoInfo())) {
                        return false;
                    }
                    break;
                case 511:
                    if (!getHachiInfo().equals(other.getHachiInfo())) {
                        return false;
                    }
                    break;
                case ARENA_CHALLENGE_INFO_FIELD_NUMBER /* 538 */:
                    if (!getArenaChallengeInfo().equals(other.getArenaChallengeInfo())) {
                        return false;
                    }
                    break;
                case 551:
                    if (!getBartenderInfo().equals(other.getBartenderInfo())) {
                        return false;
                    }
                    break;
                case 560:
                    if (!getRogueDiaryInfo().equals(other.getRogueDiaryInfo())) {
                        return false;
                    }
                    break;
                case 621:
                    if (!getCharAmusementInfo().equals(other.getCharAmusementInfo())) {
                        return false;
                    }
                    break;
                case 635:
                    if (!getWaterSpiritInfo().equals(other.getWaterSpiritInfo())) {
                        return false;
                    }
                    break;
                case 686:
                    if (!getBuoyantCombatInfo().equals(other.getBuoyantCombatInfo())) {
                        return false;
                    }
                    break;
                case 699:
                    if (!getWinterCampInfo().equals(other.getWinterCampInfo())) {
                        return false;
                    }
                    break;
                case ISLAND_PARTY_INFO_FIELD_NUMBER /* 740 */:
                    if (!getIslandPartyInfo().equals(other.getIslandPartyInfo())) {
                        return false;
                    }
                    break;
                case MOONFIN_TRIAL_INFO_FIELD_NUMBER /* 766 */:
                    if (!getMoonfinTrialInfo().equals(other.getMoonfinTrialInfo())) {
                        return false;
                    }
                    break;
                case SPICE_INFO_FIELD_NUMBER /* 789 */:
                    if (!getSpiceInfo().equals(other.getSpiceInfo())) {
                        return false;
                    }
                    break;
                case 812:
                    if (!getCrystalLinkInfo().equals(other.getCrystalLinkInfo())) {
                        return false;
                    }
                    break;
                case 839:
                    if (!getHideAndSeekInfo().equals(other.getHideAndSeekInfo())) {
                        return false;
                    }
                    break;
                case 846:
                    if (!getChannelerSlabInfo().equals(other.getChannelerSlabInfo())) {
                        return false;
                    }
                    break;
                case 922:
                    if (!getBounceConjuringInfo().equals(other.getBounceConjuringInfo())) {
                        return false;
                    }
                    break;
                case ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER /* 970 */:
                    if (!getRoguelikeDungeonInfo().equals(other.getRoguelikeDungeonInfo())) {
                        return false;
                    }
                    break;
                case 1006:
                    if (!getChessInfo().equals(other.getChessInfo())) {
                        return false;
                    }
                    break;
                case TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1032 */:
                    if (!getTreasureSeelieInfo().equals(other.getTreasureSeelieInfo())) {
                        return false;
                    }
                    break;
                case 1056:
                    if (!getIrodoriInfo().equals(other.getIrodoriInfo())) {
                        return false;
                    }
                    break;
                case DELIVERY_INFO_FIELD_NUMBER /* 1141 */:
                    if (!getDeliveryInfo().equals(other.getDeliveryInfo())) {
                        return false;
                    }
                    break;
                case INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 1145 */:
                    if (!getInstableSprayInfo().equals(other.getInstableSprayInfo())) {
                        return false;
                    }
                    break;
                case ECHO_SHELL_INFO_FIELD_NUMBER /* 1162 */:
                    if (!getEchoShellInfo().equals(other.getEchoShellInfo())) {
                        return false;
                    }
                    break;
                case 1182:
                    if (!getUgcInfo().equals(other.getUgcInfo())) {
                        return false;
                    }
                    break;
                case ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1265 */:
                    if (!getRockBoardExploreInfo().equals(other.getRockBoardExploreInfo())) {
                        return false;
                    }
                    break;
                case PLANT_FLOWER_INFO_FIELD_NUMBER /* 1274 */:
                    if (!getPlantFlowerInfo().equals(other.getPlantFlowerInfo())) {
                        return false;
                    }
                    break;
                case GACHA_INFO_FIELD_NUMBER /* 1297 */:
                    if (!getGachaInfo().equals(other.getGachaInfo())) {
                        return false;
                    }
                    break;
                case 1308:
                    if (!getVintageInfo().equals(other.getVintageInfo())) {
                        return false;
                    }
                    break;
                case 1310:
                    if (!getDragonSpineInfo().equals(other.getDragonSpineInfo())) {
                        return false;
                    }
                    break;
                case TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1348 */:
                    if (!getTanukiTravelActivityInfo().equals(other.getTanukiTravelActivityInfo())) {
                        return false;
                    }
                    break;
                case EFFIGY_INFO_FIELD_NUMBER /* 1374 */:
                    if (!getEffigyInfo().equals(other.getEffigyInfo())) {
                        return false;
                    }
                    break;
                case 1447:
                    if (!getFleurFairInfo().equals(other.getFleurFairInfo())) {
                        return false;
                    }
                    break;
                case GEAR_INFO_FIELD_NUMBER /* 1482 */:
                    if (!getGearInfo().equals(other.getGearInfo())) {
                        return false;
                    }
                    break;
                case 1522:
                    if (!getBrickBreakerInfo().equals(other.getBrickBreakerInfo())) {
                        return false;
                    }
                    break;
                case 1545:
                    if (!getLunaRiteInfo().equals(other.getLunaRiteInfo())) {
                        return false;
                    }
                    break;
                case POTION_INFO_FIELD_NUMBER /* 1567 */:
                    if (!getPotionInfo().equals(other.getPotionInfo())) {
                        return false;
                    }
                    break;
                case MUQADAS_POTION_INFO_FIELD_NUMBER /* 1662 */:
                    if (!getMuqadasPotionInfo().equals(other.getMuqadasPotionInfo())) {
                        return false;
                    }
                    break;
                case EXPEDITION_INFO_FIELD_NUMBER /* 1752 */:
                    if (!getExpeditionInfo().equals(other.getExpeditionInfo())) {
                        return false;
                    }
                    break;
                case 1757:
                    if (!getFungusFighterInfo().equals(other.getFungusFighterInfo())) {
                        return false;
                    }
                    break;
                case 1822:
                    if (!getPhotoInfo().equals(other.getPhotoInfo())) {
                        return false;
                    }
                    break;
                case 1839:
                    if (!getMichiaeMatsuriInfo().equals(other.getMichiaeMatsuriInfo())) {
                        return false;
                    }
                    break;
                case DIG_INFO_FIELD_NUMBER /* 1862 */:
                    if (!getDigInfo().equals(other.getDigInfo())) {
                        return false;
                    }
                    break;
                case 1910:
                    if (!getSummerTimeInfo().equals(other.getSummerTimeInfo())) {
                        return false;
                    }
                    break;
                case TREASURE_MAP_INFO_FIELD_NUMBER /* 1925 */:
                    if (!getTreasureMapInfo().equals(other.getTreasureMapInfo())) {
                        return false;
                    }
                    break;
                case GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1928 */:
                    if (!getGravenInnocenceInfo().equals(other.getGravenInnocenceInfo())) {
                        return false;
                    }
                    break;
                case 1962:
                    if (!getBlessingInfo().equals(other.getBlessingInfo())) {
                        return false;
                    }
                    break;
                case 1977:
                    if (!getAsterInfo().equals(other.getAsterInfo())) {
                        return false;
                    }
                    break;
                case 1989:
                    if (!getMusicGameInfo().equals(other.getMusicGameInfo())) {
                        return false;
                    }
                    break;
                case 2002:
                    if (!getCoinCollectInfo().equals(other.getCoinCollectInfo())) {
                        return false;
                    }
                    break;
                case 2011:
                    if (!getFlightInfo().equals(other.getFlightInfo())) {
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
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 360)) + Internal.hashBoolean(getUnk3300MJNPGEKLOCG()))) + 8)) + Internal.hashBoolean(getIsFinished()))) + CUR_SCORE_FIELD_NUMBER)) + getCurScore())) + 7)) + getScheduleId())) + 1870)) + getScoreLimit())) + 14)) + Internal.hashBoolean(getUnk3300ICNJJKDHPCH());
            if (getMeetCondListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getMeetCondListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 1645)) + Internal.hashBoolean(getUnk3300NEPKLLBJFKK());
            if (getWatcherInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getWatcherInfoListList().hashCode();
            }
            if (getActivityPushTipsDataListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + ACTIVITY_PUSH_TIPS_DATA_LIST_FIELD_NUMBER)) + getActivityPushTipsDataListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 13)) + getActivityId();
            if (getTakenRewardListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + TAKEN_REWARD_LIST_FIELD_NUMBER)) + getTakenRewardListList().hashCode();
            }
            int hash4 = (53 * ((37 * hash3) + 697)) + getSelectedAvatarRewardId();
            if (!internalGetActivityCoinMap().getMap().isEmpty()) {
                hash4 = (53 * ((37 * hash4) + 36)) + internalGetActivityCoinMap().hashCode();
            }
            int hash5 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash4) + FIRST_DAY_START_TIME_FIELD_NUMBER)) + getFirstDayStartTime())) + UNK3300_ABJKLALKLDG_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300ABJKLALKLDG()))) + 3)) + getActivityType())) + UNK3300_CBCEHLJJOGI_FIELD_NUMBER)) + Internal.hashBoolean(getUnk3300CBCEHLJJOGI()))) + 1)) + getBeginTime())) + 12)) + Internal.hashBoolean(getUnk3300MDBDPIBEGGH());
            if (!internalGetWishGiftNumMap().getMap().isEmpty()) {
                hash5 = (53 * ((37 * hash5) + 939)) + internalGetWishGiftNumMap().hashCode();
            }
            int hash6 = (53 * ((37 * hash5) + 10)) + getEndTime();
            if (getExpireCondListCount() > 0) {
                hash6 = (53 * ((37 * hash6) + 5)) + getExpireCondListList().hashCode();
            }
            switch (this.detailCase_) {
                case 2:
                    hash6 = (53 * ((37 * hash6) + 2)) + getSamLampInfo().hashCode();
                    break;
                case 4:
                    hash6 = (53 * ((37 * hash6) + 4)) + getTrialAvatarInfo().hashCode();
                    break;
                case 9:
                    hash6 = (53 * ((37 * hash6) + 9)) + getSalesmanInfo().hashCode();
                    break;
                case 15:
                    hash6 = (53 * ((37 * hash6) + 15)) + getCrucibleInfo().hashCode();
                    break;
                case 64:
                    hash6 = (53 * ((37 * hash6) + 64)) + getBlitzRushInfo().hashCode();
                    break;
                case 233:
                    hash6 = (53 * ((37 * hash6) + 233)) + getEffigyChallengeInfo().hashCode();
                    break;
                case 237:
                    hash6 = (53 * ((37 * hash6) + 237)) + getLanternRiteActivityInfo().hashCode();
                    break;
                case 247:
                    hash6 = (53 * ((37 * hash6) + 247)) + getSeaLampInfo().hashCode();
                    break;
                case 378:
                    hash6 = (53 * ((37 * hash6) + 378)) + getFindHilichurlInfo().hashCode();
                    break;
                case 411:
                    hash6 = (53 * ((37 * hash6) + 411)) + getSummerTimeV2Info().hashCode();
                    break;
                case MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER /* 432 */:
                    hash6 = (53 * ((37 * hash6) + MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER)) + getMistTrialActivityInfo().hashCode();
                    break;
                case 444:
                    hash6 = (53 * ((37 * hash6) + 444)) + getLuminanceStoneChallengeInfo().hashCode();
                    break;
                case WIND_FIELD_INFO_FIELD_NUMBER /* 468 */:
                    hash6 = (53 * ((37 * hash6) + WIND_FIELD_INFO_FIELD_NUMBER)) + getWindFieldInfo().hashCode();
                    break;
                case 505:
                    hash6 = (53 * ((37 * hash6) + 505)) + getSumoInfo().hashCode();
                    break;
                case 511:
                    hash6 = (53 * ((37 * hash6) + 511)) + getHachiInfo().hashCode();
                    break;
                case ARENA_CHALLENGE_INFO_FIELD_NUMBER /* 538 */:
                    hash6 = (53 * ((37 * hash6) + ARENA_CHALLENGE_INFO_FIELD_NUMBER)) + getArenaChallengeInfo().hashCode();
                    break;
                case 551:
                    hash6 = (53 * ((37 * hash6) + 551)) + getBartenderInfo().hashCode();
                    break;
                case 560:
                    hash6 = (53 * ((37 * hash6) + 560)) + getRogueDiaryInfo().hashCode();
                    break;
                case 621:
                    hash6 = (53 * ((37 * hash6) + 621)) + getCharAmusementInfo().hashCode();
                    break;
                case 635:
                    hash6 = (53 * ((37 * hash6) + 635)) + getWaterSpiritInfo().hashCode();
                    break;
                case 686:
                    hash6 = (53 * ((37 * hash6) + 686)) + getBuoyantCombatInfo().hashCode();
                    break;
                case 699:
                    hash6 = (53 * ((37 * hash6) + 699)) + getWinterCampInfo().hashCode();
                    break;
                case ISLAND_PARTY_INFO_FIELD_NUMBER /* 740 */:
                    hash6 = (53 * ((37 * hash6) + ISLAND_PARTY_INFO_FIELD_NUMBER)) + getIslandPartyInfo().hashCode();
                    break;
                case MOONFIN_TRIAL_INFO_FIELD_NUMBER /* 766 */:
                    hash6 = (53 * ((37 * hash6) + MOONFIN_TRIAL_INFO_FIELD_NUMBER)) + getMoonfinTrialInfo().hashCode();
                    break;
                case SPICE_INFO_FIELD_NUMBER /* 789 */:
                    hash6 = (53 * ((37 * hash6) + SPICE_INFO_FIELD_NUMBER)) + getSpiceInfo().hashCode();
                    break;
                case 812:
                    hash6 = (53 * ((37 * hash6) + 812)) + getCrystalLinkInfo().hashCode();
                    break;
                case 839:
                    hash6 = (53 * ((37 * hash6) + 839)) + getHideAndSeekInfo().hashCode();
                    break;
                case 846:
                    hash6 = (53 * ((37 * hash6) + 846)) + getChannelerSlabInfo().hashCode();
                    break;
                case 922:
                    hash6 = (53 * ((37 * hash6) + 922)) + getBounceConjuringInfo().hashCode();
                    break;
                case ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER /* 970 */:
                    hash6 = (53 * ((37 * hash6) + ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER)) + getRoguelikeDungeonInfo().hashCode();
                    break;
                case 1006:
                    hash6 = (53 * ((37 * hash6) + 1006)) + getChessInfo().hashCode();
                    break;
                case TREASURE_SEELIE_INFO_FIELD_NUMBER /* 1032 */:
                    hash6 = (53 * ((37 * hash6) + TREASURE_SEELIE_INFO_FIELD_NUMBER)) + getTreasureSeelieInfo().hashCode();
                    break;
                case 1056:
                    hash6 = (53 * ((37 * hash6) + 1056)) + getIrodoriInfo().hashCode();
                    break;
                case DELIVERY_INFO_FIELD_NUMBER /* 1141 */:
                    hash6 = (53 * ((37 * hash6) + DELIVERY_INFO_FIELD_NUMBER)) + getDeliveryInfo().hashCode();
                    break;
                case INSTABLE_SPRAY_INFO_FIELD_NUMBER /* 1145 */:
                    hash6 = (53 * ((37 * hash6) + INSTABLE_SPRAY_INFO_FIELD_NUMBER)) + getInstableSprayInfo().hashCode();
                    break;
                case ECHO_SHELL_INFO_FIELD_NUMBER /* 1162 */:
                    hash6 = (53 * ((37 * hash6) + ECHO_SHELL_INFO_FIELD_NUMBER)) + getEchoShellInfo().hashCode();
                    break;
                case 1182:
                    hash6 = (53 * ((37 * hash6) + 1182)) + getUgcInfo().hashCode();
                    break;
                case ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER /* 1265 */:
                    hash6 = (53 * ((37 * hash6) + ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER)) + getRockBoardExploreInfo().hashCode();
                    break;
                case PLANT_FLOWER_INFO_FIELD_NUMBER /* 1274 */:
                    hash6 = (53 * ((37 * hash6) + PLANT_FLOWER_INFO_FIELD_NUMBER)) + getPlantFlowerInfo().hashCode();
                    break;
                case GACHA_INFO_FIELD_NUMBER /* 1297 */:
                    hash6 = (53 * ((37 * hash6) + GACHA_INFO_FIELD_NUMBER)) + getGachaInfo().hashCode();
                    break;
                case 1308:
                    hash6 = (53 * ((37 * hash6) + 1308)) + getVintageInfo().hashCode();
                    break;
                case 1310:
                    hash6 = (53 * ((37 * hash6) + 1310)) + getDragonSpineInfo().hashCode();
                    break;
                case TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER /* 1348 */:
                    hash6 = (53 * ((37 * hash6) + TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER)) + getTanukiTravelActivityInfo().hashCode();
                    break;
                case EFFIGY_INFO_FIELD_NUMBER /* 1374 */:
                    hash6 = (53 * ((37 * hash6) + EFFIGY_INFO_FIELD_NUMBER)) + getEffigyInfo().hashCode();
                    break;
                case 1447:
                    hash6 = (53 * ((37 * hash6) + 1447)) + getFleurFairInfo().hashCode();
                    break;
                case GEAR_INFO_FIELD_NUMBER /* 1482 */:
                    hash6 = (53 * ((37 * hash6) + GEAR_INFO_FIELD_NUMBER)) + getGearInfo().hashCode();
                    break;
                case 1522:
                    hash6 = (53 * ((37 * hash6) + 1522)) + getBrickBreakerInfo().hashCode();
                    break;
                case 1545:
                    hash6 = (53 * ((37 * hash6) + 1545)) + getLunaRiteInfo().hashCode();
                    break;
                case POTION_INFO_FIELD_NUMBER /* 1567 */:
                    hash6 = (53 * ((37 * hash6) + POTION_INFO_FIELD_NUMBER)) + getPotionInfo().hashCode();
                    break;
                case MUQADAS_POTION_INFO_FIELD_NUMBER /* 1662 */:
                    hash6 = (53 * ((37 * hash6) + MUQADAS_POTION_INFO_FIELD_NUMBER)) + getMuqadasPotionInfo().hashCode();
                    break;
                case EXPEDITION_INFO_FIELD_NUMBER /* 1752 */:
                    hash6 = (53 * ((37 * hash6) + EXPEDITION_INFO_FIELD_NUMBER)) + getExpeditionInfo().hashCode();
                    break;
                case 1757:
                    hash6 = (53 * ((37 * hash6) + 1757)) + getFungusFighterInfo().hashCode();
                    break;
                case 1822:
                    hash6 = (53 * ((37 * hash6) + 1822)) + getPhotoInfo().hashCode();
                    break;
                case 1839:
                    hash6 = (53 * ((37 * hash6) + 1839)) + getMichiaeMatsuriInfo().hashCode();
                    break;
                case DIG_INFO_FIELD_NUMBER /* 1862 */:
                    hash6 = (53 * ((37 * hash6) + DIG_INFO_FIELD_NUMBER)) + getDigInfo().hashCode();
                    break;
                case 1910:
                    hash6 = (53 * ((37 * hash6) + 1910)) + getSummerTimeInfo().hashCode();
                    break;
                case TREASURE_MAP_INFO_FIELD_NUMBER /* 1925 */:
                    hash6 = (53 * ((37 * hash6) + TREASURE_MAP_INFO_FIELD_NUMBER)) + getTreasureMapInfo().hashCode();
                    break;
                case GRAVEN_INNOCENCE_INFO_FIELD_NUMBER /* 1928 */:
                    hash6 = (53 * ((37 * hash6) + GRAVEN_INNOCENCE_INFO_FIELD_NUMBER)) + getGravenInnocenceInfo().hashCode();
                    break;
                case 1962:
                    hash6 = (53 * ((37 * hash6) + 1962)) + getBlessingInfo().hashCode();
                    break;
                case 1977:
                    hash6 = (53 * ((37 * hash6) + 1977)) + getAsterInfo().hashCode();
                    break;
                case 1989:
                    hash6 = (53 * ((37 * hash6) + 1989)) + getMusicGameInfo().hashCode();
                    break;
                case 2002:
                    hash6 = (53 * ((37 * hash6) + 2002)) + getCoinCollectInfo().hashCode();
                    break;
                case 2011:
                    hash6 = (53 * ((37 * hash6) + 2011)) + getFlightInfo().hashCode();
                    break;
            }
            int hash7 = (29 * hash6) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash7;
            return hash7;
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
            private boolean unk3300MJNPGEKLOCG_;
            private boolean isFinished_;
            private int curScore_;
            private int scheduleId_;
            private int scoreLimit_;
            private boolean unk3300ICNJJKDHPCH_;
            private boolean unk3300NEPKLLBJFKK_;
            private RepeatedFieldBuilderV3<ActivityWatcherInfoOuterClass.ActivityWatcherInfo, ActivityWatcherInfoOuterClass.ActivityWatcherInfo.Builder, ActivityWatcherInfoOuterClass.ActivityWatcherInfoOrBuilder> watcherInfoListBuilder_;
            private RepeatedFieldBuilderV3<ActivityPushTipsDataOuterClass.ActivityPushTipsData, ActivityPushTipsDataOuterClass.ActivityPushTipsData.Builder, ActivityPushTipsDataOuterClass.ActivityPushTipsDataOrBuilder> activityPushTipsDataListBuilder_;
            private int activityId_;
            private int selectedAvatarRewardId_;
            private MapField<Integer, Integer> activityCoinMap_;
            private int firstDayStartTime_;
            private boolean unk3300ABJKLALKLDG_;
            private int activityType_;
            private boolean unk3300CBCEHLJJOGI_;
            private int beginTime_;
            private boolean unk3300MDBDPIBEGGH_;
            private MapField<Integer, Integer> wishGiftNumMap_;
            private int endTime_;
            private SingleFieldBuilderV3<SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo, SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.Builder, SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfoOrBuilder> samLampInfoBuilder_;
            private SingleFieldBuilderV3<CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo, CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.Builder, CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder> crucibleInfoBuilder_;
            private SingleFieldBuilderV3<SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo, SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder, SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder> salesmanInfoBuilder_;
            private SingleFieldBuilderV3<TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo, TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.Builder, TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder> trialAvatarInfoBuilder_;
            private SingleFieldBuilderV3<DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo, DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.Builder, DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder> deliveryInfoBuilder_;
            private SingleFieldBuilderV3<AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo, AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.Builder, AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder> asterInfoBuilder_;
            private SingleFieldBuilderV3<FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo, FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.Builder, FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder> flightInfoBuilder_;
            private SingleFieldBuilderV3<DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo, DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.Builder, DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder> dragonSpineInfoBuilder_;
            private SingleFieldBuilderV3<EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo, EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.Builder, EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfoOrBuilder> effigyInfoBuilder_;
            private SingleFieldBuilderV3<TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo, TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.Builder, TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder> treasureMapInfoBuilder_;
            private SingleFieldBuilderV3<BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo, BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder, BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder> blessingInfoBuilder_;
            private SingleFieldBuilderV3<SeaLampActivityInfoOuterClass.SeaLampActivityInfo, SeaLampActivityInfoOuterClass.SeaLampActivityInfo.Builder, SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder> seaLampInfoBuilder_;
            private SingleFieldBuilderV3<ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo, ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.Builder, ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder> expeditionInfoBuilder_;
            private SingleFieldBuilderV3<ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo, ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.Builder, ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfoOrBuilder> arenaChallengeInfoBuilder_;
            private SingleFieldBuilderV3<FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo, FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder, FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder> fleurFairInfoBuilder_;
            private SingleFieldBuilderV3<WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo, WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.Builder, WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfoOrBuilder> waterSpiritInfoBuilder_;
            private SingleFieldBuilderV3<ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo, ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.Builder, ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfoOrBuilder> channelerSlabInfoBuilder_;
            private SingleFieldBuilderV3<MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo, MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.Builder, MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder> mistTrialActivityInfoBuilder_;
            private SingleFieldBuilderV3<HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo, HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.Builder, HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder> hideAndSeekInfoBuilder_;
            private SingleFieldBuilderV3<FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo, FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.Builder, FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder> findHilichurlInfoBuilder_;
            private SingleFieldBuilderV3<SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo, SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder, SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder> summerTimeInfoBuilder_;
            private SingleFieldBuilderV3<BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo, BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.Builder, BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder> buoyantCombatInfoBuilder_;
            private SingleFieldBuilderV3<EchoShellDetailInfoOuterClass.EchoShellDetailInfo, EchoShellDetailInfoOuterClass.EchoShellDetailInfo.Builder, EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder> echoShellInfoBuilder_;
            private SingleFieldBuilderV3<BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo, BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.Builder, BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder> bounceConjuringInfoBuilder_;
            private SingleFieldBuilderV3<BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo, BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.Builder, BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder> blitzRushInfoBuilder_;
            private SingleFieldBuilderV3<ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo, ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.Builder, ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder> chessInfoBuilder_;
            private SingleFieldBuilderV3<SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo, SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder, SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder> sumoInfoBuilder_;
            private SingleFieldBuilderV3<MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo, MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.Builder, MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfoOrBuilder> moonfinTrialInfoBuilder_;
            private SingleFieldBuilderV3<LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo, LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.Builder, LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder> lunaRiteInfoBuilder_;
            private SingleFieldBuilderV3<PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo, PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder, PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder> plantFlowerInfoBuilder_;
            private SingleFieldBuilderV3<MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder> musicGameInfoBuilder_;
            private SingleFieldBuilderV3<RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo, RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.Builder, RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder> roguelikeDungeonInfoBuilder_;
            private SingleFieldBuilderV3<DigActivityDetailInfoOuterClass.DigActivityDetailInfo, DigActivityDetailInfoOuterClass.DigActivityDetailInfo.Builder, DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder> digInfoBuilder_;
            private SingleFieldBuilderV3<HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo, HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.Builder, HachiActivityDetailInfoOuterClass.HachiActivityDetailInfoOrBuilder> hachiInfoBuilder_;
            private SingleFieldBuilderV3<WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo, WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.Builder, WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder> winterCampInfoBuilder_;
            private SingleFieldBuilderV3<PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo, PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.Builder, PotionActivityDetailInfoOuterClass.PotionActivityDetailInfoOrBuilder> potionInfoBuilder_;
            private SingleFieldBuilderV3<TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo, TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.Builder, TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder> tanukiTravelActivityInfoBuilder_;
            private SingleFieldBuilderV3<LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo, LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.Builder, LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder> lanternRiteActivityInfoBuilder_;
            private SingleFieldBuilderV3<MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo, MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.Builder, MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder> michiaeMatsuriInfoBuilder_;
            private SingleFieldBuilderV3<BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo, BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.Builder, BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder> bartenderInfoBuilder_;
            private SingleFieldBuilderV3<UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo, UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.Builder, UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder> ugcInfoBuilder_;
            private SingleFieldBuilderV3<CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo, CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.Builder, CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfoOrBuilder> crystalLinkInfoBuilder_;
            private SingleFieldBuilderV3<IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo, IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.Builder, IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder> irodoriInfoBuilder_;
            private SingleFieldBuilderV3<PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo, PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.Builder, PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder> photoInfoBuilder_;
            private SingleFieldBuilderV3<SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo, SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.Builder, SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfoOrBuilder> spiceInfoBuilder_;
            private SingleFieldBuilderV3<GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo, GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder, GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder> gachaInfoBuilder_;
            private SingleFieldBuilderV3<LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo, LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.Builder, LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder> luminanceStoneChallengeInfoBuilder_;
            private SingleFieldBuilderV3<RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo, RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.Builder, RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder> rogueDiaryInfoBuilder_;
            private SingleFieldBuilderV3<SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo, SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.Builder, SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder> summerTimeV2InfoBuilder_;
            private SingleFieldBuilderV3<IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo, IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.Builder, IslandPartyDetailInfoOuterClass.IslandPartyDetailInfoOrBuilder> islandPartyInfoBuilder_;
            private SingleFieldBuilderV3<GearActivityDetailInfoOuterClass.GearActivityDetailInfo, GearActivityDetailInfoOuterClass.GearActivityDetailInfo.Builder, GearActivityDetailInfoOuterClass.GearActivityDetailInfoOrBuilder> gearInfoBuilder_;
            private SingleFieldBuilderV3<GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo, GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.Builder, GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder> gravenInnocenceInfoBuilder_;
            private SingleFieldBuilderV3<InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo, InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.Builder, InstableSprayDetailInfoOuterClass.InstableSprayDetailInfoOrBuilder> instableSprayInfoBuilder_;
            private SingleFieldBuilderV3<MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo, MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.Builder, MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder> muqadasPotionInfoBuilder_;
            private SingleFieldBuilderV3<TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo, TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.Builder, TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder> treasureSeelieInfoBuilder_;
            private SingleFieldBuilderV3<RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo, RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.Builder, RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfoOrBuilder> rockBoardExploreInfoBuilder_;
            private SingleFieldBuilderV3<VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo, VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder, VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder> vintageInfoBuilder_;
            private SingleFieldBuilderV3<WindFieldDetailInfoOuterClass.WindFieldDetailInfo, WindFieldDetailInfoOuterClass.WindFieldDetailInfo.Builder, WindFieldDetailInfoOuterClass.WindFieldDetailInfoOrBuilder> windFieldInfoBuilder_;
            private SingleFieldBuilderV3<FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo, FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.Builder, FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder> fungusFighterInfoBuilder_;
            private SingleFieldBuilderV3<CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo, CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.Builder, CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder> charAmusementInfoBuilder_;
            private SingleFieldBuilderV3<EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo, EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.Builder, EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder> effigyChallengeInfoBuilder_;
            private SingleFieldBuilderV3<CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo, CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.Builder, CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder> coinCollectInfoBuilder_;
            private SingleFieldBuilderV3<BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo, BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder, BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder> brickBreakerInfoBuilder_;
            private int detailCase_ = 0;
            private Internal.IntList meetCondList_ = ActivityInfo.emptyIntList();
            private List<ActivityWatcherInfoOuterClass.ActivityWatcherInfo> watcherInfoList_ = Collections.emptyList();
            private List<ActivityPushTipsDataOuterClass.ActivityPushTipsData> activityPushTipsDataList_ = Collections.emptyList();
            private Internal.IntList takenRewardList_ = ActivityInfo.emptyIntList();
            private Internal.IntList expireCondList_ = ActivityInfo.emptyIntList();

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
                        case 36: goto L_0x001c;
                        case 939: goto L_0x0021;
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
                        case 36: goto L_0x001c;
                        case 939: goto L_0x0021;
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
                    getWatcherInfoListFieldBuilder();
                    getActivityPushTipsDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300MJNPGEKLOCG_ = false;
                this.isFinished_ = false;
                this.curScore_ = 0;
                this.scheduleId_ = 0;
                this.scoreLimit_ = 0;
                this.unk3300ICNJJKDHPCH_ = false;
                this.meetCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300NEPKLLBJFKK_ = false;
                if (this.watcherInfoListBuilder_ == null) {
                    this.watcherInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.watcherInfoListBuilder_.clear();
                }
                if (this.activityPushTipsDataListBuilder_ == null) {
                    this.activityPushTipsDataList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.activityPushTipsDataListBuilder_.clear();
                }
                this.activityId_ = 0;
                this.takenRewardList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -9;
                this.selectedAvatarRewardId_ = 0;
                internalGetMutableActivityCoinMap().clear();
                this.firstDayStartTime_ = 0;
                this.unk3300ABJKLALKLDG_ = false;
                this.activityType_ = 0;
                this.unk3300CBCEHLJJOGI_ = false;
                this.beginTime_ = 0;
                this.unk3300MDBDPIBEGGH_ = false;
                internalGetMutableWishGiftNumMap().clear();
                this.endTime_ = 0;
                this.expireCondList_ = ActivityInfo.emptyIntList();
                this.bitField0_ &= -65;
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
                result.unk3300MJNPGEKLOCG_ = this.unk3300MJNPGEKLOCG_;
                result.isFinished_ = this.isFinished_;
                result.curScore_ = this.curScore_;
                result.scheduleId_ = this.scheduleId_;
                result.scoreLimit_ = this.scoreLimit_;
                result.unk3300ICNJJKDHPCH_ = this.unk3300ICNJJKDHPCH_;
                if ((this.bitField0_ & 1) != 0) {
                    this.meetCondList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.meetCondList_ = this.meetCondList_;
                result.unk3300NEPKLLBJFKK_ = this.unk3300NEPKLLBJFKK_;
                if (this.watcherInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.watcherInfoList_ = Collections.unmodifiableList(this.watcherInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.watcherInfoList_ = this.watcherInfoList_;
                } else {
                    result.watcherInfoList_ = this.watcherInfoListBuilder_.build();
                }
                if (this.activityPushTipsDataListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.activityPushTipsDataList_ = Collections.unmodifiableList(this.activityPushTipsDataList_);
                        this.bitField0_ &= -5;
                    }
                    result.activityPushTipsDataList_ = this.activityPushTipsDataList_;
                } else {
                    result.activityPushTipsDataList_ = this.activityPushTipsDataListBuilder_.build();
                }
                result.activityId_ = this.activityId_;
                if ((this.bitField0_ & 8) != 0) {
                    this.takenRewardList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.takenRewardList_ = this.takenRewardList_;
                result.selectedAvatarRewardId_ = this.selectedAvatarRewardId_;
                result.activityCoinMap_ = internalGetActivityCoinMap();
                result.activityCoinMap_.makeImmutable();
                result.firstDayStartTime_ = this.firstDayStartTime_;
                result.unk3300ABJKLALKLDG_ = this.unk3300ABJKLALKLDG_;
                result.activityType_ = this.activityType_;
                result.unk3300CBCEHLJJOGI_ = this.unk3300CBCEHLJJOGI_;
                result.beginTime_ = this.beginTime_;
                result.unk3300MDBDPIBEGGH_ = this.unk3300MDBDPIBEGGH_;
                result.wishGiftNumMap_ = internalGetWishGiftNumMap();
                result.wishGiftNumMap_.makeImmutable();
                result.endTime_ = this.endTime_;
                if ((this.bitField0_ & 64) != 0) {
                    this.expireCondList_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.expireCondList_ = this.expireCondList_;
                if (this.detailCase_ == 2) {
                    if (this.samLampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.samLampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 15) {
                    if (this.crucibleInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.crucibleInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 9) {
                    if (this.salesmanInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.salesmanInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 4) {
                    if (this.trialAvatarInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.trialAvatarInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1141) {
                    if (this.deliveryInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.deliveryInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1977) {
                    if (this.asterInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.asterInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 2011) {
                    if (this.flightInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.flightInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1310) {
                    if (this.dragonSpineInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.dragonSpineInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1374) {
                    if (this.effigyInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1925) {
                    if (this.treasureMapInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.treasureMapInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1962) {
                    if (this.blessingInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.blessingInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 247) {
                    if (this.seaLampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.seaLampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1752) {
                    if (this.expeditionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.expeditionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 538) {
                    if (this.arenaChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.arenaChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1447) {
                    if (this.fleurFairInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fleurFairInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 635) {
                    if (this.waterSpiritInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.waterSpiritInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 846) {
                    if (this.channelerSlabInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.channelerSlabInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 432) {
                    if (this.mistTrialActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.mistTrialActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 839) {
                    if (this.hideAndSeekInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.hideAndSeekInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 378) {
                    if (this.findHilichurlInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.findHilichurlInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1910) {
                    if (this.summerTimeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.summerTimeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 686) {
                    if (this.buoyantCombatInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.buoyantCombatInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1162) {
                    if (this.echoShellInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.echoShellInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 922) {
                    if (this.bounceConjuringInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bounceConjuringInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 64) {
                    if (this.blitzRushInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.blitzRushInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1006) {
                    if (this.chessInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.chessInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 505) {
                    if (this.sumoInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.sumoInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 766) {
                    if (this.moonfinTrialInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.moonfinTrialInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1545) {
                    if (this.lunaRiteInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.lunaRiteInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1274) {
                    if (this.plantFlowerInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.plantFlowerInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1989) {
                    if (this.musicGameInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.musicGameInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 970) {
                    if (this.roguelikeDungeonInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.roguelikeDungeonInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1862) {
                    if (this.digInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.digInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 511) {
                    if (this.hachiInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.hachiInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 699) {
                    if (this.winterCampInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.winterCampInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1567) {
                    if (this.potionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.potionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1348) {
                    if (this.tanukiTravelActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.tanukiTravelActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 237) {
                    if (this.lanternRiteActivityInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.lanternRiteActivityInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1839) {
                    if (this.michiaeMatsuriInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.michiaeMatsuriInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 551) {
                    if (this.bartenderInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.bartenderInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1182) {
                    if (this.ugcInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.ugcInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 812) {
                    if (this.crystalLinkInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.crystalLinkInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1056) {
                    if (this.irodoriInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.irodoriInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1822) {
                    if (this.photoInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.photoInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 789) {
                    if (this.spiceInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.spiceInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1297) {
                    if (this.gachaInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gachaInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 444) {
                    if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.luminanceStoneChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 560) {
                    if (this.rogueDiaryInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.rogueDiaryInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 411) {
                    if (this.summerTimeV2InfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.summerTimeV2InfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 740) {
                    if (this.islandPartyInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.islandPartyInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1482) {
                    if (this.gearInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gearInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1928) {
                    if (this.gravenInnocenceInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.gravenInnocenceInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1145) {
                    if (this.instableSprayInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.instableSprayInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1662) {
                    if (this.muqadasPotionInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.muqadasPotionInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1032) {
                    if (this.treasureSeelieInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.treasureSeelieInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1265) {
                    if (this.rockBoardExploreInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.rockBoardExploreInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1308) {
                    if (this.vintageInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.vintageInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 468) {
                    if (this.windFieldInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.windFieldInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1757) {
                    if (this.fungusFighterInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.fungusFighterInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 621) {
                    if (this.charAmusementInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.charAmusementInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 233) {
                    if (this.effigyChallengeInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.effigyChallengeInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 2002) {
                    if (this.coinCollectInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.coinCollectInfoBuilder_.build();
                    }
                }
                if (this.detailCase_ == 1522) {
                    if (this.brickBreakerInfoBuilder_ == null) {
                        result.detail_ = this.detail_;
                    } else {
                        result.detail_ = this.brickBreakerInfoBuilder_.build();
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
                if (other.getUnk3300MJNPGEKLOCG()) {
                    setUnk3300MJNPGEKLOCG(other.getUnk3300MJNPGEKLOCG());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
                }
                if (other.getCurScore() != 0) {
                    setCurScore(other.getCurScore());
                }
                if (other.getScheduleId() != 0) {
                    setScheduleId(other.getScheduleId());
                }
                if (other.getScoreLimit() != 0) {
                    setScoreLimit(other.getScoreLimit());
                }
                if (other.getUnk3300ICNJJKDHPCH()) {
                    setUnk3300ICNJJKDHPCH(other.getUnk3300ICNJJKDHPCH());
                }
                if (!other.meetCondList_.isEmpty()) {
                    if (this.meetCondList_.isEmpty()) {
                        this.meetCondList_ = other.meetCondList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMeetCondListIsMutable();
                        this.meetCondList_.addAll(other.meetCondList_);
                    }
                    onChanged();
                }
                if (other.getUnk3300NEPKLLBJFKK()) {
                    setUnk3300NEPKLLBJFKK(other.getUnk3300NEPKLLBJFKK());
                }
                if (this.watcherInfoListBuilder_ == null) {
                    if (!other.watcherInfoList_.isEmpty()) {
                        if (this.watcherInfoList_.isEmpty()) {
                            this.watcherInfoList_ = other.watcherInfoList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.watcherInfoListBuilder_ = ActivityInfo.alwaysUseFieldBuilders ? getWatcherInfoListFieldBuilder() : null;
                    } else {
                        this.watcherInfoListBuilder_.addAllMessages(other.watcherInfoList_);
                    }
                }
                if (this.activityPushTipsDataListBuilder_ == null) {
                    if (!other.activityPushTipsDataList_.isEmpty()) {
                        if (this.activityPushTipsDataList_.isEmpty()) {
                            this.activityPushTipsDataList_ = other.activityPushTipsDataList_;
                            this.bitField0_ &= -5;
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
                        this.bitField0_ &= -5;
                        this.activityPushTipsDataListBuilder_ = ActivityInfo.alwaysUseFieldBuilders ? getActivityPushTipsDataListFieldBuilder() : null;
                    } else {
                        this.activityPushTipsDataListBuilder_.addAllMessages(other.activityPushTipsDataList_);
                    }
                }
                if (other.getActivityId() != 0) {
                    setActivityId(other.getActivityId());
                }
                if (!other.takenRewardList_.isEmpty()) {
                    if (this.takenRewardList_.isEmpty()) {
                        this.takenRewardList_ = other.takenRewardList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureTakenRewardListIsMutable();
                        this.takenRewardList_.addAll(other.takenRewardList_);
                    }
                    onChanged();
                }
                if (other.getSelectedAvatarRewardId() != 0) {
                    setSelectedAvatarRewardId(other.getSelectedAvatarRewardId());
                }
                internalGetMutableActivityCoinMap().mergeFrom(other.internalGetActivityCoinMap());
                if (other.getFirstDayStartTime() != 0) {
                    setFirstDayStartTime(other.getFirstDayStartTime());
                }
                if (other.getUnk3300ABJKLALKLDG()) {
                    setUnk3300ABJKLALKLDG(other.getUnk3300ABJKLALKLDG());
                }
                if (other.getActivityType() != 0) {
                    setActivityType(other.getActivityType());
                }
                if (other.getUnk3300CBCEHLJJOGI()) {
                    setUnk3300CBCEHLJJOGI(other.getUnk3300CBCEHLJJOGI());
                }
                if (other.getBeginTime() != 0) {
                    setBeginTime(other.getBeginTime());
                }
                if (other.getUnk3300MDBDPIBEGGH()) {
                    setUnk3300MDBDPIBEGGH(other.getUnk3300MDBDPIBEGGH());
                }
                internalGetMutableWishGiftNumMap().mergeFrom(other.internalGetWishGiftNumMap());
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (!other.expireCondList_.isEmpty()) {
                    if (this.expireCondList_.isEmpty()) {
                        this.expireCondList_ = other.expireCondList_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureExpireCondListIsMutable();
                        this.expireCondList_.addAll(other.expireCondList_);
                    }
                    onChanged();
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
                    case CHANNELER_SLAB_INFO:
                        mergeChannelerSlabInfo(other.getChannelerSlabInfo());
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
                    case ROGUELIKE_DUNGEON_INFO:
                        mergeRoguelikeDungeonInfo(other.getRoguelikeDungeonInfo());
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
                    case SUMMER_TIME_V2_INFO:
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

            private void ensureMeetCondListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.meetCondList_ = ActivityInfo.mutableCopy(this.meetCondList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getMeetCondListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.meetCondList_) : this.meetCondList_;
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
                this.bitField0_ &= -2;
                onChanged();
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

            private void ensureWatcherInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.watcherInfoList_ = new ArrayList(this.watcherInfoList_);
                    this.bitField0_ |= 2;
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
                    this.bitField0_ &= -3;
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
                    this.watcherInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.watcherInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.watcherInfoList_ = null;
                }
                return this.watcherInfoListBuilder_;
            }

            private void ensureActivityPushTipsDataListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.activityPushTipsDataList_ = new ArrayList(this.activityPushTipsDataList_);
                    this.bitField0_ |= 4;
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
                    this.bitField0_ &= -5;
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
                    this.activityPushTipsDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.activityPushTipsDataList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.activityPushTipsDataList_ = null;
                }
                return this.activityPushTipsDataListBuilder_;
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

            private void ensureTakenRewardListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.takenRewardList_ = ActivityInfo.mutableCopy(this.takenRewardList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getTakenRewardListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.takenRewardList_) : this.takenRewardList_;
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
                this.bitField0_ &= -9;
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

            private void ensureExpireCondListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.expireCondList_ = ActivityInfo.mutableCopy(this.expireCondList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public List<Integer> getExpireCondListList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.expireCondList_) : this.expireCondList_;
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
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSamLampInfo() {
                return this.detailCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo getSamLampInfo() {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ == 2) {
                        return (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_;
                    }
                    return SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 2) {
                    return this.samLampInfoBuilder_.getMessage();
                } else {
                    return SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setSamLampInfo(SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo value) {
                if (this.samLampInfoBuilder_ != null) {
                    this.samLampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder setSamLampInfo(SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.Builder builderForValue) {
                if (this.samLampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.samLampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder mergeSamLampInfo(SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo value) {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 2 || this.detail_ == SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.newBuilder((SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2) {
                        this.samLampInfoBuilder_.mergeFrom(value);
                    }
                    this.samLampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 2;
                return this;
            }

            public Builder clearSamLampInfo() {
                if (this.samLampInfoBuilder_ != null) {
                    if (this.detailCase_ == 2) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.samLampInfoBuilder_.clear();
                } else if (this.detailCase_ == 2) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.Builder getSamLampInfoBuilder() {
                return getSamLampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfoOrBuilder getSamLampInfoOrBuilder() {
                if (this.detailCase_ == 2 && this.samLampInfoBuilder_ != null) {
                    return this.samLampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2) {
                    return (SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_;
                }
                return SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo, SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.Builder, SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfoOrBuilder> getSamLampInfoFieldBuilder() {
                if (this.samLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 2) {
                        this.detail_ = SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo.getDefaultInstance();
                    }
                    this.samLampInfoBuilder_ = new SingleFieldBuilderV3<>((SeaLampActivityDetailInfoOuterClass.SeaLampActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 2;
                onChanged();
                return this.samLampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCrucibleInfo() {
                return this.detailCase_ == 15;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo getCrucibleInfo() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ == 15) {
                        return (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_;
                    }
                    return CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 15) {
                    return this.crucibleInfoBuilder_.getMessage();
                } else {
                    return CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setCrucibleInfo(CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo value) {
                if (this.crucibleInfoBuilder_ != null) {
                    this.crucibleInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 15;
                return this;
            }

            public Builder setCrucibleInfo(CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.Builder builderForValue) {
                if (this.crucibleInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crucibleInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 15;
                return this;
            }

            public Builder mergeCrucibleInfo(CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo value) {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ != 15 || this.detail_ == CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.newBuilder((CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 15) {
                        this.crucibleInfoBuilder_.mergeFrom(value);
                    }
                    this.crucibleInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 15;
                return this;
            }

            public Builder clearCrucibleInfo() {
                if (this.crucibleInfoBuilder_ != null) {
                    if (this.detailCase_ == 15) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.crucibleInfoBuilder_.clear();
                } else if (this.detailCase_ == 15) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.Builder getCrucibleInfoBuilder() {
                return getCrucibleInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder getCrucibleInfoOrBuilder() {
                if (this.detailCase_ == 15 && this.crucibleInfoBuilder_ != null) {
                    return this.crucibleInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 15) {
                    return (CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_;
                }
                return CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo, CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.Builder, CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfoOrBuilder> getCrucibleInfoFieldBuilder() {
                if (this.crucibleInfoBuilder_ == null) {
                    if (this.detailCase_ != 15) {
                        this.detail_ = CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo.getDefaultInstance();
                    }
                    this.crucibleInfoBuilder_ = new SingleFieldBuilderV3<>((CrucibleActivityDetailInfoOuterClass.CrucibleActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 15;
                onChanged();
                return this.crucibleInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSalesmanInfo() {
                return this.detailCase_ == 9;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo getSalesmanInfo() {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ == 9) {
                        return (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_;
                    }
                    return SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 9) {
                    return this.salesmanInfoBuilder_.getMessage();
                } else {
                    return SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setSalesmanInfo(SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo value) {
                if (this.salesmanInfoBuilder_ != null) {
                    this.salesmanInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder setSalesmanInfo(SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder builderForValue) {
                if (this.salesmanInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.salesmanInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder mergeSalesmanInfo(SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo value) {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ != 9 || this.detail_ == SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.newBuilder((SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 9) {
                        this.salesmanInfoBuilder_.mergeFrom(value);
                    }
                    this.salesmanInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 9;
                return this;
            }

            public Builder clearSalesmanInfo() {
                if (this.salesmanInfoBuilder_ != null) {
                    if (this.detailCase_ == 9) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.salesmanInfoBuilder_.clear();
                } else if (this.detailCase_ == 9) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder getSalesmanInfoBuilder() {
                return getSalesmanInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder getSalesmanInfoOrBuilder() {
                if (this.detailCase_ == 9 && this.salesmanInfoBuilder_ != null) {
                    return this.salesmanInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 9) {
                    return (SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_;
                }
                return SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo, SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.Builder, SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfoOrBuilder> getSalesmanInfoFieldBuilder() {
                if (this.salesmanInfoBuilder_ == null) {
                    if (this.detailCase_ != 9) {
                        this.detail_ = SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo.getDefaultInstance();
                    }
                    this.salesmanInfoBuilder_ = new SingleFieldBuilderV3<>((SalesmanActivityDetailInfoOuterClass.SalesmanActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 9;
                onChanged();
                return this.salesmanInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTrialAvatarInfo() {
                return this.detailCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo getTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ == 4) {
                        return (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_;
                    }
                    return TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 4) {
                    return this.trialAvatarInfoBuilder_.getMessage();
                } else {
                    return TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setTrialAvatarInfo(TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo value) {
                if (this.trialAvatarInfoBuilder_ != null) {
                    this.trialAvatarInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder setTrialAvatarInfo(TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.Builder builderForValue) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.trialAvatarInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder mergeTrialAvatarInfo(TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo value) {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ != 4 || this.detail_ == TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.newBuilder((TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 4) {
                        this.trialAvatarInfoBuilder_.mergeFrom(value);
                    }
                    this.trialAvatarInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 4;
                return this;
            }

            public Builder clearTrialAvatarInfo() {
                if (this.trialAvatarInfoBuilder_ != null) {
                    if (this.detailCase_ == 4) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.trialAvatarInfoBuilder_.clear();
                } else if (this.detailCase_ == 4) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.Builder getTrialAvatarInfoBuilder() {
                return getTrialAvatarInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder getTrialAvatarInfoOrBuilder() {
                if (this.detailCase_ == 4 && this.trialAvatarInfoBuilder_ != null) {
                    return this.trialAvatarInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 4) {
                    return (TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_;
                }
                return TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo, TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.Builder, TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfoOrBuilder> getTrialAvatarInfoFieldBuilder() {
                if (this.trialAvatarInfoBuilder_ == null) {
                    if (this.detailCase_ != 4) {
                        this.detail_ = TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo.getDefaultInstance();
                    }
                    this.trialAvatarInfoBuilder_ = new SingleFieldBuilderV3<>((TrialAvatarActivityDetailInfoOuterClass.TrialAvatarActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 4;
                onChanged();
                return this.trialAvatarInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDeliveryInfo() {
                return this.detailCase_ == 1141;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo getDeliveryInfo() {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ == 1141) {
                        return (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_;
                    }
                    return DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1141) {
                    return this.deliveryInfoBuilder_.getMessage();
                } else {
                    return DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setDeliveryInfo(DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo value) {
                if (this.deliveryInfoBuilder_ != null) {
                    this.deliveryInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.DELIVERY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setDeliveryInfo(DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.Builder builderForValue) {
                if (this.deliveryInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.deliveryInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.DELIVERY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeDeliveryInfo(DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo value) {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ != 1141 || this.detail_ == DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.newBuilder((DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1141) {
                        this.deliveryInfoBuilder_.mergeFrom(value);
                    }
                    this.deliveryInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.DELIVERY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearDeliveryInfo() {
                if (this.deliveryInfoBuilder_ != null) {
                    if (this.detailCase_ == 1141) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.deliveryInfoBuilder_.clear();
                } else if (this.detailCase_ == 1141) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.Builder getDeliveryInfoBuilder() {
                return getDeliveryInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder getDeliveryInfoOrBuilder() {
                if (this.detailCase_ == 1141 && this.deliveryInfoBuilder_ != null) {
                    return this.deliveryInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1141) {
                    return (DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_;
                }
                return DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo, DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.Builder, DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfoOrBuilder> getDeliveryInfoFieldBuilder() {
                if (this.deliveryInfoBuilder_ == null) {
                    if (this.detailCase_ != 1141) {
                        this.detail_ = DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo.getDefaultInstance();
                    }
                    this.deliveryInfoBuilder_ = new SingleFieldBuilderV3<>((DeliveryActivityDetailInfoOuterClass.DeliveryActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.DELIVERY_INFO_FIELD_NUMBER;
                onChanged();
                return this.deliveryInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasAsterInfo() {
                return this.detailCase_ == 1977;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo getAsterInfo() {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ == 1977) {
                        return (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_;
                    }
                    return AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1977) {
                    return this.asterInfoBuilder_.getMessage();
                } else {
                    return AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setAsterInfo(AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo value) {
                if (this.asterInfoBuilder_ != null) {
                    this.asterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1977;
                return this;
            }

            public Builder setAsterInfo(AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.Builder builderForValue) {
                if (this.asterInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.asterInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1977;
                return this;
            }

            public Builder mergeAsterInfo(AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo value) {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1977 || this.detail_ == AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.newBuilder((AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1977) {
                        this.asterInfoBuilder_.mergeFrom(value);
                    }
                    this.asterInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1977;
                return this;
            }

            public Builder clearAsterInfo() {
                if (this.asterInfoBuilder_ != null) {
                    if (this.detailCase_ == 1977) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.asterInfoBuilder_.clear();
                } else if (this.detailCase_ == 1977) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.Builder getAsterInfoBuilder() {
                return getAsterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder getAsterInfoOrBuilder() {
                if (this.detailCase_ == 1977 && this.asterInfoBuilder_ != null) {
                    return this.asterInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1977) {
                    return (AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_;
                }
                return AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo, AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.Builder, AsterActivityDetailInfoOuterClass.AsterActivityDetailInfoOrBuilder> getAsterInfoFieldBuilder() {
                if (this.asterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1977) {
                        this.detail_ = AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo.getDefaultInstance();
                    }
                    this.asterInfoBuilder_ = new SingleFieldBuilderV3<>((AsterActivityDetailInfoOuterClass.AsterActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1977;
                onChanged();
                return this.asterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFlightInfo() {
                return this.detailCase_ == 2011;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo getFlightInfo() {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ == 2011) {
                        return (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_;
                    }
                    return FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 2011) {
                    return this.flightInfoBuilder_.getMessage();
                } else {
                    return FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setFlightInfo(FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo value) {
                if (this.flightInfoBuilder_ != null) {
                    this.flightInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 2011;
                return this;
            }

            public Builder setFlightInfo(FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.Builder builderForValue) {
                if (this.flightInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.flightInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 2011;
                return this;
            }

            public Builder mergeFlightInfo(FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo value) {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ != 2011 || this.detail_ == FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.newBuilder((FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2011) {
                        this.flightInfoBuilder_.mergeFrom(value);
                    }
                    this.flightInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 2011;
                return this;
            }

            public Builder clearFlightInfo() {
                if (this.flightInfoBuilder_ != null) {
                    if (this.detailCase_ == 2011) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.flightInfoBuilder_.clear();
                } else if (this.detailCase_ == 2011) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.Builder getFlightInfoBuilder() {
                return getFlightInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder getFlightInfoOrBuilder() {
                if (this.detailCase_ == 2011 && this.flightInfoBuilder_ != null) {
                    return this.flightInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2011) {
                    return (FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_;
                }
                return FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo, FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.Builder, FlightActivityDetailInfoOuterClass.FlightActivityDetailInfoOrBuilder> getFlightInfoFieldBuilder() {
                if (this.flightInfoBuilder_ == null) {
                    if (this.detailCase_ != 2011) {
                        this.detail_ = FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo.getDefaultInstance();
                    }
                    this.flightInfoBuilder_ = new SingleFieldBuilderV3<>((FlightActivityDetailInfoOuterClass.FlightActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 2011;
                onChanged();
                return this.flightInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDragonSpineInfo() {
                return this.detailCase_ == 1310;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo getDragonSpineInfo() {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ == 1310) {
                        return (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_;
                    }
                    return DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1310) {
                    return this.dragonSpineInfoBuilder_.getMessage();
                } else {
                    return DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setDragonSpineInfo(DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo value) {
                if (this.dragonSpineInfoBuilder_ != null) {
                    this.dragonSpineInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1310;
                return this;
            }

            public Builder setDragonSpineInfo(DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.Builder builderForValue) {
                if (this.dragonSpineInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dragonSpineInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1310;
                return this;
            }

            public Builder mergeDragonSpineInfo(DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo value) {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ != 1310 || this.detail_ == DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.newBuilder((DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1310) {
                        this.dragonSpineInfoBuilder_.mergeFrom(value);
                    }
                    this.dragonSpineInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1310;
                return this;
            }

            public Builder clearDragonSpineInfo() {
                if (this.dragonSpineInfoBuilder_ != null) {
                    if (this.detailCase_ == 1310) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.dragonSpineInfoBuilder_.clear();
                } else if (this.detailCase_ == 1310) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.Builder getDragonSpineInfoBuilder() {
                return getDragonSpineInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder getDragonSpineInfoOrBuilder() {
                if (this.detailCase_ == 1310 && this.dragonSpineInfoBuilder_ != null) {
                    return this.dragonSpineInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1310) {
                    return (DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_;
                }
                return DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo, DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.Builder, DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder> getDragonSpineInfoFieldBuilder() {
                if (this.dragonSpineInfoBuilder_ == null) {
                    if (this.detailCase_ != 1310) {
                        this.detail_ = DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.getDefaultInstance();
                    }
                    this.dragonSpineInfoBuilder_ = new SingleFieldBuilderV3<>((DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1310;
                onChanged();
                return this.dragonSpineInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEffigyInfo() {
                return this.detailCase_ == 1374;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo getEffigyInfo() {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ == 1374) {
                        return (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_;
                    }
                    return EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1374) {
                    return this.effigyInfoBuilder_.getMessage();
                } else {
                    return EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyInfo(EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo value) {
                if (this.effigyInfoBuilder_ != null) {
                    this.effigyInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.EFFIGY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setEffigyInfo(EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.Builder builderForValue) {
                if (this.effigyInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.EFFIGY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeEffigyInfo(EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo value) {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1374 || this.detail_ == EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.newBuilder((EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1374) {
                        this.effigyInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.EFFIGY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearEffigyInfo() {
                if (this.effigyInfoBuilder_ != null) {
                    if (this.detailCase_ == 1374) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyInfoBuilder_.clear();
                } else if (this.detailCase_ == 1374) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.Builder getEffigyInfoBuilder() {
                return getEffigyInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfoOrBuilder getEffigyInfoOrBuilder() {
                if (this.detailCase_ == 1374 && this.effigyInfoBuilder_ != null) {
                    return this.effigyInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1374) {
                    return (EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_;
                }
                return EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo, EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.Builder, EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfoOrBuilder> getEffigyInfoFieldBuilder() {
                if (this.effigyInfoBuilder_ == null) {
                    if (this.detailCase_ != 1374) {
                        this.detail_ = EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo.getDefaultInstance();
                    }
                    this.effigyInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyActivityDetailInfoOuterClass.EffigyActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.EFFIGY_INFO_FIELD_NUMBER;
                onChanged();
                return this.effigyInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTreasureMapInfo() {
                return this.detailCase_ == 1925;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo getTreasureMapInfo() {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ == 1925) {
                        return (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_;
                    }
                    return TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1925) {
                    return this.treasureMapInfoBuilder_.getMessage();
                } else {
                    return TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setTreasureMapInfo(TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo value) {
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

            public Builder setTreasureMapInfo(TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.Builder builderForValue) {
                if (this.treasureMapInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.treasureMapInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTreasureMapInfo(TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo value) {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ != 1925 || this.detail_ == TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.newBuilder((TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1925) {
                        this.treasureMapInfoBuilder_.mergeFrom(value);
                    }
                    this.treasureMapInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTreasureMapInfo() {
                if (this.treasureMapInfoBuilder_ != null) {
                    if (this.detailCase_ == 1925) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.treasureMapInfoBuilder_.clear();
                } else if (this.detailCase_ == 1925) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.Builder getTreasureMapInfoBuilder() {
                return getTreasureMapInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder getTreasureMapInfoOrBuilder() {
                if (this.detailCase_ == 1925 && this.treasureMapInfoBuilder_ != null) {
                    return this.treasureMapInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1925) {
                    return (TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_;
                }
                return TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo, TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.Builder, TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfoOrBuilder> getTreasureMapInfoFieldBuilder() {
                if (this.treasureMapInfoBuilder_ == null) {
                    if (this.detailCase_ != 1925) {
                        this.detail_ = TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo.getDefaultInstance();
                    }
                    this.treasureMapInfoBuilder_ = new SingleFieldBuilderV3<>((TreasureMapActivityDetailInfoOuterClass.TreasureMapActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TREASURE_MAP_INFO_FIELD_NUMBER;
                onChanged();
                return this.treasureMapInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBlessingInfo() {
                return this.detailCase_ == 1962;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo getBlessingInfo() {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ == 1962) {
                        return (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_;
                    }
                    return BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1962) {
                    return this.blessingInfoBuilder_.getMessage();
                } else {
                    return BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBlessingInfo(BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo value) {
                if (this.blessingInfoBuilder_ != null) {
                    this.blessingInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1962;
                return this;
            }

            public Builder setBlessingInfo(BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder builderForValue) {
                if (this.blessingInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blessingInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1962;
                return this;
            }

            public Builder mergeBlessingInfo(BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo value) {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ != 1962 || this.detail_ == BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.newBuilder((BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1962) {
                        this.blessingInfoBuilder_.mergeFrom(value);
                    }
                    this.blessingInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1962;
                return this;
            }

            public Builder clearBlessingInfo() {
                if (this.blessingInfoBuilder_ != null) {
                    if (this.detailCase_ == 1962) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.blessingInfoBuilder_.clear();
                } else if (this.detailCase_ == 1962) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder getBlessingInfoBuilder() {
                return getBlessingInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder getBlessingInfoOrBuilder() {
                if (this.detailCase_ == 1962 && this.blessingInfoBuilder_ != null) {
                    return this.blessingInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1962) {
                    return (BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_;
                }
                return BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo, BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.Builder, BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfoOrBuilder> getBlessingInfoFieldBuilder() {
                if (this.blessingInfoBuilder_ == null) {
                    if (this.detailCase_ != 1962) {
                        this.detail_ = BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo.getDefaultInstance();
                    }
                    this.blessingInfoBuilder_ = new SingleFieldBuilderV3<>((BlessingActivityDetailInfoOuterClass.BlessingActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1962;
                onChanged();
                return this.blessingInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSeaLampInfo() {
                return this.detailCase_ == 247;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampActivityInfoOuterClass.SeaLampActivityInfo getSeaLampInfo() {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ == 247) {
                        return (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_;
                    }
                    return SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
                } else if (this.detailCase_ == 247) {
                    return this.seaLampInfoBuilder_.getMessage();
                } else {
                    return SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
                }
            }

            public Builder setSeaLampInfo(SeaLampActivityInfoOuterClass.SeaLampActivityInfo value) {
                if (this.seaLampInfoBuilder_ != null) {
                    this.seaLampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 247;
                return this;
            }

            public Builder setSeaLampInfo(SeaLampActivityInfoOuterClass.SeaLampActivityInfo.Builder builderForValue) {
                if (this.seaLampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.seaLampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 247;
                return this;
            }

            public Builder mergeSeaLampInfo(SeaLampActivityInfoOuterClass.SeaLampActivityInfo value) {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 247 || this.detail_ == SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SeaLampActivityInfoOuterClass.SeaLampActivityInfo.newBuilder((SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 247) {
                        this.seaLampInfoBuilder_.mergeFrom(value);
                    }
                    this.seaLampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 247;
                return this;
            }

            public Builder clearSeaLampInfo() {
                if (this.seaLampInfoBuilder_ != null) {
                    if (this.detailCase_ == 247) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.seaLampInfoBuilder_.clear();
                } else if (this.detailCase_ == 247) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SeaLampActivityInfoOuterClass.SeaLampActivityInfo.Builder getSeaLampInfoBuilder() {
                return getSeaLampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder getSeaLampInfoOrBuilder() {
                if (this.detailCase_ == 247 && this.seaLampInfoBuilder_ != null) {
                    return this.seaLampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 247) {
                    return (SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_;
                }
                return SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SeaLampActivityInfoOuterClass.SeaLampActivityInfo, SeaLampActivityInfoOuterClass.SeaLampActivityInfo.Builder, SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder> getSeaLampInfoFieldBuilder() {
                if (this.seaLampInfoBuilder_ == null) {
                    if (this.detailCase_ != 247) {
                        this.detail_ = SeaLampActivityInfoOuterClass.SeaLampActivityInfo.getDefaultInstance();
                    }
                    this.seaLampInfoBuilder_ = new SingleFieldBuilderV3<>((SeaLampActivityInfoOuterClass.SeaLampActivityInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 247;
                onChanged();
                return this.seaLampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasExpeditionInfo() {
                return this.detailCase_ == 1752;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo getExpeditionInfo() {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ == 1752) {
                        return (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_;
                    }
                    return ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1752) {
                    return this.expeditionInfoBuilder_.getMessage();
                } else {
                    return ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setExpeditionInfo(ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo value) {
                if (this.expeditionInfoBuilder_ != null) {
                    this.expeditionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setExpeditionInfo(ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.Builder builderForValue) {
                if (this.expeditionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.expeditionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeExpeditionInfo(ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo value) {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1752 || this.detail_ == ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.newBuilder((ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1752) {
                        this.expeditionInfoBuilder_.mergeFrom(value);
                    }
                    this.expeditionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearExpeditionInfo() {
                if (this.expeditionInfoBuilder_ != null) {
                    if (this.detailCase_ == 1752) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.expeditionInfoBuilder_.clear();
                } else if (this.detailCase_ == 1752) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.Builder getExpeditionInfoBuilder() {
                return getExpeditionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder getExpeditionInfoOrBuilder() {
                if (this.detailCase_ == 1752 && this.expeditionInfoBuilder_ != null) {
                    return this.expeditionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1752) {
                    return (ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_;
                }
                return ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo, ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.Builder, ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfoOrBuilder> getExpeditionInfoFieldBuilder() {
                if (this.expeditionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1752) {
                        this.detail_ = ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo.getDefaultInstance();
                    }
                    this.expeditionInfoBuilder_ = new SingleFieldBuilderV3<>((ExpeditionActivityDetailInfoOuterClass.ExpeditionActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.EXPEDITION_INFO_FIELD_NUMBER;
                onChanged();
                return this.expeditionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasArenaChallengeInfo() {
                return this.detailCase_ == 538;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo getArenaChallengeInfo() {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 538) {
                        return (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_;
                    }
                    return ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 538) {
                    return this.arenaChallengeInfoBuilder_.getMessage();
                } else {
                    return ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setArenaChallengeInfo(ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo value) {
                if (this.arenaChallengeInfoBuilder_ != null) {
                    this.arenaChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setArenaChallengeInfo(ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.Builder builderForValue) {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.arenaChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeArenaChallengeInfo(ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo value) {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 538 || this.detail_ == ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.newBuilder((ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 538) {
                        this.arenaChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.arenaChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearArenaChallengeInfo() {
                if (this.arenaChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 538) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.arenaChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 538) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.Builder getArenaChallengeInfoBuilder() {
                return getArenaChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfoOrBuilder getArenaChallengeInfoOrBuilder() {
                if (this.detailCase_ == 538 && this.arenaChallengeInfoBuilder_ != null) {
                    return this.arenaChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 538) {
                    return (ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_;
                }
                return ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo, ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.Builder, ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfoOrBuilder> getArenaChallengeInfoFieldBuilder() {
                if (this.arenaChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 538) {
                        this.detail_ = ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo.getDefaultInstance();
                    }
                    this.arenaChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((ArenaChallengeActivityDetailInfoOuterClass.ArenaChallengeActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ARENA_CHALLENGE_INFO_FIELD_NUMBER;
                onChanged();
                return this.arenaChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFleurFairInfo() {
                return this.detailCase_ == 1447;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo getFleurFairInfo() {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ == 1447) {
                        return (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_;
                    }
                    return FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1447) {
                    return this.fleurFairInfoBuilder_.getMessage();
                } else {
                    return FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setFleurFairInfo(FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo value) {
                if (this.fleurFairInfoBuilder_ != null) {
                    this.fleurFairInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1447;
                return this;
            }

            public Builder setFleurFairInfo(FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder builderForValue) {
                if (this.fleurFairInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fleurFairInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1447;
                return this;
            }

            public Builder mergeFleurFairInfo(FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo value) {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ != 1447 || this.detail_ == FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.newBuilder((FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1447) {
                        this.fleurFairInfoBuilder_.mergeFrom(value);
                    }
                    this.fleurFairInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1447;
                return this;
            }

            public Builder clearFleurFairInfo() {
                if (this.fleurFairInfoBuilder_ != null) {
                    if (this.detailCase_ == 1447) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fleurFairInfoBuilder_.clear();
                } else if (this.detailCase_ == 1447) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder getFleurFairInfoBuilder() {
                return getFleurFairInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder getFleurFairInfoOrBuilder() {
                if (this.detailCase_ == 1447 && this.fleurFairInfoBuilder_ != null) {
                    return this.fleurFairInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1447) {
                    return (FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_;
                }
                return FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo, FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.Builder, FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfoOrBuilder> getFleurFairInfoFieldBuilder() {
                if (this.fleurFairInfoBuilder_ == null) {
                    if (this.detailCase_ != 1447) {
                        this.detail_ = FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo.getDefaultInstance();
                    }
                    this.fleurFairInfoBuilder_ = new SingleFieldBuilderV3<>((FleurFairActivityDetailInfoOuterClass.FleurFairActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1447;
                onChanged();
                return this.fleurFairInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWaterSpiritInfo() {
                return this.detailCase_ == 635;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo getWaterSpiritInfo() {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ == 635) {
                        return (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_;
                    }
                    return WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 635) {
                    return this.waterSpiritInfoBuilder_.getMessage();
                } else {
                    return WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setWaterSpiritInfo(WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo value) {
                if (this.waterSpiritInfoBuilder_ != null) {
                    this.waterSpiritInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 635;
                return this;
            }

            public Builder setWaterSpiritInfo(WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.Builder builderForValue) {
                if (this.waterSpiritInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.waterSpiritInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 635;
                return this;
            }

            public Builder mergeWaterSpiritInfo(WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo value) {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ != 635 || this.detail_ == WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.newBuilder((WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 635) {
                        this.waterSpiritInfoBuilder_.mergeFrom(value);
                    }
                    this.waterSpiritInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 635;
                return this;
            }

            public Builder clearWaterSpiritInfo() {
                if (this.waterSpiritInfoBuilder_ != null) {
                    if (this.detailCase_ == 635) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.waterSpiritInfoBuilder_.clear();
                } else if (this.detailCase_ == 635) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.Builder getWaterSpiritInfoBuilder() {
                return getWaterSpiritInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfoOrBuilder getWaterSpiritInfoOrBuilder() {
                if (this.detailCase_ == 635 && this.waterSpiritInfoBuilder_ != null) {
                    return this.waterSpiritInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 635) {
                    return (WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_;
                }
                return WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo, WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.Builder, WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfoOrBuilder> getWaterSpiritInfoFieldBuilder() {
                if (this.waterSpiritInfoBuilder_ == null) {
                    if (this.detailCase_ != 635) {
                        this.detail_ = WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo.getDefaultInstance();
                    }
                    this.waterSpiritInfoBuilder_ = new SingleFieldBuilderV3<>((WaterSpiritActivityDetailInfoOuterClass.WaterSpiritActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 635;
                onChanged();
                return this.waterSpiritInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasChannelerSlabInfo() {
                return this.detailCase_ == 846;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo getChannelerSlabInfo() {
                if (this.channelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ == 846) {
                        return (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_;
                    }
                    return ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 846) {
                    return this.channelerSlabInfoBuilder_.getMessage();
                } else {
                    return ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setChannelerSlabInfo(ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo value) {
                if (this.channelerSlabInfoBuilder_ != null) {
                    this.channelerSlabInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 846;
                return this;
            }

            public Builder setChannelerSlabInfo(ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.Builder builderForValue) {
                if (this.channelerSlabInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.channelerSlabInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 846;
                return this;
            }

            public Builder mergeChannelerSlabInfo(ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo value) {
                if (this.channelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ != 846 || this.detail_ == ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.newBuilder((ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 846) {
                        this.channelerSlabInfoBuilder_.mergeFrom(value);
                    }
                    this.channelerSlabInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 846;
                return this;
            }

            public Builder clearChannelerSlabInfo() {
                if (this.channelerSlabInfoBuilder_ != null) {
                    if (this.detailCase_ == 846) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.channelerSlabInfoBuilder_.clear();
                } else if (this.detailCase_ == 846) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.Builder getChannelerSlabInfoBuilder() {
                return getChannelerSlabInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfoOrBuilder getChannelerSlabInfoOrBuilder() {
                if (this.detailCase_ == 846 && this.channelerSlabInfoBuilder_ != null) {
                    return this.channelerSlabInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 846) {
                    return (ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_;
                }
                return ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo, ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.Builder, ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfoOrBuilder> getChannelerSlabInfoFieldBuilder() {
                if (this.channelerSlabInfoBuilder_ == null) {
                    if (this.detailCase_ != 846) {
                        this.detail_ = ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo.getDefaultInstance();
                    }
                    this.channelerSlabInfoBuilder_ = new SingleFieldBuilderV3<>((ChannelerSlabActivityDetailInfoOuterClass.ChannelerSlabActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 846;
                onChanged();
                return this.channelerSlabInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMistTrialActivityInfo() {
                return this.detailCase_ == 432;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo getMistTrialActivityInfo() {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 432) {
                        return (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_;
                    }
                    return MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 432) {
                    return this.mistTrialActivityInfoBuilder_.getMessage();
                } else {
                    return MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setMistTrialActivityInfo(MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo value) {
                if (this.mistTrialActivityInfoBuilder_ != null) {
                    this.mistTrialActivityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setMistTrialActivityInfo(MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.Builder builderForValue) {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.mistTrialActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeMistTrialActivityInfo(MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo value) {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 432 || this.detail_ == MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.newBuilder((MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 432) {
                        this.mistTrialActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.mistTrialActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearMistTrialActivityInfo() {
                if (this.mistTrialActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 432) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.mistTrialActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 432) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.Builder getMistTrialActivityInfoBuilder() {
                return getMistTrialActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder getMistTrialActivityInfoOrBuilder() {
                if (this.detailCase_ == 432 && this.mistTrialActivityInfoBuilder_ != null) {
                    return this.mistTrialActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 432) {
                    return (MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_;
                }
                return MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo, MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.Builder, MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfoOrBuilder> getMistTrialActivityInfoFieldBuilder() {
                if (this.mistTrialActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 432) {
                        this.detail_ = MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo.getDefaultInstance();
                    }
                    this.mistTrialActivityInfoBuilder_ = new SingleFieldBuilderV3<>((MistTrialActivityDetailInfoOuterClass.MistTrialActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.MIST_TRIAL_ACTIVITY_INFO_FIELD_NUMBER;
                onChanged();
                return this.mistTrialActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasHideAndSeekInfo() {
                return this.detailCase_ == 839;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo getHideAndSeekInfo() {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ == 839) {
                        return (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_;
                    }
                    return HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 839) {
                    return this.hideAndSeekInfoBuilder_.getMessage();
                } else {
                    return HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setHideAndSeekInfo(HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo value) {
                if (this.hideAndSeekInfoBuilder_ != null) {
                    this.hideAndSeekInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 839;
                return this;
            }

            public Builder setHideAndSeekInfo(HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.Builder builderForValue) {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hideAndSeekInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 839;
                return this;
            }

            public Builder mergeHideAndSeekInfo(HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo value) {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ != 839 || this.detail_ == HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.newBuilder((HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 839) {
                        this.hideAndSeekInfoBuilder_.mergeFrom(value);
                    }
                    this.hideAndSeekInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 839;
                return this;
            }

            public Builder clearHideAndSeekInfo() {
                if (this.hideAndSeekInfoBuilder_ != null) {
                    if (this.detailCase_ == 839) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.hideAndSeekInfoBuilder_.clear();
                } else if (this.detailCase_ == 839) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.Builder getHideAndSeekInfoBuilder() {
                return getHideAndSeekInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder getHideAndSeekInfoOrBuilder() {
                if (this.detailCase_ == 839 && this.hideAndSeekInfoBuilder_ != null) {
                    return this.hideAndSeekInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 839) {
                    return (HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_;
                }
                return HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo, HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.Builder, HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder> getHideAndSeekInfoFieldBuilder() {
                if (this.hideAndSeekInfoBuilder_ == null) {
                    if (this.detailCase_ != 839) {
                        this.detail_ = HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.getDefaultInstance();
                    }
                    this.hideAndSeekInfoBuilder_ = new SingleFieldBuilderV3<>((HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 839;
                onChanged();
                return this.hideAndSeekInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFindHilichurlInfo() {
                return this.detailCase_ == 378;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo getFindHilichurlInfo() {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ == 378) {
                        return (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_;
                    }
                    return FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 378) {
                    return this.findHilichurlInfoBuilder_.getMessage();
                } else {
                    return FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
                }
            }

            public Builder setFindHilichurlInfo(FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo value) {
                if (this.findHilichurlInfoBuilder_ != null) {
                    this.findHilichurlInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder setFindHilichurlInfo(FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.Builder builderForValue) {
                if (this.findHilichurlInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.findHilichurlInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder mergeFindHilichurlInfo(FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo value) {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ != 378 || this.detail_ == FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.newBuilder((FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 378) {
                        this.findHilichurlInfoBuilder_.mergeFrom(value);
                    }
                    this.findHilichurlInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 378;
                return this;
            }

            public Builder clearFindHilichurlInfo() {
                if (this.findHilichurlInfoBuilder_ != null) {
                    if (this.detailCase_ == 378) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.findHilichurlInfoBuilder_.clear();
                } else if (this.detailCase_ == 378) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.Builder getFindHilichurlInfoBuilder() {
                return getFindHilichurlInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder getFindHilichurlInfoOrBuilder() {
                if (this.detailCase_ == 378 && this.findHilichurlInfoBuilder_ != null) {
                    return this.findHilichurlInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 378) {
                    return (FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_;
                }
                return FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo, FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.Builder, FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfoOrBuilder> getFindHilichurlInfoFieldBuilder() {
                if (this.findHilichurlInfoBuilder_ == null) {
                    if (this.detailCase_ != 378) {
                        this.detail_ = FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo.getDefaultInstance();
                    }
                    this.findHilichurlInfoBuilder_ = new SingleFieldBuilderV3<>((FindHilichurlDetailInfoOuterClass.FindHilichurlDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 378;
                onChanged();
                return this.findHilichurlInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSummerTimeInfo() {
                return this.detailCase_ == 1910;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo getSummerTimeInfo() {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ == 1910) {
                        return (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_;
                    }
                    return SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1910) {
                    return this.summerTimeInfoBuilder_.getMessage();
                } else {
                    return SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
                }
            }

            public Builder setSummerTimeInfo(SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo value) {
                if (this.summerTimeInfoBuilder_ != null) {
                    this.summerTimeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1910;
                return this;
            }

            public Builder setSummerTimeInfo(SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder builderForValue) {
                if (this.summerTimeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.summerTimeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1910;
                return this;
            }

            public Builder mergeSummerTimeInfo(SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo value) {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1910 || this.detail_ == SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.newBuilder((SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1910) {
                        this.summerTimeInfoBuilder_.mergeFrom(value);
                    }
                    this.summerTimeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1910;
                return this;
            }

            public Builder clearSummerTimeInfo() {
                if (this.summerTimeInfoBuilder_ != null) {
                    if (this.detailCase_ == 1910) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.summerTimeInfoBuilder_.clear();
                } else if (this.detailCase_ == 1910) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder getSummerTimeInfoBuilder() {
                return getSummerTimeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder getSummerTimeInfoOrBuilder() {
                if (this.detailCase_ == 1910 && this.summerTimeInfoBuilder_ != null) {
                    return this.summerTimeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1910) {
                    return (SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_;
                }
                return SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo, SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.Builder, SummerTimeDetailInfoOuterClass.SummerTimeDetailInfoOrBuilder> getSummerTimeInfoFieldBuilder() {
                if (this.summerTimeInfoBuilder_ == null) {
                    if (this.detailCase_ != 1910) {
                        this.detail_ = SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo.getDefaultInstance();
                    }
                    this.summerTimeInfoBuilder_ = new SingleFieldBuilderV3<>((SummerTimeDetailInfoOuterClass.SummerTimeDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1910;
                onChanged();
                return this.summerTimeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBuoyantCombatInfo() {
                return this.detailCase_ == 686;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo getBuoyantCombatInfo() {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ == 686) {
                        return (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_;
                    }
                    return BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 686) {
                    return this.buoyantCombatInfoBuilder_.getMessage();
                } else {
                    return BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBuoyantCombatInfo(BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo value) {
                if (this.buoyantCombatInfoBuilder_ != null) {
                    this.buoyantCombatInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 686;
                return this;
            }

            public Builder setBuoyantCombatInfo(BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.Builder builderForValue) {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.buoyantCombatInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 686;
                return this;
            }

            public Builder mergeBuoyantCombatInfo(BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo value) {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ != 686 || this.detail_ == BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.newBuilder((BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 686) {
                        this.buoyantCombatInfoBuilder_.mergeFrom(value);
                    }
                    this.buoyantCombatInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 686;
                return this;
            }

            public Builder clearBuoyantCombatInfo() {
                if (this.buoyantCombatInfoBuilder_ != null) {
                    if (this.detailCase_ == 686) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.buoyantCombatInfoBuilder_.clear();
                } else if (this.detailCase_ == 686) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.Builder getBuoyantCombatInfoBuilder() {
                return getBuoyantCombatInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder getBuoyantCombatInfoOrBuilder() {
                if (this.detailCase_ == 686 && this.buoyantCombatInfoBuilder_ != null) {
                    return this.buoyantCombatInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 686) {
                    return (BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_;
                }
                return BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo, BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.Builder, BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfoOrBuilder> getBuoyantCombatInfoFieldBuilder() {
                if (this.buoyantCombatInfoBuilder_ == null) {
                    if (this.detailCase_ != 686) {
                        this.detail_ = BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo.getDefaultInstance();
                    }
                    this.buoyantCombatInfoBuilder_ = new SingleFieldBuilderV3<>((BuoyantCombatDetailInfoOuterClass.BuoyantCombatDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 686;
                onChanged();
                return this.buoyantCombatInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEchoShellInfo() {
                return this.detailCase_ == 1162;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EchoShellDetailInfoOuterClass.EchoShellDetailInfo getEchoShellInfo() {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ == 1162) {
                        return (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_;
                    }
                    return EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1162) {
                    return this.echoShellInfoBuilder_.getMessage();
                } else {
                    return EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
                }
            }

            public Builder setEchoShellInfo(EchoShellDetailInfoOuterClass.EchoShellDetailInfo value) {
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

            public Builder setEchoShellInfo(EchoShellDetailInfoOuterClass.EchoShellDetailInfo.Builder builderForValue) {
                if (this.echoShellInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.echoShellInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeEchoShellInfo(EchoShellDetailInfoOuterClass.EchoShellDetailInfo value) {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ != 1162 || this.detail_ == EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EchoShellDetailInfoOuterClass.EchoShellDetailInfo.newBuilder((EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1162) {
                        this.echoShellInfoBuilder_.mergeFrom(value);
                    }
                    this.echoShellInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearEchoShellInfo() {
                if (this.echoShellInfoBuilder_ != null) {
                    if (this.detailCase_ == 1162) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.echoShellInfoBuilder_.clear();
                } else if (this.detailCase_ == 1162) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EchoShellDetailInfoOuterClass.EchoShellDetailInfo.Builder getEchoShellInfoBuilder() {
                return getEchoShellInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder getEchoShellInfoOrBuilder() {
                if (this.detailCase_ == 1162 && this.echoShellInfoBuilder_ != null) {
                    return this.echoShellInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1162) {
                    return (EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_;
                }
                return EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EchoShellDetailInfoOuterClass.EchoShellDetailInfo, EchoShellDetailInfoOuterClass.EchoShellDetailInfo.Builder, EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder> getEchoShellInfoFieldBuilder() {
                if (this.echoShellInfoBuilder_ == null) {
                    if (this.detailCase_ != 1162) {
                        this.detail_ = EchoShellDetailInfoOuterClass.EchoShellDetailInfo.getDefaultInstance();
                    }
                    this.echoShellInfoBuilder_ = new SingleFieldBuilderV3<>((EchoShellDetailInfoOuterClass.EchoShellDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ECHO_SHELL_INFO_FIELD_NUMBER;
                onChanged();
                return this.echoShellInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBounceConjuringInfo() {
                return this.detailCase_ == 922;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo getBounceConjuringInfo() {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ == 922) {
                        return (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_;
                    }
                    return BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 922) {
                    return this.bounceConjuringInfoBuilder_.getMessage();
                } else {
                    return BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBounceConjuringInfo(BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo value) {
                if (this.bounceConjuringInfoBuilder_ != null) {
                    this.bounceConjuringInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 922;
                return this;
            }

            public Builder setBounceConjuringInfo(BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.Builder builderForValue) {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bounceConjuringInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 922;
                return this;
            }

            public Builder mergeBounceConjuringInfo(BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo value) {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ != 922 || this.detail_ == BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.newBuilder((BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 922) {
                        this.bounceConjuringInfoBuilder_.mergeFrom(value);
                    }
                    this.bounceConjuringInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 922;
                return this;
            }

            public Builder clearBounceConjuringInfo() {
                if (this.bounceConjuringInfoBuilder_ != null) {
                    if (this.detailCase_ == 922) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bounceConjuringInfoBuilder_.clear();
                } else if (this.detailCase_ == 922) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.Builder getBounceConjuringInfoBuilder() {
                return getBounceConjuringInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder getBounceConjuringInfoOrBuilder() {
                if (this.detailCase_ == 922 && this.bounceConjuringInfoBuilder_ != null) {
                    return this.bounceConjuringInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 922) {
                    return (BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_;
                }
                return BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo, BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.Builder, BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfoOrBuilder> getBounceConjuringInfoFieldBuilder() {
                if (this.bounceConjuringInfoBuilder_ == null) {
                    if (this.detailCase_ != 922) {
                        this.detail_ = BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo.getDefaultInstance();
                    }
                    this.bounceConjuringInfoBuilder_ = new SingleFieldBuilderV3<>((BounceConjuringActivityDetailInfoOuterClass.BounceConjuringActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 922;
                onChanged();
                return this.bounceConjuringInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBlitzRushInfo() {
                return this.detailCase_ == 64;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo getBlitzRushInfo() {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ == 64) {
                        return (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_;
                    }
                    return BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 64) {
                    return this.blitzRushInfoBuilder_.getMessage();
                } else {
                    return BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBlitzRushInfo(BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo value) {
                if (this.blitzRushInfoBuilder_ != null) {
                    this.blitzRushInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 64;
                return this;
            }

            public Builder setBlitzRushInfo(BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.Builder builderForValue) {
                if (this.blitzRushInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.blitzRushInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 64;
                return this;
            }

            public Builder mergeBlitzRushInfo(BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo value) {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ != 64 || this.detail_ == BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.newBuilder((BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 64) {
                        this.blitzRushInfoBuilder_.mergeFrom(value);
                    }
                    this.blitzRushInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 64;
                return this;
            }

            public Builder clearBlitzRushInfo() {
                if (this.blitzRushInfoBuilder_ != null) {
                    if (this.detailCase_ == 64) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.blitzRushInfoBuilder_.clear();
                } else if (this.detailCase_ == 64) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.Builder getBlitzRushInfoBuilder() {
                return getBlitzRushInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder getBlitzRushInfoOrBuilder() {
                if (this.detailCase_ == 64 && this.blitzRushInfoBuilder_ != null) {
                    return this.blitzRushInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 64) {
                    return (BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_;
                }
                return BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo, BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.Builder, BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfoOrBuilder> getBlitzRushInfoFieldBuilder() {
                if (this.blitzRushInfoBuilder_ == null) {
                    if (this.detailCase_ != 64) {
                        this.detail_ = BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo.getDefaultInstance();
                    }
                    this.blitzRushInfoBuilder_ = new SingleFieldBuilderV3<>((BlitzRushActivityDetailInfoOuterClass.BlitzRushActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 64;
                onChanged();
                return this.blitzRushInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasChessInfo() {
                return this.detailCase_ == 1006;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo getChessInfo() {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ == 1006) {
                        return (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_;
                    }
                    return ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1006) {
                    return this.chessInfoBuilder_.getMessage();
                } else {
                    return ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setChessInfo(ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo value) {
                if (this.chessInfoBuilder_ != null) {
                    this.chessInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1006;
                return this;
            }

            public Builder setChessInfo(ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.Builder builderForValue) {
                if (this.chessInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.chessInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1006;
                return this;
            }

            public Builder mergeChessInfo(ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo value) {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ != 1006 || this.detail_ == ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.newBuilder((ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1006) {
                        this.chessInfoBuilder_.mergeFrom(value);
                    }
                    this.chessInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1006;
                return this;
            }

            public Builder clearChessInfo() {
                if (this.chessInfoBuilder_ != null) {
                    if (this.detailCase_ == 1006) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.chessInfoBuilder_.clear();
                } else if (this.detailCase_ == 1006) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.Builder getChessInfoBuilder() {
                return getChessInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder getChessInfoOrBuilder() {
                if (this.detailCase_ == 1006 && this.chessInfoBuilder_ != null) {
                    return this.chessInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1006) {
                    return (ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_;
                }
                return ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo, ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.Builder, ChessActivityDetailInfoOuterClass.ChessActivityDetailInfoOrBuilder> getChessInfoFieldBuilder() {
                if (this.chessInfoBuilder_ == null) {
                    if (this.detailCase_ != 1006) {
                        this.detail_ = ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo.getDefaultInstance();
                    }
                    this.chessInfoBuilder_ = new SingleFieldBuilderV3<>((ChessActivityDetailInfoOuterClass.ChessActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1006;
                onChanged();
                return this.chessInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSumoInfo() {
                return this.detailCase_ == 505;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo getSumoInfo() {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ == 505) {
                        return (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_;
                    }
                    return SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 505) {
                    return this.sumoInfoBuilder_.getMessage();
                } else {
                    return SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setSumoInfo(SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo value) {
                if (this.sumoInfoBuilder_ != null) {
                    this.sumoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 505;
                return this;
            }

            public Builder setSumoInfo(SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder builderForValue) {
                if (this.sumoInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.sumoInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 505;
                return this;
            }

            public Builder mergeSumoInfo(SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo value) {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ != 505 || this.detail_ == SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.newBuilder((SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 505) {
                        this.sumoInfoBuilder_.mergeFrom(value);
                    }
                    this.sumoInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 505;
                return this;
            }

            public Builder clearSumoInfo() {
                if (this.sumoInfoBuilder_ != null) {
                    if (this.detailCase_ == 505) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.sumoInfoBuilder_.clear();
                } else if (this.detailCase_ == 505) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder getSumoInfoBuilder() {
                return getSumoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder getSumoInfoOrBuilder() {
                if (this.detailCase_ == 505 && this.sumoInfoBuilder_ != null) {
                    return this.sumoInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 505) {
                    return (SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_;
                }
                return SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo, SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.Builder, SumoActivityDetailInfoOuterClass.SumoActivityDetailInfoOrBuilder> getSumoInfoFieldBuilder() {
                if (this.sumoInfoBuilder_ == null) {
                    if (this.detailCase_ != 505) {
                        this.detail_ = SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo.getDefaultInstance();
                    }
                    this.sumoInfoBuilder_ = new SingleFieldBuilderV3<>((SumoActivityDetailInfoOuterClass.SumoActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 505;
                onChanged();
                return this.sumoInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMoonfinTrialInfo() {
                return this.detailCase_ == 766;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo getMoonfinTrialInfo() {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ == 766) {
                        return (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_;
                    }
                    return MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 766) {
                    return this.moonfinTrialInfoBuilder_.getMessage();
                } else {
                    return MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setMoonfinTrialInfo(MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo value) {
                if (this.moonfinTrialInfoBuilder_ != null) {
                    this.moonfinTrialInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setMoonfinTrialInfo(MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.Builder builderForValue) {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.moonfinTrialInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeMoonfinTrialInfo(MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo value) {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ != 766 || this.detail_ == MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.newBuilder((MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 766) {
                        this.moonfinTrialInfoBuilder_.mergeFrom(value);
                    }
                    this.moonfinTrialInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearMoonfinTrialInfo() {
                if (this.moonfinTrialInfoBuilder_ != null) {
                    if (this.detailCase_ == 766) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.moonfinTrialInfoBuilder_.clear();
                } else if (this.detailCase_ == 766) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.Builder getMoonfinTrialInfoBuilder() {
                return getMoonfinTrialInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfoOrBuilder getMoonfinTrialInfoOrBuilder() {
                if (this.detailCase_ == 766 && this.moonfinTrialInfoBuilder_ != null) {
                    return this.moonfinTrialInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 766) {
                    return (MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_;
                }
                return MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo, MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.Builder, MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfoOrBuilder> getMoonfinTrialInfoFieldBuilder() {
                if (this.moonfinTrialInfoBuilder_ == null) {
                    if (this.detailCase_ != 766) {
                        this.detail_ = MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo.getDefaultInstance();
                    }
                    this.moonfinTrialInfoBuilder_ = new SingleFieldBuilderV3<>((MoonfinTrialActivityDetailInfoOuterClass.MoonfinTrialActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.MOONFIN_TRIAL_INFO_FIELD_NUMBER;
                onChanged();
                return this.moonfinTrialInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLunaRiteInfo() {
                return this.detailCase_ == 1545;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo getLunaRiteInfo() {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ == 1545) {
                        return (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_;
                    }
                    return LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1545) {
                    return this.lunaRiteInfoBuilder_.getMessage();
                } else {
                    return LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
                }
            }

            public Builder setLunaRiteInfo(LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo value) {
                if (this.lunaRiteInfoBuilder_ != null) {
                    this.lunaRiteInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1545;
                return this;
            }

            public Builder setLunaRiteInfo(LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.Builder builderForValue) {
                if (this.lunaRiteInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lunaRiteInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1545;
                return this;
            }

            public Builder mergeLunaRiteInfo(LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo value) {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ != 1545 || this.detail_ == LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.newBuilder((LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1545) {
                        this.lunaRiteInfoBuilder_.mergeFrom(value);
                    }
                    this.lunaRiteInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1545;
                return this;
            }

            public Builder clearLunaRiteInfo() {
                if (this.lunaRiteInfoBuilder_ != null) {
                    if (this.detailCase_ == 1545) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.lunaRiteInfoBuilder_.clear();
                } else if (this.detailCase_ == 1545) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.Builder getLunaRiteInfoBuilder() {
                return getLunaRiteInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder getLunaRiteInfoOrBuilder() {
                if (this.detailCase_ == 1545 && this.lunaRiteInfoBuilder_ != null) {
                    return this.lunaRiteInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1545) {
                    return (LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_;
                }
                return LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo, LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.Builder, LunaRiteDetailInfoOuterClass.LunaRiteDetailInfoOrBuilder> getLunaRiteInfoFieldBuilder() {
                if (this.lunaRiteInfoBuilder_ == null) {
                    if (this.detailCase_ != 1545) {
                        this.detail_ = LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo.getDefaultInstance();
                    }
                    this.lunaRiteInfoBuilder_ = new SingleFieldBuilderV3<>((LunaRiteDetailInfoOuterClass.LunaRiteDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1545;
                onChanged();
                return this.lunaRiteInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPlantFlowerInfo() {
                return this.detailCase_ == 1274;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo getPlantFlowerInfo() {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ == 1274) {
                        return (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_;
                    }
                    return PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1274) {
                    return this.plantFlowerInfoBuilder_.getMessage();
                } else {
                    return PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setPlantFlowerInfo(PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo value) {
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

            public Builder setPlantFlowerInfo(PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder builderForValue) {
                if (this.plantFlowerInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.plantFlowerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergePlantFlowerInfo(PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo value) {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1274 || this.detail_ == PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.newBuilder((PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1274) {
                        this.plantFlowerInfoBuilder_.mergeFrom(value);
                    }
                    this.plantFlowerInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearPlantFlowerInfo() {
                if (this.plantFlowerInfoBuilder_ != null) {
                    if (this.detailCase_ == 1274) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.plantFlowerInfoBuilder_.clear();
                } else if (this.detailCase_ == 1274) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder getPlantFlowerInfoBuilder() {
                return getPlantFlowerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder getPlantFlowerInfoOrBuilder() {
                if (this.detailCase_ == 1274 && this.plantFlowerInfoBuilder_ != null) {
                    return this.plantFlowerInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1274) {
                    return (PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_;
                }
                return PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo, PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.Builder, PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfoOrBuilder> getPlantFlowerInfoFieldBuilder() {
                if (this.plantFlowerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1274) {
                        this.detail_ = PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo.getDefaultInstance();
                    }
                    this.plantFlowerInfoBuilder_ = new SingleFieldBuilderV3<>((PlantFlowerActivityDetailInfoOuterClass.PlantFlowerActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.PLANT_FLOWER_INFO_FIELD_NUMBER;
                onChanged();
                return this.plantFlowerInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMusicGameInfo() {
                return this.detailCase_ == 1989;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo getMusicGameInfo() {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ == 1989) {
                        return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
                    }
                    return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1989) {
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
                this.detailCase_ = 1989;
                return this;
            }

            public Builder setMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder builderForValue) {
                if (this.musicGameInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.musicGameInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1989;
                return this;
            }

            public Builder mergeMusicGameInfo(MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo value) {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ != 1989 || this.detail_ == MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.newBuilder((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1989) {
                        this.musicGameInfoBuilder_.mergeFrom(value);
                    }
                    this.musicGameInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1989;
                return this;
            }

            public Builder clearMusicGameInfo() {
                if (this.musicGameInfoBuilder_ != null) {
                    if (this.detailCase_ == 1989) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.musicGameInfoBuilder_.clear();
                } else if (this.detailCase_ == 1989) {
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
                if (this.detailCase_ == 1989 && this.musicGameInfoBuilder_ != null) {
                    return this.musicGameInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1989) {
                    return (MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_;
                }
                return MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.Builder, MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfoOrBuilder> getMusicGameInfoFieldBuilder() {
                if (this.musicGameInfoBuilder_ == null) {
                    if (this.detailCase_ != 1989) {
                        this.detail_ = MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo.getDefaultInstance();
                    }
                    this.musicGameInfoBuilder_ = new SingleFieldBuilderV3<>((MusicGameActivityDetailInfoOuterClass.MusicGameActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1989;
                onChanged();
                return this.musicGameInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRoguelikeDungeonInfo() {
                return this.detailCase_ == 970;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo getRoguelikeDungeonInfo() {
                if (this.roguelikeDungeonInfoBuilder_ == null) {
                    if (this.detailCase_ == 970) {
                        return (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_;
                    }
                    return RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 970) {
                    return this.roguelikeDungeonInfoBuilder_.getMessage();
                } else {
                    return RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setRoguelikeDungeonInfo(RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo value) {
                if (this.roguelikeDungeonInfoBuilder_ != null) {
                    this.roguelikeDungeonInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setRoguelikeDungeonInfo(RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.Builder builderForValue) {
                if (this.roguelikeDungeonInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.roguelikeDungeonInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRoguelikeDungeonInfo(RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo value) {
                if (this.roguelikeDungeonInfoBuilder_ == null) {
                    if (this.detailCase_ != 970 || this.detail_ == RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.newBuilder((RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 970) {
                        this.roguelikeDungeonInfoBuilder_.mergeFrom(value);
                    }
                    this.roguelikeDungeonInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearRoguelikeDungeonInfo() {
                if (this.roguelikeDungeonInfoBuilder_ != null) {
                    if (this.detailCase_ == 970) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.roguelikeDungeonInfoBuilder_.clear();
                } else if (this.detailCase_ == 970) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.Builder getRoguelikeDungeonInfoBuilder() {
                return getRoguelikeDungeonInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder getRoguelikeDungeonInfoOrBuilder() {
                if (this.detailCase_ == 970 && this.roguelikeDungeonInfoBuilder_ != null) {
                    return this.roguelikeDungeonInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 970) {
                    return (RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_;
                }
                return RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo, RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.Builder, RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder> getRoguelikeDungeonInfoFieldBuilder() {
                if (this.roguelikeDungeonInfoBuilder_ == null) {
                    if (this.detailCase_ != 970) {
                        this.detail_ = RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
                    }
                    this.roguelikeDungeonInfoBuilder_ = new SingleFieldBuilderV3<>((RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ROGUELIKE_DUNGEON_INFO_FIELD_NUMBER;
                onChanged();
                return this.roguelikeDungeonInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasDigInfo() {
                return this.detailCase_ == 1862;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DigActivityDetailInfoOuterClass.DigActivityDetailInfo getDigInfo() {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ == 1862) {
                        return (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_;
                    }
                    return DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1862) {
                    return this.digInfoBuilder_.getMessage();
                } else {
                    return DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setDigInfo(DigActivityDetailInfoOuterClass.DigActivityDetailInfo value) {
                if (this.digInfoBuilder_ != null) {
                    this.digInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.DIG_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setDigInfo(DigActivityDetailInfoOuterClass.DigActivityDetailInfo.Builder builderForValue) {
                if (this.digInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.digInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.DIG_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeDigInfo(DigActivityDetailInfoOuterClass.DigActivityDetailInfo value) {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ != 1862 || this.detail_ == DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = DigActivityDetailInfoOuterClass.DigActivityDetailInfo.newBuilder((DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1862) {
                        this.digInfoBuilder_.mergeFrom(value);
                    }
                    this.digInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.DIG_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearDigInfo() {
                if (this.digInfoBuilder_ != null) {
                    if (this.detailCase_ == 1862) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.digInfoBuilder_.clear();
                } else if (this.detailCase_ == 1862) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public DigActivityDetailInfoOuterClass.DigActivityDetailInfo.Builder getDigInfoBuilder() {
                return getDigInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder getDigInfoOrBuilder() {
                if (this.detailCase_ == 1862 && this.digInfoBuilder_ != null) {
                    return this.digInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1862) {
                    return (DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_;
                }
                return DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DigActivityDetailInfoOuterClass.DigActivityDetailInfo, DigActivityDetailInfoOuterClass.DigActivityDetailInfo.Builder, DigActivityDetailInfoOuterClass.DigActivityDetailInfoOrBuilder> getDigInfoFieldBuilder() {
                if (this.digInfoBuilder_ == null) {
                    if (this.detailCase_ != 1862) {
                        this.detail_ = DigActivityDetailInfoOuterClass.DigActivityDetailInfo.getDefaultInstance();
                    }
                    this.digInfoBuilder_ = new SingleFieldBuilderV3<>((DigActivityDetailInfoOuterClass.DigActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.DIG_INFO_FIELD_NUMBER;
                onChanged();
                return this.digInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasHachiInfo() {
                return this.detailCase_ == 511;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo getHachiInfo() {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ == 511) {
                        return (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_;
                    }
                    return HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 511) {
                    return this.hachiInfoBuilder_.getMessage();
                } else {
                    return HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setHachiInfo(HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo value) {
                if (this.hachiInfoBuilder_ != null) {
                    this.hachiInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 511;
                return this;
            }

            public Builder setHachiInfo(HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.Builder builderForValue) {
                if (this.hachiInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.hachiInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 511;
                return this;
            }

            public Builder mergeHachiInfo(HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo value) {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ != 511 || this.detail_ == HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.newBuilder((HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 511) {
                        this.hachiInfoBuilder_.mergeFrom(value);
                    }
                    this.hachiInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 511;
                return this;
            }

            public Builder clearHachiInfo() {
                if (this.hachiInfoBuilder_ != null) {
                    if (this.detailCase_ == 511) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.hachiInfoBuilder_.clear();
                } else if (this.detailCase_ == 511) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.Builder getHachiInfoBuilder() {
                return getHachiInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public HachiActivityDetailInfoOuterClass.HachiActivityDetailInfoOrBuilder getHachiInfoOrBuilder() {
                if (this.detailCase_ == 511 && this.hachiInfoBuilder_ != null) {
                    return this.hachiInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 511) {
                    return (HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_;
                }
                return HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo, HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.Builder, HachiActivityDetailInfoOuterClass.HachiActivityDetailInfoOrBuilder> getHachiInfoFieldBuilder() {
                if (this.hachiInfoBuilder_ == null) {
                    if (this.detailCase_ != 511) {
                        this.detail_ = HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo.getDefaultInstance();
                    }
                    this.hachiInfoBuilder_ = new SingleFieldBuilderV3<>((HachiActivityDetailInfoOuterClass.HachiActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 511;
                onChanged();
                return this.hachiInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWinterCampInfo() {
                return this.detailCase_ == 699;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo getWinterCampInfo() {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ == 699) {
                        return (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_;
                    }
                    return WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 699) {
                    return this.winterCampInfoBuilder_.getMessage();
                } else {
                    return WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setWinterCampInfo(WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo value) {
                if (this.winterCampInfoBuilder_ != null) {
                    this.winterCampInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder setWinterCampInfo(WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.Builder builderForValue) {
                if (this.winterCampInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.winterCampInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder mergeWinterCampInfo(WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo value) {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ != 699 || this.detail_ == WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.newBuilder((WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 699) {
                        this.winterCampInfoBuilder_.mergeFrom(value);
                    }
                    this.winterCampInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 699;
                return this;
            }

            public Builder clearWinterCampInfo() {
                if (this.winterCampInfoBuilder_ != null) {
                    if (this.detailCase_ == 699) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.winterCampInfoBuilder_.clear();
                } else if (this.detailCase_ == 699) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.Builder getWinterCampInfoBuilder() {
                return getWinterCampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder getWinterCampInfoOrBuilder() {
                if (this.detailCase_ == 699 && this.winterCampInfoBuilder_ != null) {
                    return this.winterCampInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 699) {
                    return (WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_;
                }
                return WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo, WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.Builder, WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfoOrBuilder> getWinterCampInfoFieldBuilder() {
                if (this.winterCampInfoBuilder_ == null) {
                    if (this.detailCase_ != 699) {
                        this.detail_ = WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo.getDefaultInstance();
                    }
                    this.winterCampInfoBuilder_ = new SingleFieldBuilderV3<>((WinterCampActivityDetailInfoOuterClass.WinterCampActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 699;
                onChanged();
                return this.winterCampInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPotionInfo() {
                return this.detailCase_ == 1567;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo getPotionInfo() {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ == 1567) {
                        return (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_;
                    }
                    return PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1567) {
                    return this.potionInfoBuilder_.getMessage();
                } else {
                    return PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setPotionInfo(PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo value) {
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

            public Builder setPotionInfo(PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.Builder builderForValue) {
                if (this.potionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.potionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergePotionInfo(PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo value) {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1567 || this.detail_ == PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.newBuilder((PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1567) {
                        this.potionInfoBuilder_.mergeFrom(value);
                    }
                    this.potionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearPotionInfo() {
                if (this.potionInfoBuilder_ != null) {
                    if (this.detailCase_ == 1567) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.potionInfoBuilder_.clear();
                } else if (this.detailCase_ == 1567) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.Builder getPotionInfoBuilder() {
                return getPotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PotionActivityDetailInfoOuterClass.PotionActivityDetailInfoOrBuilder getPotionInfoOrBuilder() {
                if (this.detailCase_ == 1567 && this.potionInfoBuilder_ != null) {
                    return this.potionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1567) {
                    return (PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_;
                }
                return PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo, PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.Builder, PotionActivityDetailInfoOuterClass.PotionActivityDetailInfoOrBuilder> getPotionInfoFieldBuilder() {
                if (this.potionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1567) {
                        this.detail_ = PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo.getDefaultInstance();
                    }
                    this.potionInfoBuilder_ = new SingleFieldBuilderV3<>((PotionActivityDetailInfoOuterClass.PotionActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.POTION_INFO_FIELD_NUMBER;
                onChanged();
                return this.potionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTanukiTravelActivityInfo() {
                return this.detailCase_ == 1348;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo getTanukiTravelActivityInfo() {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 1348) {
                        return (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_;
                    }
                    return TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1348) {
                    return this.tanukiTravelActivityInfoBuilder_.getMessage();
                } else {
                    return TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setTanukiTravelActivityInfo(TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo value) {
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

            public Builder setTanukiTravelActivityInfo(TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.Builder builderForValue) {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.tanukiTravelActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTanukiTravelActivityInfo(TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo value) {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1348 || this.detail_ == TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.newBuilder((TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1348) {
                        this.tanukiTravelActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.tanukiTravelActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTanukiTravelActivityInfo() {
                if (this.tanukiTravelActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 1348) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.tanukiTravelActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 1348) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.Builder getTanukiTravelActivityInfoBuilder() {
                return getTanukiTravelActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder getTanukiTravelActivityInfoOrBuilder() {
                if (this.detailCase_ == 1348 && this.tanukiTravelActivityInfoBuilder_ != null) {
                    return this.tanukiTravelActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1348) {
                    return (TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_;
                }
                return TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo, TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.Builder, TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfoOrBuilder> getTanukiTravelActivityInfoFieldBuilder() {
                if (this.tanukiTravelActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 1348) {
                        this.detail_ = TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo.getDefaultInstance();
                    }
                    this.tanukiTravelActivityInfoBuilder_ = new SingleFieldBuilderV3<>((TanukiTravelActivityDetailInfoOuterClass.TanukiTravelActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TANUKI_TRAVEL_ACTIVITY_INFO_FIELD_NUMBER;
                onChanged();
                return this.tanukiTravelActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLanternRiteActivityInfo() {
                return this.detailCase_ == 237;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo getLanternRiteActivityInfo() {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ == 237) {
                        return (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_;
                    }
                    return LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 237) {
                    return this.lanternRiteActivityInfoBuilder_.getMessage();
                } else {
                    return LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setLanternRiteActivityInfo(LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo value) {
                if (this.lanternRiteActivityInfoBuilder_ != null) {
                    this.lanternRiteActivityInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 237;
                return this;
            }

            public Builder setLanternRiteActivityInfo(LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.Builder builderForValue) {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.lanternRiteActivityInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 237;
                return this;
            }

            public Builder mergeLanternRiteActivityInfo(LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo value) {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 237 || this.detail_ == LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.newBuilder((LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 237) {
                        this.lanternRiteActivityInfoBuilder_.mergeFrom(value);
                    }
                    this.lanternRiteActivityInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 237;
                return this;
            }

            public Builder clearLanternRiteActivityInfo() {
                if (this.lanternRiteActivityInfoBuilder_ != null) {
                    if (this.detailCase_ == 237) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.lanternRiteActivityInfoBuilder_.clear();
                } else if (this.detailCase_ == 237) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.Builder getLanternRiteActivityInfoBuilder() {
                return getLanternRiteActivityInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder getLanternRiteActivityInfoOrBuilder() {
                if (this.detailCase_ == 237 && this.lanternRiteActivityInfoBuilder_ != null) {
                    return this.lanternRiteActivityInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 237) {
                    return (LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_;
                }
                return LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo, LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.Builder, LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfoOrBuilder> getLanternRiteActivityInfoFieldBuilder() {
                if (this.lanternRiteActivityInfoBuilder_ == null) {
                    if (this.detailCase_ != 237) {
                        this.detail_ = LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo.getDefaultInstance();
                    }
                    this.lanternRiteActivityInfoBuilder_ = new SingleFieldBuilderV3<>((LanternRiteActivityDetailInfoOuterClass.LanternRiteActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 237;
                onChanged();
                return this.lanternRiteActivityInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMichiaeMatsuriInfo() {
                return this.detailCase_ == 1839;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo getMichiaeMatsuriInfo() {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ == 1839) {
                        return (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_;
                    }
                    return MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1839) {
                    return this.michiaeMatsuriInfoBuilder_.getMessage();
                } else {
                    return MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setMichiaeMatsuriInfo(MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo value) {
                if (this.michiaeMatsuriInfoBuilder_ != null) {
                    this.michiaeMatsuriInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1839;
                return this;
            }

            public Builder setMichiaeMatsuriInfo(MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.Builder builderForValue) {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.michiaeMatsuriInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1839;
                return this;
            }

            public Builder mergeMichiaeMatsuriInfo(MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo value) {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1839 || this.detail_ == MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.newBuilder((MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1839) {
                        this.michiaeMatsuriInfoBuilder_.mergeFrom(value);
                    }
                    this.michiaeMatsuriInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1839;
                return this;
            }

            public Builder clearMichiaeMatsuriInfo() {
                if (this.michiaeMatsuriInfoBuilder_ != null) {
                    if (this.detailCase_ == 1839) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.michiaeMatsuriInfoBuilder_.clear();
                } else if (this.detailCase_ == 1839) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.Builder getMichiaeMatsuriInfoBuilder() {
                return getMichiaeMatsuriInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder getMichiaeMatsuriInfoOrBuilder() {
                if (this.detailCase_ == 1839 && this.michiaeMatsuriInfoBuilder_ != null) {
                    return this.michiaeMatsuriInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1839) {
                    return (MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_;
                }
                return MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo, MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.Builder, MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfoOrBuilder> getMichiaeMatsuriInfoFieldBuilder() {
                if (this.michiaeMatsuriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1839) {
                        this.detail_ = MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo.getDefaultInstance();
                    }
                    this.michiaeMatsuriInfoBuilder_ = new SingleFieldBuilderV3<>((MichiaeMatsuriActivityDetailInfoOuterClass.MichiaeMatsuriActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1839;
                onChanged();
                return this.michiaeMatsuriInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBartenderInfo() {
                return this.detailCase_ == 551;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo getBartenderInfo() {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ == 551) {
                        return (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_;
                    }
                    return BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 551) {
                    return this.bartenderInfoBuilder_.getMessage();
                } else {
                    return BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBartenderInfo(BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo value) {
                if (this.bartenderInfoBuilder_ != null) {
                    this.bartenderInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 551;
                return this;
            }

            public Builder setBartenderInfo(BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.Builder builderForValue) {
                if (this.bartenderInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.bartenderInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 551;
                return this;
            }

            public Builder mergeBartenderInfo(BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo value) {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ != 551 || this.detail_ == BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.newBuilder((BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 551) {
                        this.bartenderInfoBuilder_.mergeFrom(value);
                    }
                    this.bartenderInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 551;
                return this;
            }

            public Builder clearBartenderInfo() {
                if (this.bartenderInfoBuilder_ != null) {
                    if (this.detailCase_ == 551) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.bartenderInfoBuilder_.clear();
                } else if (this.detailCase_ == 551) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.Builder getBartenderInfoBuilder() {
                return getBartenderInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder getBartenderInfoOrBuilder() {
                if (this.detailCase_ == 551 && this.bartenderInfoBuilder_ != null) {
                    return this.bartenderInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 551) {
                    return (BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_;
                }
                return BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo, BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.Builder, BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder> getBartenderInfoFieldBuilder() {
                if (this.bartenderInfoBuilder_ == null) {
                    if (this.detailCase_ != 551) {
                        this.detail_ = BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.getDefaultInstance();
                    }
                    this.bartenderInfoBuilder_ = new SingleFieldBuilderV3<>((BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 551;
                onChanged();
                return this.bartenderInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasUgcInfo() {
                return this.detailCase_ == 1182;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo getUgcInfo() {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ == 1182) {
                        return (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_;
                    }
                    return UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1182) {
                    return this.ugcInfoBuilder_.getMessage();
                } else {
                    return UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setUgcInfo(UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo value) {
                if (this.ugcInfoBuilder_ != null) {
                    this.ugcInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1182;
                return this;
            }

            public Builder setUgcInfo(UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.Builder builderForValue) {
                if (this.ugcInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.ugcInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1182;
                return this;
            }

            public Builder mergeUgcInfo(UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo value) {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ != 1182 || this.detail_ == UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.newBuilder((UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1182) {
                        this.ugcInfoBuilder_.mergeFrom(value);
                    }
                    this.ugcInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1182;
                return this;
            }

            public Builder clearUgcInfo() {
                if (this.ugcInfoBuilder_ != null) {
                    if (this.detailCase_ == 1182) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.ugcInfoBuilder_.clear();
                } else if (this.detailCase_ == 1182) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.Builder getUgcInfoBuilder() {
                return getUgcInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder getUgcInfoOrBuilder() {
                if (this.detailCase_ == 1182 && this.ugcInfoBuilder_ != null) {
                    return this.ugcInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1182) {
                    return (UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_;
                }
                return UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo, UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.Builder, UgcActivityDetailInfoOuterClass.UgcActivityDetailInfoOrBuilder> getUgcInfoFieldBuilder() {
                if (this.ugcInfoBuilder_ == null) {
                    if (this.detailCase_ != 1182) {
                        this.detail_ = UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo.getDefaultInstance();
                    }
                    this.ugcInfoBuilder_ = new SingleFieldBuilderV3<>((UgcActivityDetailInfoOuterClass.UgcActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1182;
                onChanged();
                return this.ugcInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCrystalLinkInfo() {
                return this.detailCase_ == 812;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo getCrystalLinkInfo() {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ == 812) {
                        return (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_;
                    }
                    return CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 812) {
                    return this.crystalLinkInfoBuilder_.getMessage();
                } else {
                    return CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setCrystalLinkInfo(CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo value) {
                if (this.crystalLinkInfoBuilder_ != null) {
                    this.crystalLinkInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 812;
                return this;
            }

            public Builder setCrystalLinkInfo(CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.Builder builderForValue) {
                if (this.crystalLinkInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.crystalLinkInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 812;
                return this;
            }

            public Builder mergeCrystalLinkInfo(CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo value) {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ != 812 || this.detail_ == CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.newBuilder((CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 812) {
                        this.crystalLinkInfoBuilder_.mergeFrom(value);
                    }
                    this.crystalLinkInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 812;
                return this;
            }

            public Builder clearCrystalLinkInfo() {
                if (this.crystalLinkInfoBuilder_ != null) {
                    if (this.detailCase_ == 812) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.crystalLinkInfoBuilder_.clear();
                } else if (this.detailCase_ == 812) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.Builder getCrystalLinkInfoBuilder() {
                return getCrystalLinkInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfoOrBuilder getCrystalLinkInfoOrBuilder() {
                if (this.detailCase_ == 812 && this.crystalLinkInfoBuilder_ != null) {
                    return this.crystalLinkInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 812) {
                    return (CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_;
                }
                return CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo, CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.Builder, CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfoOrBuilder> getCrystalLinkInfoFieldBuilder() {
                if (this.crystalLinkInfoBuilder_ == null) {
                    if (this.detailCase_ != 812) {
                        this.detail_ = CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo.getDefaultInstance();
                    }
                    this.crystalLinkInfoBuilder_ = new SingleFieldBuilderV3<>((CrystalLinkActivityDetailInfoOuterClass.CrystalLinkActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 812;
                onChanged();
                return this.crystalLinkInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasIrodoriInfo() {
                return this.detailCase_ == 1056;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo getIrodoriInfo() {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ == 1056) {
                        return (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_;
                    }
                    return IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1056) {
                    return this.irodoriInfoBuilder_.getMessage();
                } else {
                    return IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setIrodoriInfo(IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo value) {
                if (this.irodoriInfoBuilder_ != null) {
                    this.irodoriInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1056;
                return this;
            }

            public Builder setIrodoriInfo(IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.Builder builderForValue) {
                if (this.irodoriInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.irodoriInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1056;
                return this;
            }

            public Builder mergeIrodoriInfo(IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo value) {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1056 || this.detail_ == IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.newBuilder((IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1056) {
                        this.irodoriInfoBuilder_.mergeFrom(value);
                    }
                    this.irodoriInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1056;
                return this;
            }

            public Builder clearIrodoriInfo() {
                if (this.irodoriInfoBuilder_ != null) {
                    if (this.detailCase_ == 1056) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.irodoriInfoBuilder_.clear();
                } else if (this.detailCase_ == 1056) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.Builder getIrodoriInfoBuilder() {
                return getIrodoriInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder getIrodoriInfoOrBuilder() {
                if (this.detailCase_ == 1056 && this.irodoriInfoBuilder_ != null) {
                    return this.irodoriInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1056) {
                    return (IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_;
                }
                return IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo, IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.Builder, IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfoOrBuilder> getIrodoriInfoFieldBuilder() {
                if (this.irodoriInfoBuilder_ == null) {
                    if (this.detailCase_ != 1056) {
                        this.detail_ = IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo.getDefaultInstance();
                    }
                    this.irodoriInfoBuilder_ = new SingleFieldBuilderV3<>((IrodoriActivityDetailInfoOuterClass.IrodoriActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1056;
                onChanged();
                return this.irodoriInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasPhotoInfo() {
                return this.detailCase_ == 1822;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo getPhotoInfo() {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ == 1822) {
                        return (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_;
                    }
                    return PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1822) {
                    return this.photoInfoBuilder_.getMessage();
                } else {
                    return PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setPhotoInfo(PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo value) {
                if (this.photoInfoBuilder_ != null) {
                    this.photoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1822;
                return this;
            }

            public Builder setPhotoInfo(PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.Builder builderForValue) {
                if (this.photoInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.photoInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1822;
                return this;
            }

            public Builder mergePhotoInfo(PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo value) {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ != 1822 || this.detail_ == PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.newBuilder((PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1822) {
                        this.photoInfoBuilder_.mergeFrom(value);
                    }
                    this.photoInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1822;
                return this;
            }

            public Builder clearPhotoInfo() {
                if (this.photoInfoBuilder_ != null) {
                    if (this.detailCase_ == 1822) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.photoInfoBuilder_.clear();
                } else if (this.detailCase_ == 1822) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.Builder getPhotoInfoBuilder() {
                return getPhotoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder getPhotoInfoOrBuilder() {
                if (this.detailCase_ == 1822 && this.photoInfoBuilder_ != null) {
                    return this.photoInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1822) {
                    return (PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_;
                }
                return PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo, PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.Builder, PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfoOrBuilder> getPhotoInfoFieldBuilder() {
                if (this.photoInfoBuilder_ == null) {
                    if (this.detailCase_ != 1822) {
                        this.detail_ = PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo.getDefaultInstance();
                    }
                    this.photoInfoBuilder_ = new SingleFieldBuilderV3<>((PhotoActivityDetailInfoOuterClass.PhotoActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1822;
                onChanged();
                return this.photoInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSpiceInfo() {
                return this.detailCase_ == 789;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo getSpiceInfo() {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ == 789) {
                        return (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_;
                    }
                    return SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 789) {
                    return this.spiceInfoBuilder_.getMessage();
                } else {
                    return SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setSpiceInfo(SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo value) {
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

            public Builder setSpiceInfo(SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.Builder builderForValue) {
                if (this.spiceInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.spiceInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeSpiceInfo(SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo value) {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ != 789 || this.detail_ == SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.newBuilder((SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 789) {
                        this.spiceInfoBuilder_.mergeFrom(value);
                    }
                    this.spiceInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearSpiceInfo() {
                if (this.spiceInfoBuilder_ != null) {
                    if (this.detailCase_ == 789) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.spiceInfoBuilder_.clear();
                } else if (this.detailCase_ == 789) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.Builder getSpiceInfoBuilder() {
                return getSpiceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfoOrBuilder getSpiceInfoOrBuilder() {
                if (this.detailCase_ == 789 && this.spiceInfoBuilder_ != null) {
                    return this.spiceInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 789) {
                    return (SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_;
                }
                return SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo, SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.Builder, SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfoOrBuilder> getSpiceInfoFieldBuilder() {
                if (this.spiceInfoBuilder_ == null) {
                    if (this.detailCase_ != 789) {
                        this.detail_ = SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo.getDefaultInstance();
                    }
                    this.spiceInfoBuilder_ = new SingleFieldBuilderV3<>((SpiceActivityDetailInfoOuterClass.SpiceActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.SPICE_INFO_FIELD_NUMBER;
                onChanged();
                return this.spiceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGachaInfo() {
                return this.detailCase_ == 1297;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo getGachaInfo() {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ == 1297) {
                        return (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_;
                    }
                    return GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1297) {
                    return this.gachaInfoBuilder_.getMessage();
                } else {
                    return GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setGachaInfo(GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo value) {
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

            public Builder setGachaInfo(GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder builderForValue) {
                if (this.gachaInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gachaInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGachaInfo(GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo value) {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ != 1297 || this.detail_ == GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.newBuilder((GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1297) {
                        this.gachaInfoBuilder_.mergeFrom(value);
                    }
                    this.gachaInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGachaInfo() {
                if (this.gachaInfoBuilder_ != null) {
                    if (this.detailCase_ == 1297) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gachaInfoBuilder_.clear();
                } else if (this.detailCase_ == 1297) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder getGachaInfoBuilder() {
                return getGachaInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder getGachaInfoOrBuilder() {
                if (this.detailCase_ == 1297 && this.gachaInfoBuilder_ != null) {
                    return this.gachaInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1297) {
                    return (GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_;
                }
                return GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo, GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.Builder, GachaActivityDetailInfoOuterClass.GachaActivityDetailInfoOrBuilder> getGachaInfoFieldBuilder() {
                if (this.gachaInfoBuilder_ == null) {
                    if (this.detailCase_ != 1297) {
                        this.detail_ = GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo.getDefaultInstance();
                    }
                    this.gachaInfoBuilder_ = new SingleFieldBuilderV3<>((GachaActivityDetailInfoOuterClass.GachaActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GACHA_INFO_FIELD_NUMBER;
                onChanged();
                return this.gachaInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasLuminanceStoneChallengeInfo() {
                return this.detailCase_ == 444;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo getLuminanceStoneChallengeInfo() {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 444) {
                        return (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_;
                    }
                    return LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 444) {
                    return this.luminanceStoneChallengeInfoBuilder_.getMessage();
                } else {
                    return LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setLuminanceStoneChallengeInfo(LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo value) {
                if (this.luminanceStoneChallengeInfoBuilder_ != null) {
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 444;
                return this;
            }

            public Builder setLuminanceStoneChallengeInfo(LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.Builder builderForValue) {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 444;
                return this;
            }

            public Builder mergeLuminanceStoneChallengeInfo(LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo value) {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 444 || this.detail_ == LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.newBuilder((LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 444) {
                        this.luminanceStoneChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.luminanceStoneChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 444;
                return this;
            }

            public Builder clearLuminanceStoneChallengeInfo() {
                if (this.luminanceStoneChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 444) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.luminanceStoneChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 444) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.Builder getLuminanceStoneChallengeInfoBuilder() {
                return getLuminanceStoneChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder getLuminanceStoneChallengeInfoOrBuilder() {
                if (this.detailCase_ == 444 && this.luminanceStoneChallengeInfoBuilder_ != null) {
                    return this.luminanceStoneChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 444) {
                    return (LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_;
                }
                return LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo, LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.Builder, LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfoOrBuilder> getLuminanceStoneChallengeInfoFieldBuilder() {
                if (this.luminanceStoneChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 444) {
                        this.detail_ = LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo.getDefaultInstance();
                    }
                    this.luminanceStoneChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((LuminanceStoneChallengeActivityDetailInfoOuterClass.LuminanceStoneChallengeActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 444;
                onChanged();
                return this.luminanceStoneChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRogueDiaryInfo() {
                return this.detailCase_ == 560;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo getRogueDiaryInfo() {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ == 560) {
                        return (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_;
                    }
                    return RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 560) {
                    return this.rogueDiaryInfoBuilder_.getMessage();
                } else {
                    return RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setRogueDiaryInfo(RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo value) {
                if (this.rogueDiaryInfoBuilder_ != null) {
                    this.rogueDiaryInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 560;
                return this;
            }

            public Builder setRogueDiaryInfo(RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.Builder builderForValue) {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rogueDiaryInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 560;
                return this;
            }

            public Builder mergeRogueDiaryInfo(RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo value) {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ != 560 || this.detail_ == RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.newBuilder((RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 560) {
                        this.rogueDiaryInfoBuilder_.mergeFrom(value);
                    }
                    this.rogueDiaryInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 560;
                return this;
            }

            public Builder clearRogueDiaryInfo() {
                if (this.rogueDiaryInfoBuilder_ != null) {
                    if (this.detailCase_ == 560) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.rogueDiaryInfoBuilder_.clear();
                } else if (this.detailCase_ == 560) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.Builder getRogueDiaryInfoBuilder() {
                return getRogueDiaryInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder getRogueDiaryInfoOrBuilder() {
                if (this.detailCase_ == 560 && this.rogueDiaryInfoBuilder_ != null) {
                    return this.rogueDiaryInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 560) {
                    return (RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_;
                }
                return RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo, RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.Builder, RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfoOrBuilder> getRogueDiaryInfoFieldBuilder() {
                if (this.rogueDiaryInfoBuilder_ == null) {
                    if (this.detailCase_ != 560) {
                        this.detail_ = RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo.getDefaultInstance();
                    }
                    this.rogueDiaryInfoBuilder_ = new SingleFieldBuilderV3<>((RogueDiaryActivityDetailInfoOuterClass.RogueDiaryActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 560;
                onChanged();
                return this.rogueDiaryInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasSummerTimeV2Info() {
                return this.detailCase_ == 411;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo getSummerTimeV2Info() {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ == 411) {
                        return (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_;
                    }
                    return SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 411) {
                    return this.summerTimeV2InfoBuilder_.getMessage();
                } else {
                    return SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
                }
            }

            public Builder setSummerTimeV2Info(SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo value) {
                if (this.summerTimeV2InfoBuilder_ != null) {
                    this.summerTimeV2InfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 411;
                return this;
            }

            public Builder setSummerTimeV2Info(SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.Builder builderForValue) {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.summerTimeV2InfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 411;
                return this;
            }

            public Builder mergeSummerTimeV2Info(SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo value) {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ != 411 || this.detail_ == SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.newBuilder((SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 411) {
                        this.summerTimeV2InfoBuilder_.mergeFrom(value);
                    }
                    this.summerTimeV2InfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 411;
                return this;
            }

            public Builder clearSummerTimeV2Info() {
                if (this.summerTimeV2InfoBuilder_ != null) {
                    if (this.detailCase_ == 411) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.summerTimeV2InfoBuilder_.clear();
                } else if (this.detailCase_ == 411) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.Builder getSummerTimeV2InfoBuilder() {
                return getSummerTimeV2InfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder getSummerTimeV2InfoOrBuilder() {
                if (this.detailCase_ == 411 && this.summerTimeV2InfoBuilder_ != null) {
                    return this.summerTimeV2InfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 411) {
                    return (SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_;
                }
                return SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo, SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.Builder, SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder> getSummerTimeV2InfoFieldBuilder() {
                if (this.summerTimeV2InfoBuilder_ == null) {
                    if (this.detailCase_ != 411) {
                        this.detail_ = SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.getDefaultInstance();
                    }
                    this.summerTimeV2InfoBuilder_ = new SingleFieldBuilderV3<>((SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 411;
                onChanged();
                return this.summerTimeV2InfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasIslandPartyInfo() {
                return this.detailCase_ == 740;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo getIslandPartyInfo() {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ == 740) {
                        return (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_;
                    }
                    return IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 740) {
                    return this.islandPartyInfoBuilder_.getMessage();
                } else {
                    return IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
                }
            }

            public Builder setIslandPartyInfo(IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo value) {
                if (this.islandPartyInfoBuilder_ != null) {
                    this.islandPartyInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder setIslandPartyInfo(IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.Builder builderForValue) {
                if (this.islandPartyInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.islandPartyInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeIslandPartyInfo(IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo value) {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ != 740 || this.detail_ == IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.newBuilder((IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 740) {
                        this.islandPartyInfoBuilder_.mergeFrom(value);
                    }
                    this.islandPartyInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearIslandPartyInfo() {
                if (this.islandPartyInfoBuilder_ != null) {
                    if (this.detailCase_ == 740) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.islandPartyInfoBuilder_.clear();
                } else if (this.detailCase_ == 740) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.Builder getIslandPartyInfoBuilder() {
                return getIslandPartyInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public IslandPartyDetailInfoOuterClass.IslandPartyDetailInfoOrBuilder getIslandPartyInfoOrBuilder() {
                if (this.detailCase_ == 740 && this.islandPartyInfoBuilder_ != null) {
                    return this.islandPartyInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 740) {
                    return (IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_;
                }
                return IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo, IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.Builder, IslandPartyDetailInfoOuterClass.IslandPartyDetailInfoOrBuilder> getIslandPartyInfoFieldBuilder() {
                if (this.islandPartyInfoBuilder_ == null) {
                    if (this.detailCase_ != 740) {
                        this.detail_ = IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo.getDefaultInstance();
                    }
                    this.islandPartyInfoBuilder_ = new SingleFieldBuilderV3<>((IslandPartyDetailInfoOuterClass.IslandPartyDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ISLAND_PARTY_INFO_FIELD_NUMBER;
                onChanged();
                return this.islandPartyInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGearInfo() {
                return this.detailCase_ == 1482;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GearActivityDetailInfoOuterClass.GearActivityDetailInfo getGearInfo() {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ == 1482) {
                        return (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_;
                    }
                    return GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1482) {
                    return this.gearInfoBuilder_.getMessage();
                } else {
                    return GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setGearInfo(GearActivityDetailInfoOuterClass.GearActivityDetailInfo value) {
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

            public Builder setGearInfo(GearActivityDetailInfoOuterClass.GearActivityDetailInfo.Builder builderForValue) {
                if (this.gearInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gearInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGearInfo(GearActivityDetailInfoOuterClass.GearActivityDetailInfo value) {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ != 1482 || this.detail_ == GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GearActivityDetailInfoOuterClass.GearActivityDetailInfo.newBuilder((GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1482) {
                        this.gearInfoBuilder_.mergeFrom(value);
                    }
                    this.gearInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGearInfo() {
                if (this.gearInfoBuilder_ != null) {
                    if (this.detailCase_ == 1482) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gearInfoBuilder_.clear();
                } else if (this.detailCase_ == 1482) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GearActivityDetailInfoOuterClass.GearActivityDetailInfo.Builder getGearInfoBuilder() {
                return getGearInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GearActivityDetailInfoOuterClass.GearActivityDetailInfoOrBuilder getGearInfoOrBuilder() {
                if (this.detailCase_ == 1482 && this.gearInfoBuilder_ != null) {
                    return this.gearInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1482) {
                    return (GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_;
                }
                return GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GearActivityDetailInfoOuterClass.GearActivityDetailInfo, GearActivityDetailInfoOuterClass.GearActivityDetailInfo.Builder, GearActivityDetailInfoOuterClass.GearActivityDetailInfoOrBuilder> getGearInfoFieldBuilder() {
                if (this.gearInfoBuilder_ == null) {
                    if (this.detailCase_ != 1482) {
                        this.detail_ = GearActivityDetailInfoOuterClass.GearActivityDetailInfo.getDefaultInstance();
                    }
                    this.gearInfoBuilder_ = new SingleFieldBuilderV3<>((GearActivityDetailInfoOuterClass.GearActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GEAR_INFO_FIELD_NUMBER;
                onChanged();
                return this.gearInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasGravenInnocenceInfo() {
                return this.detailCase_ == 1928;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo getGravenInnocenceInfo() {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ == 1928) {
                        return (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_;
                    }
                    return GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1928) {
                    return this.gravenInnocenceInfoBuilder_.getMessage();
                } else {
                    return GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
                }
            }

            public Builder setGravenInnocenceInfo(GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo value) {
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

            public Builder setGravenInnocenceInfo(GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.Builder builderForValue) {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.gravenInnocenceInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeGravenInnocenceInfo(GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo value) {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1928 || this.detail_ == GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.newBuilder((GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1928) {
                        this.gravenInnocenceInfoBuilder_.mergeFrom(value);
                    }
                    this.gravenInnocenceInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearGravenInnocenceInfo() {
                if (this.gravenInnocenceInfoBuilder_ != null) {
                    if (this.detailCase_ == 1928) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.gravenInnocenceInfoBuilder_.clear();
                } else if (this.detailCase_ == 1928) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.Builder getGravenInnocenceInfoBuilder() {
                return getGravenInnocenceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder getGravenInnocenceInfoOrBuilder() {
                if (this.detailCase_ == 1928 && this.gravenInnocenceInfoBuilder_ != null) {
                    return this.gravenInnocenceInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1928) {
                    return (GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_;
                }
                return GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo, GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.Builder, GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder> getGravenInnocenceInfoFieldBuilder() {
                if (this.gravenInnocenceInfoBuilder_ == null) {
                    if (this.detailCase_ != 1928) {
                        this.detail_ = GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.getDefaultInstance();
                    }
                    this.gravenInnocenceInfoBuilder_ = new SingleFieldBuilderV3<>((GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.GRAVEN_INNOCENCE_INFO_FIELD_NUMBER;
                onChanged();
                return this.gravenInnocenceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasInstableSprayInfo() {
                return this.detailCase_ == 1145;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo getInstableSprayInfo() {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ == 1145) {
                        return (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_;
                    }
                    return InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1145) {
                    return this.instableSprayInfoBuilder_.getMessage();
                } else {
                    return InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
                }
            }

            public Builder setInstableSprayInfo(InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo value) {
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

            public Builder setInstableSprayInfo(InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.Builder builderForValue) {
                if (this.instableSprayInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.instableSprayInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeInstableSprayInfo(InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo value) {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ != 1145 || this.detail_ == InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.newBuilder((InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1145) {
                        this.instableSprayInfoBuilder_.mergeFrom(value);
                    }
                    this.instableSprayInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearInstableSprayInfo() {
                if (this.instableSprayInfoBuilder_ != null) {
                    if (this.detailCase_ == 1145) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.instableSprayInfoBuilder_.clear();
                } else if (this.detailCase_ == 1145) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.Builder getInstableSprayInfoBuilder() {
                return getInstableSprayInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public InstableSprayDetailInfoOuterClass.InstableSprayDetailInfoOrBuilder getInstableSprayInfoOrBuilder() {
                if (this.detailCase_ == 1145 && this.instableSprayInfoBuilder_ != null) {
                    return this.instableSprayInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1145) {
                    return (InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_;
                }
                return InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo, InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.Builder, InstableSprayDetailInfoOuterClass.InstableSprayDetailInfoOrBuilder> getInstableSprayInfoFieldBuilder() {
                if (this.instableSprayInfoBuilder_ == null) {
                    if (this.detailCase_ != 1145) {
                        this.detail_ = InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo.getDefaultInstance();
                    }
                    this.instableSprayInfoBuilder_ = new SingleFieldBuilderV3<>((InstableSprayDetailInfoOuterClass.InstableSprayDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.INSTABLE_SPRAY_INFO_FIELD_NUMBER;
                onChanged();
                return this.instableSprayInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasMuqadasPotionInfo() {
                return this.detailCase_ == 1662;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo getMuqadasPotionInfo() {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ == 1662) {
                        return (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_;
                    }
                    return MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1662) {
                    return this.muqadasPotionInfoBuilder_.getMessage();
                } else {
                    return MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setMuqadasPotionInfo(MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo value) {
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

            public Builder setMuqadasPotionInfo(MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.Builder builderForValue) {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.muqadasPotionInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeMuqadasPotionInfo(MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo value) {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1662 || this.detail_ == MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.newBuilder((MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1662) {
                        this.muqadasPotionInfoBuilder_.mergeFrom(value);
                    }
                    this.muqadasPotionInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearMuqadasPotionInfo() {
                if (this.muqadasPotionInfoBuilder_ != null) {
                    if (this.detailCase_ == 1662) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.muqadasPotionInfoBuilder_.clear();
                } else if (this.detailCase_ == 1662) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.Builder getMuqadasPotionInfoBuilder() {
                return getMuqadasPotionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder getMuqadasPotionInfoOrBuilder() {
                if (this.detailCase_ == 1662 && this.muqadasPotionInfoBuilder_ != null) {
                    return this.muqadasPotionInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1662) {
                    return (MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_;
                }
                return MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo, MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.Builder, MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfoOrBuilder> getMuqadasPotionInfoFieldBuilder() {
                if (this.muqadasPotionInfoBuilder_ == null) {
                    if (this.detailCase_ != 1662) {
                        this.detail_ = MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo.getDefaultInstance();
                    }
                    this.muqadasPotionInfoBuilder_ = new SingleFieldBuilderV3<>((MuqadasPotionActivityDetailInfoOuterClass.MuqadasPotionActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.MUQADAS_POTION_INFO_FIELD_NUMBER;
                onChanged();
                return this.muqadasPotionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasTreasureSeelieInfo() {
                return this.detailCase_ == 1032;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo getTreasureSeelieInfo() {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ == 1032) {
                        return (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_;
                    }
                    return TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1032) {
                    return this.treasureSeelieInfoBuilder_.getMessage();
                } else {
                    return TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setTreasureSeelieInfo(TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo value) {
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

            public Builder setTreasureSeelieInfo(TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.Builder builderForValue) {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.treasureSeelieInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeTreasureSeelieInfo(TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo value) {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ != 1032 || this.detail_ == TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.newBuilder((TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1032) {
                        this.treasureSeelieInfoBuilder_.mergeFrom(value);
                    }
                    this.treasureSeelieInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearTreasureSeelieInfo() {
                if (this.treasureSeelieInfoBuilder_ != null) {
                    if (this.detailCase_ == 1032) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.treasureSeelieInfoBuilder_.clear();
                } else if (this.detailCase_ == 1032) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.Builder getTreasureSeelieInfoBuilder() {
                return getTreasureSeelieInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder getTreasureSeelieInfoOrBuilder() {
                if (this.detailCase_ == 1032 && this.treasureSeelieInfoBuilder_ != null) {
                    return this.treasureSeelieInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1032) {
                    return (TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_;
                }
                return TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo, TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.Builder, TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfoOrBuilder> getTreasureSeelieInfoFieldBuilder() {
                if (this.treasureSeelieInfoBuilder_ == null) {
                    if (this.detailCase_ != 1032) {
                        this.detail_ = TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo.getDefaultInstance();
                    }
                    this.treasureSeelieInfoBuilder_ = new SingleFieldBuilderV3<>((TreasureSeelieActivityDetailInfoOuterClass.TreasureSeelieActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER;
                onChanged();
                return this.treasureSeelieInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasRockBoardExploreInfo() {
                return this.detailCase_ == 1265;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo getRockBoardExploreInfo() {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ == 1265) {
                        return (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_;
                    }
                    return RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1265) {
                    return this.rockBoardExploreInfoBuilder_.getMessage();
                } else {
                    return RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
                }
            }

            public Builder setRockBoardExploreInfo(RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo value) {
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

            public Builder setRockBoardExploreInfo(RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.Builder builderForValue) {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rockBoardExploreInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeRockBoardExploreInfo(RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo value) {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ != 1265 || this.detail_ == RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.newBuilder((RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1265) {
                        this.rockBoardExploreInfoBuilder_.mergeFrom(value);
                    }
                    this.rockBoardExploreInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearRockBoardExploreInfo() {
                if (this.rockBoardExploreInfoBuilder_ != null) {
                    if (this.detailCase_ == 1265) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.rockBoardExploreInfoBuilder_.clear();
                } else if (this.detailCase_ == 1265) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.Builder getRockBoardExploreInfoBuilder() {
                return getRockBoardExploreInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfoOrBuilder getRockBoardExploreInfoOrBuilder() {
                if (this.detailCase_ == 1265 && this.rockBoardExploreInfoBuilder_ != null) {
                    return this.rockBoardExploreInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1265) {
                    return (RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_;
                }
                return RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo, RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.Builder, RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfoOrBuilder> getRockBoardExploreInfoFieldBuilder() {
                if (this.rockBoardExploreInfoBuilder_ == null) {
                    if (this.detailCase_ != 1265) {
                        this.detail_ = RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo.getDefaultInstance();
                    }
                    this.rockBoardExploreInfoBuilder_ = new SingleFieldBuilderV3<>((RockBoardExploreDetailInfoOuterClass.RockBoardExploreDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.ROCK_BOARD_EXPLORE_INFO_FIELD_NUMBER;
                onChanged();
                return this.rockBoardExploreInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasVintageInfo() {
                return this.detailCase_ == 1308;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo getVintageInfo() {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ == 1308) {
                        return (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_;
                    }
                    return VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1308) {
                    return this.vintageInfoBuilder_.getMessage();
                } else {
                    return VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
                }
            }

            public Builder setVintageInfo(VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo value) {
                if (this.vintageInfoBuilder_ != null) {
                    this.vintageInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1308;
                return this;
            }

            public Builder setVintageInfo(VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder builderForValue) {
                if (this.vintageInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.vintageInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1308;
                return this;
            }

            public Builder mergeVintageInfo(VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo value) {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ != 1308 || this.detail_ == VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.newBuilder((VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1308) {
                        this.vintageInfoBuilder_.mergeFrom(value);
                    }
                    this.vintageInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1308;
                return this;
            }

            public Builder clearVintageInfo() {
                if (this.vintageInfoBuilder_ != null) {
                    if (this.detailCase_ == 1308) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.vintageInfoBuilder_.clear();
                } else if (this.detailCase_ == 1308) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder getVintageInfoBuilder() {
                return getVintageInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder getVintageInfoOrBuilder() {
                if (this.detailCase_ == 1308 && this.vintageInfoBuilder_ != null) {
                    return this.vintageInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1308) {
                    return (VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_;
                }
                return VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo, VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.Builder, VintageActivityDetailInfoOuterClass.VintageActivityDetailInfoOrBuilder> getVintageInfoFieldBuilder() {
                if (this.vintageInfoBuilder_ == null) {
                    if (this.detailCase_ != 1308) {
                        this.detail_ = VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo.getDefaultInstance();
                    }
                    this.vintageInfoBuilder_ = new SingleFieldBuilderV3<>((VintageActivityDetailInfoOuterClass.VintageActivityDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1308;
                onChanged();
                return this.vintageInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasWindFieldInfo() {
                return this.detailCase_ == 468;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WindFieldDetailInfoOuterClass.WindFieldDetailInfo getWindFieldInfo() {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ == 468) {
                        return (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_;
                    }
                    return WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 468) {
                    return this.windFieldInfoBuilder_.getMessage();
                } else {
                    return WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
                }
            }

            public Builder setWindFieldInfo(WindFieldDetailInfoOuterClass.WindFieldDetailInfo value) {
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

            public Builder setWindFieldInfo(WindFieldDetailInfoOuterClass.WindFieldDetailInfo.Builder builderForValue) {
                if (this.windFieldInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.windFieldInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder mergeWindFieldInfo(WindFieldDetailInfoOuterClass.WindFieldDetailInfo value) {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ != 468 || this.detail_ == WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = WindFieldDetailInfoOuterClass.WindFieldDetailInfo.newBuilder((WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 468) {
                        this.windFieldInfoBuilder_.mergeFrom(value);
                    }
                    this.windFieldInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                return this;
            }

            public Builder clearWindFieldInfo() {
                if (this.windFieldInfoBuilder_ != null) {
                    if (this.detailCase_ == 468) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.windFieldInfoBuilder_.clear();
                } else if (this.detailCase_ == 468) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public WindFieldDetailInfoOuterClass.WindFieldDetailInfo.Builder getWindFieldInfoBuilder() {
                return getWindFieldInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public WindFieldDetailInfoOuterClass.WindFieldDetailInfoOrBuilder getWindFieldInfoOrBuilder() {
                if (this.detailCase_ == 468 && this.windFieldInfoBuilder_ != null) {
                    return this.windFieldInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 468) {
                    return (WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_;
                }
                return WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<WindFieldDetailInfoOuterClass.WindFieldDetailInfo, WindFieldDetailInfoOuterClass.WindFieldDetailInfo.Builder, WindFieldDetailInfoOuterClass.WindFieldDetailInfoOrBuilder> getWindFieldInfoFieldBuilder() {
                if (this.windFieldInfoBuilder_ == null) {
                    if (this.detailCase_ != 468) {
                        this.detail_ = WindFieldDetailInfoOuterClass.WindFieldDetailInfo.getDefaultInstance();
                    }
                    this.windFieldInfoBuilder_ = new SingleFieldBuilderV3<>((WindFieldDetailInfoOuterClass.WindFieldDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = ActivityInfo.WIND_FIELD_INFO_FIELD_NUMBER;
                onChanged();
                return this.windFieldInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasFungusFighterInfo() {
                return this.detailCase_ == 1757;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo getFungusFighterInfo() {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ == 1757) {
                        return (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_;
                    }
                    return FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1757) {
                    return this.fungusFighterInfoBuilder_.getMessage();
                } else {
                    return FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
                }
            }

            public Builder setFungusFighterInfo(FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo value) {
                if (this.fungusFighterInfoBuilder_ != null) {
                    this.fungusFighterInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1757;
                return this;
            }

            public Builder setFungusFighterInfo(FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.Builder builderForValue) {
                if (this.fungusFighterInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fungusFighterInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1757;
                return this;
            }

            public Builder mergeFungusFighterInfo(FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo value) {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1757 || this.detail_ == FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.newBuilder((FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1757) {
                        this.fungusFighterInfoBuilder_.mergeFrom(value);
                    }
                    this.fungusFighterInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1757;
                return this;
            }

            public Builder clearFungusFighterInfo() {
                if (this.fungusFighterInfoBuilder_ != null) {
                    if (this.detailCase_ == 1757) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.fungusFighterInfoBuilder_.clear();
                } else if (this.detailCase_ == 1757) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.Builder getFungusFighterInfoBuilder() {
                return getFungusFighterInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder getFungusFighterInfoOrBuilder() {
                if (this.detailCase_ == 1757 && this.fungusFighterInfoBuilder_ != null) {
                    return this.fungusFighterInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1757) {
                    return (FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_;
                }
                return FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo, FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.Builder, FungusFighterDetailInfoOuterClass.FungusFighterDetailInfoOrBuilder> getFungusFighterInfoFieldBuilder() {
                if (this.fungusFighterInfoBuilder_ == null) {
                    if (this.detailCase_ != 1757) {
                        this.detail_ = FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo.getDefaultInstance();
                    }
                    this.fungusFighterInfoBuilder_ = new SingleFieldBuilderV3<>((FungusFighterDetailInfoOuterClass.FungusFighterDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1757;
                onChanged();
                return this.fungusFighterInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCharAmusementInfo() {
                return this.detailCase_ == 621;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo getCharAmusementInfo() {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ == 621) {
                        return (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_;
                    }
                    return CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 621) {
                    return this.charAmusementInfoBuilder_.getMessage();
                } else {
                    return CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
                }
            }

            public Builder setCharAmusementInfo(CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo value) {
                if (this.charAmusementInfoBuilder_ != null) {
                    this.charAmusementInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 621;
                return this;
            }

            public Builder setCharAmusementInfo(CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.Builder builderForValue) {
                if (this.charAmusementInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.charAmusementInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 621;
                return this;
            }

            public Builder mergeCharAmusementInfo(CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo value) {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ != 621 || this.detail_ == CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.newBuilder((CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 621) {
                        this.charAmusementInfoBuilder_.mergeFrom(value);
                    }
                    this.charAmusementInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 621;
                return this;
            }

            public Builder clearCharAmusementInfo() {
                if (this.charAmusementInfoBuilder_ != null) {
                    if (this.detailCase_ == 621) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.charAmusementInfoBuilder_.clear();
                } else if (this.detailCase_ == 621) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.Builder getCharAmusementInfoBuilder() {
                return getCharAmusementInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder getCharAmusementInfoOrBuilder() {
                if (this.detailCase_ == 621 && this.charAmusementInfoBuilder_ != null) {
                    return this.charAmusementInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 621) {
                    return (CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_;
                }
                return CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo, CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.Builder, CharAmusementDetailInfoOuterClass.CharAmusementDetailInfoOrBuilder> getCharAmusementInfoFieldBuilder() {
                if (this.charAmusementInfoBuilder_ == null) {
                    if (this.detailCase_ != 621) {
                        this.detail_ = CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo.getDefaultInstance();
                    }
                    this.charAmusementInfoBuilder_ = new SingleFieldBuilderV3<>((CharAmusementDetailInfoOuterClass.CharAmusementDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 621;
                onChanged();
                return this.charAmusementInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasEffigyChallengeInfo() {
                return this.detailCase_ == 233;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo getEffigyChallengeInfo() {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ == 233) {
                        return (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_;
                    }
                    return EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 233) {
                    return this.effigyChallengeInfoBuilder_.getMessage();
                } else {
                    return EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
                }
            }

            public Builder setEffigyChallengeInfo(EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo value) {
                if (this.effigyChallengeInfoBuilder_ != null) {
                    this.effigyChallengeInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 233;
                return this;
            }

            public Builder setEffigyChallengeInfo(EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.Builder builderForValue) {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.effigyChallengeInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 233;
                return this;
            }

            public Builder mergeEffigyChallengeInfo(EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo value) {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 233 || this.detail_ == EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.newBuilder((EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 233) {
                        this.effigyChallengeInfoBuilder_.mergeFrom(value);
                    }
                    this.effigyChallengeInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 233;
                return this;
            }

            public Builder clearEffigyChallengeInfo() {
                if (this.effigyChallengeInfoBuilder_ != null) {
                    if (this.detailCase_ == 233) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.effigyChallengeInfoBuilder_.clear();
                } else if (this.detailCase_ == 233) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.Builder getEffigyChallengeInfoBuilder() {
                return getEffigyChallengeInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder getEffigyChallengeInfoOrBuilder() {
                if (this.detailCase_ == 233 && this.effigyChallengeInfoBuilder_ != null) {
                    return this.effigyChallengeInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 233) {
                    return (EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_;
                }
                return EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo, EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.Builder, EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfoOrBuilder> getEffigyChallengeInfoFieldBuilder() {
                if (this.effigyChallengeInfoBuilder_ == null) {
                    if (this.detailCase_ != 233) {
                        this.detail_ = EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo.getDefaultInstance();
                    }
                    this.effigyChallengeInfoBuilder_ = new SingleFieldBuilderV3<>((EffigyChallengeV2DetailInfoOuterClass.EffigyChallengeV2DetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 233;
                onChanged();
                return this.effigyChallengeInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasCoinCollectInfo() {
                return this.detailCase_ == 2002;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo getCoinCollectInfo() {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ == 2002) {
                        return (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_;
                    }
                    return CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 2002) {
                    return this.coinCollectInfoBuilder_.getMessage();
                } else {
                    return CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
                }
            }

            public Builder setCoinCollectInfo(CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo value) {
                if (this.coinCollectInfoBuilder_ != null) {
                    this.coinCollectInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 2002;
                return this;
            }

            public Builder setCoinCollectInfo(CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.Builder builderForValue) {
                if (this.coinCollectInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.coinCollectInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 2002;
                return this;
            }

            public Builder mergeCoinCollectInfo(CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo value) {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ != 2002 || this.detail_ == CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.newBuilder((CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 2002) {
                        this.coinCollectInfoBuilder_.mergeFrom(value);
                    }
                    this.coinCollectInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 2002;
                return this;
            }

            public Builder clearCoinCollectInfo() {
                if (this.coinCollectInfoBuilder_ != null) {
                    if (this.detailCase_ == 2002) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.coinCollectInfoBuilder_.clear();
                } else if (this.detailCase_ == 2002) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.Builder getCoinCollectInfoBuilder() {
                return getCoinCollectInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder getCoinCollectInfoOrBuilder() {
                if (this.detailCase_ == 2002 && this.coinCollectInfoBuilder_ != null) {
                    return this.coinCollectInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 2002) {
                    return (CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_;
                }
                return CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo, CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.Builder, CoinCollectDetailInfoOuterClass.CoinCollectDetailInfoOrBuilder> getCoinCollectInfoFieldBuilder() {
                if (this.coinCollectInfoBuilder_ == null) {
                    if (this.detailCase_ != 2002) {
                        this.detail_ = CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo.getDefaultInstance();
                    }
                    this.coinCollectInfoBuilder_ = new SingleFieldBuilderV3<>((CoinCollectDetailInfoOuterClass.CoinCollectDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 2002;
                onChanged();
                return this.coinCollectInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public boolean hasBrickBreakerInfo() {
                return this.detailCase_ == 1522;
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo getBrickBreakerInfo() {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ == 1522) {
                        return (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_;
                    }
                    return BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
                } else if (this.detailCase_ == 1522) {
                    return this.brickBreakerInfoBuilder_.getMessage();
                } else {
                    return BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
                }
            }

            public Builder setBrickBreakerInfo(BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo value) {
                if (this.brickBreakerInfoBuilder_ != null) {
                    this.brickBreakerInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.detail_ = value;
                    onChanged();
                }
                this.detailCase_ = 1522;
                return this;
            }

            public Builder setBrickBreakerInfo(BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder builderForValue) {
                if (this.brickBreakerInfoBuilder_ == null) {
                    this.detail_ = builderForValue.build();
                    onChanged();
                } else {
                    this.brickBreakerInfoBuilder_.setMessage(builderForValue.build());
                }
                this.detailCase_ = 1522;
                return this;
            }

            public Builder mergeBrickBreakerInfo(BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo value) {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1522 || this.detail_ == BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance()) {
                        this.detail_ = value;
                    } else {
                        this.detail_ = BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.newBuilder((BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.detailCase_ == 1522) {
                        this.brickBreakerInfoBuilder_.mergeFrom(value);
                    }
                    this.brickBreakerInfoBuilder_.setMessage(value);
                }
                this.detailCase_ = 1522;
                return this;
            }

            public Builder clearBrickBreakerInfo() {
                if (this.brickBreakerInfoBuilder_ != null) {
                    if (this.detailCase_ == 1522) {
                        this.detailCase_ = 0;
                        this.detail_ = null;
                    }
                    this.brickBreakerInfoBuilder_.clear();
                } else if (this.detailCase_ == 1522) {
                    this.detailCase_ = 0;
                    this.detail_ = null;
                    onChanged();
                }
                return this;
            }

            public BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder getBrickBreakerInfoBuilder() {
                return getBrickBreakerInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ActivityInfoOuterClass.ActivityInfoOrBuilder
            public BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder getBrickBreakerInfoOrBuilder() {
                if (this.detailCase_ == 1522 && this.brickBreakerInfoBuilder_ != null) {
                    return this.brickBreakerInfoBuilder_.getMessageOrBuilder();
                }
                if (this.detailCase_ == 1522) {
                    return (BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_;
                }
                return BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
            }

            private SingleFieldBuilderV3<BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo, BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.Builder, BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfoOrBuilder> getBrickBreakerInfoFieldBuilder() {
                if (this.brickBreakerInfoBuilder_ == null) {
                    if (this.detailCase_ != 1522) {
                        this.detail_ = BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo.getDefaultInstance();
                    }
                    this.brickBreakerInfoBuilder_ = new SingleFieldBuilderV3<>((BrickBreakerDetailInfoOuterClass.BrickBreakerDetailInfo) this.detail_, getParentForChildren(), isClean());
                    this.detail_ = null;
                }
                this.detailCase_ = 1522;
                onChanged();
                return this.brickBreakerInfoBuilder_;
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
        ActivityPushTipsDataOuterClass.getDescriptor();
        ActivityWatcherInfoOuterClass.getDescriptor();
        ArenaChallengeActivityDetailInfoOuterClass.getDescriptor();
        AsterActivityDetailInfoOuterClass.getDescriptor();
        BartenderActivityDetailInfoOuterClass.getDescriptor();
        BlessingActivityDetailInfoOuterClass.getDescriptor();
        BlitzRushActivityDetailInfoOuterClass.getDescriptor();
        BounceConjuringActivityDetailInfoOuterClass.getDescriptor();
        BrickBreakerDetailInfoOuterClass.getDescriptor();
        BuoyantCombatDetailInfoOuterClass.getDescriptor();
        ChannelerSlabActivityDetailInfoOuterClass.getDescriptor();
        CharAmusementDetailInfoOuterClass.getDescriptor();
        ChessActivityDetailInfoOuterClass.getDescriptor();
        CoinCollectDetailInfoOuterClass.getDescriptor();
        CrucibleActivityDetailInfoOuterClass.getDescriptor();
        CrystalLinkActivityDetailInfoOuterClass.getDescriptor();
        DeliveryActivityDetailInfoOuterClass.getDescriptor();
        DigActivityDetailInfoOuterClass.getDescriptor();
        DragonSpineActivityDetailInfoOuterClass.getDescriptor();
        EchoShellDetailInfoOuterClass.getDescriptor();
        EffigyActivityDetailInfoOuterClass.getDescriptor();
        EffigyChallengeV2DetailInfoOuterClass.getDescriptor();
        ExpeditionActivityDetailInfoOuterClass.getDescriptor();
        FindHilichurlDetailInfoOuterClass.getDescriptor();
        FleurFairActivityDetailInfoOuterClass.getDescriptor();
        FlightActivityDetailInfoOuterClass.getDescriptor();
        FungusFighterDetailInfoOuterClass.getDescriptor();
        GachaActivityDetailInfoOuterClass.getDescriptor();
        GearActivityDetailInfoOuterClass.getDescriptor();
        GravenInnocenceDetailInfoOuterClass.getDescriptor();
        HachiActivityDetailInfoOuterClass.getDescriptor();
        HideAndSeekActivityDetailInfoOuterClass.getDescriptor();
        InstableSprayDetailInfoOuterClass.getDescriptor();
        IrodoriActivityDetailInfoOuterClass.getDescriptor();
        IslandPartyDetailInfoOuterClass.getDescriptor();
        LanternRiteActivityDetailInfoOuterClass.getDescriptor();
        LuminanceStoneChallengeActivityDetailInfoOuterClass.getDescriptor();
        LunaRiteDetailInfoOuterClass.getDescriptor();
        MichiaeMatsuriActivityDetailInfoOuterClass.getDescriptor();
        MistTrialActivityDetailInfoOuterClass.getDescriptor();
        MoonfinTrialActivityDetailInfoOuterClass.getDescriptor();
        MuqadasPotionActivityDetailInfoOuterClass.getDescriptor();
        MusicGameActivityDetailInfoOuterClass.getDescriptor();
        PhotoActivityDetailInfoOuterClass.getDescriptor();
        PlantFlowerActivityDetailInfoOuterClass.getDescriptor();
        PotionActivityDetailInfoOuterClass.getDescriptor();
        RockBoardExploreDetailInfoOuterClass.getDescriptor();
        RogueDiaryActivityDetailInfoOuterClass.getDescriptor();
        RoguelikeDungeonActivityDetailInfoOuterClass.getDescriptor();
        SalesmanActivityDetailInfoOuterClass.getDescriptor();
        SeaLampActivityDetailInfoOuterClass.getDescriptor();
        SeaLampActivityInfoOuterClass.getDescriptor();
        SpiceActivityDetailInfoOuterClass.getDescriptor();
        SummerTimeDetailInfoOuterClass.getDescriptor();
        SummerTimeV2DetailInfoOuterClass.getDescriptor();
        SumoActivityDetailInfoOuterClass.getDescriptor();
        TanukiTravelActivityDetailInfoOuterClass.getDescriptor();
        TreasureMapActivityDetailInfoOuterClass.getDescriptor();
        TreasureSeelieActivityDetailInfoOuterClass.getDescriptor();
        TrialAvatarActivityDetailInfoOuterClass.getDescriptor();
        UgcActivityDetailInfoOuterClass.getDescriptor();
        VintageActivityDetailInfoOuterClass.getDescriptor();
        WaterSpiritActivityDetailInfoOuterClass.getDescriptor();
        WindFieldDetailInfoOuterClass.getDescriptor();
        WinterCampActivityDetailInfoOuterClass.getDescriptor();
    }
}
