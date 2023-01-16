package p001ch.qos.logback.core.encoder;

import java.io.ByteArrayOutputStream;

/* renamed from: ch.qos.logback.core.encoder.ByteArrayUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/encoder/ByteArrayUtil.class */
public class ByteArrayUtil {
    static void writeInt(byte[] byteArray, int offset, int i) {
        for (int j = 0; j < 4; j++) {
            byteArray[offset + j] = (byte) (i >>> (24 - (j * 8)));
        }
    }

    static void writeInt(ByteArrayOutputStream baos, int i) {
        for (int j = 0; j < 4; j++) {
            baos.write((byte) (i >>> (24 - (j * 8))));
        }
    }

    static int readInt(byte[] byteArray, int offset) {
        int i = 0;
        for (int j = 0; j < 4; j++) {
            i += (byteArray[offset + j] & 255) << (24 - (j * 8));
        }
        return i;
    }

    public static String toHexString(byte[] ba) {
        StringBuilder sbuf = new StringBuilder();
        for (byte b : ba) {
            String s = Integer.toHexString(b & 255);
            if (s.length() == 1) {
                sbuf.append('0');
            }
            sbuf.append(s);
        }
        return sbuf.toString();
    }

    public static byte[] hexStringToByteArray(String s) {
        byte[] ba = new byte[s.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            int j = i * 2;
            ba[i] = (byte) (Integer.parseInt(s.substring(j, j + 2), 16) & 255);
        }
        return ba;
    }
}
