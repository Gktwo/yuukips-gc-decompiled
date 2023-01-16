package emu.grasscutter.server.game;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.battlepass.BattlePassSystem;
import emu.grasscutter.game.chat.ChatSystem;
import emu.grasscutter.game.chat.ChatSystemHandler;
import emu.grasscutter.game.combine.CombineManger;
import emu.grasscutter.game.drop.DropSystem;
import emu.grasscutter.game.drop.DropSystemLegacy;
import emu.grasscutter.game.dungeons.DungeonManager;
import emu.grasscutter.game.dungeons.DungeonSystem;
import emu.grasscutter.game.expedition.ExpeditionSystem;
import emu.grasscutter.game.gacha.GachaSystem;
import emu.grasscutter.game.managers.cooking.CookingCompoundManager;
import emu.grasscutter.game.managers.cooking.CookingManager;
import emu.grasscutter.game.managers.energy.EnergyManager;
import emu.grasscutter.game.managers.stamina.StaminaManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.QuestSystem;
import emu.grasscutter.game.shop.ShopSystem;
import emu.grasscutter.game.systems.AnnouncementSystem;
import emu.grasscutter.game.systems.InventorySystem;
import emu.grasscutter.game.systems.MultiplayerSystem;
import emu.grasscutter.game.tower.TowerSystem;
import emu.grasscutter.game.world.World;
import emu.grasscutter.game.world.WorldDataSystem;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.proto.SocialDetailOuterClass;
import emu.grasscutter.server.event.game.ServerTickEvent;
import emu.grasscutter.server.event.internal.ServerStartEvent;
import emu.grasscutter.server.event.types.ServerEvent;
import emu.grasscutter.server.scheduler.ServerTaskScheduler;
import emu.grasscutter.task.TaskMap;
import emu.grasscutter.utils.Language;
import java.net.InetSocketAddress;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import kcp.highway.ChannelConfig;
import kcp.highway.Kcp;
import kcp.highway.KcpServer;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/GameServer.class */
public final class GameServer extends KcpServer {
    private final InetSocketAddress address;
    private final GameServerPacketHandler packetHandler;
    private final Map<Integer, Player> players;
    private final Set<World> worlds;
    private final InventorySystem inventorySystem;
    private final GachaSystem gachaSystem;
    private final ShopSystem shopSystem;
    private final MultiplayerSystem multiplayerSystem;
    private final DungeonSystem dungeonSystem;
    private final ExpeditionSystem expeditionSystem;
    private final DropSystem dropSystem;
    private final DropSystemLegacy dropSystemLegacy;
    private final WorldDataSystem worldDataSystem;
    private final BattlePassSystem battlePassSystem;
    private final CombineManger combineSystem;
    private final TowerSystem towerSystem;
    private final AnnouncementSystem announcementSystem;
    private final QuestSystem questSystem;
    private final ServerTaskScheduler scheduler;
    private final TaskMap taskMap;
    private ChatSystemHandler chatManager;

