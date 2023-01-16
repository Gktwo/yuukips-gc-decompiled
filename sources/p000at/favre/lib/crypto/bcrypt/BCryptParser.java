package p000at.favre.lib.crypto.bcrypt;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import p000at.favre.lib.bytes.Bytes;
import p000at.favre.lib.crypto.bcrypt.BCrypt;

/* renamed from: at.favre.lib.crypto.bcrypt.BCryptParser */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCryptParser.class */
public interface BCryptParser {
    BCrypt.HashData parse(byte[] bArr) throws IllegalBCryptFormatException;

    /* renamed from: at.favre.lib.crypto.bcrypt.BCryptParser$Default */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCryptParser$Default.class */
    public static final class Default implements BCryptParser {
        private final Charset defaultCharset;
        private final Radix64Encoder encoder;

        /* access modifiers changed from: package-private */
        public Default(Radix64Encoder encoder, Charset defaultCharset) {
            this.defaultCharset = defaultCharset;
            this.encoder = encoder;
        }

        @Override // p000at.favre.lib.crypto.bcrypt.BCryptParser
        public BCrypt.HashData parse(byte[] bcryptHash) throws IllegalBCryptFormatException {
            if (bcryptHash == null || bcryptHash.length == 0) {
                throw new IllegalArgumentException("must provide non-null, non-empty hash");
            } else if (bcryptHash.length < 7) {
                throw new IllegalBCryptFormatException("hash prefix meta must be at least 7 bytes long e.g. '$2a$10$'");
            } else {
                ByteBuffer byteBuffer = ByteBuffer.wrap(bcryptHash);
                if (byteBuffer.get() != 36) {
                    throw new IllegalBCryptFormatException("hash must start with " + Bytes.from((byte) 36).encodeUtf8());
                }
                BCrypt.Version usedVersion = null;
                for (BCrypt.Version versionToTest : BCrypt.Version.SUPPORTED_VERSIONS) {
                    int i = 0;
                    while (true) {
                        if (i >= versionToTest.versionIdentifier.length) {
                            break;
                        } else if (byteBuffer.get() != versionToTest.versionIdentifier[i]) {
                            byteBuffer.position(byteBuffer.position() - (i + 1));
                            break;
                        } else {
                            if (i == versionToTest.versionIdentifier.length - 1) {
                                usedVersion = versionToTest;
                            }
                            i++;
                        }
                    }
                    if (usedVersion != null) {
                        break;
                    }
                }
                if (usedVersion == null) {
                    throw new IllegalBCryptFormatException("unknown bcrypt version");
                } else if (byteBuffer.get() != 36) {
                    throw new IllegalBCryptFormatException("expected separator " + Bytes.from((byte) 36).encodeUtf8() + " after version identifier and before cost factor");
                } else {
                    byte[] costBytes = {byteBuffer.get(), byteBuffer.get()};
                    try {
                        int parsedCostFactor = Integer.valueOf(new String(costBytes, this.defaultCharset)).intValue();
                        if (byteBuffer.get() != 36) {
                            throw new IllegalBCryptFormatException("expected separator " + Bytes.from((byte) 36).encodeUtf8() + " after cost factor");
                        } else if (bcryptHash.length != 60) {
                            throw new IllegalBCryptFormatException("hash expected to be exactly 60 bytes");
                        } else {
                            byte[] salt = new byte[22];
                            byte[] hash = new byte[31];
                            byteBuffer.get(salt);
                            byteBuffer.get(hash);
                            return new BCrypt.HashData(parsedCostFactor, usedVersion, this.encoder.decode(salt), this.encoder.decode(hash));
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalBCryptFormatException("cannot parse cost factor '" + new String(costBytes, this.defaultCharset) + "'");
                    }
                }
            }
        }
    }
}
