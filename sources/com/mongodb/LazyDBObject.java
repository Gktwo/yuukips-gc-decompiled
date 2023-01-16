package com.mongodb;

import com.mongodb.annotations.Immutable;
import java.io.StringWriter;
import org.bson.LazyBSONCallback;
import org.bson.LazyBSONObject;
import org.bson.codecs.EncoderContext;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/LazyDBObject.class */
public class LazyDBObject extends LazyBSONObject implements DBObject {
    private boolean isPartial = false;

    public LazyDBObject(byte[] bytes, LazyBSONCallback callback) {
        super(bytes, callback);
    }

    public LazyDBObject(byte[] bytes, int offset, LazyBSONCallback callback) {
        super(bytes, offset, callback);
    }

    @Override // com.mongodb.DBObject
    public void markAsPartialObject() {
        this.isPartial = true;
    }

    @Override // com.mongodb.DBObject
    public boolean isPartialObject() {
        return this.isPartial;
    }

    public String toString() {
        JsonWriter writer = new JsonWriter(new StringWriter(), JsonWriterSettings.builder().build());
        DBObjectCodec.getDefaultRegistry().get(LazyDBObject.class).encode(writer, this, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        return writer.getWriter().toString();
    }
}
