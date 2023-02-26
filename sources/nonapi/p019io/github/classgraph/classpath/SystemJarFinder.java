package nonapi.p019io.github.classgraph.classpath;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.VersionFinder;

/* renamed from: nonapi.io.github.classgraph.classpath.SystemJarFinder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/classpath/SystemJarFinder.class */
public final class SystemJarFinder {
    private static final String RT_JAR;
    private static final Set<String> RT_JARS = new LinkedHashSet();
    private static final Set<String> JRE_LIB_OR_EXT_JARS = new LinkedHashSet();

    static {
        String javaHome = VersionFinder.getProperty("java.home");
        if (javaHome == null || javaHome.isEmpty()) {
            javaHome = System.getenv("JAVA_HOME");
        }
        if (javaHome != null && !javaHome.isEmpty()) {
            File javaHomeFile = new File(javaHome);
            addJREPath(javaHomeFile);
            if (javaHomeFile.getName().equals("jre")) {
                File jreParent = javaHomeFile.getParentFile();
                addJREPath(jreParent);
                addJREPath(new File(jreParent, "lib"));
                addJREPath(new File(jreParent, "lib/ext"));
            } else {
                addJREPath(new File(javaHomeFile, "jre"));
            }
            addJREPath(new File(javaHomeFile, "lib"));
            addJREPath(new File(javaHomeFile, "lib/ext"));
            addJREPath(new File(javaHomeFile, "jre/lib"));
            addJREPath(new File(javaHomeFile, "jre/lib/ext"));
            addJREPath(new File(javaHomeFile, "packages"));
            addJREPath(new File(javaHomeFile, "packages/lib"));
            addJREPath(new File(javaHomeFile, "packages/lib/ext"));
        }
        String javaExtDirs = VersionFinder.getProperty("java.ext.dirs");
        if (javaExtDirs != null && !javaExtDirs.isEmpty()) {
            String[] smartPathSplit = JarUtils.smartPathSplit(javaExtDirs, null);
            for (String javaExtDir : smartPathSplit) {
                if (!javaExtDir.isEmpty()) {
                    addJREPath(new File(javaExtDir));
                }
            }
        }
        switch (VersionFinder.f3075OS) {
            case Linux:
            case Unix:
            case BSD:
            case Unknown:
                addJREPath(new File("/usr/java/packages"));
                addJREPath(new File("/usr/java/packages/lib"));
                addJREPath(new File("/usr/java/packages/lib/ext"));
                break;
            case MacOSX:
                addJREPath(new File("/System/Library/Java"));
                addJREPath(new File("/System/Library/Java/Libraries"));
                addJREPath(new File("/System/Library/Java/Extensions"));
                break;
            case Windows:
                String systemRoot = File.separatorChar == '\\' ? System.getenv("SystemRoot") : null;
                if (systemRoot != null) {
                    addJREPath(new File(systemRoot, "Sun\\Java"));
                    addJREPath(new File(systemRoot, "Sun\\Java\\lib"));
                    addJREPath(new File(systemRoot, "Sun\\Java\\lib\\ext"));
                    addJREPath(new File(systemRoot, "Oracle\\Java"));
                    addJREPath(new File(systemRoot, "Oracle\\Java\\lib"));
                    addJREPath(new File(systemRoot, "Oracle\\Java\\lib\\ext"));
                    break;
                }
                break;
            case Solaris:
                addJREPath(new File("/usr/jdk/packages"));
                addJREPath(new File("/usr/jdk/packages/lib"));
                addJREPath(new File("/usr/jdk/packages/lib/ext"));
                break;
        }
        RT_JAR = RT_JARS.isEmpty() ? null : FastPathResolver.resolve(RT_JARS.iterator().next());
    }

    private SystemJarFinder() {
    }

    private static boolean addJREPath(File dir) {
        File[] dirFiles;
        if (dir == null || dir.getPath().isEmpty() || !FileUtils.canReadAndIsDir(dir) || (dirFiles = dir.listFiles()) == null) {
            return false;
        }
        for (File file : dirFiles) {
            String filePath = file.getPath();
            if (filePath.endsWith(".jar")) {
                String jarPathResolved = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, filePath);
                if (jarPathResolved.endsWith("/rt.jar")) {
                    RT_JARS.add(jarPathResolved);
                } else {
                    JRE_LIB_OR_EXT_JARS.add(jarPathResolved);
                }
                try {
                    if (!file.getCanonicalFile().getPath().equals(filePath)) {
                        JRE_LIB_OR_EXT_JARS.add(FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, filePath));
                    }
                } catch (IOException | SecurityException e) {
                }
            }
        }
        return true;
    }

    public static String getJreRtJarPath() {
        return RT_JAR;
    }

    public static Set<String> getJreLibOrExtJars() {
        return JRE_LIB_OR_EXT_JARS;
    }
}
