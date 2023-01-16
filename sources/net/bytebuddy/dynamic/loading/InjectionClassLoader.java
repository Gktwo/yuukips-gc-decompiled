package net.bytebuddy.dynamic.loading;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/InjectionClassLoader.class */
public abstract class InjectionClassLoader extends ClassLoader {
    private final boolean sealed;

    protected abstract Map<String, Class<?>> doDefineClasses(Map<String, byte[]> map) throws ClassNotFoundException;

    static {
        doRegisterAsParallelCapable();
    }

    @SuppressFBWarnings(value = {"DP_DO_INSIDE_DO_PRIVILEGED"}, justification = "Must be invoked from targeting ClassLoader class.")
    private static void doRegisterAsParallelCapable() {
        try {
            Method method = ClassLoader.class.getDeclaredMethod("registerAsParallelCapable", new Class[0]);
            method.setAccessible(true);
            method.invoke(null, new Object[0]);
        } catch (Throwable th) {
        }
    }

    /* access modifiers changed from: protected */
    public InjectionClassLoader(ClassLoader parent, boolean sealed) {
        super(parent);
        this.sealed = sealed;
    }

    public boolean isSealed() {
        return this.sealed;
    }

    public Class<?> defineClass(String name, byte[] binaryRepresentation) throws ClassNotFoundException {
        return defineClasses(Collections.singletonMap(name, binaryRepresentation)).get(name);
    }

    public Map<String, Class<?>> defineClasses(Map<String, byte[]> typeDefinitions) throws ClassNotFoundException {
        if (!this.sealed) {
            return doDefineClasses(typeDefinitions);
        }
        throw new IllegalStateException("Cannot inject classes into a sealed class loader");
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/dynamic/loading/InjectionClassLoader$Strategy.class */
    public enum Strategy implements ClassLoadingStrategy<InjectionClassLoader> {
        INSTANCE;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.ClassLoader, java.util.Map] */
        @Override // net.bytebuddy.dynamic.loading.ClassLoadingStrategy
        public /* bridge */ /* synthetic */ Map load(InjectionClassLoader injectionClassLoader, Map map) {
            return load(injectionClassLoader, (Map<TypeDescription, byte[]>) map);
        }

        public Map<TypeDescription, Class<?>> load(InjectionClassLoader classLoader, Map<TypeDescription, byte[]> types) {
            if (classLoader == null) {
                throw new IllegalArgumentException("Cannot add types to bootstrap class loader: " + types);
            }
            Map<String, byte[]> typeDefinitions = new LinkedHashMap<>();
            Map<String, TypeDescription> typeDescriptions = new HashMap<>();
            for (Map.Entry<TypeDescription, byte[]> entry : types.entrySet()) {
                typeDefinitions.put(entry.getKey().getName(), entry.getValue());
                typeDescriptions.put(entry.getKey().getName(), entry.getKey());
            }
            Map<TypeDescription, Class<?>> loadedTypes = new HashMap<>();
            try {
                for (Map.Entry<String, Class<?>> entry2 : classLoader.defineClasses(typeDefinitions).entrySet()) {
                    loadedTypes.put(typeDescriptions.get(entry2.getKey()), entry2.getValue());
                }
                return loadedTypes;
            } catch (ClassNotFoundException exception) {
                throw new IllegalStateException("Cannot load classes: " + types, exception);
            }
        }
    }
}
