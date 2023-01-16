package nonapi.p019io.github.classgraph.utils;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import org.eclipse.jetty.util.URIUtil;
import org.quartz.xml.XMLSchedulingDataProcessor;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.github.classgraph.ClassGraphException;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: nonapi.io.github.classgraph.utils.JarUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/JarUtils.class */
public final class JarUtils {
    public static final Pattern URL_SCHEME_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+[:].*");
    private static final Pattern DASH_VERSION = Pattern.compile("-(\\d+(\\.|$))");
    private static final Pattern NON_ALPHANUM = Pattern.compile("[^A-Za-z0-9]");
    private static final Pattern REPEATING_DOTS = Pattern.compile("(\\.)(\\1)+");
    private static final Pattern LEADING_DOTS = Pattern.compile("^\\.");
    private static final Pattern TRAILING_DOTS = Pattern.compile("\\.$");
    private static final String[] UNIX_NON_PATH_SEPARATORS = {XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX, "file:", "http://", "https://", "\\:"};
    private static final int[] UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS = new int[UNIX_NON_PATH_SEPARATORS.length];

    static {
        for (int i = 0; i < UNIX_NON_PATH_SEPARATORS.length; i++) {
            UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[i] = UNIX_NON_PATH_SEPARATORS[i].indexOf(58);
            if (UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[i] < 0) {
                throw ClassGraphException.newClassGraphException("Could not find ':' in \"" + UNIX_NON_PATH_SEPARATORS[i] + "\"");
            }
        }
    }

    private JarUtils() {
    }

    public static String[] smartPathSplit(String pathStr, ScanSpec scanSpec) {
        return smartPathSplit(pathStr, File.pathSeparatorChar, scanSpec);
    }

    public static String[] smartPathSplit(String pathStr, char separatorChar, ScanSpec scanSpec) {
        if (pathStr == null || pathStr.isEmpty()) {
            return new String[0];
        }
        if (separatorChar != ':') {
            List<String> partsFiltered = new ArrayList<>();
            for (String part : pathStr.split(String.valueOf(separatorChar))) {
                String partFiltered = part.trim();
                if (!partFiltered.isEmpty()) {
                    partsFiltered.add(partFiltered);
                }
            }
            return (String[]) partsFiltered.toArray(new String[0]);
        }
        Set<Integer> splitPoints = new HashSet<>();
        int i = -1;
        do {
            boolean foundNonPathSeparator = false;
            for (int j = 0; j < UNIX_NON_PATH_SEPARATORS.length; j++) {
                int startIdx = i - UNIX_NON_PATH_SEPARATOR_COLON_POSITIONS[j];
                if (pathStr.regionMatches(true, startIdx, UNIX_NON_PATH_SEPARATORS[j], 0, UNIX_NON_PATH_SEPARATORS[j].length()) && (startIdx == 0 || pathStr.charAt(startIdx - 1) == ':')) {
                    foundNonPathSeparator = true;
                    break;
                }
            }
            if (!foundNonPathSeparator && scanSpec != null && scanSpec.allowedURLSchemes != null && !scanSpec.allowedURLSchemes.isEmpty()) {
                for (String scheme : scanSpec.allowedURLSchemes) {
                    if (!scheme.equals(URIUtil.HTTP) && !scheme.equals(URIUtil.HTTPS) && !scheme.equals("jar") && !scheme.equals(Action.FILE_ATTRIBUTE)) {
                        int schemeLen = scheme.length();
                        int startIdx2 = i - schemeLen;
                        if (pathStr.regionMatches(true, startIdx2, scheme, 0, schemeLen) && (startIdx2 == 0 || pathStr.charAt(startIdx2 - 1) == ':')) {
                            foundNonPathSeparator = true;
                            break;
                        }
                    }
                }
            }
            if (!foundNonPathSeparator) {
                splitPoints.add(Integer.valueOf(i));
            }
            i = pathStr.indexOf(58, i + 1);
        } while (i >= 0);
        splitPoints.add(Integer.valueOf(pathStr.length()));
        List<Integer> splitPointsSorted = new ArrayList<>(splitPoints);
        CollectionUtils.sortIfNotEmpty(splitPointsSorted);
        List<String> parts = new ArrayList<>();
        for (int i2 = 1; i2 < splitPointsSorted.size(); i2++) {
            String part2 = pathStr.substring(splitPointsSorted.get(i2 - 1).intValue() + 1, splitPointsSorted.get(i2).intValue()).trim().replaceAll("\\\\:", EmitterKt.COMMENT_PREFIX);
            if (!part2.isEmpty()) {
                parts.add(part2);
            }
        }
        return (String[]) parts.toArray(new String[0]);
    }

