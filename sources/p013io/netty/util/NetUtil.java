package p013io.netty.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Arrays;
import p013io.netty.util.NetUtilInitializations;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.StringUtil;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.NetUtil */
/* loaded from: grasscutter.jar:io/netty/util/NetUtil.class */
public final class NetUtil {
    public static final InetAddress LOCALHOST;
    public static final NetworkInterface LOOPBACK_IF;
    private static final int IPV6_WORD_COUNT = 8;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final int IPV4_SEPARATORS = 3;
    private static final boolean IPV4_PREFERRED = SystemPropertyUtil.getBoolean("java.net.preferIPv4Stack", false);
    private static final boolean IPV6_ADDRESSES_PREFERRED = SystemPropertyUtil.getBoolean("java.net.preferIPv6Addresses", false);
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(NetUtil.class);
    public static final Inet4Address LOCALHOST4 = NetUtilInitializations.createLocalhost4();
    public static final Inet6Address LOCALHOST6 = NetUtilInitializations.createLocalhost6();
    public static final int SOMAXCONN = ((Integer) AccessController.doPrivileged(new SoMaxConnAction())).intValue();

    static {
        logger.debug("-Djava.net.preferIPv4Stack: {}", Boolean.valueOf(IPV4_PREFERRED));
        logger.debug("-Djava.net.preferIPv6Addresses: {}", Boolean.valueOf(IPV6_ADDRESSES_PREFERRED));
        NetUtilInitializations.NetworkIfaceAndInetAddress loopback = NetUtilInitializations.determineLoopback(LOCALHOST4, LOCALHOST6);
        LOOPBACK_IF = loopback.iface();
        LOCALHOST = loopback.address();
    }

    /* renamed from: io.netty.util.NetUtil$SoMaxConnAction */
    /* loaded from: grasscutter.jar:io/netty/util/NetUtil$SoMaxConnAction.class */
    private static final class SoMaxConnAction implements PrivilegedAction<Integer> {
        private SoMaxConnAction() {
        }

