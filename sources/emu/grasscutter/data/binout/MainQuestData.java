package emu.grasscutter.data.binout;

import dev.morphia.annotations.Entity;
import emu.grasscutter.game.quest.enums.QuestType;
import java.util.List;
import java.util.Objects;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/MainQuestData.class */
public class MainQuestData {

    /* renamed from: id */
    private int f501id;
    private int series;
    private QuestType type;
    private long titleTextMapHash;
    private int[] suggestTrackMainQuestList;
    private int[] rewardIdList;
    private SubQuestData[] subQuests;
    private List<TalkData> talks;

    public int getId() {
        return this.f501id;
    }

    public int getSeries() {
        return this.series;
    }

    public QuestType getType() {
        return this.type;
    }

    public long getTitleTextMapHash() {
        return this.titleTextMapHash;
    }

    public int[] getSuggestTrackMainQuestList() {
        return this.suggestTrackMainQuestList;
    }

    public int[] getRewardIdList() {
        return this.rewardIdList;
    }

    public SubQuestData[] getSubQuests() {
        return this.subQuests;
    }

    public List<TalkData> getTalks() {
        return this.talks;
    }

    public void onLoad() {
        this.talks = this.talks.stream().filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/MainQuestData$SubQuestData.class */
    public static class SubQuestData {
        private int subId;
        private int order;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.data.binout.MainQuestData.SubQuestData.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MainQuestData.SubQuestData(subId=, order=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MainQuestData.SubQuestData(subId=, order=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r3 = this;
                r0 = r3
                int r0 = r0.getSubId()
                r1 = r3
                int r1 = r1.getOrder()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MainQuestData.SubQuestData(subId=, order=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.MainQuestData.SubQuestData.toString():java.lang.String");
        }

        public void setSubId(int subId) {
            this.subId = subId;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SubQuestData)) {
                return false;
            }
            SubQuestData other = (SubQuestData) o;
            return other.canEqual(this) && getSubId() == other.getSubId() && getOrder() == other.getOrder();
        }

        protected boolean canEqual(Object other) {
            return other instanceof SubQuestData;
        }

        public int hashCode() {
            return (((1 * 59) + getSubId()) * 59) + getOrder();
        }

        public int getSubId() {
            return this.subId;
        }

        public int getOrder() {
            return this.order;
        }
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/MainQuestData$TalkData.class */
    public static class TalkData {

        /* renamed from: id */
        private int f502id;
        private String heroTalk;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.data.binout.MainQuestData.TalkData.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, MainQuestData.TalkData(id=, heroTalk=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, MainQuestData.TalkData(id=, heroTalk=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r3 = this;
                r0 = r3
                int r0 = r0.getId()
                r1 = r3
                java.lang.String r1 = r1.getHeroTalk()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, MainQuestData.TalkData(id=, heroTalk=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.MainQuestData.TalkData.toString():java.lang.String");
        }

        public void setId(int id) {
            this.f502id = id;
        }

        public void setHeroTalk(String heroTalk) {
            this.heroTalk = heroTalk;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TalkData)) {
                return false;
            }
            TalkData other = (TalkData) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            Object this$heroTalk = getHeroTalk();
            Object other$heroTalk = other.getHeroTalk();
            return this$heroTalk == null ? other$heroTalk == null : this$heroTalk.equals(other$heroTalk);
        }

        protected boolean canEqual(Object other) {
            return other instanceof TalkData;
        }

        public int hashCode() {
            int result = (1 * 59) + getId();
            Object $heroTalk = getHeroTalk();
            return (result * 59) + ($heroTalk == null ? 43 : $heroTalk.hashCode());
        }

        public int getId() {
            return this.f502id;
        }

        public String getHeroTalk() {
            return this.heroTalk;
        }

        public TalkData() {
        }

        public TalkData(int id, String heroTalk) {
            this.f502id = id;
            this.heroTalk = heroTalk;
        }
    }
}
