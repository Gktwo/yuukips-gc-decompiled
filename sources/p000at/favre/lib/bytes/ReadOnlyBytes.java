package p000at.favre.lib.bytes;

import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* renamed from: at.favre.lib.bytes.ReadOnlyBytes */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/ReadOnlyBytes.class */
public final class ReadOnlyBytes extends Bytes {
    /* access modifiers changed from: package-private */
    public ReadOnlyBytes(byte[] byteArray, ByteOrder byteOrder) {
        super(byteArray, byteOrder, new Factory());
    }

    @Override // p000at.favre.lib.bytes.Bytes
    public boolean isReadOnly() {
        return true;
    }

    @Override // p000at.favre.lib.bytes.Bytes
    public byte[] array() {
        throw new ReadOnlyBufferException();
    }

    /* renamed from: at.favre.lib.bytes.ReadOnlyBytes$Factory */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/ReadOnlyBytes$Factory.class */
    private static class Factory implements BytesFactory {
        private Factory() {
        }

        @Override // p000at.favre.lib.bytes.BytesFactory
        public Bytes wrap(byte[] array, ByteOrder byteOrder) {
            return new ReadOnlyBytes(array, byteOrder);
        }
    }
}
