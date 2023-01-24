package dev.morphia.mapping.codec;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.BsonReader;
import org.bson.BsonType;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;
import org.bson.codecs.pojo.PropertyCodecRegistry;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaMapPropertyCodecProvider.class */
public class MorphiaMapPropertyCodecProvider extends MorphiaPropertyCodecProvider {
    @Override // org.bson.codecs.pojo.PropertyCodecProvider
    public <T> Codec<T> get(TypeWithTypeParameters<T> type, PropertyCodecRegistry registry) {
        if (Map.class.isAssignableFrom(type.getType())) {
            List<? extends TypeWithTypeParameters<?>> typeParameters = type.getTypeParameters();
            TypeWithTypeParameters<?> keyType = getType(typeParameters, 0);
            TypeWithTypeParameters<?> valueType = getType(typeParameters, 1);
            try {
                return new MapCodec(type.getType(), keyType.getType(), registry.get(valueType));
            } catch (CodecConfigurationException e) {
                if (valueType.getType().equals(Object.class)) {
                    try {
                        return registry.get(TypeData.builder(Map.class).build());
                    } catch (CodecConfigurationException e2) {
                        throw e;
                    }
                }
                throw e;
            }
        } else if (Enum.class.isAssignableFrom(type.getType())) {
            return new EnumCodec(type.getType());
        } else {
            return null;
        }
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaMapPropertyCodecProvider$MapCodec.class */
    private static class MapCodec<K, V> implements Codec<Map<K, V>> {
        private final Class<Map<K, V>> encoderClass;
        private final Class<K> keyType;
        private final Codec<V> codec;

        @Override // org.bson.codecs.Encoder
        public /* bridge */ /* synthetic */ void encode(BsonWriter bsonWriter, Object obj, EncoderContext encoderContext) {
            encode(bsonWriter, (Map) ((Map) obj), encoderContext);
        }

        MapCodec(Class<Map<K, V>> encoderClass, Class<K> keyType, Codec<V> codec) {
            this.encoderClass = encoderClass;
            this.keyType = keyType;
            this.codec = codec;
        }

        public void encode(BsonWriter writer, Map<K, V> map, EncoderContext encoderContext) {
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000a: INVOKE  
                  (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                  (wrap: java.lang.Runnable : 0x0005: INVOKE_CUSTOM (r1v1 java.lang.Runnable A[REMOVE]) = 
                  (r6v0 'this' dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider$MapCodec<K, V> A[D('this' dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider$MapCodec<K, V>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r8v0 'map' java.util.Map<K, V> A[D('map' java.util.Map<K, V>), DONT_INLINE])
                  (r7v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                  (r9v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider$MapCodec)
                  (r2 I:java.util.Map)
                  (r3 I:org.bson.BsonWriter)
                  (r4 I:org.bson.codecs.EncoderContext)
                 type: DIRECT call: dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider.MapCodec.lambda$encode$0(java.util.Map, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider.MapCodec.encode(org.bson.BsonWriter, java.util.Map<K, V>, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/mapping/codec/MorphiaMapPropertyCodecProvider$MapCodec.class
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
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.MorphiaMapPropertyCodecProvider.MapCodec.encode(org.bson.BsonWriter, java.util.Map, org.bson.codecs.EncoderContext):void");
        }

        @Override // org.bson.codecs.Decoder
        public Map<K, V> decode(BsonReader reader, DecoderContext context) {
            reader.readStartDocument();
            Map<K, V> map = getInstance();
            while (reader.readBsonType() != BsonType.END_OF_DOCUMENT) {
                K key = (K) Conversions.convert(reader.readName(), this.keyType);
                if (reader.getCurrentBsonType() == BsonType.NULL) {
                    map.put(key, null);
                    reader.readNull();
                } else {
                    map.put(key, this.codec.decode(reader, context));
                }
            }
            reader.readEndDocument();
            return map;
        }

        @Override // org.bson.codecs.Encoder
        public Class<Map<K, V>> getEncoderClass() {
            return this.encoderClass;
        }

        private Map<K, V> getInstance() {
            if (this.encoderClass.isInterface()) {
                return new HashMap();
            }
            try {
                Constructor<Map<K, V>> constructor = this.encoderClass.getDeclaredConstructor(new Class[0]);
                constructor.setAccessible(true);
                return constructor.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new CodecConfigurationException(e.getMessage(), e);
            }
        }
    }
}
