package org.bson.codecs;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.bson.BsonReader;
import org.bson.BsonRegularExpression;
import org.bson.BsonWriter;

/* loaded from: grasscutter.jar:org/bson/codecs/PatternCodec.class */
public class PatternCodec implements Codec<Pattern> {
    private static final int GLOBAL_FLAG = 256;

    public void encode(BsonWriter writer, Pattern value, EncoderContext encoderContext) {
        writer.writeRegularExpression(new BsonRegularExpression(value.pattern(), getOptionsAsString(value)));
    }

    @Override // org.bson.codecs.Decoder
    public Pattern decode(BsonReader reader, DecoderContext decoderContext) {
        BsonRegularExpression regularExpression = reader.readRegularExpression();
        return Pattern.compile(regularExpression.getPattern(), getOptionsAsInt(regularExpression));
    }

    @Override // org.bson.codecs.Encoder
    public Class<Pattern> getEncoderClass() {
        return Pattern.class;
    }

    private static String getOptionsAsString(Pattern pattern) {
        int flags = pattern.flags();
        StringBuilder buf = new StringBuilder();
        RegexFlag[] values = RegexFlag.values();
        for (RegexFlag flag : values) {
            if ((pattern.flags() & flag.javaFlag) > 0) {
                buf.append(flag.flagChar);
                flags -= flag.javaFlag;
            }
        }
        if (flags <= 0) {
            return buf.toString();
        }
        throw new IllegalArgumentException("some flags could not be recognized.");
    }

    private static int getOptionsAsInt(BsonRegularExpression regularExpression) {
        int optionsInt = 0;
        String optionsString = regularExpression.getOptions();
        if (optionsString == null || optionsString.length() == 0) {
            return 0;
        }
        String optionsString2 = optionsString.toLowerCase();
        for (int i = 0; i < optionsString2.length(); i++) {
            RegexFlag flag = RegexFlag.getByCharacter(optionsString2.charAt(i));
            if (flag != null) {
                optionsInt |= flag.javaFlag;
                if (flag.unsupported != null) {
                }
            } else {
                throw new IllegalArgumentException("unrecognized flag [" + optionsString2.charAt(i) + "] " + ((int) optionsString2.charAt(i)));
            }
        }
        return optionsInt;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/bson/codecs/PatternCodec$RegexFlag.class */
    public enum RegexFlag {
        CANON_EQ(128, 'c', "Pattern.CANON_EQ"),
        UNIX_LINES(1, 'd', "Pattern.UNIX_LINES"),
        GLOBAL(256, 'g', null),
        CASE_INSENSITIVE(2, 'i', null),
        MULTILINE(8, 'm', null),
        DOTALL(32, 's', "Pattern.DOTALL"),
        LITERAL(16, 't', "Pattern.LITERAL"),
        UNICODE_CASE(64, 'u', "Pattern.UNICODE_CASE"),
        COMMENTS(4, 'x', null);
        
        private static final Map<Character, RegexFlag> BY_CHARACTER = new HashMap();
        private final int javaFlag;
        private final char flagChar;
        private final String unsupported;

        static {
            RegexFlag[] values = values();
            for (RegexFlag flag : values) {
                BY_CHARACTER.put(Character.valueOf(flag.flagChar), flag);
            }
        }

        public static RegexFlag getByCharacter(char ch) {
            return BY_CHARACTER.get(Character.valueOf(ch));
        }

        RegexFlag(int f, char ch, String u) {
            this.javaFlag = f;
            this.flagChar = ch;
            this.unsupported = u;
        }
    }
}
