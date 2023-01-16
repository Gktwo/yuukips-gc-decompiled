package emu.grasscutter.game.quest;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.MainQuestData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.quest.enums.ParentQuestState;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.server.packet.send.PacketFinishedParentQuestUpdateNotify;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import org.eclipse.jetty.http.HttpStatus;
import p001ch.qos.logback.classic.Logger;
import p013io.netty.util.concurrent.FastThreadLocalThread;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/QuestManager.class */
public class QuestManager extends BasePlayerManager {
    private final Player player;
    private final Int2ObjectMap<GameMainQuest> mainQuests = new Int2ObjectOpenHashMap();
    public static final ExecutorService eventExecutor = new ThreadPoolExecutor(4, 4, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(1000), FastThreadLocalThread::new, new ThreadPoolExecutor.AbortPolicy());

    @Override // emu.grasscutter.game.player.BasePlayerManager
    public Player getPlayer() {
        return this.player;
    }

    public Int2ObjectMap<GameMainQuest> getMainQuests() {
        return this.mainQuests;
    }

    public static long getQuestKey(int mainQuestId) {
        QuestEncryptionKey questEncryptionKey = GameData.getMainQuestEncryptionMap().get(mainQuestId);
        if (questEncryptionKey != null) {
            return questEncryptionKey.getEncryptionKey();
        }
        return 0;
    }

    public QuestManager(Player player) {
        super(player);
        this.player = player;
    }

    public void trySpecialQuest() {
        for (Integer id : GameData.getSpecialQuest()) {
            if (GameData.getQuestDataMap().get(id).getAcceptCond().size() == 1) {
                QuestData.QuestCondition condition = GameData.getQuestDataMap().get(id).getAcceptCond().get(0);
                if (condition.getType() == QuestTrigger.QUEST_COND_STATE_EQUAL) {
                    int Id = condition.getParam()[0];
                    int state = condition.getParam()[1];
                    GameQuest quest = getQuestById(Id);
                    GameQuest target = getQuestById(id.intValue());
                    if (quest != null && quest.getState().getValue() == state) {
                        if (target == null) {
                            addQuest(id.intValue());
                        } else if (target.getState() == QuestState.UNSTARTED) {
                            target.start();
                        }
                    }
                }
            }
        }
    }

    public void onNewPlayerCreate() {
    }

    public void onLogin() {
    }

    public void tryCheckAndAcceptQuest() {
        ObjectIterator<QuestData> it = GameData.getQuestDataMap().values().iterator();
        while (it.hasNext()) {
            QuestData value = it.next();
            if (value.getAcceptCond() == null || value.getAcceptCond().size() == 0) {
                GameQuest quest = getQuestById(value.getSubId());
                if (quest == null) {
                    addQuest(value.getSubId());
                } else if (quest.getState() == QuestState.QUEST_STATE_UNSTARTED) {
                    addQuest(value.getSubId());
                }
            }
        }
    }

    public void checkQuest() {
        List<GameMainQuest> activeQuests = getActiveMainQuests();
        new ArrayList(activeQuests.size());
        for (GameMainQuest quest : activeQuests) {
            List<Position> rewindPos = quest.rewind();
            Collection<GameQuest> activeQuest = quest.getActiveQuests();
            if (rewindPos != null) {
                getPlayer().getPosition().set(rewindPos.get(0));
                getPlayer().getRotation().set(rewindPos.get(1));
            }
            if (activeQuest == null || rewindPos != null) {
                quest.checkProgress();
            } else {
                quest.checkProgress();
            }
        }
    }

    public Integer getQuestGlobalVarValue(Integer variable) {
        return getPlayer().getQuestGlobalVariables().getOrDefault(variable, 0);
    }

