package emu.grasscutter.data;

import emu.grasscutter.data.binout.AbilityData;
import emu.grasscutter.data.binout.AbilityEmbryoEntry;
import emu.grasscutter.data.binout.AbilityModifierEntry;
import emu.grasscutter.data.binout.ConfigGadget;
import emu.grasscutter.data.binout.ConfigLevelEntity;
import emu.grasscutter.data.binout.HomeworldDefaultSaveData;
import emu.grasscutter.data.binout.MainQuestData;
import emu.grasscutter.data.binout.OpenConfigEntry;
import emu.grasscutter.data.binout.SceneNpcBornData;
import emu.grasscutter.data.binout.ScenePointEntry;
import emu.grasscutter.data.binout.ScriptSceneData;
import emu.grasscutter.data.binout.routes.Route;
import emu.grasscutter.data.excels.ActivityCondExcelConfigData;
import emu.grasscutter.data.excels.ActivityData;
import emu.grasscutter.data.excels.ActivityShopData;
import emu.grasscutter.data.excels.ActivityWatcherData;
import emu.grasscutter.data.excels.AvatarCostumeData;
import emu.grasscutter.data.excels.AvatarCurveData;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.AvatarFetterLevelData;
import emu.grasscutter.data.excels.AvatarFlycloakData;
import emu.grasscutter.data.excels.AvatarLevelData;
import emu.grasscutter.data.excels.AvatarPromoteData;
import emu.grasscutter.data.excels.AvatarSkillData;
import emu.grasscutter.data.excels.AvatarSkillDepotData;
import emu.grasscutter.data.excels.AvatarTalentData;
import emu.grasscutter.data.excels.BattlePassMissionData;
import emu.grasscutter.data.excels.BattlePassRewardData;
import emu.grasscutter.data.excels.BlossomRefreshExcelConfigData;
import emu.grasscutter.data.excels.BuffData;
import emu.grasscutter.data.excels.ChapterData;
import emu.grasscutter.data.excels.CityData;
import emu.grasscutter.data.excels.CodexAnimalData;
import emu.grasscutter.data.excels.CodexMaterialData;
import emu.grasscutter.data.excels.CodexQuestData;
import emu.grasscutter.data.excels.CodexReliquaryData;
import emu.grasscutter.data.excels.CodexWeaponData;
import emu.grasscutter.data.excels.CombineData;
import emu.grasscutter.data.excels.CompoundData;
import emu.grasscutter.data.excels.CookBonusData;
import emu.grasscutter.data.excels.CookRecipeData;
import emu.grasscutter.data.excels.DailyDungeonData;
import emu.grasscutter.data.excels.DailyTaskData;
import emu.grasscutter.data.excels.DailyTaskLevelData;
import emu.grasscutter.data.excels.DailyTaskRewardData;
import emu.grasscutter.data.excels.DropMaterialData;
import emu.grasscutter.data.excels.DropTableData;
import emu.grasscutter.data.excels.DungeonChallengeConfigData;
import emu.grasscutter.data.excels.DungeonData;
import emu.grasscutter.data.excels.DungeonEntryData;
import emu.grasscutter.data.excels.DungeonPassConfigData;
import emu.grasscutter.data.excels.EnvAnimalGatherConfigData;
import emu.grasscutter.data.excels.EquipAffixData;
import emu.grasscutter.data.excels.FetterCharacterCardData;
import emu.grasscutter.data.excels.FetterData;
import emu.grasscutter.data.excels.ForgeData;
import emu.grasscutter.data.excels.FurnitureMakeConfigData;
import emu.grasscutter.data.excels.GadgetData;
import emu.grasscutter.data.excels.GatherData;
import emu.grasscutter.data.excels.HomeWorldBgmData;
import emu.grasscutter.data.excels.HomeWorldLevelData;
import emu.grasscutter.data.excels.InvestigationMonsterData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.data.excels.MonsterCurveData;
import emu.grasscutter.data.excels.MonsterData;
import emu.grasscutter.data.excels.MonsterDescribeData;
import emu.grasscutter.data.excels.MonsterSpecialNameData;
import emu.grasscutter.data.excels.MusicGameBasicData;
import emu.grasscutter.data.excels.NpcData;
import emu.grasscutter.data.excels.OpenStateData;
import emu.grasscutter.data.excels.PersonalLineData;
import emu.grasscutter.data.excels.PlayerLevelData;
import emu.grasscutter.data.excels.ProudSkillData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.data.excels.ReliquaryAffixData;
import emu.grasscutter.data.excels.ReliquaryLevelData;
import emu.grasscutter.data.excels.ReliquaryMainPropData;
import emu.grasscutter.data.excels.ReliquarySetData;
import emu.grasscutter.data.excels.RewardData;
import emu.grasscutter.data.excels.RewardPreviewData;
import emu.grasscutter.data.excels.SceneData;
import emu.grasscutter.data.excels.ShopGoodsData;
import emu.grasscutter.data.excels.TowerFloorData;
import emu.grasscutter.data.excels.TowerLevelData;
import emu.grasscutter.data.excels.TowerScheduleData;
import emu.grasscutter.data.excels.TriggerExcelConfigData;
import emu.grasscutter.data.excels.WeaponCurveData;
import emu.grasscutter.data.excels.WeaponLevelData;
import emu.grasscutter.data.excels.WeaponPromoteData;
import emu.grasscutter.data.excels.WeatherData;
import emu.grasscutter.data.excels.WorldAreaData;
import emu.grasscutter.data.excels.WorldLevelData;
import emu.grasscutter.game.quest.QuestEncryptionKey;
import emu.grasscutter.game.quest.RewindData;
import emu.grasscutter.game.quest.TeleportData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import p014it.unimi.dsi.fastutil.ints.Int2IntMap;
import p014it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.ints.IntArrayList;
import p014it.unimi.dsi.fastutil.ints.IntList;
import p014it.unimi.dsi.fastutil.ints.IntSet;

