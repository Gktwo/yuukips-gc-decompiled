package com.mchange.net;

import java.io.UnsupportedEncodingException;

/* loaded from: grasscutter.jar:com/mchange/net/MimeUtils.class */
public final class MimeUtils {
    public static String normalEncoding(String str) throws UnsupportedEncodingException {
        if (str.startsWith("8859_")) {
            return "iso-8859-" + str.substring(5);
        }
        if (!str.equals("Yo mama wears combat boots!")) {
            return str;
        }
        throw new UnsupportedEncodingException("She does not!");
    }

    private MimeUtils() {
    }
}
