package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Indexes.class */
public final class Indexes {
    private Indexes() {
    }

    public static Bson ascending(String... fieldNames) {
        return ascending(Arrays.asList(fieldNames));
    }

    public static Bson ascending(List<String> fieldNames) {
        Assertions.notNull("fieldNames", fieldNames);
        return compoundIndex(fieldNames, new BsonInt32(1));
    }

    public static Bson descending(String... fieldNames) {
        return descending(Arrays.asList(fieldNames));
    }

    public static Bson descending(List<String> fieldNames) {
        Assertions.notNull("fieldNames", fieldNames);
        return compoundIndex(fieldNames, new BsonInt32(-1));
    }

    public static Bson geo2dsphere(String... fieldNames) {
        return geo2dsphere(Arrays.asList(fieldNames));
    }

    public static Bson geo2dsphere(List<String> fieldNames) {
        Assertions.notNull("fieldNames", fieldNames);
        return compoundIndex(fieldNames, new BsonString("2dsphere"));
    }

    public static Bson geo2d(String fieldName) {
        Assertions.notNull("fieldName", fieldName);
        return new BsonDocument(fieldName, new BsonString("2d"));
    }

    public static Bson geoHaystack(String fieldName, Bson additional) {
        Assertions.notNull("fieldName", fieldName);
        return compoundIndex(new BsonDocument(fieldName, new BsonString("geoHaystack")), additional);
    }

    public static Bson text(String fieldName) {
        Assertions.notNull("fieldName", fieldName);
        return new BsonDocument(fieldName, new BsonString("text"));
    }

    public static Bson text() {
        return text("$**");
    }

    public static Bson hashed(String fieldName) {
        Assertions.notNull("fieldName", fieldName);
        return new BsonDocument(fieldName, new BsonString("hashed"));
    }

    public static Bson compoundIndex(Bson... indexes) {
        return compoundIndex(Arrays.asList(indexes));
    }

    public static Bson compoundIndex(List<? extends Bson> indexes) {
        return new CompoundIndex(indexes);
    }

    private static Bson compoundIndex(List<String> fieldNames, BsonValue value) {
        BsonDocument document = new BsonDocument();
        for (String fieldName : fieldNames) {
            document.append(fieldName, value);
        }
        return document;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Indexes$CompoundIndex.class */
    public static class CompoundIndex implements Bson {
        private final List<? extends Bson> indexes;

        CompoundIndex(List<? extends Bson> indexes) {
            Assertions.notNull("indexes", indexes);
            this.indexes = indexes;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument compoundIndex = new BsonDocument();
            for (Bson index : this.indexes) {
                BsonDocument indexDocument = index.toBsonDocument(documentClass, codecRegistry);
                for (String key : indexDocument.keySet()) {
                    compoundIndex.append(key, indexDocument.get((Object) key));
                }
            }
            return compoundIndex;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.indexes.equals(((CompoundIndex) o).indexes);
        }

        public int hashCode() {
            return this.indexes.hashCode();
        }
    }
}
