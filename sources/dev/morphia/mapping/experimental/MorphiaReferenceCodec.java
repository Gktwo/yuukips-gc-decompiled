package dev.morphia.mapping.experimental;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.BaseReferenceCodec;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyHandler;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.pojo.TypeData;
import dev.morphia.mapping.codec.references.ReferenceCodec;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.mapping.lazy.proxy.ReferenceException;
import dev.morphia.sofia.Sofia;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/MorphiaReferenceCodec.class */
public class MorphiaReferenceCodec extends BaseReferenceCodec<MorphiaReference> implements PropertyHandler {
    private final Mapper mapper;
    private final BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap();

    public MorphiaReferenceCodec(Datastore datastore, PropertyModel propertyModel) {
        super(datastore, propertyModel);
        this.mapper = datastore.getMapper();
    }

    @Override // org.bson.codecs.Decoder
    public MorphiaReference decode(BsonReader reader, DecoderContext decoderContext) {
        Mapper mapper = getDatastore().getMapper();
        Object value = ReferenceCodec.processId(mapper.getCodecRegistry().get(this.bsonTypeClassMap.get(reader.getCurrentBsonType())).decode(reader, decoderContext), mapper, decoderContext);
        TypeData typeData = getTypeData().getTypeParameters().get(0);
        EntityModel fieldEntityModel = getEntityModelForField();
        if (Set.class.isAssignableFrom(typeData.getType())) {
            return new SetReference(getDatastore(), fieldEntityModel, (List) value);
        }
        if (Collection.class.isAssignableFrom(typeData.getType())) {
            return new ListReference(getDatastore(), fieldEntityModel, (List) value);
        }
        if (Map.class.isAssignableFrom(typeData.getType())) {
            return new MapReference(getDatastore(), (Map) value, fieldEntityModel);
        }
        return new SingleReference(getDatastore(), fieldEntityModel, value);
    }

    @Override // dev.morphia.mapping.codec.pojo.PropertyHandler
    public Object encode(@Nullable Object value) {
        MorphiaReference<Object> wrap;
        if (value != null) {
            if (value instanceof MorphiaReference) {
                wrap = (MorphiaReference) value;
            } else {
                wrap = MorphiaReference.wrap(value);
            }
            DocumentWriter writer = new DocumentWriter(this.mapper);
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x002d: INVOKE  
                  (r0v4 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter)])
                  (wrap: java.lang.Runnable : 0x0028: INVOKE_CUSTOM (r1v3 java.lang.Runnable A[REMOVE]) = 
                  (r5v0 'this' dev.morphia.mapping.experimental.MorphiaReferenceCodec A[D('this' dev.morphia.mapping.experimental.MorphiaReferenceCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v4 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter), DONT_INLINE])
                  (r7v0 'wrap' dev.morphia.mapping.experimental.MorphiaReference<java.lang.Object> A[D('wrap' dev.morphia.mapping.experimental.MorphiaReference<java.lang.Object>), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.mapping.experimental.MorphiaReferenceCodec)
                  (r2 I:dev.morphia.mapping.codec.writer.DocumentWriter)
                  (r3 I:dev.morphia.mapping.experimental.MorphiaReference)
                 type: DIRECT call: dev.morphia.mapping.experimental.MorphiaReferenceCodec.lambda$encode$0(dev.morphia.mapping.codec.writer.DocumentWriter, dev.morphia.mapping.experimental.MorphiaReference):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.experimental.MorphiaReferenceCodec.encode(java.lang.Object):java.lang.Object, file: grasscutter.jar:dev/morphia/mapping/experimental/MorphiaReferenceCodec.class
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
                	... 23 more
                */
            /*
                this = this;
                r0 = r6
                if (r0 == 0) goto L_0x003a
                r0 = r6
                boolean r0 = r0 instanceof dev.morphia.mapping.experimental.MorphiaReference
                if (r0 == 0) goto L_0x0013
                r0 = r6
                dev.morphia.mapping.experimental.MorphiaReference r0 = (dev.morphia.mapping.experimental.MorphiaReference) r0
                r7 = r0
                goto L_0x0018
            L_0x0013:
                r0 = r6
                dev.morphia.mapping.experimental.MorphiaReference r0 = dev.morphia.mapping.experimental.MorphiaReference.wrap(r0)
                r7 = r0
            L_0x0018:
                dev.morphia.mapping.codec.writer.DocumentWriter r0 = new dev.morphia.mapping.codec.writer.DocumentWriter
                r1 = r0
                r2 = r5
                dev.morphia.mapping.Mapper r2 = r2.mapper
                r1.<init>(r2)
                r8 = r0
                r0 = r8
                r1 = r5
                r2 = r8
                r3 = r7
                java.lang.Object r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$encode$0(r2, r3);
                }
                dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
                r0 = r8
                org.bson.Document r0 = r0.getDocument()
                java.lang.String r1 = "ref"
                java.lang.Object r0 = r0.get(r1)
                return r0
            L_0x003a:
                java.lang.NullPointerException r0 = new java.lang.NullPointerException
                r1 = r0
                r1.<init>()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.experimental.MorphiaReferenceCodec.encode(java.lang.Object):java.lang.Object");
        }

        public void encode(BsonWriter writer, MorphiaReference value, EncoderContext encoderContext) {
            Object ids = value.getId(this.mapper, getDatastore(), getEntityModelForField());
            if (ids == null || (((ids instanceof Collection) && ((Collection) ids).isEmpty()) || ((ids instanceof Map) && ((Map) ids).isEmpty()))) {
                throw new ReferenceException(Sofia.noIdForReference(new Locale[0]));
            }
            this.mapper.getCodecRegistry().get(ids.getClass()).encode(writer, ids, encoderContext);
        }

        @Override // org.bson.codecs.Encoder
        public Class getEncoderClass() {
            return MorphiaReference.class;
        }
    }
