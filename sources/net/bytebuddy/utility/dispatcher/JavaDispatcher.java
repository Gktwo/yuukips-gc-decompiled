package net.bytebuddy.utility.dispatcher;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import org.jline.console.Printer;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher.class */
public class JavaDispatcher<T> implements PrivilegedAction<T> {
    public static final String GENERATE_PROPERTY = "net.bytebuddy.generate";
    private static final boolean GENERATE = Boolean.parseBoolean((String) AccessController.doPrivileged(new GetSystemPropertyAction(GENERATE_PROPERTY)));
    private static final Invoker INVOKER = (Invoker) AccessController.doPrivileged(Invoker.CreationAction.INSTANCE);
    private final Class<T> proxy;
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
    private final ClassLoader classLoader;
    private final boolean generate;

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Container.class */
    public @interface Container {
    }

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Defaults.class */
    public @interface Defaults {
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Instance.class */
    public @interface Instance {
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$IsConstructor.class */
    public @interface IsConstructor {
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$IsStatic.class */
    public @interface IsStatic {
    }

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Proxied.class */
    public @interface Proxied {
        String value();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || this.generate != ((JavaDispatcher) obj).generate || !this.proxy.equals(((JavaDispatcher) obj).proxy)) {
            return false;
        }
        ClassLoader classLoader = this.classLoader;
        ClassLoader classLoader2 = ((JavaDispatcher) obj).classLoader;
        return classLoader2 != null ? classLoader != null && classLoader.equals(classLoader2) : classLoader == null;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int hashCode = ((getClass().hashCode() * 31) + this.proxy.hashCode()) * 31;
        ClassLoader classLoader = this.classLoader;
        if (classLoader != null) {
            hashCode += classLoader.hashCode();
        }
        return (hashCode * 31) + (this.generate ? 1 : 0);
    }

    protected JavaDispatcher(Class<T> proxy, ClassLoader classLoader, boolean generate) {
        this.proxy = proxy;
        this.classLoader = classLoader;
        this.generate = generate;
    }

    /* renamed from: of */
    public static <T> PrivilegedAction<T> m62of(Class<T> type) {
        return m61of(type, null);
    }

    /* renamed from: of */
    protected static <T> PrivilegedAction<T> m61of(Class<T> type, ClassLoader classLoader) {
        return m60of(type, classLoader, GENERATE);
    }

    /* renamed from: of */
    protected static <T> PrivilegedAction<T> m60of(Class<T> type, ClassLoader classLoader, boolean generate) {
        if (!type.isInterface()) {
            throw new IllegalArgumentException("Expected an interface instead of " + type);
        } else if (!type.isAnnotationPresent(Proxied.class)) {
            throw new IllegalArgumentException("Expected " + type.getName() + " to be annotated with " + Proxied.class.getName());
        } else if (!((Proxied) type.getAnnotation(Proxied.class)).value().startsWith("java.security.")) {
            return new JavaDispatcher(type, classLoader, generate);
        } else {
            throw new IllegalArgumentException("Classes related to Java security cannot be proxied: " + type.getName());
        }
    }

