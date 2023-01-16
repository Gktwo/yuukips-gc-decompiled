package dev.morphia;

import com.mongodb.ClientSessionOptions;
import com.mongodb.DBCollection;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoWriteException;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.ValidationOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.lang.Nullable;
import dev.morphia.aggregation.AggregationPipeline;
import dev.morphia.aggregation.AggregationPipelineImpl;
import dev.morphia.aggregation.experimental.Aggregation;
import dev.morphia.aggregation.experimental.AggregationImpl;
import dev.morphia.annotations.Validation;
import dev.morphia.annotations.builders.IndexHelper;
import dev.morphia.experimental.MorphiaSession;
import dev.morphia.experimental.MorphiaSessionImpl;
import dev.morphia.internal.SessionConfigurable;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MapperOptions;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.query.Query;
import dev.morphia.query.QueryFactory;
import dev.morphia.query.experimental.filters.Filters;
import dev.morphia.sofia.Sofia;
import dev.morphia.transactions.experimental.MorphiaTransaction;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/DatastoreImpl.class */
public class DatastoreImpl implements AdvancedDatastore {
    private static final Logger LOG = LoggerFactory.getLogger(DatastoreImpl.class);
    private final MongoDatabase database;
    private final MongoClient mongoClient;
    private final Mapper mapper;
    private final QueryFactory queryFactory;

