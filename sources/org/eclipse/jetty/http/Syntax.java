package org.eclipse.jetty.http;

import java.util.Objects;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/Syntax.class */
public final class Syntax {
    public static void requireValidRFC2616Token(String value, String msg) {
        int valueLen;
        Objects.requireNonNull(msg, "msg cannot be null");
        if (!(value == null || (valueLen = value.length()) == 0)) {
            for (int i = 0; i < valueLen; i++) {
                char c = value.charAt(i);
                if (c <= 31 || c == 127) {
                    throw new IllegalArgumentException(msg + ": RFC2616 tokens may not contain control characters");
                } else if (c == '(' || c == ')' || c == '<' || c == '>' || c == '@' || c == ',' || c == ';' || c == ':' || c == '\\' || c == '\"' || c == '/' || c == '[' || c == ']' || c == '?' || c == '=' || c == '{' || c == '}' || c == ' ') {
                    throw new IllegalArgumentException(msg + ": RFC2616 tokens may not contain separator character: [" + c + "]");
                } else if (c >= 128) {
                    throw new IllegalArgumentException(msg + ": RFC2616 tokens characters restricted to US-ASCII: 0x" + Integer.toHexString(c));
                }
            }
        }
    }

    public static void requireValidRFC6265CookieValue(String value) {
        if (value != null) {
            int valueLen = value.length();
            if (valueLen != 0) {
                int i = 0;
                if (value.charAt(0) == '\"') {
                    if (valueLen <= 1 || value.charAt(valueLen - 1) != '\"') {
                        throw new IllegalArgumentException("RFC6265 Cookie values must have balanced DQUOTES (if used)");
                    }
                    i = 0 + 1;
                    valueLen--;
                }
                while (i < valueLen) {
                    char c = value.charAt(i);
                    if (c <= 31 || c == 127) {
                        throw new IllegalArgumentException("RFC6265 Cookie values may not contain control characters");
                    } else if (c == ' ' || c == '\"' || c == ';' || c == '\\') {
                        throw new IllegalArgumentException("RFC6265 Cookie values may not contain character: [" + c + "]");
                    } else if (c >= 128) {
                        throw new IllegalArgumentException("RFC6265 Cookie values characters restricted to US-ASCII: 0x" + Integer.toHexString(c));
                    } else {
                        i++;
                    }
                }
            }
        }
    }
}
