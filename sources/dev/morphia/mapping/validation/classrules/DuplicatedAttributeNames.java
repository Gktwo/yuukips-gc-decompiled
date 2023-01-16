package dev.morphia.mapping.validation.classrules;

import dev.morphia.mapping.validation.ClassConstraint;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/classrules/DuplicatedAttributeNames.class */
public class DuplicatedAttributeNames implements ClassConstraint {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0069: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0069: INVOKE_CUSTOM r7, method: dev.morphia.mapping.validation.classrules.DuplicatedAttributeNames.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Mapping to MongoDB field name '' is duplicated; you cannot map different java fields to the same MongoDB field.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Mapping to MongoDB field name '' is duplicated; you cannot map different java fields to the same MongoDB field.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.mapping.validation.ClassConstraint
    public void check(dev.morphia.mapping.Mapper r10, dev.morphia.mapping.codec.pojo.EntityModel r11, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation> r12) {
        /*
            r9 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r1 = r0
            r1.<init>()
            r13 = r0
            r0 = r11
            java.util.List r0 = r0.getProperties()
            java.util.Iterator r0 = r0.iterator()
            r14 = r0
            r0 = r14
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x007d
            r0 = r14
            java.lang.Object r0 = r0.next()
            dev.morphia.mapping.codec.pojo.PropertyModel r0 = (dev.morphia.mapping.codec.pojo.PropertyModel) r0
            r15 = r0
            r0 = r15
            java.util.List r0 = r0.getLoadNames()
            java.util.Iterator r0 = r0.iterator()
            r16 = r0
            r0 = r16
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x007a
            r0 = r16
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r17 = r0
            r0 = r13
            r1 = r17
            boolean r0 = r0.add(r1)
            if (r0 != 0) goto L_0x0077
            r0 = r12
            dev.morphia.mapping.validation.ConstraintViolation r1 = new dev.morphia.mapping.validation.ConstraintViolation
            r2 = r1
            dev.morphia.mapping.validation.ConstraintViolation$Level r3 = dev.morphia.mapping.validation.ConstraintViolation.Level.FATAL
            r4 = r11
            r5 = r15
            r6 = r9
            java.lang.Class r6 = r6.getClass()
            r7 = r17
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Mapping to MongoDB field name '' is duplicated; you cannot map different java fields to the same MongoDB field.]}
            r2.<init>(r3, r4, r5, r6, r7)
            boolean r0 = r0.add(r1)
            goto L_0x0036
            goto L_0x0014
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.validation.classrules.DuplicatedAttributeNames.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, java.util.Set):void");
    }
}
