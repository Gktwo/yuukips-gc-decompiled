package dev.morphia.query;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.Map;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/Geo2dCriteria.class */
class Geo2dCriteria extends FieldCriteria {
    private final Map<String, Object> opts;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0089: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x0089: INVOKE_CUSTOM r2, method: dev.morphia.query.Geo2dCriteria.toDocument():org.bson.Document
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/query/FilterOperator;)Ljava/lang/String;},  not supported for geo-query]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/query/FilterOperator;)Ljava/lang/String;},  not supported for geo-query]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldCriteria, dev.morphia.query.Criteria
    public org.bson.Document toDocument() {
        /*
            r8 = this;
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            r1.<init>()
            r9 = r0
            int[] r0 = dev.morphia.query.Geo2dCriteria.C13331.$SwitchMap$dev$morphia$query$FilterOperator
            r1 = r8
            dev.morphia.query.FilterOperator r1 = r1.getOperator()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0034;
                case 2: goto L_0x0049;
                case 3: goto L_0x005e;
                case 4: goto L_0x005e;
                case 5: goto L_0x005e;
                default: goto L_0x0081;
            }
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            dev.morphia.query.FilterOperator r2 = dev.morphia.query.FilterOperator.NEAR
            java.lang.String r2 = r2.val()
            r3 = r8
            java.lang.Object r3 = r3.getValue()
            r1.<init>(r2, r3)
            r10 = r0
            goto L_0x0092
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            dev.morphia.query.FilterOperator r2 = dev.morphia.query.FilterOperator.NEAR_SPHERE
            java.lang.String r2 = r2.val()
            r3 = r8
            java.lang.Object r3 = r3.getValue()
            r1.<init>(r2, r3)
            r10 = r0
            goto L_0x0092
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            dev.morphia.query.FilterOperator r2 = dev.morphia.query.FilterOperator.GEO_WITHIN
            java.lang.String r2 = r2.val()
            org.bson.Document r3 = new org.bson.Document
            r4 = r3
            r5 = r8
            dev.morphia.query.FilterOperator r5 = r5.getOperator()
            java.lang.String r5 = r5.val()
            r6 = r8
            java.lang.Object r6 = r6.getValue()
            r4.<init>(r5, r6)
            r1.<init>(r2, r3)
            r10 = r0
            goto L_0x0092
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            r1 = r0
            r2 = r8
            dev.morphia.query.FilterOperator r2 = r2.getOperator()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/query/FilterOperator;)Ljava/lang/String;},  not supported for geo-query]}
            r1.<init>(r2)
            throw r0
            r0 = r8
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.opts
            if (r0 == 0) goto L_0x00d5
            r0 = r8
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.opts
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r11 = r0
            r0 = r11
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00d5
            r0 = r11
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r12 = r0
            r0 = r10
            r1 = r12
            java.lang.Object r1 = r1.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r2 = r12
            java.lang.Object r2 = r2.getValue()
            org.bson.Document r0 = r0.append(r1, r2)
            goto L_0x00a8
            r0 = r9
            r1 = r8
            java.lang.String r1 = r1.getField()
            r2 = r10
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.Geo2dCriteria.toDocument():org.bson.Document");
    }

    /* access modifiers changed from: package-private */
    public Geo2dCriteria(Mapper mapper, String field, FilterOperator op, Object value, Map<String, Object> opts, EntityModel model, boolean validating) {
        super(mapper, field, op, value, model, validating);
        this.opts = opts;
    }

    /* renamed from: dev.morphia.query.Geo2dCriteria$1 */
    /* loaded from: grasscutter.jar:dev/morphia/query/Geo2dCriteria$1.class */
    static /* synthetic */ class C13331 {
        static final /* synthetic */ int[] $SwitchMap$dev$morphia$query$FilterOperator = new int[FilterOperator.values().length];

        static {
            try {
                $SwitchMap$dev$morphia$query$FilterOperator[FilterOperator.NEAR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$dev$morphia$query$FilterOperator[FilterOperator.NEAR_SPHERE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$dev$morphia$query$FilterOperator[FilterOperator.WITHIN_BOX.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$dev$morphia$query$FilterOperator[FilterOperator.WITHIN_CIRCLE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$dev$morphia$query$FilterOperator[FilterOperator.WITHIN_CIRCLE_SPHERE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }
}