        @Override // java.security.PrivilegedAction
        public Integer run() {
            BufferedReader in;
            int somaxconn = PlatformDependent.isWindows() ? 200 : 128;
            try {
                File file = new File("/proc/sys/net/core/somaxconn");
                in = null;
                try {
                    if (file.exists()) {
                        in = new BufferedReader(new FileReader(file));
                        somaxconn = Integer.parseInt(in.readLine());
                        if (NetUtil.logger.isDebugEnabled()) {
                            NetUtil.logger.debug("{}: {}", file, Integer.valueOf(somaxconn));
                        }
                    } else {
                        Integer tmp = null;
                        if (SystemPropertyUtil.getBoolean("io.netty.net.somaxconn.trySysctl", false)) {
                            tmp = NetUtil.sysctlGetInt("kern.ipc.somaxconn");
                            if (tmp == null) {
                                tmp = NetUtil.sysctlGetInt("kern.ipc.soacceptqueue");
                                if (tmp != null) {
                                    somaxconn = tmp.intValue();
                                }
                            } else {
                                somaxconn = tmp.intValue();
                            }
                        }
                        if (tmp == null) {
                            NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(somaxconn));
                        }
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e) {
                        }
                    }
                } catch (Exception e2) {
                    if (NetUtil.logger.isDebugEnabled()) {
                        NetUtil.logger.debug("Failed to get SOMAXCONN from sysctl and file {}. Default: {}", file, Integer.valueOf(somaxconn), e2);
                    }
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e3) {
                        }
                    }
                }
                return Integer.valueOf(somaxconn);
            } catch (Throwable th) {
                if (in != null) {
                    try {
                        in.close();
                    } catch (Exception e4) {
                    }
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: private */
    public static Integer sysctlGetInt(String sysctlKey) throws IOException {
        Process process = new ProcessBuilder("sysctl", sysctlKey).start();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = br.readLine();
            if (line != null && line.startsWith(sysctlKey)) {
                for (int i = line.length() - 1; i > sysctlKey.length(); i--) {
                    if (!Character.isDigit(line.charAt(i))) {
                        Integer valueOf = Integer.valueOf(line.substring(i + 1));
                        br.close();
                        process.destroy();
                        return valueOf;
                    }
                }
            }
            br.close();
            process.destroy();
            return null;
        } catch (Throwable th) {
            process.destroy();
            throw th;
        }
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static boolean isIpV6AddressesPreferred() {
        return IPV6_ADDRESSES_PREFERRED;
    }

    public static byte[] createByteArrayFromIpAddressString(String ipAddressString) {
        if (isValidIpV4Address(ipAddressString)) {
            return validIpV4ToBytes(ipAddressString);
        }
        if (!isValidIpV6Address(ipAddressString)) {
            return null;
        }
        if (ipAddressString.charAt(0) == '[') {
            ipAddressString = ipAddressString.substring(1, ipAddressString.length() - 1);
        }
        int percentPos = ipAddressString.indexOf(37);
        if (percentPos >= 0) {
            ipAddressString = ipAddressString.substring(0, percentPos);
        }
        return getIPv6ByName(ipAddressString, true);
    }

    public static InetAddress createInetAddressFromIpAddressString(String ipAddressString) {
        if (isValidIpV4Address(ipAddressString)) {
            try {
                return InetAddress.getByAddress(validIpV4ToBytes(ipAddressString));
            } catch (UnknownHostException e) {
                throw new IllegalStateException(e);
            }
        } else if (!isValidIpV6Address(ipAddressString)) {
            return null;
        } else {
            if (ipAddressString.charAt(0) == '[') {
                ipAddressString = ipAddressString.substring(1, ipAddressString.length() - 1);
            }
            int percentPos = ipAddressString.indexOf(37);
            if (percentPos >= 0) {
                try {
                    int scopeId = Integer.parseInt(ipAddressString.substring(percentPos + 1));
                    byte[] bytes = getIPv6ByName(ipAddressString.substring(0, percentPos), true);
                    if (bytes == null) {
                        return null;
                    }
                    try {
                        return Inet6Address.getByAddress((String) null, bytes, scopeId);
                    } catch (UnknownHostException e2) {
                        throw new IllegalStateException(e2);
                    }
                } catch (NumberFormatException e3) {
                    return null;
                }
            } else {
                byte[] bytes2 = getIPv6ByName(ipAddressString, true);
                if (bytes2 == null) {
                    return null;
                }
                try {
                    return InetAddress.getByAddress(bytes2);
                } catch (UnknownHostException e4) {
                    throw new IllegalStateException(e4);
                }
            }
        }
    }

    private static int decimalDigit(String str, int pos) {
        return str.charAt(pos) - '0';
    }

    private static byte ipv4WordToByte(String ip, int from, int toExclusive) {
        int ret = decimalDigit(ip, from);
        int from2 = from + 1;
        if (from2 == toExclusive) {
            return (byte) ret;
        }
        int ret2 = (ret * 10) + decimalDigit(ip, from2);
        int from3 = from2 + 1;
        if (from3 == toExclusive) {
            return (byte) ret2;
        }
        return (byte) ((ret2 * 10) + decimalDigit(ip, from3));
    }

    static byte[] validIpV4ToBytes(String ip) {
        int i = ip.indexOf(46, 1);
        int i2 = i + 1;
        int i3 = ip.indexOf(46, i + 2);
        int i4 = i3 + 1;
        int i5 = ip.indexOf(46, i3 + 2);
        return new byte[]{ipv4WordToByte(ip, 0, i), ipv4WordToByte(ip, i2, i3), ipv4WordToByte(ip, i4, i5), ipv4WordToByte(ip, i5 + 1, ip.length())};
    }

    public static int ipv4AddressToInt(Inet4Address ipAddress) {
        byte[] octets = ipAddress.getAddress();
        return ((octets[0] & 255) << 24) | ((octets[1] & 255) << 16) | ((octets[2] & 255) << 8) | (octets[3] & 255);
    }

    public static String intToIpAddress(int i) {
        StringBuilder buf = new StringBuilder(15);
        buf.append((i >> 24) & 255);
        buf.append('.');
        buf.append((i >> 16) & 255);
        buf.append('.');
        buf.append((i >> 8) & 255);
        buf.append('.');
        buf.append(i & 255);
        return buf.toString();
    }

    public static String bytesToIpAddress(byte[] bytes) {
        return bytesToIpAddress(bytes, 0, bytes.length);
    }

    public static String bytesToIpAddress(byte[] bytes, int offset, int length) {
        switch (length) {
            case 4:
                return new StringBuilder(15).append(bytes[offset] & 255).append('.').append(bytes[offset + 1] & 255).append('.').append(bytes[offset + 2] & 255).append('.').append(bytes[offset + 3] & 255).toString();
            case 16:
                return toAddressString(bytes, offset, false);
            default:
                throw new IllegalArgumentException("length: " + length + " (expected: 4 or 16)");
        }
    }

    public static boolean isValidIpV6Address(String ip) {
        return isValidIpV6Address((CharSequence) ip);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01a7, code lost:
        if (r10 >= 0) goto L_0x01bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ae, code lost:
        if (r9 != 7) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b3, code lost:
        if (r11 <= 0) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b6, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ba, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c1, code lost:
        if ((r10 + 2) == r6) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01c6, code lost:
        if (r11 <= 0) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01cd, code lost:
        if (r9 < 8) goto L_0x01d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x01d3, code lost:
        if (r10 > r7) goto L_0x01da;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01d6, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01da, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isValidIpV6Address(java.lang.CharSequence r5) {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.util.NetUtil.isValidIpV6Address(java.lang.CharSequence):boolean");
    }

    private static boolean isValidIpV4Word(CharSequence word, int from, int toExclusive) {
        char c0;
        char c2;
        int len = toExclusive - from;
        if (len < 1 || len > 3 || (c0 = word.charAt(from)) < '0') {
            return false;
        }
        if (len != 3) {
            return c0 <= '9' && (len == 1 || isValidNumericChar(word.charAt(from + 1)));
        }
        char c1 = word.charAt(from + 1);
        return c1 >= '0' && (c2 = word.charAt(from + 2)) >= '0' && ((c0 <= '1' && c1 <= '9' && c2 <= '9') || (c0 == '2' && c1 <= '5' && (c2 <= '5' || (c1 < '5' && c2 <= '9'))));
    }

    private static boolean isValidHexChar(char c) {
        return (c >= '0' && c <= '9') || (c >= 'A' && c <= 'F') || (c >= 'a' && c <= 'f');
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isValidIPv4MappedChar(char c) {
        return c == 'f' || c == 'F';
    }

    private static boolean isValidIPv4MappedSeparators(byte b0, byte b1, boolean mustBeZero) {
        return b0 == b1 && (b0 == 0 || (!mustBeZero && b1 == -1));
    }

    private static boolean isValidIPv4Mapped(byte[] bytes, int currentIndex, int compressBegin, int compressLength) {
        boolean mustBeZero = compressBegin + compressLength >= 14;
        return currentIndex <= 12 && currentIndex >= 2 && (!mustBeZero || compressBegin < 12) && isValidIPv4MappedSeparators(bytes[currentIndex - 1], bytes[currentIndex - 2], mustBeZero) && PlatformDependent.isZero(bytes, 0, currentIndex - 3);
    }

    public static boolean isValidIpV4Address(CharSequence ip) {
        return isValidIpV4Address(ip, 0, ip.length());
    }

    public static boolean isValidIpV4Address(String ip) {
        return isValidIpV4Address(ip, 0, ip.length());
    }

    private static boolean isValidIpV4Address(CharSequence ip, int from, int toExcluded) {
        if (ip instanceof String) {
            return isValidIpV4Address((String) ip, from, toExcluded);
        }
        if (ip instanceof AsciiString) {
            return isValidIpV4Address((AsciiString) ip, from, toExcluded);
        }
        return isValidIpV4Address0(ip, from, toExcluded);
    }

    private static boolean isValidIpV4Address(String ip, int from, int toExcluded) {
        int i;
        int from2;
        int i2;
        int from3;
        int i3;
        int len = toExcluded - from;
        return len <= 15 && len >= 7 && (i = ip.indexOf(46, from + 1)) > 0 && isValidIpV4Word(ip, from, i) && (i2 = ip.indexOf(46, (from2 = i + 2))) > 0 && isValidIpV4Word(ip, from2 - 1, i2) && (i3 = ip.indexOf(46, (from3 = i2 + 2))) > 0 && isValidIpV4Word(ip, from3 - 1, i3) && isValidIpV4Word(ip, i3 + 1, toExcluded);
    }

    private static boolean isValidIpV4Address(AsciiString ip, int from, int toExcluded) {
        int i;
        int from2;
        int i2;
        int from3;
        int i3;
        int len = toExcluded - from;
        return len <= 15 && len >= 7 && (i = ip.indexOf('.', from + 1)) > 0 && isValidIpV4Word(ip, from, i) && (i2 = ip.indexOf('.', (from2 = i + 2))) > 0 && isValidIpV4Word(ip, from2 - 1, i2) && (i3 = ip.indexOf('.', (from3 = i2 + 2))) > 0 && isValidIpV4Word(ip, from3 - 1, i3) && isValidIpV4Word(ip, i3 + 1, toExcluded);
    }

    private static boolean isValidIpV4Address0(CharSequence ip, int from, int toExcluded) {
        int i;
        int from2;
        int i2;
        int from3;
        int i3;
        int len = toExcluded - from;
        return len <= 15 && len >= 7 && (i = AsciiString.indexOf(ip, '.', from + 1)) > 0 && isValidIpV4Word(ip, from, i) && (i2 = AsciiString.indexOf(ip, '.', (from2 = i + 2))) > 0 && isValidIpV4Word(ip, from2 - 1, i2) && (i3 = AsciiString.indexOf(ip, '.', (from3 = i2 + 2))) > 0 && isValidIpV4Word(ip, from3 - 1, i3) && isValidIpV4Word(ip, i3 + 1, toExcluded);
    }

    public static Inet6Address getByName(CharSequence ip) {
        return getByName(ip, true);
    }

    public static Inet6Address getByName(CharSequence ip, boolean ipv4Mapped) {
        byte[] bytes = getIPv6ByName(ip, ipv4Mapped);
        if (bytes == null) {
            return null;
        }
        try {
            return Inet6Address.getByAddress((String) null, bytes, -1);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    static byte[] getIPv6ByName(CharSequence ip, boolean ipv4Mapped) {
        int currentIndex;
        byte[] bytes = new byte[16];
        int ipLength = ip.length();
        int compressBegin = 0;
        int compressLength = 0;
        int currentIndex2 = 0;
        int value = 0;
        int begin = -1;
        int i = 0;
        int ipv6Separators = 0;
        int ipv4Separators = 0;
        while (i < ipLength) {
            char c = ip.charAt(i);
            switch (c) {
                case '.':
                    ipv4Separators++;
                    int tmp = i - begin;
                    if (tmp > 3 || begin < 0 || ipv4Separators > 3) {
                        return null;
                    }
                    if ((ipv6Separators <= 0 || currentIndex2 + compressLength >= 12) && i + 1 < ipLength && currentIndex2 < bytes.length) {
                        if (ipv4Separators == 1) {
                            if (!ipv4Mapped) {
                                return null;
                            }
                            if (currentIndex2 != 0 && !isValidIPv4Mapped(bytes, currentIndex2, compressBegin, compressLength)) {
                                return null;
                            }
                            if (tmp == 3 && (!isValidNumericChar(ip.charAt(i - 1)) || !isValidNumericChar(ip.charAt(i - 2)) || !isValidNumericChar(ip.charAt(i - 3)))) {
                                return null;
                            }
                            if (tmp == 2 && (!isValidNumericChar(ip.charAt(i - 1)) || !isValidNumericChar(ip.charAt(i - 2)))) {
                                return null;
                            }
                            if (tmp == 1 && !isValidNumericChar(ip.charAt(i - 1))) {
                                return null;
                            }
                        }
                        int value2 = value << ((3 - tmp) << 2);
                        int begin2 = ((value2 & 15) * 100) + (((value2 >> 4) & 15) * 10) + ((value2 >> 8) & 15);
                        if (begin2 <= 255) {
                            currentIndex2++;
                            bytes[currentIndex2] = (byte) begin2;
                            value = 0;
                            begin = -1;
                            break;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                    break;
                case ':':
                    ipv6Separators++;
                    if (i - begin <= 4 && ipv4Separators <= 0 && ipv6Separators <= 8 && currentIndex2 + 1 < bytes.length) {
                        int value3 = value << ((4 - (i - begin)) << 2);
                        if (compressLength > 0) {
                            compressLength -= 2;
                        }
                        int currentIndex3 = currentIndex2 + 1;
                        bytes[currentIndex2] = (byte) (((value3 & 15) << 4) | ((value3 >> 4) & 15));
                        currentIndex2 = currentIndex3 + 1;
                        bytes[currentIndex3] = (byte) ((((value3 >> 8) & 15) << 4) | ((value3 >> 12) & 15));
                        int tmp2 = i + 1;
                        if (tmp2 < ipLength && ip.charAt(tmp2) == ':') {
                            int tmp3 = tmp2 + 1;
                            if (compressBegin != 0) {
                                return null;
                            }
                            if (tmp3 < ipLength && ip.charAt(tmp3) == ':') {
                                return null;
                            }
                            ipv6Separators++;
                            compressBegin = currentIndex2;
                            compressLength = (bytes.length - compressBegin) - 2;
                            i++;
                        }
                        value = 0;
                        begin = -1;
                        break;
                    } else {
                        return null;
                    }
                    break;
                default:
                    if (!isValidHexChar(c)) {
                        return null;
                    }
                    if (ipv4Separators <= 0 || isValidNumericChar(c)) {
                        if (begin < 0) {
                            begin = i;
                        } else if (i - begin > 4) {
                            return null;
                        }
                        value += StringUtil.decodeHexNibble(c) << ((i - begin) << 2);
                        break;
                    } else {
                        return null;
                    }
                    break;
            }
            i++;
        }
        boolean isCompressed = compressBegin > 0;
        if (ipv4Separators <= 0) {
            int tmp4 = ipLength - 1;
            if ((begin > 0 && i - begin > 4) || ipv6Separators < 2) {
                return null;
            }
            if (!isCompressed && (ipv6Separators + 1 != 8 || ip.charAt(0) == ':' || ip.charAt(tmp4) == ':')) {
                return null;
            }
            if (isCompressed) {
                if (ipv6Separators > 8) {
                    return null;
                }
                if (ipv6Separators == 8) {
                    if (compressBegin <= 2 && ip.charAt(0) != ':') {
                        return null;
                    }
                    if (compressBegin >= 14 && ip.charAt(tmp4) != ':') {
                        return null;
                    }
                }
            }
            if (currentIndex2 + 1 >= bytes.length) {
                return null;
            }
            if (begin < 0 && ip.charAt(tmp4 - 1) != ':') {
                return null;
            }
            if (compressBegin > 2 && ip.charAt(0) == ':') {
                return null;
            }
            if (begin >= 0 && i - begin <= 4) {
                value <<= (4 - (i - begin)) << 2;
            }
            int currentIndex4 = currentIndex2 + 1;
            bytes[currentIndex2] = (byte) (((value & 15) << 4) | ((value >> 4) & 15));
            currentIndex = currentIndex4 + 1;
            bytes[currentIndex4] = (byte) ((((value >> 8) & 15) << 4) | ((value >> 12) & 15));
        } else if ((begin > 0 && i - begin > 3) || ipv4Separators != 3 || currentIndex2 >= bytes.length) {
            return null;
        } else {
            if (ipv6Separators != 0) {
                if (ipv6Separators < 2) {
                    return null;
                }
                if (isCompressed || ipv6Separators != 6 || ip.charAt(0) == ':') {
                    if (!isCompressed || ipv6Separators >= 8) {
                        return null;
                    }
                    if (ip.charAt(0) == ':' && compressBegin > 2) {
                        return null;
                    }
                }
            }
            int value4 = value << ((3 - (i - begin)) << 2);
            int begin3 = ((value4 & 15) * 100) + (((value4 >> 4) & 15) * 10) + ((value4 >> 8) & 15);
            if (begin3 > 255) {
                return null;
            }
            currentIndex = currentIndex2 + 1;
            bytes[currentIndex2] = (byte) begin3;
        }
        if (currentIndex < bytes.length) {
            int toBeCopiedLength = currentIndex - compressBegin;
            int targetIndex = bytes.length - toBeCopiedLength;
            System.arraycopy(bytes, compressBegin, bytes, targetIndex, toBeCopiedLength);
            Arrays.fill(bytes, compressBegin, targetIndex, (byte) 0);
        }
        if (ipv4Separators > 0) {
            bytes[11] = -1;
            bytes[10] = -1;
        }
        return bytes;
    }

    public static String toSocketAddressString(InetSocketAddress addr) {
        StringBuilder sb;
        String port = String.valueOf(addr.getPort());
        if (addr.isUnresolved()) {
            String hostname = getHostname(addr);
            sb = newSocketAddressStringBuilder(hostname, port, !isValidIpV6Address(hostname));
        } else {
            InetAddress address = addr.getAddress();
            sb = newSocketAddressStringBuilder(toAddressString(address), port, address instanceof Inet4Address);
        }
        return sb.append(':').append(port).toString();
    }

    public static String toSocketAddressString(String host, int port) {
        String portStr = String.valueOf(port);
        return newSocketAddressStringBuilder(host, portStr, !isValidIpV6Address(host)).append(':').append(portStr).toString();
    }

    private static StringBuilder newSocketAddressStringBuilder(String host, String port, boolean ipv4) {
        int hostLen = host.length();
        if (ipv4) {
            return new StringBuilder(hostLen + 1 + port.length()).append(host);
        }
        StringBuilder stringBuilder = new StringBuilder(hostLen + 3 + port.length());
        if (hostLen > 1 && host.charAt(0) == '[' && host.charAt(hostLen - 1) == ']') {
            return stringBuilder.append(host);
        }
        return stringBuilder.append('[').append(host).append(']');
    }

    public static String toAddressString(InetAddress ip) {
        return toAddressString(ip, false);
    }

    public static String toAddressString(InetAddress ip, boolean ipv4Mapped) {
        if (ip instanceof Inet4Address) {
            return ip.getHostAddress();
        }
        if (ip instanceof Inet6Address) {
            return toAddressString(ip.getAddress(), 0, ipv4Mapped);
        }
        throw new IllegalArgumentException("Unhandled type: " + ip);
    }

    private static String toAddressString(byte[] bytes, int offset, boolean ipv4Mapped) {
        boolean isIpv4Mapped;
        int currentLength;
        int[] words = new int[8];
        int end = offset + words.length;
        for (int i = offset; i < end; i++) {
            words[i] = ((bytes[i << 1] & 255) << 8) | (bytes[(i << 1) + 1] & 255);
        }
        int currentStart = -1;
        int shortestStart = -1;
        int shortestLength = 0;
        int i2 = 0;
        while (i2 < words.length) {
            if (words[i2] == 0) {
                if (currentStart < 0) {
                    currentStart = i2;
                }
            } else if (currentStart >= 0) {
                int currentLength2 = i2 - currentStart;
                if (currentLength2 > shortestLength) {
                    shortestStart = currentStart;
                    shortestLength = currentLength2;
                }
                currentStart = -1;
            }
            i2++;
        }
        if (currentStart >= 0 && (currentLength = i2 - currentStart) > shortestLength) {
            shortestStart = currentStart;
            shortestLength = currentLength;
        }
        if (shortestLength == 1) {
            shortestLength = 0;
            shortestStart = -1;
        }
        int shortestEnd = shortestStart + shortestLength;
        StringBuilder b = new StringBuilder(39);
        if (shortestEnd < 0) {
            b.append(Integer.toHexString(words[0]));
            for (int i3 = 1; i3 < words.length; i3++) {
                b.append(':');
                b.append(Integer.toHexString(words[i3]));
            }
        } else {
            if (inRangeEndExclusive(0, shortestStart, shortestEnd)) {
                b.append("::");
                isIpv4Mapped = ipv4Mapped && shortestEnd == 5 && words[5] == 65535;
            } else {
                b.append(Integer.toHexString(words[0]));
                isIpv4Mapped = false;
            }
            for (int i4 = 1; i4 < words.length; i4++) {
                if (!inRangeEndExclusive(i4, shortestStart, shortestEnd)) {
                    if (!inRangeEndExclusive(i4 - 1, shortestStart, shortestEnd)) {
                        if (!isIpv4Mapped || i4 == 6) {
                            b.append(':');
                        } else {
                            b.append('.');
                        }
                    }
                    if (!isIpv4Mapped || i4 <= 5) {
                        b.append(Integer.toHexString(words[i4]));
                    } else {
                        b.append(words[i4] >> 8);
                        b.append('.');
                        b.append(words[i4] & 255);
                    }
                } else if (!inRangeEndExclusive(i4 - 1, shortestStart, shortestEnd)) {
                    b.append("::");
                }
            }
        }
        return b.toString();
    }

    public static String getHostname(InetSocketAddress addr) {
        return PlatformDependent.javaVersion() >= 7 ? addr.getHostString() : addr.getHostName();
    }

    private static boolean inRangeEndExclusive(int value, int start, int end) {
        return value >= start && value < end;
    }

    private NetUtil() {
    }
}
