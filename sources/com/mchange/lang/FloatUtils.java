package com.mchange.lang;

/* loaded from: grasscutter.jar:com/mchange/lang/FloatUtils.class */
public final class FloatUtils {
    static final boolean DEBUG = true;
    private static FParser fParser;

    /* loaded from: grasscutter.jar:com/mchange/lang/FloatUtils$FParser.class */
    interface FParser {
        float parseFloat(String str) throws NumberFormatException;
    }

    static {
        try {
            fParser = new J12FParser();
            fParser.parseFloat("0.1");
        } catch (NoSuchMethodError e) {
            System.err.println("com.mchange.lang.FloatUtils: reconfiguring for Java 1.1 environment");
            fParser = new J11FParser();
        }
    }

    public static byte[] byteArrayFromFloat(float f) {
        return IntegerUtils.byteArrayFromInt(Float.floatToIntBits(f));
    }

    public static float floatFromByteArray(byte[] bArr, int i) {
        return Float.intBitsToFloat(IntegerUtils.intFromByteArray(bArr, i));
    }

    public static float parseFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return fParser.parseFloat(str);
        } catch (NumberFormatException e) {
            return f;
        }
    }

    public static float parseFloat(String str) throws NumberFormatException {
        return fParser.parseFloat(str);
    }

    public static String floatToString(float f, int i) {
        boolean z = f < 0.0f;
        long round = Math.round(((double) (z ? -f : f)) * Math.pow(10.0d, (double) (-i)));
        String valueOf = String.valueOf(round);
        if (round == 0) {
            return valueOf;
        }
        int length = valueOf.length();
        int i2 = length + i;
        StringBuffer stringBuffer = new StringBuffer(32);
        if (z) {
            stringBuffer.append('-');
        }
        if (i2 <= 0) {
            stringBuffer.append("0.");
            for (int i3 = 0; i3 < (-i2); i3++) {
                stringBuffer.append('0');
            }
            stringBuffer.append(valueOf);
        } else {
            stringBuffer.append(valueOf.substring(0, Math.min(i2, length)));
            if (i2 < length) {
                stringBuffer.append('.');
                stringBuffer.append(valueOf.substring(i2));
            } else if (i2 > length) {
                int i4 = i2 - length;
                for (int i5 = 0; i5 < i4; i5++) {
                    stringBuffer.append('0');
                }
            }
        }
        return stringBuffer.toString();
    }

    /* loaded from: grasscutter.jar:com/mchange/lang/FloatUtils$J12FParser.class */
    static class J12FParser implements FParser {
        J12FParser() {
        }

        @Override // com.mchange.lang.FloatUtils.FParser
        public float parseFloat(String str) throws NumberFormatException {
            return Float.parseFloat(str);
        }
    }

    /* loaded from: grasscutter.jar:com/mchange/lang/FloatUtils$J11FParser.class */
    static class J11FParser implements FParser {
        J11FParser() {
        }

        @Override // com.mchange.lang.FloatUtils.FParser
        public float parseFloat(String str) throws NumberFormatException {
            return new Float(str).floatValue();
        }
    }
}
