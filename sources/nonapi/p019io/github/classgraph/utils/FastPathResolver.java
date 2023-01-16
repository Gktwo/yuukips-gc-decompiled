package nonapi.p019io.github.classgraph.utils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* renamed from: nonapi.io.github.classgraph.utils.FastPathResolver */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/FastPathResolver.class */
public final class FastPathResolver {
    private static final Pattern percentMatcher = Pattern.compile("([%][0-9a-fA-F][0-9a-fA-F])+");
    private static final Pattern schemeTwoSlashMatcher = Pattern.compile("^[a-zA-Z+\\-.]+://");
    private static final Pattern schemeOneSlashMatcher = Pattern.compile("^[a-zA-Z+\\-.]+:/");
    private static final boolean WINDOWS;

    static {
        WINDOWS = File.separatorChar == '\\';
    }

    private FastPathResolver() {
    }

    private static void translateSeparator(String path, int startIdx, int endIdx, boolean stripFinalSeparator, StringBuilder buf) {
        for (int i = startIdx; i < endIdx; i++) {
            char c = path.charAt(i);
            if (c != '\\' && c != '/') {
                buf.append(c);
            } else if (i < endIdx - 1 || !stripFinalSeparator) {
                if ((buf.length() == 0 ? 0 : buf.charAt(buf.length() - 1)) != '/') {
                    buf.append('/');
                }
            }
        }
    }

    private static int hexCharToInt(char c) {
        return (c < '0' || c > '9') ? (c < 'a' || c > 'f') ? (c - 'A') + 10 : (c - 'a') + 10 : c - '0';
    }

    private static void unescapePercentEncoding(String path, int startIdx, int endIdx, StringBuilder buf) {
        if (endIdx - startIdx == 3 && path.charAt(startIdx + 1) == '2' && path.charAt(startIdx + 2) == '0') {
            buf.append(' ');
            return;
        }
        byte[] bytes = new byte[(endIdx - startIdx) / 3];
        int i = startIdx;
        int j = 0;
        while (i < endIdx) {
            char c1 = path.charAt(i + 1);
            char c2 = path.charAt(i + 2);
            bytes[j] = (byte) ((hexCharToInt(c1) << 4) | hexCharToInt(c2));
            i += 3;
            j++;
        }
        buf.append(new String(bytes, StandardCharsets.UTF_8).replace("/", "%2F").replace("\\", "%5C"));
    }

    public static String normalizePath(String path, boolean isFileOrJarURL) {
        boolean hasPercent = path.indexOf(37) >= 0;
        if (!hasPercent && path.indexOf(92) < 0 && !path.endsWith("/")) {
            return path;
        }
        int len = path.length();
        StringBuilder buf = new StringBuilder();
        if (!hasPercent || !isFileOrJarURL) {
            translateSeparator(path, 0, len, true, buf);
            return buf.toString();
        }
        int prevEndMatchIdx = 0;
        Matcher matcher = percentMatcher.matcher(path);
        while (matcher.find()) {
            int startMatchIdx = matcher.start();
            int endMatchIdx = matcher.end();
            translateSeparator(path, prevEndMatchIdx, startMatchIdx, false, buf);
            unescapePercentEncoding(path, startMatchIdx, endMatchIdx, buf);
            prevEndMatchIdx = endMatchIdx;
        }
        translateSeparator(path, prevEndMatchIdx, len, true, buf);
        return buf.toString();
    }

    public static String resolve(String resolveBasePath, String relativePath) {
        String pathResolved;
        if (relativePath == null || relativePath.isEmpty()) {
            return resolveBasePath == null ? "" : resolveBasePath;
        }
        String prefix = "";
        boolean isAbsolutePath = false;
        boolean isFileOrJarURL = false;
        int startIdx = 0;
        if (relativePath.regionMatches(true, 0, XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX, 0, 4)) {
            startIdx = 4;
            isFileOrJarURL = true;
        }
        if (relativePath.regionMatches(true, 0, "http://", 0, 7)) {
            startIdx = 7;
            prefix = "http://";
            isAbsolutePath = true;
        } else if (relativePath.regionMatches(true, 0, "https://", 0, 8)) {
            startIdx = 8;
            prefix = "https://";
            isAbsolutePath = true;
        } else if (relativePath.regionMatches(true, 0, "jrt:", 0, 5)) {
            startIdx = 4;
            prefix = "jrt:";
            isAbsolutePath = true;
        } else if (relativePath.regionMatches(true, 0, "file:", 0, 5)) {
            startIdx = 5;
            if (WINDOWS) {
                if (relativePath.startsWith("\\\\\\\\", 5) || relativePath.startsWith("////", 5)) {
                    startIdx = 5 + 4;
                    prefix = "//";
                    isAbsolutePath = true;
                } else if (relativePath.startsWith("\\\\", 5)) {
                    startIdx = 5 + 2;
                }
            }
            if (relativePath.startsWith("///", startIdx)) {
                startIdx += 2;
            }
            isFileOrJarURL = true;
        } else {
            Matcher m2 = schemeTwoSlashMatcher.matcher(relativePath);
            if (m2.find()) {
                String m2Match = m2.group();
                startIdx += m2Match.length();
                prefix = m2Match;
                isAbsolutePath = true;
            } else {
                Matcher m1 = schemeOneSlashMatcher.matcher(relativePath);
                if (m1.find()) {
                    String m1Match = m1.group();
                    startIdx += m1Match.length();
                    prefix = m1Match;
                    isAbsolutePath = true;
                }
            }
        }
        if (WINDOWS) {
            if (relativePath.startsWith("//", startIdx) || relativePath.startsWith("\\\\", startIdx)) {
                startIdx += 2;
                prefix = "//";
                isAbsolutePath = true;
            } else if (relativePath.length() - startIdx > 2 && Character.isLetter(relativePath.charAt(startIdx)) && relativePath.charAt(startIdx + 1) == ':') {
                isAbsolutePath = true;
            } else if (relativePath.length() - startIdx > 3 && ((relativePath.charAt(startIdx) == '/' || relativePath.charAt(startIdx) == '\\') && Character.isLetter(relativePath.charAt(startIdx + 1)) && relativePath.charAt(startIdx + 2) == ':')) {
                isAbsolutePath = true;
                startIdx++;
            }
        }
        if (relativePath.length() - startIdx > 1 && (relativePath.charAt(startIdx) == '/' || relativePath.charAt(startIdx) == '\\')) {
            isAbsolutePath = true;
        }
        String pathStr = normalizePath(startIdx == 0 ? relativePath : relativePath.substring(startIdx), isFileOrJarURL);
        if (!pathStr.equals("/")) {
            if (pathStr.endsWith("/")) {
                pathStr = pathStr.substring(0, pathStr.length() - 1);
            }
            if (pathStr.endsWith("!")) {
                pathStr = pathStr.substring(0, pathStr.length() - 1);
            }
            if (pathStr.endsWith("/")) {
                pathStr = pathStr.substring(0, pathStr.length() - 1);
            }
            if (pathStr.isEmpty()) {
                pathStr = "/";
            }
        }
        if (isAbsolutePath || resolveBasePath == null || resolveBasePath.isEmpty()) {
            pathResolved = FileUtils.sanitizeEntryPath(pathStr, false, true);
        } else {
            pathResolved = FileUtils.sanitizeEntryPath(resolveBasePath + (resolveBasePath.endsWith("/") ? "" : "/") + pathStr, false, true);
        }
        return prefix.isEmpty() ? pathResolved : prefix + pathResolved;
    }

    public static String resolve(String pathStr) {
        return resolve(null, pathStr);
    }
}
