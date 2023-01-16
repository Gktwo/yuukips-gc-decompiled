package p001ch.qos.logback.core.util;

import java.util.ArrayList;
import java.util.List;
import net.bytebuddy.ClassFileVersion;

/* renamed from: ch.qos.logback.core.util.EnvUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/EnvUtil.class */
public class EnvUtil {
    private static boolean isJDK_N_OrHigher(int n) {
        List<String> versionList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            versionList.add("1." + (n + i));
        }
        String javaVersion = System.getProperty(ClassFileVersion.VersionLocator.JAVA_VERSION);
        if (javaVersion == null) {
            return false;
        }
        for (String v : versionList) {
            if (javaVersion.startsWith(v)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isJDK5() {
        return isJDK_N_OrHigher(5);
    }

    public static boolean isJDK6OrHigher() {
        return isJDK_N_OrHigher(6);
    }

    public static boolean isJDK7OrHigher() {
        return isJDK_N_OrHigher(7);
    }

    public static boolean isJaninoAvailable() {
        try {
            return EnvUtil.class.getClassLoader().loadClass("org.codehaus.janino.ScriptEvaluator") != null;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean isWindows() {
        return System.getProperty("os.name").startsWith("Windows");
    }
}
