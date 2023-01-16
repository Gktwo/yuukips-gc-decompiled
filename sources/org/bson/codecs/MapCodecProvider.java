package org.bson.codecs;

import java.util.Map;
import org.bson.Transformer;
import org.bson.assertions.Assertions;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;

/* loaded from: grasscutter.jar:org/bson/codecs/MapCodecProvider.class */
public class MapCodecProvider implements CodecProvider {
    private final BsonTypeClassMap bsonTypeClassMap;
    private final Transformer valueTransformer;

    public MapCodecProvider() {
        this(BsonTypeClassMap.DEFAULT_BSON_TYPE_CLASS_MAP);
    }

    public MapCodecProvider(BsonTypeClassMap bsonTypeClassMap) {
        this(bsonTypeClassMap, null);
    }

    public MapCodecProvider(Transformer valueTransformer) {
        this(BsonTypeClassMap.DEFAULT_BSON_TYPE_CLASS_MAP, valueTransformer);
    }

    public MapCodecProvider(BsonTypeClassMap bsonTypeClassMap, Transformer valueTransformer) {
        this.bsonTypeClassMap = (BsonTypeClassMap) Assertions.notNull("bsonTypeClassMap", bsonTypeClassMap);
        this.valueTransformer = valueTransformer;
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
        if (Map.class.isAssignableFrom(clazz)) {
            return new MapCodec(registry, this.bsonTypeClassMap, this.valueTransformer);
        }
        return null;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MapCodecProvider that = (MapCodecProvider) o;
        if (!this.bsonTypeClassMap.equals(that.bsonTypeClassMap)) {
            return false;
        }
        if (this.valueTransformer != null) {
            if (!this.valueTransformer.equals(that.valueTransformer)) {
                return false;
            }
            return true;
        } else if (that.valueTransformer != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * this.bsonTypeClassMap.hashCode()) + (this.valueTransformer != null ? this.valueTransformer.hashCode() : 0);
    }
}
