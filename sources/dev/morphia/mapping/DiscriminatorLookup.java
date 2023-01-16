package dev.morphia.mapping;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import org.bson.codecs.configuration.CodecConfigurationException;

/* loaded from: grasscutter.jar:dev/morphia/mapping/DiscriminatorLookup.class */
public final class DiscriminatorLookup {
    private final Map<String, Class<?>> discriminatorClassMap = new ConcurrentHashMap();
    private final Set<String> packages = new ConcurrentSkipListSet();
    private final ClassLoader classLoader;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0024: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0024: INVOKE_CUSTOM r1, r2, method: dev.morphia.mapping.DiscriminatorLookup.searchPackages(java.lang.String):java.lang.Class<?>
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @com.mongodb.lang.Nullable
    private java.lang.Class<?> searchPackages(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
            r0 = r4
            java.util.Set<java.lang.String> r0 = r0.packages
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0036
            r0 = r7
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r8 = r0
            r0 = r4
            r1 = r8
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, .]}
            java.lang.Class r0 = r0.getClassForName(r1)
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x0033
            r0 = r6
            return r0
            goto L_0x000c
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.DiscriminatorLookup.searchPackages(java.lang.String):java.lang.Class");
    }

    public DiscriminatorLookup(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void addModel(EntityModel entityModel) {
        this.discriminatorClassMap.put(entityModel.getDiscriminator(), entityModel.getType());
    }

    public Class<?> lookup(String discriminator) {
        if (this.discriminatorClassMap.containsKey(discriminator)) {
            return this.discriminatorClassMap.get(discriminator);
        }
        Class<?> clazz = getClassForName(discriminator);
        if (clazz == null) {
            clazz = searchPackages(discriminator);
        }
        if (clazz == null) {
            throw new CodecConfigurationException(String.format("A class could not be found for the discriminator: '%s'.", discriminator));
        }
        this.discriminatorClassMap.put(discriminator, clazz);
        return clazz;
    }

    @Nullable
    private Class<?> getClassForName(String discriminator) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(discriminator, true, this.classLoader);
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }
}
