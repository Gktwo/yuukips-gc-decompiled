package okio;

import java.io.IOException;
import java.security.MessageDigest;
import javax.crypto.Mac;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: HashingSink.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\u0018�� \u001a2\u00020\u00012\u00020\u0002:\u0001\u001aB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000eH\u0007¢\u0006\u0002\b\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u0011\u0010\u0010\u001a\u00020\u000e8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n��R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n��¨\u0006\u001b"}, m373d2 = {"Lokio/HashingSink;", "Lokio/ForwardingSink;", "Lokio/Sink;", "sink", "digest", "Ljava/security/MessageDigest;", "(Lokio/Sink;Ljava/security/MessageDigest;)V", "algorithm", "", "(Lokio/Sink;Ljava/lang/String;)V", "mac", "Ljavax/crypto/Mac;", "(Lokio/Sink;Ljavax/crypto/Mac;)V", Action.KEY_ATTRIBUTE, "Lokio/ByteString;", "(Lokio/Sink;Lokio/ByteString;Ljava/lang/String;)V", "hash", "()Lokio/ByteString;", "messageDigest", "-deprecated_hash", "write", "", "source", "Lokio/Buffer;", "byteCount", "", "Companion", "okio"})
/* loaded from: grasscutter.jar:okio/HashingSink.class */
public final class HashingSink extends ForwardingSink implements Sink {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final MessageDigest messageDigest;
    @Nullable
    private final Mac mac;

    @JvmStatic
    @NotNull
    public static final HashingSink md5(@NotNull Sink sink) {
        return Companion.md5(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha1(@NotNull Sink sink) {
        return Companion.sha1(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha256(@NotNull Sink sink) {
        return Companion.sha256(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink sha512(@NotNull Sink sink) {
        return Companion.sha512(sink);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
        return Companion.hmacSha1(sink, key);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
        return Companion.hmacSha256(sink, key);
    }

    @JvmStatic
    @NotNull
    public static final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
        return Companion.hmacSha512(sink, key);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull MessageDigest digest) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(digest, "digest");
        this.messageDigest = digest;
        this.mac = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSink(@org.jetbrains.annotations.NotNull okio.Sink r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r7
            java.lang.String r1 = "algorithm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            r1 = r6
            r2 = r7
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)
            r8 = r2
            r2 = r8
            java.lang.String r3 = "getInstance(algorithm)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r2 = r8
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, java.lang.String):void");
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public HashingSink(@NotNull Sink sink, @NotNull Mac mac) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(mac, "mac");
        this.mac = mac;
        this.messageDigest = null;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public HashingSink(@org.jetbrains.annotations.NotNull okio.Sink r7, @org.jetbrains.annotations.NotNull okio.ByteString r8, @org.jetbrains.annotations.NotNull java.lang.String r9) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r8
            java.lang.String r1 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r9
            java.lang.String r1 = "algorithm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            r1 = r7
            r17 = r1
            r16 = r0
            r0 = r16
            r1 = r17
            r2 = r9
            javax.crypto.Mac r2 = javax.crypto.Mac.getInstance(r2)     // Catch: InvalidKeyException -> 0x0059
            r11 = r2
            r2 = 0
            r12 = r2
            r2 = 0
            r13 = r2
            r2 = r11
            r14 = r2
            r19 = r1
            r18 = r0
            r0 = 0
            r15 = r0
            r0 = r14
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec     // Catch: InvalidKeyException -> 0x0059
            r2 = r1
            r3 = r8
            byte[] r3 = r3.toByteArray()     // Catch: InvalidKeyException -> 0x0059
            r4 = r9
            r2.<init>(r3, r4)     // Catch: InvalidKeyException -> 0x0059
            java.security.Key r1 = (java.security.Key) r1     // Catch: InvalidKeyException -> 0x0059
            r0.init(r1)     // Catch: InvalidKeyException -> 0x0059
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: InvalidKeyException -> 0x0059
            r20 = r0
            r0 = r18
            r1 = r19
            r2 = r11
            r11 = r2
            goto L_0x006c
        L_0x0059:
            r12 = move-exception
            r2 = r16
            r3 = r17
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            r5 = r4
            r6 = r12
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r5.<init>(r6)
            throw r4
        L_0x006c:
            r2 = r11
            r10 = r2
            r2 = r10
            java.lang.String r3 = "try {\n      Mac.getInsta…rgumentException(e)\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r2 = r10
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.HashingSink.<init>(okio.Sink, okio.ByteString, java.lang.String):void");
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    @Override // okio.ForwardingSink, okio.Sink
    public void write(@NotNull Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        _UtilKt.checkOffsetAndCount(source.size(), 0, byteCount);
        char c = 0;
        Segment s = source.head;
        Intrinsics.checkNotNull(s);
        while (c < byteCount) {
            int toHash = (int) Math.min(byteCount - c, (long) (s.limit - s.pos));
            if (this.messageDigest != null) {
                this.messageDigest.update(s.data, s.pos, toHash);
            } else {
                Mac mac = this.mac;
                Intrinsics.checkNotNull(mac);
                mac.update(s.data, s.pos, toHash);
            }
            c += (long) toHash;
            s = s.next;
            Intrinsics.checkNotNull(s);
        }
        write(source, byteCount);
    }

    @JvmName(name = "hash")
    @NotNull
    public final ByteString hash() {
        byte[] result;
        if (this.messageDigest != null) {
            result = this.messageDigest.digest();
        } else {
            Mac mac = this.mac;
            Intrinsics.checkNotNull(mac);
            result = mac.doFinal();
        }
        Intrinsics.checkNotNullExpressionValue(result, "result");
        return new ByteString(result);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "hash", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_hash")
    @NotNull
    /* renamed from: -deprecated_hash  reason: not valid java name */
    public final ByteString m9391deprecated_hash() {
        return hash();
    }

    /* compiled from: HashingSink.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u000f"}, m373d2 = {"Lokio/HashingSink$Companion;", "", "()V", "hmacSha1", "Lokio/HashingSink;", "sink", "Lokio/Sink;", Action.KEY_ATTRIBUTE, "Lokio/ByteString;", "hmacSha256", "hmacSha512", "md5", "sha1", "sha256", "sha512", "okio"})
    /* loaded from: grasscutter.jar:okio/HashingSink$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final HashingSink md5(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "MD5");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha1(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha256(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink sha512(@NotNull Sink sink) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            return new HashingSink(sink, "SHA-512");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha1(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            return new HashingSink(sink, key, "HmacSHA1");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha256(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            return new HashingSink(sink, key, "HmacSHA256");
        }

        @JvmStatic
        @NotNull
        public final HashingSink hmacSha512(@NotNull Sink sink, @NotNull ByteString key) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            return new HashingSink(sink, key, "HmacSHA512");
        }
    }
}
