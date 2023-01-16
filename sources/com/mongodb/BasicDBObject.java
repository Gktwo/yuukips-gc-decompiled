package com.mongodb;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.bson.BSONObject;
import org.bson.BasicBSONObject;
import org.bson.BsonBinaryWriter;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWrapper;
import org.bson.UuidRepresentation;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.internal.CodecRegistryHelper;
import org.bson.json.JsonMode;
import org.bson.json.JsonReader;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
import org.bson.p022io.BasicOutputBuffer;
import org.bson.p022io.OutputBuffer;
import org.bson.types.BasicBSONList;

/* loaded from: grasscutter.jar:com/mongodb/BasicDBObject.class */
public class BasicDBObject extends BasicBSONObject implements DBObject, Bson {
    private static final long serialVersionUID = -4415279469780082174L;
    private boolean isPartialObject;

    public static BasicDBObject parse(String json) {
        return parse(json, DBObjectCodec.getDefaultRegistry().get(BasicDBObject.class));
    }

    public static BasicDBObject parse(String json, Decoder<BasicDBObject> decoder) {
        return decoder.decode(new JsonReader(json), DecoderContext.builder().build());
    }

    public BasicDBObject() {
    }

    public BasicDBObject(int size) {
        super(size);
    }

    public BasicDBObject(String key, Object value) {
        super(key, value);
    }

    public BasicDBObject(Map map) {
        super(map);
    }

    @Override // org.bson.BasicBSONObject
    public BasicDBObject append(String key, Object val) {
        put((Object) key, val);
        return this;
    }

    @Override // com.mongodb.DBObject
    public boolean isPartialObject() {
        return this.isPartialObject;
    }

    public String toJson() {
        return toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build());
    }

    public String toJson(JsonWriterSettings writerSettings) {
        return toJson(writerSettings, DBObjectCodec.getDefaultRegistry().get(BasicDBObject.class));
    }

    public String toJson(Encoder<BasicDBObject> encoder) {
        return toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build(), encoder);
    }

    public String toJson(JsonWriterSettings writerSettings, Encoder<BasicDBObject> encoder) {
        JsonWriter writer = new JsonWriter(new StringWriter(), writerSettings);
        encoder.encode(writer, this, EncoderContext.builder().build());
        return writer.getWriter().toString();
    }

    @Override // org.bson.BasicBSONObject, java.util.AbstractMap, java.util.Map, java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BSONObject)) {
            return false;
        }
        BSONObject other = (BSONObject) o;
        if (!keySet().equals(other.keySet())) {
            return false;
        }
        return Arrays.equals(toBson(canonicalizeBSONObject((BSONObject) this)), toBson(canonicalizeBSONObject(other)));
    }

    @Override // org.bson.BasicBSONObject, java.util.AbstractMap, java.util.Map, java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(toBson(canonicalizeBSONObject((BSONObject) this)));
    }

    private static byte[] toBson(DBObject dbObject) {
        OutputBuffer outputBuffer = new BasicOutputBuffer();
        CodecRegistryHelper.createRegistry(DBObjectCodec.getDefaultRegistry(), UuidRepresentation.STANDARD).get(DBObject.class).encode(new BsonBinaryWriter(outputBuffer), dbObject, EncoderContext.builder().build());
        return outputBuffer.toByteArray();
    }

    @Override // java.util.AbstractMap, java.lang.Object
    public String toString() {
        return toJson();
    }

    @Override // com.mongodb.DBObject
    public void markAsPartialObject() {
        this.isPartialObject = true;
    }

    public Object copy() {
        BasicDBObject newCopy = new BasicDBObject(toMap());
        for (String field : keySet()) {
            Object val = get(field);
            if (val instanceof BasicDBObject) {
                newCopy.put((Object) field, ((BasicDBObject) val).copy());
            } else if (val instanceof BasicDBList) {
                newCopy.put((Object) field, ((BasicDBList) val).copy());
            }
        }
        return newCopy;
    }

    @Override // org.bson.conversions.Bson
    public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
        return new BsonDocumentWrapper(this, codecRegistry.get(BasicDBObject.class));
    }

    private static Object canonicalize(Object from) {
        if ((from instanceof BSONObject) && !(from instanceof BasicBSONList)) {
            return canonicalizeBSONObject((BSONObject) from);
        }
        if (from instanceof List) {
            return canonicalizeList((List) from);
        }
        if (from instanceof Map) {
            return canonicalizeMap((Map) from);
        }
        return from;
    }

    private static Map<String, Object> canonicalizeMap(Map<String, Object> from) {
        Map<String, Object> canonicalized = new LinkedHashMap<>(from.size());
        Iterator<String> it = new TreeSet<>(from.keySet()).iterator();
        while (it.hasNext()) {
            String key = it.next();
            canonicalized.put(key, canonicalize(from.get(key)));
        }
        return canonicalized;
    }

    private static DBObject canonicalizeBSONObject(BSONObject from) {
        BasicDBObject canonicalized = new BasicDBObject();
        Iterator<String> it = new TreeSet<>(from.keySet()).iterator();
        while (it.hasNext()) {
            String key = it.next();
            canonicalized.put((Object) key, canonicalize(from.get(key)));
        }
        return canonicalized;
    }

    private static List canonicalizeList(List<Object> list) {
        List<Object> canonicalized = new ArrayList<>(list.size());
        for (Object cur : list) {
            canonicalized.add(canonicalize(cur));
        }
        return canonicalized;
    }
}
