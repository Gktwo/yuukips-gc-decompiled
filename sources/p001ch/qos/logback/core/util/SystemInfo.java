package p001ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.SystemInfo */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/SystemInfo.class */
public class SystemInfo {
    public static String getJavaVendor() {
        return OptionHelper.getSystemProperty("java.vendor", null);
    }
}
