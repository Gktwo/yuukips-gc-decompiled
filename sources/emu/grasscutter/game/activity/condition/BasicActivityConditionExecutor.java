package emu.grasscutter.game.activity.condition;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.ActivityCondExcelConfigData;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.condition.all.UnknownActivityConditionHandler;
import emu.grasscutter.game.quest.enums.LogicType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/BasicActivityConditionExecutor.class */
public class BasicActivityConditionExecutor implements ActivityConditionExecutor {
    private final Map<Integer, ActivityConfigItem> activityConfigItemMap;
    private final Int2ObjectMap<ActivityCondExcelConfigData> activityConditions;
    private final Int2ObjectMap<PlayerActivityData> playerActivityDataByActivityCondId;
    private final Map<ActivityConditions, ActivityConditionBaseHandler> activityConditionsHandlers;
    private static final UnknownActivityConditionHandler UNKNOWN_CONDITION_HANDLER = new UnknownActivityConditionHandler();

    public BasicActivityConditionExecutor(Map<Integer, ActivityConfigItem> activityConfigItemMap, Int2ObjectMap<ActivityCondExcelConfigData> activityConditions, Int2ObjectMap<PlayerActivityData> playerActivityDataByActivityCondId, Map<ActivityConditions, ActivityConditionBaseHandler> activityConditionsHandlers) {
        this.activityConfigItemMap = activityConfigItemMap;
        this.activityConditions = activityConditions;
        this.playerActivityDataByActivityCondId = playerActivityDataByActivityCondId;
        this.activityConditionsHandlers = activityConditionsHandlers;
    }

    @Override // emu.grasscutter.game.activity.condition.ActivityConditionExecutor
    public List<Integer> getMeetActivitiesConditions(List<Integer> condIds) {
        return (List) condIds.stream().filter(arg0 -> {
            return meetsCondition(arg0.intValue());
        }).collect(Collectors.toList());
    }

    @Override // emu.grasscutter.game.activity.condition.ActivityConditionExecutor
    public boolean meetsCondition(int activityCondId) {
        ActivityCondExcelConfigData condData = this.activityConditions.get(activityCondId);
        if (condData == null) {
            Grasscutter.getLogger().debug("Could not find condition for activity with id = {}", Integer.valueOf(activityCondId));
            return false;
        }
        LogicType condComb = condData.getCondComb();
        if (condComb == null) {
            condComb = LogicType.LOGIC_AND;
        }
        PlayerActivityData activity = this.playerActivityDataByActivityCondId.get(activityCondId);
        if (activity == null) {
            return false;
        }
        ActivityConfigItem activityConfig = this.activityConfigItemMap.get(Integer.valueOf(activity.getActivityId()));
        return LogicType.calculate(condComb, (List) condData.getCond().stream().map(c -> {
            return ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: RETURN  
                  (wrap: java.util.function.BooleanSupplier : 0x0004: INVOKE_CUSTOM (r0v1 java.util.function.BooleanSupplier A[REMOVE]) = 
                  (r5v0 'this' emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor A[D('this' emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r8v0 'activityConfig' emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition A[D('c' emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition), DONT_INLINE])
                  (r6v0 'activity' emu.grasscutter.game.activity.PlayerActivityData A[D('activity' emu.grasscutter.game.activity.PlayerActivityData), DONT_INLINE])
                  (r7v0 'activity' emu.grasscutter.game.activity.ActivityConfigItem A[D('activityConfig' emu.grasscutter.game.activity.ActivityConfigItem), DONT_INLINE])
                
                 handle type: INVOKE_INSTANCE
                 lambda: java.util.function.BooleanSupplier.getAsBoolean():boolean
                 call insn: ?: INVOKE  
                  (r0 I:emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor)
                  (r1 I:emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition)
                  (r2 I:emu.grasscutter.game.activity.PlayerActivityData)
                  (r3 I:emu.grasscutter.game.activity.ActivityConfigItem)
                 type: VIRTUAL call: emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor.lambda$meetsCondition$1(emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition, emu.grasscutter.game.activity.PlayerActivityData, emu.grasscutter.game.activity.ActivityConfigItem):boolean)
                 in method: emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor.lambda$meetsCondition$2(emu.grasscutter.game.activity.PlayerActivityData, emu.grasscutter.game.activity.ActivityConfigItem, emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition):java.util.function.BooleanSupplier, file: grasscutter.jar:emu/grasscutter/game/activity/condition/BasicActivityConditionExecutor.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:913)
                	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:320)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                	... 62 more
                */
            /*
                this = this;
                r0 = r5
                r1 = r8
                r2 = r6
                r3 = r7
                java.util.function.BooleanSupplier r0 = () -> { // java.util.function.BooleanSupplier.getAsBoolean():boolean
                    return r0.lambda$meetsCondition$1(r1, r2, r3);
                }
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.condition.BasicActivityConditionExecutor.lambda$meetsCondition$2(emu.grasscutter.game.activity.PlayerActivityData, emu.grasscutter.game.activity.ActivityConfigItem, emu.grasscutter.data.excels.ActivityCondExcelConfigData$ActivityConfigCondition):java.util.function.BooleanSupplier");
        }).collect(Collectors.toList()));
    }
}
