package dev.morphia.mapping.codec;

import org.bson.BsonBinary;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.codecs.Codec;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/ByteWrapperArrayCodec.class */
public class ByteWrapperArrayCodec implements Codec<Byte[]> {
    @Override // org.bson.codecs.Decoder
    public Byte[] decode(BsonReader reader, DecoderContext decoderContext) {
        return wrapper(reader.readBinaryData().getData());
    }

    public void encode(BsonWriter writer, Byte[] value, EncoderContext encoderContext) {
        writer.writeBinaryData(new BsonBinary(primitive(value)));
    }

    @Override // org.bson.codecs.Encoder
    public Class<Byte[]> getEncoderClass() {
        return Byte[].class;
    }

    private byte[] primitive(Byte[] value) {
        byte[] array = new byte[value.length];
        for (int i = 0; i < value.length; i++) {
            if (value[i] != null) {
                array[i] = value[i].byteValue();
            }
        }
        return array;
    }

    private Byte[] wrapper(byte[] value) {
        Byte[] array = new Byte[value.length];
        for (int i = 0; i < value.length; i++) {
            array[i] = Byte.valueOf(value[i]);
        }
        return array;
    }
}
