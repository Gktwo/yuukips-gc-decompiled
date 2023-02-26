package nonapi.p019io.github.classgraph.utils;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.nio.charset.StandardCharsets;
import nonapi.p019io.github.classgraph.utils.VersionFinder;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* renamed from: nonapi.io.github.classgraph.utils.URLPathEncoder */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/URLPathEncoder.class */
public final class URLPathEncoder {
    private static boolean[] safe = new boolean[256];
    private static final char[] HEXADECIMAL;
    private static final String[] SCHEME_PREFIXES;

    static {
        for (int i = 97; i <= 122; i++) {
            safe[i] = true;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            safe[i2] = true;
        }
        for (int i3 = 48; i3 <= 57; i3++) {
            safe[i3] = true;
        }
        boolean[] zArr = safe;
        boolean[] zArr2 = safe;
        boolean[] zArr3 = safe;
        boolean[] zArr4 = safe;
        safe[43] = true;
        zArr4[46] = true;
        zArr3[95] = true;
        zArr2[45] = true;
        zArr[36] = true;
        boolean[] zArr5 = safe;
        boolean[] zArr6 = safe;
        boolean[] zArr7 = safe;
        boolean[] zArr8 = safe;
        boolean[] zArr9 = safe;
        safe[44] = true;
        zArr9[41] = true;
        zArr8[40] = true;
        zArr7[39] = true;
        zArr6[42] = true;
        zArr5[33] = true;
        safe[47] = true;
        HEXADECIMAL = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        SCHEME_PREFIXES = new String[]{"jrt:", "file:", "jar:file:", XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX, "http:", "https:"};
    }

    private URLPathEncoder() {
    }

    public static String encodePath(String path) {
        int validColonPrefixLen = 0;
        String[] strArr = SCHEME_PREFIXES;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            String scheme = strArr[i];
            if (path.startsWith(scheme)) {
                validColonPrefixLen = scheme.length();
                break;
            }
            i++;
        }
        if (VersionFinder.f3075OS == VersionFinder.OperatingSystem.Windows) {
            int i2 = validColonPrefixLen;
            if (i2 < path.length() && path.charAt(i2) == '/') {
                i2++;
            }
            if (i2 < path.length() - 1 && Character.isLetter(path.charAt(i2)) && path.charAt(i2 + 1) == ':') {
                validColonPrefixLen = i2 + 2;
            }
        }
        byte[] pathBytes = path.getBytes(StandardCharsets.UTF_8);
        StringBuilder encodedPath = new StringBuilder(pathBytes.length * 3);
        for (int i3 = 0; i3 < pathBytes.length; i3++) {
            int b = pathBytes[i3] & 255;
            if (safe[b] || (b == 58 && i3 < validColonPrefixLen)) {
                encodedPath.append((char) b);
            } else {
                encodedPath.append('%');
                encodedPath.append(HEXADECIMAL[(b & PacketOpcodes.SceneKickPlayerRsp) >> 4]);
                encodedPath.append(HEXADECIMAL[b & 15]);
            }
        }
        return encodedPath.toString();
    }

    public static String normalizeURLPath(String urlPath) {
        String urlPathNormalized = urlPath;
        if (!urlPathNormalized.startsWith("jrt:") && !urlPathNormalized.startsWith("http://") && !urlPathNormalized.startsWith("https://")) {
            if (urlPathNormalized.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
                urlPathNormalized = urlPathNormalized.substring(4);
            }
            if (urlPathNormalized.startsWith("file:")) {
                urlPathNormalized = urlPathNormalized.substring(4);
            }
            String windowsDrivePrefix = "";
            if (VersionFinder.f3075OS == VersionFinder.OperatingSystem.Windows) {
                if (urlPathNormalized.length() >= 2 && Character.isLetter(urlPathNormalized.charAt(0)) && urlPathNormalized.charAt(1) == ':') {
                    windowsDrivePrefix = urlPathNormalized.substring(0, 2);
                    urlPathNormalized = urlPathNormalized.substring(2);
                } else if (urlPathNormalized.length() >= 3 && urlPathNormalized.charAt(0) == '/' && Character.isLetter(urlPathNormalized.charAt(1)) && urlPathNormalized.charAt(2) == ':') {
                    windowsDrivePrefix = urlPathNormalized.substring(1, 3);
                    urlPathNormalized = urlPathNormalized.substring(3);
                }
            }
            String urlPathNormalized2 = urlPathNormalized.replace("/!", "!").replace("!/", "!").replace("!", "!/");
            if (windowsDrivePrefix.isEmpty()) {
                urlPathNormalized = urlPathNormalized2.startsWith("/") ? "file:" + urlPathNormalized2 : "file:/" + urlPathNormalized2;
            } else {
                urlPathNormalized = "file:/" + windowsDrivePrefix + (urlPathNormalized2.startsWith("/") ? urlPathNormalized2 : "/" + urlPathNormalized2);
            }
            if (urlPathNormalized.contains("!") && !urlPathNormalized.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
                urlPathNormalized = XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX + urlPathNormalized;
            }
        }
        return encodePath(urlPathNormalized);
    }
}
