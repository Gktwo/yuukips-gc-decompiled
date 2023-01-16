package com.mchange.p006v1.util;

import java.util.StringTokenizer;

/* renamed from: com.mchange.v1.util.StringTokenizerUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/StringTokenizerUtils.class */
public final class StringTokenizerUtils {
    public static String[] tokenizeToArray(String str, String str2, boolean z) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, str2, z);
        String[] strArr = new String[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            strArr[i] = stringTokenizer.nextToken();
            i++;
        }
        return strArr;
    }

    public static String[] tokenizeToArray(String str, String str2) {
        return tokenizeToArray(str, str2, false);
    }

    public static String[] tokenizeToArray(String str) {
        return tokenizeToArray(str, " \t\r\n");
    }
}
