package p013io.netty.util.internal;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.util.internal.NativeLibraryUtil */
/* loaded from: grasscutter.jar:io/netty/util/internal/NativeLibraryUtil.class */
public final class NativeLibraryUtil {
    public static void loadLibrary(String libName, boolean absolute) {
        if (absolute) {
            System.load(libName);
        } else {
            System.loadLibrary(libName);
        }
    }

    private NativeLibraryUtil() {
    }
}
