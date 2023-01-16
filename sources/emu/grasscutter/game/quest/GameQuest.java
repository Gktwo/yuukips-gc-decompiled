package emu.grasscutter.game.quest;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ChapterData;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.data.excels.TriggerExcelConfigData;
import emu.grasscutter.game.dungeons.DungeonPassConditionType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.enums.QuestState;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.proto.ChapterStateOuterClass;
import emu.grasscutter.net.proto.QuestOuterClass;
import emu.grasscutter.scripts.data.SceneGroup;
import emu.grasscutter.server.packet.send.PacketChapterStateNotify;
import emu.grasscutter.server.packet.send.PacketDelQuestNotify;
import emu.grasscutter.server.packet.send.PacketQuestListUpdateNotify;
import emu.grasscutter.utils.Utils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.script.Bindings;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/GameQuest.class */
public class GameQuest {
    @Transient
    private GameMainQuest mainQuest;
    @Transient
    private QuestData questData;
    private int subQuestId;
    private int mainQuestId;
    public QuestState state;
    private int startTime;
    private int acceptTime;
    private int finishTime;
    private int[] finishProgressList;
    private int[] failProgressList;
    @Transient
    private Map<String, TriggerExcelConfigData> triggerData;
    private Map<String, Boolean> triggers;
    private transient Bindings bindings;

    public GameMainQuest getMainQuest() {
        return this.mainQuest;
    }

    public void setMainQuest(GameMainQuest mainQuest) {
        this.mainQuest = mainQuest;
    }

    public QuestData getQuestData() {
        return this.questData;
    }

    public int getSubQuestId() {
        return this.subQuestId;
    }

    public int getMainQuestId() {
        return this.mainQuestId;
    }

    public QuestState getState() {
        return this.state;
    }

