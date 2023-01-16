package dev.morphia.aggregation.experimental.codecs.stages;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.stages.UnionWith;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/UnionWithCodec.class */
public class UnionWithCodec extends StageCodec<UnionWith> {
    public UnionWithCodec(Mapper mapper) {
        super(mapper);
    }

    @Override // org.bson.codecs.Encoder
    public Class<UnionWith> getEncoderClass() {
        return UnionWith.class;
    }

    /* access modifiers changed from: protected */
    public void encodeStage(BsonWriter writer, UnionWith unionWith, EncoderContext encoderContext) {
        String name = unionWith.getCollectionName();
        String collectionName = name != null ? name : getMapper().getCollection(unionWith.getCollectionType()).getNamespace().getCollectionName();
        ExpressionHelper.document(writer, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0031: INVOKE  
              (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (wrap: java.lang.Runnable : 0x002c: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r7v0 'this' dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec A[D('this' dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r0v3 'collectionName' java.lang.String A[D('collectionName' java.lang.String), DONT_INLINE])
              (r10v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
              (r9v0 'unionWith' dev.morphia.aggregation.experimental.stages.UnionWith A[D('unionWith' dev.morphia.aggregation.experimental.stages.UnionWith), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r1 I:dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec)
              (r2 I:org.bson.BsonWriter)
              (r3 I:java.lang.String)
              (r4 I:org.bson.codecs.EncoderContext)
              (r5 I:dev.morphia.aggregation.experimental.stages.UnionWith)
             type: DIRECT call: dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec.lambda$encodeStage$0(org.bson.BsonWriter, java.lang.String, org.bson.codecs.EncoderContext, dev.morphia.aggregation.experimental.stages.UnionWith):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec.encodeStage(org.bson.BsonWriter, dev.morphia.aggregation.experimental.stages.UnionWith, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/aggregation/experimental/codecs/stages/UnionWithCodec.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
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
            java.lang.String r0 = r0.getCollectionName()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x0010
            r0 = r11
            goto L_0x0023
        L_0x0010:
            r0 = r7
            dev.morphia.mapping.Mapper r0 = r0.getMapper()
            r1 = r9
            java.lang.Class r1 = r1.getCollectionType()
            com.mongodb.client.MongoCollection r0 = r0.getCollection(r1)
            com.mongodb.MongoNamespace r0 = r0.getNamespace()
            java.lang.String r0 = r0.getCollectionName()
        L_0x0023:
            r12 = r0
            r0 = r8
            r1 = r7
            r2 = r8
            r3 = r12
            r4 = r10
            r5 = r9
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$encodeStage$0(r2, r3, r4, r5);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.experimental.codecs.stages.UnionWithCodec.encodeStage(org.bson.BsonWriter, dev.morphia.aggregation.experimental.stages.UnionWith, org.bson.codecs.EncoderContext):void");
    }
}