    /*  JADX ERROR: Dependency scan failed at insn: 0x00EA: INVOKE_CUSTOM r-9
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x00FC: INVOKE_CUSTOM r-10
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x011D: INVOKE_CUSTOM r-15, r-14
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
    /*  JADX ERROR: Failed to decode insn: 0x00EA: INVOKE_CUSTOM r1, method: dev.morphia.DatastoreImpl.ensureCaps():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/Document;)Ljava/lang/String;}, MongoCollection already exists and is capped already; doing nothing. ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lorg/bson/Document;)Ljava/lang/String;}, MongoCollection already exists and is capped already; doing nothing. ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x00FC: INVOKE_CUSTOM r1, method: dev.morphia.DatastoreImpl.ensureCaps():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, MongoCollection already exists with same name() and is not capped; not creating capped version!]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, MongoCollection already exists with same name() and is not capped; not creating capped version!]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x011D: INVOKE_CUSTOM r1, r2, method: dev.morphia.DatastoreImpl.ensureCaps():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Lcom/mongodb/client/model/CreateCollectionOptions;)Ljava/lang/String;}, Created capped MongoCollection () with opts ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Lcom/mongodb/client/model/CreateCollectionOptions;)Ljava/lang/String;}, Created capped MongoCollection () with opts ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.Datastore
    public void ensureCaps() {
        /*
        // Method dump skipped, instructions count: 299
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.DatastoreImpl.ensureCaps():void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001F: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001F: INVOKE_CUSTOM r4, method: dev.morphia.DatastoreImpl.getLoggedQuery(dev.morphia.query.FindOptions):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, logged query: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, logged query: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.Datastore
    public java.lang.String getLoggedQuery(dev.morphia.query.FindOptions r7) {
        /*
            r6 = this;
            r0 = r7
            boolean r0 = r0.isLogQuery()
            if (r0 == 0) goto L_0x007f
            java.lang.String r0 = "{}"
            r8 = r0
            r0 = r6
            com.mongodb.client.MongoDatabase r0 = r0.getDatabase()
            java.lang.String r1 = "system.profile"
            com.mongodb.client.MongoCollection r0 = r0.getCollection(r1)
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "command.comment"
            r4 = r7
            java.lang.String r4 = r4.getQueryLogId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, logged query: ]}
            r2.<init>(r3, r4)
            java.lang.Class<org.bson.Document> r2 = org.bson.Document.class
            com.mongodb.client.FindIterable r0 = r0.find(r1, r2)
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "command.filter"
            r4 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r2.<init>(r3, r4)
            com.mongodb.client.FindIterable r0 = r0.projection(r1)
            java.lang.Object r0 = r0.first()
            org.bson.Document r0 = (org.bson.Document) r0
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L_0x007d
            r0 = r9
            java.lang.String r1 = "command"
            java.lang.Object r0 = r0.get(r1)
            org.bson.Document r0 = (org.bson.Document) r0
            r10 = r0
            r0 = r10
            java.lang.String r1 = "filter"
            java.lang.Object r0 = r0.get(r1)
            org.bson.Document r0 = (org.bson.Document) r0
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x007d
            r0 = r11
            r1 = r6
            dev.morphia.mapping.Mapper r1 = r1.mapper
            org.bson.codecs.configuration.CodecRegistry r1 = r1.getCodecRegistry()
            java.lang.Class<org.bson.Document> r2 = org.bson.Document.class
            org.bson.codecs.Codec r1 = r1.get(r2)
            java.lang.String r0 = r0.toJson(r1)
            r8 = r0
            r0 = r8
            return r0
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            r2 = 0
            java.util.Locale[] r2 = new java.util.Locale[r2]
            java.lang.String r2 = dev.morphia.sofia.Sofia.queryNotLogged(r2)
            r1.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.DatastoreImpl.getLoggedQuery(dev.morphia.query.FindOptions):java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: dev.morphia.DatastoreImpl.merge(T, dev.morphia.InsertOneOptions):T
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
    @Override // dev.morphia.Datastore
    public <T> T merge(T r8, dev.morphia.InsertOneOptions r9) {
        /*
        // Method dump skipped, instructions count: 305
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.DatastoreImpl.merge(java.lang.Object, dev.morphia.InsertOneOptions):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public DatastoreImpl(MongoClient mongoClient, MapperOptions options, String dbName) {
        MongoDatabase database = mongoClient.getDatabase(dbName);
        this.mapper = new Mapper(this, database.getCodecRegistry(), options);
        this.database = database.withCodecRegistry(this.mapper.getCodecRegistry());
        this.mongoClient = mongoClient;
        this.queryFactory = options.getQueryFactory();
    }

    public DatastoreImpl(MongoDatabase database, MongoClient mongoClient, Mapper mapper, QueryFactory queryFactory) {
        this.database = database;
        this.mongoClient = mongoClient;
        this.mapper = mapper;
        this.queryFactory = queryFactory;
    }

    @Override // dev.morphia.Datastore
    public Aggregation<Document> aggregate(String source) {
        return new AggregationImpl(this, getDatabase().getCollection(source));
    }

    @Override // dev.morphia.Datastore
    public <T> Aggregation<T> aggregate(Class<T> source) {
        return new AggregationImpl(this, source, this.mapper.getCollection(source));
    }

    @Override // dev.morphia.Datastore
    public AggregationPipeline createAggregation(Class source) {
        return new AggregationPipelineImpl(this, this.mapper.getCollection(source), source);
    }

    @Override // dev.morphia.Datastore
    public <T> DeleteResult delete(T entity) {
        return delete((DatastoreImpl) entity, new DeleteOptions().writeConcern(this.mapper.getWriteConcern(entity.getClass())));
    }

    @Override // dev.morphia.Datastore
    public <T> DeleteResult delete(T entity, DeleteOptions options) {
        if (entity instanceof Class) {
            throw new MappingException(Sofia.deleteWithClass(entity.getClass().getName(), new Locale[0]));
        }
        Object id = this.mapper.getId(entity);
        if (id != null) {
            return find(entity.getClass()).filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, id)).delete(options);
        }
        return new NoDeleteResult();
    }

    @Override // dev.morphia.Datastore
    public void enableDocumentValidation() {
        for (EntityModel model : this.mapper.getMappedEntities()) {
            enableDocumentValidation(model);
        }
    }

    @Override // dev.morphia.Datastore
    public void ensureIndexes() {
        if (this.mapper.getMappedEntities().isEmpty()) {
            Sofia.logNoMappedClasses(new Locale[0]);
        }
        IndexHelper indexHelper = new IndexHelper(this.mapper);
        for (EntityModel model : this.mapper.getMappedEntities()) {
            if (model.getIdProperty() != null) {
                indexHelper.createIndex(this.mapper.getCollection(model.getType()), model);
            }
        }
    }

    @Override // dev.morphia.AdvancedDatastore
    public AggregationPipeline createAggregation(String collection, Class<?> clazz) {
        return new AggregationPipelineImpl(this, getDatabase().getCollection(collection), clazz);
    }

    @Override // dev.morphia.AdvancedDatastore
    public <T> Query<T> createQuery(Class<T> type, Document q) {
        return this.queryFactory.createQuery(this, type, q);
    }

    @Override // dev.morphia.Datastore
    public <T> Query<T> find(Class<T> type) {
        return this.queryFactory.createQuery(this, type);
    }

    @Override // dev.morphia.Datastore
    public <T> Query<T> find(String collection, Class<T> type) {
        return this.queryFactory.createQuery(this, collection, type);
    }

    @Override // dev.morphia.Datastore
    @Nullable
    public ClientSession findSession(SessionConfigurable<?> configurable) {
        if (configurable.clientSession() != null) {
            return configurable.clientSession();
        }
        return getSession();
    }

    @Override // dev.morphia.AdvancedDatastore
    public <T> Query<T> queryByExample(String collection, T ex) {
        return queryByExample(ex);
    }

    @Override // dev.morphia.Datastore
    public Mapper getMapper() {
        return this.mapper;
    }

    @Override // dev.morphia.Datastore
    public <T> void ensureIndexes(Class<T> type) {
        new IndexHelper(this.mapper).createIndex(this.mapper.getCollection(type), this.mapper.getEntityModel(type));
    }

    @Override // dev.morphia.Datastore
    public <T> Query<T> find(String collection) {
        return this.queryFactory.createQuery(this, this.mapper.getClassFromCollection(collection));
    }

    @Override // dev.morphia.Datastore
    public MongoDatabase getDatabase() {
        return this.database;
    }

    @Override // dev.morphia.Datastore
    public <T> void insert(T entity) {
        insert((DatastoreImpl) entity, new InsertOneOptions().writeConcern(this.mapper.getWriteConcern(entity.getClass())));
    }

    @Override // dev.morphia.Datastore
    public <T> void insert(T entity, InsertOneOptions options) {
        save((DatastoreImpl) entity, options);
    }

    @Override // dev.morphia.Datastore
    public <T> void insert(List<T> entities, InsertManyOptions options) {
        save(entities, options);
    }

    @Override // dev.morphia.Datastore
    public <T> T merge(T entity) {
        return (T) merge((DatastoreImpl) entity, new InsertOneOptions());
    }

    @Override // dev.morphia.Datastore
    public <T> Query<T> queryByExample(T example) {
        return this.queryFactory.createQuery(this, example.getClass(), this.mapper.toDocument(example));
    }

    @Override // dev.morphia.Datastore
    public <T> void refresh(T entity) {
        getMapper().refresh(entity);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: dev.morphia.DatastoreImpl */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // dev.morphia.Datastore
    public <T> List<T> save(List<T> entities, InsertManyOptions options) {
        if (entities.isEmpty()) {
            return List.of();
        }
        Map<Class<?>, List<T>> grouped = new LinkedHashMap<>();
        List<T> list = new ArrayList<>();
        for (T entity : entities) {
            Class<?> type = entity.getClass();
            EntityModel model = getMapper().getEntityModel(type);
            if (getMapper().getId(entity) == null && model.getVersionProperty() == null) {
                grouped.computeIfAbsent(type, c -> {
                    return new ArrayList();
                }).add(entity);
            } else {
                list.add(entity);
            }
        }
        for (Map.Entry<Class<?>, List<T>> entry : grouped.entrySet()) {
            MongoCollection<T> collection = this.mapper.getCollection(entry.getKey());
            ClientSession clientSession = options.clientSession();
            if (clientSession == null) {
                collection.insertMany((List<? extends T>) entry.getValue(), options.getOptions());
            } else {
                collection.insertMany(clientSession, entry.getValue(), options.getOptions());
            }
        }
        InsertOneOptions insertOneOptions = new InsertOneOptions().bypassDocumentValidation(options.getBypassDocumentValidation()).clientSession(findSession(options)).writeConcern(options.writeConcern());
        for (T entity2 : list) {
            save((DatastoreImpl) entity2, insertOneOptions);
        }
        return entities;
    }

