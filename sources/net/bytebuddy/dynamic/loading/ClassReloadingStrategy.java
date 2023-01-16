package net.bytebuddy.dynamic.loading;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.File;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.security.AccessController;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.loading.ClassInjector;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy.class */
public class ClassReloadingStrategy implements ClassLoadingStrategy<ClassLoader> {
    private static final String INSTALLER_TYPE = "net.bytebuddy.agent.Installer";
    private static final String INSTRUMENTATION_GETTER = "getInstrumentation";
    private static final Object STATIC_MEMBER = null;
    protected static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
    private final Instrumentation instrumentation;
    private final Strategy strategy;
    private final BootstrapInjection bootstrapInjection;
    private final Map<String, Class<?>> preregisteredTypes;

    /* access modifiers changed from: protected */
    @JavaDispatcher.Proxied("java.lang.instrument.Instrumentation")
    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$Dispatcher.class */
    public interface Dispatcher {
        boolean isModifiableClass(Instrumentation instrumentation, Class<?> cls);

        boolean isRetransformClassesSupported(Instrumentation instrumentation);

        void addTransformer(Instrumentation instrumentation, ClassFileTransformer classFileTransformer, boolean z);

        void retransformClasses(Instrumentation instrumentation, Class<?>[] clsArr) throws UnmodifiableClassException;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.strategy.equals(((ClassReloadingStrategy) obj).strategy) && this.instrumentation.equals(((ClassReloadingStrategy) obj).instrumentation) && this.bootstrapInjection.equals(((ClassReloadingStrategy) obj).bootstrapInjection) && this.preregisteredTypes.equals(((ClassReloadingStrategy) obj).preregisteredTypes);
    }

    public int hashCode() {
        return (((((((getClass().hashCode() * 31) + this.instrumentation.hashCode()) * 31) + this.strategy.hashCode()) * 31) + this.bootstrapInjection.hashCode()) * 31) + this.preregisteredTypes.hashCode();
    }

    public ClassReloadingStrategy(Instrumentation instrumentation, Strategy strategy) {
        this(instrumentation, strategy, BootstrapInjection.Disabled.INSTANCE, Collections.emptyMap());
    }

    protected ClassReloadingStrategy(Instrumentation instrumentation, Strategy strategy, BootstrapInjection bootstrapInjection, Map<String, Class<?>> preregisteredTypes) {
        this.instrumentation = instrumentation;
        this.strategy = strategy.validate(instrumentation);
        this.bootstrapInjection = bootstrapInjection;
        this.preregisteredTypes = preregisteredTypes;
    }

    /* renamed from: of */
    public static ClassReloadingStrategy m216of(Instrumentation instrumentation) {
        if (DISPATCHER.isRetransformClassesSupported(instrumentation)) {
            return new ClassReloadingStrategy(instrumentation, Strategy.RETRANSFORMATION);
        }
        if (instrumentation.isRedefineClassesSupported()) {
            return new ClassReloadingStrategy(instrumentation, Strategy.REDEFINITION);
        }
        throw new IllegalArgumentException("Instrumentation does not support reloading of classes: " + instrumentation);
    }

