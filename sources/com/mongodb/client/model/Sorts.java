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

/* loaded from: grasscutter.jar:com/mongodb/client/model/Sorts.class */
public final class Sorts {
    private Sorts() {
    }

    public static Bson ascending(String... fieldNames) {
        return ascending(Arrays.asList(fieldNames));
    }

    public static Bson ascending(List<String> fieldNames) {
        Assertions.notNull("fieldNames", fieldNames);
        return orderBy(fieldNames, new BsonInt32(1));
    }

    public static Bson descending(String... fieldNames) {
        return descending(Arrays.asList(fieldNames));
    }

    public static Bson descending(List<String> fieldNames) {
        Assertions.notNull("fieldNames", fieldNames);
        return orderBy(fieldNames, new BsonInt32(-1));
    }

    public static Bson metaTextScore(String fieldName) {
        return new BsonDocument(fieldName, new BsonDocument("$meta", new BsonString("textScore")));
    }

    public static Bson orderBy(Bson... sorts) {
        return orderBy(Arrays.asList(sorts));
    }

    public static Bson orderBy(List<? extends Bson> sorts) {
        Assertions.notNull("sorts", sorts);
        return new CompoundSort(sorts);
    }

    private static Bson orderBy(List<String> fieldNames, BsonValue value) {
        BsonDocument document = new BsonDocument();
        for (String fieldName : fieldNames) {
            document.append(fieldName, value);
        }
        return document;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Sorts$CompoundSort.class */
    public static final class CompoundSort implements Bson {
        private final List<? extends Bson> sorts;

        private CompoundSort(List<? extends Bson> sorts) {
            this.sorts = sorts;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument combinedDocument = new BsonDocument();
            for (Bson sort : this.sorts) {
                BsonDocument sortDocument = sort.toBsonDocument(documentClass, codecRegistry);
                for (String key : sortDocument.keySet()) {
                    combinedDocument.append(key, sortDocument.get((Object) key));
                }
            }
            return combinedDocument;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CompoundSort that = (CompoundSort) o;
            return this.sorts != null ? this.sorts.equals(that.sorts) : that.sorts == null;
        }

        public int hashCode() {
            if (this.sorts != null) {
                return this.sorts.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Compound Sort{sorts=" + this.sorts + '}';
        }
    }
}
