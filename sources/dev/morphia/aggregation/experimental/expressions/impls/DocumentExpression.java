package dev.morphia.aggregation.experimental.expressions.impls;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/DocumentExpression.class */
public class DocumentExpression extends Expression implements FieldHolder<DocumentExpression> {
    private final Fields<DocumentExpression> fields = Fields.m1256on(this);

    public DocumentExpression() {
        super("unused");
    }

    public void encode(String name, Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, name, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000c: INVOKE  
              (r10v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (r8v0 'name' java.lang.String A[D('name' java.lang.String)])
              (wrap: java.lang.Runnable : 0x0007: INVOKE_CUSTOM (r2v1 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression A[D('this' dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r9v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
              (r10v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r11v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r2 I:dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression)
              (r3 I:dev.morphia.mapping.Mapper)
              (r4 I:org.bson.BsonWriter)
              (r5 I:org.bson.codecs.EncoderContext)
             type: DIRECT call: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.lambda$encode$0(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.String, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.encode(java.lang.String, dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/DocumentExpression.class
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
            r0 = r10
            r1 = r8
            r2 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            void r2 = () -> { // java.lang.Runnable.run():void
                r2.lambda$encode$0(r3, r4, r5);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.encode(java.lang.String, dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
    }

    @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
              (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (wrap: java.lang.Runnable : 0x0005: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression A[D('this' dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
              (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r9v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r1 I:dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression)
              (r2 I:dev.morphia.mapping.Mapper)
              (r3 I:org.bson.BsonWriter)
              (r4 I:org.bson.codecs.EncoderContext)
             type: DIRECT call: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.lambda$encode$1(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/impls/DocumentExpression.class
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
            r0 = r8
            r1 = r6
            r2 = r7
            r3 = r8
            r4 = r9
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$encode$1(r2, r3, r4);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.expressions.impls.DocumentExpression.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
    }

    @Override // dev.morphia.aggregation.experimental.expressions.impls.FieldHolder
    public DocumentExpression field(String name, Expression expression) {
        return this.fields.add(name, expression);
    }
}
