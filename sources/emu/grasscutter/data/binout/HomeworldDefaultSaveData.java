package emu.grasscutter.data.binout;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.utils.Position;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/HomeworldDefaultSaveData.class */
public class HomeworldDefaultSaveData {
    @SerializedName(value = "KFHBFNPDJBE", alternate = {"PKACPHDGGEI"})
    private List<HomeBlock> homeBlockLists;
    @SerializedName(value = "IJNPADKGNKE", alternate = {"MINCKHBNING"})
    private Position bornPos;
    @SerializedName("IPIIGEMFLHK")
    private Position bornRot;
    @SerializedName("HHOLBNPIHEM")
    private Position djinPos;
    @SerializedName("KNHCJKHCOAN")
    private HomeFurniture mainhouse;
    @SerializedName("NIHOJFEKFPG")
    private List<HomeFurniture> doorLists;
    @SerializedName("EPGELGEFJFK")
    private List<HomeFurniture> stairLists;

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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.data.binout.HomeworldDefaultSaveData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/data/binout/HomeworldDefaultSaveData$HomeFurniture;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData(homeBlockLists=, bornPos=, bornRot=, djinPos=, mainhouse=, doorLists=, stairLists=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/data/binout/HomeworldDefaultSaveData$HomeFurniture;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData(homeBlockLists=, bornPos=, bornRot=, djinPos=, mainhouse=, doorLists=, stairLists=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r8 = this;
            r0 = r8
            java.util.List r0 = r0.getHomeBlockLists()
            r1 = r8
            emu.grasscutter.utils.Position r1 = r1.getBornPos()
            r2 = r8
            emu.grasscutter.utils.Position r2 = r2.getBornRot()
            r3 = r8
            emu.grasscutter.utils.Position r3 = r3.getDjinPos()
            r4 = r8
            emu.grasscutter.data.binout.HomeworldDefaultSaveData$HomeFurniture r4 = r4.getMainhouse()
            r5 = r8
            java.util.List r5 = r5.getDoorLists()
            r6 = r8
            java.util.List r6 = r6.getStairLists()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/data/binout/HomeworldDefaultSaveData$HomeFurniture;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData(homeBlockLists=, bornPos=, bornRot=, djinPos=, mainhouse=, doorLists=, stairLists=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.HomeworldDefaultSaveData.toString():java.lang.String");
    }

    public void setHomeBlockLists(List<HomeBlock> homeBlockLists) {
        this.homeBlockLists = homeBlockLists;
    }

    public void setBornPos(Position bornPos) {
        this.bornPos = bornPos;
    }

    public void setBornRot(Position bornRot) {
        this.bornRot = bornRot;
    }

    public void setDjinPos(Position djinPos) {
        this.djinPos = djinPos;
    }

    public void setMainhouse(HomeFurniture mainhouse) {
        this.mainhouse = mainhouse;
    }

    public void setDoorLists(List<HomeFurniture> doorLists) {
        this.doorLists = doorLists;
    }

    public void setStairLists(List<HomeFurniture> stairLists) {
        this.stairLists = stairLists;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof HomeworldDefaultSaveData)) {
            return false;
        }
        HomeworldDefaultSaveData other = (HomeworldDefaultSaveData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$homeBlockLists = getHomeBlockLists();
        Object other$homeBlockLists = other.getHomeBlockLists();
        if (this$homeBlockLists == null) {
            if (other$homeBlockLists != null) {
                return false;
            }
        } else if (!this$homeBlockLists.equals(other$homeBlockLists)) {
            return false;
        }
        Object this$bornPos = getBornPos();
        Object other$bornPos = other.getBornPos();
        if (this$bornPos == null) {
            if (other$bornPos != null) {
                return false;
            }
        } else if (!this$bornPos.equals(other$bornPos)) {
            return false;
        }
        Object this$bornRot = getBornRot();
        Object other$bornRot = other.getBornRot();
        if (this$bornRot == null) {
            if (other$bornRot != null) {
                return false;
            }
        } else if (!this$bornRot.equals(other$bornRot)) {
            return false;
        }
        Object this$djinPos = getDjinPos();
        Object other$djinPos = other.getDjinPos();
        if (this$djinPos == null) {
            if (other$djinPos != null) {
                return false;
            }
        } else if (!this$djinPos.equals(other$djinPos)) {
            return false;
        }
        Object this$mainhouse = getMainhouse();
        Object other$mainhouse = other.getMainhouse();
        if (this$mainhouse == null) {
            if (other$mainhouse != null) {
                return false;
            }
        } else if (!this$mainhouse.equals(other$mainhouse)) {
            return false;
        }
        Object this$doorLists = getDoorLists();
        Object other$doorLists = other.getDoorLists();
        if (this$doorLists == null) {
            if (other$doorLists != null) {
                return false;
            }
        } else if (!this$doorLists.equals(other$doorLists)) {
            return false;
        }
        Object this$stairLists = getStairLists();
        Object other$stairLists = other.getStairLists();
        return this$stairLists == null ? other$stairLists == null : this$stairLists.equals(other$stairLists);
    }

    protected boolean canEqual(Object other) {
        return other instanceof HomeworldDefaultSaveData;
    }

    public int hashCode() {
        Object $homeBlockLists = getHomeBlockLists();
        int result = (1 * 59) + ($homeBlockLists == null ? 43 : $homeBlockLists.hashCode());
        Object $bornPos = getBornPos();
        int result2 = (result * 59) + ($bornPos == null ? 43 : $bornPos.hashCode());
        Object $bornRot = getBornRot();
        int result3 = (result2 * 59) + ($bornRot == null ? 43 : $bornRot.hashCode());
        Object $djinPos = getDjinPos();
        int result4 = (result3 * 59) + ($djinPos == null ? 43 : $djinPos.hashCode());
        Object $mainhouse = getMainhouse();
        int result5 = (result4 * 59) + ($mainhouse == null ? 43 : $mainhouse.hashCode());
        Object $doorLists = getDoorLists();
        int result6 = (result5 * 59) + ($doorLists == null ? 43 : $doorLists.hashCode());
        Object $stairLists = getStairLists();
        return (result6 * 59) + ($stairLists == null ? 43 : $stairLists.hashCode());
    }

    public List<HomeBlock> getHomeBlockLists() {
        return this.homeBlockLists;
    }

    public Position getBornPos() {
        return this.bornPos;
    }

    public Position getBornRot() {
        return this.bornRot;
    }

    public Position getDjinPos() {
        return this.djinPos;
    }

    public HomeFurniture getMainhouse() {
        return this.mainhouse;
    }

    public List<HomeFurniture> getDoorLists() {
        return this.doorLists;
    }

    public List<HomeFurniture> getStairLists() {
        return this.stairLists;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/HomeworldDefaultSaveData$HomeBlock.class */
    public static class HomeBlock {
        @SerializedName(value = "FGIJCELCGFI", alternate = {"PGDPDIDJEEL"})
        private int blockId;
        @SerializedName("BEAPOFELABD")
        private List<HomeFurniture> furnitures;
        @SerializedName("MLIODLGDFHJ")
        private List<HomeFurniture> persistentFurnitures;

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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.data.binout.HomeworldDefaultSaveData.HomeBlock.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeBlock(blockId=, furnitures=, persistentFurnitures=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeBlock(blockId=, furnitures=, persistentFurnitures=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.getBlockId()
                r1 = r4
                java.util.List r1 = r1.getFurnitures()
                r2 = r4
                java.util.List r2 = r2.getPersistentFurnitures()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeBlock(blockId=, furnitures=, persistentFurnitures=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.HomeworldDefaultSaveData.HomeBlock.toString():java.lang.String");
        }

        public void setBlockId(int blockId) {
            this.blockId = blockId;
        }

        public void setFurnitures(List<HomeFurniture> furnitures) {
            this.furnitures = furnitures;
        }

        public void setPersistentFurnitures(List<HomeFurniture> persistentFurnitures) {
            this.persistentFurnitures = persistentFurnitures;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof HomeBlock)) {
                return false;
            }
            HomeBlock other = (HomeBlock) o;
            if (!other.canEqual(this) || getBlockId() != other.getBlockId()) {
                return false;
            }
            Object this$furnitures = getFurnitures();
            Object other$furnitures = other.getFurnitures();
            if (this$furnitures == null) {
                if (other$furnitures != null) {
                    return false;
                }
            } else if (!this$furnitures.equals(other$furnitures)) {
                return false;
            }
            Object this$persistentFurnitures = getPersistentFurnitures();
            Object other$persistentFurnitures = other.getPersistentFurnitures();
            return this$persistentFurnitures == null ? other$persistentFurnitures == null : this$persistentFurnitures.equals(other$persistentFurnitures);
        }

        protected boolean canEqual(Object other) {
            return other instanceof HomeBlock;
        }

        public int hashCode() {
            int result = (1 * 59) + getBlockId();
            Object $furnitures = getFurnitures();
            int result2 = (result * 59) + ($furnitures == null ? 43 : $furnitures.hashCode());
            Object $persistentFurnitures = getPersistentFurnitures();
            return (result2 * 59) + ($persistentFurnitures == null ? 43 : $persistentFurnitures.hashCode());
        }

        public int getBlockId() {
            return this.blockId;
        }

        public List<HomeFurniture> getFurnitures() {
            return this.furnitures;
        }

        public List<HomeFurniture> getPersistentFurnitures() {
            return this.persistentFurnitures;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/data/binout/HomeworldDefaultSaveData$HomeFurniture.class */
    public static class HomeFurniture {
        @SerializedName(value = "ENHNGKJBJAB", alternate = {"KMAAJJHPNBA"})

        /* renamed from: id */
        private int f500id;
        @SerializedName(value = "NGIEEIOLPPO", alternate = {"JFKAHNCPDME"})
        private Position pos;
        private Position rot;

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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.data.binout.HomeworldDefaultSaveData.HomeFurniture.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeFurniture(id=, pos=, rot=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeFurniture(id=, pos=, rot=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.getId()
                r1 = r4
                emu.grasscutter.utils.Position r1 = r1.getPos()
                r2 = r4
                emu.grasscutter.utils.Position r2 = r2.getRot()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;)Ljava/lang/String;}, HomeworldDefaultSaveData.HomeFurniture(id=, pos=, rot=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.HomeworldDefaultSaveData.HomeFurniture.toString():java.lang.String");
        }

        public void setId(int id) {
            this.f500id = id;
        }

        public void setPos(Position pos) {
            this.pos = pos;
        }

        public void setRot(Position rot) {
            this.rot = rot;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof HomeFurniture)) {
                return false;
            }
            HomeFurniture other = (HomeFurniture) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            Object this$pos = getPos();
            Object other$pos = other.getPos();
            if (this$pos == null) {
                if (other$pos != null) {
                    return false;
                }
            } else if (!this$pos.equals(other$pos)) {
                return false;
            }
            Object this$rot = getRot();
            Object other$rot = other.getRot();
            return this$rot == null ? other$rot == null : this$rot.equals(other$rot);
        }

        protected boolean canEqual(Object other) {
            return other instanceof HomeFurniture;
        }

        public int hashCode() {
            int result = (1 * 59) + getId();
            Object $pos = getPos();
            int result2 = (result * 59) + ($pos == null ? 43 : $pos.hashCode());
            Object $rot = getRot();
            return (result2 * 59) + ($rot == null ? 43 : $rot.hashCode());
        }

        public int getId() {
            return this.f500id;
        }

        public Position getPos() {
            return this.pos;
        }

        public Position getRot() {
            return this.rot;
        }
    }
}
