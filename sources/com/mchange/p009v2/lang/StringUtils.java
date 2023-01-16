package com.mchange.p009v2.lang;

import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* renamed from: com.mchange.v2.lang.StringUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/StringUtils.class */
public final class StringUtils {
    static final Pattern COMMA_SEP_TRIM_REGEX;
    static final Pattern COMMA_SEP_NO_TRIM_REGEX;
    public static final String[] EMPTY_STRING_ARRAY;

    static {
        try {
            COMMA_SEP_TRIM_REGEX = Pattern.compile("\\s*\\,\\s*");
            COMMA_SEP_NO_TRIM_REGEX = Pattern.compile("\\,");
            EMPTY_STRING_ARRAY = new String[0];
        } catch (PatternSyntaxException e) {
            e.printStackTrace();
            throw new InternalError(e.toString());
        }
    }

    public static String normalString(String str) {
        return nonEmptyTrimmedOrNull(str);
    }

    public static boolean nonEmptyString(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean nonWhitespaceString(String str) {
        return str != null && str.trim().length() > 0;
    }

    public static String nonEmptyOrNull(String str) {
        if (nonEmptyString(str)) {
            return str;
        }
        return null;
    }

    public static String nonNullOrBlank(String str) {
        return str != null ? str : "";
    }

    public static String nonEmptyTrimmedOrNull(String str) {
        String str2 = str;
        if (str2 != null) {
            String trim = str2.trim();
            str2 = trim.length() > 0 ? trim : null;
        }
        return str2;
    }

    public static byte[] getUTF8Bytes(String str) {
        try {
            return str.getBytes("UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new InternalError("UTF8 is an unsupported encoding?!?");
        }
    }

    public static String[] splitCommaSeparated(String str, boolean z) {
        return (z ? COMMA_SEP_TRIM_REGEX : COMMA_SEP_NO_TRIM_REGEX).split(str);
    }
}
