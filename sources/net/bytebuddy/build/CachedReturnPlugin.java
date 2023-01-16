package net.bytebuddy.build;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.Map;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.modifier.FieldPersistence;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Ownership;
import net.bytebuddy.description.modifier.SyntheticState;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.bytecode.assign.Assigner;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import net.bytebuddy.utility.RandomString;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin.class */
public class CachedReturnPlugin extends Plugin.ForElementMatcher implements Plugin.Factory {
    private static final String NAME_INFIX = "_";
    private static final String ADVICE_INFIX = "$";
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final RandomString randomString = new RandomString();
    private final ClassFileLocator classFileLocator = ClassFileLocator.ForClassLoader.m232of(CachedReturnPlugin.class.getClassLoader());
    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.IGNORE)
    private final Map<TypeDescription, TypeDescription> adviceByType = new HashMap();

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$CacheField.class */
    protected @interface CacheField {
    }

    @Target({ElementType.METHOD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$Enhance.class */
    public @interface Enhance {
        String value() default "";
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher, java.lang.Object
    public boolean equals(Object obj) {
        if (!equals(obj)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.classFileLocator.equals(((CachedReturnPlugin) obj).classFileLocator);
    }

    @Override // net.bytebuddy.build.Plugin.ForElementMatcher, java.lang.Object
    public int hashCode() {
        return (hashCode() * 31) + this.classFileLocator.hashCode();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$Object.class */
    class Object {
        private Object() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static Object enter(@CacheField Object cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object returned, @CacheField Object cached) {
            if (returned != null) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$boolean  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$boolean.class */
    class Cboolean {
        private Cboolean() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static boolean enter(@CacheField boolean cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "IP_PARAMETER_IS_DEAD_BUT_OVERWRITTEN"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) boolean returned, @CacheField boolean cached) {
            if (!returned) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$byte  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$byte.class */
    class Cbyte {
        private Cbyte() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static byte enter(@CacheField byte cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) byte returned, @CacheField byte cached) {
            if (returned != 0) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$char  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$char.class */
    class Cchar {
        private Cchar() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static char enter(@CacheField char cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) char returned, @CacheField char cached) {
            if (returned != 0) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$double  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$double.class */
    class Cdouble {
        private Cdouble() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static double enter(@CacheField double cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) double returned, @CacheField double cached) {
            if (returned != 0.0d) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$float  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$float.class */
    class Cfloat {
        private Cfloat() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static float enter(@CacheField float cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) float returned, @CacheField float cached) {
            if (returned != 0.0f) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$int  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$int.class */
    class Cint {
        private Cint() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static int enter(@CacheField int cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) int returned, @CacheField int cached) {
            if (returned != 0) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$long  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$long.class */
    class Clong {
        private Clong() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static long enter(@CacheField long cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) long returned, @CacheField long cached) {
            if (returned != 0) {
            }
        }
    }

    @SuppressFBWarnings(value = {"NM_CLASS_NAMING_CONVENTION"}, justification = "Name is chosen to optimize for simple lookup")
    /* renamed from: net.bytebuddy.build.CachedReturnPlugin$short  reason: invalid class name */
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$short.class */
    class Cshort {
        private Cshort() {
            throw new UnsupportedOperationException("This class is merely an advice template and should not be instantiated");
        }

        @Advice.OnMethodEnter(skipOn = Advice.OnNonDefaultValue.class)
        protected static short enter(@CacheField short cached) {
            return cached;
        }

        @Advice.OnMethodExit
        @SuppressFBWarnings(value = {"UC_USELESS_VOID_METHOD", "DLS_DEAD_LOCAL_STORE"}, justification = "Advice method serves as a template")
        protected static void exit(@Advice.Return(readOnly = false) short returned, @CacheField short cached) {
            if (returned != 0) {
            }
        }
    }

    public CachedReturnPlugin() {
        super(ElementMatchers.declaresMethod(ElementMatchers.isAnnotatedWith(Enhance.class)));
        TypePool typePool = TypePool.Default.m89of(this.classFileLocator);
        Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Object.class};
        for (Class<?> type : clsArr) {
            this.adviceByType.put(TypeDescription.ForLoadedType.m247of(type), typePool.describe(CachedReturnPlugin.class.getName() + ADVICE_INFIX + type.getSimpleName()).resolve());
        }
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        for (MethodDescription.InDefinedShape methodDescription : typeDescription.getDeclaredMethods().filter(ElementMatchers.not(ElementMatchers.isBridge()).and(ElementMatchers.isAnnotatedWith(Enhance.class)))) {
            if (methodDescription.isAbstract()) {
                throw new IllegalStateException("Cannot cache the value of an abstract method: " + methodDescription);
            } else if (!methodDescription.getParameters().isEmpty()) {
                throw new IllegalStateException("Cannot cache the value of a method with parameters: " + methodDescription);
            } else if (methodDescription.getReturnType().represents(Void.TYPE)) {
                throw new IllegalStateException("Cannot cache void result for " + methodDescription);
            } else {
                String name = ((Enhance) methodDescription.getDeclaredAnnotations().ofType(Enhance.class).load()).value();
                if (name.length() == 0) {
                    name = methodDescription.getName() + "_" + this.randomString.nextString();
                }
                TypeDescription asErasure = methodDescription.getReturnType().asErasure();
                ModifierContributor.ForField[] forFieldArr = new ModifierContributor.ForField[4];
                forFieldArr[0] = methodDescription.isStatic() ? Ownership.STATIC : Ownership.MEMBER;
                forFieldArr[1] = Visibility.PRIVATE;
                forFieldArr[2] = SyntheticState.SYNTHETIC;
                forFieldArr[3] = FieldPersistence.TRANSIENT;
                builder = builder.defineField(name, asErasure, forFieldArr).visit(Advice.withCustomMapping().bind(CacheField.class, (Advice.OffsetMapping) new CacheFieldOffsetMapping(name)).m296to(this.adviceByType.get(methodDescription.getReturnType().isPrimitive() ? methodDescription.getReturnType().asErasure() : TypeDescription.OBJECT), this.classFileLocator).m332on(ElementMatchers.m97is(methodDescription)));
            }
        }
        return builder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/build/CachedReturnPlugin$CacheFieldOffsetMapping.class */
    protected static class CacheFieldOffsetMapping implements Advice.OffsetMapping {
        private final String name;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.name.equals(((CacheFieldOffsetMapping) obj).name);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.name.hashCode();
        }

        protected CacheFieldOffsetMapping(String name) {
            this.name = name;
        }

        @Override // net.bytebuddy.asm.Advice.OffsetMapping
        public Advice.OffsetMapping.Target resolve(TypeDescription instrumentedType, MethodDescription instrumentedMethod, Assigner assigner, Advice.ArgumentHandler argumentHandler, Advice.OffsetMapping.Sort sort) {
            return new Advice.OffsetMapping.Target.ForField.ReadWrite((FieldDescription) instrumentedType.getDeclaredFields().filter(ElementMatchers.named(this.name)).getOnly());
        }
    }
}
