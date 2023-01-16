package p001ch.qos.logback.core.joran.spi;

/* renamed from: ch.qos.logback.core.joran.spi.NoAutoStartUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/NoAutoStartUtil.class */
public class NoAutoStartUtil {
    public static boolean notMarkedWithNoAutoStart(Object o) {
        return o != null && ((NoAutoStart) o.getClass().getAnnotation(NoAutoStart.class)) == null;
    }
}
