package dev.morphia.query.experimental.filters;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.PropertyHandler;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.query.OperationTarget;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/Filter.class */
public class Filter {
    private final String name;
    private String field;
    @Nullable
    private Object value;
    private boolean not;
    private boolean validate;
    private Class<?> entityClass;
    private PathTarget pathTarget;
    private boolean mapped;

    /* access modifiers changed from: protected */
    public Filter(String name) {
        this.name = name;
    }

    /* access modifiers changed from: protected */
    public Filter(String name, @Nullable String field, @Nullable Object value) {
        this.name = name;
        this.field = field != null ? field : "";
        this.value = value;
    }

    public boolean isNot() {
        return this.not;
    }

    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        ExpressionHelper.document(writer, path(mapper), ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
              (r9v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (wrap: java.lang.String : 0x0003: INVOKE  (r1v1 java.lang.String A[REMOVE]) = 
              (r7v0 'this' dev.morphia.query.experimental.filters.Filter A[D('this' dev.morphia.query.experimental.filters.Filter), IMMUTABLE_TYPE, THIS])
              (r8v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper)])
             type: VIRTUAL call: dev.morphia.query.experimental.filters.Filter.path(dev.morphia.mapping.Mapper):java.lang.String)
              (wrap: java.lang.Runnable : 0x000a: INVOKE_CUSTOM (r2v2 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' dev.morphia.query.experimental.filters.Filter A[D('this' dev.morphia.query.experimental.filters.Filter), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r9v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r8v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
              (r10v0 'context' org.bson.codecs.EncoderContext A[D('context' org.bson.codecs.EncoderContext), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r2 I:dev.morphia.query.experimental.filters.Filter)
              (r3 I:org.bson.BsonWriter)
              (r4 I:dev.morphia.mapping.Mapper)
              (r5 I:org.bson.codecs.EncoderContext)
             type: DIRECT call: dev.morphia.query.experimental.filters.Filter.lambda$encode$1(org.bson.BsonWriter, dev.morphia.mapping.Mapper, org.bson.codecs.EncoderContext):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.String, java.lang.Runnable):void in method: dev.morphia.query.experimental.filters.Filter.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/query/experimental/filters/Filter.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r9
            r1 = r7
            r2 = r8
            java.lang.String r1 = r1.path(r2)
            r2 = r7
            r3 = r9
            r4 = r8
            r5 = r10
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$encode$1(r3, r4, r5);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.experimental.filters.Filter.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
    }

    public Filter entityType(Class<?> type) {
        this.entityClass = type;
        return this;
    }

    @Nullable
    public String getField() {
        return this.field;
    }

    public Filter not() {
        this.not = true;
        return this;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    @Nullable
    public Object getValue() {
        return this.value;
    }

    public Filter isValidating(boolean validate) {
        this.validate = validate;
        this.pathTarget = null;
        this.mapped = false;
        return this;
    }

    @Nullable
    protected Object getValue(Mapper mapper) {
        if (!this.mapped) {
            PathTarget target = pathTarget(mapper);
            OperationTarget operationTarget = new OperationTarget(this.pathTarget, this.value);
            this.value = operationTarget.getValue();
            PropertyModel property = target.getTarget();
            if (property != null && (property.getCodec() instanceof PropertyHandler)) {
                this.value = ((Document) operationTarget.encode(mapper)).get(this.field);
            }
            this.mapped = true;
        }
        return this.value;
    }

    public String toString() {
        return String.format("%s %s %s", this.field, this.name, this.value);
    }

    protected String path(Mapper mapper) {
        return pathTarget(mapper).translatedPath();
    }

    private PathTarget pathTarget(Mapper mapper) {
        if (this.pathTarget == null) {
            this.pathTarget = new PathTarget(mapper, this.entityClass, this.field, this.validate);
        }
        return this.pathTarget;
    }

    protected void writeNamedValue(@Nullable String name, @Nullable Object value, Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        writer.writeName(name);
        if (value != null) {
            encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(value.getClass()), writer, value);
        } else {
            writer.writeNull();
        }
    }

    protected void writeUnnamedValue(@Nullable Object value, Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        if (value != null) {
            encoderContext.encodeWithChildContext(mapper.getCodecRegistry().get(value.getClass()), writer, value);
        } else {
            writer.writeNull();
        }
    }
}
