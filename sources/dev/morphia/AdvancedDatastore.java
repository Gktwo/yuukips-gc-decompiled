package dev.morphia;

import com.mongodb.DBObject;
import com.mongodb.DBRef;
import dev.morphia.aggregation.AggregationPipeline;
import dev.morphia.query.Query;
import dev.morphia.query.UpdateOperations;
import dev.morphia.query.UpdateOpsImpl;
import java.util.List;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/AdvancedDatastore.class */
public interface AdvancedDatastore extends Datastore {
    @Deprecated(since = "2.0", forRemoval = true)
    AggregationPipeline createAggregation(String str, Class<?> cls);

    @Deprecated(since = "2.0", forRemoval = true)
    <T> Query<T> createQuery(Class<T> cls, Document document);

    /*  JADX ERROR: Dependency scan failed at insn: 0x001A: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001A: INVOKE_CUSTOM r2, method: dev.morphia.AdvancedDatastore.createRef(T):com.mongodb.DBRef
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get id for ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get id for ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @java.lang.Deprecated(since = "2.0", forRemoval = true)
    default <T> com.mongodb.DBRef createRef(T r5) {
        /*
            r4 = this;
            r0 = r4
            dev.morphia.mapping.Mapper r0 = r0.getMapper()
            r1 = r5
            java.lang.Object r0 = r0.getId(r1)
            r6 = r0
            r0 = r6
            if (r0 != 0) goto L_0x0023
            dev.morphia.mapping.MappingException r0 = new dev.morphia.mapping.MappingException
            r1 = r0
            r2 = r5
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Could not get id for ]}
            r1.<init>(r2)
            throw r0
            r0 = r4
            r1 = r5
            java.lang.Class r1 = r1.getClass()
            r2 = r6
            com.mongodb.DBRef r0 = r0.createRef(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.AdvancedDatastore.createRef(java.lang.Object):com.mongodb.DBRef");
    }

    @Deprecated(since = "2.0", forRemoval = true)
    <T> Query<T> queryByExample(String str, T t);

    @Deprecated(since = "2.0", forRemoval = true)
    default <T, V> DBRef createRef(Class<T> clazz, V id) {
        return new DBRef(getMapper().getCollection(clazz).getNamespace().getCollectionName(), id);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> UpdateOperations<T> createUpdateOperations(Class<T> type, DBObject ops) {
        UpdateOpsImpl<T> upOps = (UpdateOpsImpl) createUpdateOperations(type);
        upOps.setOps(new Document(ops.toMap()));
        return upOps;
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> void insert(T entity, InsertOptions options) {
        insert((AdvancedDatastore) entity, options.toInsertOneOptions());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default <T> void insert(List<T> entities, InsertOptions options) {
        insert(entities, options.toInsertManyOptions());
    }
}
