package com.mchange.lang;

import java.io.UnsupportedEncodingException;

/* loaded from: grasscutter.jar:com/mchange/lang/StringUtils.class */
public final class StringUtils {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

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
}
