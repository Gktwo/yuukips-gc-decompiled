package p013io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.Inflater;
import com.jcraft.jzlib.JZlib;

/* renamed from: io.netty.handler.codec.compression.ZlibUtil */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ZlibUtil.class */
final class ZlibUtil {
    /* access modifiers changed from: package-private */
    public static void fail(Inflater z, String message, int resultCode) {
        throw inflaterException(z, message, resultCode);
    }

    /* access modifiers changed from: package-private */
    public static void fail(Deflater z, String message, int resultCode) {
        throw deflaterException(z, message, resultCode);
    }

    static DecompressionException inflaterException(Inflater z, String message, int resultCode) {
        return new DecompressionException(message + " (" + resultCode + ')' + (z.msg != null ? ": " + z.msg : ""));
    }

    /* access modifiers changed from: package-private */
    public static CompressionException deflaterException(Deflater z, String message, int resultCode) {
        return new CompressionException(message + " (" + resultCode + ')' + (z.msg != null ? ": " + z.msg : ""));
    }

    /* access modifiers changed from: package-private */
    public static JZlib.WrapperType convertWrapperType(ZlibWrapper wrapper) {
        JZlib.WrapperType convertedWrapperType;
        switch (wrapper) {
            case NONE:
                convertedWrapperType = JZlib.W_NONE;
                break;
            case ZLIB:
                convertedWrapperType = JZlib.W_ZLIB;
                break;
            case GZIP:
                convertedWrapperType = JZlib.W_GZIP;
                break;
            case ZLIB_OR_NONE:
                convertedWrapperType = JZlib.W_ANY;
                break;
            default:
                throw new Error();
        }
        return convertedWrapperType;
    }

    /* access modifiers changed from: package-private */
    public static int wrapperOverhead(ZlibWrapper wrapper) {
        int overhead;
        switch (wrapper) {
            case NONE:
                overhead = 0;
                break;
            case ZLIB:
            case ZLIB_OR_NONE:
                overhead = 2;
                break;
            case GZIP:
                overhead = 10;
                break;
            default:
                throw new Error();
        }
        return overhead;
    }

    private ZlibUtil() {
    }
}
