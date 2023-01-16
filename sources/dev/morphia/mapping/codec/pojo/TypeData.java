package dev.morphia.mapping.codec.pojo;

import dev.morphia.mapping.codec.pojo.WildCardTypeData;
import dev.morphia.sofia.Sofia;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.bson.assertions.Assertions;
import org.bson.codecs.pojo.TypeWithTypeParameters;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/TypeData.class */
public class TypeData<T> implements TypeWithTypeParameters<T> {
    private static final Map<Class<?>, Class<?>> PRIMITIVE_CLASS_MAP = Map.of(Boolean.TYPE, Boolean.class, Byte.TYPE, Byte.class, Character.TYPE, Character.class, Double.TYPE, Double.class, Float.TYPE, Float.class, Integer.TYPE, Integer.class, Long.TYPE, Long.class, Short.TYPE, Short.class);
    private final Class<T> type;
    private final List<TypeData<?>> typeParameters;

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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0026: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0018: INVOKE_CUSTOM r0, method: dev.morphia.mapping.codec.pojo.TypeData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, , typeParameters=[]]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, , typeParameters=[]]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0026: INVOKE_CUSTOM r0, r1, method: dev.morphia.mapping.codec.pojo.TypeData.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TypeData{type=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TypeData{type=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = r3
            java.util.List<dev.morphia.mapping.codec.pojo.TypeData<?>> r0 = r0.typeParameters
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = ""
            goto L_0x001d
            r0 = r3
            java.util.List<dev.morphia.mapping.codec.pojo.TypeData<?>> r0 = r0.typeParameters
            java.lang.String r0 = nestedTypeParameters(r0)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, , typeParameters=[]]}
            r4 = r0
            r0 = r3
            java.lang.Class<T> r0 = r0.type
            java.lang.String r0 = r0.getSimpleName()
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, TypeData{type=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.pojo.TypeData.toString():java.lang.String");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<T> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public TypeData(Class<T> type, List<TypeData<?>> typeParameters) {
        this.type = (Class<T>) boxType(type);
        this.typeParameters = typeParameters;
    }

    public static <T> Builder<T> builder(Class<T> type) {
        return new Builder<>((Class) Assertions.notNull("type", type));
    }

    private static <T> TypeData<?> getTypeData(Type type) {
        Type[] bounds;
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Builder paramBuilder = builder((Class) pType.getRawType());
            for (Type argType : pType.getActualTypeArguments()) {
                paramBuilder.addTypeParameter(getTypeData(argType));
            }
            return paramBuilder.build();
        } else if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds != null) {
                bounds = upperBounds;
            } else {
                bounds = wildcardType.getLowerBounds();
            }
            WildCardTypeData.Builder wildCard = WildCardTypeData.builder(upperBounds != null);
            for (Type bound : bounds) {
                wildCard.addTypeParameter(getTypeData(bound));
            }
            return wildCard.build();
        } else if (type instanceof TypeVariable) {
            return builder(Object.class).build();
        } else {
            if (type instanceof Class) {
                Builder builder = builder((Class) type);
                for (TypeVariable typeParameter : builder.type.getTypeParameters()) {
                    builder.addTypeParameter(getTypeData(typeParameter));
                }
                return builder.build();
            }
            throw new UnsupportedOperationException(Sofia.unhandledTypeData(type.getTypeName(), new Locale[0]));
        }
    }

    private static String nestedTypeParameters(List<TypeData<?>> typeParameters) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int last = typeParameters.size();
        for (TypeData<?> typeParameter : typeParameters) {
            count++;
            builder.append(typeParameter.getType().getSimpleName());
            if (!typeParameter.getTypeParameters().isEmpty()) {
                builder.append(String.format("<%s>", nestedTypeParameters(typeParameter.getTypeParameters())));
            }
            if (count < last) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public static TypeData<?> newInstance(Field field) {
        return newInstance(field.getGenericType(), field.getType());
    }

    public static TypeData<?> newInstance(Method method) {
        return newInstance(method.getGenericReturnType(), method.getReturnType());
    }

    public static <T> TypeData<T> newInstance(Type genericType, Class<T> clazz) {
        Builder<T> builder = builder(clazz);
        if (genericType instanceof ParameterizedType) {
            for (Type argType : ((ParameterizedType) genericType).getActualTypeArguments()) {
                builder.addTypeParameter(getTypeData(argType));
            }
        }
        return builder.build();
    }

    @Override // org.bson.codecs.pojo.TypeWithTypeParameters
    public Class<T> getType() {
        return this.type;
    }

    @Override // org.bson.codecs.pojo.TypeWithTypeParameters
    public List<TypeData<?>> getTypeParameters() {
        return this.typeParameters;
    }

    public int hashCode() {
        return (31 * getType().hashCode()) + getTypeParameters().hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TypeData)) {
            return false;
        }
        TypeData<?> that = (TypeData) o;
        if (!getType().equals(that.getType())) {
            return false;
        }
        return getTypeParameters().equals(that.getTypeParameters());
    }

    public TypeData<?> withType(Class<?> concreteClass) {
        return new TypeData<>(concreteClass, new ArrayList(this.typeParameters));
    }

    private <S> Class<S> boxType(Class<S> clazz) {
        if (clazz.isPrimitive()) {
            return (Class<S>) PRIMITIVE_CLASS_MAP.get(clazz);
        }
        return clazz;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    boolean isAssignableFrom(Class<?> cls) {
        return this.type.isAssignableFrom(boxType(cls));
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/codec/pojo/TypeData$Builder.class */
    public static final class Builder<T> {
        private final Class<T> type;
        private final List<TypeData<?>> typeParameters = new ArrayList();

        private Builder(Class<T> type) {
            this.type = type;
        }

        public <S> Builder<T> addTypeParameter(TypeData<S> typeParameter) {
            this.typeParameters.add((TypeData) Assertions.notNull("typeParameter", typeParameter));
            return this;
        }

        public TypeData<T> build() {
            return new TypeData<>(this.type, Collections.unmodifiableList(this.typeParameters));
        }
    }
}
