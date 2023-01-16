package emu.grasscutter.game.activity.musicgame;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.MusicGameBasicData;
import emu.grasscutter.net.proto.MusicGameRecordOuterClass;
import emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData.class */
public class MusicGamePlayerData {
    private Map<Integer, MusicGameRecord> musicGameRecord;
    private Map<Long, CustomBeatmapRecord> personalCustomBeatmapRecord;
    private Map<Long, CustomBeatmapRecord> othersCustomBeatmapRecord;

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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            java.util.Map r0 = r0.getMusicGameRecord()
            r1 = r4
            java.util.Map r1 = r1.getPersonalCustomBeatmapRecord()
            r2 = r4
            java.util.Map r2 = r2.getOthersCustomBeatmapRecord()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.toString():java.lang.String");
    }

    public void setMusicGameRecord(Map<Integer, MusicGameRecord> musicGameRecord) {
        this.musicGameRecord = musicGameRecord;
    }

    public void setPersonalCustomBeatmapRecord(Map<Long, CustomBeatmapRecord> personalCustomBeatmapRecord) {
        this.personalCustomBeatmapRecord = personalCustomBeatmapRecord;
    }

    public void setOthersCustomBeatmapRecord(Map<Long, CustomBeatmapRecord> othersCustomBeatmapRecord) {
        this.othersCustomBeatmapRecord = othersCustomBeatmapRecord;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MusicGamePlayerData)) {
            return false;
        }
        MusicGamePlayerData other = (MusicGamePlayerData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$musicGameRecord = getMusicGameRecord();
        Object other$musicGameRecord = other.getMusicGameRecord();
        if (this$musicGameRecord == null) {
            if (other$musicGameRecord != null) {
                return false;
            }
        } else if (!this$musicGameRecord.equals(other$musicGameRecord)) {
            return false;
        }
        Object this$personalCustomBeatmapRecord = getPersonalCustomBeatmapRecord();
        Object other$personalCustomBeatmapRecord = other.getPersonalCustomBeatmapRecord();
        if (this$personalCustomBeatmapRecord == null) {
            if (other$personalCustomBeatmapRecord != null) {
                return false;
            }
        } else if (!this$personalCustomBeatmapRecord.equals(other$personalCustomBeatmapRecord)) {
            return false;
        }
        Object this$othersCustomBeatmapRecord = getOthersCustomBeatmapRecord();
        Object other$othersCustomBeatmapRecord = other.getOthersCustomBeatmapRecord();
        return this$othersCustomBeatmapRecord == null ? other$othersCustomBeatmapRecord == null : this$othersCustomBeatmapRecord.equals(other$othersCustomBeatmapRecord);
    }

    protected boolean canEqual(Object other) {
        return other instanceof MusicGamePlayerData;
    }

    public int hashCode() {
        Object $musicGameRecord = getMusicGameRecord();
        int result = (1 * 59) + ($musicGameRecord == null ? 43 : $musicGameRecord.hashCode());
        Object $personalCustomBeatmapRecord = getPersonalCustomBeatmapRecord();
        int result2 = (result * 59) + ($personalCustomBeatmapRecord == null ? 43 : $personalCustomBeatmapRecord.hashCode());
        Object $othersCustomBeatmapRecord = getOthersCustomBeatmapRecord();
        return (result2 * 59) + ($othersCustomBeatmapRecord == null ? 43 : $othersCustomBeatmapRecord.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData$MusicGamePlayerDataBuilder.class */
    public static class MusicGamePlayerDataBuilder {
        private Map<Integer, MusicGameRecord> musicGameRecord;
        private Map<Long, CustomBeatmapRecord> personalCustomBeatmapRecord;
        private Map<Long, CustomBeatmapRecord> othersCustomBeatmapRecord;

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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGamePlayerDataBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData.MusicGamePlayerDataBuilder(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData.MusicGamePlayerDataBuilder(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                java.util.Map<java.lang.Integer, emu.grasscutter.game.activity.musicgame.MusicGamePlayerData$MusicGameRecord> r0 = r0.musicGameRecord
                r1 = r4
                java.util.Map<java.lang.Long, emu.grasscutter.game.activity.musicgame.MusicGamePlayerData$CustomBeatmapRecord> r1 = r1.personalCustomBeatmapRecord
                r2 = r4
                java.util.Map<java.lang.Long, emu.grasscutter.game.activity.musicgame.MusicGamePlayerData$CustomBeatmapRecord> r2 = r2.othersCustomBeatmapRecord
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/Map;, Ljava/util/Map;, Ljava/util/Map;)Ljava/lang/String;}, MusicGamePlayerData.MusicGamePlayerDataBuilder(musicGameRecord=, personalCustomBeatmapRecord=, othersCustomBeatmapRecord=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGamePlayerDataBuilder.toString():java.lang.String");
        }

        MusicGamePlayerDataBuilder() {
        }

        public MusicGamePlayerDataBuilder musicGameRecord(Map<Integer, MusicGameRecord> musicGameRecord) {
            this.musicGameRecord = musicGameRecord;
            return this;
        }

        public MusicGamePlayerDataBuilder personalCustomBeatmapRecord(Map<Long, CustomBeatmapRecord> personalCustomBeatmapRecord) {
            this.personalCustomBeatmapRecord = personalCustomBeatmapRecord;
            return this;
        }

        public MusicGamePlayerDataBuilder othersCustomBeatmapRecord(Map<Long, CustomBeatmapRecord> othersCustomBeatmapRecord) {
            this.othersCustomBeatmapRecord = othersCustomBeatmapRecord;
            return this;
        }

        public MusicGamePlayerData build() {
            return new MusicGamePlayerData(this.musicGameRecord, this.personalCustomBeatmapRecord, this.othersCustomBeatmapRecord);
        }
    }

    MusicGamePlayerData(Map<Integer, MusicGameRecord> musicGameRecord, Map<Long, CustomBeatmapRecord> personalCustomBeatmapRecord, Map<Long, CustomBeatmapRecord> othersCustomBeatmapRecord) {
        this.musicGameRecord = musicGameRecord;
        this.personalCustomBeatmapRecord = personalCustomBeatmapRecord;
        this.othersCustomBeatmapRecord = othersCustomBeatmapRecord;
    }

    /* renamed from: of */
    public static MusicGamePlayerDataBuilder m1208of() {
        return new MusicGamePlayerDataBuilder();
    }

    public Map<Integer, MusicGameRecord> getMusicGameRecord() {
        return this.musicGameRecord;
    }

    public Map<Long, CustomBeatmapRecord> getPersonalCustomBeatmapRecord() {
        return this.personalCustomBeatmapRecord;
    }

    public Map<Long, CustomBeatmapRecord> getOthersCustomBeatmapRecord() {
        return this.othersCustomBeatmapRecord;
    }

    public static MusicGamePlayerData create() {
        return m1208of().musicGameRecord((Map) GameData.getMusicGameBasicDataMap().values().stream().collect(Collectors.toMap((v0) -> {
            return v0.getId();
        }, MusicGameRecord::create))).personalCustomBeatmapRecord(new HashMap()).othersCustomBeatmapRecord(new HashMap()).build();
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData$MusicGameRecord.class */
    public static class MusicGameRecord {
        private int musicId;
        private int maxCombo;
        private int maxScore;

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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGameRecord.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord(musicId=, maxCombo=, maxScore=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord(musicId=, maxCombo=, maxScore=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.getMusicId()
                r1 = r4
                int r1 = r1.getMaxCombo()
                r2 = r4
                int r2 = r2.getMaxScore()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord(musicId=, maxCombo=, maxScore=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGameRecord.toString():java.lang.String");
        }

        public void setMusicId(int musicId) {
            this.musicId = musicId;
        }

        public void setMaxCombo(int maxCombo) {
            this.maxCombo = maxCombo;
        }

        public void setMaxScore(int maxScore) {
            this.maxScore = maxScore;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof MusicGameRecord)) {
                return false;
            }
            MusicGameRecord other = (MusicGameRecord) o;
            return other.canEqual(this) && getMusicId() == other.getMusicId() && getMaxCombo() == other.getMaxCombo() && getMaxScore() == other.getMaxScore();
        }

        protected boolean canEqual(Object other) {
            return other instanceof MusicGameRecord;
        }

        public int hashCode() {
            return (((((1 * 59) + getMusicId()) * 59) + getMaxCombo()) * 59) + getMaxScore();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData$MusicGameRecord$MusicGameRecordBuilder.class */
        public static class MusicGameRecordBuilder {
            private int musicId;
            private int maxCombo;
            private int maxScore;

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
            /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGameRecord.MusicGameRecordBuilder.toString():java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord.MusicGameRecordBuilder(musicId=, maxCombo=, maxScore=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord.MusicGameRecordBuilder(musicId=, maxCombo=, maxScore=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            public java.lang.String toString() {
                /*
                    r4 = this;
                    r0 = r4
                    int r0 = r0.musicId
                    r1 = r4
                    int r1 = r1.maxCombo
                    r2 = r4
                    int r2 = r2.maxScore
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I)Ljava/lang/String;}, MusicGamePlayerData.MusicGameRecord.MusicGameRecordBuilder(musicId=, maxCombo=, maxScore=)]}
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.MusicGameRecord.MusicGameRecordBuilder.toString():java.lang.String");
            }

            MusicGameRecordBuilder() {
            }

            public MusicGameRecordBuilder musicId(int musicId) {
                this.musicId = musicId;
                return this;
            }

            public MusicGameRecordBuilder maxCombo(int maxCombo) {
                this.maxCombo = maxCombo;
                return this;
            }

            public MusicGameRecordBuilder maxScore(int maxScore) {
                this.maxScore = maxScore;
                return this;
            }

            public MusicGameRecord build() {
                return new MusicGameRecord(this.musicId, this.maxCombo, this.maxScore);
            }
        }

        MusicGameRecord(int musicId, int maxCombo, int maxScore) {
            this.musicId = musicId;
            this.maxCombo = maxCombo;
            this.maxScore = maxScore;
        }

        /* renamed from: of */
        public static MusicGameRecordBuilder m1206of() {
            return new MusicGameRecordBuilder();
        }

        public int getMusicId() {
            return this.musicId;
        }

        public int getMaxCombo() {
            return this.maxCombo;
        }

        public int getMaxScore() {
            return this.maxScore;
        }

        public static MusicGameRecord create(MusicGameBasicData musicGameBasicData) {
            return m1206of().musicId(musicGameBasicData.getId()).build();
        }

        public MusicGameRecordOuterClass.MusicGameRecord toProto() {
            return MusicGameRecordOuterClass.MusicGameRecord.newBuilder().setIsUnlock(true).setMaxCombo(this.maxCombo).setMaxScore(this.maxScore).build();
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData$CustomBeatmapRecord.class */
    public static class CustomBeatmapRecord {
        private long musicShareId;
        private int score;
        private boolean settle;

        /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r0, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.CustomBeatmapRecord.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord(musicShareId=, score=, settle=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord(musicShareId=, score=, settle=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r5 = this;
                r0 = r5
                long r0 = r0.getMusicShareId()
                r1 = r5
                int r1 = r1.getScore()
                r2 = r5
                boolean r2 = r2.isSettle()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord(musicShareId=, score=, settle=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.CustomBeatmapRecord.toString():java.lang.String");
        }

        public void setMusicShareId(long musicShareId) {
            this.musicShareId = musicShareId;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public void setSettle(boolean settle) {
            this.settle = settle;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CustomBeatmapRecord)) {
                return false;
            }
            CustomBeatmapRecord other = (CustomBeatmapRecord) o;
            return other.canEqual(this) && getMusicShareId() == other.getMusicShareId() && getScore() == other.getScore() && isSettle() == other.isSettle();
        }

        protected boolean canEqual(Object other) {
            return other instanceof CustomBeatmapRecord;
        }

        public int hashCode() {
            long $musicShareId = getMusicShareId();
            return (((((1 * 59) + ((int) (($musicShareId >>> 32) ^ $musicShareId))) * 59) + getScore()) * 59) + (isSettle() ? 79 : 97);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGamePlayerData$CustomBeatmapRecord$CustomBeatmapRecordBuilder.class */
        public static class CustomBeatmapRecordBuilder {
            private long musicShareId;
            private int score;
            private boolean settle;

            /*  JADX ERROR: Dependency scan failed at insn: 0x000C: INVOKE_CUSTOM r-3, r0, r-2, r-1
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
            /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r0, r1, r2, method: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.CustomBeatmapRecord.CustomBeatmapRecordBuilder.toString():java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord.CustomBeatmapRecordBuilder(musicShareId=, score=, settle=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord.CustomBeatmapRecordBuilder(musicShareId=, score=, settle=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            public java.lang.String toString() {
                /*
                    r5 = this;
                    r0 = r5
                    long r0 = r0.musicShareId
                    r1 = r5
                    int r1 = r1.score
                    r2 = r5
                    boolean r2 = r2.settle
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, Z)Ljava/lang/String;}, MusicGamePlayerData.CustomBeatmapRecord.CustomBeatmapRecordBuilder(musicShareId=, score=, settle=)]}
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGamePlayerData.CustomBeatmapRecord.CustomBeatmapRecordBuilder.toString():java.lang.String");
            }

            CustomBeatmapRecordBuilder() {
            }

            public CustomBeatmapRecordBuilder musicShareId(long musicShareId) {
                this.musicShareId = musicShareId;
                return this;
            }

            public CustomBeatmapRecordBuilder score(int score) {
                this.score = score;
                return this;
            }

            public CustomBeatmapRecordBuilder settle(boolean settle) {
                this.settle = settle;
                return this;
            }

            public CustomBeatmapRecord build() {
                return new CustomBeatmapRecord(this.musicShareId, this.score, this.settle);
            }
        }

        CustomBeatmapRecord(long musicShareId, int score, boolean settle) {
            this.musicShareId = musicShareId;
            this.score = score;
            this.settle = settle;
        }

        /* renamed from: of */
        public static CustomBeatmapRecordBuilder m1207of() {
            return new CustomBeatmapRecordBuilder();
        }

        public long getMusicShareId() {
            return this.musicShareId;
        }

        public int getScore() {
            return this.score;
        }

        public boolean isSettle() {
            return this.settle;
        }

        public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder toPersonalBriefProto() {
            MusicGameBeatmap.getByShareId(this.musicShareId);
            return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.newBuilder();
        }

        public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder toOthersBriefProto() {
            return MusicGameBeatmap.getByShareId(this.musicShareId).toBriefProto().setMaxScore(this.score);
        }
    }
}
