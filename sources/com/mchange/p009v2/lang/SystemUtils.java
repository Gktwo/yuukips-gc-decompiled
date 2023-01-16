package com.mchange.p009v2.lang;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.mchange.v2.lang.SystemUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/SystemUtils.class */
public final class SystemUtils {
    private static final Pattern REPLACE_ME_REGEX = Pattern.compile("(?<!\\$)\\$\\{\\s*(.+?)\\s*\\}");
    private static final Pattern UNESCAPE_ME_REGEX = Pattern.compile("\\$\\$\\{\\s*(.+?)\\s*\\}");

    private static String _unescape(String str) {
        Matcher matcher = UNESCAPE_ME_REGEX.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, '\\' + matcher.group(0).substring(1));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static String _mapReplace(String str, Map<String, String> map) {
        Matcher matcher = REPLACE_ME_REGEX.matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcher.find()) {
            String str2 = map.get(matcher.group(1));
            if (str2 != null) {
                matcher.appendReplacement(stringBuffer, str2);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static Map<String, String> propsMap() {
        return Collections.checkedMap(System.getProperties(), String.class, String.class);
    }

    public static String mapReplace(String str, Map<String, String> map) {
        return _unescape(_mapReplace(str, map));
    }

    public static String sysPropsReplace(String str) {
        return mapReplace(str, propsMap());
    }

    public static String envReplace(String str) {
        return mapReplace(str, System.getenv());
    }

    public static String sysPropsEnvReplace(String str) {
        return envReplace(_mapReplace(str, propsMap()));
    }

    private SystemUtils() {
    }
}
