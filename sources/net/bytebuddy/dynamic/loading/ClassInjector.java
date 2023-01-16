package net.bytebuddy.dynamic.loading;

import com.sun.jna.FunctionMapper;
import com.sun.jna.JNIEnv;
import com.sun.jna.LastErrorException;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.lang.instrument.Instrumentation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarFile;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.asm.MemberRemoval;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;
import net.bytebuddy.dynamic.scaffold.TypeValidation;
import net.bytebuddy.dynamic.scaffold.subclass.ConstructorStrategy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.RandomString;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector.class */
public interface ClassInjector {
    public static final Permission SUPPRESS_ACCESS_CHECKS = new ReflectPermission("suppressAccessChecks");
    public static final boolean ALLOW_EXISTING_TYPES = false;

    boolean isAlive();

    Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> map);

    Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> map);

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$AbstractBase.class */
    public static abstract class AbstractBase implements ClassInjector {
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<TypeDescription, Class<?>> inject(Map<? extends TypeDescription, byte[]> types) {
            Map<String, byte[]> binaryRepresentations = new LinkedHashMap<>();
            for (Map.Entry<? extends TypeDescription, byte[]> entry : types.entrySet()) {
                binaryRepresentations.put(((TypeDescription) entry.getKey()).getName(), entry.getValue());
            }
            Map<String, Class<?>> loadedTypes = injectRaw(binaryRepresentations);
            Map<TypeDescription, Class<?>> result = new LinkedHashMap<>();
            for (TypeDescription typeDescription : types.keySet()) {
                result.put(typeDescription, loadedTypes.get(typeDescription.getName()));
            }
            return result;
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection.class */
    public static class UsingReflection extends AbstractBase {
        private static final Dispatcher.Initializable DISPATCHER = (Dispatcher.Initializable) AccessController.doPrivileged(Dispatcher.CreationAction.INSTANCE);
        private final ClassLoader classLoader;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;
        private final PackageDefinitionStrategy packageDefinitionStrategy;
        private final boolean forbidExisting;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass() || this.forbidExisting != ((UsingReflection) obj).forbidExisting || !this.classLoader.equals(((UsingReflection) obj).classLoader)) {
                return false;
            }
            ProtectionDomain protectionDomain = this.protectionDomain;
            ProtectionDomain protectionDomain2 = ((UsingReflection) obj).protectionDomain;
            if (protectionDomain2 != null) {
                if (protectionDomain == null || !protectionDomain.equals(protectionDomain2)) {
                    return false;
                }
            } else if (protectionDomain != null) {
                return false;
            }
            return this.packageDefinitionStrategy.equals(((UsingReflection) obj).packageDefinitionStrategy);
        }

        public int hashCode() {
            int hashCode = ((getClass().hashCode() * 31) + this.classLoader.hashCode()) * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            if (protectionDomain != null) {
                hashCode += protectionDomain.hashCode();
            }
            return (((hashCode * 31) + this.packageDefinitionStrategy.hashCode()) * 31) + (this.forbidExisting ? 1 : 0);
        }

        public UsingReflection(ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        public UsingReflection(ClassLoader classLoader, ProtectionDomain protectionDomain) {
            this(classLoader, protectionDomain, PackageDefinitionStrategy.Trivial.INSTANCE, false);
        }

        public UsingReflection(ClassLoader classLoader, ProtectionDomain protectionDomain, PackageDefinitionStrategy packageDefinitionStrategy, boolean forbidExisting) {
            if (classLoader == null) {
                throw new IllegalArgumentException("Cannot inject classes into the bootstrap class loader");
            }
            this.classLoader = classLoader;
            this.protectionDomain = protectionDomain;
            this.packageDefinitionStrategy = packageDefinitionStrategy;
            this.forbidExisting = forbidExisting;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0109
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r12) {
            /*
            // Method dump skipped, instructions count: 486
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.injectRaw(java.util.Map):java.util.Map");
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemClassLoader() {
            return new UsingReflection(ClassLoader.getSystemClassLoader());
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher.class */
        protected interface Dispatcher {
            public static final Class<?> UNDEFINED = null;

            Object getClassLoadingLock(ClassLoader classLoader, String str);

            Class<?> findClass(ClassLoader classLoader, String str);

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);

            Package getDefinedPackage(ClassLoader classLoader, String str);

            Package getPackage(ClassLoader classLoader, String str);

            Package definePackage(ClassLoader classLoader, String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url);

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Initializable.class */
            public interface Initializable {
                boolean isAvailable();

                Dispatcher initialize();

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Initializable$Unavailable.class */
                public static class Unavailable implements Dispatcher, Initializable {
                    private final String message;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.message.hashCode();
                    }

                    protected Unavailable(String message) {
                        this.message = message;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                    public boolean isAvailable() {
                        return false;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                    public Dispatcher initialize() {
                        return this;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                        return classLoader;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Class<?> findClass(ClassLoader classLoader, String name) {
                        try {
                            return classLoader.loadClass(name);
                        } catch (ClassNotFoundException e) {
                            return UNDEFINED;
                        }
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                        throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package getDefinedPackage(ClassLoader classLoader, String name) {
                        throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package getPackage(ClassLoader classLoader, String name) {
                        throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Package definePackage(ClassLoader classLoader, String name, String specificationTitle, String specificationVersion, String specificationVendor, String implementationTitle, String implementationVersion, String implementationVendor, URL sealBase) {
                        throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$CreationAction.class */
            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback")
                public Initializable run() {
                    try {
                        if (!JavaModule.isSupported()) {
                            return Direct.make();
                        }
                        if (UsingUnsafe.isAvailable()) {
                            return UsingUnsafeInjection.make();
                        }
                        return UsingUnsafeOverride.make();
                    } catch (InvocationTargetException exception) {
                        return new Initializable.Unavailable(exception.getCause().getMessage());
                    } catch (Exception exception2) {
                        return new Initializable.Unavailable(exception2.getMessage());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Direct.class */
            public static abstract class Direct implements Dispatcher, Initializable {
                protected final Method findLoadedClass;
                protected final Method defineClass;
                protected final Method getDefinedPackage;
                protected final Method getPackage;
                protected final Method definePackage;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.findLoadedClass.equals(((Direct) obj).findLoadedClass) && this.defineClass.equals(((Direct) obj).defineClass) && this.getDefinedPackage.equals(((Direct) obj).getDefinedPackage) && this.getPackage.equals(((Direct) obj).getPackage) && this.definePackage.equals(((Direct) obj).definePackage);
                }

                public int hashCode() {
                    return (((((((((getClass().hashCode() * 31) + this.findLoadedClass.hashCode()) * 31) + this.defineClass.hashCode()) * 31) + this.getDefinedPackage.hashCode()) * 31) + this.getPackage.hashCode()) * 31) + this.definePackage.hashCode();
                }

                protected Direct(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage) {
                    this.findLoadedClass = findLoadedClass;
                    this.defineClass = defineClass;
                    this.getDefinedPackage = getDefinedPackage;
                    this.getPackage = getPackage;
                    this.definePackage = definePackage;
                }

                @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Privilege is explicit caller responsibility")
                protected static Initializable make() throws Exception {
                    Method getDefinedPackage;
                    if (JavaModule.isSupported()) {
                        try {
                            getDefinedPackage = ClassLoader.class.getMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException e) {
                            getDefinedPackage = null;
                        }
                    } else {
                        getDefinedPackage = null;
                    }
                    Method getPackage = ClassLoader.class.getDeclaredMethod("getPackage", String.class);
                    getPackage.setAccessible(true);
                    Method findLoadedClass = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
                    findLoadedClass.setAccessible(true);
                    Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class);
                    defineClass.setAccessible(true);
                    Method definePackage = ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
                    definePackage.setAccessible(true);
                    try {
                        Method getClassLoadingLock = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class);
                        getClassLoadingLock.setAccessible(true);
                        return new ForJava7CapableVm(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage, getClassLoadingLock);
                    } catch (NoSuchMethodException e2) {
                        return new ForLegacyVm(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    SecurityManager securityManager = System.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            securityManager.checkPermission(ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        } catch (Exception exception) {
                            return new Unavailable(exception.getMessage());
                        }
                    }
                    return this;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String name) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#findClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#findClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, name, binaryRepresentation, 0, Integer.valueOf(binaryRepresentation.length), protectionDomain);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#defineClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#defineClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getDefinedPackage(ClassLoader classLoader, String name) {
                    if (this.getDefinedPackage == null) {
                        return getPackage(classLoader, name);
                    }
                    try {
                        return (Package) this.getDefinedPackage.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#getDefinedPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#getDefinedPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String name) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#getPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#getPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String name, String specificationTitle, String specificationVersion, String specificationVendor, String implementationTitle, String implementationVersion, String implementationVendor, URL sealBase) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, name, specificationTitle, specificationVersion, specificationVendor, implementationTitle, implementationVersion, implementationVendor, sealBase);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#definePackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#definePackage", exception2.getCause());
                    }
                }

                /* access modifiers changed from: protected */
                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Direct$ForJava7CapableVm.class */
                public static class ForJava7CapableVm extends Direct {
                    private final Method getClassLoadingLock;

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Direct
                    public boolean equals(Object obj) {
                        if (!equals(obj)) {
                            return false;
                        }
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Direct
                    public int hashCode() {
                        return (hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }

                    protected ForJava7CapableVm(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage, Method getClassLoadingLock) {
                        super(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                        this.getClassLoadingLock = getClassLoadingLock;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, name);
                        } catch (IllegalAccessException exception) {
                            throw new IllegalStateException("Could not access java.lang.ClassLoader#getClassLoadingLock", exception);
                        } catch (InvocationTargetException exception2) {
                            throw new IllegalStateException("Error invoking java.lang.ClassLoader#getClassLoadingLock", exception2.getCause());
                        }
                    }
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Direct$ForLegacyVm.class */
                public static class ForLegacyVm extends Direct {
                    protected ForLegacyVm(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage) {
                        super(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                        return classLoader;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeInjection.class */
            public static class UsingUnsafeInjection implements Dispatcher, Initializable {
                private final Object accessor;
                private final Method findLoadedClass;
                private final Method defineClass;
                private final Method getDefinedPackage;
                private final Method getPackage;
                private final Method definePackage;
                private final Method getClassLoadingLock;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.accessor.equals(((UsingUnsafeInjection) obj).accessor) && this.findLoadedClass.equals(((UsingUnsafeInjection) obj).findLoadedClass) && this.defineClass.equals(((UsingUnsafeInjection) obj).defineClass) && this.getDefinedPackage.equals(((UsingUnsafeInjection) obj).getDefinedPackage) && this.getPackage.equals(((UsingUnsafeInjection) obj).getPackage) && this.definePackage.equals(((UsingUnsafeInjection) obj).definePackage) && this.getClassLoadingLock.equals(((UsingUnsafeInjection) obj).getClassLoadingLock);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.accessor.hashCode()) * 31) + this.findLoadedClass.hashCode()) * 31) + this.defineClass.hashCode()) * 31) + this.getDefinedPackage.hashCode()) * 31) + this.getPackage.hashCode()) * 31) + this.definePackage.hashCode()) * 31) + this.getClassLoadingLock.hashCode();
                }

                protected UsingUnsafeInjection(Object accessor, Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage, Method getClassLoadingLock) {
                    this.accessor = accessor;
                    this.findLoadedClass = findLoadedClass;
                    this.defineClass = defineClass;
                    this.getDefinedPackage = getDefinedPackage;
                    this.getPackage = getPackage;
                    this.definePackage = definePackage;
                    this.getClassLoadingLock = getClassLoadingLock;
                }

                @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Privilege is explicit caller responsibility")
                protected static Initializable make() throws Exception {
                    Method getDefinedPackage;
                    if (Boolean.getBoolean(UsingUnsafe.SAFE_PROPERTY)) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> unsafe = Class.forName("sun.misc.Unsafe");
                    Field theUnsafe = unsafe.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    Object unsafeInstance = theUnsafe.get(null);
                    if (JavaModule.isSupported()) {
                        try {
                            getDefinedPackage = ClassLoader.class.getDeclaredMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException e) {
                            getDefinedPackage = null;
                        }
                    } else {
                        getDefinedPackage = null;
                    }
                    DynamicType.Builder<?> builder = new ByteBuddy().with(TypeValidation.DISABLED).subclass(Object.class, (ConstructorStrategy) ConstructorStrategy.Default.NO_CONSTRUCTORS).name(ClassLoader.class.getName() + "$ByteBuddyAccessor$" + RandomString.make()).defineMethod("findLoadedClass", Class.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class)).onArgument(0).withArgument(1)).defineMethod("defineClass", Class.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class)).onArgument(0).withArgument(1, 2, 3, 4, 5)).defineMethod("getPackage", Package.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getPackage", String.class)).onArgument(0).withArgument(1)).defineMethod("definePackage", Package.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class)).onArgument(0).withArgument(1, 2, 3, 4, 5, 6, 7, 8));
                    if (getDefinedPackage != null) {
                        builder = builder.defineMethod("getDefinedPackage", Package.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(getDefinedPackage).onArgument(0).withArgument(1));
                    }
                    try {
                        builder = builder.defineMethod("getClassLoadingLock", Object.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class).intercept(MethodCall.invoke(ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class)).onArgument(0).withArgument(1));
                    } catch (NoSuchMethodException e2) {
                        builder = builder.defineMethod("getClassLoadingLock", Object.class, Visibility.PUBLIC).withParameters(ClassLoader.class, String.class).intercept(FixedValue.argument(0));
                    }
                    Class<?> type = builder.make().load(ClassLoadingStrategy.BOOTSTRAP_LOADER, new ClassLoadingStrategy.ForUnsafeInjection()).getLoaded();
                    return new UsingUnsafeInjection(unsafe.getMethod("allocateInstance", Class.class).invoke(unsafeInstance, type), type.getMethod("findLoadedClass", ClassLoader.class, String.class), type.getMethod("defineClass", ClassLoader.class, String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class), getDefinedPackage != null ? type.getMethod("getDefinedPackage", ClassLoader.class, String.class) : null, type.getMethod("getPackage", ClassLoader.class, String.class), type.getMethod("definePackage", ClassLoader.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class), type.getMethod("getClassLoadingLock", ClassLoader.class, String.class));
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    SecurityManager securityManager = System.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            securityManager.checkPermission(ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        } catch (Exception exception) {
                            return new Unavailable(exception.getMessage());
                        }
                    }
                    return this;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                    try {
                        return this.getClassLoadingLock.invoke(this.accessor, classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::getClassLoadingLock", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::getClassLoadingLock", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String name) {
                    try {
                        return (Class) this.findLoadedClass.invoke(this.accessor, classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::findLoadedClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::findLoadedClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.accessor, classLoader, name, binaryRepresentation, 0, Integer.valueOf(binaryRepresentation.length), protectionDomain);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::defineClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::defineClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getDefinedPackage(ClassLoader classLoader, String name) {
                    if (this.getDefinedPackage == null) {
                        return getPackage(classLoader, name);
                    }
                    try {
                        return (Package) this.getDefinedPackage.invoke(this.accessor, classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::getDefinedPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::getDefinedPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String name) {
                    try {
                        return (Package) this.getPackage.invoke(this.accessor, classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::getPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::getPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String name, String specificationTitle, String specificationVersion, String specificationVendor, String implementationTitle, String implementationVersion, String implementationVendor, URL sealBase) {
                    try {
                        return (Package) this.definePackage.invoke(this.accessor, classLoader, name, specificationTitle, specificationVersion, specificationVendor, implementationTitle, implementationVersion, implementationVendor, sealBase);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access (accessor)::definePackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking (accessor)::definePackage", exception2.getCause());
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeOverride.class */
            public static abstract class UsingUnsafeOverride implements Dispatcher, Initializable {
                protected final Method findLoadedClass;
                protected final Method defineClass;
                protected final Method getDefinedPackage;
                protected final Method getPackage;
                protected final Method definePackage;

                protected UsingUnsafeOverride(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage) {
                    this.findLoadedClass = findLoadedClass;
                    this.defineClass = defineClass;
                    this.getDefinedPackage = getDefinedPackage;
                    this.getPackage = getPackage;
                    this.definePackage = definePackage;
                }

                @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Privilege is explicit caller responsibility")
                protected static Initializable make() throws Exception {
                    Field override;
                    Method getDefinedPackage;
                    if (Boolean.getBoolean(UsingUnsafe.SAFE_PROPERTY)) {
                        return new Initializable.Unavailable("Use of Unsafe was disabled by system property");
                    }
                    Class<?> unsafeType = Class.forName("sun.misc.Unsafe");
                    Field theUnsafe = unsafeType.getDeclaredField("theUnsafe");
                    theUnsafe.setAccessible(true);
                    Object unsafe = theUnsafe.get(null);
                    try {
                        override = AccessibleObject.class.getDeclaredField("override");
                    } catch (NoSuchFieldException e) {
                        override = new ByteBuddy().redefine(AccessibleObject.class).name("net.bytebuddy.mirror." + AccessibleObject.class.getSimpleName()).noNestMate().visit(new MemberRemoval().stripInvokables(ElementMatchers.any())).make().load(AccessibleObject.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER).getLoaded().getDeclaredField("override");
                    }
                    long offset = ((Long) unsafeType.getMethod("objectFieldOffset", Field.class).invoke(unsafe, override)).longValue();
                    Method putBoolean = unsafeType.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
                    if (JavaModule.isSupported()) {
                        try {
                            getDefinedPackage = ClassLoader.class.getMethod("getDefinedPackage", String.class);
                        } catch (NoSuchMethodException e2) {
                            getDefinedPackage = null;
                        }
                    } else {
                        getDefinedPackage = null;
                    }
                    Method getPackage = ClassLoader.class.getDeclaredMethod("getPackage", String.class);
                    putBoolean.invoke(unsafe, getPackage, Long.valueOf(offset), true);
                    Method findLoadedClass = ClassLoader.class.getDeclaredMethod("findLoadedClass", String.class);
                    Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ProtectionDomain.class);
                    Method definePackage = ClassLoader.class.getDeclaredMethod("definePackage", String.class, String.class, String.class, String.class, String.class, String.class, String.class, URL.class);
                    putBoolean.invoke(unsafe, defineClass, Long.valueOf(offset), true);
                    putBoolean.invoke(unsafe, findLoadedClass, Long.valueOf(offset), true);
                    putBoolean.invoke(unsafe, definePackage, Long.valueOf(offset), true);
                    try {
                        Method getClassLoadingLock = ClassLoader.class.getDeclaredMethod("getClassLoadingLock", String.class);
                        putBoolean.invoke(unsafe, getClassLoadingLock, Long.valueOf(offset), true);
                        return new ForJava7CapableVm(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage, getClassLoadingLock);
                    } catch (NoSuchMethodException e3) {
                        return new ForLegacyVm(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher.Initializable
                public Dispatcher initialize() {
                    SecurityManager securityManager = System.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            securityManager.checkPermission(ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        } catch (Exception exception) {
                            return new Unavailable(exception.getMessage());
                        }
                    }
                    return this;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String name) {
                    try {
                        return (Class) this.findLoadedClass.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#findClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#findClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(classLoader, name, binaryRepresentation, 0, Integer.valueOf(binaryRepresentation.length), protectionDomain);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#defineClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#defineClass", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getDefinedPackage(ClassLoader classLoader, String name) {
                    if (this.getDefinedPackage == null) {
                        return getPackage(classLoader, name);
                    }
                    try {
                        return (Package) this.getDefinedPackage.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#getDefinedPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#getDefinedPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String name) {
                    try {
                        return (Package) this.getPackage.invoke(classLoader, name);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#getPackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#getPackage", exception2.getCause());
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String name, String specificationTitle, String specificationVersion, String specificationVendor, String implementationTitle, String implementationVersion, String implementationVendor, URL sealBase) {
                    try {
                        return (Package) this.definePackage.invoke(classLoader, name, specificationTitle, specificationVersion, specificationVendor, implementationTitle, implementationVersion, implementationVendor, sealBase);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access java.lang.ClassLoader#definePackage", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking java.lang.ClassLoader#definePackage", exception2.getCause());
                    }
                }

                /* access modifiers changed from: protected */
                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeOverride$ForJava7CapableVm.class */
                public static class ForJava7CapableVm extends UsingUnsafeOverride {
                    private final Method getClassLoadingLock;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.getClassLoadingLock.equals(((ForJava7CapableVm) obj).getClassLoadingLock);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.getClassLoadingLock.hashCode();
                    }

                    protected ForJava7CapableVm(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage, Method getClassLoadingLock) {
                        super(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                        this.getClassLoadingLock = getClassLoadingLock;
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                        try {
                            return this.getClassLoadingLock.invoke(classLoader, name);
                        } catch (IllegalAccessException exception) {
                            throw new IllegalStateException("Could not access java.lang.ClassLoader#getClassLoadingLock", exception);
                        } catch (InvocationTargetException exception2) {
                            throw new IllegalStateException("Error invoking java.lang.ClassLoader#getClassLoadingLock", exception2.getCause());
                        }
                    }
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$UsingUnsafeOverride$ForLegacyVm.class */
                public static class ForLegacyVm extends UsingUnsafeOverride {
                    protected ForLegacyVm(Method findLoadedClass, Method defineClass, Method getDefinedPackage, Method getPackage, Method definePackage) {
                        super(findLoadedClass, defineClass, getDefinedPackage, getPackage, definePackage);
                    }

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                    public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                        return classLoader;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingReflection$Dispatcher$Unavailable.class */
            public static class Unavailable implements Dispatcher {
                private final String message;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }

                protected Unavailable(String message) {
                    this.message = message;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Object getClassLoadingLock(ClassLoader classLoader, String name) {
                    return classLoader;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> findClass(ClassLoader classLoader, String name) {
                    try {
                        return classLoader.loadClass(name);
                    } catch (ClassNotFoundException e) {
                        return UNDEFINED;
                    }
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Cannot define class using reflection: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getDefinedPackage(ClassLoader classLoader, String name) {
                    throw new UnsupportedOperationException("Cannot get defined package using reflection: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package getPackage(ClassLoader classLoader, String name) {
                    throw new UnsupportedOperationException("Cannot get package using reflection: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingReflection.Dispatcher
                public Package definePackage(ClassLoader classLoader, String name, String specificationTitle, String specificationVersion, String specificationVendor, String implementationTitle, String implementationVersion, String implementationVendor, URL sealBase) {
                    throw new UnsupportedOperationException("Cannot define package using injection: " + this.message);
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingLookup.class */
    public static class UsingLookup extends AbstractBase {
        private static final MethodHandles METHOD_HANDLES = (MethodHandles) AccessController.doPrivileged(JavaDispatcher.m62of(MethodHandles.class));
        private static final MethodHandles.Lookup METHOD_HANDLES_LOOKUP = (MethodHandles.Lookup) AccessController.doPrivileged(JavaDispatcher.m62of(MethodHandles.Lookup.class));
        private static final int PACKAGE_LOOKUP = 8;
        private final Object lookup;

        @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles")
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingLookup$MethodHandles.class */
        protected interface MethodHandles {

            @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup")
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingLookup$MethodHandles$Lookup.class */
            public interface Lookup {
                Class<?> lookupClass(Object obj);

                int lookupModes(Object obj);

                Class<?> defineClass(Object obj, byte[] bArr) throws IllegalAccessException;
            }

            @JavaDispatcher.IsStatic
            Object privateLookupIn(Class<?> cls, @JavaDispatcher.Proxied("java.lang.invoke.MethodHandles$Lookup") Object obj) throws IllegalAccessException;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.lookup.equals(((UsingLookup) obj).lookup);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.lookup.hashCode();
        }

        protected UsingLookup(Object lookup) {
            this.lookup = lookup;
        }

        /* renamed from: of */
        public static UsingLookup m218of(Object lookup) {
            if (!isAvailable()) {
                throw new IllegalStateException("The current VM does not support class definition via method handle lookups");
            } else if (!JavaType.METHOD_HANDLES_LOOKUP.isInstance(lookup)) {
                throw new IllegalArgumentException("Not a method handle lookup: " + lookup);
            } else if ((METHOD_HANDLES_LOOKUP.lookupModes(lookup) & 8) != 0) {
                return new UsingLookup(lookup);
            } else {
                throw new IllegalArgumentException("Lookup does not imply package-access: " + lookup);
            }
        }

        public Class<?> lookupType() {
            return METHOD_HANDLES_LOOKUP.lookupClass(this.lookup);
        }

        /* renamed from: in */
        public UsingLookup m219in(Class<?> type) {
            try {
                return new UsingLookup(METHOD_HANDLES.privateLookupIn(type, this.lookup));
            } catch (IllegalAccessException exception) {
                throw new IllegalStateException("Cannot access " + type.getName() + " from " + this.lookup, exception);
            }
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public Map<String, Class<?>> injectRaw(Map<? extends String, byte[]> types) {
            String expectedPackage = TypeDescription.ForLoadedType.m247of(lookupType()).getPackage().getName();
            HashMap hashMap = new HashMap();
            for (Map.Entry<? extends String, byte[]> entry : types.entrySet()) {
                int index = ((String) entry.getKey()).lastIndexOf(46);
                if (!expectedPackage.equals(index == -1 ? "" : ((String) entry.getKey()).substring(0, index))) {
                    throw new IllegalArgumentException(((String) entry.getKey()) + " must be defined in the same package as " + this.lookup);
                }
                try {
                    hashMap.put(entry.getKey(), METHOD_HANDLES_LOOKUP.defineClass(this.lookup, entry.getValue()));
                } catch (IllegalAccessException exception) {
                    throw new IllegalStateException("Failed to define " + ((String) entry.getKey()) + " using " + this.lookup, exception);
                }
            }
            return hashMap;
        }

        public static boolean isAvailable() {
            return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V9);
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe.class */
    public static class UsingUnsafe extends AbstractBase {
        public static final String SAFE_PROPERTY = "net.bytebuddy.safe";
        private static final Dispatcher.Initializable DISPATCHER = (Dispatcher.Initializable) AccessController.doPrivileged(Dispatcher.CreationAction.INSTANCE);
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;
        private final Dispatcher.Initializable dispatcher;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassLoader classLoader = this.classLoader;
            ClassLoader classLoader2 = ((UsingUnsafe) obj).classLoader;
            if (classLoader2 != null) {
                if (classLoader == null || !classLoader.equals(classLoader2)) {
                    return false;
                }
            } else if (classLoader != null) {
                return false;
            }
            ProtectionDomain protectionDomain = this.protectionDomain;
            ProtectionDomain protectionDomain2 = ((UsingUnsafe) obj).protectionDomain;
            if (protectionDomain2 != null) {
                if (protectionDomain == null || !protectionDomain.equals(protectionDomain2)) {
                    return false;
                }
            } else if (protectionDomain != null) {
                return false;
            }
            return this.dispatcher.equals(((UsingUnsafe) obj).dispatcher);
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            if (classLoader != null) {
                hashCode += classLoader.hashCode();
            }
            int i = hashCode * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            if (protectionDomain != null) {
                i += protectionDomain.hashCode();
            }
            return (i * 31) + this.dispatcher.hashCode();
        }

        public UsingUnsafe(ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        public UsingUnsafe(ClassLoader classLoader, ProtectionDomain protectionDomain) {
            this(classLoader, protectionDomain, DISPATCHER);
        }

        protected UsingUnsafe(ClassLoader classLoader, ProtectionDomain protectionDomain, Dispatcher.Initializable dispatcher) {
            this.classLoader = classLoader;
            this.protectionDomain = protectionDomain;
            this.dispatcher = dispatcher;
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return this.dispatcher.isAvailable();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x006d
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                r0 = r8
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable r0 = r0.dispatcher
                net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher r0 = r0.initialize()
                r10 = r0
                java.util.HashMap r0 = new java.util.HashMap
                r1 = r0
                r1.<init>()
                r11 = r0
                r0 = r8
                java.lang.ClassLoader r0 = r0.classLoader
                if (r0 != 0) goto L_0x001f
                java.lang.Object r0 = net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.BOOTSTRAP_LOADER_LOCK
                goto L_0x0023
            L_0x001f:
                r0 = r8
                java.lang.ClassLoader r0 = r0.classLoader
            L_0x0023:
                r1 = r0
                r12 = r1
                monitor-enter(r0)
                r0 = r9
                java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x00a8
                java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x00a8
                r13 = r0
            L_0x0034:
                r0 = r13
                boolean r0 = r0.hasNext()     // Catch: all -> 0x00a8
                if (r0 == 0) goto L_0x00a2
                r0 = r13
                java.lang.Object r0 = r0.next()     // Catch: all -> 0x00a8
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: all -> 0x00a8
                r14 = r0
                r0 = r11
                r1 = r14
                java.lang.Object r1 = r1.getKey()     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                r2 = r14
                java.lang.Object r2 = r2.getKey()     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                java.lang.String r2 = (java.lang.String) r2     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                r3 = 0
                r4 = r8
                java.lang.ClassLoader r4 = r4.classLoader     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                java.lang.Class r2 = java.lang.Class.forName(r2, r3, r4)     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                java.lang.Object r0 = r0.put(r1, r2)     // Catch: ClassNotFoundException -> 0x006d, all -> 0x00a8
                goto L_0x009f
            L_0x006d:
                r15 = move-exception
                r0 = r11
                r1 = r14
                java.lang.Object r1 = r1.getKey()     // Catch: all -> 0x00a8
                r2 = r10
                r3 = r8
                java.lang.ClassLoader r3 = r3.classLoader     // Catch: all -> 0x00a8
                r4 = r14
                java.lang.Object r4 = r4.getKey()     // Catch: all -> 0x00a8
                java.lang.String r4 = (java.lang.String) r4     // Catch: all -> 0x00a8
                r5 = r14
                java.lang.Object r5 = r5.getValue()     // Catch: all -> 0x00a8
                byte[] r5 = (byte[]) r5     // Catch: all -> 0x00a8
                r6 = r8
                java.security.ProtectionDomain r6 = r6.protectionDomain     // Catch: all -> 0x00a8
                java.lang.Class r2 = r2.defineClass(r3, r4, r5, r6)     // Catch: all -> 0x00a8
                java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x00a8
            L_0x009f:
                goto L_0x0034
            L_0x00a2:
                r0 = r12
                monitor-exit(r0)     // Catch: all -> 0x00a8
                goto L_0x00b0
            L_0x00a8:
                r16 = move-exception
                r0 = r12
                monitor-exit(r0)     // Catch: all -> 0x00a8
                r0 = r16
                throw r0
            L_0x00b0:
                r0 = r11
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.injectRaw(java.util.Map):java.util.Map");
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader());
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingUnsafe(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofBootLoader() {
            return new UsingUnsafe(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Dispatcher.class */
        protected interface Dispatcher {

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Dispatcher$Initializable.class */
            public interface Initializable {
                boolean isAvailable();

                Dispatcher initialize();
            }

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Dispatcher$CreationAction.class */
            public enum CreationAction implements PrivilegedAction<Initializable> {
                INSTANCE;

                /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                    jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0068
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                    	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                    */
                @Override // java.security.PrivilegedAction
                @edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback")
                public net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable run() {
                    /*
                    // Method dump skipped, instructions count: 436
                    */
                    throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.CreationAction.run():net.bytebuddy.dynamic.loading.ClassInjector$UsingUnsafe$Dispatcher$Initializable");
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Dispatcher$Enabled.class */
            public static class Enabled implements Dispatcher, Initializable {
                private final Object unsafe;
                private final Method defineClass;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.unsafe.equals(((Enabled) obj).unsafe) && this.defineClass.equals(((Enabled) obj).defineClass);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.unsafe.hashCode()) * 31) + this.defineClass.hashCode();
                }

                protected Enabled(Object unsafe, Method defineClass) {
                    this.unsafe = unsafe;
                    this.defineClass = defineClass;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public boolean isAvailable() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public Dispatcher initialize() {
                    SecurityManager securityManager = System.getSecurityManager();
                    if (securityManager != null) {
                        try {
                            securityManager.checkPermission(ClassInjector.SUPPRESS_ACCESS_CHECKS);
                        } catch (Exception exception) {
                            return new Unavailable(exception.getMessage());
                        }
                    }
                    return this;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    try {
                        return (Class) this.defineClass.invoke(this.unsafe, name, binaryRepresentation, 0, Integer.valueOf(binaryRepresentation.length), classLoader, protectionDomain);
                    } catch (IllegalAccessException exception) {
                        throw new IllegalStateException("Could not access Unsafe::defineClass", exception);
                    } catch (InvocationTargetException exception2) {
                        throw new IllegalStateException("Error invoking Unsafe::defineClass", exception2.getCause());
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Dispatcher$Unavailable.class */
            public static class Unavailable implements Dispatcher, Initializable {
                private final String message;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.message.equals(((Unavailable) obj).message);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.message.hashCode();
                }

                protected Unavailable(String message) {
                    this.message = message;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public boolean isAvailable() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher.Initializable
                public Dispatcher initialize() {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("Could not access Unsafe class: " + this.message);
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Factory.class */
        public static class Factory {
            private final Dispatcher.Initializable dispatcher;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.dispatcher.equals(((Factory) obj).dispatcher);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.dispatcher.hashCode();
            }

            public Factory() {
                this(AccessResolver.Default.INSTANCE);
            }

            @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception is captured to trigger lazy error upon use.")
            public Factory(AccessResolver accessResolver) {
                Dispatcher.Initializable dispatcher;
                if (UsingUnsafe.DISPATCHER.isAvailable()) {
                    dispatcher = UsingUnsafe.DISPATCHER;
                } else {
                    try {
                        Class<?> unsafeType = Class.forName("jdk.internal.misc.Unsafe");
                        Field theUnsafe = unsafeType.getDeclaredField("theUnsafe");
                        accessResolver.apply(theUnsafe);
                        Object unsafe = theUnsafe.get(null);
                        Method defineClass = unsafeType.getMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE, ClassLoader.class, ProtectionDomain.class);
                        accessResolver.apply(defineClass);
                        dispatcher = new Dispatcher.Enabled(unsafe, defineClass);
                    } catch (Exception exception) {
                        dispatcher = new Dispatcher.Unavailable(exception.getMessage());
                    }
                }
                this.dispatcher = dispatcher;
            }

            protected Factory(Dispatcher.Initializable dispatcher) {
                this.dispatcher = dispatcher;
            }

            public static Factory resolve(Instrumentation instrumentation) {
                return resolve(instrumentation, false);
            }

            @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception intends to trigger disabled injection strategy.")
            public static Factory resolve(Instrumentation instrumentation, boolean local) {
                if (UsingUnsafe.isAvailable() || !JavaModule.isSupported()) {
                    return new Factory();
                }
                try {
                    Class<?> type = Class.forName("jdk.internal.misc.Unsafe");
                    PackageDescription packageDescription = new PackageDescription.ForLoadedPackage(type.getPackage());
                    JavaModule source = JavaModule.ofType(type);
                    if (source.isOpened(packageDescription, JavaModule.ofType(UsingUnsafe.class))) {
                        return new Factory();
                    }
                    if (local) {
                        JavaModule module = JavaModule.ofType(AccessResolver.Default.class);
                        UsingInstrumentation.redefineModule(instrumentation, source, Collections.singleton(module), Collections.emptyMap(), Collections.singletonMap(packageDescription.getName(), Collections.singleton(module)), Collections.emptySet(), Collections.emptyMap());
                        return new Factory();
                    }
                    Class<? extends AccessResolver> resolver = new ByteBuddy().subclass(AccessResolver.class).method(ElementMatchers.named("apply")).intercept(MethodCall.invoke(AccessibleObject.class.getMethod("setAccessible", Boolean.TYPE)).onArgument(0).with(true)).make().load(AccessResolver.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER.with(AccessResolver.class.getProtectionDomain())).getLoaded();
                    JavaModule module2 = JavaModule.ofType(resolver);
                    UsingInstrumentation.redefineModule(instrumentation, source, Collections.singleton(module2), Collections.emptyMap(), Collections.singletonMap(packageDescription.getName(), Collections.singleton(module2)), Collections.emptySet(), Collections.emptyMap());
                    return new Factory((AccessResolver) resolver.getConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception exception) {
                    return new Factory(new Dispatcher.Unavailable(exception.getMessage()));
                }
            }

            public boolean isAvailable() {
                return this.dispatcher.isAvailable();
            }

            public ClassInjector make(ClassLoader classLoader) {
                return make(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
            }

            public ClassInjector make(ClassLoader classLoader, ProtectionDomain protectionDomain) {
                return new UsingUnsafe(classLoader, protectionDomain, this.dispatcher);
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Factory$AccessResolver.class */
            public interface AccessResolver {
                void apply(AccessibleObject accessibleObject);

                /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingUnsafe$Factory$AccessResolver$Default.class */
                public enum Default implements AccessResolver {
                    INSTANCE;

                    @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingUnsafe.Factory.AccessResolver
                    public void apply(AccessibleObject accessibleObject) {
                        accessibleObject.setAccessible(true);
                    }
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingInstrumentation.class */
    public static class UsingInstrumentation extends AbstractBase {
        private static final String JAR = "jar";
        private static final String CLASS_FILE_EXTENSION = ".class";
        private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
        private final Instrumentation instrumentation;
        private final Target target;
        private final File folder;
        private final RandomString randomString;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingInstrumentation$Dispatcher.class */
        public interface Dispatcher {
            void appendToBootstrapClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            void appendToSystemClassLoaderSearch(Instrumentation instrumentation, JarFile jarFile);

            boolean isModifiableModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj);

            void redefineModule(Instrumentation instrumentation, @JavaDispatcher.Proxied("java.lang.Module") Object obj, Set<?> set, Map<String, Set<?>> map, Map<String, Set<?>> map2, Set<Class<?>> set2, Map<Class<?>, List<Class<?>>> map3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.target.equals(((UsingInstrumentation) obj).target) && this.instrumentation.equals(((UsingInstrumentation) obj).instrumentation) && this.folder.equals(((UsingInstrumentation) obj).folder) && this.randomString.equals(((UsingInstrumentation) obj).randomString);
        }

        public int hashCode() {
            return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.target.hashCode()) * 31) + this.folder.hashCode()) * 31) + this.randomString.hashCode();
        }

        protected UsingInstrumentation(File folder, Target target, Instrumentation instrumentation, RandomString randomString) {
            this.folder = folder;
            this.target = target;
            this.instrumentation = instrumentation;
            this.randomString = randomString;
        }

        public static void redefineModule(Instrumentation instrumentation, JavaModule target, Set<JavaModule> reads, Map<String, Set<JavaModule>> exports, Map<String, Set<JavaModule>> opens, Set<Class<?>> uses, Map<Class<?>, List<Class<?>>> provides) {
            if (!DISPATCHER.isModifiableModule(instrumentation, target.unwrap())) {
                throw new IllegalArgumentException("Cannot modify module: " + target);
            }
            Set<Object> unwrappedReads = new HashSet<>();
            for (JavaModule read : reads) {
                unwrappedReads.add(read.unwrap());
            }
            Map<String, Set<?>> unwrappedExports = new HashMap<>();
            for (Map.Entry<String, Set<JavaModule>> entry : exports.entrySet()) {
                Set<Object> modules = new HashSet<>();
                for (JavaModule module : entry.getValue()) {
                    modules.add(module.unwrap());
                }
                unwrappedExports.put(entry.getKey(), modules);
            }
            Map<String, Set<?>> unwrappedOpens = new HashMap<>();
            for (Map.Entry<String, Set<JavaModule>> entry2 : opens.entrySet()) {
                Set<Object> modules2 = new HashSet<>();
                for (JavaModule module2 : entry2.getValue()) {
                    modules2.add(module2.unwrap());
                }
                unwrappedOpens.put(entry2.getKey(), modules2);
            }
            DISPATCHER.redefineModule(instrumentation, target.unwrap(), unwrappedReads, unwrappedExports, unwrappedOpens, uses, provides);
        }

        /* renamed from: of */
        public static ClassInjector m220of(File folder, Target target, Instrumentation instrumentation) {
            return new UsingInstrumentation(folder, target, instrumentation, new RandomString());
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return isAvailable();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x00f3
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
            // Method dump skipped, instructions count: 383
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.injectRaw(java.util.Map):java.util.Map");
        }

        public static boolean isAvailable() {
            return ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V6);
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingInstrumentation$Target.class */
        public enum Target {
            BOOTSTRAP(null) {
                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target
                protected void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToBootstrapClassLoaderSearch(instrumentation, jarFile);
                }
            },
            SYSTEM(ClassLoader.getSystemClassLoader()) {
                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingInstrumentation.Target
                protected void inject(Instrumentation instrumentation, JarFile jarFile) {
                    UsingInstrumentation.DISPATCHER.appendToSystemClassLoaderSearch(instrumentation, jarFile);
                }
            };
            
            private final ClassLoader classLoader;

            protected abstract void inject(Instrumentation instrumentation, JarFile jarFile);

            Target(ClassLoader classLoader) {
                this.classLoader = classLoader;
            }

            protected ClassLoader getClassLoader() {
                return this.classLoader;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna.class */
    public static class UsingJna extends AbstractBase {
        private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(Dispatcher.CreationAction.INSTANCE);
        private static final Object BOOTSTRAP_LOADER_LOCK = new Object();
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ClassLoader classLoader;
        @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
        private final ProtectionDomain protectionDomain;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ClassLoader classLoader = this.classLoader;
            ClassLoader classLoader2 = ((UsingJna) obj).classLoader;
            if (classLoader2 != null) {
                if (classLoader == null || !classLoader.equals(classLoader2)) {
                    return false;
                }
            } else if (classLoader != null) {
                return false;
            }
            ProtectionDomain protectionDomain = this.protectionDomain;
            ProtectionDomain protectionDomain2 = ((UsingJna) obj).protectionDomain;
            return protectionDomain2 != null ? protectionDomain != null && protectionDomain.equals(protectionDomain2) : protectionDomain == null;
        }

        public int hashCode() {
            int hashCode = getClass().hashCode() * 31;
            ClassLoader classLoader = this.classLoader;
            if (classLoader != null) {
                hashCode += classLoader.hashCode();
            }
            int i = hashCode * 31;
            ProtectionDomain protectionDomain = this.protectionDomain;
            return protectionDomain != null ? i + protectionDomain.hashCode() : i;
        }

        public UsingJna(ClassLoader classLoader) {
            this(classLoader, ClassLoadingStrategy.NO_PROTECTION_DOMAIN);
        }

        public UsingJna(ClassLoader classLoader, ProtectionDomain protectionDomain) {
            this.classLoader = classLoader;
            this.protectionDomain = protectionDomain;
        }

        public static boolean isAvailable() {
            return DISPATCHER.isAvailable();
        }

        public static ClassInjector ofSystemLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader());
        }

        public static ClassInjector ofPlatformLoader() {
            return new UsingJna(ClassLoader.getSystemClassLoader().getParent());
        }

        public static ClassInjector ofBootLoader() {
            return new UsingJna(ClassLoadingStrategy.BOOTSTRAP_LOADER);
        }

        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public boolean isAlive() {
            return DISPATCHER.isAvailable();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0062
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // net.bytebuddy.dynamic.loading.ClassInjector
        public java.util.Map<java.lang.String, java.lang.Class<?>> injectRaw(java.util.Map<? extends java.lang.String, byte[]> r9) {
            /*
                r8 = this;
                java.util.HashMap r0 = new java.util.HashMap
                r1 = r0
                r1.<init>()
                r10 = r0
                r0 = r8
                java.lang.ClassLoader r0 = r0.classLoader
                if (r0 != 0) goto L_0x0015
                java.lang.Object r0 = net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.BOOTSTRAP_LOADER_LOCK
                goto L_0x0019
            L_0x0015:
                r0 = r8
                java.lang.ClassLoader r0 = r0.classLoader
            L_0x0019:
                r1 = r0
                r11 = r1
                monitor-enter(r0)
                r0 = r9
                java.util.Set r0 = r0.entrySet()     // Catch: all -> 0x009e
                java.util.Iterator r0 = r0.iterator()     // Catch: all -> 0x009e
                r12 = r0
            L_0x0029:
                r0 = r12
                boolean r0 = r0.hasNext()     // Catch: all -> 0x009e
                if (r0 == 0) goto L_0x0099
                r0 = r12
                java.lang.Object r0 = r0.next()     // Catch: all -> 0x009e
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: all -> 0x009e
                r13 = r0
                r0 = r10
                r1 = r13
                java.lang.Object r1 = r1.getKey()     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                r2 = r13
                java.lang.Object r2 = r2.getKey()     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                java.lang.String r2 = (java.lang.String) r2     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                r3 = 0
                r4 = r8
                java.lang.ClassLoader r4 = r4.classLoader     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                java.lang.Class r2 = java.lang.Class.forName(r2, r3, r4)     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                java.lang.Object r0 = r0.put(r1, r2)     // Catch: ClassNotFoundException -> 0x0062, all -> 0x009e
                goto L_0x0096
            L_0x0062:
                r14 = move-exception
                r0 = r10
                r1 = r13
                java.lang.Object r1 = r1.getKey()     // Catch: all -> 0x009e
                net.bytebuddy.dynamic.loading.ClassInjector$UsingJna$Dispatcher r2 = net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.DISPATCHER     // Catch: all -> 0x009e
                r3 = r8
                java.lang.ClassLoader r3 = r3.classLoader     // Catch: all -> 0x009e
                r4 = r13
                java.lang.Object r4 = r4.getKey()     // Catch: all -> 0x009e
                java.lang.String r4 = (java.lang.String) r4     // Catch: all -> 0x009e
                r5 = r13
                java.lang.Object r5 = r5.getValue()     // Catch: all -> 0x009e
                byte[] r5 = (byte[]) r5     // Catch: all -> 0x009e
                r6 = r8
                java.security.ProtectionDomain r6 = r6.protectionDomain     // Catch: all -> 0x009e
                java.lang.Class r2 = r2.defineClass(r3, r4, r5, r6)     // Catch: all -> 0x009e
                java.lang.Object r0 = r0.put(r1, r2)     // Catch: all -> 0x009e
            L_0x0096:
                goto L_0x0029
            L_0x0099:
                r0 = r11
                monitor-exit(r0)     // Catch: all -> 0x009e
                goto L_0x00a5
            L_0x009e:
                r15 = move-exception
                r0 = r11
                monitor-exit(r0)     // Catch: all -> 0x009e
                r0 = r15
                throw r0
            L_0x00a5:
                r0 = r10
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.injectRaw(java.util.Map):java.util.Map");
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher.class */
        protected interface Dispatcher {

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher$Jvm.class */
            public interface Jvm extends Library {
                Class<?> JVM_DefineClass(JNIEnv jNIEnv, String str, ClassLoader classLoader, byte[] bArr, int i, ProtectionDomain protectionDomain) throws LastErrorException;
            }

            boolean isAvailable();

            Class<?> defineClass(ClassLoader classLoader, String str, byte[] bArr, ProtectionDomain protectionDomain);

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher$CreationAction.class */
            public enum CreationAction implements PrivilegedAction<Dispatcher> {
                INSTANCE;

                @Override // java.security.PrivilegedAction
                public Dispatcher run() {
                    if (System.getProperty("java.vm.name", "").toUpperCase(Locale.US).contains("J9")) {
                        return new Unavailable("J9 does not support JNA-based class definition");
                    }
                    try {
                        Map<String, Object> options = new HashMap<>();
                        options.put(Library.OPTION_ALLOW_OBJECTS, Boolean.TRUE);
                        if (Platform.isWindows() && !Platform.is64Bit()) {
                            options.put(Library.OPTION_FUNCTION_MAPPER, Windows32BitFunctionMapper.INSTANCE);
                        }
                        return new Enabled((Jvm) Native.loadLibrary("jvm", Jvm.class, options));
                    } catch (Throwable throwable) {
                        return new Unavailable(throwable.getMessage());
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher$Windows32BitFunctionMapper.class */
            public enum Windows32BitFunctionMapper implements FunctionMapper {
                INSTANCE;

                @Override // com.sun.jna.FunctionMapper
                public String getFunctionName(NativeLibrary library, Method method) {
                    if (method.getName().equals("JVM_DefineClass")) {
                        return "_JVM_DefineClass@24";
                    }
                    return method.getName();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher$Enabled.class */
            public static class Enabled implements Dispatcher {
                private final Jvm jvm;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.jvm.equals(((Enabled) obj).jvm);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.jvm.hashCode();
                }

                protected Enabled(Jvm jvm) {
                    this.jvm = jvm;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public boolean isAvailable() {
                    return true;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    return this.jvm.JVM_DefineClass(JNIEnv.CURRENT, name.replace('.', '/'), classLoader, binaryRepresentation, binaryRepresentation.length, protectionDomain);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassInjector$UsingJna$Dispatcher$Unavailable.class */
            public static class Unavailable implements Dispatcher {
                private final String error;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.error.equals(((Unavailable) obj).error);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.error.hashCode();
                }

                protected Unavailable(String error) {
                    this.error = error;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public boolean isAvailable() {
                    return false;
                }

                @Override // net.bytebuddy.dynamic.loading.ClassInjector.UsingJna.Dispatcher
                public Class<?> defineClass(ClassLoader classLoader, String name, byte[] binaryRepresentation, ProtectionDomain protectionDomain) {
                    throw new UnsupportedOperationException("JNA is not available and JNA-based injection cannot be used: " + this.error);
                }
            }
        }
    }
}
