package p000at.favre.lib.bytes;

import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Objects;
import p000at.favre.lib.bytes.Util;

/* renamed from: at.favre.lib.bytes.MutableBytes */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/MutableBytes.class */
public final class MutableBytes extends Bytes implements AutoCloseable {
    /* access modifiers changed from: package-private */
    public MutableBytes(byte[] byteArray, ByteOrder byteOrder) {
        super(byteArray, byteOrder, new Factory());
    }

    public static MutableBytes allocate(int length) {
        return allocate(length, (byte) 0);
    }

    public static MutableBytes allocate(int length, byte defaultValue) {
        return Bytes.allocate(length, defaultValue).mutable();
    }

    @Override // p000at.favre.lib.bytes.Bytes
    public boolean isMutable() {
        return true;
    }

    public MutableBytes overwrite(byte[] newArray) {
        return overwrite(newArray, 0);
    }

    public MutableBytes overwrite(Bytes newBytes) {
        return overwrite(newBytes, 0);
    }

    public MutableBytes overwrite(byte[] newArray, int offsetInternalArray) {
        Objects.requireNonNull(newArray, "must provide non-null array as source");
        System.arraycopy(newArray, 0, internalArray(), offsetInternalArray, newArray.length);
        return this;
    }

    public MutableBytes overwrite(Bytes newBytes, int offsetInternalArray) {
        return overwrite(((Bytes) Objects.requireNonNull(newBytes, "must provide non-null array as source")).array(), offsetInternalArray);
    }

    public MutableBytes setByteAt(int index, byte newByte) {
        internalArray()[index] = newByte;
        return this;
    }

    public MutableBytes wipe() {
        return fill((byte) 0);
    }

    public MutableBytes fill(byte fillByte) {
        Arrays.fill(internalArray(), fillByte);
        return this;
    }

    public MutableBytes secureWipe() {
        return secureWipe(new SecureRandom());
    }

    public MutableBytes secureWipe(SecureRandom random) {
        Objects.requireNonNull(random, "random param must not be null");
        if (length() > 0) {
            random.nextBytes(internalArray());
        }
        return this;
    }

    public Bytes immutable() {
        return Bytes.wrap(internalArray(), byteOrder());
    }

    @Override // p000at.favre.lib.bytes.Bytes, java.lang.Object
    public int hashCode() {
        return Util.Obj.hashCode(internalArray(), byteOrder());
    }

    @Override // p000at.favre.lib.bytes.Bytes, java.lang.Object
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        secureWipe();
    }

    /* renamed from: at.favre.lib.bytes.MutableBytes$Factory */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/MutableBytes$Factory.class */
    private static class Factory implements BytesFactory {
        private Factory() {
        }

        @Override // p000at.favre.lib.bytes.BytesFactory
        public Bytes wrap(byte[] array, ByteOrder byteOrder) {
            return new MutableBytes(array, byteOrder);
        }
    }
}
