package com.esotericsoftware.reflectasm;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.WeakHashMap;

/* loaded from: grasscutter.jar:com/esotericsoftware/reflectasm/AccessClassLoader.class */
class AccessClassLoader extends ClassLoader {
    private static final WeakHashMap<ClassLoader, WeakReference<AccessClassLoader>> accessClassLoaders = new WeakHashMap<>();
    private static final ClassLoader selfContextParentClassLoader = getParentClassLoader(AccessClassLoader.class);
    private static volatile AccessClassLoader selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
    private static volatile Method defineClassMethod;
    private final HashSet<String> localClassNames = new HashSet<>();

    private AccessClassLoader(ClassLoader parent) {
        super(parent);
    }

    /* access modifiers changed from: package-private */
    public Class loadAccessClass(String name) {
        if (!this.localClassNames.contains(name)) {
            return null;
        }
        try {
            return loadClass(name, false);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /* access modifiers changed from: package-private */
    public Class defineAccessClass(String name, byte[] bytes) throws ClassFormatError {
        this.localClassNames.add(name);
        return defineClass(name, bytes);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        return name.equals(FieldAccess.class.getName()) ? FieldAccess.class : name.equals(MethodAccess.class.getName()) ? MethodAccess.class : name.equals(ConstructorAccess.class.getName()) ? ConstructorAccess.class : name.equals(PublicConstructorAccess.class.getName()) ? PublicConstructorAccess.class : loadClass(name, resolve);
    }

    Class<?> defineClass(String name, byte[] bytes) throws ClassFormatError {
        try {
            return (Class) getDefineClassMethod().invoke(getParent(), name, bytes, 0, Integer.valueOf(bytes.length), getClass().getProtectionDomain());
        } catch (Exception e) {
            return defineClass(name, bytes, 0, bytes.length, getClass().getProtectionDomain());
        }
    }

    /* access modifiers changed from: package-private */
    public static boolean areInSameRuntimeClassLoader(Class type1, Class type2) {
        if (type1.getPackage() != type2.getPackage()) {
            return false;
        }
        ClassLoader loader1 = type1.getClassLoader();
        ClassLoader loader2 = type2.getClassLoader();
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        return loader1 == null ? loader2 == null || loader2 == systemClassLoader : loader2 == null ? loader1 == systemClassLoader : loader1 == loader2;
    }

    private static ClassLoader getParentClassLoader(Class type) {
        ClassLoader parent = type.getClassLoader();
        if (parent == null) {
            parent = ClassLoader.getSystemClassLoader();
        }
        return parent;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0045
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static java.lang.reflect.Method getDefineClassMethod() throws java.lang.Exception {
        /*
            java.lang.reflect.Method r0 = com.esotericsoftware.reflectasm.AccessClassLoader.defineClassMethod
            if (r0 != 0) goto L_0x0050
            java.util.WeakHashMap<java.lang.ClassLoader, java.lang.ref.WeakReference<com.esotericsoftware.reflectasm.AccessClassLoader>> r0 = com.esotericsoftware.reflectasm.AccessClassLoader.accessClassLoaders
            r1 = r0
            r7 = r1
            monitor-enter(r0)
            java.lang.reflect.Method r0 = com.esotericsoftware.reflectasm.AccessClassLoader.defineClassMethod     // Catch: all -> 0x004b
            if (r0 != 0) goto L_0x0046
            java.lang.Class<java.lang.ClassLoader> r0 = java.lang.ClassLoader.class
            java.lang.String r1 = "defineClass"
            r2 = 5
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: all -> 0x004b
            r3 = r2
            r4 = 0
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r3[r4] = r5     // Catch: all -> 0x004b
            r3 = r2
            r4 = 1
            java.lang.Class<byte[]> r5 = byte[].class
            r3[r4] = r5     // Catch: all -> 0x004b
            r3 = r2
            r4 = 2
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: all -> 0x004b
            r3[r4] = r5     // Catch: all -> 0x004b
            r3 = r2
            r4 = 3
            java.lang.Class r5 = java.lang.Integer.TYPE     // Catch: all -> 0x004b
            r3[r4] = r5     // Catch: all -> 0x004b
            r3 = r2
            r4 = 4
            java.lang.Class<java.security.ProtectionDomain> r5 = java.security.ProtectionDomain.class
            r3[r4] = r5     // Catch: all -> 0x004b
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: all -> 0x004b
            com.esotericsoftware.reflectasm.AccessClassLoader.defineClassMethod = r0     // Catch: all -> 0x004b
            java.lang.reflect.Method r0 = com.esotericsoftware.reflectasm.AccessClassLoader.defineClassMethod     // Catch: all -> 0x004b, Exception -> 0x0045
            r1 = 1
            r0.setAccessible(r1)     // Catch: all -> 0x004b, Exception -> 0x0045
            goto L_0x0046
        L_0x0045:
            r8 = move-exception
        L_0x0046:
            r0 = r7
            monitor-exit(r0)     // Catch: all -> 0x004b
            goto L_0x0050
        L_0x004b:
            r9 = move-exception
            r0 = r7
            monitor-exit(r0)     // Catch: all -> 0x004b
            r0 = r9
            throw r0
        L_0x0050:
            java.lang.reflect.Method r0 = com.esotericsoftware.reflectasm.AccessClassLoader.defineClassMethod
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.esotericsoftware.reflectasm.AccessClassLoader.getDefineClassMethod():java.lang.reflect.Method");
    }

    /* access modifiers changed from: package-private */
    public static AccessClassLoader get(Class type) {
        ClassLoader parent = getParentClassLoader(type);
        if (selfContextParentClassLoader.equals(parent)) {
            if (selfContextAccessClassLoader == null) {
                synchronized (accessClassLoaders) {
                    if (selfContextAccessClassLoader == null) {
                        selfContextAccessClassLoader = new AccessClassLoader(selfContextParentClassLoader);
                    }
                }
            }
            return selfContextAccessClassLoader;
        }
        synchronized (accessClassLoaders) {
            WeakReference<AccessClassLoader> ref = accessClassLoaders.get(parent);
            if (ref != null) {
                AccessClassLoader accessClassLoader = ref.get();
                if (accessClassLoader != null) {
                    return accessClassLoader;
                }
                accessClassLoaders.remove(parent);
            }
            AccessClassLoader accessClassLoader2 = new AccessClassLoader(parent);
            accessClassLoaders.put(parent, new WeakReference<>(accessClassLoader2));
            return accessClassLoader2;
        }
    }

    public static void remove(ClassLoader parent) {
        if (selfContextParentClassLoader.equals(parent)) {
            selfContextAccessClassLoader = null;
            return;
        }
        synchronized (accessClassLoaders) {
            accessClassLoaders.remove(parent);
        }
    }

    public static int activeAccessClassLoaders() {
        int sz = accessClassLoaders.size();
        if (selfContextAccessClassLoader != null) {
            sz++;
        }
        return sz;
    }
}
