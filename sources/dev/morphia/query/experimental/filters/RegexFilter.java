package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.Mapper;
import java.util.regex.Pattern;
import org.bson.BsonRegularExpression;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/RegexFilter.class */
public class RegexFilter extends Filter {
    private String regex;
    private String options;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r-5, r-4
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
    /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r1, r2, method: dev.morphia.query.experimental.filters.RegexFilter.add(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void add(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r4
            java.lang.String r0 = r0.options
            if (r0 != 0) goto L_0x000d
            r0 = r4
            java.lang.String r1 = ""
            r0.options = r1
            r0 = r4
            java.lang.String r0 = r0.options
            r1 = r5
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0026
            r0 = r4
            r1 = r0
            java.lang.String r1 = r1.options
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
            r0.options = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.experimental.filters.RegexFilter.add(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public RegexFilter(String field) {
        super("$regex", field, null);
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        if (isNot()) {
            writer.writeStartDocument(QueryOperators.NOT);
        }
        ExpressionHelper.value(mapper, writer, "$regex", new BsonRegularExpression(this.regex), context);
        ExpressionHelper.value(mapper, writer, "$options", this.options, context);
        if (isNot()) {
            writer.writeEndDocument();
        }
        writer.writeEndDocument();
    }

    public RegexFilter options(String options) {
        this.options = options;
        return this;
    }

    public RegexFilter pattern(String pattern) {
        this.regex = pattern;
        return this;
    }

    public RegexFilter pattern(Pattern pattern) {
        this.regex = pattern.pattern();
        return this;
    }

    public RegexFilter caseInsensitive() {
        add(IntegerTokenConverter.CONVERTER_KEY);
        return this;
    }

    public RegexFilter extended() {
        add("x");
        return this;
    }

    public RegexFilter multiline() {
        add(ANSIConstants.ESC_END);
        return this;
    }

    public RegexFilter special() {
        add("s");
        return this;
    }
}
