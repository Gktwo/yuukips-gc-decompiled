package org.bson;

import java.io.Serializable;
import java.io.StringWriter;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.assertions.Assertions;
import org.bson.codecs.Decoder;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.Encoder;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.json.JsonMode;
import org.bson.json.JsonReader;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;
import org.bson.types.ObjectId;

/* loaded from: grasscutter.jar:org/bson/Document.class */
public class Document implements Map<String, Object>, Serializable, Bson {
    private static final long serialVersionUID = 6297731997167536582L;
    private final LinkedHashMap<String, Object> documentAsMap;

    public Document() {
        this.documentAsMap = new LinkedHashMap<>();
    }

    public Document(String key, Object value) {
        this.documentAsMap = new LinkedHashMap<>();
        this.documentAsMap.put(key, value);
    }

    public Document(Map<String, Object> map) {
        this.documentAsMap = new LinkedHashMap<>(map);
    }

    public static Document parse(String json) {
        return parse(json, new DocumentCodec());
    }

    public static Document parse(String json, Decoder<Document> decoder) {
        Assertions.notNull("codec", decoder);
        return decoder.decode(new JsonReader(json), DecoderContext.builder().build());
    }

    @Override // org.bson.conversions.Bson
    public <C> BsonDocument toBsonDocument(Class<C> documentClass, CodecRegistry codecRegistry) {
        return new BsonDocumentWrapper(this, codecRegistry.get(Document.class));
    }

    public Document append(String key, Object value) {
        this.documentAsMap.put(key, value);
        return this;
    }

    public <T> T get(Object key, Class<T> clazz) {
        Assertions.notNull("clazz", clazz);
        return clazz.cast(this.documentAsMap.get(key));
    }

    public <T> T get(Object key, T defaultValue) {
        Assertions.notNull("defaultValue", defaultValue);
        T t = (T) this.documentAsMap.get(key);
        return t == null ? defaultValue : t;
    }

    public <T> T getEmbedded(List<?> keys, Class<T> clazz) {
        Assertions.notNull("keys", keys);
        Assertions.isTrue("keys", !keys.isEmpty());
        Assertions.notNull("clazz", clazz);
        return (T) getEmbeddedValue(keys, clazz, null);
    }

    public <T> T getEmbedded(List<?> keys, T defaultValue) {
        Assertions.notNull("keys", keys);
        Assertions.isTrue("keys", !keys.isEmpty());
        Assertions.notNull("defaultValue", defaultValue);
        return (T) getEmbeddedValue(keys, null, defaultValue);
    }

    private <T> T getEmbeddedValue(List<?> keys, Class<T> clazz, T defaultValue) {
        Object value = (T) this;
        Iterator<?> keyIterator = keys.iterator();
        while (keyIterator.hasNext()) {
            Object key = keyIterator.next();
            value = (T) ((Document) value).get(key);
            if (!(value instanceof Document)) {
                if (value == null) {
                    return defaultValue;
                }
                if (keyIterator.hasNext()) {
                    throw new ClassCastException(String.format("At key %s, the value is not a Document (%s)", key, value.getClass().getName()));
                }
            }
        }
        return clazz != null ? clazz.cast(value) : (T) value;
    }

    public Integer getInteger(Object key) {
        return (Integer) get(key);
    }

    public int getInteger(Object key, int defaultValue) {
        return ((Integer) get(key, Integer.valueOf(defaultValue))).intValue();
    }

    public Long getLong(Object key) {
        return (Long) get(key);
    }

    public Double getDouble(Object key) {
        return (Double) get(key);
    }

    public String getString(Object key) {
        return (String) get(key);
    }

    public Boolean getBoolean(Object key) {
        return (Boolean) get(key);
    }

    public boolean getBoolean(Object key, boolean defaultValue) {
        return ((Boolean) get(key, Boolean.valueOf(defaultValue))).booleanValue();
    }

    public ObjectId getObjectId(Object key) {
        return (ObjectId) get(key);
    }

    public Date getDate(Object key) {
        return (Date) get(key);
    }

    public <T> List<T> getList(Object key, Class<T> clazz) {
        Assertions.notNull("clazz", clazz);
        return constructValuesList(key, clazz, null);
    }

    public <T> List<T> getList(Object key, Class<T> clazz, List<T> defaultValue) {
        Assertions.notNull("defaultValue", defaultValue);
        Assertions.notNull("clazz", clazz);
        return constructValuesList(key, clazz, defaultValue);
    }

    private <T> List<T> constructValuesList(Object key, Class<T> clazz, List<T> defaultValue) {
        List<T> list = (List) get(key, (Class<Object>) List.class);
        if (list == null) {
            return defaultValue;
        }
        for (T item : list) {
            if (!clazz.isAssignableFrom(item.getClass())) {
                throw new ClassCastException(String.format("List element cannot be cast to %s", clazz.getName()));
            }
        }
        return list;
    }

    public String toJson() {
        return toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build());
    }

    public String toJson(JsonWriterSettings writerSettings) {
        return toJson(writerSettings, new DocumentCodec());
    }

    public String toJson(Encoder<Document> encoder) {
        return toJson(JsonWriterSettings.builder().outputMode(JsonMode.RELAXED).build(), encoder);
    }

    public String toJson(JsonWriterSettings writerSettings, Encoder<Document> encoder) {
        JsonWriter writer = new JsonWriter(new StringWriter(), writerSettings);
        encoder.encode(writer, this, EncoderContext.builder().build());
        return writer.getWriter().toString();
    }

    @Override // java.util.Map
    public int size() {
        return this.documentAsMap.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.documentAsMap.isEmpty();
    }

    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return this.documentAsMap.containsValue(value);
    }

    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return this.documentAsMap.containsKey(key);
    }

    @Override // java.util.Map
    public Object get(Object key) {
        return this.documentAsMap.get(key);
    }

    public Object put(String key, Object value) {
        return this.documentAsMap.put(key, value);
    }

    @Override // java.util.Map
    public Object remove(Object key) {
        return this.documentAsMap.remove(key);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.util.Map<? extends java.lang.String, ?>] */
    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Object> map) {
        this.documentAsMap.putAll(map);
    }

    @Override // java.util.Map
    public void clear() {
        this.documentAsMap.clear();
    }

    @Override // java.util.Map
    public Set<String> keySet() {
        return this.documentAsMap.keySet();
    }

    @Override // java.util.Map
    public Collection<Object> values() {
        return this.documentAsMap.values();
    }

    @Override // java.util.Map
    public Set<Map.Entry<String, Object>> entrySet() {
        return this.documentAsMap.entrySet();
    }

    @Override // java.util.Map, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.documentAsMap.equals(((Document) o).documentAsMap)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map, java.lang.Object
    public int hashCode() {
        return this.documentAsMap.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "Document{" + this.documentAsMap + '}';
    }
}
