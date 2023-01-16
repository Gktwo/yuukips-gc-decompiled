package dev.morphia.mapping.codec.references;

import com.mongodb.DBCollection;
import com.mongodb.DBRef;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.Key;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.BaseReferenceCodec;
import dev.morphia.mapping.codec.Conversions;
import dev.morphia.mapping.codec.pojo.PropertyHandler;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.pojo.TypeData;
import dev.morphia.mapping.codec.reader.DocumentReader;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.mapping.experimental.ListReference;
import dev.morphia.mapping.experimental.MapReference;
import dev.morphia.mapping.experimental.MorphiaReference;
import dev.morphia.mapping.experimental.SetReference;
import dev.morphia.mapping.experimental.SingleReference;
import dev.morphia.mapping.lazy.proxy.ReferenceException;
import dev.morphia.query.QueryException;
import dev.morphia.sofia.Sofia;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.TypeCache;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/references/ReferenceCodec.class */
public class ReferenceCodec extends BaseReferenceCodec<Object> implements PropertyHandler {
    private final Reference annotation;
    private final Mapper mapper;
    private static final String FIELD_INVOCATION_HANDLER = "handler";
    private final BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap();
    private final TypeCache<TypeCache.SimpleKey> typeCache = new TypeCache.WithInlineExpunction(TypeCache.Sort.SOFT);

