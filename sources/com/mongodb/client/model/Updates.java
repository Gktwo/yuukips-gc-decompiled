package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonString;
import org.bson.BsonValue;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Updates.class */
public final class Updates {
    public static Bson combine(Bson... updates) {
        return combine(Arrays.asList(updates));
    }

    public static Bson combine(List<? extends Bson> updates) {
        Assertions.notNull("updates", updates);
        return new CompositeUpdate(updates);
    }

    public static <TItem> Bson set(String fieldName, @Nullable TItem value) {
        return new SimpleUpdate(fieldName, value, "$set");
    }

    public static Bson unset(String fieldName) {
        return new SimpleUpdate(fieldName, "", "$unset");
    }

    public static Bson setOnInsert(Bson value) {
        return new SimpleBsonKeyValue("$setOnInsert", value);
    }

    public static <TItem> Bson setOnInsert(String fieldName, @Nullable TItem value) {
        return new SimpleUpdate(fieldName, value, "$setOnInsert");
    }

    public static Bson rename(String fieldName, String newFieldName) {
        Assertions.notNull("newFieldName", newFieldName);
        return new SimpleUpdate(fieldName, newFieldName, "$rename");
    }

    public static Bson inc(String fieldName, Number number) {
        Assertions.notNull("number", number);
        return new SimpleUpdate(fieldName, number, "$inc");
    }

    public static Bson mul(String fieldName, Number number) {
        Assertions.notNull("number", number);
        return new SimpleUpdate(fieldName, number, "$mul");
    }

    public static <TItem> Bson min(String fieldName, TItem value) {
        return new SimpleUpdate(fieldName, value, "$min");
    }

    public static <TItem> Bson max(String fieldName, TItem value) {
        return new SimpleUpdate(fieldName, value, "$max");
    }

    public static Bson currentDate(String fieldName) {
        return new SimpleUpdate(fieldName, true, "$currentDate");
    }

    public static Bson currentTimestamp(String fieldName) {
        return new SimpleUpdate(fieldName, new BsonDocument("$type", new BsonString("timestamp")), "$currentDate");
    }

    public static <TItem> Bson addToSet(String fieldName, @Nullable TItem value) {
        return new SimpleUpdate(fieldName, value, "$addToSet");
    }

    public static <TItem> Bson addEachToSet(String fieldName, List<TItem> values) {
        return new WithEachUpdate(fieldName, values, "$addToSet");
    }

    public static <TItem> Bson push(String fieldName, @Nullable TItem value) {
        return new SimpleUpdate(fieldName, value, "$push");
    }

    public static <TItem> Bson pushEach(String fieldName, List<TItem> values) {
        return new PushUpdate(fieldName, values, new PushOptions());
    }

    public static <TItem> Bson pushEach(String fieldName, List<TItem> values, PushOptions options) {
        return new PushUpdate(fieldName, values, options);
    }

    public static <TItem> Bson pull(String fieldName, @Nullable TItem value) {
        return new SimpleUpdate(fieldName, value, "$pull");
    }

