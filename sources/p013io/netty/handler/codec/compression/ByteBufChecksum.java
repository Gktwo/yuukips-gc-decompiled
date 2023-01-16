package p013io.netty.handler.codec.compression;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import p013io.netty.buffer.ByteBuf;
import p013io.netty.util.ByteProcessor;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.compression.ByteBufChecksum */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ByteBufChecksum.class */
public abstract class ByteBufChecksum implements Checksum {
    private static final Method ADLER32_UPDATE_METHOD = updateByteBuffer(new Adler32());
    private static final Method CRC32_UPDATE_METHOD = updateByteBuffer(new CRC32());
    private final ByteProcessor updateProcessor = new ByteProcessor() { // from class: io.netty.handler.codec.compression.ByteBufChecksum.1
        @Override // p013io.netty.util.ByteProcessor
        public boolean process(byte value) throws Exception {
            ByteBufChecksum.this.update(value);
            return true;
        }
    };

    private static Method updateByteBuffer(Checksum checksum) {
        if (PlatformDependent.javaVersion() < 8) {
            return null;
        }
        try {
            Method method = checksum.getClass().getDeclaredMethod("update", ByteBuffer.class);
            method.invoke(checksum, ByteBuffer.allocate(1));
            return method;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public static ByteBufChecksum wrapChecksum(Checksum checksum) {
        ObjectUtil.checkNotNull(checksum, "checksum");
        if (checksum instanceof ByteBufChecksum) {
            return (ByteBufChecksum) checksum;
        }
        if ((checksum instanceof Adler32) && ADLER32_UPDATE_METHOD != null) {
            return new ReflectiveByteBufChecksum(checksum, ADLER32_UPDATE_METHOD);
        }
        if (!(checksum instanceof CRC32) || CRC32_UPDATE_METHOD == null) {
            return new SlowByteBufChecksum(checksum);
        }
        return new ReflectiveByteBufChecksum(checksum, CRC32_UPDATE_METHOD);
    }

    public void update(ByteBuf b, int off, int len) {
        if (b.hasArray()) {
            update(b.array(), b.arrayOffset() + off, len);
        } else {
            b.forEachByte(off, len, this.updateProcessor);
        }
    }

    /* renamed from: io.netty.handler.codec.compression.ByteBufChecksum$ReflectiveByteBufChecksum */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ByteBufChecksum$ReflectiveByteBufChecksum.class */
    private static final class ReflectiveByteBufChecksum extends SlowByteBufChecksum {
        private final Method method;

        ReflectiveByteBufChecksum(Checksum checksum, Method method) {
            super(checksum);
            this.method = method;
        }

        @Override // p013io.netty.handler.codec.compression.ByteBufChecksum
        public void update(ByteBuf b, int off, int len) {
            if (b.hasArray()) {
                update(b.array(), b.arrayOffset() + off, len);
                return;
            }
            try {
                this.method.invoke(this.checksum, CompressionUtil.safeNioBuffer(b, off, len));
            } catch (Throwable th) {
                throw new Error();
            }
        }
    }

    /* renamed from: io.netty.handler.codec.compression.ByteBufChecksum$SlowByteBufChecksum */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/ByteBufChecksum$SlowByteBufChecksum.class */
    private static class SlowByteBufChecksum extends ByteBufChecksum {
        protected final Checksum checksum;

        SlowByteBufChecksum(Checksum checksum) {
            this.checksum = checksum;
        }

        @Override // java.util.zip.Checksum
        public void update(int b) {
            this.checksum.update(b);
        }

        @Override // java.util.zip.Checksum
        public void update(byte[] b, int off, int len) {
            this.checksum.update(b, off, len);
        }

        @Override // java.util.zip.Checksum
        public long getValue() {
            return this.checksum.getValue();
        }

        @Override // java.util.zip.Checksum
        public void reset() {
            this.checksum.reset();
        }
    }
}
