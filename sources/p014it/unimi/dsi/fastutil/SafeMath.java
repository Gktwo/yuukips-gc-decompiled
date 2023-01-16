package p014it.unimi.dsi.fastutil;

import okhttp3.internal.p021ws.WebSocketProtocol;

/* renamed from: it.unimi.dsi.fastutil.SafeMath */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/SafeMath.class */
public final class SafeMath {
    private SafeMath() {
    }

    public static char safeIntToChar(int value) {
        if (value >= 0 && 65535 >= value) {
            return (char) value;
        }
        throw new IllegalArgumentException(value + " can't be represented as char");
    }

    public static byte safeIntToByte(int value) {
        if (value >= -128 && 127 >= value) {
            return (byte) value;
        }
        throw new IllegalArgumentException(value + " can't be represented as byte (out of range)");
    }

    public static short safeIntToShort(int value) {
        if (value >= -32768 && 32767 >= value) {
            return (short) value;
        }
        throw new IllegalArgumentException(value + " can't be represented as short (out of range)");
    }

    public static char safeLongToChar(long value) {
        if (value >= 0 && WebSocketProtocol.PAYLOAD_SHORT_MAX >= value) {
            return (char) ((int) value);
        }
        throw new IllegalArgumentException(value + " can't be represented as int (out of range)");
    }

    public static byte safeLongToByte(long value) {
        if (value >= -128 && 127 >= value) {
            return (byte) ((int) value);
        }
        throw new IllegalArgumentException(value + " can't be represented as int (out of range)");
    }

    public static short safeLongToShort(long value) {
        if (value >= -32768 && 32767 >= value) {
            return (short) ((int) value);
        }
        throw new IllegalArgumentException(value + " can't be represented as int (out of range)");
    }

    public static int safeLongToInt(long value) {
        if (value >= -2147483648L && 2147483647L >= value) {
            return (int) value;
        }
        throw new IllegalArgumentException(value + " can't be represented as int (out of range)");
    }

    public static float safeDoubleToFloat(double value) {
        if (Double.isNaN(value)) {
            return Float.NaN;
        }
        if (Double.isInfinite(value)) {
            return value < 0.0d ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        }
        if (value < -3.4028234663852886E38d || 3.4028234663852886E38d < value) {
            throw new IllegalArgumentException(value + " can't be represented as float (out of range)");
        }
        float floatValue = (float) value;
        if (((double) floatValue) == value) {
            return floatValue;
        }
        throw new IllegalArgumentException(value + " can't be represented as float (imprecise)");
    }
}
