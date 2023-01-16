package emu.grasscutter.game.dailytask;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DailyTaskLevelData;
import emu.grasscutter.data.excels.DailyTaskRewardData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketDailyTaskDataNotify;
import emu.grasscutter.server.packet.send.PacketDailyTaskUnlockedCitiesNotify;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.bson.types.ObjectId;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.IntSet;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

@Entity(value = "dailytasks", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/dailytask/DailyTaskManager.class */
public class DailyTaskManager {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f567id;
    @Indexed(options = @IndexOptions(unique = true))
    private int ownerUid;
    private transient Player player;
    private Set<DailyTask> dailyTasks;
    private Set<Integer> unlockedCities;
    private int cityId;
    static final IntSet cityIds = IntSet.m696of(GameData.getDailyTaskDataMap().values().stream().mapToInt((v0) -> {
        return v0.getCityId();
    }).distinct().toArray());

    /*  JADX ERROR: Dependency scan failed at insn: 0x0096: INVOKE_CUSTOM r-10, r-9
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
    /*  JADX ERROR: Failed to decode insn: 0x0096: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.dailytask.DailyTaskManager.resetDailyTasks():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Reset DailyTasks:  | City ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Reset DailyTasks:  | City ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void resetDailyTasks() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = r0
            r2 = 1
            r1.<init>(r2)
            r6 = r0
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            r1 = r0
            r2 = 4
            r1.<init>(r2)
            r7 = r0
            it.unimi.dsi.fastutil.ints.IntSet r0 = emu.grasscutter.game.dailytask.DailyTaskManager.cityIds
            java.util.stream.IntStream r0 = r0.intStream()
            java.util.OptionalInt r0 = r0.min()
            r1 = r6
            r2 = r1
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            void r1 = this::set
            r0.ifPresent(r1)
            it.unimi.dsi.fastutil.ints.IntSet r0 = emu.grasscutter.game.dailytask.DailyTaskManager.cityIds
            java.util.stream.IntStream r0 = r0.intStream()
            java.util.OptionalInt r0 = r0.max()
            r1 = r7
            r2 = r1
            java.lang.Object r2 = java.util.Objects.requireNonNull(r2)
            void r1 = this::set
            r0.ifPresent(r1)
            java.util.Random r0 = new java.util.Random
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r5
            int r0 = r0.cityId
            r9 = r0
            r0 = r6
            int r0 = r0.get()
            r1 = r9
            if (r0 > r1) goto L_0x0068
            r0 = r7
            int r0 = r0.get()
            r1 = r9
            if (r0 >= r1) goto L_0x0078
            r0 = r8
            r1 = r6
            int r1 = r1.get()
            r2 = r7
            int r2 = r2.get()
            r3 = 1
            int r2 = r2 + r3
            int r0 = r0.nextInt(r1, r2)
            r9 = r0
            r0 = r5
            java.util.Set r0 = r0.getDailyTasks()
            r0.clear()
            r0 = r5
            r1 = r9
            r2 = r8
            java.util.List r0 = r0.chooseDailyTasks(r1, r2)
            r10 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r10
            int r1 = r1.size()
            r2 = r9
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Reset DailyTasks:  | City ]}
            r0.info(r1)
            r0 = r5
            java.util.Set r0 = r0.getDailyTasks()
            r1 = r10
            boolean r0 = r0.addAll(r1)
            r0 = r5
            r0.save()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dailytask.DailyTaskManager.resetDailyTasks():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.dailytask.DailyTaskManager.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r7 = this;
            r0 = r7
            org.bson.types.ObjectId r0 = r0.getId()
            r1 = r7
            int r1 = r1.getOwnerUid()
            r2 = r7
            emu.grasscutter.game.player.Player r2 = r2.getPlayer()
            r3 = r7
            java.util.Set r3 = r3.getDailyTasks()
            r4 = r7
            java.util.Set r4 = r4.getUnlockedCities()
            r5 = r7
            int r5 = r5.getCityId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dailytask.DailyTaskManager.toString():java.lang.String");
    }

    public void setId(ObjectId id) {
        this.f567id = id;
    }

    public void setOwnerUid(int ownerUid) {
        this.ownerUid = ownerUid;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setDailyTasks(Set<DailyTask> dailyTasks) {
        this.dailyTasks = dailyTasks;
    }

    public void setUnlockedCities(Set<Integer> unlockedCities) {
        this.unlockedCities = unlockedCities;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof DailyTaskManager)) {
            return false;
        }
        DailyTaskManager other = (DailyTaskManager) o;
        if (!other.canEqual(this) || getOwnerUid() != other.getOwnerUid() || getCityId() != other.getCityId()) {
            return false;
        }
        Object this$id = getId();
        Object other$id = other.getId();
        if (this$id == null) {
            if (other$id != null) {
                return false;
            }
        } else if (!this$id.equals(other$id)) {
            return false;
        }
        Object this$dailyTasks = getDailyTasks();
        Object other$dailyTasks = other.getDailyTasks();
        if (this$dailyTasks == null) {
            if (other$dailyTasks != null) {
                return false;
            }
        } else if (!this$dailyTasks.equals(other$dailyTasks)) {
            return false;
        }
        Object this$unlockedCities = getUnlockedCities();
        Object other$unlockedCities = other.getUnlockedCities();
        return this$unlockedCities == null ? other$unlockedCities == null : this$unlockedCities.equals(other$unlockedCities);
    }

    protected boolean canEqual(Object other) {
        return other instanceof DailyTaskManager;
    }

    public int hashCode() {
        int result = (((1 * 59) + getOwnerUid()) * 59) + getCityId();
        Object $id = getId();
        int result2 = (result * 59) + ($id == null ? 43 : $id.hashCode());
        Object $dailyTasks = getDailyTasks();
        int result3 = (result2 * 59) + ($dailyTasks == null ? 43 : $dailyTasks.hashCode());
        Object $unlockedCities = getUnlockedCities();
        return (result3 * 59) + ($unlockedCities == null ? 43 : $unlockedCities.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/dailytask/DailyTaskManager$DailyTaskManagerBuilder.class */
    public static class DailyTaskManagerBuilder {

        /* renamed from: id */
        private ObjectId f568id;
        private int ownerUid;
        private Player player;
        private Set<DailyTask> dailyTasks;
        private Set<Integer> unlockedCities;
        private int cityId;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, method: emu.grasscutter.game.dailytask.DailyTaskManager.DailyTaskManagerBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager.DailyTaskManagerBuilder(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager.DailyTaskManagerBuilder(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r7 = this;
                r0 = r7
                org.bson.types.ObjectId r0 = r0.f568id
                r1 = r7
                int r1 = r1.ownerUid
                r2 = r7
                emu.grasscutter.game.player.Player r2 = r2.player
                r3 = r7
                java.util.Set<emu.grasscutter.game.dailytask.DailyTask> r3 = r3.dailyTasks
                r4 = r7
                java.util.Set<java.lang.Integer> r4 = r4.unlockedCities
                r5 = r7
                int r5 = r5.cityId
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/types/ObjectId;, I, Lemu/grasscutter/game/player/Player;, Ljava/util/Set;, Ljava/util/Set;, I)Ljava/lang/String;}, DailyTaskManager.DailyTaskManagerBuilder(id=, ownerUid=, player=, dailyTasks=, unlockedCities=, cityId=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.dailytask.DailyTaskManager.DailyTaskManagerBuilder.toString():java.lang.String");
        }

        DailyTaskManagerBuilder() {
        }

        /* renamed from: id */
        public DailyTaskManagerBuilder m1204id(ObjectId id) {
            this.f568id = id;
            return this;
        }

        public DailyTaskManagerBuilder ownerUid(int ownerUid) {
            this.ownerUid = ownerUid;
            return this;
        }

        public DailyTaskManagerBuilder player(Player player) {
            this.player = player;
            return this;
        }

        public DailyTaskManagerBuilder dailyTasks(Set<DailyTask> dailyTasks) {
            this.dailyTasks = dailyTasks;
            return this;
        }

        public DailyTaskManagerBuilder unlockedCities(Set<Integer> unlockedCities) {
            this.unlockedCities = unlockedCities;
            return this;
        }

        public DailyTaskManagerBuilder cityId(int cityId) {
            this.cityId = cityId;
            return this;
        }

        public DailyTaskManager build() {
            return new DailyTaskManager(this.f568id, this.ownerUid, this.player, this.dailyTasks, this.unlockedCities, this.cityId);
        }
    }

    DailyTaskManager(ObjectId id, int ownerUid, Player player, Set<DailyTask> dailyTasks, Set<Integer> unlockedCities, int cityId) {
        this.f567id = id;
        this.ownerUid = ownerUid;
        this.player = player;
        this.dailyTasks = dailyTasks;
        this.unlockedCities = unlockedCities;
        this.cityId = cityId;
    }

    /* renamed from: of */
    public static DailyTaskManagerBuilder m1205of() {
        return new DailyTaskManagerBuilder();
    }

    public ObjectId getId() {
        return this.f567id;
    }

    public int getOwnerUid() {
        return this.ownerUid;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Set<DailyTask> getDailyTasks() {
        return this.dailyTasks;
    }

    public Set<Integer> getUnlockedCities() {
        return this.unlockedCities;
    }

    public int getCityId() {
        return this.cityId;
    }

    public static DailyTaskManager getByUid(int uid) {
        DailyTaskManager manager = DatabaseHelper.getDailyTasksByUid(uid);
        if (manager == null) {
            manager = m1205of().ownerUid(uid).dailyTasks(new HashSet()).unlockedCities(cityIds).cityId(0).build();
            manager.save();
        }
        return manager;
    }

    public int getScoreRewardId() {
        int level = getPlayer().getLevel();
        int rewardId = 0;
        ObjectIterator<Int2ObjectMap.Entry<DailyTaskLevelData>> it = GameData.getDailyTaskLevelDataMap().int2ObjectEntrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DailyTaskLevelData dailyTaskLevelData = it.next().getValue();
            if (dailyTaskLevelData.getMinPlayerLevel() <= level && level <= dailyTaskLevelData.getMaxPlayerLevel()) {
                rewardId = dailyTaskLevelData.getScorePreviewRewardId();
                break;
            }
        }
        return rewardId;
    }

    public int getRewardId(int taskRewardId) {
        int level = getPlayer().getLevel();
        int id = 1;
        int rewardId = 0;
        ObjectIterator<Int2ObjectMap.Entry<DailyTaskLevelData>> it = GameData.getDailyTaskLevelDataMap().int2ObjectEntrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Int2ObjectMap.Entry<DailyTaskLevelData> entry = it.next();
            DailyTaskLevelData dailyTaskLevelData = entry.getValue();
            if (dailyTaskLevelData.getMinPlayerLevel() <= level && level <= dailyTaskLevelData.getMaxPlayerLevel()) {
                id = entry.getIntKey();
                break;
            }
        }
        for (Int2ObjectMap.Entry<DailyTaskRewardData> entry2 : GameData.getDailyTaskRewardDataMap().int2ObjectEntrySet().stream().filter(e -> {
            return e.getIntKey() == taskRewardId;
        }).toList()) {
            List<DailyTaskRewardData.DropVec> vec = entry2.getValue().getDropVec();
            if (id > 0 && id <= vec.size()) {
                rewardId = vec.get(id - 1).getPreviewRewardId();
            }
        }
        return rewardId;
    }

    private List<DailyTask> chooseDailyTasks(int cityId, Random random) {
        return chooseRandom(GameData.getDailyTaskDataMap().values().stream().filter(e -> {
            return e.getCityId() == cityId;
        }).map(e -> {
            return new DailyTask(e.getTaskRewardId(), e.getId(), e.getFinishProgress(), 0);
        }).toList(), 4, random);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.util.ArrayList */
    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.ArrayList */
    /* JADX WARN: Multi-variable type inference failed */
    private static <E> List<E> chooseRandom(Collection<E> list, int pullSize, Random random) {
        int size = list.size();
        if (pullSize < 0 || size < pullSize) {
            pullSize = 0;
        }
        ArrayList arrayList = new ArrayList(pullSize);
        ArrayList arrayList2 = new ArrayList(list);
        for (int i = 0; i < pullSize; i++) {
            int j = (int) (random.nextDouble() * ((double) (size - i)));
            arrayList.add(arrayList2.get(j));
            arrayList2.set(j, arrayList2.get((size - i) - 1));
        }
        return arrayList;
    }

    public void onPlayerLogin(Player player) {
        if (this.player == null) {
            this.player = player;
        }
        getPlayer().sendPacket(new PacketDailyTaskUnlockedCitiesNotify(getUnlockedCities()));
        getPlayer().sendPacket(new PacketDailyTaskDataNotify(getDailyTasks().stream().filter((v0) -> {
            return v0.isFinished();
        }).toList().size(), getScoreRewardId()));
    }

    public void filterCityId(int cityId) {
        this.cityId = cityId;
        save();
    }

    public void save() {
        DatabaseHelper.saveDailyTasks(this);
    }
}
