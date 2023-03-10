package p013io.netty.handler.codec.marshalling;

import java.io.IOException;
import org.jboss.marshalling.ByteInput;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.marshalling.LimitingByteInput */
/* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/LimitingByteInput.class */
class LimitingByteInput implements ByteInput {
    private static final TooBigObjectException EXCEPTION = new TooBigObjectException();
    private final ByteInput input;
    private final long limit;
    private long read;

    /* access modifiers changed from: package-private */
    public LimitingByteInput(ByteInput input, long limit) {
        this.input = input;
        this.limit = ObjectUtil.checkPositive(limit, "limit");
    }

    public void close() throws IOException {
    }

    public int available() throws IOException {
        return readable(this.input.available());
    }

    public int read() throws IOException {
        if (readable(1) > 0) {
            int b = this.input.read();
            this.read++;
            return b;
        }
        throw EXCEPTION;
    }

    public int read(byte[] array) throws IOException {
        return read(array, 0, array.length);
    }

    public int read(byte[] array, int offset, int length) throws IOException {
        int readable = readable(length);
        if (readable > 0) {
            int i = this.input.read(array, offset, readable);
            this.read += (long) i;
            return i;
        }
        throw EXCEPTION;
    }

    public long skip(long bytes) throws IOException {
        int readable = readable((int) bytes);
        if (readable > 0) {
            long i = this.input.skip((long) readable);
            this.read += i;
            return i;
        }
        throw EXCEPTION;
    }

    private int readable(int length) {
        return (int) Math.min((long) length, this.limit - this.read);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.marshalling.LimitingByteInput$TooBigObjectException */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/marshalling/LimitingByteInput$TooBigObjectException.class */
    public static final class TooBigObjectException extends IOException {
        private static final long serialVersionUID = 1;

        TooBigObjectException() {
        }
    }
}
