package nonapi.p019io.github.classgraph.json;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import nonapi.p019io.github.classgraph.types.ParseException;
import nonapi.p019io.github.classgraph.types.Parser;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.JSONParser */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONParser.class */
public final class JSONParser extends Parser {
    private JSONParser(String string) throws ParseException {
        super(string);
    }

    private int getAndParseHexChar() throws ParseException {
        char hexChar = getc();
        if (hexChar >= '0' && hexChar <= '9') {
            return hexChar - '0';
        }
        if (hexChar >= 'a' && hexChar <= 'f') {
            return (hexChar - 'a') + 10;
        }
        if (hexChar >= 'A' && hexChar <= 'F') {
            return (hexChar - 'A') + 10;
        }
        throw new ParseException(this, "Invalid character in Unicode escape sequence: " + hexChar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ce  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.CharSequence parseString() throws nonapi.p019io.github.classgraph.types.ParseException {
        /*
        // Method dump skipped, instructions count: 522
        */
        throw new UnsupportedOperationException("Method not decompiled: nonapi.p019io.github.classgraph.json.JSONParser.parseString():java.lang.CharSequence");
    }

    private Number parseNumber() throws ParseException {
        int startIdx = getPosition();
        if (peekMatches("Infinity")) {
            advance(8);
            return Double.valueOf(Double.POSITIVE_INFINITY);
        } else if (peekMatches("-Infinity")) {
            advance(9);
            return Double.valueOf(Double.NEGATIVE_INFINITY);
        } else if (peekMatches("NaN")) {
            advance(3);
            return Double.valueOf(Double.NaN);
        } else {
            if (peek() == '-') {
                next();
            }
            int integralStartIdx = getPosition();
            while (hasMore() && (c = peek()) >= '0' && c <= '9') {
                next();
            }
            int integralEndIdx = getPosition();
            int numIntegralDigits = integralEndIdx - integralStartIdx;
            if (numIntegralDigits == 0) {
                throw new ParseException(this, "Expected a number");
            }
            boolean hasFractionalPart = peek() == '.';
            if (hasFractionalPart) {
                next();
                while (hasMore() && (c = peek()) >= '0' && c <= '9') {
                    next();
                }
                if (getPosition() - (integralEndIdx + 1) == 0) {
                    throw new ParseException(this, "Expected digits after decimal point");
                }
            }
            boolean hasExponentPart = peek() == 'e' || peek() == 'E';
            if (hasExponentPart) {
                next();
                char sign = peek();
                if (sign == '-' || sign == '+') {
                    next();
                }
                int exponentStart = getPosition();
                while (hasMore() && (c = peek()) >= '0' && c <= '9') {
                    next();
                }
                if (getPosition() - exponentStart == 0) {
                    throw new ParseException(this, "Expected an exponent");
                }
            }
            String numberStr = getSubstring(startIdx, getPosition());
            if (hasFractionalPart || hasExponentPart) {
                return Double.valueOf(numberStr);
            }
            if (numIntegralDigits < 9) {
                return Integer.valueOf(numberStr);
            }
            if (numIntegralDigits != 9) {
                return Long.valueOf(numberStr);
            }
            long longVal = Long.parseLong(numberStr);
            if (longVal < -2147483648L || longVal > 2147483647L) {
                return Long.valueOf(longVal);
            }
            return Integer.valueOf((int) longVal);
        }
    }

    private JSONArray parseJSONArray() throws ParseException {
        expect('[');
        skipWhitespace();
        if (peek() == ']') {
            next();
            return new JSONArray(Collections.emptyList());
        }
        List<Object> elements = new ArrayList<>();
        boolean first = true;
        while (peek() != ']') {
            if (first) {
                first = false;
            } else {
                expect(',');
            }
            elements.add(parseJSON());
        }
        expect(']');
        return new JSONArray(elements);
    }

    private JSONObject parseJSONObject() throws ParseException {
        expect('{');
        skipWhitespace();
        if (peek() == '}') {
            next();
            return new JSONObject(Collections.emptyList());
        }
        List<Map.Entry<String, Object>> kvPairs = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(kvPairs);
        boolean first = true;
        while (peek() != '}') {
            if (first) {
                first = false;
            } else {
                expect(',');
            }
            CharSequence key = parseString();
            if (key == null) {
                throw new ParseException(this, "Object keys must be strings");
            } else if (peek() != ':') {
                return null;
            } else {
                expect(':');
                Object value = parseJSON();
                if (!key.equals("__ID")) {
                    kvPairs.add(new AbstractMap.SimpleEntry<>(key.toString(), value));
                } else if (value == null) {
                    throw new ParseException(this, "Got null value for \"__ID\" key");
                } else {
                    jsonObject.objectId = (CharSequence) value;
                }
            }
        }
        expect('}');
        return jsonObject;
    }

    private Object parseJSON() throws ParseException {
        skipWhitespace();
        try {
            char c = peek();
            if (c == '{') {
                JSONObject parseJSONObject = parseJSONObject();
                skipWhitespace();
                return parseJSONObject;
            } else if (c == '[') {
                JSONArray parseJSONArray = parseJSONArray();
                skipWhitespace();
                return parseJSONArray;
            } else if (c == '\"') {
                CharSequence charSequence = parseString();
                if (charSequence != null) {
                    return charSequence;
                }
                throw new ParseException(this, "Invalid string");
            } else if (peekMatches(C3P0Substitutions.DEBUG)) {
                advance(4);
                Boolean bool = Boolean.TRUE;
                skipWhitespace();
                return bool;
            } else if (peekMatches("false")) {
                advance(5);
                Boolean bool2 = Boolean.FALSE;
                skipWhitespace();
                return bool2;
            } else if (peekMatches("null")) {
                advance(4);
                skipWhitespace();
                return null;
            } else {
                Number parseNumber = parseNumber();
                skipWhitespace();
                return parseNumber;
            }
        } finally {
            skipWhitespace();
        }
    }

    /* access modifiers changed from: package-private */
    public static Object parseJSON(String str) throws ParseException {
        return new JSONParser(str).parseJSON();
    }
}
