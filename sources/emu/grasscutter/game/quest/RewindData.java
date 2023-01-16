package emu.grasscutter.game.quest;

import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/quest/RewindData.class */
public class RewindData {
    AvatarData avatar;
    List<Npc> npcs;

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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.game.quest.RewindData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/RewindData$AvatarData;, Ljava/util/List;)Ljava/lang/String;}, RewindData(avatar=, npcs=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/RewindData$AvatarData;, Ljava/util/List;)Ljava/lang/String;}, RewindData(avatar=, npcs=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = r3
            emu.grasscutter.game.quest.RewindData$AvatarData r0 = r0.getAvatar()
            r1 = r3
            java.util.List r1 = r1.getNpcs()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/game/quest/RewindData$AvatarData;, Ljava/util/List;)Ljava/lang/String;}, RewindData(avatar=, npcs=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.RewindData.toString():java.lang.String");
    }

    public void setAvatar(AvatarData avatar) {
        this.avatar = avatar;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RewindData)) {
            return false;
        }
        RewindData other = (RewindData) o;
        if (!other.canEqual(this)) {
            return false;
        }
        Object this$avatar = getAvatar();
        Object other$avatar = other.getAvatar();
        if (this$avatar == null) {
            if (other$avatar != null) {
                return false;
            }
        } else if (!this$avatar.equals(other$avatar)) {
            return false;
        }
        Object this$npcs = getNpcs();
        Object other$npcs = other.getNpcs();
        return this$npcs == null ? other$npcs == null : this$npcs.equals(other$npcs);
    }

    protected boolean canEqual(Object other) {
        return other instanceof RewindData;
    }

    public int hashCode() {
        Object $avatar = getAvatar();
        int result = (1 * 59) + ($avatar == null ? 43 : $avatar.hashCode());
        Object $npcs = getNpcs();
        return (result * 59) + ($npcs == null ? 43 : $npcs.hashCode());
    }

    public AvatarData getAvatar() {
        return this.avatar;
    }

    public List<Npc> getNpcs() {
        return this.npcs;
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/quest/RewindData$AvatarData.class */
    public static class AvatarData {
        private String pos;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0004: INVOKE_CUSTOM r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0004: INVOKE_CUSTOM r0, method: emu.grasscutter.game.quest.RewindData.AvatarData.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RewindData.AvatarData(pos=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RewindData.AvatarData(pos=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r2 = this;
                r0 = r2
                java.lang.String r0 = r0.getPos()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, RewindData.AvatarData(pos=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.RewindData.AvatarData.toString():java.lang.String");
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AvatarData)) {
                return false;
            }
            AvatarData other = (AvatarData) o;
            if (!other.canEqual(this)) {
                return false;
            }
            Object this$pos = getPos();
            Object other$pos = other.getPos();
            return this$pos == null ? other$pos == null : this$pos.equals(other$pos);
        }

        protected boolean canEqual(Object other) {
            return other instanceof AvatarData;
        }

        public int hashCode() {
            Object $pos = getPos();
            return (1 * 59) + ($pos == null ? 43 : $pos.hashCode());
        }

        public String getPos() {
            return this.pos;
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/quest/RewindData$Npc.class */
    public static class Npc {
        private String script;
        private int room_id;
        private int data_index;

        /* renamed from: id */
        private int f592id;
        private String pos;
        private int scene_id;
        private String alias;

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
        /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.game.quest.RewindData.Npc.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, RewindData.Npc(script=, room_id=, data_index=, id=, pos=, scene_id=, alias=)]}
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
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, RewindData.Npc(script=, room_id=, data_index=, id=, pos=, scene_id=, alias=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r8 = this;
                r0 = r8
                java.lang.String r0 = r0.getScript()
                r1 = r8
                int r1 = r1.getRoom_id()
                r2 = r8
                int r2 = r2.getData_index()
                r3 = r8
                int r3 = r3.getId()
                r4 = r8
                java.lang.String r4 = r4.getPos()
                r5 = r8
                int r5 = r5.getScene_id()
                r6 = r8
                java.lang.String r6 = r6.getAlias()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, I, I, I, Ljava/lang/String;, I, Ljava/lang/String;)Ljava/lang/String;}, RewindData.Npc(script=, room_id=, data_index=, id=, pos=, scene_id=, alias=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.quest.RewindData.Npc.toString():java.lang.String");
        }

        public void setScript(String script) {
            this.script = script;
        }

        public void setRoom_id(int room_id) {
            this.room_id = room_id;
        }

        public void setData_index(int data_index) {
            this.data_index = data_index;
        }

        public void setId(int id) {
            this.f592id = id;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }

        public void setScene_id(int scene_id) {
            this.scene_id = scene_id;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Npc)) {
                return false;
            }
            Npc other = (Npc) o;
            if (!other.canEqual(this) || getRoom_id() != other.getRoom_id() || getData_index() != other.getData_index() || getId() != other.getId() || getScene_id() != other.getScene_id()) {
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
            if (this$pos == null) {
                if (other$pos != null) {
                    return false;
                }
            } else if (!this$pos.equals(other$pos)) {
                return false;
            }
            Object this$alias = getAlias();
            Object other$alias = other.getAlias();
            return this$alias == null ? other$alias == null : this$alias.equals(other$alias);
        }

        protected boolean canEqual(Object other) {
            return other instanceof Npc;
        }

        public int hashCode() {
            int result = (((((((1 * 59) + getRoom_id()) * 59) + getData_index()) * 59) + getId()) * 59) + getScene_id();
            Object $script = getScript();
            int result2 = (result * 59) + ($script == null ? 43 : $script.hashCode());
            Object $pos = getPos();
            int result3 = (result2 * 59) + ($pos == null ? 43 : $pos.hashCode());
            Object $alias = getAlias();
            return (result3 * 59) + ($alias == null ? 43 : $alias.hashCode());
        }

        public String getScript() {
            return this.script;
        }

        public int getRoom_id() {
            return this.room_id;
        }

        public int getData_index() {
            return this.data_index;
        }

        public int getId() {
            return this.f592id;
        }

        public String getPos() {
            return this.pos;
        }

        public int getScene_id() {
            return this.scene_id;
        }

        public String getAlias() {
            return this.alias;
        }
    }
}
