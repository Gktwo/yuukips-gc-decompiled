package p014it.unimi.dsi.fastutil.floats;

import java.util.Comparator;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException: Cannot invoke "java.util.List.forEach(java.util.function.Consumer)" because "blocks" is null
    	at jadx.core.utils.BlockUtils.collectAllInsns(BlockUtils.java:904)
    	at jadx.core.dex.visitors.ClassModifier.removeBridgeMethod(ClassModifier.java:221)
    	at jadx.core.dex.visitors.ClassModifier.removeSyntheticMethods(ClassModifier.java:150)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at jadx.core.dex.visitors.ClassModifier.visit(ClassModifier.java:57)
    */
@FunctionalInterface
/* renamed from: it.unimi.dsi.fastutil.floats.FloatComparator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatComparator.class */
public interface FloatComparator extends Comparator<Float> {
    int compare(float f, float f2);

    /*  JADX ERROR: Failed to decode insn: 0x0002: INVOKE_CUSTOM r0, r1, method: it.unimi.dsi.fastutil.floats.FloatComparator.thenComparing(it.unimi.dsi.fastutil.floats.FloatComparator):it.unimi.dsi.fastutil.floats.FloatComparator
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    default p014it.unimi.dsi.fastutil.floats.FloatComparator thenComparing(p014it.unimi.dsi.fastutil.floats.FloatComparator r4) {
        /*
            r3 = this;
            r0 = r3
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
            java.io.Serializable r0 = (java.io.Serializable) r0
            it.unimi.dsi.fastutil.floats.FloatComparator r0 = (p014it.unimi.dsi.fastutil.floats.FloatComparator) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatComparator.thenComparing(it.unimi.dsi.fastutil.floats.FloatComparator):it.unimi.dsi.fastutil.floats.FloatComparator");
    }

    /*  JADX ERROR: Failed to decode insn: 0x0091: INVOKE_CUSTOM r0, r1, method: it.unimi.dsi.fastutil.floats.FloatComparator.$deserializeLambda$(java.lang.invoke.SerializedLambda):java.lang.Object
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static /* synthetic */ java.lang.Object $deserializeLambda$(java.lang.invoke.SerializedLambda r4) {
        /*
            r0 = r4
            java.lang.String r0 = r0.getImplMethodName()
            r5 = r0
            r0 = -1
            r6 = r0
            r0 = r5
            int r0 = r0.hashCode()
            switch(r0) {
                case 33007787: goto L_0x001c;
                default: goto L_0x0027;
            }
            r0 = r5
            java.lang.String r1 = "lambda$thenComparing$99a1156d$1"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0027
            r0 = 0
            r6 = r0
            r0 = r6
            switch(r0) {
                case 0: goto L_0x003c;
                default: goto L_0x0097;
            }
            r0 = r4
            int r0 = r0.getImplMethodKind()
            r1 = 7
            if (r0 != r1) goto L_0x0097
            r0 = r4
            java.lang.String r0 = r0.getFunctionalInterfaceClass()
            java.lang.String r1 = "it/unimi/dsi/fastutil/floats/FloatComparator"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = r4
            java.lang.String r0 = r0.getFunctionalInterfaceMethodName()
            java.lang.String r1 = "compare"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = r4
            java.lang.String r0 = r0.getFunctionalInterfaceMethodSignature()
            java.lang.String r1 = "(FF)I"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = r4
            java.lang.String r0 = r0.getImplClass()
            java.lang.String r1 = "it/unimi/dsi/fastutil/floats/FloatComparator"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = r4
            java.lang.String r0 = r0.getImplMethodSignature()
            java.lang.String r1 = "(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0097
            r0 = r4
            r1 = 0
            java.lang.Object r0 = r0.getCapturedArg(r1)
            it.unimi.dsi.fastutil.floats.FloatComparator r0 = (p014it.unimi.dsi.fastutil.floats.FloatComparator) r0
            r1 = r4
            r2 = 1
            java.lang.Object r1 = r1.getCapturedArg(r2)
            it.unimi.dsi.fastutil.floats.FloatComparator r1 = (p014it.unimi.dsi.fastutil.floats.FloatComparator) r1
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/LambdaMetafactory;->altMetafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, compare, {ENCODED_METHOD_TYPE: (Lit/unimi/dsi/fastutil/floats/FloatComparator;, Lit/unimi/dsi/fastutil/floats/FloatComparator;)Lit/unimi/dsi/fastutil/floats/FloatComparator;}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_METHOD_HANDLE: INVOKE_DIRECT: Lit/unimi/dsi/fastutil/floats/FloatComparator;->lambda$thenComparing$99a1156d$1(Lit/unimi/dsi/fastutil/floats/FloatComparator;FF)I}, {ENCODED_METHOD_TYPE: (F, F)I}, {ENCODED_INT: 5}, {ENCODED_INT: 0}]}
            return r0
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            java.lang.String r2 = "Invalid lambda deserialization"
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p014it.unimi.dsi.fastutil.floats.FloatComparator.$deserializeLambda$(java.lang.invoke.SerializedLambda):java.lang.Object");
    }

    /* Return type fixed from 'it.unimi.dsi.fastutil.floats.FloatComparator' to match base method */
    @Override // java.util.Comparator
    default Comparator<Float> reversed() {
        return FloatComparators.oppositeComparator(this);
    }

    @Deprecated
    default int compare(Float ok1, Float ok2) {
        return compare(ok1.floatValue(), ok2.floatValue());
    }

    private /* synthetic */ default int lambda$thenComparing$99a1156d$1(FloatComparator second, float k1, float k2) {
        int comp = compare(k1, k2);
        return comp == 0 ? second.compare(k1, k2) : comp;
    }

    @Override // java.util.Comparator
    default Comparator<Float> thenComparing(Comparator<? super Float> second) {
        return second instanceof FloatComparator ? thenComparing((FloatComparator) second) : thenComparing(second);
    }
}