    public void setState(QuestState state) {
        this.state = state;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getAcceptTime() {
        return this.acceptTime;
    }

    public void setAcceptTime(int acceptTime) {
        this.acceptTime = acceptTime;
    }

    public int getFinishTime() {
        return this.finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public int[] getFinishProgressList() {
        return this.finishProgressList;
    }

    public int[] getFailProgressList() {
        return this.failProgressList;
    }

    public Map<String, TriggerExcelConfigData> getTriggerData() {
        return this.triggerData;
    }

    public Map<String, Boolean> getTriggers() {
        return this.triggers;
    }

    @Deprecated(forRemoval = true)
    public GameQuest() {
    }

    public GameQuest(GameMainQuest mainQuest, QuestData questData) {
        this.mainQuest = mainQuest;
        this.subQuestId = questData.getId();
        this.mainQuestId = questData.getMainId();
        this.questData = questData;
        this.state = QuestState.QUEST_STATE_UNSTARTED;
        this.triggerData = new HashMap();
        this.triggers = new HashMap();
    }

    public void start() {
        clearProgress(false);
        this.acceptTime = Utils.getCurrentSeconds();
        this.startTime = this.acceptTime;
        this.state = QuestState.QUEST_STATE_UNFINISHED;
        List<QuestData.QuestCondition> triggerCond = this.questData.getFinishCond().stream().filter(p -> {
            return p.getType() == QuestTrigger.QUEST_CONTENT_TRIGGER_FIRE;
        }).toList();
        if (triggerCond.size() > 0) {
            for (QuestData.QuestCondition cond : triggerCond) {
                TriggerExcelConfigData newTrigger = GameData.getTriggerExcelConfigDataMap().get(cond.getParam()[0]);
                if (newTrigger != null) {
                    if (this.triggerData == null) {
                        this.triggerData = new HashMap();
                    }
                    this.triggerData.put(newTrigger.getTriggerName(), newTrigger);
                    this.triggers.put(newTrigger.getTriggerName(), false);
                    getOwner().getWorld().getSceneById(newTrigger.getSceneId()).loadTriggerFromGroup(SceneGroup.m1194of(newTrigger.getGroupId()).load(newTrigger.getSceneId()), newTrigger.getTriggerName());
                }
            }
        }
        if (ChapterData.beginQuestChapterMap.containsKey(Integer.valueOf(this.subQuestId))) {
            this.mainQuest.getOwner().sendPacket(new PacketChapterStateNotify(ChapterData.beginQuestChapterMap.get(Integer.valueOf(this.subQuestId)).getId(), ChapterStateOuterClass.ChapterState.CHAPTER_STATE_BEGIN));
        }
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_QUEST_STATE_EQUAL, getSubQuestId(), getState().getValue(), 0, 0, 0);
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_COND_STATE_EQUAL, getSubQuestId(), getState().getValue(), 0, 0, 0);
        getQuestData().getBeginExec().forEach(e -> {
            getOwner().getServer().getQuestSystem().triggerExec(this, e, e.getParam());
        });
        if (!(this.mainQuest == null || this.mainQuest.getQuestManager() == null)) {
            this.mainQuest.getQuestManager().checkQuestAlreadyFullfilled(this);
        }
        getOwner().getSession().send(new PacketQuestListUpdateNotify(this));
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_UNLOCK_TRANS_POINT, -1);
        Grasscutter.getLogger().info("Quest {} is started", Integer.valueOf(this.subQuestId));
    }

    public String getTriggerNameById(int id) {
        TriggerExcelConfigData trigger = GameData.getTriggerExcelConfigDataMap().get(id);
        if (trigger != null) {
            return trigger.getTriggerName();
        }
        return "";
    }

    public Player getOwner() {
        return getMainQuest().getOwner();
    }

    public void setConfig(QuestData config) {
        if (config != null && getSubQuestId() == config.getId()) {
            this.questData = config;
        }
    }

    public void setFinishProgress(int index, int value) {
        this.finishProgressList[index] = value;
    }

    public void setFailProgress(int index, int value) {
        this.failProgressList[index] = value;
    }

    public boolean clearProgress(boolean notifyDelete) {
        QuestState oldState = this.state;
        if (!(this.questData.getFinishCond() == null || this.questData.getFinishCond().size() == 0)) {
            this.finishProgressList = new int[this.questData.getFinishCond().size()];
        }
        if (!(this.questData.getFailCond() == null || this.questData.getFailCond().size() == 0)) {
            this.failProgressList = new int[this.questData.getFailCond().size()];
        }
        setState(QuestState.QUEST_STATE_UNSTARTED);
        this.finishTime = 0;
        this.acceptTime = 0;
        this.startTime = 0;
        if (oldState == QuestState.QUEST_STATE_UNSTARTED) {
            return false;
        }
        if (notifyDelete) {
            getOwner().sendPacket(new PacketDelQuestNotify(getSubQuestId()));
        }
        save();
        return true;
    }

    public void finish() {
        this.state = QuestState.QUEST_STATE_FINISHED;
        this.finishTime = Utils.getCurrentSeconds();
        getOwner().sendPacket(new PacketQuestListUpdateNotify(this));
        getOwner().getQuestManager().handleGiveAvatar(this.subQuestId);
        if (getQuestData().finishParent()) {
            getMainQuest().finish();
        }
        try {
            getQuestData().getFinishExec().forEach(e -> {
                getOwner().getServer().getQuestSystem().triggerExec(this, e, e.getParam());
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error: getFinishExec", (Throwable) e);
        }
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_QUEST_STATE_EQUAL, this.subQuestId, this.state.getValue(), 0, 0, 0);
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_COND_STATE_EQUAL, this.subQuestId, this.state.getValue(), 0, 0, 0);
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_FINISH_PLOT, this.subQuestId, 0);
        getOwner().getScene().triggerDungeonEvent(DungeonPassConditionType.DUNGEON_COND_FINISH_QUEST, getSubQuestId());
        if (ChapterData.endQuestChapterMap.containsKey(Integer.valueOf(this.subQuestId))) {
            this.mainQuest.getOwner().sendPacket(new PacketChapterStateNotify(ChapterData.endQuestChapterMap.get(Integer.valueOf(this.subQuestId)).getId(), ChapterStateOuterClass.ChapterState.CHAPTER_STATE_END));
        }
        getOwner().getQuestManager().trySpecialQuest();
        Grasscutter.getLogger().info("Quest {} is finished", Integer.valueOf(this.subQuestId));
    }

    public void fail() {
        this.state = QuestState.QUEST_STATE_FAILED;
        this.finishTime = Utils.getCurrentSeconds();
        getOwner().sendPacket(new PacketQuestListUpdateNotify(this));
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_QUEST_STATE_EQUAL, this.subQuestId, this.state.getValue(), 0, 0, 0);
        getOwner().getQuestManager().queueEvent(QuestTrigger.QUEST_COND_STATE_EQUAL, this.subQuestId, this.state.getValue(), 0, 0, 0);
        getQuestData().getFailExec().forEach(e -> {
            getOwner().getServer().getQuestSystem().triggerExec(this, e, e.getParam());
        });
        Grasscutter.getLogger().warn("Quest {} is failed", Integer.valueOf(this.subQuestId));
    }

    public boolean rewind(boolean notifyDelete) {
        getMainQuest().getChildQuests().values().stream().filter(p -> {
            return p.getQuestData().getOrder() > getQuestData().getOrder();
        }).forEach(q -> {
            q.clearProgress(notifyDelete);
        });
        clearProgress(notifyDelete);
        Grasscutter.getLogger().warn("Quest {} is rewind", Integer.valueOf(this.subQuestId));
        start();
        return true;
    }

    public void save() {
        getMainQuest().save();
    }

    public void remove() {
        getMainQuest().delete();
    }

    public QuestOuterClass.Quest toProto() {
        QuestOuterClass.Quest.Builder proto = QuestOuterClass.Quest.newBuilder().setQuestId(getSubQuestId()).setState(getState().getValue()).setParentQuestId(getMainQuestId()).setStartTime(getStartTime()).setStartGameTime(438).setAcceptTime(getAcceptTime());
        if (getFinishProgressList() != null) {
            for (int i : getFinishProgressList()) {
                proto.addFinishProgressList(i);
            }
        }
        if (getFailProgressList() != null) {
            for (int i2 : getFailProgressList()) {
                proto.addFailProgressList(i2);
            }
        }
        return proto.build();
    }
}
