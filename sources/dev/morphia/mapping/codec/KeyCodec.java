package dev.morphia.mapping.codec;

import dev.morphia.Key;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import java.util.Iterator;
import org.bson.BsonReader;
import org.bson.BsonReaderMark;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/KeyCodec.class */
public class KeyCodec implements Codec<Key> {
    private final Mapper mapper;

    /* access modifiers changed from: package-private */
    public KeyCodec(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override // org.bson.codecs.Decoder
    public Key decode(BsonReader reader, DecoderContext decoderContext) {
        reader.readStartDocument();
        String ref = reader.readString("$ref");
        reader.readName();
        BsonReaderMark mark = reader.getMark();
        Object idValue = null;
        EntityModel model = null;
        Iterator<EntityModel> iterator = this.mapper.getClassesMappedToCollection(ref).iterator();
        while (idValue == null && iterator.hasNext()) {
            model = iterator.next();
            try {
                PropertyModel idField = model.getIdProperty();
                if (idField != null) {
                    idValue = this.mapper.getCodecRegistry().get(idField.getType()).decode(reader, decoderContext);
                }
            } catch (Exception e) {
                mark.reset();
            }
        }
        if (idValue == null) {
            throw new MappingException("Could not map the Key to a type.");
        }
        reader.readEndDocument();
        return new Key(model.getType(), ref, idValue);
    }

    @Override // org.bson.codecs.Encoder
    public Class<Key> getEncoderClass() {
        return Key.class;
    }

    public void encode(BsonWriter writer, Key value, EncoderContext encoderContext) {
        ExpressionHelper.document(writer, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
              (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
              (wrap: java.lang.Runnable : 0x0005: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
              (r6v0 'this' dev.morphia.mapping.codec.KeyCodec A[D('this' dev.morphia.mapping.codec.KeyCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r8v0 'value' dev.morphia.Key A[D('value' dev.morphia.Key), DONT_INLINE])
              (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
              (r9v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r1 I:dev.morphia.mapping.codec.KeyCodec)
              (r2 I:dev.morphia.Key)
              (r3 I:org.bson.BsonWriter)
              (r4 I:org.bson.codecs.EncoderContext)
             type: DIRECT call: dev.morphia.mapping.codec.KeyCodec.lambda$encode$0(dev.morphia.Key, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.codec.KeyCodec.encode(org.bson.BsonWriter, dev.morphia.Key, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/mapping/codec/KeyCodec.class
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
            r0 = r7
            r1 = r6
            r2 = r8
            r3 = r7
            r4 = r9
            void r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$encode$0(r2, r3, r4);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.KeyCodec.encode(org.bson.BsonWriter, dev.morphia.Key, org.bson.codecs.EncoderContext):void");
    }
}