package dev.morphia.mapping.validation.fieldrules;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/fieldrules/MapKeyTypeConstraint.class */
public class MapKeyTypeConstraint extends PropertyConstraint {
    private static final String SUPPORTED = "(Map<String/Enum/Long/ObjectId/..., ?>)";

    /*  JADX ERROR: Dependency scan failed at insn: 0x008B: INVOKE_CUSTOM r-9
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
    /*  JADX ERROR: Failed to decode insn: 0x008B: INVOKE_CUSTOM r7, method: dev.morphia.mapping.validation.fieldrules.MapKeyTypeConstraint.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, dev.morphia.mapping.codec.pojo.PropertyModel, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation>):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;)Ljava/lang/String;}, Maps must be keyed by a simple type (Map<String/Enum/Long/ObjectId/..., ?>);  is not supported as a map key type.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;)Ljava/lang/String;}, Maps must be keyed by a simple type (Map<String/Enum/Long/ObjectId/..., ?>);  is not supported as a map key type.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.mapping.validation.fieldrules.PropertyConstraint
    protected void check(dev.morphia.mapping.Mapper r10, dev.morphia.mapping.codec.pojo.EntityModel r11, dev.morphia.mapping.codec.pojo.PropertyModel r12, java.util.Set<dev.morphia.mapping.validation.ConstraintViolation> r13) {
        /*
            r9 = this;
            r0 = r12
            boolean r0 = r0.isMap()
            if (r0 == 0) goto L_0x0099
            r0 = 0
            r14 = r0
            r0 = r12
            dev.morphia.mapping.codec.pojo.TypeData r0 = r0.getTypeData()
            java.util.List r0 = r0.getTypeParameters()
            r15 = r0
            r0 = r15
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0031
            r0 = r15
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            dev.morphia.mapping.codec.pojo.TypeData r0 = (dev.morphia.mapping.codec.pojo.TypeData) r0
            r16 = r0
            r0 = r16
            java.lang.Class r0 = r0.getType()
            r14 = r0
            r0 = r14
            if (r0 == 0) goto L_0x0040
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r1 = r14
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x005d
            r0 = r13
            dev.morphia.mapping.validation.ConstraintViolation r1 = new dev.morphia.mapping.validation.ConstraintViolation
            r2 = r1
            dev.morphia.mapping.validation.ConstraintViolation$Level r3 = dev.morphia.mapping.validation.ConstraintViolation.Level.WARNING
            r4 = r11
            r5 = r12
            r6 = r9
            java.lang.Class r6 = r6.getClass()
            java.lang.String r7 = "Maps cannot be keyed by Object (Map<Object,?>); Use a parametrized type that is supported (Map<String/Enum/Long/ObjectId/..., ?>)"
            r2.<init>(r3, r4, r5, r6, r7)
            boolean r0 = r0.add(r1)
            goto L_0x0099
            r0 = r14
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0099
            r0 = r14
            java.lang.Class<org.bson.types.ObjectId> r1 = org.bson.types.ObjectId.class
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0099
            r0 = r9
            r1 = r14
            boolean r0 = r0.isPrimitiveLike(r1)
            if (r0 != 0) goto L_0x0099
            r0 = r13
            dev.morphia.mapping.validation.ConstraintViolation r1 = new dev.morphia.mapping.validation.ConstraintViolation
            r2 = r1
            dev.morphia.mapping.validation.ConstraintViolation$Level r3 = dev.morphia.mapping.validation.ConstraintViolation.Level.FATAL
            r4 = r11
            r5 = r12
            r6 = r9
            java.lang.Class r6 = r6.getClass()
            r7 = r14
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Class;)Ljava/lang/String;}, Maps must be keyed by a simple type (Map<String/Enum/Long/ObjectId/..., ?>);  is not supported as a map key type.]}
            r2.<init>(r3, r4, r5, r6, r7)
            boolean r0 = r0.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.validation.fieldrules.MapKeyTypeConstraint.check(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.pojo.EntityModel, dev.morphia.mapping.codec.pojo.PropertyModel, java.util.Set):void");
    }

    private boolean isPrimitiveLike(Class<?> type) {
        return List.of((Object[]) new Class[]{Character.class, Character.TYPE, Short.class, Short.TYPE, Integer.class, Integer.TYPE, Long.class, Long.TYPE, Double.class, Double.TYPE, Float.class, Float.TYPE, Boolean.class, Boolean.TYPE, Byte.class, Byte.TYPE, String.class, Date.class, Locale.class, Class.class, UUID.class, URI.class}).contains(type) || type.isEnum();
    }
}
