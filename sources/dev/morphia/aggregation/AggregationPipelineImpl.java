package dev.morphia.aggregation;

import com.mongodb.AggregationOptions;
import com.mongodb.DBCollection;
import com.mongodb.ReadPreference;
import com.mongodb.client.MongoCollection;
import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.query.BucketAutoOptions;
import dev.morphia.query.BucketOptions;
import dev.morphia.query.Query;
import dev.morphia.query.Sort;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.classic.joran.action.InsertFromJNDIAction;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/aggregation/AggregationPipelineImpl.class */
public class AggregationPipelineImpl implements AggregationPipeline {
    private static final Logger LOG = LoggerFactory.getLogger(AggregationPipelineImpl.class);
    private final MongoCollection collection;
    private final Class source;
    private final List<Document> stages = new ArrayList();
    private final Mapper mapper;
    private boolean firstStage;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0007: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0007: INVOKE_CUSTOM r1, method: dev.morphia.aggregation.AggregationPipelineImpl.aggregate(java.lang.String, java.lang.Class<U>, com.mongodb.AggregationOptions, com.mongodb.ReadPreference):java.util.Iterator<U>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;)Ljava/lang/String;}, stages = ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;)Ljava/lang/String;}, stages = ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> java.util.Iterator<U> aggregate(java.lang.String r5, java.lang.Class<U> r6, com.mongodb.AggregationOptions r7, com.mongodb.ReadPreference r8) {
        /*
            r4 = this;
            org.slf4j.Logger r0 = dev.morphia.aggregation.AggregationPipelineImpl.LOG
            r1 = r4
            java.util.List<org.bson.Document> r1 = r1.stages
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/util/List;)Ljava/lang/String;}, stages = ]}
            r0.debug(r1)
            r0 = r4
            com.mongodb.client.MongoCollection r0 = r0.collection
            r1 = r4
            java.util.List<org.bson.Document> r1 = r1.stages
            r2 = r6
            com.mongodb.client.AggregateIterable r0 = r0.aggregate(r1, r2)
            r9 = r0
            r0 = r9
            com.mongodb.client.MongoCursor r0 = r0.iterator()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.aggregate(java.lang.String, java.lang.Class, com.mongodb.AggregationOptions, com.mongodb.ReadPreference):java.util.Iterator");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001F: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x001F: INVOKE_CUSTOM r2, method: dev.morphia.aggregation.AggregationPipelineImpl.bucket(java.lang.String, java.util.List<?>, dev.morphia.query.BucketOptions):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline bucket(java.lang.String r7, java.util.List<?> r8, dev.morphia.query.BucketOptions r9) {
        /*
            r6 = this;
            r0 = r8
            int r0 = r0.size()
            r1 = 2
            if (r0 >= r1) goto L_0x0014
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.String r2 = "Boundaries list should be present and has at least 2 elements"
            r1.<init>(r2)
            throw r0
            r0 = r9
            org.bson.Document r0 = r0.toDocument()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "groupBy"
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r10
            java.lang.String r1 = "boundaries"
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$bucket"
            r4 = r10
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.bucket(java.lang.String, java.util.List, dev.morphia.query.BucketOptions):dev.morphia.aggregation.AggregationPipeline");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001A: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x001A: INVOKE_CUSTOM r2, method: dev.morphia.aggregation.AggregationPipelineImpl.bucketAuto(java.lang.String, int, dev.morphia.query.BucketAutoOptions):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline bucketAuto(java.lang.String r7, int r8, dev.morphia.query.BucketAutoOptions r9) {
        /*
            r6 = this;
            r0 = r8
            r1 = 1
            if (r0 >= r1) goto L_0x000f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r1 = r0
            java.lang.String r2 = "bucket count should be more than 0"
            r1.<init>(r2)
            throw r0
            r0 = r9
            org.bson.Document r0 = r0.toDocument()
            r10 = r0
            r0 = r10
            java.lang.String r1 = "groupBy"
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r10
            java.lang.String r1 = "buckets"
            r2 = r8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$bucketAuto"
            r4 = r10
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.bucketAuto(java.lang.String, int, dev.morphia.query.BucketAutoOptions):dev.morphia.aggregation.AggregationPipeline");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0010: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0010: INVOKE_CUSTOM r2, method: dev.morphia.aggregation.AggregationPipelineImpl.group(java.lang.String, dev.morphia.aggregation.Group[]):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline group(@com.mongodb.lang.Nullable java.lang.String r7, dev.morphia.aggregation.Group... r8) {
        /*
            r6 = this;
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r9
            java.lang.String r1 = "_id"
            r2 = r7
            if (r2 == 0) goto L_0x0018
            r2 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            goto L_0x0019
            r2 = 0
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r8
            r10 = r0
            r0 = r10
            int r0 = r0.length
            r11 = r0
            r0 = 0
            r12 = r0
            r0 = r12
            r1 = r11
            if (r0 >= r1) goto L_0x0046
            r0 = r10
            r1 = r12
            r0 = r0[r1]
            r13 = r0
            r0 = r9
            r1 = r6
            r2 = r13
            org.bson.Document r1 = r1.toDocument(r2)
            r0.putAll(r1)
            int r12 = r12 + 1
            goto L_0x0028
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$group"
            r4 = r9
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.group(java.lang.String, dev.morphia.aggregation.Group[]):dev.morphia.aggregation.AggregationPipeline");
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r4, method: dev.morphia.aggregation.AggregationPipelineImpl.sortByCount(java.lang.String):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline sortByCount(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$sortByCount"
            r4 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.sortByCount(java.lang.String):dev.morphia.aggregation.AggregationPipeline");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0007: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0007: INVOKE_CUSTOM r3, method: dev.morphia.aggregation.AggregationPipelineImpl.unwind(java.lang.String, com.mongodb.client.model.UnwindOptions):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline unwind(java.lang.String r7, com.mongodb.client.model.UnwindOptions r8) {
        /*
            r6 = this;
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            java.lang.String r2 = "path"
            r3 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r1.<init>(r2, r3)
            java.lang.String r1 = "preserveNullAndEmptyArrays"
            r2 = r8
            java.lang.Boolean r2 = r2.isPreserveNullAndEmptyArrays()
            org.bson.Document r0 = r0.append(r1, r2)
            r9 = r0
            r0 = r8
            java.lang.String r0 = r0.getIncludeArrayIndex()
            r10 = r0
            r0 = r10
            if (r0 == 0) goto L_0x002d
            r0 = r9
            java.lang.String r1 = "includeArrayIndex"
            r2 = r10
            org.bson.Document r0 = r0.append(r1, r2)
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$unwind"
            r4 = r9
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.unwind(java.lang.String, com.mongodb.client.model.UnwindOptions):dev.morphia.aggregation.AggregationPipeline");
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r4, method: dev.morphia.aggregation.AggregationPipelineImpl.unwind(java.lang.String):dev.morphia.aggregation.AggregationPipeline
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.aggregation.AggregationPipeline
    public dev.morphia.aggregation.AggregationPipeline unwind(java.lang.String r7) {
        /*
            r6 = this;
            r0 = r6
            java.util.List<org.bson.Document> r0 = r0.stages
            org.bson.Document r1 = new org.bson.Document
            r2 = r1
            java.lang.String r3 = "$unwind"
            r4 = r7
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r2.<init>(r3, r4)
            boolean r0 = r0.add(r1)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.unwind(java.lang.String):dev.morphia.aggregation.AggregationPipeline");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0061: INVOKE_CUSTOM r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0061: INVOKE_CUSTOM r1, method: dev.morphia.aggregation.AggregationPipelineImpl.toExpressionArgs(java.util.List<java.lang.Object>):java.util.List<java.lang.Object>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private java.util.List<java.lang.Object> toExpressionArgs(@com.mongodb.lang.Nullable java.util.List<java.lang.Object> r5) {
        /*
            r4 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L_0x007b
            r0 = r5
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x007b
            r0 = r7
            java.lang.Object r0 = r0.next()
            r8 = r0
            r0 = r8
            boolean r0 = r0 instanceof dev.morphia.aggregation.Projection
            if (r0 == 0) goto L_0x006f
            r0 = r8
            dev.morphia.aggregation.Projection r0 = (dev.morphia.aggregation.Projection) r0
            r9 = r0
            r0 = r9
            java.util.List r0 = r0.getArguments()
            if (r0 != 0) goto L_0x004b
            r0 = r9
            java.util.List r0 = r0.getProjections()
            if (r0 != 0) goto L_0x004b
            r0 = r9
            java.lang.String r0 = r0.getSource()
            if (r0 == 0) goto L_0x005b
            r0 = r6
            r1 = r4
            r2 = r9
            org.bson.Document r1 = r1.toDocument(r2)
            boolean r0 = r0.add(r1)
            goto L_0x006c
            r0 = r6
            r1 = r9
            java.lang.String r1 = r1.getTarget()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            boolean r0 = r0.add(r1)
            goto L_0x0078
            r0 = r6
            r1 = r8
            boolean r0 = r0.add(r1)
            goto L_0x0013
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.aggregation.AggregationPipelineImpl.toExpressionArgs(java.util.List):java.util.List");
    }

    public AggregationPipelineImpl(Datastore datastore, MongoCollection collection, Class source) {
        this.collection = collection;
        this.mapper = datastore.getMapper();
        this.source = source;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> aggregate(Class<U> target) {
        return aggregate(target, AggregationOptions.builder().build(), this.collection.getReadPreference());
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> aggregate(Class<U> target, AggregationOptions options) {
        return aggregate(target, options, this.collection.getReadPreference());
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> aggregate(Class<U> target, AggregationOptions options, ReadPreference readPreference) {
        return aggregate(this.mapper.getCollection(target).getNamespace().getCollectionName(), target, options, readPreference);
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline bucket(String field, List<?> boundaries) {
        return bucket(field, boundaries, new BucketOptions());
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline bucketAuto(String field, int bucketCount) {
        return bucketAuto(field, bucketCount, new BucketAutoOptions());
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline geoNear(GeoNear geoNear) {
        throw new UnsupportedOperationException(Sofia.legacyOperation(new Locale[0]));
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline group(Group... groupings) {
        return group((String) null, groupings);
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline group(List<Group> id, Group... groupings) {
        Document idGroup = new Document();
        for (Group group : id) {
            idGroup.putAll(toDocument(group));
        }
        Document group2 = new Document(DBCollection.ID_FIELD_NAME, idGroup);
        for (Group grouping : groupings) {
            group2.putAll(toDocument(grouping));
        }
        this.stages.add(new Document("$group", group2));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline limit(int count) {
        this.stages.add(new Document("$limit", Integer.valueOf(count)));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline lookup(String from, String localField, String foreignField, String as) {
        this.stages.add(new Document("$lookup", new Document("from", from).append("localField", localField).append("foreignField", foreignField).append(InsertFromJNDIAction.AS_ATTR, as)));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline match(Query query) {
        this.stages.add(new Document("$match", query.disableValidation().toDocument()));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> out(Class<U> target) {
        return out(this.mapper.getCollection(target).getNamespace().getCollectionName(), target);
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> out(Class<U> target, AggregationOptions options) {
        return out(this.mapper.getCollection(target).getNamespace().getCollectionName(), target, options);
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> out(String collectionName, Class<U> target) {
        return out(collectionName, target, AggregationOptions.builder().build());
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public <U> Iterator<U> out(String collectionName, Class<U> target, AggregationOptions options) {
        this.stages.add(new Document("$out", collectionName));
        return aggregate(target, options);
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline project(Projection... projections) {
        this.firstStage = this.stages.isEmpty();
        Document document = new Document();
        for (Projection projection : projections) {
            document.putAll(toDocument(projection));
        }
        this.stages.add(new Document("$project", document));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline sample(int sampleSize) {
        this.stages.add(new Document("$sample", new Document("size", Integer.valueOf(sampleSize))));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline skip(int count) {
        this.stages.add(new Document("$skip", Integer.valueOf(count)));
        return this;
    }

    @Override // dev.morphia.aggregation.AggregationPipeline
    public AggregationPipeline sort(Sort... sorts) {
        Document sortList = new Document();
        for (Sort sort : sorts) {
            sortList.put(sort.getField(), (Object) Integer.valueOf(sort.getOrder()));
        }
        this.stages.add(new Document("$sort", sortList));
        return this;
    }

    public List<Document> getStages() {
        return this.stages;
    }

    public String toString() {
        return this.stages.toString();
    }

    private void putIfNull(Document document, String name, @Nullable Object value) {
        if (value != null) {
            document.put(name, value);
        }
    }

    private Document toDocument(Group group) {
        Document document = new Document();
        Accumulator accumulator = group.getAccumulator();
        if (accumulator != null) {
            document.put(group.getName(), (Object) accumulator.toDocument());
        } else {
            List<Projection> projections = group.getProjections();
            if (projections != null) {
                Document projection = new Document();
                for (Projection p : projections) {
                    projection.putAll(toDocument(p));
                }
                document.put(group.getName(), (Object) projection);
            } else {
                Group nested = group.getNested();
                if (nested != null) {
                    document.put(group.getName(), (Object) toDocument(nested));
                } else {
                    document.put(group.getName(), (Object) group.getSourceField());
                }
            }
        }
        return document;
    }

    private Document toDocument(Projection projection) {
        String target = projection.getTarget();
        if (this.firstStage) {
            EntityModel entityModel = this.mapper.getEntityModel(this.source);
            PropertyModel property = (entityModel == null || target == null) ? null : entityModel.getProperty(target);
            target = property != null ? property.getMappedName() : target;
        }
        List<Projection> list = projection.getProjections();
        if (list != null) {
            Document projections = new Document();
            for (Projection subProjection : list) {
                projections.putAll(toDocument(subProjection));
            }
            return new Document(target, projections);
        } else if (projection.getSource() != null) {
            return new Document(target, projection.getSource());
        } else {
            if (projection.getArguments() == null) {
                return new Document(target, Integer.valueOf(projection.isSuppressed() ? 0 : 1));
            }
            List<Object> args = toExpressionArgs(projection.getArguments());
            if (target == null) {
                if (args.size() == 1) {
                    Object firstArg = args.get(0);
                    if (firstArg instanceof Document) {
                        return (Document) firstArg;
                    }
                }
                throw new UnsupportedOperationException("aggregation support pending");
            } else if (args.size() == 1) {
                return new Document(target, args.get(0));
            } else {
                return new Document(target, args);
            }
        }
    }
}