    public void setQuestGlobalVarValue(Integer variable, Integer value) {
        Integer previousValue = getPlayer().getQuestGlobalVariables().put(variable, value);
        Logger logger = Grasscutter.getLogger();
        Object[] objArr = new Object[3];
        objArr[0] = variable;
        objArr[1] = Integer.valueOf(previousValue == null ? 0 : previousValue.intValue());
        objArr[2] = value;
        logger.warn("Changed questGlobalVar {} value from {} to {}", objArr);
    }

    public void incQuestGlobalVarValue(Integer variable, Integer inc) {
        Integer previousValue = getPlayer().getQuestGlobalVariables().getOrDefault(variable, 0);
        getPlayer().getQuestGlobalVariables().put(variable, Integer.valueOf(previousValue.intValue() + inc.intValue()));
        Grasscutter.getLogger().warn("Incremented questGlobalVar {} value from {} to {}", variable, previousValue, Integer.valueOf(previousValue.intValue() + inc.intValue()));
    }

    public void decQuestGlobalVarValue(Integer variable, Integer dec) {
        Integer previousValue = getPlayer().getQuestGlobalVariables().getOrDefault(variable, 0);
        getPlayer().getQuestGlobalVariables().put(variable, Integer.valueOf(previousValue.intValue() - dec.intValue()));
        Grasscutter.getLogger().warn("Decremented questGlobalVar {} value from {} to {}", variable, previousValue, Integer.valueOf(previousValue.intValue() - dec.intValue()));
    }

    public GameMainQuest getMainQuestById(int mainQuestId) {
        return getMainQuests().get(mainQuestId);
    }

    public GameQuest getQuestById(int questId) {
        GameMainQuest mainQuest;
        QuestData questConfig = GameData.getQuestDataMap().get(questId);
        if (questConfig == null || (mainQuest = getMainQuests().get(questConfig.getMainId())) == null) {
            return null;
        }
        return mainQuest.getChildQuests().get(Integer.valueOf(questId));
    }

    public void forEachQuest(Consumer<GameQuest> callback) {
        ObjectIterator<GameMainQuest> it = getMainQuests().values().iterator();
        while (it.hasNext()) {
            for (GameQuest quest : it.next().getChildQuests().values()) {
                callback.accept(quest);
            }
        }
    }

    public void forEachMainQuest(Consumer<GameMainQuest> callback) {
        ObjectIterator<GameMainQuest> it = getMainQuests().values().iterator();
        while (it.hasNext()) {
            callback.accept(it.next());
        }
    }

    public void forEachActiveQuest(Consumer<GameQuest> callback) {
        ObjectIterator<GameMainQuest> it = getMainQuests().values().iterator();
        while (it.hasNext()) {
            for (GameQuest quest : it.next().getChildQuests().values()) {
                if (quest.getState() != QuestState.QUEST_STATE_FINISHED) {
                    callback.accept(quest);
                }
            }
        }
    }

    public GameMainQuest addMainQuest(QuestData questConfig) {
        GameMainQuest mainQuest = new GameMainQuest(getPlayer(), questConfig.getMainId());
        getMainQuests().put(mainQuest.getParentQuestId(), (int) mainQuest);
        getPlayer().sendPacket(new PacketFinishedParentQuestUpdateNotify(mainQuest));
        return mainQuest;
    }

    public GameQuest addQuest(int questId) {
        QuestData questConfig = GameData.getQuestDataMap().get(questId);
        if (questConfig == null) {
            return null;
        }
        GameMainQuest mainQuest = getMainQuestById(questConfig.getMainId());
        if (mainQuest == null) {
            Grasscutter.getLogger().debug("start main {}", Integer.valueOf(questId));
            mainQuest = addMainQuest(questConfig);
        }
        GameQuest quest = mainQuest.getChildQuestById(questId);
        if (quest == null) {
            Grasscutter.getLogger().debug("No found sub quest {}", Integer.valueOf(questId));
            return quest;
        }
        quest.start();
        checkQuestAlreadyFullfilled(quest);
        return quest;
    }

