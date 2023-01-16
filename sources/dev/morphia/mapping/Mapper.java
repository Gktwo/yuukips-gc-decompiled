package dev.morphia.mapping;

import com.mongodb.DBCollection;
import com.mongodb.QueryOperators;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.EntityInterceptor;
import dev.morphia.Key;
import dev.morphia.aggregation.experimental.codecs.AggregationCodecProvider;
import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.experimental.EmbeddedBuilder;
import dev.morphia.mapping.codec.EnumCodecProvider;
import dev.morphia.mapping.codec.MorphiaCodecProvider;
import dev.morphia.mapping.codec.MorphiaTypesCodecProvider;
import dev.morphia.mapping.codec.PrimitiveCodecRegistry;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.mapping.codec.reader.DocumentReader;
import dev.morphia.mapping.codec.references.MorphiaProxy;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.mapping.validation.MappingValidator;
import dev.morphia.sofia.Sofia;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:dev/morphia/mapping/Mapper.class */
public class Mapper {
    public static final String IGNORED_FIELDNAME = ".";
    private final Map<Class, EntityModel> mappedEntities = new ConcurrentHashMap();
    private final ConcurrentHashMap<String, Set<EntityModel>> mappedEntitiesByCollection = new ConcurrentHashMap<>();
    private final List<EntityInterceptor> interceptors = new LinkedList();
    private final MapperOptions options;
    private final DiscriminatorLookup discriminatorLookup;
    private final MorphiaCodecProvider morphiaCodecProvider;
    private final Datastore datastore;
    private final CodecRegistry codecRegistry;

