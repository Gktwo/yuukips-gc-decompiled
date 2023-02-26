package nonapi.p019io.github.classgraph.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import net.bytebuddy.ClassFileVersion;

/* renamed from: nonapi.io.github.classgraph.utils.VersionFinder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/VersionFinder.class */
public final class VersionFinder {
    private static final String MAVEN_PACKAGE = "io.github.classgraph";
    private static final String MAVEN_ARTIFACT = "classgraph";

    /* renamed from: OS */
    public static final OperatingSystem f3075OS;
    public static final String JAVA_VERSION = getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
    public static final int JAVA_MAJOR_VERSION;
    public static final int JAVA_MINOR_VERSION;
    public static final int JAVA_SUB_VERSION;
    public static final boolean JAVA_IS_EA_VERSION;

    /* renamed from: nonapi.io.github.classgraph.utils.VersionFinder$OperatingSystem */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/VersionFinder$OperatingSystem.class */
    public enum OperatingSystem {
        Windows,
        MacOSX,
        Linux,
        Solaris,
        BSD,
        Unix,
        Unknown
    }

    static {
        int javaMajorVersion = 0;
        int javaMinorVersion = 0;
        int javaSubVersion = 0;
        List<Integer> versionParts = new ArrayList<>();
        if (JAVA_VERSION != null) {
            for (String versionPart : JAVA_VERSION.split("[^0-9]+")) {
                try {
                    versionParts.add(Integer.valueOf(Integer.parseInt(versionPart)));
                } catch (NumberFormatException e) {
                }
            }
            if (!versionParts.isEmpty() && versionParts.get(0).intValue() == 1) {
                versionParts.remove(0);
            }
            if (versionParts.isEmpty()) {
                throw new RuntimeException("Could not determine Java version: " + JAVA_VERSION);
            }
            javaMajorVersion = versionParts.get(0).intValue();
            if (versionParts.size() > 1) {
                javaMinorVersion = versionParts.get(1).intValue();
            }
            if (versionParts.size() > 2) {
                javaSubVersion = versionParts.get(2).intValue();
            }
        }
        JAVA_MAJOR_VERSION = javaMajorVersion;
        JAVA_MINOR_VERSION = javaMinorVersion;
        JAVA_SUB_VERSION = javaSubVersion;
        JAVA_IS_EA_VERSION = JAVA_VERSION != null && JAVA_VERSION.endsWith("-ea");
        String osName = getProperty("os.name", "unknown").toLowerCase(Locale.ENGLISH);
        if (osName == null) {
            f3075OS = OperatingSystem.Unknown;
        } else if (osName.contains("mac") || osName.contains("darwin")) {
            f3075OS = OperatingSystem.MacOSX;
        } else if (osName.contains("win")) {
            f3075OS = OperatingSystem.Windows;
        } else if (osName.contains("nux")) {
            f3075OS = OperatingSystem.Linux;
        } else if (osName.contains("sunos") || osName.contains("solaris")) {
            f3075OS = OperatingSystem.Solaris;
        } else if (osName.contains("bsd")) {
            f3075OS = OperatingSystem.Unix;
        } else if (osName.contains("nix") || osName.contains("aix")) {
            f3075OS = OperatingSystem.Unix;
        } else {
            f3075OS = OperatingSystem.Unknown;
        }
    }

    private VersionFinder() {
    }

    public static String getProperty(String propName) {
        try {
            return System.getProperty(propName);
        } catch (SecurityException e) {
            return null;
        }
    }

    public static String getProperty(String propName, String defaultVal) {
        try {
            return System.getProperty(propName, defaultVal);
        } catch (SecurityException e) {
            return null;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:40:0x0127
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static synchronized java.lang.String getVersion() {
        /*
        // Method dump skipped, instructions count: 589
        */
        throw new UnsupportedOperationException("Method not decompiled: nonapi.p019io.github.classgraph.utils.VersionFinder.getVersion():java.lang.String");
    }
}
