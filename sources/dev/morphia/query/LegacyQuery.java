package dev.morphia.query;

import com.mongodb.CursorType;
import com.mongodb.DBCollection;
import com.mongodb.ExplainVerbosity;
import com.mongodb.QueryOperators;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.DatastoreImpl;
import dev.morphia.DeleteOptions;
import dev.morphia.annotations.Entity;
import dev.morphia.internal.MorphiaInternals;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.query.experimental.updates.UpdateOperator;
import dev.morphia.query.internal.MorphiaCursor;
import dev.morphia.query.internal.MorphiaKeyCursor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/query/LegacyQuery.class */
public class LegacyQuery<T> implements CriteriaContainer, Query<T> {
    private static final Logger LOG = LoggerFactory.getLogger(LegacyQuery.class);
    private final DatastoreImpl datastore;
    private final Class<T> clazz;
    private final Mapper mapper;
    private final String collectionName;
    private final MongoCollection<T> collection;
    private final EntityModel model;
    private final CriteriaContainer compoundContainer;
    private boolean validateName = true;
    private boolean validateType = true;
    private Document baseQuery;
    @Deprecated
    private FindOptions options;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r2, method: dev.morphia.query.LegacyQuery.filter(java.lang.String, java.lang.Object):dev.morphia.query.Query<T>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, '' is not a legal filter condition]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, '' is not a legal filter condition]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.Query
    public dev.morphia.query.Query<T> filter(java.lang.String r14, java.lang.Object r15) {
        /*
            r13 = this;
            r0 = r14
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            r16 = r0
            r0 = r16
            int r0 = r0.length
            r1 = 1
            if (r0 < r1) goto L_0x0017
            r0 = r16
            int r0 = r0.length
            r1 = 6
            if (r0 <= r1) goto L_0x0025
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r14
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, '' is not a legal filter condition]}
            r1.<init>(r2)
            throw r0
            r0 = r16
            r1 = 0
            r0 = r0[r1]
            java.lang.String r0 = r0.trim()
            r17 = r0
            r0 = r16
            int r0 = r0.length
            r1 = 2
            if (r0 != r1) goto L_0x003d
            r0 = r13
            r1 = r16
            r2 = 1
            r1 = r1[r2]
            dev.morphia.query.FilterOperator r0 = r0.translate(r1)
            goto L_0x0040
            dev.morphia.query.FilterOperator r0 = dev.morphia.query.FilterOperator.EQUAL
            r18 = r0
            r0 = r13
            r1 = 1
            dev.morphia.query.Criteria[] r1 = new dev.morphia.query.Criteria[r1]
            r2 = r1
            r3 = 0
            dev.morphia.query.FieldCriteria r4 = new dev.morphia.query.FieldCriteria
            r5 = r4
            r6 = r13
            dev.morphia.mapping.Mapper r6 = r6.mapper
            r7 = r17
            r8 = r18
            r9 = r15
            r10 = r13
            dev.morphia.mapping.Mapper r10 = r10.mapper
            r11 = r13
            java.lang.Class r11 = r11.getEntityClass()
            dev.morphia.mapping.codec.pojo.EntityModel r10 = r10.getEntityModel(r11)
            r11 = r13
            boolean r11 = r11.isValidatingNames()
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r2[r3] = r4
            r0.add(r1)
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.LegacyQuery.filter(java.lang.String, java.lang.Object):dev.morphia.query.Query");
    }

    /* access modifiers changed from: protected */
    public LegacyQuery(Datastore datastore, @Nullable String collectionName, Class<T> clazz) {
        this.clazz = clazz;
        this.datastore = (DatastoreImpl) datastore;
        this.mapper = this.datastore.getMapper();
        this.model = this.mapper.getEntityModel(clazz);
        if (collectionName != null) {
            this.collection = datastore.getDatabase().getCollection(collectionName, clazz);
            this.collectionName = collectionName;
        } else {
            this.collection = this.mapper.getCollection(clazz);
            this.collectionName = this.collection.getNamespace().getCollectionName();
        }
        this.compoundContainer = new CriteriaContainerImpl(this.mapper, this, CriteriaJoin.AND);
    }

    @Override // dev.morphia.query.CriteriaContainer
    public void add(Criteria... criteria) {
        for (Criteria c : criteria) {
            c.attach(this);
            this.compoundContainer.add(c);
        }
    }

    @Override // dev.morphia.query.CriteriaContainer
    public CriteriaContainer and(Criteria... criteria) {
        return this.compoundContainer.and(criteria);
    }

    @Override // dev.morphia.query.CriteriaContainer
    public FieldEnd<? extends CriteriaContainer> criteria(String field) {
        CriteriaContainerImpl container = new CriteriaContainerImpl(this.mapper, this, CriteriaJoin.AND);
        add(container);
        return new FieldEndImpl(this.mapper, field, container, this.model, isValidatingNames());
    }

    @Override // dev.morphia.query.CriteriaContainer
    /* renamed from: or */
    public CriteriaContainer mo1224or(Criteria... criteria) {
        return this.compoundContainer.mo1224or(criteria);
    }

    @Override // dev.morphia.query.CriteriaContainer
    public void remove(Criteria criteria) {
        this.compoundContainer.remove(criteria);
    }

    @Override // dev.morphia.query.Criteria
    public void attach(CriteriaContainer container) {
        this.compoundContainer.attach(container);
    }

    @Override // dev.morphia.query.Criteria
    public String getFieldName() {
        throw new UnsupportedOperationException("this method is unused on a Query");
    }

    @Override // dev.morphia.query.Query
    @Deprecated(since = "2.0", forRemoval = true)
    public MorphiaCursor<T> execute() {
        return iterator();
    }

    @Override // dev.morphia.query.Query
    public long count() {
        return count(new CountOptions());
    }

    @Override // dev.morphia.query.Query
    public long count(CountOptions options) {
        ClientSession session = this.datastore.findSession(options);
        return session == null ? getCollection().countDocuments(getQueryDocument(), options) : getCollection().countDocuments(session, getQueryDocument(), options);
    }

    @Override // dev.morphia.query.Query
    public T findAndDelete(FindAndDeleteOptions options) {
        MongoCollection<C> prepare = options.prepare(getCollection());
        ClientSession session = this.datastore.findSession(options);
        if (session == null) {
            return (T) prepare.findOneAndDelete(getQueryDocument(), options);
        }
        return (T) prepare.findOneAndDelete(session, getQueryDocument(), options);
    }

    @Override // dev.morphia.query.Query
    public DeleteResult delete(DeleteOptions options) {
        MongoCollection<C> prepare = options.prepare(getCollection());
        ClientSession session = this.datastore.findSession(options);
        if (options.isMulti()) {
            if (session == null) {
                return prepare.deleteMany(getQueryDocument(), options);
            }
            return prepare.deleteMany(session, getQueryDocument(), options);
        } else if (session == null) {
            return prepare.deleteOne(getQueryDocument(), options);
        } else {
            return prepare.deleteOne(session, getQueryDocument(), options);
        }
    }

    @Override // dev.morphia.query.Query
    public Query<T> disableValidation() {
        this.validateName = false;
        this.validateType = false;
        return this;
    }

    @Override // dev.morphia.query.Query
    public Query<T> enableValidation() {
        this.validateName = true;
        this.validateType = true;
        return this;
    }

    @Override // dev.morphia.query.Query
    @Deprecated(since = "2.0", forRemoval = true)
    public MorphiaCursor<T> execute(FindOptions options) {
        return iterator(options);
    }

    @Override // dev.morphia.query.Query
    public Map<String, Object> explain(FindOptions options, @Nullable ExplainVerbosity verbosity) {
        return (Map) MorphiaInternals.tryInvoke(MorphiaInternals.DriverVersion.v4_2_0, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: RETURN  
              (wrap: java.util.Map<java.lang.String, java.lang.Object> : 0x0014: CHECK_CAST (r0v2 java.util.Map<java.lang.String, java.lang.Object> A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0011: INVOKE  (r0v1 java.lang.Object A[REMOVE]) = 
              (wrap: dev.morphia.internal.MorphiaInternals$DriverVersion : 0x0000: SGET  (r0v0 dev.morphia.internal.MorphiaInternals$DriverVersion A[REMOVE]) =  dev.morphia.internal.MorphiaInternals.DriverVersion.v4_2_0 dev.morphia.internal.MorphiaInternals$DriverVersion)
              (wrap: java.util.function.Supplier : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier A[REMOVE]) = 
              (r5v0 'this' dev.morphia.query.LegacyQuery<T> A[D('this' dev.morphia.query.LegacyQuery<T>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'verbosity' com.mongodb.ExplainVerbosity A[D('verbosity' com.mongodb.ExplainVerbosity), DONT_INLINE])
              (r6v0 'options' dev.morphia.query.FindOptions A[D('options' dev.morphia.query.FindOptions), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:dev.morphia.query.LegacyQuery), (r2 I:com.mongodb.ExplainVerbosity), (r3 I:dev.morphia.query.FindOptions) type: DIRECT call: dev.morphia.query.LegacyQuery.lambda$explain$0(com.mongodb.ExplainVerbosity, dev.morphia.query.FindOptions):java.io.Serializable)
              (wrap: java.util.function.Supplier : 0x000c: INVOKE_CUSTOM (r2v2 java.util.function.Supplier A[REMOVE]) = 
              (r5v0 'this' dev.morphia.query.LegacyQuery<T> A[D('this' dev.morphia.query.LegacyQuery<T>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r2 I:dev.morphia.query.LegacyQuery) type: DIRECT call: dev.morphia.query.LegacyQuery.lambda$explain$1():java.io.Serializable)
             type: STATIC call: dev.morphia.internal.MorphiaInternals.tryInvoke(dev.morphia.internal.MorphiaInternals$DriverVersion, java.util.function.Supplier, java.util.function.Supplier):java.lang.Object))
             in method: dev.morphia.query.LegacyQuery.explain(dev.morphia.query.FindOptions, com.mongodb.ExplainVerbosity):java.util.Map<java.lang.String, java.lang.Object>, file: grasscutter.jar:dev/morphia/query/LegacyQuery.class
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
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:320)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            dev.morphia.internal.MorphiaInternals$DriverVersion r0 = dev.morphia.internal.MorphiaInternals.DriverVersion.v4_2_0
            r1 = r5
            r2 = r7
            r3 = r6
            java.util.Map<java.lang.String, java.lang.Object> r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return r1.lambda$explain$0(r2, r3);
            }
            r2 = r5
            java.util.Map<java.lang.String, java.lang.Object> r2 = () -> { // java.util.function.Supplier.get():java.lang.Object
                return r2.lambda$explain$1();
            }
            java.lang.Object r0 = dev.morphia.internal.MorphiaInternals.tryInvoke(r0, r1, r2)
            java.util.Map r0 = (java.util.Map) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.LegacyQuery.explain(dev.morphia.query.FindOptions, com.mongodb.ExplainVerbosity):java.util.Map");
    }

    @Override // dev.morphia.query.Query
    public FieldEnd<? extends Query<T>> field(String name) {
        return new FieldEndImpl(this.mapper, name, this, this.model, isValidatingNames());
    }

    @Override // dev.morphia.query.Query
    public Modify<T> modify(UpdateOperator first, UpdateOperator... updates) {
        return new Modify<>(this.datastore, this.mapper, getCollection(), this, this.clazz, first, updates);
    }

    @Override // dev.morphia.query.Query
    public T first() {
        return first(new FindOptions());
    }

    @Override // dev.morphia.query.Query
    public T first(FindOptions options) {
        MongoCursor<T> it = iterator(options.copy().limit(1));
        try {
            T tryNext = it.tryNext();
            if (it != null) {
                it.close();
            }
            return tryNext;
        } catch (Throwable th) {
            if (it != null) {
                try {
                    it.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // dev.morphia.query.Query
    public Class<T> getEntityClass() {
        return this.clazz;
    }

    @Override // dev.morphia.query.Query
    public Update<T> update(UpdateOperator first, UpdateOperator... updates) {
        return new Update<>(this.datastore, this.mapper, getCollection(), this, this.clazz, first, updates);
    }

    /* JADX DEBUG: Type inference failed for r4v1. Raw type applied. Possible types: com.mongodb.client.MongoCollection<T>, com.mongodb.client.MongoCollection<E> */
    @Override // dev.morphia.query.Query
    public MorphiaCursor<T> iterator(FindOptions options) {
        return new MorphiaCursor<>(prepareCursor(options, (MongoCollection<T>) getCollection()));
    }

    @Override // dev.morphia.query.Query
    public MorphiaKeyCursor<T> keys() {
        return keys(new FindOptions());
    }

    /* JADX DEBUG: Type inference failed for r4v4. Raw type applied. Possible types: com.mongodb.client.MongoCollection<org.bson.Document>, com.mongodb.client.MongoCollection<E> */
    @Override // dev.morphia.query.Query
    public MorphiaKeyCursor<T> keys(FindOptions options) {
        return new MorphiaKeyCursor<>(prepareCursor(new FindOptions().copy(options).projection().include(DBCollection.ID_FIELD_NAME), this.datastore.getDatabase().getCollection(getCollectionName())), this.datastore.getMapper(), this.clazz, getCollectionName());
    }

    @Override // dev.morphia.query.Query
    public Modify<T> modify(UpdateOperations<T> operations) {
        return new Modify<>(this.datastore, this.mapper, getCollection(), this, this.clazz, (UpdateOpsImpl) operations);
    }

    @Override // dev.morphia.query.Query
    public Query<T> retrieveKnownFields() {
        getOptions().projection().knownFields();
        return this;
    }

    @Override // dev.morphia.query.Query
    public Query<T> search(String search) {
        criteria(QueryOperators.TEXT).equal(new Document(QueryOperators.SEARCH, search));
        return this;
    }

    @Override // dev.morphia.query.Query
    public Query<T> search(String search, String language) {
        criteria(QueryOperators.TEXT).equal(new Document(QueryOperators.SEARCH, search).append(QueryOperators.LANGUAGE, language));
        return this;
    }

    public MongoCollection<T> getCollection() {
        return this.collection;
    }

    @Override // dev.morphia.query.Query
    @Deprecated(since = "2.0", forRemoval = true)
    public Update<T> update(UpdateOperations<T> operations) {
        return new Update<>(this.datastore, this.mapper, getCollection(), this, this.clazz, (UpdateOpsImpl) operations);
    }

    @Override // dev.morphia.query.Criteria
    public Document toDocument() {
        Document query = getQueryDocument();
        EntityModel model = this.mapper.getEntityModel(getEntityClass());
        Entity entityAnnotation = model.getEntityAnnotation();
        if (entityAnnotation != null && entityAnnotation.useDiscriminator() && !query.containsKey(DBCollection.ID_FIELD_NAME) && !query.containsKey(model.getDiscriminatorKey())) {
            List<EntityModel> subtypes = this.mapper.getEntityModel(getEntityClass()).getSubtypes();
            List<String> values = new ArrayList<>();
            values.add(model.getDiscriminator());
            for (EntityModel subtype : subtypes) {
                values.add(subtype.getDiscriminator());
            }
            query.put(model.getDiscriminatorKey(), (Object) new Document(QueryOperators.f432IN, values));
        }
        return query;
    }

    @Nullable
    public Document getFieldsObject() {
        Projection projection = getOptions().getProjection();
        if (projection != null) {
            return projection.map(this.mapper, this.clazz);
        }
        return null;
    }

    @Nullable
    public Document getSort() {
        if (this.options != null) {
            return this.options.getSort();
        }
        return null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hash(this.clazz, Boolean.valueOf(this.validateName), Boolean.valueOf(this.validateType), this.baseQuery, getOptions(), this.compoundContainer, getCollectionName());
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LegacyQuery)) {
            return false;
        }
        LegacyQuery<?> query = (LegacyQuery) o;
        return this.validateName == query.validateName && this.validateType == query.validateType && Objects.equals(this.clazz, query.clazz) && Objects.equals(this.baseQuery, query.baseQuery) && Objects.equals(getOptions(), query.getOptions()) && Objects.equals(this.compoundContainer, query.compoundContainer) && Objects.equals(getCollectionName(), query.getCollectionName());
    }

    @Override // java.lang.Object
    public String toString() {
        return getOptions().getProjection() == null ? getQueryDocument().toString() : String.format("{ %s, %s }", getQueryDocument(), getFieldsObject());
    }

    public boolean isValidatingNames() {
        return this.validateName;
    }

    public void setQueryObject(Document query) {
        this.baseQuery = new Document(query);
    }

    protected Datastore getDatastore() {
        return this.datastore;
    }

    private String getCollectionName() {
        return this.collectionName;
    }

    private Document getQueryDocument() {
        Document obj = new Document();
        if (this.baseQuery != null) {
            obj.putAll(this.baseQuery);
        }
        obj.putAll(this.compoundContainer.toDocument());
        this.mapper.updateQueryWithDiscriminators(this.mapper.getEntityModel(getEntityClass()), obj);
        return obj;
    }

    @NotNull
    private <E> FindIterable<E> iterable(FindOptions options, MongoCollection<E> collection) {
        FindIterable<E> iterable;
        Document query = toDocument();
        if (LOG.isTraceEnabled()) {
            LOG.trace(String.format("Running query(%s) : %s, options: %s,", getCollectionName(), query.toJson(), options));
        }
        if (!(options.getCursorType() == null || options.getCursorType() == CursorType.NonTailable || options.getSort() == null)) {
            LOG.warn("Sorting on tail is not allowed.");
        }
        ClientSession clientSession = this.datastore.findSession(options);
        if (clientSession != null) {
            iterable = collection.find(clientSession, query);
        } else {
            iterable = collection.find(query);
        }
        return iterable;
    }

    private <E> MongoCursor<E> prepareCursor(FindOptions options, MongoCollection<E> collection) {
        Document oldProfile = null;
        if (options.isLogQuery()) {
            oldProfile = this.datastore.getDatabase().runCommand(new Document("profile", 2).append("slowms", 0));
        }
        try {
            MongoCursor<E> mongoCursor = (MongoCursor<E>) options.apply(iterable(options, collection), this.mapper, this.clazz).iterator();
            if (options.isLogQuery()) {
                this.datastore.getDatabase().runCommand(new Document("profile", oldProfile.get("was")).append("slowms", oldProfile.get("slowms")).append("sampleRate", oldProfile.get("sampleRate")));
            }
            return mongoCursor;
        } catch (Throwable th) {
            if (options.isLogQuery()) {
                this.datastore.getDatabase().runCommand(new Document("profile", oldProfile.get("was")).append("slowms", oldProfile.get("slowms")).append("sampleRate", oldProfile.get("sampleRate")));
            }
            throw th;
        }
    }

    private FilterOperator translate(String operator) {
        return FilterOperator.fromString(operator);
    }

    FindOptions getOptions() {
        if (this.options == null) {
            this.options = new FindOptions();
        }
        return this.options;
    }
}
