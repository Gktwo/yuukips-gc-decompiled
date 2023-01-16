package p000at.favre.lib.bytes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Random;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p000at.favre.lib.bytes.Util;

/* renamed from: at.favre.lib.bytes.BytesTransformers */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers.class */
public final class BytesTransformers {
    private BytesTransformers() {
    }

    public static BytesTransformer shuffle() {
        return new ShuffleTransformer(new SecureRandom());
    }

    public static BytesTransformer shuffle(Random random) {
        return new ShuffleTransformer(random);
    }

    public static BytesTransformer sort() {
        return new SortTransformer();
    }

    public static BytesTransformer sortUnsigned() {
        return new SortTransformer(new SortTransformer.UnsignedByteComparator());
    }

    public static BytesTransformer sort(Comparator<Byte> comparator) {
        return new SortTransformer(comparator);
    }

    public static BytesTransformer checksumAppendCrc32() {
        return new ChecksumTransformer(new CRC32(), ChecksumTransformer.Mode.APPEND, 4);
    }

    public static BytesTransformer checksumCrc32() {
        return new ChecksumTransformer(new CRC32(), ChecksumTransformer.Mode.TRANSFORM, 4);
    }

    public static BytesTransformer checksum(Checksum checksum, ChecksumTransformer.Mode mode, int checksumLengthByte) {
        return new ChecksumTransformer(checksum, mode, checksumLengthByte);
    }

    public static BytesTransformer compressGzip() {
        return new GzipCompressor(true);
    }

    public static BytesTransformer decompressGzip() {
        return new GzipCompressor(false);
    }

    public static BytesTransformer hmacSha1(byte[] key) {
        return new HmacTransformer(key, "HmacSHA1");
    }

    public static BytesTransformer hmacSha256(byte[] key) {
        return new HmacTransformer(key, "HmacSHA256");
    }

