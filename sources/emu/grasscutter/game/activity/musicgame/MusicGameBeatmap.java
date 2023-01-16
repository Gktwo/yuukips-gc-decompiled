package emu.grasscutter.game.activity.musicgame;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.net.proto.MusicBeatmapListOuterClass;
import emu.grasscutter.net.proto.MusicBeatmapNoteOuterClass;
import emu.grasscutter.net.proto.MusicBeatmapOuterClass;
import emu.grasscutter.net.proto.UgcMusicBriefInfoOuterClass;
import java.util.List;
import java.util.Random;

@Entity("music_game_beatmaps")
/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameBeatmap.class */
public class MusicGameBeatmap {
    @AbstractC1283Id
    private long musicShareId;
    private int authorUid;
    private int musicId;
    private int musicNoteCount;
    private int savePosition;
    private int maxScore;
    private int createTime;
    private List<List<BeatmapNote>> beatmap;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r0, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r10 = this;
            r0 = r10
            long r0 = r0.getMusicShareId()
            r1 = r10
            int r1 = r1.getAuthorUid()
            r2 = r10
            int r2 = r2.getMusicId()
            r3 = r10
            int r3 = r3.getMusicNoteCount()
            r4 = r10
            int r4 = r4.getSavePosition()
            r5 = r10
            int r5 = r5.getMaxScore()
            r6 = r10
            int r6 = r6.getCreateTime()
            r7 = r10
            java.util.List r7 = r7.getBeatmap()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.toString():java.lang.String");
    }

    public void setMusicShareId(long musicShareId) {
        this.musicShareId = musicShareId;
    }

    public void setAuthorUid(int authorUid) {
        this.authorUid = authorUid;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public void setMusicNoteCount(int musicNoteCount) {
        this.musicNoteCount = musicNoteCount;
    }

    public void setSavePosition(int savePosition) {
        this.savePosition = savePosition;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }

    public void setBeatmap(List<List<BeatmapNote>> beatmap) {
        this.beatmap = beatmap;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof MusicGameBeatmap)) {
            return false;
        }
        MusicGameBeatmap other = (MusicGameBeatmap) o;
        if (!other.canEqual(this) || getMusicShareId() != other.getMusicShareId() || getAuthorUid() != other.getAuthorUid() || getMusicId() != other.getMusicId() || getMusicNoteCount() != other.getMusicNoteCount() || getSavePosition() != other.getSavePosition() || getMaxScore() != other.getMaxScore() || getCreateTime() != other.getCreateTime()) {
            return false;
        }
        Object this$beatmap = getBeatmap();
        Object other$beatmap = other.getBeatmap();
        return this$beatmap == null ? other$beatmap == null : this$beatmap.equals(other$beatmap);
    }

    protected boolean canEqual(Object other) {
        return other instanceof MusicGameBeatmap;
    }

    public int hashCode() {
        long $musicShareId = getMusicShareId();
        int result = (((((((((((((1 * 59) + ((int) (($musicShareId >>> 32) ^ $musicShareId))) * 59) + getAuthorUid()) * 59) + getMusicId()) * 59) + getMusicNoteCount()) * 59) + getSavePosition()) * 59) + getMaxScore()) * 59) + getCreateTime();
        Object $beatmap = getBeatmap();
        return (result * 59) + ($beatmap == null ? 43 : $beatmap.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameBeatmap$MusicGameBeatmapBuilder.class */
    public static class MusicGameBeatmapBuilder {
        private long musicShareId;
        private int authorUid;
        private int musicId;
        private int musicNoteCount;
        private int savePosition;
        private int maxScore;
        private int createTime;
        private List<List<BeatmapNote>> beatmap;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r0, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.MusicGameBeatmapBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap.MusicGameBeatmapBuilder(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap.MusicGameBeatmapBuilder(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r10 = this;
                r0 = r10
                long r0 = r0.musicShareId
                r1 = r10
                int r1 = r1.authorUid
                r2 = r10
                int r2 = r2.musicId
                r3 = r10
                int r3 = r3.musicNoteCount
                r4 = r10
                int r4 = r4.savePosition
                r5 = r10
                int r5 = r5.maxScore
                r6 = r10
                int r6 = r6.createTime
                r7 = r10
                java.util.List<java.util.List<emu.grasscutter.game.activity.musicgame.MusicGameBeatmap$BeatmapNote>> r7 = r7.beatmap
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (J, I, I, I, I, I, I, Ljava/util/List;)Ljava/lang/String;}, MusicGameBeatmap.MusicGameBeatmapBuilder(musicShareId=, authorUid=, musicId=, musicNoteCount=, savePosition=, maxScore=, createTime=, beatmap=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.MusicGameBeatmapBuilder.toString():java.lang.String");
        }

        MusicGameBeatmapBuilder() {
        }

        public MusicGameBeatmapBuilder musicShareId(long musicShareId) {
            this.musicShareId = musicShareId;
            return this;
        }

        public MusicGameBeatmapBuilder authorUid(int authorUid) {
            this.authorUid = authorUid;
            return this;
        }

        public MusicGameBeatmapBuilder musicId(int musicId) {
            this.musicId = musicId;
            return this;
        }

        public MusicGameBeatmapBuilder musicNoteCount(int musicNoteCount) {
            this.musicNoteCount = musicNoteCount;
            return this;
        }

        public MusicGameBeatmapBuilder savePosition(int savePosition) {
            this.savePosition = savePosition;
            return this;
        }

        public MusicGameBeatmapBuilder maxScore(int maxScore) {
            this.maxScore = maxScore;
            return this;
        }

        public MusicGameBeatmapBuilder createTime(int createTime) {
            this.createTime = createTime;
            return this;
        }

        public MusicGameBeatmapBuilder beatmap(List<List<BeatmapNote>> beatmap) {
            this.beatmap = beatmap;
            return this;
        }

        public MusicGameBeatmap build() {
            return new MusicGameBeatmap(this.musicShareId, this.authorUid, this.musicId, this.musicNoteCount, this.savePosition, this.maxScore, this.createTime, this.beatmap);
        }
    }

    MusicGameBeatmap(long musicShareId, int authorUid, int musicId, int musicNoteCount, int savePosition, int maxScore, int createTime, List<List<BeatmapNote>> beatmap) {
        this.musicShareId = musicShareId;
        this.authorUid = authorUid;
        this.musicId = musicId;
        this.musicNoteCount = musicNoteCount;
        this.savePosition = savePosition;
        this.maxScore = maxScore;
        this.createTime = createTime;
        this.beatmap = beatmap;
    }

    /* renamed from: of */
    public static MusicGameBeatmapBuilder m1210of() {
        return new MusicGameBeatmapBuilder();
    }

    public long getMusicShareId() {
        return this.musicShareId;
    }

    public int getAuthorUid() {
        return this.authorUid;
    }

    public int getMusicId() {
        return this.musicId;
    }

    public int getMusicNoteCount() {
        return this.musicNoteCount;
    }

    public int getSavePosition() {
        return this.savePosition;
    }

    public int getMaxScore() {
        return this.maxScore;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public List<List<BeatmapNote>> getBeatmap() {
        return this.beatmap;
    }

    public static MusicGameBeatmap getByShareId(long musicShareId) {
        return DatabaseHelper.getMusicGameBeatmap(musicShareId);
    }

    public void save() {
        if (this.musicShareId == 0) {
            this.musicShareId = new Random().nextLong(100000000000000L, 999999999999999L);
        }
        DatabaseHelper.saveMusicGameBeatmap(this);
    }

    public static List<List<BeatmapNote>> parse(List<MusicBeatmapListOuterClass.MusicBeatmapList> beatmapItemListList) {
        return beatmapItemListList.stream().map(item -> {
            return item.getBeatmapNoteListList().stream().map(BeatmapNote::parse).toList();
        }).toList();
    }

    public MusicBeatmapOuterClass.MusicBeatmap toProto() {
        return MusicBeatmapOuterClass.MusicBeatmap.newBuilder().setMusicId(this.musicId).addAllBeatmapItemList(this.beatmap.stream().map(this::musicBeatmapListToProto).toList()).build();
    }

    public UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.Builder toBriefProto() {
        DatabaseHelper.getPlayerByUid(this.authorUid);
        return UgcMusicBriefInfoOuterClass.UgcMusicBriefInfo.newBuilder();
    }

    private MusicBeatmapListOuterClass.MusicBeatmapList musicBeatmapListToProto(List<BeatmapNote> beatmapNoteList) {
        return MusicBeatmapListOuterClass.MusicBeatmapList.newBuilder().addAllBeatmapNoteList(beatmapNoteList.stream().map((v0) -> {
            return v0.toProto();
        }).toList()).build();
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameBeatmap$BeatmapNote.class */
    public static class BeatmapNote {
        private int startTime;
        private int endTime;

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
        /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.BeatmapNote.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote(startTime=, endTime=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote(startTime=, endTime=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r3 = this;
                r0 = r3
                int r0 = r0.getStartTime()
                r1 = r3
                int r1 = r1.getEndTime()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote(startTime=, endTime=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.BeatmapNote.toString():java.lang.String");
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof BeatmapNote)) {
                return false;
            }
            BeatmapNote other = (BeatmapNote) o;
            return other.canEqual(this) && getStartTime() == other.getStartTime() && getEndTime() == other.getEndTime();
        }

        protected boolean canEqual(Object other) {
            return other instanceof BeatmapNote;
        }

        public int hashCode() {
            return (((1 * 59) + getStartTime()) * 59) + getEndTime();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/game/activity/musicgame/MusicGameBeatmap$BeatmapNote$BeatmapNoteBuilder.class */
        public static class BeatmapNoteBuilder {
            private int startTime;
            private int endTime;

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
            /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.BeatmapNote.BeatmapNoteBuilder.toString():java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote.BeatmapNoteBuilder(startTime=, endTime=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote.BeatmapNoteBuilder(startTime=, endTime=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            public java.lang.String toString() {
                /*
                    r3 = this;
                    r0 = r3
                    int r0 = r0.startTime
                    r1 = r3
                    int r1 = r1.endTime
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, MusicGameBeatmap.BeatmapNote.BeatmapNoteBuilder(startTime=, endTime=)]}
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.activity.musicgame.MusicGameBeatmap.BeatmapNote.BeatmapNoteBuilder.toString():java.lang.String");
            }

            BeatmapNoteBuilder() {
            }

            public BeatmapNoteBuilder startTime(int startTime) {
                this.startTime = startTime;
                return this;
            }

            public BeatmapNoteBuilder endTime(int endTime) {
                this.endTime = endTime;
                return this;
            }

            public BeatmapNote build() {
                return new BeatmapNote(this.startTime, this.endTime);
            }
        }

        BeatmapNote(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        /* renamed from: of */
        public static BeatmapNoteBuilder m1209of() {
            return new BeatmapNoteBuilder();
        }

        public int getStartTime() {
            return this.startTime;
        }

        public int getEndTime() {
            return this.endTime;
        }

        public static BeatmapNote parse(MusicBeatmapNoteOuterClass.MusicBeatmapNote note) {
            return m1209of().startTime(note.getStartTime()).endTime(note.getEndTime()).build();
        }

        public MusicBeatmapNoteOuterClass.MusicBeatmapNote toProto() {
            return MusicBeatmapNoteOuterClass.MusicBeatmapNote.newBuilder().setStartTime(this.startTime).setEndTime(this.endTime).build();
        }
    }
}
