package p000at.favre.lib.bytes;

import java.nio.ByteOrder;

/* renamed from: at.favre.lib.bytes.BytesFactory */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesFactory.class */
public interface BytesFactory {
    Bytes wrap(byte[] bArr, ByteOrder byteOrder);
}
