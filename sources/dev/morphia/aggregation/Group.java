package dev.morphia.aggregation;

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
/* loaded from: grasscutter.jar:dev/morphia/aggregation/Group.class */
public final class Group {
    private final String name;
    @Nullable
    private Group nested;
    @Nullable
    private List<Projection> projections;
    @Nullable
    private Accumulator accumulator;
    private String sourceField;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r1, method: dev.morphia.aggregation.Group.<init>(java.lang.String, java.lang.String):void
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
    private Group(java.lang.String r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = r3
            r0.<init>()
            r0 = r3
            r1 = r4
            r0.name = r1
            r0 = r3
            r1 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r0.sourceField = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.Group.<init>(java.lang.String, java.lang.String):void");
    }

    private Group(String name, Accumulator accumulator) {
        this.name = name;
        this.accumulator = accumulator;
    }

    private Group(String name, Projection... projections) {
        this.name = name;
        this.projections = Arrays.asList(projections);
    }

    private Group(String name, Group nested) {
        this.name = name;
        this.nested = nested;
    }

    public static Accumulator addToSet(String field) {
        return new Accumulator("$addToSet", field);
    }

    public static Accumulator average(String field) {
        return new Accumulator("$avg", field);
    }

    public static Accumulator first(String field) {
        return new Accumulator("$first", field);
    }

    public static Group grouping(String name) {
        return grouping(name, name);
    }

    public static Group grouping(String name, String sourceField) {
        return new Group(name, sourceField);
    }

    public static Group grouping(String name, Projection... projections) {
        return new Group(name, projections);
    }

    public static Group grouping(String name, Group group) {
        return new Group(name, group);
    }

    public static Group grouping(String name, Accumulator accumulator) {
        return new Group(name, accumulator);
    }

    /* renamed from: id */
    public static List<Group> m1266id(Group... fields) {
        return Arrays.asList(fields);
    }

    public static Accumulator last(String field) {
        return new Accumulator("$last", field);
    }

    public static Accumulator max(String field) {
        return new Accumulator("$max", field);
    }

    public static Accumulator min(String field) {
        return new Accumulator("$min", field);
    }

    public static Accumulator push(String field) {
        return new Accumulator("$push", field);
    }

    public static Accumulator sum(String field) {
        return new Accumulator("$sum", field);
    }

    @Nullable
    public Accumulator getAccumulator() {
        return this.accumulator;
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public Group getNested() {
        return this.nested;
    }

    @Nullable
    public List<Projection> getProjections() {
        if (this.projections != null) {
            return new ArrayList(this.projections);
        }
        return null;
    }

    public String getSourceField() {
        return this.sourceField;
    }
}
