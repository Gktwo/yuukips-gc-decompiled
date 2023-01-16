package dev.morphia.annotations.builders;

import dev.morphia.annotations.Collation;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.IndexOptions;
import dev.morphia.annotations.Indexed;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/IndexOptionsBuilder.class */
public class IndexOptionsBuilder extends AnnotationBuilder<IndexOptions> implements IndexOptions {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0054: INVOKE_CUSTOM r-5, r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x0054: INVOKE_CUSTOM r1, r2, method: dev.morphia.annotations.builders.IndexOptionsBuilder.<init>(dev.morphia.annotations.IndexOptions, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    IndexOptionsBuilder(dev.morphia.annotations.IndexOptions r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r4
            r1 = r5
            r0.<init>(r1)
            java.lang.String r0 = ""
            r1 = r5
            java.lang.String r1 = r1.partialFilter()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0071
            r0 = r5
            java.lang.String r0 = r0.partialFilter()
            org.bson.Document r0 = org.bson.Document.parse(r0)
            r7 = r0
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r7
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
            r9 = r0
            r0 = r9
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0067
            r0 = r9
            java.lang.Object r0 = r0.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            r10 = r0
            r0 = r8
            r1 = r6
            r2 = r10
            java.lang.Object r2 = r2.getKey()
            java.lang.String r2 = (java.lang.String) r2
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
            r2 = r10
            java.lang.Object r2 = r2.getValue()
            java.lang.Object r0 = r0.put(r1, r2)
            goto L_0x0031
            r0 = r4
            r1 = r8
            java.lang.String r1 = r1.toJson()
            dev.morphia.annotations.builders.IndexOptionsBuilder r0 = r0.partialFilter(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.annotations.builders.IndexOptionsBuilder.<init>(dev.morphia.annotations.IndexOptions, java.lang.String):void");
    }

    public IndexOptionsBuilder() {
    }

    @Override // dev.morphia.annotations.builders.AnnotationBuilder, java.lang.annotation.Annotation
    public Class<IndexOptions> annotationType() {
        return IndexOptions.class;
    }

    @Override // dev.morphia.annotations.IndexOptions
    public boolean background() {
        return ((Boolean) get("background")).booleanValue();
    }

    @Override // dev.morphia.annotations.IndexOptions
    public boolean disableValidation() {
        return ((Boolean) get("disableValidation")).booleanValue();
    }

    @Override // dev.morphia.annotations.IndexOptions
    public int expireAfterSeconds() {
        return ((Integer) get("expireAfterSeconds")).intValue();
    }

    @Override // dev.morphia.annotations.IndexOptions
    public String language() {
        return (String) get("language");
    }

    @Override // dev.morphia.annotations.IndexOptions
    public String languageOverride() {
        return (String) get("languageOverride");
    }

    @Override // dev.morphia.annotations.IndexOptions
    public String name() {
        return (String) get("name");
    }

    @Override // dev.morphia.annotations.IndexOptions
    public boolean sparse() {
        return ((Boolean) get("sparse")).booleanValue();
    }

    @Override // dev.morphia.annotations.IndexOptions
    public boolean unique() {
        return ((Boolean) get("unique")).booleanValue();
    }

    @Override // dev.morphia.annotations.IndexOptions
    public String partialFilter() {
        return (String) get("partialFilter");
    }

    @Override // dev.morphia.annotations.IndexOptions
    public Collation collation() {
        return (Collation) get("collation");
    }

    public IndexOptionsBuilder background(boolean background) {
        put("background", Boolean.valueOf(background));
        return this;
    }

    public IndexOptionsBuilder collation(Collation collation) {
        put("collation", collation);
        return this;
    }

    public IndexOptionsBuilder disableValidation(boolean disableValidation) {
        put("disableValidation", Boolean.valueOf(disableValidation));
        return this;
    }

    public IndexOptionsBuilder expireAfterSeconds(int expireAfterSeconds) {
        put("expireAfterSeconds", Integer.valueOf(expireAfterSeconds));
        return this;
    }

    public IndexOptionsBuilder language(String language) {
        put("language", language);
        return this;
    }

    public IndexOptionsBuilder languageOverride(String languageOverride) {
        put("languageOverride", languageOverride);
        return this;
    }

    public IndexOptionsBuilder name(String name) {
        put("name", name);
        return this;
    }

    public IndexOptionsBuilder partialFilter(String partialFilter) {
        put("partialFilter", partialFilter);
        return this;
    }

    public IndexOptionsBuilder sparse(boolean sparse) {
        put("sparse", Boolean.valueOf(sparse));
        return this;
    }

    public IndexOptionsBuilder unique(boolean unique) {
        put("unique", Boolean.valueOf(unique));
        return this;
    }

    IndexOptionsBuilder migrate(Index index) {
        putAll(toMap(index));
        return this;
    }

    IndexOptionsBuilder migrate(Indexed index) {
        putAll(toMap(index));
        return this;
    }
}
