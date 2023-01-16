package com.mchange.p009v2.log;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/* renamed from: com.mchange.v2.log.LogUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/log/LogUtils.class */
public final class LogUtils {
    public static String createParamsList(Object[] objArr) {
        StringBuffer stringBuffer = new StringBuffer(511);
        appendParamsList(stringBuffer, objArr);
        return stringBuffer.toString();
    }

    public static void appendParamsList(StringBuffer stringBuffer, Object[] objArr) {
        stringBuffer.append("[params: ");
        if (objArr != null) {
            int length = objArr.length;
            for (int i = 0; i < length; i++) {
                if (i != 0) {
                    stringBuffer.append(", ");
                }
                stringBuffer.append(objArr[i]);
            }
        }
        stringBuffer.append(']');
    }

    public static String createMessage(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer(511);
        stringBuffer.append("[class: ");
        stringBuffer.append(str);
        stringBuffer.append("; method: ");
        stringBuffer.append(str2);
        if (!str2.endsWith(")")) {
            stringBuffer.append("()");
        }
        stringBuffer.append("] ");
        stringBuffer.append(str3);
        return stringBuffer.toString();
    }

    public static String createMessage(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer(511);
        stringBuffer.append("[method: ");
        stringBuffer.append(str);
        if (!str.endsWith(")")) {
            stringBuffer.append("()");
        }
        stringBuffer.append("] ");
        stringBuffer.append(str2);
        return stringBuffer.toString();
    }

    public static String formatMessage(String str, String str2, Object[] objArr) {
        ResourceBundle bundle;
        String string;
        if (str2 != null) {
            if (!(str == null || (bundle = ResourceBundle.getBundle(str)) == null || (string = bundle.getString(str2)) == null)) {
                str2 = string;
            }
            return objArr == null ? str2 : MessageFormat.format(str2, objArr);
        } else if (objArr == null) {
            return "";
        } else {
            return createParamsList(objArr);
        }
    }

    private LogUtils() {
    }
}
