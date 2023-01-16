package net.bytebuddy.utility;

import dev.morphia.mapping.Mapper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant.class */
public interface JavaConstant {
    Object toDescription();

    TypeDescription getTypeDescription();

    <T> T accept(Visitor<T> visitor);

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Visitor.class */
    public interface Visitor<T> {
        T onValue(Simple<?> simple);

        T onType(Simple<TypeDescription> simple);

        T onMethodType(MethodType methodType);

        T onMethodHandle(MethodHandle methodHandle);

        T onDynamic(Dynamic dynamic);

        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Visitor$NoOp.class */
        public enum NoOp implements Visitor<JavaConstant> {
            INSTANCE;

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onValue(Simple<?> constant) {
                return constant;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onType(Simple<TypeDescription> constant) {
                return constant;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onMethodType(MethodType constant) {
                return constant;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onMethodHandle(MethodHandle constant) {
                return constant;
            }

            @Override // net.bytebuddy.utility.JavaConstant.Visitor
            public JavaConstant onDynamic(Dynamic constant) {
                return constant;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple.class */
    public static abstract class Simple<T> implements JavaConstant {
        protected static final Dispatcher CONSTANT_DESC = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
        protected static final Dispatcher.OfClassDesc CLASS_DESC = (Dispatcher.OfClassDesc) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfClassDesc.class));
        protected static final Dispatcher.OfMethodTypeDesc METHOD_TYPE_DESC = (Dispatcher.OfMethodTypeDesc) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfMethodTypeDesc.class));
        protected static final Dispatcher.OfMethodHandleDesc METHOD_HANDLE_DESC = (Dispatcher.OfMethodHandleDesc) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfMethodHandleDesc.class));
        protected static final Dispatcher.OfDirectMethodHandleDesc DIRECT_METHOD_HANDLE_DESC = (Dispatcher.OfDirectMethodHandleDesc) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfDirectMethodHandleDesc.class));
        protected static final Dispatcher.OfDirectMethodHandleDesc.ForKind DIRECT_METHOD_HANDLE_DESC_KIND = (Dispatcher.OfDirectMethodHandleDesc.ForKind) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfDirectMethodHandleDesc.ForKind.class));
        protected static final Dispatcher.OfDynamicConstantDesc DYNAMIC_CONSTANT_DESC = (Dispatcher.OfDynamicConstantDesc) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.OfDynamicConstantDesc.class));
        protected final T value;
        private final TypeDescription typeDescription;

        @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc")
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher.class */
        protected interface Dispatcher {

            @JavaDispatcher.Proxied("java.lang.constant.ClassDesc")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfClassDesc.class */
            public interface OfClassDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                Object ofDescriptor(String str);

                String descriptorString(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfDirectMethodHandleDesc.class */
            public interface OfDirectMethodHandleDesc extends Dispatcher {

                @JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind")
                /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfDirectMethodHandleDesc$ForKind.class */
                public interface ForKind {
                    @JavaDispatcher.IsStatic
                    Object valueOf(int i, boolean z);
                }

                int refKind(Object obj);

                String methodName(Object obj);

                Object owner(Object obj);

                String lookupDescriptor(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.DynamicConstantDesc")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfDynamicConstantDesc.class */
            public interface OfDynamicConstantDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                Object ofCanonical(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc") Object obj, String str, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, @JavaDispatcher.Proxied("java.lang.constant.ConstantDesc") Object[] objArr);

                Object[] bootstrapArgs(Object obj);

                String constantName(Object obj);

                Object constantType(Object obj);

                Object bootstrapMethod(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodHandleDesc")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfMethodHandleDesc.class */
            public interface OfMethodHandleDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                /* renamed from: of */
                Object m66of(@JavaDispatcher.Proxied("java.lang.constant.DirectMethodHandleDesc$Kind") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj2, String str, String str2);

                Object invocationType(Object obj);
            }

            @JavaDispatcher.Proxied("java.lang.constant.MethodTypeDesc")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$Dispatcher$OfMethodTypeDesc.class */
            public interface OfMethodTypeDesc extends Dispatcher {
                @JavaDispatcher.IsStatic
                /* renamed from: of */
                Object m65of(@JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object obj, @JavaDispatcher.Proxied("java.lang.constant.ClassDesc") Object[] objArr);

                @JavaDispatcher.IsStatic
                Object ofDescriptor(String str);

                Object returnType(Object obj);

                Object[] parameterArray(Object obj);
            }

            @JavaDispatcher.Instance
            boolean isInstance(Object obj);

            @JavaDispatcher.Container
            Object[] toArray(int i);
        }

        protected Simple(T value, TypeDescription typeDescription) {
            this.value = value;
            this.typeDescription = typeDescription;
        }

        public static JavaConstant ofLoaded(Object value) {
            if (value instanceof Integer) {
                return new OfTrivialValue((Integer) value, TypeDescription.ForLoadedType.m247of(Integer.TYPE));
            }
            if (value instanceof Long) {
                return new OfTrivialValue((Long) value, TypeDescription.ForLoadedType.m247of(Long.TYPE));
            }
            if (value instanceof Float) {
                return new OfTrivialValue((Float) value, TypeDescription.ForLoadedType.m247of(Float.TYPE));
            }
            if (value instanceof Double) {
                return new OfTrivialValue((Double) value, TypeDescription.ForLoadedType.m247of(Double.TYPE));
            }
            if (value instanceof String) {
                return new OfTrivialValue((String) value, TypeDescription.STRING);
            }
            if (value instanceof Class) {
                return m67of(TypeDescription.ForLoadedType.m247of((Class) value));
            }
            if (JavaType.METHOD_HANDLE.isInstance(value)) {
                return MethodHandle.ofLoaded(value);
            }
            if (JavaType.METHOD_TYPE.isInstance(value)) {
                return MethodType.ofLoaded(value);
            }
            throw new IllegalArgumentException("Not a loaded Java constant value: " + value);
        }

        public static JavaConstant ofDescription(Object value, ClassLoader classLoader) {
            return ofDescription(value, ClassFileLocator.ForClassLoader.m232of(classLoader));
        }

        public static JavaConstant ofDescription(Object value, ClassFileLocator classFileLocator) {
            return ofDescription(value, TypePool.Default.WithLazyResolution.m83of(classFileLocator));
        }

        public static JavaConstant ofDescription(Object value, TypePool typePool) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            if (value instanceof Integer) {
                return new OfTrivialValue((Integer) value, TypeDescription.ForLoadedType.m247of(Integer.TYPE));
            }
            if (value instanceof Long) {
                return new OfTrivialValue((Long) value, TypeDescription.ForLoadedType.m247of(Long.TYPE));
            }
            if (value instanceof Float) {
                return new OfTrivialValue((Float) value, TypeDescription.ForLoadedType.m247of(Float.TYPE));
            }
            if (value instanceof Double) {
                return new OfTrivialValue((Double) value, TypeDescription.ForLoadedType.m247of(Double.TYPE));
            }
            if (value instanceof String) {
                return new OfTrivialValue((String) value, TypeDescription.STRING);
            }
            if (CLASS_DESC.isInstance(value)) {
                Type type = Type.getType(CLASS_DESC.descriptorString(value));
                if (type.getSort() == 9) {
                    str7 = type.getInternalName().replace('/', '.');
                } else {
                    str7 = type.getClassName();
                }
                return OfTypeDescription.m67of(typePool.describe(str7).resolve());
            } else if (METHOD_TYPE_DESC.isInstance(value)) {
                Object[] parameterTypes = METHOD_TYPE_DESC.parameterArray(value);
                List<TypeDescription> typeDescriptions = new ArrayList<>(parameterTypes.length);
                for (Object parameterType : parameterTypes) {
                    Type type2 = Type.getType(CLASS_DESC.descriptorString(parameterType));
                    if (type2.getSort() == 9) {
                        str6 = type2.getInternalName().replace('/', '.');
                    } else {
                        str6 = type2.getClassName();
                    }
                    typeDescriptions.add(typePool.describe(str6).resolve());
                }
                Type type3 = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(value)));
                if (type3.getSort() == 9) {
                    str5 = type3.getInternalName().replace('/', '.');
                } else {
                    str5 = type3.getClassName();
                }
                return MethodType.m69of(typePool.describe(str5).resolve(), typeDescriptions);
            } else if (DIRECT_METHOD_HANDLE_DESC.isInstance(value)) {
                Object[] parameterTypes2 = METHOD_TYPE_DESC.parameterArray(METHOD_HANDLE_DESC.invocationType(value));
                List<TypeDescription> typeDescriptions2 = new ArrayList<>(parameterTypes2.length);
                for (Object parameterType2 : parameterTypes2) {
                    Type type4 = Type.getType(CLASS_DESC.descriptorString(parameterType2));
                    if (type4.getSort() == 9) {
                        str4 = type4.getInternalName().replace('/', '.');
                    } else {
                        str4 = type4.getClassName();
                    }
                    typeDescriptions2.add(typePool.describe(str4).resolve());
                }
                Type type5 = Type.getType(CLASS_DESC.descriptorString(METHOD_TYPE_DESC.returnType(METHOD_HANDLE_DESC.invocationType(value))));
                return new MethodHandle(MethodHandle.HandleType.m75of(DIRECT_METHOD_HANDLE_DESC.refKind(value)), typePool.describe(Type.getType(CLASS_DESC.descriptorString(DIRECT_METHOD_HANDLE_DESC.owner(value))).getClassName()).resolve(), DIRECT_METHOD_HANDLE_DESC.methodName(value), DIRECT_METHOD_HANDLE_DESC.refKind(value) == 8 ? TypeDescription.VOID : typePool.describe(type5.getSort() == 9 ? type5.getInternalName().replace('/', '.') : type5.getClassName()).resolve(), typeDescriptions2);
            } else if (DYNAMIC_CONSTANT_DESC.isInstance(value)) {
                Type methodType = Type.getMethodType(DIRECT_METHOD_HANDLE_DESC.lookupDescriptor(DYNAMIC_CONSTANT_DESC.bootstrapMethod(value)));
                List<TypeDescription> parameterTypes3 = new ArrayList<>(methodType.getArgumentTypes().length);
                Type[] argumentTypes = methodType.getArgumentTypes();
                for (Type type6 : argumentTypes) {
                    if (type6.getSort() == 9) {
                        str3 = type6.getInternalName().replace('/', '.');
                    } else {
                        str3 = type6.getClassName();
                    }
                    parameterTypes3.add(typePool.describe(str3).resolve());
                }
                Object[] constant = DYNAMIC_CONSTANT_DESC.bootstrapArgs(value);
                List<JavaConstant> arguments = new ArrayList<>(constant.length);
                for (Object aConstant : constant) {
                    arguments.add(ofDescription(aConstant, typePool));
                }
                Type type7 = Type.getType(CLASS_DESC.descriptorString(DYNAMIC_CONSTANT_DESC.constantType(value)));
                String constantName = DYNAMIC_CONSTANT_DESC.constantName(value);
                if (type7.getSort() == 9) {
                    str = type7.getInternalName().replace('/', '.');
                } else {
                    str = type7.getClassName();
                }
                TypeDescription resolve = typePool.describe(str).resolve();
                MethodHandle.HandleType of = MethodHandle.HandleType.m75of(DIRECT_METHOD_HANDLE_DESC.refKind(DYNAMIC_CONSTANT_DESC.bootstrapMethod(value)));
                TypeDescription resolve2 = typePool.describe(Type.getType(CLASS_DESC.descriptorString(DIRECT_METHOD_HANDLE_DESC.owner(DYNAMIC_CONSTANT_DESC.bootstrapMethod(value)))).getClassName()).resolve();
                String methodName = DIRECT_METHOD_HANDLE_DESC.methodName(DYNAMIC_CONSTANT_DESC.bootstrapMethod(value));
                if (methodType.getReturnType().getSort() == 9) {
                    str2 = methodType.getReturnType().getInternalName().replace('/', '.');
                } else {
                    str2 = methodType.getReturnType().getClassName();
                }
                return new Dynamic(constantName, resolve, new MethodHandle(of, resolve2, methodName, typePool.describe(str2).resolve(), parameterTypes3), arguments);
            } else {
                throw new IllegalArgumentException("Not a resolvable constant description or not expressible as a constant pool value: " + value);
            }
        }

        /* renamed from: of */
        public static JavaConstant m67of(TypeDescription typeDescription) {
            if (!typeDescription.isPrimitive()) {
                return new OfTypeDescription(typeDescription);
            }
            throw new IllegalArgumentException("A primitive type cannot be represented as a type constant: " + typeDescription);
        }

        public static JavaConstant wrap(Object value) {
            if (value instanceof JavaConstant) {
                return (JavaConstant) value;
            }
            if (value instanceof TypeDescription) {
                return m67of((TypeDescription) value);
            }
            return ofLoaded(value);
        }

        public static List<JavaConstant> wrap(List<?> values) {
            List<JavaConstant> constants = new ArrayList<>(values.size());
            Iterator<?> it = values.iterator();
            while (it.hasNext()) {
                constants.add(wrap(it.next()));
            }
            return constants;
        }

        public T getValue() {
            return this.value;
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            return this.value.equals(((Simple) object).value);
        }

        public String toString() {
            return this.value.toString();
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$OfTrivialValue.class */
        public static class OfTrivialValue<S> extends Simple<S> {
            protected OfTrivialValue(S value, TypeDescription typeDescription) {
                super(value, typeDescription);
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public Object toDescription() {
                return this.value;
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onValue(this);
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Simple$OfTypeDescription.class */
        public static class OfTypeDescription extends Simple<TypeDescription> {
            protected OfTypeDescription(TypeDescription value) {
                super(value, TypeDescription.CLASS);
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public Object toDescription() {
                return CLASS_DESC.ofDescriptor(((TypeDescription) this.value).getDescriptor());
            }

            @Override // net.bytebuddy.utility.JavaConstant
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onType(this);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodType.class */
    public static class MethodType implements JavaConstant {
        private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
        private final TypeDescription returnType;
        private final List<? extends TypeDescription> parameterTypes;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodType$Dispatcher.class */
        public interface Dispatcher {
            Class<?> returnType(Object obj);

            Class<?>[] parameterArray(Object obj);
        }

        protected MethodType(TypeDescription returnType, List<? extends TypeDescription> parameterTypes) {
            this.returnType = returnType;
            this.parameterTypes = parameterTypes;
        }

        public static MethodType ofLoaded(Object methodType) {
            if (JavaType.METHOD_TYPE.isInstance(methodType)) {
                return m73of(DISPATCHER.returnType(methodType), DISPATCHER.parameterArray(methodType));
            }
            throw new IllegalArgumentException("Expected method type object: " + methodType);
        }

        /* renamed from: of */
        public static MethodType m73of(Class<?> returnType, Class<?>... parameterType) {
            return m69of(TypeDescription.ForLoadedType.m247of(returnType), new TypeList.ForLoadedTypes(parameterType));
        }

        /* renamed from: of */
        public static MethodType m68of(TypeDescription returnType, TypeDescription... parameterType) {
            return new MethodType(returnType, Arrays.asList(parameterType));
        }

        /* renamed from: of */
        public static MethodType m69of(TypeDescription returnType, List<? extends TypeDescription> parameterTypes) {
            return new MethodType(returnType, parameterTypes);
        }

        /* renamed from: of */
        public static MethodType m71of(Method method) {
            return m70of(new MethodDescription.ForLoadedMethod(method));
        }

        /* renamed from: of */
        public static MethodType m72of(Constructor<?> constructor) {
            return m70of(new MethodDescription.ForLoadedConstructor(constructor));
        }

        /* renamed from: of */
        public static MethodType m70of(MethodDescription methodDescription) {
            return new MethodType(methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
        }

        public static MethodType ofSetter(Field field) {
            return ofSetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofSetter(FieldDescription fieldDescription) {
            return new MethodType(TypeDescription.VOID, Collections.singletonList(fieldDescription.getType().asErasure()));
        }

        public static MethodType ofGetter(Field field) {
            return ofGetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodType ofGetter(FieldDescription fieldDescription) {
            return new MethodType(fieldDescription.getType().asErasure(), Collections.emptyList());
        }

        public static MethodType ofConstant(Object instance) {
            return ofConstant(instance.getClass());
        }

        public static MethodType ofConstant(Class<?> type) {
            return ofConstant(TypeDescription.ForLoadedType.m247of(type));
        }

        public static MethodType ofConstant(TypeDescription typeDescription) {
            return new MethodType(typeDescription, Collections.emptyList());
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public String getDescriptor() {
            StringBuilder stringBuilder = new StringBuilder("(");
            for (TypeDescription parameterType : this.parameterTypes) {
                stringBuilder.append(parameterType.getDescriptor());
            }
            return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            Object[] parameterType = Simple.CLASS_DESC.toArray(this.parameterTypes.size());
            for (int index = 0; index < this.parameterTypes.size(); index++) {
                parameterType[index] = Simple.CLASS_DESC.ofDescriptor(((TypeDescription) this.parameterTypes.get(index)).getDescriptor());
            }
            return Simple.METHOD_TYPE_DESC.m65of(Simple.CLASS_DESC.ofDescriptor(this.returnType.getDescriptor()), parameterType);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodType(this);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_TYPE.getTypeStub();
        }

        public int hashCode() {
            return (31 * this.returnType.hashCode()) + this.parameterTypes.hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MethodType)) {
                return false;
            }
            MethodType methodType = (MethodType) other;
            return this.parameterTypes.equals(methodType.parameterTypes) && this.returnType.equals(methodType.returnType);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append('(');
            boolean first = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append(',');
                }
                stringBuilder.append(typeDescription.getSimpleName());
            }
            return stringBuilder.append(')').append(this.returnType.getSimpleName()).toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle.class */
    public static class MethodHandle implements JavaConstant {
        protected static final MethodHandleInfo METHOD_HANDLE_INFO = (MethodHandleInfo) AccessController.doPrivileged(JavaDispatcher.m62of(MethodHandleInfo.class));
        protected static final MethodType METHOD_TYPE = (MethodType) AccessController.doPrivileged(JavaDispatcher.m62of(MethodType.class));
        protected static final MethodHandles METHOD_HANDLES = (MethodHandles) AccessController.doPrivileged(JavaDispatcher.m62of(MethodHandles.class));
        protected static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = (MethodHandles.Lookup) AccessController.doPrivileged(JavaDispatcher.m62of(MethodHandles.Lookup.class));
        private final HandleType handleType;
        private final TypeDescription ownerType;
        private final String name;
        private final TypeDescription returnType;
        private final List<? extends TypeDescription> parameterTypes;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandleInfo")
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle$MethodHandleInfo.class */
        public interface MethodHandleInfo {
            String getName(Object obj);

            Class<?> getDeclaringClass(Object obj);

            int getReferenceKind(Object obj);

            Object getMethodType(Object obj);

            @JavaDispatcher.IsConstructor
            Object revealDirect(@JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj);
        }

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle$MethodHandles.class */
        public interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle$MethodHandles$Lookup.class */
            public interface Lookup {
                Class<?> lookupClass(Object obj);

                Object revealDirect(Object obj, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandle") Object obj2);
            }

            @JavaDispatcher.IsStatic
            Object publicLookup();
        }

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.invoke.MethodType")
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle$MethodType.class */
        public interface MethodType {
            Class<?> returnType(Object obj);

            Class<?>[] parameterArray(Object obj);
        }

        protected MethodHandle(HandleType handleType, TypeDescription ownerType, String name, TypeDescription returnType, List<? extends TypeDescription> parameterTypes) {
            this.handleType = handleType;
            this.ownerType = ownerType;
            this.name = name;
            this.returnType = returnType;
            this.parameterTypes = parameterTypes;
        }

        public static MethodHandle ofLoaded(Object methodHandle) {
            return ofLoaded(methodHandle, METHOD_HANDLES.publicLookup());
        }

        public static MethodHandle ofLoaded(Object methodHandle, Object lookup) {
            Object methodHandleInfo;
            if (!JavaType.METHOD_HANDLE.isInstance(methodHandle)) {
                throw new IllegalArgumentException("Expected method handle object: " + methodHandle);
            } else if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(lookup)) {
                throw new IllegalArgumentException("Expected method handle lookup object: " + lookup);
            } else {
                if (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V8).isAtMost(ClassFileVersion.JAVA_V7)) {
                    methodHandleInfo = METHOD_HANDLE_INFO.revealDirect(methodHandle);
                } else {
                    methodHandleInfo = METHOD_HANDLES_LOOKUP.revealDirect(lookup, methodHandle);
                }
                Object methodType = METHOD_HANDLE_INFO.getMethodType(methodHandleInfo);
                return new MethodHandle(HandleType.m75of(METHOD_HANDLE_INFO.getReferenceKind(methodHandleInfo)), TypeDescription.ForLoadedType.m247of(METHOD_HANDLE_INFO.getDeclaringClass(methodHandleInfo)), METHOD_HANDLE_INFO.getName(methodHandleInfo), TypeDescription.ForLoadedType.m247of(METHOD_TYPE.returnType(methodType)), new TypeList.ForLoadedTypes(METHOD_TYPE.parameterArray(methodType)));
            }
        }

        /* renamed from: of */
        public static MethodHandle m77of(Method method) {
            return m76of(new MethodDescription.ForLoadedMethod(method));
        }

        /* renamed from: of */
        public static MethodHandle m78of(Constructor<?> constructor) {
            return m76of(new MethodDescription.ForLoadedConstructor(constructor));
        }

        /* renamed from: of */
        public static MethodHandle m76of(MethodDescription.InDefinedShape methodDescription) {
            return new MethodHandle(HandleType.m74of(methodDescription), methodDescription.getDeclaringType().asErasure(), methodDescription.getInternalName(), methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
        }

        public static MethodHandle ofSpecial(Method method, Class<?> type) {
            return ofSpecial(new MethodDescription.ForLoadedMethod(method), TypeDescription.ForLoadedType.m247of(type));
        }

        public static MethodHandle ofSpecial(MethodDescription.InDefinedShape methodDescription, TypeDescription typeDescription) {
            if (methodDescription.isSpecializableFor(typeDescription)) {
                return new MethodHandle(HandleType.ofSpecial(methodDescription), typeDescription, methodDescription.getInternalName(), methodDescription.getReturnType().asErasure(), methodDescription.getParameters().asTypeList().asErasures());
            }
            throw new IllegalArgumentException("Cannot specialize " + methodDescription + " for " + typeDescription);
        }

        public static MethodHandle ofGetter(Field field) {
            return ofGetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofGetter(FieldDescription.InDefinedShape fieldDescription) {
            return new MethodHandle(HandleType.ofGetter(fieldDescription), fieldDescription.getDeclaringType().asErasure(), fieldDescription.getInternalName(), fieldDescription.getType().asErasure(), Collections.emptyList());
        }

        public static MethodHandle ofSetter(Field field) {
            return ofSetter(new FieldDescription.ForLoadedField(field));
        }

        public static MethodHandle ofSetter(FieldDescription.InDefinedShape fieldDescription) {
            return new MethodHandle(HandleType.ofSetter(fieldDescription), fieldDescription.getDeclaringType().asErasure(), fieldDescription.getInternalName(), TypeDescription.VOID, Collections.singletonList(fieldDescription.getType().asErasure()));
        }

        public static Class<?> lookupType(Object callerClassLookup) {
            return METHOD_HANDLES_LOOKUP.lookupClass(callerClassLookup);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            return Simple.METHOD_HANDLE_DESC.m66of(Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.handleType.getIdentifier(), this.ownerType.isInterface()), Simple.CLASS_DESC.ofDescriptor(this.ownerType.getDescriptor()), this.name, getDescriptor());
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onMethodHandle(this);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return JavaType.METHOD_HANDLE.getTypeStub();
        }

        public HandleType getHandleType() {
            return this.handleType;
        }

        public TypeDescription getOwnerType() {
            return this.ownerType;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        public TypeList getParameterTypes() {
            return new TypeList.Explicit(this.parameterTypes);
        }

        public String getDescriptor() {
            switch (this.handleType) {
                case GET_FIELD:
                case GET_STATIC_FIELD:
                    return this.returnType.getDescriptor();
                case PUT_FIELD:
                case PUT_STATIC_FIELD:
                    return ((TypeDescription) this.parameterTypes.get(0)).getDescriptor();
                default:
                    StringBuilder stringBuilder = new StringBuilder().append('(');
                    for (TypeDescription parameterType : this.parameterTypes) {
                        stringBuilder.append(parameterType.getDescriptor());
                    }
                    return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
            }
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * ((31 * this.handleType.hashCode()) + this.ownerType.hashCode())) + this.name.hashCode())) + this.returnType.hashCode())) + this.parameterTypes.hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MethodHandle)) {
                return false;
            }
            MethodHandle methodHandle = (MethodHandle) other;
            return this.handleType == methodHandle.handleType && this.name.equals(methodHandle.name) && this.ownerType.equals(methodHandle.ownerType) && this.parameterTypes.equals(methodHandle.parameterTypes) && this.returnType.equals(methodHandle.returnType);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append(this.handleType.name()).append((!this.ownerType.isInterface() || this.handleType.isField() || this.handleType == HandleType.INVOKE_INTERFACE) ? "" : "@interface").append('/').append(this.ownerType.getSimpleName()).append("::").append(this.name).append('(');
            boolean first = true;
            for (TypeDescription typeDescription : this.parameterTypes) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append(',');
                }
                stringBuilder.append(typeDescription.getSimpleName());
            }
            return stringBuilder.append(')').append(this.returnType.getSimpleName()).toString();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$MethodHandle$HandleType.class */
        public enum HandleType {
            INVOKE_VIRTUAL(5, false),
            INVOKE_STATIC(6, false),
            INVOKE_SPECIAL(7, false),
            INVOKE_INTERFACE(9, false),
            INVOKE_SPECIAL_CONSTRUCTOR(8, false),
            PUT_FIELD(3, true),
            GET_FIELD(1, true),
            PUT_STATIC_FIELD(4, true),
            GET_STATIC_FIELD(2, true);
            
            private final int identifier;
            private final boolean field;

            HandleType(int identifier, boolean field) {
                this.identifier = identifier;
                this.field = field;
            }

            /* renamed from: of */
            protected static HandleType m74of(MethodDescription.InDefinedShape methodDescription) {
                if (methodDescription.isTypeInitializer()) {
                    throw new IllegalArgumentException("Cannot create handle of type initializer " + methodDescription);
                } else if (methodDescription.isStatic()) {
                    return INVOKE_STATIC;
                } else {
                    if (methodDescription.isConstructor()) {
                        return INVOKE_SPECIAL_CONSTRUCTOR;
                    }
                    if (methodDescription.isPrivate()) {
                        return INVOKE_SPECIAL;
                    }
                    if (methodDescription.getDeclaringType().isInterface()) {
                        return INVOKE_INTERFACE;
                    }
                    return INVOKE_VIRTUAL;
                }
            }

            /* renamed from: of */
            protected static HandleType m75of(int identifier) {
                HandleType[] values = values();
                for (HandleType handleType : values) {
                    if (handleType.getIdentifier() == identifier) {
                        return handleType;
                    }
                }
                throw new IllegalArgumentException("Unknown handle type: " + identifier);
            }

            protected static HandleType ofSpecial(MethodDescription.InDefinedShape methodDescription) {
                if (!methodDescription.isStatic() && !methodDescription.isAbstract()) {
                    return methodDescription.isConstructor() ? INVOKE_SPECIAL_CONSTRUCTOR : INVOKE_SPECIAL;
                }
                throw new IllegalArgumentException("Cannot invoke " + methodDescription + " via invokespecial");
            }

            protected static HandleType ofGetter(FieldDescription.InDefinedShape fieldDescription) {
                return fieldDescription.isStatic() ? GET_STATIC_FIELD : GET_FIELD;
            }

            protected static HandleType ofSetter(FieldDescription.InDefinedShape fieldDescription) {
                return fieldDescription.isStatic() ? PUT_STATIC_FIELD : PUT_FIELD;
            }

            public int getIdentifier() {
                return this.identifier;
            }

            public boolean isField() {
                return this.field;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/utility/JavaConstant$Dynamic.class */
    public static class Dynamic implements JavaConstant {
        public static final String DEFAULT_NAME = "_";
        private final String name;
        private final TypeDescription typeDescription;
        private final MethodHandle bootstrap;
        private final List<JavaConstant> arguments;

        protected Dynamic(String name, TypeDescription typeDescription, MethodHandle bootstrap, List<JavaConstant> arguments) {
            this.name = name;
            this.typeDescription = typeDescription;
            this.bootstrap = bootstrap;
            this.arguments = arguments;
        }

        public static Dynamic ofNullConstant() {
            return new Dynamic(DEFAULT_NAME, TypeDescription.OBJECT, new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "nullConstant", TypeDescription.OBJECT, Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS)), Collections.emptyList());
        }

        public static JavaConstant ofPrimitiveType(Class<?> type) {
            return ofPrimitiveType(TypeDescription.ForLoadedType.m247of(type));
        }

        public static JavaConstant ofPrimitiveType(TypeDescription typeDescription) {
            if (typeDescription.isPrimitive()) {
                return new Dynamic(typeDescription.getDescriptor(), TypeDescription.CLASS, new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "primitiveClass", TypeDescription.CLASS, Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS)), Collections.emptyList());
            }
            throw new IllegalArgumentException("Not a primitive type: " + typeDescription);
        }

        public static JavaConstant ofEnumeration(Enum<?> enumeration) {
            return ofEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumeration));
        }

        public static JavaConstant ofEnumeration(EnumerationDescription enumerationDescription) {
            return new Dynamic(enumerationDescription.getValue(), enumerationDescription.getEnumerationType(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "enumConstant", TypeDescription.ForLoadedType.m247of(Enum.class), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS)), Collections.emptyList());
        }

        public static Dynamic ofField(Field field) {
            return ofField(new FieldDescription.ForLoadedField(field));
        }

        public static Dynamic ofField(FieldDescription.InDefinedShape fieldDescription) {
            boolean selfDeclared;
            List list;
            if (!fieldDescription.isStatic() || !fieldDescription.isFinal()) {
                throw new IllegalArgumentException("Field must be static and final: " + fieldDescription);
            }
            if (fieldDescription.getType().isPrimitive()) {
                selfDeclared = fieldDescription.getType().asErasure().asBoxed().equals(fieldDescription.getType().asErasure());
            } else {
                selfDeclared = fieldDescription.getDeclaringType().equals(fieldDescription.getType().asErasure());
            }
            String internalName = fieldDescription.getInternalName();
            TypeDescription asErasure = fieldDescription.getType().asErasure();
            MethodHandle methodHandle = new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "getStaticFinal", TypeDescription.OBJECT, selfDeclared ? Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS) : Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS, TypeDescription.CLASS));
            if (selfDeclared) {
                list = Collections.emptyList();
            } else {
                list = Collections.singletonList(Simple.m67of(fieldDescription.getDeclaringType()));
            }
            return new Dynamic(internalName, asErasure, methodHandle, list);
        }

        public static Dynamic ofInvocation(Method method, Object... constant) {
            return ofInvocation(method, Arrays.asList(constant));
        }

        public static Dynamic ofInvocation(Method method, List<?> constants) {
            return ofInvocation(new MethodDescription.ForLoadedMethod(method), constants);
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, Object... constant) {
            return ofInvocation(constructor, Arrays.asList(constant));
        }

        public static Dynamic ofInvocation(Constructor<?> constructor, List<?> constants) {
            return ofInvocation(new MethodDescription.ForLoadedConstructor(constructor), constants);
        }

        public static Dynamic ofInvocation(MethodDescription.InDefinedShape methodDescription, Object... constant) {
            return ofInvocation(methodDescription, Arrays.asList(constant));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:17:0x006a, code lost:
            if ((r15.getParameters().size() + ((r15.isStatic() || r15.isConstructor()) ? 0 : 1)) > (r16.size() + 1)) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
            if ((r15.getParameters().size() + ((r15.isStatic() || r15.isConstructor()) ? 0 : 1)) != r16.size()) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c1, code lost:
            throw new java.lang.IllegalArgumentException("Cannot assign " + r16 + " to " + r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c8, code lost:
            if (r15.isStatic() != false) goto L_0x00d4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d1, code lost:
            if (r15.isConstructor() == false) goto L_0x00e7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00d4, code lost:
            r0 = r15.getParameters().asTypeList().asErasures();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e7, code lost:
            r0 = net.bytebuddy.utility.CompoundList.m82of(r15.getDeclaringType(), r15.getParameters().asTypeList().asErasures());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0107, code lost:
            if (r15.isVarArgs() == false) goto L_0x014d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x010a, code lost:
            r18 = net.bytebuddy.utility.CompoundList.m80of((java.util.List) r0.subList(0, r0.size() - 1), java.util.Collections.nCopies((r16.size() - r0.size()) + 1, r0.get(r0.size() - 1).getComponentType())).iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x014d, code lost:
            r18 = r0.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x0154, code lost:
            r0 = new java.util.ArrayList<>(r16.size() + 1);
            r0.add(net.bytebuddy.utility.JavaConstant.MethodHandle.m76of(r15));
            r0 = r16.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x0180, code lost:
            if (r0.hasNext() == false) goto L_0x01de;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0183, code lost:
            r0 = net.bytebuddy.utility.JavaConstant.Simple.wrap(r0.next());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x01a8, code lost:
            if (r0.getTypeDescription().isAssignableTo(r18.next()) != false) goto L_0x01d1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x01d0, code lost:
            throw new java.lang.IllegalArgumentException("Cannot assign " + r16 + " to " + r15);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x01d1, code lost:
            r0.add(r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x01ea, code lost:
            if (r15.isConstructor() == false) goto L_0x01f6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:48:0x01ed, code lost:
            r3 = r15.getDeclaringType();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:49:0x01f6, code lost:
            r3 = r15.getReturnType().asErasure();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x024a, code lost:
            return new net.bytebuddy.utility.JavaConstant.Dynamic(net.bytebuddy.utility.JavaConstant.Dynamic.DEFAULT_NAME, r3, new net.bytebuddy.utility.JavaConstant.MethodHandle(net.bytebuddy.utility.JavaConstant.MethodHandle.HandleType.INVOKE_STATIC, net.bytebuddy.utility.JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "invoke", net.bytebuddy.description.type.TypeDescription.OBJECT, java.util.Arrays.asList(net.bytebuddy.utility.JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), net.bytebuddy.description.type.TypeDescription.STRING, net.bytebuddy.description.type.TypeDescription.CLASS, net.bytebuddy.utility.JavaType.METHOD_HANDLE.getTypeStub(), net.bytebuddy.description.type.TypeDescription.ArrayProjection.m249of(net.bytebuddy.description.type.TypeDescription.OBJECT))), r0);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static net.bytebuddy.utility.JavaConstant.Dynamic ofInvocation(net.bytebuddy.description.method.MethodDescription.InDefinedShape r15, java.util.List<?> r16) {
            /*
            // Method dump skipped, instructions count: 587
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.utility.JavaConstant.Dynamic.ofInvocation(net.bytebuddy.description.method.MethodDescription$InDefinedShape, java.util.List):net.bytebuddy.utility.JavaConstant$Dynamic");
        }

        public static JavaConstant ofVarHandle(Field field) {
            return ofVarHandle(new FieldDescription.ForLoadedField(field));
        }

        public static JavaConstant ofVarHandle(FieldDescription.InDefinedShape fieldDescription) {
            return new Dynamic(fieldDescription.getInternalName(), JavaType.VAR_HANDLE.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), fieldDescription.isStatic() ? "staticFieldVarHandle" : "fieldVarHandle", JavaType.VAR_HANDLE.getTypeStub(), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS, TypeDescription.CLASS, TypeDescription.CLASS)), Arrays.asList(Simple.m67of(fieldDescription.getDeclaringType()), Simple.m67of(fieldDescription.getType().asErasure())));
        }

        public static JavaConstant ofArrayVarHandle(Class<?> type) {
            return ofArrayVarHandle(TypeDescription.ForLoadedType.m247of(type));
        }

        public static JavaConstant ofArrayVarHandle(TypeDescription typeDescription) {
            if (typeDescription.isArray()) {
                return new Dynamic(DEFAULT_NAME, JavaType.VAR_HANDLE.getTypeStub(), new MethodHandle(MethodHandle.HandleType.INVOKE_STATIC, JavaType.CONSTANT_BOOTSTRAPS.getTypeStub(), "arrayVarHandle", JavaType.VAR_HANDLE.getTypeStub(), Arrays.asList(JavaType.METHOD_HANDLES_LOOKUP.getTypeStub(), TypeDescription.STRING, TypeDescription.CLASS, TypeDescription.CLASS)), Collections.singletonList(Simple.m67of(typeDescription)));
            }
            throw new IllegalArgumentException("Not an array type: " + typeDescription);
        }

        public static Dynamic bootstrap(String name, Method method, Object... constant) {
            return bootstrap(name, method, Arrays.asList(constant));
        }

        public static Dynamic bootstrap(String name, Method method, List<?> constants) {
            return bootstrap(name, new MethodDescription.ForLoadedMethod(method), constants);
        }

        public static Dynamic bootstrap(String name, Constructor<?> constructor, Object... constant) {
            return bootstrap(name, constructor, Arrays.asList(constant));
        }

        public static Dynamic bootstrap(String name, Constructor<?> constructor, List<?> constants) {
            return bootstrap(name, new MethodDescription.ForLoadedConstructor(constructor), constants);
        }

        public static Dynamic bootstrap(String name, MethodDescription.InDefinedShape bootstrapMethod, Object... constant) {
            return bootstrap(name, bootstrapMethod, Arrays.asList(constant));
        }

        public static Dynamic bootstrap(String name, MethodDescription.InDefinedShape bootstrap, List<?> constants) {
            TypeDescription typeDescription;
            TypeDescription typeDescription2;
            if (name.length() == 0 || name.contains(Mapper.IGNORED_FIELDNAME)) {
                throw new IllegalArgumentException("Not a valid field name: " + name);
            }
            List<JavaConstant> arguments = new ArrayList<>(constants.size());
            List<TypeDescription> types = new ArrayList<>(constants.size());
            Iterator<?> it = constants.iterator();
            while (it.hasNext()) {
                JavaConstant argument = Simple.wrap(it.next());
                arguments.add(argument);
                types.add(argument.getTypeDescription());
            }
            if (!bootstrap.isConstantBootstrap(types)) {
                throw new IllegalArgumentException("Not a valid bootstrap method " + bootstrap + " for " + arguments);
            }
            if (bootstrap.isConstructor()) {
                typeDescription = bootstrap.getDeclaringType();
            } else {
                typeDescription = bootstrap.getReturnType().asErasure();
            }
            MethodHandle.HandleType handleType = bootstrap.isConstructor() ? MethodHandle.HandleType.INVOKE_SPECIAL_CONSTRUCTOR : MethodHandle.HandleType.INVOKE_STATIC;
            if (bootstrap.isConstructor()) {
                typeDescription2 = bootstrap.getDeclaringType();
            } else {
                typeDescription2 = bootstrap.getReturnType().asErasure();
            }
            return new Dynamic(name, typeDescription, new MethodHandle(handleType, typeDescription2, bootstrap.getInternalName(), bootstrap.getReturnType().asErasure(), bootstrap.getParameters().asTypeList().asErasures()), arguments);
        }

        public String getName() {
            return this.name;
        }

        public MethodHandle getBootstrap() {
            return this.bootstrap;
        }

        public List<JavaConstant> getArguments() {
            return this.arguments;
        }

        public JavaConstant withType(Class<?> type) {
            return withType(TypeDescription.ForLoadedType.m247of(type));
        }

        public JavaConstant withType(TypeDescription typeDescription) {
            if (typeDescription.represents(Void.TYPE)) {
                throw new IllegalArgumentException("Constant value cannot represent void");
            } else if (!getBootstrap().getName().equals("<init>") ? typeDescription.asBoxed().isInHierarchyWith(getTypeDescription().asBoxed()) : getTypeDescription().isAssignableTo(typeDescription)) {
                return new Dynamic(getName(), typeDescription, getBootstrap(), getArguments());
            } else {
                throw new IllegalArgumentException(typeDescription + " is not compatible with bootstrapped type " + getTypeDescription());
            }
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public Object toDescription() {
            Object[] argument = Simple.CONSTANT_DESC.toArray(this.arguments.size());
            for (int index = 0; index < argument.length; index++) {
                argument[index] = this.arguments.get(index).toDescription();
            }
            return Simple.DYNAMIC_CONSTANT_DESC.ofCanonical(Simple.METHOD_HANDLE_DESC.m66of(Simple.DIRECT_METHOD_HANDLE_DESC_KIND.valueOf(this.bootstrap.getHandleType().getIdentifier(), this.bootstrap.getOwnerType().isInterface()), Simple.CLASS_DESC.ofDescriptor(this.bootstrap.getOwnerType().getDescriptor()), this.bootstrap.getName(), this.bootstrap.getDescriptor()), getName(), Simple.CLASS_DESC.ofDescriptor(this.typeDescription.getDescriptor()), argument);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public <T> T accept(Visitor<T> visitor) {
            return visitor.onDynamic(this);
        }

        @Override // net.bytebuddy.utility.JavaConstant
        public TypeDescription getTypeDescription() {
            return this.typeDescription;
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * this.name.hashCode()) + this.typeDescription.hashCode())) + this.bootstrap.hashCode())) + this.arguments.hashCode();
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            Dynamic dynamic = (Dynamic) object;
            if (this.name.equals(dynamic.name) && this.typeDescription.equals(dynamic.typeDescription) && this.bootstrap.equals(dynamic.bootstrap)) {
                return this.arguments.equals(dynamic.arguments);
            }
            return false;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append(this.bootstrap.getOwnerType().getSimpleName()).append("::").append(this.bootstrap.getName()).append('(').append(this.name.equals(DEFAULT_NAME) ? "" : this.name).append('/');
            boolean first = true;
            for (JavaConstant constant : this.arguments) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append(',');
                }
                stringBuilder.append(constant.toString());
            }
            return stringBuilder.append(')').append(this.typeDescription.getSimpleName()).toString();
        }
    }
}
