package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.Unwind;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/UnwindCodec.class */
public class UnwindCodec extends StageCodec<Unwind> {
    public UnwindCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Unwind> getEncoderClass() {
        return Unwind.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, Unwind value, EncoderContext encoderContext) {
        if (!value.optionsPresent()) {
            value.getPath().encode(getMapper(), writer, encoderContext);
        } else {
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: INVOKE  
                  (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                  (wrap: java.lang.Runnable : 0x001c: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                  (r6v0 'this' dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec A[D('this' dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                  (r8v0 'value' dev.morphia.aggregation.experimental.stages.Unwind A[D('value' dev.morphia.aggregation.experimental.stages.Unwind), DONT_INLINE])
                  (r9v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec)
                  (r2 I:org.bson.BsonWriter)
                  (r3 I:dev.morphia.aggregation.experimental.stages.Unwind)
                  (r4 I:org.bson.codecs.EncoderContext)
                 type: DIRECT call: dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec.lambda$encodeStage$0(org.bson.BsonWriter, dev.morphia.aggregation.experimental.stages.Unwind, org.bson.codecs.EncoderContext):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec.encodeStage(org.bson.BsonWriter, dev.morphia.aggregation.experimental.stages.Unwind, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/UnwindCodec.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:151)
                	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                	... 21 more
                */
            /*
                this = this;
                r0 = r8
                boolean r0 = r0.optionsPresent()
                if (r0 != 0) goto L_0x0017
                r0 = r8
                dev.morphia.aggregation.experimental.expressions.impls.Expression r0 = r0.getPath()
                r1 = r6
                dev.morphia.mapping.Mapper r1 = r1.getMapper()
                r2 = r7
                r3 = r9
                r0.encode(r1, r2, r3)
                goto L_0x0024
            L_0x0017:
                r0 = r7
                r1 = r6
                r2 = r7
                r3 = r8
                r4 = r9
                void r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$encodeStage$0(r2, r3, r4);
                }
                dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            L_0x0024:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.codecs.stages.UnwindCodec.encodeStage(org.bson.BsonWriter, dev.morphia.aggregation.experimental.stages.Unwind, org.bson.codecs.EncoderContext):void");
        }
    }