    public static ClassReloadingStrategy fromInstalledAgent() {
        try {
            return m216of((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]));
        } catch (RuntimeException exception) {
            throw exception;
        } catch (Exception exception2) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception2);
        }
    }

    public static ClassReloadingStrategy fromInstalledAgent(Strategy strategy) {
        try {
            return new ClassReloadingStrategy((Instrumentation) ClassLoader.getSystemClassLoader().loadClass(INSTALLER_TYPE).getMethod(INSTRUMENTATION_GETTER, new Class[0]).invoke(STATIC_MEMBER, new Object[0]), strategy);
        } catch (RuntimeException exception) {
            throw exception;
        } catch (Exception exception2) {
            throw new IllegalStateException("The Byte Buddy agent is not installed or not accessible", exception2);
        }
    }

    @Override // net.bytebuddy.dynamic.loading.ClassLoadingStrategy
    public Map<TypeDescription, Class<?>> load(ClassLoader classLoader, Map<TypeDescription, byte[]> types) {
        Map<String, Class<?>> availableTypes = new HashMap<>(this.preregisteredTypes);
        Class<?>[] initiatedClasses = this.instrumentation.getInitiatedClasses(classLoader);
        for (Class<?> type : initiatedClasses) {
            availableTypes.put(TypeDescription.ForLoadedType.getName(type), type);
        }
        Map<Class<?>, ClassDefinition> classDefinitions = new ConcurrentHashMap<>();
        Map<TypeDescription, Class<?>> loadedClasses = new HashMap<>();
        Map<TypeDescription, byte[]> unloadedClasses = new LinkedHashMap<>();
        for (Map.Entry<TypeDescription, byte[]> entry : types.entrySet()) {
            Class<?> type2 = availableTypes.get(entry.getKey().getName());
            if (type2 != null) {
                classDefinitions.put(type2, new ClassDefinition(type2, entry.getValue()));
                loadedClasses.put(entry.getKey(), type2);
            } else {
                unloadedClasses.put(entry.getKey(), entry.getValue());
            }
        }
        try {
            this.strategy.apply(this.instrumentation, classDefinitions);
            if (!unloadedClasses.isEmpty()) {
                loadedClasses.putAll((classLoader == null ? this.bootstrapInjection.make(this.instrumentation) : new ClassInjector.UsingReflection(classLoader)).inject(unloadedClasses));
            }
            return loadedClasses;
        } catch (UnmodifiableClassException exception) {
            throw new IllegalStateException("Cannot redefine specified class", exception);
        } catch (ClassNotFoundException exception2) {
            throw new IllegalArgumentException("Could not locate classes for redefinition", exception2);
        }
    }

    public ClassReloadingStrategy reset(Class<?>... type) throws IOException {
        return type.length == 0 ? this : reset(ClassFileLocator.ForClassLoader.m232of(type[0].getClassLoader()), type);
    }

    public ClassReloadingStrategy reset(ClassFileLocator classFileLocator, Class<?>... type) throws IOException {
        if (type.length > 0) {
            try {
                this.strategy.reset(this.instrumentation, classFileLocator, Arrays.asList(type));
            } catch (ClassNotFoundException exception) {
                throw new IllegalArgumentException("Cannot locate types " + Arrays.toString(type), exception);
            } catch (UnmodifiableClassException exception2) {
                throw new IllegalStateException("Cannot reset types " + Arrays.toString(type), exception2);
            }
        }
        return this;
    }

    public ClassReloadingStrategy enableBootstrapInjection(File folder) {
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, new BootstrapInjection.Enabled(folder), this.preregisteredTypes);
    }

    public ClassReloadingStrategy preregistered(Class<?>... type) {
        Map<String, Class<?>> preregisteredTypes = new HashMap<>(this.preregisteredTypes);
        for (Class<?> aType : type) {
            preregisteredTypes.put(TypeDescription.ForLoadedType.getName(aType), aType);
        }
        return new ClassReloadingStrategy(this.instrumentation, this.strategy, this.bootstrapInjection, preregisteredTypes);
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$Strategy.class */
    public enum Strategy {
        REDEFINITION(true) {
            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            protected void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> classDefinitions) throws UnmodifiableClassException, ClassNotFoundException {
                instrumentation.redefineClasses((ClassDefinition[]) classDefinitions.values().toArray(new ClassDefinition[0]));
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            protected Strategy validate(Instrumentation instrumentation) {
                if (instrumentation.isRedefineClassesSupported()) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support redefinition: " + instrumentation);
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> types) throws IOException, UnmodifiableClassException, ClassNotFoundException {
                Map<Class<?>, ClassDefinition> classDefinitions = new HashMap<>(types.size());
                for (Class<?> type : types) {
                    classDefinitions.put(type, new ClassDefinition(type, classFileLocator.locate(TypeDescription.ForLoadedType.getName(type)).resolve()));
                }
                apply(instrumentation, classDefinitions);
            }
        },
        RETRANSFORMATION(false) {
            /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
                jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x003f
                	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
                	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
                */
            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            protected void apply(java.lang.instrument.Instrumentation r6, java.util.Map<java.lang.Class<?>, java.lang.instrument.ClassDefinition> r7) throws java.lang.instrument.UnmodifiableClassException {
                /*
                    r5 = this;
                    net.bytebuddy.dynamic.loading.ClassReloadingStrategy$Strategy$ClassRedefinitionTransformer r0 = new net.bytebuddy.dynamic.loading.ClassReloadingStrategy$Strategy$ClassRedefinitionTransformer
                    r1 = r0
                    r2 = r7
                    r1.<init>(r2)
                    r8 = r0
                    r0 = r5
                    r1 = r0
                    r9 = r1
                    monitor-enter(r0)
                    net.bytebuddy.dynamic.loading.ClassReloadingStrategy$Dispatcher r0 = net.bytebuddy.dynamic.loading.ClassReloadingStrategy.DISPATCHER     // Catch: all -> 0x0052
                    r1 = r6
                    r2 = r8
                    r3 = 1
                    r0.addTransformer(r1, r2, r3)     // Catch: all -> 0x0052
                    net.bytebuddy.dynamic.loading.ClassReloadingStrategy$Dispatcher r0 = net.bytebuddy.dynamic.loading.ClassReloadingStrategy.DISPATCHER     // Catch: all -> 0x003f, all -> 0x0052
                    r1 = r6
                    r2 = r7
                    java.util.Set r2 = r2.keySet()     // Catch: all -> 0x003f, all -> 0x0052
                    r3 = 0
                    java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch: all -> 0x003f, all -> 0x0052
                    java.lang.Object[] r2 = r2.toArray(r3)     // Catch: all -> 0x003f, all -> 0x0052
                    java.lang.Class[] r2 = (java.lang.Class[]) r2     // Catch: all -> 0x003f, all -> 0x0052
                    r0.retransformClasses(r1, r2)     // Catch: all -> 0x003f, all -> 0x0052
                    r0 = r6
                    r1 = r8
                    boolean r0 = r0.removeTransformer(r1)     // Catch: all -> 0x0052
                    goto L_0x004c
                L_0x003f:
                    r10 = move-exception
                    r0 = r6
                    r1 = r8
                    boolean r0 = r0.removeTransformer(r1)     // Catch: all -> 0x0052
                    r0 = r10
                    throw r0     // Catch: all -> 0x0052
                L_0x004c:
                    r0 = r9
                    monitor-exit(r0)     // Catch: all -> 0x0052
                    goto L_0x005a
                L_0x0052:
                    r11 = move-exception
                    r0 = r9
                    monitor-exit(r0)     // Catch: all -> 0x0052
                    r0 = r11
                    throw r0
                L_0x005a:
                    r0 = r8
                    r0.assertTransformation()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy.C53432.apply(java.lang.instrument.Instrumentation, java.util.Map):void");
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            protected Strategy validate(Instrumentation instrumentation) {
                if (ClassReloadingStrategy.DISPATCHER.isRetransformClassesSupported(instrumentation)) {
                    return this;
                }
                throw new IllegalArgumentException("Does not support retransformation: " + instrumentation);
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy
            public void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> types) throws UnmodifiableClassException, ClassNotFoundException {
                for (Class<?> type : types) {
                    if (!ClassReloadingStrategy.DISPATCHER.isModifiableClass(instrumentation, type)) {
                        throw new IllegalArgumentException("Cannot modify type: " + type);
                    }
                }
                ClassReloadingStrategy.DISPATCHER.addTransformer(instrumentation, ClassResettingTransformer.INSTANCE, true);
                try {
                    ClassReloadingStrategy.DISPATCHER.retransformClasses(instrumentation, (Class[]) types.toArray(new Class[0]));
                    instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
                } catch (Throwable th) {
                    instrumentation.removeTransformer(ClassResettingTransformer.INSTANCE);
                    throw th;
                }
            }
        };
        
        private static final byte[] NO_REDEFINITION = null;
        private static final boolean REDEFINE_CLASSES = true;
        private final boolean redefinition;

        protected abstract void apply(Instrumentation instrumentation, Map<Class<?>, ClassDefinition> map) throws UnmodifiableClassException, ClassNotFoundException;

        protected abstract Strategy validate(Instrumentation instrumentation);

        public abstract void reset(Instrumentation instrumentation, ClassFileLocator classFileLocator, List<Class<?>> list) throws IOException, UnmodifiableClassException, ClassNotFoundException;

        Strategy(boolean redefinition) {
            this.redefinition = redefinition;
        }

        public boolean isRedefinition() {
            return this.redefinition;
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$Strategy$ClassRedefinitionTransformer.class */
        protected static class ClassRedefinitionTransformer implements ClassFileTransformer {
            private final Map<Class<?>, ClassDefinition> redefinedClasses;

            protected ClassRedefinitionTransformer(Map<Class<?>, ClassDefinition> redefinedClasses) {
                this.redefinedClasses = redefinedClasses;
            }

            @SuppressFBWarnings(value = {"EI_EXPOSE_REP"}, justification = "Value is always null")
            public byte[] transform(ClassLoader classLoader, String internalTypeName, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
                ClassDefinition redefinedClass;
                if (!(internalTypeName == null || (redefinedClass = this.redefinedClasses.remove(classBeingRedefined)) == null)) {
                    return redefinedClass.getDefinitionClassFile();
                }
                return Strategy.NO_REDEFINITION;
            }

            public void assertTransformation() {
                if (!this.redefinedClasses.isEmpty()) {
                    throw new IllegalStateException("Could not transform: " + this.redefinedClasses.keySet());
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$Strategy$ClassResettingTransformer.class */
        protected enum ClassResettingTransformer implements ClassFileTransformer {
            INSTANCE;

            public byte[] transform(ClassLoader classLoader, String internalTypeName, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
                return Strategy.NO_REDEFINITION;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$BootstrapInjection.class */
    protected interface BootstrapInjection {
        ClassInjector make(Instrumentation instrumentation);

        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$BootstrapInjection$Disabled.class */
        public enum Disabled implements BootstrapInjection {
            INSTANCE;

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.BootstrapInjection
            public ClassInjector make(Instrumentation instrumentation) {
                throw new IllegalStateException("Bootstrap injection is not enabled");
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/ClassReloadingStrategy$BootstrapInjection$Enabled.class */
        public static class Enabled implements BootstrapInjection {
            private final File folder;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.folder.equals(((Enabled) obj).folder);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.folder.hashCode();
            }

            protected Enabled(File folder) {
                this.folder = folder;
            }

            @Override // net.bytebuddy.dynamic.loading.ClassReloadingStrategy.BootstrapInjection
            public ClassInjector make(Instrumentation instrumentation) {
                return ClassInjector.UsingInstrumentation.m220of(this.folder, ClassInjector.UsingInstrumentation.Target.BOOTSTRAP, instrumentation);
            }
        }
    }
}
