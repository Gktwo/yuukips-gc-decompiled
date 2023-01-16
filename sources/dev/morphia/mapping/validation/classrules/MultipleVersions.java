package dev.morphia.mapping.validation.classrules;

import dev.morphia.mapping.validation.ClassConstraint;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/MultipleVersions.class */
public class MultipleVersions implements ClassConstraint {
    /*  JADX ERROR: Dependency scan failed at insn: 0x002B: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x002B: INVOKE_CUSTOM r6, r7, method: dev.morphia.mapping.validation.classrules.MultipleVersions.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;, Ldev/morphia/mapping/validation/classrules/FieldEnumString;)Ljava/lang/String;}, Multiple @ annotations are not allowed. (]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;, Ldev/morphia/mapping/validation/classrules/FieldEnumString;)Ljava/lang/String;}, Multiple @ annotations are not allowed. (]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.mapping.validation.ClassConstraint
    public void check(dev.morphia.mapping.Mapper r12, dev.morphia.mapping.codec.pojo.EntityModel r13, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation> r14) {
        /*
            r11 = this;
            r0 = r13
            java.lang.Class<dev.morphia.annotations.Version> r1 = dev.morphia.annotations.Version.class
            java.util.List r0 = r0.getProperties(r1)
            r15 = r0
            r0 = r15
            int r0 = r0.size()
            r1 = 1
            if (r0 <= r1) goto L_0x0039
            r0 = r14
            dev.morphia.mapping.validation.ConstraintViolation r1 = new dev.morphia.mapping.validation.ConstraintViolation
            r2 = r1
            dev.morphia.mapping.validation.ConstraintViolation$Level r3 = dev.morphia.mapping.validation.ConstraintViolation.Level.FATAL
            r4 = r13
            r5 = r11
            java.lang.Class r5 = r5.getClass()
            java.lang.Class<dev.morphia.annotations.Version> r6 = dev.morphia.annotations.Version.class
            dev.morphia.mapping.validation.classrules.FieldEnumString r7 = new dev.morphia.mapping.validation.classrules.FieldEnumString
            r8 = r7
            r9 = r15
            r8.<init>(r9)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;, Ldev/morphia/mapping/validation/classrules/FieldEnumString;)Ljava/lang/String;}, Multiple @ annotations are not allowed. (]}
            r2.<init>(r3, r4, r5, r6)
            boolean r0 = r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.validation.classrules.MultipleVersions.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, java.util.Set):void");
    }
}
