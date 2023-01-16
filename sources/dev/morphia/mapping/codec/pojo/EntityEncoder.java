package dev.morphia.mapping.codec.pojo;

import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import java.util.Collection;
import java.util.Map;
import org.bson.BsonWriter;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.IdGenerator;
import org.bson.codecs.ObjectIdGenerator;
import org.bson.types.ObjectId;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityEncoder.class */
public class EntityEncoder implements Encoder<Object> {
    public static final ObjectIdGenerator OBJECT_ID_GENERATOR = new ObjectIdGenerator();
    private final MorphiaCodec morphiaCodec;
    private IdGenerator idGenerator;

    /* access modifiers changed from: protected */
    public EntityEncoder(MorphiaCodec morphiaCodec) {
        this.morphiaCodec = morphiaCodec;
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object value, EncoderContext encoderContext) {
        EntityModel model = this.morphiaCodec.getEntityModel();
        if (areEquivalentTypes(value.getClass(), model.getType())) {
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0025: INVOKE  
                  (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                  (wrap: java.lang.Runnable : 0x0020: INVOKE_CUSTOM (r1v6 java.lang.Runnable A[REMOVE]) = 
                  (r7v0 'this' dev.morphia.mapping.codec.pojo.EntityEncoder A[D('this' dev.morphia.mapping.codec.pojo.EntityEncoder), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v2 'model' dev.morphia.mapping.codec.pojo.EntityModel A[D('model' dev.morphia.mapping.codec.pojo.EntityModel), DONT_INLINE])
                  (r8v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                  (r9v0 'value' java.lang.Object A[D('value' java.lang.Object), DONT_INLINE])
                  (r10v0 'encoderContext' org.bson.codecs.EncoderContext A[D('encoderContext' org.bson.codecs.EncoderContext), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.mapping.codec.pojo.EntityEncoder)
                  (r2 I:dev.morphia.mapping.codec.pojo.EntityModel)
                  (r3 I:org.bson.BsonWriter)
                  (r4 I:java.lang.Object)
                  (r5 I:org.bson.codecs.EncoderContext)
                 type: DIRECT call: dev.morphia.mapping.codec.pojo.EntityEncoder.lambda$encode$0(dev.morphia.mapping.codec.pojo.EntityModel, org.bson.BsonWriter, java.lang.Object, org.bson.codecs.EncoderContext):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.codec.pojo.EntityEncoder.encode(org.bson.BsonWriter, java.lang.Object, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/mapping/codec/pojo/EntityEncoder.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
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
                	... 21 more
                */
            /*
                this = this;
                r0 = r7
                dev.morphia.mapping.codec.pojo.MorphiaCodec r0 = r0.morphiaCodec
                dev.morphia.mapping.codec.pojo.EntityModel r0 = r0.getEntityModel()
                r11 = r0
                r0 = r7
                r1 = r9
                java.lang.Class r1 = r1.getClass()
                r2 = r11
                java.lang.Class r2 = r2.getType()
                boolean r0 = r0.areEquivalentTypes(r1, r2)
                if (r0 == 0) goto L_0x002b
                r0 = r8
                r1 = r7
                r2 = r11
                r3 = r8
                r4 = r9
                r5 = r10
                void r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$encode$0(r2, r3, r4, r5);
                }
                dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
                goto L_0x0043
            L_0x002b:
                r0 = r7
                dev.morphia.mapping.codec.pojo.MorphiaCodec r0 = r0.morphiaCodec
                org.bson.codecs.configuration.CodecRegistry r0 = r0.getRegistry()
                r1 = r9
                java.lang.Class r1 = r1.getClass()
                org.bson.codecs.Codec r0 = r0.get(r1)
                r1 = r8
                r2 = r9
                r3 = r10
                r0.encode(r1, r2, r3)
            L_0x0043:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.pojo.EntityEncoder.encode(org.bson.BsonWriter, java.lang.Object, org.bson.codecs.EncoderContext):void");
        }

        @Override // org.bson.codecs.Encoder
        public Class<Object> getEncoderClass() {
            return this.morphiaCodec.getEncoderClass();
        }

        protected void encodeDiscriminator(BsonWriter writer, EntityModel model) {
            writer.writeString(model.getDiscriminatorKey(), model.getDiscriminator());
        }

        protected MorphiaCodec getMorphiaCodec() {
            return this.morphiaCodec;
        }

        private <S, V> boolean areEquivalentTypes(Class<S> t1, Class<V> t2) {
            return t1.equals(t2) || (Collection.class.isAssignableFrom(t1) && Collection.class.isAssignableFrom(t2)) || (Map.class.isAssignableFrom(t1) && Map.class.isAssignableFrom(t2));
        }

        protected void encodeIdProperty(BsonWriter writer, Object instance, EncoderContext encoderContext, @Nullable PropertyModel idModel) {
            if (idModel != null) {
                IdGenerator generator = getIdGenerator();
                if (generator == null) {
                    encodeValue(writer, encoderContext, idModel, idModel.getAccessor().get(instance));
                    return;
                }
                Object id = idModel.getAccessor().get(instance);
                if (id == null && encoderContext.isEncodingCollectibleDocument()) {
                    id = generator.generate();
                    idModel.getAccessor().set(instance, id);
                }
                encodeValue(writer, encoderContext, idModel, id);
            }
        }

        /* access modifiers changed from: protected */
        public void encodeValue(BsonWriter writer, EncoderContext encoderContext, PropertyModel model, @Nullable Object value) {
            if (model.shouldSerialize(value)) {
                writeValue(writer, encoderContext, model, value);
            }
        }

        protected void writeValue(BsonWriter writer, EncoderContext encoderContext, PropertyModel model, @Nullable Object value) {
            writer.writeName(model.getMappedName());
            if (value == null) {
                writer.writeNull();
            } else {
                encoderContext.encodeWithChildContext(model.getCachedCodec(), writer, value);
            }
        }

        @Nullable
        private IdGenerator getIdGenerator() {
            PropertyModel idModel;
            if (this.idGenerator == null && (idModel = this.morphiaCodec.getEntityModel().getIdProperty()) != null && idModel.getNormalizedType().isAssignableFrom(ObjectId.class)) {
                this.idGenerator = OBJECT_ID_GENERATOR;
            }
            return this.idGenerator;
        }
    }
