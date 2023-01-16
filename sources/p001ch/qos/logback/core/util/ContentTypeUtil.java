package p001ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.ContentTypeUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/ContentTypeUtil.class */
public class ContentTypeUtil {
    public static boolean isTextual(String contextType) {
        if (contextType == null) {
            return false;
        }
        return contextType.startsWith("text");
    }

    public static String getSubType(String contextType) {
        int index;
        int subTypeStartIndex;
        if (contextType == null || (index = contextType.indexOf(47)) == -1 || (subTypeStartIndex = index + 1) >= contextType.length()) {
            return null;
        }
        return contextType.substring(subTypeStartIndex);
    }
}
