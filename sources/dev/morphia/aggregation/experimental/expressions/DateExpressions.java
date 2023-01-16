package dev.morphia.aggregation.experimental.expressions;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.expressions.impls.DateFromParts;
import dev.morphia.aggregation.experimental.expressions.impls.DateFromString;
import dev.morphia.aggregation.experimental.expressions.impls.DateToParts;
import dev.morphia.aggregation.experimental.expressions.impls.DateToString;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.aggregation.experimental.expressions.impls.IsoDates;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/DateExpressions.class */
public final class DateExpressions {
    private DateExpressions() {
    }

    public static DateFromParts dateFromParts() {
        return new DateFromParts();
    }

    public static DateFromString dateFromString() {
        return new DateFromString();
    }

    public static DateToParts dateToParts(Expression date) {
        return new DateToParts(date);
    }

    public static DateToString dateToString() {
        return new DateToString();
    }

    public static DateExpression dayOfMonth(Expression value) {
        return new DateExpression("$dayOfMonth", value);
    }

    public static DateExpression dayOfWeek(Expression value) {
        return new DateExpression("$dayOfWeek", value);
    }

    public static DateExpression dayOfYear(Expression value) {
        return new DateExpression("$dayOfYear", value);
    }

    public static DateExpression hour(Expression value) {
        return new DateExpression("$hour", value);
    }

    public static IsoDates isoDayOfWeek(Expression value) {
        return new IsoDates("$isoDayOfWeek", value);
    }

    public static IsoDates isoWeek(Expression value) {
        return new IsoDates("$isoWeek", value);
    }

    public static IsoDates isoWeekYear(Expression value) {
        return new IsoDates("$isoWeekYear", value);
    }

    public static DateExpression milliseconds(Expression value) {
        return new DateExpression("$millisecond", value);
    }

    public static DateExpression minute(Expression value) {
        return new DateExpression("$minute", value);
    }

    public static DateExpression month(Expression value) {
        return new DateExpression("$month", value);
    }

    public static DateExpression second(Expression value) {
        return new DateExpression("$second", value);
    }

    public static DateExpression toDate(Expression value) {
        return new DateExpression("$toDate", value);
    }

    public static DateExpression week(Expression value) {
        return new DateExpression("$week", value);
    }

    public static DateExpression year(Expression value) {
        return new DateExpression("$year", value);
    }

    /* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/DateExpressions$DateExpression.class */
    public static class DateExpression extends Expression {
        protected DateExpression(String operation, Expression value) {
            super(operation, value);
        }

        @Override // dev.morphia.aggregation.experimental.expressions.impls.Expression
        public void encode(Mapper mapper, BsonWriter writer, EncoderContext encoderContext) {
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
                  (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                  (wrap: java.lang.Runnable : 0x0005: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                  (r6v0 'this' dev.morphia.aggregation.experimental.expressions.DateExpressions$DateExpression A[D('this' dev.morphia.aggregation.experimental.expressions.DateExpressions$DateExpression), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r7v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
                  (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                  (r9v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.aggregation.experimental.expressions.DateExpressions$DateExpression)
                  (r2 I:dev.morphia.mapping.Mapper)
                  (r3 I:org.bson.BsonWriter)
                  (r4 I:org.bson.codecs.EncoderContext)
                 type: DIRECT call: dev.morphia.aggregation.experimental.expressions.DateExpressions.DateExpression.lambda$encode$0(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.expressions.DateExpressions.DateExpression.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/expressions/DateExpressions$DateExpression.class
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
                    r1.lambda$encode$0(r2, r3, r4);
                }
                dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.expressions.DateExpressions.DateExpression.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
        }
    }
}
