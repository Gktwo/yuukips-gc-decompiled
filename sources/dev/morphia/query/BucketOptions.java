package dev.morphia.query;

import dev.morphia.aggregation.Accumulator;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/BucketOptions.class */
public class BucketOptions {
    private Object defaultField;
    private final Map<String, Accumulator> accumulators = new HashMap();

    public Document toDocument() {
        Document document = new Document();
        if (this.defaultField != null) {
            document.put("default", this.defaultField);
        }
        Document output = new Document();
        for (Map.Entry<String, Accumulator> entry : this.accumulators.entrySet()) {
            output.put(entry.getKey(), (Object) entry.getValue().toDocument());
        }
        if (!this.accumulators.isEmpty()) {
            document.put("output", (Object) output);
        }
        return document;
    }

    public BucketOptions defaultField(Object defaultField) {
        this.defaultField = defaultField;
        return this;
    }

    public OutputOperation output(String fieldName) {
        return new OutputOperation(fieldName);
    }

    /* loaded from: grasscutter.jar:dev/morphia/query/BucketOptions$OutputOperation.class */
    public class OutputOperation {
        private final String fieldName;

        public OutputOperation(String fieldName) {
            this.fieldName = fieldName;
        }

        public BucketOptions addToSet(String field) {
            BucketOptions.this.accumulators.put(this.fieldName, new Accumulator("$addToSet", field));
            return BucketOptions.this;
        }

        public BucketOptions average(String field) {
            BucketOptions.this.accumulators.put(this.fieldName, new Accumulator("$avg", field));
            return BucketOptions.this;
        }

        public BucketOptions sum(Object field) {
            BucketOptions.this.accumulators.put(this.fieldName, new Accumulator("$sum", field));
            return BucketOptions.this;
        }
    }

    public Object getDefaultField() {
        return this.defaultField;
    }

    public Map<String, Accumulator> getAccumulators() {
        return this.accumulators;
    }
}