/* loaded from: grasscutter.jar:emu/grasscutter/data/GameData.class */
public class GameData {
    private static List<Integer> specialQuest = new ArrayList();
    private static final Int2ObjectMap<HomeworldDefaultSaveData> homeworldDefaultSaveData = new Int2ObjectOpenHashMap();
    private static Map<Integer, Integer> questGiveAvatar = new HashMap();
    private static final Int2ObjectMap<String> abilityHashes = new Int2ObjectOpenHashMap();
    @Deprecated(forRemoval = true)
    private static final Map<String, AbilityModifierEntry> abilityModifiers = new HashMap();
    protected static final Map<String, AbilityData> abilityDataMap = new HashMap();
    private static final Map<String, ConfigGadget> gadgetConfigData = new HashMap();
    private static final Map<String, OpenConfigEntry> openConfigEntries = new HashMap();
    @Deprecated(forRemoval = true)
    private static final Map<String, ScenePointEntry> scenePointEntries = new HashMap();
    protected static final Int2ObjectMap<ScenePointEntry> scenePointEntryMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MainQuestData> mainQuestData = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<QuestEncryptionKey> questsKeys = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<SceneNpcBornData> npcBornData = new Int2ObjectOpenHashMap();
    private static final Map<String, AbilityEmbryoEntry> abilityEmbryos = new HashMap();
    private static final ArrayList<CodexReliquaryData> codexReliquaryArrayList = new ArrayList<>();
    private static final Int2ObjectMap<ActivityData> activityDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ActivityShopData> activityShopDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ActivityWatcherData> activityWatcherDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarCostumeData> avatarCostumeDataItemIdMap = new Int2ObjectLinkedOpenHashMap();
    private static final Int2ObjectMap<AvatarCostumeData> avatarCostumeDataMap = new Int2ObjectLinkedOpenHashMap();
    private static final Int2ObjectMap<AvatarCurveData> avatarCurveDataMap = new Int2ObjectLinkedOpenHashMap();
    private static final Int2ObjectMap<AvatarData> avatarDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarFetterLevelData> avatarFetterLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarFlycloakData> avatarFlycloakDataMap = new Int2ObjectLinkedOpenHashMap();
    private static final Int2ObjectMap<AvatarLevelData> avatarLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarSkillData> avatarSkillDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarSkillDepotData> avatarSkillDepotDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarTalentData> avatarTalentDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<BattlePassMissionData> battlePassMissionDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ActivityCondExcelConfigData> activityCondExcelConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DungeonChallengeConfigData> dungeonChallengeConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<BattlePassRewardData> battlePassRewardDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<BlossomRefreshExcelConfigData> blossomRefreshExcelConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<BuffData> buffDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ChapterData> chapterDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CityData> cityDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexAnimalData> codexAnimalDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexMaterialData> codexMaterialDataIdMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexQuestData> codexQuestDataIdMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexReliquaryData> codexReliquaryDataIdMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexWeaponData> codexWeaponDataIdMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DailyTaskData> dailyTaskDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DailyTaskLevelData> dailyTaskLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DailyTaskRewardData> dailyTaskRewardDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CombineData> combineDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CookBonusData> cookBonusDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CookRecipeData> cookRecipeDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CompoundData> compoundDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DailyDungeonData> dailyDungeonDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DropTableData> dropTableDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DropMaterialData> dropMaterialDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DungeonData> dungeonDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DungeonPassConfigData> dungeonPassConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<DungeonEntryData> dungeonEntryDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<EnvAnimalGatherConfigData> envAnimalGatherConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<EquipAffixData> equipAffixDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<Int2ObjectMap<Route>> sceneRouteData = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<FetterCharacterCardData> fetterCharacterCardDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ForgeData> forgeDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<FurnitureMakeConfigData> furnitureMakeConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<GadgetData> gadgetDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<GatherData> gatherDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<HomeWorldBgmData> homeWorldBgmDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<HomeWorldLevelData> homeWorldLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<InvestigationMonsterData> investigationMonsterDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ItemData> itemDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MonsterCurveData> monsterCurveDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MonsterData> monsterDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MonsterDescribeData> monsterDescribeDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MonsterSpecialNameData> monsterSpecialNameDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<MusicGameBasicData> musicGameBasicDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<NpcData> npcDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<OpenStateData> openStateDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<PersonalLineData> personalLineDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<PlayerLevelData> playerLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ProudSkillData> proudSkillDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<QuestData> questDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ReliquaryAffixData> reliquaryAffixDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ReliquaryMainPropData> reliquaryMainPropDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ReliquarySetData> reliquarySetDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<RewardData> rewardDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<RewardPreviewData> rewardPreviewDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<SceneData> sceneDataMap = new Int2ObjectLinkedOpenHashMap();
    private static final Int2ObjectMap<TowerFloorData> towerFloorDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<TowerLevelData> towerLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<TowerScheduleData> towerScheduleDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<TriggerExcelConfigData> triggerExcelConfigDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WeaponCurveData> weaponCurveDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WeaponLevelData> weaponLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WeaponPromoteData> weaponPromoteDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WeatherData> weatherDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WorldAreaData> worldAreaDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<WorldLevelData> worldLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<AvatarPromoteData> avatarPromoteDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<FetterData> fetterDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ReliquaryLevelData> reliquaryLevelDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<ShopGoodsData> shopGoodsDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<RewindData> rewindDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<TeleportData> teleportDataMap = new Int2ObjectOpenHashMap();
    protected static Int2ObjectMap<IntSet> proudSkillGroupLevels = new Int2ObjectOpenHashMap();
    protected static Int2IntMap proudSkillGroupMaxLevels = new Int2IntOpenHashMap();
    protected static Int2ObjectMap<IntSet> avatarSkillLevels = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexMaterialData> codexMaterialDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexQuestData> codexQuestDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexReliquaryData> codexReliquaryDataMap = new Int2ObjectOpenHashMap();
    private static final Int2ObjectMap<CodexWeaponData> codexWeaponDataMap = new Int2ObjectOpenHashMap();
    private static final IntList scenePointIdList = new IntArrayList();
    private static final List<OpenStateData> openStateList = new ArrayList();
    private static final Map<Integer, List<Integer>> scenePointsPerScene = new HashMap();
    private static final Map<String, ScriptSceneData> scriptSceneDataMap = new HashMap();
    private static final Map<String, ConfigLevelEntity> configLevelEntityDataMap = new HashMap();
    private static Map<Integer, List<Integer>> fetters = new HashMap();
    private static Map<Integer, List<ShopGoodsData>> shopGoods = new HashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0032: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r1, method: emu.grasscutter.data.GameData.getMapByResourceDef(java.lang.Class<?>):it.unimi.dsi.fastutil.ints.Int2ObjectMap<?>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Map]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Map]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0032: INVOKE_CUSTOM r1, method: emu.grasscutter.data.GameData.getMapByResourceDef(java.lang.Class<?>):it.unimi.dsi.fastutil.ints.Int2ObjectMap<?>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error fetching resource map for ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error fetching resource map for ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static p014it.unimi.dsi.fastutil.ints.Int2ObjectMap<?> getMapByResourceDef(java.lang.Class<?> r4) {
        /*
            r0 = 0
            r5 = r0
            java.lang.Class<emu.grasscutter.data.GameData> r0 = emu.grasscutter.data.GameData.class
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            java.lang.String r1 = emu.grasscutter.utils.Utils.lowerCaseFirstChar(r1)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Map]}
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)
            r6 = r0
            r0 = r6
            r1 = 1
            r0.setAccessible(r1)
            r0 = r6
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = (p014it.unimi.dsi.fastutil.ints.Int2ObjectMap) r0
            r5 = r0
            r0 = r6
            r1 = 0
            r0.setAccessible(r1)
            goto L_0x003b
            r6 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            java.lang.String r1 = r1.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Error fetching resource map for ]}
            r2 = r6
            r0.error(r1, r2)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.GameData.getMapByResourceDef(java.lang.Class):it.unimi.dsi.fastutil.ints.Int2ObjectMap");
    }

    public static List<Integer> getSpecialQuest() {
        return specialQuest;
    }

    public static void setSpecialQuest(List<Integer> specialQuest2) {
        specialQuest = specialQuest2;
    }

    public static Int2ObjectMap<HomeworldDefaultSaveData> getHomeworldDefaultSaveData() {
        return homeworldDefaultSaveData;
    }

    public static Map<Integer, Integer> getQuestGiveAvatar() {
        return questGiveAvatar;
    }

    public static Int2ObjectMap<String> getAbilityHashes() {
        return abilityHashes;
    }

    @Deprecated
    public static Map<String, AbilityModifierEntry> getAbilityModifiers() {
        return abilityModifiers;
    }

    public static Map<String, ConfigGadget> getGadgetConfigData() {
        return gadgetConfigData;
    }

    public static Map<String, OpenConfigEntry> getOpenConfigEntries() {
        return openConfigEntries;
    }

    @Deprecated
    public static Map<String, ScenePointEntry> getScenePointEntries() {
        return scenePointEntries;
    }

    public static ArrayList<CodexReliquaryData> getCodexReliquaryArrayList() {
        return codexReliquaryArrayList;
    }

    public static Int2ObjectMap<ActivityData> getActivityDataMap() {
        return activityDataMap;
    }

    public static Int2ObjectMap<ActivityShopData> getActivityShopDataMap() {
        return activityShopDataMap;
    }

    public static Int2ObjectMap<ActivityWatcherData> getActivityWatcherDataMap() {
        return activityWatcherDataMap;
    }

    public static Int2ObjectMap<AvatarCostumeData> getAvatarCostumeDataItemIdMap() {
        return avatarCostumeDataItemIdMap;
    }

    public static Int2ObjectMap<AvatarCostumeData> getAvatarCostumeDataMap() {
        return avatarCostumeDataMap;
    }

    public static Int2ObjectMap<AvatarCurveData> getAvatarCurveDataMap() {
        return avatarCurveDataMap;
    }

    public static Int2ObjectMap<AvatarData> getAvatarDataMap() {
        return avatarDataMap;
    }

    public static Int2ObjectMap<AvatarFetterLevelData> getAvatarFetterLevelDataMap() {
        return avatarFetterLevelDataMap;
    }

    public static Int2ObjectMap<AvatarFlycloakData> getAvatarFlycloakDataMap() {
        return avatarFlycloakDataMap;
    }

    public static Int2ObjectMap<AvatarLevelData> getAvatarLevelDataMap() {
        return avatarLevelDataMap;
    }

    public static Int2ObjectMap<AvatarSkillData> getAvatarSkillDataMap() {
        return avatarSkillDataMap;
    }

    public static Int2ObjectMap<AvatarSkillDepotData> getAvatarSkillDepotDataMap() {
        return avatarSkillDepotDataMap;
    }

    public static Int2ObjectMap<AvatarTalentData> getAvatarTalentDataMap() {
        return avatarTalentDataMap;
    }

    public static Int2ObjectMap<BattlePassMissionData> getBattlePassMissionDataMap() {
        return battlePassMissionDataMap;
    }

    public static Int2ObjectMap<ActivityCondExcelConfigData> getActivityCondExcelConfigDataMap() {
        return activityCondExcelConfigDataMap;
    }

    public static Int2ObjectMap<DungeonChallengeConfigData> getDungeonChallengeConfigDataMap() {
        return dungeonChallengeConfigDataMap;
    }

    public static Int2ObjectMap<BattlePassRewardData> getBattlePassRewardDataMap() {
        return battlePassRewardDataMap;
    }

    public static Int2ObjectMap<BlossomRefreshExcelConfigData> getBlossomRefreshExcelConfigDataMap() {
        return blossomRefreshExcelConfigDataMap;
    }

    public static Int2ObjectMap<BuffData> getBuffDataMap() {
        return buffDataMap;
    }

    public static Int2ObjectMap<ChapterData> getChapterDataMap() {
        return chapterDataMap;
    }

    public static Int2ObjectMap<CityData> getCityDataMap() {
        return cityDataMap;
    }

    public static Int2ObjectMap<CodexAnimalData> getCodexAnimalDataMap() {
        return codexAnimalDataMap;
    }

    public static Int2ObjectMap<CodexMaterialData> getCodexMaterialDataIdMap() {
        return codexMaterialDataIdMap;
    }

    public static Int2ObjectMap<CodexQuestData> getCodexQuestDataIdMap() {
        return codexQuestDataIdMap;
    }

    public static Int2ObjectMap<CodexReliquaryData> getCodexReliquaryDataIdMap() {
        return codexReliquaryDataIdMap;
    }

    public static Int2ObjectMap<CodexWeaponData> getCodexWeaponDataIdMap() {
        return codexWeaponDataIdMap;
    }

    public static Int2ObjectMap<DailyTaskData> getDailyTaskDataMap() {
        return dailyTaskDataMap;
    }

    public static Int2ObjectMap<DailyTaskLevelData> getDailyTaskLevelDataMap() {
        return dailyTaskLevelDataMap;
    }

    public static Int2ObjectMap<DailyTaskRewardData> getDailyTaskRewardDataMap() {
        return dailyTaskRewardDataMap;
    }

    public static Int2ObjectMap<CombineData> getCombineDataMap() {
        return combineDataMap;
    }

    public static Int2ObjectMap<CookBonusData> getCookBonusDataMap() {
        return cookBonusDataMap;
    }

    public static Int2ObjectMap<CookRecipeData> getCookRecipeDataMap() {
        return cookRecipeDataMap;
    }

    public static Int2ObjectMap<CompoundData> getCompoundDataMap() {
        return compoundDataMap;
    }

    public static Int2ObjectMap<DailyDungeonData> getDailyDungeonDataMap() {
        return dailyDungeonDataMap;
    }

    public static Int2ObjectMap<DropTableData> getDropTableDataMap() {
        return dropTableDataMap;
    }

    public static Int2ObjectMap<DropMaterialData> getDropMaterialDataMap() {
        return dropMaterialDataMap;
    }

    public static Int2ObjectMap<DungeonData> getDungeonDataMap() {
        return dungeonDataMap;
    }

    public static Int2ObjectMap<DungeonPassConfigData> getDungeonPassConfigDataMap() {
        return dungeonPassConfigDataMap;
    }

    public static Int2ObjectMap<DungeonEntryData> getDungeonEntryDataMap() {
        return dungeonEntryDataMap;
    }

    public static Int2ObjectMap<EnvAnimalGatherConfigData> getEnvAnimalGatherConfigDataMap() {
        return envAnimalGatherConfigDataMap;
    }

    public static Int2ObjectMap<EquipAffixData> getEquipAffixDataMap() {
        return equipAffixDataMap;
    }

    public static Int2ObjectMap<Int2ObjectMap<Route>> getSceneRouteData() {
        return sceneRouteData;
    }

    public static Int2ObjectMap<FetterCharacterCardData> getFetterCharacterCardDataMap() {
        return fetterCharacterCardDataMap;
    }

    public static Int2ObjectMap<ForgeData> getForgeDataMap() {
        return forgeDataMap;
    }

    public static Int2ObjectMap<FurnitureMakeConfigData> getFurnitureMakeConfigDataMap() {
        return furnitureMakeConfigDataMap;
    }

    public static Int2ObjectMap<GadgetData> getGadgetDataMap() {
        return gadgetDataMap;
    }

    public static Int2ObjectMap<GatherData> getGatherDataMap() {
        return gatherDataMap;
    }

    public static Int2ObjectMap<HomeWorldBgmData> getHomeWorldBgmDataMap() {
        return homeWorldBgmDataMap;
    }

    public static Int2ObjectMap<HomeWorldLevelData> getHomeWorldLevelDataMap() {
        return homeWorldLevelDataMap;
    }

    public static Int2ObjectMap<InvestigationMonsterData> getInvestigationMonsterDataMap() {
        return investigationMonsterDataMap;
    }

    public static Int2ObjectMap<ItemData> getItemDataMap() {
        return itemDataMap;
    }

    public static Int2ObjectMap<MonsterCurveData> getMonsterCurveDataMap() {
        return monsterCurveDataMap;
    }

    public static Int2ObjectMap<MonsterData> getMonsterDataMap() {
        return monsterDataMap;
    }

    public static Int2ObjectMap<MonsterDescribeData> getMonsterDescribeDataMap() {
        return monsterDescribeDataMap;
    }

    public static Int2ObjectMap<MonsterSpecialNameData> getMonsterSpecialNameDataMap() {
        return monsterSpecialNameDataMap;
    }

    public static Int2ObjectMap<MusicGameBasicData> getMusicGameBasicDataMap() {
        return musicGameBasicDataMap;
    }

    public static Int2ObjectMap<NpcData> getNpcDataMap() {
        return npcDataMap;
    }

    public static Int2ObjectMap<OpenStateData> getOpenStateDataMap() {
        return openStateDataMap;
    }

    public static Int2ObjectMap<PersonalLineData> getPersonalLineDataMap() {
        return personalLineDataMap;
    }

    public static Int2ObjectMap<PlayerLevelData> getPlayerLevelDataMap() {
        return playerLevelDataMap;
    }

    public static Int2ObjectMap<ProudSkillData> getProudSkillDataMap() {
        return proudSkillDataMap;
    }

    public static Int2ObjectMap<QuestData> getQuestDataMap() {
        return questDataMap;
    }

    public static Int2ObjectMap<ReliquaryAffixData> getReliquaryAffixDataMap() {
        return reliquaryAffixDataMap;
    }

    public static Int2ObjectMap<ReliquaryMainPropData> getReliquaryMainPropDataMap() {
        return reliquaryMainPropDataMap;
    }

    public static Int2ObjectMap<ReliquarySetData> getReliquarySetDataMap() {
        return reliquarySetDataMap;
    }

    public static Int2ObjectMap<RewardData> getRewardDataMap() {
        return rewardDataMap;
    }

    public static Int2ObjectMap<RewardPreviewData> getRewardPreviewDataMap() {
        return rewardPreviewDataMap;
    }

    public static Int2ObjectMap<SceneData> getSceneDataMap() {
        return sceneDataMap;
    }

    public static Int2ObjectMap<TowerFloorData> getTowerFloorDataMap() {
        return towerFloorDataMap;
    }

    public static Int2ObjectMap<TowerLevelData> getTowerLevelDataMap() {
        return towerLevelDataMap;
    }

    public static Int2ObjectMap<TowerScheduleData> getTowerScheduleDataMap() {
        return towerScheduleDataMap;
    }

    public static Int2ObjectMap<TriggerExcelConfigData> getTriggerExcelConfigDataMap() {
        return triggerExcelConfigDataMap;
    }

    public static Int2ObjectMap<WeaponCurveData> getWeaponCurveDataMap() {
        return weaponCurveDataMap;
    }

    public static Int2ObjectMap<WeaponLevelData> getWeaponLevelDataMap() {
        return weaponLevelDataMap;
    }

    public static Int2ObjectMap<WeaponPromoteData> getWeaponPromoteDataMap() {
        return weaponPromoteDataMap;
    }

    public static Int2ObjectMap<WeatherData> getWeatherDataMap() {
        return weatherDataMap;
    }

    public static Int2ObjectMap<WorldAreaData> getWorldAreaDataMap() {
        return worldAreaDataMap;
    }

    public static Int2ObjectMap<WorldLevelData> getWorldLevelDataMap() {
        return worldLevelDataMap;
    }

    public static Int2ObjectMap<RewindData> getRewindDataMap() {
        return rewindDataMap;
    }

    public static Int2ObjectMap<TeleportData> getTeleportDataMap() {
        return teleportDataMap;
    }

    public static IntList getScenePointIdList() {
        return scenePointIdList;
    }

    public static List<OpenStateData> getOpenStateList() {
        return openStateList;
    }

    public static Map<Integer, List<Integer>> getScenePointsPerScene() {
        return scenePointsPerScene;
    }

    public static Map<String, ScriptSceneData> getScriptSceneDataMap() {
        return scriptSceneDataMap;
    }

    public static Map<String, ConfigLevelEntity> getConfigLevelEntityDataMap() {
        return configLevelEntityDataMap;
    }

    public static Int2ObjectMap<MainQuestData> getMainQuestDataMap() {
        return mainQuestData;
    }

    public static Int2ObjectMap<QuestEncryptionKey> getMainQuestEncryptionMap() {
        return questsKeys;
    }

    public static Int2ObjectMap<SceneNpcBornData> getSceneNpcBornData() {
        return npcBornData;
    }

    public static Map<String, AbilityEmbryoEntry> getAbilityEmbryoInfo() {
        return abilityEmbryos;
    }

    public static AbilityData getAbilityData(String abilityName) {
        return abilityDataMap.get(abilityName);
    }

    public static IntSet getAvatarSkillLevels(int avatarSkillId) {
        return avatarSkillLevels.get(avatarSkillId);
    }

    public static IntSet getProudSkillGroupLevels(int proudSkillGroupId) {
        return proudSkillGroupLevels.get(proudSkillGroupId);
    }

    public static int getProudSkillGroupMaxLevel(int proudSkillGroupId) {
        return proudSkillGroupMaxLevels.getOrDefault(proudSkillGroupId, 0);
    }

    public static AvatarPromoteData getAvatarPromoteData(int promoteId, int promoteLevel) {
        return avatarPromoteDataMap.get((promoteId << 8) + promoteLevel);
    }

    public static WeaponPromoteData getWeaponPromoteData(int promoteId, int promoteLevel) {
        return weaponPromoteDataMap.get((promoteId << 8) + promoteLevel);
    }

    public static ReliquaryLevelData getRelicLevelData(int rankLevel, int level) {
        return reliquaryLevelDataMap.get((rankLevel << 8) + level);
    }

    public static ScenePointEntry getScenePointEntryById(int sceneId, int pointId) {
        return scenePointEntryMap.get((sceneId << 16) + pointId);
    }

    public static int getAvatarLevelExpRequired(int level) {
        return ((Integer) Optional.ofNullable(avatarLevelDataMap.get(level)).map(d -> {
            return Integer.valueOf(d.getExp());
        }).orElse(0)).intValue();
    }

    public static int getAvatarFetterLevelExpRequired(int level) {
        return ((Integer) Optional.ofNullable(avatarFetterLevelDataMap.get(level)).map(d -> {
            return Integer.valueOf(d.getExp());
        }).orElse(0)).intValue();
    }

    public static int getRelicExpRequired(int rankLevel, int level) {
        return ((Integer) Optional.ofNullable(getRelicLevelData(rankLevel, level)).map(d -> {
            return Integer.valueOf(d.getExp());
        }).orElse(0)).intValue();
    }

    public static int getWeaponExpRequired(int rankLevel, int level) {
        WeaponLevelData levelData = weaponLevelDataMap.get(level);
        if (levelData == null) {
            return 0;
        }
        try {
            return levelData.getRequiredExps()[rankLevel - 1];
        } catch (Exception e) {
            return 0;
        }
    }

    public static Map<Integer, List<Integer>> getFetterDataEntries() {
        if (fetters.isEmpty()) {
            fetterDataMap.forEach(k, v -> {
                if (!fetters.containsKey(Integer.valueOf(v.getAvatarId()))) {
                    fetters.put(Integer.valueOf(v.getAvatarId()), new ArrayList());
                }
                fetters.get(Integer.valueOf(v.getAvatarId())).add(k);
            });
        }
        return fetters;
    }

    public static Map<Integer, List<ShopGoodsData>> getShopGoodsDataEntries() {
        if (shopGoods.isEmpty()) {
            shopGoodsDataMap.forEach(k, v -> {
                if (!shopGoods.containsKey(Integer.valueOf(v.getShopType()))) {
                    shopGoods.put(Integer.valueOf(v.getShopType()), new ArrayList());
                }
                shopGoods.get(Integer.valueOf(v.getShopType())).add(v);
            });
        }
        return shopGoods;
    }

    public static Int2ObjectMap<Route> getSceneRoutes(int sceneId) {
        return sceneRouteData.computeIfAbsent(sceneId, k -> {
            return new Int2ObjectOpenHashMap();
        });
    }
}
