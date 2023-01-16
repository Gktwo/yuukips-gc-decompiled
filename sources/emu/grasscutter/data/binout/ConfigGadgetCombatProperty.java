package emu.grasscutter.data.binout;

import com.google.gson.annotations.SerializedName;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/ConfigGadgetCombatProperty.class */
public class ConfigGadgetCombatProperty {
    @SerializedName(value = "HP", alternate = {"CMBBAPKBDCI"})

    /* renamed from: HP */
    private float f499HP;
    private boolean isLockHP;
    private boolean isInvincible;
    private boolean isGhostToAllied;
    private float attack;
    private float defence;
    private float weight;
    private boolean useCreatorProperty;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.data.binout.ConfigGadgetCombatProperty.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, Z, Z, Z, F, F, F, Z)Ljava/lang/String;}, ConfigGadgetCombatProperty(HP=, isLockHP=, isInvincible=, isGhostToAllied=, attack=, defence=, weight=, useCreatorProperty=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, Z, Z, Z, F, F, F, Z)Ljava/lang/String;}, ConfigGadgetCombatProperty(HP=, isLockHP=, isInvincible=, isGhostToAllied=, attack=, defence=, weight=, useCreatorProperty=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r9 = this;
            r0 = r9
            float r0 = r0.getHP()
            r1 = r9
            boolean r1 = r1.isLockHP()
            r2 = r9
            boolean r2 = r2.isInvincible()
            r3 = r9
            boolean r3 = r3.isGhostToAllied()
            r4 = r9
            float r4 = r4.getAttack()
            r5 = r9
            float r5 = r5.getDefence()
            r6 = r9
            float r6 = r6.getWeight()
            r7 = r9
            boolean r7 = r7.isUseCreatorProperty()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (F, Z, Z, Z, F, F, F, Z)Ljava/lang/String;}, ConfigGadgetCombatProperty(HP=, isLockHP=, isInvincible=, isGhostToAllied=, attack=, defence=, weight=, useCreatorProperty=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.ConfigGadgetCombatProperty.toString():java.lang.String");
    }

    public void setHP(float HP) {
        this.f499HP = HP;
    }

    public void setLockHP(boolean isLockHP) {
        this.isLockHP = isLockHP;
    }

    public void setInvincible(boolean isInvincible) {
        this.isInvincible = isInvincible;
    }

    public void setGhostToAllied(boolean isGhostToAllied) {
        this.isGhostToAllied = isGhostToAllied;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public void setDefence(float defence) {
        this.defence = defence;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setUseCreatorProperty(boolean useCreatorProperty) {
        this.useCreatorProperty = useCreatorProperty;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ConfigGadgetCombatProperty)) {
            return false;
        }
        ConfigGadgetCombatProperty other = (ConfigGadgetCombatProperty) o;
        return other.canEqual(this) && Float.compare(getHP(), other.getHP()) == 0 && isLockHP() == other.isLockHP() && isInvincible() == other.isInvincible() && isGhostToAllied() == other.isGhostToAllied() && Float.compare(getAttack(), other.getAttack()) == 0 && Float.compare(getDefence(), other.getDefence()) == 0 && Float.compare(getWeight(), other.getWeight()) == 0 && isUseCreatorProperty() == other.isUseCreatorProperty();
    }

    protected boolean canEqual(Object other) {
        return other instanceof ConfigGadgetCombatProperty;
    }

    public int hashCode() {
        return (((((((((((((((1 * 59) + Float.floatToIntBits(getHP())) * 59) + (isLockHP() ? 79 : 97)) * 59) + (isInvincible() ? 79 : 97)) * 59) + (isGhostToAllied() ? 79 : 97)) * 59) + Float.floatToIntBits(getAttack())) * 59) + Float.floatToIntBits(getDefence())) * 59) + Float.floatToIntBits(getWeight())) * 59) + (isUseCreatorProperty() ? 79 : 97);
    }

    public float getHP() {
        return this.f499HP;
    }

    public boolean isLockHP() {
        return this.isLockHP;
    }

    public boolean isInvincible() {
        return this.isInvincible;
    }

    public boolean isGhostToAllied() {
        return this.isGhostToAllied;
    }

    public float getAttack() {
        return this.attack;
    }

    public float getDefence() {
        return this.defence;
    }

    public float getWeight() {
        return this.weight;
    }

    public boolean isUseCreatorProperty() {
        return this.useCreatorProperty;
    }
}
