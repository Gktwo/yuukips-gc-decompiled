package emu.grasscutter.game.activity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/ActivityConfigItem.class */
public class ActivityConfigItem {
    @SerializedName(value = "activityId", alternate = {"activity_id"})
    private int activityId;
    @SerializedName(value = "activityType", alternate = {"activity_type"})
    private int activityType;
    @SerializedName(value = "scheduleId", alternate = {"schedule_id"})
    private int scheduleId;
    @SerializedName(value = "meetCondList", alternate = {"meet_cond_list"})
    private List<Integer> meetCondList;
    @SerializedName(value = "beginTime", alternate = {"begin_time"})
    private int beginTime;
    @SerializedName(value = "endTime", alternate = {"end_time"})
    private int endTime;
    private transient ActivityHandler activityHandler;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.activity.ActivityConfigItem.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Ljava/util/List;, I, I, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, ActivityConfigItem(activityId=, activityType=, scheduleId=, meetCondList=, beginTime=, endTime=, activityHandler=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Ljava/util/List;, I, I, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, ActivityConfigItem(activityId=, activityType=, scheduleId=, meetCondList=, beginTime=, endTime=, activityHandler=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r8 = this;
            r0 = r8
            int r0 = r0.getActivityId()
            r1 = r8
            int r1 = r1.getActivityType()
            r2 = r8
            int r2 = r2.getScheduleId()
            r3 = r8
            java.util.List r3 = r3.getMeetCondList()
            r4 = r8
            int r4 = r4.getBeginTime()
            r5 = r8
            int r5 = r5.getEndTime()
            r6 = r8
            emu.grasscutter.game.activity.ActivityHandler r6 = r6.getActivityHandler()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, Ljava/util/List;, I, I, Lemu/grasscutter/game/activity/ActivityHandler;)Ljava/lang/String;}, ActivityConfigItem(activityId=, activityType=, scheduleId=, meetCondList=, beginTime=, endTime=, activityHandler=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.ActivityConfigItem.toString():java.lang.String");
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setMeetCondList(List<Integer> meetCondList) {
        this.meetCondList = meetCondList;
    }

    public void setBeginTime(int beginTime) {
        this.beginTime = beginTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setActivityHandler(ActivityHandler activityHandler) {
        this.activityHandler = activityHandler;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ActivityConfigItem)) {
            return false;
        }
        ActivityConfigItem other = (ActivityConfigItem) o;
        if (!other.canEqual(this) || getActivityId() != other.getActivityId() || getActivityType() != other.getActivityType() || getScheduleId() != other.getScheduleId() || getBeginTime() != other.getBeginTime() || getEndTime() != other.getEndTime()) {
            return false;
        }
        Object this$meetCondList = getMeetCondList();
        Object other$meetCondList = other.getMeetCondList();
        return this$meetCondList == null ? other$meetCondList == null : this$meetCondList.equals(other$meetCondList);
    }

    protected boolean canEqual(Object other) {
        return other instanceof ActivityConfigItem;
    }

    public int hashCode() {
        int result = (((((((((1 * 59) + getActivityId()) * 59) + getActivityType()) * 59) + getScheduleId()) * 59) + getBeginTime()) * 59) + getEndTime();
        Object $meetCondList = getMeetCondList();
        return (result * 59) + ($meetCondList == null ? 43 : $meetCondList.hashCode());
    }

    public int getActivityId() {
        return this.activityId;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public List<Integer> getMeetCondList() {
        return this.meetCondList;
    }

    public int getBeginTime() {
        return this.beginTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public ActivityHandler getActivityHandler() {
        return this.activityHandler;
    }
}
