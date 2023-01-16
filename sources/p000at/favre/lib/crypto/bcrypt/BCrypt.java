package p000at.favre.lib.crypto.bcrypt;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import p000at.favre.lib.bytes.Bytes;
import p000at.favre.lib.bytes.BytesTransformer;
import p000at.favre.lib.bytes.BytesValidators;
import p000at.favre.lib.bytes.MutableBytes;
import p000at.favre.lib.crypto.bcrypt.BCryptFormatter;
import p000at.favre.lib.crypto.bcrypt.BCryptParser;
import p000at.favre.lib.crypto.bcrypt.LongPasswordStrategy;
import p000at.favre.lib.crypto.bcrypt.Radix64Encoder;

/* renamed from: at.favre.lib.crypto.bcrypt.BCrypt */
/* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt.class */
public final class BCrypt {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    public static final int SALT_LENGTH = 16;
    public static final int MAX_PW_LENGTH_BYTE = 71;
    public static final int MIN_COST = 4;
    public static final int MAX_COST = 31;
    static final byte MAJOR_VERSION = 50;
    static final int HASH_OUT_LENGTH = 23;
    static final byte SEPARATOR = 36;

    private BCrypt() {
    }

    public static Hasher withDefaults() {
        return new Hasher(Version.VERSION_2A, new SecureRandom(), new LongPasswordStrategy.StrictMaxPasswordLengthStrategy(71));
    }

    public static Hasher with(Version version) {
        return new Hasher(version, new SecureRandom(), new LongPasswordStrategy.StrictMaxPasswordLengthStrategy(71));
    }

    public static Hasher with(SecureRandom secureRandom) {
        return new Hasher(Version.VERSION_2A, secureRandom, new LongPasswordStrategy.StrictMaxPasswordLengthStrategy(71));
    }

    public static Hasher with(LongPasswordStrategy longPasswordStrategy) {
        return new Hasher(Version.VERSION_2A, new SecureRandom(), longPasswordStrategy);
    }

    public static Hasher with(Version version, SecureRandom secureRandom, LongPasswordStrategy longPasswordStrategy) {
        return new Hasher(version, secureRandom, longPasswordStrategy);
    }

