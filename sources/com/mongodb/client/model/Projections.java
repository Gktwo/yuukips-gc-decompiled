package com.mongodb.client.model;

import com.mongodb.DBCollection;
import com.mongodb.QueryOperators;
import com.mongodb.assertions.Assertions;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonArray;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Projections.class */
public final class Projections {
    private Projections() {
    }

    public static <TExpression> Bson computed(String fieldName, TExpression expression) {
        return new SimpleExpression(fieldName, expression);
    }

    public static Bson include(String... fieldNames) {
        return include(Arrays.asList(fieldNames));
    }

    public static Bson include(List<String> fieldNames) {
        return combine(fieldNames, new BsonInt32(1));
    }

    public static Bson exclude(String... fieldNames) {
        return exclude(Arrays.asList(fieldNames));
    }

    public static Bson exclude(List<String> fieldNames) {
        return combine(fieldNames, new BsonInt32(0));
    }

    public static Bson excludeId() {
        return new BsonDocument(DBCollection.ID_FIELD_NAME, new BsonInt32(0));
    }

    public static Bson elemMatch(String fieldName) {
        return new BsonDocument(fieldName + ".$", new BsonInt32(1));
    }

    public static Bson elemMatch(String fieldName, Bson filter) {
        return new ElemMatchFilterProjection(fieldName, filter);
    }

    public static Bson meta(String fieldName, String metaFieldName) {
        return new BsonDocument(fieldName, new BsonDocument("$meta", new BsonString(metaFieldName)));
    }

    public static Bson metaTextScore(String fieldName) {
        return meta(fieldName, "textScore");
    }

    public static Bson slice(String fieldName, int limit) {
        return new BsonDocument(fieldName, new BsonDocument("$slice", new BsonInt32(limit)));
    }

    public static Bson slice(String fieldName, int skip, int limit) {
        return new BsonDocument(fieldName, new BsonDocument("$slice", new BsonArray(Arrays.asList(new BsonInt32(skip), new BsonInt32(limit)))));
    }

    public static Bson fields(Bson... projections) {
        return fields(Arrays.asList(projections));
    }

    public static Bson fields(List<? extends Bson> projections) {
        Assertions.notNull("projections", projections);
        return new FieldsProjection(projections);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Projections$FieldsProjection.class */
    public static class FieldsProjection implements Bson {
        private final List<? extends Bson> projections;

        FieldsProjection(List<? extends Bson> projections) {
            this.projections = projections;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument combinedDocument = new BsonDocument();
            for (Bson sort : this.projections) {
                BsonDocument sortDocument = sort.toBsonDocument(documentClass, codecRegistry);
                for (String key : sortDocument.keySet()) {
                    combinedDocument.remove((Object) key);
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
            FieldsProjection that = (FieldsProjection) o;
            return this.projections != null ? this.projections.equals(that.projections) : that.projections == null;
        }

        public int hashCode() {
            if (this.projections != null) {
                return this.projections.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Projections{projections=" + this.projections + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Projections$ElemMatchFilterProjection.class */
    private static class ElemMatchFilterProjection implements Bson {
        private final String fieldName;
        private final Bson filter;

        ElemMatchFilterProjection(String fieldName, Bson filter) {
            this.fieldName = fieldName;
            this.filter = filter;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            return new BsonDocument(this.fieldName, new BsonDocument(QueryOperators.ELEM_MATCH, this.filter.toBsonDocument(documentClass, codecRegistry)));
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ElemMatchFilterProjection that = (ElemMatchFilterProjection) o;
            if (this.fieldName != null) {
                if (!this.fieldName.equals(that.fieldName)) {
                    return false;
                }
            } else if (that.fieldName != null) {
                return false;
            }
            return this.filter != null ? this.filter.equals(that.filter) : that.filter == null;
        }

        public int hashCode() {
            return (31 * (this.fieldName != null ? this.fieldName.hashCode() : 0)) + (this.filter != null ? this.filter.hashCode() : 0);
        }

        public String toString() {
            return "ElemMatch Projection{fieldName='" + this.fieldName + "', filter=" + this.filter + '}';
        }
    }

    private static Bson combine(List<String> fieldNames, BsonValue value) {
        BsonDocument document = new BsonDocument();
        for (String fieldName : fieldNames) {
            document.remove((Object) fieldName);
            document.append(fieldName, value);
        }
        return document;
    }
}
