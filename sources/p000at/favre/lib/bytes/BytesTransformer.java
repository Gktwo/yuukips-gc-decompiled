package p000at.favre.lib.bytes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import p000at.favre.lib.bytes.Util;

/* renamed from: at.favre.lib.bytes.BytesTransformer */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer.class */
public interface BytesTransformer {
    byte[] transform(byte[] bArr, boolean z);

    boolean supportInPlaceTransformation();

    /* renamed from: at.favre.lib.bytes.BytesTransformer$BitWiseOperatorTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$BitWiseOperatorTransformer.class */
    public static final class BitWiseOperatorTransformer implements BytesTransformer {
        private final byte[] secondArray;
        private final Mode mode;

        /* renamed from: at.favre.lib.bytes.BytesTransformer$BitWiseOperatorTransformer$Mode */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$BitWiseOperatorTransformer$Mode.class */
        public enum Mode {
            AND,
            OR,
            XOR
        }

        /* access modifiers changed from: package-private */
        public BitWiseOperatorTransformer(byte[] secondArray, Mode mode) {
            this.secondArray = (byte[]) Objects.requireNonNull(secondArray, "the second byte array must not be null");
            this.mode = (Mode) Objects.requireNonNull(mode, "passed bitwise mode must not be null");
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            if (currentArray.length != this.secondArray.length) {
                throw new IllegalArgumentException("all byte array must be of same length doing bit wise operation");
            }
            byte[] out = inPlace ? currentArray : new byte[currentArray.length];
            for (int i = 0; i < currentArray.length; i++) {
                switch (this.mode) {
                    case AND:
                        out[i] = (byte) (currentArray[i] & this.secondArray[i]);
                        break;
                    case XOR:
                        out[i] = (byte) (currentArray[i] ^ this.secondArray[i]);
                        break;
                    case OR:
                    default:
                        out[i] = (byte) (currentArray[i] | this.secondArray[i]);
                        break;
                }
            }
            return out;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$NegateTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$NegateTransformer.class */
    public static final class NegateTransformer implements BytesTransformer {
        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
            for (int i = 0; i < out.length; i++) {
                out[i] = (byte) (out[i] ^ -1);
            }
            return out;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$ShiftTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ShiftTransformer.class */
    public static final class ShiftTransformer implements BytesTransformer {
        private final int shiftCount;
        private final Type type;

        /* renamed from: at.favre.lib.bytes.BytesTransformer$ShiftTransformer$Type */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ShiftTransformer$Type.class */
        public enum Type {
            LEFT_SHIFT,
            RIGHT_SHIFT
        }

        /* access modifiers changed from: package-private */
        public ShiftTransformer(int shiftCount, Type type) {
            this.shiftCount = shiftCount;
            this.type = (Type) Objects.requireNonNull(type, "passed shift type must not be null");
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
            switch (this.type) {
                case RIGHT_SHIFT:
                    return Util.Byte.shiftRight(out, this.shiftCount);
                case LEFT_SHIFT:
                default:
                    return Util.Byte.shiftLeft(out, this.shiftCount);
            }
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$ConcatTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ConcatTransformer.class */
    public static final class ConcatTransformer implements BytesTransformer {
        private final byte[] secondArray;

        /* access modifiers changed from: package-private */
        public ConcatTransformer(byte[] secondArrays) {
            this.secondArray = (byte[]) Objects.requireNonNull(secondArrays, "the second byte array must not be null");
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            return Util.Byte.concat(currentArray, this.secondArray);
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$ReverseTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ReverseTransformer.class */
    public static final class ReverseTransformer implements BytesTransformer {
        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
            Util.Byte.reverse(out, 0, out.length);
            return out;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$CopyTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$CopyTransformer.class */
    public static final class CopyTransformer implements BytesTransformer {
        final int offset;
        final int length;

        /* access modifiers changed from: package-private */
        public CopyTransformer(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] copy = new byte[this.length];
            System.arraycopy(currentArray, this.offset, copy, 0, copy.length);
            return copy;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$ResizeTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ResizeTransformer.class */
    public static final class ResizeTransformer implements BytesTransformer {
        private final int newSize;
        private final Mode mode;

        /* renamed from: at.favre.lib.bytes.BytesTransformer$ResizeTransformer$Mode */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$ResizeTransformer$Mode.class */
        public enum Mode {
            RESIZE_KEEP_FROM_ZERO_INDEX,
            RESIZE_KEEP_FROM_MAX_LENGTH
        }

        /* access modifiers changed from: package-private */
        public ResizeTransformer(int newSize, Mode mode) {
            this.newSize = newSize;
            this.mode = mode;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            if (currentArray.length == this.newSize) {
                return currentArray;
            }
            if (this.newSize < 0) {
                throw new IllegalArgumentException("cannot resize to smaller than 0");
            } else if (this.newSize == 0) {
                return new byte[0];
            } else {
                byte[] resizedArray = new byte[this.newSize];
                if (this.mode != Mode.RESIZE_KEEP_FROM_MAX_LENGTH) {
                    System.arraycopy(currentArray, 0, resizedArray, 0, Math.min(currentArray.length, resizedArray.length));
                } else if (this.newSize > currentArray.length) {
                    System.arraycopy(currentArray, 0, resizedArray, Math.max(0, Math.abs(this.newSize - currentArray.length)), Math.min(this.newSize, currentArray.length));
                } else {
                    System.arraycopy(currentArray, Math.max(0, Math.abs(this.newSize - currentArray.length)), resizedArray, Math.min(0, Math.abs(this.newSize - currentArray.length)), Math.min(this.newSize, currentArray.length));
                }
                return resizedArray;
            }
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$BitSwitchTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$BitSwitchTransformer.class */
    public static class BitSwitchTransformer implements BytesTransformer {
        private final int position;
        private final Boolean newBitValue;

        /* access modifiers changed from: package-private */
        public BitSwitchTransformer(int position, Boolean newBitValue) {
            this.position = position;
            this.newBitValue = newBitValue;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
            if (this.position < 0 || this.position >= 8 * currentArray.length) {
                throw new IllegalArgumentException("bit index " + (this.position * 8) + " out of bounds");
            }
            int bytePosition = (currentArray.length - 1) - (this.position / 8);
            if (this.newBitValue == null) {
                out[bytePosition] = (byte) (out[bytePosition] ^ (1 << (this.position % 8)));
            } else if (this.newBitValue.booleanValue()) {
                out[bytePosition] = (byte) (out[bytePosition] | (1 << (this.position % 8)));
            } else {
                out[bytePosition] = (byte) (out[bytePosition] & ((1 << (this.position % 8)) ^ -1));
            }
            return out;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformer$MessageDigestTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformer$MessageDigestTransformer.class */
    public static class MessageDigestTransformer implements BytesTransformer {
        static final String ALGORITHM_MD5 = "MD5";
        static final String ALGORITHM_SHA_1 = "SHA-1";
        static final String ALGORITHM_SHA_256 = "SHA-256";
        private final MessageDigest messageDigest;

        /* access modifiers changed from: package-private */
        public MessageDigestTransformer(String digestName) {
            try {
                this.messageDigest = MessageDigest.getInstance(digestName);
            } catch (NoSuchAlgorithmException e) {
                throw new IllegalArgumentException("could not get message digest algorithm " + digestName, e);
            }
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            this.messageDigest.update(currentArray);
            return this.messageDigest.digest();
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }
}
