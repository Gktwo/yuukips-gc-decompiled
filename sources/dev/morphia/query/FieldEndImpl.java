package dev.morphia.query;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;
import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.query.CriteriaContainer;
import dev.morphia.utils.Assert;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/FieldEndImpl.class */
public class FieldEndImpl<T extends CriteriaContainer> implements FieldEnd<T> {
    private static final Logger LOG = LoggerFactory.getLogger(FieldEndImpl.class);
    private final String field;
    private final T target;
    private final EntityModel model;
    private final boolean validating;
    private final Mapper mapper;
    private boolean not;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, method: dev.morphia.query.FieldEndImpl.endsWith(java.lang.String):T extends dev.morphia.query.CriteriaContainer
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldEnd
    public T endsWith(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "val"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            dev.morphia.utils.Assert.parametersNotNull(r0, r1)
            r0 = r6
            dev.morphia.query.FilterOperator r1 = dev.morphia.query.FilterOperator.EQUAL
            r2 = r7
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            dev.morphia.query.CriteriaContainer r0 = r0.addCriteria(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.FieldEndImpl.endsWith(java.lang.String):dev.morphia.query.CriteriaContainer");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, method: dev.morphia.query.FieldEndImpl.endsWithIgnoreCase(java.lang.String):T extends dev.morphia.query.CriteriaContainer
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldEnd
    public T endsWithIgnoreCase(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "val"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            dev.morphia.utils.Assert.parametersNotNull(r0, r1)
            r0 = r6
            dev.morphia.query.FilterOperator r1 = dev.morphia.query.FilterOperator.EQUAL
            r2 = r7
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, $]}
            r3 = 2
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            dev.morphia.query.CriteriaContainer r0 = r0.addCriteria(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.FieldEndImpl.endsWithIgnoreCase(java.lang.String):dev.morphia.query.CriteriaContainer");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0018: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r2, method: dev.morphia.query.FieldEndImpl.equalIgnoreCase(java.lang.Object):T extends dev.morphia.query.CriteriaContainer
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^$]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^$]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldEnd
    public T equalIgnoreCase(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.String r0 = "val"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            dev.morphia.utils.Assert.parametersNotNull(r0, r1)
            r0 = r6
            dev.morphia.query.FilterOperator r1 = dev.morphia.query.FilterOperator.EQUAL
            r2 = r7
            java.lang.String r2 = r2.toString()
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^$]}
            r3 = 2
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            dev.morphia.query.CriteriaContainer r0 = r0.addCriteria(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.FieldEndImpl.equalIgnoreCase(java.lang.Object):dev.morphia.query.CriteriaContainer");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, method: dev.morphia.query.FieldEndImpl.startsWith(java.lang.String):T extends dev.morphia.query.CriteriaContainer
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldEnd
    public T startsWith(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "val"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            dev.morphia.utils.Assert.parametersNotNull(r0, r1)
            r0 = r6
            dev.morphia.query.FilterOperator r1 = dev.morphia.query.FilterOperator.EQUAL
            r2 = r7
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            dev.morphia.query.CriteriaContainer r0 = r0.addCriteria(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.FieldEndImpl.startsWith(java.lang.String):dev.morphia.query.CriteriaContainer");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r2, method: dev.morphia.query.FieldEndImpl.startsWithIgnoreCase(java.lang.String):T extends dev.morphia.query.CriteriaContainer
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // dev.morphia.query.FieldEnd
    public T startsWithIgnoreCase(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "val"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r2 = r1
            r3 = 0
            r4 = r7
            r2[r3] = r4
            dev.morphia.utils.Assert.parametersNotNull(r0, r1)
            r0 = r6
            dev.morphia.query.FilterOperator r1 = dev.morphia.query.FilterOperator.EQUAL
            r2 = r7
            java.lang.String r2 = java.util.regex.Pattern.quote(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, ^]}
            r3 = 2
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            dev.morphia.query.CriteriaContainer r0 = r0.addCriteria(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.FieldEndImpl.startsWithIgnoreCase(java.lang.String):dev.morphia.query.CriteriaContainer");
    }

    /* access modifiers changed from: protected */
    public FieldEndImpl(Mapper mapper, String field, T target, EntityModel model, boolean validating) {
        this.mapper = mapper;
        this.field = field;
        this.target = target;
        this.model = model;
        this.validating = validating;
    }

    @Override // dev.morphia.query.FieldEnd
    public T contains(String string) {
        Assert.parametersNotNull("val", string);
        return addCriteria(FilterOperator.EQUAL, Pattern.compile(Pattern.quote(string)));
    }

    @Override // dev.morphia.query.FieldEnd
    public T containsIgnoreCase(String string) {
        Assert.parametersNotNull("val", string);
        return addCriteria(FilterOperator.EQUAL, Pattern.compile(Pattern.quote(string), 2));
    }

    @Override // dev.morphia.query.FieldEnd
    public T doesNotExist() {
        return addCriteria(FilterOperator.EXISTS, false);
    }

    @Override // dev.morphia.query.FieldEnd
    public T equal(Object val) {
        return addCriteria(FilterOperator.EQUAL, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T exists() {
        return addCriteria(FilterOperator.EXISTS, true);
    }

    @Override // dev.morphia.query.FieldEnd
    public T greaterThan(Object val) {
        Assert.parametersNotNull("val", val);
        return addCriteria(FilterOperator.GREATER_THAN, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T greaterThanOrEq(Object val) {
        Assert.parametersNotNull("val", val);
        return addCriteria(FilterOperator.GREATER_THAN_OR_EQUAL, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T hasAllOf(Iterable<?> values) {
        Assert.parametersNotNull("values", values);
        Assert.parameterNotEmpty("values", values);
        return addCriteria(FilterOperator.ALL, values);
    }

    @Override // dev.morphia.query.FieldEnd
    public T hasAnyOf(Iterable<?> values) {
        Assert.parametersNotNull("values", values);
        Assert.parameterNotEmpty("values", values);
        return addCriteria(FilterOperator.IN, values);
    }

    @Override // dev.morphia.query.FieldEnd
    public T hasNoneOf(Iterable<?> values) {
        Assert.parametersNotNull("values", values);
        Assert.parameterNotEmpty("values", values);
        return addCriteria(FilterOperator.NOT_IN, values);
    }

    @Override // dev.morphia.query.FieldEnd
    public T elemMatch(Query query) {
        Assert.parametersNotNull("query", query);
        return addCriteria(FilterOperator.ELEMENT_MATCH, query, this.not);
    }

    @Override // dev.morphia.query.FieldEnd
    public T hasThisOne(Object val) {
        return addCriteria(FilterOperator.EQUAL, val);
    }

    @Override // dev.morphia.query.FieldEnd
    /* renamed from: in */
    public T mo1225in(Iterable<?> values) {
        return hasAnyOf(values);
    }

    @Override // dev.morphia.query.FieldEnd
    public T intersects(Geometry geometry) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.INTERSECTS, geometry, this.model, this.validating));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T intersects(Geometry geometry, CoordinateReferenceSystem crs) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.INTERSECTS, geometry, this.model, this.validating).addCoordinateReferenceSystem(crs));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T lessThan(Object val) {
        Assert.parametersNotNull("val", val);
        return addCriteria(FilterOperator.LESS_THAN, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T lessThanOrEq(Object val) {
        Assert.parametersNotNull("val", val);
        return addCriteria(FilterOperator.LESS_THAN_OR_EQUAL, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T mod(long divisor, long remainder) {
        return addCriteria(FilterOperator.MOD, new long[]{divisor, remainder});
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(double longitude, double latitude) {
        return near(longitude, latitude, false);
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(double longitude, double latitude, boolean spherical) {
        FilterOperator filterOperator;
        if (spherical) {
            filterOperator = FilterOperator.NEAR_SPHERE;
        } else {
            filterOperator = FilterOperator.NEAR;
        }
        return addGeoCriteria(filterOperator, new double[]{longitude, latitude}, new HashMap());
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(double longitude, double latitude, double radius) {
        return near(longitude, latitude, radius, false);
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(double longitude, double latitude, double radius, boolean spherical) {
        return addGeoCriteria(spherical ? FilterOperator.NEAR_SPHERE : FilterOperator.NEAR, new double[]{longitude, latitude}, Map.of(QueryOperators.MAX_DISTANCE, Double.valueOf(radius)));
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(Point point) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.NEAR, point, this.model, this.validating));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T near(Point point, Double maxDistance, Double minDistance) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.NEAR, point, this.model, this.validating).maxDistance(maxDistance).minDistance(minDistance));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T nearSphere(Point point) {
        return nearSphere(point, (Double) null, (Double) null);
    }

    @Override // dev.morphia.query.FieldEnd
    public T nearSphere(Point point, @Nullable Double maxDistance, @Nullable Double minDistance) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.NEAR_SPHERE, point, this.model, this.validating).maxDistance(maxDistance).minDistance(minDistance));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public FieldEnd<T> not() {
        this.not = !this.not;
        return this;
    }

    @Override // dev.morphia.query.FieldEnd
    public T notEqual(Object val) {
        return addCriteria(FilterOperator.NOT_EQUAL, val);
    }

    @Override // dev.morphia.query.FieldEnd
    public T notIn(Iterable<?> values) {
        return hasNoneOf(values);
    }

    @Override // dev.morphia.query.FieldEnd
    public T sizeEq(int val) {
        return addCriteria(FilterOperator.SIZE, Integer.valueOf(val));
    }

    @Override // dev.morphia.query.FieldEnd
    public T type(Type type) {
        return addCriteria(FilterOperator.TYPE, type);
    }

    @Override // dev.morphia.query.FieldEnd
    public T within(Shape shape) {
        Assert.parametersNotNull("shape", shape);
        return addCriteria(FilterOperator.GEO_WITHIN, shape);
    }

    @Override // dev.morphia.query.FieldEnd
    public T within(Polygon boundary) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.GEO_WITHIN, boundary, this.model, this.validating));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T within(MultiPolygon boundaries) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.GEO_WITHIN, boundaries, this.model, this.validating));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T within(Polygon boundary, CoordinateReferenceSystem crs) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.GEO_WITHIN, boundary, this.model, this.validating).addCoordinateReferenceSystem(crs));
        return this.target;
    }

    @Override // dev.morphia.query.FieldEnd
    public T within(MultiPolygon boundaries, CoordinateReferenceSystem crs) {
        this.target.add(Geo2dSphereCriteria.geo(this.mapper, this.field, FilterOperator.GEO_WITHIN, boundaries, this.model, this.validating).addCoordinateReferenceSystem(crs));
        return this.target;
    }

    protected T addCriteria(FilterOperator op, Object val) {
        return addCriteria(op, val, this.not);
    }

    protected T addCriteria(FilterOperator op, Object val, boolean not) {
        this.target.add(new FieldCriteria(this.mapper, this.field, op, val, not, this.model, this.validating));
        return this.target;
    }

    protected T addGeoCriteria(FilterOperator op, Object val, Map<String, Object> opts) {
        if (this.not) {
            throw new QueryException("Geospatial queries cannot be negated with 'not'.");
        }
        this.target.add(new Geo2dCriteria(this.mapper, this.field, op, val, opts, this.model, this.validating));
        return this.target;
    }

    protected String getField() {
        return this.field;
    }

    protected boolean isNot() {
        return this.not;
    }
}