    @Override // java.security.PrivilegedAction
    public T run() {
        Dispatcher dispatcher;
        Dispatcher dispatcher2;
        Dispatcher dispatcher3;
        int offset;
        Map<Method, Dispatcher> dispatchers = new HashMap<>();
        boolean defaults = this.proxy.isAnnotationPresent(Defaults.class);
        String name = ((Proxied) this.proxy.getAnnotation(Proxied.class)).value();
        try {
            Class<?> target = Class.forName(name, false, this.classLoader);
            boolean generate = this.generate;
            Method[] methods = this.proxy.getMethods();
            for (Method method : methods) {
                if (method.getDeclaringClass() != Object.class) {
                    if (method.isAnnotationPresent(Instance.class)) {
                        if (method.getParameterTypes().length != 1 || !method.getParameterTypes()[0].isAssignableFrom(target)) {
                            throw new IllegalStateException("Instance check requires a single regular-typed argument: " + method);
                        } else if (method.getReturnType() != Boolean.TYPE) {
                            throw new IllegalStateException("Instance check requires a boolean return type: " + method);
                        } else {
                            dispatchers.put(method, new Dispatcher.ForInstanceCheck(target));
                        }
                    } else if (method.isAnnotationPresent(Container.class)) {
                        if (method.getParameterTypes().length != 1 || method.getParameterTypes()[0] != Integer.TYPE) {
                            throw new IllegalStateException("Container creation requires a single int-typed argument: " + method);
                        } else if (!method.getReturnType().isArray() || !method.getReturnType().getComponentType().isAssignableFrom(target)) {
                            throw new IllegalStateException("Container creation requires an assignable array as return value: " + method);
                        } else {
                            dispatchers.put(method, new Dispatcher.ForContainerCreation(target));
                        }
                    } else if (!target.getName().equals("java.lang.invoke.MethodHandles") || !method.getName().equals("lookup")) {
                        try {
                            Class<?>[] parameterType = method.getParameterTypes();
                            if (method.isAnnotationPresent(IsStatic.class) || method.isAnnotationPresent(IsConstructor.class)) {
                                offset = 0;
                            } else {
                                offset = 1;
                                if (parameterType.length == 0) {
                                    throw new IllegalStateException("Expected self type: " + method);
                                } else if (!parameterType[0].isAssignableFrom(target)) {
                                    throw new IllegalStateException("Cannot assign self type: " + target + " on " + method);
                                } else {
                                    Class<?>[] adjusted = new Class[parameterType.length - 1];
                                    System.arraycopy(parameterType, 1, adjusted, 0, adjusted.length);
                                    parameterType = adjusted;
                                }
                            }
                            Annotation[][] parameterAnnotation = method.getParameterAnnotations();
                            for (int index = 0; index < parameterType.length; index++) {
                                Annotation[] annotationArr = parameterAnnotation[index + offset];
                                int length = annotationArr.length;
                                int i = 0;
                                while (true) {
                                    if (i < length) {
                                        Annotation annotation = annotationArr[i];
                                        if (annotation instanceof Proxied) {
                                            int arity = 0;
                                            while (parameterType[index].isArray()) {
                                                arity++;
                                                parameterType[index] = parameterType[index].getComponentType();
                                            }
                                            if (arity <= 0) {
                                                Class<?> resolved = Class.forName(((Proxied) annotation).value(), false, this.classLoader);
                                                if (!parameterType[index].isAssignableFrom(resolved)) {
                                                    throw new IllegalStateException("Cannot resolve to type: " + resolved.getName() + " at " + index + " of " + method);
                                                }
                                                parameterType[index] = resolved;
                                            } else if (parameterType[index].isPrimitive()) {
                                                throw new IllegalStateException("Primitive values are not supposed to be proxied: " + index + " of " + method);
                                            } else if (!parameterType[index].isAssignableFrom(Class.forName(((Proxied) annotation).value(), false, this.classLoader))) {
                                                throw new IllegalStateException("Cannot resolve to component type: " + ((Proxied) annotation).value() + " at " + index + " of " + method);
                                            } else {
                                                StringBuilder stringBuilder = new StringBuilder();
                                                while (true) {
                                                    arity--;
                                                    if (arity <= 0) {
                                                        break;
                                                    }
                                                    stringBuilder.append('[');
                                                }
                                                parameterType[index] = Class.forName(stringBuilder.append('L').append(((Proxied) annotation).value()).append(';').toString(), false, this.classLoader);
                                            }
                                        } else {
                                            i++;
                                        }
                                    }
                                }
                            }
                            if (method.isAnnotationPresent(IsConstructor.class)) {
                                Constructor<?> resolved2 = target.getConstructor(parameterType);
                                if (!method.getReturnType().isAssignableFrom(target)) {
                                    throw new IllegalStateException("Cannot assign " + resolved2.getDeclaringClass().getName() + " to " + method);
                                }
                                if ((resolved2.getModifiers() & 1) == 0 || (target.getModifiers() & 1) == 0) {
                                    resolved2.setAccessible(true);
                                    generate = false;
                                }
                                dispatchers.put(method, new Dispatcher.ForConstructor(resolved2));
                            } else {
                                Proxied proxied = (Proxied) method.getAnnotation(Proxied.class);
                                Method resolved3 = target.getMethod(proxied == null ? method.getName() : proxied.value(), parameterType);
                                if (!method.getReturnType().isAssignableFrom(resolved3.getReturnType())) {
                                    throw new IllegalStateException("Cannot assign " + resolved3.getReturnType().getName() + " to " + method);
                                }
                                Class<?>[] exceptionTypes = resolved3.getExceptionTypes();
                                for (Class<?> type : exceptionTypes) {
                                    if (!RuntimeException.class.isAssignableFrom(type) && !Error.class.isAssignableFrom(type)) {
                                        for (Class<?> exception : method.getExceptionTypes()) {
                                            if (exception.isAssignableFrom(type)) {
                                                break;
                                            }
                                        }
                                        throw new IllegalStateException("Resolved method for " + method + " throws undeclared checked exception " + type.getName());
                                    }
                                }
                                if ((resolved3.getModifiers() & 1) == 0 || (resolved3.getDeclaringClass().getModifiers() & 1) == 0) {
                                    resolved3.setAccessible(true);
                                    generate = false;
                                }
                                if (Modifier.isStatic(resolved3.getModifiers())) {
                                    if (!method.isAnnotationPresent(IsStatic.class)) {
                                        throw new IllegalStateException("Resolved method for " + method + " was expected to be static: " + resolved3);
                                    }
                                    dispatchers.put(method, new Dispatcher.ForStaticMethod(resolved3));
                                } else if (method.isAnnotationPresent(IsStatic.class)) {
                                    throw new IllegalStateException("Resolved method for " + method + " was expected to be virtual: " + resolved3);
                                } else {
                                    dispatchers.put(method, new Dispatcher.ForNonStaticMethod(resolved3));
                                }
                            }
                        } catch (ClassNotFoundException exception2) {
                            if (defaults || method.isAnnotationPresent(Defaults.class)) {
                                dispatcher3 = Dispatcher.ForDefaultValue.m59of(method.getReturnType());
                            } else {
                                dispatcher3 = new Dispatcher.ForUnresolvedMethod("Class not available on current VM: " + exception2.getMessage());
                            }
                            dispatchers.put(method, dispatcher3);
                        } catch (NoSuchMethodException exception3) {
                            if (defaults || method.isAnnotationPresent(Defaults.class)) {
                                dispatcher2 = Dispatcher.ForDefaultValue.m59of(method.getReturnType());
                            } else {
                                dispatcher2 = new Dispatcher.ForUnresolvedMethod("Method not available on current VM: " + exception3.getMessage());
                            }
                            dispatchers.put(method, dispatcher2);
                        } catch (Throwable throwable) {
                            dispatchers.put(method, new Dispatcher.ForUnresolvedMethod("Unexpected error: " + throwable.getMessage()));
                        }
                    } else {
                        throw new UnsupportedOperationException("Cannot resolve Byte Buddy lookup via dispatcher");
                    }
                }
            }
            if (generate) {
                return (T) DynamicClassLoader.proxy(this.proxy, dispatchers);
            }
            return (T) Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[]{this.proxy}, new ProxiedInvocationHandler(target.getName(), dispatchers));
        } catch (ClassNotFoundException exception4) {
            Method[] methods2 = this.proxy.getMethods();
            for (Method method2 : methods2) {
                if (method2.getDeclaringClass() != Object.class) {
                    if (!method2.isAnnotationPresent(Instance.class)) {
                        if (defaults || method2.isAnnotationPresent(Defaults.class)) {
                            dispatcher = Dispatcher.ForDefaultValue.m59of(method2.getReturnType());
                        } else {
                            dispatcher = new Dispatcher.ForUnresolvedMethod("Type not available on current VM: " + exception4.getMessage());
                        }
                        dispatchers.put(method2, dispatcher);
                    } else if (method2.getParameterTypes().length != 1 || method2.getParameterTypes()[0].isPrimitive() || method2.getParameterTypes()[0].isArray()) {
                        throw new IllegalStateException("Instance check requires a single regular-typed argument: " + method2);
                    } else if (method2.getReturnType() != Boolean.TYPE) {
                        throw new IllegalStateException("Instance check requires a boolean return type: " + method2);
                    } else {
                        dispatchers.put(method2, Dispatcher.ForDefaultValue.BOOLEAN);
                    }
                }
            }
            return this.generate ? (T) DynamicClassLoader.proxy(this.proxy, dispatchers) : (T) Proxy.newProxyInstance(this.proxy.getClassLoader(), new Class[]{this.proxy}, new ProxiedInvocationHandler(name, dispatchers));
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Invoker.class */
    public interface Invoker {
        Object newInstance(Constructor<?> constructor, Object[] objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException;

        Object invoke(Method method, Object obj, Object[] objArr) throws IllegalAccessException, InvocationTargetException;

        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Invoker$CreationAction.class */
        public enum CreationAction implements PrivilegedAction<Invoker> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            public Invoker run() {
                return DynamicClassLoader.invoker();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher.class */
    public interface Dispatcher {
        Object invoke(Object[] objArr) throws Throwable;

        int apply(MethodVisitor methodVisitor, Method method);

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForInstanceCheck.class */
        public static class ForInstanceCheck implements Dispatcher {
            private final Class<?> target;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForInstanceCheck) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            protected ForInstanceCheck(Class<?> target) {
                this.target = target;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) {
                return Boolean.valueOf(this.target.isInstance(argument[0]));
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(25, 1);
                methodVisitor.visitTypeInsn(193, Type.getInternalName(this.target));
                methodVisitor.visitInsn(172);
                return 1;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForContainerCreation.class */
        public static class ForContainerCreation implements Dispatcher {
            private final Class<?> target;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.target.equals(((ForContainerCreation) obj).target);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.target.hashCode();
            }

            protected ForContainerCreation(Class<?> target) {
                this.target = target;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) {
                return Array.newInstance(this.target, ((Integer) argument[0]).intValue());
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitVarInsn(21, 1);
                methodVisitor.visitTypeInsn(189, Type.getInternalName(this.target));
                methodVisitor.visitInsn(176);
                return 1;
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForDefaultValue.class */
        public enum ForDefaultValue implements Dispatcher {
            VOID(null, 0, 177, 0),
            BOOLEAN(false, 3, 172, 1),
            BYTE((byte) 0, 3, 172, 1),
            SHORT((short) 0, 3, 172, 1),
            CHARACTER((char) 0, 3, 172, 1),
            INTEGER(0, 3, 172, 1),
            LONG(0L, 9, 173, 2),
            FLOAT(Float.valueOf(0.0f), 11, 174, 1),
            DOUBLE(Double.valueOf(0.0d), 14, 175, 2),
            REFERENCE(null, 1, 176, 1);
            
            private final Object value;
            private final int load;
            private final int returned;
            private final int size;

            ForDefaultValue(Object value, int load, int returned, int size) {
                this.value = value;
                this.load = load;
                this.returned = returned;
                this.size = size;
            }

            /* renamed from: of */
            protected static Dispatcher m59of(Class<?> type) {
                if (type == Void.TYPE) {
                    return VOID;
                }
                if (type == Boolean.TYPE) {
                    return BOOLEAN;
                }
                if (type == Byte.TYPE) {
                    return BYTE;
                }
                if (type == Short.TYPE) {
                    return SHORT;
                }
                if (type == Character.TYPE) {
                    return CHARACTER;
                }
                if (type == Integer.TYPE) {
                    return INTEGER;
                }
                if (type == Long.TYPE) {
                    return LONG;
                }
                if (type == Float.TYPE) {
                    return FLOAT;
                }
                if (type == Double.TYPE) {
                    return DOUBLE;
                }
                if (!type.isArray()) {
                    return REFERENCE;
                }
                if (type.getComponentType() == Boolean.TYPE) {
                    return OfPrimitiveArray.BOOLEAN;
                }
                if (type.getComponentType() == Byte.TYPE) {
                    return OfPrimitiveArray.BYTE;
                }
                if (type.getComponentType() == Short.TYPE) {
                    return OfPrimitiveArray.SHORT;
                }
                if (type.getComponentType() == Character.TYPE) {
                    return OfPrimitiveArray.CHARACTER;
                }
                if (type.getComponentType() == Integer.TYPE) {
                    return OfPrimitiveArray.INTEGER;
                }
                if (type.getComponentType() == Long.TYPE) {
                    return OfPrimitiveArray.LONG;
                }
                if (type.getComponentType() == Float.TYPE) {
                    return OfPrimitiveArray.FLOAT;
                }
                if (type.getComponentType() == Double.TYPE) {
                    return OfPrimitiveArray.DOUBLE;
                }
                return OfNonPrimitiveArray.m58of(type.getComponentType());
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) {
                return this.value;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                if (this.load != 0) {
                    methodVisitor.visitInsn(this.load);
                }
                methodVisitor.visitInsn(this.returned);
                return this.size;
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForDefaultValue$OfPrimitiveArray.class */
            public enum OfPrimitiveArray implements Dispatcher {
                BOOLEAN(new boolean[0], 4),
                BYTE(new byte[0], 8),
                SHORT(new short[0], 9),
                CHARACTER(new char[0], 5),
                INTEGER(new int[0], 10),
                LONG(new long[0], 11),
                FLOAT(new float[0], 6),
                DOUBLE(new double[0], 7);
                
                private final Object value;
                private final int operand;

                OfPrimitiveArray(Object value, int operand) {
                    this.value = value;
                    this.operand = operand;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] argument) {
                    return this.value;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitIntInsn(188, this.operand);
                    methodVisitor.visitInsn(176);
                    return 1;
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForDefaultValue$OfNonPrimitiveArray.class */
            public static class OfNonPrimitiveArray implements Dispatcher {
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
                private final Object value;
                private final Class<?> componentType;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfNonPrimitiveArray) obj).componentType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.componentType.hashCode();
                }

                protected OfNonPrimitiveArray(Object value, Class<?> componentType) {
                    this.value = value;
                    this.componentType = componentType;
                }

                /* renamed from: of */
                protected static Dispatcher m58of(Class<?> componentType) {
                    return new OfNonPrimitiveArray(Array.newInstance(componentType, 0), componentType);
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public Object invoke(Object[] argument) {
                    return this.value;
                }

                @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
                public int apply(MethodVisitor methodVisitor, Method method) {
                    methodVisitor.visitInsn(3);
                    methodVisitor.visitTypeInsn(189, Type.getInternalName(this.componentType));
                    methodVisitor.visitInsn(176);
                    return 1;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForConstructor.class */
        public static class ForConstructor implements Dispatcher {
            private final Constructor<?> constructor;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForConstructor) obj).constructor);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.constructor.hashCode();
            }

            protected ForConstructor(Constructor<?> constructor) {
                this.constructor = constructor;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) throws Throwable {
                return JavaDispatcher.INVOKER.newInstance(this.constructor, argument);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] source = method.getParameterTypes();
                Class<?>[] target = this.constructor.getParameterTypes();
                methodVisitor.visitTypeInsn(187, Type.getInternalName(this.constructor.getDeclaringClass()));
                methodVisitor.visitInsn(89);
                int offset = 1;
                for (int index = 0; index < source.length; index++) {
                    Type type = Type.getType(source[index]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), offset);
                    if (source[index] != target[index]) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(target[index]));
                    }
                    offset += type.getSize();
                }
                methodVisitor.visitMethodInsn(183, Type.getInternalName(this.constructor.getDeclaringClass()), "<init>", Type.getConstructorDescriptor(this.constructor), false);
                methodVisitor.visitInsn(176);
                return offset + 1;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForStaticMethod.class */
        public static class ForStaticMethod implements Dispatcher {
            private final Method method;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            protected ForStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) throws Throwable {
                return JavaDispatcher.INVOKER.invoke(this.method, null, argument);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] source = method.getParameterTypes();
                Class<?>[] target = this.method.getParameterTypes();
                int offset = 1;
                for (int index = 0; index < source.length; index++) {
                    Type type = Type.getType(source[index]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), offset);
                    if (source[index] != target[index]) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(target[index]));
                    }
                    offset += type.getSize();
                }
                methodVisitor.visitMethodInsn(184, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(offset - 1, Type.getReturnType(this.method).getSize());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForNonStaticMethod.class */
        public static class ForNonStaticMethod implements Dispatcher {
            private static final Object[] NO_ARGUMENTS = new Object[0];
            private final Method method;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.method.equals(((ForNonStaticMethod) obj).method);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.method.hashCode();
            }

            protected ForNonStaticMethod(Method method) {
                this.method = method;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) throws Throwable {
                Object[] reduced;
                if (argument.length == 1) {
                    reduced = NO_ARGUMENTS;
                } else {
                    reduced = new Object[argument.length - 1];
                    System.arraycopy(argument, 1, reduced, 0, reduced.length);
                }
                return JavaDispatcher.INVOKER.invoke(this.method, argument[0], reduced);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                Class<?>[] source = method.getParameterTypes();
                Class<?>[] target = this.method.getParameterTypes();
                int offset = 1;
                int index = 0;
                while (index < source.length) {
                    Type type = Type.getType(source[index]);
                    methodVisitor.visitVarInsn(type.getOpcode(21), offset);
                    if (source[index] != (index == 0 ? this.method.getDeclaringClass() : target[index - 1])) {
                        methodVisitor.visitTypeInsn(192, Type.getInternalName(index == 0 ? this.method.getDeclaringClass() : target[index - 1]));
                    }
                    offset += type.getSize();
                    index++;
                }
                methodVisitor.visitMethodInsn(this.method.getDeclaringClass().isInterface() ? 185 : 182, Type.getInternalName(this.method.getDeclaringClass()), this.method.getName(), Type.getMethodDescriptor(this.method), this.method.getDeclaringClass().isInterface());
                methodVisitor.visitInsn(Type.getReturnType(this.method).getOpcode(172));
                return Math.max(offset - 1, Type.getReturnType(this.method).getSize());
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$Dispatcher$ForUnresolvedMethod.class */
        public static class ForUnresolvedMethod implements Dispatcher {
            private final String message;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((ForUnresolvedMethod) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            protected ForUnresolvedMethod(String message) {
                this.message = message;
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public Object invoke(Object[] argument) throws Throwable {
                throw new IllegalStateException("Could not invoke proxy: " + this.message);
            }

            @Override // net.bytebuddy.utility.dispatcher.JavaDispatcher.Dispatcher
            public int apply(MethodVisitor methodVisitor, Method method) {
                methodVisitor.visitTypeInsn(187, Type.getInternalName(IllegalStateException.class));
                methodVisitor.visitInsn(89);
                methodVisitor.visitLdcInsn(this.message);
                methodVisitor.visitMethodInsn(183, Type.getInternalName(IllegalStateException.class), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, Type.getType(String.class)), false);
                methodVisitor.visitInsn(191);
                return 3;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$ProxiedInvocationHandler.class */
    protected static class ProxiedInvocationHandler implements InvocationHandler {
        private final String name;
        private final Map<Method, Dispatcher> targets;

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((ProxiedInvocationHandler) obj).name) && this.targets.equals(((ProxiedInvocationHandler) obj).targets);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.targets.hashCode();
        }

        protected ProxiedInvocationHandler(String name, Map<Method, Dispatcher> targets) {
            this.name = name;
            this.targets = targets;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] argument) throws Throwable {
            if (method.getDeclaringClass() != Object.class) {
                try {
                    Dispatcher dispatcher = this.targets.get(method);
                    try {
                        if (dispatcher != null) {
                            return dispatcher.invoke(argument);
                        }
                        throw new IllegalStateException("No proxy target found for " + method);
                    } catch (InvocationTargetException exception) {
                        throw exception.getCause();
                    }
                } catch (RuntimeException exception2) {
                    throw exception2;
                } catch (Throwable throwable) {
                    for (Class<?> type : method.getExceptionTypes()) {
                        if (type.isInstance(throwable)) {
                            throw throwable;
                        }
                    }
                    throw new IllegalStateException("Failed to invoke proxy for " + method, throwable);
                }
            } else if (method.getName().equals("hashCode")) {
                return Integer.valueOf(hashCode());
            } else {
                if (method.getName().equals("equals")) {
                    return Boolean.valueOf(argument[0] != null && Proxy.isProxyClass(argument[0].getClass()) && Proxy.getInvocationHandler(argument[0]).equals(this));
                } else if (method.getName().equals(Printer.TO_STRING)) {
                    return "Call proxy for " + this.name;
                } else {
                    throw new IllegalStateException("Unexpected object method: " + method);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/utility/dispatcher/JavaDispatcher$DynamicClassLoader.class */
    public static class DynamicClassLoader extends ClassLoader {
        private static final Class<?>[] NO_PARAMETER = new Class[0];
        private static final Object[] NO_ARGUMENT = new Object[0];

        protected DynamicClassLoader(ClassLoader parent) {
            super(parent);
        }

        @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Expected internal invocation")
        protected static Object proxy(Class<?> proxy, Map<Method, Dispatcher> dispatchers) {
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, Type.getInternalName(proxy) + "$Proxy", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(proxy)});
            for (Map.Entry<Method, Dispatcher> entry : dispatchers.entrySet()) {
                Class<?>[] exceptionType = entry.getKey().getExceptionTypes();
                String[] exceptionTypeName = new String[exceptionType.length];
                for (int index = 0; index < exceptionType.length; index++) {
                    exceptionTypeName[index] = Type.getInternalName(exceptionType[index]);
                }
                MethodVisitor methodVisitor = classWriter.visitMethod(1, entry.getKey().getName(), Type.getMethodDescriptor(entry.getKey()), null, exceptionTypeName);
                methodVisitor.visitCode();
                int offset = (entry.getKey().getModifiers() & 8) == 0 ? 1 : 0;
                for (Class<?> type : entry.getKey().getParameterTypes()) {
                    offset += Type.getType(type).getSize();
                }
                methodVisitor.visitMaxs(entry.getValue().apply(methodVisitor, entry.getKey()), offset);
                methodVisitor.visitEnd();
            }
            MethodVisitor methodVisitor2 = classWriter.visitMethod(1, "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null);
            methodVisitor2.visitCode();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(183, Type.getInternalName(Object.class), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), false);
            methodVisitor2.visitInsn(177);
            methodVisitor2.visitMaxs(1, 1);
            methodVisitor2.visitEnd();
            classWriter.visitEnd();
            byte[] binaryRepresentation = classWriter.toByteArray();
            try {
                return new DynamicClassLoader(proxy.getClassLoader()).defineClass(proxy.getName() + "$Proxy", binaryRepresentation, 0, binaryRepresentation.length, new ProtectionDomain(null, null)).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (Exception exception) {
                throw new IllegalStateException("Failed to create proxy for " + proxy.getName(), exception);
            }
        }

        @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION", "DP_CREATE_CLASSLOADER_INSIDE_DO_PRIVILEGED"}, justification = "Expected internal invocation")
        protected static Invoker invoker() {
            ClassWriter classWriter = new ClassWriter(0);
            classWriter.visit(ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).getMinorMajorVersion(), 1, Type.getInternalName(Invoker.class) + "$Dispatcher", null, Type.getInternalName(Object.class), new String[]{Type.getInternalName(Invoker.class)});
            Method[] methods = Invoker.class.getMethods();
            for (Method method : methods) {
                Class<?>[] exceptionType = method.getExceptionTypes();
                String[] exceptionTypeName = new String[exceptionType.length];
                for (int index = 0; index < exceptionType.length; index++) {
                    exceptionTypeName[index] = Type.getInternalName(exceptionType[index]);
                }
                MethodVisitor methodVisitor = classWriter.visitMethod(1, method.getName(), Type.getMethodDescriptor(method), null, exceptionTypeName);
                methodVisitor.visitCode();
                int offset = 1;
                Type[] parameter = new Type[method.getParameterTypes().length - 1];
                for (int index2 = 0; index2 < method.getParameterTypes().length; index2++) {
                    Type type = Type.getType(method.getParameterTypes()[index2]);
                    if (index2 > 0) {
                        parameter[index2 - 1] = type;
                    }
                    methodVisitor.visitVarInsn(type.getOpcode(21), offset);
                    offset += type.getSize();
                }
                methodVisitor.visitMethodInsn(182, Type.getInternalName(method.getParameterTypes()[0]), method.getName(), Type.getMethodDescriptor(Type.getReturnType(method), parameter), false);
                methodVisitor.visitInsn(Type.getReturnType(method).getOpcode(172));
                methodVisitor.visitMaxs(Math.max(offset - 1, Type.getReturnType(method).getSize()), offset);
                methodVisitor.visitEnd();
            }
            MethodVisitor methodVisitor2 = classWriter.visitMethod(1, "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), null, null);
            methodVisitor2.visitCode();
            methodVisitor2.visitVarInsn(25, 0);
            methodVisitor2.visitMethodInsn(183, Type.getInternalName(Object.class), "<init>", Type.getMethodDescriptor(Type.VOID_TYPE, new Type[0]), false);
            methodVisitor2.visitInsn(177);
            methodVisitor2.visitMaxs(1, 1);
            methodVisitor2.visitEnd();
            classWriter.visitEnd();
            byte[] binaryRepresentation = classWriter.toByteArray();
            try {
                return (Invoker) new DynamicClassLoader(Invoker.class.getClassLoader()).defineClass(Invoker.class.getName() + "$Dispatcher", binaryRepresentation, 0, binaryRepresentation.length, new ProtectionDomain(null, null)).getConstructor(NO_PARAMETER).newInstance(NO_ARGUMENT);
            } catch (Exception exception) {
                throw new IllegalStateException("Failed to create invoker for " + Invoker.class.getName(), exception);
            }
        }
    }
}