    /*  JADX ERROR: Dependency scan failed at insn: 0x0039: INVOKE_CUSTOM r-1
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0039: INVOKE_CUSTOM r2, method: dev.morphia.mapping.codec.references.ReferenceCodec.encodeId(dev.morphia.mapping.Mapper, java.lang.Object, dev.morphia.mapping.codec.pojo.EntityModel):java.lang.Object
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;)Ljava/lang/String;}, The type for the reference could not be determined for the key ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;)Ljava/lang/String;}, The type for the reference could not be determined for the key ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @com.mongodb.lang.Nullable
    public static java.lang.Object encodeId(dev.morphia.mapping.Mapper r5, java.lang.Object r6, dev.morphia.mapping.codec.pojo.EntityModel r7) {
        /*
            r0 = r6
            boolean r0 = r0 instanceof dev.morphia.Key
            if (r0 == 0) goto L_0x0045
            r0 = r6
            dev.morphia.Key r0 = (dev.morphia.Key) r0
            java.lang.Object r0 = r0.getId()
            r8 = r0
            r0 = r6
            dev.morphia.Key r0 = (dev.morphia.Key) r0
            java.lang.String r0 = r0.getCollection()
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x0026
            r0 = r5
            r1 = r11
            java.lang.Class r0 = r0.getClassFromCollection(r1)
            goto L_0x002d
            r0 = r6
            dev.morphia.Key r0 = (dev.morphia.Key) r0
            java.lang.Class r0 = r0.getType()
            r10 = r0
            r0 = r10
            if (r0 != 0) goto L_0x0042
            dev.morphia.mapping.MappingException r0 = new dev.morphia.mapping.MappingException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/Object;)Ljava/lang/String;}, The type for the reference could not be determined for the key ]}
            r1.<init>(r2)
            throw r0
            goto L_0x0066
            r0 = r5
            r1 = r6
            java.lang.Object r0 = r0.getId(r1)
            r8 = r0
            r0 = r8
            if (r0 != 0) goto L_0x0060
            r0 = r5
            r1 = r6
            java.lang.Class r1 = r1.getClass()
            boolean r0 = r0.isMappable(r1)
            if (r0 != 0) goto L_0x005e
            r0 = r6
            goto L_0x005f
            r0 = 0
            return r0
            r0 = r6
            java.lang.Class r0 = r0.getClass()
            r10 = r0
            r0 = r5
            r1 = r10
            com.mongodb.client.MongoCollection r0 = r0.getCollection(r1)
            r9 = r0
            r0 = r9
            com.mongodb.MongoNamespace r0 = r0.getNamespace()
            java.lang.String r0 = r0.getCollectionName()
            r11 = r0
            r0 = r7
            java.lang.String r0 = r0.getCollectionName()
            r12 = r0
            r0 = r7
            java.lang.Class<dev.morphia.annotations.Reference> r1 = dev.morphia.annotations.Reference.class
            java.lang.annotation.Annotation r0 = r0.getAnnotation(r1)
            dev.morphia.annotations.Reference r0 = (dev.morphia.annotations.Reference) r0
            r13 = r0
            r0 = r13
            if (r0 == 0) goto L_0x009a
            r0 = r13
            boolean r0 = r0.idOnly()
            if (r0 == 0) goto L_0x00a4
            r0 = r11
            r1 = r12
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00af
            com.mongodb.DBRef r0 = new com.mongodb.DBRef
            r1 = r0
            r2 = r11
            r3 = r8
            r1.<init>(r2, r3)
            r8 = r0
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.references.ReferenceCodec.encodeId(dev.morphia.mapping.Mapper, java.lang.Object, dev.morphia.mapping.codec.pojo.EntityModel):java.lang.Object");
    }

    public ReferenceCodec(Datastore datastore, PropertyModel propertyModel) {
        super(datastore, propertyModel);
        this.mapper = datastore.getMapper();
        this.annotation = (Reference) propertyModel.getAnnotation(Reference.class);
    }

    @Nullable
    public static Object encodeId(Mapper mapper, Datastore datastore, Object value, PropertyModel model) {
        MongoCollection<?> collection;
        Object idValue;
        if (value instanceof Key) {
            idValue = ((Key) value).getId();
            String collectionName = ((Key) value).getCollection();
            Class<?> type = ((Key) value).getType();
            if (collectionName == null || type == null) {
                throw new QueryException("Missing type or collection information in key");
            }
            collection = datastore.getDatabase().getCollection(collectionName, type);
        } else {
            idValue = mapper.getId(value);
            if (idValue != null || getReferenceAnnotation(model).ignoreMissing()) {
                collection = mapper.getCollection(value.getClass());
            } else if (!mapper.isMappable(value.getClass())) {
                return value;
            } else {
                throw new QueryException("No ID value found on referenced entity.  Save referenced entities before defining references to them.");
            }
        }
        String valueCollectionName = collection.getNamespace().getCollectionName();
        Reference annotation = (Reference) model.getAnnotation(Reference.class);
        if (annotation != null && !annotation.idOnly()) {
            idValue = new DBRef(valueCollectionName, idValue);
        }
        return idValue;
    }

    @NonNull
    public static Object processId(Object decode, Mapper mapper, DecoderContext decoderContext) {
        Object id = decode;
        if (id instanceof Iterable) {
            List<? super Object> ids = new ArrayList<>();
            Iterator<?> it = ((Iterable) id).iterator();
            while (it.hasNext()) {
                ids.add(processId(it.next(), mapper, decoderContext));
            }
            id = ids;
        } else if (id instanceof Document) {
            Document document = (Document) id;
            if (document.containsKey("$ref")) {
                id = processId(new DBRef(document.getString("$db"), document.getString("$ref"), document.get("$id")), mapper, decoderContext);
            } else if (document.containsKey(mapper.getOptions().getDiscriminatorKey())) {
                try {
                    id = mapper.getCodecRegistry().get(mapper.getClass(document)).decode(new DocumentReader(document), decoderContext);
                } catch (CodecConfigurationException e) {
                    throw new MappingException(Sofia.cannotFindTypeInDocument(new Locale[0]), e);
                }
            }
        } else if (id instanceof DBRef) {
            DBRef ref = (DBRef) id;
            Object refId = ref.getId();
            if (refId instanceof Document) {
                refId = mapper.getCodecRegistry().get(Object.class).decode(new DocumentReader((Document) refId), decoderContext);
            }
            id = new DBRef(ref.getDatabaseName(), ref.getCollectionName(), refId);
        }
        return id;
    }

    @Override // org.bson.codecs.Decoder
    @Nullable
    public Object decode(BsonReader reader, DecoderContext decoderContext) {
        return fetch(processId(getDatastore().getMapper().getCodecRegistry().get(this.bsonTypeClassMap.get(reader.getCurrentBsonType())).decode(reader, decoderContext), getDatastore().getMapper(), decoderContext));
    }

    private static TypeCache.SimpleKey getCacheKey(Class<?> type) {
        return new TypeCache.SimpleKey(type, Arrays.asList(type.getInterfaces()));
    }

    @Override // org.bson.codecs.Encoder
    public void encode(BsonWriter writer, Object instance, EncoderContext encoderContext) {
        Object idValue = collectIdValues(instance);
        if (idValue != null) {
            getDatastore().getMapper().getCodecRegistry().get(idValue.getClass()).encode(writer, idValue, encoderContext);
        } else if (getReferenceAnnotation(getPropertyModel()).ignoreMissing()) {
            writer.writeNull();
        } else {
            throw new ReferenceException(Sofia.noIdForReference(new Locale[0]));
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class getEncoderClass() {
        TypeData<?> type = getTypeData();
        List<?> typeParameters = type.getTypeParameters();
        if (!typeParameters.isEmpty()) {
            type = typeParameters.get(typeParameters.size() - 1);
        }
        return type.getType();
    }

    @Nullable
    private Object collectIdValues(Object value) {
        if (value instanceof Collection) {
            List<Object> ids = new ArrayList<>(((Collection) value).size());
            for (Object o : (Collection) value) {
                ids.add(collectIdValues(o));
            }
            return ids;
        } else if (value instanceof Map) {
            Map<Object, Object> ids2 = new LinkedHashMap<>();
            for (Map.Entry<Object, Object> o2 : ((Map) value).entrySet()) {
                ids2.put(o2.getKey().toString(), collectIdValues(o2.getValue()));
            }
            return ids2;
        } else if (!value.getClass().isArray()) {
            return encodeId(getDatastore().getMapper(), getDatastore(), value, getPropertyModel());
        } else {
            List<Object> ids3 = new ArrayList<>(((Object[]) value).length);
            for (Object o3 : (Object[]) value) {
                ids3.add(collectIdValues(o3));
            }
            return ids3;
        }
    }

    @Override // dev.morphia.mapping.codec.pojo.PropertyHandler
    public Object encode(@Nullable Object value) {
        try {
            DocumentWriter writer = new DocumentWriter(this.mapper);
            ExpressionHelper.document(writer, ()
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0015: INVOKE  
                  (r0v1 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter)])
                  (wrap: java.lang.Runnable : 0x0010: INVOKE_CUSTOM (r1v2 java.lang.Runnable A[REMOVE]) = 
                  (r5v0 'this' dev.morphia.mapping.codec.references.ReferenceCodec A[D('this' dev.morphia.mapping.codec.references.ReferenceCodec), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                  (r0v1 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter), DONT_INLINE])
                  (r6v0 'value' java.lang.Object A[D('value' java.lang.Object), DONT_INLINE])
                
                 handle type: INVOKE_DIRECT
                 lambda: java.lang.Runnable.run():void
                 call insn: ?: INVOKE  
                  (r1 I:dev.morphia.mapping.codec.references.ReferenceCodec)
                  (r2 I:dev.morphia.mapping.codec.writer.DocumentWriter)
                  (r3 I:java.lang.Object)
                 type: DIRECT call: dev.morphia.mapping.codec.references.ReferenceCodec.lambda$encode$0(dev.morphia.mapping.codec.writer.DocumentWriter, java.lang.Object):void)
                 type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.mapping.codec.references.ReferenceCodec.encode(java.lang.Object):java.lang.Object, file: grasscutter.jar:dev/morphia/mapping/codec/references/ReferenceCodec.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
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
                	... 21 more
                */
            /*
                this = this;
                dev.morphia.mapping.codec.writer.DocumentWriter r0 = new dev.morphia.mapping.codec.writer.DocumentWriter     // Catch: ReferenceException -> 0x0022
                r1 = r0
                r2 = r5
                dev.morphia.mapping.Mapper r2 = r2.mapper     // Catch: ReferenceException -> 0x0022
                r1.<init>(r2)     // Catch: ReferenceException -> 0x0022
                r7 = r0
                r0 = r7
                r1 = r5
                r2 = r7
                r3 = r6
                java.lang.Object r1 = () -> { // java.lang.Runnable.run():void
                    r1.lambda$encode$0(r2, r3);
                }     // Catch: ReferenceException -> 0x0022
                dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)     // Catch: ReferenceException -> 0x0022
                r0 = r7
                org.bson.Document r0 = r0.getDocument()     // Catch: ReferenceException -> 0x0022
                java.lang.String r1 = "ref"
                java.lang.Object r0 = r0.get(r1)     // Catch: ReferenceException -> 0x0022
                return r0
            L_0x0022:
                r7 = move-exception
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.references.ReferenceCodec.encode(java.lang.Object):java.lang.Object");
        }

        private <T> T createProxy(MorphiaReference<?> reference) {
            ReferenceProxy referenceProxy = new ReferenceProxy(reference);
            try {
                Class<?> type = getPropertyModel().getType();
                Class<?> findOrInsert = this.typeCache.findOrInsert(type.getClassLoader(), getCacheKey(type), () -> {
                    return makeProxy();
                }, this.typeCache);
                T proxy = (T) findOrInsert.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Field field = findOrInsert.getDeclaredField(FIELD_INVOCATION_HANDLER);
                field.setAccessible(true);
                field.set(proxy, referenceProxy);
                return proxy;
            } catch (IllegalArgumentException | ReflectiveOperationException e) {
                throw new MappingException(e.getMessage(), e);
            }
        }

        /* JADX DEBUG: Type inference failed for r0v18. Raw type applied. Possible types: java.lang.Class<? extends T>, java.lang.Class<T> */
        private <T> Class<T> makeProxy() {
            PropertyModel propertyModel = getPropertyModel();
            Class<?> type = propertyModel.getType();
            DynamicType.Builder<T> name = new ByteBuddy().subclass((Class) type).implement(MorphiaProxy.class).name(String.format("%s$%s$$ReferenceProxy", propertyModel.getEntityModel().getName(), propertyModel.getName()));
            ElementMatcher.Junction<ByteCodeElement> matcher = ElementMatchers.isDeclaredBy(type);
            if (!type.isInterface()) {
                Class<?> type2 = type.getSuperclass();
                while (type2 != null && !type2.equals(Object.class)) {
                    matcher = matcher.mo105or(ElementMatchers.isDeclaredBy(type2));
                    type2 = type2.getSuperclass();
                }
            }
            return (Class<? extends T>) name.invokable(matcher.mo105or(ElementMatchers.isDeclaredBy(MorphiaProxy.class))).intercept(InvocationHandlerAdapter.toField(FIELD_INVOCATION_HANDLER)).defineField(FIELD_INVOCATION_HANDLER, InvocationHandler.class, Visibility.PRIVATE).make().load(Thread.currentThread().getContextClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded();
        }

        @Nullable
        private Object fetch(Object value) {
            MorphiaReference<?> reference;
            Class<?> type = getPropertyModel().getType();
            if (List.class.isAssignableFrom(type)) {
                reference = readList((List) value);
            } else if (Map.class.isAssignableFrom(type)) {
                reference = readMap((Map) value);
            } else if (Set.class.isAssignableFrom(type)) {
                reference = readSet((List) value);
            } else if (type.isArray()) {
                reference = readList((List) value);
            } else if (value instanceof Document) {
                reference = readDocument((Document) value);
            } else {
                reference = readSingle(value);
            }
            reference.ignoreMissing(this.annotation.ignoreMissing());
            return !this.annotation.lazy() ? reference.get() : createProxy(reference);
        }

        private List<?> mapToEntitiesIfNecessary(List<?> value) {
            Codec<?> codec = getDatastore().getMapper().getCodecRegistry().get(getEntityModelForField().getType());
            return (List) value.stream().filter(v -> {
                return (v instanceof Document) && ((Document) v).containsKey(DBCollection.ID_FIELD_NAME);
            }).map(d -> {
                return codec.decode(new DocumentReader((Document) d), DecoderContext.builder().build());
            }).collect(Collectors.toList());
        }

        MorphiaReference<?> readDocument(Document value) {
            return readSingle(getDatastore().getMapper().getCodecRegistry().get(Object.class).decode(new DocumentReader(value), DecoderContext.builder().build()));
        }

        MorphiaReference<?> readList(List<?> value) {
            List<?> mapped = mapToEntitiesIfNecessary(value);
            if (mapped.isEmpty()) {
                return new ListReference(getDatastore(), getEntityModelForField(), value);
            }
            return new ListReference(mapped);
        }

        MorphiaReference<?> readMap(Map<Object, Object> value) {
            Map<Object, Object> ids = new LinkedHashMap<>();
            Class<?> keyType = getTypeData().getTypeParameters().get(0).getType();
            for (Map.Entry<Object, Object> entry : value.entrySet()) {
                ids.put(Conversions.convert(entry.getKey(), keyType), entry.getValue());
            }
            return new MapReference(getDatastore(), ids, getEntityModelForField());
        }

        MorphiaReference<?> readSet(List<?> value) {
            List<?> mapped = mapToEntitiesIfNecessary(value);
            if (mapped.isEmpty()) {
                return new SetReference(getDatastore(), getEntityModelForField(), value);
            }
            return new SetReference(new LinkedHashSet(mapped));
        }

        MorphiaReference<?> readSingle(Object value) {
            return new SingleReference(getDatastore(), getEntityModelForField(), value);
        }
    }
