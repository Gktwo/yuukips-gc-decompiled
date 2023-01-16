package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.quest.enums.LogicType;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import java.util.Arrays;
import java.util.List;

@ResourceType(name = {"QuestExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/QuestData.class */
public class QuestData extends GameResource {
    private int subId;
    private int mainId;
    private int order;
    private long descTextMapHash;
    private boolean finishParent;
    private boolean isRewind;
    private LogicType acceptCondComb;
    private LogicType finishCondComb;
    private LogicType failCondComb;
    private List<QuestCondition> acceptCond;
    private List<QuestCondition> finishCond;
    private List<QuestCondition> failCond;
    private List<QuestExecParam> beginExec;
    private List<QuestExecParam> finishExec;
    private List<QuestExecParam> failExec;
    private Guide guide;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0040: INVOKE_CUSTOM r-16, r-15, r-14, r-13, r0, r-12, r-11, r-10, r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0040: INVOKE_CUSTOM r0, r1, r2, r3, r0, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, method: emu.grasscutter.data.excels.QuestData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, J, Z, Z, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/data/excels/QuestData$Guide;)Ljava/lang/String;}, QuestData(subId=, mainId=, order=, descTextMapHash=, finishParent=, isRewind=, acceptCondComb=, finishCondComb=, failCondComb=, acceptCond=, finishCond=, failCond=, beginExec=, finishExec=, failExec=, guide=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, J, Z, Z, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/data/excels/QuestData$Guide;)Ljava/lang/String;}, QuestData(subId=, mainId=, order=, descTextMapHash=, finishParent=, isRewind=, acceptCondComb=, finishCondComb=, failCondComb=, acceptCond=, finishCond=, failCond=, beginExec=, finishExec=, failExec=, guide=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r18 = this;
            r0 = r18
            int r0 = r0.getSubId()
            r1 = r18
            int r1 = r1.getMainId()
            r2 = r18
            int r2 = r2.getOrder()
            r3 = r18
            long r3 = r3.getDescTextMapHash()
            r4 = r18
            boolean r4 = r4.isFinishParent()
            r5 = r18
            boolean r5 = r5.isRewind()
            r6 = r18
            emu.grasscutter.game.quest.enums.LogicType r6 = r6.getAcceptCondComb()
            r7 = r18
            emu.grasscutter.game.quest.enums.LogicType r7 = r7.getFinishCondComb()
            r8 = r18
            emu.grasscutter.game.quest.enums.LogicType r8 = r8.getFailCondComb()
            r9 = r18
            java.util.List r9 = r9.getAcceptCond()
            r10 = r18
            java.util.List r10 = r10.getFinishCond()
            r11 = r18
            java.util.List r11 = r11.getFailCond()
            r12 = r18
            java.util.List r12 = r12.getBeginExec()
            r13 = r18
            java.util.List r13 = r13.getFinishExec()
            r14 = r18
            java.util.List r14 = r14.getFailExec()
            r15 = r18
            emu.grasscutter.data.excels.QuestData$Guide r15 = r15.getGuide()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, J, Z, Z, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Lemu/grasscutter/game/quest/enums/LogicType;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Ljava/util/List;, Lemu/grasscutter/data/excels/QuestData$Guide;)Ljava/lang/String;}, QuestData(subId=, mainId=, order=, descTextMapHash=, finishParent=, isRewind=, acceptCondComb=, finishCondComb=, failCondComb=, acceptCond=, finishCond=, failCond=, beginExec=, finishExec=, failExec=, guide=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.excels.QuestData.toString():java.lang.String");
    }

    public boolean isFinishParent() {
        return this.finishParent;
    }

    public List<QuestExecParam> getBeginExec() {
        return this.beginExec;
    }

    public List<QuestExecParam> getFinishExec() {
        return this.finishExec;
    }

    public List<QuestExecParam> getFailExec() {
        return this.failExec;
    }

    public Guide getGuide() {
        return this.guide;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.subId;
    }

    public int getSubId() {
        return this.subId;
    }

    public int getMainId() {
        return this.mainId;
    }

    public int getOrder() {
        return this.order;
    }

    public long getDescTextMapHash() {
        return this.descTextMapHash;
    }

    public boolean finishParent() {
        return this.finishParent;
    }

    public boolean isRewind() {
        return this.isRewind;
    }

    public LogicType getAcceptCondComb() {
        return this.acceptCondComb == null ? LogicType.LOGIC_NONE : this.acceptCondComb;
    }

    public List<QuestCondition> getAcceptCond() {
        return this.acceptCond;
    }

    public LogicType getFinishCondComb() {
        return this.finishCondComb == null ? LogicType.LOGIC_NONE : this.finishCondComb;
    }

    public List<QuestCondition> getFinishCond() {
        return this.finishCond;
    }

    public LogicType getFailCondComb() {
        return this.failCondComb == null ? LogicType.LOGIC_NONE : this.failCondComb;
    }

    public List<QuestCondition> getFailCond() {
        return this.failCond;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.acceptCond = this.acceptCond.stream().filter(p -> {
            return p.type != null;
        }).toList();
        this.finishCond = this.finishCond.stream().filter(p -> {
            return p.type != null;
        }).toList();
        this.failCond = this.failCond.stream().filter(p -> {
            return p.type != null;
        }).toList();
        this.beginExec = this.beginExec.stream().filter(p -> {
            return p.type != null;
        }).toList();
        this.finishExec = this.finishExec.stream().filter(p -> {
            return p.type != null;
        }).toList();
        this.failExec = this.failExec.stream().filter(p -> {
            return p.type != null;
        }).toList();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/QuestData$QuestExecParam.class */
    public class QuestExecParam {
        @SerializedName("_type")
        private QuestTrigger type;
        @SerializedName("_param")
        private String[] param;
        @SerializedName("_count")
        private String count;

        /*  JADX ERROR: Dependency scan failed at insn: 0x000F: INVOKE_CUSTOM r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x000F: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.data.excels.QuestData.QuestExecParam.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, QuestData.QuestExecParam(type=, param=, count=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, QuestData.QuestExecParam(type=, param=, count=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                emu.grasscutter.game.quest.enums.QuestTrigger r0 = r0.getType()
                r1 = r4
                java.lang.String[] r1 = r1.getParam()
                java.lang.String r1 = java.util.Arrays.deepToString(r1)
                r2 = r4
                java.lang.String r2 = r2.getCount()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, QuestData.QuestExecParam(type=, param=, count=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.excels.QuestData.QuestExecParam.toString():java.lang.String");
        }

        public QuestExecParam() {
        }

        public void setType(QuestTrigger type) {
            this.type = type;
        }

        public void setParam(String[] param) {
            this.param = param;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof QuestExecParam)) {
                return false;
            }
            QuestExecParam other = (QuestExecParam) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Object this$type = getType();
            Object other$type = other.getType();
            if (this$type == null) {
                if (other$type != null) {
                    return false;
                }
            } else if (!this$type.equals(other$type)) {
                return false;
            }
            if (!Arrays.deepEquals(getParam(), other.getParam())) {
                return false;
            }
            Object this$count = getCount();
            Object other$count = other.getCount();
            return this$count == null ? other$count == null : this$count.equals(other$count);
        }

        protected boolean canEqual(Object other) {
            return other instanceof QuestExecParam;
        }

        public int hashCode() {
            Object $type = getType();
            int result = (((1 * 59) + ($type == null ? 43 : $type.hashCode())) * 59) + Arrays.deepHashCode(getParam());
            Object $count = getCount();
            return (result * 59) + ($count == null ? 43 : $count.hashCode());
        }

        public QuestTrigger getType() {
            return this.type;
        }

        public String[] getParam() {
            return this.param;
        }

        public String getCount() {
            return this.count;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/QuestData$QuestCondition.class */
    public static class QuestCondition {
        @SerializedName("_type")
        private QuestTrigger type;
        @SerializedName("_param")
        private int[] param;
        @SerializedName("_param_str")
        private String paramStr;
        @SerializedName("_count")
        private int count;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0013: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0013: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.data.excels.QuestData.QuestCondition.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, QuestData.QuestCondition(type=, param=, paramStr=, count=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, QuestData.QuestCondition(type=, param=, paramStr=, count=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r5 = this;
                r0 = r5
                emu.grasscutter.game.quest.enums.QuestTrigger r0 = r0.getType()
                r1 = r5
                int[] r1 = r1.getParam()
                java.lang.String r1 = java.util.Arrays.toString(r1)
                r2 = r5
                java.lang.String r2 = r2.getParamStr()
                r3 = r5
                int r3 = r3.getCount()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/enums/QuestTrigger;, Ljava/lang/String;, Ljava/lang/String;, I)Ljava/lang/String;}, QuestData.QuestCondition(type=, param=, paramStr=, count=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.excels.QuestData.QuestCondition.toString():java.lang.String");
        }

        public void setType(QuestTrigger type) {
            this.type = type;
        }

        public void setParam(int[] param) {
            this.param = param;
        }

        public void setParamStr(String paramStr) {
            this.paramStr = paramStr;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof QuestCondition)) {
                return false;
            }
            QuestCondition other = (QuestCondition) o;
            if (!other.canEqual(this) || getCount() != other.getCount()) {
                return false;
            }
            Object this$type = getType();
            Object other$type = other.getType();
            if (this$type == null) {
                if (other$type != null) {
                    return false;
                }
            } else if (!this$type.equals(other$type)) {
                return false;
            }
            if (!Arrays.equals(getParam(), other.getParam())) {
                return false;
            }
            Object this$paramStr = getParamStr();
            Object other$paramStr = other.getParamStr();
            return this$paramStr == null ? other$paramStr == null : this$paramStr.equals(other$paramStr);
        }

        protected boolean canEqual(Object other) {
            return other instanceof QuestCondition;
        }

        public int hashCode() {
            int result = (1 * 59) + getCount();
            Object $type = getType();
            int result2 = (((result * 59) + ($type == null ? 43 : $type.hashCode())) * 59) + Arrays.hashCode(getParam());
            Object $paramStr = getParamStr();
            return (result2 * 59) + ($paramStr == null ? 43 : $paramStr.hashCode());
        }

        public QuestTrigger getType() {
            return this.type;
        }

        public int[] getParam() {
            return this.param;
        }

        public String getParamStr() {
            return this.paramStr;
        }

        public int getCount() {
            return this.count;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/excels/QuestData$Guide.class */
    public static class Guide {
        private String type;
        private List<String> param;
        private int guideScene;

        /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.data.excels.QuestData.Guide.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/util/List;, I)Ljava/lang/String;}, QuestData.Guide(type=, param=, guideScene=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/util/List;, I)Ljava/lang/String;}, QuestData.Guide(type=, param=, guideScene=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                java.lang.String r0 = r0.getType()
                r1 = r4
                java.util.List r1 = r1.getParam()
                r2 = r4
                int r2 = r2.getGuideScene()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/util/List;, I)Ljava/lang/String;}, QuestData.Guide(type=, param=, guideScene=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.excels.QuestData.Guide.toString():java.lang.String");
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setParam(List<String> param) {
            this.param = param;
        }

        public void setGuideScene(int guideScene) {
            this.guideScene = guideScene;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Guide)) {
                return false;
            }
            Guide other = (Guide) o;
            if (!other.canEqual(this) || getGuideScene() != other.getGuideScene()) {
                return false;
            }
            Object this$type = getType();
            Object other$type = other.getType();
            if (this$type == null) {
                if (other$type != null) {
                    return false;
                }
            } else if (!this$type.equals(other$type)) {
                return false;
            }
            Object this$param = getParam();
            Object other$param = other.getParam();
            return this$param == null ? other$param == null : this$param.equals(other$param);
        }

        protected boolean canEqual(Object other) {
            return other instanceof Guide;
        }

        public int hashCode() {
            int result = (1 * 59) + getGuideScene();
            Object $type = getType();
            int result2 = (result * 59) + ($type == null ? 43 : $type.hashCode());
            Object $param = getParam();
            return (result2 * 59) + ($param == null ? 43 : $param.hashCode());
        }

        public String getType() {
            return this.type;
        }

        public List<String> getParam() {
            return this.param;
        }

        public int getGuideScene() {
            return this.guideScene;
        }
    }
}
