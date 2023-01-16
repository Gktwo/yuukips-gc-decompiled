package com.mongodb.internal.connection;

import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.bson.BsonDocument;
import org.bson.BsonReader;
import org.bson.BsonValue;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.DecoderContext;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AbstractByteBufBsonDocument.class */
public abstract class AbstractByteBufBsonDocument extends BsonDocument {
    private static final long serialVersionUID = 1;
    private static final CodecRegistry REGISTRY = CodecRegistries.fromProviders(new BsonValueCodecProvider());

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AbstractByteBufBsonDocument$Finder.class */
    public interface Finder<T> {
        T find(BsonReader bsonReader);

        T notFound();
    }

    abstract <T> T findInDocument(Finder<T> finder);

    abstract BsonDocument toBaseBsonDocument();

    @Override // org.bson.BsonDocument, java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("ByteBufBsonDocument instances are immutable");
    }

    @Override // org.bson.BsonDocument
    public BsonValue put(String key, BsonValue value) {
        throw new UnsupportedOperationException("ByteBufBsonDocument instances are immutable");
    }

    @Override // org.bson.BsonDocument
    public BsonDocument append(String key, BsonValue value) {
        throw new UnsupportedOperationException("ByteBufBsonDocument instances are immutable");
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public void putAll(Map<? extends String, ? extends BsonValue> m) {
        throw new UnsupportedOperationException("ByteBufBsonDocument instances are immutable");
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public BsonValue remove(Object key) {
        throw new UnsupportedOperationException("ByteBufBsonDocument instances are immutable");
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public boolean isEmpty() {
        return ((Boolean) findInDocument(new Finder<Boolean>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.1
            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean find(BsonReader bsonReader) {
                return false;
            }

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean notFound() {
                return true;
            }
        })).booleanValue();
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public int size() {
        return ((Integer) findInDocument(new Finder<Integer>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.2
            private int size;

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Integer find(BsonReader bsonReader) {
                this.size++;
                bsonReader.readName();
                bsonReader.skipValue();
                return null;
            }

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Integer notFound() {
                return Integer.valueOf(this.size);
            }
        })).intValue();
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public Set<Map.Entry<String, BsonValue>> entrySet() {
        return toBaseBsonDocument().entrySet();
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public Collection<BsonValue> values() {
        return toBaseBsonDocument().values();
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public Set<String> keySet() {
        return toBaseBsonDocument().keySet();
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public boolean containsKey(final Object key) {
        if (key == null) {
            throw new IllegalArgumentException("key can not be null");
        }
        Boolean containsKey = (Boolean) findInDocument(new Finder<Boolean>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.3
            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean find(BsonReader bsonReader) {
                if (bsonReader.readName().equals(key)) {
                    return true;
                }
                bsonReader.skipValue();
                return null;
            }

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean notFound() {
                return false;
            }
        });
        if (containsKey != null) {
            return containsKey.booleanValue();
        }
        return false;
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public boolean containsValue(final Object value) {
        Boolean containsValue = (Boolean) findInDocument(new Finder<Boolean>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.4
            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean find(BsonReader bsonReader) {
                bsonReader.skipName();
                if (AbstractByteBufBsonDocument.this.deserializeBsonValue(bsonReader).equals(value)) {
                    return true;
                }
                return null;
            }

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public Boolean notFound() {
                return false;
            }
        });
        if (containsValue != null) {
            return containsValue.booleanValue();
        }
        return false;
    }

    @Override // org.bson.BsonDocument, java.util.Map
    public BsonValue get(final Object key) {
        if (key != null) {
            return (BsonValue) findInDocument(new Finder<BsonValue>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.5
                @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
                public BsonValue find(BsonReader bsonReader) {
                    if (bsonReader.readName().equals(key)) {
                        return AbstractByteBufBsonDocument.this.deserializeBsonValue(bsonReader);
                    }
                    bsonReader.skipValue();
                    return null;
                }

                @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
                public BsonValue notFound() {
                    return null;
                }
            });
        }
        throw new IllegalArgumentException("key can not be null");
    }

    @Override // org.bson.BsonDocument
    public String getFirstKey() {
        return (String) findInDocument(new Finder<String>() { // from class: com.mongodb.internal.connection.AbstractByteBufBsonDocument.6
            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public String find(BsonReader bsonReader) {
                return bsonReader.readName();
            }

            @Override // com.mongodb.internal.connection.AbstractByteBufBsonDocument.Finder
            public String notFound() {
                throw new NoSuchElementException();
            }
        });
    }

    @Override // org.bson.BsonDocument, java.util.Map, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return toBaseBsonDocument().equals(o);
    }

    @Override // org.bson.BsonDocument, java.util.Map, java.lang.Object
    public int hashCode() {
        return toBaseBsonDocument().hashCode();
    }

    /* access modifiers changed from: private */
    public BsonValue deserializeBsonValue(BsonReader bsonReader) {
        return (BsonValue) REGISTRY.get(BsonValueCodecProvider.getClassForBsonType(bsonReader.getCurrentBsonType())).decode(bsonReader, DecoderContext.builder().build());
    }

    Object writeReplace() {
        return toBaseBsonDocument();
    }
}
