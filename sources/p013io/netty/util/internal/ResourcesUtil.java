package p013io.netty.util.internal;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: io.netty.util.internal.ResourcesUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/ResourcesUtil.class */
public final class ResourcesUtil {
    public static File getFile(Class resourceClass, String fileName) {
        try {
            return new File(URLDecoder.decode(resourceClass.getResource(fileName).getFile(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            return new File(resourceClass.getResource(fileName).getFile());
        }
    }

    private ResourcesUtil() {
    }
}
