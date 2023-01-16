package org.bson.codecs;

import java.io.StringWriter;
import org.bson.BsonReader;
import org.bson.BsonWriter;
import org.bson.json.JsonObject;
import org.bson.json.JsonReader;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

/* loaded from: grasscutter.jar:org/bson/codecs/JsonObjectCodec.class */
public class JsonObjectCodec implements Codec<JsonObject> {
    private final JsonWriterSettings writerSettings;

    public JsonObjectCodec() {
        this(JsonWriterSettings.builder().build());
    }

    public JsonObjectCodec(JsonWriterSettings writerSettings) {
        this.writerSettings = writerSettings;
    }

    public void encode(BsonWriter writer, JsonObject value, EncoderContext encoderContext) {
        writer.pipe(new JsonReader(value.getJson()));
    }

    @Override // org.bson.codecs.Decoder
    public JsonObject decode(BsonReader reader, DecoderContext decoderContext) {
        StringWriter stringWriter = new StringWriter();
        new JsonWriter(stringWriter, this.writerSettings).pipe(reader);
        return new JsonObject(stringWriter.toString());
    }

    @Override // org.bson.codecs.Encoder
    public Class<JsonObject> getEncoderClass() {
        return JsonObject.class;
    }
}
