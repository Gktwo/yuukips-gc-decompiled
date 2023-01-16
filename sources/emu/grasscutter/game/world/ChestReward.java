package emu.grasscutter.game.world;

import emu.grasscutter.game.inventory.ItemDef;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/world/ChestReward.class */
public class ChestReward {
    private List<String> objNames;
    private int advExp;
    private int resin;
    private int mora;
    private int sigil;
    private int primogem;
    private List<ItemDef> content;
    private int randomCount;
    private List<ItemDef> randomContent;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, method: emu.grasscutter.game.world.ChestReward.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, I, I, I, I, I, Ljava/util/List;, I, Ljava/util/List;)Ljava/lang/String;}, ChestReward(objNames=, advExp=, resin=, mora=, sigil=, primogem=, content=, randomCount=, randomContent=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, I, I, I, I, I, Ljava/util/List;, I, Ljava/util/List;)Ljava/lang/String;}, ChestReward(objNames=, advExp=, resin=, mora=, sigil=, primogem=, content=, randomCount=, randomContent=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r10 = this;
            r0 = r10
            java.util.List r0 = r0.getObjNames()
            r1 = r10
            int r1 = r1.getAdvExp()
            r2 = r10
            int r2 = r2.getResin()
            r3 = r10
            int r3 = r3.getMora()
            r4 = r10
            int r4 = r4.getSigil()
            r5 = r10
            int r5 = r5.getPrimogem()
            r6 = r10
            java.util.List r6 = r6.getContent()
            r7 = r10
            int r7 = r7.getRandomCount()
            r8 = r10
            java.util.List r8 = r8.getRandomContent()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;, I, I, I, I, I, Ljava/util/List;, I, Ljava/util/List;)Ljava/lang/String;}, ChestReward(objNames=, advExp=, resin=, mora=, sigil=, primogem=, content=, randomCount=, randomContent=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.world.ChestReward.toString():java.lang.String");
    }

    public void setObjNames(List<String> objNames) {
        this.objNames = objNames;
    }

    public void setAdvExp(int advExp) {
        this.advExp = advExp;
    }

    public void setResin(int resin) {
        this.resin = resin;
    }

    public void setMora(int mora) {
        this.mora = mora;
    }

    public void setSigil(int sigil) {
        this.sigil = sigil;
    }

    public void setPrimogem(int primogem) {
        this.primogem = primogem;
    }

    public void setContent(List<ItemDef> content) {
        this.content = content;
    }

    public void setRandomCount(int randomCount) {
        this.randomCount = randomCount;
    }

    public void setRandomContent(List<ItemDef> randomContent) {
        this.randomContent = randomContent;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ChestReward)) {
            return false;
        }
        ChestReward other = (ChestReward) o;
        if (!other.canEqual(this) || getAdvExp() != other.getAdvExp() || getResin() != other.getResin() || getMora() != other.getMora() || getSigil() != other.getSigil() || getPrimogem() != other.getPrimogem() || getRandomCount() != other.getRandomCount()) {
            return false;
        }
        Object this$objNames = getObjNames();
        Object other$objNames = other.getObjNames();
        if (this$objNames == null) {
            if (other$objNames != null) {
                return false;
            }
        } else if (!this$objNames.equals(other$objNames)) {
            return false;
        }
        Object this$content = getContent();
        Object other$content = other.getContent();
        if (this$content == null) {
            if (other$content != null) {
                return false;
            }
        } else if (!this$content.equals(other$content)) {
            return false;
        }
        Object this$randomContent = getRandomContent();
        Object other$randomContent = other.getRandomContent();
        return this$randomContent == null ? other$randomContent == null : this$randomContent.equals(other$randomContent);
    }

    protected boolean canEqual(Object other) {
        return other instanceof ChestReward;
    }

    public int hashCode() {
        int result = (((((((((((1 * 59) + getAdvExp()) * 59) + getResin()) * 59) + getMora()) * 59) + getSigil()) * 59) + getPrimogem()) * 59) + getRandomCount();
        Object $objNames = getObjNames();
        int result2 = (result * 59) + ($objNames == null ? 43 : $objNames.hashCode());
        Object $content = getContent();
        int result3 = (result2 * 59) + ($content == null ? 43 : $content.hashCode());
        Object $randomContent = getRandomContent();
        return (result3 * 59) + ($randomContent == null ? 43 : $randomContent.hashCode());
    }

    public List<String> getObjNames() {
        return this.objNames;
    }

    public int getAdvExp() {
        return this.advExp;
    }

    public int getResin() {
        return this.resin;
    }

    public int getMora() {
        return this.mora;
    }

    public int getSigil() {
        return this.sigil;
    }

    public int getPrimogem() {
        return this.primogem;
    }

    public List<ItemDef> getContent() {
        return this.content;
    }

    public int getRandomCount() {
        return this.randomCount;
    }

    public List<ItemDef> getRandomContent() {
        return this.randomContent;
    }
}
