package dev.morphia.query;

import java.util.Arrays;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/ArraySlice.class */
public class ArraySlice {
    private final Integer limit;
    private Integer skip;

    public ArraySlice(int limit) {
        this.limit = Integer.valueOf(limit);
    }

    public ArraySlice(int skip, int limit) {
        this.skip = Integer.valueOf(skip);
        this.limit = Integer.valueOf(limit);
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getSkip() {
        return this.skip;
    }

    /* access modifiers changed from: package-private */
    public Document toDatabase() {
        return new Document("$slice", this.skip == null ? this.limit : Arrays.asList(this.skip, this.limit));
    }
}
