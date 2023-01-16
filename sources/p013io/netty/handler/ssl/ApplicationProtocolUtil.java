package p013io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.List;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.ApplicationProtocolUtil */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/ApplicationProtocolUtil.class */
final class ApplicationProtocolUtil {
    private static final int DEFAULT_LIST_SIZE = 2;

    private ApplicationProtocolUtil() {
    }

    /* access modifiers changed from: package-private */
    public static List<String> toList(Iterable<String> protocols) {
        return toList(2, protocols);
    }

    static List<String> toList(int initialListSize, Iterable<String> protocols) {
        if (protocols == null) {
            return null;
        }
        List<String> result = new ArrayList<>(initialListSize);
        for (String p : protocols) {
            result.add(ObjectUtil.checkNonEmpty(p, "p"));
        }
        return (List) ObjectUtil.checkNonEmpty(result, "result");
    }

    /* access modifiers changed from: package-private */
    public static List<String> toList(String... protocols) {
        return toList(2, protocols);
    }

    static List<String> toList(int initialListSize, String... protocols) {
        if (protocols == null) {
            return null;
        }
        List<String> result = new ArrayList<>(initialListSize);
        for (String p : protocols) {
            result.add(ObjectUtil.checkNonEmpty(p, "p"));
        }
        return (List) ObjectUtil.checkNonEmpty(result, "result");
    }
}
