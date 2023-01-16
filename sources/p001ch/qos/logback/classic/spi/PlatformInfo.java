package p001ch.qos.logback.classic.spi;

/* renamed from: ch.qos.logback.classic.spi.PlatformInfo */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/PlatformInfo.class */
public class PlatformInfo {
    private static final int UNINITIALIZED = -1;
    private static int hasJMXObjectName = -1;

    public static boolean hasJMXObjectName() {
        if (hasJMXObjectName == -1) {
            try {
                Class.forName("javax.management.ObjectName");
                hasJMXObjectName = 1;
            } catch (Throwable th) {
                hasJMXObjectName = 0;
            }
        }
        return hasJMXObjectName == 1;
    }
}
