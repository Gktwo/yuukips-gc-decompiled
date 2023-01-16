package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: -Base64.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��\u0012\n��\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\nH��\u001a\u0016\u0010\u000b\u001a\u00020\n*\u00020\u00012\b\b\u0002\u0010\f\u001a\u00020\u0001H��\"\u001c\u0010��\u001a\u00020\u00018��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u00020\u00018��X\u0004¢\u0006\u000e\n��\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\u0005¨\u0006\r"}, m373d2 = {"BASE64", "", "getBASE64$annotations", "()V", "getBASE64", "()[B", "BASE64_URL_SAFE", "getBASE64_URL_SAFE$annotations", "getBASE64_URL_SAFE", "decodeBase64ToArray", "", "encodeBase64", "map", "okio"})
/* loaded from: grasscutter.jar:okio/_Base64Kt.class */
public final class _Base64Kt {
    @NotNull
    private static final byte[] BASE64 = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
    @NotNull
    private static final byte[] BASE64_URL_SAFE = ByteString.Companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();

    public static /* synthetic */ void getBASE64$annotations() {
    }

    public static /* synthetic */ void getBASE64_URL_SAFE$annotations() {
    }

    @NotNull
    public static final byte[] getBASE64() {
        return BASE64;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return BASE64_URL_SAFE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01b8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01d6  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0209  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] decodeBase64ToArray(@org.jetbrains.annotations.NotNull java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 540
        */
        throw new UnsupportedOperationException("Method not decompiled: okio._Base64Kt.decodeBase64ToArray(java.lang.String):byte[]");
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = BASE64;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] $this$encodeBase64, @NotNull byte[] map) {
        Intrinsics.checkNotNullParameter($this$encodeBase64, "<this>");
        Intrinsics.checkNotNullParameter(map, "map");
        byte[] out = new byte[(($this$encodeBase64.length + 2) / 3) * 4];
        int index = 0;
        int end = $this$encodeBase64.length - ($this$encodeBase64.length % 3);
        int i = 0;
        while (i < end) {
            int i2 = i + 1;
            byte b = $this$encodeBase64[i];
            int i3 = i2 + 1;
            byte b2 = $this$encodeBase64[i2];
            i = i3 + 1;
            byte b3 = $this$encodeBase64[i3];
            int index2 = index + 1;
            out[index] = map[(b & 255) >> 2];
            int index3 = index2 + 1;
            out[index2] = map[((b & 3) << 4) | ((b2 & 255) >> 4)];
            int index4 = index3 + 1;
            out[index3] = map[((b2 & 15) << 2) | ((b3 & 255) >> 6)];
            index = index4 + 1;
            out[index4] = map[b3 & 63];
        }
        switch ($this$encodeBase64.length - end) {
            case 1:
                byte b4 = $this$encodeBase64[i];
                int index5 = index + 1;
                out[index] = map[(b4 & 255) >> 2];
                int index6 = index5 + 1;
                out[index5] = map[(b4 & 3) << 4];
                out[index6] = (byte) 61;
                out[index6 + 1] = (byte) 61;
                break;
            case 2:
                byte b5 = $this$encodeBase64[i];
                byte b6 = $this$encodeBase64[i + 1];
                int index7 = index + 1;
                out[index] = map[(b5 & 255) >> 2];
                int index8 = index7 + 1;
                out[index7] = map[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
                out[index8] = map[(b6 & 15) << 2];
                out[index8 + 1] = (byte) 61;
                break;
        }
        return _JvmPlatformKt.toUtf8String(out);
    }
}
