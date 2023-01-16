package emu.grasscutter.game.quest.content;

import emu.grasscutter.game.quest.QuestValue;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.game.quest.handlers.QuestBaseHandler;

@QuestValue(QuestTrigger.QUEST_CONTENT_FINISH_PLOT)
/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/content/ContentFinishPlot.class */
public class ContentFinishPlot extends QuestBaseHandler {
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x007f, code lost:
        if (r10.getParam()[0] == r12[0]) goto L_0x0082;
     */
    @Override // emu.grasscutter.game.quest.handlers.QuestBaseHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean execute(emu.grasscutter.game.quest.GameQuest r9, emu.grasscutter.data.excels.QuestData.QuestCondition r10, java.lang.String r11, int... r12) {
        /*
            r8 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()     // Catch: Exception -> 0x002f
            java.lang.String r1 = "QUEST_CONTENT_FINISH_PLOT: quest {} trigger params0 {} = condition0 {}"
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Exception -> 0x002f
            r3 = r2
            r4 = 0
            r5 = r9
            int r5 = r5.getSubQuestId()     // Catch: Exception -> 0x002f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: Exception -> 0x002f
            r3[r4] = r5     // Catch: Exception -> 0x002f
            r3 = r2
            r4 = 1
            r5 = r12
            r6 = 0
            r5 = r5[r6]     // Catch: Exception -> 0x002f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: Exception -> 0x002f
            r3[r4] = r5     // Catch: Exception -> 0x002f
            r3 = r2
            r4 = 2
            r5 = r10
            int[] r5 = r5.getParam()     // Catch: Exception -> 0x002f
            r6 = 0
            r5 = r5[r6]     // Catch: Exception -> 0x002f
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch: Exception -> 0x002f
            r3[r4] = r5     // Catch: Exception -> 0x002f
            r0.warn(r1, r2)     // Catch: Exception -> 0x002f
            goto L_0x003b
        L_0x002f:
            r13 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "error"
            r2 = r13
            r0.warn(r1, r2)
        L_0x003b:
            r0 = r9
            emu.grasscutter.game.quest.GameMainQuest r0 = r0.getMainQuest()     // Catch: Exception -> 0x0088
            java.util.Map r0 = r0.getTalks()     // Catch: Exception -> 0x0088
            r1 = r12
            r2 = 0
            r1 = r1[r2]     // Catch: Exception -> 0x0088
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: Exception -> 0x0088
            java.lang.Object r0 = r0.get(r1)     // Catch: Exception -> 0x0088
            emu.grasscutter.data.binout.MainQuestData$TalkData r0 = (emu.grasscutter.data.binout.MainQuestData.TalkData) r0     // Catch: Exception -> 0x0088
            r13 = r0
            r0 = r9
            emu.grasscutter.game.quest.GameMainQuest r0 = r0.getMainQuest()     // Catch: Exception -> 0x0088
            r1 = r12
            r2 = 0
            r1 = r1[r2]     // Catch: Exception -> 0x0088
            emu.grasscutter.game.quest.GameQuest r0 = r0.getChildQuestById(r1)     // Catch: Exception -> 0x0088
            r14 = r0
            r0 = r13
            if (r0 == 0) goto L_0x006a
            r0 = r14
            if (r0 != 0) goto L_0x0082
        L_0x006a:
            r0 = r10
            java.lang.String r0 = r0.getParamStr()     // Catch: Exception -> 0x0088
            r1 = r11
            boolean r0 = r0.equals(r1)     // Catch: Exception -> 0x0088
            if (r0 == 0) goto L_0x0086
            r0 = r10
            int[] r0 = r0.getParam()     // Catch: Exception -> 0x0088
            r1 = 0
            r0 = r0[r1]     // Catch: Exception -> 0x0088
            r1 = r12
            r2 = 0
            r1 = r1[r2]     // Catch: Exception -> 0x0088
            if (r0 != r1) goto L_0x0086
        L_0x0082:
            r0 = 1
            goto L_0x0087
        L_0x0086:
            r0 = 0
        L_0x0087:
            return r0
        L_0x0088:
            r13 = move-exception
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.content.ContentFinishPlot.execute(emu.grasscutter.game.quest.GameQuest, emu.grasscutter.data.excels.QuestData$QuestCondition, java.lang.String, int[]):boolean");
    }
}