    @Override // dev.morphia.Datastore
    public <T> T save(T entity) {
        return (T) save((DatastoreImpl) entity, new InsertOneOptions().writeConcern(this.mapper.getWriteConcern(entity.getClass())));
    }

    @Override // dev.morphia.Datastore
    public <T> T save(T entity, InsertOneOptions options) {
        save(this.mapper.getCollection(entity.getClass()), entity, options);
        return entity;
    }

    @Override // dev.morphia.Datastore
    public MorphiaSession startSession() {
        return new MorphiaSessionImpl(this.mongoClient.startSession(), this.mongoClient, this.database, this.mapper, this.queryFactory);
    }

    @Override // dev.morphia.Datastore
    public MorphiaSession startSession(ClientSessionOptions options) {
        return new MorphiaSessionImpl(this.mongoClient.startSession(options), this.mongoClient, this.database, this.mapper, this.queryFactory);
    }

    @Override // dev.morphia.Datastore
    public <T> T withTransaction(MorphiaTransaction<T> body) {
        return (T) doTransaction(startSession(), body);
    }

    @Override // dev.morphia.Datastore
    public <T> T withTransaction(ClientSessionOptions options, MorphiaTransaction<T> transaction) {
        return (T) doTransaction(startSession(options), transaction);
    }

    public void enableValidation(EntityModel model, Validation validation) {
        String collectionName = model.getCollectionName();
        if (collectionName == null) {
            throw new MappingException(Sofia.notTopLevelType(new Locale[0]));
        }
        try {
            getDatabase().runCommand(new Document("collMod", collectionName).append("validator", Document.parse(validation.value())).append("validationLevel", validation.level().getValue()).append("validationAction", validation.action().getValue()));
        } catch (MongoCommandException e) {
            if (e.getCode() == 26) {
                getDatabase().createCollection(collectionName, new CreateCollectionOptions().validationOptions(new ValidationOptions().validator(Document.parse(validation.value())).validationLevel(validation.level()).validationAction(validation.action())));
                return;
            }
            throw e;
        }
    }