    /*  JADX ERROR: Dependency scan failed at insn: 0x003C: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x003C: INVOKE_CUSTOM r1, method: emu.grasscutter.server.game.GameServer.onServerShutdown():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, -> Total Player ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, -> Total Player ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void onServerShutdown() {
        /*
            r5 = this;
            emu.grasscutter.server.event.internal.ServerStopEvent r0 = new emu.grasscutter.server.event.internal.ServerStopEvent
            r1 = r0
            emu.grasscutter.server.event.types.ServerEvent$Type r2 = emu.grasscutter.server.event.types.ServerEvent.Type.GAME
            java.time.OffsetDateTime r3 = java.time.OffsetDateTime.now()
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r0.call()
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r5
            java.util.Map r2 = r2.getPlayers()
            int r2 = r2.size()
            r1.<init>(r2)
            r7 = r0
            r0 = r7
            r1 = r5
            java.util.Map r1 = r1.getPlayers()
            java.util.Collection r1 = r1.values()
            boolean r0 = r0.addAll(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r7
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, -> Total Player ]}
            r0.info(r1)
            r0 = r7
            java.util.Iterator r0 = r0.iterator()
            r8 = r0
            r0 = r8
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x006b
            r0 = r8
            java.lang.Object r0 = r0.next()
            emu.grasscutter.game.player.Player r0 = (emu.grasscutter.game.player.Player) r0
            r9 = r0
            r0 = r9
            emu.grasscutter.server.game.GameSession r0 = r0.getSession()
            r1 = 0
            r0.Logout(r1)
            goto L_0x004b
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Shutdown Server..."
            r0.info(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameServer.onServerShutdown():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0005: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0005: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.game.GameServer.doExit(int, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Exit with code  | ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Exit with code  | ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static void doExit(int r4, java.lang.String r5) {
        /*
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Exit with code  | ]}
            r0.info(r1)
            r0 = r4
            java.lang.System.exit(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.game.GameServer.doExit(int, java.lang.String):void");
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    public GameServerPacketHandler getPacketHandler() {
        return this.packetHandler;
    }

    public Map<Integer, Player> getPlayers() {
        return this.players;
    }

    public Set<World> getWorlds() {
        return this.worlds;
    }

    public InventorySystem getInventorySystem() {
        return this.inventorySystem;
    }

    public GachaSystem getGachaSystem() {
        return this.gachaSystem;
    }

    public ShopSystem getShopSystem() {
        return this.shopSystem;
    }

    public MultiplayerSystem getMultiplayerSystem() {
        return this.multiplayerSystem;
    }

    public DungeonSystem getDungeonSystem() {
        return this.dungeonSystem;
    }

    public ExpeditionSystem getExpeditionSystem() {
        return this.expeditionSystem;
    }

    public DropSystem getDropSystem() {
        return this.dropSystem;
    }

    public DropSystemLegacy getDropSystemLegacy() {
        return this.dropSystemLegacy;
    }

    public WorldDataSystem getWorldDataSystem() {
        return this.worldDataSystem;
    }

    public BattlePassSystem getBattlePassSystem() {
        return this.battlePassSystem;
    }

    public CombineManger getCombineSystem() {
        return this.combineSystem;
    }

    public TowerSystem getTowerSystem() {
        return this.towerSystem;
    }

    public AnnouncementSystem getAnnouncementSystem() {
        return this.announcementSystem;
    }

    public QuestSystem getQuestSystem() {
        return this.questSystem;
    }

    public ServerTaskScheduler getScheduler() {
        return this.scheduler;
    }

    public TaskMap getTaskMap() {
        return this.taskMap;
    }

    public ChatSystemHandler getChatManager() {
        return this.chatManager;
    }

    public GameServer() {
        this(getAdapterInetSocketAddress());
    }

    public GameServer(InetSocketAddress address) {
        ChannelConfig channelConfig = new ChannelConfig();
        channelConfig.nodelay(true, Configuration.GAME_INFO.kcpInterval, 2, true);
        channelConfig.setMtu(Kcp.IKCP_MTU_DEF);
        channelConfig.setSndwnd(256);
        channelConfig.setRcvwnd(256);
        channelConfig.setTimeoutMillis(30000);
        channelConfig.setUseConvChannel(true);
        channelConfig.setAckNoDelay(false);
        init(GameSessionManager.getListener(), channelConfig, address);
        Grasscutter.ServerRunMode runMode = Grasscutter.getRunMode();
        if (runMode == Grasscutter.ServerRunMode.GAME_ONLY || runMode == Grasscutter.ServerRunMode.HYBRID) {
            DungeonManager.initialize();
            EnergyManager.initialize();
            StaminaManager.initialize();
            CookingManager.initialize();
            CookingCompoundManager.initialize();
            CombineManger.initialize();
        }
        this.address = address;
        this.packetHandler = new GameServerPacketHandler(PacketHandler.class);
        this.players = new ConcurrentHashMap();
        this.worlds = Collections.synchronizedSet(new HashSet());
        this.scheduler = new ServerTaskScheduler();
        this.taskMap = new TaskMap(true);
        this.inventorySystem = new InventorySystem(this);
        this.gachaSystem = new GachaSystem(this);
        this.shopSystem = new ShopSystem(this);
        this.multiplayerSystem = new MultiplayerSystem(this);
        this.dungeonSystem = new DungeonSystem(this);
        this.dropSystem = new DropSystem(this);
        this.dropSystemLegacy = new DropSystemLegacy(this);
        this.expeditionSystem = new ExpeditionSystem(this);
        this.combineSystem = new CombineManger(this);
        this.towerSystem = new TowerSystem(this);
        this.worldDataSystem = new WorldDataSystem(this);
        this.battlePassSystem = new BattlePassSystem(this);
        this.announcementSystem = new AnnouncementSystem(this);
        this.questSystem = new QuestSystem(this);
        this.chatManager = new ChatSystem(this);
        Runtime.getRuntime().addShutdownHook(new Thread(this::onServerShutdown));
    }

    public ChatSystemHandler getChatSystem() {
        return this.chatManager;
    }

    public void setChatSystem(ChatSystemHandler chatManager) {
        this.chatManager = chatManager;
    }

    private static InetSocketAddress getAdapterInetSocketAddress() {
        InetSocketAddress inetSocketAddress;
        if (Configuration.GAME_INFO.bindAddress.equals("")) {
            inetSocketAddress = new InetSocketAddress(Configuration.GAME_INFO.bindPort);
        } else {
            inetSocketAddress = new InetSocketAddress(Configuration.GAME_INFO.bindAddress, Configuration.GAME_INFO.bindPort);
        }
        return inetSocketAddress;
    }

    public void registerPlayer(Player player) {
        getPlayers().put(Integer.valueOf(player.getUid()), player);
    }

    public Player getPlayerByUid(int id) {
        return getPlayerByUid(id, false);
    }

    public Player getPlayerByUid(int id, boolean allowOfflinePlayers) {
        if (id == 99) {
            return null;
        }
        Player player = getPlayers().get(Integer.valueOf(id));
        if (!allowOfflinePlayers) {
            return player;
        }
        if (player == null) {
            player = DatabaseHelper.getPlayerByUid(id);
        }
        return player;
    }

    public Player getPlayerOnlineByUid(int id) {
        return getPlayers().get(Integer.valueOf(id));
    }

    public Player getPlayerByAccountId(String accountId) {
        return getPlayers().values().stream().filter(player -> {
            return player.getAccount().getId().equals(accountId);
        }).findFirst().orElse(null);
    }

    public SocialDetailOuterClass.SocialDetail.Builder getSocialDetailByUid(int id) {
        Player player = getPlayerByUid(id, true);
        if (player == null) {
            return null;
        }
        return player.getSocialDetail();
    }

    public Account getAccountByName(String username) {
        Optional<Player> playerOpt = getPlayers().values().stream().filter(player -> {
            return player.getAccount().getUsername().equals(username);
        }).findFirst();
        if (playerOpt.isPresent()) {
            return playerOpt.get().getAccount();
        }
        return DatabaseHelper.getAccountByName(username);
    }

    public synchronized void onTick() {
        Instant tickStart = Instant.now();
        try {
            this.worlds.removeIf((v0) -> {
                return v0.onTick();
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error Tick Worlds: ", (Throwable) e);
        }
        try {
            this.players.values().forEach((v0) -> {
                v0.onTick();
            });
        } catch (Exception e2) {
            Grasscutter.getLogger().error("Error Tick Player: ", (Throwable) e2);
        }
        try {
            getScheduler().runTasks();
        } catch (Exception e3) {
            Grasscutter.getLogger().error("Error Tick Scheduler: ", (Throwable) e3);
        }
        new ServerTickEvent(tickStart, Instant.now()).call();
    }

    public void registerWorld(World world) {
        getWorlds().add(world);
    }

    public void deregisterWorld(World world) {
    }

    public void start() {
        new Timer().scheduleAtFixedRate(new TimerTask() { // from class: emu.grasscutter.server.game.GameServer.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    GameServer.this.onTick();
                } catch (Exception e) {
                    Grasscutter.getLogger().error(Language.translate("messages.game.game_update_error", new Object[0]), (Throwable) e);
                }
            }
        }, new Date(), 1000);
        Grasscutter.getLogger().info(Language.translate("messages.status.free_software", new Object[0]));
        Grasscutter.getLogger().info(Language.translate("messages.game.address_bind", Configuration.GAME_INFO.accessAddress, Integer.valueOf(this.address.getPort())));
        new ServerStartEvent(ServerEvent.Type.GAME, OffsetDateTime.now()).call();
    }
}
