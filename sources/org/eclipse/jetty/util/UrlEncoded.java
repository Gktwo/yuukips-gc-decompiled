package org.eclipse.jetty.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.util.Utf8Appendable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/UrlEncoded.class */
public class UrlEncoded extends MultiMap<String> implements Cloneable {
    static final Logger LOG = Log.getLogger(UrlEncoded.class);
    public static final Charset ENCODING;

    static {
        Charset encoding;
        try {
            String charset = System.getProperty("org.eclipse.jetty.util.UrlEncoding.charset");
            encoding = charset == null ? StandardCharsets.UTF_8 : Charset.forName(charset);
        } catch (Exception e) {
            LOG.warn(e);
            encoding = StandardCharsets.UTF_8;
        }
        ENCODING = encoding;
    }

    public UrlEncoded(UrlEncoded url) {
        super((MultiMap) url);
    }

    public UrlEncoded() {
    }

    public UrlEncoded(String query) {
        decodeTo(query, this, ENCODING);
    }

    public void decode(String query) {
        decodeTo(query, this, ENCODING);
    }

    public void decode(String query, Charset charset) {
        decodeTo(query, this, charset);
    }

    public String encode() {
        return encode(ENCODING, false);
    }

    public String encode(Charset charset) {
        return encode(charset, false);
    }

    public synchronized String encode(Charset charset, boolean equalsForNullValue) {
        return encode(this, charset, equalsForNullValue);
    }

