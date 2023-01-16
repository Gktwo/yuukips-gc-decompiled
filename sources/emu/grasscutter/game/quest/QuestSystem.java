package emu.grasscutter.game.quest;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.QuestData;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/QuestSystem.class */
public class QuestSystem extends BaseGameSystem {
    private final Int2ObjectMap<QuestBaseHandler> condHandlers = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<QuestBaseHandler> contHandlers = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<QuestExecHandler> execHandlers = new Int2ObjectOpenHashMap();

    public QuestSystem(GameServer server) {
        super(server);
        registerHandlers();
    }

    public void registerHandlers() {
        registerHandlers(this.condHandlers, "emu.grasscutter.game.quest.conditions", QuestBaseHandler.class);
        registerHandlers(this.contHandlers, "emu.grasscutter.game.quest.content", QuestBaseHandler.class);
        registerHandlers(this.execHandlers, "emu.grasscutter.game.quest.exec", QuestExecHandler.class);
    }

    public <T> void registerHandlers(Int2ObjectMap<T> map, String packageName, Class<T> clazz) {
        for (Class<? extends T> obj : new Reflections(packageName, new Scanner[0]).getSubTypesOf(clazz)) {
            registerPacketHandler(map, obj);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: it.unimi.dsi.fastutil.ints.Int2ObjectMap<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> void registerPacketHandler(Int2ObjectMap<T> map, Class<? extends T> handlerClass) {
        try {
            QuestValue opcode = (QuestValue) handlerClass.getAnnotation(QuestValue.class);
            if (opcode != null && opcode.value().getValue() > 0) {
                map.put(opcode.value().getValue(), (int) handlerClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error: registerPacketHandler", (Throwable) e);
        }
    }

    public boolean triggerCondition(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        QuestBaseHandler handler = this.condHandlers.get(condition.getType().getValue());
        if (handler == null || quest.getQuestData() == null) {
            return false;
        }
        return handler.execute(quest, condition, paramStr, params);
    }

    public boolean triggerContent(GameQuest quest, QuestData.QuestCondition condition, String paramStr, int... params) {
        QuestBaseHandler handler = this.contHandlers.get(condition.getType().getValue());
        if (handler == null || quest.getQuestData() == null) {
            return false;
        }
        return handler.execute(quest, condition, paramStr, params);
    }

    public void triggerExec(GameQuest quest, QuestData.QuestExecParam execParam, String... params) {
        QuestExecHandler handler = this.execHandlers.get(execParam.getType().getValue());
        if (handler != null && quest.getQuestData() != null) {
            QuestManager.eventExecutor.submit(() -> {
                if (!handler.execute(quest, execParam, params)) {
                }
            });
        }
    }
}