    public void startMainQuest(int mainQuestId) {
        MainQuestData mainQuestData = GameData.getMainQuestDataMap().get(mainQuestId);
        if (mainQuestData != null) {
            Arrays.stream(mainQuestData.getSubQuests()).min(Comparator.comparingInt((v0) -> {
                return v0.getOrder();
            })).map((v0) -> {
                return v0.getSubId();
            }).ifPresent((v1) -> {
                addQuest(v1);
            });
            if (mainQuestId == 355) {
                startMainQuest(361);
                startMainQuest(HttpStatus.IM_A_TEAPOT_418);
                startMainQuest(423);
                startMainQuest(20509);
            }
        }
    }

    public void queueEvent(QuestTrigger condType, int... params) {
        queueEvent(condType, "", params);
    }

    public void queueEvent(QuestTrigger condType, String paramStr, int... params) {
        eventExecutor.submit(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: INVOKE  
              (wrap: java.util.concurrent.ExecutorService : 0x0000: SGET  (r0v0 java.util.concurrent.ExecutorService A[REMOVE]) =  emu.grasscutter.game.quest.QuestManager.eventExecutor java.util.concurrent.ExecutorService)
              (wrap: java.lang.Runnable : 0x0007: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' emu.grasscutter.game.quest.QuestManager A[D('this' emu.grasscutter.game.quest.QuestManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'condType' emu.grasscutter.game.quest.enums.QuestTrigger A[D('condType' emu.grasscutter.game.quest.enums.QuestTrigger), DONT_INLINE])
              (r8v0 'paramStr' java.lang.String A[D('paramStr' java.lang.String), DONT_INLINE])
              (r9v0 'params' int[] A[D('params' int[]), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r1 I:emu.grasscutter.game.quest.QuestManager)
              (r2 I:emu.grasscutter.game.quest.enums.QuestTrigger)
              (r3 I:java.lang.String)
              (r4 I:int[])
             type: VIRTUAL call: emu.grasscutter.game.quest.QuestManager.lambda$queueEvent$0(emu.grasscutter.game.quest.enums.QuestTrigger, java.lang.String, int[]):void)
             type: INTERFACE call: java.util.concurrent.ExecutorService.submit(java.lang.Runnable):java.util.concurrent.Future in method: emu.grasscutter.game.quest.QuestManager.queueEvent(emu.grasscutter.game.quest.enums.QuestTrigger, java.lang.String, int[]):void, file: grasscutter.jar:emu/grasscutter/game/quest/QuestManager.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
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
            java.util.concurrent.ExecutorService r0 = emu.grasscutter.game.quest.QuestManager.eventExecutor
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$queueEvent$0(r2, r3, r4);
            }
            java.util.concurrent.Future r0 = r0.submit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.QuestManager.queueEvent(emu.grasscutter.game.quest.enums.QuestTrigger, java.lang.String, int[]):void");
    }

    public void triggerEvent(QuestTrigger condType, String paramStr, int... params) {
        Grasscutter.getLogger().debug("Trigger Event {}, {}, {}", condType, paramStr, params);
        List<GameMainQuest> checkMainQuests = getMainQuests().values().stream().filter(i -> {
            return i.getState() != ParentQuestState.PARENT_QUEST_STATE_FINISHED;
        }).toList();
        switch (condType) {
            case QUEST_COND_STATE_EQUAL:
            case QUEST_COND_STATE_NOT_EQUAL:
            case QUEST_COND_COMPLETE_TALK:
            case QUEST_COND_LUA_NOTIFY:
            case QUEST_COND_QUEST_VAR_EQUAL:
            case QUEST_COND_QUEST_VAR_GREATER:
            case QUEST_COND_QUEST_VAR_LESS:
            case QUEST_COND_PLAYER_LEVEL_EQUAL_GREATER:
            case QUEST_COND_QUEST_GLOBAL_VAR_EQUAL:
            case QUEST_COND_QUEST_GLOBAL_VAR_GREATER:
            case QUEST_COND_QUEST_GLOBAL_VAR_LESS:
            case QUEST_COND_PACK_HAVE_ITEM:
            case QUEST_COND_ITEM_NUM_LESS_THAN:
            case QUEST_COND_ACTIVITY_OPEN:
            case QUEST_COND_ACTIVITY_END:
            case QUEST_COND_ACTIVITY_COND:
                for (GameMainQuest mainquest : checkMainQuests) {
                    mainquest.tryAcceptSubQuests(condType, paramStr, params);
                }
                return;
            case QUEST_CONTENT_NOT_FINISH_PLOT:
            case QUEST_CONTENT_ANY_MANUAL_TRANSPORT:
                for (GameMainQuest mainquest2 : checkMainQuests) {
                    mainquest2.tryFailSubQuests(condType, paramStr, params);
                }
                return;
            case QUEST_CONTENT_COMPLETE_TALK:
            case QUEST_CONTENT_SKILL:
            case QUEST_CONTENT_FINISH_PLOT:
            case QUEST_CONTENT_COMPLETE_ANY_TALK:
            case QUEST_CONTENT_QUEST_VAR_EQUAL:
            case QUEST_CONTENT_QUEST_VAR_GREATER:
            case QUEST_CONTENT_QUEST_VAR_LESS:
            case QUEST_CONTENT_ENTER_DUNGEON:
            case QUEST_CONTENT_ENTER_MY_WORLD_SCENE:
            case QUEST_CONTENT_INTERACT_GADGET:
            case QUEST_CONTENT_TRIGGER_FIRE:
            case QUEST_CONTENT_UNLOCK_TRANS_POINT:
            case QUEST_CONTENT_UNLOCK_AREA:
            case QUEST_CONTENT_MONSTER_DIE:
            case QUEST_CONTENT_DESTROY_GADGET:
            case QUEST_CONTENT_PLAYER_LEVEL_UP:
            case QUEST_CONTENT_USE_ITEM:
            case QUEST_CONTENT_ENTER_VEHICLE:
            case QUEST_CONTENT_FINISH_DUNGEON:
            case QUEST_CONTENT_OBTAIN_ITEM:
                for (GameMainQuest mainQuest : checkMainQuests) {
                    mainQuest.tryFinishSubQuests(condType, paramStr, params);
                }
                return;
            case QUEST_CONTENT_GAME_TIME_TICK:
            case QUEST_CONTENT_QUEST_STATE_EQUAL:
            case QUEST_CONTENT_ADD_QUEST_PROGRESS:
            case QUEST_CONTENT_LEAVE_SCENE:
            case QUEST_CONTENT_ITEM_LESS_THAN:
            case QUEST_CONTENT_KILL_MONSTER:
            case QUEST_CONTENT_LUA_NOTIFY:
            case QUEST_CONTENT_ENTER_MY_WORLD:
            case QUEST_CONTENT_ENTER_ROOM:
            case QUEST_CONTENT_FAIL_DUNGEON:
                for (GameMainQuest mainQuest2 : checkMainQuests) {
                    mainQuest2.tryFailSubQuests(condType, paramStr, params);
                    mainQuest2.tryFinishSubQuests(condType, paramStr, params);
                }
                return;
            case QUEST_CONTENT_QUEST_STATE_NOT_EQUAL:
            case QUEST_COND_PLAYER_CHOOSE_MALE:
            default:
                Grasscutter.getLogger().debug("Unhandled1 QuestTrigger {}", condType);
                return;
        }
    }

    public void checkQuestAlreadyFullfilled(GameQuest quest) {
        Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000e: INVOKE  
              (wrap: emu.grasscutter.server.scheduler.ServerTaskScheduler : 0x0003: INVOKE  (r0v1 emu.grasscutter.server.scheduler.ServerTaskScheduler A[REMOVE]) = 
              (wrap: emu.grasscutter.server.game.GameServer : 0x0000: INVOKE  (r0v0 emu.grasscutter.server.game.GameServer A[REMOVE]) =  type: STATIC call: emu.grasscutter.Grasscutter.getGameServer():emu.grasscutter.server.game.GameServer)
             type: VIRTUAL call: emu.grasscutter.server.game.GameServer.getScheduler():emu.grasscutter.server.scheduler.ServerTaskScheduler)
              (wrap: java.lang.Runnable : 0x0008: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r4v0 'this' emu.grasscutter.game.quest.QuestManager A[D('this' emu.grasscutter.game.quest.QuestManager), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r5v0 'quest' emu.grasscutter.game.quest.GameQuest A[D('quest' emu.grasscutter.game.quest.GameQuest), DONT_INLINE])
            
             handle type: INVOKE_INSTANCE
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r1 I:emu.grasscutter.game.quest.QuestManager), (r2 I:emu.grasscutter.game.quest.GameQuest) type: VIRTUAL call: emu.grasscutter.game.quest.QuestManager.lambda$checkQuestAlreadyFullfilled$2(emu.grasscutter.game.quest.GameQuest):void)
              (1 int)
             type: VIRTUAL call: emu.grasscutter.server.scheduler.ServerTaskScheduler.scheduleDelayedTask(java.lang.Runnable, int):int in method: emu.grasscutter.game.quest.QuestManager.checkQuestAlreadyFullfilled(emu.grasscutter.game.quest.GameQuest):void, file: grasscutter.jar:emu/grasscutter/game/quest/QuestManager.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
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
            emu.grasscutter.server.game.GameServer r0 = emu.grasscutter.Grasscutter.getGameServer()
            emu.grasscutter.server.scheduler.ServerTaskScheduler r0 = r0.getScheduler()
            r1 = r4
            r2 = r5
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$checkQuestAlreadyFullfilled$2(r2);
            }
            r2 = 1
            int r0 = r0.scheduleDelayedTask(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.QuestManager.checkQuestAlreadyFullfilled(emu.grasscutter.game.quest.GameQuest):void");
    }

