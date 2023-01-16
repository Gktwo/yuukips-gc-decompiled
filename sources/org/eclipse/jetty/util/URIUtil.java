package org.eclipse.jetty.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/URIUtil.class */
public class URIUtil implements Cloneable {
    public static final String SLASH = "/";
    public static final String HTTP = "http";
    public static final String HTTPS = "https";
    private static final Logger LOG = Log.getLogger(URIUtil.class);
    public static final Charset __CHARSET = StandardCharsets.UTF_8;

    private URIUtil() {
    }

    public static String encodePath(String path) {
        if (path == null || path.length() == 0) {
            return path;
        }
        StringBuilder buf = encodePath(null, path, 0);
        return buf == null ? path : buf.toString();
    }

    public static StringBuilder encodePath(StringBuilder buf, String path) {
        return encodePath(buf, path, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00cf, code lost:
        r8 = r6.getBytes(org.eclipse.jetty.util.URIUtil.__CHARSET);
        r5 = new java.lang.StringBuilder(r6.length() * 2);
     */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0270 A[LOOP:2: B:50:0x0270->B:77:0x03e0, LOOP_START, PHI: r9 
      PHI: (r9v2 'i' int) = (r9v1 'i' int), (r9v3 'i' int) binds: [B:49:0x026d, B:77:0x03e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.StringBuilder encodePath(java.lang.StringBuilder r5, java.lang.String r6, int r7) {
        /*
        // Method dump skipped, instructions count: 1000
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.URIUtil.encodePath(java.lang.StringBuilder, java.lang.String, int):java.lang.StringBuilder");
    }

    public static String encodeSpaces(String str) {
        return StringUtil.replace(str, " ", "%20");
    }

    public static String encodeSpecific(String str, String charsToEncode) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (charsToEncode == null || charsToEncode.length() == 0) {
            return str;
        }
        char[] find = charsToEncode.toCharArray();
        int len = str.length();
        StringBuilder ret = new StringBuilder((int) (((double) len) * 0.2d));
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            boolean escaped = false;
            int length = find.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (c == find[i2]) {
                    escaped = true;
                    ret.append('%');
                    int d = 15 & ((240 & c) >> 4);
                    ret.append((char) ((d > 9 ? 55 : 48) + d));
                    int d2 = 15 & c;
                    ret.append((char) ((d2 > 9 ? 55 : 48) + d2));
                } else {
                    i2++;
                }
            }
            if (!escaped) {
                ret.append(c);
            }
        }
        return ret.toString();
    }

    public static String decodeSpecific(String str, String charsToDecode) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (charsToDecode == null || charsToDecode.length() == 0) {
            return str;
        }
        int idx = str.indexOf(37);
        if (idx == -1) {
            return str;
        }
        char[] find = charsToDecode.toCharArray();
        int len = str.length();
        Utf8StringBuilder ret = new Utf8StringBuilder(len);
        ret.append(str, 0, idx);
        int i = idx;
        while (i < len) {
            char c = str.charAt(i);
            switch (c) {
                case '%':
                    if (i + 2 < len) {
                        char result = (char) (255 & ((TypeUtil.convertHexDigit(str.charAt(i + 1)) * 16) + TypeUtil.convertHexDigit(str.charAt(i + 2))));
                        boolean decoded = false;
                        int length = find.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                if (find[i2] == result) {
                                    ret.append(result);
                                    decoded = true;
                                } else {
                                    i2++;
                                }
                            }
                        }
                        if (!decoded) {
                            ret.append(c);
                            break;
                        } else {
                            i += 2;
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException("Bad URI % encoding");
                    }
                default:
                    ret.append(c);
                    break;
            }
            i++;
        }
        return ret.toString();
    }

    public static StringBuilder encodeString(StringBuilder buf, String path, String encode) {
        if (buf == null) {
            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                if (c == '%' || encode.indexOf(c) >= 0) {
                    buf = new StringBuilder(path.length() << 1);
                    break;
                }
            }
            if (buf == null) {
                return null;
            }
        }
        for (int i2 = 0; i2 < path.length(); i2++) {
            char c2 = path.charAt(i2);
            if (c2 == '%' || encode.indexOf(c2) >= 0) {
                buf.append('%');
                StringUtil.append(buf, (byte) (255 & c2), 16);
            } else {
                buf.append(c2);
            }
        }
        return buf;
    }

    public static String decodePath(String path) {
        return decodePath(path, 0, path.length());
    }

    public static String decodePath(String path, int offset, int length) {
        try {
            Utf8StringBuilder builder = null;
            int end = offset + length;
            int i = offset;
            while (i < end) {
                char c = path.charAt(i);
                switch (c) {
                    case '%':
                        if (builder == null) {
                            builder = new Utf8StringBuilder(path.length());
                            builder.append(path, offset, i - offset);
                        }
                        if (i + 2 < end) {
                            char u = path.charAt(i + 1);
                            if (u == 'u') {
                                builder.append((char) (65535 & TypeUtil.parseInt(path, i + 2, 4, 16)));
                                i += 5;
                            } else {
                                builder.append((byte) (255 & ((TypeUtil.convertHexDigit(u) * 16) + TypeUtil.convertHexDigit(path.charAt(i + 2)))));
                                i += 2;
                            }
                            break;
                        } else {
                            throw new IllegalArgumentException("Bad URI % encoding");
                        }
                    case ';':
                        if (builder == null) {
                            builder = new Utf8StringBuilder(path.length());
                            builder.append(path, offset, i - offset);
                        }
                        while (true) {
                            i++;
                            if (i < end) {
                                if (path.charAt(i) == '/') {
                                    builder.append('/');
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                        break;
                    default:
                        if (builder == null) {
                            break;
                        } else {
                            builder.append(c);
                            break;
                        }
                }
                i++;
            }
            if (builder != null) {
                return builder.toString();
            }
            if (offset == 0 && length == path.length()) {
                return path;
            }
            return path.substring(offset, end);
        } catch (Utf8Appendable.NotUtf8Exception e) {
            LOG.debug(path.substring(offset, offset + length) + " " + e, new Object[0]);
            return decodeISO88591Path(path, offset, length);
        } catch (IllegalArgumentException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new IllegalArgumentException("cannot decode URI", e3);
        }
    }

    private static String decodeISO88591Path(String path, int offset, int length) {
        StringBuilder builder = null;
        int end = offset + length;
        int i = offset;
        while (i < end) {
            char c = path.charAt(i);
            switch (c) {
                case '%':
                    if (builder == null) {
                        builder = new StringBuilder(path.length());
                        builder.append((CharSequence) path, offset, i - offset);
                    }
                    if (i + 2 < end) {
                        char u = path.charAt(i + 1);
                        if (u != 'u') {
                            builder.append((char) (255 & ((TypeUtil.convertHexDigit(u) * 16) + TypeUtil.convertHexDigit(path.charAt(i + 2)))));
                            i += 2;
                            break;
                        } else {
                            builder.append((char) (65535 & TypeUtil.parseInt(path, i + 2, 4, 16)));
                            i += 5;
                            break;
                        }
                    } else {
                        throw new IllegalArgumentException();
                    }
                case ';':
                    if (builder == null) {
                        builder = new StringBuilder(path.length());
                        builder.append((CharSequence) path, offset, i - offset);
                    }
                    while (true) {
                        i++;
                        if (i < end) {
                            if (path.charAt(i) == '/') {
                                builder.append('/');
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    break;
                default:
                    if (builder == null) {
                        break;
                    } else {
                        builder.append(c);
                        break;
                    }
            }
            i++;
        }
        if (builder != null) {
            return builder.toString();
        }
        if (offset == 0 && length == path.length()) {
            return path;
        }
        return path.substring(offset, end);
    }

    public static String addEncodedPaths(String p1, String p2) {
        if (p1 == null || p1.length() == 0) {
            if (p1 == null || p2 != null) {
                return p2;
            }
            return p1;
        } else if (p2 == null || p2.length() == 0) {
            return p1;
        } else {
            int split = p1.indexOf(59);
            if (split < 0) {
                split = p1.indexOf(63);
            }
            if (split == 0) {
                return p2 + p1;
            }
            if (split < 0) {
                split = p1.length();
            }
            StringBuilder buf = new StringBuilder(p1.length() + p2.length() + 2);
            buf.append(p1);
            if (buf.charAt(split - 1) == '/') {
                if (p2.startsWith("/")) {
                    buf.deleteCharAt(split - 1);
                    buf.insert(split - 1, p2);
                } else {
                    buf.insert(split, p2);
                }
            } else if (p2.startsWith("/")) {
                buf.insert(split, p2);
            } else {
                buf.insert(split, '/');
                buf.insert(split + 1, p2);
            }
            return buf.toString();
        }
    }

    public static String addPaths(String p1, String p2) {
        if (p1 == null || p1.length() == 0) {
            if (p1 == null || p2 != null) {
                return p2;
            }
            return p1;
        } else if (p2 == null || p2.length() == 0) {
            return p1;
        } else {
            boolean p1EndsWithSlash = p1.endsWith("/");
            boolean p2StartsWithSlash = p2.startsWith("/");
            if (p1EndsWithSlash && p2StartsWithSlash) {
                if (p2.length() == 1) {
                    return p1;
                }
                if (p1.length() == 1) {
                    return p2;
                }
            }
            StringBuilder buf = new StringBuilder(p1.length() + p2.length() + 2);
            buf.append(p1);
            if (p1.endsWith("/")) {
                if (p2.startsWith("/")) {
                    buf.setLength(buf.length() - 1);
                }
            } else if (!p2.startsWith("/")) {
                buf.append("/");
            }
            buf.append(p2);
            return buf.toString();
        }
    }

    public static String addPathQuery(String path, String query) {
        if (query == null) {
            return path;
        }
        if (path.indexOf(63) >= 0) {
            return path + '&' + query;
        }
        return path + '?' + query;
    }

    public static String getUriLastPathSegment(URI uri) {
        String ssp = uri.getSchemeSpecificPart();
        int idx = ssp.indexOf("!/");
        if (idx != -1) {
            ssp = ssp.substring(0, idx);
        }
        if (ssp.endsWith("/")) {
            ssp = ssp.substring(0, ssp.length() - 1);
        }
        int idx2 = ssp.lastIndexOf(47);
        if (idx2 != -1) {
            ssp = ssp.substring(idx2 + 1);
        }
        return ssp;
    }

    public static String parentPath(String p) {
        int slash;
        if (p == null || "/".equals(p) || (slash = p.lastIndexOf(47, p.length() - 2)) < 0) {
            return null;
        }
        return p.substring(0, slash + 1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String canonicalURI(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 327
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.URIUtil.canonicalURI(java.lang.String):java.lang.String");
    }

    @Deprecated
    public static String canonicalEncodedPath(String path) {
        return canonicalURI(path);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String canonicalPath(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 274
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.URIUtil.canonicalPath(java.lang.String):java.lang.String");
    }

    private static boolean doDots(StringBuilder canonical, int dots) {
        switch (dots) {
            case 0:
            case 1:
                return false;
            case 2:
                if (canonical.length() < 2) {
                    return true;
                }
                canonical.setLength(canonical.length() - 1);
                canonical.setLength(canonical.lastIndexOf("/") + 1);
                return false;
        }
        while (true) {
            dots--;
            if (dots <= 0) {
                return false;
            }
            canonical.append('.');
        }
    }

    private static boolean doDotsSlash(StringBuilder canonical, int dots) {
        switch (dots) {
            case 0:
                canonical.append('/');
                return false;
            case 1:
                return false;
            case 2:
                if (canonical.length() < 2) {
                    return true;
                }
                canonical.setLength(canonical.length() - 1);
                canonical.setLength(canonical.lastIndexOf("/") + 1);
                return false;
        }
        while (true) {
            dots--;
            if (dots > 0) {
                canonical.append('.');
            } else {
                canonical.append('/');
                return false;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String compactPath(java.lang.String r5) {
        /*
            r0 = r5
            if (r0 == 0) goto L_0x000b
            r0 = r5
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000d
        L_0x000b:
            r0 = r5
            return r0
        L_0x000d:
            r0 = 0
            r6 = r0
            r0 = r5
            int r0 = r0.length()
            r7 = r0
            r0 = 0
            r8 = r0
        L_0x0016:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L_0x0055
            r0 = r5
            r1 = r8
            char r0 = r0.charAt(r1)
            r9 = r0
            r0 = r9
            switch(r0) {
                case 47: goto L_0x0042;
                case 63: goto L_0x0040;
                default: goto L_0x004d;
            }
        L_0x0040:
            r0 = r5
            return r0
        L_0x0042:
            int r6 = r6 + 1
            r0 = r6
            r1 = 2
            if (r0 != r1) goto L_0x004f
            goto L_0x0055
        L_0x004d:
            r0 = 0
            r6 = r0
        L_0x004f:
            int r8 = r8 + 1
            goto L_0x0016
        L_0x0055:
            r0 = r6
            r1 = 2
            if (r0 >= r1) goto L_0x005c
            r0 = r5
            return r0
        L_0x005c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r2 = r5
            int r2 = r2.length()
            r1.<init>(r2)
            r9 = r0
            r0 = r9
            r1 = r5
            r2 = 0
            r3 = r8
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
        L_0x0072:
            r0 = r8
            r1 = r7
            if (r0 >= r1) goto L_0x00ca
            r0 = r5
            r1 = r8
            char r0 = r0.charAt(r1)
            r10 = r0
            r0 = r10
            switch(r0) {
                case 47: goto L_0x00a8;
                case 63: goto L_0x009c;
                default: goto L_0x00ba;
            }
        L_0x009c:
            r0 = r9
            r1 = r5
            r2 = r8
            r3 = r7
            java.lang.StringBuilder r0 = r0.append(r1, r2, r3)
            goto L_0x00ca
        L_0x00a8:
            r0 = r6
            int r6 = r6 + 1
            if (r0 != 0) goto L_0x00c4
            r0 = r9
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
            goto L_0x00c4
        L_0x00ba:
            r0 = 0
            r6 = r0
            r0 = r9
            r1 = r10
            java.lang.StringBuilder r0 = r0.append(r1)
        L_0x00c4:
            int r8 = r8 + 1
            goto L_0x0072
        L_0x00ca:
            r0 = r9
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.URIUtil.compactPath(java.lang.String):java.lang.String");
    }

    public static boolean hasScheme(String uri) {
        for (int i = 0; i < uri.length(); i++) {
            char c = uri.charAt(i);
            if (c == ':') {
                return true;
            }
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                if (i <= 0) {
                    return false;
                }
                if (!((c >= '0' && c <= '9') || c == '.' || c == '+' || c == '-')) {
                    return false;
                }
            }
        }
        return false;
    }

    public static String newURI(String scheme, String server, int port, String path, String query) {
        StringBuilder builder = newURIBuilder(scheme, server, port);
        builder.append(path);
        if (query != null && query.length() > 0) {
            builder.append('?').append(query);
        }
        return builder.toString();
    }

    public static StringBuilder newURIBuilder(String scheme, String server, int port) {
        StringBuilder builder = new StringBuilder();
        appendSchemeHostPort(builder, scheme, server, port);
        return builder;
    }

    public static void appendSchemeHostPort(StringBuilder url, String scheme, String server, int port) {
        url.append(scheme).append("://").append(HostPort.normalizeHost(server));
        if (port > 0) {
            char c = 65535;
            switch (scheme.hashCode()) {
                case 3213448:
                    if (scheme.equals(HTTP)) {
                        c = 0;
                        break;
                    }
                    break;
                case 99617003:
                    if (scheme.equals(HTTPS)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    if (port != 80) {
                        url.append(':').append(port);
                        return;
                    }
                    return;
                case 1:
                    if (port != 443) {
                        url.append(':').append(port);
                        return;
                    }
                    return;
                default:
                    url.append(':').append(port);
                    return;
            }
        }
    }

    public static void appendSchemeHostPort(StringBuffer url, String scheme, String server, int port) {
        synchronized (url) {
            url.append(scheme).append("://").append(HostPort.normalizeHost(server));
            if (port > 0) {
                char c = 65535;
                switch (scheme.hashCode()) {
                    case 3213448:
                        if (scheme.equals(HTTP)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 99617003:
                        if (scheme.equals(HTTPS)) {
                            c = 1;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        if (port != 80) {
                            url.append(':').append(port);
                            break;
                        }
                        break;
                    case 1:
                        if (port != 443) {
                            url.append(':').append(port);
                            break;
                        }
                        break;
                    default:
                        url.append(':').append(port);
                        break;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean equalsIgnoreEncodings(java.lang.String r3, java.lang.String r4) {
        /*
            r0 = r3
            int r0 = r0.length()
            r5 = r0
            r0 = r4
            int r0 = r0.length()
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = 0
            r8 = r0
        L_0x0010:
            r0 = r7
            r1 = r5
            if (r0 >= r1) goto L_0x0094
            r0 = r8
            r1 = r6
            if (r0 >= r1) goto L_0x0094
            r0 = r3
            r1 = r7
            int r7 = r7 + 1
            char r0 = r0.charAt(r1)
            r9 = r0
            r0 = r9
            r10 = r0
            r0 = r10
            r1 = 37
            if (r0 != r1) goto L_0x004a
            r0 = r3
            r1 = r7
            int r0 = lenientPercentDecode(r0, r1)
            r10 = r0
            r0 = r10
            r1 = -1
            if (r0 != r1) goto L_0x0047
            r0 = 37
            r10 = r0
            goto L_0x004a
        L_0x0047:
            int r7 = r7 + 2
        L_0x004a:
            r0 = r4
            r1 = r8
            int r8 = r8 + 1
            char r0 = r0.charAt(r1)
            r11 = r0
            r0 = r11
            r12 = r0
            r0 = r12
            r1 = 37
            if (r0 != r1) goto L_0x0078
            r0 = r4
            r1 = r8
            int r0 = lenientPercentDecode(r0, r1)
            r12 = r0
            r0 = r12
            r1 = -1
            if (r0 != r1) goto L_0x0075
            r0 = 37
            r12 = r0
            goto L_0x0078
        L_0x0075:
            int r8 = r8 + 2
        L_0x0078:
            r0 = r10
            r1 = 47
            if (r0 != r1) goto L_0x0088
            r0 = r9
            r1 = r11
            if (r0 == r1) goto L_0x0088
            r0 = 0
            return r0
        L_0x0088:
            r0 = r10
            r1 = r12
            if (r0 == r1) goto L_0x0091
            r0 = 0
            return r0
        L_0x0091:
            goto L_0x0010
        L_0x0094:
            r0 = r7
            r1 = r5
            if (r0 != r1) goto L_0x00a4
            r0 = r8
            r1 = r6
            if (r0 != r1) goto L_0x00a4
            r0 = 1
            goto L_0x00a5
        L_0x00a4:
            r0 = 0
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.URIUtil.equalsIgnoreEncodings(java.lang.String, java.lang.String):boolean");
    }

    private static int lenientPercentDecode(String str, int offset) {
        if (offset < str.length() && StringUtil.isHex(str, offset, 2)) {
            return TypeUtil.parseInt(str, offset, 2, 16);
        }
        return -1;
    }

    public static boolean equalsIgnoreEncodings(URI uriA, URI uriB) {
        if (uriA.equals(uriB)) {
            return true;
        }
        if (uriA.getScheme() == null) {
            if (uriB.getScheme() != null) {
                return false;
            }
        } else if (!uriA.getScheme().equalsIgnoreCase(uriB.getScheme())) {
            return false;
        }
        if ("jar".equalsIgnoreCase(uriA.getScheme())) {
            return equalsIgnoreEncodings(URI.create(uriA.getSchemeSpecificPart()), URI.create(uriB.getSchemeSpecificPart()));
        }
        if (uriA.getAuthority() == null) {
            if (uriB.getAuthority() != null) {
                return false;
            }
        } else if (!uriA.getAuthority().equals(uriB.getAuthority())) {
            return false;
        }
        return equalsIgnoreEncodings(uriA.getPath(), uriB.getPath());
    }

    public static URI addPath(URI uri, String path) {
        String base = uri.toASCIIString();
        StringBuilder buf = new StringBuilder(base.length() + (path.length() * 3));
        buf.append(base);
        if (buf.charAt(base.length() - 1) != '/') {
            buf.append('/');
        }
        encodePath(buf, path, path.charAt(0) == '/' ? 1 : 0);
        return URI.create(buf.toString());
    }

    public static String addQueries(String query1, String query2) {
        if (StringUtil.isEmpty(query1)) {
            return query2;
        }
        if (StringUtil.isEmpty(query2)) {
            return query1;
        }
        return query1 + '&' + query2;
    }

    public static URI getJarSource(URI uri) {
        try {
            if (!"jar".equals(uri.getScheme())) {
                return uri;
            }
            String s = uri.getRawSchemeSpecificPart();
            int bangSlash = s.indexOf("!/");
            if (bangSlash >= 0) {
                s = s.substring(0, bangSlash);
            }
            return new URI(s);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String getJarSource(String uri) {
        if (!uri.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
            return uri;
        }
        int bangSlash = uri.indexOf("!/");
        return bangSlash >= 0 ? uri.substring(4, bangSlash) : uri.substring(4);
    }
}
