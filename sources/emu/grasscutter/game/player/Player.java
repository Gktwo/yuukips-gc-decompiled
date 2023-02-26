package emu.grasscutter.game.player;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.Transient;
import emu.grasscutter.GameConstants;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.ConfigLevelEntity;
import emu.grasscutter.data.excels.AvatarData;
import emu.grasscutter.data.excels.PlayerLevelData;
import emu.grasscutter.data.excels.WeatherData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.CoopRequest;
import emu.grasscutter.game.ability.AbilityManager;
import emu.grasscutter.game.activity.ActivityManager;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.avatar.AvatarStorage;
import emu.grasscutter.game.battlepass.BattlePassManager;
import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.expedition.ExpeditionInfo;
import emu.grasscutter.game.friends.FriendsList;
import emu.grasscutter.game.friends.PlayerProfile;
import emu.grasscutter.game.gacha.PlayerGachaInfo;
import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.Inventory;
import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.game.mail.MailHandler;
import emu.grasscutter.game.managers.FurnitureManager;
import emu.grasscutter.game.managers.ResinManager;
import emu.grasscutter.game.managers.SatiationManager;
import emu.grasscutter.game.managers.SotSManager;
import emu.grasscutter.game.managers.cooking.ActiveCookCompoundData;
import emu.grasscutter.game.managers.cooking.CookingCompoundManager;
import emu.grasscutter.game.managers.cooking.CookingManager;
import emu.grasscutter.game.managers.deforestation.DeforestationManager;
import emu.grasscutter.game.managers.energy.EnergyManager;
import emu.grasscutter.game.managers.forging.ActiveForgeData;
import emu.grasscutter.game.managers.forging.ForgingManager;
import emu.grasscutter.game.managers.mapmark.MapMark;
import emu.grasscutter.game.managers.mapmark.MapMarksManager;
import emu.grasscutter.game.managers.stamina.StaminaManager;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.ClimateType;
import emu.grasscutter.game.props.ElementType;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.game.quest.QuestManager;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.shop.ShopLimit;
import emu.grasscutter.game.tower.TowerData;
import emu.grasscutter.game.tower.TowerManager;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.game.world.World;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AbilityInvokeEntryOuterClass;
import emu.grasscutter.net.proto.AttackResultOuterClass;
import emu.grasscutter.net.proto.CombatInvokeEntryOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.MpSettingTypeOuterClass;
import emu.grasscutter.net.proto.OnlinePlayerInfoOuterClass;
import emu.grasscutter.net.proto.PlayerApplyEnterMpResultNotifyOuterClass;
import emu.grasscutter.net.proto.PlayerLocationInfoOuterClass;
import emu.grasscutter.net.proto.PlayerWorldLocationInfoOuterClass;
import emu.grasscutter.net.proto.ProfilePictureOuterClass;
import emu.grasscutter.net.proto.PropChangeReasonOuterClass;
import emu.grasscutter.net.proto.ShowAvatarInfoOuterClass;
import emu.grasscutter.net.proto.SocialDetailOuterClass;
import emu.grasscutter.net.proto.SocialShowAvatarInfoOuterClass;
import emu.grasscutter.scripts.data.SceneRegion;
import emu.grasscutter.server.event.player.PlayerQuitEvent;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketAbilityInvocationsNotify;
import emu.grasscutter.server.packet.send.PacketAvatarAddNotify;
import emu.grasscutter.server.packet.send.PacketAvatarExpeditionDataNotify;
import emu.grasscutter.server.packet.send.PacketAvatarGainCostumeNotify;
import emu.grasscutter.server.packet.send.PacketAvatarGainFlycloakNotify;
import emu.grasscutter.server.packet.send.PacketCardProductRewardNotify;
import emu.grasscutter.server.packet.send.PacketClientAbilityInitFinishNotify;
import emu.grasscutter.server.packet.send.PacketCombatInvocationsNotify;
import emu.grasscutter.server.packet.send.PacketHomeModuleUnlockNotify;
import emu.grasscutter.server.packet.send.PacketPlayerApplyEnterMpResultNotify;
import emu.grasscutter.server.packet.send.PacketPlayerPropChangeNotify;
import emu.grasscutter.server.packet.send.PacketPlayerPropChangeReasonNotify;
import emu.grasscutter.server.packet.send.PacketPlayerPropNotify;
import emu.grasscutter.server.packet.send.PacketSceneAreaWeatherNotify;
import emu.grasscutter.server.packet.send.PacketScenePlayerLocationNotify;
import emu.grasscutter.server.packet.send.PacketServerAnnounceNotify;
import emu.grasscutter.server.packet.send.PacketSetNameCardRsp;
import emu.grasscutter.server.packet.send.PacketUnlockNameCardNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerLocationNotify;
import emu.grasscutter.server.packet.send.PacketWorldPlayerRTTNotify;
import emu.grasscutter.utils.DateHelper;
import emu.grasscutter.utils.MessageHandler;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.Utils;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingQueue;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