    public void handleGiveAvatar(int finishId) {
        int avatarId;
        if (GameData.getQuestGiveAvatar().containsKey(Integer.valueOf(finishId)) && (avatarId = GameData.getQuestGiveAvatar().get(Integer.valueOf(finishId)).intValue()) > 0) {
            Grasscutter.getLogger().warn("handleGiveAvatar {} found... {}", Integer.valueOf(finishId), Integer.valueOf(avatarId));
            getPlayer().getInventory().addItem(avatarId, 1, ActionReason.QuestItem);
        }
    }

    public List<QuestGroupSuite> getSceneGroupSuite(int sceneId) {
        return getMainQuests().values().stream().filter(i -> {
            return i.getState() != ParentQuestState.PARENT_QUEST_STATE_FINISHED;
        }).map((v0) -> {
            return v0.getQuestGroupSuites();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).flatMap((v0) -> {
            return v0.stream();
        }).filter(i -> {
            return i.getScene() == sceneId;
        }).toList();
    }

    public void loadFromDatabase() {
        for (GameMainQuest mainQuest : DatabaseHelper.getAllQuests(getPlayer())) {
            boolean cancelAdd = false;
            mainQuest.setOwner(getPlayer());
            Iterator<GameQuest> it = mainQuest.getChildQuests().values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GameQuest quest = it.next();
                QuestData questConfig = GameData.getQuestDataMap().get(quest.getSubQuestId());
                if (questConfig == null) {
                    mainQuest.delete();
                    cancelAdd = true;
                    break;
                }
                quest.setMainQuest(mainQuest);
                quest.setConfig(questConfig);
            }
            if (!cancelAdd) {
                getMainQuests().put(mainQuest.getParentQuestId(), (int) mainQuest);
            }
        }
    }

    public List<GameMainQuest> getActiveMainQuests() {
        return getMainQuests().values().stream().filter(p -> {
            return !p.isFinished();
        }).toList();
    }
}
