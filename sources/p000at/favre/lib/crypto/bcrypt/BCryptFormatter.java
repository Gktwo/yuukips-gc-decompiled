package p000at.favre.lib.crypto.bcrypt;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Locale;
import p000at.favre.lib.bytes.Bytes;
import p000at.favre.lib.crypto.bcrypt.BCrypt;

/* renamed from: at.favre.lib.crypto.bcrypt.BCryptFormatter */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCryptFormatter.class */
public interface BCryptFormatter {
    byte[] createHashMessage(BCrypt.HashData hashData);

    /* renamed from: at.favre.lib.crypto.bcrypt.BCryptFormatter$Default */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCryptFormatter$Default.class */
    public static final class Default implements BCryptFormatter {
        private final Radix64Encoder encoder;
        private final Charset defaultCharset;

        public Default(Radix64Encoder encoder, Charset defaultCharset) {
            this.encoder = encoder;
            this.defaultCharset = defaultCharset;
        }

        @Override // p000at.favre.lib.crypto.bcrypt.BCryptFormatter
        public byte[] createHashMessage(BCrypt.HashData hashData) {
            byte[] saltEncoded = this.encoder.encode(hashData.rawSalt);
            byte[] hashEncoded = this.encoder.encode(hashData.rawHash);
            byte[] costFactorBytes = String.format(Locale.US, "%02d", Integer.valueOf(hashData.cost)).getBytes(this.defaultCharset);
            try {
                ByteBuffer byteBuffer = ByteBuffer.allocate(hashData.version.versionIdentifier.length + costFactorBytes.length + 3 + saltEncoded.length + hashEncoded.length);
                byteBuffer.put((byte) 36);
                byteBuffer.put(hashData.version.versionIdentifier);
                byteBuffer.put((byte) 36);
                byteBuffer.put(costFactorBytes);
                byteBuffer.put((byte) 36);
                byteBuffer.put(saltEncoded);
                byteBuffer.put(hashEncoded);
                byte[] array = byteBuffer.array();
                Bytes.wrapNullSafe(saltEncoded).mutable().secureWipe();
                Bytes.wrapNullSafe(hashEncoded).mutable().secureWipe();
                Bytes.wrapNullSafe(costFactorBytes).mutable().secureWipe();
                return array;
            } catch (Throwable th) {
                Bytes.wrapNullSafe(saltEncoded).mutable().secureWipe();
                Bytes.wrapNullSafe(hashEncoded).mutable().secureWipe();
                Bytes.wrapNullSafe(costFactorBytes).mutable().secureWipe();
                throw th;
            }
        }
    }
}
