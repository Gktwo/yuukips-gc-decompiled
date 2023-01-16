package org.bson.codecs;

import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.types.Symbol;

/* loaded from: grasscutter.jar:org/bson/codecs/SymbolCodec.class */
public class SymbolCodec implements Codec<Symbol> {
    @Override // org.bson.codecs.Decoder
    public Symbol decode(BsonReader reader, DecoderContext decoderContext) {
        return new Symbol(reader.readSymbol());
    }

    public void encode(BsonWriter writer, Symbol value, EncoderContext encoderContext) {
        writer.writeSymbol(value.getSymbol());
    }

    @Override // org.bson.codecs.Encoder
    public Class<Symbol> getEncoderClass() {
        return Symbol.class;
    }
}
