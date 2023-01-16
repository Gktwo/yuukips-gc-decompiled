package emu.grasscutter.game.world;

import emu.grasscutter.data.GameDepot;
import emu.grasscutter.utils.Position;
import java.util.List;
import java.util.Objects;

/* loaded from: grasscutter.jar:emu/grasscutter/game/world/SpawnDataEntry.class */
public class SpawnDataEntry {
    private transient SpawnGroupEntry group;
    private int monsterId;
    private int gadgetId;
    private int configId;
    private int level;
    private int poseId;
    private int gatherItemId;
    private int gadgetState;
    private Position pos;
    private Position rot;

    public SpawnGroupEntry getGroup() {
        return this.group;
    }

    public void setGroup(SpawnGroupEntry group) {
        this.group = group;
    }

    public int getMonsterId() {
        return this.monsterId;
    }

    public int getGadgetId() {
        return this.gadgetId;
    }

    public int getConfigId() {
        return this.configId;
    }

    public int getLevel() {
        return this.level;
    }

    public int getPoseId() {
        return this.poseId;
    }

    public int getGatherItemId() {
        return this.gatherItemId;
    }

    public int getGadgetState() {
        return this.gadgetState;
    }

    public Position getPos() {
        return this.pos;
    }

    public Position getRot() {
        return this.rot;
    }

    public GridBlockId getBlockId() {
        int scale = GridBlockId.getScale(this.gadgetId);
        return new GridBlockId(this.group.sceneId, scale, (int) (this.pos.getX() / ((float) GameDepot.BLOCK_SIZE[scale])), (int) (this.pos.getZ() / ((float) GameDepot.BLOCK_SIZE[scale])));
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/world/SpawnDataEntry$SpawnGroupEntry.class */
    public static class SpawnGroupEntry {
        private int sceneId;
        private int groupId;
        private int blockId;
        private List<SpawnDataEntry> spawns;

        public int getSceneId() {
            return this.sceneId;
        }

        public int getGroupId() {
            return this.groupId;
        }

        public int getBlockId() {
            return this.blockId;
        }

        public List<SpawnDataEntry> getSpawns() {
            return this.spawns;
        }

        public void setSpawns(List<SpawnDataEntry> spawns) {
            this.spawns = spawns;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/world/SpawnDataEntry$GridBlockId.class */
    public static class GridBlockId {
        private int sceneId;
        private int scale;

        /* renamed from: x */
        private int f603x;

        /* renamed from: z */
        private int f604z;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r0, r1, r2, r3, method: emu.grasscutter.game.world.SpawnDataEntry.GridBlockId.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I)Ljava/lang/String;}, SpawnDataEntryScaledPoint{sceneId=, scale=, x=, z=}]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I)Ljava/lang/String;}, SpawnDataEntryScaledPoint{sceneId=, scale=, x=, z=}]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r5 = this;
                r0 = r5
                int r0 = r0.sceneId
                r1 = r5
                int r1 = r1.scale
                r2 = r5
                int r2 = r2.f603x
                r3 = r5
                int r3 = r3.f604z
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I)Ljava/lang/String;}, SpawnDataEntryScaledPoint{sceneId=, scale=, x=, z=}]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.world.SpawnDataEntry.GridBlockId.toString():java.lang.String");
        }

        public int getSceneId() {
            return this.sceneId;
        }

        public int getScale() {
            return this.scale;
        }

        public int getX() {
            return this.f603x;
        }

        public int getZ() {
            return this.f604z;
        }

        public GridBlockId(int sceneId, int scale, int x, int z) {
            this.sceneId = sceneId;
            this.scale = scale;
            this.f603x = x;
            this.f604z = z;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GridBlockId that = (GridBlockId) o;
            return this.sceneId == that.sceneId && this.scale == that.scale && this.f603x == that.f603x && this.f604z == that.f604z;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.sceneId), Integer.valueOf(this.scale), Integer.valueOf(this.f603x), Integer.valueOf(this.f604z));
        }

        public static GridBlockId[] getAdjacentGridBlockIds(int sceneId, Position pos) {
            GridBlockId[] results = new GridBlockId[25 * GameDepot.BLOCK_SIZE.length];
            int t = 0;
            for (int scale = 0; scale < GameDepot.BLOCK_SIZE.length; scale++) {
                int x = (int) (pos.getX() / ((float) GameDepot.BLOCK_SIZE[scale]));
                int z = (int) (pos.getZ() / ((float) GameDepot.BLOCK_SIZE[scale]));
                for (int i = x - 2; i < x + 3; i++) {
                    for (int j = z - 2; j < z + 3; j++) {
                        t++;
                        results[t] = new GridBlockId(sceneId, scale, i, j);
                    }
                }
            }
            return results;
        }

        public static int getScale(int gadgetId) {
            return 0;
        }
    }
}
