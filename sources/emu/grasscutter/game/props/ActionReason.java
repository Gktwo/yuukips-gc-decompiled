package emu.grasscutter.game.props;

import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.DungeonSettleNotifyOuterClass;
import emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass;
import emu.grasscutter.net.proto.MusicGameCreateBeatmapReqOuterClass;
import emu.grasscutter.net.proto.PlayerLoginReqOuterClass;
import emu.grasscutter.net.proto.ShopGoodsOuterClass;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.eclipse.jetty.websocket.api.StatusCode;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ActionReason.class */
public enum ActionReason {
    None(0),
    QuestItem(1),
    QuestReward(2),
    Trifle(3),
    Shop(4),
    PlayerUpgradeReward(5),
    AddAvatar(6),
    GadgetEnvAnimal(7),
    MonsterEnvAnimal(8),
    Compound(9),
    Cook(10),
    Gather(11),
    MailAttachment(12),
    CityLevelupReturn(15),
    CityLevelupReward(17),
    AreaExploreReward(18),
    UnlockPointReward(19),
    DungeonFirstPass(20),
    DungeonPass(21),
    ChangeElemType(23),
    FetterOpen(25),
    DailyTaskScore(26),
    DailyTaskHost(27),
    RandTaskHost(28),
    Expedition(29),
    Gacha(30),
    Combine(31),
    RandTaskGuest(32),
    DailyTaskGuest(33),
    ForgeOutput(34),
    ForgeReturn(35),
    InitAvatar(36),
    MonsterDie(37),
    Gm(38),
    OpenChest(39),
    GadgetDie(40),
    MonsterChangeHp(41),
    SubfieldDrop(42),
    PushTipsReward(43),
    ActivityMonsterDrop(44),
    ActivityGather(45),
    ActivitySubfieldDrop(46),
    TowerScheduleReward(47),
    TowerFloorStarReward(48),
    TowerFirstPassReward(49),
    TowerDailyReward(50),
    HitClientTrivialEntity(51),
    OpenWorldBossChest(52),
    MaterialDeleteReturn(53),
    SignInReward(54),
    OpenBlossomChest(55),
    Recharge(56),
    BonusActivityReward(57),
    TowerCommemorativeReward(58),
    TowerSkipFloorReward(59),
    RechargeBonus(60),
    RechargeCard(61),
    RechargeCardDaily(62),
    RechargeCardReplace(63),
    RechargeCardReplaceFree(64),
    RechargePlayReplace(65),
    MpPlayTakeReward(66),
    ActivityWatcher(67),
    SalesmanDeliverItem(68),
    SalesmanReward(69),
    Rebate(70),
    McoinExchangeHcoin(71),
    DailyTaskExchangeLegendaryKey(72),
    UnlockPersonLine(73),
    FetterLevelReward(74),
    BuyResin(75),
    RechargePackage(76),
    DeliveryDailyReward(77),
    CityReputationLevel(78),
    CityReputationQuest(79),
    CityReputationRequest(80),
    CityReputationExplore(81),
    OffergingLevel(82),
    RoutineHost(83),
    RoutineGuest(84),
    TreasureMapSpotToken(89),
    TreasureMapBonusLevelReward(90),
    TreasureMapMpReward(91),
    Convert(92),
    OverflowTransform(93),
    ActivityAvatarSelectionReward(96),
    ActivityWatcherBatch(97),
    HitTreeDrop(98),
    GetHomeLevelupReward(99),
    HomeDefaultFurniture(100),
    ActivityCond(101),
    BattlePassNotify(102),
    PlayerUseItem(1001),
    DropItem(1002),
    WeaponUpgrade(StatusCode.SERVER_ERROR),
    WeaponPromote(StatusCode.SERVICE_RESTART),
    WeaponAwaken(StatusCode.TRY_AGAIN_LATER),
    RelicUpgrade(StatusCode.INVALID_UPSTREAM_RESPONSE),
    Ability(StatusCode.FAILED_TLS_HANDSHAKE),
    DungeonStatueDrop(1016),
    OfflineMsg(1017),
    AvatarUpgrade(1018),
    AvatarPromote(PacketOpcodes.AvatarSkillDepotChangeNotify),
    QuestAction(MusicGameCreateBeatmapReqOuterClass.MusicGameCreateBeatmapReq.MUSIC_BRIEF_INFO_FIELD_NUMBER),
    CityLevelup(1022),
    UpgradeSkill(1024),
    UnlockTalent(PacketOpcodes.ProudSkillExtraLevelNotify),
    UpgradeProudSkill(1026),
    PlayerLevelLimitUp(PacketOpcodes.ProudSkillChangeNotify),
    DungeonDaily(PlayerLoginReqOuterClass.PlayerLoginReq.UNK3300_OFFHPAFIFGD_FIELD_NUMBER),
    ItemGiving(PacketOpcodes.UnlockAvatarTalentRsp),
    ForgeCost(1031),
    InvestigationReward(ActivityInfoOuterClass.ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER),
    InvestigationTargetReward(1033),
    GadgetInteract(1034),
    SeaLampCiMaterial(1036),
    SeaLampContributionReward(ShopGoodsOuterClass.ShopGoods.UNK3300_OMKIFIMDGDN_FIELD_NUMBER),
    SeaLampPhaseReward(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.SUB_CHANNEL_ID_FIELD_NUMBER),
    SeaLampFlyLamp(PacketOpcodes.AvatarSkillUpgradeReq),
    AutoRecover(1040),
    ActivityExpireItem(1041),
    SubCoinNegative(PacketOpcodes.CanUseSkillNotify),
    BargainDeduct(PacketOpcodes.BigTalentPointConvertRsp),
    BattlePassPaidReward(1044),
    BattlePassLevelReward(1045),
    TrialAvatarActivityFirstPassReward(1046),
    BuyBattlePassLevel(PacketOpcodes.AvatarSkillInfoNotify),
    GrantBirthdayBenefit(PacketOpcodes.AvatarSkillUpgradeRsp),
    AchievementReward(1049),
    AchievementGoalReward(1050),
    FirstShareToSocialNetwork(1051),
    DestroyMaterial(1052),
    CodexLevelupReward(1053),
    HuntingOfferReward(1054),
    UseWidgetAnchorPoint(1055),
    UseWidgetBonfire(1056),
    UngradeWeaponReturnMaterial(PacketOpcodes.ProudSkillUpgradeRsp),
    UseWidgetOneoffGatherPointDetector(1058),
    UseWidgetClientCollector(1059),
    UseWidgetClientDetector(1060),
    TakeGeneralReward(PacketOpcodes.AvatarSkillMaxChargeCountNotify),
    AsterTakeSpecialReward(1062),
    RemoveCodexBook(1063),
    OfferingItem(1064),
    UseWidgetGadgetBuilder(1065),
    EffigyFirstPassReward(1066),
    EffigyReward(1067),
    ReunionFirstGiftReward(1068),
    ReunionSignInReward(1069),
    ReunionWatcherReward(1070),
    SalesmanMpReward(1071),
    ActionReasionAvatarPromoteReward(1072),
    BlessingRedeemReward(1073),
    ActionMiracleRingReward(1074),
    ExpeditionReward(1075),
    TreasureMapRemoveDetector(1076),
    MechanicusDungeonTicket(1077),
    MechanicusLevelupGear(PacketOpcodes.ProudSkillUpgradeReq),
    MechanicusBattleSettle(PacketOpcodes.UnlockAvatarTalentReq),
    RegionSearchReward(1080),
    UnlockCoopChapter(1081),
    TakeCoopReward(1082),
    FleurFairDungeonReward(1083),
    ActivityScore(1084),
    ChannellerSlabOneoffDungeonReward(1085),
    FurnitureMakeStart(1086),
    FurnitureMakeTake(1087),
    FurnitureMakeCancel(1088),
    FurnitureMakeFastFinish(DungeonSettleNotifyOuterClass.DungeonSettleNotify.TOWER_LEVEL_END_NOTIFY_FIELD_NUMBER),
    ChannellerSlabLoopDungeonFirstPassReward(PacketOpcodes.TeamResonanceChangeNotify),
    ChannellerSlabLoopDungeonScoreReward(1091),
    HomeLimitedShopBuy(1092),
    HomeCoinCollect(1093);
    
    private final int value;
    private static final Int2ObjectMap<ActionReason> map = new Int2ObjectOpenHashMap();
    private static final Map<String, ActionReason> stringMap = new HashMap();

    static {
        Stream.of((Object[]) values()).forEach(e -> {
            map.put(e.getValue(), (int) e);
            stringMap.put(e.name(), e);
        });
    }

    ActionReason(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static ActionReason getTypeByValue(int value) {
        return map.getOrDefault(value, (int) None);
    }

    public static ActionReason getTypeByName(String name) {
        return stringMap.getOrDefault(name, None);
    }
}
