package emu.grasscutter.game.home;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Transient;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.HomeWorldBgmData;
import emu.grasscutter.data.excels.HomeWorldLevelData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketFurnitureCurModuleArrangeCountNotify;
import emu.grasscutter.server.packet.send.PacketHomeBasicInfoNotify;
import emu.grasscutter.server.packet.send.PacketHomeComfortInfoNotify;
import emu.grasscutter.server.packet.send.PacketHomeMarkPointNotify;
import emu.grasscutter.server.packet.send.PacketPlayerHomeCompInfoNotify;
import emu.grasscutter.server.packet.send.PacketUnlockHomeBgmNotify;
import emu.grasscutter.server.packet.send.PacketUnlockedHomeBgmNotify;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Entity(value = "homes", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/home/GameHome.class */
public class GameHome {
    @AbstractC1283Id

    /* renamed from: id */
    private String f574id;
    @Indexed(options = @IndexOptions(unique = true))
    private long ownerUid;
    @Transient
    private Player player;
    private int level;
    private int exp;
    private List<FurnitureMakeSlotItem> furnitureMakeSlotItemList;
    private ConcurrentHashMap<Integer, HomeSceneItem> sceneMap;
    private Set<Integer> unlockedHomeBgmList;
    private int enterHomeOption;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-9, r-8, r0, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r0, r1, r0, r2, r3, r4, r5, r6, r7, r8, method: emu.grasscutter.game.home.GameHome.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r11 = this;
            r0 = r11
            java.lang.String r0 = r0.getId()
            r1 = r11
            long r1 = r1.getOwnerUid()
            r2 = r11
            emu.grasscutter.game.player.Player r2 = r2.getPlayer()
            r3 = r11
            int r3 = r3.getLevel()
            r4 = r11
            int r4 = r4.getExp()
            r5 = r11
            java.util.List r5 = r5.getFurnitureMakeSlotItemList()
            r6 = r11
            java.util.concurrent.ConcurrentHashMap r6 = r6.getSceneMap()
            r7 = r11
            java.util.Set r7 = r7.getUnlockedHomeBgmList()
            r8 = r11
            int r8 = r8.getEnterHomeOption()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.GameHome.toString():java.lang.String");
    }

    public void setId(String id) {
        this.f574id = id;
    }

    public void setOwnerUid(long ownerUid) {
        this.ownerUid = ownerUid;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setFurnitureMakeSlotItemList(List<FurnitureMakeSlotItem> furnitureMakeSlotItemList) {
        this.furnitureMakeSlotItemList = furnitureMakeSlotItemList;
    }

    public void setSceneMap(ConcurrentHashMap<Integer, HomeSceneItem> sceneMap) {
        this.sceneMap = sceneMap;
    }

    public void setUnlockedHomeBgmList(Set<Integer> unlockedHomeBgmList) {
        this.unlockedHomeBgmList = unlockedHomeBgmList;
    }

    public void setEnterHomeOption(int enterHomeOption) {
        this.enterHomeOption = enterHomeOption;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof GameHome)) {
            return false;
        }
        GameHome other = (GameHome) o;
        if (!other.canEqual(this) || getOwnerUid() != other.getOwnerUid() || getLevel() != other.getLevel() || getExp() != other.getExp() || getEnterHomeOption() != other.getEnterHomeOption()) {
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
        Object this$player = getPlayer();
        Object other$player = other.getPlayer();
        if (this$player == null) {
            if (other$player != null) {
                return false;
            }
        } else if (!this$player.equals(other$player)) {
            return false;
        }
        Object this$furnitureMakeSlotItemList = getFurnitureMakeSlotItemList();
        Object other$furnitureMakeSlotItemList = other.getFurnitureMakeSlotItemList();
        if (this$furnitureMakeSlotItemList == null) {
            if (other$furnitureMakeSlotItemList != null) {
                return false;
            }
        } else if (!this$furnitureMakeSlotItemList.equals(other$furnitureMakeSlotItemList)) {
            return false;
        }
        Object this$sceneMap = getSceneMap();
        Object other$sceneMap = other.getSceneMap();
        if (this$sceneMap == null) {
            if (other$sceneMap != null) {
                return false;
            }
        } else if (!this$sceneMap.equals(other$sceneMap)) {
            return false;
        }
        Object this$unlockedHomeBgmList = getUnlockedHomeBgmList();
        Object other$unlockedHomeBgmList = other.getUnlockedHomeBgmList();
        return this$unlockedHomeBgmList == null ? other$unlockedHomeBgmList == null : this$unlockedHomeBgmList.equals(other$unlockedHomeBgmList);
    }

    protected boolean canEqual(Object other) {
        return other instanceof GameHome;
    }

    public int hashCode() {
        long $ownerUid = getOwnerUid();
        int result = (((((((1 * 59) + ((int) (($ownerUid >>> 32) ^ $ownerUid))) * 59) + getLevel()) * 59) + getExp()) * 59) + getEnterHomeOption();
        Object $id = getId();
        int result2 = (result * 59) + ($id == null ? 43 : $id.hashCode());
        Object $player = getPlayer();
        int result3 = (result2 * 59) + ($player == null ? 43 : $player.hashCode());
        Object $furnitureMakeSlotItemList = getFurnitureMakeSlotItemList();
        int result4 = (result3 * 59) + ($furnitureMakeSlotItemList == null ? 43 : $furnitureMakeSlotItemList.hashCode());
        Object $sceneMap = getSceneMap();
        int result5 = (result4 * 59) + ($sceneMap == null ? 43 : $sceneMap.hashCode());
        Object $unlockedHomeBgmList = getUnlockedHomeBgmList();
        return (result5 * 59) + ($unlockedHomeBgmList == null ? 43 : $unlockedHomeBgmList.hashCode());
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/home/GameHome$GameHomeBuilder.class */
    public static class GameHomeBuilder {

        /* renamed from: id */
        private String f575id;
        private long ownerUid;
        private Player player;
        private int level;
        private int exp;
        private List<FurnitureMakeSlotItem> furnitureMakeSlotItemList;
        private ConcurrentHashMap<Integer, HomeSceneItem> sceneMap;
        private Set<Integer> unlockedHomeBgmList;
        private int enterHomeOption;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-9, r-8, r0, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r0, r1, r0, r2, r3, r4, r5, r6, r7, r8, method: emu.grasscutter.game.home.GameHome.GameHomeBuilder.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome.GameHomeBuilder(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome.GameHomeBuilder(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r11 = this;
                r0 = r11
                java.lang.String r0 = r0.f575id
                r1 = r11
                long r1 = r1.ownerUid
                r2 = r11
                emu.grasscutter.game.player.Player r2 = r2.player
                r3 = r11
                int r3 = r3.level
                r4 = r11
                int r4 = r4.exp
                r5 = r11
                java.util.List<emu.grasscutter.game.home.FurnitureMakeSlotItem> r5 = r5.furnitureMakeSlotItemList
                r6 = r11
                java.util.concurrent.ConcurrentHashMap<java.lang.Integer, emu.grasscutter.game.home.HomeSceneItem> r6 = r6.sceneMap
                r7 = r11
                java.util.Set<java.lang.Integer> r7 = r7.unlockedHomeBgmList
                r8 = r11
                int r8 = r8.enterHomeOption
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, J, Lemu/grasscutter/game/player/Player;, I, I, Ljava/util/List;, Ljava/util/concurrent/ConcurrentHashMap;, Ljava/util/Set;, I)Ljava/lang/String;}, GameHome.GameHomeBuilder(id=, ownerUid=, player=, level=, exp=, furnitureMakeSlotItemList=, sceneMap=, unlockedHomeBgmList=, enterHomeOption=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.GameHome.GameHomeBuilder.toString():java.lang.String");
        }

        GameHomeBuilder() {
        }

        /* renamed from: id */
        public GameHomeBuilder m1201id(String id) {
            this.f575id = id;
            return this;
        }

        public GameHomeBuilder ownerUid(long ownerUid) {
            this.ownerUid = ownerUid;
            return this;
        }

        public GameHomeBuilder player(Player player) {
            this.player = player;
            return this;
        }

        public GameHomeBuilder level(int level) {
            this.level = level;
            return this;
        }

        public GameHomeBuilder exp(int exp) {
            this.exp = exp;
            return this;
        }

        public GameHomeBuilder furnitureMakeSlotItemList(List<FurnitureMakeSlotItem> furnitureMakeSlotItemList) {
            this.furnitureMakeSlotItemList = furnitureMakeSlotItemList;
            return this;
        }

        public GameHomeBuilder sceneMap(ConcurrentHashMap<Integer, HomeSceneItem> sceneMap) {
            this.sceneMap = sceneMap;
            return this;
        }

        public GameHomeBuilder unlockedHomeBgmList(Set<Integer> unlockedHomeBgmList) {
            this.unlockedHomeBgmList = unlockedHomeBgmList;
            return this;
        }

        public GameHomeBuilder enterHomeOption(int enterHomeOption) {
            this.enterHomeOption = enterHomeOption;
            return this;
        }

        public GameHome build() {
            return new GameHome(this.f575id, this.ownerUid, this.player, this.level, this.exp, this.furnitureMakeSlotItemList, this.sceneMap, this.unlockedHomeBgmList, this.enterHomeOption);
        }
    }

    GameHome(String id, long ownerUid, Player player, int level, int exp, List<FurnitureMakeSlotItem> furnitureMakeSlotItemList, ConcurrentHashMap<Integer, HomeSceneItem> sceneMap, Set<Integer> unlockedHomeBgmList, int enterHomeOption) {
        this.f574id = id;
        this.ownerUid = ownerUid;
        this.player = player;
        this.level = level;
        this.exp = exp;
        this.furnitureMakeSlotItemList = furnitureMakeSlotItemList;
        this.sceneMap = sceneMap;
        this.unlockedHomeBgmList = unlockedHomeBgmList;
        this.enterHomeOption = enterHomeOption;
    }

    /* renamed from: of */
    public static GameHomeBuilder m1202of() {
        return new GameHomeBuilder();
    }

    public String getId() {
        return this.f574id;
    }

    public long getOwnerUid() {
        return this.ownerUid;
    }

    public int getLevel() {
        return this.level;
    }

    public int getExp() {
        return this.exp;
    }

    public List<FurnitureMakeSlotItem> getFurnitureMakeSlotItemList() {
        return this.furnitureMakeSlotItemList;
    }

    public ConcurrentHashMap<Integer, HomeSceneItem> getSceneMap() {
        return this.sceneMap;
    }

    public int getEnterHomeOption() {
        return this.enterHomeOption;
    }

    public void save() {
        DatabaseHelper.saveHome(this);
    }

    public static GameHome getByUid(Integer uid) {
        GameHome home = DatabaseHelper.getHomeByUid(uid.intValue());
        if (home == null) {
            home = create(uid);
        }
        return home;
    }

    public static GameHome create(Integer uid) {
        return m1202of().ownerUid((long) uid.intValue()).level(1).sceneMap(new ConcurrentHashMap<>()).unlockedHomeBgmList(new HashSet()).build();
    }

    public HomeSceneItem getHomeSceneItem(int sceneId) {
        return this.sceneMap.computeIfAbsent(Integer.valueOf(sceneId), 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0014: RETURN  
              (wrap: emu.grasscutter.game.home.HomeSceneItem : 0x0011: INVOKE  (r0v3 emu.grasscutter.game.home.HomeSceneItem A[REMOVE]) = 
              (wrap: java.util.concurrent.ConcurrentHashMap<java.lang.Integer, emu.grasscutter.game.home.HomeSceneItem> : 0x0001: IGET  (r0v1 java.util.concurrent.ConcurrentHashMap<java.lang.Integer, emu.grasscutter.game.home.HomeSceneItem> A[REMOVE]) = (r4v0 'this' emu.grasscutter.game.home.GameHome A[D('this' emu.grasscutter.game.home.GameHome), IMMUTABLE_TYPE, THIS]) emu.grasscutter.game.home.GameHome.sceneMap java.util.concurrent.ConcurrentHashMap)
              (wrap: java.lang.Integer : 0x0005: INVOKE  (r1v1 java.lang.Integer A[REMOVE]) = (r5v0 'sceneId' int A[D('sceneId' int)]) type: STATIC call: java.lang.Integer.valueOf(int):java.lang.Integer)
              (wrap: java.util.function.Function<? super java.lang.Integer, ? extends emu.grasscutter.game.home.HomeSceneItem> : 0x0009: INVOKE_CUSTOM (r2v1 java.util.function.Function<? super java.lang.Integer, ? extends emu.grasscutter.game.home.HomeSceneItem> A[REMOVE]) = (r5v0 'sceneId' int A[D('sceneId' int), DONT_INLINE])
             handle type: INVOKE_STATIC
             lambda: java.util.function.Function.apply(java.lang.Object):java.lang.Object
             call insn: ?: INVOKE  (r2 I:int), (v1 java.lang.Integer) type: STATIC call: emu.grasscutter.game.home.GameHome.lambda$getHomeSceneItem$0(int, java.lang.Integer):emu.grasscutter.game.home.HomeSceneItem)
             type: VIRTUAL call: java.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object)
             in method: emu.grasscutter.game.home.GameHome.getHomeSceneItem(int):emu.grasscutter.game.home.HomeSceneItem, file: grasscutter.jar:emu/grasscutter/game/home/GameHome.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r4
            java.util.concurrent.ConcurrentHashMap<java.lang.Integer, emu.grasscutter.game.home.HomeSceneItem> r0 = r0.sceneMap
            r1 = r5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2 = r5
            emu.grasscutter.game.home.HomeSceneItem r2 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$getHomeSceneItem$0(r2, v1);
            }
            java.lang.Object r0 = r0.computeIfAbsent(r1, r2)
            emu.grasscutter.game.home.HomeSceneItem r0 = (emu.grasscutter.game.home.HomeSceneItem) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.home.GameHome.getHomeSceneItem(int):emu.grasscutter.game.home.HomeSceneItem");
    }

    public void onOwnerLogin(Player player) {
        if (this.player == null) {
            this.player = player;
        }
        player.getSession().send(new PacketHomeBasicInfoNotify(player, false));
        player.getSession().send(new PacketPlayerHomeCompInfoNotify(player));
        player.getSession().send(new PacketHomeComfortInfoNotify(player));
        player.getSession().send(new PacketFurnitureCurModuleArrangeCountNotify());
        player.getSession().send(new PacketHomeMarkPointNotify(player));
        player.getSession().send(new PacketUnlockedHomeBgmNotify(player));
    }

    public Player getPlayer() {
        if (this.player == null) {
            this.player = Grasscutter.getGameServer().getPlayerByUid((int) this.ownerUid, true);
        }
        return this.player;
    }

    public HomeWorldLevelData getLevelData() {
        return GameData.getHomeWorldLevelDataMap().get(this.level);
    }

    public boolean addUnlockedHomeBgm(int homeBgmId) {
        if (!getUnlockedHomeBgmList().add(Integer.valueOf(homeBgmId))) {
            return false;
        }
        Player player = getPlayer();
        player.sendPacket(new PacketUnlockHomeBgmNotify(homeBgmId));
        player.sendPacket(new PacketUnlockedHomeBgmNotify(player));
        save();
        return true;
    }

    public Set<Integer> getUnlockedHomeBgmList() {
        if (this.unlockedHomeBgmList == null) {
            this.unlockedHomeBgmList = new HashSet();
        }
        if (this.unlockedHomeBgmList.addAll(getDefaultUnlockedHomeBgmIds())) {
            save();
        }
        return this.unlockedHomeBgmList;
    }

    private Set<Integer> getDefaultUnlockedHomeBgmIds() {
        return (Set) GameData.getHomeWorldBgmDataMap().int2ObjectEntrySet().stream().filter(e -> {
            return ((HomeWorldBgmData) e.getValue()).isDefaultUnlock();
        }).map((v0) -> {
            return v0.getIntKey();
        }).collect(Collectors.toUnmodifiableSet());
    }
}
