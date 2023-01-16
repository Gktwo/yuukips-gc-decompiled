package p013io.netty.handler.codec.compression;

import com.aayushatharva.brotli4j.encoder.Encoder;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.compression.BrotliOptions */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/BrotliOptions.class */
public final class BrotliOptions implements CompressionOptions {
    private final Encoder.Parameters parameters;
    static final BrotliOptions DEFAULT = new BrotliOptions(new Encoder.Parameters().setQuality(4).setMode(Encoder.Mode.TEXT));

    /* access modifiers changed from: package-private */
    public BrotliOptions(Encoder.Parameters parameters) {
        if (!Brotli.isAvailable()) {
            throw new IllegalStateException("Brotli is not available", Brotli.cause());
        }
        this.parameters = (Encoder.Parameters) ObjectUtil.checkNotNull(parameters, "Parameters");
    }

    public Encoder.Parameters parameters() {
        return this.parameters;
    }
}
