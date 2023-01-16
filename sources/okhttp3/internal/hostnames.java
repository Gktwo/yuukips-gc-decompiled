package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.Buffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.http.sse.EmitterKt;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��&\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0002\u001a\"\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0003H\u0002\u001a\f\u0010\u000e\u001a\u0004\u0018\u00010\u0003*\u00020\u0003¨\u0006\u000f"}, m373d2 = {"decodeIpv4Suffix", "", "input", "", "pos", "", "limit", "address", "", "addressOffset", "decodeIpv6", "Ljava/net/InetAddress;", "inet6AddressToAscii", "containsInvalidHostnameAsciiCodes", "toCanonicalHost", "okhttp"})
/* renamed from: okhttp3.internal.HostnamesKt */
/* loaded from: grasscutter.jar:okhttp3/internal/HostnamesKt.class */
public final class hostnames {
    @Nullable
    public static final String toCanonicalHost(@NotNull String $this$toCanonicalHost) {
        InetAddress inetAddress;
        Intrinsics.checkNotNullParameter($this$toCanonicalHost, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toCanonicalHost, (CharSequence) EmitterKt.COMMENT_PREFIX, false, 2, (Object) null)) {
            if (!StringsKt.startsWith$default($this$toCanonicalHost, "[", false, 2, (Object) null) || !StringsKt.endsWith$default($this$toCanonicalHost, "]", false, 2, (Object) null)) {
                inetAddress = decodeIpv6($this$toCanonicalHost, 0, $this$toCanonicalHost.length());
            } else {
                inetAddress = decodeIpv6($this$toCanonicalHost, 1, $this$toCanonicalHost.length() - 1);
            }
            if (inetAddress == null) {
                return null;
            }
            byte[] address = inetAddress.getAddress();
            if (address.length == 16) {
                Intrinsics.checkNotNullExpressionValue(address, "address");
                return inet6AddressToAscii(address);
            } else if (address.length == 4) {
                return inetAddress.getHostAddress();
            } else {
                throw new AssertionError("Invalid IPv6 address: '" + $this$toCanonicalHost + '\'');
            }
        } else {
            try {
                String ascii = IDN.toASCII($this$toCanonicalHost);
                Intrinsics.checkNotNullExpressionValue(ascii, "toASCII(host)");
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                String result = ascii.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(result, "this as java.lang.String).toLowerCase(locale)");
                if (!(result.length() == 0) && !containsInvalidHostnameAsciiCodes(result)) {
                    return result;
                }
                return null;
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean containsInvalidHostnameAsciiCodes(java.lang.String r7) {
        /*
            r0 = 0
            r8 = r0
            r0 = r7
            int r0 = r0.length()
            r9 = r0
        L_0x0007:
            r0 = r8
            r1 = r9
            if (r0 >= r1) goto L_0x0043
            r0 = r8
            r10 = r0
            int r8 = r8 + 1
            r0 = r7
            r1 = r10
            char r0 = r0.charAt(r1)
            r11 = r0
            r0 = r11
            r1 = 31
            int r0 = kotlin.jvm.internal.Intrinsics.compare(r0, r1)
            if (r0 <= 0) goto L_0x002c
            r0 = r11
            r1 = 127(0x7f, float:1.78E-43)
            int r0 = kotlin.jvm.internal.Intrinsics.compare(r0, r1)
            if (r0 < 0) goto L_0x002e
        L_0x002c:
            r0 = 1
            return r0
        L_0x002e:
            java.lang.String r0 = " #%/:?@[\\]"
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = r11
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.indexOf$default(r0, r1, r2, r3, r4, r5)
            r1 = -1
            if (r0 == r1) goto L_0x0007
            r0 = 1
            return r0
        L_0x0043:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.hostnames.containsInvalidHostnameAsciiCodes(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0117, code lost:
        if (r11 == r0.length) goto L_0x0145;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x011d, code lost:
        if (r12 != -1) goto L_0x0122;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0120, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0122, code lost:
        java.lang.System.arraycopy(r0, r12, r0, r0.length - (r11 - r12), r11 - r12);
        java.util.Arrays.fill(r0, r12, r12 + (r0.length - r11), (byte) 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0149, code lost:
        return java.net.InetAddress.getByAddress(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r7, int r8, int r9) {
        /*
        // Method dump skipped, instructions count: 330
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.hostnames.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final boolean decodeIpv4Suffix(String input, int pos, int limit, byte[] address, int addressOffset) {
        int b = addressOffset;
        int i = pos;
        while (i < limit) {
            if (b == address.length) {
                return false;
            }
            if (b != addressOffset) {
                if (input.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int value = 0;
            while (i < limit) {
                char c = input.charAt(i);
                if (Intrinsics.compare((int) c, 48) < 0 || Intrinsics.compare((int) c, 57) > 0) {
                    break;
                } else if (value == 0 && i != i) {
                    return false;
                } else {
                    value = ((value * 10) + c) - 48;
                    if (value > 255) {
                        return false;
                    }
                    i++;
                }
            }
            if (i - i == 0) {
                return false;
            }
            b++;
            address[b] = (byte) value;
        }
        return b == addressOffset + 4;
    }

    private static final String inet6AddressToAscii(byte[] address) {
        int longestRunOffset = -1;
        int longestRunLength = 0;
        int i = 0;
        while (i < address.length) {
            while (i < 16 && address[i] == 0 && address[i + 1] == 0) {
                i += 2;
            }
            int currentRunLength = i - i;
            if (currentRunLength > longestRunLength && currentRunLength >= 4) {
                longestRunOffset = i;
                longestRunLength = currentRunLength;
            }
            i += 2;
        }
        Buffer result = new Buffer();
        int i2 = 0;
        while (i2 < address.length) {
            if (i2 == longestRunOffset) {
                result.writeByte(58);
                i2 += longestRunLength;
                if (i2 == 16) {
                    result.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    result.writeByte(58);
                }
                result.writeHexadecimalUnsignedLong((long) ((Util.and(address[i2], 255) << 8) | Util.and(address[i2 + 1], 255)));
                i2 += 2;
            }
        }
        return result.readUtf8();
    }
}
