package dev.morphia.mapping.conventions;

import dev.morphia.Datastore;
import dev.morphia.mapping.codec.MethodAccessor;
import dev.morphia.mapping.codec.pojo.EntityModelBuilder;
import dev.morphia.mapping.codec.pojo.TypeData;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:dev/morphia/mapping/conventions/MethodDiscovery.class */
public class MethodDiscovery implements MorphiaConvention {
    private EntityModelBuilder entityModelBuilder;
    private Datastore datastore;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0017: INVOKE_CUSTOM r-6, r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0017: INVOKE_CUSTOM r0, r1, method: dev.morphia.mapping.conventions.MethodDiscovery.stripPrefix(java.lang.reflect.Method, int):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private java.lang.String stripPrefix(java.lang.reflect.Method r5, int r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.String r0 = r0.getName()
            r1 = r6
            java.lang.String r0 = r0.substring(r1)
            r7 = r0
            r0 = r7
            r1 = 0
            r2 = 1
            java.lang.String r0 = r0.substring(r1, r2)
            java.lang.String r0 = r0.toLowerCase()
            r1 = r7
            r2 = 1
            java.lang.String r1 = r1.substring(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, ]}
            r7 = r0
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.conventions.MethodDiscovery.stripPrefix(java.lang.reflect.Method, int):java.lang.String");
    }

    @Override // dev.morphia.mapping.conventions.MorphiaConvention
    public void apply(Datastore datastore, EntityModelBuilder builder) {
        this.datastore = datastore;
        this.entityModelBuilder = builder;
        List<Class<?>> list = new ArrayList<>(List.of(builder.getType()));
        list.addAll(builder.classHierarchy());
        for (Class<?> type : list) {
            processMethods(type);
        }
    }

    private List<Annotation> discoverAnnotations(Method getter, Method setter) {
        return (List) List.of(getter, setter).stream().flatMap(m -> {
            return Arrays.stream(m.getDeclaredAnnotations());
        }).collect(Collectors.toList());
    }

    private void processMethods(Class<?> type) {
        for (Map.Entry<String, List<Method>> entry : ((Map) Arrays.stream(type.getDeclaredMethods()).filter(m -> {
            return m.getName().startsWith(BeanUtil.PREFIX_GETTER_GET) || m.getName().startsWith("set") || m.getName().startsWith(BeanUtil.PREFIX_GETTER_IS);
        }).collect(Collectors.groupingBy(m -> {
            if (m.getName().startsWith(BeanUtil.PREFIX_GETTER_GET) || m.getName().startsWith("set")) {
                return stripPrefix(m, 3);
            }
            return stripPrefix(m, 2);
        }))).entrySet()) {
            List<Method> value = entry.getValue();
            if (value.size() == 2) {
                AnonymousClass1Methods methods = new Object(value) { // from class: dev.morphia.mapping.conventions.MethodDiscovery.1Methods
                    private final Method getter;
                    private final Method setter;

                    {
                        List<Method> collect = (List) methods.stream().sorted(Comparator.comparing((v0) -> {
                            return v0.getName();
                        })).collect(Collectors.toList());
                        this.getter = collect.get(0);
                        this.setter = collect.get(1);
                    }
                };
                this.entityModelBuilder.addProperty().name(entry.getKey()).accessor(new MethodAccessor(methods.getter, methods.setter)).annotations(discoverAnnotations(methods.getter, methods.setter)).typeData(this.entityModelBuilder.getTypeData(type, TypeData.newInstance(methods.getter), methods.getter.getGenericReturnType())).discoverMappedName(this.datastore.getMapper().getOptions());
            }
        }
    }
}
