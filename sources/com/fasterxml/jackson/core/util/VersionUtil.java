package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/VersionUtil.class */
public class VersionUtil {
    private static final Pattern V_SEP = Pattern.compile("[-_./;:]");

    protected VersionUtil() {
    }

    @Deprecated
    public Version version() {
        return Version.unknownVersion();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x0041
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static com.fasterxml.jackson.core.Version versionFor(java.lang.Class<?> r5) {
        /*
            r0 = 0
            r6 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: Exception -> 0x0061
            r1 = r0
            r1.<init>()     // Catch: Exception -> 0x0061
            r1 = r5
            java.lang.Package r1 = r1.getPackage()     // Catch: Exception -> 0x0061
            java.lang.String r1 = r1.getName()     // Catch: Exception -> 0x0061
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: Exception -> 0x0061
            java.lang.String r1 = ".PackageVersion"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: Exception -> 0x0061
            java.lang.String r0 = r0.toString()     // Catch: Exception -> 0x0061
            r7 = r0
            r0 = r7
            r1 = 1
            r2 = r5
            java.lang.ClassLoader r2 = r2.getClassLoader()     // Catch: Exception -> 0x0061
            java.lang.Class r0 = java.lang.Class.forName(r0, r1, r2)     // Catch: Exception -> 0x0061
            r8 = r0
            r0 = r8
            r1 = 0
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: Exception -> 0x0061, Exception -> 0x0041
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch: Exception -> 0x0061, Exception -> 0x0041
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: Exception -> 0x0061, Exception -> 0x0041
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: Exception -> 0x0061, Exception -> 0x0041
            com.fasterxml.jackson.core.Versioned r0 = (com.fasterxml.jackson.core.Versioned) r0     // Catch: Exception -> 0x0061, Exception -> 0x0041
            com.fasterxml.jackson.core.Version r0 = r0.version()     // Catch: Exception -> 0x0061, Exception -> 0x0041
            r6 = r0
            goto L_0x005e
        L_0x0041:
            r9 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: Exception -> 0x0061
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: Exception -> 0x0061
            r3 = r2
            r3.<init>()     // Catch: Exception -> 0x0061
            java.lang.String r3 = "Failed to get Versioned out of "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: Exception -> 0x0061
            r3 = r8
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: Exception -> 0x0061
            java.lang.String r2 = r2.toString()     // Catch: Exception -> 0x0061
            r1.<init>(r2)     // Catch: Exception -> 0x0061
            throw r0     // Catch: Exception -> 0x0061
        L_0x005e:
            goto L_0x0062
        L_0x0061:
            r7 = move-exception
        L_0x0062:
            r0 = r6
            if (r0 != 0) goto L_0x006c
            com.fasterxml.jackson.core.Version r0 = com.fasterxml.jackson.core.Version.unknownVersion()
            goto L_0x006d
        L_0x006c:
            r0 = r6
        L_0x006d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.VersionUtil.versionFor(java.lang.Class):com.fasterxml.jackson.core.Version");
    }

    @Deprecated
    public static Version packageVersionFor(Class<?> cls) {
        return versionFor(cls);
    }

    @Deprecated
    public static Version mavenVersionFor(ClassLoader cl, String groupId, String artifactId) {
        InputStream pomProperties = cl.getResourceAsStream("META-INF/maven/" + groupId.replaceAll("\\.", "/") + "/" + artifactId + "/pom.properties");
        if (pomProperties != null) {
            try {
                Properties props = new Properties();
                props.load(pomProperties);
                Version parseVersion = parseVersion(props.getProperty("version"), props.getProperty("groupId"), props.getProperty("artifactId"));
                _close(pomProperties);
                return parseVersion;
            } catch (IOException e) {
                _close(pomProperties);
            } catch (Throwable th) {
                _close(pomProperties);
                throw th;
            }
        }
        return Version.unknownVersion();
    }

    public static Version parseVersion(String s, String groupId, String artifactId) {
        if (s != null) {
            String s2 = s.trim();
            if (s2.length() > 0) {
                String[] parts = V_SEP.split(s2);
                return new Version(parseVersionPart(parts[0]), parts.length > 1 ? parseVersionPart(parts[1]) : 0, parts.length > 2 ? parseVersionPart(parts[2]) : 0, parts.length > 3 ? parts[3] : null, groupId, artifactId);
            }
        }
        return Version.unknownVersion();
    }

    protected static int parseVersionPart(String s) {
        char c;
        int number = 0;
        int i = 0;
        int len = s.length();
        while (i < len && (c = s.charAt(i)) <= '9' && c >= '0') {
            number = (number * 10) + (c - '0');
            i++;
        }
        return number;
    }

    private static final void _close(Closeable c) {
        try {
            c.close();
        } catch (IOException e) {
        }
    }

    public static final void throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
