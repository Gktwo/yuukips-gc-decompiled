package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.experimental.filters.Filter;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/Miscellaneous.class */
public final class Miscellaneous {
    private Miscellaneous() {
    }

    public static Expression rand() {
        return new Expression("$rand") { // from class: dev.morphia.aggregation.experimental.expressions.Miscellaneous.1
            @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
            public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                ExpressionHelper.document(writer, ()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: INVOKE  
                      (r6v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                      (wrap: java.lang.Runnable : 0x0003: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                      (r4v0 'this' dev.morphia.aggregation.experimental.expressions.Miscellaneous$1 A[D('this' dev.morphia.aggregation.experimental.expressions.Miscellaneous$1), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r6v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  (r1 I:dev.morphia.aggregation.experimental.expressions.Miscellaneous$1), (r2 I:org.bson.BsonWriter) type: DIRECT call: dev.morphia.aggregation.experimental.expressions.Miscellaneous.1.lambda$encode$1(org.bson.BsonWriter):void)
                     type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.expressions.Miscellaneous.1.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/Miscellaneous$1.class
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
                    Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
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
                    r0 = r6
                    r1 = r4
                    r2 = r6
                    void r1 = () -> { // java.lang.Runnable.run():void
                        r1.lambda$encode$1(r2);
                    }
                    dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.expressions.Miscellaneous.C12781.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
            }
        };
    }

    public static Filter sampleRate(double rate) {
        return new Filter("$sampleRate", null, Double.valueOf(rate)) { // from class: dev.morphia.aggregation.experimental.expressions.Miscellaneous.2
            @Override // dev.morphia.query.experimental.filters.Filter
            public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                writeNamedValue(getName(), getValue(), mapper, writer, context);
            }
        };
    }
}