package com.mchange.lang;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/* loaded from: grasscutter.jar:com/mchange/lang/ByteUtils.class */
public final class ByteUtils {
    public static final short UNSIGNED_MAX_VALUE = 255;

    public static short toUnsigned(byte b) {
        return (short) (b < 0 ? 256 + b : b);
    }

    public static int unsignedPromote(byte b) {
        return b & 255;
    }

    public static String toHexAscii(byte b) {
        StringWriter stringWriter = new StringWriter(2);
        addHexAscii(b, stringWriter);
        return stringWriter.toString();
    }

    public static String toLowercaseHexAscii(byte b) {
        StringWriter stringWriter = new StringWriter(2);
        addLowercaseHexAscii(b, stringWriter);
        return stringWriter.toString();
    }

    public static String toHexAscii(byte[] bArr) {
        int length = bArr.length;
        StringWriter stringWriter = new StringWriter(length * 2);
        for (byte b : bArr) {
            addHexAscii(b, stringWriter);
        }
        return stringWriter.toString();
    }

    public static String toLowercaseHexAscii(byte[] bArr) {
        int length = bArr.length;
        StringWriter stringWriter = new StringWriter(length * 2);
        for (byte b : bArr) {
            addLowercaseHexAscii(b, stringWriter);
        }
        return stringWriter.toString();
    }

    public static byte[] fromHexAscii(String str) throws NumberFormatException {
        try {
            int length = str.length();
            if (length % 2 != 0) {
                throw new NumberFormatException("Hex ascii must be exactly two digits per byte.");
            }
            int i = length / 2;
            byte[] bArr = new byte[i];
            int i2 = 0;
            StringReader stringReader = new StringReader(str);
            while (i2 < i) {
                i2++;
                bArr[i2] = (byte) ((16 * fromHexDigit(stringReader.read())) + fromHexDigit(stringReader.read()));
            }
            return bArr;
        } catch (IOException e) {
            throw new InternalError("IOException reading from StringReader?!?!");
        }
    }

    /* access modifiers changed from: package-private */
    public static void addHexAscii(byte b, StringWriter stringWriter) {
        int unsignedPromote = unsignedPromote(b);
        stringWriter.write(toHexDigit(unsignedPromote / 16));
        stringWriter.write(toHexDigit(unsignedPromote % 16));
    }

    static void addLowercaseHexAscii(byte b, StringWriter stringWriter) {
        int unsignedPromote = unsignedPromote(b);
        stringWriter.write(toLowercaseHexDigit(unsignedPromote / 16));
        stringWriter.write(toLowercaseHexDigit(unsignedPromote % 16));
    }

    private static int fromHexDigit(int i) throws NumberFormatException {
        if (i >= 48 && i < 58) {
            return i - 48;
        }
        if (i >= 65 && i < 71) {
            return i - 55;
        }
        if (i >= 97 && i < 103) {
            return i - 87;
        }
        throw new NumberFormatException((39 + i) + "' is not a valid hexadecimal digit.");
    }

    private static char toHexDigit(int i) {
        return i <= 9 ? (char) (i + 48) : (char) (i + 55);
    }

    private static char toLowercaseHexDigit(int i) {
        return i <= 9 ? (char) (i + 48) : (char) (i + 87);
    }

    private ByteUtils() {
    }
}