    private static void appendPathElt(Object pathElt, StringBuilder buf) {
        if (buf.length() > 0) {
            buf.append(File.pathSeparatorChar);
        }
        buf.append(File.separatorChar == '\\' ? pathElt.toString() : pathElt.toString().replaceAll(File.pathSeparator, "\\" + File.pathSeparator));
    }

    public static String pathElementsToPathStr(Object... pathElts) {
        StringBuilder buf = new StringBuilder();
        for (Object pathElt : pathElts) {
            appendPathElt(pathElt, buf);
        }
        return buf.toString();
    }

    public static String pathElementsToPathStr(Iterable<?> pathElts) {
        StringBuilder buf = new StringBuilder();
        Iterator<?> it = pathElts.iterator();
        while (it.hasNext()) {
            appendPathElt(it.next(), buf);
        }
        return buf.toString();
    }

    public static String leafName(String path) {
        int bangIdx = path.indexOf(33);
        int endIdx = bangIdx >= 0 ? bangIdx : path.length();
        int leafStartIdx = 1 + (File.separatorChar == '/' ? path.lastIndexOf(47, endIdx) : Math.max(path.lastIndexOf(47, endIdx), path.lastIndexOf(File.separatorChar, endIdx)));
        int sepIdx = path.indexOf(NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR);
        if (sepIdx >= 0) {
            sepIdx += NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR.length();
        }
        return path.substring(Math.min(Math.max(leafStartIdx, sepIdx), endIdx), endIdx);
    }

    public static String classfilePathToClassName(String classfilePath) {
        if (classfilePath.endsWith(".class")) {
            return classfilePath.substring(0, classfilePath.length() - 6).replace('/', '.');
        }
        throw new IllegalArgumentException("Classfile path does not end with \".class\": " + classfilePath);
    }

    public static String classNameToClassfilePath(String className) {
        return className.replace('.', '/') + ".class";
    }

    public static String derivedAutomaticModuleName(String jarPath) {
        int endIdx = jarPath.length();
        int lastPlingIdx = jarPath.lastIndexOf(33);
        if (lastPlingIdx > 0 && jarPath.lastIndexOf(46) <= Math.max(lastPlingIdx, jarPath.lastIndexOf(47))) {
            endIdx = lastPlingIdx;
        }
        int startIdx = Math.max(endIdx == 0 ? -1 : jarPath.lastIndexOf("!", endIdx - 1), jarPath.lastIndexOf(47, endIdx - 1)) + 1;
        int lastDotBeforeLastPlingIdx = jarPath.lastIndexOf(46, endIdx - 1);
        if (lastDotBeforeLastPlingIdx > startIdx) {
            endIdx = lastDotBeforeLastPlingIdx;
        }
        String moduleName = jarPath.substring(startIdx, endIdx);
        Matcher matcher = DASH_VERSION.matcher(moduleName);
        if (matcher.find()) {
            moduleName = moduleName.substring(0, matcher.start());
        }
        String moduleName2 = REPEATING_DOTS.matcher(NON_ALPHANUM.matcher(moduleName).replaceAll(Mapper.IGNORED_FIELDNAME)).replaceAll(Mapper.IGNORED_FIELDNAME);
        if (moduleName2.length() > 0 && moduleName2.charAt(0) == '.') {
            moduleName2 = LEADING_DOTS.matcher(moduleName2).replaceAll("");
        }
        int len = moduleName2.length();
        if (len > 0 && moduleName2.charAt(len - 1) == '.') {
            moduleName2 = TRAILING_DOTS.matcher(moduleName2).replaceAll("");
        }
        return moduleName2;
    }
}
