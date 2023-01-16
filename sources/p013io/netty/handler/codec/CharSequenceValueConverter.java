package p013io.netty.handler.codec;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.text.ParseException;
import java.util.Date;
import p013io.netty.util.AsciiString;
import p013io.netty.util.internal.PlatformDependent;

/* renamed from: io.netty.handler.codec.CharSequenceValueConverter */
/* loaded from: grasscutter.jar:io/netty/handler/codec/CharSequenceValueConverter.class */
public class CharSequenceValueConverter implements ValueConverter<CharSequence> {
    public static final CharSequenceValueConverter INSTANCE = new CharSequenceValueConverter();
    private static final AsciiString TRUE_ASCII = new AsciiString(C3P0Substitutions.DEBUG);

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertObject(Object value) {
        if (value instanceof CharSequence) {
            return (CharSequence) value;
        }
        return value.toString();
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertInt(int value) {
        return String.valueOf(value);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertLong(long value) {
        return String.valueOf(value);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertDouble(double value) {
        return String.valueOf(value);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertChar(char value) {
        return String.valueOf(value);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertBoolean(boolean value) {
        return String.valueOf(value);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertFloat(float value) {
        return String.valueOf(value);
    }

    public boolean convertToBoolean(CharSequence value) {
        return AsciiString.contentEqualsIgnoreCase(value, TRUE_ASCII);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertByte(byte value) {
        return String.valueOf((int) value);
    }

    public byte convertToByte(CharSequence value) {
        if (!(value instanceof AsciiString) || value.length() != 1) {
            return Byte.parseByte(value.toString());
        }
        return ((AsciiString) value).byteAt(0);
    }

    public char convertToChar(CharSequence value) {
        return value.charAt(0);
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertShort(short value) {
        return String.valueOf((int) value);
    }

    public short convertToShort(CharSequence value) {
        if (value instanceof AsciiString) {
            return ((AsciiString) value).parseShort();
        }
        return Short.parseShort(value.toString());
    }

    public int convertToInt(CharSequence value) {
        if (value instanceof AsciiString) {
            return ((AsciiString) value).parseInt();
        }
        return Integer.parseInt(value.toString());
    }

    public long convertToLong(CharSequence value) {
        if (value instanceof AsciiString) {
            return ((AsciiString) value).parseLong();
        }
        return Long.parseLong(value.toString());
    }

    @Override // p013io.netty.handler.codec.ValueConverter
    public CharSequence convertTimeMillis(long value) {
        return DateFormatter.format(new Date(value));
    }

    public long convertToTimeMillis(CharSequence value) {
        Date date = DateFormatter.parseHttpDate(value);
        if (date != null) {
            return date.getTime();
        }
        PlatformDependent.throwException(new ParseException("header can't be parsed into a Date: " + ((Object) value), 0));
        return 0;
    }

    public float convertToFloat(CharSequence value) {
        if (value instanceof AsciiString) {
            return ((AsciiString) value).parseFloat();
        }
        return Float.parseFloat(value.toString());
    }

    public double convertToDouble(CharSequence value) {
        if (value instanceof AsciiString) {
            return ((AsciiString) value).parseDouble();
        }
        return Double.parseDouble(value.toString());
    }
}
