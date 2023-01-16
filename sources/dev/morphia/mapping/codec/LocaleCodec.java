package dev.morphia.mapping.codec;

import java.util.Locale;
import net.bytebuddy.utility.JavaConstant;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/LocaleCodec.class */
public class LocaleCodec implements Codec<Locale> {
    @Override // org.bson.codecs.Decoder
    public Locale decode(BsonReader reader, DecoderContext decoderContext) {
        return parseLocale(reader.readString());
    }

    public void encode(BsonWriter writer, Locale value, EncoderContext encoderContext) {
        if (value == null) {
            writer.writeNull();
        } else {
            writer.writeString(value.toString());
        }
    }

    @Override // org.bson.codecs.Encoder
    public Class<Locale> getEncoderClass() {
        return Locale.class;
    }

    Locale parseLocale(String localeString) {
        Locale resultLocale;
        int index = localeString.indexOf(JavaConstant.Dynamic.DEFAULT_NAME);
        int index2 = localeString.indexOf(JavaConstant.Dynamic.DEFAULT_NAME, index + 1);
        if (index == -1) {
            resultLocale = new Locale(localeString);
        } else if (index2 == -1) {
            resultLocale = new Locale(localeString.substring(0, index), localeString.substring(index + 1));
        } else {
            resultLocale = new Locale(localeString.substring(0, index), localeString.substring(index + 1, index2), localeString.substring(index2 + 1));
        }
        return resultLocale;
    }
}