    public static String encode(MultiMap<String> map, Charset charset, boolean equalsForNullValue) {
        if (charset == null) {
            charset = ENCODING;
        }
        StringBuilder result = new StringBuilder(128);
        boolean delim = false;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            List<String> list = (List) entry.getValue();
            int s = list.size();
            if (delim) {
                result.append('&');
            }
            if (s == 0) {
                result.append(encodeString(key, charset));
                if (equalsForNullValue) {
                    result.append('=');
                }
            } else {
                for (int i = 0; i < s; i++) {
                    if (i > 0) {
                        result.append('&');
                    }
                    String val = list.get(i);
                    result.append(encodeString(key, charset));
                    if (val != null) {
                        if (val.length() > 0) {
                            result.append('=');
                            result.append(encodeString(val, charset));
                        } else if (equalsForNullValue) {
                            result.append('=');
                        }
                    } else if (equalsForNullValue) {
                        result.append('=');
                    }
                }
            }
            delim = true;
        }
        return result.toString();
    }

    public static void decodeTo(String content, MultiMap<String> map, String charset) {
        decodeTo(content, map, charset == null ? null : Charset.forName(charset));
    }

    public static void decodeTo(String content, MultiMap<String> map, Charset charset) {
        String key;
        if (charset == null) {
            charset = ENCODING;
        }
        if (StandardCharsets.UTF_8.equals(charset)) {
            decodeUtf8To(content, 0, content.length(), map);
            return;
        }
        synchronized (map) {
            String key2 = null;
            int mark = -1;
            boolean encoded = false;
            for (int i = 0; i < content.length(); i++) {
                switch (content.charAt(i)) {
                    case '%':
                        encoded = true;
                        break;
                    case '&':
                        int l = (i - mark) - 1;
                        String value = l == 0 ? "" : encoded ? decodeString(content, mark + 1, l, charset) : content.substring(mark + 1, i);
                        mark = i;
                        encoded = false;
                        if (key2 != null) {
                            map.add(key2, value);
                        } else if (value != null && value.length() > 0) {
                            map.add(value, "");
                        }
                        key2 = null;
                        break;
                    case '+':
                        encoded = true;
                        break;
                    case '=':
                        if (key2 == null) {
                            key2 = encoded ? decodeString(content, mark + 1, (i - mark) - 1, charset) : content.substring(mark + 1, i);
                            mark = i;
                            encoded = false;
                            break;
                        } else {
                            break;
                        }
                }
            }
            if (key2 != null) {
                int l2 = (content.length() - mark) - 1;
                map.add(key2, l2 == 0 ? "" : encoded ? decodeString(content, mark + 1, l2, charset) : content.substring(mark + 1));
            } else if (mark < content.length()) {
                if (encoded) {
                    key = decodeString(content, mark + 1, (content.length() - mark) - 1, charset);
                } else {
                    key = content.substring(mark + 1);
                }
                if (key != null && key.length() > 0) {
                    map.add(key, "");
                }
            }
        }
    }

    public static void decodeUtf8To(String query, MultiMap<String> map) {
        decodeUtf8To(query, 0, query.length(), map);
    }

    public static void decodeUtf8To(String query, int offset, int length, MultiMap<String> map) {
        Utf8StringBuilder buffer = new Utf8StringBuilder();
        synchronized (map) {
            String key = null;
            int end = offset + length;
            int i = offset;
            while (i < end) {
                char c = query.charAt(i);
                switch (c) {
                    case '%':
                        if (i + 2 < end) {
                            int i2 = i + 1;
                            char hi = query.charAt(i2);
                            i = i2 + 1;
                            buffer.append(decodeHexByte(hi, query.charAt(i)));
                            break;
                        } else {
                            throw new Utf8Appendable.NotUtf8Exception("Incomplete % encoding");
                        }
                    case '&':
                        String value = buffer.toReplacedString();
                        buffer.reset();
                        if (key != null) {
                            map.add(key, value);
                        } else if (value != null && value.length() > 0) {
                            map.add(value, "");
                        }
                        key = null;
                        break;
                    case '+':
                        buffer.append((byte) 32);
                        break;
                    case '=':
                        if (key == null) {
                            key = buffer.toReplacedString();
                            buffer.reset();
                            break;
                        } else {
                            buffer.append(c);
                            break;
                        }
                    default:
                        buffer.append(c);
                        break;
                }
                i++;
            }
            if (key != null) {
                String value2 = buffer.toReplacedString();
                buffer.reset();
                map.add(key, value2);
            } else if (buffer.length() > 0) {
                map.add(buffer.toReplacedString(), "");
            }
        }
    }

    public static void decode88591To(InputStream in, MultiMap<String> map, int maxLength, int maxKeys) throws IOException {
        synchronized (map) {
            StringBuilder buffer = new StringBuilder();
            String key = null;
            int totalLength = 0;
            while (true) {
                int b = in.read();
                if (b >= 0) {
                    switch ((char) b) {
                        case '%':
                            buffer.append(decodeHexChar(in.read(), in.read()));
                            break;
                        case '&':
                            String value = buffer.length() == 0 ? "" : buffer.toString();
                            buffer.setLength(0);
                            if (key != null) {
                                map.add(key, value);
                            } else if (value.length() > 0) {
                                map.add(value, "");
                            }
                            key = null;
                            checkMaxKeys(map, maxKeys);
                            break;
                        case '+':
                            buffer.append(' ');
                            break;
                        case '=':
                            if (key == null) {
                                key = buffer.toString();
                                buffer.setLength(0);
                                break;
                            } else {
                                buffer.append((char) b);
                                break;
                            }
                        default:
                            buffer.append((char) b);
                            break;
                    }
                    totalLength++;
                    checkMaxLength(totalLength, maxLength);
                } else {
                    if (key != null) {
                        String value2 = buffer.length() == 0 ? "" : buffer.toString();
                        buffer.setLength(0);
                        map.add(key, value2);
                    } else if (buffer.length() > 0) {
                        map.add(buffer.toString(), "");
                    }
                    checkMaxKeys(map, maxKeys);
                }
            }
        }
    }

    public static void decodeUtf8To(InputStream in, MultiMap<String> map, int maxLength, int maxKeys) throws IOException {
        synchronized (map) {
            Utf8StringBuilder buffer = new Utf8StringBuilder();
            String key = null;
            int totalLength = 0;
            while (true) {
                int b = in.read();
                if (b >= 0) {
                    switch ((char) b) {
                        case '%':
                            buffer.append(decodeHexByte((char) in.read(), (char) in.read()));
                            break;
                        case '&':
                            String value = buffer.toReplacedString();
                            buffer.reset();
                            if (key != null) {
                                map.add(key, value);
                            } else if (value != null && value.length() > 0) {
                                map.add(value, "");
                            }
                            key = null;
                            checkMaxKeys(map, maxKeys);
                            break;
                        case '+':
                            buffer.append((byte) 32);
                            break;
                        case '=':
                            if (key == null) {
                                key = buffer.toReplacedString();
                                buffer.reset();
                                break;
                            } else {
                                buffer.append((byte) b);
                                break;
                            }
                        default:
                            buffer.append((byte) b);
                            break;
                    }
                    totalLength++;
                    checkMaxLength(totalLength, maxLength);
                } else {
                    if (key != null) {
                        String value2 = buffer.toReplacedString();
                        buffer.reset();
                        map.add(key, value2);
                    } else if (buffer.length() > 0) {
                        map.add(buffer.toReplacedString(), "");
                    }
                    checkMaxKeys(map, maxKeys);
                }
            }
        }
    }

    public static void decodeUtf16To(InputStream in, MultiMap<String> map, int maxLength, int maxKeys) throws IOException {
        InputStreamReader input = new InputStreamReader(in, StandardCharsets.UTF_16);
        StringWriter buf = new StringWriter(8192);
        C5739IO.copy(input, buf, (long) maxLength);
        decodeTo(buf.getBuffer().toString(), map, StandardCharsets.UTF_16);
    }

    public static void decodeTo(InputStream in, MultiMap<String> map, String charset, int maxLength, int maxKeys) throws IOException {
        if (charset == null) {
            if (ENCODING.equals(StandardCharsets.UTF_8)) {
                decodeUtf8To(in, map, maxLength, maxKeys);
            } else {
                decodeTo(in, map, ENCODING, maxLength, maxKeys);
            }
        } else if (StringUtil.__UTF8.equalsIgnoreCase(charset)) {
            decodeUtf8To(in, map, maxLength, maxKeys);
        } else if (StringUtil.__ISO_8859_1.equalsIgnoreCase(charset)) {
            decode88591To(in, map, maxLength, maxKeys);
        } else if (StringUtil.__UTF16.equalsIgnoreCase(charset)) {
            decodeUtf16To(in, map, maxLength, maxKeys);
        } else {
            decodeTo(in, map, Charset.forName(charset), maxLength, maxKeys);
        }
    }

    public static void decodeTo(InputStream in, MultiMap<String> map, Charset charset, int maxLength, int maxKeys) throws IOException {
        if (charset == null) {
            charset = ENCODING;
        }
        if (StandardCharsets.UTF_8.equals(charset)) {
            decodeUtf8To(in, map, maxLength, maxKeys);
        } else if (StandardCharsets.ISO_8859_1.equals(charset)) {
            decode88591To(in, map, maxLength, maxKeys);
        } else if (StandardCharsets.UTF_16.equals(charset)) {
            decodeUtf16To(in, map, maxLength, maxKeys);
        } else {
            synchronized (map) {
                String key = null;
                int totalLength = 0;
                ByteArrayOutputStream2 output = new ByteArrayOutputStream2();
                while (true) {
                    int c = in.read();
                    if (c > 0) {
                        switch ((char) c) {
                            case '%':
                                output.write(decodeHexChar(in.read(), in.read()));
                                break;
                            case '&':
                                String value = output.size() == 0 ? "" : output.toString(charset);
                                output.setCount(0);
                                if (key != null) {
                                    map.add(key, value);
                                } else if (value != null && value.length() > 0) {
                                    map.add(value, "");
                                }
                                key = null;
                                checkMaxKeys(map, maxKeys);
                                break;
                            case '+':
                                output.write(32);
                                break;
                            case '=':
                                if (key == null) {
                                    key = output.size() == 0 ? "" : output.toString(charset);
                                    output.setCount(0);
                                    break;
                                } else {
                                    output.write(c);
                                    break;
                                }
                            default:
                                output.write(c);
                                break;
                        }
                        totalLength++;
                        checkMaxLength(totalLength, maxLength);
                    } else {
                        int size = output.size();
                        if (key != null) {
                            String value2 = size == 0 ? "" : output.toString(charset);
                            output.setCount(0);
                            map.add(key, value2);
                        } else if (size > 0) {
                            map.add(output.toString(charset), "");
                        }
                        checkMaxKeys(map, maxKeys);
                        output.close();
                    }
                }
            }
        }
    }

    private static void checkMaxKeys(MultiMap<String> map, int maxKeys) {
        int size = map.size();
        if (maxKeys >= 0 && size > maxKeys) {
            throw new IllegalStateException(String.format("Form with too many keys [%d > %d]", Integer.valueOf(size), Integer.valueOf(maxKeys)));
        }
    }

    private static void checkMaxLength(int length, int maxLength) {
        if (maxLength >= 0 && length > maxLength) {
            throw new IllegalStateException("Form is larger than max length " + maxLength);
        }
    }

    public static String decodeString(String encoded) {
        return decodeString(encoded, 0, encoded.length(), ENCODING);
    }

    public static String decodeString(String encoded, int offset, int length, Charset charset) {
        if (charset == null || StandardCharsets.UTF_8.equals(charset)) {
            Utf8StringBuffer buffer = null;
            int i = 0;
            while (i < length) {
                char c = encoded.charAt(offset + i);
                if (c < 0 || c > 255) {
                    if (buffer == null) {
                        buffer = new Utf8StringBuffer(length);
                        buffer.getStringBuffer().append((CharSequence) encoded, offset, offset + i + 1);
                    } else {
                        buffer.getStringBuffer().append(c);
                    }
                } else if (c == '+') {
                    if (buffer == null) {
                        buffer = new Utf8StringBuffer(length);
                        buffer.getStringBuffer().append((CharSequence) encoded, offset, offset + i);
                    }
                    buffer.getStringBuffer().append(' ');
                } else if (c == '%') {
                    if (buffer == null) {
                        buffer = new Utf8StringBuffer(length);
                        buffer.getStringBuffer().append((CharSequence) encoded, offset, offset + i);
                    }
                    if (i + 2 < length) {
                        i += 2;
                        buffer.append((byte) TypeUtil.parseInt(encoded, offset + i + 1, 2, 16));
                    } else {
                        buffer.getStringBuffer().append((char) 65533);
                        i = length;
                    }
                } else if (buffer != null) {
                    buffer.getStringBuffer().append(c);
                }
                i++;
            }
            if (buffer != null) {
                return buffer.toReplacedString();
            }
            if (offset == 0 && encoded.length() == length) {
                return encoded;
            }
            return encoded.substring(offset, offset + length);
        }
        StringBuffer buffer2 = null;
        int i2 = 0;
        while (i2 < length) {
            char c2 = encoded.charAt(offset + i2);
            if (c2 < 0 || c2 > 255) {
                if (buffer2 == null) {
                    buffer2 = new StringBuffer(length);
                    buffer2.append((CharSequence) encoded, offset, offset + i2 + 1);
                } else {
                    buffer2.append(c2);
                }
            } else if (c2 == '+') {
                if (buffer2 == null) {
                    buffer2 = new StringBuffer(length);
                    buffer2.append((CharSequence) encoded, offset, offset + i2);
                }
                buffer2.append(' ');
            } else if (c2 == '%') {
                if (buffer2 == null) {
                    buffer2 = new StringBuffer(length);
                    buffer2.append((CharSequence) encoded, offset, offset + i2);
                }
                byte[] ba = new byte[length];
                int n = 0;
                while (c2 >= 0 && c2 <= 255) {
                    if (c2 == '%') {
                        if (i2 + 2 < length) {
                            i2 += 3;
                            ba[n] = (byte) TypeUtil.parseInt(encoded, offset + i2 + 1, 2, 16);
                            n++;
                        } else {
                            n++;
                            ba[n] = 63;
                            i2 = length;
                        }
                    } else if (c2 == '+') {
                        n++;
                        ba[n] = 32;
                        i2++;
                    } else {
                        n++;
                        ba[n] = (byte) c2;
                        i2++;
                    }
                    if (i2 >= length) {
                        break;
                    }
                    c2 = encoded.charAt(offset + i2);
                }
                i2--;
                buffer2.append(new String(ba, 0, n, charset));
            } else if (buffer2 != null) {
                buffer2.append(c2);
            }
            i2++;
        }
        if (buffer2 != null) {
            return buffer2.toString();
        }
        if (offset == 0 && encoded.length() == length) {
            return encoded;
        }
        return encoded.substring(offset, offset + length);
    }

    private static char decodeHexChar(int hi, int lo) {
        try {
            return (char) ((TypeUtil.convertHexDigit(hi) << 4) + TypeUtil.convertHexDigit(lo));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid encoding '%" + ((char) hi) + ((char) lo) + "'");
        }
    }

    private static byte decodeHexByte(char hi, char lo) {
        try {
            return (byte) ((TypeUtil.convertHexDigit(hi) << 4) + TypeUtil.convertHexDigit(lo));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Not valid encoding '%" + hi + lo + "'");
        }
    }

    public static String encodeString(String string) {
        return encodeString(string, ENCODING);
    }

    public static String encodeString(String string, Charset charset) {
        int n;
        if (charset == null) {
            charset = ENCODING;
        }
        byte[] bytes = string.getBytes(charset);
        byte[] encoded = new byte[bytes.length * 3];
        int n2 = 0;
        boolean noEncode = true;
        for (byte b : bytes) {
            if (b == 32) {
                noEncode = false;
                n2++;
                encoded[n2] = 43;
            } else if ((b < 97 || b > 122) && ((b < 65 || b > 90) && !((b >= 48 && b <= 57) || b == 45 || b == 46 || b == 95 || b == 126))) {
                noEncode = false;
                int n3 = n2 + 1;
                encoded[n2] = 37;
                byte nibble = (byte) ((b & 240) >> 4);
                if (nibble >= 10) {
                    n = n3 + 1;
                    encoded[n3] = (byte) ((65 + nibble) - 10);
                } else {
                    n = n3 + 1;
                    encoded[n3] = (byte) (48 + nibble);
                }
                byte nibble2 = (byte) (b & 15);
                if (nibble2 >= 10) {
                    n2 = n + 1;
                    encoded[n] = (byte) ((65 + nibble2) - 10);
                } else {
                    n2 = n + 1;
                    encoded[n] = (byte) (48 + nibble2);
                }
            } else {
                n2++;
                encoded[n2] = b;
            }
        }
        if (noEncode) {
            return string;
        }
        return new String(encoded, 0, n2, charset);
    }

    @Override // java.util.AbstractMap, java.util.HashMap, java.lang.Object
    public Object clone() {
        return new UrlEncoded(this);
    }
}
