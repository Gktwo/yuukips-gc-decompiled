package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* loaded from: grasscutter.jar:com/google/gson/ToNumberPolicy.class */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE {
        @Override // com.google.gson.ToNumberStrategy
        public Double readNumber(JsonReader in) throws IOException {
            return Double.valueOf(in.nextDouble());
        }
    },
    LAZILY_PARSED_NUMBER {
        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader in) throws IOException {
            return new LazilyParsedNumber(in.nextString());
        }
    },
    LONG_OR_DOUBLE {
        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader in) throws IOException, JsonParseException {
            String value = in.nextString();
            try {
                return Long.valueOf(Long.parseLong(value));
            } catch (NumberFormatException e) {
                try {
                    Double d = Double.valueOf(value);
                    if ((!d.isInfinite() && !d.isNaN()) || in.isLenient()) {
                        return d;
                    }
                    throw new MalformedJsonException("JSON forbids NaN and infinities: " + d + "; at path " + in.getPreviousPath());
                } catch (NumberFormatException doubleE) {
                    throw new JsonParseException("Cannot parse " + value + "; at path " + in.getPreviousPath(), doubleE);
                }
            }
        }
    },
    BIG_DECIMAL {
        @Override // com.google.gson.ToNumberStrategy
        public BigDecimal readNumber(JsonReader in) throws IOException {
            String value = in.nextString();
            try {
                return new BigDecimal(value);
            } catch (NumberFormatException e) {
                throw new JsonParseException("Cannot parse " + value + "; at path " + in.getPreviousPath(), e);
            }
        }
    }
}
