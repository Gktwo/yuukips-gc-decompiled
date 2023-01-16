package dev.morphia.query;

import dev.morphia.aggregation.Accumulator;
import java.util.HashMap;
import java.util.Map;
import org.bson.Document;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/BucketAutoOptions.class */
public class BucketAutoOptions {
    private Granularity granularity;
    private final Map<String, Accumulator> accumulators = new HashMap();

    public Document toDocument() {
        Document document = new Document();
        if (this.granularity != null) {
            document.put("granularity", (Object) this.granularity.getGranulality());
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

    public BucketAutoOptions granularity(Granularity granularity) {
        this.granularity = granularity;
        return this;
    }

    public OutputOperation output(String fieldName) {
        return new OutputOperation(fieldName);
    }

    /* loaded from: grasscutter.jar:dev/morphia/query/BucketAutoOptions$OutputOperation.class */
    public class OutputOperation {
        private final String fieldName;

        public OutputOperation(String fieldName) {
            this.fieldName = fieldName;
        }

        public BucketAutoOptions addToSet(String field) {
            BucketAutoOptions.this.accumulators.put(this.fieldName, new Accumulator("$addToSet", field));
            return BucketAutoOptions.this;
        }

        public BucketAutoOptions average(String field) {
            BucketAutoOptions.this.accumulators.put(this.fieldName, new Accumulator("$avg", field));
            return BucketAutoOptions.this;
        }

        public BucketAutoOptions sum(Object field) {
            BucketAutoOptions.this.accumulators.put(this.fieldName, new Accumulator("$sum", field));
            return BucketAutoOptions.this;
        }
    }

    public Granularity getGranularity() {
        return this.granularity;
    }

    /* loaded from: grasscutter.jar:dev/morphia/query/BucketAutoOptions$Granularity.class */
    public enum Granularity {
        R5("R5"),
        R10("R10"),
        R20("R20"),
        R40("R40"),
        R80("R80"),
        ONE_TWO_FIVE("1-2-5"),
        E6("E6"),
        E12("E12"),
        E24("E24"),
        E48("E48"),
        E96("E96"),
        E192("E192"),
        POWERSOF2("POWERSOF2");
        
        private final String granularity;

        Granularity(String granularity) {
            this.granularity = granularity;
        }

        public String getGranulality() {
            return this.granularity;
        }
    }

    public Map<String, Accumulator> getAccumulators() {
        return this.accumulators;
    }
}
