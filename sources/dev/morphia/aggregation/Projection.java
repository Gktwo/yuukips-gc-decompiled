package dev.morphia.aggregation;

import com.mongodb.QueryOperators;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/aggregation/Projection.class */
public final class Projection {
    private final String target;
    @Nullable
    private final String source;
    @Nullable
    private List<Projection> projections;
    @Nullable
    private List<Object> arguments;
    private boolean suppressed;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r1, method: dev.morphia.aggregation.Projection.<init>(java.lang.String, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private Projection(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = r3
            r0.<init>()
            r0 = r3
            r1 = 0
            r0.suppressed = r1
            r0 = r3
            r1 = r4
            r0.target = r1
            r0 = r3
            r1 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r0.source = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.Projection.<init>(java.lang.String, java.lang.String):void");
    }

    private Projection(String field, Projection projection, Projection... subsequent) {
        this(field);
        this.projections = new ArrayList();
        this.projections.add(projection);
        this.projections.addAll(Arrays.asList(subsequent));
    }

    private Projection(@Nullable String field) {
        this.suppressed = false;
        this.target = field;
        this.source = null;
    }

    private Projection(@Nullable String expression, Object... args) {
        this(expression);
        this.arguments = Arrays.asList(args);
    }

    public static Projection add(Object... args) {
        return expression("$add", args);
    }

    public static Projection divide(Object arg1, Object arg2) {
        return expression("$divide", arg1, arg2);
    }

    public static Projection expression(String operator, Object... args) {
        return new Projection(operator, args);
    }

    public static Projection list(Object... args) {
        return new Projection((String) null, args);
    }

    public static Projection mod(Object arg1, Object arg2) {
        return expression(QueryOperators.MOD, arg1, arg2);
    }

    public static Projection multiply(Object... args) {
        return expression("$multiply", args);
    }

    public static Projection projection(String field) {
        return new Projection(field);
    }

    public static Projection projection(String field, String projectedField) {
        return new Projection(field, projectedField);
    }

    public static Projection projection(String field, Projection projection, Projection... subsequent) {
        return new Projection(field, projection, subsequent);
    }

    public static Projection size(Object expression) {
        return expression(QueryOperators.SIZE, expression);
    }

    public static Projection subtract(Object arg1, Object arg2) {
        return expression("$subtract", arg1, arg2);
    }

    @Nullable
    public List<Object> getArguments() {
        return this.arguments;
    }

    @Nullable
    public List<Projection> getProjections() {
        return this.projections;
    }

    @Nullable
    public String getSource() {
        return this.source;
    }

    @Nullable
    public String getTarget() {
        return this.target;
    }

    public boolean isSuppressed() {
        return this.suppressed;
    }

    public Projection suppress() {
        this.suppressed = true;
        return this;
    }

    public String toString() {
        return String.format("Projection{projectedField='%s', sourceField='%s', projections=%s, suppressed=%s}", this.source, this.target, this.projections, Boolean.valueOf(this.suppressed));
    }
}