    public static Bson pullByFilter(final Bson filter) {
        return new Bson() { // from class: com.mongodb.client.model.Updates.1
            @Override // org.bson.conversions.Bson
            public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
                BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
                writer.writeStartDocument();
                writer.writeName("$pull");
                BuildersHelper.encodeValue(writer, Bson.this, codecRegistry);
                writer.writeEndDocument();
                return writer.getDocument();
            }
        };
    }

    public static <TItem> Bson pullAll(String fieldName, List<TItem> values) {
        return new PullAllUpdate(fieldName, values);
    }

    public static Bson popFirst(String fieldName) {
        return new SimpleUpdate(fieldName, -1, "$pop");
    }

    public static Bson popLast(String fieldName) {
        return new SimpleUpdate(fieldName, 1, "$pop");
    }

    public static Bson bitwiseAnd(String fieldName, int value) {
        return createBitUpdateDocument(fieldName, "and", value);
    }

    public static Bson bitwiseAnd(String fieldName, long value) {
        return createBitUpdateDocument(fieldName, "and", value);
    }

    public static Bson bitwiseOr(String fieldName, int value) {
        return createBitUpdateDocument(fieldName, "or", value);
    }

    public static Bson bitwiseOr(String fieldName, long value) {
        return createBitUpdateDocument(fieldName, "or", value);
    }

    public static Bson bitwiseXor(String fieldName, int value) {
        return createBitUpdateDocument(fieldName, "xor", value);
    }

    public static Bson bitwiseXor(String fieldName, long value) {
        return createBitUpdateDocument(fieldName, "xor", value);
    }

    private static Bson createBitUpdateDocument(String fieldName, String bitwiseOperator, int value) {
        return createBitUpdateDocument(fieldName, bitwiseOperator, new BsonInt32(value));
    }

    private static Bson createBitUpdateDocument(String fieldName, String bitwiseOperator, long value) {
        return createBitUpdateDocument(fieldName, bitwiseOperator, new BsonInt64(value));
    }

    private static Bson createBitUpdateDocument(String fieldName, String bitwiseOperator, BsonValue value) {
        return new BsonDocument("$bit", new BsonDocument(fieldName, new BsonDocument(bitwiseOperator, value)));
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$SimpleBsonKeyValue.class */
    private static class SimpleBsonKeyValue implements Bson {
        private final String fieldName;
        private final Bson value;

        SimpleBsonKeyValue(String fieldName, Bson value) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.value = (Bson) Assertions.notNull("value", value);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            BuildersHelper.encodeValue(writer, this.value, codecRegistry);
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SimpleBsonKeyValue that = (SimpleBsonKeyValue) o;
            if (!this.fieldName.equals(that.fieldName)) {
                return false;
            }
            return this.value.equals(that.value);
        }

        public int hashCode() {
            return (31 * this.fieldName.hashCode()) + this.value.hashCode();
        }

        public String toString() {
            return "SimpleBsonKeyValue{fieldName='" + this.fieldName + "', value=" + this.value + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$SimpleUpdate.class */
    private static class SimpleUpdate<TItem> implements Bson {
        private final String fieldName;
        private final TItem value;
        private final String operator;

        SimpleUpdate(String fieldName, TItem value, String operator) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.value = value;
            this.operator = operator;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.operator);
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            BuildersHelper.encodeValue(writer, this.value, codecRegistry);
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SimpleUpdate<?> that = (SimpleUpdate) o;
            if (!this.fieldName.equals(that.fieldName)) {
                return false;
            }
            if (this.value != null) {
                if (!this.value.equals(that.value)) {
                    return false;
                }
            } else if (that.value != null) {
                return false;
            }
            return this.operator != null ? this.operator.equals(that.operator) : that.operator == null;
        }

        public int hashCode() {
            return (31 * ((31 * this.fieldName.hashCode()) + (this.value != null ? this.value.hashCode() : 0))) + (this.operator != null ? this.operator.hashCode() : 0);
        }

        public String toString() {
            return "Update{fieldName='" + this.fieldName + "', operator='" + this.operator + "', value=" + this.value + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$WithEachUpdate.class */
    private static class WithEachUpdate<TItem> implements Bson {
        private final String fieldName;
        private final List<TItem> values;
        private final String operator;

        WithEachUpdate(String fieldName, List<TItem> values, String operator) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.values = (List) Assertions.notNull("values", values);
            this.operator = operator;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.operator);
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            writer.writeStartDocument();
            writer.writeStartArray("$each");
            for (TItem value : this.values) {
                BuildersHelper.encodeValue(writer, value, codecRegistry);
            }
            writer.writeEndArray();
            writeAdditionalFields(writer, tDocumentClass, codecRegistry);
            writer.writeEndDocument();
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        protected <TDocument> void writeAdditionalFields(BsonDocumentWriter writer, Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
        }

        protected String additionalFieldsToString() {
            return "";
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            WithEachUpdate<?> that = (WithEachUpdate) o;
            if (this.fieldName.equals(that.fieldName) && this.values.equals(that.values)) {
                return this.operator != null ? this.operator.equals(that.operator) : that.operator == null;
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((31 * this.fieldName.hashCode()) + this.values.hashCode())) + (this.operator != null ? this.operator.hashCode() : 0);
        }

        public String toString() {
            return "Each Update{fieldName='" + this.fieldName + "', operator='" + this.operator + "', values=" + this.values + additionalFieldsToString() + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$PushUpdate.class */
    private static class PushUpdate<TItem> extends WithEachUpdate<TItem> {
        private final PushOptions options;

        PushUpdate(String fieldName, List<TItem> values, PushOptions options) {
            super(fieldName, values, "$push");
            this.options = (PushOptions) Assertions.notNull("options", options);
        }

        @Override // com.mongodb.client.model.Updates.WithEachUpdate
        protected <TDocument> void writeAdditionalFields(BsonDocumentWriter writer, Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            Integer position = this.options.getPosition();
            if (position != null) {
                writer.writeInt32("$position", position.intValue());
            }
            Integer slice = this.options.getSlice();
            if (slice != null) {
                writer.writeInt32("$slice", slice.intValue());
            }
            Integer sort = this.options.getSort();
            if (sort != null) {
                writer.writeInt32("$sort", sort.intValue());
                return;
            }
            Bson sortDocument = this.options.getSortDocument();
            if (sortDocument != null) {
                writer.writeName("$sort");
                BuildersHelper.encodeValue(writer, sortDocument, codecRegistry);
            }
        }

        @Override // com.mongodb.client.model.Updates.WithEachUpdate
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass() || !equals(o)) {
                return false;
            }
            return this.options.equals(((PushUpdate) o).options);
        }

        @Override // com.mongodb.client.model.Updates.WithEachUpdate
        public int hashCode() {
            return (31 * hashCode()) + this.options.hashCode();
        }

        @Override // com.mongodb.client.model.Updates.WithEachUpdate
        protected String additionalFieldsToString() {
            return ", options=" + this.options;
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$PullAllUpdate.class */
    private static class PullAllUpdate<TItem> implements Bson {
        private final String fieldName;
        private final List<TItem> values;

        PullAllUpdate(String fieldName, List<TItem> values) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.values = (List) Assertions.notNull("values", values);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName("$pullAll");
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            writer.writeStartArray();
            for (TItem value : this.values) {
                BuildersHelper.encodeValue(writer, value, codecRegistry);
            }
            writer.writeEndArray();
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            PullAllUpdate<?> that = (PullAllUpdate) o;
            if (!this.fieldName.equals(that.fieldName)) {
                return false;
            }
            return this.values.equals(that.values);
        }

        public int hashCode() {
            return (31 * this.fieldName.hashCode()) + this.values.hashCode();
        }

        public String toString() {
            return "Update{fieldName='" + this.fieldName + "', operator='$pullAll', value=" + this.values + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Updates$CompositeUpdate.class */
    public static class CompositeUpdate implements Bson {
        private final List<? extends Bson> updates;

        CompositeUpdate(List<? extends Bson> updates) {
            this.updates = updates;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> tDocumentClass, CodecRegistry codecRegistry) {
            BsonDocument document = new BsonDocument();
            for (Bson update : this.updates) {
                for (Map.Entry<String, BsonValue> element : update.toBsonDocument(tDocumentClass, codecRegistry).entrySet()) {
                    if (document.containsKey(element.getKey())) {
                        BsonDocument currentOperatorDocument = (BsonDocument) element.getValue();
                        BsonDocument existingOperatorDocument = document.getDocument(element.getKey());
                        for (Map.Entry<String, BsonValue> currentOperationDocumentElements : currentOperatorDocument.entrySet()) {
                            existingOperatorDocument.append(currentOperationDocumentElements.getKey(), currentOperationDocumentElements.getValue());
                        }
                    } else {
                        document.append(element.getKey(), element.getValue());
                    }
                }
            }
            return document;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            CompositeUpdate that = (CompositeUpdate) o;
            return this.updates != null ? this.updates.equals(that.updates) : that.updates == null;
        }

        public int hashCode() {
            if (this.updates != null) {
                return this.updates.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Updates{updates=" + this.updates + '}';
        }
    }

    private Updates() {
    }
}