    private <T> T doTransaction(MorphiaSession morphiaSession, MorphiaTransaction<T> body) {
        try {
            ClientSession session = morphiaSession.getSession();
            if (session == null) {
                throw new IllegalStateException("No session could be found for the transaction.");
            }
            T t = (T) session.withTransaction(() -> {
                return body.execute(morphiaSession);
            });
            if (morphiaSession != null) {
                morphiaSession.close();
            }
            return t;
        } catch (Throwable th) {
            if (morphiaSession != null) {
                try {
                    morphiaSession.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void enableDocumentValidation(EntityModel model) {
        Validation validation = (Validation) model.getAnnotation(Validation.class);
        String collectionName = model.getCollectionName();
        if (validation != null && collectionName != null) {
            try {
                getDatabase().runCommand(new Document("collMod", collectionName).append("validator", Document.parse(validation.value())).append("validationLevel", validation.level().getValue()).append("validationAction", validation.action().getValue()));
            } catch (MongoCommandException e) {
                if (e.getCode() == 26) {
                    this.database.createCollection(collectionName, new CreateCollectionOptions().validationOptions(new ValidationOptions().validator(Document.parse(validation.value())).validationLevel(validation.level()).validationAction(validation.action())));
                    return;
                }
                throw e;
            }
        }
    }

    private <T> void save(MongoCollection collection, T entity, InsertOneOptions options) {
        UpdateResult updateResult;
        ClientSession clientSession = findSession(options);
        Object id = this.mapper.findIdProperty(entity.getClass()).getValue(entity);
        VersionBumpInfo info = updateVersioning(entity);
        if (id != null) {
            try {
                if (!info.versioned || info.newVersion.longValue() != 1) {
                    ReplaceOptions updateOptions = new ReplaceOptions().bypassDocumentValidation(options.getBypassDocumentValidation()).upsert(!info.versioned);
                    Document filter = new Document(DBCollection.ID_FIELD_NAME, id);
                    if (info.versioned) {
                        filter.put(info.versionProperty.getMappedName(), (Object) info.oldVersion);
                    }
                    if (clientSession == null) {
                        updateResult = options.prepare(collection).replaceOne((Bson) filter, (Document) entity, updateOptions);
                    } else {
                        updateResult = options.prepare(collection).replaceOne(clientSession, filter, entity, updateOptions);
                    }
                    if (info.versioned && updateResult.getModifiedCount() != 1) {
                        info.rollbackVersion(entity);
                        throw new VersionMismatchException(entity.getClass(), id);
                    }
                }
            } catch (MongoWriteException e) {
                if (info.versioned) {
                    info.rollbackVersion(entity);
                }
                throw e;
            }
        }
        if (clientSession == null) {
            options.prepare(collection).insertOne((MongoCollection<C>) entity, options.getOptions());
        } else {
            options.prepare(collection).insertOne(clientSession, entity, options.getOptions());
        }
    }

    private <T> VersionBumpInfo updateVersioning(T entity) {
        PropertyModel versionProperty = this.mapper.getEntityModel(entity.getClass()).getVersionProperty();
        if (versionProperty == null) {
            return new VersionBumpInfo();
        }
        Long value = (Long) versionProperty.getValue(entity);
        long updated = value == null ? 1 : value.longValue() + 1;
        versionProperty.setValue(entity, Long.valueOf(updated));
        return new VersionBumpInfo(versionProperty, value, Long.valueOf(updated));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:dev/morphia/DatastoreImpl$NoDeleteResult.class */
    public static class NoDeleteResult extends DeleteResult {
        private NoDeleteResult() {
        }

        @Override // com.mongodb.client.result.DeleteResult
        public boolean wasAcknowledged() {
            return false;
        }

        @Override // com.mongodb.client.result.DeleteResult
        public long getDeletedCount() {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:dev/morphia/DatastoreImpl$VersionBumpInfo.class */
    public static class VersionBumpInfo {
        private final Long oldVersion;
        private final boolean versioned;
        private final Long newVersion;
        private final PropertyModel versionProperty;

        private VersionBumpInfo() {
            this.versioned = false;
            this.newVersion = null;
            this.oldVersion = null;
            this.versionProperty = null;
        }

        private VersionBumpInfo(PropertyModel versionProperty, @Nullable Long oldVersion, Long newVersion) {
            this.versioned = true;
            this.newVersion = newVersion;
            this.oldVersion = oldVersion;
            this.versionProperty = versionProperty;
        }

        private <T> void rollbackVersion(T entity) {
            if (this.versioned) {
                this.versionProperty.setValue(entity, this.oldVersion);
            }
        }
    }
}
