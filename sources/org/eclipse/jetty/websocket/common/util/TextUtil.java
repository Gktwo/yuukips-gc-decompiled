package org.eclipse.jetty.websocket.common.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/util/TextUtil.class */
public final class TextUtil {
    public static String hint(String text) {
        if (text == null) {
            return "<null>";
        }
        return '\"' + maxStringLength(30, text) + '\"';
    }

    public static String maxStringLength(int max, String raw) {
        int length = raw.length();
        if (length <= max) {
            return raw;
        }
        if (max < 9) {
            return raw.substring(0, max);
        }
        StringBuilder ret = new StringBuilder();
        int startLen = (int) Math.round(((double) max) / 3.0d);
        ret.append((CharSequence) raw, 0, startLen);
        ret.append("...");
        ret.append(raw.substring(length - ((max - startLen) - 3)));
        return ret.toString();
    }
}
