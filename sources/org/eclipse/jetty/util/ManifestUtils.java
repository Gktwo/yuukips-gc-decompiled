package org.eclipse.jetty.util;

import java.util.Optional;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ManifestUtils.class */
public class ManifestUtils {
    private ManifestUtils() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0038
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static java.util.Optional<java.util.jar.Manifest> getManifest(java.lang.Class<?> r6) {
        /*
            r0 = r6
            java.security.ProtectionDomain r0 = r0.getProtectionDomain()     // Catch: Throwable -> 0x0051
            java.security.CodeSource r0 = r0.getCodeSource()     // Catch: Throwable -> 0x0051
            r7 = r0
            r0 = r7
            if (r0 == 0) goto L_0x004d
            r0 = r7
            java.net.URL r0 = r0.getLocation()     // Catch: Throwable -> 0x0051
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x004d
            java.util.jar.JarFile r0 = new java.util.jar.JarFile     // Catch: Throwable -> 0x0051
            r1 = r0
            java.io.File r2 = new java.io.File     // Catch: Throwable -> 0x0051
            r3 = r2
            r4 = r8
            java.net.URI r4 = r4.toURI()     // Catch: Throwable -> 0x0051
            r3.<init>(r4)     // Catch: Throwable -> 0x0051
            r1.<init>(r2)     // Catch: Throwable -> 0x0051
            r9 = r0
            r0 = r9
            java.util.jar.Manifest r0 = r0.getManifest()     // Catch: Throwable -> 0x0051, Throwable -> 0x0038
            java.util.Optional r0 = java.util.Optional.of(r0)     // Catch: Throwable -> 0x0051, Throwable -> 0x0038
            r10 = r0
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x0051
            r0 = r10
            return r0
        L_0x0038:
            r10 = move-exception
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x0051, Throwable -> 0x0041
            goto L_0x004a
        L_0x0041:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0051
        L_0x004a:
            r0 = r10
            throw r0     // Catch: Throwable -> 0x0051
        L_0x004d:
            java.util.Optional r0 = java.util.Optional.empty()     // Catch: Throwable -> 0x0051
            return r0
        L_0x0051:
            r7 = move-exception
            java.util.Optional r0 = java.util.Optional.empty()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.ManifestUtils.getManifest(java.lang.Class):java.util.Optional");
    }

    public static Optional<String> getVersion(Class<?> klass) {
        Optional<String> version = getManifest(klass).map((v0) -> {
            return v0.getMainAttributes();
        }).map(attributes -> {
            return attributes.getValue("Implementation-Version");
        });
        if (version.isPresent()) {
            return version;
        }
        try {
            Object module = klass.getClass().getMethod("getModule", new Class[0]).invoke(klass, new Object[0]);
            Object descriptor = module.getClass().getMethod("getDescriptor", new Class[0]).invoke(module, new Object[0]);
            return (Optional) descriptor.getClass().getMethod("rawVersion", new Class[0]).invoke(descriptor, new Object[0]);
        } catch (Throwable th) {
            return Optional.empty();
        }
    }
}
