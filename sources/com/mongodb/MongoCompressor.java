package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/mongodb/MongoCompressor.class */
public final class MongoCompressor {
    public static final String LEVEL = "LEVEL";
    private final String name;
    private final Map<String, Object> properties;

    public static MongoCompressor createSnappyCompressor() {
        return new MongoCompressor("snappy");
    }

    public static MongoCompressor createZlibCompressor() {
        return new MongoCompressor("zlib");
    }

    public static MongoCompressor createZstdCompressor() {
        return new MongoCompressor("zstd");
    }

    public String getName() {
        return this.name;
    }

    @Nullable
    public <T> T getProperty(String key, T defaultValue) {
        Assertions.notNull(Action.KEY_ATTRIBUTE, key);
        T value = (T) this.properties.get(key.toLowerCase());
        return (value != null || this.properties.containsKey(key)) ? value : defaultValue;
    }

    public <T> T getPropertyNonNull(String key, T defaultValue) {
        T value = (T) getProperty(key, defaultValue);
        if (value != null) {
            return value;
        }
        throw new IllegalArgumentException();
    }

    public <T> MongoCompressor withProperty(String key, T value) {
        return new MongoCompressor(this, key, value);
    }

    private MongoCompressor(String name) {
        this.name = name;
        this.properties = Collections.emptyMap();
    }

    private <T> MongoCompressor(MongoCompressor from, String propertyKey, T propertyValue) {
        Assertions.notNull("propertyKey", propertyKey);
        this.name = from.name;
        this.properties = new HashMap(from.properties);
        this.properties.put(propertyKey.toLowerCase(), propertyValue);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MongoCompressor that = (MongoCompressor) o;
        if (!this.name.equals(that.name)) {
            return false;
        }
        return this.properties.equals(that.properties);
    }

    public int hashCode() {
        return (31 * this.name.hashCode()) + this.properties.hashCode();
    }

    public String toString() {
        return "MongoCompressor{name='" + this.name + "', properties=" + this.properties + '}';
    }
}
