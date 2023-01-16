package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Limit.class */
public class Limit extends Stage {
    private final long limit;

    protected Limit(long limit) {
        super("$limit");
        this.limit = limit;
    }

    public static Limit limit(long limit) {
        return new Limit(limit);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Limit m1240of(long limit) {
        return new Limit(limit);
    }

    public long getLimit() {
        return this.limit;
    }
}
