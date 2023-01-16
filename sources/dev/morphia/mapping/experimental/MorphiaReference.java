package dev.morphia.mapping.experimental;

import com.mongodb.lang.Nullable;
import dev.morphia.Datastore;
import dev.morphia.annotations.Handler;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Handler(MorphiaReferenceCodec.class)
/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/MorphiaReference.class */
public abstract class MorphiaReference<T> {
    private Datastore datastore;
    private boolean ignoreMissing;
    private boolean resolved;

    @Nullable
    public abstract T get();

    public abstract List<Object> getIds();

    public abstract Class<T> getType();

    /*  JADX ERROR: Dependency scan failed at insn: 0x000D: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000D: INVOKE_CUSTOM r3, method: dev.morphia.mapping.experimental.MorphiaReference.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, <<]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, <<]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.util.StringJoiner r0 = new java.util.StringJoiner
            r1 = r0
            java.lang.String r2 = ", "
            r3 = r6
            java.lang.Class r3 = r3.getClass()
            java.lang.String r3 = r3.getSimpleName()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, <<]}
            java.lang.String r4 = ">>"
            r1.<init>(r2, r3, r4)
            r1 = r6
            java.util.List r1 = r1.getIds()
            java.lang.String r1 = r1.toString()
            java.util.StringJoiner r0 = r0.add(r1)
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.experimental.MorphiaReference.toString():java.lang.String");
    }

    /* access modifiers changed from: package-private */
    public abstract Object getId(Mapper mapper, Datastore datastore, EntityModel entityModel);

    /* access modifiers changed from: package-private */
    public MorphiaReference() {
    }

    /* access modifiers changed from: package-private */
    public MorphiaReference(Datastore datastore) {
        this.datastore = datastore;
    }

    public static <V> MorphiaReference<V> wrap(V value) {
        if (value instanceof List) {
            return new ListReference((List) value);
        }
        if (value instanceof Set) {
            return new SetReference((Set) value);
        }
        if (value instanceof Map) {
            return new MapReference((Map) value);
        }
        return new SingleReference(value);
    }

    public int hashCode() {
        return isResolved() ? 1 : 0;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MorphiaReference)) {
            return false;
        }
        return getIds().equals(((MorphiaReference) o).getIds());
    }

    public MorphiaReference<T> ignoreMissing(boolean ignoreMissing) {
        this.ignoreMissing = ignoreMissing;
        return this;
    }

    public boolean ignoreMissing() {
        return this.ignoreMissing;
    }

    public final boolean isResolved() {
        return this.resolved;
    }

    protected void resolve() {
        this.resolved = true;
    }

    Datastore getDatastore() {
        return this.datastore;
    }
}
