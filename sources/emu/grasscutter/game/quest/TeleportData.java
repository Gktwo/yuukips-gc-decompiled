package emu.grasscutter.game.quest;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/TeleportData.class */
public class TeleportData {
    List<TransmitPoint> transmit_points;
    List<Npc> npcs;
    List<Gadget> gadgets;

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
    /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.quest.TeleportData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, TeleportData(transmit_points=, npcs=, gadgets=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, TeleportData(transmit_points=, npcs=, gadgets=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            java.util.List r0 = r0.getTransmit_points()
            r1 = r4
            java.util.List r1 = r1.getNpcs()
            r2 = r4
            java.util.List r2 = r2.getGadgets()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, Ljava/util/List;, Ljava/util/List;)Ljava/lang/String;}, TeleportData(transmit_points=, npcs=, gadgets=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.TeleportData.toString():java.lang.String");
    }

    public void setTransmit_points(List<TransmitPoint> transmit_points) {
        this.transmit_points = transmit_points;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof TeleportData)) {
            return false;
        }
        TeleportData other = (TeleportData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$transmit_points = getTransmit_points();
        Object other$transmit_points = other.getTransmit_points();
        if (this$transmit_points == null) {
            if (other$transmit_points != null) {
                return false;
            }
        } else if (!this$transmit_points.equals(other$transmit_points)) {
            return false;
        }
        Object this$npcs = getNpcs();
        Object other$npcs = other.getNpcs();
        if (this$npcs == null) {
            if (other$npcs != null) {
                return false;
            }
        } else if (!this$npcs.equals(other$npcs)) {
            return false;
        }
        Object this$gadgets = getGadgets();
        Object other$gadgets = other.getGadgets();
        return this$gadgets == null ? other$gadgets == null : this$gadgets.equals(other$gadgets);
    }

    protected boolean canEqual(Object other) {
        return other instanceof TeleportData;
    }

    public int hashCode() {
        Object $transmit_points = getTransmit_points();
        int result = (1 * 59) + ($transmit_points == null ? 43 : $transmit_points.hashCode());
        Object $npcs = getNpcs();
        int result2 = (result * 59) + ($npcs == null ? 43 : $npcs.hashCode());
        Object $gadgets = getGadgets();
        return (result2 * 59) + ($gadgets == null ? 43 : $gadgets.hashCode());
    }

    public List<TransmitPoint> getTransmit_points() {
        return this.transmit_points;
    }

    public List<Npc> getNpcs() {
        return this.npcs;
    }

    public List<Gadget> getGadgets() {
        return this.gadgets;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/quest/TeleportData$TransmitPoint.class */
    public static class TransmitPoint {
        private int point_id;
        private int scene_id;
        private String pos;

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
        /*  JADX ERROR: Failed to decode insn: 0x000C: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.game.quest.TeleportData.TransmitPoint.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.TransmitPoint(point_id=, scene_id=, pos=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.TransmitPoint(point_id=, scene_id=, pos=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.getPoint_id()
                r1 = r4
                int r1 = r1.getScene_id()
                r2 = r4
                java.lang.String r2 = r2.getPos()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.TransmitPoint(point_id=, scene_id=, pos=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.TeleportData.TransmitPoint.toString():java.lang.String");
        }

        public void setPoint_id(int point_id) {
            this.point_id = point_id;
        }

        public void setScene_id(int scene_id) {
            this.scene_id = scene_id;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TransmitPoint)) {
                return false;
            }
            TransmitPoint other = (TransmitPoint) o;
            if (!other.canEqual(this) || getPoint_id() != other.getPoint_id() || getScene_id() != other.getScene_id()) {
                return false;
            }
            Object this$pos = getPos();
            Object other$pos = other.getPos();
            return this$pos == null ? other$pos == null : this$pos.equals(other$pos);
        }

        protected boolean canEqual(Object other) {
            return other instanceof TransmitPoint;
        }

        public int hashCode() {
            int result = (((1 * 59) + getPoint_id()) * 59) + getScene_id();
            Object $pos = getPos();
            return (result * 59) + ($pos == null ? 43 : $pos.hashCode());
        }

        public int getPoint_id() {
            return this.point_id;
        }

        public int getScene_id() {
            return this.scene_id;
        }

        public String getPos() {
            return this.pos;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/quest/TeleportData$Npc.class */
    public static class Npc {
        private int data_index;
        private int room_id;
        private int scene_id;

        /* renamed from: id */
        private int f594id;
        private String alias;
        private String script;
        private String pos;

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
        /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.quest.TeleportData.Npc.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Npc(data_index=, room_id=, scene_id=, id=, alias=, script=, pos=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Npc(data_index=, room_id=, scene_id=, id=, alias=, script=, pos=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r8 = this;
                r0 = r8
                int r0 = r0.getData_index()
                r1 = r8
                int r1 = r1.getRoom_id()
                r2 = r8
                int r2 = r2.getScene_id()
                r3 = r8
                int r3 = r3.getId()
                r4 = r8
                java.lang.String r4 = r4.getAlias()
                r5 = r8
                java.lang.String r5 = r5.getScript()
                r6 = r8
                java.lang.String r6 = r6.getPos()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I, I, I, Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Npc(data_index=, room_id=, scene_id=, id=, alias=, script=, pos=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.TeleportData.Npc.toString():java.lang.String");
        }

        public void setData_index(int data_index) {
            this.data_index = data_index;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public void setScene_id(int scene_id) {
            this.scene_id = scene_id;
        }

        public void setId(int id) {
            this.f594id = id;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public void setScript(String script) {
            this.script = script;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Npc)) {
                return false;
            }
            Npc other = (Npc) o;
            if (!other.canEqual(this) || getData_index() != other.getData_index() || getRoom_id() != other.getRoom_id() || getScene_id() != other.getScene_id() || getId() != other.getId()) {
                return false;
            }
            Object this$alias = getAlias();
            Object other$alias = other.getAlias();
            if (this$alias == null) {
                if (other$alias != null) {
                    return false;
                }
            } else if (!this$alias.equals(other$alias)) {
                return false;
            }
            Object this$script = getScript();
            Object other$script = other.getScript();
            if (this$script == null) {
                if (other$script != null) {
                    return false;
                }
            } else if (!this$script.equals(other$script)) {
                return false;
            }
            Object this$pos = getPos();
            Object other$pos = other.getPos();
            return this$pos == null ? other$pos == null : this$pos.equals(other$pos);
        }

        protected boolean canEqual(Object other) {
            return other instanceof Npc;
        }

        public int hashCode() {
            int result = (((((((1 * 59) + getData_index()) * 59) + getRoom_id()) * 59) + getScene_id()) * 59) + getId();
            Object $alias = getAlias();
            int result2 = (result * 59) + ($alias == null ? 43 : $alias.hashCode());
            Object $script = getScript();
            int result3 = (result2 * 59) + ($script == null ? 43 : $script.hashCode());
            Object $pos = getPos();
            return (result3 * 59) + ($pos == null ? 43 : $pos.hashCode());
        }

        public int getData_index() {
            return this.data_index;
        }

        public int getRoom_id() {
            return this.room_id;
        }

        public int getScene_id() {
            return this.scene_id;
        }

        public int getId() {
            return this.f594id;
        }

        public String getAlias() {
            return this.alias;
        }

        public String getScript() {
            return this.script;
        }

        public String getPos() {
            return this.pos;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/quest/TeleportData$Gadget.class */
    public static class Gadget {

        /* renamed from: id */
        private int f593id;
        private String pos;

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
        /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.quest.TeleportData.Gadget.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Gadget(id=, pos=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Gadget(id=, pos=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r3 = this;
                r0 = r3
                int r0 = r0.getId()
                r1 = r3
                java.lang.String r1 = r1.getPos()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, TeleportData.Gadget(id=, pos=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.TeleportData.Gadget.toString():java.lang.String");
        }

        public void setId(int id) {
            this.f593id = id;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Gadget)) {
                return false;
            }
            Gadget other = (Gadget) o;
            if (!other.canEqual(this) || getId() != other.getId()) {
                return false;
            }
            Object this$pos = getPos();
            Object other$pos = other.getPos();
            return this$pos == null ? other$pos == null : this$pos.equals(other$pos);
        }

        protected boolean canEqual(Object other) {
            return other instanceof Gadget;
        }

        public int hashCode() {
            int result = (1 * 59) + getId();
            Object $pos = getPos();
            return (result * 59) + ($pos == null ? 43 : $pos.hashCode());
        }

        public int getId() {
            return this.f593id;
        }

        public String getPos() {
            return this.pos;
        }
    }
}