    public static BytesTransformer hmac(byte[] key, String algorithmName) {
        return new HmacTransformer(key, algorithmName);
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformers$ShuffleTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$ShuffleTransformer.class */
    public static final class ShuffleTransformer implements BytesTransformer {
        private final Random random;

        ShuffleTransformer(Random random) {
            Objects.requireNonNull(random, "passed random must not be null");
            this.random = random;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
            Util.Byte.shuffle(out, this.random);
            return out;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return true;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformers$SortTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$SortTransformer.class */
    public static final class SortTransformer implements BytesTransformer {
        private final Comparator comparator;

        SortTransformer() {
            this(null);
        }

        SortTransformer(Comparator<Byte> comparator) {
            this.comparator = comparator;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            if (this.comparator == null) {
                byte[] out = inPlace ? currentArray : Bytes.from(currentArray).array();
                Arrays.sort(out);
                return out;
            }
            Byte[] boxedArray = Bytes.wrap(currentArray).toBoxedArray();
            Arrays.sort(boxedArray, this.comparator);
            return Bytes.from(boxedArray).array();
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return this.comparator == null;
        }

        /* renamed from: at.favre.lib.bytes.BytesTransformers$SortTransformer$UnsignedByteComparator */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$SortTransformer$UnsignedByteComparator.class */
        static final class UnsignedByteComparator implements Comparator<Byte> {
            UnsignedByteComparator() {
            }

            public int compare(Byte o1, Byte o2) {
                int byteA = o1.byteValue() & 255;
                int byteB = o2.byteValue() & 255;
                if (byteA == byteB) {
                    return 0;
                }
                return byteA < byteB ? -1 : 1;
            }
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformers$ChecksumTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$ChecksumTransformer.class */
    public static final class ChecksumTransformer implements BytesTransformer {
        private final Checksum checksum;
        private final Mode mode;
        private final int checksumLengthByte;

        /* renamed from: at.favre.lib.bytes.BytesTransformers$ChecksumTransformer$Mode */
        /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$ChecksumTransformer$Mode.class */
        public enum Mode {
            APPEND,
            TRANSFORM
        }

        ChecksumTransformer(Checksum checksum, Mode mode, int checksumLengthByte) {
            if (checksumLengthByte <= 0 || checksumLengthByte > 8) {
                throw new IllegalArgumentException("checksum length must be between 1 and 8 bytes");
            }
            Objects.requireNonNull(checksum, "checksum instance must not be null");
            this.checksum = checksum;
            this.mode = mode;
            this.checksumLengthByte = checksumLengthByte;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            this.checksum.update(currentArray, 0, currentArray.length);
            byte[] checksumBytes = Bytes.from(this.checksum.getValue()).resize(this.checksumLengthByte).array();
            return this.mode == Mode.TRANSFORM ? checksumBytes : Bytes.from(currentArray, checksumBytes).array();
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformers$GzipCompressor */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$GzipCompressor.class */
    public static final class GzipCompressor implements BytesTransformer {
        private final boolean compress;

        GzipCompressor(boolean compress) {
            this.compress = compress;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            return this.compress ? compress(currentArray) : decompress(currentArray);
        }

        private byte[] decompress(byte[] compressedContent) {
            GZIPInputStream gzipInputStream;
            ByteArrayOutputStream bos;
            try {
                bos = new ByteArrayOutputStream();
                gzipInputStream = null;
                try {
                    byte[] buffer = new byte[4096];
                    gzipInputStream = new GZIPInputStream(new ByteArrayInputStream(compressedContent));
                    while (true) {
                        int len = gzipInputStream.read(buffer);
                        if (len <= 0) {
                            break;
                        }
                        bos.write(buffer, 0, len);
                    }
                    gzipInputStream.close();
                    byte[] returnBuffer = bos.toByteArray();
                    bos.close();
                    return returnBuffer;
                } catch (Exception e) {
                    throw new IllegalStateException("could not decompress gzip", e);
                }
            } finally {
                try {
                    bos.close();
                } catch (IOException e2) {
                }
                if (gzipInputStream != null) {
                    try {
                        gzipInputStream.close();
                    } catch (IOException e3) {
                    }
                }
            }
        }

        private byte[] compress(byte[] content) {
            GZIPOutputStream gzipOutputStream;
            ByteArrayOutputStream bos;
            try {
                bos = new ByteArrayOutputStream(content.length);
                gzipOutputStream = null;
                try {
                    gzipOutputStream = new GZIPOutputStream(bos);
                    gzipOutputStream.write(content);
                    gzipOutputStream.close();
                    byte[] returnBuffer = bos.toByteArray();
                    bos.close();
                    return returnBuffer;
                } catch (Exception e) {
                    throw new IllegalStateException("could not compress gzip", e);
                }
            } finally {
                try {
                    bos.close();
                } catch (IOException e2) {
                }
                if (gzipOutputStream != null) {
                    try {
                        gzipOutputStream.close();
                    } catch (IOException e3) {
                    }
                }
            }
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }

    /* renamed from: at.favre.lib.bytes.BytesTransformers$HmacTransformer */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/BytesTransformers$HmacTransformer.class */
    public static final class HmacTransformer implements BytesTransformer {
        static final String HMAC_SHA1 = "HmacSHA1";
        static final String HMAC_SHA256 = "HmacSHA256";
        private final byte[] secretKey;
        private final String macAlgorithmName;

        HmacTransformer(byte[] secretKey, String macAlgorithmName) {
            this.macAlgorithmName = macAlgorithmName;
            this.secretKey = secretKey;
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public byte[] transform(byte[] currentArray, boolean inPlace) {
            try {
                Mac mac = Mac.getInstance(this.macAlgorithmName);
                mac.init(new SecretKeySpec(this.secretKey, this.macAlgorithmName));
                return mac.doFinal(currentArray);
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }

        @Override // p000at.favre.lib.bytes.BytesTransformer
        public boolean supportInPlaceTransformation() {
            return false;
        }
    }
}
