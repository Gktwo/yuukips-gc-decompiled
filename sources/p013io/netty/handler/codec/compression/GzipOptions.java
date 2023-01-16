package p013io.netty.handler.codec.compression;

/* renamed from: io.netty.handler.codec.compression.GzipOptions */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/GzipOptions.class */
public final class GzipOptions extends DeflateOptions {
    static final GzipOptions DEFAULT = new GzipOptions(6, 15, 8);

    /* access modifiers changed from: package-private */
    public GzipOptions(int compressionLevel, int windowBits, int memLevel) {
        super(compressionLevel, windowBits, memLevel);
    }
}
