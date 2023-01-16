package dev.morphia.mapping.codec;

import com.mongodb.client.model.geojson.Position;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.query.Shape;
import dev.morphia.sofia.Sofia;
import java.util.Locale;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/CenterCodec.class */
class CenterCodec implements Codec<Shape.Center> {
    @Override // org.bson.codecs.Decoder
    public Shape.Center decode(BsonReader reader, DecoderContext decoderContext) {
        throw new UnsupportedOperationException(Sofia.encodingOnly(new Locale[0]));
    }

    public void encode(BsonWriter writer, Shape.Center value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
              (r6v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (wrap: java.lang.Runnable : 0x0004: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' dev.morphia.mapping.codec.CenterCodec A[D('this' dev.morphia.mapping.codec.CenterCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r7v0 'value' dev.morphia.query.Shape$Center A[D('value' dev.morphia.query.Shape$Center), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r1 I:dev.morphia.mapping.codec.CenterCodec), (r2 I:org.bson.BsonWriter), (r3 I:dev.morphia.query.Shape$Center) type: DIRECT call: dev.morphia.mapping.codec.CenterCodec.lambda$encode$1(org.bson.BsonWriter, dev.morphia.query.Shape$Center):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.codec.CenterCodec.encode(org.bson.BsonWriter, dev.morphia.query.Shape$Center, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/mapping/codec/CenterCodec.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
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
            r1 = r5
            r2 = r6
            r3 = r7
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$encode$1(r2, r3);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.CenterCodec.encode(org.bson.BsonWriter, dev.morphia.query.Shape$Center, org.bson.codecs.EncoderContext):void");
    }

    private void encodePosition(BsonWriter writer, Position value) {
        writer.writeStartArray();
        for (Double d : value.getValues()) {
            writer.writeDouble(d.doubleValue());
        }
        writer.writeEndArray();
    }

    @Override // org.bson.codecs.Encoder
    public Class<Shape.Center> getEncoderClass() {
        return Shape.Center.class;
    }
}
