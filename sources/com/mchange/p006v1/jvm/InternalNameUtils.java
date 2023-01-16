package com.mchange.p006v1.jvm;

import okhttp3.HttpUrl;

/* renamed from: com.mchange.v1.jvm.InternalNameUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/jvm/InternalNameUtils.class */
public final class InternalNameUtils {
    public static String dottifySlashesAndDollarSigns(String str) {
        return _dottifySlashesAndDollarSigns(str).toString();
    }

    public static String decodeType(String str) throws TypeFormatException {
        return _decodeType(str).toString();
    }

    public static String decodeTypeList(String str) throws TypeFormatException {
        StringBuffer stringBuffer = new StringBuffer(64);
        _decodeTypeList(str, 0, stringBuffer);
        return stringBuffer.toString();
    }

    public static boolean isPrimitive(char c) {
        return c == 'Z' || c == 'B' || c == 'C' || c == 'S' || c == 'I' || c == 'J' || c == 'F' || c == 'D' || c == 'V';
    }

    private static void _decodeTypeList(String str, int i, StringBuffer stringBuffer) throws TypeFormatException {
        int i2;
        int i3;
        if (stringBuffer.length() != 0) {
            stringBuffer.append(' ');
        }
        char charAt = str.charAt(i);
        if (isPrimitive(charAt)) {
            stringBuffer.append(_decodeType(str.substring(i, i + 1)));
            i2 = i + 1;
        } else {
            if (charAt == '[') {
                int i4 = i + 1;
                while (str.charAt(i4) == '[') {
                    i4++;
                }
                if (str.charAt(i4) == 'L') {
                    while (true) {
                        i4++;
                        if (str.charAt(i4) == ';') {
                            break;
                        }
                    }
                }
                i3 = i4;
            } else {
                i3 = str.indexOf(59, i);
                if (i3 < 0) {
                    throw new TypeFormatException(str.substring(i) + " is neither a primitive nor semicolon terminated!");
                }
            }
            int i5 = i3 + 1;
            i2 = i5;
            stringBuffer.append(_decodeType(str.substring(i, i5)));
        }
        if (i2 < str.length()) {
            stringBuffer.append(',');
            _decodeTypeList(str, i2, stringBuffer);
        }
    }

    private static StringBuffer _decodeType(String str) throws TypeFormatException {
        StringBuffer stringBuffer;
        int i = 0;
        switch (str.charAt(0)) {
            case 'B':
                stringBuffer = new StringBuffer("byte");
                break;
            case 'C':
                stringBuffer = new StringBuffer("char");
                break;
            case 'D':
                stringBuffer = new StringBuffer("double");
                break;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                throw new TypeFormatException(str + " is not a valid inernal type name.");
            case 'F':
                stringBuffer = new StringBuffer("float");
                break;
            case 'I':
                stringBuffer = new StringBuffer("int");
                break;
            case 'J':
                stringBuffer = new StringBuffer("long");
                break;
            case 'L':
                stringBuffer = _decodeSimpleClassType(str);
                break;
            case 'S':
                stringBuffer = new StringBuffer("short");
                break;
            case 'V':
                stringBuffer = new StringBuffer("void");
                break;
            case 'Z':
                stringBuffer = new StringBuffer("boolean");
                break;
            case '[':
                i = 0 + 1;
                stringBuffer = _decodeType(str.substring(1));
                break;
        }
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        }
        return stringBuffer;
    }

    private static StringBuffer _decodeSimpleClassType(String str) throws TypeFormatException {
        int length = str.length();
        if (str.charAt(0) == 'L' && str.charAt(length - 1) == ';') {
            return _dottifySlashesAndDollarSigns(str.substring(1, length - 1));
        }
        throw new TypeFormatException(str + " is not a valid representation of a simple class type.");
    }

    private static StringBuffer _dottifySlashesAndDollarSigns(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        int length = stringBuffer.length();
        for (int i = 0; i < length; i++) {
            char charAt = stringBuffer.charAt(i);
            if (charAt == '/' || charAt == '$') {
                stringBuffer.setCharAt(i, '.');
            }
        }
        return stringBuffer;
    }

    private InternalNameUtils() {
    }

    public static void main(String[] strArr) {
        try {
            System.out.println(decodeTypeList(strArr[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
