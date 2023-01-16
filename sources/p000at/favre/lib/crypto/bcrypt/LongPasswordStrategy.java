package p000at.favre.lib.crypto.bcrypt;

import p000at.favre.lib.bytes.Bytes;
import p000at.favre.lib.bytes.BytesTransformer;

/* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategy */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategy.class */
public interface LongPasswordStrategy {
    byte[] derive(byte[] bArr);

    /* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategy$BaseLongPasswordStrategy */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategy$BaseLongPasswordStrategy.class */
    public static abstract class BaseLongPasswordStrategy implements LongPasswordStrategy {
        final int maxLength;

        abstract byte[] innerDerive(byte[] bArr);

        private BaseLongPasswordStrategy(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override // p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy
        public byte[] derive(byte[] rawPassword) {
            if (rawPassword.length >= this.maxLength) {
                return innerDerive(rawPassword);
            }
            return rawPassword;
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategy$StrictMaxPasswordLengthStrategy */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategy$StrictMaxPasswordLengthStrategy.class */
    public static final class StrictMaxPasswordLengthStrategy extends BaseLongPasswordStrategy {
        /* access modifiers changed from: package-private */
        public StrictMaxPasswordLengthStrategy(int maxLength) {
            super(maxLength);
        }

        @Override // p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy.BaseLongPasswordStrategy
        public byte[] innerDerive(byte[] rawPassword) {
            throw new IllegalArgumentException("password must not be longer than " + this.maxLength + " bytes plus null terminator encoded in utf-8, was " + rawPassword.length);
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategy$Sha512DerivationStrategy */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategy$Sha512DerivationStrategy.class */
    public static final class Sha512DerivationStrategy extends BaseLongPasswordStrategy {
        /* access modifiers changed from: package-private */
        public Sha512DerivationStrategy(int maxLength) {
            super(maxLength);
        }

        @Override // p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy.BaseLongPasswordStrategy
        public byte[] innerDerive(byte[] rawPassword) {
            return Bytes.wrap(rawPassword).hash("SHA-512").array();
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.LongPasswordStrategy$TruncateStrategy */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/LongPasswordStrategy$TruncateStrategy.class */
    public static final class TruncateStrategy extends BaseLongPasswordStrategy {
        /* access modifiers changed from: package-private */
        public TruncateStrategy(int maxLength) {
            super(maxLength);
        }

        @Override // p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy.BaseLongPasswordStrategy
        public byte[] innerDerive(byte[] rawPassword) {
            return Bytes.wrap(rawPassword).resize(this.maxLength, BytesTransformer.ResizeTransformer.Mode.RESIZE_KEEP_FROM_ZERO_INDEX).array();
        }
    }
}