    /*  JADX ERROR: Dependency scan failed at insn: 0x003F: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x003F: INVOKE_CUSTOM r2, method: dev.morphia.mapping.Mapper.mapPackage(java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get map classes from package ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get map classes from package ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized void mapPackage(java.lang.String r6) {
        /*
            r5 = this;
            r0 = r5
            r1 = r5
            dev.morphia.mapping.MapperOptions r1 = r1.options
            java.lang.ClassLoader r1 = r1.getClassLoader()
            r2 = r6
            r3 = r5
            dev.morphia.mapping.MapperOptions r3 = r3.getOptions()
            boolean r3 = r3.isMapSubPackages()
            java.util.List r0 = r0.getClasses(r1, r2, r3)
            java.util.stream.Stream r0 = r0.stream()
            r1 = r5
            void r1 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return r1.lambda$mapPackage$1(v1);
            }
            java.util.stream.Stream r0 = r0.map(r1)
            void r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return java.util.Objects.nonNull(v0);
            }
            java.util.stream.Stream r0 = r0.filter(r1)
            java.util.stream.Collector r1 = java.util.stream.Collectors.toList()
            java.lang.Object r0 = r0.collect(r1)
            goto L_0x0049
            r7 = move-exception
            dev.morphia.mapping.MappingException r0 = new dev.morphia.mapping.MappingException
            r1 = r0
            r2 = r6
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get map classes from package ]}
            r3 = r7
            r1.<init>(r2, r3)
            throw r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.Mapper.mapPackage(java.lang.String):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0017: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0017: INVOKE_CUSTOM r2, method: dev.morphia.mapping.Mapper.updateCollection(dev.morphia.Key):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/Key;)Ljava/lang/String;}, Key is invalid! ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/Key;)Ljava/lang/String;}, Key is invalid! ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @java.lang.Deprecated(since = "2.0", forRemoval = true)
    public java.lang.String updateCollection(dev.morphia.Key r5) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r0 = r0.getCollection()
            r6 = r0
            r0 = r5
            java.lang.Class r0 = r0.getType()
            r7 = r0
            r0 = r6
            if (r0 != 0) goto L_0x0020
            r0 = r7
            if (r0 != 0) goto L_0x0020
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/Key;)Ljava/lang/String;}, Key is invalid! ]}
            r1.<init>(r2)
            throw r0
            r0 = r6
            if (r0 != 0) goto L_0x0032
            r0 = r4
            r1 = r7
            dev.morphia.mapping.codec.pojo.EntityModel r0 = r0.getEntityModel(r1)
            java.lang.String r0 = r0.getCollectionName()
            r6 = r0
            r0 = r5
            r1 = r6
            r0.setCollection(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.Mapper.updateCollection(dev.morphia.Key):java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0034: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0034: INVOKE_CUSTOM r4, method: dev.morphia.mapping.Mapper.getClasses(java.lang.ClassLoader, java.lang.String, boolean):java.util.List<java.lang.Class>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .*]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .*]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private java.util.List<java.lang.Class> getClasses(java.lang.ClassLoader r7, java.lang.String r8, boolean r9) throws java.lang.ClassNotFoundException {
        /*
            r6 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r1 = r0
            r1.<init>()
            r10 = r0
            io.github.classgraph.ClassGraph r0 = new io.github.classgraph.ClassGraph
            r1 = r0
            r1.<init>()
            r1 = r7
            io.github.classgraph.ClassGraph r0 = r0.addClassLoader(r1)
            io.github.classgraph.ClassGraph r0 = r0.enableAllInfo()
            r11 = r0
            r0 = r9
            if (r0 == 0) goto L_0x0041
            r0 = r11
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = r1
            r3 = 0
            r4 = r8
            r2[r3] = r4
            io.github.classgraph.ClassGraph r0 = r0.whitelistPackages(r1)
            r0 = r11
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = r1
            r3 = 0
            r4 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, .*]}
            r2[r3] = r4
            io.github.classgraph.ClassGraph r0 = r0.whitelistPackages(r1)
            goto L_0x004f
            r0 = r11
            r1 = 1
            java.lang.String[] r1 = new java.lang.String[r1]
            r2 = r1
            r3 = 0
            r4 = r8
            r2[r3] = r4
            io.github.classgraph.ClassGraph r0 = r0.whitelistPackagesNonRecursive(r1)
            r0 = r11
            io.github.classgraph.ScanResult r0 = r0.scan()
            r12 = r0
            r0 = r12
            io.github.classgraph.ClassInfoList r0 = r0.getAllClasses()
            java.util.Iterator r0 = r0.iterator()
            r13 = r0
            r0 = r13
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x008b
            r0 = r13
            java.lang.Object r0 = r0.next()
            io.github.classgraph.ClassInfo r0 = (p013io.github.classgraph.ClassInfo) r0
            r14 = r0
            r0 = r10
            r1 = r14
            java.lang.String r1 = r1.getName()
            r2 = 1
            r3 = r7
            java.lang.Class r1 = java.lang.Class.forName(r1, r2, r3)
            boolean r0 = r0.add(r1)
            goto L_0x0060
            r0 = r12
            if (r0 == 0) goto L_0x00b3
            r0 = r12
            r0.close()
            goto L_0x00b3
            r13 = move-exception
            r0 = r12
            if (r0 == 0) goto L_0x00b0
            r0 = r12
            r0.close()
            goto L_0x00b0
            r14 = move-exception
            r0 = r13
            r1 = r14
            r0.addSuppressed(r1)
            r0 = r13
            throw r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r2 = r10
            r1.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.Mapper.getClasses(java.lang.ClassLoader, java.lang.String, boolean):java.util.List");
    }

    public Mapper(Datastore datastore, CodecRegistry codecRegistry, MapperOptions options) {
        this.datastore = datastore;
        this.options = options;
        this.morphiaCodecProvider = new MorphiaCodecProvider(this, datastore);
        this.discriminatorLookup = new DiscriminatorLookup(options.getClassLoader());
        this.codecRegistry = CodecRegistries.fromProviders(new MorphiaTypesCodecProvider(this), new PrimitiveCodecRegistry(codecRegistry), new EnumCodecProvider(), new AggregationCodecProvider(this), this.morphiaCodecProvider, codecRegistry);
    }

    public void addInterceptor(EntityInterceptor ei) {
        this.interceptors.add(ei);
    }

    public <T> PropertyModel findIdProperty(Class<?> type) {
        PropertyModel idField = getEntityModel(type).getIdProperty();
        if (idField != null) {
            return idField;
        }
        throw new MappingException(Sofia.idRequired(type.getName(), new Locale[0]));
    }

    public List<EntityModel> map(Class... entityClasses) {
        return map(List.of((Object[]) entityClasses));
    }

    public MongoCollection enforceWriteConcern(MongoCollection collection, Class type) {
        WriteConcern applied = getWriteConcern(type);
        if (applied != null) {
            return collection.withWriteConcern(applied);
        }
        return collection;
    }

    public <T> T fromDocument(Class<T> type, Document document) {
        Class<T> aClass = type;
        if (document.containsKey(this.options.getDiscriminatorKey())) {
            aClass = getClass(document);
        }
        CodecRegistry codecRegistry = getCodecRegistry();
        return codecRegistry.get(aClass).decode(new DocumentReader(document), DecoderContext.builder().build());
    }

    @Nullable
    public <T> Class<T> getClass(Document document) {
        Class c = null;
        String discriminator = (String) document.get(getOptions().getDiscriminatorKey());
        if (discriminator != null) {
            c = getClass(discriminator);
        }
        return c;
    }

    public Class getClass(String discriminator) {
        return this.discriminatorLookup.lookup(discriminator);
    }

    public <T> Class<T> getClassFromCollection(String collection) {
        List<EntityModel> classes = getClassesMappedToCollection(collection);
        if (classes.size() > 1) {
            Sofia.logMoreThanOneMapper(collection, classes.stream().map(c -> {
                return c.getType().getName();
            }).collect(Collectors.joining(", ")), new Locale[0]);
        }
        return (Class<T>) classes.get(0).getType();
    }

    public List<EntityModel> getClassesMappedToCollection(String collection) {
        Set<EntityModel> entities = this.mappedEntitiesByCollection.get(collection);
        if (entities != null && !entities.isEmpty()) {
            return new ArrayList(entities);
        }
        throw new MappingException(Sofia.collectionNotMapped(collection, new Locale[0]));
    }

    public CodecRegistry getCodecRegistry() {
        return this.codecRegistry;
    }

    public <T> MongoCollection<T> getCollection(Class<T> type) {
        EntityModel entityModel = getEntityModel(type);
        MongoCollection<T> collection = this.datastore.getDatabase().getCollection(entityModel.getCollectionName(), type);
        Entity annotation = entityModel.getEntityAnnotation();
        if (!(annotation == null || WriteConcern.valueOf(annotation.concern()) == null)) {
            collection = collection.withWriteConcern(WriteConcern.valueOf(annotation.concern()));
        }
        return collection;
    }

    public DiscriminatorLookup getDiscriminatorLookup() {
        return this.discriminatorLookup;
    }

    public List<EntityModel> map(List<Class> classes) {
        for (Class type : classes) {
            if (!isMappable(type)) {
                throw new MappingException(Sofia.entityOrEmbedded(type.getName(), new Locale[0]));
            }
        }
        return (List) classes.stream().map(this::getEntityModel).filter((v0) -> {
            return Objects.nonNull(v0);
        }).collect(Collectors.toList());
    }

    public EntityModel getEntityModel(Class type) {
        Class actual = MorphiaProxy.class.isAssignableFrom(type) ? type.getSuperclass() : type;
        EntityModel model = this.mappedEntities.get(actual);
        if (model == null) {
            if (!isMappable(actual)) {
                throw new NotMappableException(type);
            }
            model = register(createEntityModel(type));
        }
        return model;
    }

    @Nullable
    public Object getId(@Nullable Object entity) {
        if (entity == null) {
            return null;
        }
        try {
            PropertyModel idField = getEntityModel(entity.getClass()).getIdProperty();
            if (idField != null) {
                return idField.getValue(entity);
            }
            return null;
        } catch (NotMappableException e) {
            return null;
        }
    }

    public Collection<EntityInterceptor> getInterceptors() {
        return this.interceptors;
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    public <T> Key<T> getKey(T entity) {
        if (entity instanceof Key) {
            return (Key) entity;
        }
        Object id = getId(entity);
        Class<?> cls = entity.getClass();
        if (id == null) {
            return null;
        }
        return new Key<>(cls, getEntityModel(cls).getCollectionName(), id);
    }

    @Nullable
    @Deprecated(since = "2.0", forRemoval = true)
    public <T> Key<T> getKey(T entity, String collection) {
        if (entity instanceof Key) {
            return (Key) entity;
        }
        Object id = getId(entity);
        Class<?> cls = entity.getClass();
        if (id == null) {
            return null;
        }
        return new Key<>(cls, collection, id);
    }

    public List<EntityModel> getMappedEntities() {
        return new ArrayList(this.mappedEntities.values());
    }

    public MapperOptions getOptions() {
        return this.options;
    }

    @Deprecated(since = "2.0", forRemoval = true)
    public void setOptions(MapperOptions options) {
    }

    @Nullable
    public WriteConcern getWriteConcern(Class clazz) {
        Entity entityAnn;
        WriteConcern wc = null;
        EntityModel entityModel = getEntityModel(clazz);
        if (!(entityModel == null || (entityAnn = entityModel.getEntityAnnotation()) == null || entityAnn.concern().isEmpty())) {
            wc = WriteConcern.valueOf(entityAnn.concern());
        }
        return wc;
    }

    public boolean hasInterceptors() {
        return !this.interceptors.isEmpty();
    }

    public <T> boolean isMappable(Class<T> type) {
        return hasAnnotation(MorphiaProxy.class.isAssignableFrom(type) ? type.getSuperclass() : type, List.of(Entity.class, Embedded.class));
    }

    public boolean isMapped(Class c) {
        return this.mappedEntities.containsKey(c);
    }

    public <A extends Annotation> EntityModel mapExternal(@Nullable A annotation, Class type) {
        EntityModel model = this.mappedEntities.get(MorphiaProxy.class.isAssignableFrom(type) ? type.getSuperclass() : type);
        if (model == null) {
            if (annotation == null) {
                annotation = EmbeddedBuilder.builder();
            }
            model = register(createEntityModel(type, annotation));
        }
        return model;
    }

    private <T> EntityModel createEntityModel(Class<T> clazz) {
        return new EntityModelBuilder(this.datastore, clazz).build();
    }

    private <T, A extends Annotation> EntityModel createEntityModel(Class<T> clazz, A annotation) {
        return new EntityModelBuilder(this.datastore, annotation, clazz).build();
    }

    public void mapPackageFromClass(Class clazz) {
        mapPackage(clazz.getPackage().getName());
    }

    public <T> void refresh(T entity) {
        Codec<T> refreshCodec = this.morphiaCodecProvider.getRefreshCodec(entity, getCodecRegistry());
        MongoCollection<?> collection = getCollection(entity.getClass());
        PropertyModel idField = getEntityModel(entity.getClass()).getIdProperty();
        if (idField == null) {
            throw new MappingException(Sofia.idRequired(entity.getClass().getName(), new Locale[0]));
        }
        refreshCodec.decode(new DocumentReader((Document) collection.find(new Document(DBCollection.ID_FIELD_NAME, idField.getValue(entity)), Document.class).iterator().next()), DecoderContext.builder().checkedDiscriminator(true).build());
    }

    public Document toDocument(Object entity) {
        EntityModel entityModel = getEntityModel(entity.getClass());
        DocumentWriter writer = new DocumentWriter(this);
        getCodecRegistry().get(entityModel.getType()).encode(writer, entity, EncoderContext.builder().build());
        return writer.getDocument();
    }

    public void updateQueryWithDiscriminators(EntityModel model, Document query) {
        Entity annotation = model.getEntityAnnotation();
        if (!(annotation == null || !annotation.useDiscriminator() || query.containsKey(DBCollection.ID_FIELD_NAME) || query.containsKey(model.getDiscriminatorKey()))) {
            List<EntityModel> subtypes = model.getSubtypes();
            List<String> values = new ArrayList<>();
            values.add(model.getDiscriminator());
            if (this.options.isEnablePolymorphicQueries()) {
                for (EntityModel subtype : subtypes) {
                    values.add(subtype.getDiscriminator());
                }
            }
            query.put(model.getDiscriminatorKey(), (Object) new Document(QueryOperators.f432IN, values));
        }
    }

    private String discriminatorKey(Class<?> type) {
        return this.mappedEntities.get(type).getDiscriminatorKey();
    }

    /* JADX DEBUG: Type inference failed for r0v19. Raw type applied. Possible types: java.lang.Class<? extends java.lang.annotation.Annotation>, java.lang.Class<A extends java.lang.annotation.Annotation> */
    private <T> boolean hasAnnotation(Class<T> clazz, List<Class<? extends Annotation>> annotations) {
        Iterator<Class<? extends Annotation>> it = annotations.iterator();
        while (it.hasNext()) {
            if (clazz.getAnnotation(it.next()) != null) {
                return true;
            }
        }
        return (clazz.getSuperclass() != null && hasAnnotation(clazz.getSuperclass(), annotations)) || ((Boolean) Arrays.stream(clazz.getInterfaces()).map(i -> {
            return Boolean.valueOf(hasAnnotation(annotations, annotations));
        }).reduce(false, l, r -> {
            return Boolean.valueOf(l.booleanValue() || r.booleanValue());
        })).booleanValue();
    }

    private EntityModel register(EntityModel entityModel) {
        this.discriminatorLookup.addModel(entityModel);
        this.mappedEntities.put(entityModel.getType(), entityModel);
        if (entityModel.getCollectionName() != null) {
            this.mappedEntitiesByCollection.computeIfAbsent(entityModel.getCollectionName(), s -> {
                return new CopyOnWriteArraySet();
            }).add(entityModel);
        }
        if (!entityModel.isInterface()) {
            new MappingValidator().validate(this, entityModel);
        }
        return entityModel;
    }
}