@Entity(value = "players", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/Player.class */
public class Player {
    @AbstractC1283Id

    /* renamed from: id */
    private int f582id;
    @Indexed(options = @IndexOptions(unique = true))
    private String accountId;
    private transient Account account;
    private transient GameSession session;
    private String nickname;
    private String signature;
    private int headImage;
    private int nameCardId;
    private Position position;
    private Position prevPos;
    private Position rotation;
    private PlayerBirthday birthday;
    private PlayerCodex codex;
    private boolean showAvatars;
    private List<Integer> showAvatarList;
    private List<Integer> showNameCardList;
    private Map<Integer, Integer> properties;
    private int currentRealmId;
    private int widgetId;
    private int sceneId;
    private int regionId;
    private int mainCharacterId;
    private boolean godmode;
    private boolean stamina;
    private Set<Integer> nameCardList;
    private Set<Integer> flyCloakList;
    private Set<Integer> costumeList;
    private Set<Integer> rewardedLevels;
    private Set<Integer> homeRewardedLevels;
    private Set<Integer> realmList;
    private Set<Integer> seenRealmList;
    private Set<Integer> unlockedForgingBlueprints;
    private Set<Integer> unlockedCombines;
    private Set<Integer> unlockedFurniture;
    private Set<Integer> unlockedFurnitureSuite;
    private Map<Long, ExpeditionInfo> expeditionInfo;
    private Map<Integer, Integer> unlockedRecipies;
    private List<ActiveForgeData> activeForges;
    private Map<Integer, ActiveCookCompoundData> activeCookCompounds;
    private Map<Integer, Integer> questGlobalVariables;
    private Map<Integer, Integer> openStates;
    private Map<Integer, Set<Integer>> unlockedSceneAreas;
    private Map<Integer, Set<Integer>> unlockedScenePoints;
    private List<Integer> chatEmojiIdList;
    @Transient
    private long nextGuid;
    @Transient
    private int peerId;
    @Transient
    private World world;
    @Transient
    private Scene scene;
    @Transient
    private int weatherId;
    @Transient
    private ClimateType climate;
    private transient AvatarStorage avatars;
    private transient Inventory inventory;
    private transient FriendsList friendsList;
    private transient MailHandler mailHandler;
    private transient MessageHandler messageHandler;
    private transient AbilityManager abilityManager;
    private transient QuestManager questManager;
    private transient TowerManager towerManager;
    private transient SotSManager sotsManager;
    private transient MapMarksManager mapMarksManager;
    private transient StaminaManager staminaManager;
    private transient EnergyManager energyManager;
    private transient ResinManager resinManager;
    private transient ForgingManager forgingManager;
    private transient DeforestationManager deforestationManager;
    private transient FurnitureManager furnitureManager;
    private transient BattlePassManager battlePassManager;
    private transient CookingManager cookingManager;
    private transient CookingCompoundManager cookingCompoundManager;
    private transient ActivityManager activityManager;
    private transient PlayerBuffManager buffManager;
    private transient PlayerProgressManager progressManager;
    private transient SatiationManager satiationManager;
    private transient DailyTaskManager dailyTaskManager;
    private PlayerProfile playerProfile;
    private TeamManager teamManager;
    private TowerData towerData;
    private PlayerGachaInfo gachaInfo;
    private PlayerCollectionRecords collectionRecordStore;
    private ArrayList<ShopLimit> shopLimit;
    private transient GameHome home;
    private boolean moonCard;
    private Date moonCardStartTime;
    private int moonCardDuration;
    private Set<Date> moonCardGetTimes;
    @Transient
    private boolean paused;
    @Transient
    private int enterSceneToken;
    @Transient
    private SceneLoadState sceneLoadState;
    @Transient
    private boolean hasSentLoginPackets;
    @Transient
    private long nextSendPlayerLocTime;
    @Transient
    private long nextCheckPlayerActivities;
    private final transient Int2ObjectMap<CoopRequest> coopRequests;
    private final transient Queue<AttackResultOuterClass.AttackResult> attackResults;
    private final transient InvokeHandler<CombatInvokeEntryOuterClass.CombatInvokeEntry> combatInvokeHandler;
    private final transient InvokeHandler<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> abilityInvokeHandler;
    private final transient InvokeHandler<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> clientAbilityInitFinishHandler;
    private long springLastUsed;
    private HashMap<String, MapMark> mapMarks;
    private int nextResinRefresh;
    private int lastDailyReset;
    private transient MpSettingTypeOuterClass.MpSettingType mpSetting;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0092: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00CB: INVOKE_CUSTOM r-10, r-9, r-8, r-7, r-6
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00E8: INVOKE_CUSTOM r-11
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0114: INVOKE_CUSTOM r-14
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x018B: INVOKE_CUSTOM r-23, r-22, r-21, r-20, r-19, r-18
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x019D: INVOKE_CUSTOM r-24
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x01C3: INVOKE_CUSTOM r-28
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0220: INVOKE_CUSTOM r-35
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x026F: INVOKE_CUSTOM r-36
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x035D: INVOKE_CUSTOM r-47
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0395: INVOKE_CUSTOM r-49
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x03FD: INVOKE_CUSTOM r-56, r-55
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0433: INVOKE_CUSTOM r-61
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
    /*  JADX ERROR: Failed to decode insn: 0x0092: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove null Avatar: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove null Avatar: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00CB: INVOKE_CUSTOM r1, r2, r3, r4, r5, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, I, I)Ljava/lang/String;}, Avatar:  (Index ) |  |  | Abilities:  ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, I, I)Ljava/lang/String;}, Avatar:  (Index ) |  |  | Abilities:  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00E8: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove testing Avatar: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove testing Avatar: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0114: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove Duplicate Avatar: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Remove Duplicate Avatar: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x018B: INVOKE_CUSTOM r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, Ljava/lang/String;, I)Ljava/lang/String;}, LastLast Index  (Good  index) (IDAV:) (IDMR:) (ID: ) (TT )]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, Ljava/lang/String;, I)Ljava/lang/String;}, LastLast Index  (Good  index) (IDAV:) (IDMR:) (ID: ) (TT )]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x019D: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, UseLastID: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, UseLastID: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x01C3: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, User new join? (ID: ) ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, User new join? (ID: ) ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0220: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Avatar: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Avatar: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x026F: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Found Lisa with hp ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F)Ljava/lang/String;}, Found Lisa with hp ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x035D: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Avatar in Team: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Avatar in Team: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0395: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Don't delete our main character: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Don't delete our main character: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x03FD: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, No Avatar (getCurrentSinglePlayerTeamInfo) (add )(ID: )]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, No Avatar (getCurrentSinglePlayerTeamInfo) (add )(ID: )]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0433: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.loadFromDatabase():boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, No Avatar and no main char? (ID: )  ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, No Avatar and no main char? (ID: )  ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public boolean loadFromDatabase() {
        /*
        // Method dump skipped, instructions count: 1158
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.player.Player.loadFromDatabase():boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x014F: INVOKE_CUSTOM r-51
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x01BA: INVOKE_CUSTOM r-64
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0204: INVOKE_CUSTOM r-74
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
    /*  JADX ERROR: Failed to decode insn: 0x014F: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.onLogin():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Packets failure]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Packets failure]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x01BA: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.onLogin():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Manager failure]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Manager failure]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0204: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.Player.onLogin():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Home failure]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Player (UID ) Home failure]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void onLogin() {
        /*
        // Method dump skipped, instructions count: 632
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.player.Player.onLogin():void");
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public GameSession getSession() {
        return this.session;
    }

    public void setSession(GameSession session) {
        this.session = session;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getSignature() {
        return this.signature;
    }

    public int getHeadImage() {
        return this.headImage;
    }

    public int getNameCardId() {
        return this.nameCardId;
    }

    public Position getPosition() {
        return this.position;
    }

    public Position getPrevPos() {
        return this.prevPos;
    }

    public void setPrevPos(Position prevPos) {
        this.prevPos = prevPos;
    }

    public Position getRotation() {
        return this.rotation;
    }

    public PlayerBirthday getBirthday() {
        return this.birthday;
    }

    public PlayerCodex getCodex() {
        return this.codex;
    }

    public boolean isShowAvatars() {
        return this.showAvatars;
    }

    public void setShowAvatars(boolean showAvatars) {
        this.showAvatars = showAvatars;
    }

    public List<Integer> getShowAvatarList() {
        return this.showAvatarList;
    }

    public void setShowAvatarList(List<Integer> showAvatarList) {
        this.showAvatarList = showAvatarList;
    }

    public List<Integer> getShowNameCardList() {
        return this.showNameCardList;
    }

    public void setShowNameCardList(List<Integer> showNameCardList) {
        this.showNameCardList = showNameCardList;
    }

    public Map<Integer, Integer> getProperties() {
        return this.properties;
    }

    public int getCurrentRealmId() {
        return this.currentRealmId;
    }

    public void setCurrentRealmId(int currentRealmId) {
        this.currentRealmId = currentRealmId;
    }

    public int getWidgetId() {
        return this.widgetId;
    }

    public void setWidgetId(int widgetId) {
        this.widgetId = widgetId;
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public void setSceneId(int sceneId) {
        this.sceneId = sceneId;
    }

    public int getRegionId() {
        return this.regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public int getMainCharacterId() {
        return this.mainCharacterId;
    }

    public void setGodmode(boolean godmode) {
        this.godmode = godmode;
    }

    public Set<Integer> getNameCardList() {
        return this.nameCardList;
    }

    public Set<Integer> getFlyCloakList() {
        return this.flyCloakList;
    }

    public Set<Integer> getCostumeList() {
        return this.costumeList;
    }

    public Set<Integer> getRewardedLevels() {
        return this.rewardedLevels;
    }

    public void setRewardedLevels(Set<Integer> rewardedLevels) {
        this.rewardedLevels = rewardedLevels;
    }

    public Set<Integer> getHomeRewardedLevels() {
        return this.homeRewardedLevels;
    }

    public void setHomeRewardedLevels(Set<Integer> homeRewardedLevels) {
        this.homeRewardedLevels = homeRewardedLevels;
    }

    public Set<Integer> getRealmList() {
        return this.realmList;
    }

    public void setRealmList(Set<Integer> realmList) {
        this.realmList = realmList;
    }

    public Set<Integer> getSeenRealmList() {
        return this.seenRealmList;
    }

    public void setSeenRealmList(Set<Integer> seenRealmList) {
        this.seenRealmList = seenRealmList;
    }

    public Set<Integer> getUnlockedForgingBlueprints() {
        return this.unlockedForgingBlueprints;
    }

    public Set<Integer> getUnlockedCombines() {
        return this.unlockedCombines;
    }

    public Set<Integer> getUnlockedFurniture() {
        return this.unlockedFurniture;
    }

    public Set<Integer> getUnlockedFurnitureSuite() {
        return this.unlockedFurnitureSuite;
    }

    public Map<Long, ExpeditionInfo> getExpeditionInfo() {
        return this.expeditionInfo;
    }

    public Map<Integer, Integer> getUnlockedRecipies() {
        return this.unlockedRecipies;
    }

    public List<ActiveForgeData> getActiveForges() {
        return this.activeForges;
    }

    public Map<Integer, ActiveCookCompoundData> getActiveCookCompounds() {
        return this.activeCookCompounds;
    }

    public Map<Integer, Integer> getQuestGlobalVariables() {
        return this.questGlobalVariables;
    }

    public Map<Integer, Integer> getOpenStates() {
        return this.openStates;
    }

    public Map<Integer, Set<Integer>> getUnlockedSceneAreas() {
        return this.unlockedSceneAreas;
    }

    public void setUnlockedSceneAreas(Map<Integer, Set<Integer>> unlockedSceneAreas) {
        this.unlockedSceneAreas = unlockedSceneAreas;
    }

    public Map<Integer, Set<Integer>> getUnlockedScenePoints() {
        return this.unlockedScenePoints;
    }

    public void setUnlockedScenePoints(Map<Integer, Set<Integer>> unlockedScenePoints) {
        this.unlockedScenePoints = unlockedScenePoints;
    }

    public List<Integer> getChatEmojiIdList() {
        return this.chatEmojiIdList;
    }

    public void setChatEmojiIdList(List<Integer> chatEmojiIdList) {
        this.chatEmojiIdList = chatEmojiIdList;
    }

    public int getPeerId() {
        return this.peerId;
    }

    public void setPeerId(int peerId) {
        this.peerId = peerId;
    }

    public int getWeatherId() {
        return this.weatherId;
    }

    public ClimateType getClimate() {
        return this.climate;
    }

    public AvatarStorage getAvatars() {
        return this.avatars;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public FriendsList getFriendsList() {
        return this.friendsList;
    }

    public MailHandler getMailHandler() {
        return this.mailHandler;
    }

    public MessageHandler getMessageHandler() {
        return this.messageHandler;
    }

    public void setMessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    public AbilityManager getAbilityManager() {
        return this.abilityManager;
    }

    public QuestManager getQuestManager() {
        return this.questManager;
    }

    public void setQuestManager(QuestManager questManager) {
        this.questManager = questManager;
    }

    public TowerManager getTowerManager() {
        return this.towerManager;
    }

    public SotSManager getSotsManager() {
        return this.sotsManager;
    }

    public MapMarksManager getMapMarksManager() {
        return this.mapMarksManager;
    }

    public StaminaManager getStaminaManager() {
        return this.staminaManager;
    }

    public EnergyManager getEnergyManager() {
        return this.energyManager;
    }

    public ResinManager getResinManager() {
        return this.resinManager;
    }

    public ForgingManager getForgingManager() {
        return this.forgingManager;
    }

    public DeforestationManager getDeforestationManager() {
        return this.deforestationManager;
    }

    public FurnitureManager getFurnitureManager() {
        return this.furnitureManager;
    }

    public BattlePassManager getBattlePassManager() {
        return this.battlePassManager;
    }

    public CookingManager getCookingManager() {
        return this.cookingManager;
    }

    public CookingCompoundManager getCookingCompoundManager() {
        return this.cookingCompoundManager;
    }

    public ActivityManager getActivityManager() {
        return this.activityManager;
    }

    public PlayerBuffManager getBuffManager() {
        return this.buffManager;
    }

    public PlayerProgressManager getProgressManager() {
        return this.progressManager;
    }

    public SatiationManager getSatiationManager() {
        return this.satiationManager;
    }

    public DailyTaskManager getDailyTaskManager() {
        return this.dailyTaskManager;
    }

    public TeamManager getTeamManager() {
        return this.teamManager;
    }

    public PlayerGachaInfo getGachaInfo() {
        return this.gachaInfo;
    }

    public ArrayList<ShopLimit> getShopLimit() {
        return this.shopLimit;
    }

    public GameHome getHome() {
        return this.home;
    }

    public void setMoonCard(boolean moonCard) {
        this.moonCard = moonCard;
    }

    public Date getMoonCardStartTime() {
        return this.moonCardStartTime;
    }

    public void setMoonCardStartTime(Date moonCardStartTime) {
        this.moonCardStartTime = moonCardStartTime;
    }

    public int getMoonCardDuration() {
        return this.moonCardDuration;
    }

    public void setMoonCardDuration(int moonCardDuration) {
        this.moonCardDuration = moonCardDuration;
    }

    public Set<Date> getMoonCardGetTimes() {
        return this.moonCardGetTimes;
    }

    public void setMoonCardGetTimes(Set<Date> moonCardGetTimes) {
        this.moonCardGetTimes = moonCardGetTimes;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public int getEnterSceneToken() {
        return this.enterSceneToken;
    }

    public void setEnterSceneToken(int enterSceneToken) {
        this.enterSceneToken = enterSceneToken;
    }

    public SceneLoadState getSceneLoadState() {
        return this.sceneLoadState;
    }

    public void setSceneLoadState(SceneLoadState sceneLoadState) {
        this.sceneLoadState = sceneLoadState;
    }

    public Queue<AttackResultOuterClass.AttackResult> getAttackResults() {
        return this.attackResults;
    }

    public InvokeHandler<CombatInvokeEntryOuterClass.CombatInvokeEntry> getCombatInvokeHandler() {
        return this.combatInvokeHandler;
    }

    public InvokeHandler<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getAbilityInvokeHandler() {
        return this.abilityInvokeHandler;
    }

    public InvokeHandler<AbilityInvokeEntryOuterClass.AbilityInvokeEntry> getClientAbilityInitFinishHandler() {
        return this.clientAbilityInitFinishHandler;
    }

    public long getSpringLastUsed() {
        return this.springLastUsed;
    }

    public void setSpringLastUsed(long springLastUsed) {
        this.springLastUsed = springLastUsed;
    }

    public int getNextResinRefresh() {
        return this.nextResinRefresh;
    }

    public void setNextResinRefresh(int nextResinRefresh) {
        this.nextResinRefresh = nextResinRefresh;
    }

    public int getLastDailyReset() {
        return this.lastDailyReset;
    }

    public void setLastDailyReset(int lastDailyReset) {
        this.lastDailyReset = lastDailyReset;
    }

    public MpSettingTypeOuterClass.MpSettingType getMpSetting() {
        return this.mpSetting;
    }

    @Deprecated(forRemoval = true)
    public Player() {
        this.nameCardId = 210001;
        this.nextGuid = 0;
        this.weatherId = 0;
        this.climate = ClimateType.CLIMATE_SUNNY;
        this.sceneLoadState = SceneLoadState.NONE;
        this.nextSendPlayerLocTime = 0;
        this.nextCheckPlayerActivities = 0;
        this.mpSetting = MpSettingTypeOuterClass.MpSettingType.MP_SETTING_TYPE_ENTER_AFTER_APPLY;
        this.inventory = new Inventory(this);
        this.avatars = new AvatarStorage(this);
        this.friendsList = new FriendsList(this);
        this.mailHandler = new MailHandler(this);
        this.towerManager = new TowerManager(this);
        this.abilityManager = new AbilityManager(this);
        this.deforestationManager = new DeforestationManager(this);
        this.questManager = new QuestManager(this);
        this.buffManager = new PlayerBuffManager(this);
        this.position = new Position(GameConstants.START_POSITION);
        this.prevPos = new Position();
        this.rotation = new Position(0.0f, 307.0f, 0.0f);
        this.sceneId = 3;
        this.regionId = 1;
        this.properties = new HashMap();
        PlayerProperty[] values = PlayerProperty.values();
        for (PlayerProperty prop : values) {
            if (prop.getId() >= 10000) {
                this.properties.put(Integer.valueOf(prop.getId()), 0);
            }
        }
        this.gachaInfo = new PlayerGachaInfo();
        this.nameCardList = new HashSet();
        this.flyCloakList = new HashSet();
        this.costumeList = new HashSet();
        this.towerData = new TowerData();
        this.collectionRecordStore = new PlayerCollectionRecords();
        this.unlockedForgingBlueprints = new HashSet();
        this.unlockedCombines = new HashSet();
        this.unlockedFurniture = new HashSet();
        this.unlockedFurnitureSuite = new HashSet();
        this.activeCookCompounds = new HashMap();
        this.activeForges = new ArrayList();
        this.unlockedRecipies = new HashMap();
        this.questGlobalVariables = new HashMap();
        this.openStates = new HashMap();
        this.unlockedSceneAreas = new HashMap();
        this.unlockedScenePoints = new HashMap();
        this.chatEmojiIdList = new ArrayList();
        this.attackResults = new LinkedBlockingQueue();
        this.coopRequests = new Int2ObjectOpenHashMap();
        this.combatInvokeHandler = new InvokeHandler<>(PacketCombatInvocationsNotify.class);
        this.abilityInvokeHandler = new InvokeHandler<>(PacketAbilityInvocationsNotify.class);
        this.clientAbilityInitFinishHandler = new InvokeHandler<>(PacketClientAbilityInitFinishNotify.class);
        this.birthday = new PlayerBirthday();
        this.rewardedLevels = new HashSet();
        this.homeRewardedLevels = new HashSet();
        this.seenRealmList = new HashSet();
        this.moonCardGetTimes = new HashSet();
        this.codex = new PlayerCodex(this);
        this.progressManager = new PlayerProgressManager(this);
        this.shopLimit = new ArrayList<>();
        this.expeditionInfo = new HashMap();
        this.messageHandler = null;
        this.mapMarksManager = new MapMarksManager(this);
        this.staminaManager = new StaminaManager(this);
        this.sotsManager = new SotSManager(this);
        this.energyManager = new EnergyManager(this);
        this.resinManager = new ResinManager(this);
        this.forgingManager = new ForgingManager(this);
        this.progressManager = new PlayerProgressManager(this);
        this.furnitureManager = new FurnitureManager(this);
        this.cookingManager = new CookingManager(this);
        this.cookingCompoundManager = new CookingCompoundManager(this);
        this.satiationManager = new SatiationManager(this);
    }

    public Player(GameSession session) {
        this();
        this.account = session.getAccount();
        this.accountId = getAccount().getId();
        this.session = session;
        this.nickname = "Traveler";
        this.signature = "";
        this.teamManager = new TeamManager(this);
        this.birthday = new PlayerBirthday();
        this.codex = new PlayerCodex(this);
        setProperty(PlayerProperty.PROP_PLAYER_LEVEL, 1, false);
        setProperty(PlayerProperty.PROP_IS_SPRING_AUTO_USE, 1, false);
        setProperty(PlayerProperty.PROP_SPRING_AUTO_USE_PERCENT, 50, false);
        setProperty(PlayerProperty.PROP_IS_FLYABLE, 1, false);
        setProperty(PlayerProperty.PROP_IS_TRANSFERABLE, 1, false);
        setProperty(PlayerProperty.PROP_MAX_STAMINA, 24000, false);
        setProperty(PlayerProperty.PROP_CUR_PERSIST_STAMINA, 24000, false);
        setProperty(PlayerProperty.PROP_PLAYER_RESIN, 160, false);
        getFlyCloakList().add(140001);
        getNameCardList().add(210001);
        this.messageHandler = null;
        this.mapMarksManager = new MapMarksManager(this);
        this.staminaManager = new StaminaManager(this);
        this.sotsManager = new SotSManager(this);
        this.energyManager = new EnergyManager(this);
        this.resinManager = new ResinManager(this);
        this.deforestationManager = new DeforestationManager(this);
        this.forgingManager = new ForgingManager(this);
        this.progressManager = new PlayerProgressManager(this);
        this.furnitureManager = new FurnitureManager(this);
        this.cookingManager = new CookingManager(this);
        this.cookingCompoundManager = new CookingCompoundManager(this);
        this.satiationManager = new SatiationManager(this);
    }

    public int getUid() {
        return this.f582id;
    }

    public void setUid(int id) {
        this.f582id = id;
    }

    public long getNextGameGuid() {
        long nextId = this.nextGuid + 1;
        this.nextGuid = nextId;
        return (((long) getUid()) << 32) + nextId;
    }

    public Account getAccount() {
        if (this.account == null) {
            this.account = DatabaseHelper.getAccountById(this.accountId);
        }
        return this.account;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public boolean isOnline() {
        return getSession() != null && getSession().isActive();
    }

    public GameServer getServer() {
        return getSession().getServer();
    }

    public synchronized World getWorld() {
        return this.world;
    }

    public synchronized void setWorld(World world) {
        this.world = world;
    }

    public synchronized Scene getScene() {
        return this.scene;
    }

    public synchronized void setScene(Scene scene) {
        this.scene = scene;
    }

    public synchronized void setClimate(ClimateType climate) {
        this.climate = climate;
        this.session.send(new PacketSceneAreaWeatherNotify(this));
    }

    public void sendNotif(String text) {
        this.session.send(new PacketServerAnnounceNotify(text, new Random().nextInt(10000, 99999)));
    }

    public synchronized void setWeather(int weather) {
        setWeather(weather, ClimateType.CLIMATE_NONE);
    }

    public synchronized void setWeather(int weatherId, ClimateType climate) {
        WeatherData w;
        Grasscutter.getLogger().info("setWeather -> {},{}", Integer.valueOf(weatherId), climate.getShortName());
        if (climate == ClimateType.CLIMATE_NONE && (w = GameData.getWeatherDataMap().get(weatherId)) != null) {
            climate = w.getDefaultClimate();
        }
        this.weatherId = weatherId;
        this.climate = climate;
        this.session.send(new PacketSceneAreaWeatherNotify(this));
    }

    public void setNickname(String nickName) {
        this.nickname = nickName;
        updateProfile();
    }

    public void setHeadImage(int picture) {
        this.headImage = picture;
        updateProfile();
    }

    public void setSignature(String signature) {
        this.signature = signature;
        updateProfile();
    }

    public void addRealmList(int realmId) {
        if (this.realmList == null) {
            this.realmList = new HashSet();
        } else if (this.realmList.contains(Integer.valueOf(realmId))) {
            return;
        }
        this.realmList.add(Integer.valueOf(realmId));
        if (realmId > 3) {
            sendPacket(new PacketHomeModuleUnlockNotify(realmId));
            getHome().onClaimReward(this);
        }
    }

    public void addSeenRealmList(int seenId) {
        if (this.seenRealmList == null) {
            this.seenRealmList = new HashSet();
        } else if (this.seenRealmList.contains(Integer.valueOf(seenId))) {
            return;
        }
        this.seenRealmList.add(Integer.valueOf(seenId));
    }

    public int getExpeditionLimit() {
        int expeditionLimit = 2;
        Int2ObjectMap<PlayerLevelData> levelMap = GameData.getPlayerLevelDataMap();
        for (int i = 1; i <= getLevel(); i++) {
            PlayerLevelData data = levelMap.get(i);
            if (data != null) {
                expeditionLimit += data.getExpeditionLimitAdd();
            }
        }
        return expeditionLimit;
    }

    public Set<Integer> getUnlockedSceneAreas(int sceneId) {
        return this.unlockedSceneAreas.computeIfAbsent(Integer.valueOf(sceneId), i -> {
            return new CopyOnWriteArraySet();
        });
    }

    public Set<Integer> getUnlockedScenePoints(int sceneId) {
        return this.unlockedScenePoints.computeIfAbsent(Integer.valueOf(sceneId), i -> {
            return new CopyOnWriteArraySet();
        });
    }

    public int getLevel() {
        return getProperty(PlayerProperty.PROP_PLAYER_LEVEL);
    }

    public boolean setLevel(int level) {
        if (getLevel() == level) {
            return true;
        }
        if (!setProperty(PlayerProperty.PROP_PLAYER_LEVEL, level)) {
            return false;
        }
        updateWorldLevel();
        updateProfile();
        getProgressManager().tryUnlockOpenStates();
        getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_PLAYER_LEVEL_UP, level);
        return true;
    }

    public int getExp() {
        return getProperty(PlayerProperty.PROP_PLAYER_EXP);
    }

    public int getWorldLevel() {
        return getProperty(PlayerProperty.PROP_PLAYER_WORLD_LEVEL);
    }

    public boolean setWorldLevel(int level) {
        if (!setProperty(PlayerProperty.PROP_PLAYER_WORLD_LEVEL, level)) {
            return false;
        }
        if (this.world.getHost() == this) {
            this.world.setWorldLevel(level);
        }
        updateProfile();
        return true;
    }

    public boolean setElement(ElementType use) {
        if (use == null) {
            return false;
        }
        try {
            EntityAvatar entity_current_avatar = getTeamManager().getCurrentAvatarEntity();
            if (entity_current_avatar == null) {
                return false;
            }
            int avatarId = entity_current_avatar.getAvatar().getAvatarId();
            if (avatarId != 10000005 && avatarId != 10000007) {
                return false;
            }
            entity_current_avatar.getAvatar().changeElement(use);
            return true;
        } catch (Exception e) {
            Grasscutter.getLogger().error("Switch Element Error:", (Throwable) e);
            return false;
        }
    }

    public int getForgePoints() {
        return getProperty(PlayerProperty.PROP_PLAYER_FORGE_POINT);
    }

    public boolean setForgePoints(int value) {
        if (value == getForgePoints()) {
            return true;
        }
        return setProperty(PlayerProperty.PROP_PLAYER_FORGE_POINT, value);
    }

    public int getPrimogems() {
        return getProperty(PlayerProperty.PROP_PLAYER_HCOIN);
    }

    public boolean setPrimogems(int primogem) {
        return setProperty(PlayerProperty.PROP_PLAYER_HCOIN, primogem);
    }

    public int getMora() {
        return getProperty(PlayerProperty.PROP_PLAYER_SCOIN);
    }

    public boolean setMora(int mora) {
        return setProperty(PlayerProperty.PROP_PLAYER_SCOIN, mora);
    }

    public int getCrystals() {
        return getProperty(PlayerProperty.PROP_PLAYER_MCOIN);
    }

    public boolean setCrystals(int crystals) {
        return setProperty(PlayerProperty.PROP_PLAYER_MCOIN, crystals);
    }

    public int getHomeCoin() {
        return getProperty(PlayerProperty.PROP_PLAYER_HOME_COIN);
    }

    public boolean setHomeCoin(int coin) {
        return setProperty(PlayerProperty.PROP_PLAYER_HOME_COIN, coin);
    }

    private int getExpRequired(int level) {
        PlayerLevelData levelData = GameData.getPlayerLevelDataMap().get(level);
        if (levelData != null) {
            return levelData.getExp();
        }
        return 0;
    }

    private float getExpModifier() {
        return Configuration.GAME_OPTIONS.rates.adventureExp;
    }

    public void earnExp(int exp) {
        addExpDirectly((int) (((float) exp) * getExpModifier()));
    }

    public void addExpDirectly(int gain) {
        int level = getLevel();
        int exp = getExp();
        int reqExp = getExpRequired(level);
        int exp2 = exp + gain;
        while (exp2 >= reqExp && reqExp > 0) {
            exp2 -= reqExp;
            level++;
            reqExp = getExpRequired(level);
            setLevel(level);
        }
        setProperty(PlayerProperty.PROP_PLAYER_EXP, exp2);
    }

    private void updateWorldLevel() {
        int newWorldLevel;
        int currentWorldLevel = getWorldLevel();
        int currentLevel = getLevel();
        if (currentLevel >= 55) {
            newWorldLevel = 8;
        } else if (currentLevel >= 50) {
            newWorldLevel = 7;
        } else if (currentLevel >= 45) {
            newWorldLevel = 6;
        } else if (currentLevel >= 40) {
            newWorldLevel = 5;
        } else if (currentLevel >= 35) {
            newWorldLevel = 4;
        } else {
            newWorldLevel = currentLevel >= 30 ? 3 : currentLevel >= 25 ? 2 : currentLevel >= 20 ? 1 : 0;
        }
        if (newWorldLevel != currentWorldLevel) {
            setWorldLevel(newWorldLevel);
        }
    }

    private void updateProfile() {
        getProfile().syncWithCharacter(this);
    }

    public boolean isFirstLoginEnterScene() {
        return !this.hasSentLoginPackets;
    }

    public TowerData getTowerData() {
        if (this.towerData == null) {
            this.towerData = new TowerData();
        }
        return this.towerData;
    }

    public void onEnterRegion(SceneRegion region) {
        getQuestManager().forEachActiveQuest(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
              (wrap: emu.grasscutter.game.quest.QuestManager : 0x0001: INVOKE  (r0v1 emu.grasscutter.game.quest.QuestManager A[REMOVE]) = (r4v0 'this' emu.grasscutter.game.player.Player A[D('this' emu.grasscutter.game.player.Player), IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: emu.grasscutter.game.player.Player.getQuestManager():emu.grasscutter.game.quest.QuestManager)
              (wrap: java.util.function.Consumer<emu.grasscutter.game.quest.GameQuest> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Consumer<emu.grasscutter.game.quest.GameQuest> A[REMOVE]) = 
              (r4v0 'this' emu.grasscutter.game.player.Player A[D('this' emu.grasscutter.game.player.Player), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'region' emu.grasscutter.scripts.data.SceneRegion A[D('region' emu.grasscutter.scripts.data.SceneRegion), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  
              (r1 I:emu.grasscutter.game.player.Player)
              (r2 I:emu.grasscutter.scripts.data.SceneRegion)
              (v2 emu.grasscutter.game.quest.GameQuest)
             type: VIRTUAL call: emu.grasscutter.game.player.Player.lambda$onEnterRegion$2(emu.grasscutter.scripts.data.SceneRegion, emu.grasscutter.game.quest.GameQuest):void)
             type: VIRTUAL call: emu.grasscutter.game.quest.QuestManager.forEachActiveQuest(java.util.function.Consumer):void in method: emu.grasscutter.game.player.Player.onEnterRegion(emu.grasscutter.scripts.data.SceneRegion):void, file: grasscutter.jar:emu/grasscutter/game/player/Player.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r4
            emu.grasscutter.game.quest.QuestManager r0 = r0.getQuestManager()
            r1 = r4
            r2 = r5
            void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$onEnterRegion$2(r2, v2);
            }
            r0.forEachActiveQuest(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.player.Player.onEnterRegion(emu.grasscutter.scripts.data.SceneRegion):void");
    }

    public void onLeaveRegion(SceneRegion region) {
        getQuestManager().forEachActiveQuest(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000b: INVOKE  
              (wrap: emu.grasscutter.game.quest.QuestManager : 0x0001: INVOKE  (r0v1 emu.grasscutter.game.quest.QuestManager A[REMOVE]) = (r4v0 'this' emu.grasscutter.game.player.Player A[D('this' emu.grasscutter.game.player.Player), IMMUTABLE_TYPE, THIS]) type: VIRTUAL call: emu.grasscutter.game.player.Player.getQuestManager():emu.grasscutter.game.quest.QuestManager)
              (wrap: java.util.function.Consumer<emu.grasscutter.game.quest.GameQuest> : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Consumer<emu.grasscutter.game.quest.GameQuest> A[REMOVE]) = 
              (r4v0 'this' emu.grasscutter.game.player.Player A[D('this' emu.grasscutter.game.player.Player), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'region' emu.grasscutter.scripts.data.SceneRegion A[D('region' emu.grasscutter.scripts.data.SceneRegion), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  
              (r1 I:emu.grasscutter.game.player.Player)
              (r2 I:emu.grasscutter.scripts.data.SceneRegion)
              (v2 emu.grasscutter.game.quest.GameQuest)
             type: VIRTUAL call: emu.grasscutter.game.player.Player.lambda$onLeaveRegion$3(emu.grasscutter.scripts.data.SceneRegion, emu.grasscutter.game.quest.GameQuest):void)
             type: VIRTUAL call: emu.grasscutter.game.quest.QuestManager.forEachActiveQuest(java.util.function.Consumer):void in method: emu.grasscutter.game.player.Player.onLeaveRegion(emu.grasscutter.scripts.data.SceneRegion):void, file: grasscutter.jar:emu/grasscutter/game/player/Player.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r4
            emu.grasscutter.game.quest.QuestManager r0 = r0.getQuestManager()
            r1 = r4
            r2 = r5
            void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$onLeaveRegion$3(r2, v2);
            }
            r0.forEachActiveQuest(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.player.Player.onLeaveRegion(emu.grasscutter.scripts.data.SceneRegion):void");
    }

    public PlayerProfile getProfile() {
        if (this.playerProfile == null) {
            this.playerProfile = new PlayerProfile(this);
        }
        return this.playerProfile;
    }

    public boolean setProperty(PlayerProperty prop, int value) {
        return setPropertyWithSanityCheck(prop, value, true);
    }

    public boolean setProperty(PlayerProperty prop, int value, boolean sendPacket) {
        return setPropertyWithSanityCheck(prop, value, sendPacket);
    }

    public int getProperty(PlayerProperty prop) {
        return getProperties().get(Integer.valueOf(prop.getId())).intValue();
    }

    public synchronized Int2ObjectMap<CoopRequest> getCoopRequests() {
        return this.coopRequests;
    }

    public void setNameCardId(int nameCardId) {
        this.nameCardId = nameCardId;
        updateProfile();
    }

    public void setMainCharacterId(int mainCharacterId) {
        if (this.mainCharacterId == 0) {
            this.mainCharacterId = mainCharacterId;
        }
    }

    public int getClientTime() {
        return this.session.getClientTime();
    }

    public long getLastPingTime() {
        return this.session.getLastPingTime();
    }

    public void setPaused(boolean newPauseState) {
        boolean oldPauseState = this.paused;
        this.paused = newPauseState;
        if (newPauseState && !oldPauseState) {
            onPause();
        } else if (oldPauseState && !newPauseState) {
            onUnpause();
        }
    }

    public boolean isInMultiplayer() {
        return getWorld() != null && getWorld().isMultiplayer();
    }

    public boolean inMoonCard() {
        return this.moonCard;
    }

    public void addMoonCardDays(int days) {
        this.moonCardDuration += days;
    }

    public int getMoonCardRemainDays() {
        Calendar remainCalendar = Calendar.getInstance();
        remainCalendar.setTime(this.moonCardStartTime);
        remainCalendar.add(5, this.moonCardDuration);
        return (int) ((remainCalendar.getTime().getTime() - DateHelper.onlyYearMonthDay(new Date()).getTime()) / 86400000);
    }

    public boolean rechargeMoonCard() {
        if (this.moonCardDuration > 150) {
            return false;
        }
        this.inventory.addItem(new GameItem(203, 300));
        if (!this.moonCard) {
            this.moonCard = true;
            this.moonCardStartTime = DateHelper.onlyYearMonthDay(new Date());
            this.moonCardDuration = 30;
        } else {
            this.moonCardDuration += 30;
        }
        if (this.moonCardGetTimes.contains(this.moonCardStartTime)) {
            return true;
        }
        this.moonCardGetTimes.add(this.moonCardStartTime);
        return true;
    }

    public void getTodayMoonCard() {
        if (this.moonCard) {
            Date now = DateHelper.onlyYearMonthDay(new Date());
            if (!this.moonCardGetTimes.contains(now)) {
                Date stopTime = new Date();
                Calendar stopCalendar = Calendar.getInstance();
                stopCalendar.setTime(stopTime);
                stopCalendar.add(5, this.moonCardDuration);
                if (now.after(stopCalendar.getTime())) {
                    this.moonCard = false;
                    return;
                }
                this.moonCardGetTimes.add(now);
                addMoonCardDays(1);
                getInventory().addItem(new GameItem(201, 90), ActionReason.BlessingRedeemReward);
                this.session.send(new PacketCardProductRewardNotify(getMoonCardRemainDays()));
            }
        }
    }

    public void addExpeditionInfo(long avatarGuid, int expId, int hourTime, int startTime) {
        ExpeditionInfo exp = new ExpeditionInfo();
        exp.setExpId(expId);
        exp.setHourTime(hourTime);
        exp.setState(1);
        exp.setStartTime(startTime);
        this.expeditionInfo.put(Long.valueOf(avatarGuid), exp);
    }

    public void removeExpeditionInfo(long avatarGuid) {
        this.expeditionInfo.remove(Long.valueOf(avatarGuid));
    }

    public ExpeditionInfo getExpeditionInfo(long avatarGuid) {
        return this.expeditionInfo.get(Long.valueOf(avatarGuid));
    }

    public ShopLimit getGoodsLimit(int goodsId) {
        Optional<ShopLimit> shopLimit = this.shopLimit.stream().filter(x -> {
            return x.getShopGoodId() == goodsId;
        }).findFirst();
        if (shopLimit.isEmpty()) {
            return null;
        }
        return shopLimit.get();
    }

    public void addShopLimit(int goodsId, int boughtCount, int nextRefreshTime) {
        ShopLimit target = getGoodsLimit(goodsId);
        if (target != null) {
            target.setHasBought(target.getHasBought() + boughtCount);
            target.setHasBoughtInPeriod(target.getHasBoughtInPeriod() + boughtCount);
            target.setNextRefreshTime(nextRefreshTime);
        } else {
            ShopLimit sl = new ShopLimit();
            sl.setShopGoodId(goodsId);
            sl.setHasBought(boughtCount);
            sl.setHasBoughtInPeriod(boughtCount);
            sl.setNextRefreshTime(nextRefreshTime);
            getShopLimit().add(sl);
        }
        save();
    }

    public boolean getUnlimitedStamina() {
        return this.stamina;
    }

    public void setUnlimitedStamina(boolean stamina) {
        this.stamina = stamina;
    }

    public boolean inGodmode() {
        return this.godmode;
    }

    public boolean hasSentLoginPackets() {
        return this.hasSentLoginPackets;
    }

    public void addAvatar(Avatar avatar, boolean addToCurrentTeam) {
        if (getAvatars().addAvatar(avatar)) {
            getAvatars().addStartingWeapon(avatar);
            if (hasSentLoginPackets()) {
                avatar.recalcStats();
                sendPacket(new PacketAvatarAddNotify(avatar, addToCurrentTeam && getTeamManager().canAddAvatarToCurrentTeam()));
                if (addToCurrentTeam) {
                    getTeamManager().addAvatarToCurrentTeam(avatar);
                }
            }
        }
    }

    public void addAvatar(Avatar avatar) {
        addAvatar(avatar, true);
    }

    public void addFlycloak(int flycloakId) {
        getFlyCloakList().add(Integer.valueOf(flycloakId));
        sendPacket(new PacketAvatarGainFlycloakNotify(flycloakId));
    }

    public void addCostume(int costumeId) {
        getCostumeList().add(Integer.valueOf(costumeId));
        sendPacket(new PacketAvatarGainCostumeNotify(costumeId));
    }

    public void addNameCard(int nameCardId) {
        getNameCardList().add(Integer.valueOf(nameCardId));
        sendPacket(new PacketUnlockNameCardNotify(nameCardId));
    }

    public void setNameCard(int nameCardId) {
        if (getNameCardList().contains(Integer.valueOf(nameCardId))) {
            setNameCardId(nameCardId);
            sendPacket(new PacketSetNameCardRsp(nameCardId));
        }
    }

    public void dropMessage(Object message) {
        if (this.messageHandler != null) {
            this.messageHandler.append(message.toString());
        } else {
            getServer().getChatSystem().sendPrivateMessageFromServer(getUid(), message.toString());
        }
    }

    public void setAvatarsAbilityForScene(Scene scene) {
        try {
            ConfigLevelEntity config = GameData.getConfigLevelEntityDataMap().get(scene.getSceneData().getLevelEntityConfig());
            if (config != null) {
                List<Integer> avatarIds = scene.getSceneData().getSpecifiedAvatarList();
                List<EntityAvatar> specifiedAvatarList = getTeamManager().getActiveTeam();
                if (avatarIds != null && avatarIds.size() > 0) {
                    specifiedAvatarList.clear();
                    for (Integer num : avatarIds) {
                        Avatar avatar = getAvatars().getAvatarById(num.intValue());
                        if (avatar != null) {
                            specifiedAvatarList.add(new EntityAvatar(scene, avatar));
                        }
                    }
                }
                for (EntityAvatar entityAvatar : specifiedAvatarList) {
                    AvatarData avatarData = entityAvatar.getAvatar().getAvatarData();
                    if (avatarData != null) {
                        avatarData.rebuildAbilityEmbryo();
                        if (config.getAvatarAbilities() != null) {
                            for (ConfigLevelEntity.EntityAbilities abilities : config.getAvatarAbilities()) {
                                avatarData.getAbilities().add(Utils.abilityHash(abilities.getAbilityName()));
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error applying level entity config for scene {}", Integer.valueOf(scene.getSceneData().getId()), e);
        }
    }

    public void sendMessage(Player sender, Object message) {
        getServer().getChatSystem().sendPrivateMessage(sender, getUid(), message.toString());
    }

    public List<Mail> getAllMail() {
        return getMailHandler().getMail();
    }

    public void sendMail(Mail message) {
        getMailHandler().sendMail(message);
    }

    public boolean deleteMail(int mailId) {
        return getMailHandler().deleteMail(mailId);
    }

    public Mail getMail(int index) {
        return getMailHandler().getMailById(index);
    }

    public int getMailId(Mail message) {
        return getMailHandler().getMailIndex(message);
    }

    public boolean replaceMailByIndex(int index, Mail message) {
        return getMailHandler().replaceMailByIndex(index, message);
    }

    public void interactWith(int gadgetEntityId, GadgetInteractReqOuterClass.GadgetInteractReq interactReq) {
        GameEntity target = getScene().getEntityById(gadgetEntityId);
        if (target != null) {
            target.onInteract(this, interactReq);
        }
    }

    public void onPause() {
        getStaminaManager().stopSustainedStaminaHandler();
    }

    public void onUnpause() {
        getStaminaManager().startSustainedStaminaHandler();
    }

    public void sendPacket(BasePacket packet) {
        if (getSession() != null) {
            getSession().send(packet);
        }
    }

    public OnlinePlayerInfoOuterClass.OnlinePlayerInfo getOnlinePlayerInfo() {
        OnlinePlayerInfoOuterClass.OnlinePlayerInfo.Builder onlineInfo = OnlinePlayerInfoOuterClass.OnlinePlayerInfo.newBuilder().setUid(getUid()).setNickname(getNickname()).setPlayerLevel(getLevel()).setMpSettingType(getMpSetting()).setNameCardId(getNameCardId()).setSignature(getSignature()).setProfilePicture(ProfilePictureOuterClass.ProfilePicture.newBuilder().setAvatarId(getHeadImage()));
        if (getWorld() != null) {
            onlineInfo.setCurPlayerNumInWorld(getWorld().getPlayerCount());
        } else {
            onlineInfo.setCurPlayerNumInWorld(1);
        }
        return onlineInfo.build();
    }

    public void setBirthday(int d, int m) {
        this.birthday = new PlayerBirthday(d, m);
        updateProfile();
    }

    public boolean hasBirthday() {
        return this.birthday.getDay() > 0;
    }

    public SocialDetailOuterClass.SocialDetail.Builder getSocialDetail() {
        List<SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo> socialShowAvatarInfoList = new ArrayList<>();
        if (!isOnline()) {
            List<Integer> showAvatarList = DatabaseHelper.getPlayerByUid(this.f582id).getShowAvatarList();
            AvatarStorage avatars = DatabaseHelper.getPlayerByUid(this.f582id).getAvatars();
            avatars.loadFromDatabase();
            if (showAvatarList != null) {
                for (Integer num : showAvatarList) {
                    int avatarId = num.intValue();
                    socialShowAvatarInfoList.add(socialShowAvatarInfoList.size(), SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.newBuilder().setAvatarId(avatarId).setLevel(avatars.getAvatarById(avatarId).getLevel()).setCostumeId(avatars.getAvatarById(avatarId).getCostume()).build());
                }
            }
        } else if (getShowAvatarList() != null) {
            for (Integer num2 : getShowAvatarList()) {
                int avatarId2 = num2.intValue();
                socialShowAvatarInfoList.add(socialShowAvatarInfoList.size(), SocialShowAvatarInfoOuterClass.SocialShowAvatarInfo.newBuilder().setAvatarId(avatarId2).setLevel(getAvatars().getAvatarById(avatarId2).getLevel()).setCostumeId(getAvatars().getAvatarById(avatarId2).getCostume()).build());
            }
        }
        return SocialDetailOuterClass.SocialDetail.newBuilder().setUid(getUid()).setProfilePicture(ProfilePictureOuterClass.ProfilePicture.newBuilder().setAvatarId(getHeadImage())).setNickname(getNickname()).setSignature(getSignature()).setLevel(getLevel()).setBirthday(getBirthday().getFilledProtoWhenNotEmpty()).setWorldLevel(getWorldLevel()).setNameCardId(getNameCardId()).setIsShowAvatar(isShowAvatars()).addAllShowAvatarInfoList(socialShowAvatarInfoList).addAllShowNameCardIdList(getShowNameCardInfoList()).setFinishAchievementNum(0).setFriendEnterHomeOptionValue(getHome() == null ? 0 : getHome().getEnterHomeOption());
    }

    public List<ShowAvatarInfoOuterClass.ShowAvatarInfo> getShowAvatarInfoList() {
        boolean shouldRecalc;
        Player player;
        List<ShowAvatarInfoOuterClass.ShowAvatarInfo> showAvatarInfoList = new ArrayList<>();
        if (isOnline()) {
            player = this;
            shouldRecalc = false;
        } else {
            player = DatabaseHelper.getPlayerByUid(this.f582id);
            player.getAvatars().loadFromDatabase();
            player.getInventory().loadFromDatabase();
            shouldRecalc = true;
        }
        List<Integer> showAvatarList = player.getShowAvatarList();
        AvatarStorage avatars = player.getAvatars();
        if (showAvatarList != null) {
            for (Integer num : showAvatarList) {
                Avatar avatar = avatars.getAvatarById(num.intValue());
                if (shouldRecalc) {
                    avatar.recalcStats();
                }
                showAvatarInfoList.add(avatar.toShowAvatarInfoProto());
            }
        }
        return showAvatarInfoList;
    }

    public List<Integer> getShowNameCardInfoList() {
        List<Integer> info = getShowNameCardList();
        return info == null ? new ArrayList() : info;
    }

    public PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo getWorldPlayerLocationInfo() {
        return PlayerWorldLocationInfoOuterClass.PlayerWorldLocationInfo.newBuilder().setSceneId(getSceneId()).setPlayerLoc(getPlayerLocationInfo()).build();
    }

    public PlayerLocationInfoOuterClass.PlayerLocationInfo getPlayerLocationInfo() {
        return PlayerLocationInfoOuterClass.PlayerLocationInfo.newBuilder().setUid(getUid()).setPos(getPosition().toProto()).setRot(getRotation().toProto()).build();
    }

    public void loadBattlePassManager() {
        if (this.battlePassManager == null) {
            this.battlePassManager = DatabaseHelper.loadBattlePass(this);
            this.battlePassManager.getMissions().values().removeIf(mission -> {
                return mission.getData() == null;
            });
        }
    }

    public PlayerCollectionRecords getCollectionRecordStore() {
        if (this.collectionRecordStore == null) {
            this.collectionRecordStore = new PlayerCollectionRecords();
        }
        return this.collectionRecordStore;
    }

    public Map<String, MapMark> getMapMarks() {
        if (this.mapMarks == null) {
            this.mapMarks = new HashMap<>();
        }
        return this.mapMarks;
    }

    private boolean expireCoopRequest(CoopRequest req) {
        if (!req.isExpired()) {
            return false;
        }
        req.getRequester().sendPacket(new PacketPlayerApplyEnterMpResultNotify(this, false, PlayerApplyEnterMpResultNotifyOuterClass.PlayerApplyEnterMpResultNotify.Reason.REASON_SYSTEM_JUDGE));
        return true;
    }

    public synchronized void onTick() {
        long time = System.currentTimeMillis();
        getCoopRequests().values().removeIf(this::expireCoopRequest);
        getBuffManager().onTick();
        if (getWorld() != null) {
            sendPacket(new PacketWorldPlayerRTTNotify(getWorld()));
            if (getWorld().isMultiplayer() && getScene() != null && time > this.nextSendPlayerLocTime) {
                sendPacket(new PacketWorldPlayerLocationNotify(getWorld()));
                sendPacket(new PacketScenePlayerLocationNotify(getScene()));
                resetSendPlayerLocTime();
            }
        }
        doDailyReset();
        if (time > this.nextCheckPlayerActivities) {
            this.activityManager = new ActivityManager(this);
            resetCheckPlayerActivitie();
        }
        int timeNow = Utils.getCurrentSeconds();
        boolean needNotify = false;
        for (ExpeditionInfo e : this.expeditionInfo.values()) {
            if (e.getState() == 1 && timeNow - e.getStartTime() >= e.getHourTime() * 60 * 60) {
                e.setState(2);
                needNotify = true;
            }
        }
        if (needNotify) {
            save();
            sendPacket(new PacketAvatarExpeditionDataNotify(getExpeditionInfo()));
        }
        getForgingManager().sendPlayerForgingUpdate();
        getResinManager().rechargeResin();
        getSatiationManager().reduceSatiation();
    }

    private synchronized void doDailyReset() {
        int currentTime = Utils.getCurrentSeconds();
        LocalDate currentDate = LocalDate.ofInstant(Instant.ofEpochSecond((long) currentTime), ZoneId.systemDefault());
        if (currentDate.isAfter(LocalDate.ofInstant(Instant.ofEpochSecond((long) getLastDailyReset()), ZoneId.systemDefault()))) {
            setForgePoints(300000);
            getBattlePassManager().resetDailyMissions();
            getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_LOGIN);
            if (currentDate.getDayOfWeek() == DayOfWeek.MONDAY) {
                getBattlePassManager().resetWeeklyMissions();
            }
            setLastDailyReset(currentTime);
        }
    }

    public void resetSendPlayerLocTime() {
        this.nextSendPlayerLocTime = System.currentTimeMillis() + 5000;
    }

    public void resetCheckPlayerActivitie() {
        this.nextCheckPlayerActivities = System.currentTimeMillis() + 300000;
    }

    @PostLoad
    private void onLoad() {
        getCodex().setPlayer(this);
        getProgressManager().setPlayer(this);
        getTeamManager().setPlayer(this);
    }

    public void save() {
        DatabaseHelper.savePlayer(this);
    }

    public void onPlayerBorn() {
        if (Grasscutter.getConfig().server.game.gameOptions.questing) {
            getQuestManager().onNewPlayerCreate();
        }
    }

    public void onLogout(boolean delete) {
        try {
            getServer().getChatSystem().clearHistoryOnLogout(this);
            getStaminaManager().stopSustainedStaminaHandler();
            getServer().getDungeonSystem().exitDungeon(this);
            if (getWorld() != null) {
                getWorld().removePlayer(this);
            }
            getProfile().syncWithCharacter(this);
            getProfile().setPlayer(null);
            getCoopRequests().clear();
            save();
            getTeamManager().saveAvatars();
            getFriendsList().save();
            new PlayerQuitEvent(this).call();
            if (delete) {
                removeFromServer();
            }
        } catch (Throwable th) {
            if (delete) {
                removeFromServer();
            }
            throw th;
        }
    }

    public void removeFromServer() {
        getServer().getPlayers().values().removeIf(player1 -> {
            return player1 == this;
        });
    }

    public int getLegendaryKey() {
        return getProperty(PlayerProperty.PROP_PLAYER_LEGENDARY_KEY);
    }

    public synchronized void addLegendaryKey(int count) {
        setProperty(PlayerProperty.PROP_PLAYER_LEGENDARY_KEY, getLegendaryKey() + count);
    }

    public synchronized void useLegendaryKey(int count) {
        setProperty(PlayerProperty.PROP_PLAYER_LEGENDARY_KEY, getLegendaryKey() - count);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/player/Player$SceneLoadState.class */
    public enum SceneLoadState {
        NONE(0),
        LOADING(1),
        INIT(2),
        LOADED(3);
        
        private final int value;

        public int getValue() {
            return this.value;
        }

        SceneLoadState(int value) {
            this.value = value;
        }
    }

    public int getPropertyMin(PlayerProperty prop) {
        if (prop.isDynamicRange()) {
            return 0;
        }
        return prop.getMin();
    }

    public int getPropertyMax(PlayerProperty prop) {
        if (!prop.isDynamicRange()) {
            return prop.getMax();
        }
        switch (prop) {
            case PROP_CUR_SPRING_VOLUME:
                return getProperty(PlayerProperty.PROP_MAX_SPRING_VOLUME);
            case PROP_CUR_PERSIST_STAMINA:
                return getProperty(PlayerProperty.PROP_MAX_STAMINA);
            default:
                return 0;
        }
    }

    private boolean setPropertyWithSanityCheck(PlayerProperty prop, int value, boolean sendPacket) {
        if (prop == null) {
            return false;
        }
        int min = getPropertyMin(prop);
        int max = getPropertyMax(prop);
        if (min > value || value > max) {
            return false;
        }
        try {
            int currentValue = this.properties.get(Integer.valueOf(prop.getId())).intValue();
            this.properties.put(Integer.valueOf(prop.getId()), Integer.valueOf(value));
            if (!sendPacket) {
                return true;
            }
            sendPacket(new PacketPlayerPropNotify(this, prop));
            sendPacket(new PacketPlayerPropChangeNotify(this, prop, value - currentValue));
            if (prop != PlayerProperty.PROP_PLAYER_EXP) {
                return true;
            }
            sendPacket(new PacketPlayerPropChangeReasonNotify(this, prop, currentValue, value, PropChangeReasonOuterClass.PropChangeReason.PROP_CHANGE_REASON_PLAYER_ADD_EXP));
            return true;
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error setPropertyWithSanityCheck", (Throwable) e);
            return false;
        }
    }
}
