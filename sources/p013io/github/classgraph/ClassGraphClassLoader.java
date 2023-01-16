package p013io.github.classgraph;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.Set;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClassGraphClassLoader */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassGraphClassLoader.class */
public class ClassGraphClassLoader extends ClassLoader {
    private final ScanResult scanResult;
    private final boolean initializeLoadedClasses;
    private final Set<ClassLoader> environmentClassLoaderDelegationOrder;
    private final Set<ClassLoader> overriddenOrAddedClassLoaderDelegationOrder;

    /* access modifiers changed from: package-private */
    public ClassGraphClassLoader(ScanResult scanResult) {
        super(null);
        registerAsParallelCapable();
        this.scanResult = scanResult;
        ScanSpec scanSpec = scanResult.scanSpec;
        this.initializeLoadedClasses = scanSpec.initializeLoadedClasses;
        boolean classpathOverridden = scanSpec.overrideClasspath != null && !scanSpec.overrideClasspath.isEmpty();
        boolean classloadersOverridden = scanSpec.overrideClassLoaders != null && !scanSpec.overrideClassLoaders.isEmpty();
        boolean clasloadersAdded = scanSpec.addedClassLoaders != null && !scanSpec.addedClassLoaders.isEmpty();
        this.environmentClassLoaderDelegationOrder = new LinkedHashSet();
        if (!classpathOverridden && !classloadersOverridden) {
            this.environmentClassLoaderDelegationOrder.add(null);
            ClassLoader[] envClassLoaderOrder = scanResult.getClassLoaderOrderRespectingParentDelegation();
            if (envClassLoaderOrder != null) {
                for (ClassLoader envClassLoader : envClassLoaderOrder) {
                    this.environmentClassLoaderDelegationOrder.add(envClassLoader);
                }
            }
        }
        URLClassLoader classpathClassLoader = new URLClassLoader((URL[]) scanResult.getClasspathURLs().toArray(new URL[0]));
        if (classpathOverridden) {
            this.environmentClassLoaderDelegationOrder.add(classpathClassLoader);
        }
        this.overriddenOrAddedClassLoaderDelegationOrder = new LinkedHashSet();
        if (classloadersOverridden) {
            this.overriddenOrAddedClassLoaderDelegationOrder.addAll(scanSpec.overrideClassLoaders);
        }
        if (clasloadersAdded) {
            this.overriddenOrAddedClassLoaderDelegationOrder.addAll(scanSpec.addedClassLoaders);
        }
        if (!classpathOverridden) {
            this.overriddenOrAddedClassLoaderDelegationOrder.add(classpathClassLoader);
        }
        this.overriddenOrAddedClassLoaderDelegationOrder.removeAll(this.environmentClassLoaderDelegationOrder);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:53:0x0153
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.ClassLoader
    protected java.lang.Class<?> findClass(java.lang.String r6) throws java.lang.ClassNotFoundException, java.lang.LinkageError, java.lang.SecurityException {
        /*
        // Method dump skipped, instructions count: 425
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.ClassGraphClassLoader.findClass(java.lang.String):java.lang.Class");
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String path) {
        if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader envClassLoader : this.environmentClassLoaderDelegationOrder) {
                URL resource = envClassLoader.getResource(path);
                if (resource != null) {
                    return resource;
                }
            }
        }
        if (!this.overriddenOrAddedClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader additionalClassLoader : this.overriddenOrAddedClassLoaderDelegationOrder) {
                URL resource2 = additionalClassLoader.getResource(path);
                if (resource2 != null) {
                    return resource2;
                }
            }
        }
        ResourceList resourceList = this.scanResult.getResourcesWithPath(path);
        if (resourceList == null || resourceList.isEmpty()) {
            return getResource(path);
        }
        return ((Resource) resourceList.get(0)).getURL();
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String path) throws IOException {
        if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader envClassLoader : this.environmentClassLoaderDelegationOrder) {
                Enumeration<URL> resources = envClassLoader.getResources(path);
                if (resources != null && resources.hasMoreElements()) {
                    return resources;
                }
            }
        }
        if (!this.overriddenOrAddedClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader additionalClassLoader : this.overriddenOrAddedClassLoaderDelegationOrder) {
                Enumeration<URL> resources2 = additionalClassLoader.getResources(path);
                if (resources2 != null && resources2.hasMoreElements()) {
                    return resources2;
                }
            }
        }
        final ResourceList resourceList = this.scanResult.getResourcesWithPath(path);
        if (resourceList == null || resourceList.isEmpty()) {
            return Collections.emptyEnumeration();
        }
        return new Enumeration<URL>() { // from class: io.github.classgraph.ClassGraphClassLoader.1
            int idx;

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return this.idx < resourceList.size();
            }

            @Override // java.util.Enumeration
            public URL nextElement() {
                ResourceList resourceList2 = resourceList;
                int i = this.idx;
                this.idx = i + 1;
                return ((Resource) resourceList2.get(i)).getURL();
            }
        };
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String path) {
        if (!this.environmentClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader envClassLoader : this.environmentClassLoaderDelegationOrder) {
                InputStream inputStream = envClassLoader.getResourceAsStream(path);
                if (inputStream != null) {
                    return inputStream;
                }
            }
        }
        if (!this.overriddenOrAddedClassLoaderDelegationOrder.isEmpty()) {
            for (ClassLoader additionalClassLoader : this.overriddenOrAddedClassLoaderDelegationOrder) {
                InputStream inputStream2 = additionalClassLoader.getResourceAsStream(path);
                if (inputStream2 != null) {
                    return inputStream2;
                }
            }
        }
        ResourceList resourceList = this.scanResult.getResourcesWithPath(path);
        if (resourceList == null || resourceList.isEmpty()) {
            return getResourceAsStream(path);
        }
        try {
            return ((Resource) resourceList.get(0)).open();
        } catch (IOException e) {
            return null;
        }
    }
}
