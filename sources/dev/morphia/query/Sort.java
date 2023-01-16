package dev.morphia.query;

/* loaded from: grasscutter.jar:dev/morphia/query/Sort.class */
public class Sort {
    private static final String NATURAL = "$natural";
    private final String field;
    private final int order;

    /* access modifiers changed from: protected */
    public Sort(String field, int order) {
        this.field = field;
        this.order = order;
    }

    public static Sort ascending(String field) {
        return new Sort(field, 1);
    }

    public static Sort descending(String field) {
        return new Sort(field, -1);
    }

    public static Sort naturalAscending() {
        return new Sort(NATURAL, 1);
    }

    public static Sort naturalDescending() {
        return new Sort(NATURAL, -1);
    }

    public int getOrder() {
        return this.order;
    }

    public String getField() {
        return this.field;
    }
}
