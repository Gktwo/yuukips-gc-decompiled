package dev.morphia.query;

import com.mongodb.CursorType;
import com.mongodb.DBCollection;
import com.mongodb.ExplainVerbosity;
import com.mongodb.QueryOperators;
import com.mongodb.client.ClientSession;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.internal.MorphiaInternals;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.query.Shape;
import dev.morphia.query.experimental.filters.Filter;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.query.experimental.filters.NearFilter;
import dev.morphia.query.experimental.updates.UpdateOperator;
import dev.morphia.query.internal.MorphiaCursor;
import dev.morphia.query.internal.MorphiaKeyCursor;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/query/MorphiaQuery.class */
public class MorphiaQuery<T> implements Query<T> {
    private static final Logger LOG = LoggerFactory.getLogger(MorphiaQuery.class);
    private final Datastore datastore;
    private final Class<T> type;
    private final Mapper mapper;
    private final String collectionName;
    private final MongoCollection<T> collection;
    private final List<Filter> filters;
    private final Document seedQuery;
    private boolean validate;

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
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r2, method: dev.morphia.query.MorphiaQuery.filter(java.lang.String, java.lang.Object):dev.morphia.query.Query<T>
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
    public dev.morphia.query.Query<T> filter(java.lang.String r9, java.lang.Object r10) {
        /*
            r8 = this;
            r0 = r9
            java.lang.String r0 = r0.trim()
            java.lang.String r1 = " "
            java.lang.String[] r0 = r0.split(r1)
            r11 = r0
            r0 = r11
            int r0 = r0.length
            r1 = 1
            if (r0 < r1) goto L_0x0017
            r0 = r11
            int r0 = r0.length
            r1 = 6
            if (r0 <= r1) goto L_0x0025
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = r0
            r2 = r9
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, '' is not a legal filter condition]}
            r1.<init>(r2)
            throw r0
            r0 = r11
            int r0 = r0.length
            r1 = 2
            if (r0 != r1) goto L_0x0034
            r0 = r11
            r1 = 1
            r0 = r0[r1]
            dev.morphia.query.FilterOperator r0 = dev.morphia.query.FilterOperator.fromString(r0)
            goto L_0x0037
            dev.morphia.query.FilterOperator r0 = dev.morphia.query.FilterOperator.EQUAL
            r12 = r0
            r0 = r8
            r1 = 1
            dev.morphia.query.experimental.filters.Filter[] r1 = new dev.morphia.query.experimental.filters.Filter[r1]
            r2 = r1
            r3 = 0
            r4 = r12
            r5 = r11
            r6 = 0
            r5 = r5[r6]
            java.lang.String r5 = r5.trim()
            r6 = r10
            dev.morphia.query.experimental.filters.Filter r4 = r4.apply(r5, r6)
            r2[r3] = r4
            dev.morphia.query.Query r0 = r0.filter(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.MorphiaQuery.filter(java.lang.String, java.lang.Object):dev.morphia.query.Query");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x001C: INVOKE_CUSTOM r-4
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0028: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r3, method: dev.morphia.query.MorphiaQuery.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x001C: INVOKE_CUSTOM r1, method: dev.morphia.query.MorphiaQuery.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, clazz=]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, clazz=]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0028: INVOKE_CUSTOM r1, method: dev.morphia.query.MorphiaQuery.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/Document;)Ljava/lang/String;}, query=]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/Document;)Ljava/lang/String;}, query=]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.lang.Object
    public java.lang.String toString() {
        /*
            r6 = this;
            java.util.StringJoiner r0 = new java.util.StringJoiner
            r1 = r0
            java.lang.String r2 = ", "
            java.lang.Class<dev.morphia.query.MorphiaQuery> r3 = dev.morphia.query.MorphiaQuery.class
            java.lang.String r3 = r3.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, []}
            java.lang.String r4 = "]"
            r1.<init>(r2, r3, r4)
            r1 = r6
            java.lang.Class<T> r1 = r1.type
            java.lang.String r1 = r1.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, clazz=]}
            java.util.StringJoiner r0 = r0.add(r1)
            r1 = r6
            org.bson.Document r1 = r1.getQueryDocument()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/Document;)Ljava/lang/String;}, query=]}
            java.util.StringJoiner r0 = r0.add(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.MorphiaQuery.toString():java.lang.String");
    }

    /* access modifiers changed from: protected */
    public MorphiaQuery(Datastore datastore, @Nullable String collectionName, Class<T> type) {
        this.filters = new ArrayList();
        this.validate = true;
        this.type = type;
        this.datastore = datastore;
        this.mapper = this.datastore.getMapper();
        this.seedQuery = null;
        if (collectionName != null) {
            this.collection = datastore.getDatabase().getCollection(collectionName, type);
            this.collectionName = collectionName;
        } else if (this.mapper.isMappable(type)) {
            this.collection = this.mapper.getCollection(type);
            this.collectionName = this.collection.getNamespace().getCollectionName();
        } else {
            this.collection = null;
            this.collectionName = null;
        }
    }

    /* access modifiers changed from: protected */
    public MorphiaQuery(Datastore datastore, Class<T> type, Document query) {
        this.filters = new ArrayList();
        this.validate = true;
        this.type = type;
        this.datastore = datastore;
        this.seedQuery = query;
        this.mapper = this.datastore.getMapper();
        this.collection = this.mapper.getCollection(type);
        this.collectionName = this.collection.getNamespace().getCollectionName();
    }

    /* access modifiers changed from: package-private */
    public static <V> V legacyOperation() {
        throw new UnsupportedOperationException(Sofia.legacyOperation(new Locale[0]));
    }

    @Override // dev.morphia.query.Query
    public long count() {
        return count(new CountOptions());
    }

    @Override // dev.morphia.query.Query
    public long count(CountOptions options) {
        ClientSession session = this.datastore.findSession(options);
        Document query = getQueryDocument();
        return session == null ? getCollection().countDocuments(query, options) : getCollection().countDocuments(session, query, options);
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
        this.validate = false;
        return this;
    }

    @Override // dev.morphia.query.Query
    public Query<T> enableValidation() {
        this.validate = true;
        return this;
    }

    @Override // dev.morphia.query.Query
    public Map<String, Object> explain(FindOptions options, @Nullable ExplainVerbosity verbosity) {
        return (Map) MorphiaInternals.tryInvoke(MorphiaInternals.DriverVersion.v4_2_0, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0017: RETURN  
              (wrap: java.util.Map<java.lang.String, java.lang.Object> : 0x0014: CHECK_CAST (r0v2 java.util.Map<java.lang.String, java.lang.Object> A[REMOVE]) = (java.util.Map) (wrap: java.lang.Object : 0x0011: INVOKE  (r0v1 java.lang.Object A[REMOVE]) = 
              (wrap: dev.morphia.internal.MorphiaInternals$DriverVersion : 0x0000: SGET  (r0v0 dev.morphia.internal.MorphiaInternals$DriverVersion A[REMOVE]) =  dev.morphia.internal.MorphiaInternals.DriverVersion.v4_2_0 dev.morphia.internal.MorphiaInternals$DriverVersion)
              (wrap: java.util.function.Supplier : 0x0006: INVOKE_CUSTOM (r1v1 java.util.function.Supplier A[REMOVE]) = 
              (r5v0 'this' dev.morphia.query.MorphiaQuery<T> A[D('this' dev.morphia.query.MorphiaQuery<T>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r7v0 'verbosity' com.mongodb.ExplainVerbosity A[D('verbosity' com.mongodb.ExplainVerbosity), DONT_INLINE])
              (r6v0 'options' dev.morphia.query.FindOptions A[D('options' dev.morphia.query.FindOptions), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r1 I:dev.morphia.query.MorphiaQuery), (r2 I:com.mongodb.ExplainVerbosity), (r3 I:dev.morphia.query.FindOptions) type: DIRECT call: dev.morphia.query.MorphiaQuery.lambda$explain$0(com.mongodb.ExplainVerbosity, dev.morphia.query.FindOptions):java.io.Serializable)
              (wrap: java.util.function.Supplier : 0x000c: INVOKE_CUSTOM (r2v2 java.util.function.Supplier A[REMOVE]) = 
              (r5v0 'this' dev.morphia.query.MorphiaQuery<T> A[D('this' dev.morphia.query.MorphiaQuery<T>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
            
             handle type: INVOKE_DIRECT
             lambda: java.util.function.Supplier.get():java.lang.Object
             call insn: ?: INVOKE  (r2 I:dev.morphia.query.MorphiaQuery) type: DIRECT call: dev.morphia.query.MorphiaQuery.lambda$explain$1():java.io.Serializable)
             type: STATIC call: dev.morphia.internal.MorphiaInternals.tryInvoke(dev.morphia.internal.MorphiaInternals$DriverVersion, java.util.function.Supplier, java.util.function.Supplier):java.lang.Object))
             in method: dev.morphia.query.MorphiaQuery.explain(dev.morphia.query.FindOptions, com.mongodb.ExplainVerbosity):java.util.Map<java.lang.String, java.lang.Object>, file: grasscutter.jar:dev/morphia/query/MorphiaQuery.class
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
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.MorphiaQuery.explain(dev.morphia.query.FindOptions, com.mongodb.ExplainVerbosity):java.util.Map");
    }

    @Override // dev.morphia.query.Query
    public FieldEnd<? extends Query<T>> field(String name) {
        return new MorphiaQueryFieldEnd(name);
    }

    @Override // dev.morphia.query.Query
    public Query<T> filter(Filter... additional) {
        for (Filter filter : additional) {
            this.filters.add(filter.entityType(getEntityClass()).isValidating(this.validate));
        }
        return this;
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
        return this.type;
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
        return new MorphiaKeyCursor<>(prepareCursor(new FindOptions().copy(options).projection().include(DBCollection.ID_FIELD_NAME), this.datastore.getDatabase().getCollection(getCollectionName())), this.datastore.getMapper(), this.type, getCollectionName());
    }

    @Override // dev.morphia.query.Query
    public Modify<T> modify(UpdateOperator first, UpdateOperator... updates) {
        return new Modify<>(this.datastore, this.mapper, getCollection(), this, getEntityClass(), first, updates);
    }

    @Override // dev.morphia.query.Query
    public Query<T> search(String searchText) {
        return filter(Filters.text(searchText));
    }

    @Override // dev.morphia.query.Query
    public Query<T> search(String searchText, String language) {
        return filter(Filters.text(searchText).language(language));
    }

    @Override // dev.morphia.query.Query, dev.morphia.query.Criteria
    public Document toDocument() {
        return getQueryDocument();
    }

    @Override // dev.morphia.query.Query
    public Update<T> update(UpdateOperator first, UpdateOperator... updates) {
        return new Update<>(this.datastore, this.mapper, getCollection(), this, this.type, first, updates);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hash(this.type, Boolean.valueOf(this.validate), getCollectionName());
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MorphiaQuery)) {
            return false;
        }
        MorphiaQuery<?> query20 = (MorphiaQuery) o;
        return this.validate == query20.validate && Objects.equals(this.type, query20.type) && Objects.equals(getCollectionName(), query20.getCollectionName());
    }

    private MongoCollection<T> getCollection() {
        return this.collection;
    }

    private String getCollectionName() {
        return this.collectionName;
    }

    @NotNull
    private <E> FindIterable<E> iterable(FindOptions findOptions, MongoCollection<E> collection) {
        FindIterable<E> iterable;
        Document query = toDocument();
        if (LOG.isTraceEnabled()) {
            LOG.trace(String.format("Running query(%s) : %s, options: %s,", getCollectionName(), query, findOptions));
        }
        if (!(findOptions.getCursorType() == null || findOptions.getCursorType() == CursorType.NonTailable || findOptions.getSort() == null)) {
            LOG.warn("Sorting on tail is not allowed.");
        }
        ClientSession clientSession = this.datastore.findSession(findOptions);
        MongoCollection<C> prepare = findOptions.prepare(collection);
        if (clientSession != null) {
            iterable = prepare.find(clientSession, query);
        } else {
            iterable = prepare.find(query);
        }
        return iterable;
    }

    private <E> MongoCursor<E> prepareCursor(FindOptions findOptions, MongoCollection<E> collection) {
        Document oldProfile = null;
        if (findOptions.isLogQuery()) {
            oldProfile = this.datastore.getDatabase().runCommand(new Document("profile", 2).append("slowms", 0));
        }
        try {
            MongoCursor<E> mongoCursor = (MongoCursor<E>) findOptions.apply(iterable(findOptions, collection), this.mapper, this.type).iterator();
            if (findOptions.isLogQuery()) {
                this.datastore.getDatabase().runCommand(new Document("profile", oldProfile.get("was")).append("slowms", oldProfile.get("slowms")).append("sampleRate", oldProfile.get("sampleRate")));
            }
            return mongoCursor;
        } catch (Throwable th) {
            if (findOptions.isLogQuery()) {
                this.datastore.getDatabase().runCommand(new Document("profile", oldProfile.get("was")).append("slowms", oldProfile.get("slowms")).append("sampleRate", oldProfile.get("sampleRate")));
            }
            throw th;
        }
    }

    Document getQueryDocument() {
        DocumentWriter writer = new DocumentWriter(this.mapper, this.seedQuery);
        ExpressionHelper.document(writer, ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0018: INVOKE  
              (r0v0 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter)])
              (wrap: java.lang.Runnable : 0x0013: INVOKE_CUSTOM (r1v2 java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' dev.morphia.query.MorphiaQuery<T> A[D('this' dev.morphia.query.MorphiaQuery<T>), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r0v0 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  (r1 I:dev.morphia.query.MorphiaQuery), (r2 I:dev.morphia.mapping.codec.writer.DocumentWriter) type: DIRECT call: dev.morphia.query.MorphiaQuery.lambda$getQueryDocument$2(dev.morphia.mapping.codec.writer.DocumentWriter):void)
             type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.query.MorphiaQuery.getQueryDocument():org.bson.Document, file: grasscutter.jar:dev/morphia/query/MorphiaQuery.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
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
            dev.morphia.mapping.codec.writer.DocumentWriter r0 = new dev.morphia.mapping.codec.writer.DocumentWriter
            r1 = r0
            r2 = r5
            dev.morphia.mapping.Mapper r2 = r2.mapper
            r3 = r5
            org.bson.Document r3 = r3.seedQuery
            r1.<init>(r2, r3)
            r6 = r0
            r0 = r6
            r1 = r5
            r2 = r6
            org.bson.Document r1 = () -> { // java.lang.Runnable.run():void
                r1.lambda$getQueryDocument$2(r2);
            }
            dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
            r0 = r6
            org.bson.Document r0 = r0.getDocument()
            r7 = r0
            r0 = r5
            dev.morphia.mapping.Mapper r0 = r0.mapper
            r1 = r5
            java.lang.Class r1 = r1.getEntityClass()
            boolean r0 = r0.isMappable(r1)
            if (r0 == 0) goto L_0x0041
            r0 = r5
            dev.morphia.mapping.Mapper r0 = r0.mapper
            r1 = r5
            dev.morphia.mapping.Mapper r1 = r1.mapper
            r2 = r5
            java.lang.Class r2 = r2.getEntityClass()
            dev.morphia.mapping.codec.pojo.EntityModel r1 = r1.getEntityModel(r2)
            r2 = r7
            r0.updateQueryWithDiscriminators(r1, r2)
        L_0x0041:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.MorphiaQuery.getQueryDocument():org.bson.Document");
    }

    @Deprecated(since = "2.0", forRemoval = true)
    /* loaded from: grasscutter.jar:dev/morphia/query/MorphiaQuery$MorphiaQueryFieldEnd.class */
    private class MorphiaQueryFieldEnd extends FieldEndImpl {
        private final String name;

        private MorphiaQueryFieldEnd(String name) {
            super(MorphiaQuery.this.mapper, name, MorphiaQuery.this, MorphiaQuery.this.mapper.getEntityModel(MorphiaQuery.this.getEntityClass()), MorphiaQuery.this.validate);
            this.name = name;
        }

        @Override // dev.morphia.query.FieldEndImpl, dev.morphia.query.FieldEnd
        public CriteriaContainer within(Shape shape) {
            Filter converted;
            if (shape instanceof Shape.Center) {
                Shape.Center center = (Shape.Center) shape;
                converted = Filters.center(getField(), center.getCenter(), center.getRadius());
            } else if (shape.getGeometry().equals(QueryOperators.BOX)) {
                Point[] points = shape.getPoints();
                converted = Filters.box(getField(), points[0], points[1]);
            } else if (shape.getGeometry().equals(QueryOperators.POLYGON)) {
                converted = Filters.polygon(getField(), shape.getPoints());
            } else {
                throw new UnsupportedOperationException(Sofia.conversionNotSupported(shape.getGeometry(), new Locale[0]));
            }
            if (isNot()) {
                converted.not();
            }
            MorphiaQuery.this.filter(converted);
            return MorphiaQuery.this;
        }

        /* access modifiers changed from: protected */
        @Override // dev.morphia.query.FieldEndImpl
        public MorphiaQuery<T> addCriteria(FilterOperator op, Object val, boolean not) {
            Filter converted = op.apply(this.name, val);
            if (not) {
                converted.not();
            }
            MorphiaQuery.this.filter(converted);
            return MorphiaQuery.this;
        }

        @Override // dev.morphia.query.FieldEndImpl
        protected CriteriaContainer addGeoCriteria(FilterOperator op, Object val, Map opts) {
            NearFilter apply = (NearFilter) op.apply(this.name, val);
            apply.applyOpts(opts);
            MorphiaQuery.this.filter(apply);
            return MorphiaQuery.this;
        }
    }
}