    public static Verifyer verifyer() {
        return new Verifyer();
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.BCrypt$Hasher */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt$Hasher.class */
    public static final class Hasher {
        private final Charset defaultCharset;
        private final Version version;
        private final SecureRandom secureRandom;
        private final LongPasswordStrategy longPasswordStrategy;

        private Hasher(Version version, SecureRandom secureRandom, LongPasswordStrategy longPasswordStrategy) {
            this.defaultCharset = BCrypt.DEFAULT_CHARSET;
            this.version = version;
            this.secureRandom = secureRandom;
            this.longPasswordStrategy = longPasswordStrategy;
        }

        public char[] hashToChar(int cost, char[] password) {
            return this.defaultCharset.decode(ByteBuffer.wrap(hash(cost, password))).array();
        }

        public String hashToString(int cost, char[] password) {
            return new String(hash(cost, password), this.defaultCharset);
        }

        public byte[] hash(int cost, char[] password) {
            if (password == null) {
                throw new IllegalArgumentException("provided password must not be null");
            }
            byte[] passwordBytes = null;
            try {
                passwordBytes = Bytes.from(password, this.defaultCharset).array();
                byte[] hash = hash(cost, Bytes.random(16, this.secureRandom).array(), passwordBytes);
                Bytes.wrapNullSafe(passwordBytes).mutable().secureWipe();
                return hash;
            } catch (Throwable th) {
                Bytes.wrapNullSafe(passwordBytes).mutable().secureWipe();
                throw th;
            }
        }

        public byte[] hash(int cost, byte[] password) {
            return hash(cost, Bytes.random(16, this.secureRandom).array(), password);
        }

        public byte[] hash(int cost, byte[] salt, byte[] password) {
            return this.version.formatter.createHashMessage(hashRaw(cost, salt, password));
        }

        public HashData hashRaw(int cost, byte[] salt, byte[] password) {
            byte[] bArr;
            if (cost > 31 || cost < 4) {
                throw new IllegalArgumentException("cost factor must be between 4 and 31, was " + cost);
            } else if (salt == null) {
                throw new IllegalArgumentException("salt must not be null");
            } else if (salt.length != 16) {
                throw new IllegalArgumentException("salt must be exactly 16 bytes, was " + salt.length);
            } else if (password == null) {
                throw new IllegalArgumentException("provided password must not be null");
            } else if (this.version.appendNullTerminator || password.length != 0) {
                if (password.length > 71 + (this.version.appendNullTerminator ? 0 : 1)) {
                    password = this.longPasswordStrategy.derive(password);
                }
                byte[] pwWithNullTerminator = this.version.appendNullTerminator ? Bytes.wrap(password).append((byte) 0).array() : Bytes.wrap(password).copy().array();
                try {
                    byte[] hash = new BCryptOpenBSDProtocol().cryptRaw(1 << ((int) ((long) cost)), salt, pwWithNullTerminator);
                    Version version = this.version;
                    if (this.version.useOnly23bytesForHash) {
                        bArr = Bytes.wrap(hash).resize(23, BytesTransformer.ResizeTransformer.Mode.RESIZE_KEEP_FROM_ZERO_INDEX).array();
                    } else {
                        bArr = hash;
                    }
                    HashData hashData = new HashData(cost, version, salt, bArr);
                    Bytes.wrapNullSafe(pwWithNullTerminator).mutable().secureWipe();
                    return hashData;
                } catch (Throwable th) {
                    Bytes.wrapNullSafe(pwWithNullTerminator).mutable().secureWipe();
                    throw th;
                }
            } else {
                throw new IllegalArgumentException("provided password must at least be length 1 if no null terminator is appended");
            }
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.BCrypt$HashData */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt$HashData.class */
    public static final class HashData {
        public final int cost;
        public final Version version;
        public final byte[] rawSalt;
        public final byte[] rawHash;

        public HashData(int cost, Version version, byte[] rawSalt, byte[] rawHash) {
            Objects.requireNonNull(rawHash);
            Objects.requireNonNull(rawSalt);
            Objects.requireNonNull(version);
            if (!Bytes.wrap(rawSalt).validate(BytesValidators.exactLength(16)) || !Bytes.wrap(rawHash).validate(BytesValidators.m1593or(BytesValidators.exactLength(23), BytesValidators.exactLength(24)))) {
                throw new IllegalArgumentException("salt must be exactly 16 bytes and hash 23 bytes long");
            }
            this.cost = cost;
            this.version = version;
            this.rawSalt = rawSalt;
            this.rawHash = rawHash;
        }

        public void wipe() {
            Bytes.wrapNullSafe(this.rawSalt).mutable().secureWipe();
            Bytes.wrapNullSafe(this.rawHash).mutable().secureWipe();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            HashData hashData = (HashData) o;
            return this.cost == hashData.cost && this.version == hashData.version && Bytes.wrap(this.rawSalt).equalsConstantTime(hashData.rawSalt) && Bytes.wrap(this.rawHash).equalsConstantTime(hashData.rawHash);
        }

        public int hashCode() {
            return (31 * ((31 * Objects.hash(Integer.valueOf(this.cost), this.version)) + Arrays.hashCode(this.rawSalt))) + Arrays.hashCode(this.rawHash);
        }

        public String toString() {
            return "HashData{cost=" + this.cost + ", version=" + this.version + ", rawSalt=" + Bytes.wrap(this.rawSalt).encodeHex() + ", rawHash=" + Bytes.wrap(this.rawHash).encodeHex() + '}';
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.BCrypt$Verifyer */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt$Verifyer.class */
    public static final class Verifyer {
        private final Charset defaultCharset;

        private Verifyer() {
            this.defaultCharset = BCrypt.DEFAULT_CHARSET;
        }

        public Result verifyStrict(byte[] password, byte[] bcryptHash, Version expectedVersion) {
            return verify(password, bcryptHash, expectedVersion);
        }

        public Result verify(byte[] password, byte[] bcryptHash) {
            return verify(password, bcryptHash, (Version) null);
        }

        public Result verifyStrict(char[] password, char[] bcryptHash, Version expectedVersion) {
            return verify(password, bcryptHash, expectedVersion);
        }

        public Result verify(char[] password, char[] bcryptHash) {
            return verify(password, bcryptHash, (Version) null);
        }

        public Result verify(char[] password, CharSequence bcryptHash) {
            return verify(password, toCharArray(bcryptHash), (Version) null);
        }

        public Result verify(char[] password, byte[] bcryptHash) {
            MutableBytes pw = Bytes.from(password, this.defaultCharset).mutable();
            Throwable th = null;
            try {
                Result verify = verify(pw.array(), bcryptHash, (Version) null);
                if (pw != null) {
                    if (0 != 0) {
                        try {
                            pw.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        pw.close();
                    }
                }
                return verify;
            } catch (Throwable th3) {
                if (pw != null) {
                    if (0 != 0) {
                        try {
                            pw.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        pw.close();
                    }
                }
                throw th3;
            }
        }

        private static char[] toCharArray(CharSequence charSequence) {
            if (charSequence instanceof String) {
                return charSequence.toString().toCharArray();
            }
            char[] buffer = new char[charSequence.length()];
            for (int i = 0; i < charSequence.length(); i++) {
                buffer[i] = charSequence.charAt(i);
            }
            return buffer;
        }

        private Result verify(char[] password, char[] bcryptHash, Version requiredVersion) {
            byte[] passwordBytes = null;
            byte[] bcryptHashBytes = null;
            try {
                passwordBytes = Bytes.from(password, this.defaultCharset).array();
                bcryptHashBytes = Bytes.from(bcryptHash, this.defaultCharset).array();
                Result verify = verify(passwordBytes, bcryptHashBytes, requiredVersion);
                Bytes.wrapNullSafe(passwordBytes).mutable().secureWipe();
                Bytes.wrapNullSafe(bcryptHashBytes).mutable().secureWipe();
                return verify;
            } catch (Throwable th) {
                Bytes.wrapNullSafe(passwordBytes).mutable().secureWipe();
                Bytes.wrapNullSafe(bcryptHashBytes).mutable().secureWipe();
                throw th;
            }
        }

        private Result verify(byte[] password, byte[] bcryptHash, Version requiredVersion) {
            Objects.requireNonNull(bcryptHash);
            try {
                HashData hashData = (requiredVersion == null ? Version.VERSION_2A.parser : requiredVersion.parser).parse(bcryptHash);
                if (requiredVersion == null || hashData.version == requiredVersion) {
                    return verify(password, hashData.cost, hashData.rawSalt, hashData.rawHash);
                }
                return new Result(hashData, false);
            } catch (IllegalBCryptFormatException e) {
                return new Result(e);
            }
        }

        public Result verify(byte[] password, HashData bcryptHashData) {
            return verify(password, bcryptHashData.cost, bcryptHashData.rawSalt, bcryptHashData.rawHash);
        }

        public Result verify(byte[] password, int cost, byte[] salt, byte[] rawBcryptHash23Bytes) {
            Objects.requireNonNull(password);
            Objects.requireNonNull(rawBcryptHash23Bytes);
            Objects.requireNonNull(salt);
            HashData hashData = BCrypt.withDefaults().hashRaw(cost, salt, password);
            return new Result(hashData, Bytes.wrap(hashData.rawHash).equalsConstantTime(rawBcryptHash23Bytes));
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.BCrypt$Result */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt$Result.class */
    public static final class Result {
        public final HashData details;
        public final boolean validFormat;
        public final boolean verified;
        public final String formatErrorMessage;

        Result(IllegalBCryptFormatException e) {
            this(null, false, false, e.getMessage());
        }

        Result(HashData details, boolean verified) {
            this(details, true, verified, null);
        }

        private Result(HashData details, boolean validFormat, boolean verified, String formatErrorMessage) {
            this.details = details;
            this.validFormat = validFormat;
            this.verified = verified;
            this.formatErrorMessage = formatErrorMessage;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Result result = (Result) o;
            return this.validFormat == result.validFormat && this.verified == result.verified && Objects.equals(this.details, result.details) && Objects.equals(this.formatErrorMessage, result.formatErrorMessage);
        }

        public int hashCode() {
            return Objects.hash(this.details, Boolean.valueOf(this.validFormat), Boolean.valueOf(this.verified), this.formatErrorMessage);
        }

        public String toString() {
            return "Result{details=" + this.details + ", validFormat=" + this.validFormat + ", verified=" + this.verified + ", formatErrorMessage='" + this.formatErrorMessage + "'}";
        }
    }

    /* renamed from: at.favre.lib.crypto.bcrypt.BCrypt$Version */
    /* loaded from: grasscutter.jar:at/favre/lib/crypto/bcrypt/BCrypt$Version.class */
    public static final class Version {
        private static final BCryptFormatter DEFAULT_FORMATTER = new BCryptFormatter.Default(new Radix64Encoder.Default(), BCrypt.DEFAULT_CHARSET);
        private static final BCryptParser DEFAULT_PARSER = new BCryptParser.Default(new Radix64Encoder.Default(), BCrypt.DEFAULT_CHARSET);
        public static final Version VERSION_2A = new Version(new byte[]{50, 97}, DEFAULT_FORMATTER, DEFAULT_PARSER);
        public static final Version VERSION_2B = new Version(new byte[]{50, 98}, DEFAULT_FORMATTER, DEFAULT_PARSER);
        public static final Version VERSION_2X = new Version(new byte[]{50, 120}, DEFAULT_FORMATTER, DEFAULT_PARSER);
        public static final Version VERSION_2Y = new Version(new byte[]{50, 121}, DEFAULT_FORMATTER, DEFAULT_PARSER);
        public static final Version VERSION_BC = new Version(new byte[]{50, 99}, false, false, DEFAULT_FORMATTER, DEFAULT_PARSER);
        public static final List<Version> SUPPORTED_VERSIONS = Collections.unmodifiableList(Arrays.asList(VERSION_2A, VERSION_2B, VERSION_2X, VERSION_2Y));
        public final byte[] versionIdentifier;
        public final boolean useOnly23bytesForHash;
        public final boolean appendNullTerminator;
        public final BCryptFormatter formatter;
        public final BCryptParser parser;

        private Version(byte[] versionIdentifier, BCryptFormatter formatter, BCryptParser parser) {
            this(versionIdentifier, true, true, formatter, parser);
        }

        public Version(byte[] versionIdentifier, boolean useOnly23bytesForHash, boolean appendNullTerminator, BCryptFormatter formatter, BCryptParser parser) {
            this.versionIdentifier = versionIdentifier;
            this.useOnly23bytesForHash = useOnly23bytesForHash;
            this.appendNullTerminator = appendNullTerminator;
            this.formatter = formatter;
            this.parser = parser;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Version version = (Version) o;
            return this.useOnly23bytesForHash == version.useOnly23bytesForHash && this.appendNullTerminator == version.appendNullTerminator && Arrays.equals(this.versionIdentifier, version.versionIdentifier);
        }

        public int hashCode() {
            return (31 * Objects.hash(Boolean.valueOf(this.useOnly23bytesForHash), Boolean.valueOf(this.appendNullTerminator))) + Arrays.hashCode(this.versionIdentifier);
        }

        public String toString() {
            return "$" + new String(this.versionIdentifier) + "$";
        }
    }
}
